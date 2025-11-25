package service;

import enums.TipoConsulta;
import model.*;
import java.util.ArrayList;

public class ConsultaService {

    private ArrayList<Consulta> c = new ArrayList<>();

    private AnimalService animalService;
    private VeterinarioService vetService;

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
}
