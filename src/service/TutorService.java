package service;

import model.Animal;
import model.Tutor;
import java.util.ArrayList;
import java.util.List;

public class TutorService {

    private List<Tutor> tutores = new ArrayList<>();

    public void salvar(Tutor t) {
        tutores.add(t);
    }

    public List<Tutor> listar() {
        return tutores;
    }

    public Tutor buscarPorNome(String nome) {
        for (Tutor t : tutores) {
            if (t.getNome().equalsIgnoreCase(nome)) {
                return t;
            }
        }
        return null;
    }

    public boolean adicionarAnimalAoTutor(String nomeTutor, Animal animal) {
        Tutor t = buscarPorNome(nomeTutor);

        if (t != null) {
            t.adicionarAnimal(animal);
            return true;
        }
        return false;
    }
}
