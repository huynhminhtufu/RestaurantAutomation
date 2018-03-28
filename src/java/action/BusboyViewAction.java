/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import db.table.TableDAO;
import db.table.TableDTO;
import java.util.List;

/**
 *
 * @author NiChuot
 */
public class BusboyViewAction {

    private List<TableDTO> tableList;
    private final String TRUE = "true";

    public BusboyViewAction() {
    }

    public String execute() throws Exception {

        TableDAO dao = new TableDAO();
        dao.showTableBusboy();
        tableList = dao.getTableList();

        return TRUE;
    }

}
