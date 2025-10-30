import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String navn;

    public Menu(String navn) { // Constructer
        this.navn = navn;
    }

    public String getNavn() { // Getter Method
        return navn;
    }

    @Override
    public String toString() { // To String overrride
        return navn;
    }

    public static List<Menu> laesPizzaFraMenu() {
        List<Menu> menu = new ArrayList<>(); // Oprette en NY! arraylist
        String menuFil = "menu.txt"; // oprette et string til menu

        try (BufferedReader br = new BufferedReader(new FileReader(menuFil))) { // Indføre buffer reader til brug
            String line; // opretter hjælpe variable til linje seperaring
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    menu.add(new Menu(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Fejl ved læsning af menu: " + e.getMessage()); // Catch skal være der hvis der er try, men vi skal ikke forklare det
        }

        return menu; // return :D
    }
}
