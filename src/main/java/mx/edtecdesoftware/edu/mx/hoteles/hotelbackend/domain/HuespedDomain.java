package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class HuespedDomain {

    private Integer idHuesped;
    private String nombre;
    private String apellidos;
    private String correo;
    private String contrasena;

    public HuespedDomain() {
    }

    public HuespedDomain(Integer idHuesped, String nombre, String apellidos, String correo, String contrasena) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    public Integer getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(Integer idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Schema(accessMode = Schema.AccessMode.WRITE_ONLY)
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}