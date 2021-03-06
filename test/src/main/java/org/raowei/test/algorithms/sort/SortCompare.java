package org.raowei.test.algorithms.sort;


import org.raowei.test.algorithms.util.StdOut;
import org.raowei.test.algorithms.util.StdRandom;

/**
 * Created by terryrao on 2016/4/2.
 */
public class SortCompare {
    public static long time(String alg,Double[] a) {
        long start = System.currentTimeMillis();
        if (alg.equals("Insertion")) Sort.insertionSort(a);
        if (alg.equals("Selection")) Sort.selectSort(a);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static double timeRandomInput(String alg,int N,int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(alg,a);
        }
        return total;

    }



    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1,N,T);
        double t2 = timeRandomInput(alg2,N,T);

        StdOut.printf("For %d random Doubles \n %s is ",N, alg1);
        StdOut.printf(" %.1f times faster than %s\n",t2/t1,alg2);
    }
}

