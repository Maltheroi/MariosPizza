import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Historik {
    private Map<String, Integer> pizzaTælling = new HashMap<>();
    private final String FILNAVN = "historik.txt";

    public Historik() {
        læsFraFil();
    }

    public void tilføjAfsluttetOrdre(Ordrer ordre) {
        for (String pizza : ordre.getPizzaer()) {
            pizzaTælling.put(pizza, pizzaTælling.getOrDefault(pizza, 0) + 1);
        }
        gemTilFil();
    }

    private void gemTilFil() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILNAVN))) {
            pizzaTælling.entrySet().stream()
                    .sorted((a, b) -> b.getValue() - a.getValue())
                    .forEach(entry -> {
                        try {
                            bw.write(entry.getKey() + " - " + entry.getValue());
                            bw.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til historikfil: " + e.getMessage());
        }
    }

    private void læsFraFil() {
        File file = new File(FILNAVN);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILNAVN))) {
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
        try (BufferedReader br = new BufferedReader(new FileReader(FILNAVN))) {
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
