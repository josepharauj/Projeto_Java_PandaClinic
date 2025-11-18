package service;

import model.*;

import java.util.ArrayList;

public class ConsultaRegrasService {

    private ArrayList<Consulta> c = new ArrayList<>();

    public ArrayList<Consulta> getConsultas(){
        return c;
    }
    public void adicionarConsulta (Consulta consulta){
        this.c.add(consulta);
    }
    public void removerConsulta (int index){
        this.c.remove(index);
    }
    public void alterarConsulta (int index, Animal a, Veterinario v, String data){
        this.c.set(index, new Consulta(a,v,data));
    }
}
