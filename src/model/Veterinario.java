package model;

import model.interfaces.Folha;

public final class Veterinario extends Pessoa implements Folha {

    private String especialidade;
    private double salarioBase;

    public Veterinario(String nome, int idade, String especialidade, String cpf, int telefone) {
        super(nome, idade, cpf, telefone);
        this.especialidade = especialidade;
        this.salarioBase = 4500.0;
    }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade;}

    @Override
    public void quemSou() {
        System.out.println("Médico Veterinário");
    }

    @Override
    public void minhaAtividade() {
        System.out.println("Cuidar de animais.");
    }

    @Override
    public double calculaSalario() {
        return salarioBase;


    }

    @Override
    public String toString() {
        return "Veterinario{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", telefone=" + telefone +
                ", especialidade" + especialidade + '\'' +
                ",salarioBase" + salarioBase +
                '}';
    }

}
