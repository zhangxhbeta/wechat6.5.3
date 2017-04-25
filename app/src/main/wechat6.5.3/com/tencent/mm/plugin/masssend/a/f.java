package com.tencent.mm.plugin.masssend.a;

import android.content.ContentValues;
import com.tencent.mm.a.g;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahx;
import com.tencent.mm.protocal.c.ahy;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import junit.framework.Assert;

public final class f extends k implements j {
    int aYJ;
    boolean cAv;
    private int cLy;
    a cQT;
    public b cif;
    private e cii;
    int dhM;
    private a hjz;

    public f(a aVar, boolean z) {
        this(aVar, z, 0);
    }

    public f(a aVar, boolean z, int i) {
        int i2 = 1;
        this.hjz = null;
        this.cQT = null;
        this.aYJ = 0;
        this.dhM = 0;
        this.cAv = false;
        this.hjz = aVar;
        this.cLy = i;
        aVar.dhH = be.Ni();
        if (aVar.msgType == 43) {
            aVar.status = UpdateLogConst.ACTION_POP_INSTALL_DIALOG;
            com.tencent.mm.as.k.KV();
            aVar.hju = o.le(o.ld(aVar.ayY()));
            com.tencent.mm.as.k.KV();
            aVar.aPV = o.le(o.lc(aVar.ayY()));
            this.dhM = 2500;
            if (aVar.hjv == 2) {
                this.dhM = 2500;
            }
        } else if (aVar.msgType == 34) {
            this.dhM = 40;
            aVar.status = UpdateLogConst.ACTION_POP_INSTALL_DIALOG;
            aVar.aPV = com.tencent.mm.modelvoice.o.le(aVar.ayY());
            aVar.hju = 0;
        } else if (aVar.msgType == 3) {
            int i3;
            this.dhM = 40;
            if (i == 1) {
                this.dhM = 1250;
                i3 = 1;
            } else {
                i3 = 0;
            }
            aVar.hjw = i3;
            aVar.status = UpdateLogConst.ACTION_POP_INSTALL_DIALOG;
            aVar.hju = 0;
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            aVar.aPV = com.tencent.mm.a.e.aQ(stringBuilder.append(c.wP()).append(aVar.ayY()).toString());
        } else if (aVar.msgType == 1) {
            this.dhM = 1;
            aVar.status = UpdateLogConst.ACTION_POP_INSTALL_DIALOG;
            aVar.aPV = aVar.ayY().getBytes().length;
            aVar.hju = 0;
        } else {
            v.d("MicroMsg.NetSceneMasSend", "error msgtype:" + aVar.msgType);
            Assert.assertTrue("error msgtype:" + aVar.msgType, false);
        }
        b.a aVar2 = new b.a();
        aVar2.czn = new ahx();
        aVar2.czo = new ahy();
        aVar2.uri = "/cgi-bin/micromsg-bin/masssend";
        aVar2.czm = 193;
        aVar2.czp = 84;
        aVar2.czq = 1000000084;
        this.cif = aVar2.Bv();
        ahx com_tencent_mm_protocal_c_ahx = (ahx) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ahx.mHv = g.m(aVar.aza().getBytes());
        com_tencent_mm_protocal_c_ahx.mHF = aVar.hjr;
        com_tencent_mm_protocal_c_ahx.mHu = aVar.aza();
        aVar.dac = be.Ni();
        com_tencent_mm_protocal_c_ahx.mHw = aVar.ayX();
        com_tencent_mm_protocal_c_ahx.gll = aVar.msgType;
        com_tencent_mm_protocal_c_ahx.mHx = aVar.hjs;
        if (!z) {
            i2 = 0;
        }
        com_tencent_mm_protocal_c_ahx.mHG = i2;
        com_tencent_mm_protocal_c_ahx.mzC = i;
        this.cQT = new a();
    }

    public final void cancel() {
        this.cAv = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 2;
        int i2 = 0;
        this.cii = eVar2;
        if (this.cAv) {
            v.d("MicroMsg.NetSceneMasSend", "isCancel");
            this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
            return -1;
        }
        this.dhM--;
        if (this.dhM < 0) {
            v.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
            this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
            return -1;
        } else if (this.hjz == null) {
            v.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
            this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
            return -1;
        } else if (be.kS(this.hjz.aza())) {
            v.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
            this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
            return -1;
        } else if (this.hjz.hjr == 0) {
            v.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
            this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
            return -1;
        } else if (this.hjz.aPV <= 0) {
            v.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
            this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
            return -1;
        } else if (this.hjz.status == 103 && this.hjz.hju <= 0) {
            v.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
            this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
            return -1;
        } else if (this.hjz.status == 103 || this.hjz.status == UpdateLogConst.ACTION_POP_INSTALL_DIALOG) {
            ahx com_tencent_mm_protocal_c_ahx = (ahx) this.cif.czk.czs;
            String ayY;
            if (this.hjz.msgType == 43) {
                int i3;
                ayY = this.hjz.ayY();
                if (be.kS(ayY)) {
                    v.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
                    this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                    i3 = -1;
                } else {
                    com_tencent_mm_protocal_c_ahx.mfq = new are();
                    com_tencent_mm_protocal_c_ahx.mHy = 0;
                    com_tencent_mm_protocal_c_ahx.mHC = new are();
                    com_tencent_mm_protocal_c_ahx.mHB = 0;
                    com_tencent_mm_protocal_c_ahx.mHD = 2;
                    com_tencent_mm_protocal_c_ahx.mHx = this.hjz.hjs;
                    if (this.hjz.hjv <= 0) {
                        i = 0;
                    }
                    com_tencent_mm_protocal_c_ahx.mHE = i;
                    com_tencent_mm_protocal_c_ahx.mHA = this.hjz.hju;
                    com_tencent_mm_protocal_c_ahx.mHz = this.hjz.aPV;
                    o.b e;
                    Object obj;
                    are com_tencent_mm_protocal_c_are;
                    if (this.hjz.status == 103) {
                        com.tencent.mm.as.k.KV();
                        e = o.e(o.ld(ayY), this.hjz.dhF, 8000);
                        if (e.ret < 0 || e.aUT == 0) {
                            v.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + ayY + "]  Error ");
                            this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                            i3 = -1;
                        } else {
                            v.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + ayY + "] read ret:" + e.ret + " readlen:" + e.aUT + " newOff:" + e.dik + " netOff:" + this.hjz.dhF);
                            if (e.dik < this.hjz.dhF) {
                                v.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + ayY + "] newOff:" + e.dik + " OldtOff:" + this.hjz.dhF);
                                this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                                i3 = -1;
                            } else {
                                obj = new byte[e.aUT];
                                System.arraycopy(e.buf, 0, obj, 0, e.aUT);
                                com_tencent_mm_protocal_c_ahx.mHB = this.hjz.dhF;
                                com_tencent_mm_protocal_c_are = new are();
                                com_tencent_mm_protocal_c_are.ba(obj);
                                com_tencent_mm_protocal_c_ahx.mHC = com_tencent_mm_protocal_c_are;
                            }
                        }
                    } else {
                        com.tencent.mm.as.k.KV();
                        e = o.e(o.lc(ayY), this.hjz.hjt, 8000);
                        if (e.ret < 0 || e.aUT == 0) {
                            v.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + ayY + "]  Error ");
                            this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                            i3 = -1;
                        } else {
                            v.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + ayY + "] read ret:" + e.ret + " readlen:" + e.aUT + " newOff:" + e.dik + " netOff:" + this.hjz.hjt);
                            if (e.dik < this.hjz.hjt) {
                                v.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + ayY + "] newOff:" + e.dik + " OldtOff:" + this.hjz.hjt);
                                this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                                i3 = -1;
                            } else if (e.dik >= 20971520) {
                                v.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + ayY + "] maxsize:20971520");
                                this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                                i3 = -1;
                            } else {
                                obj = new byte[e.aUT];
                                System.arraycopy(e.buf, 0, obj, 0, e.aUT);
                                com_tencent_mm_protocal_c_ahx.mHy = this.hjz.hjt;
                                com_tencent_mm_protocal_c_ahx.mHB = this.hjz.dhF;
                                com_tencent_mm_protocal_c_are = new are();
                                com_tencent_mm_protocal_c_are.ba(obj);
                                com_tencent_mm_protocal_c_ahx.mfq = com_tencent_mm_protocal_c_are;
                            }
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    return i3;
                }
            } else if (this.hjz.msgType == 34) {
                com_tencent_mm_protocal_c_ahx.mHD = 0;
                com_tencent_mm_protocal_c_ahx.mHE = 0;
                com_tencent_mm_protocal_c_ahx.mfq = new are().ba(new byte[0]);
                com_tencent_mm_protocal_c_ahx.mHy = 0;
                com_tencent_mm_protocal_c_ahx.mHC = new are().ba(new byte[0]);
                com_tencent_mm_protocal_c_ahx.mHB = 0;
                com_tencent_mm_protocal_c_ahx.mHA = 0;
                com_tencent_mm_protocal_c_ahx.mHz = this.hjz.aPV;
                com.tencent.mm.modelvoice.b lC = q.lC(this.hjz.ayY());
                if (lC == null) {
                    this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                    v.d("MicroMsg.NetSceneMasSend", "fileop is null");
                    i2 = -1;
                } else {
                    com.tencent.mm.modelvoice.g aU = lC.aU(this.hjz.hjt, 8000);
                    if (aU.ret < 0) {
                        v.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.hjz.ayY() + "] read ret:" + aU.ret + " readlen:" + aU.aUT + " newOff:" + aU.dik + " netOff:" + this.hjz.hjt);
                        this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                        i2 = -1;
                    } else if (aU.dik < this.hjz.hjt || aU.dik >= 469000) {
                        v.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.hjz.ayY() + "] read ret:" + aU.ret + " readlen:" + aU.aUT + " newOff:" + aU.dik + " netOff:" + this.hjz.hjt);
                        this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                        i2 = -1;
                    } else if (this.hjz.aPV <= 0) {
                        v.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.hjz.ayY() + "] read totalLen:" + this.hjz.aPV);
                        this.aYJ = com.tencent.mm.compatible.util.g.sk() + 10000;
                        i2 = -1;
                    } else {
                        Object obj2 = new byte[aU.aUT];
                        System.arraycopy(aU.buf, 0, obj2, 0, aU.aUT);
                        com_tencent_mm_protocal_c_ahx.mfq = new are().ba(obj2);
                        com_tencent_mm_protocal_c_ahx.mHx = this.hjz.hjs;
                        com_tencent_mm_protocal_c_ahx.mHy = this.hjz.hjt;
                        com_tencent_mm_protocal_c_ahx.mHH = lC.getFormat();
                    }
                }
                if (i2 != 0) {
                    return -1;
                }
            } else if (this.hjz.msgType == 3) {
                if (be.kS(this.hjz.ayY())) {
                    v.d("MicroMsg.NetSceneMasSend", "getFilename is null");
                    this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                    i2 = -1;
                } else {
                    com_tencent_mm_protocal_c_ahx.mHD = 0;
                    com_tencent_mm_protocal_c_ahx.mHE = 0;
                    com_tencent_mm_protocal_c_ahx.mfq = new are().ba(new byte[0]);
                    com_tencent_mm_protocal_c_ahx.mHy = 0;
                    com_tencent_mm_protocal_c_ahx.mHC = new are().ba(new byte[0]);
                    com_tencent_mm_protocal_c_ahx.mHB = 0;
                    com_tencent_mm_protocal_c_ahx.mHA = 0;
                    com_tencent_mm_protocal_c_ahx.mHx = 0;
                    com_tencent_mm_protocal_c_ahx.mHA = this.hjz.hju;
                    com_tencent_mm_protocal_c_ahx.mHz = this.hjz.aPV;
                    com_tencent_mm_protocal_c_ahx.mzC = this.cLy;
                    StringBuilder stringBuilder = new StringBuilder();
                    ak.yW();
                    ayY = stringBuilder.append(c.wP()).append(this.hjz.ayY()).toString();
                    i = this.hjz.aPV - this.hjz.hjt;
                    if (i > 8000) {
                        i = 8000;
                    }
                    byte[] c = com.tencent.mm.a.e.c(ayY, this.hjz.hjt, i);
                    if (be.bl(c)) {
                        v.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.hjz.ayY() + "]  Error ");
                        this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                        i2 = -1;
                    } else {
                        com_tencent_mm_protocal_c_ahx.mHy = this.hjz.hjt;
                        com_tencent_mm_protocal_c_ahx.mHB = this.hjz.dhF;
                        are com_tencent_mm_protocal_c_are2 = new are();
                        com_tencent_mm_protocal_c_are2.ba(c);
                        com_tencent_mm_protocal_c_ahx.mfq = com_tencent_mm_protocal_c_are2;
                    }
                }
                if (i2 != 0) {
                    return -1;
                }
            } else if (this.hjz.msgType == 1) {
                com_tencent_mm_protocal_c_ahx.mfq = new are().ba(this.hjz.ayY().getBytes());
                com_tencent_mm_protocal_c_ahx.mHz = this.hjz.aPV;
                com_tencent_mm_protocal_c_ahx.mHx = 0;
                com_tencent_mm_protocal_c_ahx.mHy = 0;
                com_tencent_mm_protocal_c_ahx.mHC = new are().ba(new byte[0]);
                com_tencent_mm_protocal_c_ahx.mHB = 0;
                com_tencent_mm_protocal_c_ahx.mHA = 0;
                com_tencent_mm_protocal_c_ahx.mHD = 0;
                com_tencent_mm_protocal_c_ahx.mHE = 0;
            } else {
                v.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.hjz.msgType);
                this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                return -1;
            }
            return a(eVar, this.cif, this);
        } else {
            v.d("MicroMsg.NetSceneMasSend", "msg type :" + this.hjz.msgType);
            this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
            return -1;
        }
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    protected final int ul() {
        return 2500;
    }

    protected final void a(k.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + i2 + " errCode:" + i3);
        if (i2 != 0 || i3 != 0) {
            v.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + i2 + " errCode:" + i3);
            this.aYJ = (0 - com.tencent.mm.compatible.util.g.sk()) - 10000;
            this.cii.a(i2, i3, str, this);
        } else if (this.hjz == null) {
            v.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
            this.aYJ = (0 - com.tencent.mm.compatible.util.g.sk()) - 10000;
            this.cii.a(i2, i3, str, this);
        } else if (this.hjz.status == UpdateLogConst.ACTION_POP_INSTALL_DIALOG || this.hjz.status == 103) {
            ahy com_tencent_mm_protocal_c_ahy = (ahy) this.cif.czl.czs;
            ahx com_tencent_mm_protocal_c_ahx = (ahx) this.cif.czk.czs;
            if (com_tencent_mm_protocal_c_ahx.mHA > 0 && com_tencent_mm_protocal_c_ahx.mHC != null && com_tencent_mm_protocal_c_ahx.mHC.mQw != null && !be.bl(com_tencent_mm_protocal_c_ahx.mHC.mQw.toByteArray()) && com_tencent_mm_protocal_c_ahx.mHB != com_tencent_mm_protocal_c_ahy.mHB - com_tencent_mm_protocal_c_ahx.mHC.mQu) {
                v.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
                this.aYJ = (0 - com.tencent.mm.compatible.util.g.sk()) - 10000;
                this.cii.a(3, -1, "doScene failed", this);
            } else if (com_tencent_mm_protocal_c_ahx.mHz <= 0 || com_tencent_mm_protocal_c_ahx.mfq == null || com_tencent_mm_protocal_c_ahx.mfq.mQw == null || be.bl(com_tencent_mm_protocal_c_ahx.mfq.mQw.toByteArray()) || com_tencent_mm_protocal_c_ahx.mHy == com_tencent_mm_protocal_c_ahy.mHy - com_tencent_mm_protocal_c_ahx.mfq.mQu) {
                this.hjz.dhI = be.Nh();
                int i4 = this.hjz.status;
                if (i4 == 103) {
                    this.hjz.dhF = com_tencent_mm_protocal_c_ahx.mHC.mQu + com_tencent_mm_protocal_c_ahx.mHB;
                    if (this.hjz.dhF >= this.hjz.hju) {
                        this.hjz.status = 199;
                    }
                } else if (i4 == UpdateLogConst.ACTION_POP_INSTALL_DIALOG) {
                    this.hjz.hjt = com_tencent_mm_protocal_c_ahx.mfq.mQu + com_tencent_mm_protocal_c_ahx.mHy;
                    if (this.hjz.hjt >= this.hjz.aPV) {
                        if (this.hjz.hju > 0) {
                            this.hjz.status = 103;
                        } else {
                            this.hjz.status = 199;
                        }
                    }
                } else {
                    v.e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:" + i4);
                    this.aYJ = (0 - com.tencent.mm.compatible.util.g.sk()) - 10000;
                    this.cii.a(3, -1, "doScene failed", this);
                    return;
                }
                if (this.hjz.status == 199) {
                    b azf = h.azf();
                    a aVar = this.hjz;
                    if (aVar != null) {
                        aVar.bkU = -1;
                        ContentValues contentValues = new ContentValues();
                        if ((aVar.bkU & 1) != 0) {
                            contentValues.put("clientid", aVar.ayX());
                        }
                        if ((aVar.bkU & 2) != 0) {
                            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(aVar.status));
                        }
                        if ((aVar.bkU & 4) != 0) {
                            contentValues.put("createtime", Long.valueOf(aVar.dhH));
                        }
                        if ((aVar.bkU & 8) != 0) {
                            contentValues.put("lastmodifytime", Long.valueOf(aVar.dhI));
                        }
                        if ((aVar.bkU & 16) != 0) {
                            contentValues.put("filename", aVar.ayY());
                        }
                        if ((aVar.bkU & 32) != 0) {
                            contentValues.put("thumbfilename", aVar.ayZ());
                        }
                        if ((aVar.bkU & 64) != 0) {
                            contentValues.put("tolist", aVar.aza());
                        }
                        if ((aVar.bkU & 128) != 0) {
                            contentValues.put("tolistcount", Integer.valueOf(aVar.hjr));
                        }
                        if ((aVar.bkU & 256) != 0) {
                            contentValues.put("msgtype", Integer.valueOf(aVar.msgType));
                        }
                        if ((aVar.bkU & 512) != 0) {
                            contentValues.put("mediatime", Integer.valueOf(aVar.hjs));
                        }
                        if ((aVar.bkU & 1024) != 0) {
                            contentValues.put("datanetoffset", Integer.valueOf(aVar.hjt));
                        }
                        if ((aVar.bkU & 2048) != 0) {
                            contentValues.put("datalen", Integer.valueOf(aVar.aPV));
                        }
                        if ((aVar.bkU & 4096) != 0) {
                            contentValues.put("thumbnetoffset", Integer.valueOf(aVar.dhF));
                        }
                        if ((aVar.bkU & 8192) != 0) {
                            contentValues.put("thumbtotallen", Integer.valueOf(aVar.hju));
                        }
                        if ((aVar.bkU & 16384) != 0) {
                            contentValues.put("reserved1", Integer.valueOf(aVar.hjv));
                        }
                        if ((aVar.bkU & 32768) != 0) {
                            contentValues.put("reserved2", Integer.valueOf(aVar.hjw));
                        }
                        if ((aVar.bkU & 65536) != 0) {
                            contentValues.put("reserved3", aVar.cuV == null ? "" : aVar.cuV);
                        }
                        if ((aVar.bkU & 131072) != 0) {
                            contentValues.put("reserved4", aVar.cuW == null ? "" : aVar.cuW);
                        }
                        if (((int) azf.cuX.insert("massendinfo", "clientid", contentValues)) != -1) {
                            ak.yW();
                            Object obj = c.wK().Mh("masssendapp") == null ? 1 : null;
                            ab abVar = new ab();
                            abVar.setUsername("masssendapp");
                            abVar.setContent(b.a(aVar));
                            abVar.s(aVar.dhH);
                            abVar.di(0);
                            abVar.df(0);
                            if (obj != null) {
                                ak.yW();
                                c.wK().d(abVar);
                            } else {
                                ak.yW();
                                c.wK().a(abVar, "masssendapp", true);
                            }
                            azf.Ls();
                        }
                    }
                    v.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:" + (this.cQT != null ? this.cQT.sn() : 0));
                    this.cii.a(i2, i3, str, this);
                } else if (a(this.czE, this.cii) == -1) {
                    this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                    this.cii.a(3, -1, "doScene failed", this);
                }
            } else {
                v.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
                this.aYJ = (0 - com.tencent.mm.compatible.util.g.sk()) - 10000;
                this.cii.a(3, -1, "doScene failed", this);
            }
        } else {
            v.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.hjz.status);
            this.aYJ = (0 - com.tencent.mm.compatible.util.g.sk()) - 10000;
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 193;
    }
}
