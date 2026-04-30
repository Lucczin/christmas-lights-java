import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LightsPanel extends JPanel {

    private int activeIndex = 0;
    private final int TOTAL = 7;
    private Timer timer;

    public LightsPanel() {
        setBackground(Color.BLACK);

        timer = new Timer(500, (ActionEvent e) -> {
            nextLight();
        });
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void setDelay(int delay) {
        timer.setDelay(delay);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int diameter = 50;
        int spacing = 20;

        for (int i = 0; i < TOTAL; i++) {
            if (i == activeIndex) {
                g.setColor(Color.YELLOW);
            } else {
                g.setColor(Color.GRAY);
            }

            int x = 50 + i * (diameter + spacing);
            int y = 100;

            g.fillOval(x, y, diameter, diameter);
        }
    }

    private void nextLight() {
        activeIndex = (activeIndex + 1) % TOTAL;
        repaint();
    }
}