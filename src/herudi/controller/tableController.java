/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herudi.controller;

import herudi.model.Artist;
import herudi.model.artisName;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.util.Callback;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author Herudi
 */
public class tableController implements Initializable {
    @FXML
    private TableView<Artist> tableData;
    @FXML
    private TableColumn<Artist, artisName> colName;
    @FXML
    private TableColumn<Artist, String> colHome;
    @FXML
    private TableColumn colAction;
    public static ObservableList<Artist> listData = FXCollections.observableArrayList();
    public static ObservableList<Artist> listDataProperties = FXCollections.observableArrayList();
    Integer StatusAction = 0;
    @FXML
    private TableColumn<Artist, String> colHit;
    @FXML
    private TableColumn<Artist, Integer> colRating;
    public static IntegerProperty statusEdit = new SimpleIntegerProperty();
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colName.setCellValueFactory(new PropertyValueFactory<>("artisName"));
        colHit.setCellValueFactory(new PropertyValueFactory("hit"));
        colRating.setCellValueFactory(new PropertyValueFactory("rating"));
        colHome.setCellValueFactory(new PropertyValueFactory("homeBase"));
        colAction.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Object, Boolean>,ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Object, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
        colAction.setCellFactory(new Callback<TableColumn<Object, Boolean>, TableCell<Object, Boolean>>() {
            @Override
            public TableCell<Object, Boolean> call(TableColumn<Object, Boolean> p) {
                return new ButtonCell(tableData);
            }
        });
        colName.setCellFactory((TableColumn<Artist, artisName> param) -> new AttachmentColumnCell());
        colRating.setCellFactory((TableColumn<Artist, Integer> param) -> new AttachmentColumnCellRating());
        colHome.setCellFactory((TableColumn<Artist, String> param) -> new AttachmentColumnCellResize());
        tableData.setItems(listData);
        
        // TODO
    }    

    @FXML
    private void klikTableData(MouseEvent event) {
        if (StatusAction ==1) {
            try {
                Artist klik = tableData.getSelectionModel().getSelectedItem();
                
            } catch (Exception e) {
            }
        }
        
    }
    
    private static class AttachmentColumnCell extends TableCell<Artist, artisName> {
        private Text text;
        @Override
        public void updateItem(artisName item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
                setText(null);
            } else {
                text = new Text(item.getName());
                text.setSmooth(true);
                text.setFontSmoothingType(FontSmoothingType.LCD);
                text.setWrappingWidth(120);
                InputStream in = null;
                try {
                    in = new FileInputStream(item.getUrlImage());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(tableController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Image fxImage = new Image(in);
                ImageView imageView = new ImageView(fxImage);
                imageView.setFitHeight(75);
                imageView.setFitWidth(75);
                VBox hb = new VBox(imageView, text);
                hb.setAlignment(Pos.CENTER);
                hb.setSpacing(5);
                setGraphic(hb);
            }
        }
    }
    
    private static class AttachmentColumnCellRating extends TableCell<Artist, Integer> {
        Rating ret = new Rating();
        @Override
        public void updateItem(Integer item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
                setText(null);
            } else {
                ret.setRating(item);
                VBox hb = new VBox(ret);
                hb.setAlignment(Pos.CENTER);
                setGraphic(hb);
            }
        }
    }
    
    private static class AttachmentColumnCellResize extends TableCell<Artist, String> {
        private Text text;
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
                setText(null);
            } else {
                text = new Text(item);
                text.setSmooth(true);
                text.setFontSmoothingType(FontSmoothingType.LCD);
                setPrefHeight(Control.USE_COMPUTED_SIZE);
                text.wrappingWidthProperty().bind(widthProperty());
                text.textProperty().bind(itemProperty());
                setGraphic(text);
            }
        }
    }
    
    private class ButtonCell extends TableCell<Object, Boolean> {
        final Hyperlink detail = new Hyperlink("Delete");
        ButtonCell(final TableView tblView){
            detail.setOnAction((ActionEvent t) -> {
                int row = getTableRow().getIndex();
                Artist person = tableController.listData.get(row);
                tableController.listDataProperties.add(person);
                tableData.getItems().remove(row);
                statusEdit.setValue(2);
            });
        }

        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(detail);
            }else{
                setGraphic(null);
            }
        }
    }
    
}
