package com.tencent.mm.al;

import com.tencent.mm.e.a.kj;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.nj;
import com.tencent.mm.protocal.c.nk;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.m;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public final class j extends k implements com.tencent.mm.network.j, m {
    public int aZc;
    public int cUo;
    private b cif;
    private e cii;
    private int offset = 0;

    public j(int i, int i2) {
        this.cUo = i;
        this.aZc = i2;
        m aK = t.HS().aK(i, i2);
        if (aK == null) {
            v.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:" + i);
            return;
        }
        aK.status = 3;
        aK.bkU = 64;
        t.HS().b(aK);
        if (i2 == 5) {
            ak.yW();
            com.tencent.mm.loader.stub.b.deleteFile(c.xp() + "brand_i18n.apk");
            return;
        }
        com.tencent.mm.loader.stub.b.deleteFile(n.HO() + t.HS().aM(i, i2));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", Integer.valueOf(this.cUo), Integer.valueOf(this.aZc));
        m aK = t.HS().aK(this.cUo, this.aZc);
        if (aK == null) {
            v.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.cUo + " type:" + this.aZc);
            return -1;
        } else if (aK.status != 3) {
            v.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.cUo + " stat:" + aK.status);
            return -1;
        } else if (aK.size <= 0) {
            v.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.cUo + " size:" + aK.size);
            return -1;
        } else {
            a aVar = new a();
            aVar.czn = new nj();
            aVar.czo = new nk();
            aVar.uri = "/cgi-bin/micromsg-bin/downloadpackage";
            aVar.czm = 160;
            aVar.czp = 0;
            aVar.czq = 0;
            this.cif = aVar.Bv();
            nj njVar = (nj) this.cif.czk.czs;
            ali com_tencent_mm_protocal_c_ali = new ali();
            com_tencent_mm_protocal_c_ali.gof = aK.id;
            com_tencent_mm_protocal_c_ali.efl = aK.version;
            njVar.mpm = com_tencent_mm_protocal_c_ali;
            njVar.mfb = this.offset;
            njVar.mpn = 65536;
            njVar.efm = this.aZc;
            return a(eVar, this.cif, this);
        }
    }

    protected final int a(p pVar) {
        nj njVar = (nj) ((b) pVar).czk.czs;
        m aK = t.HS().aK(this.cUo, this.aZc);
        if (aK == null) {
            v.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.cUo);
            return b.czV;
        } else if (njVar.mpm.gof == this.cUo && njVar.mfb == this.offset && njVar.mfb < aK.size && njVar.mpn == 65536 && aK.size > 0 && aK.status == 3) {
            return b.czU;
        } else {
            v.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.cUo);
            return b.czV;
        }
    }

    protected final int ul() {
        return 50;
    }

    protected final void a(a aVar) {
        t.HS().aO(this.cUo, this.aZc);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.cUo + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        if (i2 == 0 || i3 == 0) {
            nk nkVar = (nk) ((b) pVar).czl.czs;
            if (nkVar.efm != this.aZc) {
                v.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
                t.HS().aO(this.cUo, this.aZc);
                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                return;
            }
            byte[] a = com.tencent.mm.platformtools.m.a(nkVar.mpo);
            if (a == null || a.length == 0) {
                v.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.cUo);
                t.HS().aO(this.cUo, this.aZc);
                this.cii.a(3, -1, str, this);
                return;
            }
            m aK = t.HS().aK(this.cUo, this.aZc);
            if (aK == null) {
                v.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.cUo);
                t.HS().aO(this.cUo, this.aZc);
                this.cii.a(3, -1, str, this);
                return;
            } else if (aK.size != nkVar.mpp) {
                v.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
                t.HS().aO(this.cUo, this.aZc);
                ak.vy().a(new k(this.aZc), 0);
                this.cii.a(3, -1, str, this);
                return;
            } else {
                String xp;
                String str2;
                if (this.aZc == 5) {
                    ak.yW();
                    xp = c.xp();
                    str2 = "brand_i18n.apk";
                } else {
                    t.HS();
                    xp = n.HO();
                    str2 = t.HS().aM(this.cUo, this.aZc);
                }
                v.d("MicroMsg.NetSceneDownloadPackage", "packagePath " + xp);
                v.d("MicroMsg.NetSceneDownloadPackage", "packageName " + str2);
                int a2 = com.tencent.mm.a.e.a(xp, str2, a);
                if (a2 != 0) {
                    t.HS().aO(this.cUo, this.aZc);
                    v.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = " + a2);
                    this.cii.a(3, -1, str, this);
                    return;
                }
                this.offset = a.length + this.offset;
                if (this.offset >= aK.size) {
                    String aN;
                    boolean z = false;
                    if (this.aZc == 1) {
                        aN = t.HS().aN(this.cUo, this.aZc);
                        a2 = be.dB(xp + str2, aN);
                        if (a2 < 0) {
                            v.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + a2 + ", zipFilePath = " + xp + str2 + ", unzipPath = " + aN);
                            t.HS().aO(this.cUo, this.aZc);
                            this.cii.a(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                    if (this.aZc == 8) {
                        z = X(xp, str2);
                    }
                    if (this.aZc == 23) {
                        if (be.kS(xp) || be.kS(str2)) {
                            v.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", xp, str2);
                            t.HS().aO(this.cUo, this.aZc);
                            this.cii.a(3, 0, "open permission pkg failed", this);
                            z = false;
                        } else if (new File(xp + str2).exists()) {
                            if (-1 == com.tencent.mm.a.e.p(xp + str2, com.tencent.mm.compatible.util.e.cng + "permissioncfg.cfg")) {
                                v.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                t.HS().aO(this.cUo, this.aZc);
                                this.cii.a(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                z = true;
                            }
                        } else {
                            v.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", xp, str2);
                            t.HS().aO(this.cUo, this.aZc);
                            this.cii.a(3, 0, "file not exist", this);
                            z = false;
                        }
                    }
                    if (this.aZc == 7) {
                        z = true;
                    }
                    if (this.aZc == 9) {
                        z = true;
                    }
                    if (this.aZc == 5) {
                        z = true;
                        u.DL();
                    }
                    if (this.aZc == 12) {
                        com.tencent.mm.sdk.c.b kjVar = new kj();
                        kjVar.blv.blx = xp + str2;
                        com.tencent.mm.sdk.c.a.nhr.z(kjVar);
                        z = true;
                    }
                    if (this.aZc == 18) {
                        aN = t.HS().aN(this.cUo, this.aZc);
                        a2 = be.dB(xp + str2, aN);
                        if (a2 < 0) {
                            v.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + a2 + ", zipFilePath = " + xp + str2 + ", unzipPath = " + aN);
                            t.HS().aO(this.cUo, this.aZc);
                            this.cii.a(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            v.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", aN);
                            z = true;
                        }
                    }
                    if (this.aZc == 20) {
                        z = true;
                    }
                    if (this.aZc == 21) {
                        z = true;
                    }
                    if (this.aZc == 26) {
                        if (be.kS(xp) || be.kS(str2)) {
                            v.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", xp, str2);
                            this.cii.a(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
                            z = false;
                        } else if (new File(xp + str2).exists()) {
                            if (-1 == com.tencent.mm.a.e.p(xp + str2, com.tencent.mm.compatible.util.e.cng + "ipcallCountryCodeConfig.cfg")) {
                                v.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                t.HS().aO(this.cUo, this.aZc);
                                this.cii.a(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                v.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
                                z = true;
                            }
                        } else {
                            v.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", xp, str2);
                            t.HS().aO(this.cUo, this.aZc);
                            this.cii.a(3, 0, "file not exist", this);
                            z = false;
                        }
                    }
                    if (this.aZc == 36) {
                        z = W(xp, str2);
                    }
                    if (z) {
                        aK.status = 2;
                        aK.bkU = 64;
                        t.HS().b(aK);
                        this.cii.a(0, 0, SQLiteDatabase.KeyEmpty, this);
                        return;
                    }
                    return;
                } else if (a(this.czE, this.cii) < 0) {
                    t.HS().aO(this.cUo, this.aZc);
                    this.cii.a(3, -1, str, this);
                    return;
                } else {
                    return;
                }
            }
        }
        v.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
        t.HS().aO(this.cUo, this.aZc);
        this.cii.a(i2, i3, str, this);
    }

    private static boolean W(String str, String str2) {
        Throwable e;
        boolean z = true;
        if (be.kS(str) || be.kS(str2)) {
            return false;
        }
        try {
            String str3 = str + str2;
            Object aV = com.tencent.mm.a.e.aV(str3);
            if (be.kS(aV)) {
                z = false;
            } else {
                ak.yW();
                c.vf().a(t.a.USERINFO_SENSE_WHERE_LOCATION_STRING, aV);
            }
            try {
                com.tencent.mm.loader.stub.b.deleteFile(str3);
                v.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", Boolean.valueOf(z), str3, be.KW(aV));
                return z;
            } catch (IOException e2) {
                e = e2;
                v.a("MicroMsg.NetSceneDownloadPackage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return z;
            }
        } catch (Throwable e3) {
            e = e3;
            z = false;
            v.a("MicroMsg.NetSceneDownloadPackage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return z;
        }
    }

    private boolean X(String str, String str2) {
        InputStream fileInputStream;
        BufferedWriter bufferedWriter;
        Throwable e;
        Throwable th;
        if (be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.NetSceneDownloadPackage", "update regioncode failed, no file assigned, packagePath:" + str + " ,packageName:" + str2);
            t.HS().aO(this.cUo, this.aZc);
            this.cii.a(3, 0, "open regioncode file fail", this);
            return false;
        }
        File file = new File(str + str2);
        if (file.exists()) {
            InputStream inputStream = null;
            Map hashMap = new HashMap();
            try {
                fileInputStream = new FileInputStream(file);
                Reader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.trim().split("\\|");
                    if (split.length < 2 || be.kS(split[0]) || be.kS(split[1])) {
                        v.e("MicroMsg.NetSceneDownloadPackage", "dispatch regioncode, error line = " + readLine);
                    } else {
                        bufferedWriter = (BufferedWriter) hashMap.get(split[0]);
                        if (bufferedWriter == null) {
                            RegionCodeDecoder.bxc();
                            readLine = RegionCodeDecoder.Nm(split[0]);
                            if (be.kS(readLine)) {
                                v.e("MicroMsg.NetSceneDownloadPackage", "dispatch regioncode, output language unsupported");
                            } else {
                                try {
                                    File file2 = new File(readLine);
                                    if (!file2.exists()) {
                                        file2.createNewFile();
                                    }
                                    bufferedWriter = new BufferedWriter(new FileWriter(file2));
                                    hashMap.put(split[0], bufferedWriter);
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            }
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(split[1]);
                        stringBuffer.append('|');
                        stringBuffer.append(split[2]);
                        stringBuffer.append('\n');
                        bufferedWriter.write(stringBuffer.toString());
                    }
                }
                bufferedReader.close();
                inputStreamReader.close();
                file.delete();
                try {
                    fileInputStream.close();
                    for (BufferedWriter bufferedWriter2 : hashMap.values()) {
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.close();
                        }
                    }
                } catch (Throwable e3) {
                    v.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", be.e(e3));
                }
                return true;
            } catch (Exception e4) {
                e3 = e4;
                fileInputStream = null;
                try {
                    v.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", be.e(e3));
                    t.HS().aO(this.cUo, this.aZc);
                    this.cii.a(3, 0, e3.getMessage(), this);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e32) {
                            v.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", be.e(e32));
                            return false;
                        }
                    }
                    for (BufferedWriter bufferedWriter22 : hashMap.values()) {
                        if (bufferedWriter22 != null) {
                            bufferedWriter22.close();
                        }
                    }
                    return false;
                } catch (Throwable e322) {
                    inputStream = fileInputStream;
                    th = e322;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3222) {
                            v.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", be.e(e3222));
                            throw th;
                        }
                    }
                    for (BufferedWriter bufferedWriter222 : hashMap.values()) {
                        if (bufferedWriter222 != null) {
                            bufferedWriter222.close();
                        }
                    }
                    throw th;
                }
            } catch (Throwable e32222) {
                th = e32222;
                if (inputStream != null) {
                    inputStream.close();
                }
                for (BufferedWriter bufferedWriter2222 : hashMap.values()) {
                    if (bufferedWriter2222 != null) {
                        bufferedWriter2222.close();
                    }
                }
                throw th;
            }
        }
        v.e("MicroMsg.NetSceneDownloadPackage", "update regioncode failed, file not exist, packagePath:" + str + " ,packageName:" + str2);
        t.HS().aO(this.cUo, this.aZc);
        this.cii.a(3, 0, "no regioncode file found", this);
        return false;
    }

    public final int getType() {
        return 160;
    }

    public final int BI() {
        return this.aZc;
    }
}
