package repository;

import java.util.ArrayList;
import java.util.List;
import model.*;


public class AnimalRepository {

    private List<Animal> animais = new ArrayList<>();

    public void salvar(Animal a) {
        animais.add(a);
    }

    public List<Animal> listar() {
        return animais;
    }

}
