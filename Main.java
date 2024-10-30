package org.example;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static int contor = 0;


    public static void main(String[] args) {

        Secretariat secretariat = new Secretariat();
        String posteaza = null;
        String fisier = null;
        String noteUnu = null;
        String noteDoi = null;
        String noteTrei = null;
        if(args[0].equals("01-posteaza_medii")) {
            try {
                secretariat = new Secretariat();
                fisier = "src/main/resources/01-posteaza_medii/01-posteaza_medii.in";
                noteUnu = "src/main/resources/01-posteaza_medii/note_1.txt";
                noteDoi = "src/main/resources/01-posteaza_medii/note_2.txt";
                posteaza = "src/main/resources/01-posteaza_medii/01-posteaza_medii.out";
                secretariat.posteazaMedii(fisier, noteUnu, noteDoi, null, posteaza);
            }  catch (ExceptieStudentulAFost e) {
                System.out.println("Student duplicat:");
                secretariat.afisareEroare(posteaza);
                secretariat.posteazaMediDupaEroare(fisier, noteUnu, noteDoi,null, posteaza);

            } catch (Exception e) {
                System.out.println("Eroare1");
            }

        }

        if(args[0].equals("02-posteaza_medii_contestatii")) {
            try {
                secretariat = new Secretariat();
                fisier = "src/main/resources/02-posteaza_medii_contestatii/02-posteaza_medii_contestatii.in";
                noteUnu = "src/main/resources/02-posteaza_medii_contestatii/note_1.txt";
                noteDoi = "src/main/resources/02-posteaza_medii_contestatii/note_2.txt";
                posteaza = "src/main/resources/02-posteaza_medii_contestatii/02-posteaza_medii_contestatii.out";
                secretariat.posteazaMedii(fisier, noteUnu, noteDoi, null, posteaza);
            }catch (ExceptieStudentulAFost e) {
                    System.out.println("Student duplicat:");
                    secretariat.afisareEroare(posteaza);
                    secretariat.posteazaMediDupaEroare(fisier, noteUnu, noteDoi,null, posteaza);

            } catch (Exception e) {
                    System.out.println("Eroare1");
            }
        }

        if(args[0].equals("03-posteaza_medii_contestatii")) {
            try {
                 secretariat = new Secretariat();
                 fisier = "src/main/resources/03-posteaza_medii_contestatii/03-posteaza_medii_contestatii.in";
                 noteUnu = "src/main/resources/03-posteaza_medii_contestatii/note_1.txt";
                 noteDoi = "src/main/resources/03-posteaza_medii_contestatii/note_2.txt";
                 posteaza = "src/main/resources/03-posteaza_medii_contestatii/03-posteaza_medii_contestatii.out";
                secretariat.posteazaMedii(fisier, noteUnu, noteDoi, null, posteaza);
            }catch (ExceptieStudentulAFost e) {
                    System.out.println("Student duplicat:");
                    secretariat.afisareEroare(posteaza);
                    secretariat.posteazaMediDupaEroare(fisier, noteUnu, noteDoi,null, posteaza);

            } catch (Exception e) {
                    System.out.println("Eroare1");
            }
        }
        if(args[0].equals("04-posteaza_medii_contestatii")) {
            try {
                secretariat = new Secretariat();
                fisier = "src/main/resources/04-posteaza_medii_contestatii/04-posteaza_medii_contestatii.in";
                noteUnu = "src/main/resources/04-posteaza_medii_contestatii/note_1.txt";
                noteDoi = "src/main/resources/04-posteaza_medii_contestatii/note_2.txt";
                posteaza = "src/main/resources/04-posteaza_medii_contestatii/04-posteaza_medii_contestatii.out";
                secretariat.posteazaMedii(fisier, noteUnu, noteDoi, null, posteaza);
            }catch (ExceptieStudentulAFost e) {
                    System.out.println("Student duplicat:");
                    secretariat.afisareEroare(posteaza);
                    secretariat.posteazaMediDupaEroare(fisier, noteUnu, noteDoi,null, posteaza);

            } catch (Exception e) {
                    System.out.println("Eroare1");
            }

        }

        if(args[0].equals("05-inroleaza_simplu")) {

            try {
                 secretariat = new Secretariat();
                 fisier = "src/main/resources/05-inroleaza_simplu/05-inroleaza_simplu.in";
                 noteUnu = "src/main/resources/05-inroleaza_simplu/note_1.txt";
                 noteDoi = "src/main/resources/05-inroleaza_simplu/note_2.txt";
                 noteTrei = "src/main/resources/05-inroleaza_simplu/note_3.txt";
               posteaza = "src/main/resources/05-inroleaza_simplu/05-inroleaza_simplu.out";
               secretariat.posteazaMedii(fisier, noteUnu, noteDoi, noteTrei, posteaza);
            }catch (ExceptieStudentulAFost e) {
                System.out.println("Student duplicat:");
                secretariat.afisareEroare(posteaza);
                secretariat.posteazaMediDupaEroare(fisier, noteUnu, noteDoi,noteTrei, posteaza);

            } catch (Exception e) {
                System.out.println("Eroare1");
            }

        }

        if(args[0].equals("06-inroleaza_ciclu_studii")) {
            try {
                 secretariat = new Secretariat();
                 fisier = "src/main/resources/06-inroleaza_ciclu_studii/06-inroleaza_ciclu_studii.in";
                 noteUnu = "src/main/resources/06-inroleaza_ciclu_studii/note_1.txt";
                 noteDoi = "src/main/resources/06-inroleaza_ciclu_studii/note_2.txt";
                 posteaza = "src/main/resources/06-inroleaza_ciclu_studii/06-inroleaza_ciclu_studii.out";
                secretariat.posteazaMedii(fisier, noteUnu, noteDoi, null, posteaza);
            }catch (ExceptieStudentulAFost e) {
                System.out.println("Student duplicat:");
                secretariat.afisareEroare(posteaza);
                secretariat.posteazaMediDupaEroare(fisier, noteUnu, noteDoi,null, posteaza);

            } catch (Exception e) {
                System.out.println("Eroare1");
            }
        }

        if(args[0].equals("07-inroleaza_ciclu_studii_contestatii")) {
            try {
             secretariat = new Secretariat();
             fisier = "src/main/resources/07-inroleaza_ciclu_studii_contestatii/07-inroleaza_ciclu_studii_contestatii.in";
             noteUnu = "src/main/resources/07-inroleaza_ciclu_studii_contestatii/note_1.txt";
             noteDoi = "src/main/resources/07-inroleaza_ciclu_studii_contestatii/note_2.txt";
             posteaza = "src/main/resources/07-inroleaza_ciclu_studii_contestatii/07-inroleaza_ciclu_studii_contestatii.out";
            secretariat.posteazaMedii(fisier, noteUnu, noteDoi,null, posteaza);
            }catch (ExceptieStudentulAFost e) {
                System.out.println("Student duplicat:");
                secretariat.afisareEroare(posteaza);
                secretariat.posteazaMediDupaEroare(fisier, noteUnu, noteDoi,null, posteaza);

            } catch (Exception e) {
                System.out.println("Eroare1");
            }
        }

        if(args[0].equals("08-coliziuni_medie")) {
            try {
             secretariat = new Secretariat();
             fisier = "src/main/resources/08-coliziuni_medie/08-coliziuni_medie.in";
             noteUnu = "src/main/resources/08-coliziuni_medie/note_1.txt";
             posteaza = "src/main/resources/08-coliziuni_medie/08-coliziuni_medie.out";
            secretariat.posteazaMedii(fisier, noteUnu, null,null, posteaza);
            }catch (ExceptieStudentulAFost e) {
                System.out.println("Student duplicat:");
                secretariat.afisareEroare(posteaza);
                secretariat.posteazaMediDupaEroare(fisier, noteUnu, null,null, posteaza);

            } catch (Exception e) {
                System.out.println("Eroare1");
            }
        }

        if(args[0].equals("09-coliziuni_ciclu_studii")) {
            try {
                 secretariat = new Secretariat();
                 fisier = "src/main/resources/09-coliziuni_ciclu_studii/09-coliziuni_ciclu_studii.in";
                 noteUnu = "src/main/resources/09-coliziuni_ciclu_studii/note_1.txt";
                 noteDoi = "src/main/resources/09-coliziuni_ciclu_studii/note_2.txt";
                 noteTrei = "src/main/resources/09-coliziuni_ciclu_studii/note_3.txt";
                 posteaza = "src/main/resources/09-coliziuni_ciclu_studii/09-coliziuni_ciclu_studii.out";
                secretariat.posteazaMedii(fisier, noteUnu, noteDoi, noteTrei, posteaza);
            }catch (ExceptieStudentulAFost e) {
                System.out.println("Student duplicat:");
                secretariat.afisareEroare(posteaza);
                secretariat.posteazaMediDupaEroare(fisier, noteUnu, noteDoi,noteTrei, posteaza);

            } catch (Exception e) {
                System.out.println("Eroare1");
            }

        }
        if(args[0].equals("10-coliziuni_ciclu_studii_contestatii")) {
        try {
             secretariat = new Secretariat();
             fisier = "src/main/resources/10-coliziuni_ciclu_studii_contestatii/10-coliziuni_ciclu_studii_contestatii.in";
             noteUnu = "src/main/resources/10-coliziuni_ciclu_studii_contestatii/note_1.txt";
             noteDoi = "src/main/resources/10-coliziuni_ciclu_studii_contestatii/note_2.txt";
             noteTrei = "src/main/resources/10-coliziuni_ciclu_studii_contestatii/note_3.txt";
             posteaza = "src/main/resources/10-coliziuni_ciclu_studii_contestatii/10-coliziuni_ciclu_studii_contestatii.out";
            secretariat.posteazaMedii(fisier, noteUnu, noteDoi, noteTrei, posteaza);
        }catch (ExceptieStudentulAFost e) {
            System.out.println("Student duplicat:");
            secretariat.afisareEroare(posteaza);
            secretariat.posteazaMediDupaEroare(fisier, noteUnu, noteDoi,noteTrei, posteaza);

        } catch (Exception e) {
            System.out.println("Eroare1");
        }

        }

        if(args[0].equals("11-exceptie_simplu")) {
            try {
                //Secretariat secretariat = new Secretariat();
                 fisier = "src/main/resources/11-exceptie_simplu/11-exceptie_simplu.in";
                noteUnu = "src/main/resources/11-exceptie_simplu/note_1.txt";
                 noteDoi = "src/main/resources/11-exceptie_simplu/note_2.txt";
                 posteaza = "src/main/resources/11-exceptie_simplu/11-exceptie_simplu.out";
                secretariat.posteazaMedii(fisier, noteUnu, noteDoi,null, posteaza);
            } catch (ExceptieStudentulAFost e) {
                System.out.println("Student duplicat:");
                secretariat.afisareEroare(posteaza);
                secretariat.posteazaMediDupaEroare(fisier, noteUnu, noteDoi,null, posteaza);

            } catch (Exception e) {
            System.out.println("Eroare1");
        }

        }

        if(args[0].equals("12-toate_functionalitatile")) {
            try {
                //Secretariat secretariat = new Secretariat();
                fisier = "src/main/resources/12-toate_functionalitatile/12-toate_functionalitatile.in";
                noteUnu = "src/main/resources/12-toate_functionalitatile/note_1.txt";
                noteDoi = "src/main/resources/12-toate_functionalitatile/note_2.txt";
                noteTrei = "src/main/resources/12-toate_functionalitatile/note_3.txt";
                posteaza = "src/main/resources/12-toate_functionalitatile/12-toate_functionalitatile.out";
                secretariat.posteazaMedii(fisier, noteUnu, noteDoi,noteTrei, posteaza);
            } catch (ExceptieStudentulAFost e) {
                System.out.println("Student duplicat:");
                secretariat.afisareEroare(posteaza);
                secretariat.posteazaMediDupaEroare(fisier, noteUnu, noteDoi,noteTrei, posteaza);

            } catch (Exception e) {
                System.out.println("Eroare1");
            }
        }


    }
}
