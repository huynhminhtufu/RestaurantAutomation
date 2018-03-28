/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.table;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author NiChuot
 */
public class TableDAO implements Serializable {
    
    private List<TableDTO> tableList;

    public List<TableDTO> getTableList() {
        return tableList;
    }
    
    public void showTableBusboy()
            throws NamingException, SQLException {
        
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select * from TableInfo";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (tableList == null) {
                        tableList = new ArrayList<>();
                    }
                    int tableID = rs.getInt("tableID");
                    boolean isClean = rs.getBoolean("isClean");
                    boolean isReady = rs.getBoolean("isReady");
                    tableList.add(new TableDTO(tableID, isClean, isReady));
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
        
    }
    
    public void showTableHost() {
        
    }
    
}
