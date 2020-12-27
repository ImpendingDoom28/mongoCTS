package ru.itis.mongoose.springJpa;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "ru.itis.mongoose.springJpa")
public class MongoJpaConfig {
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(MongoClients.create("mongodb+srv://Sergey:7llnjQeDHedaXR41@kinonew.ag4d1.mongodb.net"), "user_codep");
    }
}
