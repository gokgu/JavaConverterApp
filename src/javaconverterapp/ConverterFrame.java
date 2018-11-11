package javaconverterapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Dosya yolu verilen dosyayı string olarak okuyup
 * Xml'den Json'a yada Json'dan Xml'e dönüştürmeyi sağlar.
 * @author Gurel
 */
public class ConverterFrame extends javax.swing.JFrame
{
    public Timer t;
    public ActionListener al;

    public ConverterFrame()
    {
        initComponents();
        setLocationRelativeTo(null);       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        JTextFieldSource = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JTextFieldTarget = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Source File");

        jButton1.setText("Select File");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                SourceActionPerformed(evt);
            }
        });

        jLabel2.setText("Target File");

        jButton2.setText("Select File");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                TargetActionPerformed(evt);
            }
        });

        jButton3.setText("Convert");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ConvertActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CancelActionPerformed(evt);
            }
        });

        jProgressBar1.setOpaque(true);
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JTextFieldTarget, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                    .addComponent(JTextFieldSource, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 207, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextFieldSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextFieldTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(27, 27, 27)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SourceActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_SourceActionPerformed
    {//GEN-HEADEREND:event_SourceActionPerformed
        JFileChooser fc = new JFileChooser();
        int index = fc.showOpenDialog(rootPane);
        if(index == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Hatalı İşlem Yaptınız.", "HATA", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        else if(index == 0) JTextFieldSource.setText(fc.getSelectedFile().getAbsolutePath());
        String[] tps = JTextFieldSource.getText().split("/");
        JTextFieldTarget.setText("");
        for (int i = 0; i < tps.length-1; i++)
        {
            JTextFieldTarget.setText(JTextFieldTarget.getText()+tps[i]+"/");           
        }
    }//GEN-LAST:event_SourceActionPerformed

    private void TargetActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_TargetActionPerformed
    {//GEN-HEADEREND:event_TargetActionPerformed
        JFileChooser fc;
        if(!JTextFieldTarget.getText().equals(""))
            fc=new JFileChooser(JTextFieldTarget.getText());
        else
            fc=new JFileChooser();
        int ndx=fc.showSaveDialog(rootPane);
        if(ndx==-1) 
        {
            JOptionPane.showMessageDialog(rootPane, "Hatalı İşlem Yaptınız.", "HATA", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        else if (ndx==0)
            JTextFieldTarget.setText(fc.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_TargetActionPerformed

    private void ConvertActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ConvertActionPerformed
    {//GEN-HEADEREND:event_ConvertActionPerformed
        al = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (jProgressBar1.getValue() < 100)
                {
                    jProgressBar1.setValue(jProgressBar1.getValue()+5);
                    if(jProgressBar1.getValue() == 100 )
                    convertToFile();     
                }                    
                else 
                    t.stop();               
            }
        };
        t = new Timer(200,al);    
        t.start();    
    }//GEN-LAST:event_ConvertActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_CancelActionPerformed
    {//GEN-HEADEREND:event_CancelActionPerformed
        dispose();
        new SelectFrame().setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_CancelActionPerformed
    
    public void convertToFile()
    {
        //Overwrite
    }
    
    /**
     * Kaynak dosyanın yolunu string olarak döndürmektedir.
     * @return kaynak dosyanın yolunu döndürür.
     */
    public String getSourcePath()
    {
        String url=JTextFieldSource.getText();
        return url;
    }
    
    /**
     * Hedef dosyanın yolunu string olarak döndürmektedir.
     * @return hedef dosyanın yolunu döndürür.
     */
    public String getTargetPath()
    {
        String url=JTextFieldTarget.getText();
        return url;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ConverterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ConverterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ConverterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ConverterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ConverterFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldSource;
    private javax.swing.JTextField JTextFieldTarget;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
