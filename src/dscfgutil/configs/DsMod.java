// Author: Sean Pesce

package dscfgutil.configs;

import static dscfgutil.DSCfgUtilConstants.AUTHOR;
import static dscfgutil.DSCfgUtilConstants.COPYING;
import static dscfgutil.DSCfgUtilConstants.DELETE_ERRORS;
import static dscfgutil.DSCfgUtilConstants.DELETED_SUCCESS;
import static dscfgutil.DSCfgUtilConstants.DESCRIPTION;
import static dscfgutil.DSCfgUtilConstants.FAIL_CLEAR_README_TMP_ERR;
import static dscfgutil.DSCfgUtilConstants.GET_MODS_URL;
import static dscfgutil.DSCfgUtilConstants.FAILED_FILE_COPY_ERR;
import static dscfgutil.DSCfgUtilConstants.FAILED_FILE_DELETE_ERR;
import static dscfgutil.DSCfgUtilConstants.FAILED_FOLDER_DELETE_ERR;
import static dscfgutil.DSCfgUtilConstants.INFO_NOT_WRITTEN_ERR;
import static dscfgutil.DSCfgUtilConstants.INSTALL_ERRORS;
import static dscfgutil.DSCfgUtilConstants.INSTALLED_SUCCESS;
import static dscfgutil.DSCfgUtilConstants.INSTALLING;
import static dscfgutil.DSCfgUtilConstants.MAIN_UI;
import static dscfgutil.DSCfgUtilConstants.MOD_AUTHOR_KEY;
import static dscfgutil.DSCfgUtilConstants.MOD_CATEGORY_KEY;
import static dscfgutil.DSCfgUtilConstants.MOD_DESCRIPTION_KEY;
import static dscfgutil.DSCfgUtilConstants.MOD_ENUM_INSTALLED;
import static dscfgutil.DSCfgUtilConstants.MOD_ENUM_NOT_INSTALLED;
import static dscfgutil.DSCfgUtilConstants.MOD_ENUM_PART_INSTALLED;
import static dscfgutil.DSCfgUtilConstants.MOD_EXCLUDE_FILE_KEY;
import static dscfgutil.DSCfgUtilConstants.MOD_FOLDER_NOT_FOUND;
import static dscfgutil.DSCfgUtilConstants.MOD_FOLDER_NOT_DIR;
import static dscfgutil.DSCfgUtilConstants.MOD_INFO_FILE;
import static dscfgutil.DSCfgUtilConstants.MOD_INSTALL_SUBDIR_KEY;
import static dscfgutil.DSCfgUtilConstants.MOD_NEXUS_ID_KEY;
import static dscfgutil.DSCfgUtilConstants.MOD_README_KEY;
import static dscfgutil.DSCfgUtilConstants.MOD_SUMMARY_KEY;
import static dscfgutil.DSCfgUtilConstants.MOD_TITLE_KEY;
import static dscfgutil.DSCfgUtilConstants.MOD_VERSION_KEY;
import static dscfgutil.DSCfgUtilConstants.WEBSITE_CANT_ACCESS;
import static dscfgutil.DSCfgUtilConstants.MOD_WEBSITE_KEY;
import static dscfgutil.DSCfgUtilConstants.MOD_WEBSITE_NOT_EXIST;
import static dscfgutil.DSCfgUtilConstants.NEXUS;
import static dscfgutil.DSCfgUtilConstants.OVERVIEW;
import static dscfgutil.DSCfgUtilConstants.PAGE;
import static dscfgutil.DSCfgUtilConstants.PERM_DELETING;
import static dscfgutil.DSCfgUtilConstants.README_NOT_EXIST;
import static dscfgutil.DSCfgUtilConstants.README_NOT_FOUND;
import static dscfgutil.DSCfgUtilConstants.README_NOT_OPENED_ERR;
import static dscfgutil.DSCfgUtilConstants.TEMP_README_FILE;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_ERRORS;
import static dscfgutil.DSCfgUtilConstants.UNINSTALLED_SUCCESS;
import static dscfgutil.DSCfgUtilConstants.UNINSTALLING;
import static dscfgutil.DSCfgUtilConstants.UNKNOWN_MOD_TITLE;
import static dscfgutil.DSCfgUtilConstants.VERSION;
import static dscfgutil.DSCfgUtilConstants.WEBSITE;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.math.NumberUtils;

import dscfgutil.FileIO.DSFixFileController;

public class DsMod {
	
	// List of mod categories (used for grouping in the GUI)
	public static ArrayList<String> categories = new ArrayList<String>(Arrays.asList(""));
	
	// Title of this mod
	public String title = "";
	
	// Author of this mod
	public String author = "";
	
	// Version of this mod
	public String version = "";
	
	// Category of this mod (used for grouping in the GUI)
	public int category = 0;
	
	// Summary of this mod (only one line)
	public String summary = "";
	
	// Full description of this mod (one or more lines)
	public ArrayList<String> description;
	
	// Website for this mod or author
	public String website = "";
	
	// Unique ID number of this mod on the Dark Souls Nexus mod website
	public int nexusId = -1;
	
	// Readme file for this mod (may not exist)
	public String readme = ""; // Readme line in INFO.txt should be path to Readme file relative to mod folder passed to constructor
	
	// Subdirectory of the Dark Souls DATA folder where the files should be installed
	public String installSubDir = "";
	
	// List of files/folders that aren't included in this mod's file list
	public ArrayList<String> excludedFiles;
	
	// Mod directory (where this mod's files are stored)
	public String storagePath = "";
	
	// Filenames of each mod file
	public ArrayList<String> files;
	
	// Sizes (in bytes) of each mod file
	public long fileSizes[];
	
	// SHA-1 checksums of each mod file
	public ArrayList<String> hashes;
	
	
	// Constructor
	public DsMod(String mod_folder) throws FileNotFoundException, IOException {
		// Trim whitespace
		mod_folder = mod_folder.trim();
		
		// Remove trailing backslash, if it exists
		while(mod_folder.charAt(mod_folder.length() - 1) == '\\'){
			mod_folder = mod_folder.substring(0, mod_folder.length()).trim();
		}
		
		// Initialize data structures
		this.files = new ArrayList<String>();
		this.hashes = new ArrayList<String>();
		this.description = new ArrayList<String>();
		this.excludedFiles = new ArrayList<String>(Arrays.asList(mod_folder + MOD_INFO_FILE));
		
		// Set storage path:
		storagePath = mod_folder;
		
		// Check if mod folder exists
		Path p = Paths.get(storagePath);
		if (storagePath.length() < 1 || Files.notExists(p)) {
			MAIN_UI.printConsole("ERROR: " + MOD_FOLDER_NOT_FOUND);
			throw new FileNotFoundException(MOD_FOLDER_NOT_FOUND);
		}else if(!Files.isDirectory(p)){
			MAIN_UI.printConsole("ERROR: " + MOD_FOLDER_NOT_DIR);
			throw new IOException(MOD_FOLDER_NOT_DIR);
		}
		
		// Obtain list of all files in the mod folder
		Collection<File> file_list = FileUtils.listFiles(new File(storagePath), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		
		this.readInfoFile();
		
		if(this.title.length() == 0){
			// If title wasn't found, use folder name for mod title
			this.title = storagePath.substring(storagePath.lastIndexOf("\\") + 1);
		}
		
		// If title is blank, rename to unknown mod title preset
		this.title = this.title.trim();
		if(this.title.length() < 1){
			this.title = UNKNOWN_MOD_TITLE;
		}
		
		// If Readme entry wasn't found, search for a file with "Readme" in the filename
		if(this.readme.length() <= 0){
			for(File f : file_list){
				String fn = f.getName();
				if(fn.length() >= "README".length() && fn.toUpperCase().contains("README")){
					if(Files.exists(Paths.get(f.getPath())) && !Files.isDirectory(Paths.get(f.getPath()))){
						this.readme = f.getPath();
						break;
					}
				}
			}
		}
		
		// Add Readme to excluded files
		if(this.readme.length() > 0 && !this.excludedFiles.contains(this.readme)){
			this.excludedFiles.add(this.readme);
		}
		
		// Remove excluded files from file list
		for(String fs : this.excludedFiles){
			File f = new File(fs);
			
			if(f.isDirectory()){
				file_list.removeIf((File fl) -> (fl.getAbsolutePath().startsWith(f.getAbsolutePath())));
			}else{
				file_list.removeIf((File fl) -> (fl.getAbsolutePath().equals(f.getAbsolutePath())));
			}
		}
		
		// Get other file data (paths, hashes, and file sizes)
		File pathFile = new File(storagePath);
		for(File f : file_list){
			if(f.exists() && !f.isDirectory()){
				// Save file name
				this.files.add(f.getAbsolutePath().substring(pathFile.getAbsolutePath().length()));
				
				// Calculate SHA-1 hash
				this.hashes.add(DSFixFileController.getSHA1Hash(f.getPath()));
			}
		}
		
		// Obtain file sizes
		this.fileSizes = new long[this.files.size()];
		int i = 0;
		for(String f : this.files){
			fileSizes[i] = new File(storagePath + f).length();
			i++;
		}
	}
	
	// Return the number of files in this mod (not including excluded files)
	public int fileCount(){
		return this.files.size();
	}
	
	
	// Return the full mod description as a single String
	public String getDescription(){
		return this.getDescription("");
	}
	public String getDescription(String indent){
		String desc = "";
		for(String d : this.description){
			desc += (indent + d + String.format("%n"));
		}
		return desc;
	}
	
	
	// Return the Dark Souls Nexus mod site page for the mod (or the main Dark Souls Nexus page if this mod object has no nexusId)
	public String getNexusUrl(){
		if(this.nexusId > 0)
			return GET_MODS_URL + "mods/" + this.nexusId;
		else
			return GET_MODS_URL;
	}
	
	
	// Open the mod Readme file using the system default application
	public void openReadme(){
		try {
			DsMod.clearReadmeTempFile();
			FileWriter fw = new FileWriter(TEMP_README_FILE, true);
			PrintWriter out = new PrintWriter(fw);
			Scanner in = null;
			if(this.readme.length() > 0){
				in = new Scanner(DSFixFileController.readTextFile(this.readme));
				while(in.hasNextLine()){
					out.print(in.nextLine() + String.format("%n"));
				}
			}else{
				out.print(this.title + String.format("%n"));
				if(this.version.length() > 0)
					out.print(VERSION + ": " + this.version + String.format("%n"));
				if(this.author.length() > 0)
					out.print(AUTHOR + ": " + this.author + String.format("%n"));
				if(this.website.length() > 0)
					out.print(WEBSITE + ": " + this.website + String.format("%n"));
				if(this.nexusId > 0)
					out.print(NEXUS + " " + PAGE.toLowerCase() + ": " + this.getNexusUrl() + String.format("%n"));
				out.print(String.format("%n"));
				if(this.summary.length() > 0){
					out.print(OVERVIEW + String.format(": %n    ") + this.summary + String.format("%n"));
				}
				out.print(String.format("%n"));
				if(this.description.size() > 0)
					out.print(DESCRIPTION + String.format(": %n"));
				out.print(this.getDescription("    ") + String.format("%n"));
				out.print(String.format("-------------------------------%n%n"));
				out.print(README_NOT_EXIST + String.format("%n"));
				
			}
			if(in != null)
			{
				in.close();
			}
			fw.close();
			out.close();
			
			// Open the temporary Readme file in the system resolver:
			Desktop.getDesktop().open(new File(TEMP_README_FILE));
			
		} catch (IOException e) {
			MAIN_UI.printConsole(README_NOT_OPENED_ERR + this.readme);
		}
	}
	
	
	// Open the website of the author/mod
	public void openWebsite(){
		if(this.website.length() > 0){
			try {
				String site = this.website.trim();
				if(!((site.length() >= "www".length() && site.toLowerCase().startsWith("www"))
						|| (site.length() >= "http://".length() && site.toLowerCase().startsWith("http://"))
						|| (site.length() >= "https://".length() && site.toLowerCase().startsWith("https://")))){
					site = "http://" + site;
				}
				Desktop.getDesktop().browse(new URI(site));
			} catch (IOException | URISyntaxException e) {
				MAIN_UI.printConsole(WEBSITE_CANT_ACCESS + this.website);
			}
		}else{
			MAIN_UI.printConsole(MOD_WEBSITE_NOT_EXIST);
		}
	}
	
	
	// Open the Dark Souls Nexus site page for the mod (or the main Dark Souls Nexus page if this mod object has no nexusId)
	public void openNexusPage(){
		try {
			Desktop.getDesktop().browse(new URI(this.getNexusUrl()));
		} catch (IOException | URISyntaxException e) {
			MAIN_UI.printConsole(WEBSITE_CANT_ACCESS + this.getNexusUrl());
		}
	}
	
	
	// Install the mod by copying all files into the Dark Souls DATA folder
	public void install(){
		boolean error = false;
		MAIN_UI.printConsole(INSTALLING + this.title + "...");
		for(String f : this.files){
			File file = new File(storagePath + "\\" + f);
			MAIN_UI.printConsole(COPYING + f + "...");
			try {
				FileUtils.copyFile(file, new File(MAIN_UI.getDataFolder().getPath() + "\\" + this.installSubDir + "\\" + f));
			} catch (IOException e) {
				MAIN_UI.printConsole("ERROR - " + FAILED_FILE_COPY_ERR + f);
				error = true;
			}
		}
		String message;
		if(!error){
			message = this.title + INSTALLED_SUCCESS;
		}else{
			message = INSTALL_ERRORS + this.title + ".";
		}
		MAIN_UI.printConsole(message);
	}
	
	// Uninstall the mod by deleting all mod files from the Dark Souls DATA folder
	public void uninstall(){
		boolean error = false;
		MAIN_UI.printConsole(UNINSTALLING + this.title + "...");
		int i = 0;
		for(String f : this.files){
			File file = new File(MAIN_UI.getDataFolder().getPath() + "\\" + this.installSubDir + "\\" + f);
			// Before deleting, make sure it's not a file from another mod with the same filename
			if(file.exists() && file.length() == this.fileSizes[i] && DSFixFileController.getSHA1Hash(file.getPath()).equals(this.hashes.get(i)) ){
				try {
					file.delete();
					// Delete leftover folders, if empty
					String parent = this.installSubDir + "\\" + f;
					while(parent.indexOf("\\") > -1){
						parent = parent.substring(0, parent.lastIndexOf("\\"));
						File folder = new File(MAIN_UI.getDataFolder().getPath() + "\\" + parent);
						
						if(folder.exists() && folder.isDirectory() && FileUtils.listFiles(folder, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE).size() == 0){
							try{
								folder.delete();
							}catch (SecurityException ex){
								MAIN_UI.printConsole("ERROR - " + FAILED_FOLDER_DELETE_ERR + folder.getPath());
								error = true;
							}
						}
					}
				} catch (SecurityException ex) {
					MAIN_UI.printConsole("ERROR - " + FAILED_FILE_DELETE_ERR + file.getPath());
					error = true;
				}
			}
			i++;
		}
		if(!error){
			MAIN_UI.printConsole(this.title + UNINSTALLED_SUCCESS);
		}else{
			MAIN_UI.printConsole(UNINSTALL_ERRORS + this.title + ".");
		}
	}
	
	// Check if the mod is installed in the Dark Souls directory
	// @return Installed = 0, Not Installed = 1, Partially installed = 2
	public int isInstalled(){
		int filesFound = 0, filesChecked = 0;
		for(String f : this.files){
			File file = new File(MAIN_UI.getDataFolder().getPath() + "\\" + this.installSubDir + "\\" + f);
			if(file.exists() && file.length() == this.fileSizes[filesChecked] && DSFixFileController.getSHA1Hash(file.getAbsolutePath()).equals(this.hashes.get(filesChecked))){
				filesFound++; // File is verified
			}
			filesChecked++;
		}
		
		if(filesFound > 0 && filesFound == filesChecked && filesFound == this.files.size()){
			return MOD_ENUM_INSTALLED; // Installed
		}else if(filesFound == 0){
			return MOD_ENUM_NOT_INSTALLED; // Not installed
		}
		return MOD_ENUM_PART_INSTALLED;
	}
	
	// Delete the mod from the Config Utility files directory
	public boolean delete(){
		boolean error = false;
		MAIN_UI.printConsole(PERM_DELETING + this.title + "...");
		File file = new File(storagePath);
		
		// Delete all files
		Collection<File> file_list = FileUtils.listFiles(file, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for(File f : file_list){
			try {
				f.delete();
			} catch (SecurityException ex) {
				MAIN_UI.printConsole("ERROR - " + FAILED_FILE_DELETE_ERR + f.getPath());
				error = true;
			}
		}
		
		// Delete leftover subfolders (if any)
		int deleted = -1; // Number of folders deleted in each pass
		while(deleted != 0){ // Folders can only be deleted if empty, so do multiple passes until nothing's deleted
			deleted = 0;
			if(file.exists()){
				file_list = FileUtils.listFilesAndDirs(file, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
				for(File f : file_list){
					try {
						f.delete();
						if(!f.exists()){
							deleted++;
						}
					} catch (SecurityException ex) {
						MAIN_UI.printConsole("ERROR - " + FAILED_FOLDER_DELETE_ERR + f.getPath());
						error = true;
					}
				}
			}
		}
		
		
		// Delete mod directory
		try {
			file.delete();
		} catch (SecurityException ex) {
			MAIN_UI.printConsole("ERROR - " + FAILED_FOLDER_DELETE_ERR + file.getAbsolutePath());
			error = true;
		}
		
		if(!error){
			MAIN_UI.printConsole(this.title + DELETED_SUCCESS);
		}else{
			MAIN_UI.printConsole(DELETE_ERRORS + this.title);
		}
		
		return !error;
	}
	
	// Read the INFO file to determine member data (mod title, author, version, website, installation folder, etc)
	public void readInfoFile() throws FileNotFoundException{
		// Check for INFO.txt
		Scanner fileReader;
		//for(File file : file_list){ // Uncomment if you want to allow INFO file to be in subfolders (also line below and some others)
			//String fn = file.getName();
			File file = new File(storagePath + MOD_INFO_FILE); // Comment out if enabling mobile INFO file
			//if(fn.toUpperCase().equals(new File(MOD_INFO_FILE).getName().toUpperCase())){
				if(Files.exists(Paths.get(file.getPath())) && !Files.isDirectory(Paths.get(file.getPath()))){
					// Found info file
					fileReader = new Scanner(DSFixFileController.readTextFile(file.getPath()));
					
					// Parse info file for mod info (title, author, version, readme)
					while(fileReader.hasNextLine()){
						String line = fileReader.nextLine().trim();
						
						if(line.length() > MOD_TITLE_KEY.length() && line.substring(0, MOD_TITLE_KEY.length()).toUpperCase().equals(MOD_TITLE_KEY.toUpperCase())){
							// Found mod title
							this.title = line.substring(MOD_TITLE_KEY.length()).trim();
							
						}else if(line.length() > MOD_README_KEY.length() && line.substring(0, MOD_README_KEY.length()).toUpperCase().equals(MOD_README_KEY.toUpperCase())){
							// Found mod Readme
							this.readme = storagePath + "\\" + line.substring(MOD_README_KEY.length()).trim().replace("/", "\\");
							File f = new File(this.readme);
							if(!f.exists() || f.isDirectory()){
								this.readme = line.substring(MOD_README_KEY.length()).trim().replace("/", "\\");
								f = new File(this.readme);
								if(!f.exists() || f.isDirectory()){
									MAIN_UI.printConsole(README_NOT_FOUND + this.readme);
									this.readme = "";
								}
							}
						}else if(line.length() > MOD_AUTHOR_KEY.length() && line.substring(0, MOD_AUTHOR_KEY.length()).toUpperCase().equals(MOD_AUTHOR_KEY.toUpperCase())){
							// Found mod author
							this.author = line.substring(MOD_AUTHOR_KEY.length()).trim();
						}else if(line.length() > MOD_VERSION_KEY.length() && line.substring(0, MOD_VERSION_KEY.length()).toUpperCase().equals(MOD_VERSION_KEY.toUpperCase())){
							// Found mod version
							this.version = line.substring(MOD_VERSION_KEY.length()).trim();
						}else if(line.length() > MOD_CATEGORY_KEY.length() && line.substring(0, MOD_CATEGORY_KEY.length()).toUpperCase().equals(MOD_CATEGORY_KEY.toUpperCase())){
							// Found mod category
							String cat = line.substring(MOD_CATEGORY_KEY.length()).trim();
							this.category = DsMod.categories.indexOf(cat.toUpperCase());
							if(this.category < 0){
								DsMod.categories.add(cat.toUpperCase());
								this.category = DsMod.categories.size() - 1;
							}
						}else if(line.length() > MOD_SUMMARY_KEY.length() && line.substring(0, MOD_SUMMARY_KEY.length()).toUpperCase().equals(MOD_SUMMARY_KEY.toUpperCase())){
							// Found one-line summary of the mod
							this.summary = line.substring(MOD_SUMMARY_KEY.length()).trim();
						}else if(line.length() >= MOD_DESCRIPTION_KEY.length() && line.substring(0, MOD_DESCRIPTION_KEY.length()).toUpperCase().equals(MOD_DESCRIPTION_KEY.toUpperCase())){
							// Found description line
							this.description.add(line.substring(MOD_DESCRIPTION_KEY.length()));
						}else if(line.length() > MOD_WEBSITE_KEY.length() && line.substring(0, MOD_WEBSITE_KEY.length()).toUpperCase().equals(MOD_WEBSITE_KEY.toUpperCase())){
							// Found mod/author website
							this.website = line.substring(MOD_WEBSITE_KEY.length()).trim();
						}else if(line.length() > MOD_INSTALL_SUBDIR_KEY.length() && line.substring(0, MOD_INSTALL_SUBDIR_KEY.length()).toUpperCase().equals(MOD_INSTALL_SUBDIR_KEY.toUpperCase())){
							// Found the installation subdirectory
							this.installSubDir = line.substring(MOD_INSTALL_SUBDIR_KEY.length()).replace("/", "\\").trim();
							// Remove surrounding slashes
							while(this.installSubDir.length() > 0 && this.installSubDir.charAt(0) == '\\'){
								this.installSubDir = this.installSubDir.substring(1);
							}
							while(this.installSubDir.length() > 0 && this.installSubDir.charAt(this.installSubDir.length()-1) == '\\'){
								this.installSubDir = this.installSubDir.substring(0, this.installSubDir.length()-1);
							}
							this.installSubDir = this.installSubDir.trim();
						}else if(line.length() > MOD_EXCLUDE_FILE_KEY.length() && line.substring(0, MOD_EXCLUDE_FILE_KEY.length()).toUpperCase().equals(MOD_EXCLUDE_FILE_KEY.toUpperCase())){
							// Found a file to exclude from the files list
							File f = new File(storagePath + "\\" + line.substring(MOD_EXCLUDE_FILE_KEY.length()).trim().replace("/", "\\"));
							if(f.exists()){
								if(!excludedFiles.contains(storagePath + "\\" + line.substring(MOD_EXCLUDE_FILE_KEY.length()).trim())){
									this.excludedFiles.add(storagePath + "\\" + line.substring(MOD_EXCLUDE_FILE_KEY.length()).trim());
								}
								
								if(f.isDirectory()){
									Collection<File> file_list = FileUtils.listFiles(f, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
									for(File folder_file : file_list){
										if(!excludedFiles.contains(folder_file.toPath().toString())){
											this.excludedFiles.add(folder_file.toPath().toString());
										}
									}
								}
							}
						}else if(line.length() > MOD_NEXUS_ID_KEY.length() && line.substring(0, MOD_NEXUS_ID_KEY.length()).toUpperCase().equals(MOD_NEXUS_ID_KEY.toUpperCase())){
							// Found Dark Souls Nexus mod website ID number
							String nexId = line.substring(MOD_NEXUS_ID_KEY.length()).trim();
							if(NumberUtils.isParsable(nexId) || Integer.parseInt(nexId) > 0){
								this.nexusId = Integer.parseInt(nexId);
							}
						}
					}
					
					fileReader.close();
					//break;
				}
			//}
		//}
	}
	
	// Write configurable data to the INFO file to determine member data more quickly in the future
	public void writeInfoFile(){
		File file = new File(storagePath + MOD_INFO_FILE);
		
		try {
			FileWriter fw = new FileWriter(file.getAbsolutePath(), false);
			fw.write("");
			fw.close();
			fw = new FileWriter(file.getAbsolutePath(), true);
			PrintWriter out = new PrintWriter(fw);
			
			out.print(MOD_TITLE_KEY + this.title + String.format("%n"));
			if(this.version.length() > 0)
				out.print(MOD_VERSION_KEY + this.version + String.format("%n"));
			if(this.author.length() > 0)
				out.print(MOD_AUTHOR_KEY + this.author + String.format("%n"));
			if(this.category >= 0 && this.category < DsMod.categories.size())
				out.print(MOD_CATEGORY_KEY + DsMod.categories.get(this.category) + String.format("%n"));
			if(this.summary.length() > 0)
				out.print(MOD_SUMMARY_KEY + this.summary + String.format("%n"));
			if(this.description.size() > 0){
				for(String d : this.description){
					out.print(MOD_DESCRIPTION_KEY + d + String.format("%n"));
				}
			}
			if(this.readme.length() > 0 && new File(this.readme).exists() && !(new File(this.readme).isDirectory())){
				if(this.readme.startsWith(storagePath)){
					String relPath = this.readme.substring(storagePath.length());
					while(relPath.length() > 0 && relPath.charAt(0) == '\\'){
						relPath = relPath.substring(1);
					}
					out.print(MOD_README_KEY + relPath + String.format("%n"));
				}else{
					out.print(MOD_README_KEY + this.readme + String.format("%n"));
				}
			}
			if(this.installSubDir.length() > 0)
				out.print(MOD_INSTALL_SUBDIR_KEY + this.installSubDir + String.format("%n"));
			if(this.website.length() > 0)
				out.print(MOD_WEBSITE_KEY + this.website + String.format("%n"));
			if(this.nexusId > 0){
				out.print(MOD_NEXUS_ID_KEY + this.nexusId + String.format("%n"));
			}
			
			@SuppressWarnings("unchecked")
			ArrayList<String> exFiles = (ArrayList<String>)this.excludedFiles.clone();
			for(String f : this.excludedFiles){
				File folder = new File(f);
				if(folder.exists() && folder.isDirectory()){
					Collection<File> file_list = FileUtils.listFiles(folder, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
					for(File subFile : file_list){
						exFiles.remove(subFile.toPath().toString());
					}
				}
			}
			for(String f : exFiles){
				if(!f.equals(storagePath + MOD_INFO_FILE) && !f.equals(this.readme)){
					String relPath = f.substring(storagePath.length());
					while(relPath.length() > 0 && relPath.charAt(0) == '\\'){
						relPath = relPath.substring(1);
					}
					out.print(MOD_EXCLUDE_FILE_KEY + relPath + String.format("%n"));
				}
			}
			
			out.print(String.format("%n"));
			
			fw.close();
			out.close();
			
		} catch (IOException e) {
			MAIN_UI.printConsole(INFO_NOT_WRITTEN_ERR + this.title);
		}
	}
	
	
	// Clear the temporary Readme file (used to stop the user from editing a mod's Readme through the Config Utility)
	public static void clearReadmeTempFile(){
		FileWriter fw;
		try {
			fw = new FileWriter(TEMP_README_FILE, false);
			fw.write("");
			fw.close();
		} catch (IOException e) {
			MAIN_UI.printConsole(FAIL_CLEAR_README_TMP_ERR);
		}
	}
}
