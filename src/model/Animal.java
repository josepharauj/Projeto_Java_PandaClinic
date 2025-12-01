package model;

import enums.*;

public final class Animal {

    private String nome;
    private int idade;
    private TipoAnimal tipoa;  //enum
    private EstadoAnimal estado; //enum
    private PorteAnimal porte; //enum
    private TipoConsulta tipoc; //enum
    private Tutor tutor;
    private boolean teveConsultaPaga;
    private String doenca;

    public Animal(String nome, int idade, TipoAnimal tipoa, EstadoAnimal estado, PorteAnimal porte, TipoConsulta tipoc) {
        this.nome = nome;
        this.idade = idade;
        this.tipoa = tipoa;
        this.estado = estado;
        this.porte = porte;
        this.tipoc = tipoc;

        this.tutor = null;
        this.doenca = doenca;
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
        return tipoa;}
    public void setTipo(TipoAnimal tipo) {
        this.tipoa = tipo;}

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

    public TipoConsulta getTipoc() { return tipoc;}
    public void setTipoc(TipoConsulta tipoc) {
        this.tipoc = tipoc;
    }

    public Tutor getTutor() {
        return tutor;
    }
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
        if (tutor != null && !tutor.getAnimais().contains(this)) {
            tutor.adicionarAnimal(this);
        }
    }

    public boolean teveConsultaPaga() {
        return teveConsultaPaga;
    }

    public void registrarConsultaPaga() {
        this.teveConsultaPaga = true;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", tipoa=" + tipoa +
                ", estado=" + estado +
                ", porte=" + porte +
                ", tipoc=" + tipoc +
                ", tutor=" + (tutor != null ? tutor.getNome() : "Sem tutor") +
                '}';
    }
}

