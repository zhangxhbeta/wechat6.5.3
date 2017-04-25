package com.tencent.mm.storage;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;

public final class RegionCodeDecoder {
    private static RegionCodeDecoder nwy = null;
    public static final String nwz = (e.cnf + "MicroMsg/regioncode/");
    private String nwA = SQLiteDatabase.KeyEmpty;
    private String nwB = SQLiteDatabase.KeyEmpty;

    private static class DecoderJni {
        public static native void buildFromFile(String str);

        public static native Region[] getCities(String str, String str2, String str3);

        public static native Region[] getCountries(String str);

        public static native String getLocName(String str);

        public static native Region[] getProvinces(String str, String str2);

        public static native void release();

        private DecoderJni() {
        }
    }

    public static class Region {
        private String code;
        private boolean hasChildren = false;
        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public boolean hasChildren() {
            return this.hasChildren;
        }

        public void setHasChildren(boolean z) {
            this.hasChildren = z;
        }
    }

    public static RegionCodeDecoder bxc() {
        if (nwy == null) {
            nwy = new RegionCodeDecoder();
        }
        RegionCodeDecoder regionCodeDecoder = nwy;
        if (!u.bsY().equals(regionCodeDecoder.nwA)) {
            regionCodeDecoder.bvb();
        }
        return nwy;
    }

    public final void bvb() {
        File file = new File(nwz);
        if (!file.exists()) {
            file.mkdir();
            y(file);
        }
        String[] list = file.list();
        if (list == null || list.length == 0) {
            y(file);
        }
        this.nwA = u.bsY();
        String bxd = bxd();
        if (be.kS(bxd)) {
            v.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.nwA);
            return;
        }
        bxd = nwz + bxd;
        if (!bxd.equals(this.nwB)) {
            this.nwB = bxd;
            DecoderJni.buildFromFile(this.nwB);
        }
    }

    private synchronized void y(File file) {
        synchronized (this) {
            String[] strArr = null;
            if (file.exists()) {
                strArr = file.list();
            }
            if (!file.exists() || r1 == null || r1.length == 0) {
                try {
                    for (String str : aa.getContext().getAssets().list("regioncode")) {
                        v.i("MicroMsg.RegionCodeDecoder", "from:%s,  to:%s", "regioncode/" + str, file.getPath() + "/" + str);
                        j.y(aa.getContext(), "regioncode/" + str, file.getPath() + "/" + str);
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.RegionCodeDecoder", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
        }
    }

    private String bxd() {
        String str = "mmregioncode_" + (this.nwA.equalsIgnoreCase("zh_HK") ? "zh_TW" : this.nwA) + ".txt";
        String str2 = "mmregioncode_en.txt";
        File file = new File(nwz);
        if (file.exists()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                return null;
            }
            Object obj = null;
            for (String str3 : list) {
                if (str3.equals(str)) {
                    return str3;
                }
                if (obj == null && str3.equals(str2)) {
                    obj = 1;
                }
            }
            return obj != null ? str2 : null;
        } else {
            file.mkdir();
            return null;
        }
    }

    public static final String Y(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!be.kS(str)) {
            stringBuffer.append(str);
            if (!be.kS(str2)) {
                stringBuffer.append('_');
                stringBuffer.append(str2);
                if (!be.kS(str3)) {
                    stringBuffer.append('_');
                    stringBuffer.append(str3);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String Nm(String str) {
        if (be.kS(str) || !u.Kd(str)) {
            v.e("MicroMsg.RegionCodeDecoder", "unsupported language:" + str);
            return null;
        }
        if (str.equalsIgnoreCase("zh_HK")) {
            str = "zh_TW";
        }
        return nwz + "mmregioncode_" + str + ".txt";
    }

    public static final boolean Nn(String str) {
        if (be.kS(str)) {
            return false;
        }
        return str.equalsIgnoreCase("cn");
    }

    public static String getLocName(String str) {
        if (be.kS(str)) {
            return null;
        }
        return DecoderJni.getLocName(str);
    }

    public final String No(String str) {
        String locName = getLocName(str);
        return be.kS(locName) ? be.ma(str) : locName;
    }

    public final String dP(String str, String str2) {
        String str3 = null;
        if (!(be.kS(str) || be.kS(str2))) {
            str3 = getLocName(Y(str, str2, null));
        }
        return be.kS(str3) ? be.ma(str2) : str3;
    }

    public final String Z(String str, String str2, String str3) {
        String locName = (be.kS(str) || be.kS(str2) || be.kS(str3)) ? null : getLocName(Y(str, str2, str3));
        return be.kS(locName) ? be.ma(str3) : locName;
    }

    public final Region[] bxe() {
        if (be.kS(this.nwB)) {
            return null;
        }
        return DecoderJni.getCountries(this.nwB);
    }

    public final Region[] Np(String str) {
        if (be.kS(this.nwB) || be.kS(str)) {
            return null;
        }
        return DecoderJni.getProvinces(this.nwB, str);
    }

    public final Region[] dQ(String str, String str2) {
        if (be.kS(this.nwB) || be.kS(str) || be.kS(str2)) {
            return null;
        }
        return DecoderJni.getCities(this.nwB, str, str2);
    }
}
