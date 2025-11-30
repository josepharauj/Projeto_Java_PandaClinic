package model;

import model.interfaces.Folha;

public class Funcionario extends Pessoa implements Folha {

    private double salarioBase;

    public Funcionario(String nome, int idade, String cpf, int telefone) {
        super(nome, idade, cpf, telefone);
        this.salarioBase = 1500.0;
    }

    @Override
    public void quemSou() {
        System.out.println("Sou um atendente da clínica.");
    }

    @Override
    public void minhaAtividade() {
        System.out.println("Responsável por apoiar o funcionamento da clínica.");
    }

    @Override
    public double calculaSalario() {

        return this.salarioBase;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "salarioBase=" + salarioBase +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}

