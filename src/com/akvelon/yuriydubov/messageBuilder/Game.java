package com.akvelon.yuriydubov.messageBuilder;

public class Game {
   private String teamA;
   private String teamB;
   private int teamAscore;
   private int teamBscore;

   public Game(String teamA, String teamB, int teamAscore, int teamBscore) {
      this.teamA = teamA;
      this.teamB = teamB;
      this.teamAscore = teamAscore;
      this.teamBscore = teamBscore;
   }

   public String getTeamA() {
      return teamA;
   }

   public void setTeamA(String teamA) {
      this.teamA = teamA;
   }

   public String getTeamB() {
      return teamB;
   }

   public void setTeamB(String teamB) {
      this.teamB = teamB;
   }

   public int getTeamAscore() {
      return teamAscore;
   }

   public void setTeamAscore(int teamAscore) {
      this.teamAscore = teamAscore;
   }

   public int getTeamBscore() {
      return teamBscore;
   }

   public void setTeamBscore(int teamBscore) {
      this.teamBscore = teamBscore;
   }
}
