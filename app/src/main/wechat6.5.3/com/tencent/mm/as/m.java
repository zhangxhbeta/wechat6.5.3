package com.tencent.mm.as;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;
import java.io.FileInputStream;

public final class m {
    private static String E(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            String toHexString = Integer.toHexString(bArr[i] & WebView.NORMAL_MODE_ALPHA);
            if (toHexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    public static boolean kX(String str) {
        v.d("MicroMsg.VideoFile", " filepath " + str);
        if (be.kS(str)) {
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[10];
            fileInputStream.read(bArr, 0, 10);
            String toUpperCase = E(bArr).toUpperCase();
            fileInputStream.close();
            v.d("MicroMsg.VideoFile", "file type " + toUpperCase);
            if (!toUpperCase.contains("00000014667479707174")) {
                return false;
            }
            v.d("MicroMsg.VideoFile", "file type qt ");
            return true;
        } catch (Throwable e) {
            v.e("MicroMsg.VideoFile", "exception:%s", be.e(e));
            return false;
        }
    }
}
