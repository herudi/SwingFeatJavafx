/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herudi.view;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import herudi.controller.tableController;
import herudi.model.Artist;
import herudi.model.UndoRedoManager;
import herudi.model.prepareStoreData;
import java.io.File;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Herudi
 */
public class formSwing extends javax.swing.JFrame {
    final JFXPanel fxpanel = new JFXPanel();
    private String strLocationXml = "";
    private String imageLocation = "";
    UndoManager undoRedo = new UndoRedoManager();
    
    /**
     * Creates new form formSwing
     */
    
    public formSwing() {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
        }
        initComponents();
        paneTable.add(fxpanel);
        Platform.runLater(() -> {
            initFX(fxpanel);
        });
//        statusAction();
    }
    
    public void setDataFilePath(File file) {
        if (file != null) {
            this.setTitle("Artist - "+file.getAbsolutePath());
            strLocationXml = file.getAbsolutePath();
        } 
    }
    
    public void saveDataXml(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(prepareStoreData.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            prepareStoreData wrapper = new prepareStoreData();
            wrapper.setListData(tableController.listData);
            m.marshal(wrapper, file);
            setDataFilePath(file);
        } catch (Exception e) { 

        }
    }
    
    public void loadDataXml(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(prepareStoreData.class);
            Unmarshaller um = context.createUnmarshaller();
            prepareStoreData wrapper = (prepareStoreData) um.unmarshal(file);
            tableController.listData.clear();
            tableController.listData.addAll(wrapper.getListData());
            setDataFilePath(file);
        } catch (Exception e) { 

        }
    }
    
    private void initFX(JFXPanel fx){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/herudi/view/tableData.fxml"));
            Scene scene = new Scene(root);
            fx.setScene(scene);
        } catch (Exception e) {
        }
    }
    
    private void enableSaveBtn(boolean a, boolean b, boolean c){
        btnSave.setEnabled(a);
        menuSave.setEnabled(b);
        menuSaveAs.setEnabled(c);
    }
    
    private void clear(){
        txtName.setText("");
        txtHomeBase.setText("");
        sliderRating.setValue(1);
        txtHit.setText("");
        lblImage.setIcon(null);
    }
    
//    private void statusAction(){
//        tableController.listData.addListener((ListChangeListener.Change<? extends Artist> c) -> {
//            tableController.listDataProperties.addListener((ListChangeListener.Change<? extends Artist> d) -> {
//                while (c.next() || d.next()) {    
//                    if (c.getList().isEmpty() || d.getList().isEmpty()) {   
//                        btnUndo.setEnabled(false);
//                        btnRedo.setEnabled(false);
//                    }else{
//                        btnUndo.setEnabled(true);
//                        btnRedo.setEnabled(true);
//                    }
//                }
//            });
//        });
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        btnRedo = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHomeBase = new javax.swing.JTextField();
        btnSaveCrud = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtHit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        btnBrowseImage = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sliderRating = new javax.swing.JSlider();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        paneTable = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuNew = new javax.swing.JMenuItem();
        menuOpen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSave = new javax.swing.JMenuItem();
        menuSaveAs = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuUndo = new javax.swing.JMenuItem();
        menuRedo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herudi/img/archive-insert-directoryBig.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herudi/img/document-openBig.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herudi/img/document-save-allBig.png"))); // NOI18N
        btnSave.setEnabled(false);
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);

        btnUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herudi/img/edit-undoBig.png"))); // NOI18N
        btnUndo.setFocusable(false);
        btnUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnUndo);

        btnRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herudi/img/edit-redoBig.png"))); // NOI18N
        btnRedo.setFocusable(false);
        btnRedo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRedo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRedo);

        jPanel1.setBackground(java.awt.Color.white);

        jLabel1.setText("Name :");

        jLabel2.setText("Home Base :");

        btnSaveCrud.setText("Save");
        btnSaveCrud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCrudActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");

        jLabel5.setText("Hits Single :");

        jLabel6.setText("Rating :");

        lblImage.setBackground(new java.awt.Color(204, 204, 204));
        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnBrowseImage.setText("Browse...");
        btnBrowseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseImageActionPerformed(evt);
            }
        });

        jLabel4.setText("Image :");

        sliderRating.setBackground(java.awt.Color.white);
        sliderRating.setMajorTickSpacing(1);
        sliderRating.setMaximum(5);
        sliderRating.setMinimum(1);
        sliderRating.setPaintLabels(true);
        sliderRating.setPaintTicks(true);
        sliderRating.setSnapToTicks(true);
        sliderRating.setToolTipText("");
        sliderRating.setValue(1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 99, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveCrud, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtHomeBase, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHit, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBrowseImage, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sliderRating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(txtHomeBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addComponent(txtHit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(2, 2, 2)
                .addComponent(sliderRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBrowseImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveCrud)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Form Input Java Swing", jPanel1);

        paneTable.setBackground(java.awt.Color.white);
        paneTable.setLayout(new java.awt.GridLayout(1, 0));
        jTabbedPane3.addTab("Table View Javafx", paneTable);

        jMenu1.setText("File");

        menuNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herudi/img/archive-insert-directory.png"))); // NOI18N
        menuNew.setText("New...");
        menuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewActionPerformed(evt);
            }
        });
        jMenu1.add(menuNew);

        menuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herudi/img/document-open.png"))); // NOI18N
        menuOpen.setText("Open...");
        menuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenActionPerformed(evt);
            }
        });
        jMenu1.add(menuOpen);
        jMenu1.add(jSeparator1);

        menuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herudi/img/document-save.png"))); // NOI18N
        menuSave.setText("Save...");
        menuSave.setEnabled(false);
        menuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveActionPerformed(evt);
            }
        });
        jMenu1.add(menuSave);

        menuSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herudi/img/document-save-as.png"))); // NOI18N
        menuSaveAs.setText("Save As...");
        menuSaveAs.setEnabled(false);
        menuSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveAsActionPerformed(evt);
            }
        });
        jMenu1.add(menuSaveAs);
        jMenu1.add(jSeparator2);

        menuExit.setText("Exit");
        jMenu1.add(menuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        menuUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        menuUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herudi/img/edit-undo.png"))); // NOI18N
        menuUndo.setText("Undo");
        menuUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUndoActionPerformed(evt);
            }
        });
        jMenu2.add(menuUndo);

        menuRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        menuRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/herudi/img/edit-redo.png"))); // NOI18N
        menuRedo.setText("Redo");
        menuRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRedoActionPerformed(evt);
            }
        });
        jMenu2.add(menuRedo);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jTabbedPane3))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveCrudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCrudActionPerformed
        if (btnSaveCrud.getText().equals("Save")) {
            if (txtName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Name Not Empty");
                txtName.requestFocus();
            }else if (txtHomeBase.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Home Base Not Empty");
                txtHomeBase.requestFocus();
            }else if (txtHit.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Hit Not Empty");
                txtHit.requestFocus();
            }else if (lblImage.getIcon()==null) {
                JOptionPane.showMessageDialog(rootPane, "Icon Not Empty");
            } else{
                Artist p = new Artist();
                p.setHomeBase(txtHomeBase.getText());
                p.setRating(sliderRating.getValue());
                p.setHit(txtHit.getText());
                p.getArtisName().setName(txtName.getText());
                p.getArtisName().setUrlImage(imageLocation);
                tableController.listData.add(p);
                tableController.statusEdit.setValue(1);
                clear();
                JOptionPane.showMessageDialog(rootPane, "Succes Save Data...");
                enableSaveBtn(true, true, true);
            }
        }
    }//GEN-LAST:event_btnSaveCrudActionPerformed

    
    private void btnBrowseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseImageActionPerformed
        JFileChooser chooser=new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Image files", "jpg", "png", "gif", "bmp");
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        int saveVal = chooser.showOpenDialog(rootPane);
        if (saveVal == JFileChooser.OPEN_DIALOG) {
            File file = new File(chooser.getSelectedFile().toString());
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            lblImage.setIcon(icon);
            imageLocation = file.getAbsolutePath();
        }        
    }//GEN-LAST:event_btnBrowseImageActionPerformed

    private void menuUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUndoActionPerformed
        undoRedo.undo();
    }//GEN-LAST:event_menuUndoActionPerformed

    private void menuRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRedoActionPerformed
        undoRedo.redo();
    }//GEN-LAST:event_menuRedoActionPerformed

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        menuUndoActionPerformed(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_btnUndoActionPerformed

    private void btnRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedoActionPerformed
        menuRedoActionPerformed(evt);           // TODO add your handling code here:
    }//GEN-LAST:event_btnRedoActionPerformed

    private void menuSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaveAsActionPerformed
        JFileChooser chooser=new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter(".xml", "xml file");
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        int saveVal = chooser.showSaveDialog(rootPane);
        if (saveVal == JFileChooser.APPROVE_OPTION) {
            File file = new File(chooser.getSelectedFile().toString());
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            strLocationXml = file.getAbsolutePath();
            saveDataXml(file);
            enableSaveBtn(false, false, true);
        }      // TODO add your handling code here:
    }//GEN-LAST:event_menuSaveAsActionPerformed

    private void menuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenActionPerformed
        JFileChooser chooser=new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("xml Files", "xml");
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        int saveVal = chooser.showOpenDialog(rootPane);
        if (saveVal == JFileChooser.OPEN_DIALOG) {
            File file = new File(chooser.getSelectedFile().toString());
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            strLocationXml = file.getAbsolutePath();
            loadDataXml(file);
            enableSaveBtn(false, false, true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_menuOpenActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        menuNewActionPerformed(evt);            // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void menuNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewActionPerformed
        if (menuSave.isEnabled()) {
            int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "This File Not Save. do you want to save ?", "confirm", dialogButton);
            if (dialogResult==0) {
                menuSaveActionPerformed(evt);
                clear();
                tableController.listData.clear();
                tableController.listDataProperties.clear();
                tableController.statusEdit.setValue(0);
                this.setTitle("Artist - ");
            }else if (dialogResult==1) {
                clear();
                tableController.listData.clear();
                tableController.listDataProperties.clear();
                tableController.statusEdit.setValue(0);
                this.setTitle("Artist - ");
            }else{
                txtName.requestFocus();
            }
        }else{
            clear();
            tableController.listData.clear();
            tableController.listDataProperties.clear();
            tableController.statusEdit.setValue(0);
            this.setTitle("Artist - ");
        }
    }//GEN-LAST:event_menuNewActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        menuOpenActionPerformed(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        menuSaveActionPerformed(evt);                // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void menuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaveActionPerformed
        try {
            if (strLocationXml.isEmpty()) {
                menuSaveAsActionPerformed(evt);
            }else{
                File file = new File(strLocationXml);
                saveDataXml(file);
                enableSaveBtn(false, false, true);
            }
        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formSwing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseImage;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRedo;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveCrud;
    private javax.swing.JButton btnUndo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuNew;
    private javax.swing.JMenuItem menuOpen;
    private javax.swing.JMenuItem menuRedo;
    private javax.swing.JMenuItem menuSave;
    private javax.swing.JMenuItem menuSaveAs;
    private javax.swing.JMenuItem menuUndo;
    private javax.swing.JPanel paneTable;
    private javax.swing.JSlider sliderRating;
    private javax.swing.JTextField txtHit;
    private javax.swing.JTextField txtHomeBase;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
