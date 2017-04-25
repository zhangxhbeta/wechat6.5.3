package com.tencent.tinker.loader;

public class TinkerRuntimeException extends RuntimeException {
    public TinkerRuntimeException(String str) {
        super("Tinker Exception:" + str);
    }

    public TinkerRuntimeException(String str, Throwable th) {
        super("Tinker Exception:" + str, th);
    }
}
