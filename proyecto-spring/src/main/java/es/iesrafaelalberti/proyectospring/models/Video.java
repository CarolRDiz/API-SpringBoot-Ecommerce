package es.iesrafaelalberti.proyectospring.models;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;

public class Video {
    @Transient
    public static final String SEQUENCE_NAME = "video_sequence";
    @Id
    private long id;
}
