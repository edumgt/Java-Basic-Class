import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiniBoardConsole {
    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("\n== Mini Board ==");
                System.out.println("1. Write post");
                System.out.println("2. List posts");
                System.out.println("3. Search by title keyword");
                System.out.println("0. Exit");
                System.out.print("Select: ");
                int menu = Integer.parseInt(scanner.nextLine());

                switch (menu) {
                    case 1:
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Content: ");
                        String content = scanner.nextLine();
                        posts.add(new Post(title, content, LocalDateTime.now()));
                        break;
                    case 2:
                        for (int i = 0; i < posts.size(); i++) {
                            System.out.println((i + 1) + ". " + posts.get(i));
                        }
                        break;
                    case 3:
                        System.out.print("Keyword: ");
                        String keyword = scanner.nextLine().toLowerCase();
                        for (Post post : posts) {
                            if (post.title.toLowerCase().contains(keyword)) {
                                System.out.println(post);
                            }
                        }
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid menu.");
                }
            }
        }
    }

    static class Post {
        private final String title;
        private final String content;
        private final LocalDateTime createdAt;

        Post(String title, String content, LocalDateTime createdAt) {
            this.title = title;
            this.content = content;
            this.createdAt = createdAt;
        }

        @Override
        public String toString() {
            return "[" + createdAt + "] " + title + " - " + content;
        }
    }
}
