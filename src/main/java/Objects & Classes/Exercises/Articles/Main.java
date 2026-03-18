package ObjectsAndClassesEXERCISE.Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String articleData = scanner.nextLine();
        String title = articleData.split(", ")[0];
        String content = articleData.split(", ")[1];
        String author = articleData.split(", ")[2];
        Article currentArticle = new Article(title, content, author);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= number ; i++) {
            String command = scanner.nextLine();
            String currentCommand = command.split(": ")[0];
            String newValue = command.split(": ")[1];
            switch (currentCommand){
                case "Edit":
                    currentArticle.edit(newValue);
                    break;
                case "ChangeAuthor":
                    currentArticle.changeAuthor(newValue);
                    break;
                case "Rename":
                    currentArticle.rename(newValue);
                    break;
            }
        }
        System.out.println(currentArticle);
    }
}
