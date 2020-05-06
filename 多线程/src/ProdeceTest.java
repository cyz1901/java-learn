public class ProdeceTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Prodecer prodecer = new Prodecer(clerk);
        Customer customer = new Customer(clerk);

        prodecer.setName("生产者");
        customer.setName("消费者");

        prodecer.start();
        customer.start();
    }
}
class Prodecer extends Thread{
    private Clerk clerk;

    public Prodecer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产产品");
        while (true){
            clerk.produceProduct();
        }
    }
}

class Customer extends Thread{
    private Clerk clerk;

    public Customer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始消费产品");
        while (true){
            clerk.cousumeProduct();
        }
    }

}
class Clerk{

    private int product = 0;

    public synchronized void produceProduct() {
        if (product<20){
            product++;
            System.out.println(Thread.currentThread().getName() + "开始生产第"+ product+"个产品");

            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void cousumeProduct() {
        if (product>0){
            System.out.println(Thread.currentThread().getName() + "开始消费第"+ product+"个产品");
            product--;

            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
