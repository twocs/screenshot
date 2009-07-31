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
public class ScreenshotErrorTest {

    public ScreenshotErrorTest() {
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
     * Test of throwError method, of class ScreenCaptureError.
     */
    @Test
    public void testThrowError() {
        System.out.println("throwError");
        System.out.println("Can't test class completely because it calls System.exit() to stop the Java VM");
    }

    /**
     * Test of printUsage method, of class ScreenCaptureError.
     */
    @Test
    public void testPrintUsage() {
        System.out.println("printUsage");
        int expResult = 1;
        int result = ScreenshotError.printUsage();
        assertEquals(expResult, result);
    }

}