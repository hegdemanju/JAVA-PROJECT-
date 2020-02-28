/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Manjunath
 */
public class TexteditorFrame extends javax.swing.JFrame {

    /**
     * Creates new form TexteditorFrame
     */
    public TexteditorFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        newbutton = new javax.swing.JButton();
        savebutton = new javax.swing.JButton();
        loadbutton = new javax.swing.JButton();
        quitbutton = new javax.swing.JButton();
        textbutton = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textareabutton = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newbutton.setText("NEW");
        newbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newbuttonActionPerformed(evt);
            }
        });

        savebutton.setText("SAVE");
        savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebuttonActionPerformed(evt);
            }
        });

        loadbutton.setText("LOAD");
        loadbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadbuttonActionPerformed(evt);
            }
        });

        quitbutton.setText("QUIT");
        quitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitbuttonActionPerformed(evt);
            }
        });

        textbutton.setEditable(false);

        textareabutton.setColumns(20);
        textareabutton.setLineWrap(true);
        textareabutton.setRows(5);
        textareabutton.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textareabutton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(newbutton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(savebutton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(loadbutton)
                                                .addGap(13, 13, 13)
                                                .addComponent(quitbutton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(newbutton)
                                        .addComponent(savebutton)
                                        .addComponent(loadbutton)
                                        .addComponent(quitbutton)
                                        .addComponent(textbutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void newbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        textareabutton.setText("");
        textbutton.setText("new file");
    }

    private void quitbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }

    private void savebuttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JFileChooser chooser =new JFileChooser();//provides the functionalies for styling up thr windows
        int chooserValue = chooser.showSaveDialog(this);//retunred value from the user either ok or cancel
        if(chooserValue==JFileChooser.APPROVE_OPTION){
            try {
                PrintWriter fout =new PrintWriter(chooser.getSelectedFile());
                fout.print(textareabutton.getText());
                fout.close();
                textbutton.setText("saved"+chooser.getSelectedFile().getAbsolutePath());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TexteditorFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void loadbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JFileChooser chooser =new JFileChooser();
        int chooserValue = chooser.showSaveDialog(this);
        if(chooserValue==JFileChooser.APPROVE_OPTION){
            try{
                Scanner fin= new Scanner(chooser.getSelectedFile());
                String buffer ="";
                while(fin.hasNext()){
                    buffer+=fin.nextLine() +"\n";
                }
                textareabutton.setText(buffer);
                textbutton.setText("saved"+chooser.getSelectedFile().getAbsolutePath());
                fin.close();


            } catch (FileNotFoundException ex) {

                JOptionPane.showMessageDialog(this, "file not found");
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TexteditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TexteditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TexteditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TexteditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TexteditorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadbutton;
    private javax.swing.JButton newbutton;
    private javax.swing.JButton quitbutton;
    private javax.swing.JButton savebutton;
    private javax.swing.JTextArea textareabutton;
    private javax.swing.JTextField textbutton;
    // End of variables declaration                   
}