package JavaXMLreadSAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySAXParser {

    public void parseXML(String FILENAME, ListPlants listPlants){
        SAXParser saxParser;
        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser();
            String fullPath = System.getProperty("user.dir") + File.separator+ FILENAME;

            DefaultHandler handler = new DefaultHandler() {

                boolean commonName = false;
                boolean botanicalName = false;
                boolean zoneName = false;
                boolean lightName = false;
                boolean priceName = false;
                boolean availabilityName = false;

                @Override
                public void startElement(String uri, String localName,
                                         String qName, Attributes attributes)
                        throws SAXException {

//                    System.out.println("Начало элемента: " + qName);
                    if (qName.equalsIgnoreCase("COMMON")) {
                        commonName = true;
                    }
                    if (qName.equalsIgnoreCase("BOTANICAL")) {
                        botanicalName = true;
                    }
                    if (qName.equalsIgnoreCase("ZONE")) {
                        zoneName = true;
                    }
                    if (qName.equalsIgnoreCase("LIGHT")) {
                        lightName = true;
                    }
                    if (qName.equalsIgnoreCase("PRICE")) {
                        priceName = true;
                    }
                    if (qName.equalsIgnoreCase("AVAILABILITY")) {
                        availabilityName = true;
                    }
                }

                @Override
                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {
//                    System.out.println("Конец элемента: " + qName);
                }

                String common = "";
                String botanical = "";
                String zone = "";
                String light = "";
                String price = "";
                String availability = "";

                @Override
                public void characters(char ch[], int start,
                                       int length) throws SAXException {
                    if (commonName) {
                        common = new String(ch, start, length);
                        commonName = false;
                    }
                    if (botanicalName) {
                        botanical = new String(ch, start, length);
                        botanicalName = false;
                    }
                    if (zoneName) {
                        zone = new String(ch, start, length);
                        zoneName = false;
                    }
                    if (lightName) {
                        light = new String(ch, start, length);
                        lightName = false;
                    }
                    if (priceName) {
                        price = new String(ch, start, length);
                        Matcher m = Pattern.compile("[$]([\\d.]+)").matcher(price);
                        m.matches();
                        price = m.group(1); // Get value without '$'
                        priceName = false;
                    }
                    if (availabilityName) {
                        availability = new String(ch, start, length);
                        availabilityName = false;
                    }
                    if ( common != "" & botanical != "" &
                            zone != "" & light != "" & price != "" & availability != ""){

                        listPlants.addPlant(new Plant(common, botanical, zone, light,
                                Double.parseDouble(price), Integer.parseInt(availability)));
                        common = "";
                        botanical = "";
                        zone = "";
                        light = "";
                        price = "";
                        availability = "";
                    }
                }
            };

            saxParser.parse(fullPath, handler);
        } catch (ParserConfigurationException | SAXException
                | IOException ex) {
            System.out.println("Ошибка чтения файла");
        }
    }

}
