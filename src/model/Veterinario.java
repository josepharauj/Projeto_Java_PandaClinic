package model;

import model.interfaces.Folha;

public final class Veterinario extends Pessoa implements Folha {
    private String especialidade;

    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void quemSou() {
        System.out.println("Médico Veterinário");
    }

    @Override
    public String toString() {
        return "model.Veterinario{" +
                "especialidade='" + especialidade + '\'' +
                '}';
    }

    @Override
    public void minhaAtividade() {
        System.out.println("Cuidar de animais.");
    }

    @Override
    public void calculaSalario() {

    }
}
