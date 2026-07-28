package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HuespedDomain;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.service.HuespedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/huespedes")
@Tag(name = "Guest", description = "Manage guests in the system.")
@SecurityRequirement(name = "bearerAuth")
public class HuespedController {

    private final HuespedService huespedService;

    @Autowired
    public HuespedController(HuespedService huespedService) {
        this.huespedService = huespedService;
    }

    @GetMapping
    @Operation(summary = "Get all guests", description = "Return a list of all registered guests.")
    @ApiResponse(responseCode = "200", description = "Successful retrieval")
    public ResponseEntity<List<HuespedDomain>> getAll() {
        return new ResponseEntity<>(huespedService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get guest by ID", description = "Return a guest by its ID if it exists.")
    @ApiResponse(responseCode = "200", description = "Guest found")
    @ApiResponse(responseCode = "404", description = "Guest not found")
    public ResponseEntity<HuespedDomain> getById(
            @Parameter(description = "ID of the guest", example = "1", required = true)
            @PathVariable Integer id) {
        Optional<HuespedDomain> encontrado = huespedService.getById(id);
        if (encontrado.isPresent()) {
            return new ResponseEntity<>(encontrado.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/correo/{correo}")
    @Operation(summary = "Get guest by email", description = "Return a guest by their email if it exists.")
    @ApiResponse(responseCode = "200", description = "Guest found")
    @ApiResponse(responseCode = "404", description = "Guest not found")
    public ResponseEntity<HuespedDomain> getByCorreo(
            @Parameter(description = "Email of the guest", example = "juan@correo.com", required = true)
            @PathVariable String correo) {
        Optional<HuespedDomain> encontrado = huespedService.getByCorreo(correo);
        if (encontrado.isPresent()) {
            return new ResponseEntity<>(encontrado.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(
            summary = "Save a new guest",
            description = "Register a new guest and return the created guest.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example guest",
                                    value = """
                                        {
                                          "nombre": "Juan",
                                          "apellidos": "Perez",
                                          "correo": "juan@correo.com"
                                        }
                                        """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "Guest created successfully")
    public ResponseEntity<HuespedDomain> save(@RequestBody HuespedDomain huespedDomain) {
        return new ResponseEntity<>(huespedService.save(huespedDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a guest by ID", description = "Delete a guest if it exists.")
    @ApiResponse(responseCode = "204", description = "Guest deleted successfully")
    @ApiResponse(responseCode = "404", description = "Guest not found")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID of the guest to delete")
            @PathVariable Integer id) {
        if (huespedService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}