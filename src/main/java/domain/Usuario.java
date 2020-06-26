package domain;

import com.google.common.*;
import com.google.common.hash.Hashing;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario extends Persistente{
    @Column
    private String nombreDeUsuario;

    @Column
    private String contrasenia;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaDeAlta;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaActivo;

    public Usuario(){

    }

    public Usuario(String nombreDeUsuario, String contrasenia){
        this.nombreDeUsuario = nombreDeUsuario;
        this.fechaDeAlta = LocalDate.now();
        this.setContrasenia(contrasenia);
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = Hashing.sha256().hashString(contrasenia, StandardCharsets.UTF_8).toString();
        //Hashing.sha256().hashString(contrasenia, StandardCharsets.UTF_8).toString();

    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
