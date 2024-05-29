package hust.soict.cybersec.aims.screen.customer.controller;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Playable;
import hust.soict.cybersec.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {
	
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
    void btnPlayPressed(ActionEvent event) {

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {

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
