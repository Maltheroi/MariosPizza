import java.util.ArrayList;
import java.util.List;

public class Ordrer {

    private static int næsteId = 1;
    private List<String> pizzaer; // Tilføje en list til at have mere end en pizza
    private int time;
    private int id;

    public Ordrer() { // Constructer
        this.id = næsteId++;
        this.pizzaer = new ArrayList<>();
    }

    public void addPizza(String pizza) { // Metode til at tilføje pizza
        pizzaer.add(pizza);
    }

    public List<String> getPizzaer() { // Getter Method: Det er til at få vores pizzaer
        return pizzaer;
    }

    public void setTime(int time) { // det er hvordan vi sætter vores tid
        this.time = time;
    }

    public int getId() { // Getter Method
        return id;
    }

    @Override
    public String toString() { //To String så vi får noget læsbart retuneret
        int timer = time / 100;
        int minutter = time % 100;
        String tid = (timer + ":" + minutter);
        return "Ordre #" + id + " | Pizzaer: " + pizzaer + " | Afhentningstid: " + tid;
    }
}
