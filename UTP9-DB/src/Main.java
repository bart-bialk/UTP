/**
 *
 *  @author Białkowski Bartłomiej S27335
 *
 */


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        File dataDir = new File("data");
        TravelData travelData = new TravelData(dataDir);
        String dateFormat = "yyyy-MM-dd";
        for (String locale : Arrays.asList("pl_PL", "en_GB")) {
            List<String> odlist = travelData.getOffersDescriptionsList(locale, dateFormat);
            for (String od : odlist) System.out.println(od);
        }
        // --- część bazodanowa
        String url = "jdbc:mysql://root@localhost:3306/utpdatabase";
        Database db = new Database(url, travelData);
        db.create();
        db.showGui();
    }

}

