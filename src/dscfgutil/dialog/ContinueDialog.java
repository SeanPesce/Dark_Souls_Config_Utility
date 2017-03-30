/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.dialog;

import static dscfgutil.DSCfgUtilConstants.CSS_DIRECTORY;
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
public class ContinueDialog {
    
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
    
    boolean proceed;
    
    
    
    public ContinueDialog(double newW, double newH, String newTitle, String newMessage,
                          String continueTxt, String cancelTxt){
        initialize(newW, newH, newTitle, newMessage,
                    "file:" + IMAGE_DIRECTORY + "\\" + PROGRAM_ICON);
        
        initializeButtons(new String[]{continueTxt, cancelTxt});
        
        initializeOKButton(buttons.get(0));
        initializeCancelButton(buttons.get(1));
        
    }
    
    public boolean show(){
        alert.showAndWait();
        
        return proceed;
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
            proceed = false;
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
        
        buttonsGrid.add(buttonsPane, 0, 0);
        layoutVBox.getChildren().add(buttonsGrid);
    }
    
    private void initializeCancelButton(Button cancelBT){
        cancelBT.setOnAction(e -> {
            proceed = false;
            close();
        });
    }
    
    private void initializeOKButton(Button okBT){
        okBT.setOnAction(e -> {
            proceed = true;
            close();
        });
    }
    
    private void close(){
        stage.close();
        alert.close();
    }
}

