import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;



public class Historik{
    private static final String FILNAVN = "Historik.txt";

    public void tilfoejHistorik(List<Ordrer> ordreListe){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILNAVN, true))){

            for (Ordrer o : ordreListe) {
                writer.write(o.toString());
                writer.newLine();
            }
            System.out.println("Historik opdateret med " + ordreListe.size() + " afsluttede ordre(r).");
        } catch (IOException e){

            System.out.println("Fejl ved skrivning i historik: " + e.getMessage());

        }



    }

    public void visHistorik() {

        System.out.println()

    }



}