package com.github.smartbooks.bootstrap.config;

import com.github.smartbooks.bootstrap.handler.DefaultAuthenticationSuccessHandler;
import com.github.smartbooks.bootstrap.handler.DefaultSimpleUrlAuthenticationFailureHandler;
import com.github.smartbooks.bootstrap.support.DefaultUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 默认授权策略适配器
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DefaultWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    /**
     * 自动装配用户详情服务
     */
    @Autowired
    private DefaultUserDetailsService defaultUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/help/**", "/passport/loginoutok")
                .permitAll()  //允许访问
                .anyRequest()
                .authenticated()                             //其他路径都需要授权
                .and()
                .formLogin()                                 //开启表单登陆
                .loginPage("/passport/login")                //登陆页面
                .usernameParameter("userName")
                .passwordParameter("password")
                .loginProcessingUrl("/passport/login")       //post提交表单
                .successHandler(new DefaultAuthenticationSuccessHandler("/home/index"))
                .failureHandler(new DefaultSimpleUrlAuthenticationFailureHandler("/passport/login"))
                .permitAll()                                    //允许所有用户都有权限访问登录页面
                .and()                                          //
                .logout()                                       //
                .logoutUrl("/passport/loginout")
                .logoutSuccessUrl("/passport/loginoutok");      //注销成功页面

    }

    @Override
    public void configure(WebSecurity web) {

        web.ignoring().antMatchers("/static/**/**");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(defaultUserDetailsService).passwordEncoder(passwordEncoder());

    }

    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

}
