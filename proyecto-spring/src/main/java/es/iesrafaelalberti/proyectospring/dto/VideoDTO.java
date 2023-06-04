package es.iesrafaelalberti.proyectospring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.InputStream;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoDTO {
    private String title;
    private InputStream stream;
}
