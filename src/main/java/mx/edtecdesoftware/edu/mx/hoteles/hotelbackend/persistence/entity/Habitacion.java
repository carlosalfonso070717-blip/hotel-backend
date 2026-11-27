package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Integer idHabitacion; // Identificador de tipo objeto (Integer)

    @Column(name = "numero_habitacion")
    private String numeroHabitacion;

    @Column(name = "tipo_habitacion")
    private String tipoHabitacion;

    @Column(name = "id_hotel")
    private Integer idHotel; // Columna cruda para que no hayan errore a futuro

    // URL pública de la imagen en Supabase Storage (bucket "productos")
    @Column(name = "image_url")
    private String imageUrl;

    // Precio por noche
    @Column(name = "precio")
    private Double precio;

    // Habitaciones disponibles de este tipo
    @Column(name = "stock")
    private Integer stock;

    // Relación ManyToOne hacia hotel
    @ManyToOne
    @JoinColumn(name = "id_hotel", insertable = false, updatable = false)
    private Hotel hotel;

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}