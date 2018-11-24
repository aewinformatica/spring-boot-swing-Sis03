package com.aewinformatica.sis03.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleUtils {
	

	public static ResourceBundle getRb() {
		
		Locale locale = new Locale("pt_BR");
    	ResourceBundle rb = ResourceBundle.getBundle("com.aewinformatica.sis03.resources.content", locale);
    	
		return rb;
	}
	


}
