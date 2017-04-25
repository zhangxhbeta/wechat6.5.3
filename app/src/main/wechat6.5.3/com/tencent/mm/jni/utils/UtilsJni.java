package com.tencent.mm.jni.utils;

public class UtilsJni {
    public static native byte[] cryptGenRandom(int i);

    public static native int doEcdsaSHAVerify(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native int doEcdsaVerify(byte[] bArr, byte[] bArr2, byte[] bArr3);
}
