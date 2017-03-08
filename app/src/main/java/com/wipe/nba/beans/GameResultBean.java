package com.wipe.nba.beans;

/**
 * Created by Administrator on 2017/2/6.
 */
public class GameResultBean {

    private String[] gameStatus;
    private int status;
    private String score;
    private String teamName1;
    private String teamName2;
    private String teamLogo1;
    private String teamLogo2;

    public GameResultBean() {
    }


    public GameResultBean(String[] gameStatus, String score, String teamName1, String teamName2, String teamLogo1, String teamLogo2, int status) {
        this.score = score;
        this.status = status;

        this.gameStatus = gameStatus;
        this.teamName1 = teamName1;
        this.teamName2 = teamName2;
        this.teamLogo1 = teamLogo1;
        this.teamLogo2 = teamLogo2;
    }


    public int getStatus() {
        return status;
    }

    public String getScore() {
        return score;
    }

    public String getTeamName1() {
        return teamName1;
    }

    public String getTeamName2() {
        return teamName2;
    }

    public String getTeamLogo1() {
        return teamLogo1;
    }

    public String getTeamLogo2() {
        return teamLogo2;
    }

    public String[] getGameStatus() {
        return gameStatus;
    }
}
