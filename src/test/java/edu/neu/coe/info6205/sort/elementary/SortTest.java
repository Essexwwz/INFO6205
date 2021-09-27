package edu.neu.coe.info6205.sort.elementary;
import edu.neu.coe.info6205.sort.*;
import edu.neu.coe.info6205.util.*;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
public class SortTest {

    public static void main(String[] args)throws Exception{
    test1();
    test2();
    test3();
    test4();
    }
    //random

    public static void test1() throws Exception {
        BaseHelper<Integer> helper = new BaseHelper<>("InsertionSort", 5, Config.load(InsertionSortTest.class));
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(5);

        final Integer[] xs = list.toArray(new Integer[0]);
        sorting(helper, xs);
    }
    //ordered
    public static void test2() throws Exception {
        BaseHelper<Integer> helper = new BaseHelper<>("InsertionSort", 5, Config.load(InsertionSortTest.class));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        final Integer[] xs = list.toArray(new Integer[0]);
        sorting(helper, xs);
    }
   //partially-ordered
    public static void test3() throws Exception {
        BaseHelper<Integer> helper = new BaseHelper<>("InsertionSort", 5, Config.load(InsertionSortTest.class));
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(5);

        final Integer[] xs = list.toArray(new Integer[0]);
        sorting(helper, xs);
    }
 //reverse-ordered
    public static void test4() throws Exception {
        BaseHelper<Integer> helper = new BaseHelper<>("InsertionSort", 5, Config.load(InsertionSortTest.class));
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        final Integer[] xs = list.toArray(new Integer[0]);
        sorting(helper, xs);
    }
    public static void sorting(BaseHelper<Integer> helper , Integer[] xs) throws Exception {


        GenericSort<Integer> sorter = new InsertionSort<Integer>(helper);

        int n =1000;
        for(int i = 1; i <7; i++) {
            final Timer timer = new Timer();

            final double mean = timer.repeat(n, () -> {

                Integer[] ys = sorter.sort(xs);

                return null;
            });

            System.out.println(mean*1e6);



            n = n+n;
        }
        System.out.println("XXXXXXXXXXXXXXXXX");
        Integer[] ys = sorter.sort(xs);
        assertTrue(helper.sorted(ys));
    }

}
