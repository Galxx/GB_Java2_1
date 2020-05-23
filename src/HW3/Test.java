package HW3;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Task1();
        Task2();
    }

    static void Task1(){

        ArrayList<String> array = new ArrayList<String>();
        array.add("Sasha");
        array.add("Masha");
        array.add("Dasha");
        array.add("Pasha");
        array.add("Sasha");
        array.add("Sasha");
        array.add("Sasha");
        array.add("Sasha");
        array.add("Sasha");
        array.add("Sasha");
        array.add("Sasha");

        HashMap<String, Integer> hm = new HashMap<>();
        for (String name:array) {
            if (hm.get(name)==null){
                hm.put(name,1);
            }else{
                hm.put(name, hm.get(name) + 1);
            }
        }
        System.out.println(hm);
    }

    static void Task2(){

        DirectoryNumber dn = new DirectoryNumber();
        dn.add("Gorokhov","1232143214");
        dn.add("Gorokhov","2342423424");
        dn.add("Petrov","323232323");

        System.out.println(dn.get("Gorokhov"));
        System.out.println(dn.get("Sidorov"));
        System.out.println(dn.get("Petrov"));
    }

}

 class DirectoryNumber{

    private  HashMap<String, ArrayList<String>> directoryNumber;

    public DirectoryNumber(){
        directoryNumber = new HashMap<>();
    }

    public void add(String surname,String number){

       if(directoryNumber.get(surname) == null){
           ArrayList<String> arrayNumber = new ArrayList<>();
           arrayNumber.add(number);
           directoryNumber.put(surname,arrayNumber);
       }else{
           directoryNumber.get(surname).add(number);
       }

    }

    public ArrayList<String> get(String surname){
        return directoryNumber.get(surname);
    }

 }

