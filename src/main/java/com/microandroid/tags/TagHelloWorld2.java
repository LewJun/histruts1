package com.microandroid.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * 得到tag内的内容
 */
public class TagHelloWorld2 extends SimpleTagSupport {
    private StringWriter sw = new StringWriter();

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
//        得到tag内的内容<TagHelloWorld2>Hello Tag</TagHelloWorld2>
        getJspBody().invoke(sw);
        getJspContext().getOut().write(sw.toString());
    }
}
