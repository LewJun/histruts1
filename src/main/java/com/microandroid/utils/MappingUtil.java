package com.microandroid.utils;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MappingUtil {
    public static ActionForward forward(ActionMapping mapping, String forwardName) {
        return mapping.findForward(forwardName);
    }
}
