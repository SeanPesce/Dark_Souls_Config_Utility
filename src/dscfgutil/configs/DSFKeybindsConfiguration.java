/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.configs;

import static dscfgutil.DSCfgUtilConstants.DISABLED;
import static dscfgutil.DSCfgUtilConstants.DSCUTIL_FILE_NOT_FOUND;
import static dscfgutil.DSCfgUtilConstants.DSF_DEFAULT_KEY_VALUES;
import static dscfgutil.DSCfgUtilConstants.DSF_FILES;
import static dscfgutil.DSCfgUtilConstants.DSF_KEYBINDS_VERIFICATION;
import static dscfgutil.DSCfgUtilConstants.DSF_KEY_ACTIONS;
import static dscfgutil.DSCfgUtilConstants.FILES_EDITED_ERR;
import static dscfgutil.DSCfgUtilConstants.FILE_WRITE_FAILED;
import static dscfgutil.DSCfgUtilConstants.INVALID_DSF_KEYBINDS_INI;
import static dscfgutil.DSCfgUtilConstants.IOEX_FILE_WRITER;
import static dscfgutil.DSCfgUtilConstants.KEYBINDS_LOADED;
import static dscfgutil.DSCfgUtilConstants.KEYBINDS_NOT_LOADED;
import static dscfgutil.DSCfgUtilConstants.LOADING_USER_KEYBINDS;
import static dscfgutil.DSCfgUtilConstants.SEE_CONSOLE;
import static dscfgutil.DSCfgUtilConstants.TEMPLATES_DIR;
import static dscfgutil.DSCfgUtilConstants.UNABLE_TO_OVERWRITE_DSF_KB;
import static dscfgutil.DSCfgUtilConstants.UNABLE_TO_READ_FILE;
import static dscfgutil.DSCfgUtilConstants.WRITING_FILE;
import dscfgutil.view.DSCfgMainUI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sean Pesce
 */
public class DSFKeybindsConfiguration {
    
    
    //Possible Keybinds
    StringBuilder toggleCursorVisibility  = new StringBuilder(DSF_DEFAULT_KEY_VALUES[1]);
    
    StringBuilder toggleCursorCapture = new StringBuilder(DSF_DEFAULT_KEY_VALUES[0]);
            
    StringBuilder toggleBorderlessFullscreen = new StringBuilder(DSF_DEFAULT_KEY_VALUES[2]);
            
    StringBuilder singleFrameFullCapture = new StringBuilder(DISABLED);
            
    StringBuilder takeHudlessScreenshot = new StringBuilder(DISABLED);
                    
    StringBuilder toggleHUD = new StringBuilder(DSF_DEFAULT_KEY_VALUES[3]);
                    
    StringBuilder toggleHUDChanges = new StringBuilder(DSF_DEFAULT_KEY_VALUES[4]);
            
    StringBuilder toggleAA = new StringBuilder(DISABLED);
    
    StringBuilder toggleSMAA = new StringBuilder(DISABLED);
            
    StringBuilder toggleVSSAO = new StringBuilder(DISABLED);
            
    StringBuilder toggleDofGauss = new StringBuilder(DISABLED);
            
    StringBuilder reloadAAEffect = new StringBuilder(DISABLED);
            
    StringBuilder reloadSSAOEffect = new StringBuilder(DISABLED);
                    
    StringBuilder reloadGAUSSEffect = new StringBuilder(DISABLED);
                    
    StringBuilder reloadHUDVertices = new StringBuilder(DISABLED);
                            
    StringBuilder toggle30FPSLimit = new StringBuilder(DSF_DEFAULT_KEY_VALUES[5]);
                            
    StringBuilder togglePaused = new StringBuilder(DISABLED);
                                    
    StringBuilder userTrigger = new StringBuilder(DISABLED);
    
    
    //Non-keybind Instance variables
    DSCfgMainUI ui;
    public ArrayList<StringBuilder> binds;
    Scanner fileInput;
    BufferedWriter fileWriter;
    
    //Default constructor
    public DSFKeybindsConfiguration(DSCfgMainUI initUI, boolean loadSettings){
        ui = initUI;
        
        initKeybindsList();
        //If DATA folder is available, DSFix is installed, and "loadSettings" is true, load their keybinds
        if(ui.getDataFolder() != null && ui.getDSFStatus() == 0
                && loadSettings){
            ui.printConsole(LOADING_USER_KEYBINDS);
            loadSettingsFromIniFile(ui.getDataFolder().getPath() + "\\" +
                                    DSF_FILES[2]);
        }
        
    }
    
    //Loads binds from an existing DSFix keybinds configuration
    public void loadSettingsFromIniFile(String filePath){
        File in = new File(filePath);
        
        //Check if file is readable
        if(in.canRead()){
            try {
                fileInput = new Scanner(in);
                disableAllBinds();
                String line = " ";
                boolean verifiedIniFile = false;
                while(fileInput.hasNextLine()){
                    line = fileInput.nextLine();
                    
                    //Make sure it's a DSfix Keybinds ini file and not just some random .ini
                    if(!verifiedIniFile && !line.equals(DSF_KEYBINDS_VERIFICATION)){
                        ui.printConsole(in.getName() + INVALID_DSF_KEYBINDS_INI);
                        ui.printConsole(KEYBINDS_NOT_LOADED);
                        return;
                    }else if(!verifiedIniFile && line.equals(DSF_KEYBINDS_VERIFICATION)){
                        verifiedIniFile = true;
                    }
                    
                    if(line.length() > 1 && line.charAt(0) != '\n' && line.charAt(0) != '#' && line.indexOf(' ') > 0){
                        //Change StringBuilder value
                        String action = line.substring(0, line.indexOf(' '));
                        String key = line.substring(line.indexOf(' ') + 1);
                        //Get index of action in binds array
                        int actionIndex = 0;
                        for(actionIndex = 0; actionIndex < DSF_KEY_ACTIONS.length; actionIndex++){
                            if(action.toLowerCase().equals(DSF_KEY_ACTIONS[actionIndex].toLowerCase())){
                                break;
                            }
                        }
                        
                        if(actionIndex < DSF_KEY_ACTIONS.length && actionIndex >= 0){
                        	StringBuilder stringVal = (StringBuilder)binds.get(actionIndex);
                            stringVal.replace(0, stringVal.length(), key);
                        }
                        
                    }
                }
                ui.printConsole(KEYBINDS_LOADED);
            } catch (FileNotFoundException ex) {
                //FileNotFoundException thrown by Scanner constructor
                ui.printConsole(in.getName() + DSCUTIL_FILE_NOT_FOUND);
                restoreDefaultKeybinds();
            }
        }else{
            ui.printConsole(UNABLE_TO_READ_FILE + in.getName());
            ui.printConsole(KEYBINDS_NOT_LOADED);
        }
        
        if(fileInput != null){
            fileInput.close();
        }
    }
    
    public void writeSettingsToIniFile(String writePath){
        File template = new File(TEMPLATES_DIR + "\\" + DSF_FILES[2]);
        
        File writeFile = new File(writePath);
        if(writeFile.exists()){
            writeFile.delete();
            if(writeFile.exists()){
                //.ini file was not deleted, so we won't be able to write over it
                ui.printConsole(UNABLE_TO_OVERWRITE_DSF_KB);
                ui.printConsole(FILE_WRITE_FAILED + " " + SEE_CONSOLE);
                return;
            }
        }
        ui.printConsole(WRITING_FILE[0] + writeFile.getName());
        
        try {
            fileInput = new Scanner(template);
        } catch (FileNotFoundException ex) {
            ui.printConsole(FILES_EDITED_ERR[0] + template.getName() + FILES_EDITED_ERR[1]);
            ui.printConsole(FILE_WRITE_FAILED + " " + SEE_CONSOLE);
            return;
        }
        
        String writeBuffer = ""; //Will store the text of the output file
        while(fileInput.hasNext()){
            String line = fileInput.nextLine();
            if(line.length() >= 1 && line.charAt(0) == '$'){
                //Write all keybinds here
                for(int i = 0; i < 18; i++){
                    if(!binds.get(i).toString().equals(DISABLED)){
                        writeBuffer += DSF_KEY_ACTIONS[i] + " " + binds.get(i).toString() + String.format("%n");
                    }
                }
            }else{
                //This is a line to copy
                writeBuffer += line + String.format("%n");
            }
        }
        
        try {
            //Read was successful
            fileWriter = new BufferedWriter(new FileWriter(writeFile));
            fileWriter.write(writeBuffer);
            fileWriter.close();
            //Write was successful
            ui.printConsole(WRITING_FILE[1]);
        } catch (IOException ex) {
            ui.printConsole(IOEX_FILE_WRITER);
            ui.printConsole(FILE_WRITE_FAILED + " " + SEE_CONSOLE);
        }
        
    }
    
    public void restoreDefaultKeybinds(){
        toggleCursorVisibility  = new StringBuilder(DSF_DEFAULT_KEY_VALUES[1]);
        toggleCursorCapture = new StringBuilder(DSF_DEFAULT_KEY_VALUES[0]);
        toggleBorderlessFullscreen = new StringBuilder(DSF_DEFAULT_KEY_VALUES[2]);
        singleFrameFullCapture = new StringBuilder(DISABLED);
        takeHudlessScreenshot = new StringBuilder(DISABLED);
        toggleHUD = new StringBuilder(DSF_DEFAULT_KEY_VALUES[3]);
        toggleHUDChanges = new StringBuilder(DSF_DEFAULT_KEY_VALUES[4]);
        toggleAA = new StringBuilder(DISABLED);
        toggleSMAA = new StringBuilder(DISABLED);
        toggleVSSAO = new StringBuilder(DISABLED);
        toggleDofGauss = new StringBuilder(DISABLED);
        reloadAAEffect = new StringBuilder(DISABLED);
        reloadSSAOEffect = new StringBuilder(DISABLED);
        reloadGAUSSEffect = new StringBuilder(DISABLED);
        reloadHUDVertices = new StringBuilder(DISABLED);
        toggle30FPSLimit = new StringBuilder(DSF_DEFAULT_KEY_VALUES[5]);
        togglePaused = new StringBuilder(DISABLED);
        userTrigger = new StringBuilder(DISABLED);
        
        initKeybindsList();
    }
    
    private void disableAllBinds(){
        toggleCursorVisibility  = new StringBuilder(DISABLED);
        toggleCursorCapture = new StringBuilder(DISABLED);
        toggleBorderlessFullscreen = new StringBuilder(DISABLED);
        singleFrameFullCapture = new StringBuilder(DISABLED);
        takeHudlessScreenshot = new StringBuilder(DISABLED);
        toggleHUD = new StringBuilder(DISABLED);
        toggleHUDChanges = new StringBuilder(DISABLED);
        toggleAA = new StringBuilder(DISABLED);
        toggleSMAA = new StringBuilder(DISABLED);
        toggleVSSAO = new StringBuilder(DISABLED);
        toggleDofGauss = new StringBuilder(DISABLED);
        reloadAAEffect = new StringBuilder(DISABLED);
        reloadSSAOEffect = new StringBuilder(DISABLED);
        reloadGAUSSEffect = new StringBuilder(DISABLED);
        reloadHUDVertices = new StringBuilder(DISABLED);
        toggle30FPSLimit = new StringBuilder(DISABLED);
        togglePaused = new StringBuilder(DISABLED);
        userTrigger = new StringBuilder(DISABLED);
        initKeybindsList();
    }
    
    private void initKeybindsList(){
        binds = new ArrayList<>();
        
        binds.add(toggleCursorVisibility);
        binds.add(toggleCursorCapture);
        binds.add(toggleBorderlessFullscreen);
        binds.add(singleFrameFullCapture);
        binds.add(takeHudlessScreenshot);
        binds.add(toggleHUD);
        binds.add(toggleHUDChanges);
        binds.add(toggleAA);
        binds.add(toggleSMAA);
        binds.add(toggleVSSAO);
        binds.add(toggleDofGauss);
        binds.add(reloadAAEffect);
        binds.add(reloadSSAOEffect);
        binds.add(reloadGAUSSEffect);
        binds.add(reloadHUDVertices);
        binds.add(toggle30FPSLimit);
        binds.add(togglePaused);
        binds.add(userTrigger);
        
    }
    
    //Getter/Accessor Methods
    public ArrayList<StringBuilder> getBinds(){
        return this.binds;
    }
}
