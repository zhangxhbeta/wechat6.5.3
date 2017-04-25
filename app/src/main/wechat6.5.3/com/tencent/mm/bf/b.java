package com.tencent.mm.bf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class b {
    public static final String nmU = (e.cnf + "app_font");
    public static final String nmV = (nmU + File.separator + "color_emoji");
    private static final boolean nmW = (VERSION.SDK_INT < 19);
    private static b nmX;
    private LinkedList<c> dVF;
    private Context mContext = aa.getContext();
    private int nmY = 0;
    private int nmZ;
    private int nna;
    private int nnb;
    public long nnc = 0;
    private a nnd = new a();
    private SparseArray<c> nne = new SparseArray();
    public SparseArray<c> nnf = new SparseArray();
    private SparseArray<c> nng = new SparseArray();
    private SparseArray<SparseArray<c>> nnh = new SparseArray();
    private SparseArray<String> nni = null;
    private x<Integer, Bitmap> nnj = new x(200);
    private boolean nnk = false;
    private LinkedList<d> nnl;

    private class a {
        int end;
        c nnm;
        boolean nnn = false;
        final /* synthetic */ b nno;
        int start;

        public a(b bVar, c cVar, int i, int i2, boolean z) {
            this.nno = bVar;
            this.nnm = cVar;
            this.start = i;
            this.end = i2;
            this.nnn = z;
        }
    }

    private b() {
        if (com.tencent.mm.a.e.aR(nmV)) {
            v.i("MicroMsg.EmojiHelper", "emoji color file exist.");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            buM();
            j.y(this.mContext, "color_emoji", nmV);
            v.d("MicroMsg.EmojiHelper", "copyColorEmojiFile. use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        init();
        if (com.tencent.mm.bd.a.dt(this.mContext)) {
            this.nmY = com.tencent.mm.bd.a.fromDPToPix(this.mContext, 4);
        } else {
            this.nmY = com.tencent.mm.bd.a.fromDPToPix(this.mContext, 2);
        }
    }

    public static b buL() {
        if (nmX == null) {
            synchronized (b.class) {
                nmX = new b();
            }
        }
        return nmX;
    }

    public static void buM() {
        File file = new File(nmU);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final void init() {
        InputStream fileInputStream;
        DataInputStream dataInputStream;
        Throwable e;
        InputStream inputStream = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            fileInputStream = new FileInputStream(new File(nmV));
            try {
                dataInputStream = new DataInputStream(fileInputStream);
                try {
                    this.nnb = dataInputStream.readInt();
                    this.nnc = dataInputStream.readLong();
                    this.nmZ = dataInputStream.readInt();
                    this.nna = ((this.nmZ + 4) + 8) + 4;
                    byte[] bArr = new byte[this.nmZ];
                    dataInputStream.read(bArr);
                    this.nnd.az(bArr);
                    buN();
                    this.nnk = true;
                    v.i("MicroMsg.EmojiHelper", "init time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    try {
                        dataInputStream.close();
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        v.a("MicroMsg.EmojiHelper", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    inputStream = fileInputStream;
                    try {
                        v.a("MicroMsg.EmojiHelper", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable e22) {
                                v.a("MicroMsg.EmojiHelper", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                                return;
                            }
                        }
                        if (inputStream == null) {
                            inputStream.close();
                        }
                    } catch (Throwable th) {
                        e22 = th;
                        fileInputStream = inputStream;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable e4) {
                                v.a("MicroMsg.EmojiHelper", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                                throw e22;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw e22;
                    }
                } catch (Throwable th2) {
                    e22 = th2;
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e22;
                }
            } catch (IOException e5) {
                e22 = e5;
                dataInputStream = null;
                inputStream = fileInputStream;
                v.a("MicroMsg.EmojiHelper", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (inputStream == null) {
                    inputStream.close();
                }
            } catch (Throwable th3) {
                e22 = th3;
                dataInputStream = null;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e22;
            }
        } catch (IOException e6) {
            e22 = e6;
            dataInputStream = null;
            v.a("MicroMsg.EmojiHelper", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (inputStream == null) {
                inputStream.close();
            }
        } catch (Throwable th4) {
            e22 = th4;
            dataInputStream = null;
            fileInputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e22;
        }
    }

    public static long Lh(String str) {
        Throwable e;
        InputStream inputStream;
        DataInputStream dataInputStream = null;
        InputStream fileInputStream;
        try {
            DataInputStream dataInputStream2;
            fileInputStream = new FileInputStream(new File(str));
            try {
                dataInputStream2 = new DataInputStream(fileInputStream);
            } catch (IOException e2) {
                e = e2;
                inputStream = fileInputStream;
                try {
                    v.a("MicroMsg.EmojiHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e3) {
                            v.a("MicroMsg.EmojiHelper", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                            return 0;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    e3 = th;
                    fileInputStream = inputStream;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.EmojiHelper", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                            throw e3;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e3;
                }
            } catch (Throwable th2) {
                e3 = th2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
            try {
                dataInputStream2.readInt();
                long readLong = dataInputStream2.readLong();
                try {
                    dataInputStream2.close();
                    fileInputStream.close();
                    return readLong;
                } catch (Throwable e5) {
                    v.a("MicroMsg.EmojiHelper", e5, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return readLong;
                }
            } catch (IOException e6) {
                e3 = e6;
                dataInputStream = dataInputStream2;
                inputStream = fileInputStream;
                v.a("MicroMsg.EmojiHelper", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return 0;
            } catch (Throwable th3) {
                e3 = th3;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
        } catch (IOException e7) {
            e3 = e7;
            inputStream = null;
            v.a("MicroMsg.EmojiHelper", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return 0;
        } catch (Throwable th4) {
            e3 = th4;
            fileInputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e3;
        }
    }

    public static int Li(String str) {
        DataInputStream dataInputStream;
        Throwable e;
        InputStream inputStream;
        DataInputStream dataInputStream2 = null;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                dataInputStream = new DataInputStream(fileInputStream);
            } catch (IOException e2) {
                e = e2;
                dataInputStream = null;
                inputStream = fileInputStream;
                try {
                    v.a("MicroMsg.EmojiHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e3) {
                            v.a("MicroMsg.EmojiHelper", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                            return 0;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    e3 = th;
                    fileInputStream = inputStream;
                    dataInputStream2 = dataInputStream;
                    if (dataInputStream2 != null) {
                        try {
                            dataInputStream2.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.EmojiHelper", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                            throw e3;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e3;
                }
            } catch (Throwable th2) {
                e3 = th2;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
            try {
                int readInt = dataInputStream.readInt();
                try {
                    dataInputStream.close();
                    fileInputStream.close();
                    return readInt;
                } catch (Throwable e42) {
                    v.a("MicroMsg.EmojiHelper", e42, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return readInt;
                }
            } catch (IOException e5) {
                e3 = e5;
                inputStream = fileInputStream;
                v.a("MicroMsg.EmojiHelper", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return 0;
            } catch (Throwable th3) {
                e3 = th3;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
        } catch (IOException e6) {
            e3 = e6;
            dataInputStream = null;
            v.a("MicroMsg.EmojiHelper", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return 0;
        } catch (Throwable th4) {
            e3 = th4;
            fileInputStream = null;
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e3;
        }
    }

    public final SpannableString a(SpannableString spannableString, int i, PInt pInt) {
        if (spannableString == null || spannableString.length() == 0) {
            return spannableString;
        }
        String spannableString2 = spannableString.toString();
        ArrayList arrayList = new ArrayList();
        int length = spannableString2.length();
        int charCount;
        for (int i2 = 0; i2 < length; i2 = charCount) {
            int codePointAt;
            int codePointAt2 = spannableString2.codePointAt(i2);
            charCount = i2 + Character.charCount(codePointAt2);
            if (charCount < length) {
                codePointAt = spannableString2.codePointAt(charCount);
            } else {
                codePointAt = 0;
            }
            c vb = buL().vb(codePointAt2);
            if (vb != null) {
                arrayList.add(new a(this, vb, i2, i2 + 1, true));
            } else {
                vb = buL().cY(codePointAt2, codePointAt);
                if (vb != null) {
                    int charCount2;
                    if (vb.nnq != 0 || (127995 <= codePointAt && codePointAt <= 127999)) {
                        charCount2 = charCount + Character.charCount(codePointAt);
                    } else {
                        charCount2 = charCount;
                    }
                    arrayList.add(new a(this, vb, i2, charCount2, false));
                    charCount = charCount2;
                }
            }
            if (arrayList.size() >= pInt.value) {
                break;
            }
        }
        if (arrayList.size() == 0) {
            return spannableString;
        }
        a aVar;
        Spannable spannableString3;
        if (nmW) {
            StringBuilder stringBuilder = new StringBuilder(spannableString2);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (!aVar.nnn) {
                    if (aVar.nnm.nnr == 0 || aVar.end - aVar.start != 1) {
                        stringBuilder.replace(aVar.start, aVar.end, "....".substring(0, aVar.end - aVar.start));
                    } else {
                        stringBuilder.replace(aVar.start, aVar.end, String.valueOf((char) aVar.nnm.nnr));
                    }
                }
            }
            spannableString3 = new SpannableString(stringBuilder.toString());
        } else {
            CharSequence charSequence = spannableString;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            aVar = (a) it2.next();
            a(spannableString3, buL().a(aVar.nnm), aVar.start, aVar.end, i);
        }
        pInt.value -= arrayList.size();
        return spannableString3;
    }

    public static boolean Lj(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = str.toString();
        int length = str2.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str2.codePointAt(i);
            int charCount = Character.charCount(codePointAt) + i;
            if (charCount < length) {
                i = str2.codePointAt(charCount);
            } else {
                i = 0;
            }
            if (buL().vb(codePointAt) != null) {
                return true;
            }
            if (buL().cY(codePointAt, i) != null) {
                return true;
            }
            i = charCount;
        }
        return false;
    }

    public final String Lk(String str) {
        if (be.kS(str)) {
            return str;
        }
        int i;
        if (this.nni == null) {
            Context context = aa.getContext();
            String d = u.d(context.getSharedPreferences(aa.bti(), 0));
            String[] stringArray = d.equals("zh_CN") ? context.getResources().getStringArray(2131296276) : (d.equals("zh_TW") || d.equals("zh_HK")) ? context.getResources().getStringArray(2131296278) : context.getResources().getStringArray(2131296277);
            String[] stringArray2 = context.getResources().getStringArray(2131296275);
            this.nni = new SparseArray();
            i = 0;
            while (i < stringArray2.length && i < stringArray.length) {
                this.nni.put(stringArray2[i].charAt(0), stringArray[i]);
                i++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        i = 0;
        while (i < length) {
            int codePointAt;
            int codePointAt2 = str.codePointAt(i);
            i += Character.charCount(codePointAt2);
            if (i < length) {
                codePointAt = str.codePointAt(i);
            } else {
                codePointAt = 0;
            }
            c vb = buL().vb(codePointAt2);
            if (vb != null) {
                d = (String) this.nni.get(vb.nnr);
                if (d != null) {
                    stringBuilder.append(d);
                } else {
                    stringBuilder.append(".");
                }
            } else {
                vb = buL().cY(codePointAt2, codePointAt);
                if (vb != null) {
                    if (vb.nnq != 0) {
                        i = Character.charCount(codePointAt) + i;
                    }
                    d = (String) this.nni.get(vb.nnr);
                    if (d != null) {
                        stringBuilder.append(d);
                    } else {
                        stringBuilder.append(".");
                    }
                } else {
                    stringBuilder.appendCodePoint(codePointAt2);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String dG(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt;
            int codePointAt2 = str.codePointAt(i);
            i += Character.charCount(codePointAt2);
            if (i < length) {
                codePointAt = str.codePointAt(i);
            } else {
                codePointAt = 0;
            }
            if (buL().vb(codePointAt2) != null) {
                stringBuilder.append(str2);
            } else {
                c cY = buL().cY(codePointAt2, codePointAt);
                if (cY != null) {
                    if (cY.nnq != 0) {
                        codePointAt = Character.charCount(codePointAt) + i;
                    } else {
                        codePointAt = i;
                    }
                    stringBuilder.append(str2);
                    i = codePointAt;
                } else {
                    stringBuilder.appendCodePoint(codePointAt2);
                }
            }
        }
        return stringBuilder.toString();
    }

    public final void a(Spannable spannable, Drawable drawable, int i, int i2, int i3) {
        try {
            drawable.setBounds(0, 0, (int) (((float) i3) * 1.3f), (int) (((float) i3) * 1.3f));
            com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(drawable);
            eVar.pbC = this.nmY;
            spannable.setSpan(eVar, i, i2, 33);
        } catch (Throwable e) {
            v.a("MicroMsg.EmojiHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    final c cY(int i, int i2) {
        if (this.nnl == null || this.nnl.isEmpty() || this.nnk) {
            this.nnl = new LinkedList(this.nnd.nmS);
            this.nnk = false;
        }
        if (this.nnl == null || this.nnl.isEmpty()) {
            return null;
        }
        Iterator it = this.nnl.iterator();
        boolean z = false;
        while (it.hasNext()) {
            boolean z2;
            d dVar = (d) it.next();
            if (i < dVar.kWz || i > dVar.max) {
                z2 = z;
            } else {
                z2 = true;
            }
            z = z2;
        }
        if (!z) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.nnh.get(i);
        if (sparseArray == null) {
            return null;
        }
        if (sparseArray.size() != 1 || sparseArray.get(0) == null) {
            return (c) sparseArray.get(i2);
        }
        return (c) sparseArray.get(0);
    }

    public final c vb(int i) {
        if (i < 57345 || i > 58679) {
            return null;
        }
        return (c) this.nne.get(i);
    }

    public final Drawable hH(int i) {
        return a((c) this.nng.get(i));
    }

    public final Drawable a(c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            Bitmap bitmap = (Bitmap) this.nnj.get(Integer.valueOf(cVar.cyv));
            if (bitmap != null && !bitmap.isRecycled()) {
                return new BitmapDrawable(aa.getContext().getResources(), bitmap);
            }
            byte[] c = com.tencent.mm.a.e.c(nmV, cVar.cyv + this.nna, cVar.size);
            Options options = new Options();
            options.inPreferredConfig = Config.RGB_565;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(c, 0, c.length, options);
            if (decodeByteArray != null) {
                decodeByteArray.setDensity(240);
                this.nnj.put(Integer.valueOf(cVar.cyv), decodeByteArray);
                return new BitmapDrawable(aa.getContext().getResources(), decodeByteArray);
            }
            return null;
        } catch (Throwable e) {
            v.a("MicroMsg.EmojiHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    private void buN() {
        this.dVF = new LinkedList(this.nnd.nmT);
        if (this.dVF == null || this.dVF.isEmpty()) {
            v.i("MicroMsg.EmojiHelper", "initIndex failed. items is empty.");
            return;
        }
        Iterator it = this.dVF.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.nnp != 0) {
                SparseArray sparseArray = (SparseArray) this.nnh.get(cVar.nnp);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.nnh.append(cVar.nnp, sparseArray);
                }
                sparseArray.put(cVar.nnq, cVar);
                if (cVar.nnr != 0) {
                    this.nne.append(cVar.nnr, cVar);
                }
                if (cVar.nns != -1) {
                    this.nnf.append(cVar.nns, cVar);
                }
            } else {
                this.nng.append(cVar.nnt, cVar);
            }
        }
    }

    public static int buO() {
        return 1;
    }
}
