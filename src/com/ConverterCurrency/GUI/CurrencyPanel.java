package com.ConverterCurrency.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;


public class CurrencyPanel extends JDialog {
    private JPanel Currency;
    private JLabel BackGround;
    private JLabel Title;
    private JComboBox cmbCurrency;
    private JTextField txtLocal;
    private JButton btnCalculate;
    private JTextField txtForeign;
    private JButton btnHome;
    private JPanel CurrencyPanel;

    private double change;

    private String value = "";


    public CurrencyPanel(JFrame parent){
        super(parent);
        setContentPane(Currency);
        setTitle("Currency Converter");
        setMinimumSize(new Dimension(560,900));
        setMaximumSize(new Dimension(560,900));
        setModal(true);
        setLocationRelativeTo(parent);



        btnHome.addActionListener(e -> {
            setVisible(false);
            new MainPanel(null);


        });


        cmbCurrency.addActionListener(e -> value = Objects.requireNonNull(cmbCurrency.getSelectedItem()).toString());

        txtLocal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (caracter < '0' || caracter > '9'){
                    e.consume();
                    java.awt.Toolkit.getDefaultToolkit().beep();
                }
            }

        });
        txtForeign.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (caracter < '0' || caracter > '9'){
                    e.consume();
                    java.awt.Toolkit.getDefaultToolkit().beep();
                }
            }
        });


        txtLocal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        txtForeign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (!value.equals("-")){
                    String txtValueLocal = txtLocal.getText();
                    String txtValueForeign = txtForeign.getText();
                    if (!txtValueLocal.equals("")){
                        if (!txtValueForeign.equals("")){
                            txtLocal.setText("");
                            txtForeign.setText("");
                        }else {
                            switch (value){
                                case "Euro" -> change = 4593.29;
                                case "Dollar" -> change = 4087.83;
                                case "Pound" -> change = 5351.38;
                                case "Yen" -> change = 29.47;
                                case "Yuan" -> change = 572.44;
                            }


                            Double calculate = Double.parseDouble(txtValueLocal) / change;
                            txtForeign.setText((String.format("%.4f", calculate)));
                        }
                    } else if (!txtValueForeign.equals("")) {
                        switch (value){
                            case "Euro" -> change = 0.00022;
                            case "Dollar" -> change = 0.00024463;
                            case "Pound" -> change = 0.0001868;
                            case "Yen" -> change = 0.03393;
                            case "Yuan" -> change = 0.001746;
                        }
                        Double calculate = Double.parseDouble(txtValueForeign) / change;
                        txtLocal.setText(String.valueOf(String.format("%.2f", calculate)));
                    }
                }

            }
        });

        setVisible(true);



    }


}
