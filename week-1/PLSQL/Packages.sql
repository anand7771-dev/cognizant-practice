CREATE OR REPLACE PACKAGE student_pkg AS

    PROCEDURE show_name;

    FUNCTION add_numbers(a NUMBER, b NUMBER)
    RETURN NUMBER;

END student_pkg;
/

CREATE OR REPLACE PACKAGE BODY student_pkg AS

    PROCEDURE show_name AS
    BEGIN
        DBMS_OUTPUT.PUT_LINE('My Name is Anand');
    END;

    FUNCTION add_numbers(a NUMBER, b NUMBER)
    RETURN NUMBER
    AS
    BEGIN
        RETURN a + b;
    END;

END student_pkg;
/

BEGIN

    student_pkg.show_name;

    DBMS_OUTPUT.PUT_LINE(
        student_pkg.add_numbers(10,20)
    );

END;
/