package es.iesrafaelalberti.proyectospring.factories;

import ch.qos.logback.core.util.TimeUtil;
import com.github.javafaker.Faker;
import es.iesrafaelalberti.proyectospring.models.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Random;

@Component
public class CourseFactory {
    Faker esFaker = new Faker(new Locale("es-ES"));
    String [] languages = {"Español","Inglés","Alemán","Francés"};
    List<String> languagesList = Arrays.asList(languages);

    String [] areas = {"Audio","Música","Sound Design","Podcasting"};
    List<String> areasList = Arrays.asList(areas);
    String [] subareas = {"Producción musical","Instrumentos","Fundamentos sobre música","Software de música","Técnicas musicales","Vocal"};
    List<String> subareasList = Arrays.asList(subareas);
    String [] level = {"Begginers","Medium","Advanced"};
    List<String> levelList = Arrays.asList(level);

    public static<T> T getRandomElement(List<T> list) {
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
    public List<Course> get(int number) {
        return IntStream.range(0, number)
                .mapToObj(x -> new Course(
                        // https://javadoc.io/doc/com.github.javafaker/javafaker/latest/com/github/javafaker/Faker.html
                        esFaker.music().instrument(),           //String title
                        esFaker.artist().name(),                //String author
                        esFaker.number().randomDouble(2, 5, 80), //Double price
                        esFaker.number().numberBetween(0, 10),  //Hours
                        esFaker.number().numberBetween(0, 10),  //Minutes
                        getRandomElement(languagesList),        //Language
                        getRandomElement(languagesList),        //Subtitle
                        getRandomElement(areasList),            //Area
                        getRandomElement(subareasList),         //Subarea
                        getRandomElement(levelList),            //Level
                        esFaker.date().birthday().toString()    //Date
                )).collect(Collectors.toList());
    }
}
