package service;

import java.util.Scanner;
import model.Animal;
import model.Tutor;
import enums.*;
import repository.*;

public class AnimalService {

    private AnimalRepository repository = new AnimalRepository();
    private TutorService tutorService;
    private Scanner sc = new Scanner(System.in);

    public AnimalService(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    public void cadastrarAnimal() {

        System.out.print("---CADASTRE SEU PET AQUI!---");

        System.out.print("Nome do animal: ");
        String nome = sc.nextLine();

        System.out.print("Informe o tipo do seu Pet: (GATO, CACHORRO, PASSARO OU VACA): ");
        TipoAnimal tipoa = TipoAnimal.valueOf(sc.nextLine().toUpperCase());

        System.out.print("Informe a idade: ");
        int idade = Integer.parseInt(sc.nextLine());

        System.out.print("Informe o estado de saúde: (SAUDAVEL, DOENTE, URGÊNCIA OU EM TRATAMENTO): ");
        EstadoAnimal estado = EstadoAnimal.valueOf(sc.nextLine().toUpperCase());

        System.out.print("Informe o porte (PEQUENO, MEDIO, GRANDE)");
        PorteAnimal porte = PorteAnimal.valueOf(sc.nextLine().toUpperCase());

        System.out.print("Informe o tipo de consulta (ROTINA, VACINACAO, EMERGENCIA, RETORNO, CIRURGIA):");
        TipoConsulta tipoc = TipoConsulta.valueOf(sc.nextLine().toUpperCase());

        Animal a = new Animal(nome, idade, tipoa, estado, porte, tipoc);

        //Assoiciando animal ao tutor
        System.out.println("Informe o nome do tutor do animal (ou deixe vazio para nenhum tutor): ");
        String nomeTutor = sc.nextLine();

        if (!nomeTutor.isEmpty()) {
            Tutor tutor = tutorService.buscarPorNome(nomeTutor);

            if (tutor != null) {
                a.setTutor(tutor);
                System.out.println("Tutor associado com sucesso!");
            } else {
                System.out.println("Tutor não encontrado! Animal será cadastrado sem tutor.");
            }
        }

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

    public Animal buscarPorNome(String nome) {
        for (Animal a : repository.listar()) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }

}
