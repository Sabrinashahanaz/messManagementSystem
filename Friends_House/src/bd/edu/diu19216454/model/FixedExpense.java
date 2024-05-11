package bd.edu.diu19216454.model;

import bd.edu.diu19216454.helpers.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FixedExpense {

    private int fixedExpenseId;
    private String fixedExpenseType;
    private double amount;
    private String status;

    public FixedExpense() {
    }

    public FixedExpense(int fixedExpenseId, String fixedExpenseType, double amount, String status) {
        this.fixedExpenseId = fixedExpenseId;
        this.fixedExpenseType = fixedExpenseType;
        this.amount = amount;
        this.status = status;
    }

    public int getFixedExpenseId() {
        return fixedExpenseId;
    }

    public void setFixedExpenseId(int fixedExpenseId) {
        this.fixedExpenseId = fixedExpenseId;
    }

    public String getfixedExpenseType() {
        return fixedExpenseType;
    }

    public void setfixedExpenseType(String fixedExpenseType) {
        this.fixedExpenseType = fixedExpenseType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean save() {

        Connection con = new DBConnection().connection();
        try {

            String otherShoppingInsert = "INSERT INTO `fixedexpense` "
                    + " (`fixedExpenseId`, `fixedExpenseType`, `amount`,`status`) "
                    + " VALUES (NULL, ?, ?, ?) ";

            PreparedStatement ps = con.prepareStatement(otherShoppingInsert);

            ps.setString(1, this.fixedExpenseType);
            ps.setDouble(2, this.amount);
            ps.setString(3, this.status);

            int affectedROws = ps.executeUpdate();

            con.close();
            if (affectedROws > 0) {
                return true;
            }

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return false;
    }

    public ArrayList<FixedExpense> allFixedExpenses() {

        ArrayList<FixedExpense> fixedExpenses = new ArrayList<>();

        Connection con = new DBConnection().connection();
        try {
            String selectQuery = "SELECT *  from `fixedexpense`";
            PreparedStatement ps = con.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                FixedExpense fx = new FixedExpense();
                fx.setFixedExpenseId(rs.getInt("fixedExpenseId"));
                fx.setAmount(rs.getDouble("amount"));
                fx.setfixedExpenseType(rs.getString("fixedExpenseType"));
                fx.setStatus(rs.getString("status"));
                
                fixedExpenses.add(fx);
                
            }

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }

        return fixedExpenses;
    }

    public void setFixedExpenseName(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getFixedExpenseName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
