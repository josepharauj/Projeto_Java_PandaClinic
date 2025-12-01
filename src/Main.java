
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


        //  FUNCIONÁRIOS

        Funcionario funcionario1 = new Funcionario("João", 28, "111.111.111-11", 99999);
        Funcionario funcionario2 = new Funcionario("Paula", 30, "222.222.222-22", 88888);

        folhaController.pagar(funcionario1);
        folhaController.pagar(funcionario2);

        // VETERINÁRIOS POR ESPECIALIDADE


        Veterinario Ana = new Veterinario("Ana", 35, "Cirurgia", "222.222.222-22", 88888);
        Veterinario Carlos= new Veterinario("Carlos", 24, "Exames", "123.456.789.00", 222333);
        Veterinario Matias = new Veterinario("Matias", 30, "Vacinação", "555.555.555-55", 55555);
        Veterinario Pedro = new Veterinario("Pedro", 40, "Emergência", "999.999.999-99", 66666);

        // CADASTRANDO VETERINÁRIOS DEPOIS DE EXTANCIAR-LOS
        vetService.adicionarVeterinario(Ana);
        vetService.adicionarVeterinario(Carlos);
        vetService.adicionarVeterinario(Matias);
        vetService.adicionarVeterinario(Pedro);

        folhaController.pagar(Ana);
        folhaController.pagar(Carlos);
        folhaController.pagar(Matias);
        folhaController.pagar(Pedro);

        //LISTAGEM DE VETERINÁRIOS
        System.out.println("\n=== Veterinários cadastrados ===");
        vetService.listarVeterinarios();


        // CADASTRO
        // Criar tutores
        Tutor tutorMaria = new Tutor("Maria", 35, "111.111.111-11", 99999);
        Tutor tutorJoao = new Tutor("João", 28, "222.222.222-22", 88888);
        Tutor tutorCecilia = new Tutor("Cecilia", 21, "333.444.111.11", 222222);
        Tutor tutorMarcos  = new Tutor("Marcos", 18,"555.777.555.77", 22223333);

        // Criar animais
        Animal animal1 = new Animal("Rex", 5, TipoAnimal.CACHORRO, EstadoAnimal.SAUDAVEL, PorteAnimal.MEDIO, TipoConsulta.ROTINA);
        animal1.setTutor(tutorMaria);
        animal1.setDoenca("Gripe");

        Animal animal2 = new Animal("Mimi", 3, TipoAnimal.GATO, EstadoAnimal.TRATAMENTO, PorteAnimal.PEQUENO, TipoConsulta.VACINACAO);
        animal2.setTutor(tutorJoao);
        animal2.setDoenca("Pulgas");

        Animal animal3 = new Animal("Mag", 2, TipoAnimal.VACA, EstadoAnimal.SAUDAVEL, PorteAnimal.GRANDE, TipoConsulta.ROTINA);
        animal3.setTutor(tutorCecilia);
        animal3.setDoenca("Gripe");

        Animal animal4 = new Animal("Nita", 1,TipoAnimal.PASSARO, EstadoAnimal.URGENCIA, PorteAnimal.PEQUENO, TipoConsulta.CIRURGIA);
        animal4.setTutor(tutorMarcos);
        animal4.setDoenca("Fratura");


        // Adicionar animais no AnimalService
        animalService.salvarAnimal(animal1);
        animalService.salvarAnimal(animal2);
        animalService.salvarAnimal(animal3);
        animalService.salvarAnimal(animal4);



        // Criar consultas
        consultaService.adicionarConsulta(new Consulta(animal1, Carlos, TipoConsulta.ROTINA, "01/12/2025"));
        consultaService.adicionarConsulta(new Consulta(animal2, Matias, TipoConsulta.VACINACAO, "02/12/2025"));
        consultaService.adicionarConsulta(new Consulta(animal3, Carlos, TipoConsulta.ROTINA, "03/12/2025"));
        consultaService.adicionarConsulta(new Consulta(animal4, Ana, TipoConsulta.CIRURGIA, "04/12/2025"));


        //  MENU

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar consulta");
            System.out.println("2 - Listar consultas");
            System.out.println("3 - Registrar pagamento");
            System.out.println("4 - Alterar consulta");
            System.out.println("5 - Remover consulta");
            System.out.println("6 - Mostrar folha de pagamento");
            System.out.println("7 - Gerar relatório de consultas");
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
                case 7 -> consultaController.gerarRelatorio();
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
