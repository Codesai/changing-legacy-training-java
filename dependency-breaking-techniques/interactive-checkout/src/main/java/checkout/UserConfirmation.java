package checkout;

import java.util.Scanner;

public class UserConfirmation {
    private final boolean accepted;

    public UserConfirmation(String message) {
        System.out.println(message + " Choose Option (Y yes) (N no):");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        accepted = result != null && result.equalsIgnoreCase("y");
    }

    public boolean wasAccepted() {
        return accepted;
    }
}