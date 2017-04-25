package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.op;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip_cs.b.a.c;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.protocal.c.bdc;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.pb.common.c.h;
import java.util.Arrays;

@a(3)
public class VoipCSMainUI extends MMActivity implements com.tencent.mm.plugin.voip_cs.b.a, com.tencent.mm.plugin.voip_cs.b.b.a.a {
    private b aUX;
    private String appId = "";
    private ac cnC;
    public String fSc = "";
    private ah gPw = new ah(Looper.getMainLooper(), new ah.a(this) {
        final /* synthetic */ VoipCSMainUI kEW;

        {
            this.kEW = r1;
        }

        public final boolean oU() {
            CharSequence string = aa.getContext().getString(2131235889);
            Notification notification = new Builder(aa.getContext()).setTicker(aa.getContext().getString(2131235889)).setWhen(System.currentTimeMillis()).setContentTitle(aa.getContext().getString(2131235883)).setContentText(string).setContentIntent(PendingIntent.getActivity(aa.getContext(), 44, new Intent(aa.getContext(), VoipCSMainUI.class), 134217728)).setOngoing(true).getNotification();
            notification.icon = com.tencent.mm.ax.a.bmo();
            notification.flags |= 32;
            ak.oH().a(44, notification, false);
            return true;
        }
    }, true);
    private m ixZ = new m.a(this) {
        final /* synthetic */ VoipCSMainUI kEW;

        {
            this.kEW = r1;
        }

        public final void cI(int i) {
            v.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from " + i);
            if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe != 2) {
                return;
            }
            if (i == 4 || i == 6) {
                d bec = com.tencent.mm.plugin.voip_cs.b.b.bec();
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = com.tencent.mm.plugin.voip_cs.b.b.beb().gGO;
                if (bec.ksm == 0) {
                    bec.ksm = com_tencent_mm_plugin_voip_model_v2protocal.kvG;
                }
                int netType = com.tencent.mm.plugin.voip.b.a.getNetType(aa.getContext());
                if (netType != bec.ksm) {
                    v.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + bec.ksm + " to " + netType);
                    try {
                        byte[] bArr = new byte[4];
                        bArr[0] = (byte) netType;
                        int appCmd = com_tencent_mm_plugin_voip_model_v2protocal.setAppCmd(301, bArr, 4);
                        if (appCmd < 0) {
                            v.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + com_tencent_mm_plugin_voip_model_v2protocal.gFO + ", roomkey=" + com_tencent_mm_plugin_voip_model_v2protocal.gFH + "]");
                        }
                        bdc com_tencent_mm_protocal_c_bdc = new bdc();
                        com_tencent_mm_protocal_c_bdc.mZd = 3;
                        com_tencent_mm_protocal_c_bdc.mZe = new com.tencent.mm.ba.b(bArr, 0, 1);
                        com_tencent_mm_plugin_voip_model_v2protocal.SendRUDP(com_tencent_mm_protocal_c_bdc.toByteArray(), com_tencent_mm_protocal_c_bdc.toByteArray().length);
                    } catch (Exception e) {
                        v.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
                    }
                    bec.ksm = netType;
                }
                bec = com.tencent.mm.plugin.voip_cs.b.b.bec();
                v.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kvI + "roomkey:" + com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.gFH);
                ak.vy().a(285, bec);
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal2 = com.tencent.mm.plugin.voip_cs.b.b.beb().gGO;
                ak.vy().a(new com.tencent.mm.plugin.voip_cs.b.c.d(com_tencent_mm_plugin_voip_model_v2protocal2.kvI, com_tencent_mm_plugin_voip_model_v2protocal2.gFH), 0);
            }
        }
    };
    private com.tencent.mm.plugin.voip_cs.b.a.b kEO;
    private c kEP;
    private boolean kEQ = false;
    public String kER = "";
    public String kES = "";
    public String kET = "";
    private ah kEU = new ah(Looper.getMainLooper(), new ah.a(this) {
        final /* synthetic */ VoipCSMainUI kEW;

        {
            this.kEW = r1;
        }

        public final boolean oU() {
            v.d("MicroMsg.voipcs.VoipCSMainUI", "delay startbluetooth!");
            ak.yX().qS();
            return false;
        }
    }, false);
    com.tencent.mm.compatible.b.d.a kEV = new com.tencent.mm.compatible.b.d.a(this) {
        final /* synthetic */ VoipCSMainUI kEW;

        {
            this.kEW = r1;
        }

        public final void cK(int i) {
            v.d("MicroMsg.voipcs.VoipCSMainUI", "onBluetoothHeadsetStateChange status: %d, mBTRecoverSpeakerOn: %b", new Object[]{Integer.valueOf(i)});
            switch (i) {
                case 1:
                    this.kEW.kEP.gN(false);
                    return;
                case 2:
                    ak.yX().qT();
                    this.kEW.kEP.gN(true);
                    return;
                case 3:
                    ak.yX().qS();
                    return;
                case 4:
                    ak.yX().qT();
                    this.kEW.kEP.gN(true);
                    return;
                default:
                    return;
            }
        }
    };
    public String kEf = "";
    private com.tencent.mm.plugin.voip_cs.b.a.a kEk;
    private HeadsetPlugReceiver ktI = null;
    private TelephonyManager ktJ;
    private BroadcastReceiver kun = new BroadcastReceiver(this) {
        final /* synthetic */ VoipCSMainUI kEW;

        {
            this.kEW = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            PowerManager powerManager = (PowerManager) aa.getContext().getSystemService("power");
            if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
                v.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
                this.kEW.kEO.beg = false;
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                v.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
                this.kEW.kEO.beg = false;
                if (!this.kEW.kEk.bcI() && com.tencent.mm.plugin.voip_cs.b.b.bec().kEe == 2) {
                    this.kEW.kEk.bek();
                }
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                v.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
                this.kEW.kEO.beg = true;
                if (!this.kEW.kEk.bcI()) {
                    this.kEW.kEk.aCp();
                }
            }
        }
    };
    private HeadsetPlugReceiver.a kup = new HeadsetPlugReceiver.a(this) {
        final /* synthetic */ VoipCSMainUI kEW;

        {
            this.kEW = r1;
        }

        public final void dG(boolean z) {
            v.d("MicroMsg.voipcs.VoipCSMainUI", "onHeadsetState, on:%b", new Object[]{Boolean.valueOf(z)});
            if (this.kEW.kEQ == z) {
                v.d("MicroMsg.voipcs.VoipCSMainUI", "same status, no changed");
                return;
            }
            this.kEW.kEQ = z;
            if (z) {
                this.kEW.kEP.gN(false);
                Toast.makeText(aa.getContext(), aa.getContext().getString(2131235956), 0).show();
                return;
            }
            this.kEW.kEP.gN(true);
            Toast.makeText(aa.getContext(), aa.getContext().getString(2131235957), 0).show();
        }
    };
    PhoneStateListener kuq = new PhoneStateListener(this) {
        final /* synthetic */ VoipCSMainUI kEW;

        {
            this.kEW = r1;
        }

        public final void onCallStateChanged(int i, String str) {
            v.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
            if (i == 2) {
                v.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
                com.tencent.mm.plugin.voip_cs.b.b.bed().kDy = 4;
                this.kEW.sd(7);
            }
        }
    };

    public void onCreate(Bundle bundle) {
        v.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
        super.onCreate(bundle);
        this.nDR.bAj();
        this.kEf = getIntent().getStringExtra("voipCSBizId");
        this.appId = getIntent().getStringExtra("voipCSAppId");
        this.kER = getIntent().getStringExtra("voipCSAllowBackCamera");
        this.kES = getIntent().getStringExtra("voipCSShowOther");
        this.fSc = getIntent().getStringExtra("voipCSAvatarUrl");
        this.kET = getIntent().getStringExtra("voipCSContext");
        getWindow().addFlags(6946944);
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        this.cnC = new ac();
        com.tencent.mm.plugin.voip_cs.b.c bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
        v.d("MicroMsg.VoipCSReportHelper", "reset");
        bed.aKG = 0;
        bed.kDf = 0;
        bed.kDg = 0;
        bed.kDh = 0;
        bed.kDi = 0;
        bed.kDj = 0;
        bed.kDk = 0;
        bed.kDl = 0;
        bed.kDm = 0;
        bed.kDn = 0;
        bed.kDo = 0;
        bed.networkType = 0;
        bed.kDp = 0;
        bed.kDq = com.tencent.mm.plugin.voip_cs.b.c.kDc;
        bed.kDr = 0;
        bed.kDs = 0;
        bed.gFH = 0;
        bed.kDt = "";
        bed.kvG = 0;
        bed.kDw = 0;
        bed.kDx = 0;
        bed.kDy = 0;
        bed.kvX = 0;
        bed.kvW = 0;
        bed.kDz = 0;
        bed.kDA = 0;
        bed.kDB = 0;
        bed.kDC = 0;
        bed.kDD = 0;
        bed.kDE = 0;
        bed.kDF = 0;
        bed.kDG = 0;
        bed.kDH = 0;
        bed.kDI = 0;
        bed.kDJ = 0;
        bed.gHd = 0;
        bed.kDK = 0;
        bed.kDL = 0;
        bed.channelStrategy = 1;
        bed.kxe = 0;
        bed.kvY = 0;
        bed.kDM = 0;
        bed.kDN = 0;
        bed.gHo = "";
        bed.gHn = "";
        bed.kDR = 0;
        bed.kDS = 0;
        bed.kDT = 0;
        bed.kDU = 0;
        bed.kDV = 0;
        this.ktJ = (TelephonyManager) aa.getContext().getSystemService("phone");
        com.tencent.mm.plugin.voip_cs.b.b.bec().kEf = this.kEf;
        this.kEO = new com.tencent.mm.plugin.voip_cs.b.a.b(this);
        this.kEP = new c();
        this.aUX = new b(aa.getContext());
        this.kEk = com.tencent.mm.plugin.voip_cs.b.a.a.bei();
        com.tencent.mm.plugin.voip_cs.b.b.beb().kEM = this;
        com.tencent.mm.plugin.voip_cs.b.b.bec().kDX = this;
        if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe == 0 || com.tencent.mm.plugin.voip_cs.b.b.bec().kEe == 3) {
            com.tencent.mm.plugin.voip_cs.b.b.bec().kEe = 0;
        }
        ak.oJ().pU();
        this.aUX.requestFocus();
        this.kEU.ea(2000);
        ak.yX().a(this.kEV);
        this.ktI = new HeadsetPlugReceiver();
        this.ktI.a(aa.getContext(), this.kup);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        aa.getContext().registerReceiver(this.kun, intentFilter);
        ak.a(this.ixZ);
        int callState = this.ktJ.getCallState();
        if (callState == 2 || callState == 1) {
            v.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", new Object[]{Integer.valueOf(callState)});
            g.a(this, 2131235895, 2131231164, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI kEW;

                {
                    this.kEW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.kEW.sd(0);
                }
            });
            callState = 1;
        } else {
            callState = 0;
        }
        if (callState != 0) {
            v.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
            return;
        }
        this.ktJ.listen(this.kuq, 32);
        if (!com.tencent.mm.sdk.platformtools.ak.isNetworkConnected(this)) {
            v.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
            g.a(this, 2131235891, 2131235932, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI kEW;

                {
                    this.kEW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.kEW.sd(9);
                }
            });
            callState = 0;
        } else if (com.tencent.mm.sdk.platformtools.ak.isWifi(this) || l.bcx()) {
            callState = 1;
        } else {
            v.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
            g.a(this, 2131235892, 2131235932, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI kEW;

                {
                    this.kEW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    v.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
                    l.bcw();
                    if (this.kEW.bet()) {
                        this.kEW.bes();
                    }
                }
            }, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI kEW;

                {
                    this.kEW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    v.i("MicroMsg.voipcs.VoipCSMainUI", "cannot start voip by user choose cancel call  in not wifi network!");
                    dialogInterface.dismiss();
                    this.kEW.sd(8);
                }
            });
            callState = 0;
        }
        if (callState == 0) {
            v.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
            return;
        }
        if (com.tencent.mm.plugin.voip.b.d.bdz()) {
            v.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
            g.a(this, 2131235887, 2131231164, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI kEW;

                {
                    this.kEW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.kEW.sd(0);
                }
            });
            callState = 1;
        } else if (com.tencent.mm.plugin.voip.b.d.bdy()) {
            v.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
            g.a(this, 2131235888, 2131231164, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI kEW;

                {
                    this.kEW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.kEW.sd(0);
                }
            });
            callState = 1;
        } else if (com.tencent.mm.ah.a.Hv()) {
            v.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
            g.a(this, 2131235885, 2131231164, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI kEW;

                {
                    this.kEW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.kEW.sd(0);
                }
            });
            callState = 1;
        } else if (com.tencent.mm.ah.a.Hw()) {
            v.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
            g.a(this, 2131235886, 2131231164, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI kEW;

                {
                    this.kEW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.kEW.sd(0);
                }
            });
            callState = 1;
        } else {
            callState = 0;
        }
        if (callState != 0) {
            v.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
        } else if (bet()) {
            bes();
        }
    }

    private void bes() {
        int init;
        if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe <= 0) {
            com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.kEO;
            if (bVar.kEC.btC()) {
                bVar.kEC.ea((long) bVar.kEx);
            }
            bVar = this.kEO;
            if (bVar.kED.btC()) {
                bVar.kED.ea((long) bVar.kEy);
            }
            com.tencent.mm.plugin.voip_cs.b.b.a beb = com.tencent.mm.plugin.voip_cs.b.b.beb();
            beb.gGR = false;
            beb.gGQ = false;
            if (beb.gGO.hqt) {
                v.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
                beb.gGO.gU(false);
                beb.gGO.reset();
            }
            beb.gGO.kvH = 1;
            long currentTimeMillis = System.currentTimeMillis();
            v2protocal com_tencent_mm_plugin_voip_model_v2protocal = beb.gGO;
            com_tencent_mm_plugin_voip_model_v2protocal.netType = com.tencent.mm.plugin.voip.b.a.getNetType(aa.getContext());
            com_tencent_mm_plugin_voip_model_v2protocal.kvG = com_tencent_mm_plugin_voip_model_v2protocal.netType;
            com.tencent.mm.plugin.voip_cs.b.b.bed().kvG = com_tencent_mm_plugin_voip_model_v2protocal.netType;
            if (com_tencent_mm_plugin_voip_model_v2protocal.netType == 5) {
                com_tencent_mm_plugin_voip_model_v2protocal.netType = 4;
            }
            boolean z = com_tencent_mm_plugin_voip_model_v2protocal.kvG >= 4 && (v2protocal.kjU & 1024) != 0 && (v2protocal.kjU & 255) >= 30;
            boolean z2 = p.ceA.cdd == 1 && p.ceA.ccG.width >= 480 && p.ceA.ccG.height >= 360 && p.ceA.ccI.width >= 480 && p.ceA.ccI.height >= 360;
            boolean z3 = p.ceA.cdd == 0;
            if ((z || z2) && !z3) {
                com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth = 480;
                com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight = 360;
                v2protocal.kvD = true;
                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip", "steve:Set Enable 480! " + com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth + "x" + com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight);
            }
            com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip", "steve: Android CPUFlag:" + (v2protocal.kjU & 255) + ", 480x360 Enc flags: bEnable480FromLocal:" + z + ", bEnable480FromSvr:" + z2 + ", bDisable480FromSvr:" + z3);
            com_tencent_mm_plugin_voip_model_v2protocal.kwx = new int[(com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth * com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight)];
            ak.yW();
            com_tencent_mm_plugin_voip_model_v2protocal.kvF = com.tencent.mm.model.c.ww();
            if ((v2protocal.kjU & 1024) != 0) {
                com.tencent.mm.compatible.loader.d.v(aa.getContext(), "libvoipCodec_v7a.so");
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
            } else if ((v2protocal.kjU & 512) != 0) {
                com.tencent.mm.compatible.loader.d.v(aa.getContext(), "libvoipCodec.so");
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
            } else {
                com.tencent.mm.compatible.loader.d.v(aa.getContext(), "libvoipCodec_v5.so");
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
            }
            int i = VERSION.SDK_INT;
            int bdM = OpenGlRender.bdM();
            Display defaultDisplay = ((WindowManager) aa.getContext().getSystemService("window")).getDefaultDisplay();
            init = com_tencent_mm_plugin_voip_model_v2protocal.init(com_tencent_mm_plugin_voip_model_v2protocal.netType, 2, (com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth << 16) | com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight, (defaultDisplay.getWidth() << 16) | defaultDisplay.getHeight(), com_tencent_mm_plugin_voip_model_v2protocal.kvF, ((i << 16) | (bdM << 24)) | v2protocal.kjU, e.cnf + "app_lib/", 8);
            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip", "protocal init ret :" + init + ",uin= " + com_tencent_mm_plugin_voip_model_v2protocal.kvF);
            com_tencent_mm_plugin_voip_model_v2protocal.hqt = true;
            if (init < 0) {
                com_tencent_mm_plugin_voip_model_v2protocal.reset();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            v.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", new Object[]{Integer.valueOf(init), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
            if (init < 0) {
                v.e("MicroMsg.VoipCSEngine", "engine init failed!");
            }
            d bec = com.tencent.mm.plugin.voip_cs.b.b.bec();
            String str = this.kEf;
            String str2 = this.appId;
            String str3 = this.kET;
            v.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + str + ",appid:" + str2 + ",voipCSContext:" + str3);
            bec.kEf = str;
            bec.kEe = 1;
            com.tencent.mm.plugin.voip_cs.b.c bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
            v.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
            if (bed.kDR == 0) {
                bed.kDR = (int) (System.currentTimeMillis() / 1000);
            }
            byte[] bArr = null;
            if (!(str3 == null || str3.equals(""))) {
                bArr = str3.getBytes();
            }
            ak.vy().a(823, bec);
            com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.gFJ = (int) (System.currentTimeMillis() / 1000);
            com.tencent.mm.plugin.voip_cs.b.c.c cVar = new com.tencent.mm.plugin.voip_cs.b.c.c(com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.gFJ, str, com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.netType, bArr, com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.field_capInfo, str2);
            v.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.field_capInfo));
            ak.vy().a(cVar, 0);
        }
        if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe < 2) {
            this.kEk.bek();
        }
        f fVar = this.kEO;
        v.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
        if (fVar.hBQ == null) {
            v.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
            fVar.hBQ = new ObservableTextureView(fVar.kEl);
            fVar.hBQ.setLayoutParams(new LayoutParams(1, 1));
            fVar.kEm.addView(fVar.hBQ, new LayoutParams(1, 1));
            fVar.hBQ.setVisibility(0);
        }
        if (fVar.hBO == null) {
            init = 320;
            int i2 = 240;
            com.tencent.mm.plugin.voip_cs.b.b.beb();
            if (v2protocal.kvD) {
                init = 640;
                i2 = 480;
            }
            v.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
            fVar.hBO = new com.tencent.mm.plugin.voip.video.a(init, i2);
            fVar.hBO.a(fVar, true);
            fVar.hBO.a(fVar.hBQ);
            com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kvS = fVar.hBO.bdJ();
            fVar.hBO.bdE();
            fVar.hBO.bdK();
            v.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[]{Boolean.valueOf(fVar.hBO.bdH()), Boolean.valueOf(fVar.hBO.bdI())});
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        if (i == 25) {
            ak.yX().dO(auE());
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            ak.yX().dN(auE());
            return true;
        }
    }

    private int auE() {
        int i = 2;
        if (this.kEk.bcI()) {
            if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe != 2) {
                c cVar = this.kEP;
                if (cVar.ksw != null) {
                    i = cVar.ksw.bbu();
                }
            }
            i = 0;
        }
        v.d("MicroMsg.voipcs.VoipCSMainUI", "Current StreamType:%d", new Object[]{Integer.valueOf(i)});
        return i;
    }

    protected void onResume() {
        v.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
        super.onResume();
        if (this.kEO != null) {
            this.kEO.beg = false;
            if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe > 1) {
                bes();
                if (this.kES != null && this.kES.equals("1")) {
                    this.kEO.bep();
                }
            }
        }
        if (this.gPw != null) {
            this.gPw.QI();
        }
        ak.oH().cancel(44);
    }

    protected void onPause() {
        super.onPause();
        if (!this.kEk.bcI()) {
            this.kEk.aCp();
        }
        if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe == 1 || com.tencent.mm.plugin.voip_cs.b.b.bec().kEe == 2) {
            CharSequence string = aa.getContext().getString(2131235889);
            Intent intent = new Intent(aa.getContext(), VoipCSMainUI.class);
            intent.putExtra("voipCSBizId", this.kEf);
            intent.putExtra("voipCSAppId", this.appId);
            Notification notification = new Builder(aa.getContext()).setTicker(aa.getContext().getString(2131235889)).setWhen(System.currentTimeMillis()).setContentTitle(aa.getContext().getString(2131235883)).setContentText(string).setContentIntent(PendingIntent.getActivity(aa.getContext(), 44, intent, 134217728)).setOngoing(true).getNotification();
            notification.icon = com.tencent.mm.ax.a.bmo();
            notification.flags |= 32;
            ak.oH().a(44, notification, false);
            if (this.gPw != null && this.gPw.btC()) {
                this.gPw.ea(5000);
            }
        } else {
            ak.oH().cancel(44);
            if (this.gPw != null) {
                this.gPw.QI();
            }
        }
        this.kEO.ben();
        this.kEO.beg = true;
    }

    protected void onRestart() {
        v.i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
        super.onRestart();
        if (bet() && com.tencent.mm.plugin.voip_cs.b.b.bec().kEe <= 1) {
            bes();
        }
        if (this.kEO != null) {
            this.kEO.beg = false;
        }
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        int i;
        int i2 = 2;
        v.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
        if (this.aUX != null) {
            this.aUX.si();
        }
        op opVar = new op();
        if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEg == -1) {
            opVar.bpV.status = 3;
        } else if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEg == 823) {
            opVar.bpV.status = 4;
        } else if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe <= 1) {
            opVar.bpV.status = 1;
        } else if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe >= 2) {
            opVar.bpV.status = 2;
        }
        com.tencent.mm.sdk.c.a.nhr.z(opVar);
        c cVar = this.kEP;
        com.tencent.mm.plugin.voip_cs.b.c bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
        if (cVar.ksw == null || com.tencent.mm.plugin.voip_cs.b.b.bed().kDD != 1) {
            i = 0;
        } else {
            i = cVar.ksw.bbu();
        }
        bed.kDN = (int) ((((float) ak.yX().getStreamVolume(i)) / ((float) ak.yX().getStreamMaxVolume(i))) * 100.0f);
        bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
        if (cVar.hza == null || com.tencent.mm.plugin.voip_cs.b.b.bed().kDD != 1) {
            i = 0;
        } else {
            i = cVar.hza.pl();
        }
        bed.kvY = i;
        if (cVar.hza != null) {
            cVar.hza.pb();
        }
        if (cVar.ksw != null) {
            cVar.ksw.bbs();
        }
        this.kEk.aCp();
        if (this.kEO != null) {
            com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.kEO;
            if (com.tencent.mm.plugin.voip_cs.b.b.bed().aKG == 0) {
                if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe < 2) {
                    com.tencent.mm.plugin.voip_cs.b.b.bed().aKG = 1;
                } else {
                    com.tencent.mm.plugin.voip_cs.b.b.bed().aKG = 3;
                }
            }
            bVar.kxR.bdN();
            bVar.kxS.bdN();
            bVar.ben();
            bVar.beq();
            d bec = com.tencent.mm.plugin.voip_cs.b.b.bec();
            v.i("MicroMsg.voipcs.VoipCSService", "now stop service");
            ak.vy().b(823, bec);
            ak.vy().b(455, bec);
            ak.vy().b(818, bec);
            ak.vy().b(795, bec);
            ak.vy().b(285, bec);
            ak.vy().b(312, bec);
            bec.kEe = 3;
            if (bec.kEg != 823) {
                ak.vy().a(880, bec);
                if (bec.kDZ == 0) {
                    i2 = 1;
                } else if (bec.kDZ != 2) {
                    i2 = bec.kDZ == 3 ? 3 : 4;
                }
                v.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + bec.kEf + ",inviteId：" + com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.gFJ + ",csroomId:" + com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kvI + ",roomkey:" + com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.gFH + ",reason:" + i2);
                ak.vy().a(new com.tencent.mm.plugin.voip_cs.b.c.a(com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.gFJ, com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kvI, com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.gFH, bec.kEf, i2), 0);
            }
            bec.kEh.QI();
            bec.kEi.QI();
            bec.kDY = 0;
            bec.kDu = 0;
            bec.kDZ = 0;
            bec.kEa = 0;
            bec.kEb = null;
            bec.gFR = 0;
            bec.kEc = 0;
            bec.kEe = 0;
            bec.kEf = "";
            bec.kEd = 0;
            bec.kEg = 0;
            com.tencent.mm.plugin.voip_cs.b.b.a beb = com.tencent.mm.plugin.voip_cs.b.b.beb();
            v.i("MicroMsg.VoipCSEngine", "now stop engine");
            beb.gGO.gU(true);
            com.tencent.mm.plugin.voip_cs.b.c bed2 = com.tencent.mm.plugin.voip_cs.b.b.bed();
            if (be.kS(bed2.gHo) && be.kS(bed2.gHn)) {
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = com.tencent.mm.plugin.voip_cs.b.b.beb().gGO;
                com_tencent_mm_plugin_voip_model_v2protocal.getVoipcsChannelInfo(com_tencent_mm_plugin_voip_model_v2protocal.kxb, com_tencent_mm_plugin_voip_model_v2protocal.kxb.length, bed2.kDB == 1 ? 1 : 0);
                v.d("MicroMsg.Voip", "field_voipcsEngineInfoLength: %d", new Object[]{Integer.valueOf(com_tencent_mm_plugin_voip_model_v2protocal.field_voipcsChannelInfoLength)});
                bed2.gHo = new String(com_tencent_mm_plugin_voip_model_v2protocal.kxb, 0, com_tencent_mm_plugin_voip_model_v2protocal.field_voipcsChannelInfoLength);
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal2 = com.tencent.mm.plugin.voip_cs.b.b.beb().gGO;
                com_tencent_mm_plugin_voip_model_v2protocal2.getVoipcsEngineInfo(com_tencent_mm_plugin_voip_model_v2protocal2.kxc, com_tencent_mm_plugin_voip_model_v2protocal2.kxc.length);
                v.d("MicroMsg.Voip", "field_voipcsEngineInfoLength: %d", new Object[]{Integer.valueOf(com_tencent_mm_plugin_voip_model_v2protocal2.field_voipcsEngineInfoLength)});
                String str = com_tencent_mm_plugin_voip_model_v2protocal2.gFO + "," + com_tencent_mm_plugin_voip_model_v2protocal2.gFH + "," + com_tencent_mm_plugin_voip_model_v2protocal2.kvI + "," + com.tencent.mm.plugin.voip_cs.b.b.bed().kDD + "," + com_tencent_mm_plugin_voip_model_v2protocal2.kvS + "," + com_tencent_mm_plugin_voip_model_v2protocal2.kvT + com_tencent_mm_plugin_voip_model_v2protocal2.bdb() + new String(com_tencent_mm_plugin_voip_model_v2protocal2.kxc, 0, com_tencent_mm_plugin_voip_model_v2protocal2.field_voipcsEngineInfoLength);
                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip", "voipreport:NewEngineString:" + str);
                bed2.gHn = str;
                v.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", new Object[]{bed2.gHo});
                v.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", new Object[]{bed2.gHn});
            }
            ak.vy().a(312, com.tencent.mm.plugin.voip_cs.b.b.bec());
            ak.vy().a(new com.tencent.mm.plugin.voip_cs.b.c.e(com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kvI, com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.gFH), 0);
            beb.gGO.reset();
            k.bct().bcv();
            k.bct().kuD = null;
        }
        this.kEO = null;
        this.kEP = null;
        ak.yX().setMode(0);
        aa.getContext().unregisterReceiver(this.kun);
        ak.yX().b(this.kEV);
        ak.yX().qT();
        this.kEU.QI();
        if (this.ktI != null) {
            this.ktI.cD(aa.getContext());
        }
        ak.b(this.ixZ);
        if (this.gPw != null) {
            this.gPw.QI();
        }
        ak.oH().cancel(44);
        if (!(this.ktJ == null || this.kuq == null)) {
            this.ktJ.listen(this.kuq, 0);
            this.kuq = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904594;
    }

    public final void sd(int i) {
        v.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + i + ",CallingStatus:" + com.tencent.mm.plugin.voip_cs.b.b.bec().kEe);
        if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe == 0) {
            finish();
        } else if (this.kEO != null) {
            this.kEO.onFinish(i);
        }
    }

    public final void onError(int i) {
        if (this.kEO != null) {
            v.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:" + i);
            this.kEO.onFinish(i);
        }
    }

    public final void cV(String str, String str2) {
        com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.kEO;
        if (bVar.kEB.equals("") && h.isNullOrEmpty(str2)) {
            bVar.euh.setText(2131235876);
        } else {
            bVar.CR(str2);
        }
        if (bVar.kEA.equals("") && h.isNullOrEmpty(str) && (bVar.kEl.fSc == null || bVar.kEl.fSc.equals(""))) {
            bVar.kEr.setImageResource(2130838080);
            return;
        }
        SharedPreferences btk = aa.btk();
        if (!(h.isNullOrEmpty(str) || bVar.kEA.equals(str))) {
            bVar.CS(str);
            btk.edit().putString(bVar.bel(), str).commit();
        }
        if (!h.isNullOrEmpty(str2) && !bVar.kEB.equals(str2)) {
            bVar.CR(str2);
            btk.edit().putString(bVar.bem(), str2).commit();
        }
    }

    private boolean bet() {
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            v.d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, "", "")), be.bur(), this});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, "", "")) {
                return true;
            }
            v.i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
            return false;
        }
        v.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 2131234163;
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            v.e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", new Object[]{Integer.valueOf(i)});
            return;
        }
        v.d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    bes();
                    return;
                }
                if ("android.permission.CAMERA".equals(strArr[0])) {
                    i2 = 2131234160;
                }
                g.a(this, getString(i2), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                    final /* synthetic */ VoipCSMainUI kEW;

                    {
                        this.kEW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.kEW.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ VoipCSMainUI kEW;

                    {
                        this.kEW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.kEW.sd(3);
                    }
                });
                return;
            case 82:
                if (iArr[0] == 0) {
                    v.d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
                    if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, "", "")) {
                        bes();
                        return;
                    }
                    return;
                }
                g.a(this, getString(2131234163), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                    final /* synthetic */ VoipCSMainUI kEW;

                    {
                        this.kEW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kEW.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ VoipCSMainUI kEW;

                    {
                        this.kEW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.kEW.sd(2);
                    }
                });
                return;
            default:
                return;
        }
    }

    public final void atQ() {
        int i;
        com.tencent.mm.plugin.voip_cs.b.c bed;
        this.kEO.atQ();
        if (ak.yX().ra() || ak.yX().qU()) {
            this.kEP.gN(false);
        } else {
            this.kEP.gN(true);
        }
        c cVar = this.kEP;
        if (cVar.hza != null) {
            boolean pj = cVar.hza.pj();
            com.tencent.mm.plugin.voip_cs.b.b.bed().kDD = 1;
            if (pj) {
                i = 1;
                com.tencent.mm.plugin.voip_cs.b.b.bed().kDW = i;
                cVar = this.kEP;
                if (cVar.ksw != null) {
                    com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kvT = Math.abs(1);
                } else {
                    cVar.ksw.bbq();
                    if (cVar.ksw.bbq() <= 0) {
                        com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kvT = Math.abs(1);
                    }
                }
                this.kEk.aCp();
                bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
                if (bed.kDR != 0) {
                    bed.kDG = ((int) (System.currentTimeMillis() / 1000)) - bed.kDR;
                }
                bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
                v.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
                if (bed.kDU == 0) {
                    bed.kDU = (int) (System.currentTimeMillis() / 1000);
                }
                bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
                v.d("MicroMsg.VoipCSReportHelper", "markConnect");
                if (bed.kDT != 0) {
                    bed.kDI = (long) (((int) (System.currentTimeMillis() / 1000)) - bed.kDT);
                }
            }
        }
        i = -1;
        com.tencent.mm.plugin.voip_cs.b.b.bed().kDW = i;
        cVar = this.kEP;
        if (cVar.ksw != null) {
            cVar.ksw.bbq();
            if (cVar.ksw.bbq() <= 0) {
                com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kvT = Math.abs(1);
            }
        } else {
            com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kvT = Math.abs(1);
        }
        this.kEk.aCp();
        bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
        if (bed.kDR != 0) {
            bed.kDG = ((int) (System.currentTimeMillis() / 1000)) - bed.kDR;
        }
        bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
        v.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
        if (bed.kDU == 0) {
            bed.kDU = (int) (System.currentTimeMillis() / 1000);
        }
        bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
        v.d("MicroMsg.VoipCSReportHelper", "markConnect");
        if (bed.kDT != 0) {
            bed.kDI = (long) (((int) (System.currentTimeMillis() / 1000)) - bed.kDT);
        }
    }

    public final void ber() {
        v.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
        this.kEO.onFinish(5);
    }
}
