/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.reportsales1;

/**
 *
 * @author Student
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductGUI extends JFrame implements ActionListener {
    //menu item variables declaration JMenuItem itemExit , itemProcess, item Clear;
    JTextField txtCustomerName, txtPrice;
    JComboBox<String> cmbProduct;
    JButton btnProcess;
    JMenuItem itemExit, itemProcess, itemClear;

    public ProductGUI() {
        setTitle("Product App");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(30, 30, 120, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(160, 30, 180, 25);
        add(txtCustomerName);

        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(30, 70, 120, 25);
        add(lblProduct);

        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(160, 70, 180, 25);
        add(cmbProduct);

        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(30, 110, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(160, 110, 180, 25);
        add(txtPrice);

        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(160, 160, 180, 30);
        btnProcess.addActionListener(this);
        add(btnProcess);

        // Menu Bar Setup
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(this);
        menuFile.add(itemExit);

        JMenu menuTools = new JMenu("Tools");
        itemProcess = new JMenuItem("Process");
        itemProcess.addActionListener(this);
        itemClear = new JMenuItem("Clear");
        itemClear.addActionListener(this);
        menuTools.add(itemProcess);
        menuTools.add(itemClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnProcess || source == itemProcess) {
            processSales();
        } else if (source == itemClear) {
            txtCustomerName.setText("");
            txtPrice.setText("");
            cmbProduct.setSelectedIndex(0);
        } else if (source == itemExit) {
            System.exit(0);
        }
    }

    private void processSales() {
        try {
            String customer = txtCustomerName.getText();
            String product = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            String report = "Customer Name: " + customer + "\n" +
                            "Product: " + product + "\n" +
                            "VAT: R " + vat + "\n" +
                            "COMMISSION: R " + commission + "\n" +
                            "TOTAL: R " + total;

            JOptionPane.showMessageDialog(this, report, "Message", JOptionPane.INFORMATION_MESSAGE);

            PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true));
            writer.println("DATA LOG");
            writer.println("****************************************");
            writer.println(report);
            writer.println("****************************************");
            writer.close();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new ProductGUI();
    }
}


    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

