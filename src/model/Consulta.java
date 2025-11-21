package model;

import enums.TipoConsulta;

public class Consulta {
    private Animal a;
    private Veterinario v;
    private String data;

    public Consulta(Animal a, Veterinario v, String data) {
        this.a = a;
        this.v = v;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "a=" + a +
                ", v=" + v +
                ", data='" + data + '\'' +
                '}';
    }
}
