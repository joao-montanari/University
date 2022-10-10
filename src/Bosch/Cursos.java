package Bosch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cursos extends JFrame implements ActionListener {
    String nome;
    JButton Curso;
    JFrame AdicionarCurso;

    Cursos(String nome){//, JFrame AdicionarCurso){
        this.nome = nome;
        Curso = new JButton();
        //AdicionarCurso = new JFrame();

        Curso.setText(nome);
        Curso.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        Curso.setBackground(new Color(218,218,218));
        Curso.setBounds(125,300,250,25);
        //Curso.addActionListener((ActionListener) AdicionarCurso);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Curso){
            JFrame ola = new JFrame("Ola Mundo");
            ola.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ola.setSize(500,500);
            ola.setVisible(true);
        }
    }

    public void addActionListener(VerCursos verCursos) {
    }
}
