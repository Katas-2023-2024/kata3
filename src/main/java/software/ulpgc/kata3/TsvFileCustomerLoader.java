package software.ulpgc.kata3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvFileCustomerLoader implements CustomerLoader{
    private final File file;

    public TsvFileCustomerLoader(File file) {
        this.file = file;
    }

    @Override
    public List<Customer> load() {
        try{
            return load(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Customer> load(FileReader reader) throws IOException{
        return load(new BufferedReader(reader));
    }

    private List<Customer> load(BufferedReader reader) throws IOException{
        reader.skip(1);
        List<Customer> customers = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if(line==null) return customers;
            customers.add(toCostumer(line));
        }
    }

    private Customer toCostumer(String line) {
        return toCostumer(line.split("\t"));
    }

    private Customer toCostumer(String[] fields) {
        return new Customer(
                fields[0],
                fields[1],
                fields[2],
                fields[3],
                fields[4],
                fields[5],
                fields[6],
                fields[7],
                fields[8],
                fields[9],
                fields[10]
        );
    }
}
