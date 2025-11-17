public final class Animal {

    private String nome;
    private int idade;


    private TipoAnimal tipo;  //enum
    private EstadoAnimal estado; //enum

    public Animal(String nome, int idade, TipoAnimal tipo, EstadoAnimal estado) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
        this.estado = estado;
    }
     //gets e sets
    public String getNome() { return nome;}
    public void setNome(String nome) {
        this.nome = nome;}


    public int getIdade() {
        return idade;}
    public void setIdade(int idade) {
        this.idade = idade;}

    public TipoAnimal getTipo() {
        return tipo;}
    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;}

    public EstadoAnimal getEstado() {
        return estado;}
    public void setEstado(EstadoAnimal estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", tipo=" + tipo +
                ", estado=" + estado +
                '}';
    }
}

