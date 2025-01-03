package aquaguard;

import Sections.Fishfall.User;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Jordan Dreelan x23150076
 */
public class AquaGuardApp extends javax.swing.JFrame {
    private int mouseX, mouseY;
    private CardLayout cl;
    
    private static ArrayList<User> Users = new ArrayList<User>();
    private static User currentUser;
    
    public static Basket basket = new Basket();
    public static Customer cust = new Customer();
    /**
     * Creates new form AquaGuardApp
     */
    
    //AquaGuardApp constructor
    public AquaGuardApp() {
        //Users.add(Admin);
        initComponents();
        this.setLocationRelativeTo(null);
        dragWindow(this);
        cl = (CardLayout)(cards.getLayout());
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
        
    }
    
    //method to get array of Users
    public static ArrayList<User> getUsers(){
        return Users;
    }
    
    //method to add User to array of users
    public static void addUser(User u){
        Users.add(u);
    }
    
    //method to set the current User using the app
    public void setCurrentUser(User user){
        this.currentUser = user;
    }
    
    //method to get the current User using the app
    public static User getCurrentUser(){
        return currentUser;
    }
    
    // method for moving app around the screen since it is undecorated
    public void dragWindow(JFrame frame){
        
        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                 mouseX = e.getX();
                 mouseY = e.getY();
            }
        });

        frame.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                // Get the new position of the window
                int newX = e.getXOnScreen() - mouseX;
                int newY = e.getYOnScreen() - mouseY;

                // Set the new position of the window
                frame.setLocation(newX, newY);
            }
        });

    }
    // method for bubble popping noise when buttons are clicked
    public static void bubblePop(){
        String soundName = "src/Audio/bubblePop.wav";    
        AudioInputStream audioInputStream = null;
        Clip clip = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(AquaGuardApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AquaGuardApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(AquaGuardApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(-20);
        
        clip.start();
    }
    
    //method for signing up and creating new account
    public void Signup(){
        if(verifySignupCredentials()){
            User u = new User(signupUsernameInputField.getText(),signupPasswordInputField.getText());
            Users.add(u);
            AquaGuard.saveUser(u);
            nameLabel.setText("Login");
            cl.show(cards,"login");
            
        }
    }
    
    //method to verify credentials for new account
    public boolean verifySignupCredentials(){
        if(signupUsernameInputField.getText().isEmpty()){
            signupErrorLabel.setText("Please Enter A Username");
            return false;
        }else if(signupPasswordInputField.getText().isEmpty()){
            signupErrorLabel.setText("Please Enter A Password");
            return false;
        }else if(confirmPasswordInputField.getText().isEmpty()){
            signupErrorLabel.setText("Please Confirm Password");
            return false;
        }else if(!confirmPasswordInputField.getText().equals(signupPasswordInputField.getText())){
            
            signupErrorLabel.setText("Passwords Do Not Match");
            return false;
        }
        loginErrorLabel.setText("");
        return true;
    }
    
    //method for logging in
    public void login(){
        if(verifyLoginCredentials()){
            cl.show(cards,"home");
            nameLabel.setText("Home");
            homeBTN.setVisible(true);
            logoutLabel.setVisible(true);
            settingsBTN.setVisible(true);
            settingsPage1.setUser(currentUser);
            settingsPage1.initUser();
        }
    }
    
    //method to verify credentials when logging in
    public boolean verifyLoginCredentials(){
        for(User u : Users){
            if(u.checkUsername(usernameInputField.getText()) && u.checkPassword(passwordInputField.getText())){
                currentUser = u;
               return true;
            }
        }
        loginErrorLabel.setText("No Account Matching Those Credentials Found");
        return false;
    }
    
    //method to clear signup and login InputField
    public void clearCredentials(){
        usernameInputField.clearText();
        passwordInputField.clearText();
        signupUsernameInputField.clearText();
        signupPasswordInputField.clearText();
        confirmPasswordInputField.clearText();
        loginErrorLabel.setText("");
    }
    
    //method to logout
    public void logout(){
        cl.show(cards,"login");
        nameLabel.setText("Login");
        homeBTN.setVisible(false);
        logoutLabel.setVisible(false);
        settingsBTN.setVisible(false);
        clearCredentials();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleBar = new javax.swing.JPanel();
        exitBTN = new javax.swing.JLabel();
        minimiseBTN = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        iconLabel = new javax.swing.JLabel();
        topBar = new javax.swing.JPanel();
        homeBTN = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        settingsBTN = new javax.swing.JLabel();
        cards = new javax.swing.JPanel();
        loginCard = new javax.swing.JPanel();
        usernameInputField = new Sections.Main.InputField();
        passwordInputField = new Sections.Main.InputField();
        loginBTN = new javax.swing.JLabel();
        createAccountBTN = new javax.swing.JLabel();
        loginErrorLabel = new javax.swing.JLabel();
        passwordDisplay = new javax.swing.JLabel();
        usernameDisplay = new javax.swing.JLabel();
        credentialsDisplay = new javax.swing.JLabel();
        signupCard = new javax.swing.JPanel();
        signupUsernameInputField = new Sections.Main.InputField();
        signupPasswordInputField = new Sections.Main.InputField();
        SignupBTN = new javax.swing.JLabel();
        signupLoginBTN = new javax.swing.JLabel();
        signupErrorLabel = new javax.swing.JLabel();
        confirmPasswordInputField = new Sections.Main.InputField();
        homeCard = new javax.swing.JPanel();
        descriptionText = new javax.swing.JLabel();
        shoppingBTN = new javax.swing.JLabel();
        fishFallBTN = new javax.swing.JLabel();
        adoptionBTN = new javax.swing.JLabel();
        fishFallSection1 = new Sections.Fishfall.FishFallSection();
        settingsPage1 = new Sections.Main.SettingsPage();
        shop = new javax.swing.JPanel();
        itembg1JP = new javax.swing.JPanel();
        item1LBL = new javax.swing.JLabel();
        price1LBL = new javax.swing.JLabel();
        image1LBL = new javax.swing.JLabel();
        stock1LBL = new javax.swing.JLabel();
        buy1BTN = new javax.swing.JLabel();
        remove1BTN = new javax.swing.JLabel();
        itembg2JP = new javax.swing.JPanel();
        item2LBL = new javax.swing.JLabel();
        price2LBL = new javax.swing.JLabel();
        image2LBL = new javax.swing.JLabel();
        stock2LBL = new javax.swing.JLabel();
        buy2BTN = new javax.swing.JLabel();
        remove2BTN = new javax.swing.JLabel();
        itembg3JP = new javax.swing.JPanel();
        item3LBL = new javax.swing.JLabel();
        price3LBL = new javax.swing.JLabel();
        image3LBL = new javax.swing.JLabel();
        stock3LBL = new javax.swing.JLabel();
        buy3BTN = new javax.swing.JLabel();
        remove3BTN = new javax.swing.JLabel();
        itembg4JP = new javax.swing.JPanel();
        item4LBL = new javax.swing.JLabel();
        price4LBL = new javax.swing.JLabel();
        image4LBL = new javax.swing.JLabel();
        stock4LBL = new javax.swing.JLabel();
        buy4BTN = new javax.swing.JLabel();
        remove4BTN = new javax.swing.JLabel();
        itembg5JP = new javax.swing.JPanel();
        item5LBL = new javax.swing.JLabel();
        price5LBL = new javax.swing.JLabel();
        image5LBL = new javax.swing.JLabel();
        stock5LBL = new javax.swing.JLabel();
        buy5BTN = new javax.swing.JLabel();
        remove5BTN = new javax.swing.JLabel();
        basketJP = new javax.swing.JPanel();
        basketLBL = new javax.swing.JLabel();
        totalPriceLBL = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        basketItemsTA = new javax.swing.JTextArea();
        clearBasketBTN = new javax.swing.JLabel();
        billingPanel = new javax.swing.JPanel();
        nameLBL = new javax.swing.JLabel();
        emailLBL = new javax.swing.JLabel();
        addressLBL = new javax.swing.JLabel();
        billinginfoLBL = new javax.swing.JLabel();
        customerNameTF = new javax.swing.JTextField();
        customerEmailTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerAddressTA = new javax.swing.JTextArea();
        itembg6JP = new javax.swing.JPanel();
        item6LBL = new javax.swing.JLabel();
        price6LBL = new javax.swing.JLabel();
        image6LBL = new javax.swing.JLabel();
        stock6LBL = new javax.swing.JLabel();
        buy6BTN = new javax.swing.JLabel();
        remove6BTN = new javax.swing.JLabel();
        checkoutBTN1 = new javax.swing.JLabel();
        adoptionCard = new javax.swing.JPanel();
        adopternameLBL = new javax.swing.JLabel();
        adopternameTF = new javax.swing.JTextField();
        accountnumberLBL = new javax.swing.JLabel();
        accountnumberTF = new javax.swing.JTextField();
        donationamountLBL = new javax.swing.JLabel();
        donationamountTF = new javax.swing.JTextField();
        addBTN = new javax.swing.JButton();
        clearBTN = new javax.swing.JButton();
        exitBTN1 = new javax.swing.JButton();
        frequencyLBL = new javax.swing.JLabel();
        frequencyTF = new javax.swing.JTextField();
        animaladopterregistrationLBL = new javax.swing.JLabel();
        adopteremailLBL = new javax.swing.JLabel();
        adopteremailTF = new javax.swing.JTextField();
        updateBTN = new javax.swing.JButton();
        mainmenuBTN = new javax.swing.JButton();
        topreviousjformBTN = new javax.swing.JButton();
        nameLBL1 = new javax.swing.JLabel();
        ageLBL = new javax.swing.JLabel();
        sexLBL = new javax.swing.JLabel();
        nameTF1 = new javax.swing.JTextField();
        ageTF = new javax.swing.JTextField();
        sexTF = new javax.swing.JTextField();
        animaladopteeLBL = new javax.swing.JLabel();
        addBTN1 = new javax.swing.JButton();
        clearBTN1 = new javax.swing.JButton();
        updateBTN1 = new javax.swing.JButton();
        exitBTN2 = new javax.swing.JButton();
        mainmenuBTN1 = new javax.swing.JButton();
        tonextjformBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aqua Guard");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1500, 950));
        setMinimumSize(new java.awt.Dimension(1500, 950));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1500, 900));

        titleBar.setBackground(new java.awt.Color(1, 187, 187));
        titleBar.setMaximumSize(new java.awt.Dimension(1500, 50));
        titleBar.setMinimumSize(new java.awt.Dimension(1500, 50));
        titleBar.setPreferredSize(new java.awt.Dimension(1500, 50));

        exitBTN.setBackground(new java.awt.Color(49, 122, 139));
        exitBTN.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        exitBTN.setForeground(new java.awt.Color(255, 255, 255));
        exitBTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitBTN.setText("X");
        exitBTN.setMaximumSize(new java.awt.Dimension(40, 40));
        exitBTN.setMinimumSize(new java.awt.Dimension(40, 40));
        exitBTN.setOpaque(true);
        exitBTN.setPreferredSize(new java.awt.Dimension(40, 40));
        exitBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBTNMouseClicked(evt);
            }
        });

        minimiseBTN.setBackground(new java.awt.Color(33, 86, 138));
        minimiseBTN.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        minimiseBTN.setForeground(new java.awt.Color(255, 255, 255));
        minimiseBTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimiseBTN.setText("-");
        minimiseBTN.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        minimiseBTN.setMaximumSize(new java.awt.Dimension(40, 40));
        minimiseBTN.setMinimumSize(new java.awt.Dimension(40, 40));
        minimiseBTN.setOpaque(true);
        minimiseBTN.setPreferredSize(new java.awt.Dimension(40, 40));
        minimiseBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimiseBTNMouseClicked(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Aqua Guard");

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AquaGuardLogo.png"))); // NOI18N

        javax.swing.GroupLayout titleBarLayout = new javax.swing.GroupLayout(titleBar);
        titleBar.setLayout(titleBarLayout);
        titleBarLayout.setHorizontalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleBarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(iconLabel)
                .addGap(10, 10, 10)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimiseBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(exitBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        titleBarLayout.setVerticalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(titleBarLayout.createSequentialGroup()
                .addGroup(titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(minimiseBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(iconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        topBar.setBackground(new java.awt.Color(0, 255, 255));
        topBar.setBorder(new MatteBorder(-5, 0, 5, 0, new Color(46, 116, 132)));
        topBar.setMaximumSize(new java.awt.Dimension(1500, 100));
        topBar.setMinimumSize(new java.awt.Dimension(1500, 100));
        topBar.setPreferredSize(new java.awt.Dimension(1500, 100));

        homeBTN.setVisible(false);
        homeBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buttons/homeBTN.png"))); // NOI18N
        homeBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBTNMouseClicked(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("Login");

        logoutLabel.setVisible(false);
        logoutLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        logoutLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoutLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logoutBTN.png"))); // NOI18N
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabelMouseClicked(evt);
            }
        });

        settingsBTN.setVisible(false);
        settingsBTN.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        settingsBTN.setForeground(new java.awt.Color(255, 255, 255));
        settingsBTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingsBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settingsBTN.png"))); // NOI18N
        settingsBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsBTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addComponent(homeBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(settingsBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutLabel)
                .addContainerGap())
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(settingsBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutLabel))
                .addContainerGap())
        );

        cards.setBackground(new java.awt.Color(49, 122, 139));
        cards.setMaximumSize(new java.awt.Dimension(1500, 800));
        cards.setMinimumSize(new java.awt.Dimension(1500, 800));
        cards.setPreferredSize(new java.awt.Dimension(1500, 800));
        cards.setLayout(new java.awt.CardLayout());

        loginCard.setOpaque(false);

        usernameInputField.setTag("Username");

        passwordInputField.setTag("Password");

        loginBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buttons/loginBTN.png"))); // NOI18N
        loginBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBTNMouseClicked(evt);
            }
        });

        createAccountBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buttons/SignupButton.png"))); // NOI18N
        createAccountBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createAccountBTNMouseClicked(evt);
            }
        });

        loginErrorLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        loginErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        loginErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        passwordDisplay.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        passwordDisplay.setText("Password : Password");

        usernameDisplay.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        usernameDisplay.setText("Username : Admin");

        credentialsDisplay.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        credentialsDisplay.setText("Login Credentials");

        javax.swing.GroupLayout loginCardLayout = new javax.swing.GroupLayout(loginCard);
        loginCard.setLayout(loginCardLayout);
        loginCardLayout.setHorizontalGroup(
            loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginCardLayout.createSequentialGroup()
                .addGroup(loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(loginErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(createAccountBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(loginCardLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(loginBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, loginCardLayout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addGroup(loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(passwordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(loginCardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(usernameDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(credentialsDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        loginCardLayout.setVerticalGroup(
            loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginCardLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(loginErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usernameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createAccountBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(credentialsDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordDisplay)
                .addContainerGap())
        );

        cards.add(loginCard, "login");

        signupCard.setOpaque(false);

        signupUsernameInputField.setTag("Username");

        signupPasswordInputField.setTag("Password");

        SignupBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buttons/SignupButton.png"))); // NOI18N
        SignupBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignupBTNMouseClicked(evt);
            }
        });

        signupLoginBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buttons/loginBTN.png"))); // NOI18N
        signupLoginBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupLoginBTNMouseClicked(evt);
            }
        });

        signupErrorLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        signupErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        signupErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        confirmPasswordInputField.setTag("Confirm Password");

        javax.swing.GroupLayout signupCardLayout = new javax.swing.GroupLayout(signupCard);
        signupCard.setLayout(signupCardLayout);
        signupCardLayout.setHorizontalGroup(
            signupCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupCardLayout.createSequentialGroup()
                .addGroup(signupCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(confirmPasswordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signupErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signupLoginBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(signupCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(signupCardLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(SignupBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, signupCardLayout.createSequentialGroup()
                            .addGap(175, 175, 175)
                            .addGroup(signupCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(signupPasswordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(signupUsernameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        signupCardLayout.setVerticalGroup(
            signupCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupCardLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(signupErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signupUsernameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signupPasswordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmPasswordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SignupBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signupLoginBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        cards.add(signupCard, "signup");

        homeCard.setMaximumSize(new java.awt.Dimension(1500, 800));
        homeCard.setMinimumSize(new java.awt.Dimension(1500, 800));
        homeCard.setOpaque(false);

        descriptionText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AquaGuard Description.png"))); // NOI18N

        shoppingBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buttons/Shopping.png"))); // NOI18N
        shoppingBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shoppingBTNMouseClicked(evt);
            }
        });

        fishFallBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buttons/Fish Fall.png"))); // NOI18N
        fishFallBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fishFallBTNMouseClicked(evt);
            }
        });

        adoptionBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buttons/Adoption.png"))); // NOI18N
        adoptionBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adoptionBTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout homeCardLayout = new javax.swing.GroupLayout(homeCard);
        homeCard.setLayout(homeCardLayout);
        homeCardLayout.setHorizontalGroup(
            homeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeCardLayout.createSequentialGroup()
                .addComponent(descriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeCardLayout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(shoppingBTN)
                .addGap(18, 18, 18)
                .addComponent(fishFallBTN)
                .addGap(18, 18, 18)
                .addComponent(adoptionBTN)
                .addGap(192, 192, 192))
        );
        homeCardLayout.setVerticalGroup(
            homeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeCardLayout.createSequentialGroup()
                .addComponent(descriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(homeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shoppingBTN)
                    .addComponent(fishFallBTN)
                    .addComponent(adoptionBTN))
                .addGap(0, 44, Short.MAX_VALUE))
        );

        cards.add(homeCard, "home");
        cards.add(fishFallSection1, "fishFall");
        cards.add(settingsPage1, "settings");

        shop.setOpaque(false);

        itembg1JP.setBackground(new java.awt.Color(0, 255, 255));
        itembg1JP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        itembg1JP.setPreferredSize(new java.awt.Dimension(287, 354));

        item1LBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        item1LBL.setText("AquaGuard Shirt");

        price1LBL.setText("Price: €20.99");

        image1LBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Products/tshirt.png"))); // NOI18N

        stock1LBL.setText("Stock : 25");

        buy1BTN.setBackground(new java.awt.Color(1, 187, 187));
        buy1BTN.setForeground(new java.awt.Color(255, 255, 255));
        buy1BTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buy1BTN.setText("Buy");
        buy1BTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        buy1BTN.setOpaque(true);
        buy1BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy1BTNMouseClicked(evt);
            }
        });

        remove1BTN.setBackground(new java.awt.Color(1, 187, 187));
        remove1BTN.setForeground(new java.awt.Color(255, 255, 255));
        remove1BTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        remove1BTN.setText("Remove");
        remove1BTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        remove1BTN.setOpaque(true);
        remove1BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remove1BTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout itembg1JPLayout = new javax.swing.GroupLayout(itembg1JP);
        itembg1JP.setLayout(itembg1JPLayout);
        itembg1JPLayout.setHorizontalGroup(
            itembg1JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itembg1JPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(itembg1JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itembg1JPLayout.createSequentialGroup()
                        .addComponent(price1LBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(buy1BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remove1BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(stock1LBL)
                    .addComponent(item1LBL)
                    .addComponent(image1LBL, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        itembg1JPLayout.setVerticalGroup(
            itembg1JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itembg1JPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(image1LBL)
                .addGap(18, 18, 18)
                .addComponent(item1LBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(itembg1JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(itembg1JPLayout.createSequentialGroup()
                        .addComponent(stock1LBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(price1LBL))
                    .addGroup(itembg1JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buy1BTN)
                        .addComponent(remove1BTN)))
                .addContainerGap())
        );

        itembg2JP.setBackground(new java.awt.Color(0, 255, 255));
        itembg2JP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        itembg2JP.setPreferredSize(new java.awt.Dimension(287, 354));

        item2LBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        item2LBL.setText("AquaGuard Cap");

        price2LBL.setText("Price: €15.99");

        image2LBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Products/cap.png"))); // NOI18N

        stock2LBL.setText("Stock : 15");

        buy2BTN.setBackground(new java.awt.Color(1, 187, 187));
        buy2BTN.setForeground(new java.awt.Color(255, 255, 255));
        buy2BTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buy2BTN.setText("Buy");
        buy2BTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        buy2BTN.setOpaque(true);
        buy2BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy2BTNMouseClicked(evt);
            }
        });

        remove2BTN.setBackground(new java.awt.Color(1, 187, 187));
        remove2BTN.setForeground(new java.awt.Color(255, 255, 255));
        remove2BTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        remove2BTN.setText("Remove");
        remove2BTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        remove2BTN.setOpaque(true);
        remove2BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remove2BTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout itembg2JPLayout = new javax.swing.GroupLayout(itembg2JP);
        itembg2JP.setLayout(itembg2JPLayout);
        itembg2JPLayout.setHorizontalGroup(
            itembg2JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itembg2JPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(itembg2JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itembg2JPLayout.createSequentialGroup()
                        .addGroup(itembg2JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(item2LBL)
                            .addGroup(itembg2JPLayout.createSequentialGroup()
                                .addGroup(itembg2JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(price2LBL)
                                    .addComponent(stock2LBL))
                                .addGap(18, 18, 18)
                                .addComponent(buy2BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remove2BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(image2LBL, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        itembg2JPLayout.setVerticalGroup(
            itembg2JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itembg2JPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(image2LBL)
                .addGap(18, 18, 18)
                .addComponent(item2LBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(itembg2JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(itembg2JPLayout.createSequentialGroup()
                        .addComponent(stock2LBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(price2LBL))
                    .addGroup(itembg2JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buy2BTN)
                        .addComponent(remove2BTN)))
                .addContainerGap())
        );

        itembg3JP.setBackground(new java.awt.Color(0, 255, 255));
        itembg3JP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        itembg3JP.setPreferredSize(new java.awt.Dimension(287, 354));

        item3LBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        item3LBL.setText("AquaGuard Bottle");

        price3LBL.setText("Price: €18.50");

        image3LBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Products/bottle.png"))); // NOI18N

        stock3LBL.setText("Stock : 12");

        buy3BTN.setBackground(new java.awt.Color(1, 187, 187));
        buy3BTN.setForeground(new java.awt.Color(255, 255, 255));
        buy3BTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buy3BTN.setText("Buy");
        buy3BTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        buy3BTN.setOpaque(true);
        buy3BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy3BTNMouseClicked(evt);
            }
        });

        remove3BTN.setBackground(new java.awt.Color(1, 187, 187));
        remove3BTN.setForeground(new java.awt.Color(255, 255, 255));
        remove3BTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        remove3BTN.setText("Remove");
        remove3BTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        remove3BTN.setOpaque(true);
        remove3BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remove3BTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout itembg3JPLayout = new javax.swing.GroupLayout(itembg3JP);
        itembg3JP.setLayout(itembg3JPLayout);
        itembg3JPLayout.setHorizontalGroup(
            itembg3JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itembg3JPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(itembg3JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itembg3JPLayout.createSequentialGroup()
                        .addComponent(price3LBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buy3BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remove3BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(stock3LBL)
                    .addComponent(item3LBL)
                    .addComponent(image3LBL, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        itembg3JPLayout.setVerticalGroup(
            itembg3JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itembg3JPLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(image3LBL)
                .addGap(18, 18, 18)
                .addComponent(item3LBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(itembg3JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(itembg3JPLayout.createSequentialGroup()
                        .addComponent(stock3LBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(price3LBL))
                    .addGroup(itembg3JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buy3BTN)
                        .addComponent(remove3BTN)))
                .addContainerGap())
        );

        itembg4JP.setBackground(new java.awt.Color(0, 255, 255));
        itembg4JP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        itembg4JP.setPreferredSize(new java.awt.Dimension(287, 354));

        item4LBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        item4LBL.setText("AquaGuard Bracelet");

        price4LBL.setText("Price: €10.55");

        image4LBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Products/bracelet.png"))); // NOI18N

        stock4LBL.setText("Stock : 12");

        buy4BTN.setBackground(new java.awt.Color(1, 187, 187));
        buy4BTN.setForeground(new java.awt.Color(255, 255, 255));
        buy4BTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buy4BTN.setText("Buy");
        buy4BTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        buy4BTN.setOpaque(true);
        buy4BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy4BTNMouseClicked(evt);
            }
        });

        remove4BTN.setBackground(new java.awt.Color(1, 187, 187));
        remove4BTN.setForeground(new java.awt.Color(255, 255, 255));
        remove4BTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        remove4BTN.setText("Remove");
        remove4BTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        remove4BTN.setOpaque(true);
        remove4BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remove4BTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout itembg4JPLayout = new javax.swing.GroupLayout(itembg4JP);
        itembg4JP.setLayout(itembg4JPLayout);
        itembg4JPLayout.setHorizontalGroup(
            itembg4JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itembg4JPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(itembg4JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itembg4JPLayout.createSequentialGroup()
                        .addComponent(price4LBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buy4BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remove4BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(itembg4JPLayout.createSequentialGroup()
                        .addGroup(itembg4JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stock4LBL)
                            .addComponent(item4LBL)
                            .addComponent(image4LBL, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        itembg4JPLayout.setVerticalGroup(
            itembg4JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itembg4JPLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(image4LBL)
                .addGap(18, 18, 18)
                .addComponent(item4LBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(itembg4JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(itembg4JPLayout.createSequentialGroup()
                        .addComponent(stock4LBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(price4LBL))
                    .addGroup(itembg4JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buy4BTN)
                        .addComponent(remove4BTN)))
                .addContainerGap())
        );

        itembg5JP.setBackground(new java.awt.Color(0, 255, 255));
        itembg5JP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        itembg5JP.setPreferredSize(new java.awt.Dimension(287, 354));

        item5LBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        item5LBL.setText("AquaGuard Poster");

        price5LBL.setText("Price: €10.20");

        image5LBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Products/poster.png"))); // NOI18N

        stock5LBL.setText("Stock : 15");

        buy5BTN.setBackground(new java.awt.Color(1, 187, 187));
        buy5BTN.setForeground(new java.awt.Color(255, 255, 255));
        buy5BTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buy5BTN.setText("Buy");
        buy5BTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        buy5BTN.setOpaque(true);
        buy5BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy5BTNMouseClicked(evt);
            }
        });

        remove5BTN.setBackground(new java.awt.Color(1, 187, 187));
        remove5BTN.setForeground(new java.awt.Color(255, 255, 255));
        remove5BTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        remove5BTN.setText("Remove");
        remove5BTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        remove5BTN.setOpaque(true);
        remove5BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remove5BTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout itembg5JPLayout = new javax.swing.GroupLayout(itembg5JP);
        itembg5JP.setLayout(itembg5JPLayout);
        itembg5JPLayout.setHorizontalGroup(
            itembg5JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itembg5JPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(itembg5JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itembg5JPLayout.createSequentialGroup()
                        .addComponent(price5LBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buy5BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remove5BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(itembg5JPLayout.createSequentialGroup()
                        .addGroup(itembg5JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(item5LBL)
                            .addComponent(image5LBL, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stock5LBL))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        itembg5JPLayout.setVerticalGroup(
            itembg5JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itembg5JPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(image5LBL)
                .addGap(18, 18, 18)
                .addComponent(item5LBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(itembg5JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(itembg5JPLayout.createSequentialGroup()
                        .addComponent(stock5LBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(price5LBL))
                    .addGroup(itembg5JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buy5BTN)
                        .addComponent(remove5BTN)))
                .addContainerGap())
        );

        basketJP.setBackground(new java.awt.Color(33, 86, 138));
        basketJP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));

        basketLBL.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        basketLBL.setForeground(new java.awt.Color(255, 255, 255));
        basketLBL.setText("Basket");

        totalPriceLBL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalPriceLBL.setForeground(new java.awt.Color(255, 255, 255));
        totalPriceLBL.setText("Total:");

        basketItemsTA.setEditable(false);
        basketItemsTA.setBackground(new java.awt.Color(33, 86, 138));
        basketItemsTA.setColumns(20);
        basketItemsTA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        basketItemsTA.setForeground(new java.awt.Color(255, 255, 255));
        basketItemsTA.setRows(5);
        jScrollPane2.setViewportView(basketItemsTA);

        clearBasketBTN.setBackground(new java.awt.Color(1, 187, 187));
        clearBasketBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clearBasketBTN.setForeground(new java.awt.Color(255, 255, 255));
        clearBasketBTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clearBasketBTN.setText("Clear");
        clearBasketBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        clearBasketBTN.setOpaque(true);
        clearBasketBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBasketBTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout basketJPLayout = new javax.swing.GroupLayout(basketJP);
        basketJP.setLayout(basketJPLayout);
        basketJPLayout.setHorizontalGroup(
            basketJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basketJPLayout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(basketLBL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(basketJPLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(totalPriceLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearBasketBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basketJPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        basketJPLayout.setVerticalGroup(
            basketJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basketJPLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(basketLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addGap(18, 18, 18)
                .addGroup(basketJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearBasketBTN, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalPriceLBL, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(14, 14, 14))
        );

        billingPanel.setBackground(new java.awt.Color(33, 86, 138));
        billingPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));

        nameLBL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nameLBL.setForeground(new java.awt.Color(255, 255, 255));
        nameLBL.setText("Name:");

        emailLBL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        emailLBL.setForeground(new java.awt.Color(255, 255, 255));
        emailLBL.setText("Email:");

        addressLBL.setBackground(new java.awt.Color(255, 255, 255));
        addressLBL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addressLBL.setForeground(new java.awt.Color(255, 255, 255));
        addressLBL.setText("Address:");

        billinginfoLBL.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        billinginfoLBL.setForeground(new java.awt.Color(255, 255, 255));
        billinginfoLBL.setText("Billing Information");

        customerAddressTA.setColumns(20);
        customerAddressTA.setRows(5);
        jScrollPane1.setViewportView(customerAddressTA);

        javax.swing.GroupLayout billingPanelLayout = new javax.swing.GroupLayout(billingPanel);
        billingPanel.setLayout(billingPanelLayout);
        billingPanelLayout.setHorizontalGroup(
            billingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billingPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(billingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addressLBL)
                    .addGroup(billingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(emailLBL, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(nameLBL)))
                .addGap(35, 35, 35)
                .addGroup(billingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerNameTF)
                    .addComponent(customerEmailTF)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(billinginfoLBL)
                .addGap(64, 64, 64))
        );
        billingPanelLayout.setVerticalGroup(
            billingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(billinginfoLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLBL)
                    .addComponent(customerNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(billingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerEmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLBL))
                .addGroup(billingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billingPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(addressLBL))
                    .addGroup(billingPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        itembg6JP.setBackground(new java.awt.Color(0, 255, 255));
        itembg6JP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        itembg6JP.setPreferredSize(new java.awt.Dimension(287, 354));

        item6LBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        item6LBL.setText("AquaGuard Plush");

        price6LBL.setText("Price: €25.99");

        image6LBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Products/plush.png"))); // NOI18N

        stock6LBL.setText("Stock : 13");

        buy6BTN.setBackground(new java.awt.Color(1, 187, 187));
        buy6BTN.setForeground(new java.awt.Color(255, 255, 255));
        buy6BTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buy6BTN.setText("Buy");
        buy6BTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        buy6BTN.setOpaque(true);
        buy6BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy6BTNMouseClicked(evt);
            }
        });

        remove6BTN.setBackground(new java.awt.Color(1, 187, 187));
        remove6BTN.setForeground(new java.awt.Color(255, 255, 255));
        remove6BTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        remove6BTN.setText("Remove");
        remove6BTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        remove6BTN.setOpaque(true);
        remove6BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remove6BTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout itembg6JPLayout = new javax.swing.GroupLayout(itembg6JP);
        itembg6JP.setLayout(itembg6JPLayout);
        itembg6JPLayout.setHorizontalGroup(
            itembg6JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itembg6JPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(itembg6JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itembg6JPLayout.createSequentialGroup()
                        .addComponent(price6LBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buy6BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remove6BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(itembg6JPLayout.createSequentialGroup()
                        .addGroup(itembg6JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stock6LBL)
                            .addComponent(item6LBL)
                            .addComponent(image6LBL, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        itembg6JPLayout.setVerticalGroup(
            itembg6JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itembg6JPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(image6LBL)
                .addGap(18, 18, 18)
                .addComponent(item6LBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(itembg6JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(itembg6JPLayout.createSequentialGroup()
                        .addComponent(stock6LBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(price6LBL))
                    .addGroup(itembg6JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buy6BTN)
                        .addComponent(remove6BTN)))
                .addContainerGap())
        );

        checkoutBTN1.setBackground(new java.awt.Color(1, 187, 187));
        checkoutBTN1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        checkoutBTN1.setForeground(new java.awt.Color(255, 255, 255));
        checkoutBTN1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        checkoutBTN1.setText("Checkout");
        checkoutBTN1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        checkoutBTN1.setOpaque(true);
        checkoutBTN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkoutBTN1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout shopLayout = new javax.swing.GroupLayout(shop);
        shop.setLayout(shopLayout);
        shopLayout.setHorizontalGroup(
            shopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shopLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(shopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itembg1JP, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addComponent(itembg4JP, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(shopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itembg2JP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itembg5JP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(shopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itembg6JP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itembg3JP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(shopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(basketJP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(billingPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(shopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(shopLayout.createSequentialGroup()
                    .addGap(1000, 1000, 1000)
                    .addComponent(checkoutBTN1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(16, 16, 16)))
        );
        shopLayout.setVerticalGroup(
            shopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shopLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(shopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(itembg3JP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(itembg2JP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(itembg1JP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(basketJP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(shopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(billingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itembg5JP, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(itembg4JP, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(itembg6JP, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addGroup(shopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(shopLayout.createSequentialGroup()
                    .addGap(714, 714, 714)
                    .addComponent(checkoutBTN1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(5, 5, 5)))
        );

        cards.add(shop, "shop");

        adoptionCard.setName("adoption"); // NOI18N
        adoptionCard.setOpaque(false);

        adopternameLBL.setText("ADOPTER NAME");

        accountnumberLBL.setText("ACCOUNT NUMBER");

        donationamountLBL.setText("DONATION AMOUNT");

        addBTN.setText("ADD");

        clearBTN.setText("CLEAR");

        exitBTN1.setText("EXIT");

        frequencyLBL.setText("FREQUENCY");

        animaladopterregistrationLBL.setText("ANIMAL ADOPTER REGISTRATION");

        adopteremailLBL.setText("ADOPTER EMAIL");

        updateBTN.setText("UPDATE");

        mainmenuBTN.setText("MAIN MENU");

        topreviousjformBTN.setText("TO ANIMAL ADOPTEE");

        nameLBL1.setText("NAME:");

        ageLBL.setText("AGE:");

        sexLBL.setText("SEX:");

        animaladopteeLBL.setText(" ANIMAL ADOPTEE ");

        addBTN1.setText("ADD");

        clearBTN1.setText("CLEAR");

        updateBTN1.setText("UPDATE");

        exitBTN2.setText("EXIT");

        mainmenuBTN1.setText("MAIN MENU");

        tonextjformBTN.setText("TO ANIMAL ADOPTER");

        javax.swing.GroupLayout adoptionCardLayout = new javax.swing.GroupLayout(adoptionCard);
        adoptionCard.setLayout(adoptionCardLayout);
        adoptionCardLayout.setHorizontalGroup(
            adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adoptionCardLayout.createSequentialGroup()
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(adoptionCardLayout.createSequentialGroup()
                        .addContainerGap(552, Short.MAX_VALUE)
                        .addComponent(updateBTN1)
                        .addGap(18, 18, 18)
                        .addComponent(mainmenuBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(adoptionCardLayout.createSequentialGroup()
                        .addGap(548, 548, 548)
                        .addComponent(addBTN1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitBTN2)
                        .addGap(21, 21, 21)))
                .addGap(27, 27, 27)
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearBTN1)
                    .addComponent(tonextjformBTN))
                .addGap(0, 563, Short.MAX_VALUE))
            .addGroup(adoptionCardLayout.createSequentialGroup()
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adoptionCardLayout.createSequentialGroup()
                        .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(adoptionCardLayout.createSequentialGroup()
                                .addGap(504, 504, 504)
                                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(adoptionCardLayout.createSequentialGroup()
                                        .addComponent(nameLBL1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nameTF1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
                                    .addGroup(adoptionCardLayout.createSequentialGroup()
                                        .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(sexLBL)
                                            .addComponent(ageLBL))
                                        .addGap(24, 24, 24)
                                        .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(sexTF, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                                            .addComponent(ageTF)))))
                            .addGroup(adoptionCardLayout.createSequentialGroup()
                                .addGap(667, 667, 667)
                                .addComponent(animaladopteeLBL)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adoptionCardLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(adoptionCardLayout.createSequentialGroup()
                                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(donationamountLBL)
                                    .addComponent(frequencyLBL))
                                .addGap(28, 28, 28)
                                .addComponent(frequencyTF, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(adoptionCardLayout.createSequentialGroup()
                                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(adopteremailLBL)
                                        .addComponent(adopternameLBL, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(accountnumberLBL))
                                .addGap(25, 25, 25)
                                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adopternameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(accountnumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adopteremailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(donationamountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(adoptionCardLayout.createSequentialGroup()
                                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addBTN)
                                    .addComponent(exitBTN1))
                                .addGap(18, 18, 18)
                                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateBTN)
                                    .addComponent(clearBTN)))
                            .addGroup(adoptionCardLayout.createSequentialGroup()
                                .addComponent(mainmenuBTN)
                                .addGap(18, 18, 18)
                                .addComponent(topreviousjformBTN)))
                        .addGap(406, 406, 406)))
                .addContainerGap())
            .addGroup(adoptionCardLayout.createSequentialGroup()
                .addGap(634, 634, 634)
                .addComponent(animaladopterregistrationLBL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adoptionCardLayout.setVerticalGroup(
            adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adoptionCardLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(animaladopteeLBL)
                .addGap(18, 18, 18)
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLBL1))
                .addGap(18, 18, 18)
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ageLBL)
                    .addComponent(ageTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexLBL)
                    .addComponent(sexTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBTN1)
                    .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exitBTN2)
                        .addComponent(clearBTN1)))
                .addGap(18, 18, 18)
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBTN1)
                    .addComponent(mainmenuBTN1)
                    .addComponent(tonextjformBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(animaladopterregistrationLBL)
                .addGap(18, 18, 18)
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adopternameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adopternameLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBTN)
                    .addComponent(clearBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adopteremailLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adopteremailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitBTN1)
                    .addComponent(updateBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountnumberLBL)
                    .addComponent(accountnumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainmenuBTN)
                    .addComponent(topreviousjformBTN))
                .addGap(15, 15, 15)
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(donationamountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(donationamountLBL))
                .addGap(18, 18, 18)
                .addGroup(adoptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(frequencyLBL)
                    .addComponent(frequencyTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        cards.add(adoptionCard, "adoption");
        adoptionCard.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void shoppingBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shoppingBTNMouseClicked
        cl.show(cards,"shop");
        nameLabel.setText("Shopping");
        bubblePop();
    }//GEN-LAST:event_shoppingBTNMouseClicked

    private void fishFallBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fishFallBTNMouseClicked
        cl.show(cards,"fishFall");
        nameLabel.setText("FishFall");
        bubblePop();
        fishFallSection1.setFocus();
        fishFallSection1.displayLeaderBoard();
    }//GEN-LAST:event_fishFallBTNMouseClicked

    private void homeBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBTNMouseClicked
        cl.show(cards,"home");
        nameLabel.setText("Home");
        bubblePop();
    }//GEN-LAST:event_homeBTNMouseClicked

    private void exitBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBTNMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitBTNMouseClicked

    private void minimiseBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimiseBTNMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimiseBTNMouseClicked

    private void loginBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBTNMouseClicked
        login();
        fishFallSection1.setPlayer();
    }//GEN-LAST:event_loginBTNMouseClicked

    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseClicked
        logout();
    }//GEN-LAST:event_logoutLabelMouseClicked

    private void SignupBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignupBTNMouseClicked
        Signup();
    }//GEN-LAST:event_SignupBTNMouseClicked

    private void createAccountBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAccountBTNMouseClicked
        cl.show(cards,"signup");
        nameLabel.setText("Signup");
    }//GEN-LAST:event_createAccountBTNMouseClicked

    private void signupLoginBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupLoginBTNMouseClicked
        cl.show(cards,"login");
        nameLabel.setText("Login");
    }//GEN-LAST:event_signupLoginBTNMouseClicked

    private void adoptionBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adoptionBTNMouseClicked
        // TODO add your handling code here:
         cl.show(cards,"adoption");
        nameLabel.setText("Adoption");
        bubblePop();
    }//GEN-LAST:event_adoptionBTNMouseClicked

    private void settingsBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBTNMouseClicked
        cl.show(cards,"settings");
        nameLabel.setText("Settings");
        bubblePop();
    }//GEN-LAST:event_settingsBTNMouseClicked
//Joy Cannon Code
    private void buy1BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy1BTNMouseClicked
        // TODO add your handling code here:
        basket.addItem(0); //Add item at index 0 Tshirt
        stock1LBL.setText("Stock: "+basket.getItemStock()[0]);//Update stock label      
    }//GEN-LAST:event_buy1BTNMouseClicked

    private void buy2BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy2BTNMouseClicked
        // TODO add your handling code here:
        basket.addItem(1);
        stock2LBL.setText("Stock: "+basket.getItemStock()[1]);
    }//GEN-LAST:event_buy2BTNMouseClicked

    private void buy3BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy3BTNMouseClicked
        // TODO add your handling code here:
        basket.addItem(2);
        stock3LBL.setText("Stock: "+basket.getItemStock()[2]);
        
    }//GEN-LAST:event_buy3BTNMouseClicked

    private void buy4BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy4BTNMouseClicked
        // TODO add your handling code here:
        basket.addItem(3);
        stock4LBL.setText("Stock: "+basket.getItemStock()[3]);
    }//GEN-LAST:event_buy4BTNMouseClicked

    private void buy5BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy5BTNMouseClicked
        // TODO add your handling code here:
        basket.addItem(4);
        stock5LBL.setText("Stock: "+basket.getItemStock()[4]);
    }//GEN-LAST:event_buy5BTNMouseClicked

    private void buy6BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy6BTNMouseClicked
        // TODO add your handling code here:
        basket.addItem(5);
        stock6LBL.setText("Stock: "+basket.getItemStock()[5]);
    }//GEN-LAST:event_buy6BTNMouseClicked

    private void remove1BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove1BTNMouseClicked
        // TODO add your handling code here:
        basket.removeItem(0);
        stock1LBL.setText("Stock: "+basket.getItemStock()[0]);
    }//GEN-LAST:event_remove1BTNMouseClicked

    private void remove2BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove2BTNMouseClicked
        // TODO add your handling code here:
        basket.removeItem(1);
        stock2LBL.setText("Stock: "+basket.getItemStock()[1]);
    }//GEN-LAST:event_remove2BTNMouseClicked

    private void remove3BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove3BTNMouseClicked
        // TODO add your handling code here:
        basket.removeItem(2);
        stock3LBL.setText("Stock: "+basket.getItemStock()[2]);
        
    }//GEN-LAST:event_remove3BTNMouseClicked

    private void remove4BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove4BTNMouseClicked
        // TODO add your handling code here:
        basket.removeItem(3);
        stock4LBL.setText("Stock: "+basket.getItemStock()[3]);
    }//GEN-LAST:event_remove4BTNMouseClicked

    private void remove5BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove5BTNMouseClicked
        // TODO add your handling code here:
        basket.removeItem(4);
        stock5LBL.setText("Stock: "+basket.getItemStock()[4]);
    }//GEN-LAST:event_remove5BTNMouseClicked

    private void remove6BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove6BTNMouseClicked
        // TODO add your handling code here:
        basket.removeItem(5);
        stock6LBL.setText("Stock: "+basket.getItemStock()[5]);
    }//GEN-LAST:event_remove6BTNMouseClicked

    private void checkoutBTN1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkoutBTN1MouseClicked
        // TODO add your handling code here:
        //Error check if basket has items in it
        if (basket.getBasketItems().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Your basket is empty. Please add items before proceeding.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;//Exit the method if the basket is empty
        }
        
        //Error check if input fields are empt
        if (customerNameTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Customer Name cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;//Exit if error check fails
        }

        if (customerEmailTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Customer Email cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;//Exit if error check fails
        }

        if (customerAddressTA.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Customer Address cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;//Exit if error check fails
        }
        
        //Declare file, filewrietr and buffedwriter
        File customerFile;
        FileWriter fw;
        BufferedWriter bw;
       
        //Set customer info from text fields
        cust.setCustomerName(customerNameTF.getText());
        cust.setCustomerEmail(customerEmailTF.getText());
        cust.setCustomerAddress(customerAddressTA.getText());
        
         //Call the method in Customer class to confirm details
        if (!cust.displayCustomerDetails()) {//If the user cancels
            JOptionPane.showMessageDialog(null, "Please correct the information and try again.");
            return;//Exit the method
        }

        try {    
            customerFile = new File("customerData.txt");//Create or open the customerData.txt file

            //make new filewriter and bufferdwriter
            fw = new FileWriter(customerFile, true);  
            bw = new BufferedWriter(fw);
            
            bw.write(cust.getCustomerName() + ", " + cust.getCustomerEmail() + ", " + cust.getCustomerAddress());//Write customer data to the file 
            bw.newLine(); //Add a new line after writing customer's data      
            bw.close();//Close the BufferedWriter
            
            JOptionPane.showMessageDialog(null, "Order successfully placed!");// Display to the user about the order       
            basket.charityCalc();// Call charity donation method      
            JOptionPane.showMessageDialog(null, "Charity Donated: €" + String.format("%.2f", basket.getCharityProfit()));//Display the charity donation amount

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }   
        basket.getBasketItems().clear();//Clear the basketItems list     
        basket.setTotalPrice(0.0);//Reset the totalPrice to 0
        basket.updateBasket();//Update the basket display and total price labels
        
        //Empty Customer Info 
        customerNameTF.setText("");
        customerEmailTF.setText("");
        customerAddressTA.setText("");
        
    }//GEN-LAST:event_checkoutBTN1MouseClicked

    private void clearBasketBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBasketBTNMouseClicked
        // TODO add your handling code here:
        basket.clearBasket();//Clear the basket and return items to stock
         
        // Update stock labels
        stock1LBL.setText("Stock: " + Stock.stock.getItemStock()[0]);
        stock2LBL.setText("Stock: " + Stock.stock.getItemStock()[1]);
        stock3LBL.setText("Stock: " + Stock.stock.getItemStock()[2]);
        stock4LBL.setText("Stock: " + Stock.stock.getItemStock()[3]);
        stock5LBL.setText("Stock: " + Stock.stock.getItemStock()[4]);
        stock6LBL.setText("Stock: " + Stock.stock.getItemStock()[5]);
        
        basket.updateBasket();//Update the basket display and total price labels
    }//GEN-LAST:event_clearBasketBTNMouseClicked
//Joy Cannon Code end
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AquaGuardApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AquaGuardApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AquaGuardApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AquaGuardApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AquaGuardApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SignupBTN;
    private javax.swing.JLabel accountnumberLBL;
    private javax.swing.JTextField accountnumberTF;
    private javax.swing.JButton addBTN;
    private javax.swing.JButton addBTN1;
    private javax.swing.JLabel addressLBL;
    private javax.swing.JLabel adopteremailLBL;
    private javax.swing.JTextField adopteremailTF;
    private javax.swing.JLabel adopternameLBL;
    private javax.swing.JTextField adopternameTF;
    private javax.swing.JLabel adoptionBTN;
    private javax.swing.JPanel adoptionCard;
    private javax.swing.JLabel ageLBL;
    private javax.swing.JTextField ageTF;
    private javax.swing.JLabel animaladopteeLBL;
    private javax.swing.JLabel animaladopterregistrationLBL;
    public static javax.swing.JTextArea basketItemsTA;
    private javax.swing.JPanel basketJP;
    private javax.swing.JLabel basketLBL;
    private javax.swing.JPanel billingPanel;
    private javax.swing.JLabel billinginfoLBL;
    private javax.swing.JLabel buy1BTN;
    private javax.swing.JLabel buy2BTN;
    private javax.swing.JLabel buy3BTN;
    private javax.swing.JLabel buy4BTN;
    private javax.swing.JLabel buy5BTN;
    private javax.swing.JLabel buy6BTN;
    private javax.swing.JPanel cards;
    private javax.swing.JLabel checkoutBTN1;
    private javax.swing.JButton clearBTN;
    private javax.swing.JButton clearBTN1;
    private javax.swing.JLabel clearBasketBTN;
    private Sections.Main.InputField confirmPasswordInputField;
    private javax.swing.JLabel createAccountBTN;
    private javax.swing.JLabel credentialsDisplay;
    public static javax.swing.JTextArea customerAddressTA;
    public static javax.swing.JTextField customerEmailTF;
    public static javax.swing.JTextField customerNameTF;
    private javax.swing.JLabel descriptionText;
    private javax.swing.JLabel donationamountLBL;
    private javax.swing.JTextField donationamountTF;
    private javax.swing.JLabel emailLBL;
    private javax.swing.JLabel exitBTN;
    private javax.swing.JButton exitBTN1;
    private javax.swing.JButton exitBTN2;
    private javax.swing.JLabel fishFallBTN;
    public Sections.Fishfall.FishFallSection fishFallSection1;
    private javax.swing.JLabel frequencyLBL;
    private javax.swing.JTextField frequencyTF;
    private javax.swing.JLabel homeBTN;
    private javax.swing.JPanel homeCard;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel image1LBL;
    private javax.swing.JLabel image2LBL;
    private javax.swing.JLabel image3LBL;
    private javax.swing.JLabel image4LBL;
    private javax.swing.JLabel image5LBL;
    private javax.swing.JLabel image6LBL;
    private javax.swing.JLabel item1LBL;
    private javax.swing.JLabel item2LBL;
    private javax.swing.JLabel item3LBL;
    private javax.swing.JLabel item4LBL;
    private javax.swing.JLabel item5LBL;
    private javax.swing.JLabel item6LBL;
    private javax.swing.JPanel itembg1JP;
    private javax.swing.JPanel itembg2JP;
    private javax.swing.JPanel itembg3JP;
    private javax.swing.JPanel itembg4JP;
    private javax.swing.JPanel itembg5JP;
    private javax.swing.JPanel itembg6JP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel loginBTN;
    private javax.swing.JPanel loginCard;
    private javax.swing.JLabel loginErrorLabel;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JButton mainmenuBTN;
    private javax.swing.JButton mainmenuBTN1;
    private javax.swing.JLabel minimiseBTN;
    private javax.swing.JLabel nameLBL;
    private javax.swing.JLabel nameLBL1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTF1;
    private javax.swing.JLabel passwordDisplay;
    private Sections.Main.InputField passwordInputField;
    private javax.swing.JLabel price1LBL;
    private javax.swing.JLabel price2LBL;
    private javax.swing.JLabel price3LBL;
    private javax.swing.JLabel price4LBL;
    private javax.swing.JLabel price5LBL;
    private javax.swing.JLabel price6LBL;
    private javax.swing.JLabel remove1BTN;
    private javax.swing.JLabel remove2BTN;
    private javax.swing.JLabel remove3BTN;
    private javax.swing.JLabel remove4BTN;
    private javax.swing.JLabel remove5BTN;
    private javax.swing.JLabel remove6BTN;
    private javax.swing.JLabel settingsBTN;
    private Sections.Main.SettingsPage settingsPage1;
    private javax.swing.JLabel sexLBL;
    private javax.swing.JTextField sexTF;
    private javax.swing.JPanel shop;
    private javax.swing.JLabel shoppingBTN;
    private javax.swing.JPanel signupCard;
    private javax.swing.JLabel signupErrorLabel;
    private javax.swing.JLabel signupLoginBTN;
    private Sections.Main.InputField signupPasswordInputField;
    private Sections.Main.InputField signupUsernameInputField;
    private javax.swing.JLabel stock1LBL;
    private javax.swing.JLabel stock2LBL;
    private javax.swing.JLabel stock3LBL;
    private javax.swing.JLabel stock4LBL;
    private javax.swing.JLabel stock5LBL;
    private javax.swing.JLabel stock6LBL;
    private javax.swing.JPanel titleBar;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton tonextjformBTN;
    private javax.swing.JPanel topBar;
    private javax.swing.JButton topreviousjformBTN;
    public static javax.swing.JLabel totalPriceLBL;
    private javax.swing.JButton updateBTN;
    private javax.swing.JButton updateBTN1;
    private javax.swing.JLabel usernameDisplay;
    private Sections.Main.InputField usernameInputField;
    // End of variables declaration//GEN-END:variables

}
