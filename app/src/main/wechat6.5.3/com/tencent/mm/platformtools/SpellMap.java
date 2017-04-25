package com.tencent.mm.platformtools;

import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;

public class SpellMap {
    public static native String spellGetJni(int i, int i2);

    public static String f(char c) {
        int g = g(c);
        if (g < 65536) {
            return String.valueOf(c);
        }
        int i = g >> 16;
        g &= WebView.NORMAL_MODE_ALPHA;
        String spellGetJni = (i < 129 || i > 253) ? null : (g < 63 || g > 254) ? null : spellGetJni(i - 129, g - 63);
        if (spellGetJni == null) {
            return null;
        }
        String[] split = spellGetJni.split(",");
        if (split == null || split.length < 2) {
            return spellGetJni;
        }
        return split[0];
    }

    private static int g(char c) {
        if (c <= '') {
            return c;
        }
        try {
            byte[] bytes = String.valueOf(c).getBytes("GBK");
            if (bytes == null || bytes.length > 2 || bytes.length <= 0) {
                return '\u0000';
            }
            if (bytes.length == 1) {
                return bytes[0];
            }
            return bytes.length == 2 ? ((bytes[0] + FileUtils.S_IRUSR) << 16) + (bytes[1] + FileUtils.S_IRUSR) : '\u0000';
        } catch (UnsupportedEncodingException e) {
            return '\u0000';
        }
    }
}
