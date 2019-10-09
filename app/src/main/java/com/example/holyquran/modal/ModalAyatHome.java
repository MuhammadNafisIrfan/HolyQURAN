package com.example.holyquran.modal;

public class ModalAyatHome {
    private String nomor;
    private String name;
    private String arti;
    private String asma;

    public ModalAyatHome(String nomor, String name, String arti, String asma) {
        this.nomor = nomor;
        this.name = name;
        this.arti = arti;
        this.asma = asma;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }
    public String getAsma() {
        return asma;
    }

    public void setAsma(String asma) {
        this.asma = asma;
    }
}
