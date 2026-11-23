package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain;

import io.swagger.v3.oas.annotations.media.Schema;

public class HabitacionDomain {

    private Integer idHabitacion;
    private String numeroHabitacion;
    private String tipoHabitacion;
    private Integer idHotel;
    private String imageUrl;

    public HabitacionDomain() {
    }

    public HabitacionDomain(Integer idHabitacion, String numeroHabitacion, String tipoHabitacion, Integer idHotel) {
        this.idHabitacion = idHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.idHotel = idHotel;
    }

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
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
}