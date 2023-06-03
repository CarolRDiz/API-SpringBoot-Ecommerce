package es.iesrafaelalberti.proyectospring.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class ElvisEntity implements Serializable, Cloneable {

}
