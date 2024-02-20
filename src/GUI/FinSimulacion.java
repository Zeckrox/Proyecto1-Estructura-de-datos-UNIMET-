/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import logica.Grafo;
import logica.ListaDoble;
import logica.Nodo;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.Graphs;

/**
 * @author Stefano Boschetti
 * @author Diego De Jesus
 */

public class FinSimulacion extends javax.swing.JFrame {
    String[] ciclosOptimos;
    Grafo myGrafo;
    int nido;
    int comida;
    Graph ogGraph;
    Graph graph;
    GraphViewer graphVisualizer = new GraphViewer();
    private final int visCiudad;

    /**
     * Creates new form FinSimulacion
     * @param myG
     * @param grafo
     * @param nest
     * @param food
     * @param optimalC
     * @param impFeromona
     * @param visCiudad
     * @param facEvaporacion
     * @param hormiga
     */
    public FinSimulacion(Grafo myG, Graph grafo, int nest, int food, String[] optimalC, int impFeromona,
            int visCiudad, float facEvaporacion, int hormiga) {
        
        initComponents();
        this.setAlwaysOnTop(true);
        hormigas.setText(String.format("Hormigas: %d", hormiga));
        ciclos.setText(String.format("Ciclos: %d", optimalC.length));
        nidos.setText(String.format("Nido: (%d)%s", nest, myG.listaAdy[nest].nombre));
        comidas.setText(String.format("Comida: (%d)%s", food, myG.listaAdy[food].nombre));
        evaporacion.setText(String.format("Factor de evaporación: %f", facEvaporacion));
        feromona.setText(String.format("Grado de importancia de la feromona: %d", impFeromona));
        ciudad.setText(String.format("Grado de visibilidad de la ciudad: %d", visCiudad));
        ciclosOptimos = optimalC;
        myGrafo = myG;
        ogGraph = grafo;
        graph = Graphs.clone(grafo);
        nido = nest;
        comida = food;
        graph.setAttribute("ui.stylesheet", "node.nido{fill-color: #badc58; size: 15px;} node.comida { fill-color: #ff6b81; size:15px;}"
                + " edge.connected { fill-color: #6ab04c; size: 2px; }");
        
        ListaDoble posiblesRecorridos = new ListaDoble();
//        Se analizan todos los posible recorridos
        for(int i = 0; i< ciclosOptimos.length; i++){
            if( !posiblesRecorridos.contains(ciclosOptimos[i]) ){
                posiblesRecorridos.push(ciclosOptimos[i]);
            }
        }
//        Y se buscan las ocurrencias de estos caminos para determinar el mas optimo.
        int ocurrencias[] = new int[posiblesRecorridos.size];
        for(int i = 0; i< ciclosOptimos.length; i++){
            Nodo auxNodo = posiblesRecorridos.first;
            for(int j = 0 ; j < ocurrencias.length ; j++){
                if (auxNodo.text.equals(ciclosOptimos[i])){
                    ocurrencias[j]++;
                }
                auxNodo = auxNodo.next;
            } 
        }
//        Se almacena la posicion con mayor ocurrencias
        int caminoOptimo = -1;
        for(int index = 0; index < ocurrencias.length; index++){
            if(caminoOptimo == -1){
                caminoOptimo = index;
            }
            else if(ocurrencias[index] > ocurrencias[caminoOptimo]){
                    caminoOptimo = index;
            }
        }
//        Y ahora se busca en los posibles caminos el valor del camino optimo.
        Nodo caminoIdeal = posiblesRecorridos.first;
        for(int indice = 0; indice != caminoOptimo; indice++){
            caminoIdeal = caminoIdeal.next;
        }
//        Finalmente se personaliza el grafo con cada uno delos vertices del camino más optimo.
        String posicionesIdeales[] = caminoIdeal.text.split("→");
        for(int pI = 0; pI < posicionesIdeales.length-1 ; pI++){
            String from = String.format("(%d)",Integer.parseInt(posicionesIdeales[pI]) )
                    + myGrafo.listaAdy[Integer.parseInt(posicionesIdeales[pI])].nombre;
            String to = String.format("(%d)",Integer.parseInt(posicionesIdeales[pI+1]))
                    + myGrafo.listaAdy[Integer.parseInt(posicionesIdeales[pI+1])].nombre;
            if(graph.getEdge(from+to) == null){
                graph.getEdge(to+from).setAttribute("ui.class", "connected");
            }
            else{
                graph.getEdge(from+to).setAttribute("ui.class", "connected");
            }
        }
//        Aqui se personaliza el grafo de GraphStream
        graph.getNode(String.format("(%d)", nido) + myGrafo.listaAdy[nido].nombre).setAttribute("ui.class", "nido");
        graph.getNode(String.format("(%d)", comida) + myGrafo.listaAdy[comida].nombre).setAttribute("ui.class", "comida");
        graphVisualizer.display(graph, this.getWidth()+230, this.getHeight()+100, "Ruta óptima de la simulación");
        this.visCiudad = visCiudad;
        
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
        hormigas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ciclos = new javax.swing.JLabel();
        nidos = new javax.swing.JLabel();
        comidas = new javax.swing.JLabel();
        evaporacion = new javax.swing.JLabel();
        feromona = new javax.swing.JLabel();
        ciudad = new javax.swing.JLabel();
        backStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hormigas.setText("Hormigas:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIMULACION TERMINADA");

        ciclos.setText("Ciclos:");

        nidos.setText("Nido:");

        comidas.setText("Comida:");

        evaporacion.setText("Factor de evaporación:");

        feromona.setText("Grado de importancia de la feromona:");

        ciudad.setText("Grado de visibilidad de la ciudad:");

        backStart.setText("Volver al inicio");
        backStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hormigas)
                            .addComponent(ciclos)
                            .addComponent(nidos)
                            .addComponent(comidas)
                            .addComponent(evaporacion)
                            .addComponent(feromona)
                            .addComponent(ciudad)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(backStart)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(hormigas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ciclos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(evaporacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feromona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ciudad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(backStart)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backStartActionPerformed
        // TODO add your handling code here:
        graphVisualizer.kill();
        VentanaInicial myVentana = new VentanaInicial(myGrafo, ogGraph);
        myVentana.setVisible(true);
        myVentana.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_backStartActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backStart;
    private javax.swing.JLabel ciclos;
    private javax.swing.JLabel ciudad;
    private javax.swing.JLabel comidas;
    private javax.swing.JLabel evaporacion;
    private javax.swing.JLabel feromona;
    private javax.swing.JLabel hormigas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nidos;
    // End of variables declaration//GEN-END:variables
}
