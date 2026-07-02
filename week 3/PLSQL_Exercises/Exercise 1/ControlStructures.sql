SET SERVEROUTPUT ON;

---------------------------------------------------------
-- Scenario 1
-- Apply 1% discount on loan interest rate for customers
-- above 60 years of age
---------------------------------------------------------

DECLARE

    CURSOR c1 IS
        SELECT CustomerID, Age
        FROM Customers;

BEGIN

    FOR rec IN c1 LOOP

        IF rec.Age > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Scenario 1 Completed: Interest rates updated.');

END;
/

---------------------------------------------------------
-- Scenario 2
-- Promote customers to VIP if balance is greater than
-- 10000
---------------------------------------------------------

DECLARE

    CURSOR c2 IS
        SELECT CustomerID, Balance
        FROM Customers;

BEGIN

    FOR rec IN c2 LOOP

        IF rec.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Scenario 2 Completed: VIP customers updated.');

END;
/

---------------------------------------------------------
-- Scenario 3
-- Print reminder for loans due within next 30 days
---------------------------------------------------------

DECLARE

    CURSOR c3 IS
        SELECT CustomerID, LoanID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN

    FOR rec IN c3 LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer ID '
            || rec.CustomerID
            || ' has Loan ID '
            || rec.LoanID
            || ' due on '
            || TO_CHAR(rec.DueDate, 'DD-MON-YYYY')
        );

    END LOOP;

END;
/