package fakturierung;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Controller {

	public Controller() {
	}

	public ObservableList<String> content = FXCollections.observableArrayList();

	@FXML
	public ListView<String> listView;

	@FXML
	public void newButtonClicked() {
		System.out.println();
	}
	
	

}
