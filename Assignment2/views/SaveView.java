package views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/** 
 * Save File View
 * 
 * Based on the Tetris assignment in the Nifty Assignments Database, authored by Nick Parlante
 */
public class SaveView {

    static String saveFileSuccess = "Saved board!!";
    static String saveFileExistsError = "Error: File already exists";
    static String saveFileNotSerError = "Error: File must end with .ser";
    private Label saveFileErrorLabel = new Label("");
    private Label saveBoardLabel = new Label(String.format("Enter name of file to save"));
    private TextField saveFileNameTextField = new TextField("");
    private Button saveBoardButton = new Button("Save board");
    TetrisView tetrisView;

     /**
         * Constructor
         * 
         * @param tetrisView master view
         */
    public SaveView(TetrisView tetrisView) {
        this.tetrisView = tetrisView;

        tetrisView.paused = true;
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(tetrisView.stage);
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20, 20, 20, 20));
        dialogVbox.setStyle("-fx-background-color: #121212;");


        saveBoardLabel.setId("SaveBoard"); // DO NOT MODIFY ID
        saveFileErrorLabel.setId("SaveFileErrorLabel");
        saveFileNameTextField.setId("SaveFileNameTextField");
        saveBoardLabel.setStyle("-fx-text-fill: #e8e6e3;");
        saveBoardLabel.setFont(new Font(16));
        saveFileErrorLabel.setStyle("-fx-text-fill: #e8e6e3;");
        saveFileErrorLabel.setFont(new Font(16));
        saveFileNameTextField.setStyle("-fx-text-fill: #e8e6e3;");
        saveFileNameTextField.setFont(new Font(16));

        String boardName = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".ser";
        saveFileNameTextField.setText(boardName);

        saveBoardButton = new Button("Save board");
        saveBoardButton.setId("SaveBoard"); // DO NOT MODIFY ID
        saveBoardButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");
        saveBoardButton.setPrefSize(200, 50);
        saveBoardButton.setFont(new Font(16));
        saveBoardButton.setOnAction(e -> saveBoard());

        VBox saveBoardBox = new VBox(10, saveBoardLabel, saveFileNameTextField, saveBoardButton, saveFileErrorLabel);

        dialogVbox.getChildren().add(saveBoardBox);
        Scene dialogScene = new Scene(dialogVbox, 400, 400);
        dialog.setScene(dialogScene);
        dialog.show();
        dialog.setOnCloseRequest(event -> {
            tetrisView.paused = false;
        });

    }

    /**
     * Save the board to a file 
     */
    public void saveBoard() {
        try {
            String s = saveFileNameTextField.getText();

            File myObj = new File("C:\\Users\\huang\\liukuant\\Assignment2\\boards\\"+s+".ser");

            if (myObj.createNewFile()) {
                ObjectOutputStream obout = new ObjectOutputStream(new FileOutputStream(myObj));
                obout.writeObject(tetrisView.model);
                System.out.println(saveFileSuccess);
            } else if(!myObj.getName().endsWith("ser")){
                System.out.println(saveFileNotSerError);
            }else
            {
                System.out.println(saveFileExistsError);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
