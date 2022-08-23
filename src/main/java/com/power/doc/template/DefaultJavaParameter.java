package com.power.doc.template;

import com.thoughtworks.qdox.model.JavaAnnotation;
import com.thoughtworks.qdox.model.JavaClass;

import java.util.List;

public class DefaultJavaParameter extends com.thoughtworks.qdox.model.impl.DefaultJavaParameter{
    public DefaultJavaParameter(JavaClass type, String name) {
        super(type, name);
    }

    public DefaultJavaParameter(JavaClass type, String name, boolean varArgs) {
        super(type, name, varArgs);
    }

    @Override
    public String toString() {
        return super.getName();
    }

    @Override
    public void setAnnotations(List<JavaAnnotation> annotations) {
        super.setAnnotations(annotations);
    }
}
