package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean sitemesh() {
        FilterRegistrationBean<SiteMeshFilter> filterRegistrationBean =
            new FilterRegistrationBean<>(new SiteMeshFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean struts2() {
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> filterRegistrationBean =
            new FilterRegistrationBean<>(new StrutsPrepareAndExecuteFilter());
        filterRegistrationBean.addUrlPatterns("/");
        filterRegistrationBean.addUrlPatterns("/addUserForm.action");
        filterRegistrationBean.addUrlPatterns("/addUser.action");
        filterRegistrationBean.addUrlPatterns("/findUserForm.action");
        filterRegistrationBean.addUrlPatterns("/findUser.action");
        filterRegistrationBean.addUrlPatterns("/listAllUsers.action");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }
}
