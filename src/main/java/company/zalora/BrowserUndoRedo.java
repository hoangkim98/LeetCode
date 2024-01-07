package company.zalora;

import java.util.List;
import java.util.Stack;

public class BrowserUndoRedo {

    public static void browserManipulate(List<String> lst) {
        Stack<String> stack = new Stack<>();
        Stack<String> removedStack = new Stack<>();

        for (String item : lst) {
            String[] splitLst = item.split("\\s");
            if (splitLst.length > 1 && splitLst[0].equalsIgnoreCase("WRITE")) {
                stack.push(splitLst[1]);
            }
            if (splitLst[0].equalsIgnoreCase("UNDO")) {
                removedStack.push(stack.pop());
            }
            if (splitLst[0].equalsIgnoreCase("REDO")) {
                if (!removedStack.isEmpty()) {
                    stack.push(removedStack.pop());
                }
            }
            if (splitLst[0].equalsIgnoreCase("PRINT")) {
                System.out.println(stack);
            }
        }
    }

    public static void main(String[] args) {
        browserManipulate(List.of("WRITE A", "WRITE B", "WRITE C", "UNDO", "UNDO", "PRINT", "REDO", "REDO", "REDO", "PRINT"));
    }
}
