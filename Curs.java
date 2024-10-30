package org.example;
import java.util.ArrayList;

public class Curs<T extends Student> {
    public String numeCurs;
    public int capacitateStudenti;
    public String rolCurs;

    ArrayList<String> cursAdaugat = new ArrayList<>();
    ArrayList<Integer> capacitate = new ArrayList<>();
    ArrayList<Integer> capacitateUnu = new ArrayList<>();


    public void adaugaCurs(String tipCurs, String linie) {

        String adauga = "adauga_curs - ";
        rolCurs = tipCurs.replace(adauga,"").trim();
        numeCurs = linie.replace(tipCurs, "").trim();

        String stringCapacitate;

        stringCapacitate = linie.replace(tipCurs, "").trim();

        System.out.println(stringCapacitate);

        int indexPrimulDelimitator = numeCurs.indexOf("-");

        int indexAlDoileaDelimitator = numeCurs.indexOf("-", indexPrimulDelimitator + 1);

        if (indexPrimulDelimitator != -1 && indexAlDoileaDelimitator != -1) {
            // Extrage porțiunea de text între cele două caractere "-"
            numeCurs = numeCurs.substring(indexPrimulDelimitator + 1, indexAlDoileaDelimitator).trim();

            System.out.println("Textul dintre delimitatoare: " + numeCurs);
        }
        stringCapacitate = stringCapacitate.substring(indexAlDoileaDelimitator + 2, stringCapacitate.length());
        System.out.println(stringCapacitate);
        capacitateStudenti = Integer.parseInt(stringCapacitate);
        cursAdaugat.add(numeCurs);
        capacitate.add(capacitateStudenti);
        capacitateUnu.add(0);

    }



}
