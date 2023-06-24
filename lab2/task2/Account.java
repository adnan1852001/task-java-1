import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Account {
    private final String fileName = "items.txt";
    public static void main(String[] args) {
        Account account = new Account();
        account.askUser();
    }

    public ArrayList<Item> items = new ArrayList<Item>();

    public void askUser() {
        try {
            readItems();
        } catch (Exception e) {
            System.out.print("connot read items");
        }
        System.out.println("Welcome to hamza store!");
        System.out.println("Please select one of the following options:");
        System.out.println(" 1. Create Receipt");
        System.out.println(" 2. List items");
        System.out.println(" 3. add item");
        System.out.println(" 4. edit item");
        System.out.println(" 5. delete item");
        System.out.println(" 6. Exit");
        Scanner input = new Scanner(System.in);

        loop: while (true) {
            System.out.print("Enter Selection: ");
            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    createReceipt();
                break;
                case 2:
                    listItems();
                break;
                case 3:
                    addItem();
                break;
                case 4:
                    editItem();
                break;
                case 5:
                    deleteItem();
                break;
                case 6:
                    try {
                        itemsSave();
                    } catch (Exception e) {
                        System.out.print("error in saving items");
                    }
                    input.close();
                    System.out.print("Bye Bye!");
                break loop;
                default:
                    System.out.println("unknown command");
            }
        }
    }


    public void createReceipt() {
        Receipt receipt = new Receipt(this);
        receipt.askUser();
    }

    public void listItems() {
        if (items.size() == 0) {
            System.out.println("there is no items please enter an item");
        }
        System.out.printf("%s %10s %10s\n","CODE", "ITEM NAME", "PRICE");
        for (int w = 0; w < items.size(); w++) {
            System.out.printf("%s %10s %8.2f\n", items.get(w).getCode(), items.get(w).getName(), items.get(w).getPrice());
        }
    }

    public void addItem() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter the name :");
        String name = input.nextLine();
        System.out.print("enter the code :");
        String code = input.next();
        System.out.print("enter the price :");
        double price = input.nextDouble();
        items.add(new Item(name,code,price));
        System.out.println("item added successfully");
    }

    public void editItem() {
        Scanner input = new Scanner(System.in);
        Item item = getItemFromScanner();
        if (item == null) System.out.println("item not exists");
        System.out.println("enter the new code:");
        item.setCode(input.next());
        System.out.println("enter the name (leave it if not change):");
        item.setName(input.nextLine());
        System.out.println("enter the new price:");
        item.setPrice(input.nextDouble());
        System.out.print("item edited successfully");
    }

    public void deleteItem() {
        Item item = getItemFromScanner();
        boolean status = items.remove(item);
        System.out.print("item " + (status ? "remove successfully" : "not exists"));
    }

    public Item getItemFromScanner() {
        Scanner input = new Scanner(System.in);
        String code = input.next();
        for (int i=0;i<items.size();i++) {
            if (code.equals(items.get(i).getCode()))
                return items.get(i);
        }
        return null;
    }
    
    public void itemsSave() throws Exception {
        String content = "";
        for (int i = 0; i < items.size(); i++) {
            content += items.get(i).getString();
        }
        FileWriter writer = new FileWriter(new File(fileName));
        writer.write(content);
        writer.close();
    }

    public void readItems() throws Exception {
        File file = new File(fileName);
        Scanner fileInput = new Scanner(file);
        while (fileInput.hasNext())
            items.add(new Item(fileInput.nextLine()));
        fileInput.close();
    }
}
