package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HotelDomain;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hoteles")
@Tag(name = "Hotel", description = "Central entity that controls the others.")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<HotelDomain>> getAll() {
        return new ResponseEntity<>(hotelService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDomain> getById(@PathVariable Integer id) {
        Optional<HotelDomain> encontrado = hotelService.getById(id);
        if (encontrado.isPresent()) {
            return new ResponseEntity<>(encontrado.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(
            summary = "Save a new hotel",
            description = "Register a new hotel and return the created hotel.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example hotel",
                                    value = """
                                        {
                                          "nombre": "Hotel Central",
                                          "direccion": "Av. Reforma 100"
                                        }
                                        """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "Hotel created successfully")
    public ResponseEntity<HotelDomain> save(@RequestBody HotelDomain hotelDomain) {
        return new ResponseEntity<>(hotelService.save(hotelDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (hotelService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}