package com.qq.wx.voice.vad;

public final class a {
    public static boolean DEBUG = false;
    public long aHg = 0;
    public EVadNative aHh = new EVadNative();

    static {
        System.loadLibrary("EVadEmbed");
    }
}
