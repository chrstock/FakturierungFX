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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static List<Auftrag> auftragsListe = new ArrayList<>();
	private static final String PFAD = "C:\\Users\\chrstock\\Desktop\\example4.csv";
	private static Controller myController;

	@Override
	public void stop() throws Exception {
		try {
			// schreibeCSV();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Datei konnte nicht gespeichert werden");
			return;
		}
	}

	@Override
	public void init() throws Exception {

	}

	@Override
	public void start(Stage stage) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fakturierung/view.fxml"));
			Parent root = loader.load();
			myController = loader.getController();

			stage.setTitle("Rüas Fakturierung");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), e.getClass().toString(), JOptionPane.ERROR_MESSAGE);
		}
		aktualisiereAnsicht();
		// fehlender Eventhandler
	}

	private static void aktualisiereAnsicht() {
		ObservableList<String> content = FXCollections.observableArrayList();
		content.add("Test1");
		content.add("test2");
		myController.listView.setItems(myController.content);
	}

	public static void main(String[] args) {
		leseCSV();
		launch(args);
	}

	public static void leseCSV() {
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

	public void schreibeCSV() throws IOException {
		if (auftragsListe.isEmpty()) {
			return;
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter(PFAD));
		for (Auftrag auftrag : auftragsListe) {
			writer.write(auftrag.toCSV());
			writer.newLine();
		}
		writer.close();
	}

}
