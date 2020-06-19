package de.iits.VacationApp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebtTest {

    @Test
    void contains_CreditorDebitorMatch() {
        float credit = 30;
        Persons creditor = new Persons(1, "Kevin");
        Persons debitor = new Persons(2, "Joey");
        Debt sut = new Debt(creditor, debitor, credit);

        boolean result = sut.contains(creditor,debitor);

        assertTrue(result);

    }

    @Test
    void contains_OnlyCreditorMatch() {
        float credit = 30;
        Persons creditor = new Persons(1, "Kevin");
        Persons debitor = new Persons(2, "Joey");
        Persons otherPerson= new Persons(3, "Felix");
        Debt sut = new Debt(creditor, debitor, credit);

        boolean result = sut.contains(creditor,otherPerson);

        assertFalse(result);

    }
}