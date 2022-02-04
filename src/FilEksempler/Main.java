package FilEksempler;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DbSql db=new DbSql();
        //db.opretTabelStud();
        Studerende s=new Studerende(1,"Anne","Andersen","Annevej 5","2000","12121212","1a");
       // db.indsaetStud(s);
        Studerende s1=new Studerende(2,"Bent","Jensen","Bentvej 7","2000","12345678","1b");
       // db.indsaetStud(s1);

       StudContainer sc= new StudContainer();
       try {
           sc.laesTxtFil();
       } catch (FileNotFoundException exception) {
           exception.printStackTrace();
       }

       OutputSkaerm os=new OutputSkaerm();

       os.udskrivStudListe(sc);

       //db.indsaetStudListe(sc);


      // db.opretTabelfag();
       Fag f=new Fag(1,"Matematik");
       //db.indsaetFag(f);
       //f.setFagnr(5);
      // f.setFagnavn("Systemudvikling");
      // db.indsaetFag(f);
        //db.opretTabelStudFag();


        StudFagContainer sfc=new StudFagContainer();
        try {
            sfc.laesTxtFil();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
      //  sfc.udskrivSkaerm();
     //   db.indsaetStudFagListe(sfc);

        s=db.soegStnnr(3);
        os.udskrivStud(s);


    }
}
