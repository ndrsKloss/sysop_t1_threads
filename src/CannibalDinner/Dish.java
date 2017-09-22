package CannibalDinner;

import java.util.concurrent.Semaphore;

public class Dish {

    private int slices;
    private int TOTAL_SLICES;

    Dish(int slices) {
        this.TOTAL_SLICES = slices;
        this.slices = slices;
    }

    public int getSlices() {
        return slices;
    }

    public synchronized boolean serve(int id) {
        if ( this.slices > 0 ) {
            this.slices -= 1;

            System.out.println(new StringBuilder("Cannibal ").append(id).append(" served itself.").toString());

            return true;
        } else {
            return false;
        }
    }

    public void serveDishes() {
        this.slices = this.TOTAL_SLICES;
        System.out.println(new StringBuilder("Cook ").append("put the dishes.").toString());
    }
}
