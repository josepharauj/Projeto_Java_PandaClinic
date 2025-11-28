package Controller;

import model.Funcionario;
import model.Veterinario;
import service.FolhaService;

import java.util.Scanner;

public class FolhaController {

    private FolhaService folhaService = new FolhaService();
    private Scanner sc = new Scanner(System.in);

    public void pagarFuncionario(Funcionario f) {
        double valor = folhaService.pagar(f);
        System.out.println("Salário do funcionário pago: R$ " + valor);
    }

    public void pagarVeterinario(Veterinario v) {
        double valor = folhaService.pagar(v);
        System.out.println("Salário do veterinário pago: R$ " + valor);
    }

    public void mostrarRelatorio() {
        System.out.println("\n=== Pagamentos Realizados ===");
        for (double p : folhaService.listarPagamentos()) {
            System.out.println("Pagamento: R$ " + p);
        }

        System.out.println("Total pago: R$ " + folhaService.totalPago());
    }
}

