import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Bestilling

{
    private List<Ordrer> ordre = new ArrayList<>();

    public void Bestilling()
    {
        List<Menu> pizzaMenu = Menu.laesPizzaFraMenu();
        // Denne her arraylist er hvor vi obevarer vores odre Marian

        boolean flereOdre = true;

        while (flereOdre) {
            System.out.println("Hvad er ordren?");
            Scanner sc = new Scanner(System.in);

            int ordreNr = sc.nextInt();
            System.out.println("Hvad tid skal den hentes?");
            int tid = sc.nextInt();

            if (ordreNr >= 1 && ordreNr <= pizzaMenu.size()) {

                Menu pizzaBestilt = pizzaMenu.get(ordreNr - 1);

                System.out.println(ordreNr + ". " + pizzaBestilt + " bestilt!");
                Ordrer ordrer = new Ordrer(pizzaBestilt.getNavn(), tid);
                ordre.add(ordrer);
            }

            // Hvis der ikke kan findes en Pizza
            else
            {
                System.out.println("Denne pizza er ikke på menuen");
            }

            // Om den skal køres igen Gutter
            System.out.println("Er der flere ordre?");
            System.out.println("0 for nej, 1 for ja");
            int jaNej = sc.nextInt();
            if (jaNej == 0)
                flereOdre = false;
        }
    }

    public List<Ordrer> getOrdre()
    {
        return ordre;
    }

    public void printOrdreListe() {
        for (Ordrer o : ordre) {
            System.out.println(o);
        }
    }
}
