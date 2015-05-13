/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herudi.model;

/**
 *
 * @author Herudi
 */
public class Artist {
    private artisName artisName = new artisName();
    private String homeBase;
    private String hit;
    private Integer rating;

    public Artist() {
    }

    public artisName getArtisName() {
        return artisName;
    }

    public void setArtisName(artisName artisName) {
        this.artisName = artisName;
    }    

    public String getHomeBase() {
        return homeBase;
    }

    public void setHomeBase(String homeBase) {
        this.homeBase = homeBase;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    
    
}
