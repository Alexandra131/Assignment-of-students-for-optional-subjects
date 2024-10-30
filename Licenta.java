package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Licenta extends Student {


    public void posteazaStudentLicenta(String linie, String posteaza) {
        String nume = linie.replace("posteaza_student -","").trim();
        try (FileWriter fw = new FileWriter(posteaza, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("***");

            for (int i = 0; i < note.size(); i++) {
              //  System.out.println("mami:" + note.size() + " " + studenti.get(i)  + " " + note.get(i) + nume);
                if (studenti.get(i).equals(nume))    {
                    out.print("Student Licenta: " + nume + " - " + note.get(i) + " - ");
                    break;
                }
            }


            for (int i = 0; i < note.size(); i++) {
                //System.out.println(repCurs.get(i) + " MAmi " + nume);
                if(repCurs.get(i).contains(nume)) {
                    String curs = repCurs.get(i).replace(nume, "").trim();
                    out.println(curs);
                }
            }


        } catch (IOException e) {
            System.out.println("Eroare2");
        }
    }



    public void posteazaStudentLicentaDuplicat(String linie, String posteaza, double nr) {
        String nume = linie.replace("posteaza_student -","").trim();
        try (FileWriter fw = new FileWriter(posteaza, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("***");

            for (int i = 0; i < note.size(); i++) {
                //  System.out.println("mami:" + note.size() + " " + studenti.get(i)  + " " + note.get(i) + nume);
                if (studenti.get(i).equals(nume))    {
                    out.print("Student Licenta: " + nume + " - " + nr + " - ");
                    break;
                }
            }


            for (int i = 0; i < note.size(); i++) {
                //System.out.println(repCurs.get(i) + " MAmi " + nume);
                if(repCurs.get(i).contains(nume)) {
                    String curs = repCurs.get(i).replace(nume, "").trim();
                    out.println(curs);
                }
            }


        } catch (IOException e) {
            System.out.println("Eroare2");
        }
    }

}
