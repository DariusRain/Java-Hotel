package console;

public class HotelConsole extends Console {

    public static void unavailable(String roomType) { log("No " + roomType + " rooms"); }

    public static void invalid(String invalidInput) { log("INVALID: " + invalidInput);}

    public static void attempt(String message) { log("Attempting to " +  message); }

    public static void success(String message) { log("SUCCESS: " + message); };

    public static void alert(String message) { log("ALERT: " + message); };

    public static void error(String message) { log("ERROR: " + message); };

}
