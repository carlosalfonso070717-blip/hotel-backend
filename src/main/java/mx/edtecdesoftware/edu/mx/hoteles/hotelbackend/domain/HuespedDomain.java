package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain;

public class HuespedDomain {

    private Integer idHuesped;
    private String nombre;
    private String apellidos;
    private String correo;

    public HuespedDomain() {
    }

    public HuespedDomain(Integer idHuesped, String nombre, String apellidos, String correo) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

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
}