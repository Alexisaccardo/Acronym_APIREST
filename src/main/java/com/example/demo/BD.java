package com.example.demo;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BD {
    public BD() {
    }
    String error_register = "No se pudo registrar el habitante";
    String error_edit = "No se pudo editar el habitante";

    public static int Select_acronym(String acronym) throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/product_acronym";
        String username = "root";
        String password = "";

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String consultaSQL = "SELECT * FROM acronym WHERE name = ?";

        PreparedStatement statement = connection.prepareStatement(consultaSQL);
        statement.setString(1,  acronym); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet = statement.executeQuery();

        // Procesar el resultado si existe
        if (resultSet.next()) {
            int expiration = resultSet.getInt("expiration_days");
            return expiration;

        }
        // Cerrar recursos
        resultSet.close();
        statement.close();
        connection.close();
        return 0;
    }


    public static String Select_date(String id) throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/product_acronym";
        String username = "root";
        String password = "";

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String consultaSQL = "SELECT * FROM product WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(consultaSQL);
        statement.setString(1,  id); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet = statement.executeQuery();

        // Procesar el resultado si existe
        if (resultSet.next()) {
            String date = resultSet.getString("creation_date");
            return date;

        }
        // Cerrar recursos
        resultSet.close();
        statement.close();
        connection.close();
        return "";
    }


    public Product register(String id, String name, String status, String name_acronym) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/product_acronym";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product");

            // Sentencia INSERT
            String sql = "INSERT INTO product (id , name, status, creation_date, name_acronym) VALUES (?, ?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, status);
            preparedStatement.setString(4, String.valueOf(LocalDateTime.now()));
            preparedStatement.setString(5, name_acronym);
            // Ejecutar la sentencia
            int files = preparedStatement.executeUpdate();

            if (files > 0) {
                System.out.println("\"Producto agregado exitosamente.\"");
                return new Product(id,name,status, name_acronym);
            } else {
                System.out.println("No se pudo registrar el producto");
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Product(null,null,null, null);
    }

    public Product editar(String id, String status) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/product_acronym";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();
        String consulta = "UPDATE product SET status = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection2.prepareStatement(consulta);
        preparedStatement.setString(1, status);
        preparedStatement.setString(2, id);

        int filasActualizadas = preparedStatement.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Producto editado exitosamente");
            return new Product(id,null,status, null);
        } else {
            System.out.println("No se pudo actualizar el Producto");
        }

        preparedStatement.close();
        connection2.close();
        return new Product(null,null,null,null);
    }
}


