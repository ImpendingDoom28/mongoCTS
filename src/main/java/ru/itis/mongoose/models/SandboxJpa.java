package ru.itis.mongoose.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection = "sandboxJpa")
public class SandboxJpa {
    @Id
    private String _id;
    private String htmlCode;
    private String jsCode;
    private String cssCode;
}
