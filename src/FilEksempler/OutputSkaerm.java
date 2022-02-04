package FilEksempler;

public class OutputSkaerm {

    public void udskrivStud(Studerende s){
        System.out.format("\n%d %s %s %s %s %s %s",s.getStdnr(),s.getFnavn(),s.getEnavn(),
                s.getAdresse(),s.getPostnr(),s.getMobil(),s.getKlasse());

    }

    public void udskrivStudListe(StudContainer sc)
    {
        int i=0;
        for(i=0;i<sc.henttabel().size();i++)
            System.out.format("\n%d %s %s %s %s %s %s",sc.henttabel().get(i).getStdnr(),sc.henttabel().get(i).getFnavn(),
                    sc.henttabel().get(i).getEnavn(),sc.henttabel().get(i).getAdresse(),sc.henttabel().get(i).getPostnr(),
                    sc.henttabel().get(i).getMobil(),sc.henttabel().get(i).getKlasse());
    }

}
