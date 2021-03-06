/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Ventana.java
 *
 * Created on 2/03/2014, 11:32:32 AM
 */
package fayerbird.gui;

import fayerbird.core.*;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import twitter4j.Location;
import twitter4j.PagableResponseList;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;

/**
 *
 * @author desiderantes
 */
public class Ventana extends javax.swing.JFrame {

	private Autenticador auth;
	TwitterStream twitter;
	TwitterStream hashStream;
	Twitter tw;
	DefaultListModel statuses = new DefaultListModel();
	DefaultListModel hashtags = new DefaultListModel();
	DefaultListModel following = new DefaultListModel();
	DefaultListModel followed = new DefaultListModel();
	DefaultListModel personal = new DefaultListModel();
	StreamHandler listener = new StreamHandler(statuses);
	StreamHandler ownListener = new StreamHandler(statuses);
	List<Location> locations= new ArrayList<Location>();
	/** Creates new form Ventana */
	public Ventana(Autenticador authen) {
		
			this.auth = authen;
			this.twitter = auth.getTwitter();
			this.hashStream = new TwitterStreamFactory(auth.getConfig()).getInstance();
			
			initComponents();
			setTitle("Fayerbird Twitter Client");
			//User usuario = twitter.showUser(twitter.getId());
			//URL imgURL = new URL(usuario.getProfileImageURL());
			//ImageIcon img = new ImageIcon(imgURL);
			//jLabel1.setIcon(img);
			tw = auth.getTw();
			this.followUpdates();
			this.getProfile();
			this.setStatistics();
		
			this.actualizar();
		
			twitter.addListener(listener);
			twitter.user();
			
			this.setVisible(true);
		
	}
	
	public void getProfile(){
		try {
			User me = tw.showUser(tw.getScreenName());
			picLabel.setIcon(new ImageIcon(me.getBiggerProfileImageURL()));
			nameLabel.setText(me.getName());
			bioLabel.setText(me.getDescription());
			locationLabel.setText(me.getLocation());
		} catch (TwitterException ex) {
			Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
		}
	
	}

	public void setStatistics(){
		try {
			locations.addAll(tw.getAvailableTrends());
		} catch (TwitterException ex) {
			Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
		}
		HashSet<Trend> set = new HashSet<Trend>();
		for(Location loc : locations){
			try {
				set.addAll(Arrays.asList(tw.getPlaceTrends(loc.getWoeid()).getTrends()));
			} catch (TwitterException ex) {
				Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		for(Trend tr : set){
			hashtags.addElement(tr);
		}
	}
	
	public void followUpdates(){
		try {
			PagableResponseList<User> imFollowing = tw.getFriendsList(tw.getScreenName(), -1);
			PagableResponseList<User> followsMe = tw.getFollowersList(tw.getScreenName(), -1);
			long c1 = -1;
			long c2 = -1;
			while (c1 != 0){
			for(User u: imFollowing ){
				following.addElement(u);
				
			}
			c1 = imFollowing.getNextCursor();
			imFollowing = tw.getFriendsList(tw.getScreenName(), c1);
			}while(c2 !=0){
			for (User u: followsMe){
				followed.addElement(u);
			}
			c2 = followsMe.getNextCursor();
			followsMe = tw.getFollowersList(tw.getScreenName(), c2);
			}
		} catch (TwitterException ex) {
			Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalStateException ex) {
			Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
	
	public void actualizar()  {
		Paging pagina = new Paging();
		pagina.setCount(70);
		ArrayList<Status> listado = new ArrayList<Status>();
		try {
			listado.addAll(tw.getHomeTimeline(pagina));
		} catch (TwitterException ex) {
			Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
		}
		for (int i = 0; i < listado.size(); i++) {
			statuses.addElement(listado.get(i));
		}
	}
	

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jSplitPane4 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        picLabel = new javax.swing.JLabel();
        bioLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jSplitPane3 = new javax.swing.JSplitPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("windowFrame"); // NOI18N

        jTabbedPane1.setFont(jTabbedPane1.getFont());

        jSplitPane1.setDividerLocation(630);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jList1.setModel(statuses);
        jList1.setCellRenderer(new TweetPanel());
        jScrollPane3.setViewportView(jList1);

        jSplitPane1.setTopComponent(jScrollPane3);

        jLabel1.setText("Enviar un tweet");

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setToolTipText("Escriba aquí su tweet :D");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 445, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel1);

        jTabbedPane1.addTab("Timeline", null, jSplitPane1, "Ver los tweets del usuario");

        jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        picLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        picLabel.setNextFocusableComponent(nameLabel);

        bioLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bioLabel.setMaximumSize(new java.awt.Dimension(400, 100));
        bioLabel.setNextFocusableComponent(locationLabel);

        locationLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        nameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        nameLabel.setNextFocusableComponent(bioLabel);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(bioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(locationLabel)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(picLabel)))
                .addContainerGap(381, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(picLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationLabel)
                .addGap(16, 16, 16))
        );

        jSplitPane4.setTopComponent(jPanel4);

        jList5.setModel(personal);
        jList5.setCellRenderer(new TweetPanel());
        jScrollPane8.setViewportView(jList5);

        jSplitPane4.setRightComponent(jScrollPane8);

        jScrollPane1.setViewportView(jSplitPane4);

        jTabbedPane1.addTab("Perfil", null, jScrollPane1, "Mostrar el perfil del usuario");

        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jList2.setModel(hashtags);
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList2.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jScrollPane7.setViewportView(jList2);

        jSplitPane3.setTopComponent(jScrollPane7);

        jScrollPane2.setViewportView(jSplitPane3);

        jTabbedPane1.addTab("Hashtags", null, jScrollPane2, "Muestra información sobre un hashtag");

        jSplitPane2.setDividerLocation(400);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel2.setText("Te siguen");

        jList3.setModel(followed);
        jList3.setCellRenderer(new UserPanel());
        jScrollPane5.setViewportView(jList3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(531, Short.MAX_VALUE))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(jPanel2);

        jLabel3.setText("Siguiendo");

        jList4.setModel(following);
        jList4.setCellRenderer(new UserPanel());
        jScrollPane6.setViewportView(jList4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(530, Short.MAX_VALUE))
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(jPanel3);

        jTabbedPane1.addTab("Usuarios", jSplitPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		if(!"".equals(jTextField1.getText())){
            try {
                //Escribir tweet
                Status tweetEscrito=tw.updateStatus(jTextField1.getText());
                jTextField1.setText("");
            } catch (TwitterException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	}//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bioLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JList jList4;
    private javax.swing.JList jList5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel picLabel;
    // End of variables declaration//GEN-END:variables
}
