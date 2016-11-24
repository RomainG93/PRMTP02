package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by Rom on 11/17/2016.
 */
public class FileParser {
    private File file;
    private HashMap<String, Integer> vector;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public HashMap<String, Integer> getVector() {
        return vector;
    }

    public void setVector(HashMap<String, Integer> vector) {
        this.vector = vector;
    }

    public FileParser(File file, HashMap<String, Integer> vector) {
        this.file = file;
        //HashMap<String, Integer> tmp = new HashMap<>();
        this.vector = new HashMap<String, Integer>(vector);
    }

    public void setVectorValue() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.getFile()));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine().toLowerCase();

            while (line != null) {
                for (String key : this.getVector().keySet()) {
                    if (line.contains(key)) this.getVector().put(key, this.getVector().get(key) + 1);
                }
                /*sb.append(line);
                sb.append(System.lineSeparator());*/
                line = br.readLine();
            }
            //String everything = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
            /*System.out.println(this.getFile().getName());
            System.out.println(this.getVector());*/
        }
    }
}
