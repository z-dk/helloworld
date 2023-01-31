package base;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Clipboard {

    public static void main(String[] args) throws IOException, UnsupportedFlavorException {
        java.awt.datatransfer.Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        //ClipboardService clipboardService = ClipboardServiceImpl.getInstance();
        Transferable contents = systemClipboard.getContents(null);
        if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            System.out.println(contents.getTransferData(DataFlavor.stringFlavor));
        }

        // copy
        StringSelection selection = new StringSelection("idea copy!!!");
        systemClipboard.setContents(selection, selection);
    }

}
