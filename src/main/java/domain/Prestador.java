package domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "prestador")
public class Prestador extends Persistente {
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "fechaDeNacimiento", columnDefinition = "DATE")
    private LocalDate fechaDeNacimiento;

    @Column(name = "foto")
    private String foto;

    @Column
    private String cuitCuil;

    @Enumerated(EnumType.STRING)
    private TipoDeDocumento tipoDeDocumento;

    @Column
    private Integer numeroDeIdentificacion;

    @ElementCollection
    @CollectionTable(name = "email", joinColumns = @JoinColumn(name = "prestador_id"))
    @Column(name = "email")
    private Set<String> emails;

    @ElementCollection
    @CollectionTable(name = "telefono", joinColumns = @JoinColumn(name = "prestador_id"))
    @Column(name = "telefono")
    private Set<Integer> telefonos;

    public Prestador(){
    }

    public Prestador(String nombre, String apellido, Usuario usuario){
        this.init(nombre, apellido);
        this.usuario = usuario;
    }

    public Prestador(String nombre, String apellido){
        this.init(nombre, apellido);
    }

    private void init(String nombre, String apellido){
        this.nombre     = nombre;
        this.apellido   = apellido;
        this.emails     = new LinkedHashSet<>();
        this.telefonos  = new LinkedHashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCuitCuil() {
        return cuitCuil;
    }

    public void setCuitCuil(String cuitCuil) {
        this.cuitCuil = cuitCuil;
    }

    public TipoDeDocumento getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(TipoDeDocumento tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public Integer getNumeroDeIdentificacion() {
        return numeroDeIdentificacion;
    }

    public void setNumeroDeIdentificacion(Integer numeroDeIdentificacion) {
        this.numeroDeIdentificacion = numeroDeIdentificacion;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public Set<Integer> getTelefonos() {
        return telefonos;
    }

    public void agregarTelefonos(Integer ... telefonos){
        Collections.addAll(this.telefonos, telefonos);
    }

    public void agregarMails(String ... mails){
        Collections.addAll(this.emails, mails);
    }
}