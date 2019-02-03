package edu.neu.csye6200.tractor;

import java.util.ArrayList;
import java.util.List;

public class TractorTest {

    public TractorTest() {

    }

    public static void main(String[] args) {
        Tractor trac1 = new Tractor("Allis Chalmers", "4W-220", "dfdfhsdj", 10, "fshfkhd", "dfjsdhfjh", 20.0);
        Tractor trac2 = new Tractor("John Deere", "40C", "sfd", 10, "dfsdf", "fdsfsdf", 40.0);
        Tractor trac3 = new Tractor("Ford", "8BR", "fsdf", 10, "dfsdf", "dfsf", 50.0);
        Tractor trac4 = new Tractor("Fiat", "513R", "dfsdf", 10, "dfsdfsdf", "dffdsfs", 30.0);
        Tractor trac5 = new Tractor("Kubota", "A-155", "fdsf", 10, "dfsdf", "dfsdfsdf", 12.0);
        System.out.println(trac1);

        List<Tractor> tractors = new ArrayList<>();
        tractors.add(trac1);
        tractors.add(trac2);
        tractors.add(trac3);
        tractors.add(trac4);
        tractors.add(trac5);
        for (Tractor tractor : tractors) {
            System.out.println(tractor);
            //System.out.println("the range for "+tractors.get()+ tractor.range());
        }
    }
}
