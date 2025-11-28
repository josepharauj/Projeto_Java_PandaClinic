

package service;

import model.interfaces.Folha;
import java.util.ArrayList;
import java.util.List;

public class FolhaService {

    private List<Double> pagamentos = new ArrayList<>();

    // recebe qualquer funcionário OU veterinário
    public double pagar(Folha f) {
        double salario = f.calculaSalario();
        pagamentos.add(salario);
        return salario;
    }

    public List<Double> listarPagamentos() {
        return pagamentos;
    }

    public double totalPago() {
        double total = 0;
        for (Double p : pagamentos) {
            total += p;
        }
        return total;
    }
}
