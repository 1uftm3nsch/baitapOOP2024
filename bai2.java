import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;

public class bai2 {

    static class Customer {
        private String address, code, name;

        public Customer(String address, String code, String name) {
            this.address = address;
            this.code = code;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Code: " + code + ", Address: " + address;
        }
    }

    static class OrderLine {
        private Currency value;

        public OrderLine(Currency value) {
            this.value = value;
        }

        public Currency getValue() {
            return value;
        }
    }

    static class Order {
        private Customer customer;
        private ArrayList<OrderLine> orderLine;
        private Currency total;

        public Order(Customer customer) {
            this.customer = customer;
            this.orderLine = new ArrayList<>();
        }

        public Currency getTotal() {
            return total;
        }

        public void setTotal(Currency total) {
            this.total = total;
        }

        public OrderLine addLine(OrderLine line) {
            orderLine.add(line);
            return line;
        }

        public void removeLine(OrderLine line) {
            orderLine.remove(line);
        }

        public void inOrder() {
            System.out.println("Order Info:");
            System.out.println("Customer: " + customer);
            System.out.println("Total: " + total);
            System.out.println("Order Lines:");
            for (OrderLine line : orderLine) {
                System.out.println(" - Value: " + line.getValue());
            }
        }
    }

    static class OrderIterator implements Iterator<Order> {
        private ArrayList<Order> orders;
        private int index;

        public OrderIterator(ArrayList<Order> orders) {
            this.orders = orders;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < orders.size();
        }

        @Override
        public Order next() {
            return orders.get(index++);
        }
    }

    static class OrderList {
        private ArrayList<Order> order;

        public OrderList() {
            this.order = new ArrayList<>();
        }

        public void add(Order ord) {
            order.add(ord);
        }

        public void remove(Order ord) {
            order.remove(ord);
        }

        public int getCount() {
            return order.size();
        }

        public OrderIterator getOIterator() {
            return new OrderIterator(order);
        }
    }
    
    public static void main(String[] args) {
        Customer customer1 = new Customer("Ha Noi", "KH01", "Nguyen Van A");
        Customer customer2 = new Customer("Hai Phong", "KH02", "Tran Van B");

        Order order1 = new Order(customer1);
        Order order2 = new Order(customer2);

        Currency usd = Currency.getInstance(Locale.US);
        order1.setTotal(usd);
        order2.setTotal(usd);

        OrderLine line1 = new OrderLine(usd);
        OrderLine line2 = new OrderLine(usd);
        OrderLine line3 = new OrderLine(usd);

        order1.addLine(line1);
        order1.addLine(line2);

        order2.addLine(line3);

        OrderList orderList = new OrderList();
        orderList.add(order1);
        orderList.add(order2);

        System.out.println("Total orders: " + orderList.getCount());

        OrderIterator iterator = orderList.getOIterator();
        while (iterator.hasNext()) {
            Order ord = iterator.next();
            ord.inOrder();
        }
    }
}
