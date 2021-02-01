/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafa_
 */
public class CommandWords {

    private static final String[] validCommands = {
        "go", "quit", "help"
    };

    public CommandWords() {
        // nothing to do at the moment...
    }

    public boolean isCommand(String aString) {
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].equals(aString)) {
                return true;
            }
        }
        return false;
    }
}
