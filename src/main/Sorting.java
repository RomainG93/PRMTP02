package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Rom on 11/17/2016.
 */
public class Sorting {

    private static HashMap<String, Integer> emptyVector = new HashMap<>();
    private static HashMap<String, FileParser> fileList = new HashMap<>();

    public static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            //System.out.println(fileEntry.getName());
            FileParser fp = new FileParser(fileEntry, emptyVector);
            fileList.put(fileEntry.getName(), fp);
            try {
                fp.setVectorValue();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void calculate(Analysis analysis) {
        for (FileParser value : fileList.values()) {
            System.out.println(value.getFile().getName());
            //System.out.println(value.getVector());
            boolean result = analysis.calculScalaire(value.getVector());
            if(result){
                System.out.println("OK");
            }else{
                System.out.println("KO");
            }
        }
    }

    public static void main(String[] args) {
        emptyVector.put("Java", 0);
        emptyVector.put("offre", 0);

        final File folder = new File("data");
        listFilesForFolder(folder);
        Analysis analysis = new Analysis();
        calculate(analysis);
    }
}
