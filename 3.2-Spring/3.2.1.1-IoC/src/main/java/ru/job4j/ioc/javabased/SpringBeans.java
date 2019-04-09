package ru.job4j.ioc.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * class SpringBeans.
 *
 * @author ifedorenko
 * @since 19.03.2019
 */
@Configuration
@ComponentScan(value = "ru.job4j.ioc.javabased")
public class SpringBeans {

    @Bean
    public UserStorageJava getStorage() {
        return new UserStorageJava(getMemory());
    }

    @Bean
    public  MemoryStorageJava getMemory() {
        return new MemoryStorageJava();
    }
}
