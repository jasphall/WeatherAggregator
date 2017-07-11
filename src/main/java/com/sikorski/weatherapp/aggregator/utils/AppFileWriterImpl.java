package com.sikorski.weatherapp.aggregator.utils;

import java.io.FileWriter;
import java.io.IOException;

public class AppFileWriterImpl implements AppFileWriter {

    private FileWriter fileWriter;

    public AppFileWriterImpl(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void append(String s) throws IOException {
        fileWriter.append(s);
    }
}
