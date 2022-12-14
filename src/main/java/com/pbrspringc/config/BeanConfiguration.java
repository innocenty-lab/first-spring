package com.pbrspringc.config;

import com.pbrspringc.repository.CourseArrayRepository;
import com.pbrspringc.repository.ICourseRepository;
import com.pbrspringc.service.CourseService;
import com.pbrspringc.service.ICourseService;
import com.pbrspringc.util.IRandomStringGenerator;
import com.pbrspringc.util.UidGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguration {
    @Bean
    @Scope("prototype")
    public ICourseRepository getCourseRepository(){
        return new CourseArrayRepository();
    }

    @Bean
    @Scope("prototype")
    public ICourseService getCourseService(){
        return new CourseService(getCourseRepository());
    }

    @Bean
    public IRandomStringGenerator getRandomUid(){
        return new UidGenerator();
    }
}
