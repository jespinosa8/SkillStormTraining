package com.skillstorm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * JUNIT - unit testing framework
 *      - unit testing is testing the individual components to ensure they work as intended
 * 
 * 
 * JUNIT ANNOTATIONS
 *      BeforeClass
 *      Before
 *      Test
 *      Ignore
 *      After
 *      AfterClass 
 * 
 */


public class AgeValidatorTest 
{
    static AgeValidator ageValidator;
    Person person1;
    Person person2;
    Person person3;
    Person person4;
    Person person5;

    /*
     * BeforeClass and Before
     *      these are setup methods
     *          used to initialize data you will use within your tests
     * 
     *      BeforeClass - runs once before all other methods
     *      Before - runs right before each test
     * 
     *          ex: BeforeClass to setup a database connection
     *          ex: Before to load data fromt he database
     *      
     *          
     *          if you have multiple methods of the same annotation type, JUNIT does not gaurantee the order that those matching annotations will run in
     * 
     * 
     */

    @BeforeClass
    public static void setupAgeValidator() {
        ageValidator = new AgeValidator();
    }

    @Before
    public void setupPeople() {
        person1 = new Person("Jeremy", 12);
        person2 = new Person("Trafton", 16);
        person3 = new Person("Jordan", 17);
        person4 = new Person("Mohammed", 19);
        person5 = new Person("Koji", 67);
    }


    /*
     * defines your test methods
     * test methods should be public void and take in no params
     */
    @Test
    public void testOldEnoughToDrive() {
        /*
         * tests either pass or fail
         *      only fail if an exception is thrown and is unhandled
         * 
         * junit has assertion methods to throw exceptions for us 
         */

        try {
            assertFalse(ageValidator.oldEnoughToDrive(person1));
            assertTrue(ageValidator.oldEnoughToDrive(person2));
            assertEquals(ageValidator.oldEnoughToDrive(person3), ageValidator.oldEnoughToDrive(person4));
            assertTrue(ageValidator.oldEnoughToDrive(person5));            
        } catch (InvalidAgeException e) {
            System.out.println("Not Old Enough");
        }

    }

    /*
     * instead of using a try-catch, you can tell the test to expect a specific exception
     * 
     */
    @Test(expected = InvalidAgeException.class)
    public void testOldEnoughToVote() {
        assertFalse(ageValidator.oldEnoughToVote(person1));
        assertTrue(ageValidator.oldEnoughToVote(person2));
        assertEquals(ageValidator.oldEnoughToVote(person3), ageValidator.oldEnoughToVote(person4));
        assertTrue(ageValidator.oldEnoughToVote(person5));        

    }

     @Test
    public void testOldEnoughToPurchaseAlcohol() {

        /*
         * assertThrows is saying that a specific method call should throw an exception, rather than all the asserts in the Test method
         * 
         */
        assertThrows(InvalidAgeException.class, () -> {
            ageValidator.oldEnoughToPurchaseAlcohol(person1);
        });

        assertThrows(InvalidAgeException.class, () -> {
            ageValidator.oldEnoughToPurchaseAlcohol(person2);
        });

        assertThrows(InvalidAgeException.class, () -> {
            ageValidator.oldEnoughToPurchaseAlcohol(person3);
        });

        assertThrows(InvalidAgeException.class, () -> {
            ageValidator.oldEnoughToPurchaseAlcohol(person4);
        });

        assertTrue(ageValidator.oldEnoughToPurchaseAlcohol(person5));
    }


    /*
     * After and AfterClass
     *      these are teardown methods used to rollback or delete things that were setup 
     *
     *  
     *      After - runs after each test has finished
     *      AfterClass - runs once at the end of all tests
     * 
     *          ex: after to rollback any changes made to the data
     *          ex: AfterClass to close database connection 
     * 
     */

    @After
    public void teardownPeople() {
        person1 = null;
        person2 = null;
        person3 = null;
        person4 = null;
        person5 = null;
    }

    public static void teardownAgeValidator() {
        ageValidator = null;
    }
}
