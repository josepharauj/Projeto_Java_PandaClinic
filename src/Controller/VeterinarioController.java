package Controller;

import java.util.Scanner;
import model.Veterinario;
import service.VeterinarioService;

public class VeterinarioController {

    private VeterinarioService vetService = new VeterinarioService();
    private Scanner sc = new Scanner(System.in);

    public void cadastrarVeterinario() {
        vetService.cadastrarVeterinario();
    }

    public void listarVeterinarios() {
        vetService.listarVeterinarios();
    }

    public void buscarPorNome() {
        System.out.println("Digite o nome do veterinário para buscar:");
        String nome = sc.nextLine();

        Veterinario v = vetService.buscarPorNome(nome);

        if (v != null) {
            System.out.println("Veterinário encontrado:");
            System.out.println(v);
        } else {
            System.out.println("Nenhum veterinário encontrado com esse nome.");
        }
    }
}
