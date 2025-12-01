package service;

import model.Animal;
import model.Tutor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TutorService {

    private List<Tutor> tutores = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


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

    public void cadastrarTutor() {
        System.out.println("\n=== Cadastro de Tutor ===");

        System.out.print("Nome do tutor: ");
        String nome = sc.nextLine().trim();

        System.out.print("Idade: ");
        int idade = lerInteiro();

        System.out.print("CPF: ");
        String cpf = sc.nextLine().trim();

        System.out.print("Telefone: ");
        int telefone = lerInteiro();

        if (buscarPorNome(nome) != null) {
            System.out.println("Tutor já cadastrado!");
            return;
        }

        Tutor t = new Tutor(nome, idade, cpf, telefone);
        salvar(t);

        System.out.println("Tutor cadastrado com sucesso!");
    }

    private int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Digite um número válido: ");
            }
        }
    }
}


