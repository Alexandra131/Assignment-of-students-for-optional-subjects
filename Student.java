package org.example;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Student {
    private String numStudent;
    String medieString;
    private double medieStudent;
    ArrayList<String> studenti = new ArrayList<>(); //vector studenti

    ArrayList<String> studentiCopie = new ArrayList<>(); //vector studenti copie
    ArrayList<Double> note = new ArrayList<>(); //vector pt note
    ArrayList<Double> noteCopie = new ArrayList<>(); //vector pt note copie
    ArrayList<String> anUniversitar = new ArrayList<>(); //anul in care e
    ArrayList<String> anUniversitarDuplicat = new ArrayList<>(); //anul in care e
    ArrayList<String> cursOptional = new ArrayList<>(); //curs optional
    ArrayList<String> repCurs = new ArrayList<>(); //curs optional
    ArrayList<String> studentDuplicat = new ArrayList<>(); //curs optional
    ArrayList<Double> noteRep = new ArrayList<>(); //note studenti pt anumite cursuri

    Double[] vectorNote = new Double[1000]; //vector note

    public int indexnote = 0;
    public int contor = 0;
    Curs<Student> cursRep = new Curs<>();
    int contorStudentExi = 0;




    public Student() {}


    public void ordAlfabetic(ArrayList<String> nume) {
        for(int i = 0; i < nume.size(); i++) {
            for(int j = i+1; j < nume.size(); j++ ) {
                if(nume.get(i).compareTo(nume.get(j)) > 0) {
//                    double notaTemp = noteCopie.get(i);
//                    noteCopie.set(i, noteCopie.get(j));
//                    noteCopie.set(j, notaTemp);
//
//                    // Schimbarea cursurilor
                    String cursTemp = nume.get(i);
                    nume.set(i, nume.get(j));
                    nume.set(j, cursTemp);
                }
            }
        }

        for(int i = 0; i < studentiCopie.size(); i++) {

        }
    }

    public void sortCrescator() {
        for (int i = 0; i < noteRep.size(); i++) {
            for (int j = i+1; j < noteRep.size(); j++) {
                if (noteRep.get(i) > noteRep.get(j)) {
                    double nr = noteRep.get(i);
                    noteRep.set(i, noteRep.get(j));
                    noteRep.set(j, nr);


                    String contor = repCurs.get(i);
                    repCurs.set(i,repCurs.get(j));
                    repCurs.set(j, contor);
                }
            }
        }
    }


    //scriere intr-un fisier
    public void scriere (String posteaza) {
        try (FileWriter fw = new FileWriter(posteaza, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("***");

            for(int i = 0; i < note.size(); i++) {
                out.print(studenti.get(i));
                out.print(" - ");
                out.println(note.get(i));

            }
        } catch (IOException e) {
            System.out.println("Eroare5");
        }
    }



    //sortare vectori
    public void sort() {

        for (int i = 0; i < note.size(); i++) {
            for (int j = i + 1; j < note.size(); j++) {
                if (note.get(i) < note.get(j)) {
                    // Schimbarea pozițiilor atât în lista cu note, cât și în lista cu nume
                    double varNota = note.get(i);
                    note.set(i, note.get(j));
                    note.set(j, varNota);

                    String varNume = studenti.get(i);
                    studenti.set(i, studenti.get(j));
                    studenti.set(j, varNume);


                    String  varAn =  anUniversitar.get(i);
                    anUniversitar.set(i, anUniversitar.get(j));
                    anUniversitar.set(j, varAn);
                }
            }
        }


    }




    //sortare vectroi lexicografic
    public void sortLexico() {
        for (int i = 0; i < note.size(); i++) {
            for (int j = i + 1; j < note.size(); j++) {
                if (note.get(i).equals(note.get(j))) {

                    int rezultat = studenti.get(i).compareTo(studenti.get(j));
                    if(rezultat > 0) {
                        String varNume = studenti.get(i);
                        studenti.set(i, studenti.get(j));
                        studenti.set(j, varNume);


                        String varAn = anUniversitar.get(i);
                        anUniversitar.set(i, anUniversitar.get(j));
                        anUniversitar.set(j, varAn);
                    }
                }
            }
        }

    }

    //citire note dintr-un anumit fisier
    public void citireNote(String string, String student) {
        try (BufferedReader readerNoteUnu = new BufferedReader(new FileReader(string))) {
            String linieUnu;
            while ((linieUnu = readerNoteUnu.readLine()) != null) {
                if (linieUnu.contains(student)) {
                    contor = 1;
                    int indexMinus = linieUnu.indexOf('-');
                    if (indexMinus != -1) {
                        // Extragerea părții din linie după caracterul "-"
                        String nota = linieUnu.substring(indexMinus + 2);

                        //convertirea de la sting la double
                        double numarDouble = Double.parseDouble(nota);
                        note.add(numarDouble);
                        noteCopie.add(numarDouble);

                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Eroare4");
        }
    }


    //in cazul in care studentul e la master sau licenta
    public void anUniversitar(String linie, String anUniv) throws ExceptieStudentulAFost{
        if(linie.contains(anUniv)) {
            String adauga = "adauga_student - " + anUniv + " -";
            String nume = linie.replace(adauga, "").trim();
            contorStudentExi = 0;
            studenti.add(nume);
            studentDuplicat.add(nume);
            anUniversitarDuplicat.add(anUniv);
            anUniversitar.add(anUniv);
        }
    }

    //metoda verifca exceptie student exi
    public void studentExi() throws ExceptieStudentulAFost {
        for(int i = 0; i < studenti.size(); i++) {
        for(int j = i+1; j < studenti.size(); j++) {
                if(studenti.get(i).equals(studenti.get(j))) {
                    throw new ExceptieStudentulAFost();
                }
            }
        }
    }



    //metoda student duplicat afisare
    public void studentDuplicat(String posteaza){

            for(int i = 0; i < studenti.size(); i++) {
                for (int j = i + 1; j < studenti.size(); j++) {
                    if (studenti.get(i).equals(studenti.get(j))) {
                        try (FileWriter fw = new FileWriter(posteaza, true);
                             BufferedWriter bw = new BufferedWriter(fw);
                             PrintWriter out = new PrintWriter(bw)) {
                            out.println("***");
                            out.println("Student duplicat: " + studenti.get(i));
                        } catch (IOException e) {
                            System.out.println("Eroare3");
                        }
                    }
                }
            }
        System.out.println(anUniversitar.size());
            for(int i = 0; i<studenti.size(); i++) {
                for(int j = i+1; j < studenti.size(); j++) {

                    if(studenti.get(i).equals(studenti.get(j))) {
                        System.out.println("MAria " + studenti.get(i) + " " +studenti.get(j));
                        studentDuplicat.set(j,null);
                        anUniversitar.set(j,null);
                        anUniversitarDuplicat.set(j,null);
                    }
                }
            }
        System.out.println(anUniversitar.size());
            for(int i = 0; i < anUniversitar.size(); i++){
                System.out.println( " Ana "+ anUniversitar.get(i) + " " + studentDuplicat.get(i));
            }



            //eliminam valorile duplicate din student
            List<String> studentiFaraDuplicate = eliminaDuplicate(studenti);
            studenti = new ArrayList<>(studentiFaraDuplicate);



    }



    //metoda elimina duplicate
    public static List<String> eliminaDuplicate(List<String> lista) {
        Set<String> set = new HashSet<>(lista); // Convert lista in set pentru a elimina duplicatele
        return new ArrayList<>(set); // Convert set-ul inapoi la o lista
    }



    //contestatie medie
    public void contestatie(String linie) {
        String informatii;
        informatii = linie.replace("contestatie - ", "").trim();
        numStudent = informatii;
        int pozitieMinus = numStudent.indexOf("-");

        // Extrage partea dinainte de "-"
        if (pozitieMinus != -1) {
            numStudent = numStudent.substring(0, pozitieMinus-1);
        }
        int pozitiePlus = informatii.indexOf("-");
        //extragere parte dupa;
        if(pozitiePlus != -1) {
            medieString = informatii.substring(pozitiePlus + 2);
        }
        medieStudent = Double.parseDouble(medieString);
        for(int i = 0; i < note.size(); i++) {
            if(studenti.get(i).equals(numStudent)) {
                note.set(i, medieStudent);
            }
        }
    }

    //posteaza curs
    public void posteazaCurs(String linie, String posteaza, Curs<?> cursRep){
        sortCrescator();
        String cursDetali = linie.replace("posteaza_curs - ", "").trim();
        try (FileWriter fw = new FileWriter(posteaza, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("***");

            out.print(cursDetali + " (");
            for(int i = 0; i < cursRep.cursAdaugat.size(); i++) {
                if (cursRep.cursAdaugat.get(i).equals(cursDetali)) {
                    out.println(cursRep.capacitate.get(i) +")" );
                }
            }
            ArrayList<String> nume = new ArrayList<>();
            for(int i = 0; i < repCurs.size(); i ++) {
                if(repCurs.get(i).contains(cursDetali)) {
                    String numeUnu = repCurs.get(i).replace(cursDetali, "").trim();

                    nume.add(numeUnu);
                }
            }


            //ordonare alfabetic
            ordAlfabetic(nume);
            for(int i = 0; i < nume.size(); i++) {
                for (int j = 0; j < studenti.size(); j++) {
                    if (studenti.get(j).equals(nume.get(i))) {
                        out.println(nume.get(i) + " - " + note.get(j));

                    }
                }
            }



        } catch (IOException e) {
            System.out.println("Eroare3");
        }
    }


    //posteaza student
    public void posteazaStudent(String linie, String posteaza) {
        String nume = linie.replace("posteaza_student -","").trim();
        try (FileWriter fw = new FileWriter(posteaza, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("***");
            for (int i = 0; i < note.size(); i++) {
                if (studenti.get(i).equals(nume))    {
                    if(anUniversitar.get(i).equals("licenta")) {
                        out.print("Student Licenta: " + nume + " - " + note.get(i) + " - ");
                    } else {
                        out.print("Student Master: " + nume + " - " + note.get(i) + " - ");
                    }
                }
            }

            for (int i = 0; i < note.size(); i++) {
                if(repCurs.get(i).contains(nume)) {
                    String curs = repCurs.get(i).replace(nume, "").trim();
                    out.println(curs);
                }
            }


        } catch (IOException e) {
            System.out.println("Eroare2");
        }
    }

    //adauga optionalele la care vor sa fie repartizati
    public void adaugaOptional(String linie) {
        linie = linie.replace("adauga_preferinte -","").trim();
        numStudent = linie;
        int pozitieMinus = numStudent.indexOf("-");

        // Extrage partea dinainte de "-"
        if (pozitieMinus != -1) {
            numStudent = numStudent.substring(0, pozitieMinus-1);
        }

        cursOptional.add(linie);

    }

}

class ExceptieStudentulAFost extends Exception {
    public ExceptieStudentulAFost() {
    }
}
