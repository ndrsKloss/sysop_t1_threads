package CannibalDinner;

public class Cook implements Runnable {
    private final Dish dish;
    private final int slices;

    Cook(Dish dish, int slices) {
        this.dish = dish;
        this.slices = slices;
    }

    @Override
    public synchronized void run() {

        while ( true ) {

            synchronized (dish) {
                while ( dish.getSlices() == slices ) {
                    try {

                        System.out.println(new StringBuilder("Dish is full,")
                                .append(" Cook is waiting")
                                .append(" for the Cannibals to eat.")
                                .toString());

                        dish.wait();
                    } catch ( InterruptedException e ) {
                        e.printStackTrace();
                    }
                }

                dish.serveDishes();
                dish.notifyAll();
            }
        }
    }
}
