import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LightsPanel extends JPanel {

    private int activeIndex = 0;


    private LightCircle[] lights;


    private Timer timer;


    private int rows = 1;


    public LightsPanel() {

        setBackground(Color.BLACK);


        lights = new LightCircle[7];

        for (int i = 0; i < lights.length; i++) {

            lights[i] = new LightCircle(
                    Color.RED, // cor inicial
                    50,        // tamanho inicial
                    255        // intensidade inicial
            );
        }


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


    public void setRows(int rows) {
        this.rows = rows;
        repaint();
    }


    public void setLightColor(int index, Color color) {

        lights[index].setColor(color);

        repaint();
    }


    public void setLightIntensity(int index, int intensity) {

        lights[index].setIntensity(intensity);

        repaint();
    }


    public void setLightSize(int index, int size) {

        lights[index].setSize(size);

        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        int spacing = 20;


        for (int row = 0; row < rows; row++) {


            for (int i = 0; i < lights.length; i++) {

                LightCircle light = lights[i];

                int size = light.getSize();

                Color baseColor = light.getColor();


                if (i == activeIndex) {

                    int intensity = light.getIntensity();

                    int r = Math.min(
                            255,
                            baseColor.getRed() * intensity / 255
                    );

                    int gr = Math.min(
                            255,
                            baseColor.getGreen() * intensity / 255
                    );

                    int b = Math.min(
                            255,
                            baseColor.getBlue() * intensity / 255
                    );

                    g.setColor(new Color(r, gr, b));

                } else {


                    g.setColor(baseColor.darker());
                }

                int x = 50 + i * (size + spacing);

                int y = 50 + row * 100;

                g.fillOval(x, y, size, size);
            }
        }
    }


    private void nextLight() {

        activeIndex = (activeIndex + 1) % lights.length;

        repaint();
    }
}