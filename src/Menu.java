import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String navn;

    public Menu(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return navn;
    }

    public static List<Menu> laesPizzaFraMenu() {
        List<Menu> menu = new ArrayList<>();
        String menuFil = "menu.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(menuFil))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    menu.add(new Menu(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Fejl ved læsning af menu: " + e.getMessage());
        }

        return menu;
    }
}
