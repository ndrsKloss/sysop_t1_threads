package CannibalDinner;

public class Cannibal implements Runnable {
    private final Dish dish;
    private final int id;

    Cannibal(Dish dish, int id) {
        this.dish = dish;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) { }
    }
}
