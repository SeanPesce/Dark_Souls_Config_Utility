// Author: Sean Pesce

package dscfgutil.view;

import dscfgutil.configs.DsMod;
import dscfgutil.configs.DsTextureMod;
import dscfgutil.dialog.ContinueDialog;

import static dscfgutil.DSCfgUtilConstants.AUTHOR;
import static dscfgutil.DSCfgUtilConstants.CONFIGURE;
import static dscfgutil.DSCfgUtilConstants.DELETE;
import static dscfgutil.DSCfgUtilConstants.DELETE_TEX_MOD_AND_UNINSTALL;
import static dscfgutil.DSCfgUtilConstants.DELETE_TEX_MOD_AND_UNINSTALL_TT;
import static dscfgutil.DSCfgUtilConstants.DELETE_TEX_MOD_DIALOG_MSG;
import static dscfgutil.DSCfgUtilConstants.DELETE_TEX_MOD_DIALOG_TITLE;
import static dscfgutil.DSCfgUtilConstants.DELETE_TEX_MOD_TT;
import static dscfgutil.DSCfgUtilConstants.DIALOG_BUTTON_TEXTS;
import static dscfgutil.DSCfgUtilConstants.EDIT_TEX_MOD_DIALOG_TITLE;
import static dscfgutil.DSCfgUtilConstants.GET_MODS_URL;
import static dscfgutil.DSCfgUtilConstants.INSTALL;
import static dscfgutil.DSCfgUtilConstants.INVALID_INPUT;
import static dscfgutil.DSCfgUtilConstants.MAIN_UI;
import static dscfgutil.DSCfgUtilConstants.MOD_AUTHOR_KEY;
import static dscfgutil.DSCfgUtilConstants.MOD_CATEGORY_KEY;
import static dscfgutil.DSCfgUtilConstants.MOD_ENUM_INSTALLED;
import static dscfgutil.DSCfgUtilConstants.MOD_ENUM_NOT_INSTALLED;
import static dscfgutil.DSCfgUtilConstants.MOD_ENUM_PART_INSTALLED;
import static dscfgutil.DSCfgUtilConstants.MOD_INFO_FILE;
import static dscfgutil.DSCfgUtilConstants.MOD_STATUS;
import static dscfgutil.DSCfgUtilConstants.MOD_TITLE_KEY;
import static dscfgutil.DSCfgUtilConstants.MOD_VERSION_KEY;
import static dscfgutil.DSCfgUtilConstants.NEXUS;
import static dscfgutil.DSCfgUtilConstants.NEXUS_HOME;
import static dscfgutil.DSCfgUtilConstants.NO_README_AVAILABLE;
import static dscfgutil.DSCfgUtilConstants.OPEN_README;
import static dscfgutil.DSCfgUtilConstants.PRINT_INFO;
import static dscfgutil.DSCfgUtilConstants.README;
import static dscfgutil.DSCfgUtilConstants.REMOVE_PART_INSTALL;
import static dscfgutil.DSCfgUtilConstants.STATUS;
import static dscfgutil.DSCfgUtilConstants.TEX_MOD_CONFIGURE_TT;
import static dscfgutil.DSCfgUtilConstants.UNCATEGORIZED;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL;
import static dscfgutil.DSCfgUtilConstants.UNKNOWN;
import static dscfgutil.DSCfgUtilConstants.WEBSITE;
import static dscfgutil.DSCfgUtilConstants.WRITE;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class DsTexModPane extends FlowPane {
	
	// The texture mod associated with this pane
	protected DsTextureMod texMod;
	
	// GUI elements
	HBox leftHBox;
	Label leftSpacer;
	CheckBox select;
	Label title;
	HBox midHBox;
	HBox rightHBox;
	Label rightHBoxLeftSpacer;
	Button configureButton;
	Button installButton; // For installing AND uninstalling the mod from the Dark Souls DATA folder
	Button deleteButton; // For deleting the stored mod from the Config Utility directory
	Button printInfoButton;
	Button readmeButton;
	Button websiteButton;
	Button nexusButton;
	Button writeInfoButton;
	Label installLabeller;
	Label statusLabel;
	
	
	ContinueDialog configureDialog;
	Label installLabellerDialog;
	Label statusLabelDialog;
	VBox configureVBox;
	Label titleLabel;
	Label authorLabel;
	Label versionLabel;
	Label categoryLabel;
	TextField titleField;
	TextField authorField;
	TextField versionField;
	TextField categoryField;
	CheckBox uninstallBeforeDelete;
	
	// Constructor
	public DsTexModPane(DsTextureMod newTexMod){
		super();
		
		this.texMod = newTexMod;
		
		// Initialize GUI elements
		this.getStyleClass().add("tex_mod_pane");
		//Tooltip.install(this, new Tooltip(TEX_MOD_CONFIGURE_TT));
		leftHBox = new HBox();
		leftHBox.setAlignment(Pos.CENTER_LEFT);
		leftSpacer = new Label("   ");
		leftSpacer.setTextOverrun(OverrunStyle.CLIP);
		select = new CheckBox();
		title = new Label(this.texMod.title);
		//if(this.texMod.version.length() > 0)
		//	title.setText(title.getText() + " " + this.texMod.version);
		title.getStyleClass().addAll("bold_text");
		int titleFontSize = 15;
		title.setStyle("-fx-font-size: " + titleFontSize + "px;");
		this.setStyle("-fx-min-height: " + (titleFontSize + 20) + "px;");
		title.setTextOverrun(OverrunStyle.ELLIPSIS);
		String tt = texMod.title;
		if(texMod.version.length() > 0)
			tt += " " + texMod.version;
		if(texMod.author.length() > 0)
			tt += String.format("%n") + AUTHOR + ": " + texMod.author;
		if(texMod.summary.length() > 0)
			tt += String.format("%n") + texMod.summary;
		tt += String.format("%n(") + TEX_MOD_CONFIGURE_TT + ")";
		title.setTooltip(new Tooltip(tt));
		midHBox = new HBox();
		midHBox.getStyleClass().add("mid_border");
		rightHBox = new HBox();
		rightHBox.setAlignment(Pos.CENTER_RIGHT);
		rightHBox.setSpacing(5.0);
		rightHBoxLeftSpacer = new Label(" ");
		rightHBoxLeftSpacer.setTextOverrun(OverrunStyle.CLIP);
		configureButton = new Button("...");
		configureButton.setTooltip(new Tooltip(CONFIGURE));
		configureButton.setStyle("-fx-font-weight: normal;");
		installButton = new Button(" ");
		installButton.setMinWidth(70.0);
		installButton.setStyle("-fx-font-weight: normal;");
		printInfoButton = new Button(PRINT_INFO);
		printInfoButton.setStyle("-fx-font-weight: normal;");
		writeInfoButton = new Button(WRITE + " " + MOD_INFO_FILE.substring(1));
		writeInfoButton.setStyle("-fx-font-weight: normal;");
		readmeButton = new Button(README);
		readmeButton.setStyle("-fx-font-weight: normal;");
		if(texMod.readme.length() > 0)
			readmeButton.setTooltip(new Tooltip(OPEN_README));
		else
			readmeButton.setTooltip(new Tooltip(NO_README_AVAILABLE));
		websiteButton = new Button(WEBSITE);
		websiteButton.setStyle("-fx-font-weight: normal;");
		if(texMod.website.length() < 1)
			websiteButton.setDisable(true);
		else
			websiteButton.setTooltip(new Tooltip(texMod.website));
		nexusButton = new Button(NEXUS);
		nexusButton.setStyle("-fx-font-weight: normal;");
		if(texMod.nexusId >= 0)
			nexusButton.setTooltip(new Tooltip(texMod.getNexusUrl()));
		else
			nexusButton.setTooltip(new Tooltip(NEXUS_HOME));
		installLabeller = new Label("    " + STATUS + ":");
		installLabeller.setStyle("-fx-font-weight: normal;");
		installLabeller.setTooltip(new Tooltip(tt));
		statusLabel = new Label();
		statusLabel.setMinWidth(80.0);
		statusLabel.setTooltip(new Tooltip(tt));
		installLabellerDialog = new Label(installLabeller.getText());
		installLabellerDialog.setStyle(installLabeller.getStyle());
		installLabellerDialog.setTooltip(new Tooltip(installLabeller.getTooltip().getText()));
		statusLabelDialog = new Label(statusLabel.getText());
		statusLabelDialog.setStyle(statusLabel.getStyle());
		statusLabelDialog.setMinWidth(statusLabel.getMinWidth());
		statusLabelDialog.setTooltip(new Tooltip(statusLabel.getTooltip().getText()));
		
		checkInstalled();
		
		leftHBox.getChildren().addAll(leftSpacer, /*select,*/ title);
		rightHBox.getChildren().addAll(rightHBoxLeftSpacer, /*readmeButton,*/ configureButton, installButton, /*printInfoButton,*/ /*websiteButton,*/ /*nexusButton,*/
										/*writeInfoButton,*/ /*deleteButton,*/ installLabeller, statusLabel);
		this.getChildren().addAll(leftHBox, midHBox, rightHBox);
		
		String configDialogMsg = this.texMod.title;
		if(this.texMod.version.length() > 0)
			configDialogMsg += " " + this.texMod.version;
		configDialogMsg += "\nAuthor: ";
		if(this.texMod.author.length() > 0)
			configDialogMsg += this.texMod.author;
		else
			configDialogMsg += UNKNOWN;
		configureDialog = new ContinueDialog(300.0, 200.0, EDIT_TEX_MOD_DIALOG_TITLE, /*configDialogMsg*/"", DIALOG_BUTTON_TEXTS[7], DIALOG_BUTTON_TEXTS[1]);
		configureDialog.layoutVBox.setSpacing(10.0);
		configureDialog.layoutVBox.setAlignment(Pos.CENTER);
		configureDialog.buttons.get(0).setDisable(true);
		Node dialogButtons = configureDialog.layoutVBox.getChildren().get(1);
		configureDialog.layoutVBox.getChildren().remove(1);
		HBox installedHBox = new HBox();
		installedHBox.setSpacing(5.0);
		installedHBox.setAlignment(Pos.CENTER);
		installedHBox.getChildren().addAll(installLabellerDialog, statusLabelDialog);
		HBox sitesHBox = new HBox();
		sitesHBox.setSpacing(5.0);
		sitesHBox.setAlignment(Pos.CENTER);
		VBox separatorVBox = new VBox();
		separatorVBox.setAlignment(Pos.CENTER);
		separatorVBox.setSpacing(8.0);
		HBox separatorHBox = new HBox();
		separatorVBox.getChildren().addAll(new HBox(), separatorHBox, new HBox());
		sitesHBox.getChildren().addAll(readmeButton, websiteButton, nexusButton);
		separatorHBox.getStyleClass().add("light_gray_background_border");
		
		configureVBox = new VBox();
		configureVBox.setSpacing(6.0);
		titleLabel = new Label(MOD_TITLE_KEY.substring(0, MOD_TITLE_KEY.length() - 1));
		titleLabel.getStyleClass().add("tex_mod_config_field_font");
		HBox cfgHBox = new HBox(titleLabel);
		cfgHBox.setAlignment(Pos.CENTER);
		titleField = new TextField(this.texMod.title);
		titleField.getStyleClass().add("settings_text_field_generic");
		titleField.setPromptText(titleLabel.getText());
		if(this.texMod.title.length() < 1)
			titleField.pseudoClassStateChanged(INVALID_INPUT, true);
		configureVBox.getChildren().add(new VBox(cfgHBox, titleField));
		HBox cfgHBox2 = new HBox();
		cfgHBox2.setSpacing(5.0);
		authorLabel = new Label(MOD_AUTHOR_KEY.substring(0, MOD_AUTHOR_KEY.length() - 1));
		authorLabel.getStyleClass().add("tex_mod_config_field_font");
		cfgHBox = new HBox(authorLabel);
		cfgHBox.setAlignment(Pos.CENTER);
		authorField = new TextField(this.texMod.author);
		authorField.getStyleClass().add("settings_text_field_generic");
		authorField.setPromptText(authorLabel.getText());
		cfgHBox2.getChildren().add(new VBox(cfgHBox, authorField));
		versionLabel = new Label(MOD_VERSION_KEY.substring(0, MOD_VERSION_KEY.length() - 1));
		versionLabel.getStyleClass().add("tex_mod_config_field_font");
		cfgHBox = new HBox(versionLabel);
		cfgHBox.setAlignment(Pos.CENTER);
		versionField = new TextField(this.texMod.version);
		versionField.getStyleClass().add("settings_text_field_generic");
		versionField.setPromptText(versionLabel.getText());
		versionField.setPrefWidth(65.0);
		authorField.setPrefWidth((configureDialog.dPane.getMinWidth() - ((cfgHBox2.getSpacing() * 7.0) + versionField.getPrefWidth())));
		cfgHBox2.getChildren().add(new VBox(cfgHBox, versionField));
		configureVBox.getChildren().add(cfgHBox2);
		categoryLabel = new Label(MOD_CATEGORY_KEY.substring(0, MOD_CATEGORY_KEY.length() - 1));
		categoryLabel.getStyleClass().add("tex_mod_config_field_font");
		cfgHBox = new HBox(categoryLabel);
		cfgHBox.setAlignment(Pos.CENTER);
		categoryField = new TextField();
		categoryField.getStyleClass().add("settings_text_field_generic");
		categoryField.setPromptText(categoryLabel.getText());
		if(this.texMod.category != 0)
			categoryField.setText(DsMod.categories.get(this.texMod.category));
		configureVBox.getChildren().add(new VBox(cfgHBox, categoryField));
		Label deleteBtTopSpacer = new Label(" ");
		deleteBtTopSpacer.getStyleClass().add("tex_mod_config_field_font");
		//deleteButton = new Button(DELETE + " mod (" + PERMANENTLY.toLowerCase() + ")");
		//deleteButton.setStyle("-fx-font-weight: normal;");
		deleteButton = new Button(DELETE + " mod");
		deleteButton.getStyleClass().add("red_text");
		deleteButton.setTooltip(new Tooltip(DELETE_TEX_MOD_TT));
		cfgHBox = new HBox(deleteButton);
		cfgHBox.setAlignment(Pos.CENTER);
		configureVBox.getChildren().add(new VBox(deleteBtTopSpacer, cfgHBox));
		
		configureDialog.layoutVBox.getChildren().addAll(installedHBox, sitesHBox, separatorVBox, /*new HBox(new Label(CONFIGURE + ":")),*/ configureVBox, dialogButtons);
		
		uninstallBeforeDelete = new CheckBox(DELETE_TEX_MOD_AND_UNINSTALL);
		uninstallBeforeDelete.setTooltip(new Tooltip(DELETE_TEX_MOD_AND_UNINSTALL_TT));
		uninstallBeforeDelete.setStyle("-fx-translate-x: -50; -fx-translate-y: -5;");
		
		this.initializeEventHandlers();
	}
	
	
	
	// Initialize the event handlers for GUI elements
	private void initializeEventHandlers(){
		/*select.setOnAction(e -> {
			
		});*/
		
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY) && mouseEvent.getClickCount() == 2){
                	configureMod();
                }
            }
        });
		
		configureButton.setOnAction(e -> {
			configureMod();
		});
		
		this.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldWidth, Number newWidth) {
                leftHBox.setMinWidth((newWidth.doubleValue() / 2.0) - 6.0);
                leftHBox.setMaxWidth((newWidth.doubleValue() / 2.0) - 6.0);
                //rightHBox.setMinWidth((newWidth.doubleValue() / 2.0) - 15.0);
                rightHBox.setMaxWidth((newWidth.doubleValue() / 2.0) - 15.0);
            }
        });
		
		installButton.setOnAction(e -> {
			switch(texMod.isInstalled()){
				case MOD_ENUM_INSTALLED:
				case MOD_ENUM_PART_INSTALLED:
					texMod.uninstall();
					break;
				case MOD_ENUM_NOT_INSTALLED:
				default:
					texMod.install();
					break;
			}
		});
		
		printInfoButton.setOnAction(e -> {
			MAIN_UI.printConsole("---------MOD INFO---------");
			MAIN_UI.printConsole("Title: " + texMod.title);
			MAIN_UI.printConsole("Version: " + texMod.version);
			MAIN_UI.printConsole("Author: " + texMod.author);
			MAIN_UI.printConsole("Category: " + texMod.category + " (\"" + DsMod.categories.get(texMod.category) + "\")");
			MAIN_UI.printConsole("Website: " + texMod.website);
			if(texMod.nexusId >= 0)
				MAIN_UI.printConsole("NexusID: " + texMod.nexusId + " (Page: " + GET_MODS_URL + "mods/" + texMod.nexusId + ")");
			else
				MAIN_UI.printConsole("NexusID: " + texMod.nexusId);
			MAIN_UI.printConsole("Readme: " + texMod.readme);
			MAIN_UI.printConsole("Install folder: " + texMod.installSubDir);
			MAIN_UI.printConsole("Storage folder: " + texMod.storagePath);
			MAIN_UI.printConsole("Status: " + MOD_STATUS[texMod.isInstalled()]);
			MAIN_UI.printConsole("Summary: " + texMod.summary);
			if(texMod.description.size() > 0){
				MAIN_UI.printConsole("Description: ");
				MAIN_UI.printConsole(texMod.getDescription("    "));
			}
			if(texMod.fileCount() == 1)
				MAIN_UI.printConsole(texMod.fileCount() + " File: ");
			else
				MAIN_UI.printConsole(texMod.fileCount() + " Files: ");
			for(int i = 0; i < texMod.files.size(); i++){
				MAIN_UI.printConsole("    " + texMod.files.get(i));
				MAIN_UI.printConsole("        Size: " + texMod.fileSizes[i] + " bytes");
				MAIN_UI.printConsole("        SHA-1 Hash: " + texMod.hashes.get(i));
			}
			if(texMod.excludedFiles.size() == 1)
				MAIN_UI.printConsole(texMod.excludedFiles.size() + " Excluded file: ");
			else
				MAIN_UI.printConsole(texMod.excludedFiles.size() + " Excluded files: ");
			for(int i = 0; i < texMod.excludedFiles.size(); i++){
				MAIN_UI.printConsole("    " + texMod.excludedFiles.get(i));
			}
			MAIN_UI.printConsole("------END OF MOD INFO------\n");
			MAIN_UI.printConsole("");
		});
		
		deleteButton.setOnAction(e -> {
			ContinueDialog cD = new ContinueDialog(400.0, 50.0, DELETE_TEX_MOD_DIALOG_TITLE, DELETE_TEX_MOD_DIALOG_MSG, DELETE, DIALOG_BUTTON_TEXTS[1]);
			if(texMod.isInstalled() != MOD_ENUM_NOT_INSTALLED){
				cD.buttonsPane.getChildren().add(0, uninstallBeforeDelete);
			}
			
			if(cD.show()){
				configureDialog.close();
				
				if(uninstallBeforeDelete.isSelected()){
					texMod.uninstall();
				}
				
				texMod.delete();
				MAIN_UI.refreshUI();
			}
		});
		
		readmeButton.setOnAction(e -> {
			texMod.openReadme();
		});
		
		websiteButton.setOnAction(e -> {
			texMod.openWebsite();
		});
		
		nexusButton.setOnAction(e -> {
			texMod.openNexusPage();
		});
		
		writeInfoButton.setOnAction(e -> {
			texMod.writeInfoFile();
		});
		
		titleField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
            	if(titleField.getText().length() < 1){
            		titleField.pseudoClassStateChanged(INVALID_INPUT, true);
            	}else{
            		titleField.pseudoClassStateChanged(INVALID_INPUT, false);
            	}
            	
            	if(!hasInvalidInputs())
            		configureDialog.buttons.get(0).setDisable(false);
            	else
            		configureDialog.buttons.get(0).setDisable(true);
            }
		});
		
		authorField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
            	if(!hasInvalidInputs())
            		configureDialog.buttons.get(0).setDisable(false);
            	else
            		configureDialog.buttons.get(0).setDisable(true);
            }
		});
		
		versionField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
            	if(!hasInvalidInputs())
            		configureDialog.buttons.get(0).setDisable(false);
            	else
            		configureDialog.buttons.get(0).setDisable(true);
            }
		});
		
		categoryField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
            	if(!hasInvalidInputs())
            		configureDialog.buttons.get(0).setDisable(false);
            	else
            		configureDialog.buttons.get(0).setDisable(true);
            }
		});
	}
	
	
	
	
	//////////////// Getters ////////////////
	
	// Obtain the texture mod associated with this pane
	public DsTextureMod getTexMod(){
		return this.texMod;
	}
	
	// Get the selected state
	public boolean selected(){
		return this.select.isSelected();
	}
	
	
	
	
	
	//////////////// Setters ////////////////
	
	// Set the selected state
	public void setSelected(boolean newState){
		this.select.setSelected(newState);
	}
	
	
	// Check installed state
	public int checkInstalled(){
		int newState = texMod.isInstalled();
		statusLabel.getStyleClass().clear();
		statusLabelDialog.getStyleClass().clear();
		switch(newState){
			case MOD_ENUM_INSTALLED:
				installButton.setText(UNINSTALL);
				installButton.setTooltip(new Tooltip(UNINSTALL + " " + texMod.title));
				statusLabel.getStyleClass().addAll("label", "green_text");
				statusLabelDialog.getStyleClass().addAll("label", "green_text", "bold_text");
				break;
			case MOD_ENUM_NOT_INSTALLED:
				installButton.setText(INSTALL);
				installButton.setTooltip(new Tooltip(INSTALL + " " + texMod.title));
				statusLabel.getStyleClass().addAll("label", "red_text");
				statusLabelDialog.getStyleClass().addAll("label", "red_text", "bold_text");
				break;
			case MOD_ENUM_PART_INSTALLED:
			default:
				installButton.setText(UNINSTALL);
				installButton.setTooltip(new Tooltip(REMOVE_PART_INSTALL));
				statusLabel.getStyleClass().addAll("label", "red_text");
				statusLabelDialog.getStyleClass().addAll("label", "red_text", "bold_text");
				break;
		}
		statusLabel.setText(MOD_STATUS[newState] + "   ");
		statusLabelDialog.setText(statusLabel.getText());
		return newState;
	}
	
	
	public void configureMod(){
		if(configureDialog.show()){
			if(titleField.getText().length() > 0)
				texMod.title = titleField.getText();
    		texMod.author = authorField.getText();
    		texMod.version = versionField.getText();
    		if(categoryField.getText().toUpperCase().equals(UNCATEGORIZED.toUpperCase()))
    			categoryField.setText("");
    		int newCategory = DsMod.categories.indexOf(categoryField.getText().toUpperCase());
    		if(newCategory < 0){
    			DsMod.categories.add(categoryField.getText().toUpperCase());
				texMod.category = DsMod.categories.size() - 1;
    		}else{
    			texMod.category = newCategory;
    		}
    		
    		texMod.writeInfoFile();
    		MAIN_UI.refreshUI();
    	}
		
		refresh();
	}
	
	
	private void refresh(){
		title.setText(this.texMod.title);
		String tt = texMod.title;
		if(texMod.version.length() > 0)
			tt += " " + texMod.version;
		if(texMod.author.length() > 0)
			tt += String.format("%n") + AUTHOR + ": " + texMod.author;
		if(texMod.summary.length() > 0)
			tt += String.format("%n") + texMod.summary;
		tt += String.format("%n(") + TEX_MOD_CONFIGURE_TT + ")";
		title.setTooltip(new Tooltip(tt));
		if(texMod.readme.length() > 0)
			readmeButton.setTooltip(new Tooltip(OPEN_README));
		else
			readmeButton.setTooltip(new Tooltip(NO_README_AVAILABLE));
		if(texMod.website.length() < 1)
			websiteButton.setDisable(true);
		else{
			websiteButton.setDisable(false);
			websiteButton.setTooltip(new Tooltip(texMod.website));
		}
		if(texMod.nexusId >= 0)
			nexusButton.setTooltip(new Tooltip(texMod.getNexusUrl()));
		else
			nexusButton.setTooltip(new Tooltip(NEXUS_HOME));
		installLabeller.setTooltip(new Tooltip(tt));
		statusLabel.setTooltip(new Tooltip(tt));
		installLabellerDialog.setTooltip(new Tooltip(installLabeller.getTooltip().getText()));
		statusLabelDialog.setTooltip(new Tooltip(statusLabel.getTooltip().getText()));
		String configDialogMsg = this.texMod.title;
		if(this.texMod.version.length() > 0)
			configDialogMsg += " " + this.texMod.version;
		configDialogMsg += "\nAuthor: ";
		if(this.texMod.author.length() > 0)
			configDialogMsg += this.texMod.author;
		else
			configDialogMsg += UNKNOWN;
		//configureDialog.messageLabel.setText(configDialogMsg);
		
		
		uninstallBeforeDelete.setSelected(false);
		configureDialog.buttons.get(0).setDisable(true);
		
		titleField.setText(this.texMod.title);
		authorField.setText(this.texMod.author);
		versionField.setText(this.texMod.version);
		
		if(this.texMod.category != 0)
			categoryField.setText(DsMod.categories.get(this.texMod.category));
        else
        	categoryField.setText("");
		
		if(this.texMod.title.length() < 1){
			titleField.pseudoClassStateChanged(INVALID_INPUT, true);
		}else{
			titleField.pseudoClassStateChanged(INVALID_INPUT, false);
		}
		
		authorField.pseudoClassStateChanged(INVALID_INPUT, false);
		versionField.pseudoClassStateChanged(INVALID_INPUT, false);
		categoryField.pseudoClassStateChanged(INVALID_INPUT, false);
		
		checkInstalled();
	}
	
	
	// Check if any dialog input fields have invalid inputs
	public boolean hasInvalidInputs(){
        ArrayList<TextField> fields = new ArrayList<TextField>();
        
        fields.add(titleField);
        fields.add(authorField);
        fields.add(versionField);
        fields.add(categoryField);
        
        for(TextField field : fields){
            if(field.getPseudoClassStates().toString().contains("invalid")){
                return true;
            }
        }
        
        return false;
    }
	
}
