package com.example.flowabledelegatelamda;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlowableDelegateLamdaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowableDelegateLamdaApplication.class, args);
    }

    @Bean
    public JavaDelegate lamdaDelegate(){
        return execution -> {
            System.out.println("This is delegeate implemented as a lamda");
        };
    }

    @Bean
    public JavaDelegate lamdaDelegate2(){
        return execution -> {
            System.out.println("This is delegeate implemented as a lamda2");
        };
    }

    @Bean
    public CommandLineRunner commandLineRunner (RuntimeService runtimeService){
        return args -> {
            runtimeService.startProcessInstanceByKey("lamdaProcess");
        };
    }

}
