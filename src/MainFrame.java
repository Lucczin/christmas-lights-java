import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Christmas Lights");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        LightsPanel panel = new LightsPanel();


        JButton startBtn = new JButton("Start");
        JButton stopBtn = new JButton("Stop");


        JSlider speedSlider = new JSlider(100, 1000, 500);


        String[] options = {
                "Bolinha 1",
                "Bolinha 2",
                "Bolinha 3",
                "Bolinha 4",
                "Bolinha 5",
                "Bolinha 6",
                "Bolinha 7"
        };

        JComboBox<String> lightSelector =
                new JComboBox<>(options);


        JButton colorButton =
                new JButton("Escolher Cor");


        JSlider intensitySlider =
                new JSlider(50, 255, 255);


        JSlider sizeSlider =
                new JSlider(20, 100, 50);


        JSlider rowSlider =
                new JSlider(1, 7, 1);


        startBtn.addActionListener(e -> {
            panel.start();
        });


        stopBtn.addActionListener(e -> {
            panel.stop();
        });


        speedSlider.addChangeListener(e -> {
            panel.setDelay(speedSlider.getValue());
        });


        colorButton.addActionListener(e -> {

            int selected =
                    lightSelector.getSelectedIndex();

            Color color =
                    JColorChooser.showDialog(
                            this,
                            "Escolha uma cor",
                            Color.WHITE
                    );

            if (color != null) {
                panel.setLightColor(selected, color);
            }
        });


        intensitySlider.addChangeListener(e -> {

            int selected =
                    lightSelector.getSelectedIndex();

            panel.setLightIntensity(
                    selected,
                    intensitySlider.getValue()
            );
        });


        sizeSlider.addChangeListener(e -> {

            int selected =
                    lightSelector.getSelectedIndex();

            panel.setLightSize(
                    selected,
                    sizeSlider.getValue()
            );
        });


        rowSlider.addChangeListener(e -> {
            panel.setRows(rowSlider.getValue());
        });


        JPanel controlPanel = new JPanel();

        controlPanel.add(startBtn);
        controlPanel.add(stopBtn);

        controlPanel.add(new JLabel("Velocidade"));
        controlPanel.add(speedSlider);

        controlPanel.add(lightSelector);

        controlPanel.add(colorButton);

        controlPanel.add(new JLabel("Intensidade"));
        controlPanel.add(intensitySlider);

        controlPanel.add(new JLabel("Tamanho"));
        controlPanel.add(sizeSlider);

        controlPanel.add(new JLabel("Linhas"));
        controlPanel.add(rowSlider);

        add(panel, BorderLayout.CENTER);

        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}