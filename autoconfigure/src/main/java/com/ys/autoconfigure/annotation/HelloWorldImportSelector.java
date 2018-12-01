package com.ys.autoconfigure.annotation;

import com.ys.autoconfigure.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author HuaDong
 * @date 2018/12/1 20:30
 *
 * HelloWorld {@link ImportSelector} 实现
 */
public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{HelloWorldConfiguration.class.getName()};
    }

}
