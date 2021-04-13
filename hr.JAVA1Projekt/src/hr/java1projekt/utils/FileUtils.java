/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Franjo
 */
public class FileUtils {

    private static final String UPLOAD = "Upload";
        private static final String TEXT_DOCUMENTSTXT = "Text documents(*.txt)";
    private static final String SAVE = "Save";
    private static final String TXT = "txt";

    public static File uploadFile(String description, String...extensions) {
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        chooser.setFileFilter(new FileNameExtensionFilter(description, extensions));
        chooser.setDialogTitle(UPLOAD);
        chooser.setApproveButtonText(UPLOAD);
        chooser.setApproveButtonToolTipText(UPLOAD);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            String extension = selectedFile.getName().substring(selectedFile.getName().lastIndexOf(".") + 1);
            return Arrays.asList(extensions).contains(extension.toLowerCase()) ? selectedFile : null;            
        }
        return null;
    }

    public static void copyFromUrl(String source, String destination) throws MalformedURLException, IOException {
        createDirHierarchy(destination);
        URL url = new URL(source);
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(destination));
        }
    }

    public static void copy(String source, String destination) throws FileNotFoundException, IOException {
        createDirHierarchy(destination);
        Files.copy(Paths.get(source), new FileOutputStream(destination));
    }
    
        private static void createDirHierarchy(String destination) throws IOException {
        String dir = destination.substring(0, destination.lastIndexOf(File.separator));
        if (!Files.exists(Paths.get(dir))) {
            Files.createDirectories(Paths.get(dir));
        }
    }
        
        
        
        public static void deletePictures(String directoryName){
            File directory = new File(directoryName);
            
            File[] files = directory.listFiles();
            for(File file : files){
                if(!file.delete()){
                    System.out.println("Greška kod brisanja slike " + file);
                }
            }
        }
        
        
        public static Optional<File> saveTextInFile(String text, Optional<File> opFile) throws IOException {
        if (!opFile.isPresent()) {
            JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            chooser.setFileFilter(new FileNameExtensionFilter(TEXT_DOCUMENTSTXT, SAVE));
            chooser.setDialogTitle(SAVE);
            chooser.setApproveButtonText(SAVE);
            chooser.setApproveButtonToolTipText(SAVE);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                if (!selectedFile.toString().endsWith(TXT)) {
                    selectedFile = new File(selectedFile.toString().concat(".").concat(TXT));
                }
                Files.write(selectedFile.toPath(), text.getBytes());
                opFile = Optional.of(selectedFile);
            }
        } else {
            Files.write(opFile.get().toPath(), text.getBytes());            
        }
        return opFile;
    }
    
    public static Optional<String> loadTextFromFile() throws IOException {
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        //chooser.setFileFilter(new FileNameExtensionFilter(TEXT_DOCUMENTSTXT, SAVE));
        
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory() || file.toString().endsWith(TXT);
            }

            @Override
            public String getDescription() {
                return TEXT_DOCUMENTSTXT;
            }
        });
        
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return Optional.of(new String(Files.readAllBytes(chooser.getSelectedFile().toPath())));
        }
        
        return Optional.empty();
    }
        
}
        
        
        
