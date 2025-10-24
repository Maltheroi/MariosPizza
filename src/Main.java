import java.util.List;
public class Main {
    public static void main(String[] args) {

        List<Menu> pizzaMenu = Menu.laesPizzaFraMenu();

        System.out.println("=== Mario's Pizza Menu ===");


        for (int i = 0; i < pizzaMenu.size(); i++) {
            System.out.println((i + 1) + ". " + pizzaMenu.get(i).getNavn());
        }

        System.out.println("===========================");
    }
}