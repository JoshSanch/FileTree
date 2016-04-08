package com.viviose;
import java.io.File;
import java.io.FileNotFoundException;

public class TreeMaker {

    private File dir;
    private final static String tab = "  ";

    public TreeMaker(String filepath){
        dir = new File(filepath);
    }

    public File getDir(){
        return dir;
    }

    private String repeatString(String str, int iterations){
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += str;
        }

        return result;
    }
    
    private void printDirectory(File directory, int tabSpace) throws FileNotFoundException{
        if(directory.listFiles() != null) {
            for (File file :
                    directory.listFiles()) {
                if(file.isDirectory()) {
                    System.out.println(repeatString(tab, tabSpace) + "|- " + file.getName());
                    printDirectory(file, tabSpace + 1);
                }
                else{
                    if(file != null){
                        System.out.println(repeatString(tab, tabSpace) + "|- " + file.getName());
                    }
                }
            }
        }
        else if(directory.isFile()) {
            System.out.println(repeatString(tab, tabSpace) + "|- " + directory.getName());
        }
    }

    public void printDirectory(File directory) throws FileNotFoundException{
        if(directory == null){
            throw new FileNotFoundException("The file or directory at the specified file path was not found.");
        }
        System.out.println(directory.getName());
        printDirectory(directory, 1);
    }

    public static void main(String[] args) {
        TreeMaker treeMaker = new TreeMaker("test/Risk");
        try{
            treeMaker.printDirectory(treeMaker.getDir());
        } catch(FileNotFoundException e1) {
            System.out.println("File not found, shutting down program.");
        }
    }
}
