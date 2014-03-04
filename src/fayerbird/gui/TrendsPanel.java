/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fayerbird.gui;


import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import twitter4j.Trend;
import twitter4j.User;

/**
 *
 * @author desiderantes
 */
public class TrendsPanel extends javax.swing.JPanel implements ListCellRenderer {
	public TrendsPanel(){
		initComponents();
	}
	
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();

		jLabel1.setText("jLabel1");

		jLabel2.setText("jLabel2");
		jLabel2.setMaximumSize(new java.awt.Dimension(48, 48));
		jLabel2.setMinimumSize(new java.awt.Dimension(48, 48));
		jLabel2.setPreferredSize(new java.awt.Dimension(48, 48));

		jLabel.setText("Debug");


		jLabel3.setText("jLabel3");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jLabel1).addGap(0, 0, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jLabel3).addGap(0, 0, Short.MAX_VALUE)).addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)))).addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE).addComponent(jLabel3).addContainerGap()));
	}// </editor-fold>
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel;
	// End of variables declaration

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		Trend tr = (Trend) value;
		
		jLabel.setText(tr.getName());

		return this;
	}
}
