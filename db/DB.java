package db;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.*;
import java.util.Properties;

public class DB {

    public static Connection conexao = null;


    // Conectando com o banco de dados
    public static Connection getConnection() {

        if (conexao == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conexao = DriverManager.getConnection(url, props);
            }
            catch(SQLException e){
                throw new DbException("Codigo-2: " + e.getMessage());
            }
        }
        return conexao;
    }

    public static void closeConnection(){
        if(conexao != null){
            try{
                conexao.close();
            }
            catch(SQLException e){
                throw new DbException("Codigo-3: " + e.getMessage());
            }
        }
    }

    // Lendo os arquivos de configuração
    public static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException("Codigo-1: " +e.getMessage());
        }
    }

    public  static void closeStatement(Statement statement){
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new DbException("Codigo-4: " + e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new DbException("Codigo-5: " + e.getMessage());
            }
        }
    }
}
