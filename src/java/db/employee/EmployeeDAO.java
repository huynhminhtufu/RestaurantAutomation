/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.employee;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author huynh
 */
public class EmployeeDAO implements Serializable {
    public int checkLogin(String empName, String password) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select * from Employee where empName = ? and password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, empName);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int type = rs.getInt("empType");
                    return type;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return -1;
    }
}
