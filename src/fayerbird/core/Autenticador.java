/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fayerbird.core;

import java.awt.Desktop;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author desiderantes
 */
public class Autenticador {

    private Twitter twitter;
    private ConfigurationBuilder configBuilder;

    private File logfile;

    public Autenticador() throws IOException, TwitterException { //Constructor de la clase
        logfile = new File("auth_file.txt");
        configBuilder = new ConfigurationBuilder();
        configBuilder.setDebugEnabled(true);
        if (logfile.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream(logfile);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                try {
                    ArrayList<String> authString = (ArrayList<String>) objectIn.readObject();
                    configBuilder.setOAuthConsumerKey(authString.get(0));
                    configBuilder.setOAuthConsumerSecret(authString.get(1));
                    configBuilder.setOAuthAccessToken(authString.get(2));
                    configBuilder.setOAuthAccessTokenSecret(authString.get(3));
                    twitter = new TwitterFactory(configBuilder.build()).getInstance();
                } finally {
                    objectIn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
           
            configBuilder.setOAuthConsumerKey("DI05nv99UI3wSSlqI6qJaA");
            configBuilder.setOAuthConsumerSecret("P3RVFt0q11edhdEuwRIJRead13F7orXLjwawjRatW2k");
            twitter = new TwitterFactory(configBuilder.build()).getInstance();
            RequestToken requestToken;
            AccessToken accessToken;
            requestToken = null;
            accessToken = null;
            String url = null;
            do {
                try {
                    requestToken = twitter.getOAuthRequestToken();
                    System.out.println("Request Tokens obtenidos con éxito.");
                    System.out.println("Request Token: " + requestToken.getToken());
                    System.out.println("Request Token secret: " + requestToken.getTokenSecret());
                    url = requestToken.getAuthorizationURL();
                    System.out.println("URL:");
                    System.out.println(url);
                } catch (TwitterException ex) {
                    Logger.getLogger(Fayerbird.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(new URI(url));
                    } catch (Exception e) {
                        
                        e.printStackTrace();
                    }
                } else {
                    Runtime runtime = Runtime.getRuntime();
                    try {
                        runtime.exec("xdg-open " + url);
                    } catch (IOException e) {
                        
                        e.printStackTrace();
                    }
                }
                //Nos avisa de que introduciremos el PIN a continuación
                System.out.print("Introduce el PIN del navegador y pulsa intro.\n\n PIN: ");
//Leemos el PIN
                String pin = input.readLine();
                if (pin.length() > 0) {
                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                } else {
                    accessToken = twitter.getOAuthAccessToken(requestToken);
                }
            } while (accessToken == null);
            
            try {
                OutputStream file = new FileOutputStream(logfile);
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer);
                try {
                    ArrayList<String> auth = new ArrayList<String>();
                    auth.add("DI05nv99UI3wSSlqI6qJaA");
                    auth.add("P3RVFt0q11edhdEuwRIJRead13F7orXLjwawjRatW2k");
                    auth.add(accessToken.getToken());
                    auth.add(accessToken.getTokenSecret());
                    output.writeObject(auth);
                } finally {
                    output.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n\nAccess Tokens obtenidos con éxito.");
        System.out.println("Access Token: " + twitter.getOAuthAccessToken().getToken());
        System.out.println("Access Token secret: " + twitter.getOAuthAccessToken().getTokenSecret());
       
    }

    public ConfigurationBuilder getConfigBuilder() {
        return configBuilder;
    }

    public Twitter getTwitter() {
        return twitter;
    }
    
    
}
