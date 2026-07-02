SET SERVEROUTPUT ON;

---------------------------------------------------
-- Scenario 1
---------------------------------------------------

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN

UPDATE Accounts
SET Balance = Balance + (Balance * 0.01)
WHERE AccountType = 'Savings';

COMMIT;

DBMS_OUTPUT.PUT_LINE('Interest Added');

END;
/

---------------------------------------------------
-- Scenario 2
---------------------------------------------------

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus
(
dept IN VARCHAR2,
bonus IN NUMBER
)
IS
BEGIN

UPDATE Employees
SET Salary = Salary + (Salary * bonus / 100)
WHERE Department = dept;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Bonus Updated');

END;
/

---------------------------------------------------
-- Scenario 3
---------------------------------------------------

CREATE OR REPLACE PROCEDURE TransferFunds
(
fromAcc IN NUMBER,
toAcc IN NUMBER,
amt IN NUMBER
)
IS

bal NUMBER;

BEGIN

SELECT Balance
INTO bal
FROM Accounts
WHERE AccountID = fromAcc;

IF bal >= amt THEN

UPDATE Accounts
SET Balance = Balance - amt
WHERE AccountID = fromAcc;

UPDATE Accounts
SET Balance = Balance + amt
WHERE AccountID = toAcc;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Money Transferred');

ELSE

DBMS_OUTPUT.PUT_LINE('Not Enough Balance');

END IF;

END;
/