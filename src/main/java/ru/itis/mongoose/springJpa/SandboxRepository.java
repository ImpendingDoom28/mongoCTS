package ru.itis.mongoose.springJpa;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.mongoose.models.SandboxJpa;

import java.util.List;

public interface SandboxRepository extends MongoRepository<SandboxJpa,String> {

    @Query(value = "{$or: [{cssCode: ?cssCode}, {jsCode: ?jsCode}]}")
    List<SandboxJpa> find(@Param("cssCode") String cssCode, @Param("jsCode") String jsCode);
}
