import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bestilling bestilling = new Bestilling(); // Objekt fra bestillings klasse - André
        List<Menu> pizzaMenu = Menu.laesPizzaFraMenu(); // liste - André
        Scanner sc = new Scanner(System.in);

        while (true)
        {
        System.out.println("=== Mario's Pizza Menu ===");

        for (int i = 0; i < pizzaMenu.size(); i++) {
            System.out.println((i + 1) + ". " + pizzaMenu.get(i).getNavn());
        }

        System.out.println("===== Aktive Ordre =====");
        bestilling.printOrdreListe();
        System.out.println("===========================");
        System.out.println("1. Tilføj Bestilling");
        System.out.println("2. Opdater Aktive Ordre");
        System.out.println("0. Afslut");
        System.out.print("Vælg: ");

        int valg = sc.nextInt();

        if  (valg == 1)
            bestilling.bestilling();
        if  (valg == 0)
            break;
        }
    }
}