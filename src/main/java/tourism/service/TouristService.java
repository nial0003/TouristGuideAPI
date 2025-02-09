package tourism.service;

import org.springframework.stereotype.Service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {
    private TouristRepository touristRepository;

    public TouristService(){
        touristRepository = new TouristRepository();
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction){
        return touristRepository.addTouristAttraction(touristAttraction);
    }

    public TouristAttraction updateAttractionName(String newName, String oldName){
        return touristRepository.updateAttractionName(newName, oldName);
    }

    public TouristAttraction updateTouristAttractionDescription(String newDescription, String name){
        return touristRepository.updateTouristAttractionDescription(newDescription, name);
    }

    public boolean removeTouristAttraction(String name){
        return touristRepository.removeTouristAttraction(name);
    }

    public List<TouristAttraction> getTouristAttractions(){
        return touristRepository.getTouristAttractions();
    }

    public TouristAttraction findTouristAttraction(String name){
        return touristRepository.findTouristAttraction(name);
    }
}
