package com.openlibrary;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class OpenCSVWriter {
    public static void main(String[] arg) throws IOException {
           File file=new File("E:\\BridgeLabz\\Intellj Projects\\Open_Source_Library\\object-list-sample.csv");
        try {
            FileWriter writer=new FileWriter(file);
            CSVWriter csvwriter = new CSVWriter(new FileWriter("E:\\BridgeLabz\\Intellj Projects\\Open_Source_Library\\object-list-sample.csv"));
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"Name", "email", "phno"});
            data.add(new String[]{"Riyaz", "er.riyaz@gmail.com", "1234356"});
            data.add(new String[]{"ahamed", "riyaz.ahamed", "123465"});
            csvwriter.writeAll(data);
            csvwriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }


        try {
            Reader reader = Files.newBufferedReader(Paths.get("E:\\BridgeLabz\\Intellj Projects\\Open_Source_Library\\object-list-sample.csv"));
            CsvToBean<CSVPojoClass> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVPojoClass.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVPojoClass> csviterator=csvToBean.iterator();
            while(csviterator.hasNext()){
                CSVPojoClass csvpojo=csviterator.next();
                System.out.println(csvpojo.getName()+" "+csvpojo.getEmail()+" "+csvpojo.getPhNo());
            }

        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

    }

}

