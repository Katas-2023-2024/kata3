package software.ulpgc.kata3.swing;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;

import javax.swing.*;

public class JFreePanelHistogramDisplay extends JPanel implements HistogramDisplay {

    @Override
    public void show(Histogram histogram) {
        add(new ChartPanel(ChartOf(histogram)));
    }

    private JFreeChart ChartOf(Histogram histogram) {
        return ChartFactory.createHistogram(
                histogram.title(), histogram.xAxis(), histogram.yAxis(),
                dataset(histogram.data(), histogram.bins())
        );
    }

    private IntervalXYDataset dataset(double[] data, int bins) {
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("x", data, bins);
        return dataset;
    }
}
