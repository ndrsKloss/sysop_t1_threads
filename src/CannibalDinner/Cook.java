package CannibalDinner;

public class Cook implements Runnable {
    private final Dish dish;

    Cook(Dish dish) {
        this.dish = dish;
    }

    @Override
    public void run() {
        while (true) { }
    }
}
