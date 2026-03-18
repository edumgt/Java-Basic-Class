package com.example;


public class Player {

    private String name;

    private int endurance;

    private int sprint;

    private int dribble;

    private int passing;

    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting) / 5.00;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEndurance(int endurance) {
        validateStat(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        validateStat(endurance, "Sprint");

        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        validateStat(endurance, "Dribble");

        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        validateStat(endurance, "Passing");

        this.passing = passing;
    }

    private void setShooting(int shooting) {
        validateStat(endurance, "Shooting");

        this.shooting = shooting;
    }

    private void validateStat(int stat, String nameOfTheStat) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(nameOfTheStat + " should be between 0 and 100.");
        }
    }
}
