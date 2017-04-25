package com.tencent.mm.plugin.sight.encode.a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.a.e;
import com.tencent.mm.as.k;
import com.tencent.mm.as.n;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public final class g {

    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ int cSC = -1;
        final /* synthetic */ a iXi;

        AnonymousClass2(a aVar, int i) {
            this.iXi = aVar;
        }

        public final void run() {
        }
    }

    public interface a {
        void onError(int i);
    }

    public static final boolean a(byte[] bArr, int i, int i2, String str) {
        if (bArr == null) {
            v.e("MicroMsg.SightRecorderHelper", "save thumb fail, thumb yuv is null");
            return false;
        }
        boolean z;
        try {
            YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
            OutputStream fileOutputStream = new FileOutputStream(new File(str));
            yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 75, fileOutputStream);
            fileOutputStream.close();
            z = true;
        } catch (Throwable e) {
            v.a("MicroMsg.SightRecorderHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            z = false;
        } catch (Throwable e2) {
            v.a("MicroMsg.SightRecorderHelper", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            z = false;
        } catch (Throwable e22) {
            v.a("MicroMsg.SightRecorderHelper", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
            z = false;
        }
        return z;
    }

    static void a(final a aVar, final int i) {
        if (aVar != null) {
            ad.o(new Runnable() {
                public final void run() {
                    aVar.onError(i);
                }
            });
        }
    }

    public final void a(String str, int i, String str2, String str3, a aVar) {
        if (be.kS(str)) {
            v.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
            a(aVar, -1);
        } else if (be.kS(str3)) {
            v.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
            a(aVar, -1);
        } else if (!e.aR(str) || e.aQ(str) <= 0) {
            v.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
            com.tencent.mm.ui.base.g.bf(aa.getContext(), aa.getContext().getString(2131235309));
        } else {
            v.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", str2, com.tencent.mm.a.g.aX(str));
            if (be.ah(str2, SQLiteDatabase.KeyEmpty).equals(com.tencent.mm.a.g.aX(str))) {
                final String str4 = str3;
                final a aVar2 = aVar;
                final String str5 = str;
                final int i2 = i;
                if (ak.vA().x(new Runnable(this) {
                    final /* synthetic */ g iXk;

                    public final void run() {
                        v.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s", str4);
                        String lb = o.lb(str4);
                        if (-1 == p.d(lb, 1, str4)) {
                            v.e("MicroMsg.SightRecorderHelper", "prepare sight error, filename %s", lb);
                            g.a(aVar2, -1);
                            return;
                        }
                        String zz = d.zz(str5);
                        if (!e.aR(zz)) {
                            v.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
                            try {
                                com.tencent.mm.sdk.platformtools.d.a(d.F(str5, 320, 240), 60, CompressFormat.JPEG, zz, true);
                            } catch (Throwable e) {
                                v.a("MicroMsg.SightRecorderHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                v.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                            }
                        }
                        k.KV();
                        e.p(zz, o.ld(lb));
                        k.KV();
                        v.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", str4, Long.valueOf(e.p(str5, o.lc(lb))));
                        if (e.p(str5, o.lc(lb)) <= 0) {
                            v.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error", str5, r0);
                            g.a(aVar2, -1);
                            p.lh(lb);
                            return;
                        }
                        p.f(lb, i2, 62);
                        p.lk(lb);
                        a aVar = aVar2;
                        if (aVar != null) {
                            ad.o(new AnonymousClass2(aVar, -1));
                        }
                        b.deleteFile(str5);
                        b.deleteFile(zz);
                    }
                }) < 0) {
                    v.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                    a(aVar, -1);
                    return;
                }
                return;
            }
            v.e("MicroMsg.SightRecorderHelper", "error md5, return");
            a(aVar, -1);
        }
    }

    public final void a(String str, int i, String str2, List<String> list, a aVar) {
        if (be.kS(str)) {
            v.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
            a(aVar, -1);
        } else if (list == null || list.isEmpty()) {
            v.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser list empty");
            a(aVar, -1);
        } else if (!e.aR(str) || e.aQ(str) <= 0) {
            v.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
            com.tencent.mm.ui.base.g.bf(aa.getContext(), aa.getContext().getString(2131235309));
        } else {
            v.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", str2, com.tencent.mm.a.g.aX(str));
            if (be.ah(str2, SQLiteDatabase.KeyEmpty).equals(com.tencent.mm.a.g.aX(str))) {
                final String str3 = str;
                final List<String> list2 = list;
                final String str4 = str2;
                final a aVar2 = aVar;
                final int i2 = i;
                if (ak.vA().x(new Runnable(this) {
                    final /* synthetic */ g iXk;

                    public final void run() {
                        int i;
                        long j;
                        String zz = d.zz(str3);
                        if (!e.aR(zz)) {
                            v.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
                            try {
                                com.tencent.mm.sdk.platformtools.d.a(d.F(str3, 320, 240), 60, CompressFormat.JPEG, zz, true);
                            } catch (Throwable e) {
                                v.a("MicroMsg.SightRecorderHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                v.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                            }
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append((String) list2.get(0));
                        for (i = 1; i < list2.size(); i++) {
                            stringBuilder.append(',');
                            stringBuilder.append((String) list2.get(i));
                        }
                        String stringBuilder2 = stringBuilder.toString();
                        Cursor rawQuery = k.KV().cuX.rawQuery("SELECT MAX(masssendid) FROM videoinfo2", null);
                        if (rawQuery == null) {
                            j = 0;
                        } else {
                            j = 0;
                            if (rawQuery.moveToFirst()) {
                                j = rawQuery.getLong(0);
                            }
                            rawQuery.close();
                        }
                        long j2 = 1 + j;
                        for (i = 0; i < list2.size(); i++) {
                            String str = (String) list2.get(i);
                            v.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s, massSendId %d, massSendList %s, videoMD5 %s", str, Long.valueOf(j2), stringBuilder2, str4);
                            String lb = o.lb(str);
                            k.KV();
                            String ld = o.ld(lb);
                            k.KV();
                            String lc = o.lc(lb);
                            v.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightThumbSize %d bytes", str, Long.valueOf(e.p(zz, ld)));
                            if (e.p(zz, ld) <= 0) {
                                v.e("MicroMsg.SightRecorderHelper", "copy remux thumb path from %s to %s error, index %d", zz, ld, Integer.valueOf(i));
                                g.a(aVar2, i);
                            } else {
                                v.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", str, Long.valueOf(e.p(str3, lc)));
                                if (e.p(str3, lc) <= 0) {
                                    v.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error, index %d", str3, lc, Integer.valueOf(i));
                                    g.a(aVar2, i);
                                } else {
                                    int i2 = i2;
                                    lc = str4;
                                    n nVar = new n();
                                    nVar.aST = lb;
                                    nVar.dhK = i2;
                                    nVar.ble = str;
                                    ak.yW();
                                    nVar.dhC = (String) c.vf().get(2, SQLiteDatabase.KeyEmpty);
                                    nVar.dhH = be.Nh();
                                    nVar.dhI = be.Nh();
                                    nVar.dhQ = null;
                                    nVar.dgk = null;
                                    nVar.dhO = 0;
                                    nVar.dhR = 3;
                                    k.KV();
                                    int le = o.le(o.lc(lb));
                                    if (le <= 0) {
                                        v.e("MicroMsg.VideoLogic", "initMassSendSight::get Video size failed:" + lb);
                                    } else {
                                        nVar.cyu = le;
                                        k.KV();
                                        str = o.ld(lb);
                                        i2 = o.le(str);
                                        if (i2 <= 0) {
                                            v.e("MicroMsg.VideoLogic", "get Thumb size failed :" + str + " size:" + i2);
                                        } else {
                                            nVar.dhG = i2;
                                            v.i("MicroMsg.VideoLogic", "initMassSendSight file:" + lb + " thumbsize:" + nVar.dhG + " videosize:" + nVar.cyu);
                                            nVar.status = 200;
                                            v.i("MicroMsg.VideoLogic", "massSendId %d, videoMD5 %s, massSendList %s", Long.valueOf(j2), lc, stringBuilder2);
                                            nVar.dhS = stringBuilder2;
                                            nVar.dgv = j2;
                                            nVar.bov = lc;
                                            k.KV().a(nVar);
                                        }
                                    }
                                }
                            }
                        }
                        p.at(j2);
                        b.deleteFile(str3);
                        b.deleteFile(zz);
                    }
                }) < 0) {
                    v.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                    a(aVar, -1);
                    return;
                }
                return;
            }
            v.e("MicroMsg.SightRecorderHelper", "error md5, return");
            a(aVar, -1);
        }
    }

    public static void a(Context context, String str, String str2, String str3, boolean z, int i) {
        v.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", str2, str);
        if (!e.aR(str)) {
            try {
                com.tencent.mm.sdk.platformtools.d.a(d.F(str2, 320, 240), 60, CompressFormat.JPEG, str, true);
            } catch (Throwable e) {
                v.a("MicroMsg.SightRecorderHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
            }
        }
        Intent intent = new Intent();
        intent.putExtra("KSightPath", str2);
        intent.putExtra("KSightThumbPath", str);
        intent.putExtra("sight_md5", str3);
        intent.putExtra("KSightDraftEntrance", z);
        intent.putExtra("Ksnsupload_source", i);
        intent.putExtra("KSnsPostManu", true);
        intent.putExtra("KTouchCameraTime", be.Nh());
        com.tencent.mm.ay.c.b(context, "sns", ".ui.SightUploadUI", intent, 5985);
    }
}
