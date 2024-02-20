/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.DefaultListModel;
import logica.Grafo;
import logica.NodoArista;
import org.graphstream.graph.Graph;

/**
 * @author Stefano Boschetti
 * @author Diego De Jesus
 */
public class DeleteCiudad extends javax.swing.JFrame {
    Grafo myGrafo;
    Graph graph;
    int cityToDelete;
    /**
     * Creates new form DeleteCidad
     * @param myG
     * @param gStream
     */
    public DeleteCiudad(Grafo myG, Graph gStream) {
        initComponents();
        myGrafo = myG;
        graph = gStream;
        this.setAlwaysOnTop(true);
        
        DefaultListModel mod = new DefaultListModel();
        citiesList.setModel(mod);
        for(int i = 0; i < myGrafo.numVertices ; i++){
            mod.addElement(String.format("(%d)",i) + myGrafo.listaAdy[i].nombre);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        citiesList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        deleteCity = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        citiesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                citiesListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(citiesList);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELIMINAR CIUDAD");

        deleteCity.setText("Eliminar");
        deleteCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 59, Short.MAX_VALUE)
                        .addComponent(deleteCity)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteCity)
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

    private void citiesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_citiesListValueChanged
        cityToDelete = Integer.parseInt(citiesList.getSelectedValue().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_citiesListValueChanged

    private void deleteCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCityActionPerformed
        if(myGrafo.numVertices == 4){
            Alerta myAlerta = new Alerta("Debes tener al menos 4 ciudades");
            myAlerta.setLocationRelativeTo(this);
            myAlerta.setVisible(true);
        }
        else{
            myGrafo.eliminarVertice(cityToDelete);
            myGrafo.vaciarGraphStream(graph);
            myGrafo.copiarEnGraphStream(graph);
        }
        ;        this.dispose();
    }//GEN-LAST:event_deleteCityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> citiesList;
    private javax.swing.JButton deleteCity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
