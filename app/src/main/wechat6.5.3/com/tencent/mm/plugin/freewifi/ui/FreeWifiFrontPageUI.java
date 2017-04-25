package com.tencent.mm.plugin.freewifi.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartPlayVoice;
import com.tencent.mm.plugin.freewifi.e.f;
import com.tencent.mm.plugin.freewifi.e.g;
import com.tencent.mm.plugin.freewifi.e.h;
import com.tencent.mm.plugin.freewifi.e.i;
import com.tencent.mm.plugin.freewifi.e.j;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FreeWifiFrontPageUI extends MMActivity {
    protected int aPW;
    protected String aYz;
    protected int bbT;
    protected String bmJ;
    private final com.tencent.mm.ae.a.a.c cPf;
    protected String className;
    private ac cnC = new ac(this) {
        final /* synthetic */ FreeWifiFrontPageUI gbI;

        {
            this.gbI = r1;
        }

        public final void handleMessage(Message message) {
            c cVar = (c) message.obj;
            switch (cVar.gbH) {
                case START:
                    this.gbI.apY();
                    return;
                case CONNECTING:
                    this.gbI.apZ();
                    return;
                case FAIL:
                    this.gbI.aG(cVar.data);
                    return;
                case SUCCESS:
                    this.gbI.aH(cVar.data);
                    return;
                default:
                    return;
            }
        }
    };
    protected String fZD;
    protected int fZE;
    protected String fZF;
    protected View gbA;
    protected String gbB;
    protected String gbC;
    protected String gbD;
    protected String gbE;
    protected com.tencent.mm.plugin.freewifi.e.a gbF;
    private Lock gbG;
    private d gbH;
    protected ImageView gbr;
    protected TextView gbs;
    protected TextView gbt;
    protected TextView gbu;
    protected TextView gbv;
    protected TextView gbw;
    protected Button gbx;
    protected Button gby;
    protected Dialog gbz;
    protected Intent intent;
    protected String ssid;

    public static class a {
        public static a gbL = new a();
        public int gbM;
        public String gbN;
        public String text;
    }

    public static class b {
        public dq gbO;
    }

    public static class c {
        Object data;
        d gbH;

        public c(d dVar, Object obj) {
            this.gbH = dVar;
            this.data = obj;
        }
    }

    public enum d {
        START,
        CONNECTING,
        FAIL,
        SUCCESS
    }

    public FreeWifiFrontPageUI() {
        com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
        aVar.cPq = true;
        aVar.cPr = true;
        aVar.cPH = 2130838251;
        aVar.cPP = true;
        aVar.cPQ = 0.0f;
        this.cPf = aVar.GU();
    }

    private d apW() {
        try {
            this.gbG.lock();
            d dVar = this.gbH;
            return dVar;
        } finally {
            this.gbG.unlock();
        }
    }

    public final void a(d dVar, Object obj) {
        try {
            this.gbG.lock();
            this.gbH = dVar;
            Message obtain = Message.obtain();
            obtain.obj = new c(dVar, obj);
            this.cnC.sendMessage(obtain);
        } finally {
            this.gbG.unlock();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        switch (this.fZE) {
            case 1:
                this.gbF = new g(this);
                break;
            case 4:
                this.gbF = new f(this);
                break;
            case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                this.gbF = new h(this);
                this.gbA.setVisibility(0);
                apX();
                break;
            case JsApiStopRecordVoice.CTRL_INDEX /*32*/:
                this.gbF = new j(this);
                this.gbA.setVisibility(0);
                break;
            case JsApiStartPlayVoice.CTRL_INDEX /*33*/:
                this.gbF = new i(this);
                break;
        }
        v.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), this.className, this.aYz});
        l.o(com.tencent.mm.plugin.freewifi.model.d.apa(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiFrontPageUI gbI;

            {
                this.gbI = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gbI.goBack();
                return true;
            }
        });
        if (this.gbz != null) {
            this.gbz.dismiss();
        }
        this.gbG = new ReentrantLock();
        this.className = getClass().getSimpleName();
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.fZD = getIntent().getStringExtra("free_wifi_url");
        this.aYz = getIntent().getStringExtra("free_wifi_ap_key");
        this.bbT = getIntent().getIntExtra("free_wifi_source", 1);
        this.aPW = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.fZE = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        this.bmJ = getIntent().getStringExtra("free_wifi_appid");
        this.gbB = getIntent().getStringExtra("free_wifi_head_img_url");
        this.gbC = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.gbD = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.gbE = getIntent().getStringExtra("free_wifi_privacy_url");
        this.fZF = getIntent().getStringExtra("free_wifi_app_nickname");
        v.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), this.className, this.ssid, this.fZD, this.aYz, Integer.valueOf(this.bbT), Integer.valueOf(this.aPW), Integer.valueOf(this.fZE), this.bmJ, this.gbB, this.gbC, this.gbE});
        this.gbA = findViewById(2131757093);
        this.gbr = (ImageView) findViewById(2131757085);
        this.gbs = (TextView) findViewById(2131757086);
        this.gbt = (TextView) findViewById(2131757087);
        this.gbu = (TextView) findViewById(2131757088);
        this.gbv = (TextView) findViewById(2131757089);
        this.gbw = (TextView) findViewById(2131757090);
        this.gbx = (Button) findViewById(2131757091);
        this.gbx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiFrontPageUI gbI;

            {
                this.gbI = r1;
            }

            public final void onClick(View view) {
                this.gbI.apX();
            }
        });
        this.gby = (Button) findViewById(2131757092);
        this.gby.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiFrontPageUI gbI;

            {
                this.gbI = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.gbI.gbE);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.ay.c.b(this.gbI.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        if (be.kS(this.ssid)) {
            this.gbt.setText(getString(2131232982));
            this.gbx.setVisibility(4);
        }
        Fd(getString(2131232984));
        a(d.START, null);
    }

    private void apX() {
        l.p(com.tencent.mm.plugin.freewifi.model.d.apa(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        d apW = apW();
        v.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), this.className, apW.name()});
        if (apW() == d.START || apW() == d.FAIL) {
            v.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), this.className, Boolean.valueOf(this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false)), Integer.valueOf(m.aoE())});
            if (this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false) && r1 == 1 && this.fZE != 33) {
                com.tencent.mm.ui.base.g.a(this, 2131232943, 2131232944, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ FreeWifiFrontPageUI gbI;

                    {
                        this.gbI = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        m.bQ(this.gbI);
                    }
                }, null);
                return;
            }
            this.gbH = d.CONNECTING;
            apZ();
            this.gbF.connect();
        }
    }

    protected final void apY() {
        this.gbu.setVisibility(4);
        if (this.fZE == 31) {
            this.gbx.setVisibility(8);
        } else {
            this.gbx.setVisibility(0);
            this.gbx.setText(2131231991);
        }
        if (!(m.v(getIntent()) != 10 || m.ty(p.ceF.ceZ) || m.ty(p.aw(this.nDR.nEl)))) {
            this.gbx.setText(String.format(getString(2131232945), new Object[]{p.aw(this.nDR.nEl)}));
        }
        if (!be.kS(this.gbD)) {
            this.gbt.setText(this.gbD);
        } else if (this.fZE == 33) {
            this.gbt.setText(getString(2131231987) + ": " + this.ssid);
        } else {
            this.gbt.setText(getString(2131231987));
        }
        if (!be.kS(this.bmJ)) {
            if (!be.kS(this.fZF)) {
                this.gbs.setText(this.fZF);
            }
            if (!be.kS(this.gbB)) {
                n.GL().a(this.gbB, this.gbr, this.cPf);
            }
        }
        v.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
    }

    protected final void apZ() {
        this.gbu.setVisibility(4);
        this.gbx.setText(2131231988);
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        OnCancelListener anonymousClass6 = new OnCancelListener(this) {
            final /* synthetic */ FreeWifiFrontPageUI gbI;

            {
                this.gbI = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                com.tencent.mm.plugin.freewifi.model.d.a(this.gbI.ssid, 4, this.gbI.getIntent());
                v.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[]{m.s(this.gbI.getIntent()), Integer.valueOf(m.t(this.gbI.getIntent())), Integer.valueOf(4)});
            }
        };
        View inflate = View.inflate(actionBarActivity, 2130903666, null);
        com.tencent.mm.ui.base.i iVar = new com.tencent.mm.ui.base.i(actionBarActivity, 2131558737);
        iVar.setCancelable(true);
        iVar.setContentView(inflate);
        iVar.setOnCancelListener(anonymousClass6);
        this.gbz = iVar;
        v.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
        this.gbz.show();
    }

    protected final void aG(Object obj) {
        if (obj instanceof a) {
            CharSequence string;
            a aVar = (a) obj;
            v.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[]{m.s(this.intent), Integer.valueOf(m.t(this.intent)), aVar.gbN});
            if (this.gbz != null) {
                this.gbz.dismiss();
            }
            this.gbu.setVisibility(0);
            if (m.ty(aVar.text)) {
                if (aVar.gbM == 0) {
                    aVar.gbM = 2131232948;
                }
                string = getString(aVar.gbM);
            } else {
                string = aVar.text;
            }
            this.gbu.setText(string);
            this.gbu.setVisibility(0);
            this.gbv.setVisibility(0);
            this.gbw.setVisibility(0);
            final String str = getString(2131232960) + ": " + aVar.gbN;
            this.gbw.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FreeWifiFrontPageUI gbI;

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_show_detail_error", 1);
                    intent.putExtra("free_wifi_error_ui_error_msg", this.gbI.getString(2131232947));
                    intent.putExtra("free_wifi_error_ui_error_msg_detail1", str);
                    intent.setClass(this.gbI, FreeWifiErrorUI.class);
                    this.gbI.startActivity(intent);
                }
            });
            this.gbx.setVisibility(0);
            this.gbx.setText(2131232980);
            v.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
        }
    }

    protected final void aH(Object obj) {
        if (obj instanceof b) {
            com.tencent.mm.plugin.freewifi.k.a aoy;
            dq dqVar = ((b) obj).gbO;
            if (!(this.fZE == 31 || this.gbz == null)) {
                this.gbz.dismiss();
            }
            this.gbx.setText(2131231985);
            this.gbx.setClickable(false);
            Intent intent = getIntent();
            intent.putExtra("free_wifi_appid", dqVar.mbH);
            intent.putExtra("free_wifi_app_nickname", dqVar.efy);
            intent.putExtra("free_wifi_app_username", dqVar.gln);
            intent.putExtra("free_wifi_signature", dqVar.cHf);
            intent.putExtra("free_wifi_finish_actioncode", dqVar.mex);
            intent.putExtra("free_wifi_finish_url", dqVar.mey);
            intent.putExtra(com.tencent.mm.ui.d.a.nzL, dqVar.gcP);
            if (dqVar.mex == 2) {
                if (be.kS(dqVar.gln)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", dqVar.gln);
                    com.tencent.mm.ay.c.b(this, "profile", ".ui.ContactInfoUI", intent2);
                    c.qq();
                    v.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
                    aoy = k.aoy();
                    aoy.aYz = this.aYz;
                    aoy.fXa = m.s(intent);
                    aoy.fXc = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoContactInfoUI.fXM;
                    aoy.fXd = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoContactInfoUI.name;
                    aoy.bkh = m.v(intent);
                    aoy.fXb = m.u(intent);
                    aoy.bpc = 0;
                    aoy.eOP = "";
                    aoy.aoA().b(intent, true).aoz();
                    return;
                }
            } else if (m.ty(dqVar.mez)) {
                intent.setClass(this, FreeWifiSuccUI.class);
            } else {
                intent.putExtra("free_wifi_qinghuai_url", dqVar.mez);
                intent.setClass(this, FreeWifiSuccWebViewUI.class);
            }
            aoy = k.aoy();
            aoy.aYz = this.aYz;
            aoy.fXa = m.s(intent);
            aoy.fXc = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoSuc.fXM;
            aoy.fXd = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoSuc.name;
            aoy.bkh = m.v(intent);
            aoy.fXb = m.u(intent);
            aoy.bpc = 0;
            aoy.eOP = "";
            aoy.aoA().b(intent, true).aoz();
            finish();
            startActivity(intent);
            c.qq();
            v.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
        }
    }

    public void finish() {
        super.finish();
        com.tencent.mm.plugin.freewifi.k.a aoy = k.aoy();
        aoy.aYz = this.aYz;
        aoy.fXa = m.s(this.intent);
        aoy.fXc = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosed.fXM;
        aoy.fXd = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosed.name;
        aoy.bkh = m.v(this.intent);
        aoy.fXb = m.u(this.intent);
        aoy.bpc = 0;
        aoy.eOP = "";
        aoy.aoA().b(this.intent, true).aoz();
    }

    protected final int getLayoutId() {
        return 2130903660;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        l.q(com.tencent.mm.plugin.freewifi.model.d.apa(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        com.tencent.mm.plugin.freewifi.k.a aoy = k.aoy();
        aoy.aYz = this.aYz;
        aoy.fXa = m.s(this.intent);
        aoy.fXc = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoBack.fXM;
        aoy.fXd = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoBack.name;
        aoy.bkh = m.v(this.intent);
        aoy.fXb = m.u(this.intent);
        aoy.bpc = 0;
        aoy.eOP = "";
        aoy.aoA().b(this.intent, true).aoz();
        com.tencent.mm.plugin.freewifi.g.drp.i(new Intent(), this);
        finish();
    }

    protected final int NO() {
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.freewifi.model.j.apm().release();
    }
}
