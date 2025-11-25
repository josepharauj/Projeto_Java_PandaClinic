package model;

public abstract class Pessoa {
    protected String nome;
    protected int idade;
    protected String cpf;
    protected int telefone;

    public Pessoa(String nome, int idade, String cpf, int telefone){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    public abstract void quemSou();
    public abstract void minhaAtividade();


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() { return cpf;}
    public void setCpf(String cpf) { this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;}
    public void setTelefone(int telefone) {
        this.telefone = telefone;}

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf=" + cpf +
                ", telefone=" + telefone +
                '}';
    }
}
