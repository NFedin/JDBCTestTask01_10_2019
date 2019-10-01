package com.test.jdbc;

import com.test.jdbc.connector.DBConnection;
import com.test.jdbc.entity.UserEntity;
import com.test.jdbc.repository.UserRepository;

import java.sql.SQLException;

public class Main {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/company?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    static final String USER = "root";
    static final String PASSWORD = "12345";

    public static void main(String[] args) throws SQLException {

        try {
            DBConnection connection = new DBConnection(JDBC_DRIVER, DATABASE_URL, USER, PASSWORD);
            UserRepository userRepository = new UserRepository();
            UserEntity userEntity = userRepository.findByLogin("Dandy", connection);
            System.out.println(userEntity.toString());
            System.out.println("\n=====================\n");
            System.out.println(userRepository.newSecondName("Puppey", "Ivanov", connection));
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Closing connection and releasing resources...");
            DBConnection.closeDB();
        }
    }
}

