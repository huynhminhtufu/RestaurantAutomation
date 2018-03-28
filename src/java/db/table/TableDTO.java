/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.table;

import java.io.Serializable;

/**
 *
 * @author NiChuot
 */
public class TableDTO implements Serializable {

    private int tableID;
    private boolean isClean;
    private boolean isReady;

    public TableDTO(int tableID, boolean isClean, boolean isReady) {
        this.tableID = tableID;
        this.isClean = isClean;
        this.isReady = isReady;
    }

    public TableDTO() {
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public boolean isIsClean() {
        return isClean;
    }

    public void setIsClean(boolean isClean) {
        this.isClean = isClean;
    }

    public boolean isIsReady() {
        return isReady;
    }

    public void setIsReady(boolean isReady) {
        this.isReady = isReady;
    }

}
