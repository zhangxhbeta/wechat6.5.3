package com.tencent.mm.plugin.ipcall;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.c.a.a;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class c implements a, g.a, k.a {
    public static ac cnC = new ac(Looper.getMainLooper());
    public e gEo;
    public com.tencent.mm.plugin.ipcall.a.g.k gEp;
    public boolean gEq = false;
    public Runnable gEr = new Runnable(this) {
        final /* synthetic */ c gEt;

        {
            this.gEt = r1;
        }

        public final void run() {
            if (!i.auq().auj()) {
                v.i("MicroMsg.IPCallManager", "timeout! still not accept!");
                if (this.gEt.bL(9, 12) && this.gEt.gEo != null) {
                    this.gEt.gEo.b(9, null, aa.getContext().getString(2131231564), 2);
                }
            }
        }
    };
    public Runnable gEs = new Runnable(this) {
        final /* synthetic */ c gEt;

        {
            this.gEt = r1;
        }

        public final void run() {
            int i = 0;
            h auv = i.auv();
            if (3500 != -1) {
                boolean booleanValue;
                try {
                    ak.yW();
                    booleanValue = ((Boolean) com.tencent.mm.model.c.vf().get(73218, Boolean.valueOf(true))).booleanValue();
                } catch (Exception e) {
                    v.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
                    booleanValue = true;
                }
                if (booleanValue && !auv.aYi) {
                    try {
                        auv.kBV = System.currentTimeMillis();
                        auv.kBT = new MediaPlayer();
                        booleanValue = ak.yX().qU();
                        boolean ra = ak.yX().ra();
                        v.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[]{Boolean.valueOf(booleanValue), Boolean.valueOf(ra)});
                        if (p.ceB.cbW >= 0) {
                            i = p.ceB.cbW;
                        }
                        auv.gY(false);
                        auv.a(2131165636, 3500, true, i);
                        auv.aYi = true;
                        return;
                    } catch (Exception e2) {
                        v.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e2.toString());
                        return;
                    }
                }
                return;
            }
            auv.i(2131165636, 2, true);
        }
    };

    private boolean B(int i, int i2, int i3) {
        com.tencent.mm.plugin.ipcall.a.a.c cVar = i.aum().gFa;
        if (i.auq().lV(i)) {
            int i4;
            com.tencent.mm.plugin.ipcall.a.b.a aVar;
            boolean z;
            if (cVar != null) {
                v.i("MicroMsg.IPCallManager", "finishIPCall inviteId:%d, roomId:%d, state:%d, errStatus:%d, pstnErrCode:%d", new Object[]{Integer.valueOf(cVar.gFJ), Integer.valueOf(cVar.gFG), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
            v.i("MicroMsg.IPCallManager", "closeDeviceEngine");
            k.bct().bcv();
            k.bct().kuD = null;
            b auo = i.auo();
            com.tencent.mm.plugin.ipcall.a.b.b aup = i.aup();
            if (aup.gGt != null) {
                com.tencent.mm.plugin.ipcall.a.b.c cVar2 = aup.gGt;
                i4 = cVar2.gGC != null ? cVar2.gGC.aTS : 0;
            } else {
                i4 = 0;
            }
            if (auo.gHt == 0) {
                auo.gHt = i4;
            }
            auo = i.auo();
            aup = i.aup();
            if (aup.gGs != null) {
                aVar = aup.gGs;
                if (aVar.gGm != null) {
                    v.d("MicroMsg.IPCallAudioPlayer", "AudioPlayer  mAudioPlayErrState:" + aVar.gGm.bbt());
                    i4 = aVar.gGm.bbt();
                } else {
                    i4 = 0;
                }
            } else {
                i4 = 0;
            }
            if (auo.gHu == 0) {
                auo.gHu = i4;
            }
            com.tencent.mm.plugin.ipcall.a.b.b aup2 = i.aup();
            com.tencent.mm.plugin.ipcall.a.c.a aun = i.aun();
            if (aup2.gGs != null) {
                aVar = aup2.gGs;
                i4 = (aVar.gGm == null || !aVar.bhY) ? -1 : aVar.gGm.bbu();
            } else {
                i4 = 0;
            }
            aun.gGO.kwf = i4 == -1 ? 0 : (int) ((((float) ak.yX().getStreamVolume(i4)) / ((float) ak.yX().getStreamMaxVolume(i4))) * 100.0f);
            aup2.djL.si();
            aVar = aup2.gGs;
            if (aVar.bhY) {
                v.i("MicroMsg.IPCallAudioPlayer", "stopPlay");
                synchronized (aVar.gGn) {
                    e.a(new a(aVar, aVar.gGm), "IPCallAudioPlayer_stop");
                    aVar.bhY = false;
                    aVar.gGm = null;
                }
            }
            aup2.aWn = null;
            aup2.gGv.cD(aa.getContext());
            ak.yX().qT();
            ak.yX().b(aup2);
            aup2.gGy = null;
            aup2.gGw = null;
            aup = i.aup();
            com.tencent.mm.plugin.ipcall.a.b.c cVar3 = aup.gGt;
            if (cVar3.bhY) {
                v.i("MicroMsg.IPCallRecorder", "stop record");
                synchronized (cVar3.gGD) {
                    if (cVar3.gGC != null) {
                        e.a(new a(cVar3, cVar3.gGC), "IPCallRecorder_stopRecord");
                        cVar3.gGC = null;
                        cVar3.bhY = false;
                        cVar3.eJx = false;
                    }
                }
            }
            aup.aWn = null;
            com.tencent.mm.plugin.ipcall.a.c.a aun2 = i.aun();
            v.i("MicroMsg.IPCallEngineManager", "close engine");
            aun2.gGO.gU(true);
            b auo2 = i.auo();
            if (be.kS(auo2.gHo) && be.kS(auo2.gHn)) {
                com.tencent.mm.plugin.ipcall.a.a.c cVar4 = i.aum().gFa;
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = i.aun().gGO;
                z = auo2.gHc == 1;
                com_tencent_mm_plugin_voip_model_v2protocal.getPstnChannelInfo(com_tencent_mm_plugin_voip_model_v2protocal.kwZ, com_tencent_mm_plugin_voip_model_v2protocal.kwZ.length, z ? 1 : 0, cVar4.gGd);
                v.d("MicroMsg.Voip", "field_pstnChannelInfoLength: %d", new Object[]{Integer.valueOf(com_tencent_mm_plugin_voip_model_v2protocal.field_pstnChannelInfoLength)});
                auo2.gHo = new String(com_tencent_mm_plugin_voip_model_v2protocal.kwZ, 0, com_tencent_mm_plugin_voip_model_v2protocal.field_pstnChannelInfoLength);
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal2 = i.aun().gGO;
                com_tencent_mm_plugin_voip_model_v2protocal2.getPstnEngineInfo(com_tencent_mm_plugin_voip_model_v2protocal2.kxa, com_tencent_mm_plugin_voip_model_v2protocal2.kxa.length);
                v.d("MicroMsg.Voip", "field_pstnEngineInfoLength: %d", new Object[]{Integer.valueOf(com_tencent_mm_plugin_voip_model_v2protocal2.field_pstnEngineInfoLength)});
                auo2.gHn = new String(com_tencent_mm_plugin_voip_model_v2protocal2.kxa, 0, com_tencent_mm_plugin_voip_model_v2protocal2.field_pstnEngineInfoLength);
                com_tencent_mm_plugin_voip_model_v2protocal2 = i.aun().gGO;
                auo2.gHp = v2protocal.bcZ() + "," + com_tencent_mm_plugin_voip_model_v2protocal2.kwg + "," + (v2protocal.kjU & 255) + com_tencent_mm_plugin_voip_model_v2protocal2.bde() + "," + com_tencent_mm_plugin_voip_model_v2protocal2.kwf;
                v.d("MicroMsg.IPCallReportHelper", "nativeChannelReportString: %s", new Object[]{auo2.gHo});
                v.d("MicroMsg.IPCallReportHelper", "nativeEngineReportString: %s", new Object[]{auo2.gHn});
                v.d("MicroMsg.IPCallReportHelper", "clientReportExString: %s", new Object[]{auo2.gHp});
            }
            aun2.gGO.reset();
            aun2.auH();
            i.auv().stop();
            h auv = i.auv();
            i.aup();
            z = ak.yX().cba.isSpeakerphoneOn();
            auv.mContext.getSharedPreferences(aa.bti(), 0).getBoolean("settings_shake", true);
            ak.yX().setSpeakerphoneOn(z);
            if (z) {
                ak.yX().setMode(0);
            } else {
                ak.yX().setMode(2);
            }
            auv.kBW = System.currentTimeMillis();
            MediaPlayer mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(auv.mContext, Uri.parse("android.resource://" + auv.mContext.getPackageName() + "/2131165831"));
                mediaPlayer.setOnCompletionListener(new OnCompletionListener(auv) {
                    final /* synthetic */ h kBY;

                    {
                        this.kBY = r1;
                    }

                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                        if (System.currentTimeMillis() - this.kBY.kBW > 5000) {
                            this.kBY.kBU = 8;
                            ak.yX().setMode(0);
                        }
                    }
                });
                mediaPlayer.setOnErrorListener(new OnErrorListener(auv) {
                    final /* synthetic */ h kBY;

                    {
                        this.kBY = r1;
                    }

                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                            this.kBY.kBU = 5;
                            v.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", new Object[]{mediaPlayer, Integer.valueOf(i), Integer.valueOf(i2)});
                        }
                        return false;
                    }
                });
                if (ak.yX().qU() || !z) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                mediaPlayer.setAudioStreamType(i4);
                mediaPlayer.prepare();
                mediaPlayer.setLooping(false);
                mediaPlayer.start();
                if (System.currentTimeMillis() - auv.kBW > 2000) {
                    auv.kBU = 7;
                }
            } catch (Throwable th) {
                v.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[]{th});
                auv.kBU = 6;
            }
            cnC.removeCallbacks(this.gEs);
            cnC.removeCallbacks(this.gEr);
            i.auo().gHe = i3;
            b auo3 = i.auo();
            v.d("MicroMsg.IPCallReportHelper", "markEndTalk");
            if (auo3.gHm == 0 && auo3.gHl != 0) {
                auo3.gHm = System.currentTimeMillis();
                auo3.gHd = (auo3.gHm - auo3.gHl) / 1000;
                v.d("MicroMsg.IPCallReportHelper", "callTime: %d", new Object[]{Long.valueOf(auo3.gHd)});
            }
            com.tencent.mm.plugin.ipcall.a.g.k kVar;
            if (i == 8) {
                i.aum().auk();
                i.auo().auJ();
                kVar = this.gEp;
                if (kVar != null) {
                    v.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", new Object[]{Long.valueOf(kVar.nmb)});
                    if (kVar.nmb != -1) {
                        kVar.field_status = 2;
                        i.aus().a(kVar);
                    }
                }
            } else if (i == 12) {
                i.aum().auk();
                i.auo().auJ();
                if (i2 == 11) {
                    m.b(this.gEp);
                } else {
                    kVar = this.gEp;
                    if (kVar != null) {
                        v.d("MicroMsg.IPCallRecordStorageLogic", "recordCallFailed, localId: %d", new Object[]{Long.valueOf(kVar.nmb)});
                        if (kVar.nmb != -1) {
                            kVar.field_status = 6;
                            i.aus().a(kVar);
                        }
                    }
                }
            } else if (i == 9) {
                i.aum().lW(1);
                i.auo().auI();
                m.a(this.gEp, i.auo().gHd);
            } else if (i == 10) {
                i.aum().lW(1);
                auo3 = i.auo();
                v.i("MicroMsg.IPCallReportHelper", "otherSideUserShutdown");
                auo3.gGX = 1;
                kVar = this.gEp;
                long j = i.auo().gHd;
                if (kVar != null) {
                    v.d("MicroMsg.IPCallRecordStorageLogic", "recordOthersideShutdownCall, localId: %d, talkTime: %d", new Object[]{Long.valueOf(kVar.nmb), Long.valueOf(j)});
                    if (kVar.nmb != -1) {
                        kVar.field_status = 5;
                        kVar.field_duration = j;
                        i.aus().a(kVar);
                    }
                }
            } else if (i == 11) {
                if (i2 == 5) {
                    i.aum().lW(3);
                } else if (i2 == 11) {
                    i.aum().lW(1);
                } else {
                    i.aum().lW(2);
                }
                i.auo().auI();
                if (i2 == 11) {
                    m.b(this.gEp);
                } else {
                    m.a(this.gEp, i.auo().gHd);
                }
            }
            return true;
        }
        v.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        if (cVar == null) {
            return false;
        }
        v.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now inviteId:%d, roomId:%d, state:%d,errStatus:%d, pstnErrCode:%d", new Object[]{Integer.valueOf(cVar.gFJ), Integer.valueOf(cVar.gFG), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        return false;
    }

    public static boolean uG(String str) {
        v.d("MicroMsg.IPCallManager", "dialWhenTalking, dialButton: %s", new Object[]{str});
        if (!i.auq().auj()) {
            v.i("MicroMsg.IPCallManager", "ipcall not connect, cannot call dialWhenTalking now");
            return false;
        } else if (be.kS(str) || str.length() != 1) {
            return false;
        } else {
            int i;
            com.tencent.mm.plugin.ipcall.a.c.a aun;
            b auo;
            if (!be.kS(str) && str.length() == 1) {
                char charAt = str.charAt(0);
                if (charAt < '0' || charAt > '9') {
                    if (charAt == '*') {
                        i = 10;
                    } else if (charAt == '#') {
                        i = 11;
                    } else if (charAt >= 'A' && charAt <= 'D') {
                        i = (charAt - 65) + 12;
                    }
                    if (i != -1) {
                        return false;
                    }
                    aun = i.aun();
                    v.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[]{Integer.valueOf(i)});
                    auo = i.auo();
                    auo.gHw++;
                    v.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[]{Integer.valueOf(auo.gHw)});
                    if (aun.gGO.SendDTMF(i) < 0) {
                        v.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[]{Integer.valueOf(aun.gGO.SendDTMF(i))});
                    }
                    return true;
                }
                i = charAt - 48;
                if (i != -1) {
                    return false;
                }
                aun = i.aun();
                v.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[]{Integer.valueOf(i)});
                auo = i.auo();
                auo.gHw++;
                v.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[]{Integer.valueOf(auo.gHw)});
                if (aun.gGO.SendDTMF(i) < 0) {
                    v.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[]{Integer.valueOf(aun.gGO.SendDTMF(i))});
                }
                return true;
            }
            i = -1;
            if (i != -1) {
                return false;
            }
            aun = i.aun();
            v.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[]{Integer.valueOf(i)});
            auo = i.auo();
            auo.gHw++;
            v.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[]{Integer.valueOf(auo.gHw)});
            if (aun.gGO.SendDTMF(i) < 0) {
                v.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[]{Integer.valueOf(aun.gGO.SendDTMF(i))});
            }
            return true;
        }
    }

    public final void atK() {
        v.i("MicroMsg.IPCallManager", "onInviteSuccess");
        if (i.auq().lV(3)) {
            b auo = i.auo();
            v.d("MicroMsg.IPCallReportHelper", "markStartInvite");
            if (auo.gHi == 0) {
                auo.gHi = System.currentTimeMillis();
            }
            com.tencent.mm.plugin.ipcall.a.a.c cVar = i.aum().gFa;
            b auo2 = i.auo();
            int i = cVar.gFJ;
            String str = cVar.bob;
            String str2 = cVar.gGi;
            int i2 = cVar.gFG;
            long j = cVar.gFH;
            long j2 = cVar.gFI;
            auo2.gFJ = i;
            auo2.gHh = str;
            auo2.dwA = str2;
            auo2.gFG = i2;
            auo2.gFH = j;
            auo2.gHf = j2;
            if (this.gEo != null) {
                this.gEo.atK();
            }
        }
    }

    public final void r(String str, String str2, int i) {
        v.i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        if (bL(2, 0) && this.gEo != null) {
            this.gEo.b(2, str, str2, i);
        }
    }

    public final void atL() {
        v.i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        if (i.auq().lV(4)) {
            b auo = i.auo();
            v.d("MicroMsg.IPCallReportHelper", "markStartRing");
            if (auo.gHj == 0) {
                auo.gHj = System.currentTimeMillis();
                auo.gHa = auo.gHj - auo.gHi;
                v.d("MicroMsg.IPCallReportHelper", "ringTime: %d", new Object[]{Long.valueOf(auo.gHa)});
            }
            i.aun().auG();
            auo = i.auo();
            v.i("MicroMsg.IPCallReportHelper", "startRing");
            auo.gGV = 1;
            if (this.gEo != null) {
                this.gEo.atL();
            }
        }
    }

    public final void atM() {
        v.i("MicroMsg.IPCallManager", "onAccept, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        if (i.auq().lV(5)) {
            b auo = i.auo();
            v.d("MicroMsg.IPCallReportHelper", "markUserAccept");
            if (auo.gHk == 0) {
                auo.gHk = System.currentTimeMillis();
                auo.gHb = auo.gHk - auo.gHi;
                v.d("MicroMsg.IPCallReportHelper", "answerTime: %d", new Object[]{Long.valueOf(auo.gHb)});
            }
            i.aun().auG();
            auo = i.auo();
            v.i("MicroMsg.IPCallReportHelper", "userAccept");
            auo.gGW = 1;
            cnC.removeCallbacks(this.gEr);
            i.auv().stop();
            cnC.removeCallbacks(this.gEs);
            i.aup().auD();
            if (this.gEo != null && i.aun().gGR && !this.gEq) {
                i.auo().auK();
                i.auo().auN();
                this.gEq = true;
                i.aun().auF();
                this.gEo.atU();
                i.auo().auM();
                k.bct().bcu();
                k.bct().kuD = this;
            }
        }
    }

    public final void aB(String str, int i) {
        v.i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        if (bL(3, 5) && this.gEo != null) {
            this.gEo.b(3, null, str, i);
        }
    }

    public final void aC(String str, int i) {
        v.i("MicroMsg.IPCallManager", "onBusy, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        if (bL(1, 4) && this.gEo != null) {
            this.gEo.b(1, null, str, i);
        }
    }

    public final void atN() {
        v.i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        if (B(10, 0, 32) && this.gEo != null) {
            this.gEo.atV();
        }
    }

    public final void aD(String str, int i) {
        v.i("MicroMsg.IPCallManager", "onSyncFailed");
        if (bL(7, 35) && this.gEo != null) {
            this.gEo.b(7, null, str, i);
        }
    }

    public final void atO() {
        v.i("MicroMsg.IPCallManager", "onHeartbeatFailed");
        if (bL(7, 29) && this.gEo != null) {
            this.gEo.b(7, null, aa.getContext().getString(2131231561), 1);
        }
    }

    public final void s(String str, String str2, int i) {
        v.i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        if (bL(8, 9) && this.gEo != null) {
            this.gEo.b(8, str, str2, i);
        }
    }

    public final void t(String str, String str2, int i) {
        v.i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        if (bL(10, 0) && this.gEo != null) {
            this.gEo.b(10, str, str2, i);
        }
    }

    public final void u(String str, String str2, int i) {
        v.i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        if (bL(11, 0) && this.gEo != null) {
            this.gEo.b(11, str, str2, i);
        }
    }

    public final void e(String str, String str2, int i, int i2) {
        v.i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        if (bL(12, 0) && this.gEo != null) {
            this.gEo.e(str, str2, i, i2);
        }
    }

    public final void atP() {
        v.i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        if (bL(6, 0) && this.gEo != null) {
            this.gEo.b(6, null, aa.getContext().getString(2131231564), 1);
        }
    }

    public final void atQ() {
        v.i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        i.auv().stop();
        cnC.removeCallbacks(this.gEs);
        if (i.auq().auh()) {
            com.tencent.mm.plugin.ipcall.a.b.b aup = i.aup();
            aup.gGv.a(aa.getContext(), aup);
            ak.yX().a(aup);
            ak.yX().qS();
            aup.gGA = ak.yX().ra();
            aup.gGz = ak.yX().qU();
            v.d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[]{Boolean.valueOf(aup.gGA), Boolean.valueOf(aup.gGz)});
            aup.djL.requestFocus();
            com.tencent.mm.plugin.ipcall.a.b.a aVar = aup.gGs;
            if (aVar.bhY) {
                v.d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
            } else {
                v.i("MicroMsg.IPCallAudioPlayer", "startPlay");
                if (aVar.gGm == null) {
                    aVar.gGm = new com.tencent.mm.plugin.voip.model.b();
                    aVar.gGm.L(v2protocal.hyT, 20, 1);
                }
                aVar.gGo = aVar.gGm.i(aa.getContext(), false);
                aVar.gGm.kqQ = new com.tencent.mm.plugin.voip.model.a(aVar) {
                    final /* synthetic */ a gGq;

                    {
                        this.gGq = r1;
                    }

                    public final int x(byte[] bArr, int i) {
                        if (!this.gGq.bhY) {
                            return -1;
                        }
                        if (i.aun().gGO.playCallback(bArr, i) >= 0) {
                            return 0;
                        }
                        v.e("MicroMsg.IPCallAudioPlayer", "playCallback, error: %d", new Object[]{Integer.valueOf(i.aun().gGO.playCallback(bArr, i))});
                        return -1;
                    }
                };
                if (aVar.gGm.bbq() <= 0) {
                    i.auo().auL();
                }
                aVar.dE(aVar.gGp);
                aVar.bhY = true;
            }
            if (!(!aup.gGA || aup.gGz || aup.gGy == null)) {
                aup.gGy.dH(true);
            }
            if (!(!aup.gGz || aup.gGA || aup.gGy == null)) {
                aup.gGy.dI(true);
            }
        }
        i.auo().auK();
        i.aup().auD();
        if (this.gEo != null && i.auq().auj() && !this.gEq) {
            i.auo().auN();
            i.aun().auF();
            this.gEq = true;
            this.gEo.atU();
            com.tencent.mm.plugin.ipcall.a.g.k kVar = this.gEp;
            if (kVar != null) {
                v.d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", new Object[]{Long.valueOf(kVar.nmb)});
                if (kVar.nmb != -1) {
                    kVar.field_status = 3;
                    i.aus().a(kVar);
                }
            }
            i.auo().auM();
            k.bct().bcu();
            k.bct().kuD = this;
        }
    }

    public final void lT(int i) {
        v.i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", new Object[]{f.stateToString(i.auq().gEK)});
        if (i.aun().gGR) {
            v.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
            if (bL(5, i) && this.gEo != null) {
                this.gEo.b(5, null, aa.getContext().getString(2131231561), 1);
                return;
            }
            return;
        }
        v.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
        if (bL(4, i) && this.gEo != null) {
            this.gEo.b(4, null, aa.getContext().getString(2131231561), 1);
        }
    }

    public final boolean bL(int i, int i2) {
        if (i.auq().auj()) {
            if (i == 0) {
                return B(9, i, i2);
            }
            return B(11, i, i2);
        } else if (i == 0) {
            return B(8, i, i2);
        } else {
            return B(12, i, i2);
        }
    }

    public final void atR() {
        if (i.auq().gEK != 5) {
            v.i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", new Object[]{Integer.valueOf(i.auq().gEK)});
            return;
        }
        com.tencent.mm.plugin.ipcall.a.b.b aup = i.aup();
        v.i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
        if (aup.gGw != null) {
            j jVar = aup.gGw;
            if (jVar.gPg != null) {
                jVar.gPg.setVisibility(0);
            }
            if (jVar.gPh != null) {
                jVar.gPh.setVisibility(0);
            }
        }
        if (!ak.yX().cba.isSpeakerphoneOn()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - aup.gGB > 30000) {
                aup.gGB = currentTimeMillis;
                d.bbw().bcH();
            }
        }
    }

    public final void atS() {
        if (i.auq().gEK != 5) {
            v.i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", new Object[]{Integer.valueOf(i.auq().gEK)});
            return;
        }
        com.tencent.mm.plugin.ipcall.a.b.b aup = i.aup();
        v.i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
        if (aup.gGw != null) {
            aup.gGw.avv();
        }
    }
}
