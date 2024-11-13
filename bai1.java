public class bai1 {

    public static void main(String[] args) {
        IEmployee p1 = new PartTimeEmployee(13, "Nguyen Van A", 15000);
        IEmployee p2 = new FullTimeEmployee("Tran Van B", 78000);

        System.out.println("Name: " + p1.getName());
        System.out.println("Salary: " + p1.calculateSalary());

        System.out.println("Name: " + p2.getName());
        System.out.println("Salary: " + p2.calculateSalary());
    }
    
    interface IEmployee {
        int calculateSalary();
        String getName();
    }


    abstract static class Employee {
        private String name;
        private int paymentPerHour;

        public Employee(String name, int paymentPerHour) {
            this.name = name;
            this.paymentPerHour = paymentPerHour;
        }

        public String getName() {
            return name;
        }

        public int getPaymentPerHour() {
            return paymentPerHour;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPaymentPerHour(int paymentPerHour) {
            this.paymentPerHour = paymentPerHour;
        }
    }


    static class FullTimeEmployee extends Employee implements IEmployee {

        public FullTimeEmployee(String name, int paymentPerHour) {
            super(name, paymentPerHour);
        }

        @Override
        public int calculateSalary() {
            return getPaymentPerHour() * 8 * 24; // 8 hours per day, 24 days per month
        }
    }


    static class PartTimeEmployee extends Employee implements IEmployee {
        private int workingHours;

        public PartTimeEmployee(int workingHours, String name, int paymentPerHour) {
            super(name, paymentPerHour);
            this.workingHours = workingHours;
        }

        @Override
        public int calculateSalary() {
            return workingHours * getPaymentPerHour();
        }
    }
}
