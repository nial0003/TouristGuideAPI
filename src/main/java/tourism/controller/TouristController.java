package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController() {
        this.touristService = new TouristService();
    }

    @GetMapping("/getAttractions")
    public ResponseEntity<List<TouristAttraction>> getTouristAttractions() {
        List<TouristAttraction> touristAttractions = touristService.getTouristAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    @GetMapping("/{attractionName}")
    public ResponseEntity<TouristAttraction> findTouristAttraction(@PathVariable String attractionName) {
        return new ResponseEntity<>(touristService.findTouristAttraction(attractionName), HttpStatus.OK);
    }

    @PostMapping("/addAttraction")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        return new ResponseEntity<>(touristService.addTouristAttraction(touristAttraction), HttpStatus.CREATED);
    }

    @PostMapping("/updateName")
    public ResponseEntity<TouristAttraction> updateTouristAttractionName(@RequestParam String oldName,
                                                                         @RequestParam String newName) {
        TouristAttraction updatedTouristAttraction = touristService.updateAttractionName(newName, oldName);
        if (updatedTouristAttraction != null) {
            return new ResponseEntity<>(updatedTouristAttraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/updateDescription")
    public ResponseEntity<TouristAttraction> updateTouristAttractionDescription(@RequestParam String name,
                                                                                @RequestParam String newDescription) {
        TouristAttraction updatedTouristAttraction = touristService.updateTouristAttractionDescription(newDescription, name);
        if (updatedTouristAttraction != null) {
            return new ResponseEntity<>(updatedTouristAttraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/deleteAttraction")
    public ResponseEntity<String> deleteTouristAttraction(@RequestParam String name){
        boolean isDeleted = touristService.removeTouristAttraction(name);
        if (isDeleted){
            return new ResponseEntity<>("Tourist attraction deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("TouristAttraction not found.", HttpStatus.NOT_FOUND);
        }
    }
}
