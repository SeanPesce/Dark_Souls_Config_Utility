/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil;

import dscfgutil.view.DSCfgMainUI;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 *
 * @author Sean Pesce
 */
public class DSCfgUtil extends Application {
    
    DSCfgMainUI ui;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        ui = new DSCfgMainUI(primaryStage);
        
    }
}
