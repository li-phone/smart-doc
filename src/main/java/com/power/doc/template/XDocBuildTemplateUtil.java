package com.power.doc.template;

import com.power.doc.builder.ProjectDocConfigBuilder;
import com.power.doc.constants.DocTags;
import com.power.doc.utils.DocUtil;
import com.thoughtworks.qdox.model.*;
import com.thoughtworks.qdox.model.impl.DefaultJavaAnnotation;
import com.thoughtworks.qdox.model.impl.DefaultJavaMethod;

import java.util.*;

public class XDocBuildTemplateUtil {

    public static void addParametersByAnnotation(JavaMethod method, ProjectDocConfigBuilder projectBuilder) {
        DocletTag scanTag = method.getTagByName(DocTags.SCAN);
        if (Objects.isNull(scanTag)) {
            return;
        }
        DefaultJavaMethod defaultJavaMethod = (DefaultJavaMethod) method;
        String className = method.getDeclaringClass().getCanonicalName();
        Map<String, String> paramTagMap = DocUtil.getCommentsByTag(method, DocTags.UPARAM, className);
        Map<String, String> paramsComments = DocUtil.getCommentsByTag(method, DocTags.UPARAM, null);

        // 通过注解添加参数
        String uparamAnno = DocUtil.getNormalTagComments(method, DocTags.UPARAM_ANNO, null);
        List<JavaParameter> parameterList = new ArrayList<>(method.getParameters());
        for (Map.Entry<String, String> entry : paramsComments.entrySet()) {
            String[] cols = entry.getValue().trim().split("\\|", 5);
            String clsName = cols[0].trim();
            JavaClass javaClass = projectBuilder.getJavaProjectBuilder().getClassByName(clsName);
            if (javaClass != null) {
                DefaultJavaParameter javaParameter = new DefaultJavaParameter(javaClass, entry.getKey());
                // 设置参数注解
                if (uparamAnno != null) {
                    JavaClass uparamAnnoClass = projectBuilder.getJavaProjectBuilder().getClassByName(uparamAnno);
                    DefaultJavaAnnotation defaultJavaAnnotation = new DefaultJavaAnnotation(uparamAnnoClass);
                    List<JavaAnnotation> defaultJavaAnnotationList = new ArrayList<>(Collections.singleton(defaultJavaAnnotation));
                    javaParameter.setAnnotations(defaultJavaAnnotationList);
                }
                parameterList.add(javaParameter);
            }
        }
        defaultJavaMethod.setParameters(parameterList);
    }
}
