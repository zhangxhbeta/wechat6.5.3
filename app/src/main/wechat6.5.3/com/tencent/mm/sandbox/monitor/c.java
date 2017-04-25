package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.a.g;
import com.tencent.mm.b.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sandbox.b;
import com.tencent.mm.sandbox.updater.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public abstract class c implements b {
    public static final String nfo = e.cnj;
    public int nfp;
    public int nfq;
    public int nfr;
    public String nfs;
    private boolean nft = false;

    public c(int i, String str, int i2, boolean z) {
        this.nfq = i;
        this.nfs = str;
        this.nfp = i2;
        this.nft = z;
        this.nfr = com.tencent.mm.a.e.aQ(aAF());
        File file = new File(nfo);
        if (!file.exists()) {
            file.mkdirs();
        }
        v.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + aAF() + " packOffset = " + this.nfr);
    }

    public String aAF() {
        return nfo + this.nfs + ".temp";
    }

    public String bsf() {
        return nfo + this.nfs + ".apk";
    }

    public final void deleteTempFile() {
        try {
            v.d("MM.GetUpdatePack", "deleteTempFile");
            File file = new File(aAF());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            v.e("MM.GetUpdatePack", "error in deleteTempFile");
        }
    }

    public static boolean JK(String str) {
        if (com.tencent.mm.a.e.aR(nfo + str + ".temp")) {
            return true;
        }
        return false;
    }

    public static String yO(String str) {
        Exception exception;
        String str2 = nfo + str + ".temp";
        String str3 = nfo + str + ".apk";
        if (com.tencent.mm.a.e.aR(str2) && (a.bc(str2) || str.equalsIgnoreCase(g.aX(str2)))) {
            com.tencent.mm.a.e.h(nfo, str + ".temp", str + ".apk");
            return str3;
        }
        if (com.tencent.mm.a.e.aR(str3)) {
            if (a.bc(str3)) {
                v.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
                return str3;
            }
            com.tencent.mm.plugin.report.service.g gVar;
            Object[] objArr;
            try {
                str2 = com.tencent.mm.b.c.i(new File(str3));
                try {
                    if (be.kS(str2)) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(322, 10, 1, false);
                        com.tencent.mm.plugin.report.service.g.iuh.h(11098, Integer.valueOf(4010));
                    }
                } catch (Exception e) {
                    exception = e;
                    v.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + exception.getMessage());
                    com.tencent.mm.plugin.report.service.g.iuh.a(322, 9, 1, false);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11098, Integer.valueOf(4009), exception.getMessage());
                    v.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", str2);
                    if (be.kS(str2)) {
                        v.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", str2, h.bsq());
                        if (str2.equals(h.bsq())) {
                            v.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                            com.tencent.mm.plugin.report.service.g.iuh.a(322, 11, 1, false);
                            gVar = com.tencent.mm.plugin.report.service.g.iuh;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(4011);
                            objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                            gVar.h(11098, objArr);
                        } else {
                            v.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                            return str3;
                        }
                    } else if (str.equalsIgnoreCase(g.aX(str3))) {
                        v.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                        return str3;
                    }
                    v.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
                    com.tencent.mm.loader.stub.b.deleteFile(str3);
                    return null;
                }
            } catch (Exception e2) {
                exception = e2;
                str2 = null;
                v.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + exception.getMessage());
                com.tencent.mm.plugin.report.service.g.iuh.a(322, 9, 1, false);
                com.tencent.mm.plugin.report.service.g.iuh.h(11098, Integer.valueOf(4009), exception.getMessage());
                v.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", str2);
                if (be.kS(str2)) {
                    v.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", str2, h.bsq());
                    if (str2.equals(h.bsq())) {
                        v.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                        return str3;
                    }
                    v.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                    com.tencent.mm.plugin.report.service.g.iuh.a(322, 11, 1, false);
                    gVar = com.tencent.mm.plugin.report.service.g.iuh;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4011);
                    objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                    gVar.h(11098, objArr);
                } else if (str.equalsIgnoreCase(g.aX(str3))) {
                    v.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                    return str3;
                }
                v.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
                com.tencent.mm.loader.stub.b.deleteFile(str3);
                return null;
            }
            v.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", str2);
            if (be.kS(str2)) {
                v.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", str2, h.bsq());
                if (str2.equals(h.bsq())) {
                    v.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                    return str3;
                }
                v.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                com.tencent.mm.plugin.report.service.g.iuh.a(322, 11, 1, false);
                gVar = com.tencent.mm.plugin.report.service.g.iuh;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4011);
                objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                gVar.h(11098, objArr);
            } else if (str.equalsIgnoreCase(g.aX(str3))) {
                v.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                return str3;
            }
            v.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
            com.tencent.mm.loader.stub.b.deleteFile(str3);
        }
        return null;
    }

    public final boolean bsg() {
        if (!this.nft || ak.isWifi(aa.getContext())) {
            return false;
        }
        return true;
    }
}
