package JavaXMLreadSAX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListPlants {

    List<Plant> plantList = new ArrayList<>();

    public void addPlant(Plant plant){
        plantList.add(plant);
    }

    public void showList(){
        for (Plant p: plantList
                ) {
            System.out.println(p.toString());
        }
    }

    public int showCountPlants(){
        return plantList.size();
    }

//    public void sortByPrice(String str){
//        Collections.sort(plantList, new Comparator<Plant>() {
//            @Override
//            public int compare(Plant o1, Plant o2) {
//                if(o1.getPrice() > o2.getPrice()){
//                    if(str.equals("up")) {
//                        return -1;
//                    } else if(str.equals("down")) {
//                        return 1;
//                    } else return 0;
//                } else
//                if(o1.getPrice() < o2.getPrice()){
//                    if(str.equals("up")) {
//                        return 1;
//                    } else if(str.equals("down")) {
//                        return -1;
//                    } else return 0;
//                } else return 0;
//            }
//        });
//    }

}

