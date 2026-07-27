package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.ReservaDomain;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
@Tag(name = "Reservation", description = "Manage bookings in the system.")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    @Operation(summary = "Get all bookings", description = "Return a list of all registered bookings.")
    @ApiResponse(responseCode = "200", description = "Successful retrieval")
    public ResponseEntity<List<ReservaDomain>> getAll() {
        return new ResponseEntity<>(reservaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get booking by ID", description = "Return a booking by its ID if it exists.")
    @ApiResponse(responseCode = "200", description = "Booking found")
    @ApiResponse(responseCode = "404", description = "Booking not found")
    public ResponseEntity<ReservaDomain> getById(
            @Parameter(description = "ID of the booking", example = "1", required = true)
            @PathVariable Integer id) {
        Optional<ReservaDomain> encontrada = reservaService.getById(id);
        if (encontrada.isPresent()) {
            return new ResponseEntity<>(encontrada.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/huesped/{idHuesped}")
    @Operation(summary = "Get bookings by guest", description = "Return all bookings made by a specific guest.")
    @ApiResponse(responseCode = "200", description = "Bookings found for the guest")
    @ApiResponse(responseCode = "404", description = "No bookings found for the guest")
    public ResponseEntity<List<ReservaDomain>> getByHuesped(
            @Parameter(description = "ID of the guest", example = "1", required = true)
            @PathVariable Integer idHuesped) {
        Optional<List<ReservaDomain>> reservas = reservaService.getByHuesped(idHuesped);
        if (reservas.isPresent() && !reservas.get().isEmpty()) {
            return new ResponseEntity<>(reservas.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/habitacion/{idHabitacion}")
    @Operation(summary = "Get bookings by room", description = "Return all bookings made for a specific room.")
    @ApiResponse(responseCode = "200", description = "Bookings found for the room")
    @ApiResponse(responseCode = "404", description = "No bookings found for the room")
    public ResponseEntity<List<ReservaDomain>> getByHabitacion(
            @Parameter(description = "ID of the room", example = "1", required = true)
            @PathVariable Integer idHabitacion) {
        Optional<List<ReservaDomain>> reservas = reservaService.getByHabitacion(idHabitacion);
        if (reservas.isPresent() && !reservas.get().isEmpty()) {
            return new ResponseEntity<>(reservas.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(
            summary = "Save a new booking",
            description = "Register a new booking and return the created booking.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example booking",
                                    value = """
                                        {
                                          "fechaCheckIn": "2026-08-01",
                                          "fechaCheckOut": "2026-08-05",
                                          "idHabitacion": 1,
                                          "idHuesped": 1
                                        }
                                        """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "Booking created successfully")
    public ResponseEntity<ReservaDomain> save(@RequestBody ReservaDomain reservaDomain) {
        return new ResponseEntity<>(reservaService.save(reservaDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a booking by ID", description = "Delete a booking if it exists.")
    @ApiResponse(responseCode = "204", description = "Booking deleted successfully")
    @ApiResponse(responseCode = "404", description = "Booking not found")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID of the booking to delete")
            @PathVariable Integer id) {
        if (reservaService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}