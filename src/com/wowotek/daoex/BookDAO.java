package com.wowotek.daoex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book>{
    private Connection con;
    
    public BookDAO(Connection con){
        this.con = con;
    }
    
    @Override
    public List<Book> getAllData() {
        List<Book> lm = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("Select * From Daftar_Buku");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
		String Kode = rs.getString(1);
                String Judul = rs.getString(2);
		String ISBN = rs.getString(3);
		String Pengarang = rs.getString(4);
		String Penerbit = rs.getString(5);
                
                lm.add(new Book(Kode, Judul, ISBN, Pengarang, Penerbit));
            }
            
            System.err.println("Successfully Gathered Data");
            return lm;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean addData(Book b) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Daftar_Buku VALUES (?, ?, ?, ?, ?)");
            
            ps.setString(1, b.Kode);
            ps.setString(2, b.Judul);
            ps.setString(3, b.ISBN);
	    ps.setString(4, b.Pengarang);
	    ps.setString(5, b.Penerbit);
            
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
    public boolean removeData(String kode) {
        try {
            PreparedStatement ps = con.prepareStatement("Delete From Daftar_Buku Where Kode=?");
            
            ps.setInt(1, kode);
            
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
    public boolean updateData(String kode, Book b) {
        try {
            PreparedStatement ps = con.prepareStatement("Update Daftar_Mantan SET Judul=?, ISBN=?, Pengarang=?, Penerbit=?  Where Kode=?");
            
            ps.setString(1, b.Judul);
	    ps.setString(2, b.ISBN);
	    ps.setString(3, b.Pengarang);
	    ps.setString(4, b.Penerbit);
	    ps.setString(5, b.Kode);
            
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
