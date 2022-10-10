package Bosch;

import Pessoas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarDocente extends JFrame implements ActionListener {
    float salario;
    String nome;
    String cargo;

    JLabel Fundo;

    JTextField nomeDocente;

    JComboBox cargoDocente;
    JButton Finalizar;

    ImageIcon icon;
    ImageIcon fundo;

    AdicionarDocente(){
        nome = new String();
        cargo = new String();

        String[] Cargos = {"Professor", "Coordenador", "Diretor"};

        icon = new ImageIcon("img/logo.png");
        fundo = new ImageIcon("img/Adicionar_Discente.png");

        nomeDocente = new JTextField();
        cargoDocente = new JComboBox(Cargos);
        Finalizar = new JButton();
        Fundo = new JLabel();

        Fundo.setIcon(fundo);
        Fundo.setHorizontalTextPosition(JLabel.CENTER);

        nomeDocente.setBounds(125,200,250,20);

        cargoDocente.setBounds(125,270,250,20);

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
        this.add(nomeDocente);
        this.add(cargoDocente);
        this.add(Finalizar);
        this.add(Fundo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Finalizar){
            System.out.println("Nome: "+nomeDocente.getText());
            System.out.println("Cargo: "+cargoDocente.getSelectedItem());

            nome = String.valueOf(nomeDocente.getText());
            cargo = String.valueOf(cargoDocente.getSelectedItem());
            if (cargo == "Professor"){
                salario = 7000;
            } else if (cargo == "Coordenador"){
                salario = 11000;
            } else if (cargo == "Diretor") {
                salario = 16000;
            }

            Docentes docentes = new Docentes(nome, cargo, salario);
            docentes.Formatador();

            this.dispose();
            //AdicionarDisciplina adicionardisciplina = new AdicionarDisciplina();
        }
    }
}
