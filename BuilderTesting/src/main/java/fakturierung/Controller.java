package fakturierung;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import tools.FileManager;

public class Controller implements Initializable {

	private List<Auftrag> orderList = new ArrayList<>();
	private static final String PATH = "C:\\Users\\chrstock\\Desktop\\example4.csv";

	public Controller() {
	}

	public ObservableList<String> listContent = FXCollections.observableArrayList();

	@FXML
	public ListView<String> listView;

	@FXML
	public void newButtonClicked() {
		System.out.println();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initListView();
	}

	private void initListView() {
		String content = FileManager.readFile(PATH);
		for (String s : content.split(System.lineSeparator())) {
			orderList.add(new Auftrag(s.split(",")));
		}
		for (Auftrag order : orderList) {
			listContent.add(order.getName());
		}
		listView.setItems(listContent);
	}

}
