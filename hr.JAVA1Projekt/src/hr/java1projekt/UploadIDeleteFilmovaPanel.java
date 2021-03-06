/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt;

import hr.java1projekt.dal.Repository;
import hr.java1projekt.dal.RepositoryFactory;
import hr.java1projekt.model.Film;
import hr.java1projekt.parsers.rss.FilmParser;
import hr.java1projekt.utils.FileUtils;
import hr.java1projekt.utils.MessageUtils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Franjo
 */
public class UploadIDeleteFilmovaPanel extends javax.swing.JPanel {

    private DefaultListModel<Film> filmoviModel;
    private Repository repository;

    /**
     * Creates new form UploadIDeleteFilmovaPanel
     */
    public UploadIDeleteFilmovaPanel() {
        initComponents();

        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lsFilmovi = new javax.swing.JList<>();
        btnDohvati = new javax.swing.JButton();
        btnIzbrisi = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1130, 500));

        jScrollPane1.setViewportView(lsFilmovi);

        btnDohvati.setText("DOHVATI FILMOVE");
        btnDohvati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDohvatiActionPerformed(evt);
            }
        });

        btnIzbrisi.setText("IZBRISI PODATKE");
        btnIzbrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIzbrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnDohvati, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(746, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzbrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDohvati, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiActionPerformed
        try {
            repository.deleteFilmova();
            FileUtils.deletePictures(FilmParser.FOLDER_PATH);
            MessageUtils.showInformationMessage("Uspjeh", "Uspje??no izbrisani podaci u bazi i slike iz direktorija");
            lsFilmovi.setEnabled(false);
        } catch (Exception ex) {
            MessageUtils.showErrorMessage("Unrecoverable error", "Unable to delete filmovi");
            System.exit(1);
        }
    }//GEN-LAST:event_btnIzbrisiActionPerformed

    
    
    
    
    private void btnDohvatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDohvatiActionPerformed
                try {
                    lsFilmovi.setEnabled(true);
            List<Film> filmovi = FilmParser.parse();
            repository.createFilmovi(filmovi);
            loadModel();
            
        } catch (Exception ex) {
            MessageUtils.showErrorMessage("Unrecoverable error", "Unable to upload filmovi");
            System.exit(1);
        }
    }//GEN-LAST:event_btnDohvatiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDohvati;
    private javax.swing.JButton btnIzbrisi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Film> lsFilmovi;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            
            repository = RepositoryFactory.getRepository();
            filmoviModel = new DefaultListModel<>();
            loadModel();
        } catch (Exception ex) {
            Logger.getLogger(UploadIDeleteFilmovaPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void loadModel() throws Exception {
        List<Film> filmovi = repository.selectFilmovi();
        filmoviModel.clear();
        filmovi.forEach(film -> filmoviModel.addElement(film));
        lsFilmovi.setModel(filmoviModel);
    }

}
