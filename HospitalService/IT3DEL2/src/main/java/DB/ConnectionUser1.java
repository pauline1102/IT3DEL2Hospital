package DB;

import Aftale.Aftale;
import Aftale.AftaleController;

import javax.validation.constraints.Null;
import java.sql.*;

public class ConnectionUser1 {
    private final Connection connection;

    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private double cprdata;
    private String CPRdata="";
    private Date datedata;
    private String DATEdata="";
    private AftaleController aftaleController;

    public ConnectionUser1(Connection connection) {
        this.connection = connection;

    }

}

