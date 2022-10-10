package Bosch;

import Pessoas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class AdicionarAluno extends JFrame implements ActionListener {
    String nome;
    String idade;
    String media;
    String presenca;

    ArrayList<String> cadastrarAluno;
    JLabel Fundo;
    JTable tabela;
    ImageIcon icon;
    JButton Finalizar;
    ImageIcon fundo;

    AdicionarAluno(){
        nome = new String();
        idade = new String();
        media = new String();
        presenca = new String();

        String[] colunas= {"NOME","IDADE:","PRESENCA","MEDIA"};
        Object[][] dados = {
                {"","","",""},
                {"","","",""},
                {"","","",""},
                {"","","",""},
                {"","","",""},
                {"","","",""},
                {"","","",""},
                {"","","",""},
                {"","","",""},
                {"","","",""},
                {"","","",""},
                {"","","",""},
        };
        cadastrarAluno = new ArrayList<>();

        icon = new ImageIcon("img/logo.png");
        fundo = new ImageIcon("img/Adicionar_Aluno.png");

        Fundo = new JLabel();
        Finalizar = new JButton();
        tabela = new JTable(dados, colunas);

        Fundo.setIcon(fundo);
        Fundo.setHorizontalTextPosition(JLabel.CENTER);

        tabela.setBounds(45,180,400,190);

        Finalizar.setBounds(125,400,250,50);
        Finalizar.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        Finalizar.setBackground(new Color(218,218,218));
        Finalizar.setText("FINALIZAR");
        Finalizar.addActionListener(this);

        //this.getContentPane().setBackground(new Color(123,50,250));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Aplicativo de Faculdade");
        this.setSize(500,500);
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.setVisible(true);
        //this.setLayout(null);
        this.add(tabela);
        this.add(Finalizar);
        this.add(Fundo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Finalizar){
            System.out.println("Nome: "+tabela.getValueAt(0,0));
            System.out.println("Idade: "+tabela.getValueAt(0,1));
            System.out.println("Presenca: "+tabela.getValueAt(0,2));
            System.out.println("Media: "+tabela.getValueAt(0,3));

            for (int x = 0; x < 11; x++){
                if (String.valueOf(tabela.getValueAt(x,0)) != "") {
                    nome = String.valueOf(tabela.getValueAt(x, 0));
                    idade = String.valueOf(tabela.getValueAt(x, 1));
                    media = String.valueOf(tabela.getValueAt(x, 2));
                    presenca = String.valueOf(tabela.getValueAt(x, 3));

                    Aluno aluno = new Aluno(nome, idade, media, presenca);
                    aluno.Formatador();
                }

//                int idade = Integer.parseInt(String.valueOf(tabela.getValueAt(x,1)));
//                float media = Float.parseFloat(String.valueOf(tabela.getValueAt(x,2)));
//                int presenca = Integer.parseInt(String.valueOf(tabela.getValueAt(x,3)));
            }

            this.dispose();
            //AdicionarDisciplina adicionardisciplina = new AdicionarDisciplina();
        }
    }
}
