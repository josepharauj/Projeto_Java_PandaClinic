package model;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends Pessoa {

    private  List<Animal> animais;

    public Tutor(String nome, int idade, String cpf, int telefone) {
        super(nome, idade, cpf, telefone);
        this.animais = new ArrayList<>();
    }


    @Override
    public void quemSou() {
        System.out.println("Sou um tutor/responsável por pets.");
    }

    @Override
    public void minhaAtividade() {
        System.out.println("Responsável por trazer o pet às consultas e realizar pagamentos.");
    }

    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void removerAnimal(int index) {
        if (index >= 0 && index < animais.size()) {
            animais.remove(index);
        }
    }


    @Override
    public String toString() {
        return "Tutor{" +
                "animais=" + animais +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}
