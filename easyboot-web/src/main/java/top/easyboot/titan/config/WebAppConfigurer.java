package top.easyboot.titan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.easyboot.titan.handler.LogInterceptor;
import top.easyboot.titan.handler.SignInterceptor;

/**
 * @author: frank.huang
 * @date: 2021-11-06 13:08
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

     @Autowired
     @Qualifier(value = "commonSignInterceptor")
    private SignInterceptor signInterceptor;
     @Autowired
     private LogInterceptor logInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
        registry.addInterceptor(signInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
