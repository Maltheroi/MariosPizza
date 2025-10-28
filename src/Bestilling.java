import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Bestilling {
    private List<Ordrer> ordre = new ArrayList<>();
    private Ordrer ordrer;
    Scanner sc = new Scanner(System.in);

    public List<Ordrer> getOrdre()
    {
        return ordre;
    }

    public void printOrdreListe() {
        for (Ordrer o : ordre) {
            System.out.println(o);
        }
    }

    public void tilføjPizzaTilOrdre() {
        System.out.println("Pizza menu nr: ");
        List<Menu> pizzaMenu = Menu.laesPizzaFraMenu();
        int menuNr = sc.nextInt();

        if (menuNr >= 1 && menuNr <= pizzaMenu.size()){
            Menu pizzaBestilt = pizzaMenu.get(menuNr - 1);
            ordrer.addPizza(String.valueOf(pizzaBestilt));
        }
        else{
            System.out.println("Pizza Nummeret er ikke på menuen!");
        }
    }

    public void tilføjAfhentningTidsPunkt(){
        System.out.println("Afhentnings Tidspunkt: ");
        ordrer.setTime(sc.nextInt());
    }

    public void tilføjOrdre(){
        ordre.add(ordrer);
        System.out.println("Ordre gemt: " + ordrer);
    }

    public void bestilling(){
        int valg;

        ordrer = new Ordrer(ordre.size() + 1);

        do {
            tilføjPizzaTilOrdre();
            System.out.println("Tilføj Flere Pizzaer");
            System.out.println("1: Ja");
            System.out.println("2: Nej");
            System.out.print("valg: ");
            valg = sc.nextInt();
        } while (valg == 1);

        tilføjAfhentningTidsPunkt();
        tilføjOrdre();
    }
}
