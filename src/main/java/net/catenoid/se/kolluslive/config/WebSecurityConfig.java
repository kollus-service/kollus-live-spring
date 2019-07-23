package net.catenoid.se.kolluslive.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/***
 * IE11에서 js로 이미지 JPG를 추가시 보안으로 인해 막는 경우가 있음
 * 따라서 해당 기능을 해제
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().defaultsDisabled().contentTypeOptions();
    }
}
