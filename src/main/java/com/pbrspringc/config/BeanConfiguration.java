package com.pbrspringc.config;

import com.pbrspringc.repository.CourseArrayRepository;
import com.pbrspringc.repository.ICourseRepository;
import com.pbrspringc.service.CourseService;
import com.pbrspringc.service.ICourseService;
import com.pbrspringc.util.IRandomStringGenerator;
import com.pbrspringc.util.RandomInt;
import com.pbrspringc.util.UidGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:app.properties")
public class BeanConfiguration {
    @Value("${generator.type}")
    String randomType;

    @Bean("courseRepositoryBean")
//    @Scope("prototype")
    public ICourseRepository getCourseRepository(){
        System.out.println(randomType);
        if (randomType.equals("int")) {
            return new CourseArrayRepository(getRandomInt());
        }
        return new CourseArrayRepository(getRandomUid());
    }

    @Bean("courseServiceBean")
//    @Scope("prototype")
    public ICourseService getCourseService(){
        return new CourseService(getCourseRepository());
    }

    @Bean
    @Qualifier("uid")
    public IRandomStringGenerator getRandomUid(){
        return new UidGenerator();
    }

    @Bean
    @Qualifier("int")
    public IRandomStringGenerator getRandomInt() {
        return new RandomInt();
    }
}
