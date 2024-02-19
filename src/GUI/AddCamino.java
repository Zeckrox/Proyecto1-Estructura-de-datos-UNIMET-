/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.DefaultListModel;
import logica.Grafo;
import org.graphstream.graph.Graph;

/**
 *
 * @author necro
 */
public class AddCamino extends javax.swing.JFrame {
    Graph graphStream;
    Grafo myGrafo;
    String ciudadDesde;
    String ciudadHasta;

    /**
     * Creates new form AddCamino
     * @param graph
     * @param myGraph
     */
    public AddCamino(Graph graph, Grafo myGraph) {
        graphStream = graph;
        myGrafo = myGraph;
        initComponents();
        DefaultListModel mod = new DefaultListModel();
        desde.setModel(mod);
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
        addPath = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        desde = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        hasta = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        distance = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        addPath.setText("Crear");
        addPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPathActionPerformed(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(50, 150));

        desde.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                desdeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(desde);

        hasta.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                hastaValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(hasta);

        jLabel1.setText("Desde");

        jLabel2.setText("Hasta");

        jLabel3.setText("Distancia entre las ciudades:");

        distance.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(addPath))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(distance, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(distance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(addPath)
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

    private void addPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPathActionPerformed
        // TODO add your handling code here:
        if(ciudadDesde == null || ciudadHasta == null){
            System.out.println("SELECCIONAR AMBAS CIUDADES");
        }
        else{
            int desdeID = Integer.parseInt(ciudadDesde.replaceAll("[^0-9]", ""));
            int hastaID = Integer.parseInt(ciudadHasta.replaceAll("[^0-9]", ""));
            myGrafo.crearArista(desdeID, hastaID, (int) distance.getValue());
            graphStream.addEdge(ciudadDesde+ciudadHasta, ciudadDesde, ciudadHasta)
                    .setAttribute("ui.label", (int)distance.getValue() );
            this.setVisible(false);
        }
    }//GEN-LAST:event_addPathActionPerformed

    private void desdeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_desdeValueChanged
        // TODO add your handling code here:
        ciudadDesde = desde.getSelectedValue();
        DefaultListModel mod = new DefaultListModel();
        hasta.setModel(mod);
        for(int i = 0; i < myGrafo.numVertices ; i++){
            String fixedName = String.format("(%d)",i)+myGrafo.listaAdy[i].nombre;
            if(!fixedName.equals(ciudadDesde)){
                mod.addElement(String.format("(%d)",i) + myGrafo.listaAdy[i].nombre);
            }
        }
    }//GEN-LAST:event_desdeValueChanged

    private void hastaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_hastaValueChanged
        // TODO add your handling code here:
        ciudadHasta = hasta.getSelectedValue();
    }//GEN-LAST:event_hastaValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPath;
    private javax.swing.JList<String> desde;
    private javax.swing.JSpinner distance;
    private javax.swing.JList<String> hasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}