package com.sikorski.weatherapp.aggregator.utils;

import java.io.IOException;

public interface AppFileWriter {

    void append(String s) throws IOException;

}
