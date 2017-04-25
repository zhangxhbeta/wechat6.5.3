package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.k.a.d.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;

final class l {
    private final int aYo;
    private final int aYp;
    private final int aYq;
    private final boolean aYr;
    private final boolean aYu;
    final String filePath;
    final String lCO;
    private final String lCR;
    private final int lCS;
    private final byte[] lCT;
    private final String lCU;
    private final long lCW;
    private final String lCX;
    private final int lCY;
    private final int lCZ;
    volatile String lDU = null;
    volatile String lDV = null;
    final boolean lDu;
    final boolean lDv;
    volatile int state = -1;
    private final String url;

    l(int i, int i2, String str, boolean z, boolean z2, String str2, int i3, boolean z3, boolean z4, byte[] bArr, String str3, String str4, long j, String str5, int i4, int i5, int i6) {
        this.lCO = i.cU(i, i2);
        this.aYo = i;
        this.aYp = i2;
        this.filePath = str;
        this.lDv = z;
        this.lDu = z2;
        this.lCR = str2;
        this.lCS = i3;
        this.lCT = bArr;
        this.lCU = str3;
        this.aYu = z3;
        this.aYr = z4;
        this.lCX = str4;
        this.lCW = j;
        this.url = str5;
        this.lCY = i4;
        this.lCZ = i5;
        this.aYq = i6;
    }

    final l bnV() {
        boolean z;
        Throwable e;
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", this.lCO, bnY(), this.lDU, this.lDV, Boolean.valueOf(be.kS(this.lCR)));
        if (1 == this.state) {
            if (be.kS(this.lCR)) {
                v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", this.lCO);
                this.lDU = null;
                this.state = 8;
                j.q(this.lCW, 54);
                j.q(this.lCW, 45);
            } else {
                try {
                    String str = this.lDU;
                    String str2 = this.lDV;
                    String str3 = this.lCR;
                    File file = new File(str);
                    if (file.exists() && file.isFile()) {
                        file = new File(str2);
                        file.getParentFile().mkdirs();
                        file.delete();
                        byte[] Hk = a.Hk(str);
                        if (be.bl(Hk)) {
                            v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
                            j.q(this.lCW, 56);
                            j.q(this.lCW, 45);
                            j.q(this.lCW, 18);
                            z = false;
                        } else {
                            Hk = MMProtocalJni.aesDecrypt(Hk, str3.getBytes());
                            if (be.bl(Hk)) {
                                v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
                                j.q(this.lCW, 55);
                                j.q(this.lCW, 45);
                                j.q(this.lCW, 18);
                                z = false;
                            } else {
                                z = a.t(str2, Hk);
                                if (!z) {
                                    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
                                    j.q(this.lCW, 57);
                                    j.q(this.lCW, 45);
                                    j.q(this.lCW, 18);
                                }
                            }
                        }
                    } else {
                        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", str);
                        z = false;
                    }
                    try {
                        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", this.lCO, Boolean.valueOf(z));
                    } catch (Exception e2) {
                        e = e2;
                        v.a("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", this.lCO, e);
                        j.q(this.lCW, 45);
                        j.q(this.lCW, 18);
                        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.lCO, Boolean.valueOf(z));
                        if (z) {
                            j.q(this.lCW, 17);
                            this.lDU = this.lDV;
                            if (this.lDu) {
                                this.lDV = this.filePath + ".decompressed";
                                this.state = 2;
                            } else {
                                this.state = 4;
                            }
                        } else {
                            this.lDU = null;
                            this.state = 8;
                        }
                        return this;
                    }
                } catch (Throwable e3) {
                    e = e3;
                    z = false;
                    v.a("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", this.lCO, e);
                    j.q(this.lCW, 45);
                    j.q(this.lCW, 18);
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.lCO, Boolean.valueOf(z));
                    if (z) {
                        j.q(this.lCW, 17);
                        this.lDU = this.lDV;
                        if (this.lDu) {
                            this.state = 4;
                        } else {
                            this.lDV = this.filePath + ".decompressed";
                            this.state = 2;
                        }
                    } else {
                        this.lDU = null;
                        this.state = 8;
                    }
                    return this;
                }
                v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.lCO, Boolean.valueOf(z));
                if (z) {
                    this.lDU = null;
                    this.state = 8;
                } else {
                    j.q(this.lCW, 17);
                    this.lDU = this.lDV;
                    if (this.lDu) {
                        this.lDV = this.filePath + ".decompressed";
                        this.state = 2;
                    } else {
                        this.state = 4;
                    }
                }
            }
        }
        return this;
    }

    final l bnW() {
        Throwable e;
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", this.lCO, bnY(), this.lDU, this.lDV);
        if (2 == this.state) {
            boolean z;
            try {
                String str = this.lDU;
                String str2 = this.lDV;
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    new File(str2).delete();
                    byte[] q = q.q(a.Hk(str));
                    if (be.bl(q)) {
                        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
                        z = false;
                    } else {
                        z = a.t(str2, q);
                    }
                } else {
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", str);
                    z = false;
                }
                try {
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", this.lCO, Boolean.valueOf(z));
                } catch (Exception e2) {
                    e = e2;
                    v.a("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", this.lCO, e);
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.lCO, Boolean.valueOf(z));
                    if (z) {
                        this.lDU = this.lDV;
                        this.state = 4;
                        j.q(this.lCW, 19);
                    } else {
                        this.lDU = null;
                        this.state = 8;
                        j.q(this.lCW, 20);
                        j.q(this.lCW, 46);
                        if (this.lDv) {
                            j.a(this.aYo, this.aYp, this.lCS, this.aYu, true, false, false, this.lCX);
                        } else {
                            j.a(this.aYo, this.aYp, this.url, this.aYq, this.lCY > this.lCZ ? j.a.lDO : j.a.lDM, false, this.aYu, false, this.lCX);
                        }
                    }
                    return this;
                }
            } catch (Throwable e3) {
                e = e3;
                z = false;
                v.a("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", this.lCO, e);
                v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.lCO, Boolean.valueOf(z));
                if (z) {
                    this.lDU = null;
                    this.state = 8;
                    j.q(this.lCW, 20);
                    j.q(this.lCW, 46);
                    if (this.lDv) {
                        if (this.lCY > this.lCZ) {
                        }
                        j.a(this.aYo, this.aYp, this.url, this.aYq, this.lCY > this.lCZ ? j.a.lDO : j.a.lDM, false, this.aYu, false, this.lCX);
                    } else {
                        j.a(this.aYo, this.aYp, this.lCS, this.aYu, true, false, false, this.lCX);
                    }
                } else {
                    this.lDU = this.lDV;
                    this.state = 4;
                    j.q(this.lCW, 19);
                }
                return this;
            }
            v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.lCO, Boolean.valueOf(z));
            if (z) {
                this.lDU = this.lDV;
                this.state = 4;
                j.q(this.lCW, 19);
            } else {
                this.lDU = null;
                this.state = 8;
                j.q(this.lCW, 20);
                j.q(this.lCW, 46);
                if (this.lDv) {
                    j.a(this.aYo, this.aYp, this.lCS, this.aYu, true, false, false, this.lCX);
                } else if (this.lDu && this.aYr) {
                    if (this.lCY > this.lCZ) {
                    }
                    j.a(this.aYo, this.aYp, this.url, this.aYq, this.lCY > this.lCZ ? j.a.lDO : j.a.lDM, false, this.aYu, false, this.lCX);
                }
            }
        } else if (8 == this.state && this.lDv) {
            j.a(this.aYo, this.aYp, this.lCS, this.aYu, false, false, false, this.lCX);
        }
        return this;
    }

    final String bnX() {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + bnY(), this.lCO);
        if (16 == this.state) {
            return this.lDU;
        }
        if (4 != this.state && 32 != this.state) {
            return null;
        }
        String str;
        if (!be.kS(this.lDU)) {
            String str2;
            String str3 = "MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer";
            String str4 = "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s";
            Object[] objArr = new Object[4];
            objArr[0] = this.lCO;
            objArr[1] = bnY();
            objArr[2] = this.lCU;
            if (this.lCT == null) {
                str2 = "null";
            } else {
                str2 = String.valueOf(this.lCT.length);
            }
            objArr[3] = str2;
            v.i(str3, str4, objArr);
            if (be.kS(this.lCU) || !be.ma(g.aX(this.lDU)).equals(this.lCU)) {
                if (this.state == 4) {
                    j.q(this.lCW, 24);
                }
                if (!be.bl(this.lCT) && UtilsJni.doEcdsaSHAVerify(i.lDx, a.Hk(this.lDU), this.lCT) > 0) {
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", this.lCO, bnY());
                    if (this.state == 4) {
                        j.q(this.lCW, 25);
                    }
                    str = this.lDU;
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", this.lCO, str);
                    if (this.state == 4) {
                        return str;
                    }
                    if (be.kS(str) && !this.lDu) {
                        j.q(this.lCW, 58);
                        j.q(this.lCW, 45);
                    }
                    if (be.kS(str)) {
                        if (this.lDv) {
                            j.a(this.aYo, this.aYp, this.lCS, this.aYu, true, true, false, this.lCX);
                            return str;
                        } else if (this.lDu && this.aYr) {
                            j.a(this.aYo, this.aYp, this.url, this.aYq, this.lCY > this.lCZ ? j.a.lDO : j.a.lDM, false, this.aYu, true, this.lCX);
                            return str;
                        }
                    } else if (this.lDv) {
                        j.a(this.aYo, this.aYp, this.lCS, this.aYu, true, true, true, this.lCX);
                        return str;
                    } else if (this.lDu && this.aYr) {
                        j.a(this.aYo, this.aYp, this.url, this.aYq, this.lCY > this.lCZ ? j.a.lDO : j.a.lDM, true, this.aYu, true, this.lCX);
                        return str;
                    }
                } else if (this.state == 4) {
                    j.q(this.lCW, 26);
                }
            } else {
                v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", this.lCO, bnY());
                if (this.state == 4) {
                    j.q(this.lCW, 23);
                }
                str = this.lDU;
                v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", this.lCO, str);
                if (this.state == 4) {
                    return str;
                }
                j.q(this.lCW, 58);
                j.q(this.lCW, 45);
                if (be.kS(str)) {
                    if (this.lDv) {
                        return this.lDu ? str : str;
                    } else {
                        j.a(this.aYo, this.aYp, this.lCS, this.aYu, true, true, true, this.lCX);
                        return str;
                    }
                } else if (this.lDv) {
                    return this.lDu ? str : str;
                } else {
                    j.a(this.aYo, this.aYp, this.lCS, this.aYu, true, true, false, this.lCX);
                    return str;
                }
            }
        }
        str = null;
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", this.lCO, str);
        if (this.state == 4) {
            return str;
        }
        j.q(this.lCW, 58);
        j.q(this.lCW, 45);
        if (be.kS(str)) {
            if (this.lDv) {
                j.a(this.aYo, this.aYp, this.lCS, this.aYu, true, true, false, this.lCX);
                return str;
            } else if (this.lDu) {
            }
        } else if (this.lDv) {
            j.a(this.aYo, this.aYp, this.lCS, this.aYu, true, true, true, this.lCX);
            return str;
        } else if (this.lDu) {
        }
    }

    final String bnY() {
        switch (this.state) {
            case 1:
                return "state_decrypt";
            case 2:
                return "state_decompress";
            case 4:
                return "state_check_sum";
            case 8:
                return "state_file_invalid";
            case 16:
                return "state_file_valid";
            case FileUtils.S_IRGRP /*32*/:
                return "state_pre_verify_check_sum";
            default:
                return this.state;
        }
    }
}
