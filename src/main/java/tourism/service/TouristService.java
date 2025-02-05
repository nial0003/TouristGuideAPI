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

    public void updateAttractionName(String newName, String oldName){
        touristRepository.updateAttractionName(newName, oldName);
    }

    public void updateTouristAttractionDescription(String newDescription, String oldName){
        touristRepository.updateTouristAttractionDescription(newDescription, oldName);
    }

    public void removeTouristAttraction(String name){
        touristRepository.removeTouristAttraction(name);
    }

    public List<TouristAttraction> getTouristAttractions(){
        return touristRepository.getTouristAttractions();
    }

    public TouristAttraction findTouristAttraction(String name){
        return touristRepository.findTouristAttraction(name);
    }
}
