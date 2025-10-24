import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ordrer {

    private String pizzaer;
    private int time;

    public Ordrer(String pizzaer, int time) {
        this.pizzaer = pizzaer;
        this.time = time;
    }

    public String getPizzaer() {
        return pizzaer;
    }

    public void setPizzaer(String pizzaer) {
        this.pizzaer = pizzaer;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString(){
        return "Pizzaer: " + pizzaer + ", Afhentningstid: " + time;
    }

}
