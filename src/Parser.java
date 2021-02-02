import java.util.Scanner;
import java.util.StringTokenizer;

public class Parser {

    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        String inputLine;
        String commandWord = null;
        String directionWord = null;

        System.out.print("> ");

        inputLine = getReader().nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            commandWord = tokenizer.next();
            if (tokenizer.hasNext()) {
                directionWord = tokenizer.next();
            }
        }
        
        boolean isValidCommand = commands.isValidCommand(commandWord);
        
        if (isValidCommand) {
            return new Command(commandWord, directionWord);
        } else {
            return new Command(null, directionWord);
        }
    }

    public CommandWords getCommands() {
        return commands;
    }

    public Scanner getReader() {
        return reader;
    }
}
