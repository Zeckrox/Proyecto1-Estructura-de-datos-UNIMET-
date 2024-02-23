package GUI;

import javax.swing.DefaultListModel;
import logica.Grafo;
import org.graphstream.graph.Graph;

/**
 * Esta clase crea una ventana donde el usuario podrá crear una Arista
 * entre dos Vertices del Grafo.
 * 
 * @author: Stefano Boschetti
 * @author: Diego De Jesus
 * @version: 20/02/2024
 */
public class AddCamino extends javax.swing.JFrame {
//    Campos de la clase
    Graph graphStream;
    Grafo myGrafo;
    String ciudadDesde;
    String ciudadHasta;
    Float distance;

/**
 * Constructor de la ventana AddCamino.
 *
 * @param graph Grafo de GraphStream.
 * @param myGraph Grafo propio de la simulación.
 */
    public AddCamino(Graph graph, Grafo myGraph) {
        graphStream = graph;
        myGrafo = myGraph;
        distance = (float) 1.5;
        initComponents();
        this.setAlwaysOnTop(true);
        DefaultListModel mod = new DefaultListModel();
        desde.setModel(mod);
        for(int i = 0; i < myGrafo.numVertices ; i++){
            mod.addElement(String.format("(%d)",i) + myGrafo.listaAdy[i].nombre);
        }
    }//Cierre del constructor

/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        addPath = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        desde = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        hasta = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        distanceBetween = new javax.swing.JTextField();

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("AGREGAR CIUDAD");

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Desde");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hasta");

        jLabel3.setText("Distancia entre las ciudades:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setForeground(java.awt.Color.gray);
        jLabel4.setText("*Solo se muestran las ciudades");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setForeground(java.awt.Color.gray);
        jLabel5.setText("disponibles para viajar*");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AGREGAR CAMINO");

        distanceBetween.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        distanceBetween.setText("1.5");
        distanceBetween.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                distanceBetweenFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addPath)
                .addGap(131, 131, 131))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addComponent(distanceBetween))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(distanceBetween, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

/**
 * Método que al presionar el botón addPath añade una Arista al grafo,
 * entre la ciudades seleccionadas.
 */
    private void addPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPathActionPerformed
        if(ciudadDesde == null || ciudadHasta == null){
            System.out.println("SELECCIONAR AMBAS CIUDADES");
        }
        else{
            int desdeID = Integer.parseInt(ciudadDesde.replaceAll("[^0-9]", ""));
            int hastaID = Integer.parseInt(ciudadHasta.replaceAll("[^0-9]", ""));
            myGrafo.crearArista(desdeID, hastaID, (float) distance);
            graphStream.addEdge(ciudadDesde+ciudadHasta, ciudadDesde, ciudadHasta)
                    .setAttribute("ui.label", (float)distance);
            this.setVisible(false);
        }
    }//GEN-LAST:event_addPathActionPerformed
    
/**
 * Método que al cambiar el valor de la lista "desde", asigna este valor
 * al atributo ciudadDesde, y generá en la lista "hasta" todos los Vertices
 * disponibles para viajar desde el valor seleccionado.
 */    
    private void desdeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_desdeValueChanged
        ciudadDesde = desde.getSelectedValue();
        DefaultListModel mod = new DefaultListModel();
        hasta.setModel(mod);
        for(int i = 0; i < myGrafo.numVertices ; i++){
            String fixedName = String.format("(%d)",i)+myGrafo.listaAdy[i].nombre;
            if(!fixedName.equals(ciudadDesde)){
                if(!myGrafo.listaAdy[Integer.parseInt(ciudadDesde.replaceAll("[^0-9]", ""))].contains(i)){
                    mod.addElement(String.format("(%d)",i) + myGrafo.listaAdy[i].nombre);
                } 
            }
        }
    }//GEN-LAST:event_desdeValueChanged
    
/**
 * Método que al cambiar el valor de la lista "hasta", asigna este valor
 * al atributo ciudadHasta.
 */        
    private void hastaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_hastaValueChanged
        ciudadHasta = hasta.getSelectedValue();
    }//GEN-LAST:event_hastaValueChanged

/**
 * Método que cuando la caja de texto "distanceBetween" pierde el foco, asigna su
 * valor númerico al atributo "distance".
 */    
    private void distanceBetweenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_distanceBetweenFocusLost
        distanceBetween.setText(distanceBetween.getText().replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
        if(distanceBetween.getText().length() == 0){
            distanceBetween.setText("1.5");
        }
        if(Float.valueOf(distanceBetween.getText()) <= (float) 0){
            distanceBetween.setText("0.01");
        }
        distance = Float.valueOf(distanceBetween.getText());
    }//GEN-LAST:event_distanceBetweenFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPath;
    private javax.swing.JList<String> desde;
    private javax.swing.JTextField distanceBetween;
    private javax.swing.JList<String> hasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}//Cierre de la clase
