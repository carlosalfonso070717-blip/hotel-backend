package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.web;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HotelDomain;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hoteles")
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