package com.company.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ashish-mathur on 5/3/17.
 */
public class InputFileReader {

    private String mFilePath;

    public InputFileReader(String filePath) {
        mFilePath = filePath;
    }

    public String[] getInputArray() {
        BufferedReader br = null;
        final String delimiter = ",";
        String input = "";
        String[] inputArr = null;

        try {
            br = new BufferedReader(new FileReader(mFilePath));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length()-1);

            input = sb.toString();
            inputArr = input.split(delimiter);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return inputArr;
    }
}
