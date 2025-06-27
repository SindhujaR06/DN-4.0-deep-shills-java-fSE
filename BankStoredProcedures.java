import java.sql.*;

public class BankStoredProcedures {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";  
        String username = "your_username";                      
        String password = "your_password";                       

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement()) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String proc1 = """
                CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
                BEGIN
                    UPDATE Accounts
                    SET Balance = Balance + (Balance * 0.01)
                    WHERE AccountType = 'Savings';
                    COMMIT;
                END;
                """;
            stmt.execute(proc1);
            System.out.println("Procedure ProcessMonthlyInterest created.");
            String proc2 = """
                CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
                    dept_id IN NUMBER,
                    bonus_pct IN NUMBER
                ) IS
                BEGIN
                    UPDATE Employees
                    SET Salary = Salary + (Salary * bonus_pct / 100)
                    WHERE DepartmentID = dept_id;
                    COMMIT;
                END;
                """;
            stmt.execute(proc2);
            System.out.println("Procedure UpdateEmployeeBonus created.");
            String proc3 = """
                CREATE OR REPLACE PROCEDURE TransferFunds (
                    from_acct IN NUMBER,
                    to_acct IN NUMBER,
                    amount IN NUMBER
                ) IS
                    insufficient_balance EXCEPTION;
                    curr_balance NUMBER;
                BEGIN
                    SELECT Balance INTO curr_balance FROM Accounts WHERE AccountID = from_acct;

                    IF curr_balance < amount THEN
                        RAISE insufficient_balance;
                    END IF;

                    UPDATE Accounts SET Balance = Balance - amount WHERE AccountID = from_acct;
                    UPDATE Accounts SET Balance = Balance + amount WHERE AccountID = to_acct;

                    COMMIT;

                EXCEPTION
                    WHEN insufficient_balance THEN
                        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance for transfer.');
                        ROLLBACK;
                    WHEN NO_DATA_FOUND THEN
                        DBMS_OUTPUT.PUT_LINE('Error: One or both accounts not found.');
                        ROLLBACK;
                    WHEN OTHERS THEN
                        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
                        ROLLBACK;
                END;
                """;
            stmt.execute(proc3);
            System.out.println("Procedure TransferFunds created.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
