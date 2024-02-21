package GUI;
import JFileChooser.ClaseFrame;
import logica.Grafo;
import org.graphstream.graph.*;

/**
 * @author: Stefano Boschetti
 * @author: Diego De Jesus
 * @version: 20/02/2024
 */
public class VentanaInicial extends javax.swing.JFrame {
    Grafo myGrafo;
    Graph graph;
    int nido = 0;
    int comida = 3; 
    int ciclos = 1;
    int hormigas = 5;
    int importanciaFeromona = 1;
    int visibilidadCiudad = 2;
    float factorEva = (float)0.5;
    GraphViewer graphVisualizer = new GraphViewer();
    
    /**
     * Creates new form VentanaInicial
     * @param myG
     * @param gStream
     */
    public VentanaInicial(Grafo myG, Graph gStream) {
        initComponents();
        this.setAlwaysOnTop(true);
        myGrafo = myG;
        graph = gStream;
        graphVisualizer.display(graph, this.getWidth(), this.getHeight(), "Grafo de la simulacion");
        comidaSpinner.setValue(3);
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
        addCityBtn = new javax.swing.JButton();
        addPathBtn = new javax.swing.JButton();
        deleteCityBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nidoSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        comidaSpinner = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ciclosSpinner = new javax.swing.JSpinner();
        hormigasSpinner = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        startSimulation = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        alpha = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        beta = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        evaporacion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        importGraph = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addCityBtn.setText("Añadir Ciudad");
        addCityBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCityBtnActionPerformed(evt);
            }
        });

        addPathBtn.setText("Añadir Camino");
        addPathBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPathBtnActionPerformed(evt);
            }
        });

        deleteCityBtn.setText("Eliminar Ciudad");
        deleteCityBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCityBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIMULADOR DE COLONIAS DE HORMIGAS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Modificar Grafo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Valores de la simulacion");

        nidoSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nidoSpinnerStateChanged(evt);
            }
        });

        jLabel4.setText("ID de la ciudad inicial (nido)");

        comidaSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                comidaSpinnerStateChanged(evt);
            }
        });

        jLabel5.setText("ID de la ciudad objetivo (comida)");

        jLabel6.setText("Cantidad de ciclos");

        ciclosSpinner.setValue(1);
        ciclosSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ciclosSpinnerStateChanged(evt);
            }
        });

        hormigasSpinner.setValue(5);
        hormigasSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hormigasSpinnerStateChanged(evt);
            }
        });

        jLabel7.setText("Cantidad de hormigas");

        startSimulation.setText("Iniciar simulacion");
        startSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSimulationActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Constantes de la simulación");

        jLabel9.setText("Factor de evaporación (ρ)");

        alpha.setValue(1);
        alpha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                alphaStateChanged(evt);
            }
        });

        jLabel10.setText("Grado de importancia de la feromona (α)");

        beta.setValue(2);
        beta.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                betaStateChanged(evt);
            }
        });

        jLabel11.setText("Grado de visibilidad de la ciudad (β)");

        evaporacion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        evaporacion.setText("0.5");
        evaporacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                evaporacionFocusLost(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("ρ debe ser un número dentro del conjunto de (0,1]*");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Importar Grafo");

        importGraph.setText("Cargar Grafo");
        importGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importGraphActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(startSimulation)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hormigasSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ciclosSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nidoSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comidaSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(importGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(166, 166, 166)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(beta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(alpha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(evaporacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addCityBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addPathBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteCityBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addCityBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addPathBtn)
                        .addGap(18, 18, 18)
                        .addComponent(deleteCityBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nidoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comidaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ciclosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hormigasSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(importGraph))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(evaporacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(startSimulation)
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

    private void addCityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCityBtnActionPerformed
        AddCiudad addCityWindow = new AddCiudad(graph, myGrafo);
        addCityWindow.setLocationRelativeTo(this);
        addCityWindow.setVisible(true);
    }//GEN-LAST:event_addCityBtnActionPerformed

    private void addPathBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPathBtnActionPerformed
        AddCamino addPathWindow = new AddCamino(graph, myGrafo);
        addPathWindow.setLocationRelativeTo(this);
        addPathWindow.setVisible(true);
    }//GEN-LAST:event_addPathBtnActionPerformed

    private void nidoSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nidoSpinnerStateChanged
        if((int) nidoSpinner.getValue() < 0){
            nidoSpinner.setValue(0);
        }
        if((int) nidoSpinner.getValue() > myGrafo.numVertices-1){
            nidoSpinner.setValue(myGrafo.numVertices-1);
        }
        nido = (int) nidoSpinner.getValue();
    }//GEN-LAST:event_nidoSpinnerStateChanged

    private void comidaSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_comidaSpinnerStateChanged
        if((int) comidaSpinner.getValue() < 0){
            comidaSpinner.setValue(0);
        }
        if((int) comidaSpinner.getValue() > myGrafo.numVertices-1){
            comidaSpinner.setValue(myGrafo.numVertices-1);
        }
        comida = (int) comidaSpinner.getValue();
    }//GEN-LAST:event_comidaSpinnerStateChanged

    private void ciclosSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ciclosSpinnerStateChanged
        if((int) ciclosSpinner.getValue() < 1){
            ciclosSpinner.setValue(1);
        }
        ciclos = (int) ciclosSpinner.getValue();
    }//GEN-LAST:event_ciclosSpinnerStateChanged

    private void hormigasSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hormigasSpinnerStateChanged
        if((int) hormigasSpinner.getValue() < 1){
            hormigasSpinner.setValue(1);
        }
        hormigas = (int) hormigasSpinner.getValue();
    }//GEN-LAST:event_hormigasSpinnerStateChanged

    private void startSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSimulationActionPerformed
        if(nido == comida){
            Alerta alerta = new Alerta("La comida debe ser diferente del nido");
            alerta.setVisible(true);
            alerta.setLocationRelativeTo(this);
        }
        else{
            myGrafo.iniciarSimulacion(nido, comida, ciclos, hormigas, importanciaFeromona, visibilidadCiudad, factorEva);
            graphVisualizer.kill();
            this.dispose();
            String[] ciclosOptimos = new String[myGrafo.distanciasSimulacion.length];
            VentanaCiclo cicleWindow = new VentanaCiclo(myGrafo, graph, nido, comida,
                    1, ciclosOptimos, importanciaFeromona, visibilidadCiudad, factorEva, hormigas);
            cicleWindow.setVisible(true);
            cicleWindow.setLocationRelativeTo(this);
        }
    }//GEN-LAST:event_startSimulationActionPerformed

    private void alphaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_alphaStateChanged
        if((int) alpha.getValue() < 1){
            alpha.setValue(1);
        }
        importanciaFeromona = (int) alpha.getValue();
    }//GEN-LAST:event_alphaStateChanged

    private void betaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_betaStateChanged
        if((int) beta.getValue() < 1){
            beta.setValue(1);
        }
        visibilidadCiudad = (int) beta.getValue();
    }//GEN-LAST:event_betaStateChanged

    private void evaporacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_evaporacionFocusLost
        evaporacion.setText(evaporacion.getText().replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
        if(evaporacion.getText().length() == 0){
            evaporacion.setText("0.5");
        }
        if(Float.valueOf(evaporacion.getText()) < (float) 0){
            evaporacion.setText("0.01");
        }
        else if(Float.valueOf(evaporacion.getText()) >= (float) 1.0){
            evaporacion.setText("0.99");
        }
        factorEva = Float.valueOf(evaporacion.getText());
    }//GEN-LAST:event_evaporacionFocusLost

    private void deleteCityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCityBtnActionPerformed
        DeleteCiudad deleteCity = new DeleteCiudad(myGrafo, graph);
        deleteCity.setLocationRelativeTo(this);
        deleteCity.setVisible(true);
    }//GEN-LAST:event_deleteCityBtnActionPerformed

    private void importGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importGraphActionPerformed
        // TODO add your handling code here:
        
        ClaseFrame importWindow = new ClaseFrame();
        importWindow.setAlwaysOnTop(true);
        String textFile = importWindow.abrirArchivo().replace("ciudad\n", "");
        if(textFile.length() > 0){
            myGrafo.vaciarGrafo();
            myGrafo.vaciarGraphStream(graph);
            String[] ciudades = textFile.split("aristas\n")[0].split("\n");
            String[] aristas = textFile.split("aristas\n")[1].split("\n");
            Boolean contieneCero = false;
            for(int i = 0; i < ciudades.length; i++){
                if(ciudades[i].equals("0")){contieneCero = true;}
                myGrafo.crearVertice("");
            }
            if(contieneCero){
                for (int j = 0; j < aristas.length; j++) {
                    String[] tempInfo = aristas[j].split(",");
                    myGrafo.crearArista(Integer.parseInt(tempInfo[0]),Integer.parseInt(tempInfo[1]), Float.parseFloat(tempInfo[2]));
                }
            }    
            else{
                for(int j = 0; j < aristas.length; j++){
                    String[] tempInfo = aristas[j].split(",");
                    myGrafo.crearArista(Integer.parseInt(tempInfo[0])-1,Integer.parseInt(tempInfo[1])-1, Float.parseFloat(tempInfo[2]) );
                }       
            }
            
            myGrafo.copiarEnGraphStream(graph);
        }
    }//GEN-LAST:event_importGraphActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCityBtn;
    private javax.swing.JButton addPathBtn;
    private javax.swing.JSpinner alpha;
    private javax.swing.JSpinner beta;
    private javax.swing.JSpinner ciclosSpinner;
    private javax.swing.JSpinner comidaSpinner;
    private javax.swing.JButton deleteCityBtn;
    private javax.swing.JTextField evaporacion;
    private javax.swing.JSpinner hormigasSpinner;
    private javax.swing.JButton importGraph;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner nidoSpinner;
    private javax.swing.JButton startSimulation;
    // End of variables declaration//GEN-END:variables
}
