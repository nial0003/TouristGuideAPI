package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController() {
        this.touristService = new TouristService();
    }

    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getTouristAttractions(){
        List<TouristAttraction> touristAttractions = touristService.getTouristAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<TouristAttraction> findTouristAttraction(@RequestBody String name){
        return new ResponseEntity<>(touristService.findTouristAttraction(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        return new ResponseEntity<>(touristService.addTouristAttraction(touristAttraction), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<TouristAttraction> updateTouristAttractionName(@RequestBody TouristAttraction touristAttraction){

    }

    @PostMapping
    public ResponseEntity<TouristAttraction> updateTouristAttractionDescription();

    @PostMapping
    public ResponseEntity<TouristAttraction> deleteTouristAttraction();
}
