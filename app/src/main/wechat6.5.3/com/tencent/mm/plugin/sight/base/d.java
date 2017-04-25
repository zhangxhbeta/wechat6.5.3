package com.tencent.mm.plugin.sight.base;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public final class d {
    private static int hli = 0;
    private static int hlj = 0;

    public static String aOQ() {
        r2 = new Object[2];
        ak.yW();
        r2[0] = c.getAccVideoPath();
        int i = hli;
        hli = i + 1;
        r2[1] = Integer.valueOf(i);
        File file = new File(String.format("%s/tempvideo%s.mp4", r2));
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(file.getAbsolutePath() + ".remux");
        if (file2.exists()) {
            file2.delete();
        }
        file2 = new File(file.getAbsoluteFile() + ".thumb");
        if (file2.exists()) {
            file2.delete();
        }
        file2 = new File(file.getAbsoluteFile() + ".soundmp4");
        if (file2.exists()) {
            file2.delete();
        }
        final int i2 = hli - 3;
        ak.vA().x(new Runnable() {
            public final void run() {
                for (int bp = d.hlj; bp < i2; bp++) {
                    r3 = new Object[2];
                    ak.yW();
                    r3[0] = c.getAccVideoPath();
                    r3[1] = Integer.valueOf(bp);
                    File file = new File(String.format("%s/tempvideo%s.mp4", r3));
                    if (file.exists()) {
                        file.delete();
                    }
                    File file2 = new File(file.getAbsolutePath() + ".remux");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2 = new File(file.getAbsoluteFile() + ".thumb");
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
                d.hlj = Math.max(i2, 0);
            }
        });
        return file.getAbsolutePath();
    }

    public static boolean aOR() {
        if (p.ceC.cfm == 0) {
            return false;
        }
        return com.tencent.mm.compatible.util.d.dW(14);
    }

    public static boolean aOS() {
        if (p.ceC.cfk == 0) {
            return false;
        }
        if (com.tencent.mm.compatible.util.d.dX(17)) {
            return false;
        }
        ak.yW();
        String str = (String) c.vf().get(344067, SQLiteDatabase.KeyEmpty);
        if (be.kS(str)) {
            v.i("MicroMsg.SightUtil", "not find fail record when use mediaCodec");
            return true;
        }
        String[] split = str.split(":");
        if (split == null || split.length < 2) {
            v.w("MicroMsg.SightUtil", "check use mediacodec by AAC Config error:%s", "config format ERROR");
            return true;
        }
        int KL = be.KL(split[0]);
        int KL2 = be.KL(split[1]);
        if (com.tencent.mm.compatible.util.d.dY(KL)) {
            v.w("MicroMsg.SightUtil", "check use mediacodec by AAC Config :%s", "User has upgrade system, should try again");
            ak.yW();
            c.vf().set(344067, SQLiteDatabase.KeyEmpty);
            return true;
        }
        v.w("MicroMsg.SightUtil", "check use mediacodec by AAC Config :failed %d times", Integer.valueOf(KL2));
        return KL2 < 3;
    }

    public static void aOT() {
        Object format;
        ak.yW();
        String str = (String) c.vf().get(344067, SQLiteDatabase.KeyEmpty);
        if (be.kS(str)) {
            format = String.format("%d:%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(1)});
            v.i("MicroMsg.SightUtil", "mark use mediacodec fail, create config %s", format);
        } else {
            String[] split = str.split(":");
            if (split == null || split.length < 2) {
                format = String.format("%d:%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(1)});
                v.i("MicroMsg.SightUtil", "mark use mediacodec fail, recreate config %s", format);
            } else {
                int KL = be.KL(split[0]);
                int KL2 = be.KL(split[1]) + 1;
                format = String.format("%d:%d", new Object[]{Integer.valueOf(KL), Integer.valueOf(KL2)});
                v.i("MicroMsg.SightUtil", "mark use mediacodec fail, refresh config %s", format);
            }
        }
        ak.yW();
        c.vf().set(344067, format);
    }

    public static String zz(String str) {
        return be.ah(str, SQLiteDatabase.KeyEmpty) + ".thumb";
    }

    public static String zA(String str) {
        return be.ah(str, SQLiteDatabase.KeyEmpty) + ".soundmp4";
    }

    public static void zB(final String str) {
        ak.yW();
        if (((Boolean) c.vf().get(344065, Boolean.valueOf(false))).booleanValue()) {
            ad.o(new Runnable() {
                public final void run() {
                    g.bf(aa.getContext(), str);
                }
            });
        }
    }

    public static Bitmap F(String str, int i, int i2) {
        if (be.kS(str)) {
            return null;
        }
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        if (createVideoThumbnail != null) {
            return com.tencent.mm.sdk.platformtools.d.a(createVideoThumbnail, i2, i, true, true);
        }
        v.e("MicroMsg.SightUtil", "create remux thumb bmp error, target path %s", str);
        return createVideoThumbnail;
    }

    public static boolean zC(String str) {
        if (be.kS(str) || !e.aR(str)) {
            return false;
        }
        long Nj = be.Nj();
        c cVar = new c();
        int isSightOk = SightVideoJNI.isSightOk(str, cVar.iTB, cVar.iTC, cVar.iTD, cVar.iTF, cVar.iTE, cVar.iTE.length);
        v.d("MicroMsg.SightUtil", "ashu::check sight use %dms", Long.valueOf(be.az(Nj)));
        return isSightOk == 0;
    }

    public static String aOU() {
        String format;
        StringBuilder stringBuilder = new StringBuilder(512);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = aa.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.cmU);
        stringBuilderPrinter.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.cmX + ":" + com.tencent.mm.sdk.platformtools.e.cmY + ":" + f.aPW);
        stringBuilderPrinter.println("#accinfo.env=" + (b.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + b.nhm);
        stringBuilderPrinter.println("#aacinfo.device_brand=" + com.tencent.mm.protocal.d.lWa);
        stringBuilderPrinter.println("#aacinfo.device_model=" + com.tencent.mm.protocal.d.lWb);
        stringBuilderPrinter.println("#aacinfo.os_type=" + com.tencent.mm.protocal.d.lWc);
        stringBuilderPrinter.println("#aacinfo.os_name=" + com.tencent.mm.protocal.d.lWd);
        stringBuilderPrinter.println("#aacinfo.os_version=" + com.tencent.mm.protocal.d.lWe);
        stringBuilderPrinter.println("#aacinfo.device_name=" + com.tencent.mm.protocal.d.lWf);
        String str = SQLiteDatabase.KeyEmpty;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(com.tencent.mm.compatible.util.e.cni);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) context.getSystemService("activity")).getMemoryClass()), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), com.tencent.mm.compatible.util.e.cni, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            v.e("MicroMsg.SightUtil", "check data size failed :%s", e.getMessage());
            format = str;
        }
        stringBuilderPrinter.println("#accinfo.data=" + format);
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }

    public static String wu(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("extInfo: \n" + a(str, new PInt(), new PInt(), new PInt(), new PInt(), new PInt()));
        stringBuffer.append("size: " + be.aw(FileOp.jP(str)) + ":" + str + "\n");
        String mp4RecordInfo = SightVideoJNI.getMp4RecordInfo(str);
        if (!be.kS(mp4RecordInfo)) {
            stringBuffer.append(mp4RecordInfo);
        }
        return stringBuffer.toString();
    }

    public static String a(String str, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            v.d("MicroMsg.SightUtil", "get simple mp4 info %s", SightVideoJNI.getSimpleMp4Info(str));
            JSONObject jSONObject = new JSONObject(r0);
            pInt.value = (int) jSONObject.getDouble("videoDuration");
            pInt2.value = jSONObject.getInt("videoWidth");
            pInt3.value = jSONObject.getInt("videoHeight");
            pInt4.value = (int) jSONObject.getDouble("videoFPS");
            pInt5.value = jSONObject.getInt("videoBitrate");
            stringBuffer.append("videoBitrate: ").append(pInt5.value).append("\n");
            stringBuffer.append("videoWidth,videoHeight: ").append(pInt2.value).append("*").append(pInt3.value);
            stringBuffer.append(" ").append(String.format("%.4f", new Object[]{Double.valueOf((((double) pInt2.value) * 1.0d) / ((double) pInt3.value))})).append("\n");
            stringBuffer.append("videoDuration: ").append(pInt.value).append("\n");
            stringBuffer.append("videoFPS: ").append(pInt4.value).append("\n");
        } catch (Throwable e) {
            v.a("MicroMsg.SightUtil", e, "get media info error", new Object[0]);
        }
        zD(str);
        return stringBuffer.toString();
    }

    public static a zD(String str) {
        a aVar = null;
        if (!be.kS(str) && e.aR(str)) {
            aVar = new a();
            try {
                v.d("MicroMsg.SightUtil", "get simple mp4 info %s", SightVideoJNI.getSimpleMp4Info(str));
                JSONObject jSONObject = new JSONObject(r1);
                aVar.hpy = (int) jSONObject.getDouble("videoDuration");
                aVar.width = jSONObject.getInt("videoWidth");
                aVar.height = jSONObject.getInt("videoHeight");
                aVar.hqh = (int) jSONObject.getDouble("videoFPS");
                aVar.cGx = jSONObject.getInt("videoBitrate");
                aVar.cGk = jSONObject.getInt("audioBitrate");
                aVar.iTr = jSONObject.getInt("audioChannel");
            } catch (Exception e) {
                v.e("MicroMsg.SightUtil", "get media info error %s", e.toString());
            }
            v.i("MicroMsg.SightUtil", "get media %s", aVar);
        }
        return aVar;
    }
}
