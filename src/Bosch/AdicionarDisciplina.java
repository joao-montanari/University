package Bosch;

import Pessoas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdicionarDisciplina extends JFrame implements ActionListener {
    public static ArrayList<String> cadastroDisciplina;
    JLabel Fundo;
    JButton addAluno;
    JButton addMonitor;
    JButton addDocente;
    JButton Finalizar;

    JTextField nomeDisciplina;

    ImageIcon icon;
    ImageIcon fundo;

    AdicionarDisciplina(){
        cadastroDisciplina = new ArrayList<>();

        fundo = new ImageIcon("img/Adicionar_Disciplina.png");
        icon = new ImageIcon("img/logo.png");

        addAluno = new JButton();
        addMonitor = new JButton();
        addDocente = new JButton();
        Finalizar = new JButton();

        nomeDisciplina = new JTextField();

        Fundo = new JLabel();

        nomeDisciplina.setBounds(125,170,250,20);

        Finalizar.setBounds(125,400,250,50);
        Finalizar.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        Finalizar.setBackground(new Color(218,218,218));
        Finalizar.setText("FINALIZAR");
        Finalizar.addActionListener(this);

        addAluno.setBounds(125,198,250,50);
        addAluno.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        addAluno.setBackground(new Color(218,218,218));
        addAluno.setText("Adicionar alunos");
        addAluno.addActionListener(this);

        addMonitor.setBounds(125,260,250,50);
        addMonitor.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        addMonitor.setBackground(new Color(218,218,218));
        addMonitor.setText("Adicionar monitor");
        addMonitor.addActionListener(this);

        addDocente.setBounds(125,320,250,50);
        addDocente.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        addDocente.setBackground(new Color(218,218,218));
        addDocente.setText("Adicionar docente");
        addDocente.addActionListener(this);

        Fundo.setIcon(fundo);
        Fundo.setHorizontalTextPosition(JLabel.CENTER);

        //this.getContentPane().setBackground(new Color(123,50,250));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Aplicativo de Faculdade");
        this.setSize(500,500);
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.setVisible(true);
        //this.setLayout(null);
        this.add(addAluno);
        this.add(addMonitor);
        this.add(addDocente);
        this.add(nomeDisciplina);
        this.add(Finalizar);
        this.add(Fundo);

    }

    public void Formatar(){
        cadastroDisciplina.add(Docentes.cadastroDocente);
        cadastroDisciplina.add(Monitor.cadastroMonitor);
        for (String aluno : Aluno.cadastroAlunos) {
            cadastroDisciplina.add(aluno);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Finalizar){
            System.out.println("NOME DO DISCIPLINA: " + nomeDisciplina.getText());

            Formatar();

            this.dispose();

            AdicionarCurso adcionarcurso = new AdicionarCurso();

        } else if(e.getSource()==addAluno){
            addAluno.setEnabled(false);
            //this.dispose();
            AdicionarAluno adicionaraluno = new AdicionarAluno();
        } else if(e.getSource()==addDocente){
            addDocente.setEnabled(false);
            //this.dispose();
            AdicionarDocente adicionardocente = new AdicionarDocente();
        } else if (e.getSource()==addMonitor){
            addMonitor.setEnabled(false);
            //this.dispose();
            AdicionarMonitor adicionarmonitor = new AdicionarMonitor();
        }
    }
}
