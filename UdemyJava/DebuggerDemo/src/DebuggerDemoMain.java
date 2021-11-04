public class DebuggerDemoMain {
    // Run debugger: debug icon next to 'run'
    // Important to set breakpoints in the code to examine the state of the application at that time (Run menu, or click red circle)

    // When the application is suspended in a breakpoint, that line of code hasn't been executed yet
    // When the debugger runs, the debug tab below is split in two parts:
        // Frames: show the stack trace (top is most recent call); also has a dropdown showing all threads running
        // Variables: current state of variables (you can set the state clicking in the variable current value)

    // Buttons above debugger control the flow of the application
        // Show execution point: returns to current execution line
        // Step over: advance execution by one statement, completely executing current method/line
        // Step into: advance execution inside the current method, adding it to stack (but doesn't work on JDK methods/classes)
        // Force step into: same as above, but works on JDK methods/classes
        // Step out: runs rest of method, returns back to caller and suspends
        // Drop frame: returns one frame in the "past" (only local variables)
        // Run to cursor: will run again until the cursor is located, and then suspend

    // Watches (variables with glasses)
        // Some are defined automatically by intellij, but you can right-click and force to be watched
        // They are highlighted in the variables window
        // Whenever the current statement updated them, they are highlighted in blue

    // Field watchpoint:
        // breakpoint when a variable is updated (instead of marking the code line)
        // How to create it: same as adding breakpoint, but in a field/variable declaration
        // By default it suspends app when field is modified, but it can be changed to 'field is accessed'

    public static void main(String[] args) {
        // debugger example
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 10) {
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);

        // another example
        String str = "abcdefg";
        String result = utils.upperAndPrefix(utils.addSuffix(str));

    }
}
