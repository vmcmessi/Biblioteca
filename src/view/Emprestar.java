package view;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Exemplar;
import model.Usuario;

/**
 *
 * @author Victor
 */
public class Emprestar extends javax.swing.JDialog {

    /**
     * Creates new form fazerEmprestimo
     * @param parent
     * @param modal
     */
    public Emprestar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        
        combObras.removeAllItems();
        combUsuarios.removeAllItems();
        
        combObras.addItem("Selecione um exemplar");
        combUsuarios.addItem("Selecione o usuário");
        
        for (Exemplar obra : Main.getInstance().getBiblioteca().listarObrasNaoDevolvidas()) {
            combObras.addItem(obra.getNome());
        }
        for (Usuario usu : Main.getInstance().getBiblioteca().usuarios()) {
            combUsuarios.addItem(usu.getNome());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescricaoTela = new javax.swing.JLabel();
        combObras = new javax.swing.JComboBox();
        combUsuarios = new javax.swing.JComboBox();
        btnCadastrar = new javax.swing.JButton();
        lblObra = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblDescricaoTela.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblDescricaoTela.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDescricaoTela.setText("Fazer Emprestimo");

        combObras.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        combObras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combObrasActionPerformed(evt);
            }
        });

        combUsuarios.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        btnCadastrar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnCadastrar.setText("Realizar emprestimo");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblObra.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblObra.setText("Exemplar");

        lblUsuario.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblUsuario.setText("Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario)
                            .addComponent(lblObra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combObras, 0, 274, Short.MAX_VALUE)
                            .addComponent(combUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblDescricaoTela)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblDescricaoTela, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combObras)
                    .addComponent(lblObra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        LocalDate data = LocalDate.now();
        int usuarioSelecionado = combUsuarios.getSelectedIndex();
        int obraSelecionada = combObras.getSelectedIndex();
        
        if((usuarioSelecionado==0) || (obraSelecionada==0))
        {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
        } else {
            Usuario usuario = Main.getInstance().getBiblioteca().usuarios().get(usuarioSelecionado-1);
            Exemplar obra  =  Main.getInstance().getBiblioteca().listarObrasNaoDevolvidas().get(obraSelecionada-1);

            try {
                Main.getInstance().getBiblioteca().realizarEmprestimo(obra, usuario, data);
                JOptionPane.showMessageDialog(null, "Emprestimo realizado");

            } catch (Exception ex) {
                Logger.getLogger(Emprestar.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "O usuário atingiu o limite de emprestimos");

            }
        }
        
        combObras.removeAllItems();
        combUsuarios.removeAllItems();
        
        combObras.addItem("Selecione um exemplar");
        combUsuarios.addItem("Selecione o usuário");
        
        for (Exemplar obra : Main.getInstance().getBiblioteca().listarObrasNaoDevolvidas()) {
            combObras.addItem(obra.getNome());
        }
        for (Usuario usu : Main.getInstance().getBiblioteca().usuarios()) {
            combUsuarios.addItem(usu.getNome());
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void combObrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combObrasActionPerformed
        
    }//GEN-LAST:event_combObrasActionPerformed

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
            java.util.logging.Logger.getLogger(Emprestar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emprestar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emprestar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emprestar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Emprestar dialog = new Emprestar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox combObras;
    private javax.swing.JComboBox combUsuarios;
    private javax.swing.JLabel lblDescricaoTela;
    private javax.swing.JLabel lblObra;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}