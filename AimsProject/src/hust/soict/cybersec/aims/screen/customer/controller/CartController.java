package hust.soict.cybersec.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.exception.PlayerException;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Playable;
import hust.soict.cybersec.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	@FXML
	private Button btnPlaceOrder;
	
	@FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;
    
    @FXML
    private TextField tfFiilter;
    
    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    @FXML
    void btnPlaceOrderClicked(ActionEvent event) {
    	cart.clearCart();
    	updateCostLabel();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	
    	if (media instanceof Playable) {
    		((Playable) media).play();
    	}
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	updateCostLabel();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String CART_FXML_FILE_PATH = "/hust/soict/cybersec/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
    		fxmlLoader.setController(new ViewStoreController(store, cart));
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    public void initialize() {
    	colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	
    	if (cart.getItemsOrdered() != null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
        	void updateButtonBar(Media media) {
        		if (media == null) {
        			btnPlay.setVisible(false);
        			btnRemove.setVisible(false);
        		} else {
        			btnRemove.setVisible(true);
        			if (media instanceof Playable) {
        				btnPlay.setVisible(true);
        			} else {
        				btnPlay.setVisible(false);
        			}
        		}
        	}
        	
    		@Override
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			updateButtonBar(newValue);
    		}
    	});
    	
    	FilteredList<Media> filteredData = cart.getFilteredItems();
    	tblMedia.setItems(filteredData);

    	tfFiilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue, filteredData);
        });
    	
    	cart.getItemsOrdered().addListener((ListChangeListener.Change<? extends Media> c) -> {
    	    updateCostLabel();
    	});
    	
    	updateCostLabel();
    }
    
    private void updateCostLabel() {
    	float totalCost = 0;
    	for (Media media : cart.getItemsOrdered()) {
    		totalCost += media.getCost();
    	}
    	
    	costLabel.setText(String.format("%.2f", totalCost));
    }
    
    public void showFilteredMedia(String filterString, FilteredList<Media> filteredData) {
        if (filterString == null || filterString.isEmpty()) {
            filteredData.setPredicate(null);
        } else {
            filteredData.setPredicate(media -> {
                String lowerCaseFilter = filterString.toLowerCase();
                
                if (radioBtnFilterTitle.isSelected() && media.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches title.
                } else if (radioBtnFilterId.isSelected() && String.valueOf(media.getId()).equals(lowerCaseFilter)) {
                    return true; // Filter matches ID.
                }
                return false; // Does not match.
            });
        }
    }
    
    private Cart cart;
    private Store store;
    
    public CartController(Store store, Cart cart) {
    	this.store = store;
    	this.cart = cart;
    }

	public CartController() {
		// TODO Auto-generated constructor stub
	}

}
