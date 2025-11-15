import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pessoa p  = new Professor();
        Pessoa a = new Aluno();

        ((Professor) p).setCargo(CARGO.Professor);
        System.out.println(((Professor) p).getCargo());
        System.out.println("informação do professor:");
        System.out.println(p);


        System.out.println("Informação do Aluno:");
        System.out.println(a);
    }
}
