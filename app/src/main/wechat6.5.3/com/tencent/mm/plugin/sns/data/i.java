package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.f;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.u;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

public final class i {
    public static String ehZ = "<TimelineObject>";
    public static String eia = "</TimelineObject>";
    public static int jdZ = Integer.MAX_VALUE;
    public static String jea = "/";
    private static String jeb = "snsb";
    private static int jec = -1;
    private static int jed = -1;
    public static int jee = 4194304;
    public static int jef = 1048576;

    public static String ab(int i, String str) {
        return i + "-" + str;
    }

    public static String bl(List<aib> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        String str = "";
        int i = 0;
        for (aib com_tencent_mm_protocal_c_aib : list) {
            if (str.length() > 0) {
                str = str + "-";
            }
            str = str + com_tencent_mm_protocal_c_aib.gID;
            int i2 = i + 1;
            if (i2 >= 4) {
                return str;
            }
            i = i2;
        }
        return str;
    }

    private static String a(aib com_tencent_mm_protocal_c_aib) {
        if (!be.kS(com_tencent_mm_protocal_c_aib.mId)) {
            return com_tencent_mm_protocal_c_aib.mId;
        }
        String str = "";
        try {
            return g.m(com_tencent_mm_protocal_c_aib.toByteArray());
        } catch (Exception e) {
            return str;
        }
    }

    public static String zK(String str) {
        return "snst_" + zU(str);
    }

    public static String zL(String str) {
        return "snsb_" + zU(str);
    }

    public static String b(aib com_tencent_mm_protocal_c_aib) {
        String str = "snsb_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String c(aib com_tencent_mm_protocal_c_aib) {
        String str = "snst_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String zM(String str) {
        return "snsu_" + zU(str);
    }

    public static String d(aib com_tencent_mm_protocal_c_aib) {
        String str = "snsu_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String e(aib com_tencent_mm_protocal_c_aib) {
        String str = "snsblurt_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String f(aib com_tencent_mm_protocal_c_aib) {
        String str = "snsblurs_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String g(aib com_tencent_mm_protocal_c_aib) {
        String str = "snsbblur_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String h(aib com_tencent_mm_protocal_c_aib) {
        String str = "snstblur_src_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String i(aib com_tencent_mm_protocal_c_aib) {
        String str = "sight_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String j(aib com_tencent_mm_protocal_c_aib) {
        String str = "sightad_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str, com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String k(aib com_tencent_mm_protocal_c_aib) {
        String str = "snsb_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String l(aib com_tencent_mm_protocal_c_aib) {
        String str = "sns_tmpb_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String zN(String str) {
        return "sns_tmpb_" + zU(str);
    }

    public static String m(aib com_tencent_mm_protocal_c_aib) {
        String str = "sns_tmpt_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String zO(String str) {
        return "sns_tmpt_" + zU(str);
    }

    public static String n(aib com_tencent_mm_protocal_c_aib) {
        String str = "sns_tmpu_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String o(aib com_tencent_mm_protocal_c_aib) {
        String str = "sns_tmps_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String zP(String str) {
        return "sns_tmps_" + zU(str);
    }

    public static String p(aib com_tencent_mm_protocal_c_aib) {
        String str = "sns_tmpsad_" + zU(com_tencent_mm_protocal_c_aib.gID);
        if (com_tencent_mm_protocal_c_aib.mIb == 1) {
            return f.j(str + a(com_tencent_mm_protocal_c_aib), com_tencent_mm_protocal_c_aib.mIc);
        }
        return str;
    }

    public static String ac(int i, String str) {
        return i + "-" + str;
    }

    public static void x(String str, long j) {
        v.d("MicroMsg.SnsUtil", " name " + str + " allTime " + (System.currentTimeMillis() - j));
    }

    public static boolean i(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        return true;
    }

    public static boolean b(n nVar) {
        if (nVar == null || nVar.isRecycled()) {
            return false;
        }
        return true;
    }

    public static Bitmap q(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int lastIndexOf;
        if (be.kS(str)) {
            str = "";
        } else {
            lastIndexOf = str.lastIndexOf(jea);
            if (lastIndexOf > 0 && lastIndexOf + 1 < str.length()) {
                String substring = str.substring(lastIndexOf + 1);
                if (!(substring.startsWith(jeb) || substring.startsWith("sns_tmpb_") || (!substring.startsWith("snst_") && !substring.startsWith("snsu_")))) {
                    str = "";
                }
            }
        }
        if (be.kS(str)) {
            return bitmap;
        }
        Exif exif = new Exif();
        try {
            exif.parseFromFile(str);
            lastIndexOf = exif.getOrientationInDegree();
        } catch (Throwable e) {
            v.a("MicroMsg.SnsUtil", e, "Failed parsing JPEG file: " + str, new Object[0]);
            lastIndexOf = 0;
        }
        v.d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", new Object[]{str, Integer.valueOf(lastIndexOf)});
        return d.b(bitmap, (float) lastIndexOf);
    }

    public static n zQ(String str) {
        n nVar = null;
        try {
            v.i("MicroMsg.SnsUtil", "decodeFileToBlurThumbBitmap " + FileOp.aR(str));
            if (FileOp.aR(str)) {
                nVar = zS(str);
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SnsUtil", e, "snsdecode error", new Object[0]);
        }
        return nVar;
    }

    public static Bitmap zR(String str) {
        InputStream openRead;
        Throwable th;
        try {
            InputStream inputStream;
            if (!FileOp.aR(str)) {
                return null;
            }
            Options options = new Options();
            d.a(options);
            options.inSampleSize = 1;
            while (options.inSampleSize <= 10) {
                try {
                    openRead = FileOp.openRead(str);
                    try {
                        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                        long Nj = be.Nj();
                        Bitmap decodeStream = MMBitmapFactory.decodeStream(openRead, null, options, decodeResultLogger, 0, new int[0]);
                        long az = be.az(Nj);
                        if (options.inSampleSize > 1) {
                            v.w("MicroMsg.SnsUtil", "decode succ in " + options.inSampleSize);
                        }
                        if (decodeStream != null) {
                            decodeStream = q(str, decodeStream);
                            c.y(str, az);
                        } else if (decodeResultLogger.getDecodeResult() >= 2000) {
                            com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                        }
                        if (openRead == null) {
                            return decodeStream;
                        }
                        try {
                            openRead.close();
                            return decodeStream;
                        } catch (IOException e) {
                            return decodeStream;
                        }
                    } catch (OutOfMemoryError e2) {
                    }
                } catch (OutOfMemoryError e3) {
                    openRead = null;
                    try {
                        options.inSampleSize++;
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e4) {
                            }
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        inputStream = openRead;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            }
            return null;
            throw th;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        } catch (Throwable th5) {
            v.a("MicroMsg.SnsUtil", th5, "snsdecode error", new Object[0]);
            return null;
        }
    }

    public static n zS(String str) {
        try {
            if (!FileOp.aR(str)) {
                return null;
            }
            Options options = new Options();
            d.a(options);
            options.inSampleSize = 1;
            while (options.inSampleSize <= 10) {
                try {
                    DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                    long Nj = be.Nj();
                    n b = a.b(str, options, decodeResultLogger);
                    Nj = be.az(Nj);
                    if (b != null) {
                        c.y(str, Nj);
                    } else if (decodeResultLogger.getDecodeResult() >= 2000) {
                        com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                    }
                    return b;
                } catch (OutOfMemoryError e) {
                    options.inSampleSize++;
                }
            }
            return null;
        } catch (Throwable e2) {
            v.a("MicroMsg.SnsUtil", e2, "snsdecode error", new Object[0]);
            return null;
        }
    }

    public static String zT(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        while (stringBuffer.length() < 25) {
            stringBuffer.insert(0, "0");
        }
        return stringBuffer.toString();
    }

    public static String cE(long j) {
        return new BigInteger(Long.toBinaryString(j), 2).toString();
    }

    public static String cF(long j) {
        if (j == 0) {
            return "";
        }
        return zT(new BigInteger(Long.toBinaryString(j), 2).toString());
    }

    private static String zU(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        int i = 0;
        while (i < length && str.charAt(i) == '0') {
            i++;
        }
        return str.substring(i);
    }

    private static Rect w(Bitmap bitmap) {
        int width = bitmap.getWidth();
        return new Rect(width / 4, 0, (int) (((double) (width * 3)) / 4.0d), bitmap.getHeight());
    }

    private static Rect x(Bitmap bitmap) {
        return new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public static Bitmap f(List<n> list, int i) {
        for (n b : list) {
            if (!b(b)) {
                return null;
            }
        }
        if (i <= 0) {
            return null;
        }
        Rect rect;
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Config.ARGB_8888);
        int size = list.size();
        List linkedList = new LinkedList();
        int i2 = i >> 1;
        int i3 = i2 + 2;
        i2 -= 2;
        Rect rect2;
        if (size == 2) {
            rect = new Rect(0, 0, i2, i);
            rect2 = new Rect(i3, 0, i, i);
            linkedList.add(rect);
            linkedList.add(rect2);
        } else if (size == 3) {
            rect = new Rect(0, 0, i2, i);
            r7 = new Rect(i3, 0, i, i2);
            rect2 = new Rect(i3, i3, i, i);
            linkedList.add(rect);
            linkedList.add(r7);
            linkedList.add(rect2);
        } else if (size >= 4) {
            rect = new Rect(0, 0, i2, i2);
            r7 = new Rect(0, i3, i2, i);
            Rect rect3 = new Rect(i3, 0, i, i2);
            rect2 = new Rect(i3, i3, i, i);
            linkedList.add(rect);
            linkedList.add(r7);
            linkedList.add(rect3);
            linkedList.add(rect2);
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        i2 = 0;
        for (i3 = 0; i3 < list.size() && i2 < 4; i3++) {
            Rect x;
            Bitmap wn = ((n) list.get(i3)).wn();
            rect = (Rect) linkedList.get(i3);
            switch (list.size()) {
                case 1:
                    x = x(wn);
                    break;
                case 2:
                    x = w(wn);
                    break;
                case 3:
                    if (i3 != 0) {
                        x = x(wn);
                        break;
                    }
                    x = w(wn);
                    break;
                default:
                    x = x(wn);
                    break;
            }
            canvas.drawBitmap(wn, x, rect, null);
            i2++;
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public static boolean zV(String str) {
        return str.startsWith(e.cni);
    }

    public static boolean zW(String str) {
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            if (i2 >= i * 2 || i >= i2 * 2) {
                return true;
            }
            return false;
        } catch (Exception e) {
            v.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            return false;
        }
    }

    public static boolean zX(String str) {
        int i = jee;
        try {
            Options JS = d.JS(str);
            int i2 = JS.outWidth;
            int i3 = JS.outHeight;
            if ((i3 > 0 || i2 > 0) && i3 < i2 * 2 && i2 < i3 * 2 && i3 * i2 > i) {
                return true;
            }
            return false;
        } catch (Exception e) {
            v.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            return false;
        }
    }

    public static boolean pS(int i) {
        aa.getContext().getSharedPreferences(aa.bti(), 0).edit().putInt("sns_control_flag", i).commit();
        return true;
    }

    public static int aQZ() {
        return aa.getContext().getSharedPreferences(aa.bti(), 0).getInt("sns_control_flag", 0);
    }

    public static boolean pT(int i) {
        aa.getContext().getSharedPreferences(aa.bti(), 0).edit().putInt("sns_respone_count", i).commit();
        return true;
    }

    public static int aRa() {
        return aa.getContext().getSharedPreferences(aa.bti(), 0).getInt("sns_respone_count", 20);
    }

    public static String t(CharSequence charSequence) {
        int i = 0;
        if (charSequence == null) {
            return "";
        }
        SpannableString spannableString = new SpannableString(charSequence);
        j[] jVarArr = (j[]) spannableString.getSpans(0, spannableString.length(), j.class);
        v.d("MicroMsg.SnsUtil", "removeClickSpanInString, clickSpans.length:%d", new Object[]{Integer.valueOf(jVarArr.length)});
        while (i < jVarArr.length) {
            spannableString.removeSpan(jVarArr[i]);
            i++;
        }
        return spannableString.toString();
    }

    public static void b(View view, Context context) {
        if (view != null && u.ds(context) > 1.0f) {
            float ds = u.ds(context);
            LayoutParams layoutParams = view.getLayoutParams();
            int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(context, 60);
            if (layoutParams.width >= 0 && layoutParams.height >= 0) {
                int i = (int) (((float) layoutParams.width) * ds);
                int i2 = (int) (ds * ((float) layoutParams.height));
                if (i > fromDPToPix) {
                    i = fromDPToPix;
                }
                layoutParams.width = i;
                if (i2 <= fromDPToPix) {
                    fromDPToPix = i2;
                }
                layoutParams.height = fromDPToPix;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public static int aRb() {
        Context context = aa.getContext();
        if (ak.is2G(context)) {
            return 1;
        }
        if (ak.is3G(context)) {
            return 2;
        }
        if (ak.is4G(context)) {
            return 3;
        }
        if (ak.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public static boolean f(k kVar) {
        if (kVar.field_type == 3 || kVar.field_type == 4 || kVar.field_type == 5 || kVar.field_type == 6 || kVar.field_type == 9 || kVar.field_type == 10 || kVar.field_type == 11 || kVar.field_type == 12 || kVar.field_type == 13 || kVar.field_type == 14 || kVar.field_type == 17 || kVar.field_type == 22 || kVar.field_type == 23) {
            return true;
        }
        return false;
    }

    public static long Ef() {
        return ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / 60000))) / 60;
    }

    public static SpannableString a(String str, Context context, TextView textView) {
        if (be.kS(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("<img src=\"original_label.png\"/>  ");
        stringBuilder.append(str);
        return new SpannableString(com.tencent.mm.pluginsdk.ui.d.e.b(context, stringBuilder.toString(), (float) ((int) textView.getTextSize())));
    }

    public static String g(k kVar) {
        return kVar == null ? "0" : cE(kVar.field_snsId);
    }

    public static long zY(String str) {
        v.i("MicroMsg.SnsUtil", "seq %s to snsId %d ", new Object[]{str, Long.valueOf(new BigInteger(str).longValue())});
        return new BigInteger(str).longValue();
    }

    public static int zZ(String str) {
        int i = 0;
        try {
            if (!be.kS(str)) {
                v.i("MicroMsg.SnsUtil", "getSnsSightVideoDurationInSeconds, path: %s", new Object[]{str});
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                i = be.ee((long) be.getInt(mediaMetadataRetriever.extractMetadata(9), 0));
            }
        } catch (Throwable th) {
            v.e("MicroMsg.SnsUtil", "getSnsSightVideoDurationInSeconds error: %s", new Object[]{str});
        }
        return i;
    }
}
