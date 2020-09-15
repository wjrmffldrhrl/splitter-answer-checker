package org.wigo.fileManager;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    String pathName;
    String file;


    public FileReader(String pathName) {
        this.pathName = pathName;
        try {
            this.file = IOUtils.toString(getClass().getResourceAsStream(pathName), "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFile() {
        return this.file;
    }

    public List<String> getSplitFile(String splitter) {
        List<String> splitList = new ArrayList<>();
        if(splitter == "|") splitter = "\\|";

        for(String str : this.getFile().split(splitter)) {
            splitList.add(str.trim());
        }

        return splitList;
    }

    public List<String> getSplitFileByLine() {

        return this.getSplitFile("\\n");
    }

}
