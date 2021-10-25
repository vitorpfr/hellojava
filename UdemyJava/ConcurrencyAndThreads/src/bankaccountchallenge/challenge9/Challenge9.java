package bankaccountchallenge.challenge9;

/**
 * Created by timbuchalka on 16/08/2016.
 */

// we still have an issue here: when running, it prints "Tutor has arrived" and "Tutor gave progress report", then stops

// what is happening:
// tutorThread starts
    // calls tutor.studyTime(), which gets the lock for tutor in a synchronized block
    // gets the lock for the student as well in a synchronized block.
    // On it, calls wait(), which suspends the thread waiting for the studentThread to notify it (and releases tutor lock)
// studentThread starts
    // calls student.handInAssignment() method, which gets tutor lock and calls tutor.getProgressReport();
    // however, it can't get student lock because tutorThrad is holding it

// tutor thread is waiting with student lock, so student thread cannot run and notify tutor that it is ready
// root cause of issue is in the wait(), which releases the lock before exiting the synchronized block

// possible solutions:
    // - using ReentrantLock objects
    // - have the tutor thread release the student lock before it calls wait(), and then try to reacquire it when it wakes up

public class Challenge9 {
    public static void main(String[] args) {
        final NewTutor tutor = new NewTutor();
        final NewStudent student = new NewStudent(tutor);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                tutor.studyTime();
            }
        });

        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                student.handInAssignment();
            }
        });

        tutorThread.start();
        studentThread.start();
    }
}

class NewTutor {
    private NewStudent student;

    public void setStudent(NewStudent student) {
        this.student = student;
    }

    public void studyTime() {

        synchronized (this) {
            System.out.println("Tutor has arrived");
            synchronized (student) {
                try {
                    // wait for student to arrive
                    this.wait();
                } catch (InterruptedException e) {

                }
                student.startStudy();
                System.out.println("Tutor is studying with student");
            }
        }
    }

    public void getProgressReport() {
        // get progress report
        System.out.println("Tutor gave progress report");
    }
}

class NewStudent {

    private NewTutor tutor;

    NewStudent(NewTutor tutor) {
        this.tutor = tutor;
    }

    public void startStudy() {
        // study
        System.out.println("Student is studying");
    }

    public void handInAssignment() {
        synchronized (tutor) {
            tutor.getProgressReport();
            synchronized (this) {
                System.out.println("Student handed in assignment");
                tutor.notifyAll();
            }
        }
    }
}