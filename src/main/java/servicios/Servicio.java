package servicios;


import domain.Persistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "servicio")
public class Servicio extends Persistente {
    @Column
    private String nombre;

    @OneToMany
    private List<Tarea> tareas;

    public Servicio(){

    }
}
