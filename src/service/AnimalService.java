package service;

import java.util.Scanner;
import model.Animal;
import enums.*;
import repository.*;

public class AnimalService {

    private AnimalRepository repository = new AnimalRepository();
    private Scanner sc = new Scanner(System.in);

    public void cadastrarAnimal() {

        System.out.println("---CADASTRE SEU PET AQUI!---");

        System.out.println("Informe o tipo do seu Pet: (GATO, CACHORRO, PASSARO OU VACA): ");
        String tipoStr = sc.nextLine().toUpperCase();
        TipoAnimal tipoa = TipoAnimal.valueOf(tipoStr);

        System.out.println("Agora informe a idade: ");
        int idade = Integer.parseInt(sc.nextLine());

        System.out.println("Informe o estado de saúde: (SAUDAVEL, DOENTE, URGÊNCIA OU EM TRATAMENTO): ");
        String estadoStr = sc.nextLine().toUpperCase();
        EstadoAnimal estado = EstadoAnimal.valueOf(estadoStr);

        Animal a = new Animal(idade, tipoa, estado);
        repository.salvar(a);

        System.out.println("Seu animal foi cadastrado com sucesso!");
        System.out.println("Seja bem-vindo ao PandaClinic!");
    }

    public void listarAnimais() {
        System.out.println("--- Lista de Animais ---");
        for (Animal a : repository.listar()) {
            System.out.println(a);
        }
    }
}
