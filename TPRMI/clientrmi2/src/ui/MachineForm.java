/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class MachineForm extends javax.swing.JInternalFrame {
   IDao<Machine> dao= null;
   IDao<Salle> daoo= null;
    DefaultTableModel model=null;
    int id=-1;
    Machine m;   
    Salle s ;

    
    /**
     * Creates new form MachineForm
     */
    public MachineForm() {
       try {
           initComponents();
           model = (DefaultTableModel) machineList.getModel();
           dao= (IDao<Machine>) Naming.lookup("rmi://localhost:1099/dao");
           m=new Machine();
           s = new Salle();
           load();
       } catch (NotBoundException ex) {
           Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
       } catch (MalformedURLException ex) {
           Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
       } catch (RemoteException ex) {
           Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
      
    void loadServices() {
       try {
           for (Machine m : dao.findAll()) {
               listesalle.addItem(m);
           }
       } catch (RemoteException ex) {
           Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public void load() {
       try {
           model.setRowCount(0);
           for (Machine m : dao.findAll()) {
               model.addRow(new Object[]{
                   m.getId(),
                   m.getMarque(),
                   m.getPrix(),
                   m.getRef(),});
           }
       } catch (RemoteException ex) {
           Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRef = new javax.swing.JTextField();
        txtMarque = new javax.swing.JTextField();
        txtPrix = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        listesalle = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        bnAdd = new javax.swing.JButton();
        bnDelete = new javax.swing.JButton();
        bnUpdate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        machineList = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gmachine");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("information machine "));

        jLabel1.setText("Réf:");

        jLabel2.setText("Marque:");

        jLabel3.setText("Prix:");

        txtRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRefActionPerformed(evt);
            }
        });

        txtPrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrixActionPerformed(evt);
            }
        });

        jLabel4.setText("Salle:");

        listesalle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Salle1", "Salle2" }));
        listesalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listesalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listesalle, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMarque, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtRef, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addComponent(txtPrix)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(listesalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        bnAdd.setText("Ajouter");
        bnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnAddActionPerformed(evt);
            }
        });

        bnDelete.setText("Supprimer");
        bnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDeleteActionPerformed(evt);
            }
        });

        bnUpdate.setText("Modifier");
        bnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnDelete)
                    .addComponent(bnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bnAdd)
                .addGap(47, 47, 47)
                .addComponent(bnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(bnUpdate)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listes des machines"));

        machineList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Marque", "Prix", "Ref"
            }
        ));
        jScrollPane1.setViewportView(machineList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrixActionPerformed

    private void txtRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRefActionPerformed

    private void bnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDeleteActionPerformed
         // TODO add your handling code here:
        id = Integer.parseInt(model.getValueAt(machineList.getSelectedRow(), 0).toString());
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiement modifié cette machine");
        if (reponse == 0) {
            try {
                if (dao.delete(dao.findById(id))) {
                    load();
                    JOptionPane.showMessageDialog(this, "bien modifié");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bnDeleteActionPerformed

    private void bnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAddActionPerformed
       try {
           String ref= txtRef.getText().toString();
           String marque= txtMarque.getText().toString();
           double prix= Double.parseDouble(txtPrix.getText().toString());
           JOptionPane.showMessageDialog(this, "bien ajoute");
           dao.create(new Machine(ref, marque, prix));
           load();
       } catch (RemoteException ex) {
           Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_bnAddActionPerformed

    private void bnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnUpdateActionPerformed
       
    }//GEN-LAST:event_bnUpdateActionPerformed

    private void listesalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listesalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listesalleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnAdd;
    private javax.swing.JButton bnDelete;
    private javax.swing.JButton bnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox listesalle;
    private javax.swing.JTable machineList;
    private javax.swing.JTextField txtMarque;
    private javax.swing.JTextField txtPrix;
    private javax.swing.JTextField txtRef;
    // End of variables declaration//GEN-END:variables
}
