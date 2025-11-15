public final class Professor extends Pessoa {
    public CARGO cargo;
    private int matricula;

    public CARGO getCargo() {
        return cargo;
    }

    public void setCargo(CARGO cargo) {
        this.cargo = cargo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public void minhaAtividade() {
        System.out.println("Ensinar");
    }




    @Override
    public void quemSou() {
        System.out.println("Sou rigído");
    }
    @Override
    public String toString() {
        return "Professor{" + "cargo=" + cargo + '}';
    }


}
