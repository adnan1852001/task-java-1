import java.util.*;
import java.io.*;
public class Blog {
    public static void main(String[] args) {
        Blog blog = new Blog();
        blog.askUser();
    }

    public ArrayList<Post> posts = new ArrayList<Post>();

    public void askUser() {
        try {
            updatePosts();
        } catch (Exception ex) {
            System.out.println("Can't find data folder!!");
            System.exit(1);
        }
        System.out.println("Welcome to our blog!");
        System.out.println("Please select one of the following options:");
        System.out.println(" 1. List Posts");
        System.out.println(" 2. View Post");
        System.out.println(" 3. Add Post");
        System.out.println(" 4. Exit");
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Selection: ");
            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    listPosts();
                    break;
                case 2:
                    System.out.print("Enter the post index: ");
                    int index = input.nextInt();
                    viewPost(index);
                    break;
                case 3:
                    addPost();
                    break;
                case 4:
                    System.out.println("Bye bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("unknown command");
            }
        }
    }

    public void updatePosts() throws Exception {
        File file = new File("data/");
        File[] files = file.listFiles();
        for(File pf: files){
            posts.add(new Post(pf));
        }
    }

    public void listPosts() {
        for (int i = 0; i < posts.size(); i++) {
            System.out.printf("%d: %s%n",i,posts.get(i).getTitle());
        }
    }

    public void viewPost(int index) {
        Post post = posts.get(index);
        System.out.println(post.getTitle());
        System.out.println("----------------------");
        System.out.println(post.getContent());
    }

    public void addPost() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter post title: ");
        String title = input.nextLine();
        String content = "";
        System.out.println("Enter the post content with end of {{END}}:");
        while (true) {
            String line = input.nextLine();
            if (line.equals("{{END}}"))
                break;
            content += line;
        }
        Post post = new Post(title, content);
        try {
            post.save(posts.size()+"");
            posts.add(post);
            System.out.println("Post saved!");
        } catch (Exception ex) {
            System.out.println("Couldn't save the post!");
        }
    }
}
