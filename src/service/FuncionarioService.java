package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Funcionario;


public class FuncionarioService {

   private List<Funcionario> funcionarios = new ArrayList<>();
   private Scanner sc = new Scanner(System.in);

    public void cadastrarFuncionario() {
        System.out.println("\n=== Cadastro de Funcionário ===");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(sc.nextLine());

        System.out.println("CPF: ");
        String cpf = sc.nextLine();

        System.out.println("Telefone:");
        int telefone = Integer.parseInt(sc.nextLine());

        Funcionario f = new Funcionario(nome, idade, cpf, telefone);

        salvar(f);

        System.out.println("Funcionário cadastrado com sucesso!");
    }


    public void salvar(Funcionario f) {
        funcionarios.add(f);
    }

    public List<Funcionario> listar() {
        return funcionarios;
    }


    public Funcionario buscarPorNome(String nome) {
        for (Funcionario f: funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                return f;
            }
        }
        return null;
    }
}
