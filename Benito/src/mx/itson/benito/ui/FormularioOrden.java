/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.benito.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import mx.itson.benito.entidades.Articulo;
import mx.itson.benito.entidades.Compra;
import mx.itson.benito.entidades.Proveedor;
import mx.itson.benito.enumeradores.Estado;
import mx.itson.benito.persistencias.ArticuloDAO;
import mx.itson.benito.persistencias.CompraDAO;
import mx.itson.benito.persistencias.ProveedorDAO;

/**
 *
 * @author Enrique Gonzalez Leyva
 */
public class FormularioOrden extends javax.swing.JDialog {

    int id = 0;

    /**
     * Creates new form FormularioOrden
     */
    public FormularioOrden(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        this.id = id;
        
        if (id != 0) {
            Compra compra = new Compra();

            txtFolio.setText(compra.getFolio());
            cmbArticulo.getSelectedObjects();
            cmbProveedor.getSelectedItem();
        }

        cargarProveedores();
        cargarArticulos();
    }
/**
 * Metodo que se encarga de cargar los proveedores existentes dentro del comboBox
 * de Proveedor
 */
    public void cargarProveedores() {
        List<Proveedor> proveedores = ProveedorDAO.obtenerTodos();
        for (Proveedor p : proveedores) {
            cmbProveedor.addItem(p);
        }
    }
/**
 * Metodo que se encarga de cargar los articulos existentes dentro del comboBox
 * de Articulo
 */
    public void cargarArticulos() {
        List<Articulo> articulos = ArticuloDAO.obtenerTodos();
        for (Articulo a : articulos) {
            cmbArticulo.addItem(a);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox<>();
        txtFolio = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        cmbArticulo = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        spnCantidad = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Proveedores");

        jLabel2.setText("Folio");

        jLabel3.setText("Fecha");

        jLabel4.setText("Articulo");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel5.setText("Cantidad");

        jLabel6.setText("Estado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 304, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(spnCantidad)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(cmbProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFolio)
                            .addComponent(txtFecha)
                            .addComponent(cmbArticulo, 0, 280, Short.MAX_VALUE)
                            .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cmbArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btnGuardar)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Datos a guardar dentro del formulario usando un boton
        try {
            Proveedor proveedor = (Proveedor) cmbProveedor.getSelectedItem();
            System.out.println("El conductor seleccionado es: " + proveedor.getId());
            String folio = txtFolio.getText();
            Articulo idArticulo =(Articulo) cmbArticulo.getSelectedItem();
            System.out.println("El conductor seleccionado es: " + idArticulo.getId());
            Date fecha = new SimpleDateFormat("yyyy MM, d", Locale.ENGLISH).parse(txtFecha.getText());
            int cantidad = (int) spnCantidad.getValue();
            Estado estado = (Estado) cmbEstado.getSelectedItem();
            
             boolean resultado = this.id == 0 ?
            
            CompraDAO.guardar(proveedor, folio, idArticulo, fecha, cantidad):
            CompraDAO.editar(id, proveedor, folio, idArticulo, fecha, cantidad);
            
        if(resultado){
            JOptionPane.showMessageDialog(this, "El registro se guardó correctamente", "Registro guardado", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }else
            JOptionPane.showMessageDialog(this, "El registro se edito con exito", "Registro guardado", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioOrden dialog = new FormularioOrden(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Articulo> cmbArticulo;
    private javax.swing.JComboBox<Estado> cmbEstado;
    private javax.swing.JComboBox<Proveedor> cmbProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFolio;
    // End of variables declaration//GEN-END:variables
}
