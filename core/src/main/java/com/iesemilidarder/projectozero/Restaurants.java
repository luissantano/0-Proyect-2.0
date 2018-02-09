package com.iesemilidarder.projectozero;

/**
 * zeroproject
 * com.iesemilidarder.projectozero
 * Create by winadmin in 19/1/2018.
 * Description:
 */
//He afegit un private string anomenat imatge per poder mostrar una imatge.

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.ArrayList;

@Entity()
public class Restaurants {

    @Column(name="RES_NOM")
    private String name;

    @Column(name="RES_ADRECA")
    private String address;

    @Column(name="RES_WEB")
    private String website;

    @Column(name="RES_TELEFON")
    private String telephone;

    @Column(name="TRS_DESCRIPCIO")
    private String type;

    @Column(name="RES_URL_IMG")
    private String image;

    @Column(name="RES_CODI")
    private String id;

    //Cream l'estring privat anomenat id  ,amb el Set i get

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //Cream un ArrayList anomenada opinio

    private ArrayList<String> opinio;

    public ArrayList<String> getOpinion() {

        return opinio;
    }

    public void opinio(ArrayList<String> opinio) {
        this.opinio = opinio;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getWebsite() {
        return website;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Restaurants() {
        this.opinio = new ArrayList<String>();
    }
}
