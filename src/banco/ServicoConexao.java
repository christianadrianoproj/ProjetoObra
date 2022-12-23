/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class ServicoConexao {

    public Connection connection;

    public Connection getConexao() {
        final String DRIVER = "com.mysql.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/db_obra" 
                    + "?verifyServerCertificate=true"
                    + "&useSSL=false"
                    + "&requireSSL=false"
                    + "&useTimezone=true&serverTimezone=UTC";
                    /*+ "&useUnicode=true"
                    + "&characterEncoding=UTF-8";*/

        try {
            Class.forName(DRIVER);

            Properties properties = new Properties();
            properties.setProperty("useSSL", "true");
            properties.setProperty("user", "root");
            properties.setProperty("password", "1234");
            //connection = DriverManager.getConnection(URL, properties);
            connection = DriverManager.getConnection(URL, "root", "1234");
            return connection;

        } catch (ClassNotFoundException e) {
            System.out.print(e.toString());
            JOptionPane.showMessageDialog(null, "Driver não encontrado: " + e.toString());
        } catch (SQLException e) {
            System.out.print(e.toString());
            JOptionPane.showMessageDialog(null, "Problemas de conexão: " + e.toString());
        }
        return null;
    }

    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}
