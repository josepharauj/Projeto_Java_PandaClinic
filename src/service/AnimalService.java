package service;

import java.util.Scanner;
import model.Animal;
import model.Tutor;
import enums.*;
import repository.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalService {

    private List<Animal> animais = new ArrayList<>();
    private TutorService tutorService;
    private Scanner sc = new Scanner(System.in);

    public AnimalService(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    public void cadastrarAnimal() {


        System.out.print("---CADASTRE SEU PET AQUI!---");

        System.out.print("Nome do animal: ");
        String nome = sc.nextLine();

        TipoAnimal tipoa;
        while (true) {
            try {
                System.out.print("Tipo do animal (GATO, CACHORRO, PASSARO, VACA): ");
                tipoa = TipoAnimal.valueOf(sc.nextLine().trim().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo inválido! Digite novamente.");
            }
        }

        int idade;
        while (true) {
            try {
                System.out.print("Idade: ");
                idade = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Idade inválida! Digite um número inteiro.");
            }
        }

        EstadoAnimal estado;
        while (true) {
            try {
                System.out.print("Estado de saúde (SAUDAVEL, DOENTE, URGENCIA, TRATAMENTO): ");
                estado = EstadoAnimal.valueOf(sc.nextLine().trim().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Estado inválido! Digite novamente.");
            }
        }


        PorteAnimal porte;
        while (true) {
            try {
                System.out.print("Porte (PEQUENO, MEDIO, GRANDE): ");
                porte = PorteAnimal.valueOf(sc.nextLine().trim().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Porte inválido! Digite novamente.");
            }
        }

        TipoConsulta tipoc;
        while (true) {
            try {
                System.out.print("Tipo de consulta (ROTINA, VACINACAO, EMERGENCIA, RETORNO, CIRURGIA): ");
                tipoc = TipoConsulta.valueOf(sc.nextLine().trim().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de consulta inválido! Digite novamente.");
            }
        }


        Animal a = new Animal(nome, idade, tipoa, estado, porte, tipoc);

        //Doença
        System.out.print("Informe a doença (ou deixe vazio se não houver): ");
        String doenca = sc.nextLine().trim();
        if (!doenca.isEmpty()) {
            a.setDoenca(doenca);
        }

        //Associando animal ao tutor
        System.out.println("Nome do tutor do animal (ou deixe vazio para nenhum tutor): ");
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
        animais.add(a);
        System.out.println("Animal cadastrado com sucesso!");
    }

    public List<Animal> listarAnimais() {
        return animais;
    }

    public Animal buscarPorNome(String nome) {
        for (Animal a : animais) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }

    public void adicionarAnimal(Animal a) {
        animais.add(a);
    }
}



