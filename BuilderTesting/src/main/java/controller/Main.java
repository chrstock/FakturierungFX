package controller;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/controller/view.fxml"));
			stage.setTitle("Rüas Fakturierung");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), e.getClass().toString(), JOptionPane.ERROR_MESSAGE);
			System.out.println(e.getClass()+" "+ e.getMessage());
		}
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
