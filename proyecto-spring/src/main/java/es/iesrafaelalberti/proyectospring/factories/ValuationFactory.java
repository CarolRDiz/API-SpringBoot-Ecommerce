package es.iesrafaelalberti.proyectospring.factories;
import com.github.javafaker.Faker;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.models.UserReview;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ValuationFactory {
    Faker esFaker = new Faker(new Locale("es-ES"));
    public class RandomScore {
        public static double generateRandomScore() {
            Random random = new Random();
            double randomNumber = random.nextDouble(6); // Generar un número aleatorio entre 0 y 5
            if((randomNumber - (int)randomNumber)>0.5){
                randomNumber = Math.ceil(randomNumber);
            } else if ((randomNumber - (int)randomNumber)<0.5) {
                randomNumber = Math.floor(randomNumber);
            }
            return randomNumber;
        }
    }

    public List<UserReview> get(int number, List<Course> courses, List<Users> users ) {
        Random rand = new Random();
        return IntStream.range(0, number)
                .mapToObj(x -> new UserReview(
                        courses.get(rand.nextInt(courses.size())),
                        users.get(rand.nextInt(users.size())),
                        esFaker.lorem().sentence(10),
                        RandomScore.generateRandomScore()
                        ))
                .collect(Collectors.toList());
    }
}
