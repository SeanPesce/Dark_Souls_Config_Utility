/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.FileIO;

import static dscfgutil.DSCfgUtilConstants.AA_SETTING;
import static dscfgutil.DSCfgUtilConstants.APPDATA;
import static dscfgutil.DSCfgUtilConstants.APPDATA_INI;
import static dscfgutil.DSCfgUtilConstants.APPLY_DSPW_FPS_FIX;
import static dscfgutil.DSCfgUtilConstants.BUTTONS_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.COPYING;
import static dscfgutil.DSCfgUtilConstants.CREATING_INI;
import static dscfgutil.DSCfgUtilConstants.DATA_FOLDER;
import static dscfgutil.DSCfgUtilConstants.DIALOG_BUTTON_TEXTS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_APPLY_DSM_CHAIN;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_APPLY_NO_DLL_CHAIN;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_DELETE_ERRORS_PROMPT;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_DISABLE_AA;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_DSM_FILE_COPY_ERR;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_DSPW_FILE_COPY_ERR;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_FILE_COPY_ERR;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_NO_DS_EXE;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_APPLY_CHANGES;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_DISABLE_AA;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_EXPORT_DSF;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_EXPORT_INI;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_IMPORT_INI;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_INSTALL_ERR;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_NO_DS_EXE;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_OPEN_FOLDER_PROMPT;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_PICK_DIR;
import static dscfgutil.DSCfgUtilConstants.DSF_FILES;
import static dscfgutil.DSCfgUtilConstants.DSF_FILE_NOT_FOUND;
import static dscfgutil.DSCfgUtilConstants.DSF_FOLDER;
import static dscfgutil.DSCfgUtilConstants.DSF_INSTALLED_ERRORS;
import static dscfgutil.DSCfgUtilConstants.DSF_INSTALLED_SUCCESS;
import static dscfgutil.DSCfgUtilConstants.DSF_TEX_OVERRIDE_FOLDER;
import static dscfgutil.DSCfgUtilConstants.DSF_UNINSTALLED_ERRORS;
import static dscfgutil.DSCfgUtilConstants.DSF_UNINSTALLED_SUCCESS;
import static dscfgutil.DSCfgUtilConstants.DSM_FILES;
import static dscfgutil.DSCfgUtilConstants.DSM_FOLDER;
import static dscfgutil.DSCfgUtilConstants.DSM_INSTALLED_ERRORS;
import static dscfgutil.DSCfgUtilConstants.DSM_INSTALLED_SUCCESS;
import static dscfgutil.DSCfgUtilConstants.DSM_UNINSTALLED_ERRORS;
import static dscfgutil.DSCfgUtilConstants.DSM_UNINSTALLED_SUCCESS;
import static dscfgutil.DSCfgUtilConstants.DSPW_FILES;
import static dscfgutil.DSCfgUtilConstants.DSPW_FOLDER;
import static dscfgutil.DSCfgUtilConstants.DSPW_INSTALLED_ERRORS;
import static dscfgutil.DSCfgUtilConstants.DSPW_INSTALLED_SUCCESS;
import static dscfgutil.DSCfgUtilConstants.DSPW_UNINSTALLED_ERRORS;
import static dscfgutil.DSCfgUtilConstants.DSPW_UNINSTALLED_SUCCESS;
import static dscfgutil.DSCfgUtilConstants.DS_EXE;
import static dscfgutil.DSCfgUtilConstants.DS_INI;
import static dscfgutil.DSCfgUtilConstants.FAILED_FILE_COPY_ERR;
import static dscfgutil.DSCfgUtilConstants.FAILED_FILE_DELETE_ERR;
import static dscfgutil.DSCfgUtilConstants.FAILED_OPEN_FOLDER_ERR;
import static dscfgutil.DSCfgUtilConstants.FILES_DIR;
import static dscfgutil.DSCfgUtilConstants.FILE_DELETED;
import static dscfgutil.DSCfgUtilConstants.FILE_WRITE_FAILED;
import static dscfgutil.DSCfgUtilConstants.FOUND_APPDATA;
import static dscfgutil.DSCfgUtilConstants.FPS_FIX_FILES;
import static dscfgutil.DSCfgUtilConstants.FPS_FIX_FOLDER;
import static dscfgutil.DSCfgUtilConstants.INI_EXT_FILTER;
import static dscfgutil.DSCfgUtilConstants.INSTALLING_DSF;
import static dscfgutil.DSCfgUtilConstants.INSTALLING_DSM;
import static dscfgutil.DSCfgUtilConstants.INSTALLING_DSPW;
import static dscfgutil.DSCfgUtilConstants.IOEX_FILE_WRITER;
import static dscfgutil.DSCfgUtilConstants.NONE;
import static dscfgutil.DSCfgUtilConstants.RENAMING_FILE;
import static dscfgutil.DSCfgUtilConstants.SEE_CONSOLE;
import static dscfgutil.DSCfgUtilConstants.TEMPLATES_DIR;
import static dscfgutil.DSCfgUtilConstants.TEXTURE_MODS_FOLDER;
import static dscfgutil.DSCfgUtilConstants.TEX_MOD_INSTALLED_SUCCESS;
import static dscfgutil.DSCfgUtilConstants.TURNED_OFF_AA;
import static dscfgutil.DSCfgUtilConstants.TURNING_OFF_AA;
import static dscfgutil.DSCfgUtilConstants.UNABLE_TO_FIND_APPDATA;
import static dscfgutil.DSCfgUtilConstants.UNABLE_TO_FIND_DS_INI;
import static dscfgutil.DSCfgUtilConstants.UNABLE_TO_READ_DS_INI;
import static dscfgutil.DSCfgUtilConstants.UNINSTALLING_DSF;
import static dscfgutil.DSCfgUtilConstants.UNINSTALLING_DSM;
import static dscfgutil.DSCfgUtilConstants.UNINSTALLING_DSPW;
import static dscfgutil.DSCfgUtilConstants.WRITING_FILE;
import dscfgutil.dialog.AlertDialog;
import dscfgutil.dialog.ContinueDialog;
import dscfgutil.view.DSCfgMainUI;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.AccessDeniedException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javax.imageio.IIOException;
import org.apache.commons.io.FileUtils;

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
        
        for(int i = DSF_FILES.length - 1; i >= 0; i--){
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
                throw new IIOException("Could not delete pre-existing file: " +
                    filePath);
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
}
