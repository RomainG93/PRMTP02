package main;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Rom on 11/24/2016.
 */
public class Analysis {
    private HashMap<String, Integer> defaultVector = new HashMap<>();

    public boolean calculScalaire(HashMap<String, Integer> v1){
        Iterator it = defaultVector.entrySet().iterator();
        int scal = 0;
        double norme = 0.00;
        double norme0 = 0.00;
        double norme1 = 0.00;
        double cos = 0.00;
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            v1.get(pair.getKey());
            System.out.println("V1: " + v1.get(pair.getKey()));
            scal += ((Integer)pair.getValue() * (Integer)v1.get(pair.getKey()));
            norme0 += (Integer)pair.getValue() * (Integer)pair.getValue();
            norme1 += ((Integer)v1.get(pair.getKey()) * (Integer)v1.get(pair.getKey()));
        }
        System.out.println("n0: " + norme0);
        System.out.println("n1: " + norme1);
        if(norme0 != 0.00 && norme1 != 0.00){
            norme = Math.sqrt(norme0) * Math.sqrt(norme1);
            cos = (double)scal / norme;
        }


        System.out.println("cos: " + cos);

        if(cos < 0.8){
            return false;
        }else{
            Iterator it2 = defaultVector.entrySet().iterator();
            while (it2.hasNext()) {
                HashMap.Entry pair = (HashMap.Entry)it2.next();
                System.out.println(pair.getKey() + " = " + pair.getValue());
                v1.get(pair.getKey());
                int val = Math.round (((Integer)pair.getValue() + (Integer)v1.get(pair.getKey())) / 2);
                System.out.println("val: " + val);
                defaultVector.put((String)pair.getKey(), val);
            }
            System.out.println(("New vecteur: " + defaultVector));
            return true;
        }
    }

    public Analysis() {
        defaultVector.put("Java", 0);
        defaultVector.put("offre", 1);
    }
}
