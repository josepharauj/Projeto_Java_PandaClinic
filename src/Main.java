import Controller.FolhaController;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FolhaController controller = new FolhaController();

        //FUNCIONAMENTO DA FOLHA DE PAGAMENTO
        Funcionario funcionario = new Funcionario("João", 28, "111.111.111-11", 99999);
        Veterinario vet = new Veterinario("Ana", 35, "Cirurgia", "222.222.222-22", 88888);
        Veterinario a = new Veterinario("Carlos", 24,"Exames","123.456.789.00", 222333);

        controller.pagar(funcionario);
        controller.pagar(vet);
        controller.pagar(a);

        controller.mostrarRelatorio();

    }
}
