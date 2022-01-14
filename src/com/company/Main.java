package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends JPanel{

    public static ArrayList<Point> PremiereListe(int nb){
        ArrayList<Point> Tab = new ArrayList<Point>();
        double x = 0.0;
        double y = 0.0;
        for(int  i = 0; i<nb; i++){
             x = ThreadLocalRandom.current().nextDouble(0, 70 + 1);
             y = ThreadLocalRandom.current().nextDouble(0, 70 + 1);
            Point p1 = new Point(x,y);
            Tab.add(p1);
        }
        return Tab;
    }

    public static ArrayList<Point> PremierBarycentre(int nb){
        ArrayList<Point> bary = new ArrayList<Point>();
        for(int i = 0; i< nb; i++){
            double x = ThreadLocalRandom.current().nextDouble(0, 70 + 1);
            double y = ThreadLocalRandom.current().nextDouble(0, 70 + 1);
            Point p = new Point(x,y);
            bary.add(p);
        }
        return bary;
    }

    public void paint(Graphics g){
        //super.paint(g);  //fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;
        /*
        Scanner scan = new Scanner(System.in);
        System.out.println("Combien de point centrale?");
        int nbBary = scan.nextInt();
        System.out.println("Combien de point?");
        int nbTab = scan.nextInt();
        System.out.println("Combien de point Répétition de boucle?");
        int nbBoucle = scan.nextInt();
        */
        int nbBary = 5;
        int nbTab = 2000;
        int nbBoucle = 1000;
        ArrayList<Point> bary = PremierBarycentre(nbBary);
        ArrayList<Point> tabDeBase = PremiereListe(nbTab);

        for(int i =0; i< nbBoucle;i++) {
            Map.mapper(bary, tabDeBase);
            Reduce.barycentre(bary, tabDeBase);
        }

        for(int i = 0; i< bary.size();i++){
            int r = ThreadLocalRandom.current().nextInt(0, 254 + 1);
            int v = ThreadLocalRandom.current().nextInt(0, 254 + 1);
            int b = ThreadLocalRandom.current().nextInt(0, 254 + 1);
            Color test = new Color(r,v,b);
            for(int j = 0; j< tabDeBase.size();j++) {
                if (tabDeBase.get(j).getBarycentre().equals(bary.get(i))) {
                    g2.setColor(test);
                    Ellipse2D.Double e1 = new Ellipse2D.Double(tabDeBase.get(j).getX() * 10, tabDeBase.get(j).getY() * 10, 10, 10);
                    g2.fill(e1);
                }
            }
            g2.setColor(Color.BLACK);
            Ellipse2D.Double e = new Ellipse2D.Double(bary.get(i).getX()*10, bary.get(i).getY()*10,10,10);
            g2.fill(e);
        }
    }

    public static void main(String[] args) {
            JFrame f = new JFrame();
            f.add(new Main());
            f.setSize(800,800);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLocation(200,200);
            f.setVisible(true);
        }
    }



