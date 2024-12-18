/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        try {
            String userTable = "create table if not exists user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),mobileNumber varchar(10),address varchar(200),password varchar(200),status varchar(20),UNIQUE (email))";
            String adminDetails = "insert ignore into user(name, email, mobileNumber, address, password, status) values('admin', 'admin@gmail.com', '1234567890', 'India', 'admin', 'true')";
            String coachTable = "create table if not exists coach(coachID varchar(20) primary key,coachName varchar(100), gender varchar(10), experience int, sportsName varchar(100))";
            String teamsTable = "create table if not exists teams(teamID varchar(20) primary key, teamName varchar(100), coachID varchar(20), sportsName varchar(100), foreign key (coachID) references coach(coachID))";
            String playersTable = "create table if not exists players(playerID varchar(20) primary key, playerName varchar(100), gender varchar(10), height int, weight decimal(5,2), teamID varchar(20), foreign key (teamID) references teams(teamID))";
            String equipmentsTable = "create table if not exists equipments(equipmentID varchar(20) primary key, equipmentName varchar(100), quantity int, playerID varchar(20), foreign key (playerID) references players(playerID))";
            String managerTable = "create table if not exists manager(managerID varchar(20) primary key, managerName varchar(100), phoneNumber varchar(10), teamID varchar(20), foreign key (teamID) references teams(teamID))";
            DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
            DbOperations.setDataOrDelete(adminDetails, "Admin details added Successfully");
            DbOperations.setDataOrDelete(coachTable, "Coach Table Created Successfully");
            DbOperations.setDataOrDelete(teamsTable, "Teams Table Created Successfully");
            DbOperations.setDataOrDelete(playersTable, "Players Table Created Successfully");
            DbOperations.setDataOrDelete(equipmentsTable, "Equipments Table Created Successfully");
            DbOperations.setDataOrDelete(managerTable, "Manager Table Created Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
