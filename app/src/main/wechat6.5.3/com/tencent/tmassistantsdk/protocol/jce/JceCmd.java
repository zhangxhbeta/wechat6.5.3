package com.tencent.tmassistantsdk.protocol.jce;

import java.io.Serializable;

public final class JceCmd implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!JceCmd.class.desiredAssertionStatus());
    public static final JceCmd Empty = new JceCmd(0, 0, "Empty");
    public static final JceCmd GetAppSimpleDetail = new JceCmd(5, 5, "GetAppSimpleDetail");
    public static final JceCmd GetAppUpdate = new JceCmd(3, 3, "GetAppUpdate");
    public static final JceCmd GetSettings = new JceCmd(2, 2, "GetSettings");
    public static final JceCmd ReportApkFileInfo = new JceCmd(4, 4, "ReportApkFileInfo");
    public static final JceCmd ReportLog = new JceCmd(1, 1, "ReportLog");
    public static final int _Empty = 0;
    public static final int _GetAppSimpleDetail = 5;
    public static final int _GetAppUpdate = 3;
    public static final int _GetSettings = 2;
    public static final int _ReportApkFileInfo = 4;
    public static final int _ReportLog = 1;
    private static JceCmd[] __values = new JceCmd[6];
    private String __T = new String();
    private int __value;

    public static JceCmd convert(int i) {
        for (int i2 = 0; i2 < __values.length; i2++) {
            if (__values[i2].value() == i) {
                return __values[i2];
            }
        }
        if ($assertionsDisabled) {
            return null;
        }
        throw new AssertionError();
    }

    public static JceCmd convert(String str) {
        for (int i = 0; i < __values.length; i++) {
            if (__values[i].toString().equals(str)) {
                return __values[i];
            }
        }
        if ($assertionsDisabled) {
            return null;
        }
        throw new AssertionError();
    }

    public final int value() {
        return this.__value;
    }

    public final String toString() {
        return this.__T;
    }

    private JceCmd(int i, int i2, String str) {
        this.__T = str;
        this.__value = i2;
        __values[i] = this;
    }
}
