/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ManagerModel;

/**
 *
 * @author chitr
 */
public class ManagerDao {
    public static void insert(ManagerModel manager) {
        String query = "insert into manager (managerID, managerName, phoneNumber, teamID) values('"+manager.getManagerID()+"','"+manager.getManagerName()+"', '"+manager.getPhoneNumber()+"', '"+manager.getTeamID()+"')";
        DbOperations.setDataOrDelete(query, "Manager Details Added Successfully");
    }

    public static ArrayList<ManagerModel> getAllRecords() {
        ArrayList<ManagerModel> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from manager");
            while (rs.next()) {
                ManagerModel manager = new ManagerModel();
                manager.setManagerID(rs.getString("managerID"));
                manager.setManagerName(rs.getString("managerName"));
                manager.setPhoneNumber(rs.getString("phoneNumber"));
                manager.setTeamID(rs.getString("teamID"));
                arrayList.add(manager);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static void delete(String managerID) {
        String query = "delete from manager where managerID = '" + managerID + "'";
        DbOperations.setDataOrDelete(query, "Manager Detail deleted successfully");

    }

    public static ArrayList<ManagerModel> search(String managerID) {
        ArrayList<ManagerModel> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from manager where managerID = '" + managerID + "'");
            if (rs.next()) {
                ManagerModel manager = new ManagerModel();
                manager.setManagerID(rs.getString("managerID"));
                manager.setManagerName(rs.getString("managerName"));
                manager.setPhoneNumber(rs.getString("PhoneNumber"));
                manager.setTeamID(rs.getString("TeamID"));
                arrayList.add(manager);
            } else {
                JOptionPane.showMessageDialog(null, "This Manager ID doesn't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
   
    public static void update(ManagerModel manager){
        String query = "update manager set managerID = '"+manager.getManagerID()+"', managerName = '" + manager.getManagerName() + "', phoneNumber  = '" + manager.getPhoneNumber() + "', teamID = '" + manager.getTeamID() + "' where managerID ='"+manager.getManagerID()+"' ";
        DbOperations.setDataOrDelete(query, "Manager Details Updated Successfully");
    }
}
