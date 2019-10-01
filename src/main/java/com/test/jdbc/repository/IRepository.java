package com.test.jdbc.repository;

import com.test.jdbc.connector.DBConnection;
import com.test.jdbc.entity.UserEntity;

import java.sql.SQLException;

public interface IRepository {

    UserEntity findByLogin(String userName, DBConnection connection) throws SQLException, ClassNotFoundException;

    boolean newSecondName(String userName, String change, DBConnection connection) throws SQLException, ClassNotFoundException;
}
