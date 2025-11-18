package model;

public final class Animal {

    private String nome;
    private int idade;
    private TipoAnimal tipo;  //enum
    private EstadoAnimal estado;
    private PorteAnimal porte; //enum

    public Animal(String nome, int idade, TipoAnimal tipo, EstadoAnimal estado, PorteAnimal porte) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
        this.estado = estado;
        this.porte = porte;
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

    public PorteAnimal getPorte() {
        return porte;
    }

    public void setPorte(PorteAnimal porte) {
        this.porte = porte;
    }

    @Override
    public String toString() {
        return "model.Animal{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", tipo=" + tipo +
                ", estado=" + estado +
                ", porte=" + porte +
                '}';
    }
}

