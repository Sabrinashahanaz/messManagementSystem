package bd.edu.diu19216454.model;

import bd.edu.diu19216454.helpers.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Member {

    private int mId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String NID;
    private String address;
    private String type;
    private String status;

    public Member() {
    }

    public Member(int mId, String name, String email, String password, String phone, String NID, String address, String type, String status) {
        this.mId = mId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.NID = NID;
        this.address = address;
        this.type = type;
        this.status = status;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String gettype() {
        return type;
    }

    public void setRole(String type) {
        this.type = type;
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

            String memberInsertQuery = "INSERT INTO `member` "
                    + "(`mId`, `name`, `phone`, `email`, `password`, `address`, `type`, `status`, `NID`) "
                    + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(memberInsertQuery);

            ps.setString(1, this.name);
            ps.setString(2, this.phone);
            ps.setString(3, this.email);
            ps.setString(4, this.password);
            ps.setString(5, this.address);
            ps.setString(6, this.type);
            ps.setString(7, this.status);
            ps.setString(8, this.NID);

//            ResultSet rs = ps.executeQuery();
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

    public static ArrayList<Member> allMember() {

        ArrayList<Member> membersList = new ArrayList<>();

        Connection con = new DBConnection().connection();
        try {
            String selectQuery = "SELECT * FROM `member`";
            PreparedStatement ps = con.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Member m = new Member();
                m.setmId(rs.getInt("mId"));
                m.setName(rs.getString("name"));
                m.setAddress(rs.getString("address"));
                m.setNID(rs.getString("NID"));
                m.setEmail(rs.getString("email"));
                m.setPhone(rs.getString("phone"));
                m.setRole(rs.getString("type"));
                m.setPassword(rs.getString("password"));
                m.setStatus(rs.getString("status"));
                membersList.add(m);
            }

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }

        return membersList;
    }

    public boolean update() {
        Connection con = new DBConnection().connection();
        String updateQuery = "UPDATE `member` SET name=?, phone=?, email=?, address=?, type=?, status=?, NID=? WHERE mId=?";
        try {
            PreparedStatement pst = con.prepareStatement(updateQuery);

            pst.setString(1, this.name);
            pst.setString(2, this.phone);
            pst.setString(3, this.email);

            pst.setString(4, this.address);
            pst.setString(5, this.type);
            pst.setString(6, this.status);
            pst.setString(7, this.NID);

            pst.setInt(8, this.mId);

            int affectedROws = pst.executeUpdate();

            con.close();
            if (affectedROws > 0) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public static Member logIn(String email, String password) {
        Connection con = new DBConnection().connection();
        try {
            String loginQuerie = "SELECT * FROM `member` WHERE email=? and password=?";
            PreparedStatement ps = con.prepareStatement(loginQuerie);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Member m = new Member();
                m.setmId(rs.getInt("mId"));
                m.setName(rs.getString("name"));
                m.setAddress(rs.getString("address"));
                m.setNID(rs.getString("NID"));
                m.setEmail(rs.getString("email"));
                m.setPhone(rs.getString("phone"));
                m.setRole(rs.getString("type"));
                m.setPassword(rs.getString("password"));
                m.setStatus(rs.getString("status"));

                return m;
            }

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }
}
