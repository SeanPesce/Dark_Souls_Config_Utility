/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.FileIO;

import static dscfgutil.DSCfgUtilConstants.*;

import dscfgutil.configs.DsTextureMod;
import dscfgutil.dialog.AlertDialog;
import dscfgutil.dialog.ContinueDialog;
import dscfgutil.view.DSCfgMainUI;
import static dscfgutil.view.DSCfgMainUI.showConsoleBar;
import static dscfgutil.view.DSCfgMainUI.showConsoleWindow;
import static dscfgutil.view.DSCfgMainUI.writeLogToFile;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.AccessDeniedException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javax.imageio.IIOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author Sean Pesce
 */
public class DSFixFileController {
    
    DSCfgMainUI ui;
    
    public DSFixFileController(DSCfgMainUI initUI){
        ui = initUI;
    }
    
    public void chooseDataFolder(){
        DirectoryChooser dirPicker = new DirectoryChooser();
        dirPicker.setTitle(DIALOG_TITLE_PICK_DIR);
        if(ui.getDataFolder() != null && ui.getDataFolder().exists()){
            dirPicker.setInitialDirectory(ui.getDataFolder());
        }
        
        File newDataFolder = dirPicker.showDialog(ui.getStage());
        
        if(newDataFolder != null && newDataFolder.exists()){
            //Check for DARKSOULS.exe
            File dsExe = new File(newDataFolder.getPath() + "\\" + DS_EXE);
            if(!dsExe.exists()){
                //Make sure they didn't pick the parent folder by accident
                dsExe = new File(newDataFolder.getPath() + DATA_FOLDER + "\\" + DS_EXE);
                if(!dsExe.exists()){
                    @SuppressWarnings("unused")
					AlertDialog dsExeNotFound = new AlertDialog(300.0, 80.0,
                                                    DIALOG_TITLE_NO_DS_EXE,
                                                    DIALOG_MSG_NO_DS_EXE,
                                                    DIALOG_BUTTON_TEXTS[0]);
                }else{
                    ui.setDataFolder(newDataFolder.getPath() + DATA_FOLDER);
                    return;
                }
            }
            ui.setDataFolder(newDataFolder.getPath());
        }
    }
    
    public void installDSFix(){
        
        ui.printConsole(INSTALLING_DSF);
        File srcFile = null;
        File destFile = null;
        boolean copyError = false;
        
        for(int i = 0; i < DSF_FILES.length; i++){
            String file = DSF_FILES[i];
            srcFile = new File(FILES_DIR + DSF_FOLDER + "\\" + file);
            destFile = new File(ui.getDataFolder().getPath() + "\\" + file);
            
            try{
                if(i != DSF_FILES.length - 2){
                    FileUtils.copyFile(srcFile, destFile);
                }else{
                    //FileUtils.copyDirectory(srcFile, destFile);
                    FileUtils.forceMkdir(destFile);
                }
                ui.printConsole(COPYING + file);
            }catch(IOException iOE){
                ui.printConsole(FAILED_FILE_COPY_ERR + file);
                copyError = true;
            }
        }
        
        if(!copyError){
            ui.checkForDSFix();
            if(ui.getDSPWStatus() != 0){
                installFPSFix();
            }
            turnOffIngameAA();
            ui.printConsole(DSF_INSTALLED_SUCCESS);
        }else{
            ui.printConsole(DSF_INSTALLED_ERRORS);
            ContinueDialog cD = new ContinueDialog(300.0, 80.0, DIALOG_TITLE_INSTALL_ERR,
                                                    DIALOG_MSG_FILE_COPY_ERR,
                                                    DIALOG_BUTTON_TEXTS[2],
                                                    DIALOG_BUTTON_TEXTS[3]);
            if(cD.show()){
                uninstallDSFix();
            }
            
            ui.checkForDSFix();
        }
        
        
    }
    
    public void installDSMFix(){
        
        ui.printConsole(INSTALLING_DSM);
        File srcFile = null;
        File destFile = null;
        boolean copyError = false;
        
        for(int i = 0; i < DSM_FILES.length; i++){
            String file = DSM_FILES[i];
            srcFile = new File(FILES_DIR + DSM_FOLDER + "\\" + file);
            destFile = new File(ui.getDataFolder().getPath() + "\\" + file);
            
            try{
                FileUtils.copyFile(srcFile, destFile);
                ui.printConsole(COPYING + file);
            }catch(IOException iOE){
                ui.printConsole(FAILED_FILE_COPY_ERR + file);
                copyError = true;
            }
        }
        
        if(!copyError){
            ui.printConsole(DSM_INSTALLED_SUCCESS);
            ui.checkForDSMFix();
            ui.getConfig().dinput8dllWrapper.replace(0, ui.getConfig().dinput8dllWrapper.length(), DSM_FILES[0]);
            ui.setSelectedTab(5);
            ui.refreshUI();
            @SuppressWarnings("unused")
			AlertDialog aD = new AlertDialog(300.0, 80.0, DIALOG_TITLE_APPLY_CHANGES,
                                            DIALOG_MSG_APPLY_DSM_CHAIN,
                                            DIALOG_BUTTON_TEXTS[0]);
        }else{
            ui.printConsole(DSM_INSTALLED_ERRORS);
            ContinueDialog cD = new ContinueDialog(300.0, 80.0, DIALOG_TITLE_INSTALL_ERR,
                                                    DIALOG_MSG_DSM_FILE_COPY_ERR,
                                                    DIALOG_BUTTON_TEXTS[2],
                                                    DIALOG_BUTTON_TEXTS[3]);
            if(cD.show()){
                uninstallDSMFix();
            }else{
                ui.checkForDSMFix();
            }
        }
        
    }
    
    public void installDSPW(){
        
        ui.printConsole(INSTALLING_DSPW);
        File srcFile = null;
        File destFile = null;
        boolean copyError = false;
        
        for(int i = 0; i < DSPW_FILES.length; i++){
            String file = DSPW_FILES[i];
            srcFile = new File(FILES_DIR + DSPW_FOLDER + "\\" + file);
            if(i == 3){
                srcFile = new File(TEMPLATES_DIR + "\\" + DSPW_FILES[i]);
            }
            destFile = new File(ui.getDataFolder().getPath() + "\\" + file);
            
            try{
                FileUtils.copyFile(srcFile, destFile);
                ui.printConsole(COPYING + file);
            }catch(IOException iOE){
                ui.printConsole(FAILED_FILE_COPY_ERR + file);
                copyError = true;
            }
        }
        
        if(!copyError){
            ui.checkForDSPW();
            installFPSFix();
            ui.printConsole(DSPW_INSTALLED_SUCCESS);
            ui.setSelectedTab(8);
            ui.refreshUI();
        }else{
            ui.printConsole(DSPW_INSTALLED_ERRORS);
            ContinueDialog cD = new ContinueDialog(300.0, 80.0, DIALOG_TITLE_INSTALL_ERR,
                                                    DIALOG_MSG_DSPW_FILE_COPY_ERR,
                                                    DIALOG_BUTTON_TEXTS[2],
                                                    DIALOG_BUTTON_TEXTS[3]);
            if(cD.show()){
                uninstallDSPW();
            }else{
                ui.checkForDSPW();
            }
        }
    }
    
    public void installFPSFix(){
        
        File srcFile = null;
        File destFile = null;
        
        try{
            if(ui.getDSPWStatus() == 0){
                //PvP Watchdog is installed
                srcFile = new File(FILES_DIR + FPS_FIX_FOLDER + "\\" + FPS_FIX_FILES[0]);
                destFile = new File(ui.getDataFolder().getPath() + "\\" + FPS_FIX_FILES[0]);
                FileUtils.copyFile(srcFile, destFile);
                ui.printConsole(COPYING + destFile.getName());
                ui.getDSPWConfig().d3d9dllWrapper.replace(0, ui.getDSPWConfig().d3d9dllWrapper.length(), FPS_FIX_FILES[0]);
                ui.printConsole(APPLY_DSPW_FPS_FIX);
            }else if(ui.getDSFStatus() == 0 && ui.getDSPWStatus() != 0){
                //DSFix is installed and PvP Watchdog is not
                srcFile = new File(FILES_DIR + FPS_FIX_FOLDER + "\\" + FPS_FIX_FILES[0]);
                destFile = new File(ui.getDataFolder().getPath() + "\\" + DSPW_FILES[1]);
                FileUtils.copyFile(srcFile, destFile);
                ui.printConsole(COPYING + destFile.getName());
            }
            
            srcFile = new File(FILES_DIR + FPS_FIX_FOLDER + "\\" + FPS_FIX_FILES[1]);
            destFile = new File(ui.getDataFolder().getPath() + "\\" + FPS_FIX_FILES[1]);
            if(!destFile.exists()){
                FileUtils.copyFile(srcFile, destFile);
                ui.printConsole(COPYING + destFile.getName());
            }
            
        }catch(IOException ioE){
            ui.printConsole(FAILED_FILE_COPY_ERR + destFile.getName());
        }
        
    }
    
    public void installTextureMod(String folder, String[] files, String mod){
        
        File srcFile = null;
        File destFile = null;
        boolean copyError = false;
        
        for(int i = 0; i < files.length; i++){
            String file = files[i];
            srcFile = new File(FILES_DIR + TEXTURE_MODS_FOLDER + folder + "\\" + file);
            destFile = new File(ui.getDataFolder().getPath() + DSF_TEX_OVERRIDE_FOLDER + "\\" + file);
            
            try{
                FileUtils.copyFile(srcFile, destFile);
                ui.printConsole(COPYING + file);
            }catch(IOException iOE){
                ui.printConsole(FAILED_FILE_COPY_ERR + file);
                copyError = true;
            }
        }
        
        if(!copyError){
            ui.printConsole(TEX_MOD_INSTALLED_SUCCESS[0] + mod + TEX_MOD_INSTALLED_SUCCESS[1]);
        }
    }
    
    public void exportDSFIniFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(DIALOG_TITLE_EXPORT_INI);
        FileChooser.ExtensionFilter iniFilter = new FileChooser.ExtensionFilter(INI_EXT_FILTER[0], INI_EXT_FILTER[1]);
        fileChooser.getExtensionFilters().add(iniFilter);
        File exportedFile = fileChooser.showSaveDialog(ui.getStage());
        
        if(exportedFile != null){
            ui.getConfig().writeSettingsToIniFile(exportedFile.getPath());
        }
    }
    
    public void exportDSFKeybindsIniFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(DIALOG_TITLE_EXPORT_INI);
        FileChooser.ExtensionFilter iniFilter = new FileChooser.ExtensionFilter(INI_EXT_FILTER[0], INI_EXT_FILTER[1]);
        fileChooser.getExtensionFilters().add(iniFilter);
        File exportedFile = fileChooser.showSaveDialog(ui.getStage());
        
        if(exportedFile != null){
            ui.getDSFKeybinds().writeSettingsToIniFile(exportedFile.getPath());
        }
    }
    
    public void exportDSF(){
        DirectoryChooser dirChooser = new DirectoryChooser();
        dirChooser.setTitle(DIALOG_TITLE_EXPORT_DSF);
        File exportedFolder = dirChooser.showDialog(ui.getStage());
        
        if(exportedFolder != null){
            ui.getConfig().exportDSFix(exportedFolder.getPath());
            ui.getDSFKeybinds().writeSettingsToIniFile(exportedFolder + DSF_FOLDER + "\\" + DSF_FILES[2]);
        }
    }
    
    public void getVersion(){
        try {
            PROGRAM_VERSION = readTextFile(FILES_DIR + "\\version").trim();
        } catch (FileNotFoundException ex) {
            // Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
            PROGRAM_VERSION = "?.??";
        }
        if(PROGRAM_VERSION.equals("0.00") || !NumberUtils.isParsable(PROGRAM_VERSION)){
            PROGRAM_VERSION = "?.??";
            ui.printConsole(UNKNOWN_VERSION);
        }
    }
    
    public void loadDSFConfig(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(DIALOG_TITLE_IMPORT_INI);
        FileChooser.ExtensionFilter iniFilter = new FileChooser.ExtensionFilter(INI_EXT_FILTER[0], INI_EXT_FILTER[1]);
        fileChooser.getExtensionFilters().add(iniFilter);
        
        File importedFile = fileChooser.showOpenDialog(ui.getStage());
        if(importedFile != null){
            ui.getConfig().loadSettingsFromIniFile(importedFile.getPath());
        }
    }
    
    public void loadDSFKeybinds(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(DIALOG_TITLE_IMPORT_INI);
        FileChooser.ExtensionFilter iniFilter = new FileChooser.ExtensionFilter(INI_EXT_FILTER[0], INI_EXT_FILTER[1]);
        fileChooser.getExtensionFilters().add(iniFilter);
        
        File importedFile = fileChooser.showOpenDialog(ui.getStage());
        if(importedFile != null){
            ui.getDSFKeybinds().loadSettingsFromIniFile(importedFile.getPath());
        }
    }
    
    public void uninstallDSFix(){
        
        ui.printConsole(UNINSTALLING_DSF);
        File fileToDelete = null;
        boolean deleteError = false;
        
        for(int i = DSF_FILES.length - 3; i >= 0; i--){ // Don't delete tex_dump or tex_override folders (starting from length-3)
            String file = DSF_FILES[i];
            fileToDelete = new File(ui.getDataFolder().getPath() + "\\" + file);
            if(fileToDelete.exists()){
                fileToDelete.delete();
                if(fileToDelete.exists()){
                    deleteError = true;
                    ui.printConsole(FAILED_FILE_DELETE_ERR + file);
                }else{
                    ui.printConsole(FILE_DELETED + file);
                }
            }else{
                ui.printConsole(DSF_FILE_NOT_FOUND + file);
            }
        }
        
        if(!deleteError){
            if(ui.getDSPWStatus() != 0){
                uninstallFPSFix();
            }
            ui.printConsole(DSF_UNINSTALLED_SUCCESS);
        }else{
            if(ui.getDSPWStatus() != 0){
                uninstallFPSFix();
            }
            ui.printConsole(DSF_UNINSTALLED_ERRORS);
            ContinueDialog cD = new ContinueDialog(300.0, 80.0, DIALOG_TITLE_OPEN_FOLDER_PROMPT,
                                                    DIALOG_MSG_DELETE_ERRORS_PROMPT,
                                                    DIALOG_BUTTON_TEXTS[2],
                                                    DIALOG_BUTTON_TEXTS[3]);
            if(cD.show()){
                try {
                    Desktop.getDesktop().open(ui.getDataFolder());
                } catch (IOException ex) {
                    //Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
                    ui.printConsole(FAILED_OPEN_FOLDER_ERR);
                }
            }
        }
        ui.checkForDSFix();
    }
    
    public void uninstallDSMFix(){
        
        ui.printConsole(UNINSTALLING_DSM);
        File fileToDelete = null;
        boolean deleteError = false;
        
        for(int i = DSM_FILES.length - 1; i >= 0; i--){
            String file = DSM_FILES[i];
            fileToDelete = new File(ui.getDataFolder().getPath() + "\\" + file);
            if(fileToDelete.exists()){
                fileToDelete.delete();
                if(fileToDelete.exists()){
                    deleteError = true;
                    ui.printConsole(FAILED_FILE_DELETE_ERR + file);
                }else{
                    ui.printConsole(FILE_DELETED + file);
                }
            }else{
                ui.printConsole(DSF_FILE_NOT_FOUND + file);
            }
        }
        
        if(!deleteError){
            ui.printConsole(DSM_UNINSTALLED_SUCCESS);
        }else{
            ui.printConsole(DSM_UNINSTALLED_ERRORS);
            ContinueDialog cD = new ContinueDialog(300.0, 80.0, DIALOG_TITLE_OPEN_FOLDER_PROMPT,
                                                    DIALOG_MSG_DELETE_ERRORS_PROMPT,
                                                    DIALOG_BUTTON_TEXTS[2],
                                                    DIALOG_BUTTON_TEXTS[3]);
            if(cD.show()){
                try {
                    Desktop.getDesktop().open(ui.getDataFolder());
                } catch (IOException ex) {
                    //Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
                    ui.printConsole(FAILED_OPEN_FOLDER_ERR);
                }
            }
        }
        ui.checkForDSMFix();
        
        if(ui.getConfig().dinput8dllWrapper.toString().equals(DSM_FILES[0])){
            ui.getConfig().dinput8dllWrapper.replace(0, ui.getConfig().dinput8dllWrapper.length(), NONE);
            ui.setSelectedTab(5);
            ui.refreshUI();
            @SuppressWarnings("unused")
			AlertDialog aD = new AlertDialog(300.0, 80.0, DIALOG_TITLE_APPLY_CHANGES,
                                            DIALOG_MSG_APPLY_NO_DLL_CHAIN,
                                            DIALOG_BUTTON_TEXTS[0]);
        }
    }
    
    public void uninstallDSPW(){
        
        ui.printConsole(UNINSTALLING_DSPW);
        File fileToDelete = null;
        boolean deleteError = false;
        
        for(int i = DSPW_FILES.length - 1; i >= 0; i--){
            String file = DSPW_FILES[i];
            fileToDelete = new File(ui.getDataFolder().getPath() + "\\" + file);
            if(fileToDelete.exists()){
                fileToDelete.delete();
                if(fileToDelete.exists()){
                    deleteError = true;
                    ui.printConsole(FAILED_FILE_DELETE_ERR + file);
                }else{
                    ui.printConsole(FILE_DELETED + file);
                }
            }else{
                ui.printConsole(DSF_FILE_NOT_FOUND + file);
            }
        }
        
        if(ui.getCurrentTab() == 8){
            ui.setSelectedTab(0);
        }
        
        if(!deleteError){
            if(ui.getDSFStatus() != 0){
                uninstallFPSFix();
            }else{
                File renameFile = new File(ui.getDataFolder().getPath() + "\\" + FPS_FIX_FILES[0]);
                if(renameFile.exists()){
                    ui.printConsole(RENAMING_FILE[0] + FPS_FIX_FILES[0] +
                            RENAMING_FILE[1] + DSPW_FILES[1] + RENAMING_FILE[2]);
                    renameFile.renameTo(new File(ui.getDataFolder().getPath() + "\\" + DSPW_FILES[1]));
                }
            }
            ui.printConsole(DSPW_UNINSTALLED_SUCCESS);
        }else{
            if(ui.getDSFStatus() != 0){
                uninstallFPSFix();
            }else{
                File renameFile = new File(ui.getDataFolder().getPath() + "\\" + FPS_FIX_FILES[0]);
                if(renameFile.exists()){
                    ui.printConsole(RENAMING_FILE[0] + FPS_FIX_FILES[0] +
                            RENAMING_FILE[1] + DSPW_FILES[1] + RENAMING_FILE[2]);
                    renameFile.renameTo(new File(ui.getDataFolder().getPath() + "\\" + DSPW_FILES[1]));
                }
            }
            ui.printConsole(DSPW_UNINSTALLED_ERRORS);
            ContinueDialog cD = new ContinueDialog(300.0, 80.0, DIALOG_TITLE_OPEN_FOLDER_PROMPT,
                                                    DIALOG_MSG_DELETE_ERRORS_PROMPT,
                                                    DIALOG_BUTTON_TEXTS[2],
                                                    DIALOG_BUTTON_TEXTS[3]);
            if(cD.show()){
                try {
                    Desktop.getDesktop().open(ui.getDataFolder());
                } catch (IOException ex) {
                    //Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
                    ui.printConsole(FAILED_OPEN_FOLDER_ERR);
                }
            }
        }
        ui.checkForDSPW();
    }
    
    public void uninstallTextureMod(String[] files){
        File fileToDelete = null;
        
        for(int i = files.length - 1; i >= 0; i--){
            String file = files[i];
            fileToDelete = new File(ui.getDataFolder().getPath() + DSF_TEX_OVERRIDE_FOLDER + "\\" + file);
            if(fileToDelete.exists()){
                fileToDelete.delete();
                if(fileToDelete.exists()){
                    ui.printConsole(FAILED_FILE_DELETE_ERR + file);
                }else{
                    ui.printConsole(FILE_DELETED + file);
                }
            }else{
                ui.printConsole(DSF_FILE_NOT_FOUND + file);
            }
        }
    }
    
    public void uninstallFPSFix(){
        
        File fileToDelete = null;
        
        if(ui.getDSPWStatus() == 0){
            //PvP Watchdog is installed
            fileToDelete = new File(ui.getDataFolder().getPath() + "\\" + FPS_FIX_FILES[0]);
            if(fileToDelete.exists()){
                fileToDelete.delete();
                if(fileToDelete.exists()){
                    ui.printConsole(FAILED_FILE_DELETE_ERR + fileToDelete.getName());
                }else{
                    ui.printConsole(FILE_DELETED + fileToDelete.getName());
                }
            }
        }else if(ui.getDSFStatus() == 0 && ui.getDSPWStatus() != 0){
            //DSFix is installed and PvP Watchdog is not
            fileToDelete = new File(ui.getDataFolder().getPath() + "\\" + DSPW_FILES[1]);
            if(fileToDelete.exists()){
                fileToDelete.delete();
                if(fileToDelete.exists()){
                    ui.printConsole(FAILED_FILE_DELETE_ERR + fileToDelete.getName());
                }else{
                    ui.printConsole(FILE_DELETED + fileToDelete.getName());
                }
            }
        }

        fileToDelete = new File(ui.getDataFolder().getPath() + "\\" + FPS_FIX_FILES[1]);
        if(fileToDelete.exists()){
            fileToDelete.delete();
            if(fileToDelete.exists()){
                ui.printConsole(FAILED_FILE_DELETE_ERR + fileToDelete.getName());
            }else{
                ui.printConsole(FILE_DELETED + fileToDelete.getName());
            }
        }
    }
    
    public void turnOffIngameAA(){
        
        ui.printConsole(TURNING_OFF_AA);
        
        if(System.getenv("AppData") != null){
            ui.printConsole(FOUND_APPDATA);
            File iniFile = new File(System.getenv("AppData").substring(0, System.getenv("AppData").indexOf(APPDATA))
                                    + APPDATA_INI);
            if(iniFile.exists()){
                
                Scanner fileReader;
                
                try {
                    fileReader = new Scanner(iniFile);
                } catch (FileNotFoundException ex) {
                    ui.printConsole(UNABLE_TO_READ_DS_INI);
                    couldntTurnOffAA();
                    return;
                }
                
                int linesRead;
                String editedIniBuffer = "";
                for(linesRead = 0; linesRead <= 60 && fileReader.hasNextLine(); linesRead++){
                //Begin reading DarkSouls.ini
                    String line = fileReader.nextLine();
                    if(line.contains(AA_SETTING)){
                        //Change this line of the .ini file
                        line = AA_SETTING + " = 0";
                    }
                    
                    line += String.format("%n");
                    editedIniBuffer += line;
                }
                
                
                if(linesRead == 61){
                //All lines were read without issue, now write file
                    try {
                        ui.printConsole(WRITING_FILE[0]);
                        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(iniFile));
                        fileWriter.write(editedIniBuffer);
                        fileWriter.close();
                        //Write was successful
                        ui.printConsole(WRITING_FILE[1] + " " + TURNED_OFF_AA);
                    } catch (IOException ex) {
                        ui.printConsole(IOEX_FILE_WRITER);
                        ui.printConsole(FILE_WRITE_FAILED + " " + SEE_CONSOLE);
                        couldntTurnOffAA();
                    }
                }else{
                    ui.printConsole(UNABLE_TO_READ_DS_INI + " " + linesRead);
                    couldntTurnOffAA();
                }
                fileReader.close();
            }else{
                ui.printConsole(UNABLE_TO_FIND_DS_INI);
                File template = new File(TEMPLATES_DIR + "\\" + DS_INI);
                ui.printConsole(CREATING_INI);
                try{
                    FileUtils.copyFile(template, iniFile);
                    ui.printConsole(TURNED_OFF_AA);
                }catch(IOException ioe){
                    couldntTurnOffAA();
                }
            }
        }else{
            ui.printConsole(UNABLE_TO_FIND_APPDATA);
            couldntTurnOffAA();
        }
    }
    
    private void couldntTurnOffAA(){
        @SuppressWarnings("unused")
		AlertDialog aD = new AlertDialog(300.0, 80.0,
                                        DIALOG_TITLE_DISABLE_AA,
                                        DIALOG_MSG_DISABLE_AA,
                                        DIALOG_BUTTON_TEXTS[0]);
    }
    
    public static String readTextFile(String filePath) throws FileNotFoundException{
        
        //The file to be read
        File readFile = new File(filePath);
        //Initialize Scanner for reading file
        Scanner fileReader = new Scanner(readFile);
        //The String to be returned
        String text = null;

        while(fileReader.hasNextLine()){

            if(text == null){
                //Initialize return String
                text = "";
            }else{
                //Add new linebreak
                text += String.format("%n");
            }
            
            //Add line to text
            text += fileReader.nextLine();
        }
        
        fileReader.close();
        
        // If text is still null, return empty string
        if(text == null)
        	text = "";
        return text;
    }
    
    /**
     *Writes a string to a text file
     * 
     * @param filePath
     *  the path of the file to be read, including the filename
     * @param text
     *  the String to be written to the file; can be more than one line.
     * @param overwrite
     *  determines whether the user wants to overwrite the write file if it
     *  already exists. If true, pre-existing file will be overwritten
     * @throws IIOException
     *  if the write file already exists and the user allowed overwriting, but
     *  the file could not be overwritten
     * @throws AccessDeniedException
     *  if the write file already exists but the user didn't allow overwriting
     * @throws IOException
     *  if an error occurs initializing the BufferedWriter
     */
    public static void writeTextFile(String filePath, String text, boolean overwrite)
        throws IIOException, IOException, AccessDeniedException{
        
        //The file to be written
        File writeFile = new File(filePath);
        if(writeFile.exists() && overwrite){
            //If file exists, try to delete it
            if(!writeFile.delete()){
                //If file cannot be deleted, throw OIOException
                throw new IIOException("Could not delete pre-existing file: " + filePath);
            }
        }else if(writeFile.exists() && !overwrite){
            //If file exists but is not allowed to be overwritten, throw AccessDeniedException
            throw new AccessDeniedException(writeFile.getPath());
        }
        
        //Format each linebreak to be displayed correctly in a text file
        //String formattedText = text.replaceAll("\n", String.format("%n")); // Or don't
        String formattedText = text;
        //Initialize BufferedWriter to write string to file
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(writeFile));
        //Write the file
        /*Scanner scanner = new Scanner(formattedText);
        while(scanner.hasNextLine()){
            fileWriter.write(scanner.nextLine().trim());
            fileWriter.newLine();
        }*/
        fileWriter.write(formattedText, 0, formattedText.length());
        
        fileWriter.close();
    }
    
    /**
     *Checks all currently-running processes for specified process
     * 
     * @param targetProcess
     *  The name of the process to be checked for
     * @return
     *  True if target process is currently running; otherwise return false
     * @throws SecurityException
     *  If the user doesn't have permission to access running processes
     * @throws IOException
     *  If an error occurs with reading the list of processes
     */
    public static boolean processIsRunning(String targetProcess)
            throws SecurityException, IOException{
        String line;
        Process p = Runtime.getRuntime().exec
            (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
        BufferedReader input =
                new BufferedReader(new InputStreamReader(p.getInputStream()));
        //Skip header, which is the first 3 lines:
        input.readLine();
        input.readLine();
        input.readLine();
        while ((line = input.readLine()) != null) {
            if(line.startsWith(targetProcess)){
                input.close();
                //Found target process
                return true;
            }
        }
        
        input.close();
        //Checked all processes, target process does not exist
        return false;
    }
    
    /**
     * Launches the specified program.
     * 
     * @param filePath
     *  The path of the program to be launched
     * @throws IOException
     *  If the program fails to be launched
     */
    public static void launchProgram(String filePath)
            throws IOException {
        Runtime.getRuntime().exec(filePath);
    }
    
    public void changeDSVersion(int newVersion){
        if(ui.getDataFolder() == null){
            ui.printConsole(CANT_PATCH + DS_INSTALL_NOT_FOUND);
            return;
        }
        
        if(newVersion >= DS_VER_ENUM_UNKNOWN){
            // Can't change to an unknown version
            ui.printConsole(CANT_PATCH + "target is " + DS_VERSION_DETECTED[DS_VER_ENUM_UNKNOWN]);
            return;
        }
        
        if(newVersion == ui.getDSVersion()){
            ui.printConsole(SAME_VERSION);
            return;
        }
        
        File backupExecutable = new File(PATCHES_DIRECTORY + "\\" + EXE_BACKUP[newVersion]);
        File gameExecutable = new File(ui.getDataFolder().getPath() + "\\" + DS_EXE);
        
        // Check for backups of DARKSOULS.exe (and create them if they don't exist)
        if(!createPatchedExes()){
            ui.printConsole(FAILED_TO_PATCH + DS_EXE);
            return;
        }
        
        try {
            ui.printConsole(DS_VERSION_SWITCHING + DS_VERSIONS[newVersion]);
            FileUtils.copyFile(backupExecutable, gameExecutable);
        } catch (IOException ex) {
            //Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
            ui.printConsole(FAILED_TO_OVERWRITE + DS_EXE);
        }
        
    }
    
    /**
     * Checks for backups of DARKSOULS.exe, and creates them if they don't exist
     * 
     * @return true if successful; false if errors were encountered
     */
    public boolean createPatchedExes(){
        
        File latestBackup = new File(PATCHES_DIRECTORY + "\\" + EXE_BACKUP[DS_VER_ENUM_LATEST]);
        File betaBackup = new File(PATCHES_DIRECTORY + "\\" + EXE_BACKUP[DS_VER_ENUM_BETA]);
        File debugBackup = new File(PATCHES_DIRECTORY + "\\" + EXE_BACKUP[DS_VER_ENUM_DEBUG]);
        File gameExecutable = new File(ui.getDataFolder().getPath() + "\\" + DS_EXE);
        
        if(!latestBackup.exists() || !betaBackup.exists() || !debugBackup.exists()
                || latestBackup.length() != DS_SIZES[DS_VER_ENUM_LATEST]
                || betaBackup.length() != DS_SIZES[DS_VER_ENUM_BETA]
                || debugBackup.length() != DS_SIZES[DS_VER_ENUM_DEBUG]){
            
            if(latestBackup.exists() && latestBackup.length() != DS_SIZES[DS_VER_ENUM_LATEST]){
                ui.printConsole(DS_VERSION_REMOVING_INVALID_BACKUP + EXE_BACKUP[DS_VER_ENUM_LATEST]);
                if(!latestBackup.delete()){
                    // Failed to delete file
                    ui.printConsole(FAILED_FILE_DELETE_ERR + EXE_BACKUP[DS_VER_ENUM_LATEST]);
                    return false;
                }
            }
            
            // Make sure latest game build backup exists
            if(!latestBackup.exists() && (ui.getDataFolder() == null || ui.getDSVersion() >= DS_VER_ENUM_UNKNOWN)){
                // Can't create backup of latest game build
                return false;
            }else if(!latestBackup.exists() && ui.getDSVersion() == DS_VER_ENUM_LATEST){
                try {
                    ui.printConsole(DS_VERSION_CREATING_BACKUP + EXE_BACKUP[DS_VER_ENUM_LATEST]);
                    FileUtils.copyFile(gameExecutable, latestBackup);
                } catch (IOException ioEx) {
                    // Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
                    ui.printConsole(FAILED_FILE_COPY_ERR + EXE_BACKUP[DS_VER_ENUM_LATEST]);
                    return false;
                }
            }else if(!latestBackup.exists() && ui.getDSVersion() == DS_VER_ENUM_BETA){
                if(betaBackup.exists() && betaBackup.length() != DS_SIZES[DS_VER_ENUM_BETA]){
                    ui.printConsole(DS_VERSION_REMOVING_INVALID_BACKUP + EXE_BACKUP[DS_VER_ENUM_BETA]);
                    if(!betaBackup.delete()){
                        // Failed to delete file
                        ui.printConsole(FAILED_FILE_DELETE_ERR + EXE_BACKUP[DS_VER_ENUM_BETA]);
                        return false;
                    }
                }
                if(!betaBackup.exists()){
                    try {
                        ui.printConsole(DS_VERSION_CREATING_BACKUP + EXE_BACKUP[DS_VER_ENUM_BETA]);
                        FileUtils.copyFile(gameExecutable, betaBackup);
                    } catch (IOException ioEx) {
                        // Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
                        ui.printConsole(FAILED_FILE_COPY_ERR + EXE_BACKUP[DS_VER_ENUM_BETA]);
                        return false;
                    }
                }
                try {
                    ui.printConsole(DS_VERSION_PATCHING[0] + EXE_BACKUP[DS_VER_ENUM_LATEST] + DS_VERSION_PATCHING[1] + EXE_BACKUP[DS_VER_ENUM_BETA]);
                    patchFile(EXE_BACKUP[DS_VER_ENUM_BETA], EXE_BACKUP[DS_VER_ENUM_LATEST], PATCH_TO_LATEST[DS_VER_ENUM_BETA]);
                } catch (IOException ex) {
                    //Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
                    ui.printConsole(FAILED_FILE_PATCH_ERR + EXE_BACKUP[DS_VER_ENUM_LATEST]);
                    return false;
                }
            }else if(!latestBackup.exists() && ui.getDSVersion() == DS_VER_ENUM_DEBUG){
                if(debugBackup.exists() && debugBackup.length() != DS_SIZES[DS_VER_ENUM_DEBUG]){
                    ui.printConsole(DS_VERSION_REMOVING_INVALID_BACKUP + EXE_BACKUP[DS_VER_ENUM_DEBUG]);
                    if(!debugBackup.delete()){
                        // Failed to delete file
                        ui.printConsole(FAILED_FILE_DELETE_ERR + EXE_BACKUP[DS_VER_ENUM_DEBUG]);
                        return false;
                    }
                }
                if(!debugBackup.exists()){
                    try {
                        ui.printConsole(DS_VERSION_CREATING_BACKUP + EXE_BACKUP[DS_VER_ENUM_DEBUG]);
                        FileUtils.copyFile(gameExecutable, debugBackup);
                    } catch (IOException ioEx) {
                        // Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
                        ui.printConsole(FAILED_FILE_COPY_ERR + EXE_BACKUP[DS_VER_ENUM_DEBUG]);
                        return false;
                    }
                }
                try {
                    ui.printConsole(DS_VERSION_PATCHING[0] + EXE_BACKUP[DS_VER_ENUM_LATEST] + DS_VERSION_PATCHING[1] + EXE_BACKUP[DS_VER_ENUM_DEBUG]);
                    patchFile(EXE_BACKUP[DS_VER_ENUM_DEBUG], EXE_BACKUP[DS_VER_ENUM_LATEST], PATCH_TO_LATEST[DS_VER_ENUM_DEBUG]);
                } catch (IOException ex) {
                    //Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
                    ui.printConsole(FAILED_FILE_PATCH_ERR + EXE_BACKUP[DS_VER_ENUM_LATEST]);
                    return false;
                }
            }
            
            if(!latestBackup.exists() || latestBackup.length() != DS_SIZES[DS_VER_ENUM_LATEST]){
                return false;
            }
            
            if(betaBackup.exists() && betaBackup.length() != DS_SIZES[DS_VER_ENUM_BETA]){
                ui.printConsole(DS_VERSION_REMOVING_INVALID_BACKUP + EXE_BACKUP[DS_VER_ENUM_BETA]);
                if(!betaBackup.delete()){
                    // Failed to delete file
                    ui.printConsole(FAILED_FILE_DELETE_ERR + EXE_BACKUP[DS_VER_ENUM_BETA]);
                    return false;
                }
            }
            
            if(!betaBackup.exists()){
                try {
                    ui.printConsole(DS_VERSION_PATCHING[0] + EXE_BACKUP[DS_VER_ENUM_BETA] + DS_VERSION_PATCHING[1] + EXE_BACKUP[DS_VER_ENUM_LATEST]);
                    patchFile(EXE_BACKUP[DS_VER_ENUM_LATEST], EXE_BACKUP[DS_VER_ENUM_BETA], PATCH_FROM_LATEST[DS_VER_ENUM_BETA]);
                } catch (IOException ex) {
                    //Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
                    ui.printConsole(FAILED_FILE_PATCH_ERR + EXE_BACKUP[DS_VER_ENUM_BETA]);
                    return false;
                }
            }
            
            if(!betaBackup.exists() || betaBackup.length() != DS_SIZES[DS_VER_ENUM_BETA]){
                return false;
            }
            
            
            if(debugBackup.exists() && debugBackup.length() != DS_SIZES[DS_VER_ENUM_DEBUG]){
                ui.printConsole(DS_VERSION_REMOVING_INVALID_BACKUP + EXE_BACKUP[DS_VER_ENUM_DEBUG]);
                if(!debugBackup.delete()){
                    // Failed to delete file
                    ui.printConsole(FAILED_FILE_DELETE_ERR + EXE_BACKUP[DS_VER_ENUM_DEBUG]);
                    return false;
                }
            }
            
            if(!debugBackup.exists()){
                try {
                    ui.printConsole(DS_VERSION_PATCHING[0] + EXE_BACKUP[DS_VER_ENUM_DEBUG] + DS_VERSION_PATCHING[1] + EXE_BACKUP[DS_VER_ENUM_LATEST]);
                    patchFile(EXE_BACKUP[DS_VER_ENUM_LATEST], EXE_BACKUP[DS_VER_ENUM_DEBUG], PATCH_FROM_LATEST[DS_VER_ENUM_DEBUG]);
                } catch (IOException ex) {
                    //Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
                    ui.printConsole(FAILED_FILE_PATCH_ERR + EXE_BACKUP[DS_VER_ENUM_DEBUG]);
                    return false;
                }
            }
            
            if(!debugBackup.exists() || debugBackup.length() != DS_SIZES[DS_VER_ENUM_DEBUG]){
                return false;
            }
        }
        
        return true;
    }
    
    
    public void patchFile(String in, String out, String patch) throws IOException{
        String command = "cmd /c " + BSPATCH + " \"" + in + "\" \"" + out + "\" \"" + patch + "\"";
        Process patcher = Runtime.getRuntime().exec(command, null, new File(PATCHES_DIRECTORY));
        try {
            patcher.waitFor(5L, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            //Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
            ui.printConsole(SLEEP_INTERRUPTED);
        }
    }
    
    
    /*
     * Obtains the SHA-1 hash of the given file.
     * 
     * @return The SHA-1 hash of the given file, or empty string if an error occurred.
     */
    public static String getSHA1Hash(String file){
    	// The code in this method was found here:
    	//     https://www.mkyong.com/java/how-to-generate-a-file-checksum-value-in-java/
    	
    	StringBuffer hash = null;
    	
    	try{
    		MessageDigest md = MessageDigest.getInstance("SHA1");
    		FileInputStream fis = new FileInputStream(file);
    		
    		byte[] dataBytes = new byte[1024];

            int nread = 0;

            while ((nread = fis.read(dataBytes)) != -1) {
              md.update(dataBytes, 0, nread);
            };
            
            byte[] mdbytes = md.digest();

            //convert the byte to hex format
            hash = new StringBuffer("");
            for (int i = 0; i < mdbytes.length; i++) {
            	hash.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            fis.close();
    	}catch(FileNotFoundException fnfEx){
    		MAIN_UI.printConsole(SHA1_FNF_ERROR + file);
    	}catch(NoSuchAlgorithmException nsaEx){
    		MAIN_UI.printConsole(INVALID_HASH_ALGORITHM + "(\"" + "SHA1" + "\")");
    	} catch (IOException ioEx) {
    		MAIN_UI.printConsole(SHA1_IOE_ERROR + file);
		}
    	
    	if(hash != null){
    		return hash.toString();
    	}else{
    		return "";
    	}
    }
    
    
    /*
	 * Delete a folder, along with its entire subtree (files and folders)
	 * 
	 * @return true if no errors occurred; otherwise return false
	 */
    public static boolean deleteFileTree(File root){
		boolean error = false;
		Collection<File> files = FileUtils.listFiles(root, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		
		for(File file : files){
			if(file.exists()){
				try {
					file.delete();
					// Delete leftover folders, if empty
					String parent = new File(file.getParent()).getAbsolutePath();
					while(parent != null && parent.indexOf("\\") > -1 && parent.length() >= root.getAbsolutePath().length()){
						parent = parent.substring(0, parent.lastIndexOf("\\"));
						File folder = new File(MAIN_UI.getDataFolder().getPath() + "\\" + parent);
						
						if(folder.exists() && folder.isDirectory() && FileUtils.listFiles(folder, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE).size() == 0){
							try{
								folder.delete();
							}catch (SecurityException ex){
								// Unable to delete folder
								error = true;
								// @TODO: Log event
							}
						}
					}
				} catch (SecurityException ex) {
					// Unable to delete file
					error = true;
					// @TODO: Log event
				}
			}
			
			if(root.exists()){
				try{
					Collection<File> dirList;
					while((dirList = FileUtils.listFilesAndDirs(root, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)).size() > 0){
						boolean stopDeleting = false;
						for(File d : dirList){
							if(d.isDirectory()){
								Collection<File> subDirList = FileUtils.listFilesAndDirs(d, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
								d.delete();
								if(subDirList.size() == 0 && d.exists()){
									stopDeleting = true;
									break;
								}
							}else{
								d.delete();
								if(d.exists()){
									stopDeleting = true;
									break;
								}
							}
						}
						if(stopDeleting){
							break;
						}
					}
					root.delete();
				}catch (SecurityException ex){
					// Unable to delete root folder
					error = true;
					// @TODO: Log event
				}catch (IllegalArgumentException iaEx){
					// Root folder was deleted already but for some reason there was an attempt to delete it again
				}
			}
		}
		if(!error){
			// Success, no errors encountered
			// @TODO: Log event
		}else{
			// Errors were encountered
			// @TODO: Log event
		}
		
		return !error;
	}
    
    
    /*
	 * Get various settings from the program configuration file
	 */
	public static void loadStartupConfig(){
		MAIN_UI.printConsole(LOADING_PROGRAM_CONFIG);
		
		File cfgFile = new File(CONFIG_FILE);
		if(!cfgFile.exists()){
			try {
				if(cfgFile.createNewFile()){
					// Config file was missing, but a new one was made
					// @TODO: Log event
				}else{
					throw new IOException();
				}
			} catch (IOException e) {
				// Config file is missing and couldn't be created
				// @TODO: Log event
			}
		}else if(cfgFile.isDirectory()){
			// This should never happen
			// @TODO: Log event
		}else{
			// Config file was found
			
			Scanner fileReader;
			try {
				fileReader = new Scanner(DSFixFileController.readTextFile(cfgFile.getPath()));
				
				// Read config file line by line
				while(fileReader.hasNextLine()){
					String line = fileReader.nextLine().trim();
					
					if(isConfigKeyValue(line, TEX_MOD_STORAGE_DIR_KEY)){
						String newStorageDirVal = getConfigKeyValue(line, TEX_MOD_STORAGE_DIR_KEY);
						File newStorageDir = new File(newStorageDirVal);
						if(newStorageDirVal.length() > 0 && DsTextureMod.isValidStorageDir(newStorageDir)){
							// Add the new texture mod storage folder to the current list
							DsTextureMod.STORAGE_DIRS.add(newStorageDir);
							MAIN_UI.printConsole(CONFIG_ENTRY_PREFIX.toUpperCase() + CONFIG_TEX_MOD_DIR_OK + ": " + newStorageDir);
						}else{
							// Not a valid texture mod storage folder
							if(newStorageDirVal.length() > 0){
								MAIN_UI.printConsole(CONFIG_ENTRY_PREFIX.toUpperCase() + CONFIG_TEX_MOD_DIR_FAIL + ": " + newStorageDir);
							}
						}
					}else if(isConfigKeyValue(line, LOG_FILE_KEY)){
						String writeLogVal = getConfigKeyValue(line, LOG_FILE_KEY);
						if(writeLogVal.length() > 0 && NumberUtils.isParsable(writeLogVal) && Integer.parseInt(writeLogVal) == 1){
							// Enable console log file writing
							boolean oldVal = writeLogToFile;
							writeLogToFile = true;
							
							if(!oldVal){
								MAIN_UI.printConsole(CONFIG_ENTRY_PREFIX.toUpperCase() + CONFIG_LOG_FILE_ENABLE);
								// Write current log to log file
								try {
									DSFixFileController.writeTextFile(LOG_FILE, DSCfgMainUI.consoleLog, true);
								} catch (IOException e) {
									
								}
							}
						}else if(writeLogToFile && writeLogVal.length() > 0 && NumberUtils.isParsable(writeLogVal) && Integer.parseInt(writeLogVal) == 0){
							// Disable console log file writing
							writeLogToFile = false;
							MAIN_UI.printConsole(CONFIG_ENTRY_PREFIX.toUpperCase() + CONFIG_LOG_FILE_DISABLE);
							DSFixFileController.clearLogFile();
						}
					}else if(isConfigKeyValue(line, SHOW_CONSOLE_KEY)){
						String showConsoleStrVal = getConfigKeyValue(line, SHOW_CONSOLE_KEY);
						if(showConsoleStrVal.length() > 0 && NumberUtils.isParsable(showConsoleStrVal)){
							int showConsoleVal = Integer.parseInt(showConsoleStrVal);
							switch(showConsoleVal){
								case 0: // Hide console
									if(showConsoleBar || showConsoleWindow){
										MAIN_UI.printConsole(CONFIG_ENTRY_PREFIX.toUpperCase() + CONFIG_SHOW_CONSOLE[showConsoleVal]);
									}
									showConsoleBar = false;
					                showConsoleWindow = false;
									break;
								case 1: // Show console bar
									if(!showConsoleBar){
										MAIN_UI.printConsole(CONFIG_ENTRY_PREFIX.toUpperCase() + CONFIG_SHOW_CONSOLE[showConsoleVal]);
									}
									showConsoleBar = true;
									showConsoleWindow = false;
									break;
								case 2: // Show console window
									if(!showConsoleWindow){
										MAIN_UI.printConsole(CONFIG_ENTRY_PREFIX.toUpperCase() + CONFIG_SHOW_CONSOLE[showConsoleVal]);
									}
									showConsoleBar = false;
									showConsoleWindow = true;
									break;
								default:
									break;
							}
						}
					}else if(isConfigKeyValue(line, WINDOW_WIDTH_KEY)){
						String widthStr = getConfigKeyValue(line, WINDOW_WIDTH_KEY);
						if(widthStr.length() > 0 && NumberUtils.isParsable(widthStr)){
							double width = Double.parseDouble(widthStr);
							if(width != DSCfgMainUI.userWindowWidth && width > 0.0){
								DSCfgMainUI.userWindowWidth = width;
								MAIN_UI.printConsole(CONFIG_ENTRY_PREFIX.toUpperCase() + CONFIG_WINDOW_WIDTH + width + ".");
							}
						}
					}else if(isConfigKeyValue(line, WINDOW_HEIGHT_KEY)){
						String heightStr = getConfigKeyValue(line, WINDOW_HEIGHT_KEY);
						if(heightStr.length() > 0 && NumberUtils.isParsable(heightStr)){
							double height = Double.parseDouble(heightStr);
							if(height != DSCfgMainUI.userWindowHeight && height > 0.0){
								DSCfgMainUI.userWindowHeight = height;
								MAIN_UI.printConsole(CONFIG_ENTRY_PREFIX.toUpperCase() + CONFIG_WINDOW_HEIGHT + height + ".");
							}
						}
					}else if(isConfigKeyValue(line, WINDOW_X_OFFSET_KEY)){
						String xOffsetStr = getConfigKeyValue(line, WINDOW_X_OFFSET_KEY);
						if(xOffsetStr.length() > 0 && NumberUtils.isParsable(xOffsetStr)){
							double xOffset = Double.parseDouble(xOffsetStr);
							if(xOffset != DSCfgMainUI.windowXOffset){
								DSCfgMainUI.windowXOffset = xOffset;
								MAIN_UI.printConsole(CONFIG_ENTRY_PREFIX.toUpperCase() + CONFIG_WINDOW_X_OFFSET + xOffset + ".");
							}
						}
					}else if(isConfigKeyValue(line, WINDOW_Y_OFFSET_KEY)){
						String yOffsetStr = getConfigKeyValue(line, WINDOW_Y_OFFSET_KEY);
						if(yOffsetStr.length() > 0 && NumberUtils.isParsable(yOffsetStr)){
							double yOffset = Double.parseDouble(yOffsetStr);
							if(yOffset != DSCfgMainUI.windowYOffset){
								DSCfgMainUI.windowYOffset = yOffset;
								MAIN_UI.printConsole(CONFIG_ENTRY_PREFIX.toUpperCase() + CONFIG_WINDOW_Y_OFFSET + yOffset + ".");
							}
						}
					}else if(isConfigKeyValue(line, CONSOLE_X_OFFSET_KEY)){
						String xOffsetStr = getConfigKeyValue(line, CONSOLE_X_OFFSET_KEY);
						if(xOffsetStr.length() > 0 && NumberUtils.isParsable(xOffsetStr)){
							double xOffset = Double.parseDouble(xOffsetStr);
							if(xOffset != DSCfgMainUI.consoleWindowXOffset){
								DSCfgMainUI.consoleWindowXOffset = xOffset;
								MAIN_UI.printConsole(CONFIG_ENTRY_PREFIX.toUpperCase() + CONFIG_CONSOLE_X_OFFSET + xOffset + ".");
							}
						}
					}else if(isConfigKeyValue(line, CONSOLE_Y_OFFSET_KEY)){
						String yOffsetStr = getConfigKeyValue(line, CONSOLE_Y_OFFSET_KEY);
						if(yOffsetStr.length() > 0 && NumberUtils.isParsable(yOffsetStr)){
							double yOffset = Double.parseDouble(yOffsetStr);
							if(yOffset != DSCfgMainUI.consoleWindowYOffset){
								DSCfgMainUI.consoleWindowYOffset = yOffset;
								MAIN_UI.printConsole(CONFIG_ENTRY_PREFIX.toUpperCase() + CONFIG_CONSOLE_Y_OFFSET + yOffset + ".");
							}
						}
					}
				}
				fileReader.close();
			} catch (FileNotFoundException e) {
				// Error from initializing Scanner
				MAIN_UI.printConsole(ERROR + ": " + LOADING_PROGRAM_CONFIG_FAIL);
			}
			
		}
	}
	
	/*
	 * Write current settings to the program configuration file
	 */
	public static void writeStartupConfig(){
		String newCfgFile = "";
		
		// Main window dimensions
		if(DSCfgMainUI.userWindowWidth > 0.0)
			newCfgFile += WINDOW_WIDTH_KEY + DSCfgMainUI.userWindowWidth + String.format("%n");
		if(DSCfgMainUI.userWindowHeight > 0.0)
			newCfgFile += WINDOW_HEIGHT_KEY + DSCfgMainUI.userWindowHeight + String.format("%n");
		
		// Main window offsets
		if(DSCfgMainUI.windowXOffset != 0.0)
			newCfgFile += WINDOW_X_OFFSET_KEY + DSCfgMainUI.windowXOffset + String.format("%n");
		if(DSCfgMainUI.windowYOffset != 0.0)
			newCfgFile += WINDOW_Y_OFFSET_KEY + DSCfgMainUI.windowYOffset + String.format("%n");
		
		// Writing console log to file
		if(writeLogToFile)
			newCfgFile += LOG_FILE_KEY + 1 + String.format("%n");
		else
			newCfgFile += LOG_FILE_KEY + 0 + String.format("%n");
		
		// Show console output elements
		if(!showConsoleBar && !showConsoleWindow){
			newCfgFile += SHOW_CONSOLE_KEY + 0 + String.format("%n");
		}else if(!showConsoleBar && showConsoleWindow){
			newCfgFile += SHOW_CONSOLE_KEY + 2 + String.format("%n");
		}else{
			newCfgFile += SHOW_CONSOLE_KEY + 1 + String.format("%n");
		}
		
		// Console window offsets
		if(DSCfgMainUI.consoleWindowXOffset != 0.0)
			newCfgFile += CONSOLE_X_OFFSET_KEY + DSCfgMainUI.consoleWindowXOffset + String.format("%n");
		if(DSCfgMainUI.consoleWindowYOffset != 0.0)
			newCfgFile += CONSOLE_Y_OFFSET_KEY + DSCfgMainUI.consoleWindowYOffset + String.format("%n");
		
		// Additional texture mod directories
		for(File dir : DsTextureMod.STORAGE_DIRS){
			boolean defaultDir = false;
			for(String defDir : TEX_MOD_STORAGE_DIR_DEFAULTS){
				if(dir.getAbsolutePath().equals(new File(defDir).getAbsolutePath())){
					defaultDir = true;
					break;
				}
			}
			if(!defaultDir){
				newCfgFile += TEX_MOD_STORAGE_DIR_KEY + dir.getPath() + String.format("%n");
			}
		}
		
		// Write the config file
		try {
			DSFixFileController.writeTextFile(CONFIG_FILE, newCfgFile, true);
		} catch (IOException e) {
			MAIN_UI.printConsole(ERROR + ": " + WRITE_PROGRAM_CONFIG_FAIL);
		}
	}
	
	/*
	 * Checks if the given line from a config file starts with the given key value
	 */
	public static boolean isConfigKeyValue(String line, String key){
		return (line.length() >= key.length() && line.substring(0, key.length()).toUpperCase().equals(key.toUpperCase()));
	}
	
	/*
	 * Gets the configuration setting value from the line consisting of a config key and a config value
	 */
	public static String getConfigKeyValue(String line, String key){
		return line.substring(key.length()).trim();
	}
	
	// Clear the log file
	public static void clearLogFile(){
		FileWriter fw;
		try {
			fw = new FileWriter(LOG_FILE, false);
			fw.write("");
			fw.close();
		} catch (IOException e) {
			MAIN_UI.printConsole(FAIL_CLEAR_LOG_ERR);
		}
	}
	
	
	public static boolean extractZipFile(String archiveFile, String destinationFolder){
		// Source: http://www.avajava.com/tutorials/lessons/how-do-i-unzip-the-contents-of-a-zip-file.html
		if(destinationFolder.length() == 0){
			destinationFolder = new File(new File(archiveFile).getParent()).getAbsolutePath();
		}
		if(!new File(destinationFolder).exists()){
			if(!new File(destinationFolder).mkdirs()){
				return false;
			}
		}
		
		try {
            // Open the zip file
            ZipFile zipFile = new ZipFile(archiveFile);
            Enumeration<?> enu = zipFile.entries();
            while (enu.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) enu.nextElement();

                String name = zipEntry.getName();
                //long size = zipEntry.getSize();
                //long compressedSize = zipEntry.getCompressedSize();
                //System.out.printf("name: %-20s | size: %6d | compressed size: %6d\n", 
                //        name, size, compressedSize);

                // Do we need to create a directory ?
                File file = new File(name);
                if (name.endsWith("/")) {
                    new File(new File(destinationFolder).getAbsolutePath() + "\\" + file.getPath()).mkdirs();
                    continue;
                }

                File parent = file.getParentFile();
                if (parent != null) {
                	new File(new File(destinationFolder).getAbsolutePath() + "\\" + parent.getPath()).mkdirs();
                }

                // Extract the file
                InputStream is = zipFile.getInputStream(zipEntry);
                FileOutputStream fos = new FileOutputStream(new File(destinationFolder).getAbsolutePath() + "\\" + file.getPath());
                byte[] bytes = new byte[1024];
                int length;
                while ((length = is.read(bytes)) >= 0) {
                    fos.write(bytes, 0, length);
                }
                is.close();
                fos.close();

            }
            zipFile.close();
        } catch (IOException e) {
            return false;
        }
		return true;
	}
}
