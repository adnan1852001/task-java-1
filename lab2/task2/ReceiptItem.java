class ReceiptItem {
    Item item;
    int amount;

    ReceiptItem(Item item,int amount) {
        this.item = item;
        this.amount = amount;
    }

    public double getTotal() {
        return item.getPrice() * this.amount;
    }

    public void printReceipt() {
        System.out.printf("%20s%4d%5.2f%5.2f\n", item.getName(),this.amount,item.getPrice(),this.getTotal());
    }

    
}
