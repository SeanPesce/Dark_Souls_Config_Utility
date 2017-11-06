/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.view;

import static dscfgutil.DSCfgUtilConstants.DIALOG_BUTTON_TEXTS;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_MOD;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_MOD_DIALOG_CHOICES;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_MOD_DIALOG_CHOICES_TT;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_MOD_DIALOG_MESSAGE;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_MOD_DIALOG_TITLE;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_MOD_DIALOG_ZIP;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_MOD_DIALOG_ZIP_TT;
import static dscfgutil.DSCfgUtilConstants.LOAD_TEX_MOD_TT;
import static dscfgutil.DSCfgUtilConstants.MAIN_UI;
import static dscfgutil.DSCfgUtilConstants.TEXTURE_MOD;
import static dscfgutil.DSCfgUtilConstants.TEX_MOD_DISCLAIMER;
import static dscfgutil.DSCfgUtilConstants.UNCATEGORIZED;
import dscfgutil.configs.DSFConfiguration;
import dscfgutil.configs.DsMod;
import dscfgutil.configs.DsTextureMod;
import dscfgutil.dialog.ChoiceDialog;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Sean Pesce
 */
public class DSFTextureModPane extends ScrollPane{
    
    //Main UI Components
    GridPane primaryPane;
    ScrollBar scrollBar = null;
    ColumnConstraints spacerColumn;
    ColumnConstraints primaryColumn;
    VBox primaryVBox;
    HBox titleBar;
    Label titleLabel;
    HBox warningBar;
    Label disclaimerLabel;
    HBox buttonBar;
    Button loadModsButton;
    HBox spacerHBox;
    HBox bottomSpacerHBox;
    //
    //Settings components
    //
    
    
    //Instance Variables
    DSCfgMainUI ui;
    DSFConfiguration config;
    int tabIndex = 9;
    
     public DSFTextureModPane(DSCfgMainUI initUI){
        ui = initUI;
        config = ui.getConfig();
        initialize();
    }
    
    //Build the pane
    public void initialize(){
        
        //Basic layout
        this.setFitToWidth(true);
        
        spacerColumn = new ColumnConstraints();
        spacerColumn.setFillWidth(true);
        spacerColumn.setPercentWidth(3.0);
        primaryColumn = new ColumnConstraints();
        primaryColumn.setFillWidth(true);
        primaryColumn.setPercentWidth(95.0);
        primaryPane = new GridPane();
        primaryPane.getColumnConstraints().addAll(spacerColumn, primaryColumn);
        primaryVBox = new VBox();
        primaryVBox.getStyleClass().add("spacing_15");
        primaryPane.add(primaryVBox, 1, 0);
        titleLabel = new Label(TEXTURE_MOD.toUpperCase() + "S");
        titleLabel.getStyleClass().add("settings_title");
        titleBar = new HBox();
        titleBar.setAlignment(Pos.CENTER);
        titleBar.getChildren().add(titleLabel);
        warningBar = new HBox();
        warningBar.setAlignment(Pos.CENTER);
        warningBar.setSpacing(5.0);
        disclaimerLabel = new Label(TEX_MOD_DISCLAIMER);
        warningBar.getChildren().add(disclaimerLabel);
        buttonBar = new HBox();
        buttonBar.setAlignment(Pos.CENTER);
        buttonBar.setSpacing(5.0);
        loadModsButton = new Button(LOAD_TEX_MOD);
        loadModsButton.setTooltip(new Tooltip(LOAD_TEX_MOD_TT));
        //loadModsButton.getStyleClass().add("translate_y_4");
        //deleteModsButton.getStyleClass().add("translate_y_4");
        buttonBar.getChildren().addAll(loadModsButton/*, deleteModsButton*/);
        spacerHBox = new HBox();
        spacerHBox.setMinHeight(10.0);
        bottomSpacerHBox = new HBox();
        bottomSpacerHBox.setMinHeight(10.0);
        //
        
        
       primaryVBox.getChildren().addAll(titleBar, warningBar, buttonBar/*, spacerHBox*/);

       for(int i = 0; i < DsMod.categories.size(); i++){
    	   VBox vb = new VBox();
    	   //vb.getStyleClass().add("spacing_15");
    	   vb.setStyle("-fx-spacing: 0;");
    	   vb.setPadding(new Insets(0, 0, 0, 0));
    	   TitledPane tp = new TitledPane(DsMod.categories.get(i), vb);
    	   if(i==0)
    		   tp.setText(UNCATEGORIZED.toUpperCase());
    	   tp.getStyleClass().addAll("bold_text");
    	   int count = 0;
    	   for(DsTextureMod mod : DsTextureMod.texMods){
    		   if(mod.category == i){
    			   vb.getChildren().add(mod.pane);
    			   count++;
    		   }
    	   }
    	   if(count > 0)
    		   primaryVBox.getChildren().add(tp);
       }
        
        primaryVBox.getChildren().add(bottomSpacerHBox);
        initializeEventHandlers();
        
        this.setContent(primaryPane);
        
        ui.scrollbarWidth = getScrollbarWidth();
    	ui.updateStatusBarShadow();
    }
    
    public void initializeEventHandlers(){
    	
        // Check for ScrollBar being added to the pane
        this.getChildren().addListener( new ListChangeListener<Node>() {
    		@Override
    		public void onChanged(javafx.collections.ListChangeListener.Change<? extends Node> newNodes) {
    			// With help from: https://stackoverflow.com/questions/24810197/how-to-know-if-a-scroll-bar-is-visible-on-a-javafx-tableview
    			if(scrollBar == null){
    				for(Node node : newNodes.getList()){
    					if (node instanceof ScrollBar) {
    		                if (((ScrollBar)node).getOrientation().equals(Orientation.VERTICAL)) {
    		                	scrollBar = (ScrollBar)node;
    		                	scrollBar.setStyle("-fx-border-color: #bfbfbf; -fx-border-thickness: 1;");
    		                	
    		                	scrollBar.visibleProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
    		                		if(ui.getCurrentTab() == tabIndex){
    		                			ui.scrollbarWidth = getScrollbarWidth();
        		                		ui.updateStatusBarShadow();
    		                		}
    		                		
    		                	});
    		                	
    		                	if(ui.getCurrentTab() == tabIndex){
		                			ui.scrollbarWidth = getScrollbarWidth();
    		                		
		                		}
    		                }
    		            }
    				}
    			}
    		}
        });
        
        loadModsButton.setOnAction(e -> {
        	ChoiceDialog cD = new ChoiceDialog(300.0, 100.0, LOAD_TEX_MOD_DIALOG_TITLE, LOAD_TEX_MOD_DIALOG_MESSAGE,
        										LOAD_TEX_MOD_DIALOG_CHOICES, DIALOG_BUTTON_TEXTS[0], DIALOG_BUTTON_TEXTS[1],
        										ChoiceDialog.VERTICAL_CHOICES);
        	cD.choices.get(0).setTooltip(new Tooltip(LOAD_TEX_MOD_DIALOG_CHOICES_TT[0]));
        	cD.choices.get(1).setTooltip(new Tooltip(LOAD_TEX_MOD_DIALOG_CHOICES_TT[1]));
        	CheckBox loadFromZip = new CheckBox(LOAD_TEX_MOD_DIALOG_ZIP);
        	loadFromZip.setTooltip(new Tooltip(LOAD_TEX_MOD_DIALOG_ZIP_TT));
        	loadFromZip.setStyle("-fx-translate-x: -59; -fx-translate-y: -5;");
        	cD.buttonsPane.getChildren().add(0, loadFromZip);
        	
        	switch(cD.show()){
        		case 0: // Loading single texture mod
        			if(DsTextureMod.loadNewModFromGUI(loadFromZip.isSelected())){
        				// Mod was loaded successfully
        				MAIN_UI.refreshUI();
        			}
	        		break;
	        	case 1: // Loading texture mod pack
	        		if(DsTextureMod.loadNewModPackFromGUI(loadFromZip.isSelected()) > 0){
	        			// At least 1 new mod was loaded successfully
	        			MAIN_UI.refreshUI();
	        		}
	        		break;
        		default:
        			// Cancelled
        			break;
        	}
        });
        
    }
    
    public double getScrollbarWidth() {
    	if(this.scrollBar == null || !this.scrollBar.isVisible())
    		return 0.0;
    	else
    		return this.scrollBar.getWidth() - 4.0;
    }
}
