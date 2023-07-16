package com.ConverterCurrency.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JDialog {
    private JLabel Title;
    private JButton btnGo;
    private JLabel BackGround;
    private JLabel Info1;
    private JPanel MainPanel;
    private JButton btnClose;
    private JButton btnTemp;

    public MainPanel(JFrame parent){
        super(parent);
        setContentPane(MainPanel);
        setTitle("Utility Currency");
        setMinimumSize(new Dimension(560,900));
        setMaximumSize(new Dimension(560,900));
        setModal(true);
        setLocationRelativeTo(parent);




        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }

        });


        btnGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CurrencyPanel(null);

            }

        });


        btnTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TemperaturePanel(null);
            }
        });

        setVisible(true);
    }

}



