import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankControlStructures {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Change as per your DB
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);
            try (PreparedStatement ps1 = conn.prepareStatement(
                    "UPDATE Loans SET InterestRate = InterestRate - 1 " +
                    "WHERE CustomerID IN (SELECT CustomerID FROM Customers WHERE Age > 60)")) {
                int rows1 = ps1.executeUpdate();
                System.out.println("Scenario 1: Updated " + rows1 + " loan(s) with 1% discount.");
            }
            try (PreparedStatement ps2 = conn.prepareStatement(
                    "UPDATE Customers SET IsVIP = 'TRUE' WHERE Balance > 10000")) {
                int rows2 = ps2.executeUpdate();
                System.out.println("Scenario 2: Updated " + rows2 + " customer(s) to VIP.");
            }
            try (PreparedStatement ps3 = conn.prepareStatement(
                    "SELECT l.LoanID, c.CustomerName, l.DueDate " +
                    "FROM Loans l JOIN Customers c ON l.CustomerID = c.CustomerID " +
                    "WHERE l.DueDate <= ?")) {
                LocalDate next30Days = LocalDate.now().plusDays(30);
                ps3.setDate(1, java.sql.Date.valueOf(next30Days));

                ResultSet rs = ps3.executeQuery();
                System.out.println("Scenario 3: Loan reminders:");
                while (rs.next()) {
                    int loanId = rs.getInt("LoanID");
                    String name = rs.getString("CustomerName");
                    Date dueDate = rs.getDate("DueDate");
                    System.out.printf("Reminder: Loan ID %d for customer %s is due on %s%n",
                            loanId, name, dueDate.toLocalDate().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
                }
            }
            conn.commit();
            System.out.println("All updates committed successfully.");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
