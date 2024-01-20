package software.ulpgc.kata3.swing;

import javax.swing.*;

public class JFreePanelHistogramDisplay extends JPanel implements HistogramDisplay {

    @Override
    public void show(Histogram histogram) {
        add(new ChartPanel(ChartOf(histogram)));
    }
}
