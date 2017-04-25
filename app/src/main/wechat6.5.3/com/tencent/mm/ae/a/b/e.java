package com.tencent.mm.ae.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.ae.a.c.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class e implements k {
    public final boolean V(String str, String str2) {
        if (be.kS(str2)) {
            v.w("MicroMsg.DefaultImageMD5CheckListener", "hy: filePath is null. check failed");
            return false;
        } else if (be.kS(str)) {
            v.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        } else {
            String aX = g.aX(str2);
            if (be.kS(aX) || !aX.equals(str)) {
                v.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", aX, str);
                return false;
            }
            v.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
            return true;
        }
    }

    public final boolean j(String str, byte[] bArr) {
        if (be.kS(str)) {
            v.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        }
        String bi = z.bi(bArr);
        if (be.kS(bi) || !bi.equals(str)) {
            v.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", bi, str);
            return false;
        }
        v.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
        return true;
    }

    public final boolean a(String str, InputStream inputStream) {
        if (inputStream == null) {
            v.w("MicroMsg.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
            return false;
        } else if (be.kS(str)) {
            v.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        } else {
            try {
                String bi = z.bi(a(inputStream, true));
                if (be.kS(bi) || !bi.equals(str)) {
                    v.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", bi, str);
                    return false;
                }
                v.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
                return true;
            } catch (Exception e) {
                v.w("MicroMsg.DefaultImageMD5CheckListener", "hy: exception: " + e.toString());
                return false;
            }
        }
    }

    public static byte[] g(InputStream inputStream) {
        return a(inputStream, false);
    }

    public static byte[] a(InputStream inputStream, boolean z) {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        bArr = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        if (!z) {
            inputStream.close();
        }
        return bArr;
    }
}
