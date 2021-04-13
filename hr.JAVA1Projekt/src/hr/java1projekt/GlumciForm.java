/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt;

import hr.java1projekt.dal.Repository;
import hr.java1projekt.dal.RepositoryFactory;
import hr.java1projekt.model.Glumac;
import hr.java1projekt.model.GlumacKolekcija;
import hr.java1projekt.parsers.rss.GlumacTableModel;
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
public class GlumciForm extends javax.swing.JFrame {

    private Repository repository;
    private GlumacTableModel glumacTableModel;
    private Glumac glumac;
    private static final String FILENAME = "parsiraniGlumci.xml";

    /**
     * Creates new form GlumciForm
     */
    public GlumciForm() {
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
        tbGlumci = new javax.swing.JTable();
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
        setPreferredSize(new java.awt.Dimension(1000, 500));

        tbGlumci.setModel(new javax.swing.table.DefaultTableModel(
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
        tbGlumci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGlumciMouseClicked(evt);
            }
        });
        tbGlumci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbGlumciKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbGlumci);

        jLabel1.setText("Ime i prezime");

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/java1projekt/assets/menu/actor.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("GLUMCI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAzuriraj)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnDodaj))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(jLabel3)
                            .addGap(35, 35, 35)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnIzbrisi)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(44, 44, 44)
                                    .addComponent(btnExport))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfImePrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
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
        this.dispose();    }//GEN-LAST:event_mFilmoviMouseClicked

    private void btnAzurirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajActionPerformed
        try {
            glumac.setImePrezime(tfImePrezime.getText().trim());

            repository.updateGlumac(glumac);

            MessageUtils.showInformationMessage("Message", "Glumac je ažuriran!");
            glumacTableModel.setGlumci(repository.selectGlumci());

        } catch (Exception e) {
            Logger.getLogger(GlumciForm.class.getName()).log(Level.SEVERE, null, e);
            MessageUtils.showErrorMessage("Error", "Nejde!");
        }     }//GEN-LAST:event_btnAzurirajActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {

            Glumac glumac = new Glumac(tfImePrezime.getText().trim());
            repository.createGlumac(glumac);

            MessageUtils.showInformationMessage("Poruka", "Kreiran je glumac!");
            glumacTableModel.setGlumci(repository.selectGlumci());

        } catch (Exception ex) {
            Logger.getLogger(GlumciForm.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Greska!");
        }    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiActionPerformed
        if (MessageUtils.showConfirmDialog("Brisanje", "Dal to stvarno želiš?") == JOptionPane.YES_OPTION) {
            try {
                repository.deleteGlumac(glumac.getIdGlumac());

                MessageUtils.showInformationMessage("Message", "Izbrisan je glumac!");
                glumacTableModel.setGlumci(repository.selectGlumci());

            } catch (Exception e) {
                Logger.getLogger(GlumciForm.class.getName()).log(Level.SEVERE, null, e);
                MessageUtils.showErrorMessage("Error", "Ne mogu obrisat glumca!");
            }
        }     }//GEN-LAST:event_btnIzbrisiActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        try {
            save(new GlumacKolekcija(repository.selectGlumci()), FILENAME);
        } catch (Exception e) {
            Logger.getLogger(GlumciForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void tbGlumciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGlumciMouseClicked
        showGlumac();
    }//GEN-LAST:event_tbGlumciMouseClicked

    private void tbGlumciKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbGlumciKeyReleased
        showGlumac();    }//GEN-LAST:event_tbGlumciKeyReleased

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
            java.util.logging.Logger.getLogger(GlumciForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GlumciForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GlumciForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GlumciForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GlumciForm().setVisible(true);
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
    private javax.swing.JTable tbGlumci;
    private javax.swing.JTextField tfImePrezime;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            initRepository();
            initTable();
        } catch (Exception e) {
            Logger.getLogger(GlumciForm.class.getName()).log(Level.SEVERE, null, e);
            MessageUtils.showErrorMessage("Greska", "greska kod inicijalizacije");
            System.exit(1);
        }
    }

    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }

    private void initTable() throws Exception {
        tbGlumci.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbGlumci.setAutoCreateRowSorter(true);

        glumacTableModel = new GlumacTableModel(repository.selectGlumci());
        tbGlumci.setModel(glumacTableModel);
        tbGlumci.setRowHeight(25);
    }

    private void showGlumac() {
        int selectedRow = tbGlumci.getSelectedRow();
        int selectedGlumacID = (int) glumacTableModel.getValueAt(selectedRow, 0);

        try {
            Optional<Glumac> optGlumac = repository.selectGlumac(selectedGlumacID);
            if (optGlumac.isPresent()) {
                glumac = optGlumac.get();
                popuniFormu(glumac);
            }
        } catch (Exception ex) {
            Logger.getLogger(GlumciForm.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Pogreška", "Ne mogu pokazati glumce!");
        }
    }

    private void popuniFormu(Glumac glumac) {
        tfImePrezime.setText(glumac.getImePrezime());
    }

    private void save(GlumacKolekcija glumacKolekcija, String file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(GlumacKolekcija.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //marshaller.marshal(movieCollection, System.out);
        marshaller.marshal(glumacKolekcija, new File(file));
        MessageUtils.showInformationMessage("Message", "Glumci su exportirani u xml datoteku!");
    }

}
