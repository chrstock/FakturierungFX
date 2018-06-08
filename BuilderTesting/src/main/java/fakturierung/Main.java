package fakturierung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private List<Auftrag> auftragsListe = new ArrayList<>();
	private static final String PFAD = "C:\\Users\\chrstock\\Desktop\\example3.csv";

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fakturierung/view.fxml"));
			stage.setTitle("Rüas Fakturierung");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), e.getClass().toString(), JOptionPane.ERROR_MESSAGE);
		}

		leseCSV();

	}

	public static void main(String[] args) {

		launch(args);

	}

	public void leseCSV() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PFAD));
			// Skip first line
			reader.readLine();
			String line = null;

			while ((line = reader.readLine()) != null) {
				if (line.isEmpty()) {
					break;
				}
				auftragsListe.add(new Auftrag(line.split(",")));
			}

			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void schreibeCSV() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\chrstock\\Desktop\\example4.csv"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
