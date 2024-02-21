package GUI;
import java.awt.*;
import javax.swing.*;
import org.graphstream.graph.*;
import org.graphstream.ui.swingViewer.*;
import org.graphstream.ui.view.*;

/**
 * @author: Stefano Boschetti
 * @author: Diego De Jesus
 * @version: 20/02/2024
 * 
 * @see <a href = "https://stackoverflow.com/questions/45050654/add-graphstream-graph-into-my-custom-jpanel" />
 * stackoverflow.com – java - Add GraphStream graph into my custom jPanel </a>
 */
public class GraphViewer {
//    Campos de la clase
    JFrame frame;
    
    
/**
 * Método que crea una ventana nueva donde se representara
 * un grafo de la libreria GraphStream.
 *
     * @param graph Grafo de GraphStream a representar.
     * @param windowName Nombre de la ventana a generar.
 */
    public void display(Graph graph, String windowName) {
//        Se crea el JFrame.
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        Se crea un JPanel.
        JPanel panel = new JPanel(new GridLayout()){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 500);
            }
        };
        frame.setTitle(windowName);
//        Se genera el panel contenedor del grafo de GraphStream y se añade al JPanel.
        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();
        ViewPanel viewPanel = viewer.addDefaultView(false);
        panel.add(viewPanel);
//        Se agregar el JPanel al JFrame.
        frame.add(panel);
        frame.pack();
        
//        Establecer la posición del JFrame centrado a la derecha de la pantalla.
        GraphicsConfiguration config = frame.getGraphicsConfiguration();
        Rectangle bounds = config.getBounds();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = bounds.x + bounds.width - insets.right - frame.getWidth();
        frame.setLocation(x, dim.height/2-frame.getSize().height/2);
//        Se hace visible el JFrame.
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }
    
    /**
     * Método que cierra la ventana.
     */
    public void kill(){
        frame.dispose();
    }
    
}
