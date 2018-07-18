package cn.nfg.mweb.listener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Administrator
 * @Date: 2018/7/16 18:09
 * @Description:
 */
@Configuration
public class ListenerConfig {
    @Bean
    public ServletListenerRegistrationBean MyServletContextListener() {
        ServletListenerRegistrationBean slrBean = new ServletListenerRegistrationBean();
        slrBean.setListener(new MyServletContextListener());
        return slrBean;
    }

    @Bean
    public ServletListenerRegistrationBean MySessionListener() {
        ServletListenerRegistrationBean slrBean = new ServletListenerRegistrationBean();
        slrBean.setListener(new MySessionListener());
        return slrBean;
    }
}