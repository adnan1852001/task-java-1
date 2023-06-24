import java.io.*;

class SecurePost extends Post {
    String password;

    SecurePost(File file) throws Exception {
        super(file);
        String name = file.getName();
        password = name.split("_pw_")[1].split("\\.")[0];

    }

    SecurePost(String title,String content, String password) {
        super(title,content);
        this.password = password;
    }

    // @Override
    // public String getContent() {
    //     Console console = System.console();
    //     String password = new String(console.readPassword("Please enter the password: ")); 
    //     if(this.password == password) {
    //     }
    //     return "you cannot show the file";
    // }

    // @Override
    // public String getTitle() {
    //     Console console = System.console();
    //     String password = new String(console.readPassword("Please enter the password: ")); 
    //     if(this.password == password)
    //         return super.getTitle();
    //     return "you cannot show the file";
    // }

    public boolean checkPassword() {
        Console console = System.console();
        String password = new String(console.readPassword("Please enter the password: "));
        System.out.println(this.password);
        if(this.password.equals(password))
            return true;
        return false;
    }

    @Override
    public void save(String fileName) throws Exception {
        super.save(fileName + "_pw_" + password);
    }
}
