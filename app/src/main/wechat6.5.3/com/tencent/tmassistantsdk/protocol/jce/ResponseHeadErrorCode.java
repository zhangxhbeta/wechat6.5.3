package com.tencent.tmassistantsdk.protocol.jce;

import java.io.Serializable;

public final class ResponseHeadErrorCode implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!ResponseHeadErrorCode.class.desiredAssertionStatus());
    public static final ResponseHeadErrorCode EC_BUSINESS_ERROR = new ResponseHeadErrorCode(1, -11, "EC_BUSINESS_ERROR");
    public static final ResponseHeadErrorCode EC_SERVER_INTERNAL_ERROR = new ResponseHeadErrorCode(0, -10, "EC_SERVER_INTERNAL_ERROR");
    public static final int _EC_BUSINESS_ERROR = -11;
    public static final int _EC_SERVER_INTERNAL_ERROR = -10;
    private static ResponseHeadErrorCode[] __values = new ResponseHeadErrorCode[2];
    private String __T = new String();
    private int __value;

    public static ResponseHeadErrorCode convert(int i) {
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

    public static ResponseHeadErrorCode convert(String str) {
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

    private ResponseHeadErrorCode(int i, int i2, String str) {
        this.__T = str;
        this.__value = i2;
        __values[i] = this;
    }
}
