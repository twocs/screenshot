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
public class FilenameTest {

    public FilenameTest() {
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
     * Test of getFilename method, of class Filename.
     */
    @Test
    public void testGetFilename() {
        System.out.println("getFilename");
        String[] args = null;
        String expResult = "ScreenShot";
        String result = Filename.getFilename(args).substring(0, 10);
        assertEquals(expResult, result);

        System.out.println("getFilename");
        String[] args2 = new String[2];
        args2[0] = "-d";
        args2[1] = "E:\\screenshots";
        String expResult2 = "E:\\screenshots\\ScreenShot_";
        String result2 = Filename.getFilename(args2).substring(0, 26);
        assertEquals(expResult2, result2);
    }

}