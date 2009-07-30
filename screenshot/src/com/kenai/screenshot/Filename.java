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

/**
 *
 * @author tommy
 */
class Filename {
    
    public static String getFilename(String[] args) {
        java.util.Date date = new java.util.Date();
        String filename = "ScreenShot_" + date.toString().replace(' ', '_').replace(':', '-') + ".jpg";
        if ((args == null) || (args.length == 0)) {
            // filename is ok
            System.out.println("User Directory: " + System.getProperties().getProperty("user.dir") + "\\");
        }
        else if (args.length == 2)
        {
            if(args[0].equals("-d"))
            {
                // add the directory to the filename
                filename = args[1] + "\\" + filename;
            }
            else
            {
                ScreenCaptureError.throwError();
            }
        }
        else
            ScreenCaptureError.throwError();

        System.out.println("Filename should be: " + filename);

        return filename;
    }
}
