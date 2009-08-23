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

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Saves a copy of the current viewing area of all graphics devices to a file
 *
 * Note: This will save a copy of the screenshot to the screenshot directory by default
 * So before uploading through Subversion, check to remove screenshots!
 * 
 * @author tommy
 */
public class Screenshot {

    // the screenshot
    private static BufferedImage bufferedImage;
    private static Robot robot;
    static {
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(Screenshot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * capture() captures a screenshot
     * @return BufferedImage the screenshot
     */
    public static BufferedImage capture()
    {
        // Capture the screen shot of the area of the screen defined by VirtualRectangle
        bufferedImage = robot.createScreenCapture(VirtualRectangle.getVirtualRectangle());

        // return the captured image
        return bufferedImage;
    }

    /**
     * Writes a bufferedImage to a given file address
     * @return boolean success or failure of the write operation
     */
    public static boolean write(BufferedImage bufferedImage, String filename)
            throws IOException {
        // sanity checks for bufferedImage/filename?
//        if (bufferedImage == null) {
//            System.err.println("bufferedImage is null in Screenshot.write()");
//            return false; //failed because string name is empty
//        }

//        if(filename.isEmpty()) {
//            System.err.println("Filename error in Screenshot.write()");
//            return false; //failed because string name is empty
//        }
        // return true if write is successful
        return ImageIO.write(bufferedImage, "jpg", new File(filename)); 
    }

    /**
     *
     * @param args
     * @return int representing the number of args
     */
    public static void main(String[] args) {
        if (args != null)
        {
            String filename = Filename.getFilename(args);

            // capture the screen
            capture();

            try
            {
                // write the screen to the file
                write(bufferedImage, filename);
            }
            catch (IOException e)
            {
                System.err.println(e);
            }
        }
        else
            throw new CommandlineArgsException();

    }

}
