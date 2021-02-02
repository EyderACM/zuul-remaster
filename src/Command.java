public class Command {

    private String commandWord;
    private String directionWord;
    
    public Command(String commandWord, String directionWord) {
        this.commandWord = commandWord;
        this.directionWord = directionWord;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getDirectionWord() {
        return directionWord;
    }

    public boolean isUnknown() {
        return (commandWord == null);
    }

    public boolean hasDirectionWord() {
        return (directionWord != null);
    }
}
