package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain;

public class HotelDomain {

    private Integer idHotel;
    private String nombre;
    private String direccion;

    public HotelDomain() {
    }

    public HotelDomain(Integer idHotel, String nombre, String direccion) {
        this.idHotel = idHotel;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}