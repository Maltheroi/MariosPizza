import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Bestilling {
    private List<Ordrer> ordre = new ArrayList<>();
    private Ordrer ordrer;
    Scanner sc = new Scanner(System.in);

    public void printOrdreListe() { // En metode til at printe ordre listen HVIS der er en ordre
        if (ordre.isEmpty()) {
            System.out.println("Ingen aktive ordrer.");
            return;
        }
        for (Ordrer o : ordre) {
            System.out.println(o);
        }
    }

    public void tilføjPizzaTilOrdre() { // Metode til at tilføje HVIS den er inden for menues nummer
        System.out.println("Pizza menu nr: ");
        List<Menu> pizzaMenu = Menu.laesPizzaFraMenu();
        int menuNr = sc.nextInt();

        if (menuNr >= 1 && menuNr <= pizzaMenu.size()) {
            Menu pizzaBestilt = pizzaMenu.get(menuNr - 1);
            ordrer.addPizza(pizzaBestilt.getNavn());
        } else {
            System.out.println("Pizza Nummeret er ikke på menuen!");
        }
    }

    public void tilføjAfhentningTidsPunkt() { // Simple metoden til at sætte tiden
        System.out.println("Afhentnings Tidspunkt (fx 1830): ");
        ordrer.setTime(sc.nextInt());
    }

    public void tilføjOrdre() { // Metode til at tilføje en "Ordre" til ordre/aktiveordre liste
        ordre.add(ordrer);
        System.out.println("Ordre gemt: " + ordrer);
    }

    public void bestilling() { // Metoden til at køre vores forrige metoder. Det skal forstås som en slags interface
        int valg;
        ordrer = new Ordrer();

        do {
            tilføjPizzaTilOrdre();
            System.out.println("Tilføj flere pizzaer? 1 for Ja, 2 for Nej");
            valg = sc.nextInt();
        } while (valg == 1);

        tilføjAfhentningTidsPunkt();
        tilføjOrdre();
    }

    public void fjernOrdre() { // En metode til at fjerne ordre
        if (ordre.isEmpty()) { // tjekker om der er ordre
            System.out.println("Ingen aktive ordrer at fjerne.");
            return;
        }

        printOrdreListe(); // kalder på metoden til at printe ordre liste
        System.out.print("Indtast ordre-ID, der skal fjernes: ");
        int id = sc.nextInt();

        Ordrer fundet = null; // Her fra tjekker vi listen i gennem for vores inskrevet nummer og ser om det findes
        for (Ordrer o : ordre) {
            if (o.getId() == id) {
                fundet = o;
                break;
            }
        }

        if (fundet != null) { // Hvis det findes vil *fundet* ikke være lig med "null" og så vil den kører det her
            ordre.remove(fundet);
            System.out.println("Ordre fjernet: " + fundet);
            Main.historik.tilføjAfsluttetOrdre(fundet);
        } else { // hvis fundet er lig med "null" kører den der her
            System.out.println("Ingen ordre med det ID.");
        }
    }
}
