package cn.nfg.mweb.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Administrator
 * @Date: 2018/7/17 17:47
 * @Description:
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean CharsetFilterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new OnlineFilter());
        frBean.addUrlPatterns("/");
        frBean.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return frBean;
    }
}
