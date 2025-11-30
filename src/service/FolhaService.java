

package service;

import model.interfaces.Folha;
import java.util.ArrayList;
import java.util.List;

public class FolhaService {

    private List<Folha> pagamentos = new ArrayList<>();

    // recebe qualquer funcionário OU veterinário
    public double pagar(Folha f) {
        double salario = f.calculaSalario();
        pagamentos.add(f);
        return salario;
    }

    public List<Folha> listarPagamentos() {
        return pagamentos;
    }

    public double totalPago() {
        double total = 0;
        for (Folha f : pagamentos) {
            total += f.calculaSalario();
        }
        return total;
    }
}
