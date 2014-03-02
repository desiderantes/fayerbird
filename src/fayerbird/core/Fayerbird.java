/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fayerbird.core;

import fayerbird.gui.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.TwitterException;

/**
 *
 * @author desiderantes
 */
public class Fayerbird {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("GTK".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				} else if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;

				} else if ("Aqua".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				} if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				} else {
					javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		
		
		
		try {
			Autenticador auth = new Autenticador();
			new Ventana(auth).setVisible(true);
		} catch (IOException ex) {
			Logger.getLogger(Fayerbird.class.getName()).log(Level.SEVERE, null, ex);
		} catch (TwitterException ex) {
			Logger.getLogger(Fayerbird.class.getName()).log(Level.SEVERE, null, ex);
		}
		



	}
}
