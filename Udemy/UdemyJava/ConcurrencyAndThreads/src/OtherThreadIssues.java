public class OtherThreadIssues {
    // atomic operation: it either completes or doesn't execute at all (it can't be interrupted halfway through)
    // atomic operations in java:
    // - reading and writing reference values (myObject1 = myObject2)
    // - reading and writing primitive values (except long and double)
    // - reading and writing all variables declared volatile (public volatile int counter;)
        // volatile keyword guarantees that its value is always synchronized between cpu cache and main memory

    // java.util.concurrent.atomic package provides classes that ensure reading and writing variables is atomic
        // example: using AtomicInteger instead of int as a counter (using it is lock-free, thread-safe)
}
