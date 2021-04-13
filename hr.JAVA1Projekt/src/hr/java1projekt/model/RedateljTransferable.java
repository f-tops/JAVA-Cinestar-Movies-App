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
public class RedateljTransferable implements Transferable{
        public static final DataFlavor REDATELJ_FLAVOR = new DataFlavor(Redatelj.class, "Redatelj");
    public static final DataFlavor[] SUPPORTED_FLAVORS = {REDATELJ_FLAVOR};
    private final Redatelj redatelj;

    public RedateljTransferable(Redatelj redatelj) {
        this.redatelj = redatelj;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return SUPPORTED_FLAVORS;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(REDATELJ_FLAVOR);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(REDATELJ_FLAVOR)) {
            return redatelj;
        }
        throw new UnsupportedFlavorException(flavor);
    }

}
