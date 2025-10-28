import java.util.ArrayList;
import java.util.List;

public class Ordrer {

    private List<String> pizzaer;
    private int time;

    public Ordrer() {}

    public Ordrer(int time) {
        this.pizzaer = new ArrayList<>();
        this.time = time;
    }

    // Pizza metoder
    public void addPizza(String pizza) {
        pizzaer.add(pizza);
    }

    public List<String> getPizzaer() {
        return pizzaer;
    }

    public void setPizzaer(List<String> pizzaer) {
        this.pizzaer = pizzaer;
    }

    // Tids metoder
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    // 2 string for print
    @Override
    public String toString(){
        return "Pizzaer: " + pizzaer + ", Afhentningstid: " + time;
    }
}
