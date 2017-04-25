package com.tencent.mm.plugin.voip.ui;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.af.b;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.hc;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.e;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.j.AnonymousClass12;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.ui.c.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSuperAlert;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@a(3)
@SuppressLint({"SimpleDateFormat"})
public class VideoActivity extends MMActivity implements a, c, SensorController.a {
    private boolean aUy = false;
    private String bZy;
    private TelephonyManager gPp = null;
    private ac ihw;
    private CaptureView ktM;
    private u ktQ;
    private boolean ktR;
    private boolean ktS;
    private int ktW = 1;
    private c kxk;
    private WeakReference<b> kxl;
    private SensorController kxm;
    private long kxn = -1;
    private boolean kxo = false;
    private long kxp = 0;
    private boolean kxq = false;
    private int kxr = 1;
    private boolean kxs = false;
    private boolean kxt = false;
    private long kxu;
    private int mStatus;

    static /* synthetic */ void a(VideoActivity videoActivity, int i) {
        int i2;
        int i3 = 2131235901;
        v.d("MicroMsg.Voip.VideoActivity", "getHintByErrorCode " + i);
        if (i == 235) {
            i2 = 2131235903;
        } else if (i == 233) {
            d.bbw().bcG();
            i2 = 2131235902;
        } else {
            i2 = i == 237 ? (!b.He() || videoActivity.ktS) ? 2131235904 : 2131235906 : i == 236 ? 2131235918 : i == 211 ? 2131235905 : 0;
        }
        if (i2 != 0 || videoActivity.kxk == null) {
            if (i2 != 0) {
                i3 = i2;
            }
            MMSuperAlert.W(videoActivity, i3);
            return;
        }
        videoActivity.kxk.bf(videoActivity.getString(2131235901), -1);
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        boolean a;
        super.onCreate(bundle);
        if (!com.tencent.mm.plugin.voip.b.d.cF(this.nDR.nEl)) {
            com.tencent.mm.plugin.voip.b.d.cG(this.nDR.nEl);
        }
        v.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
        cU().cV().hide();
        getWindow().setSoftInputMode(3);
        getWindow().addFlags(6815872);
        if (ak.uz()) {
            d.bbw().t(false, false);
        }
        this.ihw = new ac();
        PBool pBool = new PBool();
        PBool pBool2 = new PBool();
        PString pString = new PString();
        PInt pInt = new PInt();
        pString.value = getIntent().getStringExtra("Voip_User");
        pBool.value = getIntent().getBooleanExtra("Voip_Outcall", true);
        pBool2.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
        this.kxu = getIntent().getLongExtra("Voip_LastPage_Hash", 0);
        pInt.value = com.tencent.mm.plugin.voip.b.b.w(pBool.value, pBool2.value);
        if (pBool.value) {
            try {
                if (aCq()) {
                    Toast.makeText(this, 2131235937, 0).show();
                    v.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
                    super.finish();
                    return;
                }
            } catch (Exception e) {
                v.e("MicroMsg.Voip.VideoActivity", "not ready now!");
            }
        }
        m bbw = d.bbw();
        if (bbw.kuP != null) {
            v.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
            pString.value = bbw.kuP.bZy;
            pBool.value = bbw.kuP.ktR;
            pBool2.value = bbw.kuP.ktS;
            pInt.value = bbw.kuP.ktH.mState;
        } else {
            if (pString.value == null) {
                v.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
                obj = null;
            } else if (pBool.value || bbw.kuO.bbD()) {
                String str;
                j jVar;
                List g;
                com.tencent.mm.plugin.voip.video.j jVar2;
                IntentFilter intentFilter;
                bbw.kuP = new j();
                j jVar3 = bbw.kuP;
                String str2 = pString.value;
                boolean z = pBool.value;
                boolean z2 = pBool2.value;
                v.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[]{str2, Boolean.valueOf(z), Boolean.valueOf(z2)});
                jVar3.kuk = true;
                jVar3.bZy = str2;
                jVar3.ktR = z;
                jVar3.ktS = z2;
                ak.yW();
                jVar3.ktQ = com.tencent.mm.model.c.wH().LX(jVar3.bZy);
                jVar3.ihw = new ac();
                jVar3.ktT = be.getInt(com.tencent.mm.h.j.sU().getValue("VOIPCameraSwitch"), 1) == 0;
                if (!jVar3.ktS) {
                    jVar3.ktT = false;
                }
                int w = com.tencent.mm.plugin.voip.b.b.w(z, z2);
                if (jVar3.ktT) {
                    if (w == 0) {
                        w = 1;
                    } else if (256 == w) {
                        w = 257;
                    }
                }
                if (z) {
                    jVar3.ktH = com.tencent.mm.plugin.voip.b.b.rX(w);
                } else {
                    jVar3.ktH = com.tencent.mm.plugin.voip.b.b.rW(w);
                }
                boolean se = com.tencent.mm.compatible.e.b.se();
                boolean sf = com.tencent.mm.compatible.e.b.sf();
                if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                    g gVar;
                    Object[] objArr;
                    if (!se) {
                        gVar = g.iuh;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(jVar3.ktS ? 0 : 1);
                        objArr[1] = Integer.valueOf(1);
                        gVar.h(11306, objArr);
                    }
                    if (!sf) {
                        gVar = g.iuh;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(jVar3.ktS ? 0 : 1);
                        objArr[1] = Integer.valueOf(0);
                        gVar.h(11306, objArr);
                    }
                }
                if (!(sf && se)) {
                    String str3 = null;
                    str = null;
                    if (!se && !sf) {
                        str3 = getString(2131231159);
                        str = getString(2131231097);
                    } else if (!se) {
                        str3 = getString(2131231161);
                        str = getString(2131231098);
                    } else if (!sf) {
                        str3 = getString(2131231160);
                        str = getString(2131231099);
                    }
                    com.tencent.mm.ui.base.g.a(this, str3, str, getString(2131231100), true, new AnonymousClass12(jVar3, this));
                }
                v.i("MicroMsg.Voip.VoipMgr", "initMgr");
                ak.oJ().pU();
                ak.yX().b(jVar3);
                ak.yX().a(jVar3);
                jVar3.ihw.postDelayed(new Runnable(jVar3) {
                    final /* synthetic */ j kus;

                    {
                        this.kus = r1;
                    }

                    public final void run() {
                        v.d("MicroMsg.Voip.VoipMgr", "onVoipUICreated, isBluetoothCanUse: %b, isBluetoothOn: %b", new Object[]{Boolean.valueOf(com.tencent.mm.compatible.b.d.qX()), Boolean.valueOf(ak.yX().qU())});
                        ak.yX().qS();
                    }
                }, 2000);
                jVar3.aUX = new com.tencent.mm.compatible.util.b(aa.getContext());
                jVar3.aUX.requestFocus();
                if (jVar3.ktS) {
                    d.bbw().a(true, true, jVar3.bZy);
                } else {
                    d.bbw().a(true, false, jVar3.bZy);
                }
                if (jVar3.ktR) {
                    d.bbw().kuO.bcM();
                    if ((jVar3.ktS ? d.bbw().kuO.be(jVar3.ktQ.field_username, 0) : d.bbw().kuO.be(jVar3.ktQ.field_username, 1)) < 0) {
                        jVar3.gP(false);
                    }
                }
                jVar3.ktI = new HeadsetPlugReceiver();
                jVar3.ktI.a(aa.getContext(), jVar3.kup);
                m bbw2 = d.bbw();
                Context context = aa.getContext();
                n nVar = bbw2.kuO;
                nVar.kqI.fda = context;
                nVar.kqI.ksd = jVar3;
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipServiceEx", "attach ui........");
                jVar3.ktJ = (TelephonyManager) aa.getContext().getSystemService("phone");
                jVar3.ktJ.listen(jVar3.kuq, 32);
                w = jVar3.ktS ? 0 : 1;
                m bbw3 = d.bbw();
                z2 = jVar3.ktR;
                n nVar2 = bbw3.kuO;
                if (nVar2.kve != null) {
                    nVar2.kve.j(2131165830, w, z2);
                }
                if (ak.yX().ra()) {
                    w = 3;
                    jVar = jVar3;
                } else if (ak.yX().qU()) {
                    w = 4;
                    jVar = jVar3;
                } else if (jVar3.ktS) {
                    w = 1;
                    jVar = jVar3;
                } else {
                    w = 2;
                    jVar = jVar3;
                }
                jVar.ktW = w;
                if (jVar3.ktW != 1) {
                    jVar3.ktZ = false;
                } else {
                    jVar3.ktZ = true;
                }
                str2 = "voip_recent_contact" + k.xF();
                SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("voip_plugin_prefs", 0);
                str = sharedPreferences.getString(str2, null);
                if (str != null) {
                    g = be.g(str.split(";"));
                    if (g != null) {
                        int size = g.size();
                        if (g.contains(jVar3.bZy)) {
                            if (size > 1) {
                                g.remove(jVar3.bZy);
                            }
                            sharedPreferences.edit().putString(str2, be.b(g, ";")).commit();
                            com.tencent.mm.sdk.c.a.nhr.e(jVar3.kur);
                            com.tencent.mm.sdk.c.a.nhr.e(jVar3.kuo);
                            jVar2 = jVar3.kud;
                            if (!jVar2.epu.contains(jVar3)) {
                                jVar2.epu.add(jVar3);
                            }
                            intentFilter = new IntentFilter();
                            intentFilter.addAction("android.intent.action.SCREEN_ON");
                            intentFilter.addAction("android.intent.action.SCREEN_OFF");
                            intentFilter.addAction("android.intent.action.USER_PRESENT");
                            aa.getContext().registerReceiver(jVar3.kun, intentFilter);
                        } else if (4 == size) {
                            g.remove(size - 1);
                        }
                        g.add(0, jVar3.bZy);
                        sharedPreferences.edit().putString(str2, be.b(g, ";")).commit();
                        com.tencent.mm.sdk.c.a.nhr.e(jVar3.kur);
                        com.tencent.mm.sdk.c.a.nhr.e(jVar3.kuo);
                        jVar2 = jVar3.kud;
                        if (jVar2.epu.contains(jVar3)) {
                            jVar2.epu.add(jVar3);
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        intentFilter.addAction("android.intent.action.USER_PRESENT");
                        aa.getContext().registerReceiver(jVar3.kun, intentFilter);
                    }
                }
                g = new ArrayList();
                g.add(0, jVar3.bZy);
                sharedPreferences.edit().putString(str2, be.b(g, ";")).commit();
                com.tencent.mm.sdk.c.a.nhr.e(jVar3.kur);
                com.tencent.mm.sdk.c.a.nhr.e(jVar3.kuo);
                jVar2 = jVar3.kud;
                if (jVar2.epu.contains(jVar3)) {
                    jVar2.epu.add(jVar3);
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                aa.getContext().registerReceiver(jVar3.kun, intentFilter);
            } else {
                v.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
                l.a(pString.value, pBool2.value ? at.nvC : at.nvB, pBool.value ? 1 : 0, 4, aa.getContext().getString(2131235859));
                obj = null;
            }
            if (obj != null) {
                v.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
                super.finish();
            }
            this.kxl = new WeakReference(obj);
            this.bZy = pString.value;
            this.ktS = pBool2.value;
            this.ktR = pBool.value;
            this.mStatus = pInt.value;
            ak.yW();
            this.ktQ = com.tencent.mm.model.c.wH().LX(this.bZy);
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_username", this.ktQ.field_username);
            bundle2.putBoolean("key_isoutcall", this.ktR);
            bundle2.putInt("key_status", com.tencent.mm.plugin.voip.b.b.w(this.ktR, this.ktS));
            if (com.tencent.mm.plugin.voip.b.b.rZ(this.mStatus)) {
                this.kxk = new e();
            } else {
                this.kxk = new d();
            }
            this.kxk.setArguments(bundle2);
            aS().aW().b(2131759700, this.kxk).commit();
            vB(8);
            if (com.tencent.mm.plugin.voip.b.b.sa(this.mStatus) && this.ktR) {
                this.ihw.postDelayed(new Runnable(this) {
                    final /* synthetic */ VideoActivity kxv;

                    {
                        this.kxv = r1;
                    }

                    public final void run() {
                        if (com.tencent.mm.plugin.voip.b.b.sa(this.kxv.mStatus) && !this.kxv.kxo && this.kxv.kxk != null) {
                            this.kxv.kxk.bf(this.kxv.getString(2131235873), 10000);
                        }
                    }
                }, 20000);
            }
            this.kxk.a((b) this.kxl.get());
            this.kxk.a((c) this);
            this.kxk.rQ(this.ktW);
            this.kxk.dJ(this.aUy);
            this.kxm = new SensorController(this.nDR.nEl);
            if (!(this.kxl == null || this.kxl.get() == null)) {
                ((b) this.kxl.get()).a(this, 1);
            }
            v.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[]{Boolean.valueOf(this.ktR), Boolean.valueOf(this.ktS), this.bZy, Integer.valueOf(this.mStatus)});
            if (this.kxm != null) {
                v.d("MicroMsg.Voip.VideoActivity", "onCreate setSensorCallBack");
                this.kxm.a(this);
            }
            if (com.tencent.mm.plugin.voip.b.b.rZ(this.mStatus)) {
                a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
                v.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), be.bur(), this});
                return;
            }
            a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, "", "");
            v.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), be.bur(), this});
            a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
            v.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), be.bur(), this});
            return;
        }
        obj = bbw.kuP;
        if (obj != null) {
            this.kxl = new WeakReference(obj);
            this.bZy = pString.value;
            this.ktS = pBool2.value;
            this.ktR = pBool.value;
            this.mStatus = pInt.value;
            ak.yW();
            this.ktQ = com.tencent.mm.model.c.wH().LX(this.bZy);
            Bundle bundle22 = new Bundle();
            bundle22.putString("key_username", this.ktQ.field_username);
            bundle22.putBoolean("key_isoutcall", this.ktR);
            bundle22.putInt("key_status", com.tencent.mm.plugin.voip.b.b.w(this.ktR, this.ktS));
            if (com.tencent.mm.plugin.voip.b.b.rZ(this.mStatus)) {
                this.kxk = new e();
            } else {
                this.kxk = new d();
            }
            this.kxk.setArguments(bundle22);
            aS().aW().b(2131759700, this.kxk).commit();
            vB(8);
            this.ihw.postDelayed(/* anonymous class already generated */, 20000);
            this.kxk.a((b) this.kxl.get());
            this.kxk.a((c) this);
            this.kxk.rQ(this.ktW);
            this.kxk.dJ(this.aUy);
            this.kxm = new SensorController(this.nDR.nEl);
            ((b) this.kxl.get()).a(this, 1);
            v.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[]{Boolean.valueOf(this.ktR), Boolean.valueOf(this.ktS), this.bZy, Integer.valueOf(this.mStatus)});
            if (this.kxm != null) {
                v.d("MicroMsg.Voip.VideoActivity", "onCreate setSensorCallBack");
                this.kxm.a(this);
            }
            if (com.tencent.mm.plugin.voip.b.b.rZ(this.mStatus)) {
                a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
                v.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), be.bur(), this});
                return;
            }
            a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, "", "");
            v.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), be.bur(), this});
            a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
            v.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), be.bur(), this});
            return;
        }
        v.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
        super.finish();
    }

    private static boolean aCq() {
        Exception e;
        boolean z;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) aa.getContext().getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            switch (telephonyManager.getCallState()) {
                case 0:
                    z = false;
                    break;
                case 1:
                case 2:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            try {
                v.i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", new Object[]{Integer.valueOf(r2)});
                return z;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            v.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", new Object[]{e.getLocalizedMessage()});
            return z;
        }
    }

    protected final int NO() {
        return 1;
    }

    private void bcg() {
        this.ihw.postDelayed(new Runnable(this) {
            final /* synthetic */ VideoActivity kxv;

            {
                this.kxv = r1;
            }

            public final void run() {
                this.kxv.finish();
            }
        }, 2000);
    }

    public final void cC(int i, int i2) {
        this.mStatus = i2;
        if (1 != this.kxr && i2 != 8 && i2 != 262) {
            v.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
        } else if (this.kxk == null) {
            v.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
        } else {
            this.kxk.cC(i, i2);
            switch (i2) {
                case 1:
                case 3:
                case 7:
                case 257:
                case 261:
                    if (this.kxk == null || !(this.kxk instanceof e)) {
                        if (this.kxk != null) {
                            this.kxk.uninit();
                            aS().aW().a(this.kxk).commit();
                            this.kxk = null;
                        }
                        v.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
                        Bundle bundle = new Bundle();
                        bundle.putString("key_username", this.ktQ.field_username);
                        bundle.putBoolean("key_isoutcall", this.ktR);
                        bundle.putInt("key_status", this.mStatus);
                        this.kxk = new e();
                        this.kxk.setArguments(bundle);
                        this.kxk.a((b) this.kxl.get());
                        this.kxk.ds(this.kxn);
                        this.kxk.a((c) this);
                        this.kxk.rQ(this.ktW);
                        this.kxk.dJ(this.aUy);
                        this.kxk.b(this.ktM);
                        aS().aW().b(2131759700, this.kxk).commit();
                        return;
                    }
                    return;
                case 8:
                case 262:
                    switch (i) {
                        case 4098:
                            this.ihw.postDelayed(new Runnable(this) {
                                final /* synthetic */ VideoActivity kxv;

                                {
                                    this.kxv = r1;
                                }

                                public final void run() {
                                    this.kxv.bcg();
                                }
                            }, 50);
                            break;
                        case 4099:
                            if (this.ktR) {
                                this.kxk.bf(getString(2131235866), -1);
                            }
                            bcg();
                            break;
                        case 4103:
                        case 4104:
                            bcg();
                            break;
                        case 4106:
                            this.ihw.post(new Runnable(this) {
                                final /* synthetic */ VideoActivity kxv;

                                {
                                    this.kxv = r1;
                                }

                                public final void run() {
                                    if (this.kxv.kxk != null) {
                                        this.kxv.kxk.bf(this.kxv.getString(2131235945), -1);
                                    }
                                    this.kxv.bcg();
                                }
                            });
                            break;
                        case 4107:
                            finish();
                            break;
                        case 4109:
                            this.ihw.post(new Runnable(this) {
                                final /* synthetic */ VideoActivity kxv;

                                {
                                    this.kxv = r1;
                                }

                                public final void run() {
                                    this.kxv.bcg();
                                }
                            });
                            break;
                    }
                    bcg();
                    return;
                default:
                    return;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        if (i == 25) {
            if (d.bbw().bcI() || this.ktR) {
                ak.yX().dO(auE());
                return true;
            }
            d.bbw().aCp();
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            if (d.bbw().bcI() || this.ktR) {
                ak.yX().dN(auE());
                return true;
            }
            d.bbw().aCp();
            return true;
        }
    }

    protected void onDestroy() {
        this.kxr = 4;
        v.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.rV(this.mStatus)});
        if (!this.kxt) {
            finish();
        }
        if (this.kxm != null && this.kxm.nll) {
            v.d("MicroMsg.Voip.VideoActivity", "onDestroy removeSensorCallBack");
            ca(true);
            this.kxm.btX();
        }
        if (!(this.kxl == null || this.kxl.get() == null)) {
            ((b) this.kxl.get()).a(this);
        }
        this.kxm = null;
        super.onDestroy();
    }

    protected void onStop() {
        this.kxr = 2;
        v.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.rV(this.mStatus)});
        super.onStop();
        if (262 != this.mStatus && 8 != this.mStatus && this.kxs && !this.kxt && this.kxl != null && this.kxl.get() != null) {
            ((b) this.kxl.get()).gQ(false);
            v(false, true);
            if (com.tencent.mm.plugin.voip.b.b.rY(this.mStatus)) {
                g gVar = g.iuh;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(com.tencent.mm.plugin.voip.b.b.rZ(this.mStatus) ? 2 : 3);
                objArr[1] = Integer.valueOf(2);
                gVar.h(11618, objArr);
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.kxt) {
            v.i("MicroMsg.Voip.VideoActivity", "onStart");
            this.kxr = 1;
            cC(4096, this.mStatus);
        }
    }

    public void finish() {
        boolean z;
        this.kxr = 3;
        v.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", new Object[]{Boolean.valueOf(this.kxq), com.tencent.mm.plugin.voip.b.b.rV(this.mStatus)});
        if (!(this.kxq || !com.tencent.mm.plugin.voip.b.b.rY(this.mStatus) || 4 == this.kxr)) {
            v.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", this.bZy);
            com.tencent.mm.plugin.voip.a.a.drp.e(intent, this);
        }
        if (this.kxm != null) {
            v.d("MicroMsg.Voip.VideoActivity", "removeSensorCallBack");
            ca(true);
            this.kxm.btX();
            this.kxm = null;
        }
        if (this.kxk != null) {
            if (this.kxk.kxz == 4105) {
                z = true;
            } else {
                z = false;
            }
            this.kxk.uninit();
            this.kxk = null;
        } else {
            z = false;
        }
        this.kxl = null;
        this.ktM = null;
        this.kxt = true;
        super.finish();
        if (z) {
            hc hcVar = new hc();
            hcVar.bgP.bgS = true;
            hcVar.bgP.bgR = this.kxu;
            com.tencent.mm.sdk.c.a.nhr.z(hcVar);
            return;
        }
        hcVar = new hc();
        hcVar.bgP.bgS = false;
        hcVar.bgP.bgR = 0;
        com.tencent.mm.sdk.c.a.nhr.z(hcVar);
    }

    protected void onNewIntent(Intent intent) {
        v.i("MicroMsg.Voip.VideoActivity", "onNewIntent");
        super.onNewIntent(intent);
    }

    public void onPause() {
        boolean z;
        super.onPause();
        PowerManager powerManager = (PowerManager) aa.getContext().getSystemService("power");
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) aa.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        boolean hasWindowFocus = hasWindowFocus();
        boolean isScreenOn = powerManager.isScreenOn();
        if ((hasWindowFocus || !inKeyguardRestrictedInputMode) && isScreenOn) {
            z = true;
        } else {
            z = false;
        }
        this.kxs = z;
        v.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.rV(this.mStatus), Boolean.valueOf(this.kxs), Boolean.valueOf(hasWindowFocus), Boolean.valueOf(inKeyguardRestrictedInputMode), Boolean.valueOf(isScreenOn)});
    }

    public void onResume() {
        v.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.rV(this.mStatus)});
        ak.oH().cancel(40);
        e eVar = d.bbw().kuO.kqI;
        if (eVar.krO) {
            eVar.krO = false;
        }
        super.onResume();
        ca(true);
        this.kxp = be.Nj();
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.kxk != null) {
            this.kxk.a(bArr, j, i, i2, i3, i4, i5, i6);
        }
    }

    public final void ai(final int i, String str) {
        v.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.ktS)});
        this.kxo = true;
        if (i == 241) {
            com.tencent.mm.ui.base.g.A(this, str, null);
        } else {
            this.ihw.post(new Runnable(this) {
                final /* synthetic */ VideoActivity kxv;

                public final void run() {
                    VideoActivity.a(this.kxv, i);
                }
            });
        }
    }

    protected final int getLayoutId() {
        return 2130904595;
    }

    public final void bZ(boolean z) {
        if (be.Nj() - this.kxp < 500) {
            v.d("MicroMsg.Voip.VideoActivity", "onSensorEvent time interval too small");
        } else if ((this.ktR || com.tencent.mm.plugin.voip.b.b.rY(this.mStatus)) && !com.tencent.mm.plugin.voip.b.b.rZ(this.mStatus)) {
            v.d("MicroMsg.Voip.VideoActivity", "onSensorEvent, isOn: " + z);
            ca(z);
        }
    }

    protected final void bB(View view) {
        w.c(w.a(getWindow(), null), this.nDR.nDX);
        ((ViewGroup) getWindow().getDecorView()).addView(view, 0);
    }

    private int auE() {
        int bbu;
        if (com.tencent.mm.plugin.voip.b.b.rY(this.mStatus)) {
            bbu = d.bbw().bbu();
        } else {
            bbu = ak.yX().qU() ? 0 : 2;
            if (!this.ktS && this.ktR) {
                bbu = p.ceB.cbW >= 0 ? p.ceB.cbW : 0;
            }
            if (!ak.yX().qU() && p.ceB.cbY >= 0) {
                bbu = p.ceB.cbY;
            }
        }
        v.d("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", new Object[]{Integer.valueOf(bbu)});
        return bbu;
    }

    public final void rQ(int i) {
        this.ktW = i;
        if (this.kxk != null) {
            this.kxk.rQ(i);
        }
    }

    public final void dJ(boolean z) {
        this.aUy = z;
        if (this.kxk != null) {
            this.kxk.dJ(z);
        }
    }

    public final void a(int i, int i2, int[] iArr) {
        if (this.kxk != null) {
            this.kxk.a(i, i2, iArr);
        }
    }

    public final void bck() {
        if (this.kxk != null) {
            this.kxk.bck();
        }
    }

    public final Context bdk() {
        return this.nDR.nEl;
    }

    public final void uninit() {
        if (this.kxk != null) {
            this.kxk.uninit();
        }
    }

    public final void dr(long j) {
        this.kxn = j;
        if (this.kxk != null) {
            this.kxk.ds(this.kxn);
        }
    }

    public final void bdl() {
        v.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning");
        if (this.kxk != null) {
            this.kxk.bdm();
        }
    }

    public final void avv() {
        v.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
        if (this.kxk != null) {
            this.kxk.bdn();
        }
    }

    public final void v(boolean z, boolean z2) {
        this.kxq = z2;
        if (z) {
            bcg();
        } else {
            finish();
        }
    }

    public final void a(CaptureView captureView) {
        this.ktM = captureView;
        if (this.kxk != null) {
            this.kxk.b(captureView);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 2131234163;
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            v.e("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult %d data is invalid", new Object[]{Integer.valueOf(i)});
            return;
        }
        v.i("MicroMsg.Voip.VideoActivity", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 19:
                if (iArr[0] != 0) {
                    if ("android.permission.CAMERA".equals(strArr[0])) {
                        i2 = 2131234160;
                    }
                    com.tencent.mm.ui.base.g.a(this, getString(i2), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ VideoActivity kxv;

                        {
                            this.kxv = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.kxv.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ VideoActivity kxv;

                        {
                            this.kxv = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            case 82:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(2131234163), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ VideoActivity kxv;

                        {
                            this.kxv = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kxv.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
