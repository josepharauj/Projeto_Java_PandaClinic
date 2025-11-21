package model;

import model.interfaces.Folha;

public final class Veterinario extends Pessoa implements Folha {

    private String especialidade;

    public Veterinario(String nome, int idade, String especialidade) {
        super(nome, idade);
        this.especialidade = especialidade;
    }

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
    public void minhaAtividade() {
        System.out.println("Cuidar de animais.");
    }

    @Override
    public void calculaSalario() {

    }
    @Override
    public String toString() {
        return "Veterinario{" +
                "especialidade='" + especialidade + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

}
