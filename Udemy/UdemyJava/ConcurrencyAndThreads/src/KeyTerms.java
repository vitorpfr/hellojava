public class KeyTerms {
    // Process: Unit of execution that has its own memory space. Each instance of JVM runs as a process
    //          When we run a Java console or a JavaFx application, we are kicking off a process.
    //
    //          If one Java process is running, and we run another one, each process/app has its own
    //          memory space of heap. The 1st app cannot access the heap that belongs to the 2nd app.
    //          each process has its own heap (process memory).

    // Application: Used interchangeably with 'process' here

    // Thread: Unit of execution within a process. Each process can have multiple threads. In Java, every process
    //         (or app) has at least one thread, the main thread. In practice, just about every Java process has
    //         also multiple system threads that handle tasks like memory management and I/O, which we (developer)
    //         do not need to create explicitly. Our code runs in the main thread (or in threads we create).
    //
    //         Creating a thread doesn't require as many resources as creating a process.
    //         Every thread created by a process share the process memory and files (which can create problems)
    //
    //         In addition to process memory (or heap), each thread has the thread stack, which is the memory that
    //         only that thread can access.
    //
    //         Within a thread, code is executed in a linear fashion (so the thread is 'suspended' until each command runs)

    // Summary: Every Java application runs as a single process, and each process can have multiple threads.
    //          Every process has a heap, and every thread has a thread stack.

    // Reasons to use more than one thread:
    // - Perform task that takes a long time (doing it in another threads avoid blocking the main one)
    // - API requires us to provide one (when we provide a code that will run when a method reaches a certain point in its execution)

    // Concurrency: One application doing more than one thing at a time
    // (disclaimer: an application can have concurrency even using a single thread, ex: does a bit of task 1, then a bit of task 2, then task 1, etc. until both are completed)
    // Java provide thread-related classes to facilitate building concurrent applications

}
