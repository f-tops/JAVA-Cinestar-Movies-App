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
public class ZanrTransferable implements Transferable {

    public static final DataFlavor ZANR_FLAVOR = new DataFlavor(Zanr.class, "Zanr");
    public static final DataFlavor[] SUPPORTED_FLAVORS = {ZANR_FLAVOR};
    private final Zanr zanr;

    public ZanrTransferable(Zanr zanr) {
        this.zanr = zanr;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return SUPPORTED_FLAVORS;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(ZANR_FLAVOR);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(ZANR_FLAVOR)) {
            return zanr;
        }
        throw new UnsupportedFlavorException(flavor);
    }

}
