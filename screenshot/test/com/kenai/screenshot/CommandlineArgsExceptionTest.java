/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kenai.screenshot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tommy
 */
public class CommandlineArgsExceptionTest {

    public CommandlineArgsExceptionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of printUsage method, of class CommandlineArgsException.
     */
    @Test
    public void testPrintUsage() {
        System.out.println("printUsage");
        int expResult = 1; // 1 means it printed correctly
        int result = CommandlineArgsException.printUsage();
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class CommandlineArgsException.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CommandlineArgsException.main(args);
    }

    @Test
    public void testExists() {
        assertEquals("com.kenai.screenshot.CommandlineArgsException", CommandlineArgsException.class.getName());
    }

}