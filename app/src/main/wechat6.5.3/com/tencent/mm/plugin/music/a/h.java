package com.tencent.mm.plugin.music.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Toast;
import com.tencent.mm.ae.n;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMusicObject;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class h {
    private static final String[] hDb = new String[]{"#", "?", "&"};
    private static String hDc = null;
    private static String hDd = null;
    private static final Pattern hDe = Pattern.compile("songid=([0-9]+)");

    public static String ck(Context context) {
        Throwable th;
        String str = "";
        String packageName = aa.getPackageName();
        if (packageName != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                if (packageInfo != null) {
                    packageName = str + packageInfo.versionName;
                    try {
                        str = packageName + "." + packageInfo.versionCode;
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        str = packageName;
                        th = th2;
                        v.a("MicroMsg.Music.MusicUtil", th, "", new Object[0]);
                        return str;
                    }
                }
            } catch (NameNotFoundException e2) {
                th = e2;
                v.a("MicroMsg.Music.MusicUtil", th, "", new Object[0]);
                return str;
            }
        }
        return str;
    }

    public static String d(a aVar, boolean z) {
        ak.yW();
        File file = new File(c.xq(), "music");
        if (!file.exists()) {
            file.mkdirs();
        }
        v.d("MicroMsg.Music.MusicUtil", "music name %s path %s", new Object[]{z ? z.Kg(aVar.field_musicId + "temp") + "-wifi" : z.Kg(aVar.field_musicId + "temp"), new File(file, z ? z.Kg(aVar.field_musicId + "temp") + "-wifi" : z.Kg(aVar.field_musicId + "temp")).getAbsoluteFile()});
        return new File(file, z ? z.Kg(aVar.field_musicId + "temp") + "-wifi" : z.Kg(aVar.field_musicId + "temp")).getAbsolutePath();
    }

    public static String e(a aVar, boolean z) {
        return d(aVar, false) + "-thumb-" + z;
    }

    public static boolean wY(String str) {
        if (be.kS(str)) {
            return false;
        }
        v.w("MicroMsg.Music.MusicUtil", "url %s match ? %B", new Object[]{str, Boolean.valueOf(Uri.parse(str).getHost().contains(".qq.com"))});
        return Uri.parse(str).getHost().contains(".qq.com");
    }

    public static boolean e(a aVar) {
        v.d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", new Object[]{aVar.field_songWapLinkUrl, aVar.field_songWebUrl, aVar.field_songWifiUrl});
        if (be.kS(aVar.field_songWapLinkUrl) && be.kS(aVar.field_songWebUrl) && be.kS(aVar.field_songWifiUrl)) {
            return false;
        }
        return true;
    }

    public static String a(String str, String str2, boolean z, PBool pBool) {
        String str3;
        if (z || be.kS(str2)) {
            str3 = str;
        } else {
            str3 = str2;
        }
        if (be.kS(str3)) {
            return str3;
        }
        PString pString = new PString();
        v.i("MicroMsg.Music.MusicUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", new Object[]{str, str2, Boolean.valueOf(z)});
        String wZ = wZ(str3);
        if (wZ != null) {
            if (a(wZ, z, pString)) {
                pBool.value = z;
            }
        } else if (str3.contains("wechat_music_url=")) {
            a(str3.substring(str3.indexOf("wechat_music_url=") + 17), z, pString);
        } else {
            pString.value = str3;
        }
        return pString.value;
    }

    private static String wZ(String str) {
        if (be.kS(str)) {
            return null;
        }
        if (hDc != null && str.equals(hDc)) {
            return hDd;
        }
        String str2 = "";
        String str3 = null;
        for (String str22 : hDb) {
            str22 = str22 + "p=";
            if (str.contains(str22)) {
                str3 = str;
            }
            if (str3 != null) {
                break;
            }
        }
        String str4 = str3;
        str3 = str22;
        if (str4 == null) {
            return null;
        }
        int indexOf = str4 == null ? -1 : str4.indexOf(str3);
        if (indexOf < 0) {
            v.w("MicroMsg.Music.MusicUtil", "pIndex is %d, return", new Object[]{Integer.valueOf(indexOf)});
            return null;
        }
        String substring = str4.substring(str3.length() + indexOf);
        for (String indexOf2 : hDb) {
            int indexOf3 = substring.indexOf(indexOf2);
            if (indexOf3 > 0) {
                substring = substring.substring(0, indexOf3);
            }
        }
        if (substring == null) {
            return substring;
        }
        hDc = str;
        hDd = substring;
        return substring;
    }

    private static boolean a(String str, boolean z, PString pString) {
        String str2 = new String(xa(str));
        int indexOf = str2.indexOf("{");
        if (indexOf != -1) {
            str2 = str2.substring(indexOf);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("song_WapLiveURL");
            str2 = jSONObject.getString("song_WifiURL");
            v.d("MicroMsg.Music.MusicUtil", "waplive: " + string + "  wifi:" + str2);
            if (!z) {
                str2 = string;
            }
            pString.value = str2;
            return true;
        } catch (Exception e) {
            pString.value = str;
            return false;
        }
    }

    private static byte[] xa(String str) {
        byte[] bArr = new byte[((str.length() / 2) + (str.length() % 2))];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            try {
                int i3 = i + 1;
                int h = h(str.charAt(i));
                if (i3 < str.length()) {
                    i = i3 + 1;
                    i3 = h(str.charAt(i3));
                } else {
                    i = i3;
                    i3 = 0;
                }
                int i4 = i2 + 1;
                bArr[i2] = (byte) (i3 | (h << 4));
                i2 = i4;
            } catch (Exception e) {
                return null;
            }
        }
        return bArr;
    }

    private static int xb(String str) {
        int i = 0;
        if (!be.kS(str)) {
            Matcher matcher = hDe.matcher(str);
            if (matcher.find()) {
                try {
                    i = Integer.valueOf(matcher.group(1)).intValue();
                } catch (Exception e) {
                }
            }
        }
        return i;
    }

    private static int h(char c) {
        if (c >= '1' && c <= '9') {
            return c - 48;
        }
        if (c < 'A' || c > 'F') {
            return 0;
        }
        return (c - 65) + 10;
    }

    private static String g(ajr com_tencent_mm_protocal_c_ajr) {
        String str;
        String wZ;
        if (com_tencent_mm_protocal_c_ajr != null) {
            if (!be.kS(com_tencent_mm_protocal_c_ajr.mKc)) {
                str = com_tencent_mm_protocal_c_ajr.mKc;
            } else if (!be.kS(com_tencent_mm_protocal_c_ajr.mKe)) {
                str = com_tencent_mm_protocal_c_ajr.mKe;
            } else if (!be.kS(com_tencent_mm_protocal_c_ajr.mKd)) {
                str = com_tencent_mm_protocal_c_ajr.mKd;
            }
            if (str == null) {
                return null;
            }
            wZ = wZ(com_tencent_mm_protocal_c_ajr.mKc);
            if (wZ == null) {
                return wZ;
            }
            wZ = wZ(com_tencent_mm_protocal_c_ajr.mKe);
            if (wZ != null) {
                return wZ(com_tencent_mm_protocal_c_ajr.mKd);
            }
            return wZ;
        }
        str = null;
        if (str == null) {
            return null;
        }
        wZ = wZ(com_tencent_mm_protocal_c_ajr.mKc);
        if (wZ == null) {
            return wZ;
        }
        wZ = wZ(com_tencent_mm_protocal_c_ajr.mKe);
        if (wZ != null) {
            return wZ;
        }
        return wZ(com_tencent_mm_protocal_c_ajr.mKd);
    }

    public static ajr h(ajr com_tencent_mm_protocal_c_ajr) {
        if (com_tencent_mm_protocal_c_ajr != null) {
            com_tencent_mm_protocal_c_ajr.mAi = xb(com_tencent_mm_protocal_c_ajr.mKc);
            if (com_tencent_mm_protocal_c_ajr.mAi <= 0) {
                com_tencent_mm_protocal_c_ajr.mAi = xb(com_tencent_mm_protocal_c_ajr.mKe);
                if (com_tencent_mm_protocal_c_ajr.mAi <= 0) {
                    com_tencent_mm_protocal_c_ajr.mAi = xb(com_tencent_mm_protocal_c_ajr.mKd);
                    int i = com_tencent_mm_protocal_c_ajr.mAi;
                }
            }
        }
        if (!(com_tencent_mm_protocal_c_ajr == null || g(com_tencent_mm_protocal_c_ajr) == null)) {
            long currentTimeMillis = System.currentTimeMillis();
            v.d("MicroMsg.Music.MusicUtil", "bcdUrl: %s", new Object[]{g(com_tencent_mm_protocal_c_ajr)});
            String str = new String(xa(r1));
            int indexOf = str.indexOf("{");
            if (indexOf != -1) {
                str = str.substring(indexOf);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                com_tencent_mm_protocal_c_ajr.mAi = jSONObject.getInt("song_ID");
                if (be.kS(com_tencent_mm_protocal_c_ajr.mJY)) {
                    com_tencent_mm_protocal_c_ajr.mJY = jSONObject.getString("song_Name");
                }
                if (be.kS(com_tencent_mm_protocal_c_ajr.mKd)) {
                    com_tencent_mm_protocal_c_ajr.mKd = jSONObject.getString("song_WapLiveURL");
                }
                if (be.kS(com_tencent_mm_protocal_c_ajr.mKc)) {
                    com_tencent_mm_protocal_c_ajr.mKc = jSONObject.getString("song_WifiURL");
                }
                if (be.kS(com_tencent_mm_protocal_c_ajr.mKa)) {
                    com_tencent_mm_protocal_c_ajr.mKa = jSONObject.getString("song_Album");
                }
                if (be.kS(com_tencent_mm_protocal_c_ajr.mJZ)) {
                    com_tencent_mm_protocal_c_ajr.mJZ = jSONObject.getString("song_Singer");
                }
            } catch (Throwable e) {
                v.a("MicroMsg.Music.MusicUtil", e, "", new Object[0]);
            }
            if (com_tencent_mm_protocal_c_ajr.mAi == 0) {
                com_tencent_mm_protocal_c_ajr.mAi = xb(hDc);
            }
            v.i("MicroMsg.Music.MusicUtil", "parseBCDForMusicWrapper %s: expend: %d %d", new Object[]{com_tencent_mm_protocal_c_ajr.mJW, Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(com_tencent_mm_protocal_c_ajr.mAi)});
        }
        return com_tencent_mm_protocal_c_ajr;
    }

    private static float[] aP(List<float[]> list) {
        float[] fArr;
        if (list.size() > 4) {
            float[] fArr2 = null;
            int i = 0;
            while (i < list.size()) {
                if (((float[]) list.get(i))[2] < Float.MAX_VALUE) {
                    fArr = (float[]) list.get(i);
                } else {
                    fArr = fArr2;
                }
                i++;
                fArr2 = fArr;
            }
            if (((double) fArr2[2]) <= 0.15d) {
                return fArr2;
            }
            if (((double) fArr2[1]) > 0.5d) {
                fArr2[1] = fArr2[1] - 0.1f;
            }
            fArr2[2] = fArr2[2] - 0.1f;
            return fArr2;
        }
        fArr = (float[]) list.get(0);
        fArr[2] = 0.15f;
        return fArr;
    }

    public static int[] q(Bitmap bitmap) {
        int i;
        int i2;
        int[] iArr = new int[16];
        Bitmap.createScaledBitmap(bitmap, 4, 4, false).getPixels(iArr, 0, 4, 0, 0, 4, 4);
        float[][] fArr = new float[16][];
        for (int i3 = 0; i3 < 16; i3++) {
            float[] fArr2 = new float[3];
            Color.colorToHSV(iArr[i3], fArr2);
            fArr[i3] = fArr2;
        }
        int[] iArr2 = new int[8];
        SparseArray sparseArray = new SparseArray();
        for (i = 0; i < 16; i++) {
            i2 = 1;
            while (i2 <= 7) {
                if (fArr[i][0] < 360.0f * (((float) i2) / 7.0f)) {
                    iArr2[i2] = iArr2[i2] + 1;
                    List list = (List) sparseArray.get(i2);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(fArr[i]);
                    sparseArray.put(i2, list);
                } else {
                    i2++;
                }
            }
        }
        i2 = -1;
        boolean z = false;
        for (i = 1; i <= 7; i++) {
            if (iArr2[i] > z) {
                z = iArr2[i];
                i2 = i;
            }
        }
        float[] aP = aP((List) sparseArray.get(i2, new ArrayList()));
        float[] fArr3 = new float[3];
        if (((double) aP[2]) <= 0.15d) {
            fArr3[0] = aP[0];
            fArr3[1] = aP[1];
            fArr3[2] = aP[2] + 0.7f;
        } else {
            fArr3[0] = aP[0];
            fArr3[1] = aP[1];
            if (((double) aP[2]) + 0.5d >= 1.0d) {
                fArr3[2] = aP[2] - 0.5f;
            } else {
                fArr3[2] = aP[2] + 0.5f;
            }
        }
        if (fArr3[1] > 0.5f) {
            fArr3[1] = fArr3[1] - 0.1f;
        }
        return new int[]{Color.HSVToColor(aP), Color.HSVToColor(fArr3)};
    }

    public static String i(ajr com_tencent_mm_protocal_c_ajr) {
        return com_tencent_mm_protocal_c_ajr.mJV + "_" + z.Kg(com_tencent_mm_protocal_c_ajr.mJW);
    }

    public static void a(ajr com_tencent_mm_protocal_c_ajr, Activity activity) {
        g.iuh.Y(10910, "3");
        bp bpVar = new bp();
        qf qfVar = new qf();
        qg qgVar = new qg();
        pw pwVar = new pw();
        qgVar.Jn(k.xF());
        qgVar.Jo(k.xF());
        qgVar.uN(5);
        qgVar.dV(be.Ni());
        qgVar.Jt(k(com_tencent_mm_protocal_c_ajr));
        pwVar.ID(com_tencent_mm_protocal_c_ajr.mKc);
        pwVar.IE(com_tencent_mm_protocal_c_ajr.mKd);
        pwVar.IC(com_tencent_mm_protocal_c_ajr.mKe);
        a xe = i.aDe().xe(i(com_tencent_mm_protocal_c_ajr));
        if (xe.Hz()) {
            pwVar.IF(xe.field_songHAlbumUrl);
        } else {
            pwVar.IF(xe.field_songAlbumUrl);
        }
        pwVar.io(true);
        String j = j(com_tencent_mm_protocal_c_ajr);
        if (FileOp.aR(j)) {
            pwVar.IL(j);
        } else {
            pwVar.ip(true);
        }
        pwVar.Iw(com_tencent_mm_protocal_c_ajr.mJY);
        pwVar.Ix(com_tencent_mm_protocal_c_ajr.mJZ);
        pwVar.uG(7);
        bpVar.aZd.title = com_tencent_mm_protocal_c_ajr.mJY;
        bpVar.aZd.desc = com_tencent_mm_protocal_c_ajr.mJZ;
        bpVar.aZd.aZf = qfVar;
        bpVar.aZd.type = 7;
        qfVar.a(qgVar);
        qfVar.mtR.add(pwVar);
        bpVar.aZd.aXH = activity;
        bpVar.aZd.aZl = 3;
        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
    }

    public static boolean b(ajr com_tencent_mm_protocal_c_ajr, Activity activity) {
        g.iuh.Y(10910, "4");
        if (com_tencent_mm_protocal_c_ajr == null) {
            return false;
        }
        String str;
        String str2 = com_tencent_mm_protocal_c_ajr.mKe;
        int indexOf = str2 == null ? -1 : str2.indexOf("#p=");
        if ((indexOf < 0 ? null : str2.substring(indexOf + 3)) == null) {
            v.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", new Object[]{str2});
            str = "androidqqmusic://";
        } else {
            v.i("MicroMsg.Music.MusicUtil", "get qq music data %s", new Object[]{indexOf < 0 ? null : str2.substring(indexOf + 3)});
            str = String.format("androidqqmusic://from=webPlayer&data=%s", new Object[]{str});
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            v.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", new Object[]{str});
            return false;
        }
        b.HB();
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.addFlags(268435456);
        if (be.m(activity, intent)) {
            activity.startActivity(intent);
            return true;
        }
        intent = new Intent();
        intent.putExtra("rawUrl", str2);
        b.drp.j(intent, activity);
        return false;
    }

    public static void B(Activity activity) {
        com.tencent.mm.ay.c.a(activity, ".ui.transmit.SelectConversationUI", new Intent(), 1);
    }

    public static void a(ajr com_tencent_mm_protocal_c_ajr, Intent intent, MMActivity mMActivity) {
        String stringExtra = intent.getStringExtra("Select_Conv_User");
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = com_tencent_mm_protocal_c_ajr.mKe;
        wXMusicObject.musicDataUrl = com_tencent_mm_protocal_c_ajr.mKc;
        wXMusicObject.musicLowBandUrl = com_tencent_mm_protocal_c_ajr.mKd;
        wXMusicObject.musicLowBandDataUrl = com_tencent_mm_protocal_c_ajr.mKd;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = com_tencent_mm_protocal_c_ajr.mJY;
        wXMediaMessage.description = com_tencent_mm_protocal_c_ajr.mJZ;
        Bitmap bitmap = null;
        String j = j(com_tencent_mm_protocal_c_ajr);
        if (j != null && FileOp.aR(j)) {
            int dimension = (int) mMActivity.getResources().getDimension(2131493160);
            bitmap = d.H(j, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = be.I(bitmap);
        } else {
            wXMediaMessage.thumbData = be.I(d.uU(2130838083));
        }
        b.drp.a(mMActivity, k(com_tencent_mm_protocal_c_ajr), wXMediaMessage, stringExtra, l(com_tencent_mm_protocal_c_ajr));
        v.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", new Object[]{stringExtra});
    }

    public static void c(ajr com_tencent_mm_protocal_c_ajr, Activity activity) {
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = com_tencent_mm_protocal_c_ajr.mKe;
        wXMusicObject.musicDataUrl = com_tencent_mm_protocal_c_ajr.mKc;
        wXMusicObject.musicLowBandUrl = com_tencent_mm_protocal_c_ajr.mKd;
        wXMusicObject.musicLowBandDataUrl = com_tencent_mm_protocal_c_ajr.mKd;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = com_tencent_mm_protocal_c_ajr.mJY;
        wXMediaMessage.description = com_tencent_mm_protocal_c_ajr.mJZ;
        Bitmap bitmap = null;
        String j = j(com_tencent_mm_protocal_c_ajr);
        if (j != null && FileOp.aR(j)) {
            int dimension = (int) activity.getResources().getDimension(2131493160);
            bitmap = d.H(j, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = be.I(bitmap);
        } else {
            wXMediaMessage.thumbData = be.I(d.uU(2130838083));
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        com.tencent.mm.sdk.modelmsg.c.a aVar = new com.tencent.mm.sdk.modelmsg.c.a();
        aVar.nhM = wXMediaMessage;
        aVar.t(bundle);
        intent.putExtra("Ksnsupload_timeline", bundle);
        intent.putExtra("Ksnsupload_musicid", com_tencent_mm_protocal_c_ajr.mJW);
        intent.putExtra("Ksnsupload_appid", k(com_tencent_mm_protocal_c_ajr));
        intent.putExtra("Ksnsupload_appname", l(com_tencent_mm_protocal_c_ajr));
        String fz = o.fz("music_player");
        o.yx().n(fz, true).l("prePublishId", "music_player");
        intent.putExtra("reportSessionId", fz);
        b.drp.n(intent, activity);
    }

    private static String j(ajr com_tencent_mm_protocal_c_ajr) {
        String e = e(i.aDe().xe(i(com_tencent_mm_protocal_c_ajr)), true);
        if (!FileOp.aR(e)) {
            switch (com_tencent_mm_protocal_c_ajr.mJV) {
                case 0:
                    e = n.GH().w(com_tencent_mm_protocal_c_ajr.mKg, true);
                    break;
                case 4:
                    e = j.a.bmq().zq(com_tencent_mm_protocal_c_ajr.mKb);
                    if (be.kS(e)) {
                        e = com_tencent_mm_protocal_c_ajr.mKg;
                        break;
                    }
                    break;
                case 5:
                    if (com_tencent_mm_protocal_c_ajr.mKg != null) {
                        e = com_tencent_mm_protocal_c_ajr.mKg;
                        break;
                    }
                    e = "";
                    break;
                case 6:
                    if (com_tencent_mm_protocal_c_ajr.mKg != null) {
                        e = com_tencent_mm_protocal_c_ajr.mKg;
                        break;
                    }
                    e = "";
                    break;
                case 7:
                    if (com_tencent_mm_protocal_c_ajr.mKg != null) {
                        e = com_tencent_mm_protocal_c_ajr.mKg;
                        break;
                    }
                    e = "";
                    break;
                default:
                    if (j.ak.lyf != null) {
                        aib com_tencent_mm_protocal_c_aib = new aib();
                        com_tencent_mm_protocal_c_aib.gID = com_tencent_mm_protocal_c_ajr.mfo;
                        com_tencent_mm_protocal_c_aib.mHP = com_tencent_mm_protocal_c_ajr.mKb;
                        com_tencent_mm_protocal_c_aib.mHQ = com_tencent_mm_protocal_c_ajr.mKi;
                        com_tencent_mm_protocal_c_aib.glb = com_tencent_mm_protocal_c_aib.mHP;
                        e = j.ak.lye.s(com_tencent_mm_protocal_c_aib);
                        break;
                    }
                    break;
            }
        }
        v.i("MicroMsg.Music.MusicUtil", "real album path = %s", new Object[]{e});
        return e;
    }

    public static String k(ajr com_tencent_mm_protocal_c_ajr) {
        String str = com_tencent_mm_protocal_c_ajr.glj;
        if (!be.kS(str)) {
            return str;
        }
        switch (com_tencent_mm_protocal_c_ajr.mJV) {
            case 4:
                return "wx485a97c844086dc9";
            case 5:
                return "wx482a4001c37e2b74";
            default:
                return str;
        }
    }

    private static String l(ajr com_tencent_mm_protocal_c_ajr) {
        switch (com_tencent_mm_protocal_c_ajr.mJV) {
            case 0:
            case 1:
            case 8:
                return aa.getContext().getString(2131235490);
            case 4:
                return aa.getContext().getString(2131235260);
            case 5:
                return aa.getContext().getString(2131234771);
            default:
                return aa.getContext().getString(2131232270);
        }
    }

    public static void C(Activity activity) {
        ak.yW();
        if (((Boolean) c.vf().get(82, Boolean.valueOf(true))).booleanValue()) {
            ak.yW();
            c.vf().set(82, Boolean.valueOf(false));
            switch (i.aDd().aCW().field_musicType) {
                case 0:
                    b.q(activity, 2131235228);
                    return;
                case 1:
                case 8:
                    b.q(activity, 2131235231);
                    return;
                case 4:
                    b.q(activity, 2131235230);
                    return;
                case 6:
                    b.q(activity, 2131235229);
                    return;
                default:
                    return;
            }
        } else if (i.aDd().mode == 2) {
            Toast.makeText(aa.getContext(), 2131235607, 0).show();
        } else {
            Toast.makeText(aa.getContext(), 2131235608, 0).show();
        }
    }
}
