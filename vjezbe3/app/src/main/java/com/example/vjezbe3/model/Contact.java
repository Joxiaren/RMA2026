package com.example.vjezbe3.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String ime;
    private String prezime;
    private String tel;
    private String skypeId;

    public Contact() {
    }

    public Contact(String ime, String prezime, String tel, String skypeId) {
        this.ime = ime;
        this.prezime = prezime;
        this.tel = tel;
        this.skypeId = skypeId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSkypeId() {
        return skypeId;
    }

    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId;
    }
}
