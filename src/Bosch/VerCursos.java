package Bosch;

import Pessoas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.Border;
import javax.swing.Box.*;

public class VerCursos extends JFrame{
    ArrayList<ArrayList<ArrayList<String[]>>> TodosCursos;
    ArrayList<ArrayList<String[]>> Registros;
    ArrayList<String> Pessoa;

    ArrayList<String> studant;
    ArrayList<String> mediaAluno;

    List<String> curso;
    List<String> caminhos;
    Path caminho = Paths.get("text/links.txt");

    //ArrayList<String> dadosMembro;

    VerCursos() throws IOException {
        ImageIcon icon = new ImageIcon("img/logo.png");
        String dados[] = new String[6];
        TodosCursos = new ArrayList<>();
        mediaAluno = new ArrayList<>();
        Registros = new ArrayList<>();
        Pessoa = new ArrayList<>();
        studant = new ArrayList<>();
        caminhos = Files.readAllLines(caminho);
        float mediaClasse = 0;

        for (String link: caminhos) {
            Path linkCurso = Paths.get(link);
            curso = Files.readAllLines(linkCurso);
            for (String membro : curso) {
                dados = membro.split("-");
                for (String x : dados) {
                    Pessoa.add(x);
                }
                Registros.add((ArrayList<String[]>) Pessoa.clone());
                Pessoa.clear();
            }
            TodosCursos.add((ArrayList<ArrayList<String[]>>) Registros.clone());
            Registros.clear();
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(16,0));
        this.setTitle("Aplicativo de Faculdade");
        this.setSize(500,500);
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.setVisible(true);

        for (ArrayList<ArrayList<String[]>> membro : TodosCursos) {
            int posNomeCurso = membro.size() -1;
            String nomeCurso = String.valueOf(membro.get(posNomeCurso));
            String Docente = String.valueOf(membro.get(0));
            String Monitor = String.valueOf(membro.get(1));

            System.out.println("Curso: "+nomeCurso);
            System.out.println("Docente: "+Docente);
            System.out.println("Monitor: "+Monitor);

            for (int i = 2; i < membro.size() - 1; i++){
                System.out.println("Aluno: "+membro.get(i));
                studant = (ArrayList<String>) membro.get(i);
                Aluno aluno = new Aluno(
                        studant.get(0),
                        studant.get(1),
                        studant.get(2),
                        studant.get(3)
                );
                mediaAluno.add(aluno.getMedia());
                mediaClasse = aluno.MediaClasse(mediaAluno);
            }
            System.out.println("Media de cada aluno: "+mediaAluno);
            System.out.println("media de notas da sala: " + mediaClasse);

            mediaAluno.clear();
            System.out.println("============================================");
        }
    }
}
