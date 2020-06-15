package browserpass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BrowserPass {

    public static void main(String[] args) {
        File folder = new File("Google\\Chrome\\User Data\\Default\\Web Data");
        BrowserPass listFiles = new BrowserPass();
        listFiles.listAllFiles(folder);
        System.out.println("-------------------------------------------------");
    }

    public void listAllFiles(File folder) {
        File[] fileNames = folder.listFiles();
        for (File file : fileNames) {
            if (file.isDirectory()) {
                listAllFiles(file);
            } else {
                try {
                    readContent(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readContent(File file) throws IOException {
     //   System.out.println("read file " + file.getCanonicalPath());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.toLowerCase().contains("password")) {
                    System.out.println("Line is - " + strLine);
                }

            }
        }
    }

}
