/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.PlayersModel;
/**
 *
 * @author chitr
 */
public class PlayersDao {
    public static void insert(PlayersModel players) {
        String query = "insert into players (playerID, playerName, gender, height, weight, teamID) values('"+players.getPlayerID()+"','"+players.getPlayerName()+"', '"+players.getGender()+"', '"+players.getHeight()+"', '"+players.getWeight()+"', '"+players.getTeamID()+"')";
        DbOperations.setDataOrDelete(query, "Player Details Added Successfully");
    }

    public static ArrayList<PlayersModel> getAllRecords() {
        ArrayList<PlayersModel> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from players");
            while (rs.next()) {
                PlayersModel players = new PlayersModel();
                players.setPlayerID(rs.getString("playerID"));
                players.setPlayerName(rs.getString("playerName"));
                players.setGender(rs.getString("gender"));
                players.setHeight(rs.getInt("height"));
                players.setWeight(rs.getFloat("weight"));
                players.setTeamID(rs.getString("teamID"));
                arrayList.add(players);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static void delete(String playerID) {
        String query = "delete from players where playerID = '" + playerID + "'";
        DbOperations.setDataOrDelete(query, "Player Detail deleted successfully");

    }

    public static ArrayList<PlayersModel> search(String playerID) {
        ArrayList<PlayersModel> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from players where playerID = '" + playerID + "'");
            if (rs.next()) {
                PlayersModel players = new PlayersModel();
                players.setPlayerID(rs.getString("playerID"));
                players.setPlayerName(rs.getString("playerName"));
                players.setGender(rs.getString("gender"));
                players.setHeight(rs.getInt("height"));
                players.setWeight(rs.getFloat("weight"));
                players.setTeamID(rs.getString("teamID"));
                arrayList.add(players);
            } else {
                JOptionPane.showMessageDialog(null, "This Player ID doesn't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
   
    public static void update(PlayersModel players){
        String query = "update players set playerID = '"+players.getPlayerID()+"', playerName = '" + players.getPlayerName() + "', gender = '" + players.getGender() + "', height = '" + players.getHeight() + "', weight = '" + players.getWeight() + "' where playerID ='"+players.getPlayerID()+"' ";
        DbOperations.setDataOrDelete(query, "Player Details Updated Successfully");
    }
}
    
