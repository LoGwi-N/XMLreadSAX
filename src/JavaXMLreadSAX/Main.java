package JavaXMLreadSAX;


public class Main {

    private static final String FILENAME = "plant.xml";

    public static void main(String[] args) {

        ListPlants listPlants = new ListPlants();

        MySAXParser mySAXParser = new MySAXParser();
        mySAXParser.parseXML(FILENAME, listPlants);

        listPlants.showList();
        System.out.println(listPlants.showCountPlants());

    }
}
