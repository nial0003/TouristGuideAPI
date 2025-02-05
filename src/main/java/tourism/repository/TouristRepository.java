package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    public List<TouristAttraction> getTouristAttractions() {
        return touristAttractions;
    }

    List<TouristAttraction> touristAttractions;

    public TouristRepository(){
        touristAttractions = new ArrayList<>();
        touristAttractions.add(new TouristAttraction("Rundetårn", "A round tower in Copenhagen"));
        touristAttractions.add(new TouristAttraction("Lille Havfrue", "Mermaid on a stone in Copenhagen"));
    }

    public TouristAttraction findTouristAttraction(String name){
        for (TouristAttraction touristAttraction : touristAttractions){
            if (touristAttraction.getName().equalsIgnoreCase(name)){
                return touristAttraction;
            }
        }
        return null;
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction){
        touristAttractions.add(new TouristAttraction(touristAttraction.getName(),touristAttraction.getDescription()));
        return touristAttraction;
    }

    public void updateAttractionName(String newName, String oldName){
        TouristAttraction foundTouristAttraction = findTouristAttraction(oldName);
        if (foundTouristAttraction != null){
            foundTouristAttraction.setName(newName);
        }
    }

    public void updateTouristAttractionDescription(String newDescription, String oldName){
        TouristAttraction foundTouristAttractioner = findTouristAttraction(oldName);
        if (foundTouristAttractioner!= null){
            foundTouristAttractioner.setDescription(newDescription);
        }
    }

    public void removeTouristAttraction(String name){
        touristAttractions.removeIf(touristAttraction -> touristAttraction.getName().equalsIgnoreCase(name));
    }
}
