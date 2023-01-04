/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.afif.perpustakaanclient.Controller;

import com.mycompany.afif.perpustakaanclient.FormAnggota;


import com.mycompany.afif.perpustakaanclient.Service.AnggotaService;
import com.mycompany.afif.perpustakaanclient.model.Anggota;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Apip
 */
public class AnggotaController {
    private final AnggotaService anggotaService;
    private final FormAnggota formAnggota;
    
    public AnggotaController(FormAnggota formAnggota){
        this.formAnggota = formAnggota;
        anggotaService = new AnggotaService();
    }
    
    public void bersihForm(){
        formAnggota.getTxtAnggotaId().setText("");
        formAnggota.getTxtAnggotaName().setText("");
        formAnggota.getTxtAnggotaAddress().setText("");
    }
    
    public void getAnggotaId(){
        Long id = Long.parseLong(formAnggota.getTxtAnggotaId().getText());
        Anggota anggota = anggotaService.getAnggota(id);
        if(anggota!=null){
            formAnggota.getTxtAnggotaName().setText(anggota.getNama());
            formAnggota.getTxtAnggotaAddress().setText(anggota.getAlamat());
        }else{
            JOptionPane.showMessageDialog(formAnggota, "Data Tidak Ditemukan");
        }
    }
    
    public void saveAnggota(){
        Anggota anggota = new Anggota();
        anggota.setNama(formAnggota.getTxtAnggotaName().getText());
        anggota.setAlamat(formAnggota.getTxtAnggotaAddress().getText());
        anggota = anggotaService.saveAnggota(anggota);
        if (anggota != null){
            formAnggota.getTxtAnggotaId().setText(anggota.getAnggotaId().toString());
            JOptionPane.showMessageDialog(formAnggota,"Entri Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formAnggota,"Entri Data Gagal");
        }
    }
    public void updateAnggota(){
        Anggota anggota = new Anggota();
        anggota.setAnggotaId(Long.parseLong(formAnggota.getTxtAnggotaId().getText()));
        anggota.setNama(formAnggota.getTxtAnggotaName().getText());
        anggota.setAlamat(formAnggota.getTxtAnggotaAddress().getText());
        anggota = anggotaService.updateAnggota(anggota);
        if (anggota != null){
            formAnggota.getTxtAnggotaId().setText(anggota.getAnggotaId().toString());
            JOptionPane.showMessageDialog(formAnggota,"Update Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formAnggota,"Update Data Gagal");
        }
    }
    
   public void deleteAnggota(){
        Long id = Long.parseLong(formAnggota.getTxtAnggotaId().getText());
        anggotaService.deleteAnggota(id);
            JOptionPane.showMessageDialog(formAnggota, "Delete Data Berhasil");
    }
    
    public void viewTable(){
        DefaultTableModel tabelModel = (DefaultTableModel) formAnggota.getTabelAnggota().getModel();
        tabelModel.setRowCount(0);
        List<Anggota> anggotaList = anggotaService.getAllAnggota();
        for (Anggota anggota : anggotaList){
            Object[] row = {
                anggota.getAnggotaId(),
                anggota.getNama(),
                anggota.getAlamat()
            };
            tabelModel.addRow(row);
        }
    }
}
