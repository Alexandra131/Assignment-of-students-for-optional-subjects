package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Master extends Student{
    public void posteazaStudentMaster(String linie, String posteaza) {
        String nume = linie.replace("posteaza_student -","").trim();
        try (FileWriter fw = new FileWriter(posteaza, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("***");
            for(int i = 0; i < studenti.size(); i++) {
            }
            for (int i = 0; i < note.size(); i++) {
                System.out.println(studenti.get(i));
                if (studenti.get(i).equals(nume))    {
                    System.out.println("student  Anita " + studenti.get(i) + " " + note.get(i));
                    out.print("Student Master: " + nume + " - " + note.get(i) + " - ");
                    break;
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

    public void posteazaStudentMasterDuplicat(String linie, String posteaza, double nr ) {
        String nume = linie.replace("posteaza_student -","").trim();
        try (FileWriter fw = new FileWriter(posteaza, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("***");
            for(int i = 0; i < studenti.size(); i++) {
            }
            for (int i = 0; i < note.size(); i++) {
                System.out.println(studenti.get(i));
                if (studenti.get(i).equals(nume))    {
                    System.out.println("student  Anita " + studenti.get(i) + " " + note.get(i));
                    out.print("Student Master: " + nume + " - " + nr + " - ");
                    break;
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
}
