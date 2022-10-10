package Bosch;

import Pessoas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarMonitor extends JFrame implements ActionListener {
    String nome;
    String idade;

    JTextField nomeMonitor;
    JTextField idadeMonitor;

    JButton Finalizar;

    JLabel Fundo;

    ImageIcon icon;
    ImageIcon fundo;

    AdicionarMonitor(){
        nome = new String();
        idade = new String();

        icon = new ImageIcon("img/logo.png");
        fundo = new ImageIcon("img/Adicionar_Monitor.png");

        nomeMonitor = new JTextField();
        idadeMonitor = new JTextField();
        Finalizar = new JButton();
        Fundo = new JLabel();

        Fundo.setIcon(fundo);
        Fundo.setHorizontalTextPosition(JLabel.CENTER);

        nomeMonitor.setBounds(125,200,250,20);

        idadeMonitor.setBounds(125,280,250,20);

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
        this.add(nomeMonitor);
        this.add(idadeMonitor);
        this.add(Finalizar);
        this.add(Fundo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Finalizar){
            nome = String.valueOf(nomeMonitor.getText());
            idade = String.valueOf(idadeMonitor.getText());

            Monitor monitor = new Monitor(nome, idade);
            monitor.Formatador();

            this.dispose();

            //AdicionarDisciplina adicionardisciplina = new AdicionarDisciplina();
        }
    }
}
