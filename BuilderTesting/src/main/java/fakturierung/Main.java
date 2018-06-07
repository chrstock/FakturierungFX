package fakturierung;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

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
			Parent root = FXMLLoader.load(getClass().getResource("/fakturierung/view.fxml"));
			stage.setTitle("Rüas Fakturierung");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), e.getClass().toString(), JOptionPane.ERROR_MESSAGE);
			System.out.println(e.getClass() + " " + e.getMessage());
		}

	}

	public static void main(String[] args) {
		launch(args);

		StringBuilder text = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\chrstock\\Desktop\\example.csv"));
			text.append(reader.readLine());
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(text);
	}

}
