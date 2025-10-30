import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Historik {
    private Map<String, Integer> pizzaTælling = new HashMap<>();  // Husker hvor mange hver pizza bliver nævnt i vores txt og tilføjer dem sammen. FX Margarita 5
    private final String filNavn = "historik.txt";

    public Historik() {
        læsFraFil();
    }
        // Hvis pizzaen ikke findes i listen, den bliver tilføjet med 0 +1. Hvis den findes allerede i listen, den tilføjer +1
    public void tilføjAfsluttetOrdre(Ordrer ordre) {
        for (String pizza : ordre.getPizzaer()) {
            pizzaTælling.put(pizza, pizzaTælling.getOrDefault(pizza, 0) + 1);
        }
        gemTilFil();
    }

    private void gemTilFil() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filNavn))) {

            pizzaTælling.entrySet().stream()    // EntrySet = Hent alle pizza-antal i par. Stream = Det gør det muligt at det ser pænt ud så kan man behandle dataen lettere
                    .sorted((a, b) -> b.getValue() - a.getValue())
                    .forEach(entry -> {
                        try {
                            bw.write(entry.getKey() + " - " + entry.getValue());
                            bw.newLine();
                        } catch (IOException e) {}
                    });
        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til historikfil: " + e.getMessage());
        }
    }

    private void læsFraFil() {
        File file = new File(filNavn);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(filNavn))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dele = line.split(" - ");
                if (dele.length == 2) {
                    String pizza = dele[0].trim();
                    int antal = Integer.parseInt(dele[1].trim());
                    pizzaTælling.put(pizza, antal);
                }
            }
        } catch (IOException e) {
            System.out.println("Fejl ved læsning af historikfil: " + e.getMessage());
        }
    }

    public void printHistorikFraFil() {
        try (BufferedReader br = new BufferedReader(new FileReader(filNavn))) {
            System.out.println("=== Historik (fra historik.txt) ===");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("===================================");
        } catch (IOException e) {
            System.out.println("Kunne ikke læse historik.txt: " + e.getMessage());
        }
    }
}
