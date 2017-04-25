package com.tencent.mm.plugin.multitalk.ui;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.tencent.mm.e.a.ib;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.m;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.widget.c;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.pb.common.b.a.a.aq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@a(3)
public class MultiTalkMainUI extends MMActivity implements com.tencent.mm.plugin.multitalk.a.a {
    protected ac fnw;
    private c hAE;
    private f hAF;
    private boolean hAG;
    private boolean hAH = true;
    private boolean hAI = false;
    private ah hAJ = new ah(Looper.getMainLooper(), new ah.a(this) {
        final /* synthetic */ MultiTalkMainUI hAN;

        {
            this.hAN = r1;
        }

        public final boolean oU() {
            v.d("MicroMsg.MT.MultiTalkMainUI", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
            ak.yX().qS();
            return false;
        }
    }, false);
    private Runnable hAK = new Runnable(this) {
        final /* synthetic */ MultiTalkMainUI hAN;

        {
            this.hAN = r1;
        }

        public final void run() {
            o.aCG().aCm();
        }
    };
    public boolean hAL;
    private BroadcastReceiver hAM = new BroadcastReceiver(this) {
        final /* synthetic */ MultiTalkMainUI hAN;

        {
            this.hAN = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && o.aCG().hzp == e.Inviting) {
                o.aCG().aCp();
                this.hAN.hAH = false;
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nDR.bAj();
        int intExtra = getIntent().getIntExtra("enterMainUiSource", 0);
        if (intExtra == 1 || intExtra == 2) {
            overridePendingTransition(2130968641, 2130968589);
        } else {
            overridePendingTransition(2130968682, 2130968683);
        }
        getWindow().addFlags(6946944);
        o.aCG().aCl();
        if (o.aCG().aCc()) {
            this.hAE = new c(this);
            this.hAF = new f(this);
            o.aCG().hzt = this;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            registerReceiver(this.hAM, intentFilter);
            this.hAI = true;
            this.fnw = new ac();
            this.hAJ.ea(2000);
            return;
        }
        finish();
        if (intExtra == 2) {
            getIntent().getStringExtra("enterMainUiWxGroupId");
        }
    }

    protected final int getLayoutId() {
        return 2130904099;
    }

    protected void onResume() {
        super.onResume();
        switch (o.aCG().hzp) {
            case Inviting:
                this.hAF.hBF.setVisibility(8);
                this.hAE.n(o.aCG().hzq);
                if (com.tencent.mm.sdk.platformtools.ak.is4G(this)) {
                    o.aCE().A(this);
                } else if (com.tencent.mm.sdk.platformtools.ak.is2G(this) || com.tencent.mm.sdk.platformtools.ak.is3G(this)) {
                    o.aCE().z(this);
                }
                if (this.hAH) {
                    o.aCG().eD(false);
                    break;
                }
                break;
            case Starting:
            case Creating:
                this.hAE.aCL();
                this.hAF.o(o.aCG().hzq);
                if (com.tencent.mm.sdk.platformtools.ak.is4G(this)) {
                    o.aCE().A(this);
                } else if (com.tencent.mm.sdk.platformtools.ak.is2G(this) || com.tencent.mm.sdk.platformtools.ak.is3G(this)) {
                    o.aCE().z(this);
                }
                o.aCG().eD(true);
                break;
            case Talking:
                this.hAE.aCL();
                this.hAF.o(o.aCG().hzq);
                break;
        }
        if (o.aCG().aCd()) {
            if (o.aCG().aCa()) {
                this.hAF.a(null, true);
            }
            this.fnw.postDelayed(this.hAK, 2000);
        }
    }

    protected void onPause() {
        PowerManager powerManager = (PowerManager) aa.getContext().getSystemService("power");
        boolean z = (hasWindowFocus() || !((KeyguardManager) aa.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) && powerManager.isScreenOn();
        this.hAG = z;
        v.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", new Object[]{Boolean.valueOf(this.hAG)});
        if (o.aCG().aCd()) {
            o.aCG().aCn();
            this.hAF.b(null, true);
        }
        super.onPause();
    }

    protected void onDestroy() {
        if (this.hAL) {
            o.aCG().eB(false);
        }
        if (this.hAI) {
            unregisterReceiver(this.hAM);
        }
        super.onDestroy();
        this.hAJ.QI();
        ak.yX().qT();
    }

    protected void onStop() {
        if (!this.hAL && this.hAG) {
            o.aCG().eB(false);
        }
        super.onStop();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            g.a(this, 2131233928, 2131233908, 2131230903, 2131231010, new OnClickListener(this) {
                final /* synthetic */ MultiTalkMainUI hAN;

                {
                    this.hAN = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    o.aCG().c(false, false, false);
                }
            }, null);
            return true;
        }
        if (o.aCG().hzp == e.Inviting) {
            if (i == 25 || i == 24) {
                o.aCG().aCp();
                this.hAH = false;
                return true;
            }
        } else if (i == 25) {
            if (o.aCG().gFq.bdP()) {
                ak.yX().dO(0);
            } else {
                ak.yX().dO(2);
            }
            return true;
        } else if (i == 24) {
            if (o.aCG().gFq.bdP()) {
                ak.yX().dN(0);
            } else {
                ak.yX().dN(2);
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + i + " resultCode " + i2);
        super.onActivityResult(i, i2, intent);
        this.hAL = false;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            v.i("MicroMsg.MT.MultiTalkMainUI", "add member " + stringExtra);
            List g = be.g(stringExtra.split(","));
            if (g != null) {
                com.tencent.mm.plugin.multitalk.a.e aCG = o.aCG();
                if (aCG.aCc()) {
                    stringExtra = aCG.hzq.pta;
                    if (be.kS(stringExtra)) {
                        stringExtra = aCG.hzq.ptb;
                    }
                    o.aCF().hyY.o(stringExtra, g);
                }
            }
        }
    }

    public final void aBP() {
        switch (o.aCG().hzp) {
            case Inviting:
                this.hAE.n(o.aCG().hzq);
                return;
            case Starting:
            case Creating:
            case Talking:
                this.hAF.o(o.aCG().hzq);
                return;
            default:
                return;
        }
    }

    public final void azB() {
        this.hAE.aCL();
        this.hAF.o(o.aCG().hzq);
        if (i.aCy()) {
            o.aCG().nn(0);
        }
    }

    public final void aBO() {
        ib ibVar = new ib();
        ibVar.bhW.action = 0;
        com.tencent.mm.sdk.c.a.nhr.z(ibVar);
        this.hAF.eE(true);
        o.aCG().hzt = null;
        o.aCG().aCp();
        finish();
    }

    public final void aBN() {
        com.tencent.mm.sdk.i.e.a(new Runnable(o.aCG()) {
            final /* synthetic */ e hzz;

            {
                this.hzz = r1;
            }

            public final void run() {
                this.hzz.gFq.stop();
                this.hzz.gFq.d(2131165831, false, 0);
            }
        }, "MultiTalkManager_play_end_sound");
        ib ibVar = new ib();
        ibVar.bhW.action = 0;
        com.tencent.mm.sdk.c.a.nhr.z(ibVar);
        this.hAF.eE(false);
        o.aCG().hzt = null;
        o.aCG().aCp();
        finish();
    }

    public final void aBQ() {
        v.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + o.aCG().hzo.size());
        if (o.aCG().aCd()) {
            f fVar;
            HashSet hashSet;
            if (o.aCG().hzo.size() > 0) {
                if (i.aCy()) {
                    v.i("MicroMsg.MT.MultiTalkMainUI", "2Gor3G,stop MultiTalkVideoNetworkReceiver!");
                    o.aCE().z(this);
                } else {
                    o.aCG().aCm();
                    fVar = this.hAF;
                    hashSet = new HashSet();
                    hashSet.addAll(o.aCG().hzo);
                    if (o.aCG().aCb()) {
                        fVar.b(hashSet);
                    }
                }
            }
            o.aCG().aCn();
            fVar = this.hAF;
            hashSet = new HashSet();
            hashSet.addAll(o.aCG().hzo);
            if (o.aCG().aCb()) {
                fVar.b(hashSet);
            }
        }
    }

    public final void ew(boolean z) {
        if (o.aCG().aCd()) {
            this.hAF.hBJ.setChecked(z);
        }
    }

    public final void ex(boolean z) {
        if (o.aCG().aCd()) {
            this.hAF.hBK.setChecked(z);
        }
    }

    public final void bW(int i, int i2) {
        if (o.aCG().aCd()) {
            f fVar = this.hAF;
            RelativeLayout wW = fVar.wW(k.xF());
            f.a aVar = (f.a) wW.getTag();
            if (!i.no(i2)) {
                if (i.no(i)) {
                    fVar.hBI.setChecked(false);
                    aVar.hBV.aCP();
                }
                fVar.b(wW, false);
            } else if (i.no(i2) && !i.no(i)) {
                fVar.hBI.setChecked(true);
                aVar.hBV.aCQ();
                aVar.hBY.setVisibility(0);
                ad.g(new b(fVar, aVar), 1500);
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(o.aCG().hzo);
            if (i.np(i2)) {
                if (i.np(i2) && !i.np(i)) {
                    fVar.b(hashSet);
                }
            } else if (i.np(i)) {
                fVar.aCM();
            }
        }
    }

    public final void a(String str, int[] iArr, int i, int i2, int i3) {
        if (o.aCG().aCd()) {
            this.hAF.a(str, iArr, i, i2, 0, i3);
        }
    }

    public final void a(String str, Bitmap bitmap, int i, int i2) {
        this.hAF.a(str, bitmap, i, i2);
    }

    public final int wD(String str) {
        RelativeLayout wW = this.hAF.wW(str);
        return wW == null ? -1 : ((f.a) wW.getTag()).hBV.position;
    }

    public final void a(e eVar) {
        if (eVar == e.Talking) {
            f fVar = this.hAF;
            if (fVar.hBS > 0) {
                fVar.hBS = System.currentTimeMillis();
            }
            o.aCG().aCp();
        }
    }

    public final void a(i.a aVar) {
        if (aVar == i.a._4G) {
            o.aCE().A(this);
        } else if (aVar == i.a._3GOr_2G) {
            o.aCE().z(this);
        } else if (aVar == i.a.None) {
            com.tencent.mm.ah.a.a(this, 2131235928, null);
        }
    }

    public final void aBR() {
        f.a aVar;
        f fVar = this.hAF;
        long j = (long) o.aCG().hzs;
        fVar.eTg.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        com.tencent.mm.plugin.multitalk.a.e aCG = o.aCG();
        String str = aCG.hzq.pta;
        if (be.kS(str)) {
            str = aCG.hzq.ptb;
        }
        List Qg = o.aCF().hyY.Qg(str);
        if (Qg != null) {
            Iterator it = fVar.hBN.iterator();
            while (it.hasNext()) {
                aVar = (f.a) ((RelativeLayout) it.next()).getTag();
                if (Qg.contains(aVar.hBV.username)) {
                    aVar.hBW.setVisibility(0);
                } else {
                    aVar.hBW.setVisibility(8);
                }
            }
        }
        aCG = o.aCG();
        str = aCG.hzq.pta;
        if (be.kS(str)) {
            str = aCG.hzq.ptb;
        }
        if (m.hAr == null) {
            m.hAr = new m();
        }
        m mVar = m.hAr;
        List arrayList = new ArrayList();
        mVar.hAs = com.tencent.wecall.talkroom.model.c.bPu().QK(str);
        if (mVar.hAs != null) {
            for (aq aqVar : mVar.hAs.bPr()) {
                int i;
                byte[] bArr = new byte[4];
                if (o.aCF().hyY.D(bArr, aqVar.gGl) < 0) {
                    v.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed");
                    i = -1;
                } else {
                    i = be.aA(bArr);
                    v.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", new Object[]{Integer.valueOf(i)});
                }
                Object obj = (i == -1 || i >= 5) ? null : 1;
                if (obj != null) {
                    arrayList.add(aqVar.prp);
                }
            }
        }
        Iterator it2 = fVar.hBN.iterator();
        while (it2.hasNext()) {
            aVar = (f.a) ((RelativeLayout) it2.next()).getTag();
            if (arrayList.contains(aVar.hBV.username)) {
                aVar.hBX.setVisibility(0);
            } else {
                aVar.hBX.setVisibility(8);
            }
        }
    }

    protected final int NO() {
        return 1;
    }
}
