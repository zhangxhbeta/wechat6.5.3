package com.tencent.mm.compatible.util;

import com.tencent.mm.loader.stub.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class e extends a {
    public static final String cgd = h.getExternalStorageDirectory().getParent();
    public static String cge = (cnj + "Download/");
    public static String cgf;
    public static String cgg;
    public static String cgh = (cnj + "vusericon/");
    public static String cgj = (cnj + "Game/");
    public static String cgk = (cnj + "CDNTemp/");
    public static String cgl = (cnj + "Download/VoiceRemind");
    public static String cgm = (cnj + "watchdog/");
    public static String cgn = (cnj + "xlog");
    public static String cgo = (cnj + "avatar/");
    public static String cgp = (cnj + "exdevice/");
    public static String cgq = (cnj + "newyear/");
    public static String cgr = (cnj + "expose/");
    public static String cgs = (cnj + "WebviewCache/");
    public static String cgt = (cnj + "sniffer/");

    public static void dt(String str) {
        v.i("MicroMsg.CConstants", "initSdCardPath start SDCARD_ROOT: " + cni);
        if (be.kS(str)) {
            int i;
            ArrayList btT = at.btT();
            int size = btT.size();
            for (i = 0; i < size; i++) {
                v.i("MicroMsg.CConstants", "initSdCardPath start list i = " + i + " StatMountParse: " + btT.get(i));
            }
            if (size > 1) {
                Collections.sort(btT, new Comparator<at.a>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        at.a aVar = (at.a) obj;
                        at.a aVar2 = (at.a) obj2;
                        long j = (aVar.nlb * aVar.nlc) - (aVar2.nlb * aVar2.nlc);
                        if (j < 0) {
                            return 1;
                        }
                        return j > 0 ? -1 : 0;
                    }
                });
            }
            if (!(size <= 0 || btT.get(0) == null || be.kS(((at.a) btT.get(0)).nkX))) {
                cni = ((at.a) btT.get(0)).nkX;
                for (i = 0; i < size; i++) {
                    v.i("MicroMsg.CConstants", "initSdCardPath end list i = " + i + " StatMountParse: " + btT.get(i));
                }
            }
        } else {
            cni = str;
        }
        cnj = cni + dEh;
        cge = cnj + "Download/";
        cgh = cnj + "vusericon/";
        cgj = cnj + "Game/";
        cgk = cnj + "CDNTemp/";
        cgm = cnj + "watchdog/";
        cgn = cnj + "xlog";
        cnk = cnj + "crash/";
        cgo = cnj + "avatar/";
        cgf = cnj + "Cache/";
        String str2 = cnj + "WeChat/";
        String str3 = cnj + "WeiXin/";
        if (com.tencent.mm.a.e.aR(str2) || !(com.tencent.mm.a.e.aR(str3) || u.bsY().equals("zh_CN"))) {
            str3 = str2;
        }
        cgg = str3;
        v.i("MicroMsg.CConstants", "initSdCardPath end SDCARD_ROOT: " + cni);
    }
}
