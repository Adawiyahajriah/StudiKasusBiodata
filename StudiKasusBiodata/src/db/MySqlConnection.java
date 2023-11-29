/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Yusup
 */
public class MySqlConnection {
    // URL, username, dan password untuk koneksi ke database MySQL
    private final static String DB_URL = "jdbc:mysql://localhost:3306/biodata";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "";
    
    // instance singleton dari kelas MySqlConnection
    private static MySqlConnection instance;
    
    // untuk mendapatkan instance dari MySqlConnection (singleton pattern)
    public static MySqlConnection getInstance() {
        if (instance == null) {
            instance = new MySqlConnection();
        }
        return instance;
    }
    
     // untuk mendapatkan koneksi ke database
    public Connection getConnection() {
        Connection connection = null;
        try {
            // mendaftarkan driver JDBC MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // membuat koneksi ke database menggunakan URL, username, dan password
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (Exception e){
            //  menangkap dan mencetak kesalahan jika terjadi masalah pada koneksi
            e.printStackTrace();
        }
        return connection;
    }
    
}

