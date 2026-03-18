package com.example;


import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;

    private List<Player> players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerName) {
        if (players.stream().anyMatch(p -> p.getName().equals(playerName))) {
            Player playerToRemove = players.stream().filter(p -> p.getName().equals(playerName)).findFirst().get();
            players.remove(playerToRemove);
        } else {
            throw new IllegalArgumentException("Player " + playerName + " is not in " + name + " team.");
        }

    }

    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).sum();

    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", name, Math.round(getRating()));
    }

}
