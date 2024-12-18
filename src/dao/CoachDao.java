/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.CoachModel;
import java.sql.*;

public class CoachDao {

    public static void insert(CoachModel coach) {
        String query = "insert into coach (coachID,coachName,gender,experience,sportsName) values('" + coach.getCoachID() + "','" + coach.getCoachName() + "','" + coach.getGender() + "','" + coach.getExperience() + "','" + coach.getSportsName() + "')";
        DbOperations.setDataOrDelete(query, "Coach Details Added Successfully");
    }

    public static ArrayList<CoachModel> getAllRecords() {
        ArrayList<CoachModel> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from coach");
            while (rs.next()) {
                CoachModel coach = new CoachModel();
                coach.setCoachID(rs.getString("coachID"));
                coach.setCoachName(rs.getString("coachName"));
                coach.setGender(rs.getString("gender"));
                coach.setExperience(rs.getInt("experience"));
                coach.setSportsName(rs.getString("sportsName"));
                arrayList.add(coach);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static void delete(String coachID) {
        String query = "delete from coach where coachID = '" + coachID + "'";
        DbOperations.setDataOrDelete(query, "Coach Detail deleted successfully");

    }

    public static ArrayList<CoachModel> search(String coachID) {
        ArrayList<CoachModel> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from coach where coachID = '" + coachID + "'");
            if (rs.next()) {
                CoachModel coach = new CoachModel();
                coach.setCoachID(rs.getString("coachID"));
                coach.setCoachName(rs.getString("coachName"));
                coach.setGender(rs.getString("gender"));
                coach.setExperience(rs.getInt("experience"));
                coach.setSportsName(rs.getString("sportsName"));
                arrayList.add(coach);
            } else {
                JOptionPane.showMessageDialog(null, "This Coach ID doesn't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void update(CoachModel coach){
        String query = "update coach set coachID = '"+coach.getCoachID()+"', coachName = '" + coach.getCoachName() + "', gender = '" + coach.getGender() + "', experience = '" + coach.getExperience() + "', sportsName = '" + coach.getSportsName() + "' where coachID ='"+coach.getCoachID()+"' ";
        DbOperations.setDataOrDelete(query, "Coach Details Updated Successfully");
    }
}
