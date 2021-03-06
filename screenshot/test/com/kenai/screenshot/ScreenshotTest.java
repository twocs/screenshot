/*
 * Copyright (C) <2009> <Tom Adam Frederic Anderson>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY  or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.kenai.screenshot;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
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
public class ScreenshotTest {

    public ScreenshotTest() {
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
     * Test of capture method, of class ScreenCapture.
     */
    @Test
    public void testCapture() {
        System.out.println("capture");
        BufferedImage result = Screenshot.capture();
        assertNotNull(result);
    }

    /**
     * Test of main method, of class ScreenCapture.
     */
    @Test
    public void testMain() {
        // null args
        String[] argsNull = new String[0];
        Screenshot.main(argsNull);


        // test it can run
        System.out.println("main");
        String[] args = new String[0];
        Screenshot.main(args);

        // test it can run with a default location, like C:
        String[] args2 = new String[2];
        args2[0] = "-d";
        args2[1] = "E:\\screenshots";
        Screenshot.main(args);
    }

    @Test
    public void testExists() {
        assertEquals("com.kenai.screenshot.Screenshot", Screenshot.class.getName());
    }
}