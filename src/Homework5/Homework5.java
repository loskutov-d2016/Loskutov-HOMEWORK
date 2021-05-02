package Homework5;

import java.io.FileWriter;

public class Homework5 {
    public static void main(String[] args) throws Exception
    {
        String csv = "TEST.csv";
        var writer = new CSVWriter(new FileWriter(csv));
        String [] record = "".split(";");
        writer.writeNext(record);
        writer.close();
    }
}