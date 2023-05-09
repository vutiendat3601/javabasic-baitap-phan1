package com.datvutech.util;

import java.io.File;
import java.util.Optional;

import javax.swing.JFileChooser;

public class FileUtils {
    public static Optional<File> showFileOpenDialog() {
        File file = null;
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        }
        return file == null ? Optional.empty() : Optional.of(file);
    }
}
