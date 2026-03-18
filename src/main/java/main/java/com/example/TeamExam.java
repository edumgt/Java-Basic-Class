package com.example;

import java.util.HashMap;
import java.util.Scanner;

public class TeamExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Team> teams = new HashMap<>();

        System.out.println("===== ⚽ 팀 관리 프로그램 =====");
        System.out.println("사용 가능한 명령어:");
        System.out.println("  Team;<팀이름>");
        System.out.println("  Add;<팀이름>;<선수이름>;<스탯1>;<스탯2>;<스탯3>;<스탯4>;<스탯5>");
        System.out.println("  Remove;<팀이름>;<선수이름>");
        System.out.println("  Rating;<팀이름>");
        System.out.println("  END (종료)");
        System.out.println("============================\n");

        System.out.print("명령어를 입력하세요: ");
        String command = scanner.nextLine().trim();

        while (!command.equalsIgnoreCase("END")) {
            String[] data = command.split(";");
            String currentCommand = data[0];

            switch (currentCommand) {
                case "Team":
                    if (data.length < 2) {
                        System.out.println("⚠ 팀 이름을 입력해야 합니다. 예: Team;Barcelona");
                        break;
                    }
                    String teamName = data[1];
                    try {
                        Team team = new Team(teamName);
                        teams.put(team.getName(), team);
                        System.out.println("✅ 팀 생성 완료: " + teamName);
                    } catch (IllegalArgumentException e) {
                        System.out.println("⚠ 오류: " + e.getMessage());
                    }
                    break;

                case "Add":
                    if (data.length < 8) {
                        System.out.println("⚠ Add 명령어 형식: Add;<팀이름>;<선수이름>;<스탯1>;<스탯2>;<스탯3>;<스탯4>;<스탯5>");
                        break;
                    }
                    String addTeamName = data[1];
                    if (!teams.containsKey(addTeamName)) {
                        System.out.println("⚠ 팀 " + addTeamName + " 은(는) 존재하지 않습니다.");
                        break;
                    }
                    try {
                        Player player = new Player(
                                data[2],
                                Integer.parseInt(data[3]),
                                Integer.parseInt(data[4]),
                                Integer.parseInt(data[5]),
                                Integer.parseInt(data[6]),
                                Integer.parseInt(data[7])
                        );
                        teams.get(addTeamName).addPlayer(player);
                        System.out.println("✅ 선수 추가 완료: " + player.getName() + " → 팀 " + addTeamName);
                    } catch (IllegalArgumentException e) {
                        System.out.println("⚠ 오류: " + e.getMessage());
                    }
                    break;

                case "Remove":
                    if (data.length < 3) {
                        System.out.println("⚠ Remove 명령어 형식: Remove;<팀이름>;<선수이름>");
                        break;
                    }
                    String removeTeamName = data[1];
                    String playerName = data[2];
                    if (!teams.containsKey(removeTeamName)) {
                        System.out.println("⚠ 팀 " + removeTeamName + " 은(는) 존재하지 않습니다.");
                        break;
                    }
                    try {
                        teams.get(removeTeamName).removePlayer(playerName);
                        System.out.println("✅ 선수 제거 완료: " + playerName + " → 팀 " + removeTeamName);
                    } catch (IllegalArgumentException e) {
                        System.out.println("⚠ 오류: " + e.getMessage());
                    }
                    break;

                case "Rating":
                    if (data.length < 2) {
                        System.out.println("⚠ Rating 명령어 형식: Rating;<팀이름>");
                        break;
                    }
                    String ratingTeamName = data[1];
                    if (!teams.containsKey(ratingTeamName)) {
                        System.out.println("⚠ 팀 " + ratingTeamName + " 은(는) 존재하지 않습니다.");
                        break;
                    }
                    System.out.println("📊 팀 " + ratingTeamName + " 평점: " + teams.get(ratingTeamName));
                    break;

                default:
                    System.out.println("❓ 알 수 없는 명령어입니다. 다시 확인하세요.");
            }

            System.out.print("\n명령어를 입력하세요: ");
            command = scanner.nextLine().trim();
        }

        System.out.println("프로그램을 종료합니다. 👋");
        scanner.close();
    }
}
