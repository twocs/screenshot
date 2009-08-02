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
        String expResult = "screenshot.jpg";
        String result = Filename.getFilename(args);
        assertEquals(expResult, result);

        System.out.println("getFilename");
        String[] args2 = new String[2];
        args2[0] = "-d";
        args2[1] = "E:\\screenshots";
        String expResult2 = "E:\\screenshots\\screenshot.jpg";
        String result2 = Filename.getFilename(args2);
        assertEquals(expResult2, result2);

        System.out.println("getFilename");
        String[] args3 = new String[3];
        args3[0] = "-t";
        args3[1] = "-d";
        args3[2] = "E:\\screenshots";
        String expResult3 = "E:\\screenshots\\screenshot_";
        String filename3 = Filename.getFilename(args3);
        String result3 = filename3.substring(0, expResult3.length());
        assertEquals(expResult3, result3);
        String jpgExpect3 = ".jpg"; // check the filename ends with .jpg
        String jpgResult3 = filename3.substring(filename3.length() - 4, filename3.length());
        assertEquals(jpgExpect3, jpgResult3);
    }

    @Test
    public void testExists() {
        assertEquals("com.kenai.screenshot.Filename", Filename.class.getName());
    }

}