/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.configs;

import static dscfgutil.DSCfgUtilConstants.COULDNT_WRITE_FILE;
import static dscfgutil.DSCfgUtilConstants.DEFAULT_DSPW_VALUES;
import static dscfgutil.DSCfgUtilConstants.DSCUTIL_FILE_NOT_FOUND;
import static dscfgutil.DSCfgUtilConstants.DSPW_ABBREV;
import static dscfgutil.DSCfgUtilConstants.DSPW_FILES;
import static dscfgutil.DSCfgUtilConstants.DSPW_FOLDER;
import static dscfgutil.DSCfgUtilConstants.DSPW_SETTINGS_APPLY_FAIL;
import static dscfgutil.DSCfgUtilConstants.DSPW_SETTINGS_LOADED;
import static dscfgutil.DSCfgUtilConstants.DSPW_SETTINGS_LOAD_FAIL;
import static dscfgutil.DSCfgUtilConstants.DSPW_SETTINGS_LOAD_PARTIAL_FAIL;
import static dscfgutil.DSCfgUtilConstants.DSPW_SETTING_NAMES;
import static dscfgutil.DSCfgUtilConstants.FILES_DIR;
import static dscfgutil.DSCfgUtilConstants.FILES_EDITED_ERR;
import static dscfgutil.DSCfgUtilConstants.IOEX_FILE_WRITER;
import static dscfgutil.DSCfgUtilConstants.LOADING_DSPW_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.NUMBER_OF_DSPW_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.TEMPLATES_DIR;
import static dscfgutil.DSCfgUtilConstants.WRITING_FILE;
import dscfgutil.FileIO.DSFixFileController;
import dscfgutil.view.DSCfgMainUI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOException;

/**
 *
 * @author Sean Pesce
 */
public class DSPWConfiguration {
    // Dark Souls PVP Watchdog settings file
    //

    // Display version banner
    // apparently it's annoying for some people, set this to false
    // to hide the version banner in the upper-left corner of the screen.
    // note that this will also hide the clock and the node count
    //
    public StringBuilder ShowVersionBanner = new StringBuilder(DEFAULT_DSPW_VALUES[0]);

    // Display in-game overlay
    // set this to false to hide the in-game overlay entirely
    //
    public StringBuilder ShowOverlay = new StringBuilder(DEFAULT_DSPW_VALUES[1]);

    // Overlay text alignment
    // choose where to draw text (left, center, right)
    //
    public StringBuilder TextAlignment = new StringBuilder(DEFAULT_DSPW_VALUES[2]);

    // Invasion sound notification
    // if you want to play the Windows Default Beep sound
    // when invading, or when someone invades you, set this to true
    //
    public StringBuilder InvasionSoundNotification = new StringBuilder(DEFAULT_DSPW_VALUES[3]);

    // Cheater sound notification
    // if you want to play the Windows Exclamation sound
    // when cheating is detected, set this to true
    //
    public StringBuilder CheaterSoundNotification = new StringBuilder(DEFAULT_DSPW_VALUES[4]);

    // Block Battle of Stoicism arena freeze effect
    // this effect can be abused to freeze people in place, 
    // although locking it will prevent it from happening
    // in arena fights also
    //
    public StringBuilder BlockArenaFreeze = new StringBuilder(DEFAULT_DSPW_VALUES[5]);

    // Show your client pool size
    // this will show you how many clients are currently connected
    // to your multiplayer session. Useful if you need to decide
    // whether to restart the game to fix the matchmaking or not.
    //
    public StringBuilder ShowNodeDbCount = new StringBuilder(DEFAULT_DSPW_VALUES[6]);

    // Increase the node db limit
    // the game defaults to 20 clients in lobby, you can set
    // this option to 'true' to increase this limit to 32.
    // some people believe this causes them issues with multiplayer,
    // should you experience said issues reset this to false.
    public StringBuilder IncreaseNodeDbLimit = new StringBuilder(DEFAULT_DSPW_VALUES[7]);

    // Font size
    // vertical size of the in-game overlay font
    // default is 15, max value is 72
    //
    public StringBuilder FontSize = new StringBuilder(DEFAULT_DSPW_VALUES[8]);

    // Show system clock and date
    // if you want to display a small clock in the upper-left corner
    // of your screen, set this to true. Same goes with date.
    //
    public StringBuilder DisplayDate = new StringBuilder(DEFAULT_DSPW_VALUES[9]);
    public StringBuilder DisplayClock = new StringBuilder(DEFAULT_DSPW_VALUES[10]);

    // Check for updates
    // will check the remote version on https://bitbucket.org/infausto/dark-souls-pvp-watchdog/
    // and notify you if there's something new
    //
    public StringBuilder CheckForUpdates = new StringBuilder(DEFAULT_DSPW_VALUES[11]);

    // DLL chaining
    // if you want to load another dll after DSPW, put its name here
    // NOTE: if the dll you're trying to chain doesn't export D3DCreate9
    // this won't work, dark souls won't load and you'll blame me :p
    // so, if things stop working set this back to 'none' and forget
    // about it
    //
    public StringBuilder d3d9dllWrapper = new StringBuilder(DEFAULT_DSPW_VALUES[12]);

    // Keybindings
    // reference: https://msdn.microsoft.com/en-us/library/windows/desktop/dd375731%28v=vs.85%29.aspx
    // defaults are 0x70, 0x74, 0x78, 0x79 (F1, F5, F9 and F10)
    //
    public StringBuilder key_BanPhantom = new StringBuilder(DEFAULT_DSPW_VALUES[13]);
    public StringBuilder key_IgnorePhantom = new StringBuilder(DEFAULT_DSPW_VALUES[14]);
    public StringBuilder key_HideOverlay = new StringBuilder(DEFAULT_DSPW_VALUES[15]);
    public StringBuilder key_AboutDSPW = new StringBuilder(DEFAULT_DSPW_VALUES[16]);
    
    ////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////
    
    DSCfgMainUI ui;
    public ArrayList<StringBuilder> settings;
    Scanner fileInput;
    BufferedWriter fileWriter;
    
    public DSPWConfiguration(DSCfgMainUI initUI, boolean loadSettings){
        ui = initUI;
        
        initSettingsList();
        
        if(ui.getDataFolder() != null && ui.getDSPWStatus() == 0
                && loadSettings){
            ui.printConsole(LOADING_DSPW_SETTINGS);
            loadSettings(ui.getDataFolder().getPath() + "\\" +
                                    DSPW_FILES[3]);
        }
    }
    
    public void loadSettings(String filePath){
        
        try {
            String fullINI = DSFixFileController.readTextFile(filePath);
            
            Scanner iniReader = new Scanner(fullINI);
            int settingsLoaded = 0;
            
            while(iniReader.hasNextLine()){
                String line = iniReader.nextLine();
                if(!line.startsWith("#") && line.length() > 2){
                    settings.get(settingsLoaded).replace(
                            0, settings.get(settingsLoaded).length(),
                            ("" + line.substring(line.indexOf(' ') + 1)));
                    
                    settingsLoaded++;
                }
            }
            
            if(settingsLoaded < NUMBER_OF_DSPW_SETTINGS){
                ui.printConsole((settingsLoaded) + " out of " + NUMBER_OF_DSPW_SETTINGS + " " + DSPW_ABBREV + " settings loaded.");
                ui.printConsole(DSPW_SETTINGS_LOAD_PARTIAL_FAIL);
            }else if(settingsLoaded == NUMBER_OF_DSPW_SETTINGS){
                ui.printConsole(DSPW_SETTINGS_LOADED);
            }
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(DSPWConfiguration.class.getName()).log(Level.SEVERE, null, ex);
            ui.printConsole(new File(filePath).getName() + DSCUTIL_FILE_NOT_FOUND);
            ui.printConsole(DSPW_SETTINGS_LOAD_FAIL);
        }
        
    }
    
    public void applySettings(String filePath){
        try{
            ui.printConsole(WRITING_FILE[0] + DSPW_FILES[3] + "...");
            
            String template = DSFixFileController.readTextFile(TEMPLATES_DIR + "\\" + DSPW_FILES[3]);
            
            Scanner templateReader = new Scanner(template);
            
            String output = "";
            int settingsApplied = 0;
            
            while(templateReader.hasNextLine()){
                String line = templateReader.nextLine();
                if(line.startsWith("#") || line.length() < 2){
                    output += line.trim() + String.format("%n");
                }else{
                    output += DSPW_SETTING_NAMES[settingsApplied] + " "
                                + settings.get(settingsApplied).toString()
                                + String.format("%n");
                    settingsApplied++;
                }
            }
            
            templateReader.close();
            
            if(settingsApplied != NUMBER_OF_DSPW_SETTINGS){
                ui.printConsole((NUMBER_OF_DSPW_SETTINGS - settingsApplied)
                        + DSPW_SETTINGS_APPLY_FAIL);
            }else{
                try{
                    DSFixFileController.writeTextFile(ui.getDataFolder().getPath() + "\\" + DSPW_FILES[3],
                        output, true);
                    
                    ui.printConsole(WRITING_FILE[1]);
                }catch(IIOException iioe){
                    ui.printConsole(COULDNT_WRITE_FILE);
                }catch(IOException ioe){
                    ui.printConsole(IOEX_FILE_WRITER);
                }
            }
            
        }catch(FileNotFoundException ex){
            ui.printConsole(FILES_EDITED_ERR[0]
                    + new File(DSPW_FOLDER + "\\" + DSPW_FILES[3]).getName()
                    + FILES_EDITED_ERR[1]);
        }
        
    }
    
    public void restoreDefaults(){
        ShowVersionBanner.replace(0, ShowVersionBanner.length(), DEFAULT_DSPW_VALUES[0]);
        ShowOverlay.replace(0, ShowOverlay.length(), DEFAULT_DSPW_VALUES[1]);
        TextAlignment.replace(0, TextAlignment.length(), DEFAULT_DSPW_VALUES[2]);
        InvasionSoundNotification.replace(0, InvasionSoundNotification.length(), DEFAULT_DSPW_VALUES[3]);
        CheaterSoundNotification.replace(0, CheaterSoundNotification.length(), DEFAULT_DSPW_VALUES[4]);
        BlockArenaFreeze.replace(0, BlockArenaFreeze.length(), DEFAULT_DSPW_VALUES[5]);
        ShowNodeDbCount.replace(0, ShowNodeDbCount.length(), DEFAULT_DSPW_VALUES[6]);
        IncreaseNodeDbLimit.replace(0, IncreaseNodeDbLimit.length(), DEFAULT_DSPW_VALUES[7]);
        FontSize.replace(0, FontSize.length(), DEFAULT_DSPW_VALUES[8]);
        DisplayDate.replace(0, DisplayDate.length(), DEFAULT_DSPW_VALUES[9]);
        DisplayClock.replace(0, DisplayClock.length(), DEFAULT_DSPW_VALUES[10]);
        CheckForUpdates.replace(0, CheckForUpdates.length(), DEFAULT_DSPW_VALUES[11]);
        d3d9dllWrapper.replace(0, d3d9dllWrapper.length(), DEFAULT_DSPW_VALUES[12]);
        key_BanPhantom.replace(0, key_BanPhantom.length(), DEFAULT_DSPW_VALUES[13]);
        key_IgnorePhantom.replace(0, key_IgnorePhantom.length(), DEFAULT_DSPW_VALUES[14]);
        key_HideOverlay.replace(0, key_HideOverlay.length(), DEFAULT_DSPW_VALUES[15]);
        key_AboutDSPW.replace(0, key_AboutDSPW.length(), DEFAULT_DSPW_VALUES[16]);
    }
    
    public void initSettingsList(){
        
        settings = new ArrayList<>();
        
        settings.add(ShowVersionBanner);
        settings.add(ShowOverlay);
        settings.add(TextAlignment);
        settings.add(InvasionSoundNotification);
        settings.add(CheaterSoundNotification);
        settings.add(BlockArenaFreeze);
        settings.add(ShowNodeDbCount);
        settings.add(IncreaseNodeDbLimit);
        settings.add(FontSize);
        settings.add(DisplayDate);
        settings.add(DisplayClock);
        settings.add(CheckForUpdates);
        settings.add(d3d9dllWrapper);
        settings.add(key_BanPhantom);
        settings.add(key_IgnorePhantom);
        settings.add(key_HideOverlay);
        settings.add(key_AboutDSPW);
    }
}
