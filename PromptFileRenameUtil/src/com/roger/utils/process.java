package com.roger.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;


public class process {

    public static void main(String[] args) {

        String csvFile = "D://AssignedProjects//RootCSV//default.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] arr = line.split(cvsSplitBy);

                System.out.println("TF_Name = " + arr[0] + " , AEP_Name=" + arr[1]);
                File f1 = new File("D://AssignedProjects//RootCSV//input//" + arr[0]);
                File f2 = new File("D://AssignedProjects//RootCSV//output//" + arr[1]+".wav");
                copyFile(f1, f2);
            }
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
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new RandomAccessFile(sourceFile, "rw").getChannel();
            destination = new RandomAccessFile(destFile, "rw").getChannel();

            long position = 0;
            long count = source.size();

            source.transferTo(position, count, destination);

            System.out.println("Succesfully copied File " + destFile);
        } catch (Exception ex) {
            System.out.println("Failed to copy File ********** " + destFile);
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }
}