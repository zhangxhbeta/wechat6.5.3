package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.d.l;
import com.tencent.mm.plugin.ipcall.a.f.c;
import com.tencent.mm.plugin.ipcall.a.f.d;
import com.tencent.mm.plugin.ipcall.a.f.e;
import com.tencent.mm.plugin.ipcall.a.f.f;
import com.tencent.mm.plugin.ipcall.a.f.h;
import com.tencent.mm.plugin.ipcall.a.f.i;
import com.tencent.mm.protocal.c.ant;
import com.tencent.mm.protocal.c.anu;
import com.tencent.mm.protocal.c.anw;
import com.tencent.mm.protocal.c.aoc;
import com.tencent.mm.protocal.c.aod;
import com.tencent.mm.protocal.c.beh;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Iterator;

public final class g implements com.tencent.mm.plugin.ipcall.a.a.a.a, com.tencent.mm.plugin.ipcall.a.a.b.a {
    public boolean bhY = false;
    public boolean blA = false;
    public int gEM = 0;
    public int gEN = 0;
    public int gEO = 0;
    public boolean gEP = false;
    public boolean gEQ = false;
    public a gER;
    public d gES = new d();
    i gET = new i();
    com.tencent.mm.plugin.ipcall.a.f.a gEU = new com.tencent.mm.plugin.ipcall.a.f.a();
    h gEV = new h();
    c gEW = new c();
    public e gEX = new e();
    com.tencent.mm.plugin.ipcall.a.f.g gEY = new com.tencent.mm.plugin.ipcall.a.f.g();
    f gEZ = new f();
    public com.tencent.mm.plugin.ipcall.a.a.c gFa;
    public boolean gFb = false;
    public boolean gFc = false;
    m gFd = new com.tencent.mm.network.m.a(this) {
        final /* synthetic */ g gFe;

        {
            this.gFe = r1;
        }

        public final void cI(int i) {
            int i2 = 0;
            v.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", new Object[]{Integer.valueOf(i)});
            if (i.aun().gGR) {
                f auq = i.auq();
                if (auq.gEK == 4 || auq.gEK == 5) {
                    i2 = 1;
                }
                if (i2 != 0 && i == 4 && this.gFe.gEZ != null) {
                    this.gFe.gEZ.a(this.gFe.gFa);
                }
            }
        }
    };

    public interface a {
        void aB(String str, int i);

        void aC(String str, int i);

        void aD(String str, int i);

        void atK();

        void atL();

        void atM();

        void atN();

        void atO();

        void e(String str, String str2, int i, int i2);

        void r(String str, String str2, int i);

        void s(String str, String str2, int i);

        void t(String str, String str2, int i);

        void u(String str, String str2, int i);
    }

    public final void auk() {
        if (this.gFa.gGk) {
            v.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
        }
        this.gEP = true;
        v.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(this.gFa.gFG), Integer.valueOf(this.gFa.gFJ)});
        this.gEW.stop();
        this.gET.stop();
        this.gEU.a(this.gFa);
        this.gEY.a(this.gFa);
    }

    public final void lW(int i) {
        if (!this.gFa.gGk) {
            v.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
        }
        v.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(this.gFa.gFG), Integer.valueOf(this.gFa.gFJ)});
        this.gEQ = true;
        this.gEW.stop();
        this.gET.stop();
        this.gEV.gIw = false;
        this.gEV.gIv = i;
        this.gEV.a(this.gFa);
        this.gEY.a(this.gFa);
    }

    private void dz(boolean z) {
        v.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.gEP), Boolean.valueOf(this.gEQ)});
        if (this.gEP || this.gEQ) {
            v.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
        } else if (z) {
            if (this.gER != null) {
                if (this.gFa.gFW) {
                    this.gER.atK();
                } else {
                    this.gER.e(this.gFa.gFN, this.gFa.fvD, this.gFa.gFM, this.gFa.gFS);
                }
            }
            v.i("MicroMsg.IPCallSvrLogic", "start sync");
            this.gET.a(this.gFa);
        } else if (this.gER == null) {
        } else {
            if (this.gFa.gFT) {
                this.gER.s(this.gFa.gFN, this.gFa.fvD, this.gFa.gFM);
            } else if (this.gFa.gFU) {
                this.gER.t(this.gFa.gFN, this.gFa.fvD, this.gFa.gFM);
            } else if (this.gFa.gFV) {
                this.gER.u(this.gFa.gFN, this.gFa.fvD, this.gFa.gFM);
            } else if (this.gFa.gFW) {
                this.gER.r(this.gFa.gFN, this.gFa.fvD, this.gFa.gFM);
            } else {
                this.gER.e(this.gFa.gFN, this.gFa.fvD, this.gFa.gFM, this.gFa.gFS);
            }
        }
    }

    private void dA(boolean z) {
        v.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.gEM = 0;
            return;
        }
        this.gEM++;
        if (this.gEM >= 2) {
            v.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
            this.gEW.stop();
            if (i.auq().auj() && this.gER != null) {
                this.gER.atO();
            }
        }
    }

    private void h(boolean z, int i) {
        v.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", new Object[]{Boolean.valueOf(z)});
        if (!z && i < 0 && this.gEO <= 0) {
            this.gEO++;
            v.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", new Object[]{Integer.valueOf(this.gEO)});
            this.gEU.a(this.gFa);
        }
    }

    private void i(boolean z, int i) {
        v.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.gEV.gIw)});
        if (!z && i < 0 && this.gEN <= 0) {
            this.gEN++;
            v.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", new Object[]{Integer.valueOf(this.gEN), Boolean.valueOf(this.gEV.gIw)});
            this.gEV.a(this.gFa);
        }
    }

    private void dB(boolean z) {
        int i = 1;
        v.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", new Object[]{Boolean.valueOf(z)});
        if (z && i.aun().gGR) {
            i.aun().lY(this.gFa.gGc);
        }
        if (!z) {
            v.e("MicroMsg.IPCallSvrLogic", "sync failed!");
            this.gET.stop();
            if (i.auq().gEK != 3) {
                i = 0;
            }
            if (i != 0 && this.gER != null) {
                this.gER.aD(this.gFa.fvD, this.gFa.gFM);
            }
        } else if (this.gFa != null && z) {
            lX(this.gFa.auC());
        }
    }

    private void dC(boolean z) {
        v.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", new Object[]{Boolean.valueOf(z)});
        if (z && i.aun().gGR) {
            i.aun().lY(this.gFa.gGc);
        }
        if (this.gFa != null && z) {
            int auC = this.gFa.auC();
            if (auC == 2 || auC == 1) {
                if (this.gFc) {
                    v.i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
                    return;
                } else {
                    ak.vy().a(new l(this.gFa.gFG, this.gFa.gFH, this.gFa.auB(), this.gFa.gFI, false), 0);
                }
            }
            lX(this.gFa.auC());
        }
    }

    public final boolean lX(int i) {
        switch (i) {
            case 1:
                v.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
                if (this.gFb) {
                    return true;
                }
                this.gFb = true;
                if (this.gER == null) {
                    return true;
                }
                this.gER.atL();
                return true;
            case 2:
                v.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[]{Boolean.valueOf(this.gEP), Boolean.valueOf(this.gEQ)});
                if (this.gEP || this.gEQ) {
                    return true;
                }
                this.gET.stop();
                if (this.blA) {
                    return true;
                }
                this.blA = true;
                this.gFa.gGk = true;
                if (this.gER != null) {
                    this.gER.atM();
                }
                this.gEW.a(this.gFa);
                return true;
            case 3:
                v.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
                this.gET.stop();
                this.gEW.stop();
                if (this.gER == null) {
                    return true;
                }
                this.gER.aC(this.gFa.fvD, this.gFa.gFM);
                return true;
            case 4:
            case 7:
            case 8:
                v.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
                if (this.gFa.gFV) {
                    if (this.gER == null) {
                        return true;
                    }
                    this.gER.u(this.gFa.gFN, this.gFa.fvD, this.gFa.gFM);
                    return true;
                } else if (this.gER == null) {
                    return true;
                } else {
                    this.gER.aB(this.gFa.fvD, this.gFa.gFM);
                    return true;
                }
            case 5:
                v.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
                if (this.gER == null) {
                    return true;
                }
                this.gER.atN();
                return true;
            case 6:
                v.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
                this.gFa.gFT = true;
                if (this.gER == null) {
                    return true;
                }
                this.gER.s(this.gFa.gFN, this.gFa.fvD, this.gFa.gFM);
                return true;
            default:
                v.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", new Object[]{Integer.valueOf(i)});
                return false;
        }
    }

    private void dD(boolean z) {
        beh com_tencent_mm_protocal_c_beh = null;
        v.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            beh com_tencent_mm_protocal_c_beh2;
            com.tencent.mm.plugin.ipcall.a.c.a aun = i.aun();
            com.tencent.mm.plugin.ipcall.a.a.c cVar = this.gFa;
            v.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
            if (cVar == null || cVar.emi == null || cVar.emi.size() <= 0) {
                com_tencent_mm_protocal_c_beh2 = null;
            } else {
                com_tencent_mm_protocal_c_beh2 = com.tencent.mm.plugin.ipcall.b.c.O(cVar.emi);
            }
            if (!(cVar == null || cVar.gGf == null || cVar.gGf.size() <= 0)) {
                com_tencent_mm_protocal_c_beh = com.tencent.mm.plugin.ipcall.b.c.O(cVar.gGf);
            }
            aun.gGO.b(com_tencent_mm_protocal_c_beh2, com_tencent_mm_protocal_c_beh2, com_tencent_mm_protocal_c_beh);
        }
    }

    public final void a(int i, Object obj, int i2, int i3) {
        if (c(i, obj, i2, i3)) {
            v.i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
            return;
        }
        switch (i) {
            case 1:
                dz(true);
                return;
            case 3:
                h(true, i3);
                return;
            case 4:
                i(true, i3);
                return;
            case 6:
                dD(true);
                return;
            case 8:
                dC(true);
                return;
            default:
                return;
        }
    }

    public final void b(int i, Object obj, int i2, int i3) {
        if (c(i, obj, i2, i3)) {
            v.i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
            return;
        }
        switch (i) {
            case 1:
                dz(false);
                return;
            case 3:
                h(false, i3);
                return;
            case 4:
                i(false, i3);
                return;
            case 6:
                dD(false);
                return;
            case 8:
                dC(false);
                return;
            default:
                return;
        }
    }

    public final void a(int i, k kVar, int i2, int i3) {
        if (c(i, kVar, i2, i3)) {
            v.i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
            return;
        }
        switch (i) {
            case 2:
                dB(true);
                return;
            case 5:
                dA(true);
                return;
            default:
                return;
        }
    }

    public final void b(int i, k kVar, int i2, int i3) {
        if (c(i, kVar, i2, i3)) {
            v.i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
            return;
        }
        switch (i) {
            case 2:
                dB(false);
                return;
            case 5:
                dA(false);
                return;
            default:
                return;
        }
    }

    private boolean c(int i, Object obj, int i2, int i3) {
        if (this.gFa == null || obj == null) {
            v.e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
            return true;
        }
        Iterator it;
        com.tencent.mm.plugin.ipcall.a.a.d dVar;
        Object obj2;
        switch (i) {
            case 1:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.g) {
                    com.tencent.mm.plugin.ipcall.a.d.g gVar = (com.tencent.mm.plugin.ipcall.a.d.g) obj;
                    ant com_tencent_mm_protocal_c_ant = gVar.gHL;
                    if (this.gFa.gFJ == gVar.gHK.mNO) {
                        v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", new Object[]{Integer.valueOf(this.gFa.gFJ)});
                        b auo = i.auo();
                        if (auo.gFJ == this.gFa.gFJ) {
                            v.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", new Object[]{Integer.valueOf(i3)});
                            auo.gHg = i3;
                        }
                        if (i2 == 0 && i3 == 0) {
                            if (this.gFa != null) {
                                this.gFa.gFG = com_tencent_mm_protocal_c_ant.mqS;
                                this.gFa.gFH = com_tencent_mm_protocal_c_ant.mqT;
                                this.gFa.gFI = com_tencent_mm_protocal_c_ant.mNQ;
                                this.gFa.gFO = com_tencent_mm_protocal_c_ant.mNZ;
                                this.gFa.gFR = com_tencent_mm_protocal_c_ant.mOa * BaseReportManager.MAX_READ_COUNT;
                                this.gFa.gFY = com_tencent_mm_protocal_c_ant.gFY;
                                this.gFa.gFZ = com_tencent_mm_protocal_c_ant.gFZ;
                                this.gFa.emi = com_tencent_mm_protocal_c_ant.meE;
                                this.gFa.gGf = com_tencent_mm_protocal_c_ant.mOb;
                                this.gFa.gGj = com_tencent_mm_protocal_c_ant.mOc;
                                if (com_tencent_mm_protocal_c_ant.gGg > 0) {
                                    this.gFa.gGg = com_tencent_mm_protocal_c_ant.gGg;
                                }
                                this.gFa.gGa = com_tencent_mm_protocal_c_ant.gGa;
                                this.gFa.gGb = com_tencent_mm_protocal_c_ant.gGb;
                                this.gFa.gFX = com_tencent_mm_protocal_c_ant.mOe;
                                if (com_tencent_mm_protocal_c_ant.gGd > 0) {
                                    this.gFa.gGd = com_tencent_mm_protocal_c_ant.gGd - 1;
                                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.gFa.gGd + "] from Invite resp");
                                } else {
                                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                                    this.gFa.gGd = 2;
                                }
                                this.gFa.gGe = com_tencent_mm_protocal_c_ant.mOd;
                                v.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ant.gFS)});
                                if (com_tencent_mm_protocal_c_ant.gFS > 0) {
                                    this.gFa.gFW = false;
                                    this.gFa.gFS = com_tencent_mm_protocal_c_ant.gFS;
                                } else {
                                    this.gFa.gFW = true;
                                    this.gFa.gFS = 0;
                                }
                                this.gFa.gFN = com_tencent_mm_protocal_c_ant.gFN;
                                this.gFa.gFM = com_tencent_mm_protocal_c_ant.gFM;
                                this.gFa.fvC = i3;
                                this.gFa.fvD = be.ma(com.tencent.mm.platformtools.m.a(com_tencent_mm_protocal_c_ant.mQl.mfD));
                                break;
                            }
                        }
                        v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
                        if (com_tencent_mm_protocal_c_ant.mQl == null) {
                            this.gFa.gFN = "";
                            this.gFa.gFM = 2;
                            this.gFa.fvD = aa.getContext().getString(2131231564);
                            this.gFa.fvC = i3;
                            break;
                        }
                        if (i3 == 433) {
                            v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                            this.gFa.gFT = true;
                        } else if (i3 == 434) {
                            v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                            this.gFa.gFU = true;
                        } else if (i3 == 435) {
                            v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                            this.gFa.gFV = true;
                        }
                        if (com_tencent_mm_protocal_c_ant.gFS > 0) {
                            this.gFa.gFW = false;
                            this.gFa.gFS = com_tencent_mm_protocal_c_ant.gFS;
                        } else {
                            this.gFa.gFW = true;
                            this.gFa.gFS = 0;
                        }
                        this.gFa.gFN = com_tencent_mm_protocal_c_ant.gFN;
                        this.gFa.gFM = com_tencent_mm_protocal_c_ant.gFM;
                        this.gFa.fvC = i3;
                        if (com_tencent_mm_protocal_c_ant.mQl != null) {
                            this.gFa.fvD = be.ma(com.tencent.mm.platformtools.m.a(com_tencent_mm_protocal_c_ant.mQl.mfD));
                            v.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ant.gFM), Integer.valueOf(i3), this.gFa.fvD});
                            break;
                        }
                    }
                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[]{Integer.valueOf(this.gFa.gFJ), Integer.valueOf(gVar.gHK.mNO)});
                    return true;
                }
                v.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
                return true;
                break;
            case 2:
                if (obj instanceof l) {
                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                    l lVar = (l) obj;
                    aoc com_tencent_mm_protocal_c_aoc = lVar.gHV;
                    if (this.gFa.gFG == lVar.gHU.mqS) {
                        if (i2 == 0 && i3 == 0) {
                            v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aoc.mqS), Integer.valueOf(com_tencent_mm_protocal_c_aoc.mOn), Integer.valueOf(com_tencent_mm_protocal_c_aoc.mOo), Integer.valueOf(com_tencent_mm_protocal_c_aoc.mOl)});
                            if (com_tencent_mm_protocal_c_aoc.mqS == this.gFa.gFG && com_tencent_mm_protocal_c_aoc.mqT == this.gFa.gFH) {
                                if (com_tencent_mm_protocal_c_aoc.mOo == this.gFa.gFO) {
                                    v.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
                                    if (com_tencent_mm_protocal_c_aoc.mOl > this.gFa.gFP) {
                                        this.gFa.gFP = com_tencent_mm_protocal_c_aoc.mOl;
                                        if (com_tencent_mm_protocal_c_aoc.mOn != 0) {
                                            this.gFa.gFQ = com_tencent_mm_protocal_c_aoc.mOn;
                                        }
                                    }
                                } else {
                                    v.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
                                    it = this.gFa.gGh.iterator();
                                    Object obj3 = null;
                                    while (it.hasNext()) {
                                        dVar = (com.tencent.mm.plugin.ipcall.a.a.d) it.next();
                                        if (dVar.gGl == com_tencent_mm_protocal_c_aoc.mOo) {
                                            if (com_tencent_mm_protocal_c_aoc.mOl > dVar.gFP) {
                                                dVar.gFP = com_tencent_mm_protocal_c_aoc.mOl;
                                                if (com_tencent_mm_protocal_c_aoc.mOn != 0) {
                                                    dVar.cjs = com_tencent_mm_protocal_c_aoc.mOn;
                                                }
                                            }
                                            obj2 = 1;
                                        } else {
                                            obj2 = obj3;
                                        }
                                        obj3 = obj2;
                                    }
                                    if (obj3 == null) {
                                        dVar = new com.tencent.mm.plugin.ipcall.a.a.d();
                                        dVar.gGl = com_tencent_mm_protocal_c_aoc.mOo;
                                        dVar.cjs = com_tencent_mm_protocal_c_aoc.mOn;
                                        dVar.gFP = com_tencent_mm_protocal_c_aoc.mOl;
                                        this.gFa.gGh.add(dVar);
                                    }
                                }
                                if (com_tencent_mm_protocal_c_aoc.fvC == 404 || com_tencent_mm_protocal_c_aoc.fvC == 484) {
                                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
                                    this.gFa.gFV = true;
                                }
                                this.gFa.fvD = com_tencent_mm_protocal_c_aoc.fvD;
                                this.gFa.fvC = com_tencent_mm_protocal_c_aoc.fvC;
                                this.gFa.gFM = com_tencent_mm_protocal_c_aoc.gFM;
                                this.gFa.gFN = com_tencent_mm_protocal_c_aoc.gFN;
                                this.gFa.gGc = com_tencent_mm_protocal_c_aoc.gGc;
                                break;
                            }
                        }
                    }
                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.gFa.gFG), Integer.valueOf(lVar.gHU.mqS)});
                    return true;
                }
                v.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
                return true;
            case 3:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.a) {
                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (this.gFa.gFJ != ((com.tencent.mm.plugin.ipcall.a.d.a) obj).gHx.mNO) {
                        v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[]{Integer.valueOf(this.gFa.gFJ), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.a) obj).gHx.mNO)});
                        return true;
                    }
                }
                v.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
                return true;
                break;
            case 4:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.k) {
                    if (this.gFa.gFG == ((com.tencent.mm.plugin.ipcall.a.d.k) obj).gHS.mqS) {
                        if (i2 != 0 || i3 != 0) {
                            v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
                            break;
                        }
                        v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                        this.gFa.gFQ = 5;
                        break;
                    }
                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.gFa.gFG), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.k) obj).gHS.mqS)});
                    return true;
                }
                v.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                return true;
                break;
            case 5:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.f) {
                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (this.gFa.gFG != ((com.tencent.mm.plugin.ipcall.a.d.f) obj).gHI.mqS) {
                        v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.gFa.gFG), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.f) obj).gHI.mqS)});
                        return true;
                    }
                }
                v.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
                return true;
                break;
            case 6:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.h) {
                    com.tencent.mm.plugin.ipcall.a.d.h hVar = (com.tencent.mm.plugin.ipcall.a.d.h) obj;
                    anw com_tencent_mm_protocal_c_anw = hVar.gHN;
                    if (this.gFa.gFG == hVar.gHM.mqS) {
                        if (i2 != 0 || i3 != 0) {
                            v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
                            break;
                        }
                        v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
                        this.gFa.emi = com_tencent_mm_protocal_c_anw.meE;
                        this.gFa.gGf = com_tencent_mm_protocal_c_anw.mOb;
                        break;
                    }
                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.gFa.gFG), Integer.valueOf(hVar.gHM.mqS)});
                    return true;
                }
                v.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
                return true;
                break;
            case 8:
                if (obj instanceof anu) {
                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
                    anu com_tencent_mm_protocal_c_anu = (anu) obj;
                    if (this.gFa.gFG == com_tencent_mm_protocal_c_anu.mqS) {
                        if (i2 == 0 && i3 == 0) {
                            this.gFa.gGc = com_tencent_mm_protocal_c_anu.gGc;
                            v.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_anu.mOf.size())});
                            it = com_tencent_mm_protocal_c_anu.mOf.iterator();
                            while (it.hasNext()) {
                                aod com_tencent_mm_protocal_c_aod = (aod) it.next();
                                if (this.gFa.gFO == com_tencent_mm_protocal_c_aod.mOo) {
                                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", new Object[]{Integer.valueOf(this.gFa.gFO), Integer.valueOf(com_tencent_mm_protocal_c_aod.mNm), Integer.valueOf(com_tencent_mm_protocal_c_aod.mOp)});
                                    if (com_tencent_mm_protocal_c_aod.mOp > this.gFa.gFP) {
                                        this.gFa.gFP = com_tencent_mm_protocal_c_aod.mOp;
                                        if (com_tencent_mm_protocal_c_aod.mNm != 0) {
                                            this.gFa.gFQ = com_tencent_mm_protocal_c_aod.mNm;
                                        }
                                    }
                                } else {
                                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aod.mOo), Integer.valueOf(com_tencent_mm_protocal_c_aod.mNm), Integer.valueOf(com_tencent_mm_protocal_c_aod.mOp)});
                                    Object obj4 = null;
                                    Iterator it2 = this.gFa.gGh.iterator();
                                    while (it2.hasNext()) {
                                        dVar = (com.tencent.mm.plugin.ipcall.a.a.d) it2.next();
                                        if (dVar.gGl == com_tencent_mm_protocal_c_aod.mOo) {
                                            if (com_tencent_mm_protocal_c_aod.mOp > dVar.gFP) {
                                                dVar.gFP = com_tencent_mm_protocal_c_aod.mOp;
                                                if (com_tencent_mm_protocal_c_aod.mNm != 0) {
                                                    dVar.cjs = com_tencent_mm_protocal_c_aod.mNm;
                                                }
                                            }
                                            obj2 = 1;
                                        } else {
                                            obj2 = obj4;
                                        }
                                        obj4 = obj2;
                                    }
                                    if (obj4 == null) {
                                        dVar = new com.tencent.mm.plugin.ipcall.a.a.d();
                                        dVar.gGl = com_tencent_mm_protocal_c_aod.mOo;
                                        dVar.cjs = com_tencent_mm_protocal_c_aod.mNm;
                                        dVar.gFP = com_tencent_mm_protocal_c_aod.mOp;
                                        this.gFa.gGh.add(dVar);
                                    }
                                }
                                if (com_tencent_mm_protocal_c_aod.fvC == 404 || com_tencent_mm_protocal_c_aod.fvC == 484) {
                                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
                                    this.gFa.gFV = true;
                                }
                                this.gFa.fvD = com_tencent_mm_protocal_c_aod.fvD;
                                this.gFa.fvC = com_tencent_mm_protocal_c_aod.fvC;
                                this.gFa.gFM = com_tencent_mm_protocal_c_aod.gFM;
                                this.gFa.gFN = com_tencent_mm_protocal_c_aod.gFN;
                            }
                            break;
                        }
                    }
                    v.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.gFa.gFG), Integer.valueOf(com_tencent_mm_protocal_c_anu.mqS)});
                    return true;
                }
                v.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
                return true;
                break;
        }
        return false;
    }
}
