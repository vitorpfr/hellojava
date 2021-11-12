package bankaccountchallenge.challenge8;

// Issue with code: It gets stuck with "Tutor has arrived

// What is happening:
// tutorThread
    // tutorThread starts running tutor.studyTime(), which is synchronized and locks the tutor object;
    // then it tries to call student.startStudy(), which is also synchronized, but can't because the studentThread is already locking the student object
// studentThread
    // studentThread starts running student.handInAssignment();, which is synchronized and locks the student object
    // then it tries to call tutor.getProgressReport, but can't because the tutorThread is already locking the object the tutor object
// this is a deadlock
// solutions
// - reduce synchronized code (code is probably over-synchronized)
// - make both threads get the locks in the same order
// - change code to avoid having tutor and student objects calling each other in a circular fashion (parameters may come in handy)
// - use reentrantLock with tryLock() method, using a timeout

public class Challenge8 {

    public static void main(String[] args) {
        Tutor tutor = new Tutor();
        Student student = new Student(tutor);
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

class Tutor {
    private Student student;

    public synchronized void setStudent(Student student) {
        this.student = student;
    }

    public synchronized void studyTime() {
        System.out.println("Tutor has arrived");
        try {
            // wait for student to arrive and hand in assignment
            Thread.sleep(300);
        } catch (InterruptedException e) {

        }
        student.startStudy();
        System.out.println("Tutor is studying with student");
    }

    public synchronized void getProgressReport() {
        // get progress report
        System.out.println("Tutor gave progress report");
    }
}

class Student {

    private Tutor tutor;

    Student(Tutor tutor) {
        this.tutor = tutor;
    }

    public synchronized void startStudy() {
        // study
        System.out.println("Student is studying");
    }

    public synchronized void handInAssignment() {
        tutor.getProgressReport();
        System.out.println("Student handed in assignment");
    }
}
