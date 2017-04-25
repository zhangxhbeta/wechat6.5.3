package com.tencent.mm.compatible.util;

import com.tencent.mm.plugin.appbrand.jsapi.bu;
import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessController;
import java.util.BitSet;

public final class p {
    static BitSet cgF = new BitSet(256);
    static String cgG;

    static {
        int i;
        cgG = null;
        for (i = 97; i <= bu.CTRL_INDEX; i++) {
            cgF.set(i);
        }
        for (i = 65; i <= 90; i++) {
            cgF.set(i);
        }
        for (i = 48; i <= 57; i++) {
            cgF.set(i);
        }
        cgF.set(45);
        cgF.set(95);
        cgF.set(46);
        cgF.set(42);
        cgG = (String) AccessController.doPrivileged(new i("file.encoding"));
    }

    @Deprecated
    public static String encode(String str) {
        String str2 = null;
        try {
            str2 = encode(str, cgG);
        } catch (UnsupportedEncodingException e) {
        }
        return str2;
    }

    public static String encode(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        if (str2 == null) {
            throw new NullPointerException("charsetName");
        }
        try {
            Charset forName = Charset.forName(str2);
            Object obj = null;
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (cgF.get(charAt)) {
                    if (charAt == ' ') {
                        obj = 1;
                    }
                    stringBuffer.append((char) charAt);
                    i++;
                } else {
                    int i2;
                    char c = charAt;
                    while (true) {
                        charArrayWriter.write(i2);
                        if (i2 >= 55296 && i2 <= 56319 && i + 1 < str.length()) {
                            c = str.charAt(i + 1);
                            if (c >= '?' && c <= '?') {
                                charArrayWriter.write(c);
                                i++;
                            }
                        }
                        i2 = i + 1;
                        if (i2 >= str.length()) {
                            break;
                        }
                        BitSet bitSet = cgF;
                        char charAt2 = str.charAt(i2);
                        if (bitSet.get(charAt2)) {
                            break;
                        }
                        char c2 = charAt2;
                        i = i2;
                        i2 = c2;
                    }
                    charArrayWriter.flush();
                    String str3 = new String(charArrayWriter.toCharArray());
                    o oVar = new o();
                    byte[] bytes = str3.getBytes(forName);
                    if (bytes == null) {
                        bytes = str3.getBytes();
                    }
                    for (int i3 = 0; i3 < bytes.length; i3++) {
                        stringBuffer.append('%');
                        charAt = Character.forDigit((bytes[i3] >> 4) & 15, 16);
                        if (Character.isLetter(charAt)) {
                            charAt = (char) (charAt - 32);
                        }
                        stringBuffer.append(charAt);
                        charAt = Character.forDigit(bytes[i3] & 15, 16);
                        if (Character.isLetter(charAt)) {
                            charAt = (char) (charAt - 32);
                        }
                        stringBuffer.append(charAt);
                    }
                    charArrayWriter.reset();
                    i = i2;
                    obj = 1;
                }
            }
            return obj != null ? stringBuffer.toString() : str;
        } catch (IllegalCharsetNameException e) {
            throw new UnsupportedEncodingException(str2);
        } catch (UnsupportedCharsetException e2) {
            throw new UnsupportedEncodingException(str2);
        }
    }
}
