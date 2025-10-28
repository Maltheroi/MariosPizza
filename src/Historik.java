import java.io.*;
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

    public static void visHistorik() {

    System.out.println("Historik fra " + FILNAVN + " " );

    try(BufferedReader reader = new BufferedReader(new FileReader(FILNAVN))) {

        String line;

        boolean empty = true;
        while ((line = reader.readLine()) != null) {

            System.out.println(line);
            empty = false;

        }
        if (empty) {

            System.out.println("Ingen afsluttede ordre endnu");
        }
}   catch (IOException e){
        System.out.println("fejl ved læsning af historik" + e.getMessage());

    }

    }
}