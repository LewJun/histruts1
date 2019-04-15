package com.microandroid.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TagW3Select extends SimpleTagSupport {

    private String id;

    private String name;

    private String cls;

    private String defSelectedHint;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getDefSelectedHint() {
        return defSelectedHint;
    }

    public void setDefSelectedHint(String defSelectedHint) {
        this.defSelectedHint = defSelectedHint;
    }

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        List<String> fruits = new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grape");

        StringBuilder sb = new StringBuilder(String.format("<select id='%s' name='%s' class='%s'>", id, name, cls));
        if (defSelectedHint != null) {
            sb.append(String.format("<option>%s</option>", defSelectedHint));
        }

        for (String fruit : fruits) {
            sb.append(String.format("<option value='%s'>%s</option>", fruit, fruit));
        }
        sb.append("</select>");

        JspWriter out = getJspContext().getOut();
        out.write(sb.toString());
    }
}
