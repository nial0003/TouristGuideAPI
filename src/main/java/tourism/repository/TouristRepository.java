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

    public TouristRepository() {
        touristAttractions = new ArrayList<>();
        touristAttractions.add(new TouristAttraction("Rundetårn", "A round tower in Copenhagen"));
        touristAttractions.add(new TouristAttraction("Lille Havfrue", "Mermaid on a stone in Copenhagen"));
    }

    public TouristAttraction findTouristAttraction(String name) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) {
        touristAttractions.add(new TouristAttraction(touristAttraction.getName(), touristAttraction.getDescription()));
        return touristAttraction;
    }

    public TouristAttraction updateAttractionName(String newName, String oldName) {
        TouristAttraction foundTouristAttraction = findTouristAttraction(oldName);
        if (foundTouristAttraction != null) {
            foundTouristAttraction.setName(newName);
            return foundTouristAttraction;
        } else {
            return null;
        }
    }

    public TouristAttraction updateTouristAttractionDescription(String newDescription, String name) {
        TouristAttraction foundTouristAttraction = findTouristAttraction(name);
        if (foundTouristAttraction != null) {
            foundTouristAttraction.setDescription(newDescription);
            return foundTouristAttraction;
        } else {
            return null;
        }
    }

    public boolean removeTouristAttraction(String name) {
        for (TouristAttraction touristAttraction : touristAttractions){
            if (touristAttraction.getName().equalsIgnoreCase(name)){
                touristAttractions.remove(touristAttraction);
                return true;
            }
        }
        return false;
    }
}
