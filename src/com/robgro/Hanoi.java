package com.robgro;

public class Hanoi {

    public static int hanoi(int size, int initialPlace, int finalPlace) {
        if (size == 1) {
            System.out.println("[element 1] from " + initialPlace + " move to " + finalPlace);
            return 1;
        }
        int totalMoves = 0;
        // if initialPlace = 1, finalPlace = 2 ==> temporaryPlace = 3, all together = 6
        int temporaryPlace = 6 - finalPlace - initialPlace;
        totalMoves += hanoi(size - 1, initialPlace, temporaryPlace);
        System.out.println("[element " + size + "] from " + initialPlace + " move to " + finalPlace);
        totalMoves++;
        totalMoves += hanoi(size - 1, temporaryPlace, finalPlace);
        return totalMoves;
    }

    public static void main(String[] args) {

        // how long does it take ?
        long start = System.nanoTime();

        // main method
        int totalMoves = hanoi(5,1,2);
        System.out.println("total moves = " + totalMoves);

        long elapsed = System.nanoTime() - start;
        System.out.println("Hanoi's Tower estimates solution took " + elapsed + " CPU nano ticks");

    }
}

/*
*** description ***
size ==> quantity of elements to move
initialPlace ==> place where we start (1st stick)
finalPlace ==> final number of stick (I use here stick no.2)
temporaryPlace ==> that my temporary stick (here is number 3)
 */