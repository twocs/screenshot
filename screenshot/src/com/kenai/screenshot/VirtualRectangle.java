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

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tommy
 */
class VirtualRectangle implements Runnable{

    private static GraphicsEnvironment graphicsEnvironment;

    // an array of all graphics devices (all monitors)
    private static GraphicsDevice[] graphicsDevices;

    // assuming that this computer has a virtual display, then get the max rectangle size
    private static Rectangle rectangle;

    // initialize the switch to false; true if the rectangle has been set
    private static boolean rectangleSwitch = false;

    public static void setVirtualRectangle(){
        graphicsEnvironment = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevices = graphicsEnvironment.getScreenDevices();

        if (graphicsDevices.length > 0)
        {
            // if there is only one monitor, then take a screenshot
            if(graphicsDevices.length == 1)
            {
                rectangle = getScreenSize();
            }
            // if there is more than one monitor, then union all the rectangles
            else
            {
                rectangle = new Rectangle(); // don't let rectangle be null
                for(java.awt.GraphicsDevice tmp:graphicsDevices){
                    // get the rectangle for the given GraphicsDevice
                    Rectangle tmpRect = tmp.getDefaultConfiguration().getBounds();

                    // union the rectangles
                    rectangle = rectangle.union(tmpRect);
                }
            }
            //success!
            rectangleSwitch = true;
        }
        else {
            //unsuccessful ^_^
            rectangleSwitch = false;

            //print error
            System.err.println("There aren't any display devices");
        }
    }

    public static Rectangle getVirtualRectangle()
    {
        if(rectangleSwitch==false){
            setVirtualRectangle();
        }
        return rectangle;
    }

    public static Rectangle getScreenSize(){
        Frame frame = new Frame();
        Dimension dimension = frame.getToolkit().getScreenSize();
        return new Rectangle(0,0,dimension.width,dimension.height);
    }

    public static void main(String[] args)
    {
        VirtualRectangle virtualRectangle = new VirtualRectangle();
        Thread virtualRectangleThread = new Thread(virtualRectangle);
        virtualRectangleThread.run();
        try {
            //System.out.println(VirtualRectangle.getVirtualRectangle());
            virtualRectangleThread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(VirtualRectangle.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(VirtualRectangle.getVirtualRectangle());
    }

    public void run() {
        getVirtualRectangle();
    }
}
