/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt;

import hr.java1projekt.dal.Repository;
import hr.java1projekt.dal.RepositoryFactory;
import hr.java1projekt.model.Zanr;
import hr.java1projekt.model.ZanrKolekcija;
import hr.java1projekt.parsers.rss.ZanrTableModel;
import hr.java1projekt.utils.MessageUtils;
import java.io.File;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Franjo
 */
public class ZanroviForm extends javax.swing.JFrame {

    private Repository repository;
    private ZanrTableModel zanrTableModel;
    private Zanr zanr;
    private static final String FILENAME = "parsiraniZanrovi.xml";

    /**
     * Creates new form ZanroviForm
     */
    public ZanroviForm() {
        initComponents();
        init();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbZanr = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfImePrezime = new javax.swing.JTextField();
        btnAzuriraj = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        btnIzbrisi = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mFilmovi = new javax.swing.JMenu();
        mKategorije = new javax.swing.JMenu();
        miGlumci = new javax.swing.JMenuItem();
        miRedatelj = new javax.swing.JMenuItem();
        miZanr = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbZanr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbZanr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbZanrMouseClicked(evt);
            }
        });
        tbZanr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbZanrKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbZanr);

        jLabel1.setText("Naziv");

        btnAzuriraj.setText("AŽURIRAJ");
        btnAzuriraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajActionPerformed(evt);
            }
        });

        btnDodaj.setText("DODAJ");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzbrisi.setText("IZBRIŠI");
        btnIzbrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbrisiActionPerformed(evt);
            }
        });

        btnExport.setText("EXPORT");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        jLabel2.setText("Izvoz datoteke");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/java1projekt/assets/menu/cinema2.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ŽANROVI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnDodaj))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnIzbrisi)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(44, 44, 44)
                                        .addComponent(btnExport))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfImePrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(btnAzuriraj)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfImePrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAzuriraj)
                    .addComponent(btnDodaj)
                    .addComponent(btnIzbrisi))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExport)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mFilmovi.setText("Filmovi");
        mFilmovi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mFilmovi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mFilmoviMouseClicked(evt);
            }
        });
        mFilmovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFilmoviActionPerformed(evt);
            }
        });
        jMenuBar1.add(mFilmovi);

        mKategorije.setText("Kategorije");
        mKategorije.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        miGlumci.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        miGlumci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/java1projekt/assets/menu/theatre.png"))); // NOI18N
        miGlumci.setText("Glumci");
        miGlumci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGlumciActionPerformed(evt);
            }
        });
        mKategorije.add(miGlumci);

        miRedatelj.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        miRedatelj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/java1projekt/assets/menu/redatelj.png"))); // NOI18N
        miRedatelj.setText("Redatelji");
        miRedatelj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRedateljActionPerformed(evt);
            }
        });
        mKategorije.add(miRedatelj);

        miZanr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        miZanr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/java1projekt/assets/menu/cinema.png"))); // NOI18N
        miZanr.setText("Žanrovi");
        miZanr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miZanrActionPerformed(evt);
            }
        });
        mKategorije.add(miZanr);

        jMenuBar1.add(mKategorije);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mFilmoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFilmoviActionPerformed
        GlavniEkran glavniEkran = new GlavniEkran();
        glavniEkran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mFilmoviActionPerformed

    private void miGlumciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGlumciActionPerformed
        GlumciForm glumciForm = new GlumciForm();
        glumciForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_miGlumciActionPerformed

    private void miRedateljActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRedateljActionPerformed
        RedateljiForm redateljiForm = new RedateljiForm();
        redateljiForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_miRedateljActionPerformed

    private void miZanrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miZanrActionPerformed
        ZanroviForm zanroviForm = new ZanroviForm();
        zanroviForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_miZanrActionPerformed

    private void mFilmoviMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mFilmoviMouseClicked
        GlavniEkran glavniEkran = new GlavniEkran();
        glavniEkran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mFilmoviMouseClicked

    private void btnAzurirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajActionPerformed
        try {
            zanr.setNaziv(tfImePrezime.getText().trim());

            repository.updateZanr(zanr);

            MessageUtils.showInformationMessage("Message", "Zanr je ažuriran!");
            zanrTableModel.setZanrovi(repository.selectZanrovi());

        } catch (Exception e) {
            Logger.getLogger(ZanroviForm.class.getName()).log(Level.SEVERE, null, e);
            MessageUtils.showErrorMessage("Error", "Greška!");
        }     }//GEN-LAST:event_btnAzurirajActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {

            Zanr zanr = new Zanr(tfImePrezime.getText().trim());
            repository.createZanr(zanr);

            MessageUtils.showInformationMessage("Poruka", "Kreiran je zanr!");
            zanrTableModel.setZanrovi(repository.selectZanrovi());

        } catch (Exception ex) {
            Logger.getLogger(ZanroviForm.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Greska!");
        }    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiActionPerformed
        if (MessageUtils.showConfirmDialog("Brisanje", "Dal to stvarno želiš?") == JOptionPane.YES_OPTION) {
            try {
                repository.deleteZanr(zanr.getIdZanr());

                MessageUtils.showInformationMessage("Message", "Izbrisan je zanr!");
                zanrTableModel.setZanrovi(repository.selectZanrovi());

            } catch (Exception e) {
                Logger.getLogger(ZanroviForm.class.getName()).log(Level.SEVERE, null, e);
                MessageUtils.showErrorMessage("Error", "Ne mogu obrisat zanr!");
            }
        }     }//GEN-LAST:event_btnIzbrisiActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        try {
            save(new ZanrKolekcija(repository.selectZanrovi()), FILENAME);
        } catch (Exception e) {
            Logger.getLogger(ZanroviForm.class.getName()).log(Level.SEVERE, null, e);
        }    }//GEN-LAST:event_btnExportActionPerformed

    private void tbZanrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbZanrMouseClicked
        showZanr();    }//GEN-LAST:event_tbZanrMouseClicked

    private void tbZanrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbZanrKeyReleased
        showZanr();    }//GEN-LAST:event_tbZanrKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ZanroviForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ZanroviForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ZanroviForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ZanroviForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ZanroviForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzuriraj;
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnIzbrisi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mFilmovi;
    private javax.swing.JMenu mKategorije;
    private javax.swing.JMenuItem miGlumci;
    private javax.swing.JMenuItem miRedatelj;
    private javax.swing.JMenuItem miZanr;
    private javax.swing.JTable tbZanr;
    private javax.swing.JTextField tfImePrezime;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            initRepository();
            initTable();
        } catch (Exception e) {
            Logger.getLogger(ZanroviForm.class.getName()).log(Level.SEVERE, null, e);
            MessageUtils.showErrorMessage("Greska", "greska kod inicijalizacije");
            System.exit(1);
        }
    }

    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }

    private void initTable() throws Exception {
        tbZanr.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbZanr.setAutoCreateRowSorter(true);

        zanrTableModel = new ZanrTableModel(repository.selectZanrovi());
        tbZanr.setModel(zanrTableModel);
        tbZanr.setRowHeight(25);
    }

    private void showZanr() {
        int selectedRow = tbZanr.getSelectedRow();
        int selectedZanrID = (int) zanrTableModel.getValueAt(selectedRow, 0);

        try {
            Optional<Zanr> optZanr = repository.selectZanr(selectedZanrID);
            if (optZanr.isPresent()) {
                zanr = optZanr.get();
                popuniFormu(zanr);
            }
        } catch (Exception ex) {
            Logger.getLogger(ZanroviForm.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Pogreška", "Ne mogu pokazati zanrove!");
        }
    }

    private void popuniFormu(Zanr zanr) {
        tfImePrezime.setText(zanr.getNaziv());
    }

    private void save(ZanrKolekcija zanrKolekcija, String file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ZanrKolekcija.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //marshaller.marshal(movieCollection, System.out);
        marshaller.marshal(zanrKolekcija, new File(file));
        MessageUtils.showInformationMessage("Message", "Zanrovi su exportirani u xml datoteku!");
    }

}
