package pet_house.dao;

import pet_house.model.Cat;
import pet_house.model.Dog;
import pet_house.model.Pet;

import java.util.Arrays;
import java.util.function.Predicate;

public class HouseImpl implements House {

    private Pet[] pets;
    private int size;

    // capacity - возможное кол-во животных
    public HouseImpl(int capacity) {
        this.pets = new Pet[capacity];
        // this.size = size;
    }

    @Override
    public boolean addPet(Pet pet) {
        // bad cases
        if (pet == null) {
            return false;
        }
        if (size == pets.length) {
            return false;
        }
        if (findPetByNickname(pet.getNickname()) != null) {
            return false;
        }
        // good case
        pets[size] = pet; // put in array
        System.out.println("Добавлено животное: " + pet.getNickname()); // Отладочный вывод
        size++;
        return true;
    }

    @Override
    public void printPet() {
        for (int i = 0; i < size; i++) {
            System.out.println(pets[i]);
        }
    }

    @Override
    public Pet removePet(int id) {
        for (int i = 0; i < size; i++) {
            if (pets[i].getId() == id) {
                Pet victim = pets[i];
                System.arraycopy(pets, i + 1, pets, i, size - i - 1);
                pets[--size] = null;
                return victim;
            }
        }
        return null;
    }

    @Override
    public Pet updatePet(Pet pet) {
        for (int i = 0; i < size; i++) {
            if (pets[i].getId() == pet.getId()) {
                pets[i] = pet;
                return pets[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Pet findPetByNickname(String nickname) {
        for (int i = 0; i < size; i++) {
            if(pets[i].getNickname().equals(nickname)) {
                return pets[i];
            }
        }
        return null;
    }

    @Override
    public Pet[] findDogByBreed(String breed) {
        return findPetByPredicate(pet -> pet instanceof Dog && ((Dog) pet).getBreed().equals(breed));
    }

    @Override
    public Pet[] findCatByBreed(String breed) {
        return findPetByPredicate(pet -> pet instanceof Cat && ((Cat) pet).getBreed().equals(breed));
    }

    private Pet[] findPetByPredicate(Predicate<Pet> predicate) {
        Pet[] res = new Pet[size];
        int j = 0; // это индексы массива результатов
        for (int i = 0; i < size; i++) {
            if (predicate.test(pets[i])) {
                res[j++] = pets[i];
            }
        }
        return Arrays.copyOf(res, j); // обрезаем хвост из null
    }
}


