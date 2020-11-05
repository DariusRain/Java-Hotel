package console;

public class HotelConsole extends Console {

    public static void unavailable(String roomType) { log("No " + roomType + " rooms"); }

    public static void invalid(String invalidInput) { log("Invalid input: " + invalidInput);}

    public static void attempt(String message) { log("Attempting to " +  message); }

    public static void alert(String message) { log("Alert: " + message); };

}
