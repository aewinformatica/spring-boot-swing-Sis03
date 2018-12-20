package com.aewinformatica.sis03.ui.main_menu.view;

import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.util.Borders;
import com.aewinformatica.sis03.util.LocaleUtils;
import com.aewinformatica.sis03.util.LookAndFeelUtils;

@Component
public class MainMenuFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton botao_adicionar;
	private JButton botao_cfops;
	private String TITLE_MAIN_MENU;
	private String BTN_ADD;
	private ResourceBundle rb;
	
    public MainMenuFrame() {
    	rb = LocaleUtils.getRb();
    	TITLE_MAIN_MENU = rb.getString("title.MAIN");
    	        BTN_ADD = rb.getString("Labels.BTN_ADD");
    	
        setFrameUp();
        initComponents();
        pack();
    }
		
    private void setFrameUp() {
        getRootPane().setBorder(Borders.createEmptyBorder());
        setTitle(TITLE_MAIN_MENU);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
       setExtendedState(JFrame.MAXIMIZED_BOTH); 
//        setUndecorated(true);
        setResizable(false);
        LookAndFeelUtils.setWindowsLookAndFeel();
        getContentPane().setLayout(new GridLayout(1, 2, 20, 20));
    }
    
    private void initComponents() {
    	botao_adicionar = new JButton(BTN_ADD);
    	getContentPane().add(botao_adicionar);
    	 botao_cfops = new JButton("Cfops");
    	 getContentPane().add(botao_cfops);
    	 
    	
    }
    
	public JButton getBotao_cfops() {
		return botao_cfops;
	}

	public JButton getBotao_adicionar() {
		return botao_adicionar;
	}


    
    
    
}