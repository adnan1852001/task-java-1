import java.util.*;
import java.io.*;
class Post {
    private String title;
    private String content;
    
    public Post(File file) throws Exception{
        Scanner fileInput = new Scanner(file);
        if (!fileInput.hasNext())
            System.out.print("this file is empty");
        this.title = fileInput.nextLine();
        this.content = "";
        while(fileInput.hasNext())
            this.content += fileInput.nextLine() + "\n";
        fileInput.close();
    }
    
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getContent(){
        return this.content;
    }

    public void save(String fileName) throws Exception {
        PrintWriter pw = new PrintWriter("data/"+fileName+".txt");
        pw.println(title);
        pw.println(content);
        pw.close();
    }
}