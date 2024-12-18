/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.TeamsModel;
/**
 *
 * @author chitr
 */
public class TeamsDao {
    public static void insert(TeamsModel teams) {
        String query = "insert into teams (teamID, teamName, coachID, sportsName) values('"+teams.getTeamID()+"','"+teams.getTeamName()+"', '"+teams.getCoachID()+"', '"+teams.getSportsName()+"')";
        DbOperations.setDataOrDelete(query, "Team Details Added Successfully");
    }

    public static ArrayList<TeamsModel> getAllRecords() {
        ArrayList<TeamsModel> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from teams");
            while (rs.next()) {
                TeamsModel teams = new TeamsModel();
                teams.setTeamID(rs.getString("teamID"));
                teams.setTeamName(rs.getString("teamName"));
                teams.setCoachID(rs.getString("coachID"));
                teams.setSportsName(rs.getString("sportsName"));
                arrayList.add(teams);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static void delete(String teamID) {
        String query = "delete from teams where teamID = '" + teamID + "'";
        DbOperations.setDataOrDelete(query, "Coach Detail deleted successfully");

    }
    
    public static ArrayList<TeamsModel> search(String teamID) {
        ArrayList<TeamsModel> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from teams where teamID = '" + teamID + "'");
            if (rs.next()) {
                TeamsModel team = new TeamsModel();
                team.setTeamID(rs.getString("teamID"));
                team.setTeamName(rs.getString("teamName"));
                team.setCoachID(rs.getString("coachID"));
                team.setSportsName(rs.getString("sportsName"));
                arrayList.add(team);
            } else {
                JOptionPane.showMessageDialog(null, "This Coach ID doesn't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
   
    public static void update(TeamsModel teams){
        String query = "update teams set teamID = '"+teams.getTeamID()+"', teamName = '" + teams.getTeamName() + "', coachID = '" + teams.getCoachID() + "',sportsName = '" + teams.getSportsName() + "' where teamID ='"+teams.getTeamID()+"' ";
        DbOperations.setDataOrDelete(query, "Team Details Updated Successfully");
    }
}
