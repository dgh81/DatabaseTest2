package FilEksempler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudContainer {

    private ArrayList<Studerende>tabel=new ArrayList<>();


    public ArrayList<Studerende> henttabel(){
        return tabel;
    }


    public void laesTxtFil() throws FileNotFoundException {
        int i = 0;
        try {
            File bestilling = new File("studerende.txt");
            Scanner input = new Scanner(bestilling);
            String adresse;
            int husnr;
            while (input.hasNext()) {
                Studerende s=new Studerende();
                s.setStdnr(input.nextInt());
                s.setFnavn(input.next());
                s.setEnavn(input.next());
                adresse=input.next();
                husnr=input.nextInt();
                adresse=adresse+" "+String.valueOf(husnr);
                s.setAdresse(adresse);
                s.setPostnr(input.next());
                s.setMobil(input.next());;
                s.setKlasse(input.next());
                tabel.add(s);
            }
            input.close();

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

}


