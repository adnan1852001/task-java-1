import java.util.*;

class Receipt {
    Account account;
    public ArrayList<ReceiptItem> items = new ArrayList<ReceiptItem>();
    
    Receipt(Account account){
        this.account = account;
    }

    public void askUser() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("enter the item code:");
            Item item = account.getItemFromScanner();
            if (item == null)
                break;
            System.out.print("enter the amount:");
            int amount = input.nextInt();
        this.addItem(item, amount);
        }
        this.showItems();
        System.out.println("TOTAL: $"+this.getTotal());
    }

    private void showItems(){
        System.out.println("------------Receipt------------");
        for (int i = 0; i < items.size(); i++) {
            items.get(i).printReceipt();
        }
        System.out.println("--------");
    }

    private double getTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getTotal();
        }
        return total;
    }



    private void addItem(Item item,int quantity) {
        items.add(new ReceiptItem(item, quantity));
    }
}