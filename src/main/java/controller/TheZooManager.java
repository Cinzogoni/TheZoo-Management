package controller;

import java.util.ArrayList;
import model.Animal;

public class TheZooManager {

    private final ArrayList<Animal> animals = new ArrayList<>();

    public ArrayList<Animal> getAnimalList() {
        return new ArrayList<>(animals);
    }

    public boolean isListEmpty() {
        return this.animals.isEmpty();
    }

    public Animal findById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }

        for (Animal a : this.animals) {
            if (a.getId().equalsIgnoreCase(id)) {
                return a;
            }
        }
        return null;
    }

    public boolean addAnimal(Animal animal) {
        if (animal == null || animal.getId() == null) {
            return false;
        }

        if (findById(animal.getId()) != null) {
            return false;
        }

        animals.add(animal);
        return true;
    }

    public boolean removeAnimal(String id) {
        Animal foundAnimal = findById(id);

        if (foundAnimal != null) {
            animals.remove(foundAnimal);
            return true;
        }

        return false;
    }

    public boolean updateAnimal(String id, Animal updateAnimal) {
        Animal foundAnimal = findById(id);

        if (foundAnimal != null && updateAnimal != null) {
            int index = animals.indexOf(foundAnimal);
            animals.set(index, updateAnimal);
            return true;
        }

        return false;
    }

    public ArrayList<Animal> searchAnimalByName(String keyword) {
        ArrayList<Animal> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase().trim();

        for (Animal a : this.animals) {
            if (a.getName().toLowerCase().contains(lowerKeyword)) {
                result.add(a);
            }
        }
        return result;
    }
}
