package Controller;

import java.util.Scanner;
import model.Animal;
import service.AnimalService;
import service.TutorService;

public class AnimalController {

    private AnimalService animalService;
    private TutorService tutorService;
    private Scanner sc = new Scanner(System.in);

    public AnimalController(AnimalService animalService, TutorService tutorService) {
        this.animalService = animalService;
        this.tutorService = tutorService;
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

        Animal encontrado = animalService.buscarPorNome(nome);

        if (encontrado != null) {
            System.out.println("Animal encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("Nenhum animal encontrado com esse nome.");
        }
    }
}
