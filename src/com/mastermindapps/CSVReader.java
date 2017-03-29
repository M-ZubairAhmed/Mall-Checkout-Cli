package com.mastermindapps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class CSVReader {

    /**
     * Reads the csv file line by line. Each line is in turned split into elements based on comma.
     * All elements of single line stored in single index of string array. All such parsed lines are
     * inturn stored in to an array list.
     *
     * @param path takes the local address path of csv file.
     * @return the arraylist of string[] read from csv file, where individual index has one line.
     */
    ArrayList<String[]> readFromDisk(String path) {
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
            System.exit(0);
        } catch (IOException ioE) {
            System.out.println("Error! File cannot be read");
            System.exit(0);

        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                } else {
                    System.out.println("Error! File reader is not started");
                }
            } catch (IOException ioE) {
                System.out.println("Error! File reader cannot be closed");
                System.exit(0);

            }
        }
        return fileArray;
    }

    /**
     * This method takes individual element of the line and remove leading and trailing spaces. It also makes them into all caps for easy accessibility accross code. The cleaned elements are then placed back into string array and passed back. One of this method call corresponds to operation on single line parsed from csv file.
     *
     * @param line the individual line parsed by reader containing in its array are seperated words/element
     * @param size size of the line containing string elements.
     * @return string array corresponding to each line.
     */
    private String[] cleanElements(String[] line, int size) {
        String[] cleanedLine = new String[size];
        for (int i = 0; i < size; i++) {
            cleanedLine[i] = line[i].trim().toUpperCase();
        }
        return cleanedLine;
    }
}
