/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kenai.screenshot;

import java.awt.Rectangle;
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
public class VirtualRectangleTest {

    public VirtualRectangleTest() {
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
     * Test of main method, of class VirtualRectangle.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        assertTrue(VirtualRectangle.main(args));
    }

    /**
     * Test of getVirtualRectangle method, of class VirtualRectangle.
     */
    @Test
    public void testGetVirtualRectangle() {
        System.out.println("getVirtualRectangle");
        Rectangle result = VirtualRectangle.getVirtualRectangle();
        assertNotNull(result);
    }

}