package software.ulpgc.kata3;

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
    }
}
