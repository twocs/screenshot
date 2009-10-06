/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kenai.screenshot;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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

//    /**
//     * Test of getVirtualRectangle method, of class VirtualRectangle.
//     */
//    @Test
//    public void testInitialize() {
//        System.out.println("initialize");
//        Rectangle result = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
//        assertNotNull(result);
//    }

    /**
     * Test of getScreenSize method, of class VirtualRectangle.
     */
    @Test
    public void testGetScreenSize() {
        System.out.println("getScreenSize");
        Rectangle result = VirtualRectangle.getScreenSize();
        assertNotNull(result);
    }

    /**
     * Test of getVirtualRectangle method, of class VirtualRectangle.
     */
    @Test
    public void testGetDefaultConfiguration() {
        System.out.println("getDefaultConfiguration");
        GraphicsDevice result = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
        assertNotNull(result);
    }

    /**
     * Test of getVirtualRectangle method, of class VirtualRectangle.
     */
    @Test
    public void testGetVirtualRectangle() {
        System.out.println("getVirtualRectangle");
        Rectangle result = VirtualRectangle.getVirtualRectangle();
        System.err.println(result);
        assertNotNull(result);
    }

    /**
     * Test of main method, of class VirtualRectangle.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        VirtualRectangle.main(args);
    }

    @Test
    public void testExists() {
        assertEquals("com.kenai.screenshot.VirtualRectangle", VirtualRectangle.class.getName());
    }
}