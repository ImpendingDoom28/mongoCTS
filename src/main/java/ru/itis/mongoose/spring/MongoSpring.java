package ru.itis.mongoose.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import ru.itis.mongoose.models.SandboxSpring;

public class MongoSpring {

    private final static String COLLECTION_NAME = "sandboxSpring";

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SimpleMongoConfig.class);
        MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);

        SandboxSpring sandboxSpring = new SandboxSpring("<div></div>", "const i = 0;", "p { \n\tmargin: 1rem\n}");

        // CREATE
        mongoTemplate.save(sandboxSpring, COLLECTION_NAME);
        Query query = new Query();
        query.addCriteria(Criteria.where("htmlCode").is("<div></div>"));

        System.out.println(mongoTemplate.findOne(query, SandboxSpring.class));

        // UPDATE
        Update update = new Update();
        update.set("htmlCode", "<h1></h1>");
        mongoTemplate.updateFirst(query, update, SandboxSpring.class);
        query = new Query();
        query.addCriteria(Criteria.where("htmlCode").is("<h1></h1>"));

        System.out.println(mongoTemplate.findOne(query, SandboxSpring.class));

        sandboxSpring.setHtmlCode("<h1></h1>");
        // DELETE
        mongoTemplate.remove(sandboxSpring, COLLECTION_NAME);
    }
}
