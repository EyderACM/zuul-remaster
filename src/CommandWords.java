public class CommandWords {

    private static final String[] validCommands = {
        "go", "quit", "help"
    };

    public CommandWords() {
        // TODO: Complete section
    }

    public boolean isValidCommand(String aString) {
        for (int i = 0; i < getValidCommands().length; i++) {
            if (getValidCommands()[i].equals(aString)) {
                return true;
            }
        }
        return false;
    }

    public static String[] getValidCommands() {
        return validCommands;
    }
}
