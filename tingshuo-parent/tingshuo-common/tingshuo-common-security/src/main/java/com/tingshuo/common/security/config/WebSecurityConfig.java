package com.tingshuo.common.security.config;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月14日 19:14
 **/
/*@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected  void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 关闭csrf防护
                .csrf().disable()
                .headers().frameOptions().disable()
                .and();
        httpSecurity
                //登录处理
                .formLogin() //表单方式，或httpBasic
                .loginPage("/loginPage")
                .loginProcessingUrl("/form")
                .defaultSuccessUrl("/index") //成功登陆后跳转页面
                .failureUrl("/loginError")
                .permitAll()
                .and();
        httpSecurity
                .authorizeRequests() // 授权配置
                //无需权限访问
                .antMatchers("/css/**", "/error404").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                //其他接口需要登录后才能访问
                .anyRequest().authenticated()
                .and();
    }
}*/
