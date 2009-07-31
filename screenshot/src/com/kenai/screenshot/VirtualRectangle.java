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

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

/**
 *
 * @author tommy
 */
class VirtualRectangle{

    private static GraphicsEnvironment graphicsEnvironment;

    // an array of all graphics devices (all monitors)
    private static GraphicsDevice[] graphicsDevices;

    // assuming that this computer has a virtual display, then get the max rectangle size
    private static Rectangle rectangle;

    public static Rectangle getVirtualRectangle()
    {
        graphicsEnvironment = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevices = graphicsEnvironment.getScreenDevices();

        if (graphicsDevices.length > 0)
        {
            // if there is only one monitor, then take a screenshot
            if(graphicsDevices.length == 1)
            {
                rectangle = graphicsDevices[0].getDefaultConfiguration().getBounds();
            }
            // if there is more than one monitor, then union all the rectangles
            else
            {
                rectangle = new Rectangle();
                for(java.awt.GraphicsDevice tmp:graphicsDevices){
                    // get the rectangle for the given GraphicsDevice
                    Rectangle tmpRect = tmp.getDefaultConfiguration().getBounds();

                    // union the rectangles
                    rectangle = rectangle.union(tmpRect);
                }
            }
        }
        else {
            System.err.println("There aren't any display devices");
        }
        return rectangle;
    }

    public static void main(String[] args)
    {
        System.out.println(VirtualRectangle.getVirtualRectangle());
    }
}
