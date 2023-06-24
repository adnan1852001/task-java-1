import java.util.*;
import java.io.*;

public class Blog {
    public static void main(String[] args) {
        Blog blog = new Blog();
        blog.askUser();
    }

    public ArrayList<Category> categories = new ArrayList<Category>();

    public void askUser() {
        try {
            updateCategories();
        } catch (Exception ex) {
            System.out.println("Can't find data folder!!");
            System.exit(1);
        }
        System.out.println("Welcome to our blog!");
        System.out.println("Please select one of the following options:");
        System.out.println(" 1. List categories");
        System.out.println(" 2. View category");
        System.out.println(" 3. Add Category");
        System.out.println(" 4. Exit");
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Selection: ");
            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    listCategories();
                    break;
                case 2:
                    System.out.print("Enter the category index: ");
                    int index = input.nextInt();
                    viewCategory(index);
                    break;
                case 3:
                    addCategory();
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
    
    public void viewCategory(int index) {
        Category category = categories.get(index);
        System.out.println(category.getName());
        category.showAction();
    }

    public void listCategories() {
        for (int i = 0; i < categories.size(); i++) {
            System.out.printf("%d: %s%n",i,categories.get(i).getName());
        }
    }

    public void updateCategories() throws Exception {
        File file = new File("categories/");
        File[] files = file.listFiles();
        for(File pf: files){
            categories.add(new Category(pf));
        }
    }

    public void addCategory(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter category name: ");
        Category category = new Category(input.nextLine());
        category.save();
        categories.add(category);
    }

}
