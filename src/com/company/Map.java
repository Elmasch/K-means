package com.company;

import java.util.ArrayList;

public class Map {

    public static void mapper(ArrayList<Point> bary, ArrayList<Point> tab){
        double distance  = 100000;
        for(int i = 0;i < tab.size();i++){
            distance  = 100000;
            for(int j = 0 ;j<bary.size();j++){
                if (distance > tab.get(i).distance(bary.get(j))){
                    distance = tab.get(i).distance(bary.get(j));
                    tab.get(i).setBarycentre(bary.get(j));
                }
            }
        }
    }

}
