package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HabitacionDomain;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habitaciones")
@Tag(name = "Room", description = "Manage rooms in the system.")
public class HabitacionController {

    private final HabitacionService habitacionService;

    @Autowired
    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping
    @Operation(summary = "Get all rooms", description = "Return a list of all registered rooms.")
    @ApiResponse(responseCode = "200", description = "Successful retrieval")
    public ResponseEntity<List<HabitacionDomain>> getAll() {
        return new ResponseEntity<>(habitacionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get room by ID", description = "Return a room by its ID if it exists.")
    @ApiResponse(responseCode = "200", description = "Room found")
    @ApiResponse(responseCode = "404", description = "Room not found")
    public ResponseEntity<HabitacionDomain> getById(
            @Parameter(description = "ID of the room", example = "1", required = true)
            @PathVariable Integer id) {
        Optional<HabitacionDomain> encontrada = habitacionService.getById(id);
        if (encontrada.isPresent()) {
            return new ResponseEntity<>(encontrada.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/hotel/{idHotel}")
    @Operation(summary = "Get rooms by hotel", description = "Return all rooms belonging to a specific hotel.")
    @ApiResponse(responseCode = "200", description = "Rooms found for the hotel")
    @ApiResponse(responseCode = "404", description = "No rooms found for the hotel")
    public ResponseEntity<List<HabitacionDomain>> getByHotel(
            @Parameter(description = "ID of the hotel", example = "1", required = true)
            @PathVariable Integer idHotel) {
        Optional<List<HabitacionDomain>> habitaciones = habitacionService.getByHotel(idHotel);
        if (habitaciones.isPresent() && !habitaciones.get().isEmpty()) {
            return new ResponseEntity<>(habitaciones.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(
            summary = "Save a new room",
            description = "Register a new room and return the created room.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example room",
                                    value = """
                                        {
                                          "numeroHabitacion": "101",
                                          "tipoHabitacion": "Individual",
                                          "idHotel": 1
                                        }
                                        """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "Room created successfully")
    public ResponseEntity<HabitacionDomain> save(@RequestBody HabitacionDomain habitacionDomain) {
        return new ResponseEntity<>(habitacionService.save(habitacionDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a room by ID", description = "Delete a room if it exists.")
    @ApiResponse(responseCode = "204", description = "Room deleted successfully")
    @ApiResponse(responseCode = "404", description = "Room not found")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID of the room to delete")
            @PathVariable Integer id) {
        if (habitacionService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}