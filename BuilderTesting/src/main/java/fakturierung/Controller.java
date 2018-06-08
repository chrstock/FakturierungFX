package fakturierung;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Controller {

	ObservableList<String> listenTest = FXCollections.observableArrayList();
	
	@FXML
	private ListView<String> listView;

	@FXML
	public void newButtonClicked() {
		addEintrag("test");
	}

	@FXML
	public void addEintrag(String titel) {
		listenTest.add(titel);
		listView.setItems(listenTest);
	}

}
