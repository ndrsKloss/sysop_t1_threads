package CannibalDinner;

public class Application {
    private static final int DEFAULT_NUM_CANNIBALS = 5;
    private static final int DEFAULT_NUM_SLICES = 5;
    private static final int EXEC_TIME = 30;

    public static void main(String[] args) throws InterruptedException {
        int id;
        Dish dish = new Dish(DEFAULT_NUM_SLICES);

        Cook cook = new Cook(dish, DEFAULT_NUM_SLICES);
        Thread threadCook = new Thread(cook);
        threadCook.start();

        for( id = 0; id < DEFAULT_NUM_CANNIBALS; id++ ) {
            Thread cannibal = new Thread(new Cannibal(dish, id, cook));
            cannibal.start();
        }

        Thread.sleep(EXEC_TIME * 1000);

        System.exit(0);
    }
}
