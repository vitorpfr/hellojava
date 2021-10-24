package livelock;

// live lock: a type of lock that waits for another thread to fully complete before executing
// it is the opposite of deadlock: both threads are actively running, but they can't progress without the other progressing
// solution: depends on the code

public class LiveLockMain {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Worker 1", true);
        Worker worker2 = new Worker("Worker 2", true);

        SharedResource sharedResource = new SharedResource(worker1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(sharedResource, worker2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(sharedResource, worker1);
            }
        }).start();
    }
}
