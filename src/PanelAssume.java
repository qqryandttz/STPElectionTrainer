import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;


//推测面板
class PanelAssume extends JPanel {

    InterfaceExecution IE;

    PanelAssume(InterfaceExecution interfaceExecution){
        IE = interfaceExecution;
        setLayout(null);
        
    }


    
    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);

        

    }


}

