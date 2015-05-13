/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herudi.model;

import herudi.controller.tableController;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Herudi
 */
public class UndoRedoManager extends UndoManager{
    
    @Override
    public synchronized void redo() throws CannotRedoException {
        if (tableController.statusEdit.getValue()==2) {
            try {
                int a = tableController.listData.size();
                Artist person = tableController.listData.get(a-1);
                tableController.listDataProperties.add(person);
                tableController.listData.remove(a-1);
            } catch (Exception e) {
            }
        }else if (tableController.statusEdit.getValue()==1){
            try {
                int a = tableController.listDataProperties.size();
                Artist person = tableController.listDataProperties.get(a-1);
                tableController.listData.add(person);
                tableController.listDataProperties.remove(a-1);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public synchronized void undo() throws CannotUndoException {
        if (tableController.statusEdit.getValue()==1) {
            try {
                int a = tableController.listData.size();
                Artist person = tableController.listData.get(a-1);
                tableController.listDataProperties.add(person);
                tableController.listData.remove(a-1);
            } catch (Exception e) {
            }
        }else if (tableController.statusEdit.getValue()==2){
            try {
                int a = tableController.listDataProperties.size();
                Artist person = tableController.listDataProperties.get(a-1);
                tableController.listData.add(person);
                tableController.listDataProperties.remove(a-1);
            } catch (Exception e) {
            }
        }
    }
}
