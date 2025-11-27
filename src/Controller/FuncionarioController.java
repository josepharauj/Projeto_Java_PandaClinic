package Controller;

import java.util.Scanner;
import model.Funcionario;
import model.Veterinario;
import service.FuncionarioService;

public class FuncionarioController {

    private FuncionarioService funcionarioService = new FuncionarioService();
    private Scanner sc = new Scanner(System.in);

    public void cadastrarFuncionario() {
        funcionarioService.cadastrarFuncionario();
    }
    public void listarFuncionario() {
        System.out.println("\n=== Funcionários Cadastrados ===");
        for (Funcionario f : funcionarioService.listar()) {
            System.out.println(f);
        }
    }

    public void buscarPorNome() {
        System.out.println("Digite o nome do funcionário:");
        String nome = sc.nextLine();

        Funcionario funcionario  = funcionarioService.buscarPorNome(nome);

        if (funcionario != null) {
            System.out.println("Veterinário encontrado:");
            System.out.println(funcionario);
        } else {
            System.out.println("Nenhum funcionário encontrado com esse nome.");
        }
    }

}
