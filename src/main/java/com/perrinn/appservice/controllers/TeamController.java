package com.perrinn.appservice.controllers;

import com.perrinn.appservice.beans.TeamEntity;
import com.perrinn.appservice.beans.TeamProfileEntity;
import com.perrinn.appservice.dao.TeamDAO;
import com.perrinn.appservice.dao.WorkerDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class will control all team related transaction, every relational table related to team
 * will be controlled from this controller too.
 *
 * @author Alessandro
 * @since 16.09.2016
 */
@Controller
@RequestMapping("/team")
public class TeamController {

    //TODO: for testing purpose the field aren't mandatory but they'll need to be.
    @RequestMapping(value = "/leave",method = RequestMethod.GET)
    public @ResponseBody String leaveTeam(@RequestParam(value = "key", required = false) String userkey, @RequestParam(value = "team",required = false) Integer teamId){
        TeamDAO dao = new TeamDAO();
        TeamEntity team = dao.getById(teamId);
        if(team != null){
        }
        // check if team exists
        // check if user is related to the key
        // check if the user is related to the team
        // check if the user is not a team leader
            // remove the profile_team entry
        // return error code and message

        return "Leavingteam";
    }
}
