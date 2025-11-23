package service;

import model.Veterinario;
import repository.VeterinarioRepository;
import java.util.Scanner;

public class VeterinarioService {
    private VeterinarioRepository repo = new VeterinarioRepository();
    private Scanner sc = new Scanner(System.in);

    public void cadastrarVeterinario() {
        System.out.println("\n=== Cadastro de Veterinário ===");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(sc.nextLine());

        System.out.print("Especialidade: ");
        String esp = sc.nextLine();

        Veterinario v = new Veterinario(nome, idade, esp);

        repo.salvar(v);

        System.out.println("Veterinário cadastrado com sucesso!");
    }

    public void listarVeterinarios() {
        System.out.println("\n=== Lista de Veterinários ===");
        for (Veterinario v : repo.listar()) {
            System.out.println(v);
        }
    }

    public VeterinarioRepository getRepo() {
        return repo;
    }

    public Veterinario buscarPorNome(String nome) {
        for (Veterinario v : repo.listar()) {
            if (v.getNome().equalsIgnoreCase(nome)) {
                return v;
            }
        }
        return null;
    }



}
