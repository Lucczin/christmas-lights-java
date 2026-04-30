import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        setTitle("Chrismas Lights");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        LightsPanel panel = new LightsPanel();

        JButton startBtn = new JButton("Start");
        JButton stopBtn = new JButton("Stop");

        JSlider speedSlider = new JSlider(100, 1000, 500);
        speedSlider.setMajorTickSpacing(300);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);

        startBtn.addActionListener(e -> panel.start());
        stopBtn.addActionListener(e ->panel.stop());

        speedSlider.addChangeListener(e ->{
            panel.setDelay(speedSlider.getValue());
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(startBtn);
        controlPanel.add(stopBtn);
        controlPanel.add(new JLabel("Velocidade"));
        controlPanel.add(speedSlider);

        add(panel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);

    }

}
