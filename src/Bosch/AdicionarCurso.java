package Bosch;

import Pessoas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class AdicionarCurso extends JFrame implements ActionListener {
    ArrayList<String> links;
    Path linkCaminho = Paths.get("text/links.txt");
    String nome;
    JButton addDisciplina;
    JButton Finalizar;

    JLabel Fundo;

    JTextField nomeCurso;

    ImageIcon icon;
    ImageIcon fundo;

    AdicionarCurso(){

        links = new ArrayList<>();
        icon = new ImageIcon("img/logo.png");
        fundo = new ImageIcon("img/adicionar_Curso.png");
        addDisciplina = new JButton();
        nomeCurso = new JTextField();
        Finalizar = new JButton();
        Fundo = new JLabel();

        nomeCurso.setBounds(125,200,250,20);

        Finalizar.setText("FINALIZAR");
        Finalizar.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        Finalizar.setBackground(new Color(218,218,218));
        Finalizar.setBounds(125,400,250,50);
        Finalizar.addActionListener(this);

        addDisciplina.setText("ADICIONAR DISCIPLINA");
        addDisciplina.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        addDisciplina.setBackground(new Color(218,218,218));
        addDisciplina.setBounds(125,233,250,50);
        addDisciplina.addActionListener(this);

        Fundo.setIcon(fundo);
        Fundo.setHorizontalTextPosition(JLabel.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Aplicativo de Faculdade");
        this.setSize(500,500);
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.setVisible(true);
        //this.setLayout(null);
        this.add(addDisciplina);
        this.add(nomeCurso);
        this.add(Finalizar);
        this.add(Fundo);

    }

    public void Formatar() throws IOException {

        String rota = "text/" +nome+ ".txt";
        Path caminho = Paths.get("text/" +nome+ ".txt");
        AdicionarDisciplina.cadastroDisciplina.add(nome);
        Files.write(caminho,AdicionarDisciplina.cadastroDisciplina, StandardCharsets.UTF_8);

        links.add(rota);
        Files.write(linkCaminho, links, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Finalizar){
            System.out.println("NOME DO CURSO: " + nomeCurso.getText());

            nome = String.valueOf(nomeCurso.getText());

            try {
                Formatar();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            this.dispose();

            TelaInicial TelaInicial = new TelaInicial();

        } else if(e.getSource()==addDisciplina){

            this.dispose();
            //this.setEnabled(false);

            AdicionarDisciplina adicionardisciplina = new AdicionarDisciplina();
        }
    }
}
