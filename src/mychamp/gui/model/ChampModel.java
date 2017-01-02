/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mychamp.be.Team;

/**
 *
 * @author Thomas
 */
public class ChampModel {

    private final ArrayList<Team> teams;
    private final ObservableList<String> teamNames;

    private static ChampModel instance;

    //Singleton
    public static ChampModel getInstance()
    {
        if (instance == null)
        {
            instance = new ChampModel();
        }
        return instance;
    }

    private ChampModel()
    {
        this.teamNames = FXCollections.observableArrayList();
        teams = new ArrayList<>();
    }

    /**
     * Creates a new team
     * @param name - Name of the team
     */
    public void addTeam(String name)
    {
        Team team = new Team(name);
        teams.add(team);
        setTeamNames();
    }

    /**
     * Returns ArrayList of all the teams
     * @return - Team object
     */
    public ArrayList<Team> getTeams()
    {
        return teams;
    }
    
    /**
     * Returns ObservableList of all team names
     * @return - Team names
     */
    public ObservableList<String> getTeamNames()
    {
        
        return teamNames;
    }

    /**
     * Sets the team names
     */
    private void setTeamNames()
    {
        teamNames.clear();
        for (Team team : teams)
        {
            teamNames.add(team.getName());
        }
    }

}
