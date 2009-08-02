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
class CommandlineArgsException extends RuntimeException{

    public CommandlineArgsException(){
        throwError();
    }
    private static void throwError() {
        printUsage();
        //System.exit(0);
    }

    public static int printUsage() {
        System.err.println("Error!\n\n" +
            "Usage: screencapture [-t][-d directory]\n" +
            "\n" +
            "-t\tAdd timestamp\n" +
            "-d\tDestination directory");
        return 1;
    }

    public static void main(String[] args){
        CommandlineArgsException.throwError();
    }
}
