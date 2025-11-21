package service;

import java.util.Scanner;
import model.Animal;
import enums.*;
import repository.*;

public class AnimalService {

    private AnimalRepository repository = new AnimalRepository();
    private Scanner sc = new Scanner(System.in);

    public void cadastrarAnimal() {

        System.out.println("=== Cadastro de Animal ===");

        System.out.println("Informe o tipo (GATO, CACHORRO, PASSARO): ");
        String tipoStr = sc.nextLine().toUpperCase();
        TipoAnimal tipo = TipoAnimal.valueOf(tipoStr);

        System.out.println("Informe a idade: ");
        int idade = Integer.parseInt(sc.nextLine());

        System.out.println("Informe o estado (SAUDAVEL, DOENTE, EM_TRATAMENTO): ");
        String estadoStr = sc.nextLine().toUpperCase();
        EstadoAnimal estado = EstadoAnimal.valueOf(estadoStr);

        Animal a = new Animal(nome, idade, tipoa, estado, porte );

        repository.salvar(a);

        System.out.println("Animal cadastrado com sucesso!");
    }

    public void listarAnimais() {
        System.out.println("=== Lista de Animais ===");
        for (Animal a : repository.listar()) {
            System.out.println(a);
        }
    }
}
