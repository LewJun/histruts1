package com.microandroid.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * TagHelloWorld 继承SimpleTagSupport 输出Hello World
 */
public class TagHelloWorld extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
//        得到输出对象
        JspWriter out = getJspContext().getOut();
//        输出内容
        out.write("Hello World");
    }
}
