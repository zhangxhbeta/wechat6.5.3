package com.tencent.smtt.utils;

import com.tencent.smtt.sdk.WebView;
import java.security.MessageDigest;

public final class h {
    public static String aX(String str) {
        String str2 = null;
        if (str != null) {
            try {
                byte[] bytes = str.getBytes();
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bytes);
                byte[] digest = instance.digest();
                if (digest != null && digest.length > 0) {
                    StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
                    for (int i = 0; i < digest.length; i++) {
                        if ((digest[i] & WebView.NORMAL_MODE_ALPHA) < 16) {
                            stringBuffer.append("0");
                        }
                        stringBuffer.append(Long.toString((long) (digest[i] & WebView.NORMAL_MODE_ALPHA), 16));
                    }
                    str2 = stringBuffer.toString();
                }
            } catch (Exception e) {
            }
        }
        return str2;
    }
}
