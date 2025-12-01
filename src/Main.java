
import model.*;
import enums.*;
import service.*;
import Controller.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Serviços

        TutorService tutorService = new TutorService();
        AnimalService animalService = new AnimalService(tutorService);
        VeterinarioService vetService = new VeterinarioService();
        ConsultaService consultaService = new ConsultaService(animalService, vetService);
        RelatorioService relatorioService = new RelatorioService(consultaService.getConsultas());
        FolhaController folhaController = new FolhaController();

        // controllers
        ConsultaController consultaController =
                new ConsultaController(consultaService, animalService, vetService);


        // CADASTRO
        // Criar tutores
        Tutor tutorMaria = new Tutor("Maria", 35, "111.111.111-11", 99999);
        Tutor tutorJoao = new Tutor("João", 28, "222.222.222-22", 88888);
        Tutor tutorCecilia = new Tutor("Cecilia", 21, "333.444.111.11", 222222);
        Tutor tutorMarcos  = new Tutor("Marcos", 18,"555.777.555.77", 22223333);

        // VETERINÁRIOS POR ESPECIALIDADE

        Veterinario Ana = new Veterinario("Ana", 35, "Cirurgia", "222.222.222-22", 88888);
        Veterinario Carlos= new Veterinario("Carlos", 24, "Exames", "123.456.789.00", 222333);
        Veterinario Matias = new Veterinario("Matias", 30, "Vacinação", "555.555.555-55", 55555);
        Veterinario Pedro = new Veterinario("Pedro", 40, "Emergência", "999.999.999-99", 66666);
        vetService.adicionarVeterinario(Ana);
        vetService.adicionarVeterinario(Carlos);
        vetService.adicionarVeterinario(Matias);
        vetService.adicionarVeterinario(Pedro);

        //  FUNCIONÁRIOS

        Funcionario funcionario1 = new Funcionario("João", 28, "111.111.111-11", 99999);
        Funcionario funcionario2 = new Funcionario("Paula", 30, "222.222.222-22", 88888);

        folhaController.pagar(funcionario1);
        folhaController.pagar(funcionario2);

        folhaController.pagar(Ana);
        folhaController.pagar(Carlos);
        folhaController.pagar(Matias);
        folhaController.pagar(Pedro);

        //LISTAGEM DE VETERINÁRIOS
        System.out.println("\n=== Veterinários cadastrados ===");
        vetService.listarVeterinarios();


        //  MENU

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar tutor");
            System.out.println("2 - Cadastrar animal");
            System.out.println("3 - Cadastrar consulta");
            System.out.println("4 - Listar consultas");
            System.out.println("5 - Registrar pagamento");
            System.out.println("6 - Alterar consulta");
            System.out.println("7 - Remover consulta");
            System.out.println("8 - Mostrar folha de pagamento");
            System.out.println("9 - Gerar relatório de consultas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int op = lerInteiro(sc);

            switch (op) {
                case 1 -> tutorService.cadastrarTutor();
                case 2 -> animalService.cadastrarAnimal();
                case 3 -> consultaController.cadastrarConsulta();
                case 4 -> consultaController.listarConsultas();
                case 5-> consultaController.registrarPagamento();
                case 6 -> consultaController.alterarConsulta();
                case 7 -> {
                    System.out.print("Número para remover: ");
                    int index = lerInteiro(sc);
                    consultaService.removerConsulta(index);
                    System.out.println("Consulta removida!");

                }
                case 8 -> folhaController.mostrarRelatorio();
                case 9 -> {
                    relatorioService.tipoAnimalMaisFrequente();
                    relatorioService.doencaMaisFrequente();
                    relatorioService.alertarTutor();
                    relatorioService.aplicarDescontoAutomatico(10);
                }
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
    private static int lerInteiro(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Digite um número válido: ");
            }
        }
    }
}
