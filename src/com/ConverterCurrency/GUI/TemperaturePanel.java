package com.ConverterCurrency.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TemperaturePanel extends JDialog {
    private JPanel Temperature;
    private JLabel BackGround;
    private JLabel Title;
    private JTextField txtFahrenheit;
    private JButton btnHome;
    private JTextField txtCelsius;
    private JButton btnCalculate;
    private JPanel TempPanel;




    public TemperaturePanel(JFrame parent){
        super(parent);
        setContentPane(Temperature);
        setTitle("Temperature Converter");
        setMinimumSize(new Dimension(560,900));
        setMaximumSize(new Dimension(560,900));
        setModal(true);
        setLocationRelativeTo(parent);



        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MainPanel(null);

            }
        });

        txtFahrenheit.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (caracter < '0' || caracter > '9'){
                    e.consume();
                    java.awt.Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        txtCelsius.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (caracter < '0' || caracter > '9'){
                    e.consume();
                    java.awt.Toolkit.getDefaultToolkit().beep();
                }
            }
        });


        txtFahrenheit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        txtCelsius.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String txtValueFahrenheit = txtFahrenheit.getText();
                String txtValueCelsius = txtCelsius.getText();
                if (!txtValueFahrenheit.equals("")){
                    if (!txtValueCelsius.equals("")){
                        txtFahrenheit.setText("");
                        txtCelsius.setText("");
                    }else {
                        txtCelsius.setText(String.format("%.1f", ((Double.parseDouble(txtValueFahrenheit) - 32 )/ 1.8)));
                    }
                }else if (!txtValueCelsius.equals("")){
                    txtFahrenheit.setText(String.format("%.1f", ((Double.parseDouble(txtValueCelsius) * 1.8) + 32 )));
                }
            }
        });

        setVisible(true);

    }

}
