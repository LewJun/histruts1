package com.microandroid.tags;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;

public class TagIterator extends SimpleTagSupport {
    /**
     * 标签属性，用于指定需要被迭代的集合
     */
    private String collection;

    /**
     * 标签属性，指定迭代集合元素，为集合元素指定的名称
     */
    private String item;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspContext jspContext = getJspContext();
        Collection itemList = (Collection) jspContext.getAttribute(collection);
        for (Object itemVal : itemList) {
            //将集合的元素设置到page 范围
            jspContext.setAttribute(item, itemVal);
            getJspBody().invoke(null);
        }
    }
}
