package Controller;

import enums.TipoConsulta;
import model.Animal;
import model.Consulta;
import model.Veterinario;
import service.AnimalService;
import service.VeterinarioService;
import service.ConsultaService;
import java.util.Scanner;

public class ConsultaController {

    private ConsultaService service;
    private AnimalService animalService;
    private VeterinarioService vetService;
    private Scanner sc = new Scanner(System.in);

    public ConsultaController(ConsultaService service,
                              AnimalService animalService,
                              VeterinarioService vetService) {
        this.service = service;
        this.animalService = animalService;
        this.vetService = vetService;
    }

    public void cadastrarConsulta() {
        System.out.println("\n=== Cadastro de Consulta ===");

        // Escolher animal
        if (animalService.listarAnimais().isEmpty()) {
            System.out.println("Nenhum animal cadastrado! Cadastre um animal antes.");
            return;
        }

        System.out.println("Animais disponíveis:");
        for (int i = 0; i < animalService.listarAnimais().size(); i++) {
            System.out.println(i + " - " + animalService.listarAnimais().get(i).getNome());
        }
        System.out.print("Escolha o número do animal: ");
        int animalIndex = Integer.parseInt(sc.nextLine());
        Animal a = animalService.listarAnimais().get(animalIndex);

        // Escolher veterinário
        if (vetService.getVeterinarios().isEmpty()) {
            System.out.println("Nenhum veterinário cadastrado! Cadastre veterinários primeiro.");
            return;
        }

        System.out.println("\nVeterinários disponíveis:");
        for (int i = 0; i < vetService.getVeterinarios().size(); i++) {
            Veterinario v = vetService.getVeterinarios().get(i);
            System.out.println(i + " - " + v.getNome() + " (" + v.getEspecialidade() + ")");
        }
        System.out.print("Escolha o número do veterinário: ");
        int vetIndex = Integer.parseInt(sc.nextLine());
        Veterinario v = vetService.getVeterinarios().get(vetIndex);

        // Tipo de consulta
        TipoConsulta[] tipos = TipoConsulta.values();
        for (int i = 0; i < tipos.length; i++) {
            System.out.println(i + " - " + tipos[i]);
        }
        System.out.print("Escolha o tipo de consulta: ");
        int tipoIndex = Integer.parseInt(sc.nextLine());
        TipoConsulta tipoc = tipos[tipoIndex];

        // Data
        System.out.print("Data da consulta: ");
        String data = sc.nextLine();

        // Criar consulta
        Consulta c = new Consulta(a, v, tipoc, data);
        service.adicionarConsulta(c);

        System.out.println("Consulta registrada com sucesso!");
    }

    public void listarConsultas() {
        System.out.println("\n=== Lista de Consultas ===");
        int index = 0;
        for (Consulta c : service.getConsultas()) {
            System.out.println(index + " - " + c);
            index++;
        }
    }

    public void registrarPagamento() {
        listarConsultas();
        System.out.print("\nNúmero da consulta para pagar: ");
        int index = Integer.parseInt(sc.nextLine());
        Consulta c = service.getConsultas().get(index);
        c.registrarPagamento();
        System.out.println("Pagamento registrado! Valor: " + c.getValor());
    }

    public void alterarConsulta() {
        listarConsultas();
        System.out.print("\nNúmero da consulta para alterar: ");
        int index = Integer.parseInt(sc.nextLine());
        Consulta c = service.getConsultas().get(index);

        // Escolher novo animal
        System.out.println("Escolha o novo animal:");
        for (int i = 0; i < animalService.listarAnimais().size(); i++) {
            System.out.println(i + " - " + animalService.listarAnimais().get(i).getNome());
        }
        int animalIndex = Integer.parseInt(sc.nextLine());
        Animal a = animalService.listarAnimais().get(animalIndex);

        // Escolher novo veterinário
        System.out.println("Escolha o novo veterinário:");
        for (int i = 0; i < vetService.getVeterinarios().size(); i++) {
            Veterinario v = vetService.getVeterinarios().get(i);
            System.out.println(i + " - " + v.getNome() + " (" + v.getEspecialidade() + ")");
        }
        int vetIndex = Integer.parseInt(sc.nextLine());
        Veterinario v = vetService.getVeterinarios().get(vetIndex);

        // Tipo de consulta
        TipoConsulta[] tipos = TipoConsulta.values();
        for (int i = 0; i < tipos.length; i++) {
            System.out.println(i + " - " + tipos[i]);
        }
        System.out.print("Escolha o tipo de consulta: ");
        int tipoIndex = Integer.parseInt(sc.nextLine());
        TipoConsulta tipoc = tipos[tipoIndex];

        // Data
        System.out.print("Nova data: ");
        String data = sc.nextLine();

        service.alterarConsulta(index, a, v, tipoc, data);
        System.out.println("Consulta alterada com sucesso!");
    }
}
