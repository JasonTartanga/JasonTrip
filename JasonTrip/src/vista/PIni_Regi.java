package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import modelo.DAO;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;
import recursos.LookVentana.EventLogin;

/**
 * Junta los paneles de inicar sesion y registrarse mediante una animacion.
 *
 * @author xDoble_Jx
 */
public class PIni_Regi extends javax.swing.JPanel {

    private VMain vMain;
    private DAO dao;

    private MigLayout layout;
    private Registrarse register;
    private IniciarSesion login;
    private Animator animator;
    private boolean isLogin = true;
    public static Color mainColor = new Color(21, 21, 21);

    /**
     *
     * @param animate
     */
    public void setAnimate(int animate) {
        layout.setComponentConstraints(login, "pos (50%)-290px-" + animate + " 0.5al n n");
        layout.setComponentConstraints(register, "pos (50%)-10px+" + animate + " 0.5al n n");
        if (animate == 30) {
            if (isLogin) {
                setComponentZOrder(login, 0);
            } else {
                setComponentZOrder(register, 0);
            }
        }
        revalidate();
    }

    /**
     *
     */
    public PIni_Regi() {
        initComponents();
        init();
        initAnimator();

    }

    private void initAnimator() {
        animator = new Animator(1000, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (isLogin) {
                    register.setAlpha(fraction);
                    login.setAlpha(1f - fraction);
                } else {
                    register.setAlpha(1f - fraction);
                    login.setAlpha(fraction);
                }
            }
        });
        animator.addTarget(new PropertySetter(this, "animate", 0, 30, 0));
        animator.setResolution(0);
    }

    private void init() {
        setBackground(mainColor);
        layout = new MigLayout("fill", "fill", "fill");
        setLayout(layout);
        register = new Registrarse();
        login = new IniciarSesion();

        applyEvent(register, false);
        applyEvent(login, true);
        add(login, "pos (50%)-290px 0.5al n n");
        add(register, "pos (50%)-10px 0.5al n n");
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    showLogin(false);
                }
            }
        });
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    showLogin(true);
                }
            }
        });
    }

    /**
     *
     * @param show
     */
    public void showLogin(boolean show) {
        if (show != isLogin) {
            if (!animator.isRunning()) {
                isLogin = show;
                animator.start();
            }
        }
    }

    private void applyEvent(JComponent panel, boolean login) {
        for (Component com : panel.getComponents()) {
            com.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me) {
                    showLogin(login);
                }
            });
        }
    }

    /**
     *
     * @param event
     */
    public void setEventLogin(EventLogin event) {
        login.setEventLogin(event);
    }

    /**
     *
     * @param vMain
     * @param dao
     */
    public void pasarParametros(VMain vMain, DAO dao) {
        this.vMain = vMain;
        this.dao = dao;

        login.pasarParametros(vMain, dao);
        register.pasarParametros(dao);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
