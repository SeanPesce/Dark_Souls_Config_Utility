/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.configs;

import static dscfgutil.DSCfgUtilConstants.CANT_WRITE_DIR;
import static dscfgutil.DSCfgUtilConstants.CONFIG_NOT_LOADED;
import static dscfgutil.DSCfgUtilConstants.CONFIG_PARTIALLY_LOADED;
import static dscfgutil.DSCfgUtilConstants.CONFIG_SETTING_NOT_LOADED;
import static dscfgutil.DSCfgUtilConstants.CONFIG_TOO_MANY_LOADED;
import static dscfgutil.DSCfgUtilConstants.DEFAULT_INT_VALUES;
import static dscfgutil.DSCfgUtilConstants.DEFAULT_STRING_VALUES;
import static dscfgutil.DSCfgUtilConstants.DSCUTIL_FILE_NOT_FOUND;
import static dscfgutil.DSCfgUtilConstants.DSF_FILES;
import static dscfgutil.DSCfgUtilConstants.DSF_FILES_COPIED;
import static dscfgutil.DSCfgUtilConstants.DSF_FOLDER;
import static dscfgutil.DSCfgUtilConstants.DSF_VERIFICATION;
import static dscfgutil.DSCfgUtilConstants.EXPORT_FAILED;
import static dscfgutil.DSCfgUtilConstants.FILES_DIR;
import static dscfgutil.DSCfgUtilConstants.FILES_EDITED_ERR;
import static dscfgutil.DSCfgUtilConstants.FILE_WRITE_FAILED;
import static dscfgutil.DSCfgUtilConstants.INT_VALUE_NAMES;
import static dscfgutil.DSCfgUtilConstants.INVALID_DSF_INI;
import static dscfgutil.DSCfgUtilConstants.INVALID_FILETYPE_ERR;
import static dscfgutil.DSCfgUtilConstants.IOEX_FILE_WRITER;
import static dscfgutil.DSCfgUtilConstants.LOADING_USER_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.NOT_ALL_SETTINGS_APPLIED;
import static dscfgutil.DSCfgUtilConstants.SEE_CONSOLE;
import static dscfgutil.DSCfgUtilConstants.SETTINGS_LOADED;
import static dscfgutil.DSCfgUtilConstants.STRING_VALUE_NAMES;
import static dscfgutil.DSCfgUtilConstants.TEMPLATES_DIR;
import static dscfgutil.DSCfgUtilConstants.TOTAL_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.UNABLE_TO_OVERWRITE;
import static dscfgutil.DSCfgUtilConstants.WRITING_FILE;
import dscfgutil.view.DSCfgMainUI;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * DSFix configuration object. Will be used to store default and custom config
 * settings for DSFix.
 * @author Sean Pesce
 */
public class DSFConfiguration {
    
    ////////////////////////////////////////////////////////////////////
    //////////////////////////CHANGABLE VALUES//////////////////////////
    ////////////////////////////////////////////////////////////////////
    
    //////////////////////////GRAPHICS//////////////////////////
    //
    //Internal rendering resolution of the game. Higher values will decrease
    //  performance
    private AtomicInteger renderWidth = new AtomicInteger(DEFAULT_INT_VALUES[0]);
    private AtomicInteger renderHeight = new AtomicInteger(DEFAULT_INT_VALUES[1]);
    //
    //The display width/height
    // 0 means use the same resolution as renderWidth/Height
    // (use for downscaling - if in doubt, leave at 0)
    private AtomicInteger presentWidth = new AtomicInteger(DEFAULT_INT_VALUES[2]);
    private AtomicInteger presentHeight = new AtomicInteger(DEFAULT_INT_VALUES[3]);
    
    //////////////////////////ANTIALIASING
    //
    // AA toggle and quality setting
    // 0 = off (best performance, worst IQ)
    // 1 = low 
    // 2 = medium
    // 3 = high
    // 4 = ultra (worst performance, best IQ)
    public AtomicInteger aaQuality = new AtomicInteger(DEFAULT_INT_VALUES[4]);
    //
    //AA type
    // either "SMAA" or "FXAA"
    public StringBuilder aaType  = new StringBuilder(DEFAULT_STRING_VALUES[5]);
    
    //////////////////////////AMBIENT OCCLUSION
    //
    //Enable and set the strength of the SSAO effect (all 3 settings have the same performance impact!)
    // 0 = off
    // 1 = low
    // 2 = medium
    // 3 = high
    public AtomicInteger ssaoStrength = new AtomicInteger(DEFAULT_INT_VALUES[6]);
    //
    //Set SSAO scale
    // 1 = high quality (default)
    // 2 = lower quality, lower impact on performance
    // 3 = lowest quality, lowest impact on performance
    public AtomicInteger ssaoScale  = new AtomicInteger(DEFAULT_INT_VALUES[7]);
    //
    //Determine the type of AO used
    // "VSSAO" = Volumetric SSAO (default, only option pre-1.9)
    // "HBAO" = Horizon-Based Ambient Occlusion
    // "SCAO" = VSSAO + HBAO
    // "VSSAO2" = Volumetric SSAO with more samples (tweaked by Asmodean)
    // VSSAO and  HBAO types have a slightly different effect. and similar performance
    // SCAO combines both, with a higher performance impact
    // VSSAO2 is generally more accurate, but also requires more performance
    public StringBuilder ssaoType = new StringBuilder(DEFAULT_STRING_VALUES[8]);
    
    //////////////////////////DEPTH OF FIELD
    //
    //Depth of Field resolution override, possible values:
    // 0 = no change from default (DoF pyramid starts at 512x360)
    // 540 = DoF pyramid starts at 960x540
    // 810 = DoF pyramid starts at 1440x810
    // 1080 = DoF pyramid starts at 1920x1080
    // 2160 = DoF pyramid starts at 3840x2160
    // higher values will decrease performance
    // do NOT set this to the same value as your vertical rendering resolution!
    private AtomicInteger dofOverrideResolution = new AtomicInteger(DEFAULT_INT_VALUES[9]);
    //
    // Depth of Field scaling override (NOT RECOMMENDED)
    // 0 = DoF scaling enabled (default, recommended)
    // 1 = DoF scaling disabled (sharper, worse performance, not as originally intended)
    public AtomicInteger disableDofScaling = new AtomicInteger(DEFAULT_INT_VALUES[10]);
    //
    // Depth of field additional blur
    // allows you to use high DoF resolutions and still get the originally intended effect
    // suggested values:
    // o (off) at default DoF resolution
    // 0 or 1 at 540 DoF resolution
    // 1 or 2 above that
    // 3 or 4 at 2160 DoF resolution (if you're running a 680+)
    public StringBuilder dofBlurAmount = new StringBuilder(DEFAULT_STRING_VALUES[11]);
    
    //////////////////////////FRAMERATE
    //
    // Enable variable framerate (up to 60)
    // NOTE:
    // - this requires in-memory modification of game code, and may get you banned from GFWL
    // - there may be unintended side-effects in terms of gameplay
    // - you need a very powerful system (especially CPU) in order to maintain 60 FPS
    // - in some  instances, collision detection may fail. Avoid sliding down ladders
    // Use this at your own risk!
    // 0 = no changes to game code
    // 1 = unlock the frame rate
    public AtomicInteger unlockFPS = new AtomicInteger(DEFAULT_INT_VALUES[12]);
    //
    // FPS limit, only used with unlocked framerate
    // do not set this much higher than 60, this will lead to various issues with the engine
    public AtomicInteger FPSlimit = new AtomicInteger(DEFAULT_INT_VALUES[13]);
    //
    // FPS threshold
    // DSfix will dynamically disable AA if your framerate drops below this value 
    //  and re-enable it once it has normalized (with a bit of hysteresis thresholding)
    public AtomicInteger FPSthreshold = new AtomicInteger(DEFAULT_INT_VALUES[14]);
    
    //////////////////////////FILTERING
    //
    // texture filtering override
    // 0 = no change 
    // 1 = enable some bilinear filtering (use only if you need it!)
    // 2 = full AF override (may degrade performance)
    // if in doubt, leave this at 0
    public AtomicInteger filteringOverride = new AtomicInteger(DEFAULT_INT_VALUES[15]);
    
    
    //////////////////////////HUD//////////////////////////
    //
    //Enable HUD modifications
    // 0 = off (default) - none of the options below will do anything!
    // 1 = on
    public AtomicInteger enableHudMod = new AtomicInteger(DEFAULT_INT_VALUES[16]);
    //
    // Remove the weapon icons from the HUD 
    // (you can see which weapons you have equipped from your character model)
    public AtomicInteger enableMinimalHud = new AtomicInteger(DEFAULT_INT_VALUES[17]);
    //
    // Scale down HuD, examples:
    // 1.0 = original scale
    // 0.75 = 75% of the original size
    public StringBuilder hudScaleFactor = new StringBuilder(DEFAULT_STRING_VALUES[18]);
    //
    // Set opacity for different elements of the HUD
    // 1.0 = fully opaque
    // 0.0 = fully transparent
    // Top left: health bars, stamina bar, humanity counter, status indicators
    public StringBuilder hudTopLeftOpacity = new StringBuilder(DEFAULT_STRING_VALUES[19]);
    // Bottom left: item indicators & counts
    public StringBuilder hudBottomLeftOpacity = new StringBuilder(DEFAULT_STRING_VALUES[20]);
    // Bottom right: soul count 
    public StringBuilder hudBottomRightOpacity = new StringBuilder(DEFAULT_STRING_VALUES[21]);
    
    //////////////////////////WINDOW & MOUSE CURSOR//////////////////////////
    //
    //borderless fullscreen mode 
    // make sure to select windowed mode in the game settings for this to work!
    // 0 = disable
    // 1 = enable
    public AtomicInteger borderlessFullscreen = new AtomicInteger(DEFAULT_INT_VALUES[22]);
    //
    // disable cursor at startup
    // 0 = no change
    // 1 = off at start
    public AtomicInteger disableCursor = new AtomicInteger(DEFAULT_INT_VALUES[23]);
    //
    // capture cursor (do not allow it to leave the window)
    // 0 = don't capture
    // 1 = capture
    // (this also works if the cursor is not visible)
    public AtomicInteger captureCursor = new AtomicInteger(DEFAULT_INT_VALUES[24]);
    
    
    //////////////////////////SAVE GAME BACKUP OPTIONS//////////////////////////
    //
    //enables save game backups
    // 0 = no backups
    // 1 = backups enabled
    // backups are stored in the save folder, as "[timestamp]_[original name].bak"
    public AtomicInteger enableBackups = new AtomicInteger(DEFAULT_INT_VALUES[25]);
    //
    // backup interval in seconds (1500 = 25 minutes)
    // (minimum setting 600)
    public AtomicInteger backupInterval = new AtomicInteger(DEFAULT_INT_VALUES[26]);
    //
    // maximum amount of backups, older ones will be deleted
    public AtomicInteger maxBackups = new AtomicInteger(DEFAULT_INT_VALUES[27]);
    
    
    //////////////////////////TEXTURE OVERRIDE OPTIONS//////////////////////////
    //
    //enables texture dumping
    // you *only* need this if you want to create your own override textures
    // textures will be dumped to "dsfix\tex_override\[hash].tga"
    public AtomicInteger enableTextureDumping = new AtomicInteger(DEFAULT_INT_VALUES[28]);
    //
    // enables texture override
    // textures in "dsfix\tex_override\[hash].png" will replace the corresponding originals
    // will cause a small slowdown during texture loading!
    public AtomicInteger enableTextureOverride = new AtomicInteger(DEFAULT_INT_VALUES[29]);
    
    
    //////////////////////////OTHER//////////////////////////
    //
    //skip the intro logos
    // this should now be slightly more stable, but should still be
    // the first thing to disable in case you experience any problems
    public AtomicInteger skipIntro = new AtomicInteger(DEFAULT_INT_VALUES[30]);
    //
    // change the screenshot directory
    // default: . (current directory)
    // example: C:\Users\Peter\Pictures
    // directory must exist!
    public StringBuilder screenshotDir = new StringBuilder(DEFAULT_STRING_VALUES[31]);
    //
    // override the in-game language
    // none = no override
    // en-GB = English, fr = French, it = Italian, de = German, es = Spanish
    // ko = Korean, zh-tw = Chinese, pl = Polish, ru = Russian
    // this does not work in Windows XP!
    public StringBuilder overrideLanguage = new StringBuilder(DEFAULT_STRING_VALUES[32]);
    //
    // Dinput dll chaining
    // if you want to use another dinput8.dll wrapper together
    // with DSfix, rename it (e.g. "dinputwrapper.dll") and put the new name here
    public StringBuilder dinput8dllWrapper = new StringBuilder(DEFAULT_STRING_VALUES[33]);
    // For instance, dsmfix.dll
    //
    // D3D adapter override
    // -1 = no override
    // N = use adapter N
    // this setting is for multiple (non-SLI/crossfire) GPUs
    // everyone else should leave it at -1
    public StringBuilder d3dAdapterOverride = new StringBuilder(DEFAULT_STRING_VALUES[34]);
    //
    // Log level - 0 to 11, higher numbers mean more logging
    // only enable for debugging
    public AtomicInteger logLevel = new AtomicInteger(DEFAULT_INT_VALUES[35]);
    
    
    //////////////////////////UNSAFE//////////////////////////
    //
    //You can only set either forceFullscreen or forceWindowed (or neither)
    // 0 = off, 1 = on
    public AtomicInteger forceWindowed = new AtomicInteger(DEFAULT_INT_VALUES[36]);
    public AtomicInteger forceFullscreen = new AtomicInteger(DEFAULT_INT_VALUES[37]);
    //
    // Turn Vsync on/off
    public AtomicInteger enableVsync = new AtomicInteger(DEFAULT_INT_VALUES[38]);
    // Adjust display refresh rate in fullscreen mode - this is NOT linked to FPS!
    public AtomicInteger fullscreenHz = new AtomicInteger(DEFAULT_INT_VALUES[39]);
    
    ////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////
    
    DSCfgMainUI ui;
    public ArrayList settings;
    Scanner fileInput;
    BufferedWriter fileWriter;
    
    //Instance variables
    public boolean disableDOF = false;
    
    //Default constructor
    public DSFConfiguration(DSCfgMainUI initUI, boolean loadSettings){
        ui = initUI;
        
        initSettingsList();
        //If DATA folder is available, DSFix is installed, and "loadSettings" is true, load their settings
        if(ui.getDataFolder() != null && ui.getDSFStatus() == 0
                && loadSettings){
            ui.printConsole(LOADING_USER_SETTINGS);
            loadSettingsFromIniFile(ui.getDataFolder().getPath() + "\\" +
                                    DSF_FILES[1]);
        }else{
            setWindowsResolution();
        }
        
        //Check for disabled DOF
        if(dofOverrideResolution.equals(renderHeight) &&
            presentWidth.get() == renderWidth.get() &&
            presentHeight.get() == renderHeight.get() &&
            disableDofScaling.get() == 1 &&
            dofBlurAmount.toString().equals("o")){
            disableDOF = true;
        }
    }
    
    public void loadSettingsFromIniFile(String filePath){
        
        File in = new File(filePath);
        String iniExt = DSF_FILES[1].substring(DSF_FILES[1].lastIndexOf('.'));
        int settingsChanged = 0;
        
        boolean[] changed = new boolean[TOTAL_SETTINGS];
        Arrays.fill(changed, false);
        
        //Check for .ini file type
        if(iniExt.equals(filePath.substring(filePath.lastIndexOf('.')))){
            try {
                fileInput = new Scanner(in);
                String line = " ";
                
                while(settingsChanged < TOTAL_SETTINGS && fileInput.hasNextLine()){
                    line = fileInput.nextLine();
                    
                    line = line.replace('\t', ' ');
                    while(line.length() >= 2 && line.indexOf("  ") > -1){
                    	line = line.replace("  ", " ");
                    }
                    
                    String int_str = "";
                    int first_space = line.indexOf(' ');
                    
                    if(line.length() > 7 && line.charAt(0) != '\n' && line.charAt(0) != '#' && first_space >= 6 && first_space != (line.length() - 1)){
                    	
                    	int current_setting = -1;
                    	for(int i = 0; i < TOTAL_SETTINGS && current_setting == -1; i++){
                    		if(!changed[i] && STRING_VALUE_NAMES[i] != null){
                    			// String val
                    			if(line.length() > STRING_VALUE_NAMES[i].length() && STRING_VALUE_NAMES[i].equals(line.substring(0, STRING_VALUE_NAMES[i].length())) ){
                    				current_setting = i;
                    				if(i == 11){
                    					// dofBlurAmount (additional blur) is a special setting
                    					int_str = line.substring(first_space + 1, line.length());
                    					first_space = int_str.indexOf(' ');
                        				while(first_space > 0){
                        					// Remove extra spaces
                        					int_str = int_str.substring(first_space + 1, int_str.length());
                        					first_space = int_str.indexOf(' ');
                        				}
                        				try{
                        					if((!NumberUtils.isParsable(int_str) && !int_str.equals("o")) || (NumberUtils.isParsable(int_str) && Integer.parseInt(int_str) < 0)){
                        						// dofBlurAmount (additional blur) must be "o" or a number greater than 0
                        						current_setting = -1;
                        					}
                        				}catch(NumberFormatException nFE){
                        					current_setting = -1;
                        				}
                    				}
                    			}
                    		}else if(!changed[i] && INT_VALUE_NAMES[i] != null){
                    			// int val
                    			if(line.length() > INT_VALUE_NAMES[i].length() && INT_VALUE_NAMES[i].equals(line.substring(0, INT_VALUE_NAMES[i].length())) ){
                    				current_setting = i;
                    				int_str = line.substring(first_space + 1, line.length());
                    				first_space = int_str.indexOf(' ');
                    				
                    				while(first_space > 0){
                    					// Remove extra spaces
                    					int_str = int_str.substring(first_space + 1, int_str.length());
                    					first_space = int_str.indexOf(' ');
                    				}
                    				
                    				try{
                    					if(!NumberUtils.isParsable(int_str)){
                    						current_setting = -1;
                    					}
                    				}catch(NumberFormatException nFE){
                    					current_setting = -1;
                    				}
                    			}
                    		}
                    	}
                    	
                        //Check for special settings that have special limitations
                        //This might actually be unecessary now (the mutator methods used to make changes based on certain limitations that I've since removed)
                        if(current_setting == 2 || current_setting == 3 || current_setting == 9){
                            switch(current_setting){
                                case 2:
                                    setPresentWidth(Integer.parseInt(int_str));
                                    break;
                                case 3:
                                    setPresentHeight(Integer.parseInt(int_str));
                                    break;
                                case 9:
                                    setDOFOverride(Integer.parseInt(int_str));
                                    break;
                                default:
                                    break;
                            }
                        //Check for int valued setting
                        }else if(current_setting > -1 && INT_VALUE_NAMES[current_setting] != null){
                            //Change int value
                            AtomicInteger intVal = (AtomicInteger)settings.get(current_setting);
                            intVal.set(Integer.parseInt(int_str));
                        //Check for StringBuilder valued setting
                        }else if(current_setting > -1){
                            //Change StringBuilder value
                        	StringBuilder stringVal = (StringBuilder)settings.get(current_setting);
                            stringVal.replace(0, stringVal.length(), ("" + line.substring(line.indexOf(' ') + 1)));
                        }
                        
                        if(current_setting > -1){
                        	settingsChanged++;
                        	changed[current_setting] = true;
                        }
                    }
                }
                
            } catch (FileNotFoundException ex) {
                //Logger.getLogger(DSFConfiguration.class.getName()).log(Level.SEVERE, null, ex);
                ui.printConsole(in.getName() + DSCUTIL_FILE_NOT_FOUND);
            }
        }else{
            ui.printConsole(in.getName() + INVALID_FILETYPE_ERR + iniExt);
            ui.printConsole(CONFIG_NOT_LOADED);
        }
        
        
        if(settingsChanged < TOTAL_SETTINGS){
        	// Load default values of missing settings
        	for(int i = 0; i < TOTAL_SETTINGS && settingsChanged < TOTAL_SETTINGS; i++){
        		if(!changed[i] && STRING_VALUE_NAMES[i] != null){
        			ui.printConsole("\"" + STRING_VALUE_NAMES[i] + "\"" + CONFIG_SETTING_NOT_LOADED);
        			StringBuilder stringVal = (StringBuilder)settings.get(i);
                    stringVal.replace(0, stringVal.length(), DEFAULT_STRING_VALUES[i]);
                    settingsChanged++;
        		}else if(!changed[i] && INT_VALUE_NAMES[i] != null){
        			ui.printConsole("\"" + INT_VALUE_NAMES[i] + "\"" + CONFIG_SETTING_NOT_LOADED);
        			switch(i){
	        			case 2:
	        				setPresentWidth(DEFAULT_INT_VALUES[i]);
	        				break;
	        			case 3:
	        				setPresentHeight(DEFAULT_INT_VALUES[i]);
	        				break;
	        			case 9:
	        				setDOFOverride(DEFAULT_INT_VALUES[i]);
	        				break;
	    				default:
	    					AtomicInteger intVal = (AtomicInteger)settings.get(i);
                            intVal.set(DEFAULT_INT_VALUES[i]);
	    					break;
        			}
        			settingsChanged++;
        		}
        	}
        }
        
        
        if(settingsChanged < TOTAL_SETTINGS){
            ui.printConsole(CONFIG_PARTIALLY_LOADED);
            ui.resetDSFConfigDefaults();
        }else if(settingsChanged == TOTAL_SETTINGS){
            ui.printConsole(SETTINGS_LOADED);
        }else{
        	// Too many settings loaded somehow?
        	ui.printConsole(CONFIG_TOO_MANY_LOADED);
        }
        
        if(fileInput != null){
            fileInput.close();
        }
        
        if(dofOverrideResolution.get() == renderHeight.get() &&
                presentWidth.get() == renderWidth.get() && 
                presentHeight.get() == renderHeight.get() &&
                disableDofScaling.get() == 1 &&
                dofBlurAmount.toString().equals("o")){
            disableDOF = true;
        }else{
            disableDOF = false;
        }
        
        initSettingsList();
    }
    
    public void writeSettingsToIniFile(String writePath){
        File template = new File(TEMPLATES_DIR + "\\" + DSF_FILES[1]);
        initSettingsList();
        
        File writeFile = new File(writePath);
        if(writeFile.exists()){
            writeFile.delete();
            if(writeFile.exists()){
                //.ini file was not deleted, so we won't be able to write over it
                ui.printConsole(UNABLE_TO_OVERWRITE);
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
        int settingsApplied = 0;
        for(settingsApplied = 0; settingsApplied < TOTAL_SETTINGS && fileInput.hasNext();){
            String line = fileInput.nextLine();
            if(line.length() >= 1 && line.charAt(0) == '$'){
                //This is a line to edit/write to
                if(INT_VALUE_NAMES[settingsApplied] != null){
                    //This is an int value
                    writeBuffer += INT_VALUE_NAMES[settingsApplied] + " " + settings.get(settingsApplied) + String.format("%n");
                }else{
                    //This is a string value
                    writeBuffer += STRING_VALUE_NAMES[settingsApplied] + " " + settings.get(settingsApplied) + String.format("%n");
                }
                //Increment settingsApplied to keep track of the number of settings we've applied
                settingsApplied++;
            }else{
                //This is a line to copy
                writeBuffer += line + String.format("%n");
            }
        }
        
        if(settingsApplied == TOTAL_SETTINGS){
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
        }else{
            //Write was unsuccessful
            ui.printConsole(NOT_ALL_SETTINGS_APPLIED);
        }
        
    }
    
    /*
    * Exports all DSFix files as well as the current config
    * @param path the destination directory as a String
    */
    public void exportDSFix(String path){
        
        File toDir = new File(path);
        if(toDir.canWrite()){
            
            toDir = new File(path + DSF_FOLDER);
            //Get the unaltered files from the resource folder
            File fromDir = new File(FILES_DIR + DSF_FOLDER);
            
            try {
                FileUtils.copyDirectory(fromDir, toDir);
            } catch (IOException ex) {
                ui.printConsole(EXPORT_FAILED);
                return;
            }
            
            toDir = new File(path + DSF_FOLDER + "\\" + DSF_FILES[1]);
            if(toDir.exists()){
                ui.printConsole(DSF_FILES_COPIED);
                writeSettingsToIniFile(toDir.getPath());
            }else{
                ui.printConsole(EXPORT_FAILED);
                return;
            }
            
        }else{
            //Can't write to the directory
            ui.printConsole(CANT_WRITE_DIR);
            ui.printConsole(EXPORT_FAILED);
        }
    }
    
    //Getter/Accessor Methods
    
    //public boolean getDOFDisabled(){
    //    return disableDOF;
    //}
    
    public int getRenderWidth(){
        return renderWidth.get();
    }
    public int getRenderHeight(){
        return renderHeight.get();
    }
    public int getPresentWidth(){
        return presentWidth.get();
    }
    public int getPresentHeight(){
        return presentHeight.get();
    }
    
    public int getDOFOverride(){
        return dofOverrideResolution.get();
    }
    
    //Setter/Mutator Methods

    public void disableDOF(){
        dofOverrideResolution.set(renderHeight.get());
        presentWidth.set(renderWidth.get());
        presentHeight.set(renderHeight.get());
        disableDofScaling.set(1);
        dofBlurAmount.replace(0, dofBlurAmount.length(), "o");
        
        disableDOF = true;
    }
    
    public void setRenderHeight(int newHeight){
        if(newHeight <= dofOverrideResolution.get()){
        //    if(disableDOF){
        //        dofOverrideResolution = newHeight;
        //    }else{
        //        dofOverrideResolution = 0;
        //    }
        //}else{
        //    if(disableDOF){
        //        dofOverrideResolution = newHeight;
        //    }
        }
        
        //if(presentHeight == newHeight){
        //    presentWidth = 0;
        //    presentHeight = 0;
        //}
        renderHeight.set(newHeight);
    }
    public void setRenderWidth(int newWidth){
        //if(presentWidth == newWidth){
        //    presentWidth = 0;
        //   presentHeight = 0;
        //}
        renderWidth.set(newWidth);
    }
    public void setPresentWidth(int newWidth){
        //if(newWidth == renderWidth.intValue() && Objects.equals(presentHeight, renderHeight)){
        //    presentWidth = 0;
        //}else{
            presentWidth.set(newWidth);
        //}
    }
    public void setPresentHeight(int newHeight){
        //if(newHeight == renderHeight.intValue() && Objects.equals(presentWidth, renderWidth)){
        //    presentWidth = 0;
        //    presentHeight = 0;
        //}else{
            presentHeight.set(newHeight);
        //}
    }
    
    public void setWindowsResolution(){
        if((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() >= 1280 &&
            (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() >= 720){
            renderWidth.set((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth());
            renderHeight.set((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        }
        initSettingsList();
    }
    
    public void setDOFOverride(int newRes){
        dofOverrideResolution.set(newRes);
    }
    
    public void restoreDefaultGraphicsOptions(){
        renderWidth.set(DEFAULT_INT_VALUES[0]);
        renderHeight.set(DEFAULT_INT_VALUES[1]);
        presentWidth.set(DEFAULT_INT_VALUES[2]);
        presentHeight.set(DEFAULT_INT_VALUES[3]);
        aaQuality.set(DEFAULT_INT_VALUES[4]);
        aaType.replace(0, aaType.length(), DEFAULT_STRING_VALUES[5]);
        ssaoStrength.set(DEFAULT_INT_VALUES[6]);
        ssaoScale.set(DEFAULT_INT_VALUES[7]);
        ssaoType.replace(0, ssaoType.length(), DEFAULT_STRING_VALUES[8]);
        dofOverrideResolution.set(DEFAULT_INT_VALUES[9]);
        disableDofScaling.set(DEFAULT_INT_VALUES[10]);
        dofBlurAmount.replace(0, dofBlurAmount.length(), DEFAULT_STRING_VALUES[11]);
        unlockFPS.set(DEFAULT_INT_VALUES[12]);
        FPSlimit.set(DEFAULT_INT_VALUES[13]);
        FPSthreshold.set(DEFAULT_INT_VALUES[14]);
        filteringOverride.set(DEFAULT_INT_VALUES[15]);
    }
    
    public void restoreDefaultHUDOptions(){
        enableHudMod.set(DEFAULT_INT_VALUES[16]);
        enableMinimalHud.set(DEFAULT_INT_VALUES[17]);
        hudScaleFactor.replace(0, hudScaleFactor.length(), DEFAULT_STRING_VALUES[18]);
        hudTopLeftOpacity.replace(0, hudTopLeftOpacity.length(), DEFAULT_STRING_VALUES[19]);
        hudBottomLeftOpacity.replace(0, hudBottomLeftOpacity.length(), DEFAULT_STRING_VALUES[20]);
        hudBottomRightOpacity.replace(0, hudBottomRightOpacity.length(), DEFAULT_STRING_VALUES[21]);
    }
    
    public void restoreDefaultWMOptions(){
        borderlessFullscreen.set(DEFAULT_INT_VALUES[22]);
        disableCursor.set(DEFAULT_INT_VALUES[23]);
        captureCursor.set(DEFAULT_INT_VALUES[24]);
    }
    
    public void restoreDefaultSaveOptions(){
        enableBackups.set(DEFAULT_INT_VALUES[25]);
        backupInterval.set(DEFAULT_INT_VALUES[26]);
        maxBackups.set(DEFAULT_INT_VALUES[27]);
    }
    
    public void restoreDefaultTextureOptions(){
        enableTextureDumping.set(DEFAULT_INT_VALUES[28]);
        enableTextureOverride.set(DEFAULT_INT_VALUES[29]);
    }
    
    public void restoreDefaultOtherOptions(){
        skipIntro.set(DEFAULT_INT_VALUES[30]);
        screenshotDir.replace(0, screenshotDir.length(), DEFAULT_STRING_VALUES[31]);
        overrideLanguage.replace(0, overrideLanguage.length(), DEFAULT_STRING_VALUES[32]);
        dinput8dllWrapper.replace(0, dinput8dllWrapper.length(), DEFAULT_STRING_VALUES[33]);
        d3dAdapterOverride.replace(0, d3dAdapterOverride.length(), DEFAULT_STRING_VALUES[34]);
        logLevel.set(DEFAULT_INT_VALUES[35]);
    }
    
    public void restoreDefaultUnsafeOptions(){
        forceWindowed.set(DEFAULT_INT_VALUES[36]);
        forceFullscreen.set(DEFAULT_INT_VALUES[37]);
        enableVsync.set(DEFAULT_INT_VALUES[38]);
        fullscreenHz.set(DEFAULT_INT_VALUES[39]);
    }
    
    //Helper Methods
    public void initSettingsList(){
        settings = new ArrayList();
        
        settings.add(renderWidth);
        settings.add(renderHeight);
        settings.add(presentWidth);
        settings.add(presentHeight);
        settings.add(aaQuality);
        settings.add(aaType);
        settings.add(ssaoStrength);
        settings.add(ssaoScale);
        settings.add(ssaoType);
        settings.add(dofOverrideResolution);
        settings.add(disableDofScaling);
        settings.add(dofBlurAmount); //11
        settings.add(unlockFPS);
        settings.add(FPSlimit);
        settings.add(FPSthreshold);
        settings.add(filteringOverride);
        settings.add(enableHudMod);
        settings.add(enableMinimalHud);
        settings.add(hudScaleFactor);
        settings.add(hudTopLeftOpacity);
        settings.add(hudBottomLeftOpacity);
        settings.add(hudBottomRightOpacity);
        settings.add(borderlessFullscreen);
        settings.add(disableCursor);
        settings.add(captureCursor);
        settings.add(enableBackups);
        settings.add(backupInterval);
        settings.add(maxBackups);
        settings.add(enableTextureDumping);
        settings.add(enableTextureOverride);
        settings.add(skipIntro);
        settings.add(screenshotDir);
        settings.add(overrideLanguage);
        settings.add(dinput8dllWrapper);
        settings.add(d3dAdapterOverride);
        settings.add(logLevel);
        settings.add(forceWindowed);
        settings.add(forceFullscreen);
        settings.add(enableVsync);
        settings.add(fullscreenHz);
        
    }
}
