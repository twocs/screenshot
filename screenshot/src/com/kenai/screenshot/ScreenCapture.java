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
import javax.imageio.ImageIO;

/**
 * Saves a copy of the current viewing area of all graphics devices to a file
 * @author tommy
 */
public class ScreenCapture {

    // the screenshot
    private static BufferedImage bufferedImage;

    /**
     * capture() captures a screenshot
     * @return BufferedImage the screenshot
     */
    public static BufferedImage capture()
    {
        try {
            // Capture the screen shot of the area of the screen defined by VirtualRectangle
            Robot robot = new Robot();
            bufferedImage = robot.createScreenCapture(VirtualRectangle.getVirtualRectangle());

            // return the captured image
            return bufferedImage;
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Writes a bufferedImage to a given file address
     * @return boolean success or failure of the write operation
     */
    private static boolean write(BufferedImage bufferedImage, String filename)
    {
        boolean write = false;
        try {
            write = ImageIO.write(bufferedImage, "jpg", new File(filename));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return write;
    }

    public static int main(String[] args) {
        if (args != null)
        {
            String filename = Filename.getFilename(args);

            // capture the screen
            capture();

            // write the screen to the file
            write(bufferedImage, filename);
        }
        else
            ScreenCaptureError.throwError();
        return args.length;
    }

}
