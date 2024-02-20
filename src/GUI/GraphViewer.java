/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.*;
import javax.swing.*;
import org.graphstream.graph.*;
import org.graphstream.ui.swingViewer.*;
import org.graphstream.ui.view.*;

/**
 * @author Stefano Boschetti
 * @author Diego De Jesus
 */
public class GraphViewer {
    JFrame frame;
    public void display(Graph graph, int width, int height, String windowName) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout()){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, height);
            }
        };
        frame.setTitle(windowName);
        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();
        ViewPanel viewPanel = viewer.addDefaultView(false);
        panel.add(viewPanel);
        frame.add(panel);
        frame.pack();
        frame.setLocation(width*2+10, height/2-50);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }
    
    public void kill(){
        frame.dispose();
    }
    
}
