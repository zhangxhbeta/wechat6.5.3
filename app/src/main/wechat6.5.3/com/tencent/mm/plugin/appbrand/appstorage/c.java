package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Build.VERSION;
import android.system.Os;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;

public final class c {
    static final String dCi;
    private static final Collection<a> dCj;
    private static final AppBrandLocalMediaObject dCk = new AppBrandLocalMediaObjectManager$2();

    private interface a {
        AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject);

        AppBrandLocalMediaObject aD(String str, String str2);

        AppBrandLocalMediaObject aE(String str, String str2);

        com.tencent.mm.vending.j.a u(String str, String str2, String str3);
    }

    private static final class b {
        private b() {
        }
    }

    private static final class c implements a {
        private c() {
        }

        public final String toString() {
            return "V1MediaObjectInfoHandler";
        }

        public final AppBrandLocalMediaObject aD(String str, String str2) {
            String aA;
            try {
                aA = c.aA(str2, str);
            } catch (Throwable e) {
                v.e("MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler", "retrieveMediaObject, fileName = %s, decrypt exp = %s", new Object[]{str2, be.e(e)});
                aA = null;
            }
            if (be.kS(aA) || be.kS(aA)) {
                return null;
            }
            String[] split = aA.split("\\|");
            String str3 = "MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler";
            String str4 = "retrieveMediaObject, split arrays length %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(split == null ? -1 : split.length);
            v.i(str3, str4, objArr);
            if (split == null || split.length != 2) {
                return null;
            }
            str3 = split[0];
            str4 = split[1];
            if (be.kS(str3)) {
                v.e("MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler", "retrieveMediaObject, null or nil fileName(%s) fileMd5(%s)", new Object[]{str2, str3});
                return null;
            }
            aA = c.mV(str) + str2 + ".dat";
            String str5 = c.mV(str) + str2 + ".tmp";
            if (e.aR(aA)) {
                v.i("MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler", "retrieveMediaObject, fileName(%s) appId(%s) permanent file exists", new Object[]{str2, str});
            } else if (e.aR(str5)) {
                v.i("MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler", "retrieveMediaObject, fileName(%s) appId(%s) temp file exists", new Object[]{str2, str});
                aA = str5;
            } else {
                v.e("MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler", "retrieveMediaObject, file not exists, fileName(%s), appId(%s) ", new Object[]{str2, str});
                return null;
            }
            if (g.aX(aA).equals(str3)) {
                AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
                appBrandLocalMediaObject.bde = "wxfile://" + str2;
                appBrandLocalMediaObject.cvK = aA;
                appBrandLocalMediaObject.mimeType = str4;
                appBrandLocalMediaObject.dCf = s.Ij(str4);
                appBrandLocalMediaObject.dCg = false;
                return appBrandLocalMediaObject;
            }
            v.e("MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler", "retrieveMediaObject, exactMd5 != fileMd5, fileName(%s), appId(%s) ", new Object[]{str2, str});
            return null;
        }

        public final AppBrandLocalMediaObject aE(String str, String str2) {
            return null;
        }

        public final AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject) {
            return null;
        }

        @Deprecated
        public final com.tencent.mm.vending.j.a u(String str, String str2, String str3) {
            return null;
        }
    }

    private static final class d implements a {
        private d() {
        }

        public final String toString() {
            return "V2MediaObjectInfoHandler";
        }

        public final AppBrandLocalMediaObject aD(String str, String str2) {
            if (!str2.startsWith("store_") && !str2.startsWith("tmp_")) {
                return null;
            }
            String Ii = s.Ii(str2);
            String replaceFirst = str2.replaceFirst("store_", "").replaceFirst("tmp_", "");
            if (!be.kS(Ii)) {
                replaceFirst = replaceFirst.replaceFirst("." + Ii, "");
            }
            if (be.kS(replaceFirst)) {
                return c.dCk;
            }
            try {
                Ii = c.aA(replaceFirst, str);
            } catch (Throwable e) {
                v.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObject, decrypt exp ", new Object[0]);
                Ii = null;
            }
            if (be.kS(Ii)) {
                v.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
                return null;
            }
            String[] split = Ii.split("\\|");
            if (split == null || split.length != 2) {
                return c.dCk;
            }
            Ii = str2.startsWith("store_") ? "store_" : "tmp_";
            replaceFirst = c.mV(str) + Ii + replaceFirst;
            long j = be.getLong(split[0], 0);
            String str3 = split[1];
            try {
                if (j != c.mX(replaceFirst)) {
                    v.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s), appId(%s)", new Object[]{Long.valueOf(c.mX(replaceFirst)), Long.valueOf(j), str2, str});
                    return c.dCk;
                }
                AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
                appBrandLocalMediaObject.bde = "wxfile://" + str2;
                appBrandLocalMediaObject.cvK = replaceFirst;
                appBrandLocalMediaObject.mimeType = s.Ig(str3);
                appBrandLocalMediaObject.dCg = Ii.equalsIgnoreCase("store_");
                File file = new File(appBrandLocalMediaObject.cvK);
                appBrandLocalMediaObject.dCh = file.lastModified();
                appBrandLocalMediaObject.dfM = file.length();
                return appBrandLocalMediaObject;
            } catch (Throwable e2) {
                v.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[]{be.e(e2)});
                return c.dCk;
            }
        }

        public final AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject) {
            if (appBrandLocalMediaObject == null) {
                return null;
            }
            String replaceFirst = appBrandLocalMediaObject.cvK.replaceFirst("tmp_", "store_");
            if (!c.aw(appBrandLocalMediaObject.cvK, replaceFirst)) {
                return null;
            }
            AppBrandLocalMediaObject appBrandLocalMediaObject2 = new AppBrandLocalMediaObject();
            appBrandLocalMediaObject2.cvK = replaceFirst;
            appBrandLocalMediaObject2.bde = appBrandLocalMediaObject.bde.replaceFirst("tmp_", "store_");
            appBrandLocalMediaObject2.dfM = appBrandLocalMediaObject.dfM;
            appBrandLocalMediaObject2.dCf = appBrandLocalMediaObject.dCf;
            appBrandLocalMediaObject2.dCh = new File(appBrandLocalMediaObject2.cvK).lastModified();
            appBrandLocalMediaObject2.mimeType = appBrandLocalMediaObject.mimeType;
            appBrandLocalMediaObject2.dCg = true;
            return appBrandLocalMediaObject2;
        }

        public final com.tencent.mm.vending.j.a u(String str, String str2, String str3) {
            String ah = be.ah(str3, "unknown");
            try {
                String aC;
                Long valueOf = Long.valueOf(c.mX(str2));
                try {
                    aC = be.bn(new r().encrypt(String.format(Locale.US, "%d|%s", new Object[]{valueOf, ah}).getBytes(), str.getBytes()));
                } catch (Throwable e) {
                    v.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "attachMediaObject, enc exp = ", new Object[0]);
                    aC = null;
                }
                if (be.kS(aC)) {
                    return null;
                }
                aC = "tmp_" + aC;
                String str4 = c.mV(str) + aC;
                String str5 = "wxfile://" + aC + (be.kS(ah) ? "" : "." + ah);
                v.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", new Object[]{str5, str4});
                com.tencent.mm.vending.j.d dVar = new com.tencent.mm.vending.j.d();
                dVar.pik = new Object[]{str5, str4, ah};
                return dVar;
            } catch (Throwable e2) {
                v.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", new Object[]{be.e(e2)});
                return null;
            }
        }

        public final AppBrandLocalMediaObject aE(String str, String str2) {
            String aA;
            String replaceFirst = str2.replaceFirst("store_", "").replaceFirst("tmp_", "");
            try {
                aA = c.aA(replaceFirst, str);
            } catch (Throwable e) {
                v.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
                aA = null;
            }
            if (be.kS(aA)) {
                return null;
            }
            String[] split = aA.split("\\|");
            if (split == null || split.length != 2) {
                return null;
            }
            aA = split[1];
            aA = "wxfile://" + str2 + (be.kS(aA) ? "" : "." + aA);
            AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
            appBrandLocalMediaObject.bde = aA;
            appBrandLocalMediaObject.cvK = c.mV(str) + str2;
            appBrandLocalMediaObject.dCf = replaceFirst;
            appBrandLocalMediaObject.dCg = true;
            File file = new File(appBrandLocalMediaObject.cvK);
            appBrandLocalMediaObject.dCh = file.lastModified();
            appBrandLocalMediaObject.dfM = file.length();
            return appBrandLocalMediaObject;
        }
    }

    static /* synthetic */ String aA(String str, String str2) {
        byte[] KG = be.KG(str);
        r rVar = new r();
        byte[] bytes = str2.getBytes();
        int length = KG.length;
        rVar.preCrypt = 0;
        rVar.crypt = 0;
        rVar.key = bytes;
        bytes = new byte[8];
        if (length % 8 != 0 || length < 16) {
            bytes = null;
        } else {
            rVar.prePlain = rVar.decipher(KG, 0);
            rVar.pos = rVar.prePlain[0] & 7;
            int i = (length - rVar.pos) - 10;
            if (i < 0) {
                bytes = null;
            } else {
                for (int i2 = 0; i2 < 8; i2++) {
                    bytes[i2] = (byte) 0;
                }
                rVar.out = new byte[i];
                rVar.preCrypt = 0;
                rVar.crypt = 8;
                rVar.contextStart = 8;
                rVar.pos++;
                rVar.padding = 1;
                while (rVar.padding <= 2) {
                    if (rVar.pos < 8) {
                        rVar.pos++;
                        rVar.padding++;
                    }
                    if (rVar.pos == 8) {
                        if (!rVar.decrypt8Bytes(KG, 0, length)) {
                            bytes = null;
                            break;
                        }
                        bytes = KG;
                    }
                }
                byte[] bArr = bytes;
                int i3 = 0;
                while (i != 0) {
                    if (rVar.pos < 8) {
                        rVar.out[i3] = (byte) (bArr[(rVar.preCrypt + 0) + rVar.pos] ^ rVar.prePlain[rVar.pos]);
                        i3++;
                        i--;
                        rVar.pos++;
                    }
                    if (rVar.pos == 8) {
                        rVar.preCrypt = rVar.crypt - 8;
                        if (!rVar.decrypt8Bytes(KG, 0, length)) {
                            bytes = null;
                            break;
                        }
                        bArr = KG;
                    }
                }
                rVar.padding = 1;
                bytes = bArr;
                while (rVar.padding < 8) {
                    if (rVar.pos < 8) {
                        if ((bytes[(rVar.preCrypt + 0) + rVar.pos] ^ rVar.prePlain[rVar.pos]) != 0) {
                            bytes = null;
                            break;
                        }
                        rVar.pos++;
                    }
                    if (rVar.pos == 8) {
                        rVar.preCrypt = rVar.crypt;
                        if (!rVar.decrypt8Bytes(KG, 0, length)) {
                            bytes = null;
                            break;
                        }
                        bytes = KG;
                    }
                    rVar.padding++;
                }
                bytes = rVar.out;
            }
        }
        return be.kS(str) ? null : new String(bytes);
    }

    static /* synthetic */ long mX(String str) {
        Closeable fileInputStream = new FileInputStream(str);
        Closeable checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        be.f(checkedInputStream);
        be.f(fileInputStream);
        return value;
    }

    static {
        String str = com.tencent.mm.compatible.util.e.cnj;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        dCi = str + "wxafiles/";
        Collection linkedList = new LinkedList();
        linkedList.add(new d());
        linkedList.add(new c());
        dCj = Collections.unmodifiableCollection(linkedList);
    }

    public static String av(String str, String str2) {
        if (be.kS(str) || be.kS(str2)) {
            return null;
        }
        return mV(str) + str2;
    }

    private static boolean aw(String str, String str2) {
        if (VERSION.SDK_INT >= 21) {
            try {
                long Ni = be.Ni();
                b bVar = new b();
                Os.rename(str, str2);
                v.d("MicroMsg.AppBrand.LocalMediaObjectManager", "renameToImpl, os rename works, cost = %d", new Object[]{Long.valueOf(be.Ni() - Ni)});
                return true;
            } catch (Throwable e) {
                v.e("MicroMsg.AppBrand.LocalMediaObjectManager", "renameToImpl, os rename exp = %s", new Object[]{be.e(e)});
            }
        }
        return e.renameTo(new File(str), new File(str2));
    }

    public static List<AppBrandLocalMediaObject> mS(String str) {
        File[] mT = mT(str);
        if (mT == null || mT.length <= 0) {
            return null;
        }
        List<AppBrandLocalMediaObject> linkedList = new LinkedList();
        for (File name : mT) {
            AppBrandLocalMediaObject ay = ay(str, name.getName());
            if (ay != null) {
                linkedList.add(ay);
            }
        }
        return linkedList;
    }

    private static File[] mT(String str) {
        File file = new File(mV(str));
        if (file.exists() && file.isDirectory()) {
            return file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    return file.exists() && !file.isDirectory() && !be.kS(file.getName()) && file.getName().startsWith("store_");
                }
            });
        }
        return null;
    }

    public static long mU(String str) {
        long j = 0;
        File[] mT = mT(str);
        if (mT != null && mT.length > 0) {
            int i = 0;
            while (i < mT.length) {
                long length = mT[i].length() + j;
                i++;
                j = length;
            }
        }
        return j;
    }

    public static AppBrandLocalVideoObject ax(String str, String str2) {
        return (AppBrandLocalVideoObject) a(str, str2, AppBrandLocalVideoObject.class, "mp4", false);
    }

    private static <T extends AppBrandLocalMediaObject> T a(String str, String str2, Class<T> cls, String str3, boolean z) {
        if (be.kS(str) || !e.aR(str2)) {
            return null;
        }
        String Ii = s.Ii(str2);
        if (!be.kS(Ii)) {
            str3 = Ii;
        }
        com.tencent.mm.vending.j.a aVar = null;
        for (a u : dCj) {
            aVar = u.u(str, str2, str3);
            if (aVar != null) {
                break;
            }
        }
        com.tencent.mm.vending.j.a aVar2 = aVar;
        if (aVar2 == null || aVar2.size() < 2) {
            int i;
            String str4 = "MicroMsg.AppBrand.LocalMediaObjectManager";
            String str5 = "attachCast, no handler return correct info, attach.size = %d";
            Object[] objArr = new Object[1];
            if (aVar2 == null) {
                i = -1;
            } else {
                i = aVar2.size();
            }
            objArr[0] = Integer.valueOf(i);
            v.e(str4, str5, objArr);
            return null;
        }
        try {
            T t = (AppBrandLocalMediaObject) cls.newInstance();
            t.bde = (String) aVar2.get(0);
            t.mimeType = s.Ig(str3);
            t.cvK = (String) aVar2.get(1);
            t.dCf = be.ah((String) aVar2.get(3), be.ah(str3, "unknown"));
            str4 = t.cvK;
            int i2 = (z && aw(str2, str4)) ? 1 : (z || !j.dz(str2, str4)) ? 0 : 1;
            if (i2 == 0) {
                return null;
            }
            File file = new File(t.cvK);
            t.dfM = file.length();
            t.dCh = file.lastModified();
            return t;
        } catch (Throwable e) {
            v.a("MicroMsg.AppBrand.LocalMediaObjectManager", e, "", new Object[0]);
            return null;
        }
    }

    public static AppBrandLocalMediaObject f(String str, String str2, boolean z) {
        return b(str, str2, null, z);
    }

    public static AppBrandLocalMediaObject b(String str, String str2, String str3, boolean z) {
        return a(str, str2, AppBrandLocalMediaObject.class, str3, z);
    }

    private static String mV(String str) {
        String str2 = dCi + str + "/";
        h.JX(str2);
        try {
            new File(str2, ".nomedia").createNewFile();
        } catch (Exception e) {
        }
        return str2;
    }

    public static AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject) {
        AppBrandLocalMediaObject appBrandLocalMediaObject2 = null;
        for (a a : dCj) {
            appBrandLocalMediaObject2 = a.a(appBrandLocalMediaObject);
            if (appBrandLocalMediaObject2 != null) {
                break;
            }
        }
        return appBrandLocalMediaObject2;
    }

    private static AppBrandLocalMediaObject ay(String str, String str2) {
        AppBrandLocalMediaObject appBrandLocalMediaObject = null;
        if (!be.kS(str) && !be.kS(str2)) {
            for (a aE : dCj) {
                appBrandLocalMediaObject = aE.aE(str, str2);
                if (appBrandLocalMediaObject != null) {
                    break;
                }
            }
        }
        return appBrandLocalMediaObject;
    }

    public static AppBrandLocalMediaObject az(String str, String str2) {
        if (be.kS(str2) || !str2.startsWith("wxfile://") || be.kS(str)) {
            v.e("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, invalid args, localId(%s), appId(%s) ", new Object[]{str2, str});
            return null;
        }
        AppBrandLocalMediaObject aD;
        String substring = str2.substring(9);
        AppBrandLocalMediaObject appBrandLocalMediaObject = null;
        for (a aD2 : dCj) {
            aD = aD2.aD(str, substring);
            if (aD != null) {
                v.i("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[]{aD2.toString(), aD});
                break;
            }
            appBrandLocalMediaObject = aD;
        }
        aD = appBrandLocalMediaObject;
        if (dCk != aD) {
            return aD;
        }
        return null;
    }
}
