package com.aewinformatica.sis03.util;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Borders {

	 private static final int WIDTH = 200;
	    private static final int HEIGHT = 200;

	    public static Border createEmptyBorder() {
	        return BorderFactory.createEmptyBorder(HEIGHT, WIDTH, HEIGHT, WIDTH);
	    }
}
