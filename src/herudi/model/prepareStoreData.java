/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herudi.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Herudi
 */

@XmlRootElement(name = "Artists")
public class prepareStoreData {
    private List<Artist> listDatas;
    
    @XmlElement(name = "Artist")
    public List<Artist> getListData() {
        return listDatas;
    }

    public void setListData(List<Artist> listDatas) {
        this.listDatas = listDatas;
    }
    
}
