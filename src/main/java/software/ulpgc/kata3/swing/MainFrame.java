package software.ulpgc.kata3.swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private HistogramDisplay histogramDisplay;

    public MainFrame() throws HeadlessException{
        setTitle("Histogram");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200,900);
        setLocationRelativeTo(null);
        add(createHistogramDisplay());
    }

    public HistogramDisplay histogramDisplay() {
        return histogramDisplay;
    }

    private Component createHistogramDisplay() {
        JFreePanelHistogramDisplay display = new JFreePanelHistogramDisplay();
        histogramDisplay = display;
        return display;
    }
}
