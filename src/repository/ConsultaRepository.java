package repository;

import model.Consulta;
import java.util.ArrayList;
import java.util.List;


public class ConsultaRepository {
    private List<Consulta> consultas = new ArrayList<>();

    public void salvar(Consulta c) {
        consultas.add(c);
    }

    public List<Consulta> listar() {
        return consultas;
    }


}