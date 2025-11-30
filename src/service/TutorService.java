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

    public void adicionarAnimalAoTutor(int idTutor, Animal animal) {
        Tutor t = tutores.get(idTutor);
        if (t != null) {
            t.adicionarAnimal(animal);
        }
    }

    public Tutor buscarPorNome(String nome) {
        for (Tutor t : tutores) {
            if (t.getNome().equalsIgnoreCase(nome)) {
                return t;
            }
        }
        return null;
    }
}
