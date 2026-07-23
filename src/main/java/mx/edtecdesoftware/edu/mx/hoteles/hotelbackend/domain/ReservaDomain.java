package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain;

import java.time.LocalDate;

public class ReservaDomain {

    private Integer idReserva;
    private LocalDate fechaCheckIn;
    private LocalDate fechaCheckOut;
    private Integer idHabitacion;
    private Integer idHuesped;

    public ReservaDomain() {
    }

    public ReservaDomain(Integer idReserva, LocalDate fechaCheckIn, LocalDate fechaCheckOut,
                         Integer idHabitacion, Integer idHuesped) {
        this.idReserva = idReserva;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.idHabitacion = idHabitacion;
        this.idHuesped = idHuesped;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setFechaCheckIn(LocalDate fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    public LocalDate getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(LocalDate fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Integer getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(Integer idHuesped) {
        this.idHuesped = idHuesped;
    }
}