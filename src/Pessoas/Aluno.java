package Pessoas;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.io.IOException;

public class Aluno extends Discentes{
    public static ArrayList<String> cadastroAlunos = new ArrayList<>();
    Path caminho = Paths.get("text/registro.txt");
    String media;
    String presenca;
    String linha;
    float MaiorMedia = 0;

    public Aluno(String nome, String idade, String media, String presenca){
        super(nome, idade);
        this.media = media;
        this.presenca = presenca;
    }

    public void Formatador(){
        linha = nome + "-" + idade + "-" + media + "-" + presenca;
        cadastroAlunos.add(linha);
        System.out.println(cadastroAlunos);
    }

    public String getMedia() {
        return media;
    }

    public float MediaClasse(ArrayList<String> mediaAluno){
        float somatoriaMedia = 0;
        float cont = 0;

        for (String media : mediaAluno) {
            cont = cont + 1;
            float mediaFloat = Float.valueOf(media);
            somatoriaMedia = somatoriaMedia + mediaFloat;
        }
        return somatoriaMedia / cont;
    }
}
