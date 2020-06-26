package domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "consumidor")
public class Consumidor extends Persistente{
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaDeNacimiento;

    public Consumidor(){

    }

    public Consumidor(String nombre, String apellido, Usuario usuario){
        this.init(nombre, apellido);
        this.usuario = usuario;
    }

    public Consumidor(String nombre, String apellido){
        this.init(nombre, apellido);
    }

    private void init(String nombre, String apellido){
        this.apellido = apellido;
        this.nombre   = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
}
