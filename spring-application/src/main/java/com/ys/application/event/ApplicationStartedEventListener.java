package com.ys.application.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author HuaDong
 * @date 2018/12/13 15:57
 */
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        LOGGER.debug("......ApplicationStartedEventListener......");
    }
}
