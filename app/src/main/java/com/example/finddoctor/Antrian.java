package com.example.finddoctor;

public class Antrian {
    private final String nomor;
    private final String dokter;
    private final String waktu;

    public String getNomor() {
        return nomor;
    }

    public String getDokter() {
        return dokter;
    }

    public String getWaktu() {
        return waktu;
    }
    public Antrian(String nomor, String dokter, String waktu) {
        this.nomor = nomor;
        this.dokter = dokter;
        this.waktu = waktu;
    }

}
