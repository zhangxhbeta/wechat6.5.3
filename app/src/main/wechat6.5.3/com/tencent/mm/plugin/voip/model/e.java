package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.axs;
import com.tencent.mm.protocal.c.bdc;
import com.tencent.mm.protocal.c.beh;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Timer;
import java.util.TimerTask;

public final class e {
    public boolean blA;
    public Context fda;
    public boolean krA;
    public boolean krB;
    public boolean krC;
    public boolean krD;
    public boolean krE;
    public boolean krF;
    public axs krG;
    public int krH;
    public long krI;
    public long krJ;
    public int krK;
    public int krL;
    public boolean krM;
    public boolean krN;
    public boolean krO;
    public int krP;
    int krQ;
    int krR;
    int krS;
    int krT;
    int krU;
    public boolean krV;
    boolean krW;
    int krX;
    boolean krY;
    int krZ;
    public boolean kry;
    public boolean krz;
    int ksa;
    int ksb;
    public v2protocal ksc;
    public p ksd;
    public g kse;
    public o ksf;
    public byte[] ksg;
    public bfj ksh;
    public boolean ksi;
    public boolean ksj;
    public int ksk;
    public int ksl;
    public int ksm;
    public int ksn;
    public ah kso;
    Timer ksp;
    int ksq;
    ah ksr;
    private a kss;
    ac mHandler;
    public int mStatus;

    public interface a {
        void m(int i, int i2, String str);
    }

    protected e() {
        this.mStatus = 1;
        this.kry = false;
        this.krz = false;
        this.krA = false;
        this.krB = false;
        this.blA = false;
        this.krC = false;
        this.krD = false;
        this.krE = false;
        this.krF = false;
        this.krG = new axs();
        this.krH = 0;
        this.krI = 0;
        this.krJ = 0;
        this.krK = 0;
        this.krL = 0;
        this.krM = false;
        this.krN = false;
        this.krO = false;
        this.krP = 10;
        this.krQ = -1;
        this.krR = -1;
        this.krS = -1;
        this.krT = -1;
        this.krU = -1;
        this.krV = false;
        this.krW = false;
        this.krX = 1;
        this.krY = false;
        this.krZ = 1;
        this.ksa = -1;
        this.ksb = -1;
        this.fda = null;
        this.ksd = p.kvn;
        this.ksg = null;
        this.ksh = null;
        this.ksi = false;
        this.ksj = false;
        this.ksk = 0;
        this.ksl = 0;
        this.ksm = 0;
        this.ksn = 0;
        this.kso = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ e kst;

            {
                this.kst = r1;
            }

            public final boolean oU() {
                v.v("MicroMsg.Voip.VoipContext", "voip repeat sync");
                this.kst.ksf.a(null, false, 7);
                return true;
            }
        }, true);
        this.mHandler = new ac(this, Looper.getMainLooper()) {
            final /* synthetic */ e kst;

            public final void handleMessage(Message message) {
                if (message == null || message.what != 59998) {
                    super.handleMessage(message);
                } else if (message.arg1 == 1) {
                    if (this.kst.ksc.gFG == 0) {
                        com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
                        return;
                    }
                    com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
                    r0 = (byte[]) message.obj;
                    o oVar = this.kst.ksf;
                    r2 = message.arg2;
                    bfs com_tencent_mm_protocal_c_bfs = new bfs();
                    com_tencent_mm_protocal_c_bfs.efm = 1;
                    are com_tencent_mm_protocal_c_are = new are();
                    com_tencent_mm_protocal_c_are.ba(r0);
                    com_tencent_mm_protocal_c_bfs.meT = com_tencent_mm_protocal_c_are;
                    are com_tencent_mm_protocal_c_are2 = new are();
                    try {
                        com_tencent_mm_protocal_c_are2.ba(com_tencent_mm_protocal_c_bfs.toByteArray());
                        bfc com_tencent_mm_protocal_c_bfc = new bfc();
                        com_tencent_mm_protocal_c_bfc.bkM = r2;
                        com_tencent_mm_protocal_c_bfc.mnB = com_tencent_mm_protocal_c_are2;
                        com_tencent_mm_protocal_c_bfc.gon = k.xF();
                        bfd com_tencent_mm_protocal_c_bfd = new bfd();
                        com_tencent_mm_protocal_c_bfd.eet = 1;
                        com_tencent_mm_protocal_c_bfd.eeu.add(com_tencent_mm_protocal_c_bfc);
                        oVar.a(com_tencent_mm_protocal_c_bfd, true, 2);
                    } catch (Throwable e) {
                        v.a("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                    }
                } else if (message.arg1 == 4) {
                    if (this.kst.ksc.gFG == 0) {
                        com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
                        return;
                    }
                    com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
                    this.kst.ksc.kxf.ksP = 107;
                    this.kst.m(1, -9004, "");
                } else if (message.arg1 == 6) {
                    com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
                    if (this.kst.ksc.gFG == 0) {
                        com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
                        return;
                    }
                    this.kst.krz = true;
                    this.kst.ksc.kxf.ktf = 1;
                    if (this.kst.krA || this.kst.krB) {
                        this.kst.ksc.kwj = 0;
                    } else {
                        this.kst.ksc.kwj = 1;
                    }
                    this.kst.ksc.setInactive();
                    com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
                    this.kst.bbH();
                } else if (message.arg1 == 3) {
                    this.kst.mStatus = 5;
                } else if (message.arg1 == 5) {
                    com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + message.arg2);
                    if (this.kst.mStatus >= 5) {
                        this.kst.ksc.kxf.ksP = ba.CTRL_INDEX;
                    } else {
                        this.kst.ksc.kxf.ksP = 106;
                    }
                    if (message.arg2 == 4) {
                        this.kst.ksc.kxf.kth = 1;
                        com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "channel broken...");
                    } else if (message.arg2 == 1) {
                        if (this.kst.krE) {
                            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                            this.kst.krD = true;
                            return;
                        }
                        com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "channel connect fail...");
                        this.kst.krz = false;
                        this.kst.ksc.kxf.kth = 5;
                    } else if (message.arg2 == 5) {
                        if (this.kst.krD) {
                            this.kst.ksc.kxf.kth = 6;
                            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "channel network fail while pre-connect...");
                            this.kst.krD = true;
                            return;
                        }
                        com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "channel network fail");
                        this.kst.ksc.kxf.kth = 6;
                    }
                    this.kst.m(1, -9000, "");
                } else if (message.arg1 == 100) {
                    com.tencent.mm.plugin.voip.b.a.a((byte[]) message.obj, "MicroMsg.Voip.VoipContext", message.arg2);
                } else if (message.arg1 == 101) {
                    com.tencent.mm.plugin.voip.b.a.a((byte[]) message.obj, "MicroMsg.v2Core", message.arg2);
                } else if (message.arg1 == 7) {
                    int[] iArr = (int[]) message.obj;
                    int i = message.arg2;
                    String str = null;
                    try {
                        str = ((WifiManager) aa.getContext().getSystemService("wifi")).getConnectionInfo().getSSID();
                    } catch (Exception e2) {
                        com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
                    }
                    String str2 = null;
                    try {
                        str2 = ((TelephonyManager) aa.getContext().getSystemService("phone")).getSimOperatorName();
                    } catch (Exception e3) {
                        com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
                    }
                    new j(this.kst.krJ, this.kst.krI, this.kst.krK, str2, str, this.kst.krL, i, iArr).bcW();
                } else if (message.arg1 == 8) {
                    r0 = (byte[]) message.obj;
                    e eVar = this.kst;
                    try {
                        bdc com_tencent_mm_protocal_c_bdc = (bdc) new bdc().az(r0);
                        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + com_tencent_mm_protocal_c_bdc.mZd);
                        switch (com_tencent_mm_protocal_c_bdc.mZd) {
                            case 3:
                                if (com_tencent_mm_protocal_c_bdc.mZe != null) {
                                    Object obj = com_tencent_mm_protocal_c_bdc.mZe.lVU;
                                    com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "steve: remote new network type:" + obj);
                                    r2 = eVar.ksc.setAppCmd(302, obj, 4);
                                    if (r2 < 0) {
                                        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + obj + "fail:" + r2 + ", [roomid=" + eVar.ksc.gFO + ", roomkey=" + eVar.ksc.gFH + "]");
                                        return;
                                    }
                                    return;
                                }
                                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                                return;
                            case 4:
                                if (com_tencent_mm_protocal_c_bdc.mZe != null) {
                                    bek com_tencent_mm_protocal_c_bek = (bek) new bek().az(com_tencent_mm_protocal_c_bdc.mZe.lVU);
                                    com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + com_tencent_mm_protocal_c_bek.nar);
                                    byte[] bArr = new byte[4];
                                    bArr[0] = (byte) com_tencent_mm_protocal_c_bek.nar;
                                    eVar.ksc.setJNIAppCmd(2, bArr, 4);
                                    return;
                                }
                                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
                                return;
                            default:
                                return;
                        }
                    } catch (Exception e4) {
                        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
                    }
                    com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
                } else if (message.arg1 == 9) {
                    h hVar = this.kst.ksc.kxf;
                    hVar.kts = System.currentTimeMillis();
                    com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.VoipDailReport", "first pkt received timestamp:" + hVar.kts);
                    com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "get first pkt for voip");
                } else if (message.arg1 == 11) {
                    this.kst.ksn = 2;
                } else if (message.arg1 == 12) {
                    this.kst.ksn = 1;
                }
            }
        };
        this.ksp = null;
        this.ksq = 0;
        this.ksr = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ e kst;

            {
                this.kst = r1;
            }

            public final boolean oU() {
                if (this.kst.mStatus == 4) {
                    this.kst.ksc.kxf.ksP = 105;
                    this.kst.m(1, -9000, "");
                }
                return false;
            }
        }, false);
        this.kss = null;
        this.ksc = new v2protocal(this.mHandler);
        this.kse = new g(this);
        this.ksf = new o(this);
        this.ksm = 0;
    }

    public final void bby() {
        int i = 0;
        if (this.kry && this.krH == 0) {
            this.krH = 1;
            if (this.ksc.field_speedTestInfoLength < 8) {
                com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.ksc.field_speedTestInfoLength);
                return;
            }
            int i2 = this.ksc.kxd[1];
            if (i2 + 2 > this.ksc.field_speedTestInfoLength) {
                com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i2 + ", bufsize=" + this.ksc.field_speedTestInfoLength);
                return;
            }
            int i3 = this.ksc.kxd[(i2 + 2) + 1];
            if ((i2 + 6) + i3 != this.ksc.field_speedTestInfoLength) {
                com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i2 + ", C2SRttCnt=" + i3 + ", bufsize=" + this.ksc.field_speedTestInfoLength);
                return;
            }
            this.krI = this.ksc.gFH;
            this.krK = this.ksc.netType;
            this.krL = this.ksc.gFG;
            this.krG.mqS = this.ksc.gFG;
            this.krG.mUW = this.ksc.kvR;
            this.krG.mnk = this.ksc.netType;
            this.krG.mUX = this.kry ? 1 : 0;
            axs com_tencent_mm_protocal_c_axs = this.krG;
            if (this.krz) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            com_tencent_mm_protocal_c_axs.mUY = i2;
            this.krG.mUZ = this.ksc.kxd[0];
            this.krG.mVa = this.ksc.kxd[1];
            int i4 = 2;
            i2 = 0;
            while (i2 < this.krG.mVa) {
                i3 = i4 + 1;
                this.krG.mVb.add(Integer.valueOf(this.ksc.kxd[i4]));
                i2++;
                i4 = i3;
            }
            int i5 = i4 + 1;
            this.krG.mVc = this.ksc.kxd[i4];
            i2 = i5 + 1;
            this.krG.mVd = this.ksc.kxd[i5];
            while (i < this.krG.mVd) {
                i4 = i2 + 1;
                this.krG.mVe.add(Integer.valueOf(this.ksc.kxd[i2]));
                i++;
                i2 = i4;
            }
            i3 = i2 + 1;
            this.krG.mVf = this.ksc.kxd[i2];
            this.krG.mVg = this.ksc.kxd[i3];
            new com.tencent.mm.plugin.voip.model.a.k(this.krG).bcW();
            return;
        }
        com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.kry + " ,mSpeedTestStatus=" + this.krH);
    }

    public final void bbz() {
        if (this.krH != 0) {
            if (this.krH == 1) {
                this.krH = 0;
                this.ksc.kwL = 0;
                return;
            }
            this.krH = 0;
            v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.ksc;
            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
            com_tencent_mm_plugin_voip_model_v2protocal.StopSpeedTest();
            com_tencent_mm_plugin_voip_model_v2protocal.kwL = 0;
        }
    }

    public final void rA(int i) {
        this.ksc.kvT = Math.abs(i);
    }

    public final void bbA() {
        this.ksc.kvU = this.kse.bbO();
        this.ksc.kvV = this.kse.bbt();
    }

    public final void rB(int i) {
        this.ksc.kvW = Math.abs(i);
    }

    public final void shutdown() {
        bbM();
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ e kst;

            {
                this.kst = r1;
            }

            public final void run() {
                if (this.kst.ksd != null) {
                    this.kst.ksd.bcj();
                }
            }
        });
    }

    public final void dh(int i) {
        if (i != this.mStatus) {
            if (i == 4) {
                this.ksr.ea(60000);
            }
            this.mStatus = i;
        }
    }

    public final int bbB() {
        if (this.mStatus == 1) {
            return 0;
        }
        if (this.mStatus == 2 || this.mStatus == 3) {
            return 1;
        }
        if (this.mStatus != 4) {
            return 3;
        }
        return 2;
    }

    public final boolean bbC() {
        if (this.mStatus == 3) {
            return true;
        }
        return false;
    }

    public final boolean bbD() {
        v.d("MicroMsg.Voip.VoipContext", "isWorking, status: %d", new Object[]{Integer.valueOf(this.mStatus)});
        if (this.mStatus == 1) {
            return false;
        }
        return true;
    }

    public final void rC(int i) {
        if (8 == i || 9 == i) {
            this.krT = i;
        } else {
            this.krQ = i;
            this.krR = i;
        }
        o oVar = this.ksf;
        byte[] rS = com.tencent.mm.plugin.voip.b.a.rS(i);
        are com_tencent_mm_protocal_c_are = new are();
        com_tencent_mm_protocal_c_are.ba(rS);
        are com_tencent_mm_protocal_c_are2 = new are();
        try {
            com_tencent_mm_protocal_c_are2.ba(com_tencent_mm_protocal_c_are.toByteArray());
            bfc com_tencent_mm_protocal_c_bfc = new bfc();
            com_tencent_mm_protocal_c_bfc.bkM = 3;
            com_tencent_mm_protocal_c_bfc.mnB = com_tencent_mm_protocal_c_are2;
            com_tencent_mm_protocal_c_bfc.gon = k.xF();
            bfd com_tencent_mm_protocal_c_bfd = new bfd();
            com_tencent_mm_protocal_c_bfd.eet = 1;
            com_tencent_mm_protocal_c_bfd.eeu.add(com_tencent_mm_protocal_c_bfc);
            oVar.a(com_tencent_mm_protocal_c_bfd, false, 4);
        } catch (Throwable e) {
            v.a("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
        }
    }

    public final boolean bbE() {
        if (this.krO || this.ksc.netType == 1) {
            return false;
        }
        switch (this.krQ) {
            case -1:
                return true;
            case 0:
                if (4 != this.krR) {
                    return false;
                }
                break;
            case 1:
            case 2:
            case 3:
                return false;
            case 4:
                if (!(4 == this.krR || -1 == this.krR)) {
                    return false;
                }
            case 5:
            case 6:
            case 7:
                if (5 == this.krR || 6 == this.krR) {
                    return false;
                }
                if (7 == this.krR) {
                    return false;
                }
                break;
        }
        return true;
    }

    public final boolean bbF() {
        if (this.krO) {
            return false;
        }
        switch (this.krQ) {
            case -1:
                return true;
            case 0:
                if (4 != this.krR) {
                    return false;
                }
                break;
            case 1:
            case 2:
            case 3:
                return false;
            case 4:
                if (!(4 == this.krS || this.krS == 0 || -1 == this.krS)) {
                    return false;
                }
            case 5:
            case 6:
            case 7:
                if (5 == this.krS || 6 == this.krS) {
                    return false;
                }
                if (7 == this.krS) {
                    return false;
                }
                break;
        }
        return true;
    }

    private void bbG() {
        com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "DeviceInfo.mAudioInfo.aecMode:" + p.ceB.cca);
        if (p.ceB.cbD == 1) {
            this.ksc.nl(410);
        }
        byte[] bArr = new byte[2];
        if (p.ceB.cca >= 0) {
            bArr[0] = (byte) p.ceB.cca;
            this.ksc.setAppCmd(406, bArr, 1);
        } else if (p.ceB.cca == -2) {
            this.ksc.nl(407);
        }
        if (p.ceB.ccb >= 0) {
            bArr[0] = (byte) p.ceB.ccb;
            this.ksc.setAppCmd(408, bArr, 1);
        } else if (p.ceB.ccb == -2) {
            this.ksc.nl(409);
        }
        if (p.ceB.ccd >= 0) {
            byte[] bArr2 = new byte[5];
            if (p.ceB.cce >= 0 && p.ceB.ccf >= 0) {
                bArr2[0] = (byte) p.ceB.cce;
                bArr2[1] = (byte) p.ceB.ccf;
                if (p.ceB.ccg >= 0) {
                    bArr2[2] = (byte) p.ceB.ccg;
                    bArr2[3] = (byte) p.ceB.ccd;
                    bArr2[4] = (byte) p.ceB.cch;
                    this.ksc.setAppCmd(404, bArr2, 5);
                } else {
                    this.ksc.setAppCmd(404, bArr2, 2);
                }
            }
        } else if (p.ceB.ccd == -2) {
            this.ksc.nl(405);
        }
        if (p.ceB.cbE >= 0 || p.ceB.cbG >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (p.ceB.cbE >= 0) {
                bArr[0] = (byte) p.ceB.cbE;
            }
            if (p.ceB.cbG >= 0) {
                bArr[1] = (byte) p.ceB.cbG;
            }
            this.ksc.setAppCmd(414, bArr, 2);
        }
        if (p.ceB.cbF >= 0 || p.ceB.cbH >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (p.ceB.cbF >= 0) {
                bArr[0] = (byte) p.ceB.cbF;
            }
            if (p.ceB.cbH >= 0) {
                bArr[1] = (byte) p.ceB.cbH;
            }
            this.ksc.setAppCmd(415, bArr, 2);
        }
        if (p.ceB.cbI >= 0 || p.ceB.cbJ >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (p.ceB.cbI >= 0) {
                bArr[0] = (byte) p.ceB.cbI;
            }
            if (p.ceB.cbJ >= 0) {
                bArr[1] = (byte) p.ceB.cbJ;
            }
            this.ksc.setAppCmd(422, bArr, 2);
        }
        if (p.ceB.cbK >= 0) {
            bArr[0] = (byte) p.ceB.cbK;
            this.ksc.setAppCmd(416, bArr, 1);
        }
        if (p.ceB.cbL >= 0 && !(this.ksc.kwq == 0 && p.ceB.cbL == 5)) {
            bArr[0] = (byte) p.ceB.cbL;
            this.ksc.setAppCmd(417, bArr, 1);
        }
        if (p.ceB.cbM >= 0 && !(this.ksc.kwq == 0 && p.ceB.cbM == 5)) {
            bArr[0] = (byte) p.ceB.cbM;
            this.ksc.setAppCmd(418, bArr, 1);
        }
        if (p.ceB.cbN >= 0) {
            bArr[0] = (byte) p.ceB.cbN;
            this.ksc.setAppCmd(419, bArr, 1);
        }
        if (this.ksc.kwq == 1 && (p.ceB.cbL == 5 || p.ceB.cbM == 5)) {
            this.ksc.kwe = 5;
        }
        if (1 == p.ceB.cck) {
            byte[] bArr3 = new byte[30];
            for (int i = 0; i < 15; i++) {
                bArr3[i * 2] = (byte) (p.ceB.ccl[i] & 255);
                bArr3[(i * 2) + 1] = (byte) ((p.ceB.ccl[i] >> 8) & 255);
            }
            this.ksc.setAppCmd(420, bArr3, 30);
        }
        if (p.ceB.cck == 0) {
            this.ksc.nl(421);
        }
        if (p.ceB.ccm[0] > (short) 0 || p.ceB.ccm[1] > (short) 0) {
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            if (p.ceB.ccm[0] > (short) 0 && p.ceB.ccm[0] < (short) 10000) {
                bArr[0] = (byte) p.ceB.ccm[0];
            }
            if (p.ceB.ccm[1] > (short) 0 && p.ceB.ccm[1] < (short) 10000) {
                bArr[1] = (byte) p.ceB.ccm[1];
            }
            this.ksc.setAppCmd(423, bArr, 2);
        }
        if (p.ceB.cco > 0) {
            bArr[0] = (byte) p.ceB.cco;
            this.ksc.setAppCmd(424, bArr, 1);
        }
        if (p.ceB.ccw >= 0) {
            this.ksc.setAppCmd(426, new byte[]{(byte) p.ceB.ccw, (byte) p.ceB.ccx, (byte) p.ceB.ccy, (byte) p.ceB.ccz}, 4);
        }
    }

    public final void bbH() {
        com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
        if (this.krC && this.krz) {
            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
            this.ksc.setActive();
            if (this.krF) {
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.krF);
                return;
            }
            if (this.ksc.startEngine() == 0) {
                this.ksc.kxf.ktp = 0;
            } else {
                this.krF = false;
                this.ksc.kxf.ktp = 1;
            }
            bbG();
            if (!bbE() && !bbF()) {
                bbK();
            } else if (this.ksp != null) {
                bbK();
            } else {
                this.ksp = new Timer();
                this.ksq = 0;
                this.ksp.schedule(new TimerTask(this) {
                    final /* synthetic */ e kst;

                    {
                        this.kst = r1;
                    }

                    public final void run() {
                        e eVar = this.kst;
                        eVar.ksq++;
                        if (this.kst.ksc.kwR != 0 || this.kst.ksq > 10) {
                            this.kst.bbK();
                            this.kst.ksp.cancel();
                            this.kst.ksp = null;
                        }
                    }
                }, 200, 200);
            }
            this.ksd.bcl();
            g gVar = this.kse;
            if (gVar.ksy == 2) {
                com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
            } else {
                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipDeviceHandler", "start device......");
                gVar.ksy = 2;
                if (gVar.ksM != null) {
                    com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
                    gVar.ksM.ksO = true;
                    com.tencent.mm.sdk.i.e.remove(gVar.ksM);
                    gVar.ksM = null;
                }
                gVar.ksM = new b(gVar);
                com.tencent.mm.sdk.i.e.a(gVar.ksM, "VoipDeviceHandler_decode");
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
                p.ceB.dump();
                gVar.ksw = new b();
                gVar.ksw.L(v2protocal.hyT, 20, 0);
                gVar.ksz = gVar.ksw.i(gVar.kqI.fda, true);
                byte[] bArr = new byte[1];
                bArr[0] = (byte) (gVar.ksw.kqH ? 1 : 0);
                gVar.kqI.ksc.setAppCmd(502, bArr, 1);
                if (gVar.ksz <= 10) {
                    if (gVar.ksz <= 0) {
                        gVar.ksJ = 1;
                    }
                    gVar.ksz = 92;
                }
                gVar.ksw.kqQ = new a(gVar) {
                    final /* synthetic */ g ksN;

                    {
                        this.ksN = r1;
                    }

                    public final int x(byte[] bArr, int i) {
                        if (this.ksN.ksy != 2) {
                            return -1;
                        }
                        int playCallback = this.ksN.kqI.ksc.playCallback(bArr, i);
                        if (playCallback < 0) {
                            com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipDeviceHandler", com.tencent.mm.compatible.util.g.sm() + "protocal.playcallback ret:" + playCallback);
                            return -1;
                        }
                        g.ksK++;
                        return 0;
                    }
                };
                if (gVar.ksw.bbq() <= 0) {
                    gVar.ksJ = 1;
                }
                synchronized (gVar.ksI) {
                    com.tencent.mm.sdk.i.e.b(new Runnable(gVar) {
                        final /* synthetic */ g ksN;

                        {
                            this.ksN = r1;
                        }

                        public final void run() {
                            try {
                                g.k(this.ksN);
                            } catch (Exception e) {
                                v.e("MicroMsg.Voip.VoipDeviceHandler", "start record error: %s", new Object[]{e.getMessage()});
                                this.ksN.ksJ = 1;
                                this.ksN.kqI.rA(this.ksN.ksJ);
                            }
                        }
                    }, "voip_start_record", 10);
                }
            }
            h hVar = this.ksc.kxf;
            if (hVar.beginTime == 0) {
                hVar.kti = 0;
            } else {
                hVar.kti = (int) (System.currentTimeMillis() - hVar.beginTime);
            }
            com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.VoipDailReport", "devin:beginTime:" + hVar.beginTime + ", CurrentTime: " + System.currentTimeMillis());
            com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.VoipDailReport", "devin:endNewDial:" + hVar.kti);
            this.ksd.onConnected();
            this.mStatus = 5;
            hVar = this.ksc.kxf;
            hVar.ktq = System.currentTimeMillis();
            com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.VoipDailReport", "devin:beginTalk:" + hVar.ktq);
            this.ksc.setSvrConfig(202, this.ksc.kwk, this.ksc.kwl, 0, 0, 0, 0);
            this.ksc.setSvrConfig(203, 0, 0, this.ksc.kwp, 0, 0, 0);
            this.ksc.setSvrConfig(103, this.ksc.kwm, this.ksc.kwn, this.ksc.kwo, 0, 0, 0);
            int i = (this.ksc.kwr >> 2) & 3;
            int i2 = this.ksc.kwr & 3;
            int i3 = this.ksc.gFO == 0 ? (i << 2) + i2 : (i2 << 2) + i;
            this.ksc.setSvrConfig(502, 0, 0, i3, 0, 0, 0);
            this.ksc.setSvrConfig(503, 0, 0, this.ksc.kws, this.ksc.kwt, this.ksc.kwu, this.ksc.kwv);
            if (!(this.ksc.kwH == null || this.ksc.kwI == null)) {
                this.ksc.setSvrConfig(504, 0, 0, this.ksc.kwG, 0, 0, 0);
                this.ksc.setSvrConfig(505, 0, 0, this.ksc.kwH[0], this.ksc.kwH[1], this.ksc.kwH[2], this.ksc.kwH[3]);
                this.ksc.setSvrConfig(506, 0, 0, this.ksc.kwI[0], this.ksc.kwI[1], 0, 0);
                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.ksc.kwG + ",FECKeyPara1 = " + this.ksc.kwH[0] + "," + this.ksc.kwH[1] + "," + this.ksc.kwH[2] + "," + this.ksc.kwH[3] + ",FECKeyPara2 = " + this.ksc.kwI[0] + "," + this.ksc.kwI[1]);
            }
            this.ksc.setSvrConfig(507, 0, 0, (this.ksc.kww & 4) >> 2, (this.ksc.kww & 2) >> 1, this.ksc.kww & 1, 0);
            com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.ksc.kwk + ",audioTsdEdge = " + this.ksc.kwl + ",passthroughQosAlgorithm = " + this.ksc.kwm + ",fastPlayRepair = " + this.ksc.kwn + ", audioDTX = " + this.ksc.kwp + ", mARQFlag = " + i3 + ", mQosStrategy = " + this.ksc.kww + ", mSvrCfgListV = " + this.ksc.kwo);
            byte[] bArr2 = new byte[]{(byte) p.ceA.cdc, (byte) -1};
            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + bArr2[0]);
            this.ksc.setAppCmd(15, bArr2, 1);
            this.krF = true;
            return;
        }
        com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.krC + ", isChannelConnectedSuccess " + this.krz);
    }

    public final boolean bbI() {
        boolean bbE = bbE();
        int i = 0;
        if (bbE) {
            i = 1;
        }
        if (this.ksa == -1 || this.ksa != i) {
            this.ksa = i;
            if (bbE) {
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
                this.ksc.nl(203);
            } else {
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
                this.ksc.nl(202);
            }
        }
        return bbE;
    }

    public final boolean bbJ() {
        boolean bbF = bbF();
        int i = 0;
        if (bbF) {
            i = 1;
        }
        if (this.ksb == -1 || this.ksb != i) {
            this.ksb = i;
            if (bbF) {
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
                this.ksc.nl(201);
            } else {
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
                this.ksc.nl(200);
            }
        }
        return bbF;
    }

    final void bbK() {
        if (this.mStatus == 5) {
            dh(6);
            h hVar = this.ksc.kxf;
            if (hVar.beginTime == 0) {
                hVar.ksS = 0;
            } else {
                hVar.ksS = (int) (System.currentTimeMillis() - hVar.beginTime);
            }
            com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.VoipDailReport", "devin:beginTime:" + hVar.beginTime + ", CurrentTime: " + System.currentTimeMillis());
            com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.VoipDailReport", "devin:endDial:" + hVar.ksS);
            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "talking  now .......!");
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ e kst;

                {
                    this.kst = r1;
                }

                public final void run() {
                    this.kst.ksd.bci();
                }
            });
        }
    }

    public final void bbL() {
        this.ksc.kxf.ktb = 7;
        if (be.bl(this.ksc.kvJ) || !(this.mStatus == 4 || ((this.mStatus == 2 && this.krE) || (this.mStatus == 3 && this.krE)))) {
            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "channel:try start connect fail; mStatus:" + this.mStatus + ", isPreConnect:" + this.krE);
            return;
        }
        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel");
        int i = ((((this.ksc.kwr >> 2) & 3) >> 1) & 1) & (((this.ksc.kwr & 3) >> 1) & 1);
        int configConnect = this.ksc.setConfigConnect(this.ksc.kvH, (long) this.ksc.gFG, this.ksc.gFO, this.ksc.gFH, this.ksc.kvJ, this.ksc.channelStrategy, this.ksc.kvO, this.ksc.kvP, this.ksc.kvM, this.ksc.kvN.length, this.ksc.kvN, this.ksc.kvQ, i, this.ksc.kvG, this.ksc.kwB, this.ksc.kwC);
        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "zhengxue[Logic], mARQFlag: " + i + ",  NetType: " + this.ksc.kvG + ", EncryptStrategy: " + this.ksc.kwB);
        if (configConnect < 0) {
            com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipContext", "v2protocal setConfigConnect failed, ret:" + configConnect);
            this.ksc.kxf.ksP = 14;
            m(1, -9002, "");
            return;
        }
        this.ksc.kvJ = null;
        this.kry = true;
        this.ksc.kxf.ksW = (byte) 1;
        this.ksc.kxf.kte = 1;
    }

    public final void aH(byte[] bArr) {
        v.d("MicroMsg.Voip.VoipContext", "updateRemotePid");
        this.ksc.kxf.ksU = (byte) 1;
        this.ksc.kxf.ksT = (byte) 1;
        this.ksc.kvJ = bArr;
    }

    public final void d(int i, byte[] bArr, byte[] bArr2) {
        this.ksc.kwG = i;
        this.ksc.kwH = bArr;
        this.ksc.kwI = bArr2;
    }

    public final void a(byte[] bArr, int i, int i2, byte[] bArr2) {
        this.ksc.kvM = i;
        this.ksc.kvN = bArr;
        this.ksc.kwB = i2;
        this.ksc.kwC = bArr2;
    }

    public final void a(beh com_tencent_mm_protocal_c_beh, beh com_tencent_mm_protocal_c_beh2, beh com_tencent_mm_protocal_c_beh3) {
        this.ksc.c(com_tencent_mm_protocal_c_beh, com_tencent_mm_protocal_c_beh2, com_tencent_mm_protocal_c_beh3);
    }

    public final void g(int i, int i2, int i3, int i4, int i5) {
        this.ksc.kwr = i;
        this.ksc.kws = i2;
        this.ksc.kwt = i3;
        this.ksc.kwu = i4;
        this.ksc.kwv = i5;
    }

    public final void rD(int i) {
        this.ksc.kww = i;
    }

    public final void aI(byte[] bArr) {
        v.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", new Object[]{Byte.valueOf(this.ksc.kxf.ksY)});
        if (this.ksc.kxf.ksY != (byte) 1) {
            this.ksc.kxf.ksY = (byte) 1;
            this.ksc.kvK = bArr;
            int exchangeCabInfo = this.ksc.exchangeCabInfo(this.ksc.kvK, this.ksc.kvK.length);
            if (exchangeCabInfo < 0) {
                com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:" + exchangeCabInfo);
                this.ksc.kxf.ksP = 15;
                m(1, -9003, "");
            }
        }
    }

    public final void rE(int i) {
        this.ksc.kxf.ksV = (byte) 1;
        this.ksc.channelStrategy = i;
    }

    public final void rF(int i) {
        this.ksc.kvQ = i;
    }

    public final void bbM() {
        v.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
        this.kso.QI();
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.kss = aVar;
        }
    }

    public final void m(int i, int i2, String str) {
        bbM();
        if (this.kss != null) {
            this.kss.m(i, i2, str);
        }
    }
}
