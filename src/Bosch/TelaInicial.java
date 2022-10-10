package Bosch;

import Pessoas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.border.Border;

public class TelaInicial extends JFrame implements ActionListener {
    JButton AddCurso;
    JButton VerCurso;
    JLabel Fundo;

    TelaInicial(){
        ImageIcon fundo = new ImageIcon("img/Home.png");
        ImageIcon icon = new ImageIcon("img/logo.png");
        AddCurso = new JButton();
        VerCurso = new JButton();
        Fundo = new JLabel();

        AddCurso.setText("ADICIONAR CURSOS");
        AddCurso.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        AddCurso.setBackground(new Color(218,218,218));
        AddCurso.setBounds(125,185,250,100);
        AddCurso.addActionListener(this);

        VerCurso.setText("VER CURSOS");
        VerCurso.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        VerCurso.setBackground(new Color(218,218,218));
        VerCurso.setBounds(125,315,250,100);
        VerCurso.addActionListener(this);

        Fundo.setIcon(fundo);
        Fundo.setHorizontalTextPosition(JLabel.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Aplicativo de Faculdade");
        this.setSize(500,500);
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.setVisible(true);
        this.add(AddCurso);
        this.add(VerCurso);
        this.add(Fundo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==AddCurso){
            this.dispose();
            AdicionarCurso adcionarcurso = new AdicionarCurso();
        } else if (e.getSource()==VerCurso){
            try {
                VerCursos vercursos = new VerCursos();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
