package CannibalDinner;

public class Cannibal implements Runnable {

    private final Cook cook;
    private final Dish dish;
    private final int id;

    Cannibal(Dish dish, int id, Cook cook) {
        this.dish = dish;
        this.id = id;
        this.cook = cook;
    }

    @Override
    public synchronized void run() {

        while ( true ) {
            synchronized (dish) {
                while ( !this.dish.serve(id) ) {

                    System.out.println(new StringBuilder("Dish is empty,")
                            .append(" Cannibals are waiting")
                            .append(" for the Cook to put dishes.")
                            .toString());

                    try {
                        dish.wait();
                    } catch ( InterruptedException e ) {
                        e.printStackTrace();
                    }
                }

                dish.notifyAll();
            }
        }
    }
}
