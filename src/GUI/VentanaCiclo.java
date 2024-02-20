/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import javax.swing.DefaultListModel;
import logica.Grafo;
import logica.ListaDoble;
import logica.Nodo;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.Graphs;

/**
 * @author Stefano Boschetti
 * @author Diego De Jesus
 */
public class VentanaCiclo extends javax.swing.JFrame {
    String[] ciclosOptimos;
    Grafo myGrafo;
    int cicloNum;
    int nido;
    int comida;
    int importanciaFeromona;
    int visibilidadCiudad;
    float factorEva;
    int cHormigas;
    Graph ogGraph;
    Graph graph;
    GraphViewer graphVisualizer = new GraphViewer();
    /**
     * Creates new form VentanaCiclo
     * @param myG
     * @param grafo
     * @param nest
     * @param food
     * @param num
     * @param optimalC
     * @param impFeromona
     * @param visCiudad
     * @param facEvaporacion
     * @param hormigas
     */
    public VentanaCiclo(Grafo myG, Graph grafo,int nest, int food, int num, String[] optimalC, int impFeromona,
            int visCiudad, float facEvaporacion, int hormigas) {
        initComponents();
        this.setAlwaysOnTop(true);
        importanciaFeromona = impFeromona;
        visibilidadCiudad = visCiudad;
        factorEva = facEvaporacion;
        cHormigas = hormigas;
        ciclosOptimos = optimalC;
        myGrafo = myG;
        ogGraph = grafo;
        graph = Graphs.clone(grafo);
        graph.setAttribute("ui.stylesheet", "node.nido{fill-color: #badc58; size: 15px;} node.comida { fill-color: #ff6b81; size:15px;}"
                + " edge.connected { fill-color: #6ab04c; size: 2px; }");
        cicloNum = num;
        nido = nest;
        comida = food;
        titleLabel.setText(String.format("INFORMACION DEL CICLO #%d",num));
        hormigasLabel.setText(String.format("HORMIGAS: %d", myGrafo.distanciasSimulacion[cicloNum-1].length));
        
//        Aqui se genera el listado de las hormigas y sus recorridos
        DefaultListModel mod = new DefaultListModel();
        antInfo.setModel(mod);
        for(int i = 0; i< myGrafo.distanciasSimulacion[cicloNum-1].length; i++){
            mod.addElement(String.format("<html>Hormiga(%d): &#8205; %s <br/>Distancia recorrida: %dm<br/> &#8205; </html>",
                    i, myGrafo.recorridosSimulacion[cicloNum-1][i], myGrafo.distanciasSimulacion[cicloNum-1][i]) );
        }
        ListaDoble posiblesRecorridos = new ListaDoble();
//        Se analizan todos los posible recorridos
        for(int i = 0; i< myGrafo.recorridosSimulacion[cicloNum-1].length; i++){
            if( !posiblesRecorridos.contains(myGrafo.recorridosSimulacion[cicloNum-1][i]) ){
                posiblesRecorridos.push(myGrafo.recorridosSimulacion[cicloNum-1][i]);
            }
        }
//        Y se buscan las ocurrencias de estos caminos para determinar el mas optimo.
        int ocurrencias[] = new int[posiblesRecorridos.size];
        for(int i = 0; i< myGrafo.recorridosSimulacion[cicloNum-1].length; i++){
            Nodo auxNodo = posiblesRecorridos.first;
            for(int j = 0 ; j < ocurrencias.length ; j++){
                if (auxNodo.text.equals(myGrafo.recorridosSimulacion[cicloNum-1][i])){
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
        ciclosOptimos[cicloNum-1] = caminoIdeal.text;
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
        graph.getNode(String.format("(%d)",nido) + myGrafo.listaAdy[nido].nombre).setAttribute("ui.class", "nido");
        graph.getNode(String.format("(%d)",comida) + myGrafo.listaAdy[comida].nombre).setAttribute("ui.class", "comida");
        graphVisualizer.display(graph, this.getWidth(), this.getHeight(), String.format("Ruta óptima ciclo #%d", cicloNum) );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        nextCicleBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        antInfo = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        hormigasLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("INFORMACION DEL CICLO #");

        nextCicleBtn.setText("Siguente ciclo");
        nextCicleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextCicleBtnActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(antInfo);

        jLabel1.setText("Información de hormigas.");

        hormigasLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        hormigasLabel.setText("HORMIGAS:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(hormigasLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(nextCicleBtn)
                .addContainerGap(253, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hormigasLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nextCicleBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextCicleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextCicleBtnActionPerformed
        if(cicloNum+1 > myGrafo.distanciasSimulacion.length){
            FinSimulacion newEnd = new FinSimulacion(myGrafo, ogGraph, nido, comida, ciclosOptimos,
                    importanciaFeromona, visibilidadCiudad, factorEva, cHormigas);
            newEnd.setLocationRelativeTo(this);
            newEnd.setVisible(true);
        }
        else{
            VentanaCiclo cicleWindow = new VentanaCiclo(myGrafo, ogGraph, nido, comida, 
                    cicloNum+1, ciclosOptimos, importanciaFeromona, visibilidadCiudad, factorEva, cHormigas);
            cicleWindow.setVisible(true);
            cicleWindow.setLocationRelativeTo(this);
        }
        this.dispose();
        graphVisualizer.kill();
    }//GEN-LAST:event_nextCicleBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> antInfo;
    private javax.swing.JLabel hormigasLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextCicleBtn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}