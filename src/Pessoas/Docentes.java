package Pessoas;

public class Docentes extends Membro{
    float salario;
    String cargo;
    public static String cadastroDocente;

    public Docentes(String nome, String cargo, float salario){
        super(nome);
        this.salario = salario;
        this.cargo = cargo;
    }

    public void Formatador(){
        cadastroDocente = nome + "-" + salario + "-" + cargo;
        System.out.println(cadastroDocente);
    }
}
