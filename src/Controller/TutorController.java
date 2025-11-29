package Controller;

import model.Tutor;
import service.TutorService;

import java.util.Scanner;

public class TutorController {

    private TutorService tutorService = new TutorService();
    private Scanner sc = new Scanner(System.in);


    public void cadastrarTutor() {

        System.out.println("\n=== Cadastro de Tutor ===");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(sc.nextLine());

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Telefone: ");
        int telefone = Integer.parseInt(sc.nextLine());

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        Tutor t = new Tutor(nome, idade, cpf, telefone, endereco);
        tutorService.salvar(t);

        System.out.println("Tutor cadastrado com sucesso!");
    }


    public void listarTutores() {
        System.out.println("\n=== Lista de Tutores ===");
        for (Tutor t : tutorService.listar()) {
            System.out.println(t);
        }
    }


    public void buscarPorNome() {
        System.out.println("Digite o nome para buscar:");
        String nome = sc.nextLine();

        Tutor t = tutorService.buscarPorNome(nome);

        if (t != null) {
            System.out.println("Tutor encontrado:");
            System.out.println(t);
        } else {
            System.out.println("Nenhum tutor encontrado com esse nome.");
        }
    }
}
