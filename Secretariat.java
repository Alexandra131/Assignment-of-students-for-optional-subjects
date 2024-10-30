package org.example;

import javax.swing.undo.AbstractUndoableEdit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.io.*;

public class Secretariat {

    Student student = new Student();
    Master master = new Master();
    Licenta licenta = new Licenta();
    Curs<Licenta> cursLicenta = new Curs<>();
    Curs<Master> cursMaster = new Curs<>();
    public int contor = 0;



    public void afisareEroare(String posteaza) {
        student.studentDuplicat(posteaza);
        contor = 1;
    }
    public void repartizare (Curs<?> cursRep) {
        int nrIntermediar = 0;
        String cuvantDorit =null;
        for (int i = 0; i < student.note.size(); i++) {
            for(int j = 0; j < student.cursOptional.size(); j++) {
                if (student.cursOptional.get(j).contains(student.studenti.get(i))) {
                    String[] curs = student.cursOptional.get(j).split("-");
                    if (curs.length > 1) {
                        cuvantDorit = curs[1].trim(); // primul curs la care vrea sa fie repartizat
                    }
                    //pentru a repartiza studnetii la crsul pe care si.l doresc
                    for(int k = 0; k < cursRep.cursAdaugat.size(); k++) {
                        if(cursRep.cursAdaugat.get(k).equals(cuvantDorit) ) {
                            // sa nu fie umpluta capacitatea pentru a mai putea adauga

                            if(!cursRep.capacitate.get(k).equals(cursRep.capacitateUnu.get(k))) {
                                int indexDelimitator = student.cursOptional.get(j).indexOf("-");

                                if (indexDelimitator != -1) { // Verificare dacă caracterul "-" a fost găsit
                                    // Extrage primul cuvânt până la primul caracter "-"
                                    String numeStudent  = student.cursOptional.get(j).substring(0, indexDelimitator).trim();

                                    student.repCurs.add(numeStudent  + " " + cuvantDorit);
                                    licenta.repCurs.add(numeStudent + " " + cuvantDorit);
                                    master.repCurs.add(numeStudent + " " + cuvantDorit);
                                    // break;
                                    //caut nota studentului
                                    for(int l = 0; l < student.studenti.size(); l++){
                                        if(student.studenti.get(l).equals(numeStudent ))    {
                                            student.noteRep.add(student.note.get(i));
                                        }
                                    }


                                    //adaugam de fiecare data nr de studenti  pe care ii adaugam
                                    cursRep.capacitateUnu.set(k, cursRep.capacitateUnu.get(k) + 1);


                                }
                            } //else {


                            int indexDelimitator = student.cursOptional.get(j).indexOf("-");
                            String numeStudent = null;
                            if (indexDelimitator != -1) { // Verificare dacă caracterul "-" a fost găsit
                                // Extrage primul cuvânt până la primul caracter "-"
                                numeStudent = student.cursOptional.get(j).substring(0, indexDelimitator).trim();
                            }

                            //  cauta toti studenti de la un anumit curs
                            ArrayList<String> studentiAnumitCurs = new ArrayList<>();
                            for(int h = 0; h < student.repCurs.size(); h++) {
                                if(student.repCurs.get(h).contains(cuvantDorit)) {
                                    // ArrayList<String> studentiAnumitCurs = new ArrayList<>();
                                    int indexPrimulSpatiu = student.repCurs.get(h).indexOf(" ");

                                    if (indexPrimulSpatiu != -1) { // Verifică dacă a fost găsit spațiul
                                        // Extrage numele tuturor studentilor care sunt la acel curs
                                        String numeStudentExistent = student.repCurs.get(h).substring(0, indexPrimulSpatiu);
                                        studentiAnumitCurs.add(numeStudentExistent);
                                    }
                                }
                            }

                            //vreau sa stiu unde se afla numele pe care vreau sa.l inserez, in studenti
                            int contor = 0;
                            for(int p = 0; p < student.studenti.size(); p++) {
                                if(student.studenti.get(p).equals(numeStudent)) {
                                    contor = p;
                                }

                            }

                            //caut studentul cu cea mai mica nota
                            double aux = 10;
                            int contorUnu = 0;
                            for(int p = 0; p < studentiAnumitCurs.size(); p++){
                                for(int q = 0; q < student.studenti.size(); q++) {
                                    if(studentiAnumitCurs.get(p).equals(student.studenti.get(q))) { //vreau sa vad unde se afla un anumit studet in vectorul de studenti
                                        if(student.note.get(q) < (aux) ) {
                                            aux = student.note.get(q);
                                            contorUnu = q;
                                        }
                                    }
                                }
                            }


                            //pun in fisier acel student
                            int contorCurs = 0;

                            if(cursRep.capacitate.get(k).equals(cursRep.capacitateUnu.get(k)) && student.note.get(contor).equals(student.note.get(contorUnu))) {
                                for(int g = 0; g < student.repCurs.size(); g++) {

                                    if(student.repCurs.get(g).contains(numeStudent)) {
                                        contorCurs = 1;
                                    }
                                }
                                if(contorCurs == 0) {
                                    student.repCurs.add(numeStudent  + " " + cuvantDorit);
                                    licenta.repCurs.add(numeStudent  + " " + cuvantDorit);
                                    master.repCurs.add(numeStudent  + " " + cuvantDorit);

                                }
                                // contorUnu = 0;
                                //contor = 0;
                            }


                            for(int g = 0; g < student.repCurs.size(); g++) {

                                if(student.repCurs.get(g).contains(numeStudent)) {
                                    contorCurs = 1;
                                }
                            }

                            // }
                            if( cursRep.capacitate.get(k).equals(cursRep.capacitateUnu.get(k)) && contorCurs == 0){
                                // int indexUltimDelimitator = cursOptional.get(j).lastIndexOf("-");

                                int indexPrimulDelimitator = student.cursOptional.get(j).indexOf("-");

                                int indexAlDoileaDelimitator = student.cursOptional.get(j).indexOf("-", indexPrimulDelimitator + 1);
                                int indexAlTreilea = student.cursOptional.get(j).indexOf("-", indexAlDoileaDelimitator  + 1);
                                String ultimulCuvant = null;
                                if (indexPrimulDelimitator != -1 && indexAlDoileaDelimitator != -1 && indexAlTreilea != -1) { // Verificare dacă caracterul "-" a fost găsit
                                    // Extrage ultimul cuvânt după ultimul caracter "-"
                                    ultimulCuvant = student.cursOptional.get(j).substring(indexAlDoileaDelimitator  + 1, indexAlTreilea).trim();


                                }
                                else {
                                    ultimulCuvant = student.cursOptional.get(j).substring(indexAlDoileaDelimitator + 1).trim();
                                }
                                for(int m = 0; m < cursRep.cursAdaugat.size(); m++) {
                                    if(cursRep.cursAdaugat.get(m).equals(ultimulCuvant) ){
                                        if(!cursRep.capacitate.get(m).equals(cursRep.capacitateUnu.get(m))) {
                                            indexDelimitator = student.cursOptional.get(j).indexOf("-");

                                            if (indexDelimitator != -1) { // Verificare dacă caracterul "-" a fost găsit
                                                // Extrage primul cuvânt până la primul caracter "-"
                                                String primulCuvant = student.cursOptional.get(j).substring(0, indexDelimitator).trim();
                                                student.repCurs.add(primulCuvant + " " + ultimulCuvant);
                                                licenta.repCurs.add(primulCuvant + " " + ultimulCuvant);
                                                master.repCurs.add(primulCuvant + " " + ultimulCuvant);


                                                //caut nota studentului
                                                for(int l = 0; l < student.studenti.size(); l++){
                                                    if(student.studenti.get(l).equals(primulCuvant))    {
                                                        student.noteRep.add(student.note.get(i));
                                                    }
                                                }



                                                //adaugam de fiecare data nr de studenti  pe care ii adaugam
                                                cursRep.capacitateUnu.set(m, cursRep.capacitateUnu.get(m) + 1);


                                            }
                                        }
                                    }
                                }


                            }

                            int indexPrimulDelimitator = student.cursOptional.get(j).indexOf("-");

                            int indexAlDoileaDelimitator = student.cursOptional.get(j).indexOf("-", indexPrimulDelimitator + 1);
                            int indexAlTreilea = student.cursOptional.get(j).indexOf("-", indexAlDoileaDelimitator  + 1);
                            String ultimulCuvant = null;
                            if (indexPrimulDelimitator != -1 && indexAlDoileaDelimitator != -1 && indexAlTreilea != -1) { // Verificare dacă caracterul "-" a fost găsit
                                // Extrage ultimul cuvânt după ultimul caracter "-"
                                ultimulCuvant = student.cursOptional.get(j).substring(indexAlDoileaDelimitator  + 1, indexAlTreilea).trim();


                            }
                            else {
                                ultimulCuvant = student.cursOptional.get(j).substring(indexAlDoileaDelimitator + 1).trim();
                            }
                            // ultimul cuv = curs la care vreau sa adaug in cazul in care nu au fost adaugati studentii

                            contorCurs = 0;
                            for(int n = 0; n < cursRep.cursAdaugat.size(); n++) {
                                if(cursRep.cursAdaugat.get(n).equals(ultimulCuvant)) {
                                    if(cursRep.capacitateUnu.get(n).equals(cursRep.capacitate.get(n))) {
                                        for(int g = 0; g < student.repCurs.size(); g++) {

                                            if(student.repCurs.get(g).contains(numeStudent)) {
                                                contorCurs = 1;
                                            }
                                        }
                                        if(contorCurs == 0) {
                                            student.repCurs.add(numeStudent  + " " + ultimulCuvant);
                                            licenta.repCurs.add(numeStudent  + " " + ultimulCuvant);
                                            master.repCurs.add(numeStudent  + " " + ultimulCuvant);

                                        }
                                    }

                                }

                            }

                        }


                    }
                }
            }
        }
    }
    public void posteazaMedii( String string, String noteUnu, String noteDoi, String noteTrei, String posteaza ) throws ExceptieStudentulAFost, FileNotFoundException, IOException {

        //try (BufferedReader reader = new BufferedReader(new FileReader(string))) {
             BufferedReader reader = new BufferedReader(new FileReader(string));
            String linie;

            while ((linie = reader.readLine()) != null) {

                if(linie.contains("adauga_student")) {
                        student.anUniversitar(linie, "master");
                        student.anUniversitar(linie, "licenta");
                        licenta.anUniversitar(linie, "master");
                        licenta.anUniversitar(linie, "licenta");
                        master.anUniversitar(linie, "master");
                        master.anUniversitar(linie, "licenta");

                }
                if(linie.contains("citeste_mediile")) {
                    student.studentExi();
                    for(String student :student.studenti) {

                        this.student.contor = 0;
                      this.student.citireNote(noteUnu, student);
                        licenta.citireNote(noteUnu, student);
                        master.citireNote(noteUnu, student);

                        if (this.student.contor == 0) {
                            this.student.citireNote(noteDoi, student);
                            licenta.citireNote(noteDoi, student);
                            master.citireNote(noteDoi, student);
                        }
                        if(this.student.contor == 0) {
                           this.student.citireNote(noteTrei, student);
                            licenta.citireNote(noteTrei, student);
                            master.citireNote(noteTrei, student);
                        }
                    }
                }
                if(linie.contains("posteaza_mediile")) {

                    //incercare sortare vectori dupa medie
                   student.sort();
                    student.sortLexico();
                    student.scriere(posteaza);

//                    licenta.sort();
//                    licenta.sortLexico();
//                    licenta.scriere(posteaza);

                }

                if(linie.contains("contestatie")) {
                    licenta.contestatie(linie);
                    student.contestatie(linie);
                    master.contestatie(linie);
                }

                if(linie.contains("adauga_curs - licenta")) {

                    // Curs<Student> curs = new Curs<>();

                    //cursRep.adaugaCurs("adauga_curs - licenta", linie);
                    cursLicenta.adaugaCurs("adauga_curs - licenta", linie);
                    cursMaster.adaugaCurs("adauga_curs - licenta", linie);
                }

                if(linie.contains("adauga_curs - master")) {
                    cursMaster.adaugaCurs("adauga_curs - master", linie);
                    cursLicenta.adaugaCurs("adauga_curs - master", linie);
                }

                if(linie.contains("adauga_preferinte")) {
                   student.adaugaOptional(linie);
                    licenta.adaugaOptional(linie);
                    master.adaugaOptional(linie);
                }

                if(linie.contains("repartizeaza")) {
                    repartizare(cursLicenta);
                    //repartizare(cursMaster);
                }
                if (linie.contains("posteaza_curs")) {

                    student.posteazaCurs(linie, posteaza, cursLicenta);
                   // licenta.posteazaCurs(linie, posteaza, cursRep);


                }
                if(linie.contains("posteaza_student")) {
                    //student.posteazaStudent(linie,posteaza);
                    String nume = linie.replace("posteaza_student -","").trim();
                    for (int i = 0; i <student.note.size(); i++) {

                        if (student.studenti.get(i).equals(nume))    {
                            if(student.anUniversitar.get(i).equals("licenta")) {
                            licenta.posteazaStudentLicenta(linie, posteaza);
                            } else {
                            master.posteazaStudentMaster(linie,posteaza);    ;
                            }
                        }
                    }
                }
            }

      }


    public void posteazaMediDupaEroare( String string, String noteUnu, String noteDoi, String noteTrei, String posteaza ) {

        try (BufferedReader reader = new BufferedReader(new FileReader(string))) {
        String linie;

            while ((linie = reader.readLine()) != null) {
                 int contor1 = 0;
                if(linie.contains("adauga_student")) {

                    if(contor == 0) {
                        student.anUniversitar(linie, "master");
                        student.anUniversitar(linie, "licenta");
                        licenta.anUniversitar(linie, "master");
                        licenta.anUniversitar(linie, "licenta");
                        master.anUniversitar(linie, "master");
                        master.anUniversitar(linie, "licenta");
                    }

                }

                if(linie.contains("citeste_mediile")) {
                    for(String student :student.studenti) {

                        this.student.contor = 0;
                        this.student.citireNote(noteUnu, student);
                        licenta.citireNote(noteUnu, student);
                        master.citireNote(noteUnu, student);

                        if (this.student.contor == 0) {
                            this.student.citireNote(noteDoi, student);
                            licenta.citireNote(noteDoi, student);
                            master.citireNote(noteDoi, student);
                        }
                        if(this.student.contor == 0) {
                            this.student.citireNote(noteTrei, student);
                            licenta.citireNote(noteTrei, student);
                            master.citireNote(noteTrei, student);
                        }
                    }



                }
                if(linie.contains("posteaza_mediile")) {

                    //incercare sortare vectori dupa medie
                    student.sort();
                    student.sortLexico();
                    student.scriere(posteaza);

                }

                if(linie.contains("contestatie")) {
                    licenta.contestatie(linie);
                    student.contestatie(linie);
                    master.contestatie(linie);



                }

                if(linie.contains("adauga_curs - licenta")) {

                    cursLicenta.adaugaCurs("adauga_curs - licenta", linie);
                    cursMaster.adaugaCurs("adauga_curs - licenta", linie);

                }

                if(linie.contains("adauga_curs - master")) {
                    cursMaster.adaugaCurs("adauga_curs - master", linie);
                    cursLicenta.adaugaCurs("adauga_curs - master", linie);

                }

                if(linie.contains("adauga_preferinte")) {
                    student.adaugaOptional(linie);
                    licenta.adaugaOptional(linie);
                    master.adaugaOptional(linie);

                }

                if(linie.contains("repartizeaza")) {
                    repartizare(cursLicenta);
                    //repartizare(cursMaster);
                }
                if (linie.contains("posteaza_curs")) {

                    student.posteazaCurs(linie, posteaza, cursLicenta);
                    // licenta.posteazaCurs(linie, posteaza, cursRep);


                }
                if(linie.contains("posteaza_student")) {
                    String nume = linie.replace("posteaza_student -","").trim();


                    for(int i = 0; i < student.studentDuplicat.size(); i++) {
                       if(student.studentDuplicat.get(i) != null) {
                            if(student.studentDuplicat.get(i).equals(nume)) {
                                if(student.anUniversitarDuplicat.get(i).equals("licenta")) {
                                    double nr = 0;
                                    for(int j = 0; j < student.studenti.size(); j++) {
                                        if(student.studenti.get(j).equals(nume)) {
                                            nr = student.note.get(j);

                                            licenta.posteazaStudentLicentaDuplicat(linie, posteaza, nr);
                                        }
                                    }
                                } else {
//                                    master.posteazaStudentMaster(linie, posteaza);
                                    double nr = 0;
                                    for(int j = 0; j < student.studenti.size(); j++) {
                                        if(student.studenti.get(j).equals(nume)) {
                                            nr = student.note.get(j);

                                            master.posteazaStudentMasterDuplicat(linie, posteaza, nr);
                                        }
                                    }
                                }
                            }
                       }
                    }


                }
            }
        } catch (Exception e) {
            System.out.println("Eroare Alexaa");
        }

    }
}

