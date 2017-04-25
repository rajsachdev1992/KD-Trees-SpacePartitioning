/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is a utility class to create KML files for a list of crimes.
 */
public class KMLUtility {

    public static final String TOP = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
            + "<kml xmlns=\"http://earth.google.com/kml/2.2\">\n"
            + "<Document>\n"
            + "  <Style id=\"style1\">\n"
            + "  <IconStyle>\n"
            + "    <Icon>\n"
            + "      <href>http://maps.gstatic.com/intl/en_ALL/mapfiles/ms/micons/blue-dot.png</href>\n"
            + "    </Icon>\n"
            + "   </IconStyle>\n"
            + "   </Style>";
    public static final String PLACEMARK_ENTRY = "<Placemark>\n"
            + "     <name>{offense}</name>\n"
            + "     <description>{street}</description>\n"
            + "     <styleUrl>#style1</styleUrl>\n"
            + "     <Point>\n"
            + "       <coordinates>{longitude},{latitude},0.000000</coordinates>\n"
            + "      </Point>\n"
            + "    </Placemark>";
    public static final String BOTTOM = "</Document>\n"
            + "</kml>";
    
    /**
     * @param listOfCrimes
     * @return  String which contains all the content of the KML file.
     * Any case complexity: Theta(n)
     * Precondition: listOfCrimes should not be null.
     * Postcondition: A string which contains the content of listOfCrimes will be returned.
     */
    public static String createKMLContent(ListOfCrimes listOfCrimes) {
        CrimeRecord record;
        StringBuilder MID = new StringBuilder("");
        CrimeListNode cur = listOfCrimes.getHead();
        while (cur != null) {
            record = cur.getRecord();
            MID.append(PLACEMARK_ENTRY.replace("{offense}", record.getOffense()).
                    replace("{street}", record.getStreet()).
                    replace("{longitude}", record.getLongitude().toString()).
                    replace("{latitude}", record.getLatitude().toString()));
            cur = cur.getNext();
        }
        return TOP + MID.toString() + BOTTOM;
    }
    
    /**
     * This method creates the KML file from the content entered in the argument.
     * @param content of the KML file
     * PreCondition: content should not be null.
     * PostCondition: A KML file will be generated in the project folder.
     */
    public static void createKMLFile(String content) {
        try (PrintWriter fileOut = new PrintWriter("PGHCrimes.kml", "UTF-8")) {
            fileOut.print(content);
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(KMLUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
