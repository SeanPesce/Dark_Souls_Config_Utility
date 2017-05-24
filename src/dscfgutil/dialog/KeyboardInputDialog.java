/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.dialog;

import static dscfgutil.DSCfgUtilConstants.CSS_DIRECTORY;
import static dscfgutil.DSCfgUtilConstants.DIALOG_BUTTON_TEXTS;
import static dscfgutil.DSCfgUtilConstants.IMAGE_DIRECTORY;
import static dscfgutil.DSCfgUtilConstants.PROGRAM_ICON;
import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.NONE;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 *
 * @author Sean Pesce
 */
public class KeyboardInputDialog {
    
    Alert alert;
    Stage stage;
    DialogPane dPane;
    ColumnConstraints layoutColumn;
    GridPane layoutGridPane;
    VBox layoutVBox;
    HBox labelHBox;
    Label messageLabel;
    ColumnConstraints buttonsColumn;
    GridPane buttonsGrid;
    HBox buttonsPane;
    ArrayList<Button> buttons;
    
    int keyValue; // Virtual key code of the newly assigned keybind
    
    
    
    public KeyboardInputDialog(String newTitle, String newMessage){
        initialize(300.0, 80.0, newTitle, newMessage,
                    "file:" + IMAGE_DIRECTORY + "\\" + PROGRAM_ICON);
        
        initializeButtons(new String[]{DIALOG_BUTTON_TEXTS[1]}); // "Cancel" button
        
        initializeCancelButton(buttons.get(0));
        
        stage.getScene().setOnKeyPressed(e -> {
        	keyValue = e.getCode().impl_getCode(); // Return virtual key code
        	close();
        });
    }
    
    public int show(){
        alert.showAndWait();
        return keyValue;
    }
    
    private void initialize(double x, double y, String initDialogTitle,
                            String initMessage, String initWindowIconPath){
        alert = new Alert(NONE);
        alert.setResizable(false);
        stage = (Stage)alert.getDialogPane().getScene().getWindow();
        stage.getScene().getStylesheets().add(getClass().getResource(
                                               CSS_DIRECTORY).toExternalForm());
        
        stage.getIcons().add(new Image(initWindowIconPath));
        stage.setTitle(initDialogTitle);
        dPane = alert.getDialogPane();
        dPane.setMinWidth(x);
        dPane.setMinHeight(y);
        
        layoutGridPane = new GridPane();
        layoutColumn = new ColumnConstraints();
        layoutColumn.setPercentWidth(100.0);
        layoutColumn.setFillWidth(true);
        layoutGridPane.getColumnConstraints().add(layoutColumn);
        
        layoutVBox = new VBox();
        
        messageLabel = new Label(initMessage);
        messageLabel.setWrapText(true);
        messageLabel.setMaxWidth(x - 20.0);
        labelHBox = new HBox();
        labelHBox.getChildren().add(messageLabel);
        layoutVBox.getChildren().add(labelHBox);
        layoutGridPane.add(layoutVBox, 0, 0);
        
        dPane.setContent(layoutGridPane);
        
        stage.setOnCloseRequest(e -> {
        	keyValue = 0;
            close();
        });
    }
    
    private void initializeButtons(String[] btTexts){
        buttonsPane = new HBox();
        buttons = new ArrayList<>();
        buttonsColumn = new ColumnConstraints();
        buttonsColumn.setPercentWidth(100.0);
        buttonsColumn.setFillWidth(true);
        buttonsColumn.setHalignment(HPos.RIGHT);
        buttonsGrid = new GridPane();
        buttonsGrid.getColumnConstraints().add(buttonsColumn);
        buttonsPane.getStyleClass().add("dialog_buttons_pane");
        
        for(int i = 0; i < btTexts.length; i++){
            buttons.add(new Button());
            buttons.get(i).setText(btTexts[i]);
            buttonsPane.getChildren().add(buttons.get(i));
        }
        
        buttons.get(0).setFocusTraversable(false);
        
        buttonsGrid.add(buttonsPane, 0, 0);
        layoutVBox.getChildren().add(buttonsGrid);
    }
    
    private void initializeCancelButton(Button cancelBT){
        cancelBT.setOnAction(e -> {
        	keyValue = 0;
            close();
        });
    }
    
    private void close(){
        stage.close();
        alert.close();
    }
}

