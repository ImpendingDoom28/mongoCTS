package ru.itis.mongoose.springJpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.mongoose.models.SandboxJpa;

public class MongoJpa {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MongoJpaConfig.class);
        SandboxRepository sandboxRepository = context.getBean(SandboxRepository.class);

        SandboxJpa sandboxJpa = SandboxJpa.builder()
                .htmlCode("<h2></h2>")
                .cssCode("* {margin: 0}")
                .jsCode("let war = start")
                .build();

        // CREATE
        SandboxJpa sandboxJpaWithId = sandboxRepository.save(sandboxJpa);
        System.out.println(sandboxRepository.findById(sandboxJpaWithId.get_id()));

        // UPDATE
        SandboxJpa sandboxJpa1 = sandboxRepository.findById("5fe8b2ec68b65509b8bd6340").get();
        System.out.println(sandboxJpa1.getHtmlCode());
        sandboxJpa1.setHtmlCode("<h3></h3>");
        sandboxRepository.save(sandboxJpa1);
        System.out.println(sandboxRepository.findById("5fe8b2ec68b65509b8bd6340").get().getHtmlCode());

        // DELETE
        sandboxRepository.delete(sandboxJpa1);
        System.out.println(sandboxRepository.findById("5fe8b2ec68b65509b8bd6340").get());
    }
}
