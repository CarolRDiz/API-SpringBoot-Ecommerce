package es.iesrafaelalberti.proyectospring.models;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rols")
@Getter
@Setter
@NoArgsConstructor
public class Rol {
    @Id
    private long id;
}
