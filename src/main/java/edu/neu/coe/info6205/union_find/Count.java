package edu.neu.coe.info6205.union_find;

import java.util.HashSet;

public class Count {




    int countf;
    int countm;
    public void count(int n){

        UF_HWQUPC h = new UF_HWQUPC(n);

        int ri;
        int rj;

        HashSet<String> sites = new HashSet<String>();

        countf = 0;
        countm = 0;

        while(h.components()!=1){
            ri = (int)(Math.random()*n);
            rj = (int)(Math.random()*n);

            /* exclude duplicate pairs
            if (ri == rj)
                continue;
            String m = ri+"+"+rj;
            String k = rj+"+"+ri;
            if(sites.contains(m)||sites.contains(k))
                continue;
                sites.add(m);
             */







            if(!h.connected(ri,rj)){
                h.union(ri,rj);
                countf++;
            }
            countm ++;
        }



        //System.out.println(h.components());
        //System.out.println(countf);
        //System.out.println(countm);
    }

    public static void main(String args[]){
        double m = 0;

        for(int n = 1; n <= 100; n++) {
            for (int i = 0; i < 1000; i++) {
                Count x = new Count();
                x.count(100*n);
                m += x.countm;
            }
            m = m / 1000;

            System.out.println(m);
            m = 0;
        }

    }
}
