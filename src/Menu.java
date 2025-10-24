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


    public String toString() {
        return navn;
    }



    public static List<Menu> laesPizzaFraMenu() {

        String line = "";
        String menuFil = "menu.txt";
        List<Menu> menu = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(menuFil))) {
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                Menu pizza = new Menu(line);
                menu.add(pizza);

            }


        } catch (IOException e) {
            System.out.println("Fejl ved læsning af menu: " + e.getMessage());

        }
        return menu;

    }




}
