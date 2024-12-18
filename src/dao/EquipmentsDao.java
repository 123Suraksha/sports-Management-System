/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.EquipmentsModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author chitr
 */
public class EquipmentsDao {
    public static void insert(EquipmentsModel equipments) {
        String query = "insert into equipments (equipmentID, equipmentName, quantity, playerID) values('"+equipments.getEquipmentID()+"','"+equipments.getEquipmentName()+"', '"+equipments.getQuantity()+"', '"+equipments.getPlayerID()+"')";
        DbOperations.setDataOrDelete(query, "Equipment Details Added Successfully");
    }

    public static ArrayList<EquipmentsModel> getAllRecords() {
        ArrayList<EquipmentsModel> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from equipments");
            while (rs.next()) {
                EquipmentsModel equipments = new EquipmentsModel();
                equipments.setEquipmentID(rs.getString("equipmentID"));
                equipments.setEquipmentName(rs.getString("equipmentName"));
                equipments.setQuantity(rs.getInt("quantity"));
                equipments.setPlayerID(rs.getString("playerID"));
                arrayList.add(equipments);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static void delete(String equipmentID) {
        String query = "delete from equipments where equipmentID = '" + equipmentID + "'";
        DbOperations.setDataOrDelete(query, "Equipment Detail deleted successfully");

    }
    
    public static ArrayList<EquipmentsModel> search(String equipmentID) {
        ArrayList<EquipmentsModel> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from equipments where equipmentID = '" + equipmentID + "'");
            if (rs.next()) {
                EquipmentsModel equipments = new EquipmentsModel();
                equipments.setEquipmentID(rs.getString("equipmentID"));
                equipments.setEquipmentName(rs.getString("equipmentName"));
                equipments.setQuantity(rs.getInt("quantity"));
                equipments.setPlayerID(rs.getString("playerID"));
                arrayList.add(equipments);
            } else {
                JOptionPane.showMessageDialog(null, "This Equipment ID doesn't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
   
    public static void update(EquipmentsModel equipments){
        String query = "update equipments set equipmentID = '"+equipments.getEquipmentID()+"', equipmentName = '" + equipments.getEquipmentName()+ "', quantity = '" + equipments.getQuantity()+ "',playerID = '" + equipments.getPlayerID()+ "' where equipmentID ='"+equipments.getEquipmentID()+"' ";
        DbOperations.setDataOrDelete(query, "Team Details Updated Successfully");
    }
    
}
