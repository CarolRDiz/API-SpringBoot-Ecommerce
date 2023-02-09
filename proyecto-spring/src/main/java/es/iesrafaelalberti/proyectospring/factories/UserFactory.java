package es.iesrafaelalberti.proyectospring.factories;
import com.github.javafaker.Faker;
import es.iesrafaelalberti.proyectospring.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class UserFactory {
    Faker esFaker = new Faker(new Locale("es-ES"));

    public List<User> get(int number) {
        Random rand = new Random();
        return IntStream.range(0, number)
                .mapToObj(x -> new User(
                        esFaker.name().firstName(),             //String name
                        esFaker.name().lastName(),              //String surname
                        esFaker.internet().emailAddress(),      //String email
                        esFaker.internet().password(7,20)       //String password
                )).collect(Collectors.toList());
    }
}