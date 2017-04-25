package com.tencent.mm.modelsearch;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.bf.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.afv;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.f.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Pattern;

public final class h {
    public static final Pattern cVB = Pattern.compile(";");
    public static final int cVM = Color.parseColor("#45C01A");
    public static final int cVN = com.tencent.mm.bd.a.N(aa.getContext(), 2131493169);
    public static final TextPaint cVO = new TextPaint();
    public static final int cVP = com.tencent.mm.bd.a.N(aa.getContext(), 2131493128);
    public static final TextPaint cVQ = new TextPaint();
    public static final int cVR = com.tencent.mm.bd.a.N(aa.getContext(), 2131493202);
    public static final TextPaint cVS = new TextPaint();
    public static int cVT = 1;
    private static String[] cVU = new String[]{"wxid_", "wx_", "gh_"};
    private static String cnh = SQLiteDatabase.KeyEmpty;

    static class a {
        int end = -1;
        int start = -1;

        a() {
        }

        final boolean isAvailable() {
            return this.start >= 0;
        }
    }

    public static final class b implements com.tencent.mm.pluginsdk.j.q.e.a {
        public final void a(boolean z, boolean z2, String str, boolean z3) {
        }

        public final void b(boolean z, String str, boolean z2) {
        }
    }

    static {
        cVO.setTextSize((float) cVN);
        cVQ.setTextSize((float) cVP);
        cVS.setTextSize((float) cVR);
    }

    public static Spannable m(String str, String str2, String str3) {
        Spannable spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(str);
        if (!be.kS(str3)) {
            CharSequence spannableString = new SpannableString(str3);
            spannableString.setSpan(new ForegroundColorSpan(cVM), 0, str3.length(), 33);
            spannableStringBuilder.append(spannableString);
        }
        spannableStringBuilder.append(str2);
        return spannableStringBuilder;
    }

    public static Spannable a(Context context, CharSequence charSequence, String str) {
        List linkedList = new LinkedList();
        linkedList.add(str);
        return a(charSequence, linkedList, null, null);
    }

    public static Spannable a(Context context, CharSequence charSequence, List<String> list) {
        return a(charSequence, (List) list, null, null);
    }

    public static Spannable a(Context context, CharSequence charSequence, List<String> list, String str) {
        return a(charSequence, (List) list, str, null);
    }

    public static String a(String str, List<String> list, String str2, com.tencent.mm.modelsearch.p.h hVar) {
        if (be.kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (str2 == null) {
            str2 = be.b((List) list, SQLiteDatabase.KeyEmpty);
        }
        a b = b((CharSequence) str, str2);
        if (b.isAvailable()) {
            return a(str, b);
        }
        b = a((CharSequence) str, be.b((List) list, SQLiteDatabase.KeyEmpty));
        if (b.isAvailable()) {
            return a(str, b);
        }
        ArrayList a = a((CharSequence) str, (List) list);
        if (a.size() > 0) {
            Iterator it = a.iterator();
            while (it.hasNext()) {
                str = a(str, (a) it.next());
            }
            return str;
        } else if (hVar == null) {
            return str;
        } else {
            try {
                if (hVar.cWy == null || hVar.cWy.length <= 0 || hVar.cWy[0] == null || hVar.cWy[0].size() <= 0) {
                    return str;
                }
                com.tencent.mm.modelsearch.p.h.a aVar = (com.tencent.mm.modelsearch.p.h.a) hVar.cWy[0].get(0);
                a aVar2 = new a();
                aVar2.start = aVar.start;
                aVar2.end = aVar.end;
                if (aVar2.isAvailable()) {
                    return a(str, aVar2);
                }
                return str;
            } catch (Exception e) {
                return str;
            }
        }
    }

    public static Spannable a(CharSequence charSequence, List<String> list, String str, com.tencent.mm.modelsearch.p.h hVar) {
        if (be.D(charSequence)) {
            return new SpannableString(SQLiteDatabase.KeyEmpty);
        }
        Spannable spannableString = new SpannableString(charSequence);
        if (str == null) {
            str = be.b((List) list, SQLiteDatabase.KeyEmpty);
        }
        a b = b(charSequence, str);
        if (b.isAvailable()) {
            a(spannableString, b);
        } else {
            b = a(charSequence, be.b((List) list, SQLiteDatabase.KeyEmpty));
            if (b.isAvailable()) {
                a(spannableString, b);
            } else {
                ArrayList a = a(charSequence, (List) list);
                if (a.size() > 0) {
                    Iterator it = a.iterator();
                    while (it.hasNext()) {
                        a(spannableString, (a) it.next());
                    }
                } else if (hVar != null) {
                    try {
                        if (hVar.cWy != null && hVar.cWy.length > 0 && hVar.cWy[0] != null && hVar.cWy[0].size() > 0) {
                            com.tencent.mm.modelsearch.p.h.a aVar = (com.tencent.mm.modelsearch.p.h.a) hVar.cWy[0].get(0);
                            a aVar2 = new a();
                            aVar2.start = aVar.start;
                            aVar2.end = aVar.end;
                            if (aVar2.isAvailable()) {
                                a(spannableString, aVar2);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return spannableString;
    }

    private static a a(CharSequence charSequence, String str) {
        g.buU();
        String replaceAll = g.dH(charSequence.toString(), SQLiteDatabase.KeyEmpty).replaceAll(" ", SQLiteDatabase.KeyEmpty);
        a c = c(replaceAll.toLowerCase(), str.toLowerCase());
        if (c.isAvailable()) {
            int i = c.start;
            while (i < c.end && i < charSequence.length()) {
                if (charSequence.charAt(i) == ' ') {
                    c.end++;
                }
                i++;
            }
        }
        return c;
    }

    private static a b(CharSequence charSequence, String str) {
        return c(charSequence.toString().toLowerCase(), str.toLowerCase());
    }

    public static String a(String str, List<String> list, boolean z, String str2) {
        if (be.kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        a a = a((CharSequence) str, str2);
        if (a.isAvailable()) {
            return a(str, a);
        }
        Iterator it = a((CharSequence) str, a((CharSequence) str, z), (List) list).iterator();
        while (it.hasNext()) {
            str = a(str, (a) it.next());
        }
        return str;
    }

    public static Spannable a(CharSequence charSequence, List<String> list, boolean z, String str) {
        if (be.D(charSequence)) {
            return new SpannableString(SQLiteDatabase.KeyEmpty);
        }
        Spannable spannableString = new SpannableString(charSequence);
        a a = a(charSequence, str);
        if (a.isAvailable()) {
            a(spannableString, a);
        } else {
            Iterator it = a(charSequence, a(charSequence, z), (List) list).iterator();
            while (it.hasNext()) {
                a(spannableString, (a) it.next());
            }
        }
        return spannableString;
    }

    private static ArrayList<String> a(CharSequence charSequence, boolean z) {
        int i = 0;
        ArrayList<String> arrayList = new ArrayList();
        if (z) {
            for (int i2 = 0; i2 < charSequence.length(); i2++) {
                char charAt = charSequence.charAt(i2);
                if (d(charAt)) {
                    String f = SpellMap.f(charAt);
                    if (f == null || f.length() <= 1) {
                        arrayList.add(String.valueOf(charAt));
                    } else {
                        arrayList.add(f.substring(0, 1).toLowerCase());
                    }
                } else {
                    arrayList.add(String.valueOf(charAt));
                }
            }
        } else {
            while (i < charSequence.length()) {
                char charAt2 = charSequence.charAt(i);
                if (d(charAt2)) {
                    String f2 = SpellMap.f(charSequence.charAt(i));
                    if (be.kS(f2)) {
                        arrayList.add(String.valueOf(charAt2));
                    } else {
                        arrayList.add(f2.toLowerCase());
                    }
                } else {
                    arrayList.add(String.valueOf(charAt2));
                }
                i++;
            }
        }
        return arrayList;
    }

    private static void a(Spannable spannable, a aVar) {
        spannable.setSpan(new ForegroundColorSpan(cVM), aVar.start, aVar.end, 33);
    }

    private static String a(String str, a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.substring(0, aVar.start));
        stringBuffer.append("<em class=\"highlight\">");
        stringBuffer.append(str.substring(aVar.start, aVar.end));
        stringBuffer.append("</em>");
        if (aVar.end < str.length()) {
            stringBuffer.append(str.substring(aVar.end, str.length()));
        }
        return stringBuffer.toString();
    }

    private static ArrayList<a> a(CharSequence charSequence, List<String> list, List<String> list2) {
        List arrayList = new ArrayList();
        for (String str : list2) {
            if (str != null) {
                arrayList.add(a(charSequence, (List) list, str.toLowerCase()));
            }
        }
        return a(charSequence, arrayList);
    }

    private static String a(CharSequence charSequence, List<String> list, String str) {
        int i;
        int i2 = 0;
        int[] iArr = new int[charSequence.length()];
        String str2 = SQLiteDatabase.KeyEmpty;
        for (i = 0; i < list.size(); i++) {
            String str3 = (String) list.get(i);
            iArr[i] = i + -1 >= 0 ? iArr[i - 1] + str3.length() : str3.length();
            str2 = str2 + str3;
        }
        i = str2.indexOf(str);
        if (i < 0) {
            v.w("MicroMsg.FTS.FTSExportLogic", "Not found match sub string, origin %s, pyList %s, pyKeyword %s", charSequence, list, str);
            return SQLiteDatabase.KeyEmpty;
        }
        int length;
        for (length = iArr.length - 1; length >= 0; length--) {
            if (iArr[length] <= i) {
                i2 = length + 1;
                break;
            }
        }
        int i3 = i2 + 1;
        int length2 = str.length();
        for (i = i2; i < list.size(); i++) {
            length2 -= ((String) list.get(i)).length();
            if (length2 <= 0) {
                length = i + 1;
                break;
            }
        }
        length = i3;
        if (length >= charSequence.length()) {
            return charSequence.toString().substring(i2);
        }
        return charSequence.toString().substring(i2, length);
    }

    private static ArrayList<a> a(CharSequence charSequence, List<String> list) {
        CharSequence toLowerCase = charSequence.toString().toLowerCase();
        ArrayList<a> arrayList = new ArrayList();
        for (String toLowerCase2 : list) {
            a c = c(toLowerCase, toLowerCase2.toLowerCase());
            if (c.isAvailable()) {
                arrayList.add(c);
            }
        }
        return arrayList;
    }

    private static a c(CharSequence charSequence, String str) {
        int indexOf = charSequence.toString().indexOf(str);
        a aVar = new a();
        if (indexOf >= 0) {
            aVar.start = indexOf;
            aVar.end = aVar.start + str.length();
        }
        return aVar;
    }

    public static boolean a(CharSequence charSequence, TextView textView) {
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(charSequence);
        textView.setVisibility(0);
        return true;
    }

    public static boolean a(String str, TextView textView) {
        if (str == null || str.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(str);
        textView.setVisibility(0);
        return true;
    }

    public static int jA(String str) {
        String[] strArr = null;
        ak.yW();
        Cursor rawQuery = c.wE().rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[]{str});
        if (rawQuery.moveToFirst()) {
            CharSequence string = rawQuery.getString(0);
            if (string != null) {
                strArr = cVB.split(string);
            }
        }
        rawQuery.close();
        if (strArr == null || strArr.length <= 0) {
            return 0;
        }
        return strArr.length;
    }

    public static Spannable a(Context context, CharSequence charSequence, List<String> list, TextPaint textPaint, float f) {
        if (textPaint.measureText(charSequence.toString().replaceAll("\n", " ")) < f) {
            return a(charSequence, (List) list, null, null);
        }
        ArrayList a = a(charSequence, (List) list);
        if (a.size() == 0) {
            return new SpannableString(charSequence);
        }
        Spannable spannable;
        if (charSequence instanceof SpannableString) {
            spannable = (SpannableString) charSequence;
        } else {
            charSequence = new SpannableString(charSequence);
        }
        Iterator it = a.iterator();
        while (it.hasNext()) {
            a(spannable, (a) it.next());
        }
        a aVar = (a) a.get(0);
        int i = aVar.start;
        int i2 = aVar.end;
        float textSize = f - (textPaint.getTextSize() * 2.0f);
        float measureText = textPaint.measureText("…");
        float measureText2 = textPaint.measureText(spannable, 0, i);
        float measureText3 = textPaint.measureText(spannable, i, i2);
        float measureText4 = textPaint.measureText(spannable, i2, spannable.length());
        if ((measureText2 + measureText3) + measureText4 < textSize) {
            return spannable;
        }
        SpannableStringBuilder spannableStringBuilder;
        if ((measureText2 + measureText3) + measureText < textSize) {
            spannableStringBuilder = new SpannableStringBuilder(spannable, 0, i2);
            spannableStringBuilder.append(TextUtils.ellipsize(spannable.subSequence(i2, spannable.length()), textPaint, (textSize - measureText2) - measureText3, TruncateAt.END));
            return spannableStringBuilder;
        } else if ((measureText + measureText3) + measureText4 < textSize) {
            spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(TextUtils.ellipsize(spannable.subSequence(0, i), textPaint, (textSize - measureText3) - measureText4, TruncateAt.START));
            spannableStringBuilder.append(spannable, i, spannable.length());
            return spannableStringBuilder;
        } else if (measureText + (measureText + measureText3) >= textSize) {
            spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(TextUtils.ellipsize(spannable.subSequence(i, i2), textPaint, textSize, TruncateAt.END));
            return spannableStringBuilder;
        } else {
            spannableStringBuilder = new SpannableStringBuilder();
            textSize = (textSize - measureText3) / 2.0f;
            CharSequence subSequence = spannable.subSequence(0, i);
            CharSequence subSequence2 = spannable.subSequence(i2, spannable.length());
            spannableStringBuilder.append(TextUtils.ellipsize(subSequence, textPaint, textSize, TruncateAt.START));
            spannableStringBuilder.append(spannable, i, i2);
            spannableStringBuilder.append(TextUtils.ellipsize(subSequence2, textPaint, textSize, TruncateAt.END));
            return spannableStringBuilder;
        }
    }

    public static void a(SpannableString spannableString, int i, int i2) {
        if (i2 > spannableString.length()) {
            i2 = spannableString.length();
        }
        if (i < i2) {
            if (i < 0) {
                i = 0;
            }
            spannableString.setSpan(new ForegroundColorSpan(cVM), i, i2, 33);
        }
    }

    public static void a(SpannableString spannableString, String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(16);
        String toLowerCase = str.toLowerCase();
        String substring = spannableString.toString().substring(0);
        StringBuilder stringBuilder2 = stringBuilder;
        for (int i = 0; i < substring.length(); i++) {
            stringBuilder2.setLength(0);
            StringBuilder stringBuilder3 = stringBuilder2;
            int i2 = i;
            while (i2 < substring.length()) {
                String f = SpellMap.f(substring.charAt(i2));
                if (f == null || f.length() == 0) {
                    break;
                }
                if (z) {
                    stringBuilder3 = stringBuilder3.append(Character.toLowerCase(f.charAt(0)));
                } else {
                    stringBuilder3 = stringBuilder3.append(f.toLowerCase());
                }
                if (stringBuilder3.length() < toLowerCase.length()) {
                    i2++;
                } else if (stringBuilder3.toString().startsWith(toLowerCase)) {
                    a(spannableString, i + 0, (i2 + 1) + 0);
                    return;
                } else {
                    stringBuilder2 = stringBuilder3;
                }
            }
            stringBuilder2 = stringBuilder3;
        }
    }

    public static boolean b(CharSequence charSequence, TextView textView) {
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(charSequence, BufferType.SPANNABLE);
        textView.setVisibility(0);
        return true;
    }

    public static boolean b(String str, TextView textView) {
        if (str == null || str.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(str);
        textView.setVisibility(0);
        return true;
    }

    public static int fV(int i) {
        switch (i) {
            case -13:
                return 2131236730;
            case -11:
                return 2131234822;
            case -10:
                return 2131234826;
            case -9:
                return 2131234820;
            case -8:
                return 2131234828;
            case -7:
                return 2131234818;
            case -6:
                return 2131234817;
            case -5:
                return 2131234819;
            case -4:
                return 2131234813;
            case -3:
                return 2131234812;
            case -2:
                return 2131234821;
            case -1:
                return 2131234816;
            default:
                return -1;
        }
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i) {
        a(context, imageView, str, str2, i, true, 0, 0);
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i, int i2, int i3) {
        a(context, imageView, str, str2, i, false, i2, i3);
    }

    private static void a(Context context, ImageView imageView, String str, String str2, int i, boolean z, int i2, int i3) {
        e.bIM().a(imageView, str, str2, z, i2, i3);
        if (!be.kS(str) || !be.kS(str2)) {
            Bitmap a = e.bIM().a(str, str2, z, i2, i3);
            if (a == null || a.isRecycled()) {
                if (i > 0) {
                    imageView.setImageResource(i);
                } else {
                    imageView.setImageResource(2131690078);
                }
                e.bIM().a(context, imageView, str, str2, z, i2, i3);
            } else {
                v.v("MicroMsg.SearchDataItemLogic", "Bitmap size = %d * %d", Integer.valueOf(a.getWidth()), Integer.valueOf(a.getHeight()));
                com.tencent.mm.ui.f.d.a.a(context.getResources(), a, imageView);
            }
            imageView.setVisibility(0);
        } else if (i <= 0 || (be.kS(str) && be.kS(str2))) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i);
        }
    }

    public static afv Ig() {
        try {
            ak.yW();
            String str = (String) c.vf().get(67591, null);
            if (str != null) {
                afv com_tencent_mm_protocal_c_afv = new afv();
                String[] split = str.split(",");
                com_tencent_mm_protocal_c_afv.mrA = Integer.valueOf(split[0]).intValue();
                com_tencent_mm_protocal_c_afv.mrD = Integer.valueOf(split[1]).intValue();
                com_tencent_mm_protocal_c_afv.mjN = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                com_tencent_mm_protocal_c_afv.mjM = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                v.i("MicroMsg.FTS.FTSExportLogic", "lbs location is not null, %f, %f", Float.valueOf(com_tencent_mm_protocal_c_afv.mjN), Float.valueOf(com_tencent_mm_protocal_c_afv.mjM));
                return com_tencent_mm_protocal_c_afv;
            }
            v.i("MicroMsg.FTS.FTSExportLogic", "lbs location is null, lbsContent is null!");
            return null;
        } catch (Exception e) {
            v.i("MicroMsg.FTS.FTSExportLogic", "lbs location is null, reason %s", e.getMessage());
            return null;
        }
    }

    public static int Eu() {
        AssetManager assets = aa.getContext().getAssets();
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = assets.open("config.conf");
            properties.load(inputStream);
        } catch (Throwable e) {
            v.a("MicroMsg.FTS.FTSExportLogic", e, e.getMessage(), new Object[0]);
        } finally {
            com.tencent.mm.a.e.c(inputStream);
        }
        return Integer.valueOf(properties.getProperty("version", "1")).intValue();
    }

    public static boolean Ih() {
        return cVT > 1;
    }

    public static int Et() {
        InputStream fileInputStream;
        Throwable e;
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(Ii(), "config.conf"));
            try {
                properties.load(fileInputStream);
                com.tencent.mm.a.e.c(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    v.a("MicroMsg.FTS.FTSExportLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.c(fileInputStream);
                    return Integer.valueOf(properties.getProperty("version", "1")).intValue();
                } catch (Throwable th) {
                    e = th;
                    inputStream = fileInputStream;
                    com.tencent.mm.a.e.c(inputStream);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            v.a("MicroMsg.FTS.FTSExportLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.c(fileInputStream);
            return Integer.valueOf(properties.getProperty("version", "1")).intValue();
        } catch (Throwable th2) {
            e = th2;
            com.tencent.mm.a.e.c(inputStream);
            throw e;
        }
        return Integer.valueOf(properties.getProperty("version", "1")).intValue();
    }

    public static String Ii() {
        if (be.kS(cnh)) {
            cnh = com.tencent.mm.compatible.util.e.cnh.replace("/data/user/0", "/data/data");
        }
        File file = new File(cnh, "fts/res");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static boolean ix(String str) {
        InputStream open;
        try {
            open = aa.getContext().getAssets().open("fts_template.zip");
        } catch (Throwable e) {
            v.a("MicroMsg.FTS.FTSExportLogic", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            open = null;
        }
        if (open == null) {
            v.e("MicroMsg.FTS.FTSExportLogic", "file inputStream not found");
            return false;
        }
        OutputStream fileOutputStream;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable e2) {
            v.a("MicroMsg.FTS.FTSExportLogic", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                a(open, fileOutputStream);
                return true;
            } catch (Throwable e3) {
                v.a("MicroMsg.FTS.FTSExportLogic", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                return false;
            } finally {
                com.tencent.mm.a.e.c(open);
                com.tencent.mm.a.e.a(fileOutputStream);
            }
        } else {
            com.tencent.mm.a.e.c(open);
            return false;
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> a(int r13, boolean r14, int r15) {
        /*
        r12 = 4;
        r11 = 2;
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = 0;
        r1 = 1;
        r6 = new java.util.HashMap;
        r6.<init>();
        r0 = "scene";
        r3 = java.lang.String.valueOf(r13);
        r6.put(r0, r3);
        r0 = "type";
        r3 = java.lang.String.valueOf(r15);
        r6.put(r0, r3);
        r0 = "lang";
        r3 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r3 = com.tencent.mm.sdk.platformtools.u.dJ(r3);
        r6.put(r0, r3);
        r0 = "platform";
        r3 = "android";
        r6.put(r0, r3);
        r0 = "version";
        r3 = cVT;
        r3 = java.lang.String.valueOf(r3);
        r6.put(r0, r3);
        switch(r13) {
            case 3: goto L_0x00fd;
            case 6: goto L_0x01c0;
            case 9: goto L_0x01c0;
            case 11: goto L_0x01f6;
            case 14: goto L_0x0141;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r2;
        r3 = r2;
        r4 = r2;
    L_0x0048:
        r7 = "MicroMsg.FTS.FTSExportLogic";
        r8 = "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b";
        r9 = 6;
        r9 = new java.lang.Object[r9];
        r10 = java.lang.Integer.valueOf(r13);
        r9[r2] = r10;
        r2 = java.lang.Boolean.valueOf(r14);
        r9[r1] = r2;
        r1 = java.lang.Integer.valueOf(r15);
        r9[r11] = r1;
        r1 = 3;
        r2 = java.lang.Boolean.valueOf(r4);
        r9[r1] = r2;
        r1 = java.lang.Boolean.valueOf(r3);
        r9[r12] = r1;
        r1 = 5;
        r2 = java.lang.Boolean.valueOf(r0);
        r9[r1] = r2;
        com.tencent.mm.sdk.platformtools.v.i(r7, r8, r9);
        if (r4 == 0) goto L_0x0085;
    L_0x007c:
        r1 = "isSug";
        r2 = "1";
        r6.put(r1, r2);
    L_0x0085:
        if (r3 == 0) goto L_0x0090;
    L_0x0087:
        r1 = "isLocalSug";
        r2 = "1";
        r6.put(r1, r2);
    L_0x0090:
        if (r0 == 0) goto L_0x009b;
    L_0x0092:
        r0 = "isMostSearchBiz";
        r1 = "1";
        r6.put(r0, r1);
    L_0x009b:
        if (r14 != 0) goto L_0x00a6;
    L_0x009d:
        r0 = "isHomePage";
        r1 = "0";
        r6.put(r0, r1);
    L_0x00a6:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r0 = com.tencent.mm.bd.a.ds(r0);
        r1 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r1 == 0) goto L_0x00cb;
    L_0x00b2:
        r1 = 1063256064; // 0x3f600000 float:0.875 double:5.25318294E-315;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x00cb;
    L_0x00b8:
        r1 = 1066401792; // 0x3f900000 float:1.125 double:5.2687249E-315;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x00cb;
    L_0x00be:
        r1 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x00cb;
    L_0x00c4:
        r1 = 1068498944; // 0x3fb00000 float:1.375 double:5.27908621E-315;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x00cb;
    L_0x00ca:
        r0 = r5;
    L_0x00cb:
        r1 = "fontRatio";
        r0 = java.lang.String.valueOf(r0);
        r6.put(r1, r0);
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r0 = com.tencent.mm.sdk.platformtools.ak.isWifi(r0);
        if (r0 == 0) goto L_0x022c;
    L_0x00df:
        r0 = "netType";
        r1 = "wifi";
        r6.put(r0, r1);
    L_0x00e8:
        r0 = com.tencent.mm.ai.b.HC();
        if (r0 == 0) goto L_0x00fc;
    L_0x00ee:
        r0 = com.tencent.mm.ai.b.HE();
        if (r0 == 0) goto L_0x00fc;
    L_0x00f4:
        r1 = "musicSnsId";
        r0 = r0.mJW;
        r6.put(r1, r0);
    L_0x00fc:
        return r6;
    L_0x00fd:
        if (r14 == 0) goto L_0x010d;
    L_0x00ff:
        r0 = "SGEMix";
        r0 = com.tencent.mm.modelsearch.e.y(r0, r2);
        if (r0 == 0) goto L_0x010d;
    L_0x0108:
        r0 = r2;
        r3 = r2;
        r4 = r1;
        goto L_0x0048;
    L_0x010d:
        if (r15 != r1) goto L_0x011d;
    L_0x010f:
        r0 = "SGEDetailBizContact";
        r0 = com.tencent.mm.modelsearch.e.y(r0, r2);
        if (r0 == 0) goto L_0x011d;
    L_0x0118:
        r0 = r2;
        r3 = r2;
        r4 = r1;
        goto L_0x0048;
    L_0x011d:
        r0 = 16;
        if (r15 != r0) goto L_0x012f;
    L_0x0121:
        r0 = "SGEDetailPOI";
        r0 = com.tencent.mm.modelsearch.e.y(r0, r2);
        if (r0 == 0) goto L_0x012f;
    L_0x012a:
        r0 = r2;
        r3 = r2;
        r4 = r1;
        goto L_0x0048;
    L_0x012f:
        r0 = 8;
        if (r15 != r0) goto L_0x0045;
    L_0x0133:
        r0 = "SGEDetailTimeline";
        r0 = com.tencent.mm.modelsearch.e.y(r0, r2);
        if (r0 == 0) goto L_0x0045;
    L_0x013c:
        r0 = r2;
        r3 = r2;
        r4 = r1;
        goto L_0x0048;
    L_0x0141:
        if (r15 != r1) goto L_0x0289;
    L_0x0143:
        r0 = "SGETabBizContact";
        r0 = com.tencent.mm.modelsearch.e.y(r0, r2);
        if (r0 == 0) goto L_0x0289;
    L_0x014c:
        r0 = r1;
    L_0x014d:
        if (r15 != r11) goto L_0x0286;
    L_0x014f:
        r3 = "SGETabArticle";
        r3 = com.tencent.mm.modelsearch.e.y(r3, r1);
        if (r3 == 0) goto L_0x0159;
    L_0x0158:
        r0 = r1;
    L_0x0159:
        r3 = "SGETabArticleLocal";
        r3 = com.tencent.mm.modelsearch.e.y(r3, r1);
        if (r3 == 0) goto L_0x0286;
    L_0x0162:
        r3 = r1;
    L_0x0163:
        r4 = 8;
        if (r15 != r4) goto L_0x0283;
    L_0x0167:
        r4 = "SGETabTimeline";
        r4 = com.tencent.mm.modelsearch.e.y(r4, r1);
        if (r4 == 0) goto L_0x0171;
    L_0x0170:
        r0 = r1;
    L_0x0171:
        r4 = "SGETabTimelineLocal";
        r4 = com.tencent.mm.modelsearch.e.y(r4, r1);
        if (r4 == 0) goto L_0x0283;
    L_0x017a:
        r3 = r1;
        r4 = r0;
    L_0x017c:
        if (r14 != 0) goto L_0x018a;
    L_0x017e:
        if (r15 != r12) goto L_0x018a;
    L_0x0180:
        r0 = "SGETabDetailBizService";
        r0 = com.tencent.mm.modelsearch.e.y(r0, r2);
        if (r0 == 0) goto L_0x018a;
    L_0x0189:
        r4 = r1;
    L_0x018a:
        if (r15 != r1) goto L_0x0280;
    L_0x018c:
        r0 = "MSBizContactEntry";
        r7 = com.tencent.mm.model.ak.uz();
        if (r7 == 0) goto L_0x01be;
    L_0x0195:
        r7 = com.tencent.mm.model.c.c.Au();
        r8 = "100086";
        r7 = r7.Ls(r8);
        r8 = r7.isValid();
        if (r8 == 0) goto L_0x01be;
    L_0x01a6:
        r7 = r7.buX();
        r0 = r7.get(r0);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r2);
        if (r0 <= 0) goto L_0x01bc;
    L_0x01b6:
        r0 = r1;
    L_0x01b7:
        if (r0 == 0) goto L_0x0280;
    L_0x01b9:
        r0 = r1;
        goto L_0x0048;
    L_0x01bc:
        r0 = r2;
        goto L_0x01b7;
    L_0x01be:
        r0 = r2;
        goto L_0x01b7;
    L_0x01c0:
        r0 = "SBCSuggest";
        r3 = com.tencent.mm.model.ak.uz();
        if (r3 == 0) goto L_0x01f4;
    L_0x01c9:
        r3 = com.tencent.mm.model.c.c.Au();
        r4 = "100062";
        r3 = r3.Ls(r4);
        r4 = r3.isValid();
        if (r4 == 0) goto L_0x01f4;
    L_0x01da:
        r3 = r3.buX();
        r0 = r3.get(r0);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r2);
        if (r0 <= 0) goto L_0x01f2;
    L_0x01ea:
        r0 = r1;
    L_0x01eb:
        if (r0 == 0) goto L_0x0045;
    L_0x01ed:
        r0 = r2;
        r3 = r2;
        r4 = r1;
        goto L_0x0048;
    L_0x01f2:
        r0 = r2;
        goto L_0x01eb;
    L_0x01f4:
        r0 = r2;
        goto L_0x01eb;
    L_0x01f6:
        r0 = "SBASuggest";
        r3 = com.tencent.mm.model.ak.uz();
        if (r3 == 0) goto L_0x022a;
    L_0x01ff:
        r3 = com.tencent.mm.model.c.c.Au();
        r4 = "100063";
        r3 = r3.Ls(r4);
        r4 = r3.isValid();
        if (r4 == 0) goto L_0x022a;
    L_0x0210:
        r3 = r3.buX();
        r0 = r3.get(r0);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r2);
        if (r0 <= 0) goto L_0x0228;
    L_0x0220:
        r0 = r1;
    L_0x0221:
        if (r0 == 0) goto L_0x0045;
    L_0x0223:
        r0 = r2;
        r3 = r2;
        r4 = r1;
        goto L_0x0048;
    L_0x0228:
        r0 = r2;
        goto L_0x0221;
    L_0x022a:
        r0 = r2;
        goto L_0x0221;
    L_0x022c:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r0 = com.tencent.mm.sdk.platformtools.ak.is4G(r0);
        if (r0 == 0) goto L_0x0241;
    L_0x0236:
        r0 = "netType";
        r1 = "4g";
        r6.put(r0, r1);
        goto L_0x00e8;
    L_0x0241:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r0 = com.tencent.mm.sdk.platformtools.ak.is3G(r0);
        if (r0 == 0) goto L_0x0256;
    L_0x024b:
        r0 = "netType";
        r1 = "3g";
        r6.put(r0, r1);
        goto L_0x00e8;
    L_0x0256:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r0 = com.tencent.mm.sdk.platformtools.ak.is2G(r0);
        if (r0 == 0) goto L_0x026b;
    L_0x0260:
        r0 = "netType";
        r1 = "2g";
        r6.put(r0, r1);
        goto L_0x00e8;
    L_0x026b:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r0 = com.tencent.mm.sdk.platformtools.ak.isConnected(r0);
        if (r0 != 0) goto L_0x00e8;
    L_0x0275:
        r0 = "netType";
        r1 = "fail";
        r6.put(r0, r1);
        goto L_0x00e8;
    L_0x0280:
        r0 = r2;
        goto L_0x0048;
    L_0x0283:
        r4 = r0;
        goto L_0x017c;
    L_0x0286:
        r3 = r2;
        goto L_0x0163;
    L_0x0289:
        r0 = r2;
        goto L_0x014d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelsearch.h.a(int, boolean, int):java.util.Map<java.lang.String, java.lang.String>");
    }

    public static String l(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(Ii());
        if (map.size() > 0) {
            stringBuffer.append("/app.html?");
            for (Entry entry : map.entrySet()) {
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append((String) entry.getValue());
                stringBuffer.append("&");
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1);
        }
        stringBuffer.append("/app.html");
        return stringBuffer.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.CharSequence a(android.content.Context r9, java.util.List<com.tencent.mm.modelsearch.p.i> r10, java.lang.String[] r11, java.util.List<java.lang.String> r12, int r13, java.lang.String r14) {
        /*
        r2 = 0;
        r8 = 1;
        r0 = new com.tencent.mm.modelsearch.h$1;
        r0.<init>();
        java.util.Arrays.sort(r11, r0);
        r3 = new android.text.SpannableStringBuilder;
        r3.<init>();
        r1 = r2;
    L_0x0010:
        r0 = r10.size();
        if (r1 >= r0) goto L_0x008a;
    L_0x0016:
        r0 = r10.get(r1);
        r0 = (com.tencent.mm.modelsearch.p.i) r0;
        r4 = r0.cWG;
        r5 = r11.length;
        if (r4 >= r5) goto L_0x0059;
    L_0x0021:
        r4 = r0.cWG;
        r4 = r11[r4];
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r5 != 0) goto L_0x0059;
    L_0x002b:
        com.tencent.mm.model.ak.yW();
        r5 = com.tencent.mm.model.c.wH();
        r4 = r5.LX(r4);
        if (r4 == 0) goto L_0x0059;
    L_0x0038:
        r5 = r4.field_username;
        r6 = com.tencent.mm.model.l.a(r4, r5);
        r7 = r0.cWt;
        switch(r7) {
            case 29: goto L_0x0079;
            case 30: goto L_0x0077;
            case 31: goto L_0x0075;
            case 32: goto L_0x0083;
            case 33: goto L_0x007c;
            case 34: goto L_0x006e;
            case 35: goto L_0x006c;
            case 36: goto L_0x006a;
            case 37: goto L_0x005d;
            default: goto L_0x0043;
        };
    L_0x0043:
        r4 = r0.cWI;
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r4 != 0) goto L_0x0059;
    L_0x004b:
        r4 = r0.cWI;
        r4 = r4.contains(r14);
        if (r4 == 0) goto L_0x0059;
    L_0x0053:
        r4 = r0.cWz;
        r4 = r4 + 10;
        r0.cWz = r4;
    L_0x0059:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0010;
    L_0x005d:
        r4 = r4.pD();
        r4 = Y(r5, r4);
        r0.cWI = r4;
        r0.cWJ = r6;
        goto L_0x0043;
    L_0x006a:
        r0.cWL = r8;
    L_0x006c:
        r0.cWK = r8;
    L_0x006e:
        r4 = r4.field_nickname;
        r0.cWI = r4;
        r0.cWJ = r6;
        goto L_0x0043;
    L_0x0075:
        r0.cWL = r8;
    L_0x0077:
        r0.cWK = r8;
    L_0x0079:
        r0.cWI = r6;
        goto L_0x0043;
    L_0x007c:
        r4 = r0.content;
        r0.cWI = r4;
        r0.cWJ = r6;
        goto L_0x0043;
    L_0x0083:
        r4 = r4.bCt;
        r0.cWI = r4;
        r0.cWJ = r6;
        goto L_0x0043;
    L_0x008a:
        r0 = new com.tencent.mm.modelsearch.h$2;
        r0.<init>();
        java.util.Collections.sort(r10, r0);
    L_0x0092:
        r0 = r10.size();
        if (r2 >= r0) goto L_0x00ef;
    L_0x0098:
        r0 = r12.size();
        if (r2 >= r0) goto L_0x00ef;
    L_0x009e:
        r0 = r10.get(r2);
        r0 = (com.tencent.mm.modelsearch.p.i) r0;
        r1 = r0.cWI;
        r1 = com.tencent.mm.pluginsdk.ui.d.e.a(r9, r1, r13);
        r4 = r0.cWK;
        if (r4 == 0) goto L_0x00ce;
    L_0x00ae:
        r4 = r0.cWL;
        r1 = a(r1, r12, r4, r14);
    L_0x00b4:
        r4 = r3.length();
        if (r4 <= 0) goto L_0x00c0;
    L_0x00ba:
        r4 = ", ";
        r3.append(r4);
    L_0x00c0:
        r4 = r0.cWJ;
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r4 == 0) goto L_0x00d4;
    L_0x00c8:
        r3.append(r1);
    L_0x00cb:
        r2 = r2 + 1;
        goto L_0x0092;
    L_0x00ce:
        r4 = 0;
        r1 = a(r1, r12, r14, r4);
        goto L_0x00b4;
    L_0x00d4:
        r0 = r0.cWJ;
        r0 = com.tencent.mm.pluginsdk.ui.d.e.a(r9, r0, r13);
        r0 = r3.append(r0);
        r4 = 40;
        r0 = r0.append(r4);
        r0 = r0.append(r1);
        r1 = ")";
        r0.append(r1);
        goto L_0x00cb;
    L_0x00ef:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelsearch.h.a(android.content.Context, java.util.List, java.lang.String[], java.util.List, int, java.lang.String):java.lang.CharSequence");
    }

    private static String Y(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            return str2;
        }
        for (String startsWith : cVU) {
            if (str.startsWith(startsWith)) {
                return null;
            }
        }
        if (str.indexOf(64) >= 0) {
            return null;
        }
        return str;
    }

    public static Intent Ij() {
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
        intent.putExtra("neverGetA8Key", true);
        return intent;
    }

    private static boolean d(char c) {
        return c >= '一' && c <= '龥';
    }

    public static String jB(String str) {
        if (str == null) {
            return null;
        }
        String toLowerCase = str.toLowerCase();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < toLowerCase.length(); i++) {
            char charAt = toLowerCase.charAt(i);
            if (d(charAt)) {
                String f = SpellMap.f(charAt);
                if (f == null || f.length() <= 1) {
                    stringBuffer.append(charAt);
                } else {
                    stringBuffer.append(f);
                }
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String jC(String str) {
        if (str == null) {
            return null;
        }
        String toLowerCase = str.toLowerCase();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < toLowerCase.length(); i++) {
            char charAt = toLowerCase.charAt(i);
            if (d(charAt)) {
                String f = SpellMap.f(charAt);
                if (f == null || f.length() <= 1) {
                    stringBuffer.append(charAt);
                } else {
                    stringBuffer.append(f.charAt(0));
                }
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean jD(String str) {
        if (str != null && str.length() < 20 && str.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }

    public static boolean jE(String str) {
        if (str != null && str.length() < 20 && str.matches("^[A-Za-z0-9\\-_]+$")) {
            return true;
        }
        return false;
    }
}
