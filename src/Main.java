import java.util.List;
import java.util.Scanner;

public class Main {
    public static Historik historik = new Historik();

    public static void main(String[] args) {

        Bestilling bestilling = new Bestilling();
        List<Menu> pizzaMenu = Menu.laesPizzaFraMenu();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== Mario's Pizza Menu ===");
            for (int i = 0; i < pizzaMenu.size(); i++) {
                System.out.println((i + 1) + ". " + pizzaMenu.get(i).getNavn());
            }

            System.out.println("===== Aktive Ordrer =====");
            bestilling.printOrdreListe();
            System.out.println("===========================");
            System.out.println("1. Tilføj Bestilling");
            System.out.println("2. Fjern Afsluttet Ordre");
            System.out.println("3. Vis Historik");
            System.out.println("0. Afslut");
            System.out.print("Vælg: ");

            int valg = sc.nextInt();

            switch (valg) {
                case 1 -> bestilling.bestilling();
                case 2 -> bestilling.fjernOrdre();
                case 3 -> historik.printHistorikFraFil();
                case 0 -> {
                    System.out.println("SLUT");
                    return;
                }
                default -> System.out.println("Ugyldigt valg!");
            }
        }
    }
}
