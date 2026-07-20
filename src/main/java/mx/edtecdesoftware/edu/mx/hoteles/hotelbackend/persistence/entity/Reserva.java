package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    @Column(name = "fecha_check_in")
    private LocalDate fechaCheckIn;

    @Column(name = "fecha_check_out")
    private LocalDate fechaCheckOut;

    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @Column(name = "id_huesped")
    private Integer idHuesped;

    // Relación con Habitación
    @ManyToOne
    @JoinColumn(name = "id_habitacion", insertable = false, updatable = false)
    private Habitacion habitacion;

    // Relación con Huésped
    @ManyToOne
    @JoinColumn(name = "id_huesped", insertable = false, updatable = false)
    private Huesped huesped;


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

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }
}