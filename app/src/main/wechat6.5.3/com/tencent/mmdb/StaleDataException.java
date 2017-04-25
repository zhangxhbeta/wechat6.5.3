package com.tencent.mmdb;

public class StaleDataException extends RuntimeException {
    public StaleDataException(String str) {
        super(str);
    }
}
