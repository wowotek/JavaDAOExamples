package com.wowotek.daoex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MantanDAO implements DAO<Mantan>{
    private Connection con;
    
    public MantanDAO(Connection con){
        this.con = con;
    }
    
    @Override
    public List<Mantan> getAllData() {
        List<Mantan> lm = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("Select * From Daftar_Mantan");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int ID = rs.getInt(1);
                String Nama = rs.getString(2);
                int Umur = rs.getInt(3);
                String NoTelp = rs.getString(4);
                
                lm.add(new Mantan(ID, Nama, Umur, NoTelp));
            }
            
            System.err.println("Successfully Gathered Data");
            return lm;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean addData(Mantan t) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Daftar_Mantan(Nama, Umur, NoTelp) VALUES (?, ?, ?)");
            
            System.err.println(t.Nama + t.Umur+ t.NoTelp);
            
            ps.setString(1, t.Nama);
            ps.setInt(2, t.Umur);
            ps.setString(3, t.NoTelp);
            
            if(ps.executeUpdate() > 0){
                System.err.println("Data Sucessfully Added");
                return true;
            } else {
                System.err.println("Data Failed to Add");
                return false;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean removeData(Mantan t) {
        try {
            PreparedStatement ps = con.prepareStatement("Delete From Daftar_Mantan Where ID=? or Nama=? or Umur=? or NoTelp=?");
            
            ps.setInt(1, t.ID);
            ps.setString(2, t.Nama);
            ps.setInt(3, t.Umur);
            ps.setString(4, t.NoTelp);
            
            if(ps.executeUpdate() > 0){
                System.err.println("Data Sucessfully Deleted");
                return true;
            } else {
                System.err.println("Data Failed to Deleted");
                return false;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
    
    @Override
    public boolean removeData(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("Delete From Daftar_Mantan Where ID=?");
            
            ps.setInt(1, id);
            
            if(ps.executeUpdate() > 0){
                System.err.println("Data Sucessfully Deleted");
                return true;
            } else {
                System.err.println("Data Failed to Deleted");
                return false;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateData(int id, Mantan t) {
        try {
            PreparedStatement ps = con.prepareStatement("Update Daftar_Mantan SET Nama=?, Umur=?, NoTelp=? Where ID=?");
            
            ps.setString(1, t.Nama);
            ps.setInt(2, t.Umur);
            ps.setString(3, t.NoTelp);
            ps.setInt(4, t.ID);
            
            if(ps.executeUpdate() > 0){
                System.err.println("Data Sucessfully Updated");
                return true;
            } else {
                System.err.println("Data Failed to Updated");
                return false;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }   
}
