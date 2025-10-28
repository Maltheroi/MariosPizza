import java.util.ArrayList;
import java.util.List;

public class Ordrer {

    private static int næsteId = 1;
    private List<String> pizzaer;
    private int time;
    private int id;

    public Ordrer() {
        this.id = næsteId++;
        this.pizzaer = new ArrayList<>();
    }

    public Ordrer(int id) {
        this.id = id;
        this.pizzaer = new ArrayList<>();
        if (id >= næsteId) næsteId = id + 1;
    }

    public void addPizza(String pizza) {
        pizzaer.add(pizza);
    }

    public List<String> getPizzaer() {
        return pizzaer;
    }

    public void setPizzaer(List<String> pizzaer) {
        this.pizzaer = pizzaer;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        int timer = time / 100;
        int minutter = time % 100;
        String tid = String.format("%02d:%02d", timer, minutter);
        return "Ordre #" + id + " | Pizzaer: " + pizzaer + " | Afhentningstid: " + tid;
    }
}
