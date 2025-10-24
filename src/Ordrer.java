import java.util.ArrayList;

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

    public String getOrdre(){
        return pizzaer+" "+time;
    }

}
