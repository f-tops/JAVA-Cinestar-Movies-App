/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt.model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author Franjo
 */
public class GlumacTransferable implements Transferable {

    public static final DataFlavor GLUMAC_FLAVOR = new DataFlavor(Glumac.class, "Glumac");
    public static final DataFlavor[] SUPPORTED_FLAVORS = {GLUMAC_FLAVOR};
    private final Glumac glumac;

    public GlumacTransferable(Glumac glumac) {
        this.glumac = glumac;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return SUPPORTED_FLAVORS;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(GLUMAC_FLAVOR);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(GLUMAC_FLAVOR)) {
            return glumac;
        }
        throw new UnsupportedFlavorException(flavor);
    }

}
