public class ThreadDemo {
    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        clicker hi = new clicker(Thread.NORM_PRIORITY + 4);
        clicker lo = new clicker(Thread.NORM_PRIORITY - 4);


        lo.start();
        hi.start();;

        try {
            Thread.sleep(10000);
        }catch (InterruptedException e ){
            System.out.println("Main thread Interrupted");
        }

        lo.stop();
        hi.stop();

        try {
            lo.t.join();
            hi.t.join();
        }catch (InterruptedException e){
            System.out.println("Interruption caught");
        }

        System.out.println("Low_Priority Thread: " + lo.click);
        System.out.println("High_Priority Thread: " + hi.click);
    }
}
