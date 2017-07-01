package com.sikorski.weatheraggregator.utils;

import java.io.IOException;

public interface AppFileWriter {

    void append(String s) throws IOException;

}
