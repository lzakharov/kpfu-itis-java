import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletContext;

/**
 * Created by lzakharov on 16.10.15.
 */
public class ConfigSingleton {
    private static Configuration config = null;

    public static Configuration getConfig(ServletContext context) {
        if (config == null) {
            config = new Configuration(Configuration.VERSION_2_3_23);
            config.setServletContextForTemplateLoading(context, "/WEB-INF/templates");
            config.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        }

        return config;
    }
}
