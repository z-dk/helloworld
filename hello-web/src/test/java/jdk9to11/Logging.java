package jdk9to11;

public interface Logging {
    String ORACLE = "Oracle_Database";
    String MYSQL = "MySql_Database";
 
    private void log(String message, String prefix) {
        getConnection();
        System.out.println("Log Message : " + prefix);
        closeConnection();
    }
    default void logInfo(String message) {
        log(message, "INFO");
    }
    default void logWarn(String message) {
        log(message, "WARN");
    }
    default void logError(String message) {
        log(message, "ERROR");
    }
    default void logFatal(String message) {
        log(message, "FATAL");
    }
    private static void getConnection() {
        System.out.println("Open Database connection");
    }
    private static void closeConnection() {
        System.out.println("Close Database connection");
    }
}