package Controller;

import java.util.Scanner;
import model.Animal;
import service.AnimalService;


public class AnimalController {

    private AnimalService animalService;
    private Scanner sc = new Scanner(System.in);

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    public void cadastrarAnimal() {
        animalService.cadastrarAnimal();

    }

    public void listarAnimais() {
        animalService.listarAnimais();
    }

    public void buscarPorNome() {
        System.out.println("Digite o nome do animal para buscar:");
        String nome = sc.nextLine();

        var a = animalService.buscarPorNome(nome);

        if (a != null) {
            System.out.println("Animal encontrado:");
            System.out.println(a);
        } else {
            System.out.println("Nenhum animal encontrado com esse nome.");
        }
    }
}
