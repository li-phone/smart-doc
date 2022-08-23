package com.power.doc.qbox;

import com.power.doc.builder.AdocDocBuilder;
import com.power.doc.builder.DocBuilderTemplate;
import com.power.doc.builder.HtmlApiDocBuilder;
import com.power.doc.builder.ProjectDocConfigBuilder;
import com.power.doc.constants.DocLanguage;
import com.power.doc.constants.FrameworkEnum;
import com.power.doc.model.ApiConfig;
import com.power.doc.model.SourceCodePath;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

/**
 * smart-doc
 *
 * @author spencer
 * @project smart-doc
 * @date 2022-01-2022/1/13
 */
public class QboxScanSourceTest2 {

    @Test
    public void scanError() {
        // target source folder for scan
        String testJavaDirectory = Paths.get("src", "test", "java/com/power/doc/api/demo").toAbsolutePath().toString();
        String outPath = Paths.get("target/api/doc").toAbsolutePath().toString();

        // config and scan
        ApiConfig config = new ApiConfig();
        config.setServerUrl("HSF://127.0.0.1:8088");
        config.setOpenUrl("http://demo.torna.cn/api");
        config.setDebugEnvName("测试环境");
        config.setStyle("randomLight");
        config.setCreateDebugPage(true);
        config.setAuthor("test");
        config.setDebugEnvUrl("HSF://127.0.0.1");
        config.setCreateDebugPage(false);
        config.setAllInOne(true);
        config.setOutPath(outPath);
        config.setMd5EncryptedHtmlName(true);
        config.setFramework(FrameworkEnum.SPRING.getFramework());
        config.setSourceCodePaths(
                SourceCodePath.builder().setDesc("tesSourceScan")
                        .setPath(testJavaDirectory));

        config.setLanguage(DocLanguage.CHINESE);

        // This bug caused not all source code to be found.
        // error at ProjectDocConfigBuilder#loadJavaSource when qbox parse ScanErrorSource
        HtmlApiDocBuilder.buildApiDoc(config);
        AdocDocBuilder.buildApiDoc(config);
    }
}
