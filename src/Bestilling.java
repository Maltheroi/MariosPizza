import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Bestilling {
    private List<Ordrer> ordre = new ArrayList<>();
    private Ordrer ordrer;
    Scanner sc = new Scanner(System.in);

    public void printOrdreListe() {
        if (ordre.isEmpty()) {
            System.out.println("Ingen aktive ordrer.");
            return;
        }
        for (Ordrer o : ordre) {
            System.out.println(o);
        }
    }

    public void tilføjPizzaTilOrdre() {
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

    public void tilføjAfhentningTidsPunkt() {
        System.out.println("Afhentnings Tidspunkt (fx 1830): ");
        ordrer.setTime(sc.nextInt());
    }

    public void tilføjOrdre() {
        ordre.add(ordrer);
        System.out.println("Ordre gemt: " + ordrer);
    }

    public void bestilling() {
        int valg;
        ordrer = new Ordrer();

        do {
            tilføjPizzaTilOrdre();
            System.out.println("Tilføj flere pizzaer? 1: Ja, 2: Nej");
            valg = sc.nextInt();
        } while (valg == 1);

        tilføjAfhentningTidsPunkt();
        tilføjOrdre();
    }

    public void fjernOrdre() {
        if (ordre.isEmpty()) {
            System.out.println("Ingen aktive ordrer at fjerne.");
            return;
        }

        printOrdreListe();
        System.out.print("Indtast ordre-ID, der skal fjernes: ");
        int id = sc.nextInt();

        Ordrer fundet = null;
        for (Ordrer o : ordre) {
            if (o.getId() == id) {
                fundet = o;
                break;
            }
        }

        if (fundet != null) {
            ordre.remove(fundet);
            System.out.println("Ordre fjernet: " + fundet);
            Main.historik.tilføjAfsluttetOrdre(fundet);
        } else {
            System.out.println("Ingen ordre med det ID.");
        }
    }
}
