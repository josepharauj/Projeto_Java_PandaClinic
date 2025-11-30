package Controller;

import model.Funcionario;
import model.Veterinario;
import model.interfaces.Folha;
import service.FolhaService;



public class FolhaController {

    private FolhaService folhaService = new FolhaService();


    public void pagar(Funcionario f) {
        System.out.println("\n=== Realizar Pagamentos ===");
        double valor = folhaService.pagar(f);
       System.out.println("Salário do funcionário pago: R$ " + valor);}

    public void pagar(Veterinario v) {
       double valor = folhaService.pagar(v);
       System.out.println("Salário do veterinário pago: R$ " + valor);}

    public void mostrarRelatorio() {
        System.out.println("\n=== Relarório de Pagamentos ===");

        for (Folha f  : folhaService.listarPagamentos()) {
            System.out.println("\n=== Pagamento ===");

            System.out.println("Tipo: " + f.getClass().getSimpleName());
            System.out.println("Salário: R$ " + f.calculaSalario());
            System.out.println("Dados: " + f.toString());
        }

        System.out.println("Total pago: R$ " + folhaService.totalPago());
    }
}

