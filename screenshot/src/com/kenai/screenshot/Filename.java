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
class Filename implements Runnable{

    /**
     * Creates the filename from args
     * @param args The comand line args from ScreenCapture
     * @return String The filename, plus directory if necessary
     */
    public static String getFilename(String[] args) {

        StringBuffer filename = new StringBuffer("screenshot");
        if ((args == null) || (args.length == 0)) {
            // filename is ok without any addition
            System.out.println("User Directory: " + System.getProperties().getProperty("user.dir") + "\\");
        }
        else if ((args.length == 1) && args[0].equals("-t"))
        {
            //add timestamp to filename
            java.util.Date date = new java.util.Date();

            // clean the date for windows
            filename.append("_" + date.toString().replace(' ', '_').replace(':', '-'));
        }
        else if (args.length == 2)
        {
            if(args[0].equals("-d"))
            {
                // add the directory to the filename
                filename.insert(0, args[1] + "\\");
            }
            else
            {
                throw new CommandlineArgsException();
            }
        }
        else if ((args.length == 3) && (args[0].equals("-t")) && (args[1].equals("-d")))
        {
            // add timestamp and filename
            
            //add timestamp to filename
            java.util.Date date = new java.util.Date();

            // clean the date for windows
            filename.append("_" + date.toString().replace(' ', '_').replace(':', '-'));

            // add the directory to the filename
            filename.insert(0, args[2] + "\\");
        }
        else {
            throw new CommandlineArgsException();
        }

        filename.append(".jpg");
        System.out.println("Filename should be: " + filename);

        return filename.toString();
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static void main(String[] args)
    {
        System.out.println(Filename.getFilename(new String[0]));
    }


}
