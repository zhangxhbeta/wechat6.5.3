package com.tencent.mm.c.b;

import android.os.Build;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.h.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class g {
    public static final String aUR = (e.cnj + "test.wav");
    public static final String aUS = (e.cnj + "test.pcm");

    public static class a {
        public int aUT = 0;
        public byte[] buf;

        public a(byte[] bArr, int i) {
            this.buf = bArr;
            this.aUT = i;
        }
    }

    public static class b {
        private static boolean aUU;
        private static boolean aUV;

        static {
            aUU = false;
            aUV = false;
            int rx = l.rx();
            v.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(rx));
            if (!be.kS(Build.CPU_ABI) && !Build.CPU_ABI.contains("armeabi") && !be.kS(Build.CPU_ABI2) && !Build.CPU_ABI2.contains("armeabi")) {
                v.i("MicroMsg.RecorderUtil", "don't contains armeabi");
                k.b("wechatvoicesilk_v5", g.class.getClassLoader());
                aUU = true;
                aUV = false;
            } else if ((rx & 1024) != 0) {
                try {
                    k.b("wechatvoicesilk_v7a", g.class.getClassLoader());
                    aUU = true;
                    aUV = true;
                } catch (UnsatisfiedLinkError e) {
                    v.e("MicroMsg.RecorderUtil", "load library failed!");
                    aUU = false;
                    aUV = false;
                }
            } else if ((rx & 512) != 0) {
                k.b("wechatvoicesilk", g.class.getClassLoader());
                aUU = true;
                aUV = true;
            } else {
                k.b("wechatvoicesilk_v5", g.class.getClassLoader());
                aUU = true;
                aUV = false;
            }
            v.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", Boolean.valueOf(aUU), Boolean.valueOf(aUV));
        }

        public static boolean po() {
            return aUV;
        }
    }

    public static int i(String str, int i) {
        try {
            i = be.getInt(j.sU().getValue(str), i);
        } catch (Exception e) {
            v.e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: " + str);
        } catch (Error e2) {
            v.e("MicroMsg.RecorderUtil", "error on parseInt failed, key: " + str);
        }
        return i;
    }
}
