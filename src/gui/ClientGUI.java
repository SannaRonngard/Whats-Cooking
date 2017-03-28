package gui;

import javax.swing.*;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
/**
 * Klassen är GUI:t som klienten använder för 
 * att checka vilka ingredienter hen har hemma. 
 * Klienten klickar på sök och får recept som matchar 
 * hämtade från nätet. 
 * @author Sofia Larsson
 *
 */
public class ClientGUI extends JFrame {
	private JPanel panel = new JPanel();
	private JPanel lblTopPanel = new JPanel();
	private JPanel lblMenu = new JPanel();
	private JPanel lblBackground = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnDairy = new JMenu("Dairy");
	private JMenu mnMeat = new JMenu("Meat");
	private JMenu mnVeggies = new JMenu("Veggies");
	private JMenu mnFish = new JMenu("Fish");
	private JButton btnSearch = new JButton("Search");

	
	public ClientGUI() {
		getContentPane().setBackground(Color.GRAY);
		
		panel.setBackground(Color.WHITE);
		panel.setBackground(new Color(105, 105, 105));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 900, 600);
		setContentPane(panel);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		getContentPane().add(panel);
		panel.setLayout(null);
		setVisible(true);
		
		lblTopPanel.setBackground(Color.DARK_GRAY);
		lblTopPanel.setForeground(Color.BLACK);
		lblTopPanel.setBounds(0, 0, 894, 60);
		panel.add(lblTopPanel);
		/**
		 * Utfällbar meny med allternativ som går
		 * att markera genom att klicka på check-boxar. 
		 */
		lblTopPanel.add(menuBar);
		menuBar.setBackground(Color.DARK_GRAY);
		
		menuBar.add(mnDairy);
		mnDairy.add(new JCheckBoxMenuItem("Milk"));
		mnDairy.add(new JCheckBoxMenuItem("Cheese"));
		mnDairy.add(new JCheckBoxMenuItem("Quark"));
		
		menuBar.add(mnMeat);
		mnMeat.add(new JCheckBoxMenuItem("Beef"));
		mnMeat.add(new JCheckBoxMenuItem("Pork"));
		mnMeat.add(new JCheckBoxMenuItem("Chicken"));
		
		menuBar.add(mnVeggies);
		mnVeggies.add(new JCheckBoxMenuItem("Tomato"));
		mnVeggies.add(new JCheckBoxMenuItem("Squash"));
		mnVeggies.add(new JCheckBoxMenuItem("Pak Choi"));
		
		menuBar.add(mnFish);
		mnFish.add(new JCheckBoxMenuItem("Salmon"));
		mnFish.add(new JCheckBoxMenuItem("Tuna"));
		mnFish.add(new JCheckBoxMenuItem("Codfish"));
		
		lblMenu.setBackground(Color.WHITE);
		lblMenu.setBounds(0, 59, 262, 512);
		panel.add(lblMenu);
		
		/**
		 * Demo av iconer som representerar matkategorier
		 * i det vänstra meny-fältet.
		 */
//		JLabel lblMeat = new JLabel("");
//		lblMeat.setVisible(false);
//		lblMeat.setIcon(new ImageIcon("C:\\Users\\Sofia Larsson\\Documents\\EclipseProjects\\Whats-Cooking\\images\\icon_dairy.png"));
//		lblMenu.add(lblMeat);
//		
//		JLabel lblDairy = new JLabel("");
//		lblDairy.setVisible(false);
//		lblDairy.setIcon(new ImageIcon("C:\\Users\\Sofia Larsson\\Documents\\EclipseProjects\\Whats-Cooking\\images\\icon_meat.png"));
//		lblMenu.add(lblDairy);
//		
//		JLabel lblVeggies = new JLabel("");
//		lblVeggies.setVisible(false);
//		lblVeggies.setIcon(new ImageIcon("C:\\Users\\Sofia Larsson\\Documents\\EclipseProjects\\Whats-Cooking\\images\\icon_veggies.png"));
//		lblMenu.add(lblVeggies);
		
		lblBackground.setBounds(0, 59, 894, 512);
		panel.add(lblBackground);
	}
	/**
	 * Listeners ej implementerade. 
	 * Sytet är att lyssna på vilka checkboxar som är checkade. 
	 * @author Sofia Larsson
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
//	public static void main(String[] args){
//		ClientGUI testGUI = new ClientGUI();
//	}
}
