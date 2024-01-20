package software.ulpgc.kata3;

import software.ulpgc.kata3.swing.Histogram;
import software.ulpgc.kata3.swing.HistogramDisplay;
import software.ulpgc.kata3.swing.MainFrame;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CustomerLoader loader = new TsvFileCustomerLoader(new File("customers-10000.txt"));
        List<Customer> customers = loader.load();
        Map<String, Integer> chart = new HashMap<>();
        for (Customer customer : customers) {
            String country = customer.getCountry();
            chart.put(country, chart.getOrDefault(country, 0) + 1);
        }
        for (String key : chart.keySet()) {
            System.out.println(key + " : " + chart.get(key));
        }

        double[] data = chart.values().stream().mapToDouble(Integer::doubleValue).toArray();
        int bins = chart.size();
        Histogram histogram = new Histogram("Countries", "Number of Costumers", "Number of Countries", data, bins);
        MainFrame frame = new MainFrame();
        frame.histogramDisplay().show(histogram);
        frame.setVisible(true);
    }
}
