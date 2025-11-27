package service;

import enums.TipoConsulta;
import model.*;
import java.util.ArrayList;

public class ConsultaService {

    private ArrayList<Consulta> c = new ArrayList<>();

    private AnimalService animalService;
    private VeterinarioService vetService;

    private double totalRecebido = 0;

    public ConsultaService(AnimalService animalService, VeterinarioService vetService) {
        this.animalService = animalService;
        this.vetService = vetService;
    }

    public ArrayList<Consulta> getConsultas(){
        return c;
    }

    public void adicionarConsulta (Consulta consulta){
        this.c.add(consulta);
    }

    public void removerConsulta (int index){
        this.c.remove(index);
    }

    public void alterarConsulta (int index, Animal a, Veterinario v, TipoConsulta tipoc, String data) {
        if (index >= 0 && index < c.size()) {
            c.set(index, new Consulta(a, v, tipoc, data));
        }
    }
    public boolean registrarPagamento(int index) {

        if (index < 0 || index >= c.size()) {
            return false;
        }

        Consulta c = c.get(index);

        if (c.isPaga()) {
            return false; // já paga
        }

        // Marca como paga
        c.isPaga(true);

        // Soma ao total da clínica
        totalRecebido += c.getValor();

        return true;
    }

    // Getter do total recebido
    public double getTotalRecebido() {
        return totalRecebido;
    }



}
