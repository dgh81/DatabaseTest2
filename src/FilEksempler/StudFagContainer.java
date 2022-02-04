package FilEksempler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudFagContainer {

    private ArrayList<StudFag> tabel=new ArrayList<>();


    public ArrayList<StudFag> henttabel(){
        return tabel;
    }


    public void laesTxtFil() throws FileNotFoundException {
        int i = 0;
        try {
            File bestilling = new File("studfag.txt");
            Scanner input = new Scanner(bestilling);
            while (input.hasNext()) {
                StudFag sf=new StudFag();
                sf.setStdnr(input.nextInt());
                sf.setFagnr(input.nextInt());
                tabel.add(sf);
            }
           input.close();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }


    public void udskrivSkaerm(){
        int i=0;
        for(i=0;i<tabel.size();i++)
            System.out.format("\n%d %d",tabel.get(i).getStdnr(),tabel.get(i).getFagnr());

    }
}

