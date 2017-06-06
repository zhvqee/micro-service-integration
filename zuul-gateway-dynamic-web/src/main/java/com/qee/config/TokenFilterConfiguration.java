package com.qee.config;

import com.qee.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hzzhuqi1 on 2017/6/2.
 */
@Configuration
public class TokenFilterConfiguration {

    @Bean
    TokenFilter getTokenFilter(){
        return  new TokenFilter();
    }


}
