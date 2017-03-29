package com.mastermindapps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    /**
     * @param path takes the local address path of csv file.
     * @return the arraylist of string[] read from csv file, where individual index has one line.
     */
    protected ArrayList<String[]> readFromDisk(String path) {
        //Initialzing the arraylist to store read csv file.
        ArrayList<String[]> fileArray = new ArrayList<>();
        //Initializing bufferedreader to null also to increase its scope.
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while (((line = bufferedReader.readLine()) != null) && !line.isEmpty()) {
                String[] elements = line.split(",");

                fileArray.add(cleanElements(elements, elements.length));
            }
        } catch (FileNotFoundException fnfE) {
            System.out.println("Error! File cannot be found on disk");
        } catch (IOException ioE) {
            System.out.println("Error! File cannot be read");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                } else {
                    System.out.println("Error! File reader is not started");
                }
            } catch (IOException ioE) {
                System.out.println("Error! File reader cannot be closed");
            }
        }
        return fileArray;
    }
}
