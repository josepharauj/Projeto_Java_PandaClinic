package model;

import enums.*;

public class Consulta {
    private Animal a;
    private Veterinario v;
    private TipoConsulta tipoc;
    private String data;
    private boolean paga;
    private double valor;


    public Consulta(Animal a, Veterinario v,TipoConsulta tipoc, String data) {
        this.a = a;
        this.v = v;
        this.tipoc = tipoc;
        this.data = data;
        this.paga = false;
        this.valor = calcularValor();
    }

    private double calcularValor() {
        double base = 0;

        switch (tipoc) {
            case ROTINA:
                base = 80;
                break;
            case VACINACAO:
                base = 100;
                break;
            case EMERGENCIA:
                base = 180;
                break;
            case RETORNO:
                base = 0;
                break;
            case CIRURGIA:
                base = 350;
                break;
        }

        switch (a.getPorte()) {
            case PEQUENO:
                base += 15;
                break;
            case MEDIO:
                base += 30;
                break;
            case GRANDE:
                base += 40;
                break;
        }

        return base;
    }
    public void registrarPagamento() {
        this.paga = true;
    }

    public double getValor() {
        return valor;
    }

    public boolean isPaga() {
        return paga;
    }

    public Animal getAnimal() {
        return a;
    }



    @Override
    public String toString() {
        return "Consulta{" +
                "a=" + a.getNome() +
                ", v=" + v.getNome() +
                ", tipoc=" + tipoc +
                ", data='" + data + '\'' +
                ", paga= " + (paga ? "SIM" : "NÂO") +
                ", valor=" + valor +
                '}';
    }
}
