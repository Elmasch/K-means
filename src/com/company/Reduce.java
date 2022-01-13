package com.company;

import java.util.ArrayList;

public class Reduce {

    public static void barycentre(ArrayList<Point> bary, ArrayList<Point> tabDeBase){
        for(int i =0;i<bary.size();i++){
            double sommeX = 0;
            double sommeY = 0;
            int nbPoint = 0;
            for(int j =0; j< tabDeBase.size();j++){
                if(tabDeBase.get(j).getBarycentre().equals(bary.get(i))){
                    sommeX += tabDeBase.get(j).getX();
                    sommeY += tabDeBase.get(j).getY();
                    nbPoint++;
                }
            }
            sommeX /= nbPoint;
            sommeY /= nbPoint;
            bary.set(i,new Point(sommeX, sommeY));
        }
    }
}
