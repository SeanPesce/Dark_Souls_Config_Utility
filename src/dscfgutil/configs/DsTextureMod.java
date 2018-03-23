// Author: Sean Pesce

package dscfgutil.configs;

import static dscfgutil.DSCfgUtilConstants.WAIT_VERIFY_FOLDER;
import static dscfgutil.DSCfgUtilConstants.COPY_DIAG_CONFIRM_TITLE;
import static dscfgutil.DSCfgUtilConstants.DELETE_TEX_MOD_SRC_DIALOG;
import static dscfgutil.DSCfgUtilConstants.DELETE_TEX_MOD_SRC_DIALOG_TT;
import static dscfgutil.DSCfgUtilConstants.DELETE_TEX_MOD_SRC_DIALOG_ZIP;
import static dscfgutil.DSCfgUtilConstants.DELETE_TEX_MOD_SRC_DIALOG_ZIP_TT;
import static dscfgutil.DSCfgUtilConstants.DELETE_TEX_PACK_SRC_DIALOG_TT;
import static dscfgutil.DSCfgUtilConstants.DELETE_TEX_PACK_SRC_DIALOG_ZIP_TT;
import static dscfgutil.DSCfgUtilConstants.DIALOG_BUTTON_TEXTS;
import static dscfgutil.DSCfgUtilConstants.DUPLICATE_MOD_WARN;
import static dscfgutil.DSCfgUtilConstants.ERROR;
import static dscfgutil.DSCfgUtilConstants.FAIL;
import static dscfgutil.DSCfgUtilConstants.FAILED_FILE_COPY_ERR;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_MOD_CHECK_DIR_SUCCESS_MESSAGE;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_MOD_SUCCESS_MESSAGE;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_PACK_CONFIRM_DIAG_MSG;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_PACK_NO_MODS_DIAG_MSG;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_PACK_NO_MODS_DIAG_TITLE;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_PACK_DONE;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_PACK_START;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_PACK_DONE_TITLE;
import static dscfgutil.DSCfgUtilConstants.LOAD_TXM_CANCEL;
import static dscfgutil.DSCfgUtilConstants.LOAD_TXM_DEL_OLD_EXTRACT;
import static dscfgutil.DSCfgUtilConstants.LOAD_TXM_DIAG_CONFIRM_MSG;
import static dscfgutil.DSCfgUtilConstants.LOAD_TXM_DIAG_INVALID_TITLE;
import static dscfgutil.DSCfgUtilConstants.LOAD_TXM_EXTRACT_DONE;
import static dscfgutil.DSCfgUtilConstants.LOAD_TXM_EXTRACT_FAIL;
import static dscfgutil.DSCfgUtilConstants.LOAD_TXM_EXTRACT_START;
import static dscfgutil.DSCfgUtilConstants.LOAD_TXM_REMOVE_PARTIAL;
import static dscfgutil.DSCfgUtilConstants.LOAD_TXM_REMOVE_PARTIAL_DONE;
import static dscfgutil.DSCfgUtilConstants.LOAD_TXM_REMOVE_PARTIAL_FAIL;
import static dscfgutil.DSCfgUtilConstants.LOAD_TXM_REMOVE_PARTIAL_SUCCESS;
import static dscfgutil.DSCfgUtilConstants.LOAD_TXM_START;
import static dscfgutil.DSCfgUtilConstants.LOAD_TXM_DIAG_INVALID_MSGS;
import static dscfgutil.DSCfgUtilConstants.LOADING_TEX_MOD_DIR_COUNT;
import static dscfgutil.DSCfgUtilConstants.MAIN_UI;
import static dscfgutil.DSCfgUtilConstants.NEW;
import static dscfgutil.DSCfgUtilConstants.PACK;
import static dscfgutil.DSCfgUtilConstants.PROGRAM_SHORTEST;
import static dscfgutil.DSCfgUtilConstants.SEE_CONSOLE;
import static dscfgutil.DSCfgUtilConstants.SUCCESS;
import static dscfgutil.DSCfgUtilConstants.TEX_MOD_STORAGE_DIR_DEFAULTS;
import static dscfgutil.DSCfgUtilConstants.TEXTURE_MOD;
import static dscfgutil.DSCfgUtilConstants.ZIP_EXT_FILTER;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import dscfgutil.FileIO.DSFixFileController;
import dscfgutil.dialog.AlertDialog;
import dscfgutil.dialog.ContinueDialog;
import dscfgutil.view.DsTexModPane;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tooltip;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class DsTextureMod extends DsMod {

	// The folder where DSFix texture mods are installed (relative to the Dark Souls DATA folder)
	public static final String DSFIX_TEXTURES_FOLDER = "dsfix\\tex_override";

	// List of valid texture mod file types
	public static final String[] TEXTURE_FILE_EXTENSIONS = { ".png", ".dds" };

	// Maximum number of files a texture mod directory can hold (to avoid copying of large numbers of files)
	public static final int MAX_ALLOWED_FILES = 256;

	// List of directories where texture mods can be stored
	public static ArrayList<File> STORAGE_DIRS = new ArrayList<File>();

	// Index of the default texture mod storage directory
	public static int DEFAULT_STORAGE_DIR = 0;

	// Stores all texture mod objects
	public static ArrayList<DsTextureMod> texMods = null;

	// Pane for this mod to be displayed and configured through the GUI
	public DsTexModPane pane;

	// Constructor
	public DsTextureMod(String mod_folder) throws FileNotFoundException, IOException {
		super(mod_folder); // Call DsMod constructor

		// Set installation folder to DSFix texture override folder
		this.installSubDir = DSFIX_TEXTURES_FOLDER;

		this.pane = new DsTexModPane(this);

		if(DsTextureMod.texMods != null){
			// Check if this mod already exists
			String dup = null;
			for(DsTextureMod mod : DsTextureMod.texMods){
				if(this.hasSameFiles(mod)){
					dup = mod.title;
					break;
				}
			}

			if(dup == null){
				DsTextureMod.texMods.add(this);
			}else{
				// This mod already exists in the list
				MAIN_UI.printConsole(DUPLICATE_MOD_WARN + "(\"" + this.title + "\" & \"" + dup + "\")");
			}
		}
	}


	// Install the mod by copying all files into the Dark Souls DATA folder
	public void install(){

		super.install();

		this.pane.checkInstalled();
	}


	// Uninstall the mod by deleting all mod files from the Dark Souls DATA folder
	public void uninstall(){

		super.uninstall();

		this.pane.checkInstalled();
	}



	// Delete the texture mod files from the stored directory
	public boolean delete(){

		boolean success = super.delete();

		// Remove this texture mod object from the global list of texture mods
		DsTextureMod.texMods.remove(this);

		return success;
	}


	// Check if another DsTextureMod has the exact same files
	public boolean hasSameFiles(DsTextureMod mod){
		if(mod == null)
			return false;

		if(this == mod)
			return true;

		if(this.files.size() != mod.files.size()
			 || this.fileSizes.length != mod.fileSizes.length
			 || this.hashes.size() != mod.hashes.size()){
			return false;
		}

		for(int i = 0; i < this.fileCount(); i++){
			if(!this.files.get(i).equals(mod.files.get(i))
					 || this.fileSizes[i] != mod.fileSizes[i]
					 || !this.hashes.get(i).equals(mod.hashes.get(i))){
				return false;
			}
		}

		return true;
	}


	// Initialize default mod storage directories
	public static void initDefaultStorageDirs(){
		for(String d : TEX_MOD_STORAGE_DIR_DEFAULTS){
			File dir = new File(d);
			boolean addToList = true;
			if(!dir.exists()){
				if(dir.mkdir()){
					// Successfully created storage folder
					// @TODO: Log event
				}else{
					// Failed to create storage folder
					addToList = false;
					// @TODO: Log event
				}
			}else if(!dir.isDirectory()){
				// Path leads to a file, not a folder
				addToList = false;
				// @TODO: Log event
			}

			if(addToList){
				DsTextureMod.STORAGE_DIRS.add(dir);
			}
		}
	}


	// Check if a directory should be added to the list of texture mod storage directories
	public static boolean isValidStorageDir(File dir){
		if(dir.getAbsolutePath().length() <= 3){
			// Can't use drive root (such as C:\)
			return false;
		}else if(!dir.exists()){
			if(!dir.mkdir()){
				return false;
			}
		}else if(!dir.isDirectory()){
			return false;
		}

		for(File existingStorageDir : DsTextureMod.STORAGE_DIRS){
			// Can't use a subdirectory of a knwon storage directory
			if(dir.getAbsolutePath().length() >= existingStorageDir.getAbsolutePath().length() && dir.getAbsolutePath().startsWith(existingStorageDir.getAbsolutePath())){
				return false;
			}
		}

		return true;
	}


	// Initialize the list of texture mods stored by the Config Utility
	public static int initModList(){
		if (MAIN_UI.getDataFolder() != null) {
			String dirCountMsg = LOADING_TEX_MOD_DIR_COUNT[0] + DsTextureMod.STORAGE_DIRS.size() + LOADING_TEX_MOD_DIR_COUNT[1];
			if(DsTextureMod.STORAGE_DIRS.size() == 1)
				dirCountMsg += LOADING_TEX_MOD_DIR_COUNT[2] + "...";
			else
				dirCountMsg += LOADING_TEX_MOD_DIR_COUNT[3] + "...";
			MAIN_UI.printConsole(dirCountMsg);
		}

		int modsLoaded = 0;
		if(DsTextureMod.texMods != null){
			return modsLoaded;
		}

		ArrayList<DsTextureMod> list = new ArrayList<DsTextureMod>();

		for(File storageFolder : DsTextureMod.STORAGE_DIRS){
			// Get list of files and directories in the texture mods folder:
			String[] folder_list = storageFolder.list(new FilenameFilter() {
				  @Override
				  public boolean accept(File current, String name) {
				    return new File(current, name).isDirectory();
				  }
				});

			for(String f : folder_list){
				//ui.printConsole(f);
				try {
					String [] fl = new File(storageFolder.getPath() + "\\" + f).list(new FilenameFilter() {
						  @Override
						  public boolean accept(File current, String name) {
						    return !(new File(current, name).isDirectory()); // Only get top-level files
						  }
						});
					if(fl.length > 0){
						DsTextureMod tm = new DsTextureMod(storageFolder.getPath() + "\\" + f);
						// Make sure mod isn't a duplicate
						boolean dupMod = false;
						for(DsTextureMod dstm : list){
							if(tm.hasSameFiles(dstm)){
								dupMod = true;
								MAIN_UI.printConsole(DUPLICATE_MOD_WARN + "(\"" + tm.title + "\" & \"" + dstm.title + "\")");
								break;
							}
						}
						if(!dupMod){
							list.add(tm);
							modsLoaded++;
						}
					}
				} catch (IOException e) {
					// Ignore error
				}
			}
		}

		DsTextureMod.texMods = list;
		return modsLoaded;
	}


	/*
	 * Attempts to load a single new texture mod into the program.
	 *
	 * @return true if successful, false otherwise.
	 */
	public static boolean loadNewMod(File newModFolder){
		boolean errorsOccurred = false;
		String folderName = newModFolder.getName();
		// Check if valid texture mod directory
		ArrayList<File> fileList = new ArrayList<File>();
		if(DsTextureMod.canLoadModFromFolder(newModFolder.getAbsolutePath(), true, fileList)){
			// Copy mod folder
			MAIN_UI.printConsole(LOAD_TXM_START);
			for(File f : fileList){
				String fileName = f.getAbsolutePath().substring(newModFolder.getAbsolutePath().length());
				try {
					FileUtils.copyFile(f, new File(STORAGE_DIRS.get(DEFAULT_STORAGE_DIR).getPath() + "\\" + folderName + "\\" + fileName));
				} catch (IOException e) {
					// Failed to copy file
					errorsOccurred = true;
					MAIN_UI.printConsole(ERROR + ": " + FAILED_FILE_COPY_ERR + f.getName());
					break;
				}
			}

			if(!errorsOccurred){
				// Files were successfully copied without issue
				try {
					int sizeBefore = DsTextureMod.texMods.size();
					new DsTextureMod(STORAGE_DIRS.get(DEFAULT_STORAGE_DIR).getPath() + "\\" + folderName);
					if(sizeBefore >= DsTextureMod.texMods.size()){
						// Duplicate mod
						throw new IOException();
					}
				} catch (IOException e) {
					// Failed to create texture mod object
					errorsOccurred = true;
				}
			}
		}else{
			// Not a valid texture mod folder
			return false;
		}

		if(errorsOccurred){
			// Try to delete the partially-copied mod
			MAIN_UI.printConsole(FAIL.toUpperCase() + ": " + LOAD_TXM_REMOVE_PARTIAL);
			if(DSFixFileController.deleteFileTree(new File(STORAGE_DIRS.get(DEFAULT_STORAGE_DIR).getPath() + "\\" + folderName))){
				// Successfully deleted the partially-loaded mod
				MAIN_UI.printConsole(LOAD_TXM_REMOVE_PARTIAL_SUCCESS);
			}else{
				// Errors occurred when deleting partially-loaded mod
				MAIN_UI.printConsole(LOAD_TXM_REMOVE_PARTIAL_FAIL + " (" + STORAGE_DIRS.get(DEFAULT_STORAGE_DIR).getPath() + "\\" + folderName + ")");
			}
		}else{
			// Mod was successfully copied and loaded as an object without issue
			DsTextureMod newMod = DsTextureMod.texMods.get(DsTextureMod.texMods.size() - 1);
			String sucMsg = SUCCESS.toUpperCase() + ": " + LOAD_TEX_MOD_SUCCESS_MESSAGE + " (" + newMod.title;
			if(newMod.version.length() > 0)
				sucMsg += " " + newMod.version;
			sucMsg += ")";
			MAIN_UI.printConsole(sucMsg);
		}
		return !errorsOccurred;
	}


	/*
	 * Attempts to load a single new texture mod into the program through the GUI
	 *
	 * @return true if successful, false otherwise.
	 */
	public static boolean loadNewModFromGUI(boolean fromCompressedFile){
		boolean errorsOccurred = false;
		File source = null;
		File newModFolder = null;

		if(!fromCompressedFile){
			// Load normally from a folder
			DirectoryChooser dirPicker = new DirectoryChooser();
			dirPicker.setTitle(NEW + " " + TEXTURE_MOD.toLowerCase());
			newModFolder = dirPicker.showDialog(MAIN_UI.getStage());
			if(newModFolder == null){
				MAIN_UI.printConsole(LOAD_TXM_CANCEL);
    			return false;
			}
			source = newModFolder;
		}else{
			// Load from a zip file
			FileChooser filePicker = new FileChooser();
			filePicker.setTitle(NEW + " " + TEXTURE_MOD.toLowerCase());
	        FileChooser.ExtensionFilter zipFilter = new FileChooser.ExtensionFilter(ZIP_EXT_FILTER[0], ZIP_EXT_FILTER[1]);
	        filePicker.getExtensionFilters().add(zipFilter);
	        File archiveFile = filePicker.showOpenDialog(MAIN_UI.getStage());
	        if(archiveFile == null){
				MAIN_UI.printConsole(LOAD_TXM_CANCEL);
    			return false;
			}
	        source = archiveFile;
	        newModFolder = new File(archiveFile.getPath().substring(0, archiveFile.getPath().length() - 4) + "_" + PROGRAM_SHORTEST + "_tmp\\" + archiveFile.getName().substring(0, archiveFile.getName().length() - 4));
	        if(newModFolder.exists()){
	        	MAIN_UI.printConsole(LOAD_TXM_DEL_OLD_EXTRACT);
	        	DSFixFileController.deleteFileTree(newModFolder);
	        }
	        MAIN_UI.printConsole(LOAD_TXM_EXTRACT_START + archiveFile.getName() + "...");
	        if(!DSFixFileController.extractZipFile(archiveFile.getPath(), newModFolder.getPath())){
	        	// Extraction failed
	        	MAIN_UI.printConsole(ERROR.toUpperCase() + ": " + LOAD_TXM_EXTRACT_FAIL + "(" + archiveFile.getName() + ")");
	        	DSFixFileController.deleteFileTree(newModFolder.getParentFile());
	        	return false;
	        }else{
	        	MAIN_UI.printConsole(SUCCESS + ": " + LOAD_TXM_EXTRACT_DONE + archiveFile.getName());
	        }
		}

		String folderName = newModFolder.getName();

		// Check if valid texture mod directory
		ArrayList<File> fileList = new ArrayList<File>();
		if(DsTextureMod.canLoadModFromFolder(newModFolder.getAbsolutePath(), true, fileList)){

			// Confirm
    		ContinueDialog contD = new ContinueDialog(500.0, 100.0, COPY_DIAG_CONFIRM_TITLE,
    												LOAD_TXM_DIAG_CONFIRM_MSG[0] + folderName + LOAD_TXM_DIAG_CONFIRM_MSG[1]
    												+ fileList.size() + LOAD_TXM_DIAG_CONFIRM_MSG[2],
    												DIALOG_BUTTON_TEXTS[0], DIALOG_BUTTON_TEXTS[1]);
    		if(contD.show()){
    			// Copy mod folder
    			MAIN_UI.printConsole(LOAD_TXM_START);
    			for(File f : fileList){
    				String fileName = f.getAbsolutePath().substring(newModFolder.getAbsolutePath().length());
    				try {
						FileUtils.copyFile(f, new File(STORAGE_DIRS.get(DEFAULT_STORAGE_DIR).getPath() + "\\" + folderName + "\\" + fileName));
					} catch (IOException e) {
						// Failed to copy file
						errorsOccurred = true;
						MAIN_UI.printConsole(ERROR + ": " + FAILED_FILE_COPY_ERR + f.getName());
						break;
					}
    			}

    			if(!errorsOccurred){
    				// Files were successfully copied without issue
    				try {
    					int sizeBefore = DsTextureMod.texMods.size();
    					new DsTextureMod(STORAGE_DIRS.get(DEFAULT_STORAGE_DIR).getPath() + "\\" + folderName);
    					if(sizeBefore >= DsTextureMod.texMods.size()){
    						// Duplicate mod
    						throw new IOException();
    					}
    				} catch (IOException e) {
    					// Failed to create texture mod object
    					errorsOccurred = true;
    				}
    			}
    		}else{
    			MAIN_UI.printConsole(LOAD_TXM_CANCEL);
    			if(fromCompressedFile){
    				DSFixFileController.deleteFileTree(newModFolder.getParentFile());
    			}
    			return false;
    		}
		}else{
			// Not a valid texture mod folder
			if(fromCompressedFile){
				DSFixFileController.deleteFileTree(newModFolder.getParentFile());
			}
			return false;
		}

		if(errorsOccurred){
			// Try to delete the partially-copied mod
			MAIN_UI.printConsole(FAIL.toUpperCase() + ": " + LOAD_TXM_REMOVE_PARTIAL);
			if(DSFixFileController.deleteFileTree(new File(STORAGE_DIRS.get(DEFAULT_STORAGE_DIR).getPath() + "\\" + folderName))){
				// Successfully deleted the partially-loaded mod
				MAIN_UI.printConsole(LOAD_TXM_REMOVE_PARTIAL_SUCCESS);
			}else{
				// Errors occurred when deleting partially-loaded mod
				MAIN_UI.printConsole(LOAD_TXM_REMOVE_PARTIAL_FAIL + " (" + STORAGE_DIRS.get(DEFAULT_STORAGE_DIR).getPath() + "\\" + folderName + ")");
			}
			new AlertDialog(300.0, 100.0, ERROR, LOAD_TXM_REMOVE_PARTIAL_DONE + " " + SEE_CONSOLE + ".", DIALOG_BUTTON_TEXTS[0]);
		}else{
			// Mod was successfully copied and loaded as an object without issue
			DsTextureMod newMod = DsTextureMod.texMods.get(DsTextureMod.texMods.size() - 1);
			String sucMsg = LOAD_TEX_MOD_SUCCESS_MESSAGE + " (" + newMod.title;
			if(newMod.version.length() > 0)
				sucMsg += " " + newMod.version;
			sucMsg += ")";
			MAIN_UI.printConsole(SUCCESS.toUpperCase() + ": " + sucMsg);
			AlertDialog aD = new AlertDialog(360.0,50.0, SUCCESS.toUpperCase(), sucMsg + ".", DIALOG_BUTTON_TEXTS[0], false);
			CheckBox deleteSource = new CheckBox();
			if(fromCompressedFile){
				deleteSource.setText(DELETE_TEX_MOD_SRC_DIALOG_ZIP);
				deleteSource.setTooltip(new Tooltip(DELETE_TEX_MOD_SRC_DIALOG_ZIP_TT));
				deleteSource.setStyle("-fx-translate-x: -50; -fx-translate-y: -5;");
			}else{
				deleteSource.setText(DELETE_TEX_MOD_SRC_DIALOG);
				deleteSource.setTooltip(new Tooltip(DELETE_TEX_MOD_SRC_DIALOG_TT));
				deleteSource.setStyle("-fx-translate-x: -59; -fx-translate-y: -5;");
			}
			aD.buttonsPane.getChildren().add(0, deleteSource);
			aD.alert.showAndWait();
			if(deleteSource.isSelected() && fromCompressedFile){
				source.delete();
			}else if(deleteSource.isSelected()){
				DSFixFileController.deleteFileTree(source);
			}
		}
		if(fromCompressedFile){
			DSFixFileController.deleteFileTree(newModFolder.getParentFile());
		}
		return !errorsOccurred;
	}

	/*
	 * Attempts to load a new texture mod pack into the program through the GUI.
	 *
	 * @return The number of new mods that were successfully installed.
	 */
	public static int loadNewModPackFromGUI(boolean fromCompressedFile){
		int modsLoaded = 0;
		File source = null;
		File folder = null;

		if(!fromCompressedFile){
			// Load normally from a folder
			DirectoryChooser dirPicker = new DirectoryChooser();
			dirPicker.setTitle(NEW + " " + TEXTURE_MOD.toLowerCase() + " " + PACK.toLowerCase());
			folder = dirPicker.showDialog(MAIN_UI.getStage());
			if(folder == null){
				MAIN_UI.printConsole(LOAD_TXM_CANCEL);
    			return 0;
			}
			source = folder;
		}else{
			// Load from a zip file
			FileChooser filePicker = new FileChooser();
			filePicker.setTitle(NEW + " " + TEXTURE_MOD.toLowerCase() + " " + PACK.toLowerCase());
	        FileChooser.ExtensionFilter zipFilter = new FileChooser.ExtensionFilter(ZIP_EXT_FILTER[0], ZIP_EXT_FILTER[1]);
	        filePicker.getExtensionFilters().add(zipFilter);
	        File archiveFile = filePicker.showOpenDialog(MAIN_UI.getStage());
	        if(archiveFile == null){
				MAIN_UI.printConsole(LOAD_TXM_CANCEL);
    			return 0;
			}
	        source = archiveFile;
	        folder = new File(archiveFile.getPath().substring(0, archiveFile.getPath().length() - 4) + "_" + PROGRAM_SHORTEST + "_tmp\\" + archiveFile.getName().substring(0, archiveFile.getName().length() - 4));
	        if(folder.exists()){
	        	MAIN_UI.printConsole(LOAD_TXM_DEL_OLD_EXTRACT);
	        	DSFixFileController.deleteFileTree(folder);
	        }
	        MAIN_UI.printConsole(LOAD_TXM_EXTRACT_START + archiveFile.getName() + "...");
	        if(!DSFixFileController.extractZipFile(archiveFile.getPath(), folder.getPath())){
	        	// Extraction failed
	        	MAIN_UI.printConsole(ERROR.toUpperCase() + ": " + LOAD_TXM_EXTRACT_FAIL + "(" + archiveFile.getName() + ")");
	        	DSFixFileController.deleteFileTree(folder.getParentFile());
	        	return 0;
	        }else{
	        	MAIN_UI.printConsole(SUCCESS + ": " + LOAD_TXM_EXTRACT_DONE + archiveFile.getName());
	        }
		}

		File[] fileList = folder.listFiles();
		int nonFolderFiles = 0;
		ArrayList<File> list = new ArrayList<File>();

		for(File f : fileList){
			if(f.isDirectory()){
				if(DsTextureMod.canLoadModFromFolder(f, true, false)){
					list.add(f);
				}
			}else{
				nonFolderFiles++;
			}
		}

		if(list.size() > 0){
			// Directory contains valid texture mod folders
			// Confirm
    		ContinueDialog contD = new ContinueDialog(500.0, 100.0, COPY_DIAG_CONFIRM_TITLE,
    				LOAD_TEX_PACK_CONFIRM_DIAG_MSG[0] + folder.getName() + LOAD_TEX_PACK_CONFIRM_DIAG_MSG[1] + list.size() +
    				LOAD_TEX_PACK_CONFIRM_DIAG_MSG[2] + (fileList.length - (list.size() + nonFolderFiles)) + LOAD_TEX_PACK_CONFIRM_DIAG_MSG[3] +
    				nonFolderFiles + LOAD_TEX_PACK_CONFIRM_DIAG_MSG[4], DIALOG_BUTTON_TEXTS[0], DIALOG_BUTTON_TEXTS[1]);

    		if(contD.show()){
    			MAIN_UI.printConsole(LOAD_TEX_PACK_START[0] + list.size() + LOAD_TEX_PACK_START[1]);
    			for(File f : list){
    				if(DsTextureMod.loadNewMod(f)){
    					modsLoaded++;
    				}
    			}
    		}else{
    			MAIN_UI.printConsole(LOAD_TXM_CANCEL);
    			if(fromCompressedFile){
    				DSFixFileController.deleteFileTree(folder.getParentFile());
    			}
    			return 0;
    		}
		}else{
			// Directory does not contain valid texture mod folders
			MAIN_UI.printConsole(ERROR.toUpperCase() + ": " + LOAD_TEX_PACK_NO_MODS_DIAG_MSG);
			if(fromCompressedFile){
				DSFixFileController.deleteFileTree(folder.getParentFile());
			}
			new AlertDialog(300.0, 100.0, LOAD_TEX_PACK_NO_MODS_DIAG_TITLE, LOAD_TEX_PACK_NO_MODS_DIAG_MSG, DIALOG_BUTTON_TEXTS[0]);
			return 0;
		}

		if(fromCompressedFile){
			DSFixFileController.deleteFileTree(folder.getParentFile());
		}

		MAIN_UI.printConsole(modsLoaded + LOAD_TEX_PACK_DONE[0] + list.size() + LOAD_TEX_PACK_DONE[1]);
		AlertDialog aD = new AlertDialog(360.0, 50.0, modsLoaded + LOAD_TEX_PACK_DONE_TITLE,
					modsLoaded + LOAD_TEX_PACK_DONE[0] + list.size() + LOAD_TEX_PACK_DONE[1] + " " + SEE_CONSOLE + ".",
					DIALOG_BUTTON_TEXTS[0], false);
		CheckBox deleteSource = new CheckBox();
		if(fromCompressedFile){
			deleteSource.setText(DELETE_TEX_MOD_SRC_DIALOG_ZIP);
			if(modsLoaded == 1)
				deleteSource.setTooltip(new Tooltip(DELETE_TEX_MOD_SRC_DIALOG_ZIP_TT));
			else
				deleteSource.setTooltip(new Tooltip(DELETE_TEX_PACK_SRC_DIALOG_ZIP_TT));;
			deleteSource.setStyle("-fx-translate-x: -50; -fx-translate-y: -5;");
		}else{
			deleteSource.setText(DELETE_TEX_MOD_SRC_DIALOG);
			if(modsLoaded == 1)
				deleteSource.setTooltip(new Tooltip(DELETE_TEX_MOD_SRC_DIALOG_TT));
			else
				deleteSource.setTooltip(new Tooltip(DELETE_TEX_PACK_SRC_DIALOG_TT));
			deleteSource.setStyle("-fx-translate-x: -59; -fx-translate-y: -5;");
		}
		if(modsLoaded > 0)
			aD.buttonsPane.getChildren().add(0, deleteSource);
		aD.alert.showAndWait();
		if(deleteSource.isSelected() && fromCompressedFile){
			source.delete();
		}else if(deleteSource.isSelected()){
			DSFixFileController.deleteFileTree(source);
		}
		return modsLoaded;
	}


	// Check if a folder is a valid candidate to load a new texture mod from (must contain at least 1 .png or .dds file at the top level)
	public static boolean canLoadModFromFolder(File folder, boolean printMessages, boolean showDialogs, Collection<File> list){
		String workingDir = new File(System.getProperty("user.dir")).getAbsolutePath();

		if(printMessages)
			MAIN_UI.printConsole(WAIT_VERIFY_FOLDER + "...");

		if(folder == null || !folder.exists()){
			// Folder doesn't exist
			if(printMessages)
				MAIN_UI.printConsole(ERROR.toUpperCase() + ": " + LOAD_TXM_DIAG_INVALID_MSGS[1]);
			if(showDialogs)
				new AlertDialog(400.0, 100.0, LOAD_TXM_DIAG_INVALID_TITLE,
												LOAD_TXM_DIAG_INVALID_MSGS[0] + String.format("%n%n") + LOAD_TXM_DIAG_INVALID_MSGS[1],
												DIALOG_BUTTON_TEXTS[0]);
			return false;
		}else if(!folder.isDirectory()){
			// Not a folder
			if(printMessages)
				MAIN_UI.printConsole(ERROR.toUpperCase() + ": " + LOAD_TXM_DIAG_INVALID_MSGS[2]);
			if(showDialogs)
				new AlertDialog(400.0, 100.0, LOAD_TXM_DIAG_INVALID_TITLE,
												LOAD_TXM_DIAG_INVALID_MSGS[0] + String.format("%n%n") + LOAD_TXM_DIAG_INVALID_MSGS[2],
												DIALOG_BUTTON_TEXTS[0]);
			return false;
		}else if(folder.getAbsolutePath().length() <= 3){
			// Can't use drive root (such as C:\)
			if(printMessages)
				MAIN_UI.printConsole(ERROR.toUpperCase() + ": " + LOAD_TXM_DIAG_INVALID_MSGS[3]);
			if(showDialogs)
				new AlertDialog(400.0, 100.0, LOAD_TXM_DIAG_INVALID_TITLE,
												LOAD_TXM_DIAG_INVALID_MSGS[0] + String.format("%n%n") + LOAD_TXM_DIAG_INVALID_MSGS[3],
												DIALOG_BUTTON_TEXTS[0]);
			return false;
		}else if(folder.getAbsolutePath().length() >= workingDir.length() && folder.getAbsolutePath().startsWith(workingDir)){
			// Can't use this program or its sub-directories
			if(printMessages)
				MAIN_UI.printConsole(ERROR.toUpperCase() + ": " + LOAD_TXM_DIAG_INVALID_MSGS[6]);
			if(showDialogs)
				new AlertDialog(400.0, 100.0, LOAD_TXM_DIAG_INVALID_TITLE,
												LOAD_TXM_DIAG_INVALID_MSGS[0] + String.format("%n%n") + LOAD_TXM_DIAG_INVALID_MSGS[6],
												DIALOG_BUTTON_TEXTS[0]);
			return false;
		}else{
			for(File defaultStorageDir : DsTextureMod.STORAGE_DIRS){
				// Can't use a subdirectory of a known storage directory
				if(folder.getAbsolutePath().length() >= defaultStorageDir.getAbsolutePath().length() && folder.getAbsolutePath().startsWith(defaultStorageDir.getAbsolutePath())){
					if(printMessages)
						MAIN_UI.printConsole(ERROR.toUpperCase() + ": " + LOAD_TXM_DIAG_INVALID_MSGS[7]);
					if(showDialogs)
						new AlertDialog(400.0, 100.0, LOAD_TXM_DIAG_INVALID_TITLE,
														LOAD_TXM_DIAG_INVALID_MSGS[0] + String.format("%n%n") + LOAD_TXM_DIAG_INVALID_MSGS[7],
														DIALOG_BUTTON_TEXTS[0]);
					return false;
				}
			}

			// Check for valid files (PNG/DDS)
			File[] fileList = folder.listFiles();
			boolean hasValidFiles = false;

			for(File f : fileList){
				if(!f.isDirectory()){
					String fileName = f.getName();
					for(String e : TEXTURE_FILE_EXTENSIONS){
						// Look for a file with a valid file extension
						if(fileName.length() > e.length() && fileName.endsWith(e)){
							hasValidFiles = true;
							break;
						}
					}
				}
			}
			if(hasValidFiles){
				// Count files
				Collection<File> fullFileList = FileUtils.listFiles(folder, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

				// Check that file limit isn't exceeded
				if(fullFileList.size() > DsTextureMod.MAX_ALLOWED_FILES){
					if(printMessages)
						MAIN_UI.printConsole(ERROR.toUpperCase() + ": " + LOAD_TXM_DIAG_INVALID_MSGS[5]);
					if(showDialogs)
						new AlertDialog(400.0, 100.0, LOAD_TXM_DIAG_INVALID_TITLE,
														LOAD_TXM_DIAG_INVALID_MSGS[0] + String.format("%n%n") + LOAD_TXM_DIAG_INVALID_MSGS[5],
														DIALOG_BUTTON_TEXTS[0]);
					return false;
				}else{
					// Check if folder already exists in texture mod library
					String folderName = folder.getName();
					if(new File(STORAGE_DIRS.get(DEFAULT_STORAGE_DIR).getPath() + "\\" + folderName).exists()){
						// Another texture mod with the same folder name already exists
						if(printMessages)
							MAIN_UI.printConsole(ERROR.toUpperCase() + ": " + LOAD_TXM_DIAG_INVALID_MSGS[8]);
						if(showDialogs)
							new AlertDialog(400.0, 100.0, LOAD_TXM_DIAG_INVALID_TITLE,
															LOAD_TXM_DIAG_INVALID_MSGS[0] + String.format("%n%n") + LOAD_TXM_DIAG_INVALID_MSGS[8],
															DIALOG_BUTTON_TEXTS[0]);
						return false;
					}

					// Folder is a valid directory to load a texture mod from
					if(printMessages)
						MAIN_UI.printConsole(LOAD_TEX_MOD_CHECK_DIR_SUCCESS_MESSAGE + ": " + folder.getPath());
					if(list != null){
						// Save file list so it doesn't have to be obtained twice
						list.clear();
						for(File f : fullFileList){
							list.add(f);
						}
					}
					return true;
				}
			}else{
				// No valid files (PNG/DDS)
				if(printMessages)
					MAIN_UI.printConsole(ERROR.toUpperCase() + ": " + LOAD_TXM_DIAG_INVALID_MSGS[4]);
				if(showDialogs)
					new AlertDialog(400.0, 100.0, LOAD_TXM_DIAG_INVALID_TITLE,
												LOAD_TXM_DIAG_INVALID_MSGS[0] + String.format("%n%n") + LOAD_TXM_DIAG_INVALID_MSGS[4],
												DIALOG_BUTTON_TEXTS[0]);
			}

		}
		return false;
	}
	// Overloads of canLoadModFromFolder
	public static boolean canLoadModFromFolder(String folderPath, boolean printMessages, boolean showDialogs){ return DsTextureMod.canLoadModFromFolder(new File(folderPath), printMessages, showDialogs, null); }
	public static boolean canLoadModFromFolder(File folder, boolean printMessages, boolean showDialogs){ return DsTextureMod.canLoadModFromFolder(folder, printMessages, showDialogs, null); }
	public static boolean canLoadModFromFolder(String folderPath, boolean verbose){ return DsTextureMod.canLoadModFromFolder(new File(folderPath), verbose, verbose, null); }
	public static boolean canLoadModFromFolder(File folder, boolean verbose){ return DsTextureMod.canLoadModFromFolder(folder, verbose, verbose, null); }
	public static boolean canLoadModFromFolder(String folderPath){ return DsTextureMod.canLoadModFromFolder(new File(folderPath), false, false, null); }
	public static boolean canLoadModFromFolder(File folder){ return DsTextureMod.canLoadModFromFolder(folder, false, false, null); }
	public static boolean canLoadModFromFolder(String folderPath, boolean printMessages, boolean showDialogs, Collection<File> list){ return DsTextureMod.canLoadModFromFolder(new File(folderPath), printMessages, showDialogs, list); }
	public static boolean canLoadModFromFolder(String folderPath, boolean verbose, Collection<File> list){ return DsTextureMod.canLoadModFromFolder(new File(folderPath), verbose, verbose, list); }
	public static boolean canLoadModFromFolder(File folder, boolean verbose, Collection<File> list){ return DsTextureMod.canLoadModFromFolder(folder, verbose, verbose, list); }
	public static boolean canLoadModFromFolder(String folderPath, Collection<File> list){ return DsTextureMod.canLoadModFromFolder(new File(folderPath), false, false, list); }
	public static boolean canLoadModFromFolder(File folder, Collection<File> list){ return DsTextureMod.canLoadModFromFolder(folder, false, false, list); }

}
