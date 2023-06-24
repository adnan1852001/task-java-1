import java.util.*;
import java.io.*;

class Category {
    String name;
    public ArrayList<Post> posts = new ArrayList<Post>();

    Category(String name){
        this.name = name;
    }

    Category(File file) throws Exception {
        this.name = file.getName();
        File[] files = file.listFiles();
        for(File pf: files){
            posts.add(new Post(pf, this));
        }
    }
    
    public void showAction(){
        System.out.println("Please select one of the following options:");
        System.out.println(" 1. List posts");
        System.out.println(" 2. View post");
        System.out.println(" 3. Add post");
        System.out.println(" 4. Back");
        Scanner input = new Scanner(System.in);

        loop: while (true) {
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
                    break loop;
                default:
                    System.out.println("unknown command");
            }
        }
    }

    public String getName(){
        return this.name;
    }

    public void viewPost(int index) {
        Post post = posts.get(index);
        System.out.println(post.getTitle());
        System.out.println("----------------------");
        System.out.println(post.getContent());
    }

    public void listPosts() {
        for (int i = 0; i < posts.size(); i++) {
            System.out.printf("%d: %s%n",i,posts.get(i).getTitle());
        }
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
        Post post = new Post(title, content, this);
        try {
            post.save(posts.size()+"");
            posts.add(post);
            System.out.println("Post saved!");
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Couldn't save the post!");
        }
    }

    public void save(){
        File folder = new File("categories/" + this.name);
        folder.mkdir();
        System.out.println("category saved!!");
    }
}