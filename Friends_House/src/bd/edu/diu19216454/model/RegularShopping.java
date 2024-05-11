package bd.edu.diu19216454.model;

import bd.edu.diu19216454.helpers.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegularShopping extends Shopping {
    
    private int RegularShoppingId;
    
    public RegularShopping() {
    }
    
    public RegularShopping(int RegularShoppingId, int mId, double amount, String date) {
        super(mId, amount, date);
        this.RegularShoppingId = RegularShoppingId;
    }
    
    public int getRegularShoppingId() {
        return RegularShoppingId;
    }
    
    public void setFoodShoppingId(int foodShoppingId) {
        this.RegularShoppingId = RegularShoppingId;
    }
    
    @Override
    public boolean save() {
        
        Connection con = new DBConnection().connection();
        try {
            
            String foodShoppingInsert = "INSERT INTO `RegularShopping` "
                    + " (`RegularShoppingId`, `mId`, `amount`, `date`) "
                    + " VALUES (NULL, ?, ?, ?) ";
            
            PreparedStatement ps = con.prepareStatement(foodShoppingInsert);
            ps.setInt(1, this.getmId());
            ps.setDouble(2, this.getAmount());
            ps.setString(3, this.getDate());
            
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
    
    public ArrayList<RegularShopping> allRegularShopping() {
        
        ArrayList<RegularShopping> RegularShoppingList = new ArrayList<>();
        
        Connection con = new DBConnection().connection();
        try {
            String selectQuery = "SELECT `RegularShoppingId`, RegularShopping.mId, member.name, `amount`, `date` "
                    + " FROM `RegularShopping`, `member` "
                    + " where RegularShopping.mId = member.mId ";
            PreparedStatement ps = con.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                RegularShopping fs = new RegularShopping();
                fs.setRegularShoppingId(rs.getInt("RegularShoppingId"));
                fs.setName(rs.getString("name"));
                fs.setAmount(rs.getDouble("amount"));
                fs.setDate(rs.getString("date"));
                RegularShoppingList.add(fs);
            }
            
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        
        return RegularShoppingList;
    }

    private void setRegularShoppingId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
