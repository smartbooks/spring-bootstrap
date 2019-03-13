package com.github.smartbooks.bootstrap.template;

import com.github.smartbooks.bootstrap.util.PageUtils;
import com.github.smartbooks.bootstrap.util.Paged;
import freemarker.core.Environment;
import freemarker.ext.beans.StringModel;
import freemarker.template.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.Writer;
import java.util.Map;

/**
 * 自定义分页控件
 */
@Component
public class PageNumberDirective implements TemplateDirectiveModel {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private HttpServletRequest httpServletRequest;

    private String tagAttributeKey = "data";

    private String tagName = "PageNumber";

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagAttributeKey() {
        return tagAttributeKey;
    }

    public void setTagAttributeKey(String tagAttributeKey) {
        this.tagAttributeKey = tagAttributeKey;
    }

    @Override
    public void execute(Environment env, Map map, TemplateModel[] templateModels, TemplateDirectiveBody body)
            throws TemplateModelException {

        Paged<Object> paged = null;

        if (null != env && null != map && map.containsKey(tagAttributeKey)) {

            Object pageDataKey = map.get(tagAttributeKey);

            if (null != pageDataKey) {

                TemplateModel templateModel = env.getVariable(pageDataKey.toString());

                if (templateModel instanceof StringModel) {

                    StringModel stringModel = (StringModel) templateModel;

                    paged = (Paged<Object>) stringModel.getAdaptedObject(Paged.class);
                }
            }

        }

        if (null != paged) {

            try (Writer writer = env.getOut()) {

                String html = PageUtils.paging(paged, httpServletRequest);

                writer.write(html);

                //if(null != body)
                //body.render(writer);

            } catch (Exception e) {

                logger.error(e);
            }
        }
    }
}
