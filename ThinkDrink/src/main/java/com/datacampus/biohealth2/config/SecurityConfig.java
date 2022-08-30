package com.datacampus.biohealth2.config;

import com.datacampus.biohealth2.constant.Role;
import com.datacampus.biohealth2.service.MemberService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@Getter
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MemberService memberService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors().and().csrf().disable()
                .formLogin()
                .loginPage("/members/login")
                .defaultSuccessUrl("/",true)
                .usernameParameter("email")
                .failureForwardUrl("/members/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                .logoutSuccessUrl("/");


        httpSecurity.authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/**","/css/**","/images/**","/js/**","/members/**","/healthInformation/**").permitAll()
                .antMatchers("/healthInformation/**").hasAnyRole(Role.USER.name());


//        httpSecurity.authorizeRequests()
//                .mvcMatchers("/"
//                        ,"/img/**","/css/**","/js/**","/scss/**","/vendor/**").permitAll()
//                .mvcMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated();
//        httpSecurity.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception{
        webSecurity.ignoring().mvcMatchers("/resources/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
        throws Exception{
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }
}
