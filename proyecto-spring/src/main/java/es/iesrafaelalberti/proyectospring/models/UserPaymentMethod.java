package es.iesrafaelalberti.proyectospring.models;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_payment_methods")
@Getter
@Setter
@NoArgsConstructor
public class UserPaymentMethod {
    @Id
    private long id;
}
