package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.aw.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.t.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class c implements ag {
    public static c Eg() {
        c cVar = (c) ak.yP().fY(c.class.getName());
        if (cVar != null) {
            return cVar;
        }
        Object cVar2 = new c();
        ak.yP().a(c.class.getName(), cVar2);
        return cVar2;
    }

    public static boolean h(at atVar) {
        if (atVar == null) {
            v.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
            return false;
        } else if (!atVar.bwj()) {
            v.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
            return false;
        } else if (i(atVar)) {
            return Eh();
        } else {
            v.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
            return false;
        }
    }

    public static boolean Eh() {
        String value = j.sU().getValue("C2CImgNotAutoDownloadTimeRange");
        v.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: " + value);
        if (b.iu(value)) {
            v.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
            return false;
        }
        int i = be.getInt(j.sU().getValue("ChatImgAutoDownload"), 1);
        if (i == 3) {
            v.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : " + i);
            return false;
        }
        Context context = aa.getContext();
        if (i == 2 && com.tencent.mm.sdk.platformtools.ak.isWifi(context)) {
            v.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            return true;
        } else if (i == 1 && com.tencent.mm.sdk.platformtools.ak.isWifi(context)) {
            v.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            return true;
        } else {
            long j = (long) be.getInt(j.sU().getValue("ChatImgAutoDownloadMax"), 0);
            ak.yW();
            long a = be.a((Long) com.tencent.mm.model.c.vf().get(a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
            long KM = be.KM((String) DateFormat.format("M", System.currentTimeMillis()));
            ak.yW();
            long a2 = be.a((Long) com.tencent.mm.model.c.vf().get(a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, null), 0);
            v.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + KM + " month " + a2 + " maxcount " + j + " current " + a + " downloadMode: " + i);
            if (KM != a2) {
                v.i("MicroMsg.SubCoreAutoDownload", "update month %d ", Long.valueOf(KM));
                ak.yW();
                com.tencent.mm.model.c.vf().a(a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(0));
                ak.yW();
                com.tencent.mm.model.c.vf().a(a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(KM));
                a2 = 0;
            } else {
                a2 = a;
            }
            if (a2 > j && j > 0) {
                v.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + a2 + " C2C image, can not auto download.");
                return false;
            } else if (i == 1 && (com.tencent.mm.sdk.platformtools.ak.isWifi(context) || com.tencent.mm.sdk.platformtools.ak.is3G(context) || com.tencent.mm.sdk.platformtools.ak.is4G(context))) {
                v.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
                return true;
            } else {
                v.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
                return false;
            }
        }
    }

    public static boolean Ei() {
        String value = j.sU().getValue("SnsImgPreLoadingAroundTimeLimit");
        v.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: " + value);
        if (b.iu(value)) {
            v.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
            return false;
        }
        v.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
        return true;
    }

    public static boolean a(PInt pInt, PInt pInt2, PInt pInt3) {
        pInt.value = 0;
        int i = be.getInt(j.sU().getValue("SIGHTAutoLoadNetwork"), 1);
        ak.yW();
        i = be.a((Integer) com.tencent.mm.model.c.vf().get(327686, null), i);
        pInt2.value = i;
        if (i == 3) {
            v.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
            return false;
        }
        boolean isWifi = com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext());
        if (i == 2 && !isWifi) {
            v.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
            return false;
        } else if (com.tencent.mm.sdk.platformtools.ak.is2G(aa.getContext())) {
            v.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
            return false;
        } else {
            String value = j.sU().getValue("SnsSightNoAutoDownload");
            if (!be.kS(value)) {
                try {
                    v.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq " + value);
                    long j = be.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0) - ((((long) (((int) b.Ef()) - 8)) * 60) / 1000);
                    String[] split = value.split(",");
                    long j2 = be.getLong(split[0], 0);
                    if (j <= be.getLong(split[1], 0) && j >= j2) {
                        v.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
                        pInt3.value = 1;
                        return false;
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", value, e.getMessage());
                }
            }
            String value2 = j.sU().getValue("SnsSightNotAutoDownloadTimeRange");
            v.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: " + value2);
            if (b.iu(value2)) {
                int i2;
                v.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
                if (i == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                return false;
            }
            v.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
            return true;
        }
    }

    public static boolean a(PInt pInt, PInt pInt2) {
        pInt.value = 0;
        int i = be.getInt(j.sU().getValue("SIGHTAutoLoadNetwork"), 1);
        ak.yW();
        int a = be.a((Integer) com.tencent.mm.model.c.vf().get(327686, null), i);
        pInt2.value = a;
        if (a == 3) {
            v.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
            return false;
        }
        boolean isWifi = com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext());
        if (a == 2 && !isWifi) {
            v.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
            return false;
        } else if (com.tencent.mm.sdk.platformtools.ak.is2G(aa.getContext())) {
            v.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
            return false;
        } else {
            String value = j.sU().getValue("SnsAdSightNotAutoDownloadTimeRange");
            v.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: " + value);
            if (b.iu(value)) {
                v.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
                if (a == 2) {
                    a = 2;
                } else {
                    a = 1;
                }
                pInt.value = a;
                return false;
            }
            v.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
            return true;
        }
    }

    public static boolean i(at atVar) {
        if (atVar == null) {
            v.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
            return false;
        }
        b fP = aw.fP(atVar.bNo);
        if (fP == null) {
            v.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
            return true;
        }
        String str = fP.ctD;
        if (be.kS(str)) {
            v.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
            return true;
        } else if (b.iu(str)) {
            v.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : " + str);
            return false;
        } else {
            v.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: " + str);
            return true;
        }
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
    }

    public final void aH(boolean z) {
    }

    public final void th() {
    }
}
