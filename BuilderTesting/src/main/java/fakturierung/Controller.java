package fakturierung;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Controller {
	
	@FXML
	private ListView<String> listView;
	
	@FXML
	public void newButtonClicked() {
		System.out.println("Unser Neu Button...");
	}

}
