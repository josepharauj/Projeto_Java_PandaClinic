
package Controller;

import enums.TipoConsulta;
import model.Animal;
import model.Consulta;
import model.Veterinario;
import service.AnimalService;
import service.VeterinarioService;
import service.ConsultaService;
import service.RelatorioService;
import java.util.Scanner;

// ConsultaController está cinza
public class ConsultaController {

    private ConsultaService service;
    private AnimalService animalService;
    private VeterinarioService vetService;
    private Scanner sc = new Scanner(System.in);

//  ConsultaController está cinza
    public ConsultaController(ConsultaService service,
                              AnimalService animalService,
                              VeterinarioService vetService) {
        this.service = service;
        this.animalService = animalService;
        this.vetService = vetService;
    }

// cadastrarConsulta está cinza
    public void cadastrarConsulta() {

        System.out.println("\n=== Cadastro de Consulta ===");

        // BUSCAR ANIMAL
        System.out.print("Nome do animal: ");
        String nomeAnimal = sc.nextLine();
        Animal a = animalService.buscarPorNome(nomeAnimal);
        if (a == null) {
            System.out.println("Animal não encontrado!");
            return;
        }
        // BUSCAR VETERINÁRIO
        System.out.print("Nome do veterinário: ");
        String nomeVet = sc.nextLine();

        Veterinario v = vetService.buscarPorNome(nomeVet);

        if (v == null) {
            System.out.println("Veterinário não encontrado!");
            return;
        }

        //  TIPO DE CONSULTA
        System.out.println("Tipos disponíveis: ROTINA, VACINACAO, EMERGENCIA, RETORNO, CIRURGIA");
        System.out.print("Tipo da consulta: ");
        String tipoStr = sc.nextLine().toUpperCase();

        TipoConsulta tipoc;
        try {
            tipoc = TipoConsulta.valueOf(tipoStr);
        } catch (Exception e) {
            System.out.println("Tipo de consulta inválido!");
            return;
        }

        // DATA
        System.out.print("Data da consulta: ");
        String data = sc.nextLine();

        Consulta consulta = new Consulta(a, v, tipoc, data);
        service.adicionarConsulta(consulta);

        System.out.println("\nConsulta registrada com sucesso!");
    }


    //LISTA DE CONSULTAS
    public void listarConsultas() {
        System.out.println("\n=== Lista de Consultas ===");

        int index = 0;
        for (Consulta c : service.getConsultas()) {
            System.out.println(index + " - " + c);
            index++;
        }
    }

    //PAGAMENTO
    public void registrarPagamento() {

        listarConsultas();

        System.out.print("\nNúmero da consulta para pagar: ");
        int index = Integer.parseInt(sc.nextLine());

        if (index < 0 || index >= service.getConsultas().size()) {
            System.out.println("Consulta inválida!");
            return;
        }

        Consulta c = service.getConsultas().get(index);

        if (c.isPaga()) {
            System.out.println("Essa consulta já foi paga!");
            return;
        }

        c.registrarPagamento();
        System.out.println("Pagamento registrado! Valor: R$ " + c.getValor());
    }


// ALTERAÇÃO
    public void alterarConsulta() {

        listarConsultas();

        System.out.print("\nNúmero da consulta para alterar: ");
        int index = Integer.parseInt(sc.nextLine());

        if (index < 0 || index >= service.getConsultas().size()) {
            System.out.println("Consulta inválida!");
            return;
        }

        // Buscar animal
        System.out.print("Novo nome do animal: ");
        Animal a = animalService.buscarPorNome(sc.nextLine());
        if (a == null) {
            System.out.println("Animal não encontrado!");
            return;
        }

        // Buscar veterinario
        System.out.print("Novo nome do veterinário: ");
        Veterinario v = vetService.buscarPorNome(sc.nextLine());
        if (v == null) {
            System.out.println("Veterinário não encontrado!");
            return;
        }

        // Tipo consulta
        System.out.print("Novo tipo de consulta: ");
        TipoConsulta tipoc = TipoConsulta.valueOf(sc.nextLine().toUpperCase());

        // Data
        System.out.print("Nova data: ");
        String data = sc.nextLine();

        // Aplicando alteração
        service.alterarConsulta(index, a, v, tipoc, data);

        System.out.println("Consulta alterada com sucesso!");
    }

    public void gerarRelatorio() {
        System.out.println("\n=== Relatório de Consultas ===");

        RelatorioService relatorioService = new RelatorioService(service.getConsultas());

        // Tipo de animal mais frequente
        relatorioService.tipoAnimalMaisFrequente();

        // Doença mais frequente
        relatorioService.doencaMaisFrequente();

        // Alertar tutor sobre doenças repetidas
        relatorioService.alertarTutor();

        // Aplicar desconto automático em consultas não pagas
        relatorioService.aplicarDescontoAutomatico(10); // desconto de 10%
    }
}


