import java.util.*;
import java.io.*;

public class Post {
    private String title;
    private String content;
    private Category category;
    
    public Post(File file, Category category) throws Exception{
        Scanner fileInput = new Scanner(file);
        if (!fileInput.hasNext())
            System.out.print("this file is empty");
        this.title = fileInput.nextLine();
        this.content = "";
        while(fileInput.hasNext())
            this.content += fileInput.nextLine();
        this.category = category;
        fileInput.close();
    }
    
    public Post(String title, String content,Category category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getContent(){
        return this.content;
    }

    public void save(String fileName) throws Exception {
        PrintWriter pw = new PrintWriter("categories/"+this.category.getName() + "/"+fileName+".txt");
        pw.println(title);
        pw.println(content);
        pw.close();
    }
}