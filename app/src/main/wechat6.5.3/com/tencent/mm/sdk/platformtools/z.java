package com.tencent.mm.sdk.platformtools;

import java.security.MessageDigest;

public final class z {
    protected static char[] niy = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static ThreadLocal<MessageDigest> niz = new ThreadLocal<MessageDigest>() {
        protected final /* synthetic */ Object initialValue() {
            return AnonymousClass1.bte();
        }

        private static MessageDigest bte() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (Throwable e) {
                throw new RuntimeException("Initialize MD5 failed.", e);
            }
        }
    };

    public static String Kg(String str) {
        return bi(str.getBytes());
    }

    public static String bi(byte[] bArr) {
        byte[] digest = ((MessageDigest) niz.get()).digest(bArr);
        int length = digest.length;
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        int i = length + 0;
        for (length = 0; length < i; length++) {
            byte b = digest[length];
            char c = niy[(b & 240) >> 4];
            char c2 = niy[b & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }
}
