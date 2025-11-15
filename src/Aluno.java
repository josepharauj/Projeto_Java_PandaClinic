public final class Aluno extends Pessoa{


    private String nome;
    private int idade;
    private String curso;

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public void quemSou() {
        System.out.println("Sou Jasmin");
    }

    @Override
    public void minhaAtividade() {
        System.out.println("Programadora");
    }
}

