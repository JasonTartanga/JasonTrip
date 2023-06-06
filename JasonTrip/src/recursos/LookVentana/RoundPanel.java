package recursos.LookVentana;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 * Crea paneles redondos.
 *
 * @author xDoble_Jx
 */
public class RoundPanel extends JPanel {

    /**
     * Crea el panel.
     */
    public RoundPanel() {
        setOpaque(false);
    }

    /**
     * Hace que sea redondo.
     *
     * @param grphcs
     */
    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.dispose();
        super.paint(grphcs);
    }
}
