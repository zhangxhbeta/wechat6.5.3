package com.tencent.mm.bf;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.s;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

public final class f {
    private static volatile f nnA = null;
    static Pattern nnL;
    private static final Comparator<a> nnM = new Comparator<a>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar == null && aVar2 == null) {
                return 0;
            }
            if (aVar == null || be.kS(aVar.text)) {
                return 1;
            }
            return (aVar2 == null || be.kS(aVar2.text)) ? -1 : aVar.text.compareTo(aVar2.text);
        }
    };
    String[] nnB = null;
    String[] nnC = null;
    String[] nnD = null;
    String[] nnE = null;
    String[] nnF = null;
    String[] nnG = null;
    ArrayList<s> nnH;
    private a[] nnI = null;
    private HashMap<String, s> nnJ = new HashMap();
    private SparseArray<String> nnK = new SparseArray();

    static class a {
        public String name;
        public int pos;
        public String text;

        a() {
        }

        a(int i, String str, String str2) {
            this.pos = i;
            this.text = str;
            this.name = str2;
        }
    }

    private f(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        this.nnB = context.getResources().getStringArray(2131296289);
        this.nnC = context.getResources().getStringArray(2131296292);
        this.nnD = context.getResources().getStringArray(2131296290);
        this.nnE = context.getResources().getStringArray(2131296294);
        this.nnF = context.getResources().getStringArray(2131296291);
        this.nnG = context.getResources().getStringArray(2131296293);
        buS();
        v.d("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static f buR() {
        if (nnA == null) {
            synchronized (f.class) {
                if (nnA == null) {
                    nnA = new f(aa.getContext());
                }
            }
        }
        return nnA;
    }

    private synchronized int buS() {
        int i = 0;
        synchronized (this) {
            if (this.nnB == null || this.nnD == null || this.nnB.length != this.nnD.length) {
                v.i("MicroMsg.QQSmileyManager", "read smiley array failed.");
                if (this.nnH != null) {
                    this.nnI = new a[this.nnH.size()];
                }
            } else {
                int length = this.nnB.length;
                if (this.nnH != null) {
                    this.nnI = new a[((this.nnH.size() + length) * 6)];
                } else {
                    this.nnI = new a[(length * 6)];
                }
                int i2 = 0;
                while (i2 < length) {
                    String str = this.nnB[i2];
                    String str2 = this.nnD[i2];
                    String str3 = (this.nnC == null || this.nnC.length <= i2) ? SQLiteDatabase.KeyEmpty : this.nnC[i2];
                    String str4 = (this.nnE == null || this.nnE.length <= i2) ? SQLiteDatabase.KeyEmpty : this.nnE[i2];
                    String str5 = (this.nnF == null || this.nnF.length <= i2) ? SQLiteDatabase.KeyEmpty : this.nnF[i2];
                    String str6 = (this.nnG == null || this.nnG.length <= i2) ? SQLiteDatabase.KeyEmpty : this.nnG[i2];
                    s sVar = new s(str, str3, str2, str4, str5, str6, i2);
                    this.nnI[(i2 * 6) + 0] = new a(i2, str, SQLiteDatabase.KeyEmpty);
                    this.nnI[(i2 * 6) + 1] = new a(i2, str2, SQLiteDatabase.KeyEmpty);
                    this.nnI[(i2 * 6) + 2] = new a(i2, str3, SQLiteDatabase.KeyEmpty);
                    this.nnI[(i2 * 6) + 3] = new a(i2, str4, SQLiteDatabase.KeyEmpty);
                    this.nnI[(i2 * 6) + 4] = new a(i2, str5, SQLiteDatabase.KeyEmpty);
                    this.nnI[(i2 * 6) + 5] = new a(i2, str6, SQLiteDatabase.KeyEmpty);
                    this.nnJ.put(str, sVar);
                    this.nnK.put(sVar.field_eggIndex, sVar.field_key);
                    i2++;
                }
                i = length;
            }
            if (this.nnH == null || this.nnH.isEmpty()) {
                Arrays.sort(this.nnI, nnM);
            }
        }
        return i;
    }

    public final void buT() {
        long currentTimeMillis = System.currentTimeMillis();
        this.nnJ.clear();
        this.nnK.clear();
        this.nnH = com.tencent.mm.pluginsdk.j.a.bmr().afb();
        int buS = buS();
        if (!(this.nnH == null || this.nnH.isEmpty())) {
            Iterator it = this.nnH.iterator();
            int i = buS;
            while (it.hasNext()) {
                s sVar = (s) it.next();
                this.nnJ.put(sVar.field_key, sVar);
                this.nnK.put(sVar.field_eggIndex, sVar.field_key);
                this.nnI[(i * 6) + 0] = new a(-1, sVar.field_key, sVar.field_fileName);
                if (be.kS(sVar.field_cnValue) || "null".equalsIgnoreCase(sVar.field_cnValue)) {
                    this.nnI[(i * 6) + 1] = new a(-1, sVar.field_key, sVar.field_fileName);
                } else {
                    this.nnI[(i * 6) + 1] = new a(-1, sVar.field_cnValue, sVar.field_fileName);
                }
                if (be.kS(sVar.field_qqValue) || "null".equalsIgnoreCase(sVar.field_qqValue)) {
                    this.nnI[(i * 6) + 2] = new a(-1, sVar.field_key, sVar.field_fileName);
                } else {
                    this.nnI[(i * 6) + 2] = new a(-1, sVar.field_qqValue, sVar.field_fileName);
                }
                if (be.kS(sVar.field_twValue) || "null".equalsIgnoreCase(sVar.field_twValue)) {
                    this.nnI[(i * 6) + 3] = new a(-1, sVar.field_key, sVar.field_fileName);
                } else {
                    this.nnI[(i * 6) + 3] = new a(-1, sVar.field_twValue, sVar.field_fileName);
                }
                if (be.kS(sVar.field_enValue) || "null".equalsIgnoreCase(sVar.field_enValue)) {
                    this.nnI[(i * 6) + 4] = new a(-1, sVar.field_key, sVar.field_fileName);
                } else {
                    this.nnI[(i * 6) + 4] = new a(-1, sVar.field_enValue, sVar.field_fileName);
                }
                if (be.kS(sVar.field_thValue) || "null".equalsIgnoreCase(sVar.field_thValue)) {
                    this.nnI[(i * 6) + 5] = new a(-1, sVar.field_key, sVar.field_fileName);
                } else {
                    this.nnI[(i * 6) + 5] = new a(-1, sVar.field_thValue, sVar.field_fileName);
                }
                i++;
            }
        }
        Arrays.sort(this.nnI, nnM);
        v.d("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final a Ll(String str) {
        a[] aVarArr = buR().nnI;
        int binarySearch = Arrays.binarySearch(this.nnI, new a(0, str, SQLiteDatabase.KeyEmpty), nnM);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        if (binarySearch < 0 || !str.startsWith(this.nnI[binarySearch].text)) {
            return null;
        }
        return aVarArr[binarySearch];
    }

    public final SpannableString b(SpannableString spannableString, int i, int i2) {
        if (spannableString != null && spannableString.length() != 0) {
            String spannableString2 = spannableString.toString();
            int i3 = 0;
            int i4 = -1;
            while (true) {
                i4 = spannableString2.indexOf(47, i4 + 1);
                if (i4 != -1) {
                    if (i4 < spannableString2.length() - 1) {
                        if (i3 >= i2) {
                            break;
                        } else if (a(i4, spannableString, i)) {
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            }
            while (true) {
                i4 = spannableString2.indexOf(91, i4 + 1);
                if (i4 != -1) {
                    if (i4 < spannableString2.length() - 1) {
                        if (i3 >= i2) {
                            break;
                        } else if (a(i4, spannableString, i)) {
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return spannableString;
    }

    private boolean a(int i, SpannableString spannableString, int i2) {
        a Ll = Ll(spannableString.subSequence(i, spannableString.length()));
        if (Ll == null) {
            return false;
        }
        int i3 = Ll.pos;
        Drawable hH = i3 >= 0 ? b.buL().hH(i3) : Lm(Ll.name);
        if (hH == null || i > spannableString.length() || Ll.text.length() + i > spannableString.length()) {
            v.i("MicroMsg.QQSmileyManager", "spanQQSmileyIcon failed. drawable not found. smiley:%s", Ll.toString());
            return false;
        }
        b.buL().a(spannableString, hH, i, i + Ll.text.length(), i2);
        return true;
    }

    static Drawable Lm(String str) {
        Throwable e;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(com.tencent.mm.z.a.Es() + "/" + str);
            try {
                Options options = new Options();
                options.inPreferredConfig = Config.RGB_565;
                Drawable bitmapDrawable = new BitmapDrawable(aa.getContext().getResources(), BitmapFactory.decodeStream(fileInputStream, null, options));
                try {
                    fileInputStream.close();
                    return bitmapDrawable;
                } catch (Throwable e2) {
                    v.i("MicroMsg.QQSmileyManager", be.e(e2));
                    return bitmapDrawable;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    v.i("MicroMsg.QQSmileyManager", be.e(e));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e4) {
                            v.i("MicroMsg.QQSmileyManager", be.e(e4));
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e4 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e22) {
                            v.i("MicroMsg.QQSmileyManager", be.e(e22));
                        }
                    }
                    throw e4;
                }
            }
        } catch (FileNotFoundException e5) {
            e4 = e5;
            fileInputStream = null;
            v.i("MicroMsg.QQSmileyManager", be.e(e4));
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th2) {
            e4 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e4;
        }
    }

    public final s Ln(String str) {
        if (this.nnJ == null || !this.nnJ.containsKey(str)) {
            return null;
        }
        return (s) this.nnJ.get(str);
    }
}
