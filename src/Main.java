import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sql.CrudRepository;
import sql.DatabaseConnection;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        // Create a database connection
        DatabaseConnection databaseConnection = new DatabaseConnection("localhost", "recycoil", "allan", "etherion");
        Connection connection = databaseConnection.getConnection();
    
        // Create a CrudRepository instance
        CrudRepository repository = new CrudRepository(connection);
    
        // Read all records from the Poste table
        List<Map<String, Object>> postes = repository.read("Poste");
        System.out.println("Postes in the database:");
        for (Map<String, Object> row : postes) {
            System.out.println(row);
        }
    
        // Read all records from the Personnel table
        List<Map<String, Object>> personnel = repository.read("personnel");
        System.out.println("\nPersonnel in the database:");
        for (Map<String, Object> row : personnel) {
            System.out.println(row);
        }
    
       
    
        // Read all records from the motif table
        List<Map<String, Object>> motifs = repository.read("motif");
        System.out.println("\nMotifs in the database:");
        for (Map<String, Object> row : motifs) {
            System.out.println(row);
        }
    
   
       
    
        // Read all records from the absence table
        List<Map<String, Object>> absences = repository.read("absence");
        System.out.println("\nAbsences in the database:");
        for (Map<String, Object> row : absences) {
            System.out.println(row);
        }
/* ito rah anao where */
    
       List<Map<String, Object>> personn = repository.readWhere("Personnel", "salaire > 2000");
       System.out.println("select specific:");
       for (Map<String, Object> row : personn) {
        System.out.println(row);
       }
       
/* ito rah anao insert */
        // // Create a new record in the Personnel table
        // Map<String, Object> newPersonnel = new HashMap<>();
        // newPersonnel.put("id_Poste", 11); // Assuming there is a Poste with id 11
        // newPersonnel.put("nom", "Rakotomalala");
        // newPersonnel.put("prenom", "Andry");
        // newPersonnel.put("email", "andry.rakotomalala@recycle-huile.mg");
        // newPersonnel.put("date_embauche", new Date(123, 0, 15, 9, 0, 0)); // January 15, 2023, at 9:00 AM
        // newPersonnel.put("salaire", 2500.0);
        // newPersonnel.put("addresse", "789 Rue des Plantes");
        // newPersonnel.put("numero_telephone", "0321654789");
        // newPersonnel.put("date_naissance", new Date(90, 2, 20, 0, 0, 0)); // March 20, 1990, at 12:00 AM
        // repository.create("Personnel", newPersonnel);

        // // Create a new record in the Motif table
        // Map<String, Object> newMotif = new HashMap<>();
        // newMotif.put("motif", "Congé pour événement familial");
        // repository.create("Motif", newMotif);

        // // Create a new record in the Absence table
        // Map<String, Object> newAbsence = new HashMap<>();
        // newAbsence.put("id_Personnel", 6); // Assuming there is a Personnel with id 6
        // newAbsence.put("Date_Absence", new Date(124, 7, 20, 0, 0, 0)); // August 20, 2024, at 12:00 AM
        // newAbsence.put("id_Motif", 30); // Assuming there is a Motif with id 30
        // repository.create("Absence", newAbsence);

      
        // Disconnect from the database
        databaseConnection.disconnect();
    }   
}