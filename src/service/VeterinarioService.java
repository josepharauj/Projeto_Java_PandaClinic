package service;

import model.Veterinario;
import repository.VeterinarioRepository;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class VeterinarioService {

    private List<Veterinario> veterinarios = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    //public void adicionarVeterinario(Veterinario v) {
      //  repo.salvar(v); // ou adicionar na lista interna}

    public void cadastrarVeterinario() {
        System.out.println("\n=== Cadastro de Veterinário ===");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(sc.nextLine());

        System.out.print("Especialidade: ");
        String especialidade = sc.nextLine();

        System.out.println("CPF: ");
        String cpf = sc.nextLine();

        System.out.println("Telefone:");
        int telefone = sc.nextInt();

        Veterinario v = new Veterinario(nome, idade, especialidade, cpf, telefone);
        veterinarios.add(v);

        System.out.println("Veterinário cadastrado com sucesso!");
    }

    public void listarVeterinarios() {
        for (Veterinario v : veterinarios) {
            System.out.println(v.getNome() + " (" + v.getEspecialidade() + ")");
        }
    }

    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public void adicionarVeterinario(Veterinario v) {
        veterinarios.add(v);
    }

    public Veterinario buscarPorNome(String nome) {
        for (Veterinario v : veterinarios) {
            if (v.getNome().equalsIgnoreCase(nome)) {
                return v;
            }
        }
        return null;
    }



}
