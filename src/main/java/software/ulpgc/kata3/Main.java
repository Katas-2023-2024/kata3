package software.ulpgc.kata3;

import software.ulpgc.kata3.swing.Histogram;
import software.ulpgc.kata3.swing.MainFrame;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Customer> customers = loadCustomers("customers-10000.txt");
        Map<String, Integer> chart = buildCountryChart(customers);
        printSortedChart(chart);
        displayHistogram(chart);
    }

    private static List<Customer> loadCustomers(String fileName) {
        CustomerLoader loader = new TsvFileCustomerLoader(new File(fileName));
        return loader.load();
    }

    private static Map<String, Integer> buildCountryChart(List<Customer> customers) {
        Map<String, Integer> chart = new HashMap<>();
        for (Customer customer : customers) {
            String country = customer.getCountry();
            chart.put(country, chart.getOrDefault(country, 0) + 1);
        }
        return chart;
    }

    private static void printSortedChart(Map<String, Integer> chart) {
        chart.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }

    private static void displayHistogram(Map<String, Integer> chart) {
        double[] data = chart.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .mapToDouble(Map.Entry::getValue)
                .toArray();
        int bins = chart.size();
        Histogram histogram = new Histogram("Countries", "Number of Customers", "Number of Countries", data, bins);
        MainFrame frame = new MainFrame();
        frame.histogramDisplay().show(histogram);
        frame.setVisible(true);
    }
}
