package com.aewinformatica.sis03.ui.main_menu.view;

import java.awt.GridLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.util.Borders;
import com.aewinformatica.sis03.util.LookAndFeelUtils;

@Component
public class MainMenuFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton botao_adicionar;
	private String TITLE_MAIN_MENU;
	private Locale locale;
	private ResourceBundle rb;
	
    public MainMenuFrame() {
    	locale = new Locale("pt_BR");
    	rb = ResourceBundle.getBundle("com.aewinformatica.sis03.resources.content", locale);
    	TITLE_MAIN_MENU = rb.getString("title");
        setFrameUp();
        initComponents();
        pack();
    }
		
    private void setFrameUp() {
        getRootPane().setBorder(Borders.createEmptyBorder());
        setTitle(TITLE_MAIN_MENU);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        LookAndFeelUtils.setWindowsLookAndFeel();
        getContentPane().setLayout(new GridLayout(1, 2, 20, 20));
    }
    
    private void initComponents() {
    	botao_adicionar = new JButton("Adicionar");
    	getContentPane().add(botao_adicionar);
    }
    
    public JButton getFormsBtn() {
        return botao_adicionar;
    }
    
}