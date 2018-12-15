package com.ys.application.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author HuaDong
 * @date 2018/12/13 15:53
 */
public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationPreparedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        LOGGER.debug("......ApplicationPreparedEventListener......");
    }
}
