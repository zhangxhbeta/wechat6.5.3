package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.ipcall.a.b.d;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class IPCallTalkUI extends MMActivity implements j.a {
    private String gLs;
    private String gLt;
    private String gLu;
    private String gLv;
    private int gLw;
    private int gLx;
    private j gOC;
    private String gpi;

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (i.auq().aug()) {
            finish();
            return;
        }
        cU().cV().hide();
        getWindow().addFlags(6946944);
        this.gpi = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.gLs = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.gLt = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.gLu = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.gLv = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.gLw = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        this.gLx = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
        v.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", new Object[]{this.gpi, this.gLs, this.gLt, this.gLu, this.gLv, Integer.valueOf(this.gLw), Integer.valueOf(this.gLx)});
        v.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)), be.bur()});
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            init();
        }
    }

    private void init() {
        String vl;
        this.gOC = new j(this);
        this.gOC.gPl = this;
        j jVar = this.gOC;
        String str = this.gpi;
        String str2 = this.gLs;
        String str3 = this.gLt;
        String str4 = this.gLu;
        String str5 = this.gLv;
        int i = this.gLw;
        int i2 = this.gLx;
        jVar.gPs = jVar.gPj.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
        v.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(jVar.gPs)});
        jVar.gPb = (ImageView) jVar.gPj.findViewById(2131757569);
        jVar.dtz = (ImageView) jVar.gPj.findViewById(2131757570);
        jVar.gOZ = (EditText) jVar.gPj.findViewById(2131757562);
        jVar.dtE = (TextView) jVar.gPj.findViewById(2131757559);
        jVar.gPa = (TextView) jVar.gPj.findViewById(2131757567);
        jVar.gPc = (IPCallFuncButton) jVar.gPj.findViewById(2131757564);
        jVar.gPd = (IPCallFuncButton) jVar.gPj.findViewById(2131757565);
        jVar.gPe = (IPCallFuncButton) jVar.gPj.findViewById(2131757566);
        jVar.gPf = (ImageButton) jVar.gPj.findViewById(2131757571);
        jVar.gPg = (TextView) jVar.gPj.findViewById(2131757561);
        jVar.gPh = jVar.gPj.findViewById(2131757560);
        jVar.gIX = (DialPad) jVar.gPj.findViewById(2131757558);
        jVar.gpi = str;
        jVar.gLs = str2;
        jVar.gLt = str3;
        jVar.gLu = str4;
        jVar.gLw = i;
        jVar.gLx = i2;
        if (!be.kS(jVar.gLs)) {
            jVar.gLs = c.vt(jVar.gLs);
        }
        if (be.kS(jVar.gLu)) {
            if (com.tencent.mm.plugin.ipcall.b.a.vn(jVar.gLs)) {
                vl = com.tencent.mm.plugin.ipcall.b.a.vl(jVar.gLs);
                if (be.kS(vl)) {
                    jVar.gLs = com.tencent.mm.plugin.ipcall.b.a.vo(jVar.gLs);
                } else {
                    jVar.gLs = com.tencent.mm.plugin.ipcall.b.a.vq(jVar.gLs);
                    jVar.gLu = vl;
                }
            }
            jVar.gLu = c.avC();
        }
        v.i("MicroMsg.TalkUIController", "final mCountryCode: %s", new Object[]{jVar.gLu});
        com.tencent.mm.plugin.ipcall.a.c atY = com.tencent.mm.plugin.ipcall.a.c.atY();
        str = jVar.gLu;
        if (!atY.isInit) {
            atY.dx(false);
        }
        if (!be.kS(str)) {
            i.aut().t(be.getInt(str.replace("+", ""), 0), be.Ni());
            atY.aua();
        }
        if (be.kS(jVar.gpi)) {
            jVar.gpi = com.tencent.mm.plugin.ipcall.b.a.ab(jVar.gPj, jVar.gLs);
        }
        jVar.gLv = str5;
        if (be.kS(jVar.gLu) || com.tencent.mm.plugin.ipcall.b.a.vn(jVar.gLs)) {
            jVar.gPi = jVar.gLs;
        } else {
            jVar.gPi = jVar.gLu + jVar.gLs;
            if (!jVar.gPi.startsWith("+")) {
                jVar.gPi = "+" + jVar.gPi;
            }
        }
        v.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", new Object[]{jVar.gPi});
        i.aup().aWn = jVar.gPj;
        Object aup = i.aup();
        aup.gGu.gGL = aup;
        d dVar = aup.gGu;
        if (!dVar.evt.nll) {
            dVar.evt.a(dVar);
            if (dVar.evx.F(new Runnable(dVar) {
                final /* synthetic */ d gGM;

                {
                    this.gGM = r1;
                }

                public final void run() {
                    this.gGM.evy = be.Nj();
                }
            })) {
                dVar.evy = 0;
            } else {
                dVar.evy = -1;
            }
        }
        i.aup().gGy = jVar;
        i.aup().gGw = jVar;
        jVar.gPp.listen(jVar.gPv, 32);
        jVar.gOZ.setKeyListener(null);
        jVar.gOZ.setHorizontallyScrolling(true);
        jVar.gIX.setVisibility(4);
        jVar.gIX.auZ();
        jVar.dtE.setText("");
        jVar.vf(jVar.gPi);
        if (com.tencent.mm.compatible.util.d.dW(16)) {
            jVar.gOZ.setTypeface(Typeface.create("sans-serif-light", 0));
            jVar.gPa.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        if (!be.kS(jVar.gLt)) {
            jVar.gOQ = com.tencent.mm.plugin.ipcall.b.a.d(jVar.gPj, jVar.gLt, true);
        }
        if (jVar.gOQ == null && !be.kS(jVar.gLs) && com.tencent.mm.plugin.ipcall.b.a.Fb()) {
            jVar.gOQ = com.tencent.mm.plugin.ipcall.b.a.ae(jVar.gPj, jVar.gLs);
        }
        if (jVar.gOQ == null && !be.kS(jVar.gLv)) {
            jVar.gOQ = b.b(jVar.gLv, 480, 480, 4);
        }
        if (jVar.gOQ == null) {
            jVar.gPb.setVisibility(0);
            jVar.dtz.setVisibility(8);
        }
        if (jVar.gOQ != null) {
            jVar.gPb.setVisibility(8);
            jVar.dtz.setVisibility(0);
            jVar.dtz.setImageBitmap(jVar.gOQ);
        }
        jVar.gPe.gMu = new IPCallFuncButton.a(jVar) {
            final /* synthetic */ j gPx;

            {
                this.gPx = r1;
            }

            public final void dO(boolean z) {
                v.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", new Object[]{Boolean.valueOf(z)});
                if (i.auq().auh()) {
                    this.gPx.gPn = z;
                    this.gPx.gPo = z;
                    i.aup().dE(z);
                    g.iuh.h(12057, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
                } else if (!i.auv().bdP() && !i.auq().auj()) {
                    i.auv().gY(z);
                }
            }
        };
        jVar.gPc.gMu = new IPCallFuncButton.a(jVar) {
            final /* synthetic */ j gPx;

            {
                this.gPx = r1;
            }

            public final void dO(boolean z) {
                if (i.auq().aui()) {
                    v.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", new Object[]{Boolean.valueOf(z)});
                    com.tencent.mm.plugin.ipcall.a.c.a aun = i.aun();
                    int nl = z ? aun.gGO.nl(412) : aun.gGO.nl(413);
                    if (nl < 0) {
                        v.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:" + nl);
                    }
                    i.aup().gGt.dJ(z);
                    g.iuh.h(12057, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                }
            }
        };
        jVar.gPd.gMu = new IPCallFuncButton.a(jVar) {
            final /* synthetic */ j gPx;

            {
                this.gPx = r1;
            }

            public final void dO(boolean z) {
                j jVar;
                if (z) {
                    jVar = this.gPx;
                    if (jVar.gOQ == null) {
                        jVar.dtz.setVisibility(8);
                    } else {
                        jVar.dtz.setVisibility(4);
                    }
                    jVar.dtz.setVisibility(8);
                    jVar.gPb.setVisibility(8);
                    jVar.gOZ.setText("");
                    jVar.gPa.setText("");
                    jVar.gIX.setVisibility(0);
                } else {
                    jVar = this.gPx;
                    if (jVar.gOQ != null) {
                        jVar.dtz.setVisibility(0);
                        jVar.gPb.setVisibility(8);
                    } else {
                        jVar.gPb.setVisibility(0);
                        jVar.dtz.setVisibility(8);
                    }
                    jVar.vf(jVar.gPi);
                    jVar.gIX.setVisibility(4);
                }
                g.iuh.h(12057, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
            }
        };
        jVar.gPf.setOnClickListener(new OnClickListener(jVar) {
            final /* synthetic */ j gPx;

            {
                this.gPx = r1;
            }

            public final void onClick(View view) {
                this.gPx.j(true, 0);
            }
        });
        jVar.gIX.gIV = new DialPad.a(jVar) {
            final /* synthetic */ j gPx;

            {
                this.gPx = r1;
            }

            public final void uP(String str) {
                String obj = this.gPx.gOZ.getText().toString();
                if (be.kS(obj)) {
                    this.gPx.gPm = System.currentTimeMillis();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gPx.gPm >= 3000) {
                    obj = obj + " ";
                }
                obj = obj + str;
                this.gPx.gPm = currentTimeMillis;
                this.gPx.bS(obj, "");
                com.tencent.mm.plugin.ipcall.c.uG(str);
                g.iuh.h(12057, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
            }

            public final void uQ(String str) {
            }
        };
        if (com.tencent.mm.plugin.ipcall.a.c.atY().lU(be.getInt(jVar.gLu, -1))) {
            g.iuh.Y(12058, jVar.gLu);
            com.tencent.mm.ui.base.g.a(jVar.gPj, jVar.gPj.getString(2131231562), jVar.gPj.getString(2131231563), false, new DialogInterface.OnClickListener(jVar) {
                final /* synthetic */ j gPx;

                {
                    this.gPx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.gPx.gPj.finish();
                    this.gPx.gPj = null;
                }
            });
        } else if (ak.isNetworkConnected(jVar.gPj)) {
            long j = jVar.gPj.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1);
            if (j <= System.currentTimeMillis() || j == -1) {
                if (!(jVar.gPs && i.auq().aug())) {
                    com.tencent.mm.plugin.ipcall.a.c.b auo;
                    jVar.gPr = false;
                    int bT = com.tencent.mm.plugin.ipcall.b.a.bT(jVar.gLt, jVar.gLs);
                    if (bT != -1) {
                        vl = com.tencent.mm.plugin.ipcall.b.a.mk(bT);
                        jVar.dtE.setText(jVar.gPj.getString(2131233394, new Object[]{vl}));
                    } else {
                        jVar.dtE.setText(2131233393);
                    }
                    com.tencent.mm.plugin.ipcall.c cVar = jVar.gPk;
                    str2 = jVar.gLv;
                    str3 = jVar.gPi;
                    str4 = jVar.gLt;
                    int i3 = jVar.gLw;
                    i = jVar.gLx;
                    if (i.auq().aug()) {
                        v.i("MicroMsg.IPCallManager", "startIPCall, already start!");
                    } else {
                        v.i("MicroMsg.IPCallManager", "startIPCall");
                        v.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", new Object[]{str3, str4});
                        k kVar = new k();
                        kVar.field_phonenumber = str3;
                        if (be.kS(str4)) {
                            kVar.field_addressId = -1;
                        } else {
                            com.tencent.mm.plugin.ipcall.a.g.c uK = i.aur().uK(str4);
                            if (uK == null || uK.nmb == -1) {
                                kVar.field_addressId = -1;
                            } else {
                                kVar.field_addressId = uK.nmb;
                            }
                        }
                        if (bT != -1) {
                            kVar.field_phoneType = bT;
                        } else {
                            kVar.field_phoneType = -1;
                        }
                        kVar.field_calltime = be.Ni();
                        kVar.field_status = 1;
                        if (!i.aus().b(kVar)) {
                            kVar = null;
                        }
                        cVar.gEp = kVar;
                        com.tencent.mm.plugin.ipcall.c.cnC.postDelayed(cVar.gEs, 1754);
                        cVar.gEq = false;
                        auo = i.auo();
                        v.d("MicroMsg.IPCallReportHelper", "reset");
                        auo.gGV = 0;
                        auo.gGW = 0;
                        auo.gGX = 0;
                        auo.gGY = 0;
                        auo.gGZ = 0;
                        auo.gHa = 0;
                        auo.gHb = 0;
                        auo.gHc = 0;
                        auo.gHd = 0;
                        auo.gHe = 0;
                        auo.gFG = 0;
                        auo.gFH = 0;
                        auo.gHf = 0;
                        auo.dwA = "";
                        auo.gHg = 0;
                        auo.gHh = "";
                        auo.gHj = 0;
                        auo.gHi = 0;
                        auo.gHk = 0;
                        auo.gHl = 0;
                        auo.gHm = 0;
                        auo.gHr = 0;
                        auo.gHq = 0;
                        auo.gHn = "";
                        auo.gHo = "";
                        auo.bfd = "";
                        auo.gHs = 0;
                        auo.gHt = 0;
                        auo.gHu = 0;
                        auo.gHv = 0;
                        auo.gHw = 0;
                        i.auq().gEK = -1;
                        v.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", new Object[]{str2, str3});
                        com.tencent.mm.plugin.ipcall.a.g aum = i.aum();
                        if (!aum.bhY || aum.gFa == null || aum.gFa.gGi == null || !aum.gFa.gGi.equals(str3) || aum.gFa.bob == null || !aum.gFa.bob.equals(str2)) {
                            v.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", new Object[]{str2, str3});
                            aum.gEP = false;
                            aum.gEQ = false;
                            aum.bhY = false;
                            aum.blA = false;
                            aum.gFb = false;
                            aum.gEM = 0;
                            aum.gEN = 0;
                            aum.gEO = 0;
                            aum.gEP = false;
                            aum.gEQ = false;
                            aum.gFc = false;
                            aum.gFa = new com.tencent.mm.plugin.ipcall.a.a.c();
                            aum.gFa.gGi = str3;
                            aum.gFa.bob = str2;
                            aum.gFa.gFJ = (int) System.currentTimeMillis();
                            aum.gFa.gFK = i3;
                            aum.gFa.gFL = i;
                            aum.gES.a(aum.gFa);
                            aum.gEX.a(aum.gFa);
                            v.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", new Object[]{Integer.valueOf(aum.gFa.gFJ)});
                            aum.bhY = true;
                        } else {
                            v.d("MicroMsg.IPCallSvrLogic", "ipcall to usernmae: %s, phoneNumber: %s already start!", new Object[]{str2, str3});
                        }
                        i.auq().lV(1);
                        com.tencent.mm.plugin.ipcall.a.c.a aun = i.aun();
                        if (aun.gGS) {
                            v.d("MicroMsg.IPCallEngineManager", "already start engine");
                        } else {
                            aun.auH();
                            v.i("MicroMsg.IPCallEngineManager", "start engine");
                            if (aun.gGO.hqt) {
                                aun.gGO.gU(false);
                                aun.gGO.reset();
                            }
                            aun.gGO.kvH = 1;
                            long currentTimeMillis = System.currentTimeMillis();
                            v2protocal com_tencent_mm_plugin_voip_model_v2protocal = aun.gGO;
                            com_tencent_mm_plugin_voip_model_v2protocal.netType = com.tencent.mm.plugin.voip.b.a.getNetType(aa.getContext());
                            if (com_tencent_mm_plugin_voip_model_v2protocal.netType == 5) {
                                com_tencent_mm_plugin_voip_model_v2protocal.netType = 4;
                            }
                            com_tencent_mm_plugin_voip_model_v2protocal.kwx = new int[(com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth * com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight)];
                            com.tencent.mm.model.ak.yW();
                            com_tencent_mm_plugin_voip_model_v2protocal.kvF = com.tencent.mm.model.c.ww();
                            i = l.rx();
                            if ((i & 1024) != 0) {
                                com.tencent.mm.compatible.loader.d.v(aa.getContext(), "libvoipCodec_v7a.so");
                                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
                            } else if ((i & 512) != 0) {
                                com.tencent.mm.compatible.loader.d.v(aa.getContext(), "libvoipCodec.so");
                                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
                            } else {
                                com.tencent.mm.compatible.loader.d.v(aa.getContext(), "libvoipCodec_v5.so");
                                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
                            }
                            i2 = VERSION.SDK_INT;
                            int bdM = OpenGlRender.bdM();
                            Display defaultDisplay = ((WindowManager) aa.getContext().getSystemService("window")).getDefaultDisplay();
                            int width = defaultDisplay.getWidth();
                            bT = com_tencent_mm_plugin_voip_model_v2protocal.init(com_tencent_mm_plugin_voip_model_v2protocal.netType, 65538, (com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth << 16) | com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight, (width << 16) | defaultDisplay.getHeight(), com_tencent_mm_plugin_voip_model_v2protocal.kvF, i | ((i2 << 16) | (bdM << 24)), e.cnf + "app_lib/", 4);
                            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip", "protocal init ret :" + bT + ",uin= " + com_tencent_mm_plugin_voip_model_v2protocal.kvF);
                            com_tencent_mm_plugin_voip_model_v2protocal.hqt = true;
                            if (bT < 0) {
                                com_tencent_mm_plugin_voip_model_v2protocal.reset();
                            }
                            j = System.currentTimeMillis();
                            v.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", new Object[]{Integer.valueOf(bT), Long.valueOf(j - currentTimeMillis)});
                            if (aun.gGO.field_capInfo != null && aun.gGO.exchangeCabInfo(aun.gGO.field_capInfo, aun.gGO.field_capInfo.length) < 0) {
                                v.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
                                i.auo().gHe = 24;
                            }
                            if (bT < 0) {
                                v.e("MicroMsg.IPCallEngineManager", "engine init failed!");
                            }
                            aun.gGO.kvH = 1;
                            aun.gGS = true;
                        }
                        com.tencent.mm.plugin.ipcall.c.cnC.removeCallbacks(cVar.gEr);
                        com.tencent.mm.plugin.ipcall.c.cnC.postDelayed(cVar.gEr, 60000);
                    }
                    v.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", new Object[]{jVar.gPi});
                    auo = i.auo();
                    str = jVar.gLu;
                    v.d("MicroMsg.IPCallReportHelper", "setCountryCode: %s", new Object[]{str});
                    if (!be.kS(str)) {
                        auo.bfd = str;
                    }
                }
                jVar.gPu = false;
                return;
            }
            v.i("MicroMsg.TalkUIController", "onDisasterHappen");
            com.tencent.mm.ui.base.g.a(jVar.gPj, jVar.gPj.getString(2131233348, new Object[]{Long.valueOf(((j - r6) / 1000) + 1)}), jVar.gPj.getString(2131233341), jVar.gPj.getString(2131233342), false, new DialogInterface.OnClickListener(jVar) {
                final /* synthetic */ j gPx;

                {
                    this.gPx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.gPx.gPj.finish();
                }
            });
        } else {
            Toast.makeText(jVar.gPj, 2131235928, 1).show();
            jVar.gPj.finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ca(true);
        if (this.gOC != null) {
            j jVar = this.gOC;
            v.i("MicroMsg.TalkUIController", "onDestroy");
            if (i.auq().aug()) {
                v.i("MicroMsg.TalkUIController", "onDestroy state error and shutdownOrCancelIPCall,cureentState = " + i.auq().gEK);
                jVar.j(false, 0);
            }
            jVar.gPk.gEo = null;
            i.aup().aWn = null;
            i.aup().gGy = null;
            i.aup().gGw = null;
            com.tencent.mm.plugin.ipcall.a.b.b aup = i.aup();
            aup.gGu.gGL = null;
            d dVar = aup.gGu;
            dVar.evt.btX();
            dVar.evx.btY();
            jVar.gPp.listen(jVar.gPv, 0);
            jVar.gPv = null;
            jVar.gPj = null;
            jVar.gPl = null;
            jVar.gPw.QI();
            com.tencent.mm.model.ak.oH().cancel(42);
            if (!this.gOC.blA) {
                return;
            }
            if (i.aum().gFa.gFG != 0) {
                ActionBarActivity actionBarActivity = this.nDR.nEl;
                int i = i.aum().gFa.gFG;
                v.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog");
                if (com.tencent.mm.plugin.ipcall.d.atT()) {
                    int i2;
                    int i3 = j.sU().getInt("WCOMaxTimesForShowFeedback", 0);
                    com.tencent.mm.model.ak.yW();
                    int intValue = ((Integer) com.tencent.mm.model.c.vf().get(t.a.nqV, Integer.valueOf(0))).intValue();
                    com.tencent.mm.model.ak.yW();
                    long longValue = ((Long) com.tencent.mm.model.c.vf().get(t.a.nqU, Long.valueOf(0))).longValue();
                    long Nh = be.Nh();
                    if (Nh - longValue > 86400) {
                        v.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reset time");
                        i2 = 0;
                    } else {
                        i2 = intValue;
                    }
                    if (i2 >= i3) {
                        v.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reach max time" + i3);
                        return;
                    } else if (Nh - longValue < 1800) {
                        v.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog not reach INTERVAL_TIMES_TRY_SHOW_WCO_FEEDBACK_MAIN");
                        return;
                    } else {
                        i2++;
                        com.tencent.mm.model.ak.yW();
                        com.tencent.mm.model.c.vf().a(t.a.nqV, Integer.valueOf(i2));
                        com.tencent.mm.model.ak.yW();
                        com.tencent.mm.model.c.vf().a(t.a.nqU, Long.valueOf(Nh));
                        Intent intent = new Intent();
                        intent.putExtra("IPCallFeedbackDialogUI_KRoomId", i);
                        com.tencent.mm.ay.c.b(actionBarActivity, "ipcall", ".ui.IPCallFeedbackDialogUI", intent, 0);
                        return;
                    }
                }
                return;
            }
            v.e("MicroMsg.IPCallTalkUI", "roomId = 0,ignore feedback");
        }
    }

    protected final int getLayoutId() {
        return 2130903824;
    }

    public final void dQ(boolean z) {
        if (z) {
            ad.g(new Runnable(this) {
                final /* synthetic */ IPCallTalkUI gOD;

                {
                    this.gOD = r1;
                }

                public final void run() {
                    this.gOD.setResult(-1, new Intent());
                    this.gOD.finish();
                }
            }, 3000);
        }
    }

    public void onBackPressed() {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gOC != null) {
            boolean z;
            if (i.auq().auh()) {
                int auE;
                if (i == 25) {
                    auE = i.aup().auE();
                    if (auE != -1) {
                        com.tencent.mm.model.ak.yX().dO(auE);
                        z = true;
                        if (z) {
                            return true;
                        }
                    }
                } else if (i == 24) {
                    auE = i.aup().auE();
                    if (auE != -1) {
                        com.tencent.mm.model.ak.yX().dN(auE);
                        z = true;
                        if (z) {
                            return true;
                        }
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onPause() {
        v.d("MicroMsg.IPCallTalkUI", "onPause");
        super.onPause();
        if (this.gOC != null) {
            j jVar = this.gOC;
            v.d("MicroMsg.TalkUIController", "onPause");
            if (i.auq().aug()) {
                jVar.gPr = true;
                jVar.avu();
                if (i.auq().auj()) {
                    jVar.gPw.ea(1000);
                    return;
                }
                return;
            }
            jVar.gPw.QI();
            jVar.gPr = false;
            com.tencent.mm.model.ak.oH().cancel(42);
        }
    }

    protected void onResume() {
        v.d("MicroMsg.IPCallTalkUI", "onResume");
        super.onResume();
        if (this.gOC != null) {
            j jVar = this.gOC;
            v.d("MicroMsg.TalkUIController", "onResume");
            jVar.gPr = false;
            jVar.gPw.QI();
            com.tencent.mm.model.ak.oH().cancel(42);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.IPCallTalkUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    init();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(2131234163), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ IPCallTalkUI gOD;

                        {
                            this.gOD = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.gOD.finish();
                            this.gOD.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ IPCallTalkUI gOD;

                        {
                            this.gOD = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.gOD.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
