import java.util.List;
import java.util.Scanner;

public class Bestilling
{
    public static void Bestilling()
    {
        List<Menu> pizzaMenu = Menu.laesPizzaFraMenu();
        do {
            System.out.println("Hvad er ordren?");
            Scanner sc = new Scanner(System.in);
            int ordreNr = sc.nextInt();

            if (ordreNr >= 1 && ordreNr <= pizzaMenu.size()) {
                Menu pizzaBestilt = pizzaMenu.get(ordreNr - 1);
                System.out.println(ordreNr + ". " + pizzaBestilt + " bestilt!");
            } else {
                System.out.println("Denne pizza er ikke på menuen");
            }

        } while (true);
    }

}
