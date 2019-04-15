package com.microandroid.tags;

import org.springframework.util.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * 自定义属性
 */
public class TagHelloWorld3 extends SimpleTagSupport {

    /**
     * 消息
     */
    private String msg;

    /**
     * 用户名
     */
    private String username;

    /**
     * 年龄
     */
    private int age;
    private StringWriter sw = new StringWriter();

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        JspWriter out = getJspContext().getOut();
        StringBuilder sb = new StringBuilder();
        JspFragment jspBody = getJspBody();
        if (jspBody != null) {
            jspBody.invoke(sw);
            String s = sw.toString();
            if (s != null) {
                out.write(s);
            }
        } else {
            if (!StringUtils.isEmpty(msg)) {
                sb.append(msg).append(", ");
            }
            if (!StringUtils.isEmpty(username)) {
                sb.append(String.format("my name is %s", username));
            }
            if (age > 0) {
                sb.append(String.format(" , I'm %d years old! ", age));
            }

            out.write(sb.toString());
        }
    }
}
