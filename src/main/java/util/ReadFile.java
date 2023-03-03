package util;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.util.*;

public class ReadFile {
    public static Map<String, Map<String, String>> getCSVData(char seperator, String FileName, int primaryKeyIndex)
            throws FileNotFoundException {
        Map<String, Map<String, String>> CSVData = new TreeMap<String, Map<String, String>>();
        Map<String, String> keyVals = null;
        Reader reader = new FileReader("/home/hoangkim/Downloads/input.csv");
        try {
            Iterator<Map<String, String>> iterator = new CsvMapper().readerFor(Map.class)
                    .with(CsvSchema.emptySchema().withHeader()
                            .withColumnSeparator(seperator).withoutQuoteChar()).readValues(reader);
            while (iterator.hasNext()) {
                keyVals = iterator.next();
                Object[] keys = keyVals.keySet().toArray();
                CSVData.put(keyVals.get(keys[primaryKeyIndex]), keyVals);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CSVData;
    }


    public static void main(String[] args) throws FileNotFoundException {
        List<String> phoneLst = new ArrayList<>();
        phoneLst.add("0985487100");
        phoneLst.add("01237006360");
        phoneLst.add("0964292107");
        phoneLst.add("01232038458");

        System.out.println("+++++++++++++++++++++Code For CSV Parser++++++++++++");
        Map<String, Map<String, String>> CSV = getCSVData(',', "ParseCsv", 0);
        for (String primaryKey : CSV.keySet()) {
            String phoneNumber = CSV.get(primaryKey).get("PHONE_NUMBER");
            System.out.println(phoneNumber);
            phoneLst.add("0" + phoneNumber);
//            if (phoneLst.size() > 100) {
//                break;
//            }
        }

        String pre = "/home/hoangkim/Projects/momo-backend-v3/sof/cronjob-after-payment/src/main/resources/input";
        int count = 0;
        int multi = 100000;
        while (multi * count < phoneLst.size()) {
            PrintWriter pr = new PrintWriter(pre + count + ".txt");
            List<String> sub = phoneLst.subList(count * multi, Math.min((count + 1) * multi, phoneLst.size() - 1));
            sub.add("0985487100");
            sub.add("01237006360");
            sub.add("0964292107");
            sub.add("01232038458");
            sub.forEach(phone -> pr.print(phone + ","));
            pr.close();
            count++;
        }
    }

}
