package Controller;

import java.util.Scanner;
import model.Animal;
import service.AnimalService;

public class AnimalController {

    private AnimalService animalService = new AnimalService();
    private Scanner sc = new Scanner(System.in);

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
