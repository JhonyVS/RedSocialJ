/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import BaseDeDatos.JDBC;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Buscador extends javax.swing.JFrame {

    /**
     * Creates new form Buscador
     */
    public Buscador() {
        
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        top = new javax.swing.JPanel();
        campo = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        nombre = new javax.swing.JRadioButton();
        apellido = new javax.swing.JRadioButton();
        pais = new javax.swing.JRadioButton();
        colegio = new javax.swing.JRadioButton();
        universidad = new javax.swing.JRadioButton();
        ciudad = new javax.swing.JRadioButton();
        email = new javax.swing.JRadioButton();
        borrar = new javax.swing.JButton();
        buscador = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable(getModelo());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        campo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoKeyTyped(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarKeyTyped(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones de busqueda"));

        grupo.add(nombre);
        nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombre.setSelected(true);
        nombre.setText("Nombre");

        grupo.add(apellido);
        apellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        apellido.setText("Apellido");
        apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoActionPerformed(evt);
            }
        });

        grupo.add(pais);
        pais.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pais.setText("Pais");

        grupo.add(colegio);
        colegio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        colegio.setText("Colegio");

        grupo.add(universidad);
        universidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        universidad.setText("Universidad");

        grupo.add(ciudad);
        ciudad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ciudad.setText("Ciudad");

        grupo.add(email);
        email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        email.setText("E-mail");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(email)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre)
                            .addComponent(apellido))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ciudad)
                            .addComponent(pais))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(colegio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(universidad))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre)
                    .addComponent(pais)
                    .addComponent(colegio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellido)
                    .addComponent(ciudad)
                    .addComponent(universidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email)
                .addGap(35, 35, 35))
        );

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        buscador.setText("Personalizada");
        buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorActionPerformed(evt);
            }
        });

        area.setColumns(20);
        area.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        area.setRows(5);
        area.setText(" SELECT \n FROM \n WHERE ");
        jScrollPane1.setViewportView(area);

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topLayout.createSequentialGroup()
                        .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(topLayout.createSequentialGroup()
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topLayout.createSequentialGroup()
                        .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(topLayout.createSequentialGroup()
                        .addComponent(campo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscador))))
        );

        tabla.setAutoCreateRowSorter(true);
        tabla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        campo.setText("");
        tabla.setModel(getModelo());
        area.setText(" SELECT \n FROM \n WHERE ");
    }//GEN-LAST:event_borrarActionPerformed

    private void apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        tabla.setModel(getModelo());
        llenarTabla();
    }//GEN-LAST:event_buscarActionPerformed

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped

    }//GEN-LAST:event_buscarKeyTyped

    private void campoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoKeyTyped

    }//GEN-LAST:event_campoKeyTyped

    private void campoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            tabla.setModel(getModelo());
            llenarTabla();
        }
    }//GEN-LAST:event_campoKeyPressed

    private void buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorActionPerformed
        tablaPersonalizada(area.getText());
    }//GEN-LAST:event_buscadorActionPerformed

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
            java.util.logging.Logger.getLogger(Buscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            //UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
        } catch (Exception e) {
            
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscador().setVisible(true);
            }
        });
    }
    //mis Variables:
    private DefaultTableModel modelo;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton apellido;
    private javax.swing.JTextArea area;
    private javax.swing.JButton borrar;
    private javax.swing.JButton buscador;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField campo;
    private javax.swing.JRadioButton ciudad;
    private javax.swing.JRadioButton colegio;
    private javax.swing.JRadioButton email;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton nombre;
    private javax.swing.JRadioButton pais;
    private javax.swing.JTable tabla;
    private javax.swing.JPanel top;
    private javax.swing.JRadioButton universidad;
    // End of variables declaration//GEN-END:variables
    private void llenarTabla() {
        
        String atrib = "nomU";
        String ref = campo.getText().toLowerCase();
        
        if(ref.length()>0){
            
            if(apellido.isSelected()){
                atrib = "apeU";
            }else if(pais.isSelected()){
                atrib = "pais";
            }else if(ciudad.isSelected()){
                atrib = "ciudad";
            }else if(colegio.isSelected()){
                atrib = "colegio";
            }else if(universidad.isSelected()){
                atrib = "universidad";
            }else if(email.isSelected()) {
                atrib = "email";
            }
            
            ResultSet rs = JDBC.getJDBC().buscar(atrib,ref);
            try {
                //"Nombre","Apellido","E-mail","Pais","Ciudad","Universidad","Colegio"
                if(rs.next()){
                    do{
                        Object[] cad = new Object[7];
                        cad[0] = rs.getString("nomU");
                        cad[1] = rs.getString("apeU");
                        cad[2] = rs.getString("email");
                        cad[3] = rs.getString("pais");
                        cad[4] = rs.getString("ciudad");
                        cad[5] = rs.getString("universidad");
                        cad[6] = rs.getString("colegio");
                        modelo.addRow(cad);
                      } while(rs.next());
                
                }else {
                    JOptionPane.showMessageDialog(null,"No se encontraron resultados...");
                }
            } catch (Exception e) {
                System.out.println("No se encontraron resultados.....");
            }
        }
     
    }
    
    
    
    private DefaultTableModel getModelo(){
        String[] tablas = {"Nombre","Apellido","E-mail","Pais","Ciudad","Universidad","Colegio"}; 
        return modelo = new DefaultTableModel(null,tablas);
        
    }

    private void tablaPersonalizada(String text) {
        try {
            ResultSet rs = JDBC.getJDBC().consultaPersonalizada(text);
            tabla.setModel(modelo  = new DefaultTableModel(null,getEtiquetas(rs)));
            
            /**
             * ahora que tenemos la tabla configurada procedemos a llenarla.
             */
            while(rs.next()){

                Object[] datosFila = new Object[modelo.getColumnCount()];
                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    datosFila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(datosFila);
            }
            
        } catch (Exception e) {
            
        }
    }

    private String[] getEtiquetas(ResultSet rs) {
        String[] etiquetas = null;
        try {
            // Se obtiene los metadatos de la consulta. Con ellos
            // podemos obtener el número de columnas y el nombre
            // de las mismas.
            ResultSetMetaData metaDatos = rs.getMetaData();
                        
            // Se obtiene el numero de columnas.
            int numeroColumnas = metaDatos.getColumnCount();
                        
            // Se obtienen las etiquetas para cada columna
            etiquetas = new String[numeroColumnas];
            for (int i = 0; i < numeroColumnas; i++){
                etiquetas[i] = metaDatos.getColumnLabel(i + 1);
            }
                        
            // Se meten las etiquetas en el modelo. El numero
            // de columnas se ajusta automáticamente.
            //modelo.setColumnIdentifiers(etiquetas);

            
        } catch (Exception e) {
            System.out.println("Error al obtener las etiquetas");
        }
        return etiquetas;
    }

}

