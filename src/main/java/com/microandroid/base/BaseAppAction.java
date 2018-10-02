package com.microandroid.base;

import org.apache.struts.actions.DispatchAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 约定：所有的Action继承自BaseAppAction，不能覆盖execute方法
 */
public class BaseAppAction extends DispatchAction {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseAppAction.class);
}
