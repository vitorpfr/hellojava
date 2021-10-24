package sayhello;

public class SayHelloMain {
    // this situation also creates a deadlock, even though two different objects are being used!
    // important: the synchronized lock is by object (so there's a lock for john object, and other for jane object)
    // important: the synchronized lock is for the whole object, so if thread1 tries to run method B from jane
    //            and thread2 already holds the jane lock by running the method A, thread 1 will not succeed
    // again, the issue is the order that the threads try to acquire locks (one tries to get 1>2, other 2>1)
    public static void main(String[] args) {
        PolitePerson jane = new PolitePerson("Jane");
        PolitePerson john = new PolitePerson("John");

        new Thread(new Runnable() {
            @Override
            public void run() {
                jane.sayHello(john);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                john.sayHello(jane);
            }
        }).start();
    }

    static class PolitePerson {
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person) {
            System.out.format("%s: %s has said hello to me!%n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person) {
            System.out.format("%s: %s has said hello back to me!%n", this.name, person.getName());
        }
    }
}
