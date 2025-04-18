package utils;

import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;

public class ChooseFile {

    public static String choose() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel files", "xlsx", "xls"));
        int result = fileChooser.showOpenDialog(null);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel files", "xlsx", "xls"));

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            return filePath;
        }
        return null;
    }
}
