package ObjectsAndClassesEXERCISE.Article2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Article> articles = new ArrayList<>();
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= number ; i++) {
            String articleData = scanner.nextLine();
            String title = articleData.split(", ")[0];
            String content = articleData.split(", ")[1];
            String author = articleData.split(", ")[2];
            Article currentArticle = new Article(title, content, author);
            articles.add(currentArticle);
        }
        String word = scanner.nextLine();
        for (Article article : articles){
            System.out.printf("%s - %s: %s%n", article.getTitle(), article.getContent(), article.getAuthor());
        }
    }
}
