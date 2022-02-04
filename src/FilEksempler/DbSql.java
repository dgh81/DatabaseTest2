package FilEksempler;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class DbSql {
    private Connection connection;
    private Statement stmt;

    DbSql(){
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C://sqlite/studieadministration.db";
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public  void indsaetStud(Studerende s) {
        try {
              String sql = "INSERT INTO studerende (stdnr,fnavn,enavn,adresse,postnr,mobil,klasse) VALUES(" +
              String.valueOf(s.getStdnr()) + ",'" + s.getFnavn() + "','" + s.getEnavn() + "','";
              sql=sql+s.getAdresse()+"','"+s.getPostnr()+"','"+s.getMobil()+"','"+s.getKlasse()+"')";
              Statement stmt=connection.createStatement();
              stmt.execute(sql);
              System.out.println("Connection to SQLite has been established.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public  void indsaetFag(Fag f) {
        try {
            String sql = "INSERT INTO fag (fagnr,fagnavn) VALUES(" +
                    String.valueOf(f.getFagnr()) + ",'" + f.getFagnavn() + "');";
            Statement stmt=connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

       public void sletStud(Integer stdnr) {
        try {
              String sql = "DELETE FROM studerende WHERE id="+String.valueOf(stdnr);
              Statement stmt=connection.createStatement();
              stmt.execute(sql);
              System.out.println("Connection to SQLite has been established.");
         } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateStudKlasse(Studerende s,String nyKlasse) {
        try {
              String sql = "UPDATE studerende SET klasse ='"+nyKlasse+ "' WHERE stdnr="+String.valueOf(s.getStdnr());
              Statement stmt=connection.createStatement();
              stmt.execute(sql);
              System.out.println("Connection to SQLite has been established.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public void opretTabelfag(){
        try {
            String sql = "CREATE TABLE IF NOT EXISTS fag (\n"
                    + "	fagnr integer PRIMARY KEY,\n"
                    + "	fagnavn TEXT NOT NULL \n"
                    + ");";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public void opretTabelStudFag(){
        try {
            String sql = "CREATE TABLE IF NOT EXISTS studfag (\n"
                    + "	stdnr integer,\n"
                    + "	fagnr integer, \n"
                    + "	primary key(stdnr,fagnr), \n"
                    + "	foreign key(stdnr) references studerende(stdnr), \n"
                    + "	foreign key(fagnr) references fag(fagnr) \n"
                    + ");";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public void opretTabelStud(){
        try {
            String sql = "CREATE TABLE IF NOT EXISTS studerende (\n"
                    + "	stdnr integer PRIMARY KEY,\n"
                    + "	fnavn TEXT NOT NULL,\n"
                    + "	enavn TEXT NOT NULL,\n"
                    + "	adresse TEXT NOT NULL,\n"
                    + "	postnr TEXT NOT NULL,\n"
                    + "	mobil TEXT,\n"
                    + "	klasse TEXT \n"
                    + ");";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


        public  Studerende soegStnnr(int stdnr){
          Studerende s=new Studerende();
          String sql = "SELECT * from studerende where stdnr="+String.valueOf(stdnr);
          try{
            connection.setAutoCommit(true);
            Statement stmt=connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                s.setStdnr(rs.getInt(1));
                s.setFnavn(rs.getString(2));
                s.setEnavn(rs.getString(3));
                s.setAdresse(rs.getString(4));
                s.setPostnr(rs.getString(5));
                s.setMobil(rs.getString(6));
                s.setKlasse(rs.getString(7));
            }
            else
                s=null;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return s;
    }


    public  void indsaetStudListe(StudContainer sc) {

        try {
            for(int i=0;i<sc.henttabel().size();i++) {
                String sql = "INSERT INTO studerende (stdnr,fnavn,enavn,adresse,postnr,mobil,klasse) VALUES(" +
                        String.valueOf(sc.henttabel().get(i).getStdnr()) + ",'" + sc.henttabel().get(i).getFnavn()
                        + "','" + sc.henttabel().get(i).getEnavn() + "','";
                sql = sql + sc.henttabel().get(i).getAdresse() + "','" +
                        sc.henttabel().get(i).getPostnr() + "','" + sc.henttabel().get(i).getMobil() + "','"
                        + sc.henttabel().get(i).getKlasse() + "')";
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
            }
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public  void indsaetStudFagListe(StudFagContainer sfc) {

        try {
            for(int i=0;i<sfc.henttabel().size();i++) {
                String sql = "INSERT INTO studfag (stdnr,fagnr)VALUES(" +
                   String.valueOf(sfc.henttabel().get(i).getStdnr()) +"," + sfc.henttabel().get(i).getFagnr()+");";
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
            }
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}