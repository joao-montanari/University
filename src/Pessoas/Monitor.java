package Pessoas;

public class Monitor extends Discentes{
    public static String cadastroMonitor;
    float bolsa = 2000;

    public Monitor(String nome, String idade){
        super(nome, idade);

    }

    public void Formatador(){
        cadastroMonitor = nome + "-" + idade + "-" + bolsa;
        System.out.println(cadastroMonitor);
    }
}
