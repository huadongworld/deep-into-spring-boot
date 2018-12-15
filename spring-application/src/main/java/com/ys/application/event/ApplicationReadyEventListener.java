package com.ys.application.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author HuaDong
 * @date 2018/12/13 15:59
 */
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        LOGGER.debug("......ApplicationReadyEventListener......");
    }
}
