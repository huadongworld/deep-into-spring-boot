package com.ys.autoconfigure.bootstrap;

import com.ys.autoconfigure.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 仓储的引导类
 *
 * @author HuaDong
 * @date 2018/12/1 20:10
 */
@ComponentScan(basePackages = "com.ys.autoconfigure.repository")
public class RepositoryBootstrap {

    public static void main(String[] args) {

        //返回上下文对象
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //myFirstLevelRepository Bean 是否存在
        MyFirstLevelRepository myFirstLevelRepository =
                context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);

        System.out.println("myFirstLevelRepository Bean : " + myFirstLevelRepository);

        // 关闭上下文
        context.close();
    }
}
