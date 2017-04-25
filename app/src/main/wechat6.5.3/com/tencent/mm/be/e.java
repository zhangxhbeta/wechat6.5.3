package com.tencent.mm.be;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.a.a;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class e {
    private static final List<String> neT = Arrays.asList(new String[]{"zh_CN"});
    private static e neU;
    private static f neV;
    private static b neW;
    private static d neX;
    private static String neY = SQLiteDatabase.KeyEmpty;
    private static boolean neZ = false;
    private static boolean nfa = true;
    private static ArrayList<Integer> nfb = new ArrayList();

    public static e brZ() {
        synchronized (e.class) {
            if (neU == null) {
                neU = new e();
            }
        }
        return neU;
    }

    private e() {
    }

    private static void clean() {
        if (neV != null) {
            f fVar = neV;
            if (fVar.nfc != null) {
                fVar.nfc.clear();
            }
            if (fVar.nfd != null) {
                fVar.nfd = null;
            }
        }
        if (neW != null) {
            b bVar = neW;
            if (bVar.neM != null) {
                bVar.neM.clear();
            }
            if (bVar.epb != null) {
                bVar.epb = null;
            }
        }
        if (neX != null) {
            d dVar = neX;
            if (dVar.neR != null) {
                dVar.neR.clear();
            }
            if (dVar.epb != null) {
                dVar.epb = null;
            }
        }
    }

    public static e dx(Context context) {
        InputStream open;
        DataInputStream dataInputStream;
        Throwable e;
        InputStream inputStream;
        String d;
        String locale;
        Throwable th;
        if (context.getResources() == null) {
            v.e("MicroMsg.language.StringResouces", "the resource is null! why?");
            return null;
        }
        Locale locale2;
        boolean z;
        AssetManager assets = context.getAssets();
        if (assets != null) {
            brZ();
            v.i("MicroMsg.language.StringResouces", "[cpan] start to init string encrypt StringID List");
            if (nfb == null) {
                nfb = new ArrayList();
            }
            nfb.clear();
            long currentTimeMillis = System.currentTimeMillis();
            DataInputStream dataInputStream2 = null;
            try {
                open = assets.open("estrings/encrypt.mmstrid");
                try {
                    dataInputStream = new DataInputStream(open);
                    try {
                        v.d("MicroMsg.language.StringResouces", "encrypt string id size %d", Integer.valueOf(dataInputStream.readInt()));
                        for (int i = 0; i < r6.intValue(); i++) {
                            nfb.add(Integer.valueOf(dataInputStream.readInt()));
                            v.d("MicroMsg.language.StringResouces", "encrypt string id is %d", r7);
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable e2) {
                                v.e("MicroMsg.language.StringResouces", "exception:%s", be.e(e2));
                            }
                        }
                        try {
                            dataInputStream.close();
                        } catch (Throwable e3) {
                            v.e("MicroMsg.language.StringResouces", "exception:%s", be.e(e3));
                        }
                    } catch (IOException e4) {
                        inputStream = open;
                        try {
                            v.w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e22) {
                                    v.e("MicroMsg.language.StringResouces", "exception:%s", be.e(e22));
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Throwable e32) {
                                    v.e("MicroMsg.language.StringResouces", "exception:%s", be.e(e32));
                                }
                            }
                            v.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                            if (assets != null) {
                                brZ();
                                if (nfa) {
                                    d = u.d(context.getSharedPreferences(aa.bti(), 0));
                                    if (!be.kS(d)) {
                                    }
                                    locale2 = Locale.getDefault();
                                    u.a(context, locale2);
                                    locale = locale2.toString();
                                    brZ();
                                    z = neT.contains(locale);
                                    neZ = z;
                                    if (z) {
                                        clean();
                                        neY = locale;
                                        return null;
                                    }
                                    brZ();
                                    a(assets, locale);
                                    return brZ();
                                }
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            open = inputStream;
                            dataInputStream2 = dataInputStream;
                            e32 = th;
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (Throwable th22) {
                                    v.e("MicroMsg.language.StringResouces", "exception:%s", be.e(th22));
                                }
                            }
                            if (dataInputStream2 != null) {
                                try {
                                    dataInputStream2.close();
                                } catch (Throwable e222) {
                                    v.e("MicroMsg.language.StringResouces", "exception:%s", be.e(e222));
                                }
                            }
                            throw e32;
                        }
                    } catch (Throwable e2222) {
                        th = e2222;
                        dataInputStream2 = dataInputStream;
                        e32 = th;
                        if (open != null) {
                            open.close();
                        }
                        if (dataInputStream2 != null) {
                            dataInputStream2.close();
                        }
                        throw e32;
                    }
                } catch (IOException e5) {
                    dataInputStream = null;
                    inputStream = open;
                    v.w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    v.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                    if (assets != null) {
                        brZ();
                        if (nfa) {
                            d = u.d(context.getSharedPreferences(aa.bti(), 0));
                            if (be.kS(d)) {
                            }
                            locale2 = Locale.getDefault();
                            u.a(context, locale2);
                            locale = locale2.toString();
                            brZ();
                            if (neT.contains(locale)) {
                            }
                            neZ = z;
                            if (z) {
                                clean();
                                neY = locale;
                                return null;
                            }
                            brZ();
                            a(assets, locale);
                            return brZ();
                        }
                    }
                    return null;
                } catch (Throwable th3) {
                    e32 = th3;
                    if (open != null) {
                        open.close();
                    }
                    if (dataInputStream2 != null) {
                        dataInputStream2.close();
                    }
                    throw e32;
                }
            } catch (IOException e6) {
                inputStream = null;
                dataInputStream = null;
                v.w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                if (inputStream != null) {
                    inputStream.close();
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                v.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                if (assets != null) {
                    brZ();
                    if (nfa) {
                        d = u.d(context.getSharedPreferences(aa.bti(), 0));
                        if (be.kS(d)) {
                        }
                        locale2 = Locale.getDefault();
                        u.a(context, locale2);
                        locale = locale2.toString();
                        brZ();
                        if (neT.contains(locale)) {
                        }
                        neZ = z;
                        if (z) {
                            clean();
                            neY = locale;
                            return null;
                        }
                        brZ();
                        a(assets, locale);
                        return brZ();
                    }
                }
                return null;
            } catch (Throwable th222) {
                th = th222;
                open = null;
                e32 = th;
                if (open != null) {
                    open.close();
                }
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw e32;
            }
            v.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (assets != null) {
            brZ();
            if (nfa) {
                d = u.d(context.getSharedPreferences(aa.bti(), 0));
                if (be.kS(d) || d.equalsIgnoreCase("language_default")) {
                    locale2 = Locale.getDefault();
                    u.a(context, locale2);
                } else {
                    locale2 = u.Ke(d);
                }
                locale = locale2.toString();
                brZ();
                if (neT.contains(locale)) {
                }
                neZ = z;
                if (z) {
                    brZ();
                    a(assets, locale);
                    return brZ();
                }
                clean();
                neY = locale;
                return null;
            }
        }
        return null;
    }

    private static void a(AssetManager assetManager, String str) {
        Throwable e;
        InputStream inputStream;
        if (be.kS(str)) {
            v.w("MicroMsg.language.StringResouces", "local is null.");
        } else if (str.equals(neY)) {
            v.i("MicroMsg.language.StringResouces", "local no change. local is :%s", str);
        } else {
            int indexOf = str.indexOf("_");
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("zh")) {
                    v.d("MicroMsg.language.StringResouces", "local is :%s temp local is :%s", str, substring);
                    str = substring;
                }
            }
            clean();
            neY = str;
            v.i("MicroMsg.language.StringResouces", "[cpan] start to init string resource");
            long currentTimeMillis = System.currentTimeMillis();
            InputStream open;
            DataInputStream dataInputStream;
            try {
                open = assetManager.open("strings/" + str + ".mmstr");
                try {
                    dataInputStream = new DataInputStream(open);
                    try {
                        int i;
                        dataInputStream.readInt();
                        dataInputStream.readInt();
                        int readInt = dataInputStream.readInt();
                        v.i("MicroMsg.language.StringResouces", "string count" + readInt);
                        SparseIntArray sparseIntArray = new SparseIntArray(readInt);
                        int readInt2 = dataInputStream.readInt();
                        indexOf = 0;
                        for (i = 0; i < readInt; i++) {
                            readInt2 += dataInputStream.readShort();
                            sparseIntArray.append(readInt2, indexOf);
                            indexOf += dataInputStream.readShort();
                        }
                        neV = f.a(sparseIntArray, dataInputStream, indexOf);
                        readInt = dataInputStream.readInt();
                        v.i("MicroMsg.language.StringResouces", "plurals string count:%d", Integer.valueOf(readInt));
                        if (readInt > 0) {
                            SparseArray sparseArray = new SparseArray(readInt);
                            readInt2 = dataInputStream.readInt();
                            i = 0;
                            for (indexOf = 0; indexOf < readInt; indexOf++) {
                                readInt2 += dataInputStream.readInt();
                                i += a(dataInputStream, sparseArray, readInt2, i);
                            }
                            neW = b.a(sparseArray, dataInputStream, i);
                        }
                        int readInt3 = dataInputStream.readInt();
                        indexOf = dataInputStream.readInt();
                        v.i("MicroMsg.language.StringResouces", "string array count：%d", Integer.valueOf(readInt3));
                        if (readInt3 > 0) {
                            SparseArray sparseArray2 = new SparseArray(readInt3);
                            i = 0;
                            readInt = 0;
                            while (readInt < readInt3) {
                                readInt2 = dataInputStream.readInt() + indexOf;
                                int readInt4 = dataInputStream.readInt();
                                int[] iArr = new int[readInt4];
                                for (indexOf = 0; indexOf < readInt4; indexOf++) {
                                    iArr[indexOf] = i;
                                    i += dataInputStream.readShort();
                                }
                                sparseArray2.append(readInt2, new a(readInt2, iArr));
                                readInt++;
                                indexOf = readInt2;
                            }
                            neX = d.b(sparseArray2, dataInputStream, i);
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable e2) {
                                v.e("MicroMsg.language.StringResouces", "exception:%s", be.e(e2));
                            }
                        }
                        try {
                            dataInputStream.close();
                        } catch (Throwable e22) {
                            v.e("MicroMsg.language.StringResouces", "exception:%s", be.e(e22));
                        }
                    } catch (IOException e3) {
                        e22 = e3;
                        inputStream = open;
                        try {
                            v.a("MicroMsg.language.StringResouces", e22, "[cpan] local :%s file can not be find. use default.", str);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e222) {
                                    v.e("MicroMsg.language.StringResouces", "exception:%s", be.e(e222));
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Throwable e2222) {
                                    v.e("MicroMsg.language.StringResouces", "exception:%s", be.e(e2222));
                                }
                            }
                            v.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
                        } catch (Throwable th) {
                            e2222 = th;
                            open = inputStream;
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (Throwable e4) {
                                    v.e("MicroMsg.language.StringResouces", "exception:%s", be.e(e4));
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Throwable e5) {
                                    v.e("MicroMsg.language.StringResouces", "exception:%s", be.e(e5));
                                }
                            }
                            throw e2222;
                        }
                    } catch (Throwable th2) {
                        e2222 = th2;
                        if (open != null) {
                            open.close();
                        }
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        throw e2222;
                    }
                } catch (IOException e6) {
                    e2222 = e6;
                    dataInputStream = null;
                    inputStream = open;
                    v.a("MicroMsg.language.StringResouces", e2222, "[cpan] local :%s file can not be find. use default.", str);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    v.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th3) {
                    e2222 = th3;
                    dataInputStream = null;
                    if (open != null) {
                        open.close();
                    }
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    throw e2222;
                }
            } catch (IOException e7) {
                e2222 = e7;
                inputStream = null;
                dataInputStream = null;
                v.a("MicroMsg.language.StringResouces", e2222, "[cpan] local :%s file can not be find. use default.", str);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                v.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th4) {
                e2222 = th4;
                open = null;
                dataInputStream = null;
                if (open != null) {
                    open.close();
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw e2222;
            }
            v.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static boolean bsa() {
        if (!(nfa && neZ)) {
            boolean z = (nfb == null || nfb.isEmpty()) ? false : true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static boolean brY() {
        return nfa;
    }

    public static String getString(int i) {
        if (neV == null) {
            return null;
        }
        return neV.getString(i);
    }

    public static String getQuantityString(int i, int i2) {
        if (neW == null) {
            return null;
        }
        return neW.getQuantityString(i, i2, new Object[0]);
    }

    public static String getQuantityString(int i, int i2, Object... objArr) {
        if (neW == null) {
            return null;
        }
        return neW.getQuantityString(i, i2, objArr);
    }

    public static String[] getStringArray(int i) {
        int i2 = 0;
        if (neX == null) {
            return null;
        }
        d dVar = neX;
        int indexOfKey = dVar.neR.indexOfKey(i);
        if (indexOfKey < 0) {
            return null;
        }
        String[] strArr;
        int length = indexOfKey < dVar.neR.size() + -1 ? ((a) dVar.neR.valueAt(indexOfKey + 1)).neS[0] : dVar.epb.length;
        a aVar = (a) dVar.neR.valueAt(indexOfKey);
        indexOfKey = aVar.neS.length;
        if (indexOfKey > 0) {
            String[] strArr2 = new String[indexOfKey];
            while (i2 < indexOfKey) {
                if (i2 < indexOfKey - 1) {
                    strArr2[i2] = new String(dVar.epb, aVar.neS[i2], aVar.neS[i2 + 1] - aVar.neS[i2]);
                } else {
                    strArr2[i2] = new String(dVar.epb, aVar.neS[i2], length - aVar.neS[i2]);
                }
                i2++;
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        return strArr;
    }

    private static int a(DataInputStream dataInputStream, SparseArray<a> sparseArray, int i, int i2) {
        try {
            byte readByte = dataInputStream.readByte();
            if (readByte < (byte) 0) {
                return 0;
            }
            int[] iArr = new int[readByte];
            int[] iArr2 = new int[readByte];
            int i3 = 0;
            for (byte b = (byte) 0; b < readByte; b++) {
                iArr[b] = dataInputStream.readByte();
                iArr2[b] = i2;
                short readShort = dataInputStream.readShort();
                i3 += readShort;
                i2 += readShort;
            }
            sparseArray.append(i, new a(i, iArr, iArr2));
            return i3;
        } catch (Throwable e) {
            v.e("MicroMsg.language.StringResouces", "exception:%s", be.e(e));
            return 0;
        }
    }

    public static CharSequence c(int i, CharSequence charSequence) {
        if (charSequence == null || nfb == null || nfb.isEmpty() || !nfb.contains(Integer.valueOf(i))) {
            return charSequence;
        }
        return a.o(charSequence.toString(), g.m("lucky".getBytes()).substring(0, 16));
    }
}
