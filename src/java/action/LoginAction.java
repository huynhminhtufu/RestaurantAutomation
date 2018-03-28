/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionContext;
import db.employee.EmployeeDAO;
import java.util.Map;

/**
 *
 * @author huynh
 */
public class LoginAction {
    
    private String empName;
    private String password;
    private boolean loginStatus;
    private final String ADMIN = "admin";
    private final String BUSBOY = "busboy";
    private final String COOKER = "cooker";
    private final String HOST = "host";
    private final String WAITER = "waiter";
    private final String FALSE = "false";
    
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        loginStatus = true;
        EmployeeDAO dao = new EmployeeDAO();
        int login = dao.checkLogin(empName, password);
        if (login != -1) {
            Map session = ActionContext.getContext().getSession();
            if (session != null) {
                session.put("TYPE", login);
                session.put("EMPNAME", empName);
            }
        }
        switch (login) {
            case 0:
                return ADMIN;
            case 1:
                return BUSBOY;
            case 2:
                return COOKER;
            case 3:
                return HOST;
            case 4:
                return WAITER;
            default:
                loginStatus = false;
                return FALSE;
        }
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
    
}
