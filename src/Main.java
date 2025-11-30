
import model.*;
import service.*;
import Controller.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Serviços
        //FolhaController controller = new FolhaController();
        TutorService tutorService = new TutorService();
        AnimalService animalService = new AnimalService(tutorService);
        VeterinarioService vetService = new VeterinarioService();
        ConsultaService consultaService = new ConsultaService(animalService, vetService);

        // controllers
        ConsultaController consultaController =
                new ConsultaController(consultaService, animalService, vetService);

        FolhaController folhaController = new FolhaController();



        //  INSTANCIAR FUNCIONÁRIOS 1 VEZ (FORA DO MENU)

        Funcionario funcionario = new Funcionario("João", 28, "111.111.111-11", 99999);
        Veterinario vet = new Veterinario("Ana", 35, "Cirurgia", "222.222.222-22", 88888);
        Veterinario a = new Veterinario("Carlos", 24, "Exames", "123.456.789.00", 222333);

        folhaController.pagar(funcionario);
        folhaController.pagar(vet);
        folhaController.pagar(a);

        //  MENU

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar consulta");
            System.out.println("2 - Listar consultas");
            System.out.println("3 - Registrar pagamento");
            System.out.println("4 - Alterar consulta");
            System.out.println("5 - Remover consulta");
            System.out.println("6 - Mostrar folha de pagamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int op = lerInteiro(sc);

            switch (op) {
                case 1 -> consultaController.cadastrarConsulta();
                case 2 -> consultaController.listarConsultas();
                case 3 -> consultaController.registrarPagamento();
                case 4 -> consultaController.alterarConsulta();
                case 5 -> {
                    System.out.print("Número para remover: ");
                    int index = lerInteiro(sc);
                    consultaService.removerConsulta(index);
                    System.out.println("Consulta removida!");

                }
                case 6 -> folhaController.mostrarRelatorio();
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
