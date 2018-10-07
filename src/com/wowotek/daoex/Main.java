package com.wowotek.daoex;

public class Main {
    public static void main(String[] args) {
        DBConnection x = DBConnection.getInstance();
        MantanDAO dao = new MantanDAO(x.con);
        
        dao.addData(new Mantan("Gaby Balqis", 22, "081808180818"));
        dao.addData(new Mantan("Gillis C. Maulidiska", 20, "081708170817"));
        dao.addData(new Mantan("Bella Nove Khirria", 22, "081608160816"));
        
        for(Mantan i: dao.getAllData()){
            System.out.println(i.ID);
            System.out.println(i.Nama);
            System.out.println(i.NoTelp);
            System.out.println(i.Umur);
        }
        
        dao.removeData(3);
        
        for(Mantan i: dao.getAllData()){
            System.out.println(i.ID);
            System.out.println(i.Nama);
            System.out.println(i.NoTelp);
            System.out.println(i.Umur);
        }
    }
}
