public class CommandWords {

    private static final String[] validCommands = {
        "go", "quit", "help"
    };

    public CommandWords() {
        // TODO: Complete section
    }

    public boolean isValidCommand(String aString) {
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].equals(aString)) {
                return true;
            }
        }
        return false;
    }
}
