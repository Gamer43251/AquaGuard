/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aquaguard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 *
 * @author Jordan Dreelan x23150076
 */
public class AquaGuard {
    private static AquaGuardApp Display = new AquaGuardApp(); // Initialize immediately
    private static Path documentsPath = Paths.get("C:/AquaGuard");
    private static Path userFile = Paths.get(documentsPath + "/Users.txt");

    public static void main(String[] args) throws FileNotFoundException {
        setupFolder();
        loadUsers();
        Display.setVisible(true);
        Display.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }

    public static AquaGuardApp getDisplay() {
        return Display;
    }
    
    public static void setupFolder(){
        System.out.println("Huh?");
        try {
            if (!Files.exists(documentsPath)) {
                System.out.println("Directory");
                Files.createDirectories(documentsPath);
                createFiles();
            } else {
                System.out.println("Directory Failure");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void createFiles(){
        
        try{
            if(!Files.exists(userFile)){
                Files.createFile(userFile);
                saveUser(new User("Admin", "Password"));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public static void saveUser(User u){
        System.out.println("Saving?");
        try(BufferedWriter br = new BufferedWriter( new FileWriter(userFile.toString(), true))){
            br.newLine();
            br.write(u.getUsername() + "|" + u.getPassword() + "|" + u.getHighScore());
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void loadUsers() throws FileNotFoundException{
        try(BufferedReader br = new BufferedReader(new FileReader(userFile.toString()))){
           String line;
           while((line = br.readLine()) != null){
               String[] parts = line.split("\\|");
               if(parts.length == 3){
                   String username = parts[0];
                   String password = parts[1];
                   int highScore = Integer.parseInt(parts[2]);
                   AquaGuardApp.addUser(new User(username,password,highScore));
               }
               
        }
        }catch(IOException e){
            System.out.println("Not Saving");
            e.printStackTrace();
        }
        
            
    }
    
    public static void updateHighscore(User u, int newScore){
        System.out.println("Test");
        ArrayList<String> lines = new ArrayList<String>();
        try(BufferedReader br = new BufferedReader(new FileReader(userFile.toString()))){
           String line;
           while((line = br.readLine()) != null){
               if(line.equals(u.getUsername() + "|" + u.getPassword() + "|" + u.getHighScore())){
                   String[] parts = line.split("\\|");
                   if(parts.length == 3){
                       parts[2] = String.valueOf(newScore);
                       line = String.join("|", parts);
                   }
               }
               lines.add(line);
               
        }
        }catch(IOException e){
            System.out.println("Not Saving");
            e.printStackTrace();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile.toString()))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    

