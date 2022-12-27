/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.afif.perpustakaanclient.Model;

/**
 *
 * @author hp
 */
public class Anggota {
    private Long anggotaId;
    private String nama;
    private String alamat;

    public Long getAnggotaId() {
        return anggotaId;
    }

    public void setAnggotaId(Long anggotaId) {
        this.anggotaId = anggotaId;
    }

    public String getAnggotaName() {
        return nama;
    }

    public void setAnggotaName(String anggotaName) {
        this.nama = anggotaName;
    }

    public String getAnggotaAddress() {
        return alamat;
    }

    public void setAnggotaAddress(String anggotaAddress) {
        this.alamat = anggotaAddress;
    }
    
    
}
