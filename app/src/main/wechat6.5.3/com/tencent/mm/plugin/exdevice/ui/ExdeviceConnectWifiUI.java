package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.base.a.c;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;

public class ExdeviceConnectWifiUI extends MMActivity {
    private TextWatcher abU;
    private String fAA;
    private boolean fAB;
    private boolean fAC;
    private boolean fAD;
    private int fAE;
    private byte[] fAF;
    private int fAG;
    private int fAH;
    private int fAI;
    private String fAJ = "";
    private int fAK;
    private long fAL;
    boolean fAM = false;
    private com.tencent.mm.plugin.exdevice.d.b fAN;
    private int fAO;
    private m fAP;
    private com.tencent.mm.plugin.exdevice.model.j.a fAQ;
    private MulticastLock fAR;
    private Runnable fAS = new Runnable(this) {
        final /* synthetic */ ExdeviceConnectWifiUI fAT;

        {
            this.fAT = r1;
        }

        public final void run() {
            if (be.kS(this.fAT.getPassword())) {
                this.fAT.fAv.setText(this.fAT.fAz.fvq);
                Spannable text = this.fAT.fAv.getText();
                if (text != null) {
                    Selection.setSelection(text, text.length());
                    return;
                }
                return;
            }
            v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
        }
    };
    private View fAs;
    private TextView fAt;
    private View fAu;
    private EditText fAv;
    private View fAw;
    private p fAx;
    private WifiInfo fAy;
    private com.tencent.mm.plugin.exdevice.d.a fAz;
    private String fdK = "";

    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] fAZ = new int[b.akg().length];

        static {
            try {
                fAZ[b.fBd - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                fAZ[b.fBf - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                fAZ[b.fBe - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                fAZ[b.fBh - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                fAZ[b.fBg - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static class a {
        public static String I(int i, String str) {
            if (be.kS(str)) {
                return null;
            }
            return i + "@" + str.hashCode();
        }
    }

    public enum b {
        ;

        public static int[] akg() {
            return (int[]) fBi.clone();
        }

        static {
            fBd = 1;
            fBe = 2;
            fBf = 3;
            fBg = 4;
            fBh = 5;
            fBi = new int[]{fBd, fBe, fBf, fBg, fBh};
        }
    }

    static /* synthetic */ void a(ExdeviceConnectWifiUI exdeviceConnectWifiUI, final WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            v.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "WifiInfo is null.");
            return;
        }
        exdeviceConnectWifiUI.fAM = true;
        exdeviceConnectWifiUI.fAL = System.currentTimeMillis();
        exdeviceConnectWifiUI.ks(3);
        final String password = exdeviceConnectWifiUI.getPassword();
        String ssid = wifiInfo.getSSID();
        v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "SSID = %s", new Object[]{ssid});
        if (be.kS(ssid)) {
            v.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Error parameter: aSSID is null or nil");
            ssid = "";
        } else {
            ssid = ssid.replaceAll("\"", "");
        }
        v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "do start AirKiss, ssid(%s).", new Object[]{ssid});
        if (be.kS(ssid)) {
            v.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is invalid");
            Toast.makeText(exdeviceConnectWifiUI.nDR.nEl, "SSID is invalid", 0).show();
            return;
        }
        exdeviceConnectWifiUI.kt(b.fBf);
        ak.vA().x(new Runnable(exdeviceConnectWifiUI) {
            final /* synthetic */ ExdeviceConnectWifiUI fAT;

            public final void run() {
                this.fAT.fAR.acquire();
                int startAirKissWithInter = Java2CExDevice.startAirKissWithInter(password, ssid, this.fAT.fAF, 60000, this.fAT.fAG, this.fAT.fAH);
                v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Start AirKiss result (%d). input ssid = %s, ssid by system = %s, bssid by system = %s", new Object[]{Integer.valueOf(startAirKissWithInter), ssid, wifiInfo.getSSID(), wifiInfo.getBSSID()});
            }
        });
    }

    static /* synthetic */ void q(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        if (exdeviceConnectWifiUI.fAy == null) {
            v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "wifiInfo is null.");
            return;
        }
        String ssid = exdeviceConnectWifiUI.fAy.getSSID();
        String ma = be.ma(exdeviceConnectWifiUI.getPassword());
        if (be.kS(ssid)) {
            v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is null or nil.");
            return;
        }
        if (be.kS(exdeviceConnectWifiUI.fAz.fvp) || (ssid.equals(exdeviceConnectWifiUI.fAz.fvp) && !ma.equals(exdeviceConnectWifiUI.fAz.fvq))) {
            com.tencent.mm.plugin.exdevice.d.a H = exdeviceConnectWifiUI.H(exdeviceConnectWifiUI.fAE, ssid);
            if (H == null) {
                H = new com.tencent.mm.plugin.exdevice.d.a();
                H.fvp = ssid;
                H.fvo = exdeviceConnectWifiUI.fAE;
                exdeviceConnectWifiUI.fAN.fvr.add(H);
            }
            H.fvq = c.ba(ma, a.I(exdeviceConnectWifiUI.fAE, ssid));
        } else if (!exdeviceConnectWifiUI.fAB) {
            v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "password hasn't changed, so do not need to save.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        ssid = stringBuilder.append(com.tencent.mm.model.c.xq()).append("exdevice_wifi_infos").toString();
        try {
            byte[] toByteArray = exdeviceConnectWifiUI.fAN.toByteArray();
            e.b(ssid, toByteArray, toByteArray.length);
        } catch (Throwable e) {
            v.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e.getMessage());
            v.a("MicroMsg.exdevice.ExdeviceConnectWifiUI", e, "", new Object[0]);
        }
        v.v("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Current wifiInfo was save to file(%s).", new Object[]{ssid});
    }

    static /* synthetic */ void r(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        Java2CExDevice.stopAirKiss();
        exdeviceConnectWifiUI.cP(true);
        if (exdeviceConnectWifiUI.fAR.isHeld()) {
            exdeviceConnectWifiUI.fAR.release();
        }
    }

    protected final int getLayoutId() {
        return 2130903547;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fAP = new com.tencent.mm.network.m.a(this) {
            final /* synthetic */ ExdeviceConnectWifiUI fAT;

            {
                this.fAT = r1;
            }

            public final void cI(int i) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass8 fBa;

                    {
                        this.fBa = r1;
                    }

                    public final void run() {
                        if (this.fBa.fAT.fAO != b.fBg) {
                            this.fBa.fAT.cP(true);
                        }
                    }
                });
            }
        };
        this.fAO = b.fBd;
        if (ak.uz()) {
            this.fAN = new com.tencent.mm.plugin.exdevice.d.b();
            this.fAz = new com.tencent.mm.plugin.exdevice.d.a();
            ak.yW();
            this.fAE = com.tencent.mm.model.c.ww();
            String stringExtra = getIntent().getStringExtra("encryptKey");
            this.fAG = getIntent().getIntExtra("procInterval", 0);
            this.fAH = getIntent().getIntExtra("dataInterval", 0);
            v.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.fAG + " Data interval:" + this.fAH);
            if (!be.kS(stringExtra)) {
                this.fAF = Base64.decode(stringExtra, 0);
                this.fAK = 1;
            }
            this.fAM = false;
            this.fAI = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
            if (this.fAI == 2) {
                this.fAJ = getIntent().getStringExtra("device_brand_name");
                this.fdK = getIntent().getStringExtra("device_category_id");
            }
            this.fAQ = new com.tencent.mm.plugin.exdevice.model.j.a(this) {
                final /* synthetic */ ExdeviceConnectWifiUI fAT;

                {
                    this.fAT = r1;
                }

                public final void e(int i, Object... objArr) {
                    if (i == 0 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof Integer)) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        int intValue2 = ((Integer) objArr[1]).intValue();
                        if (this.fAT.fAR.isHeld()) {
                            this.fAT.fAR.release();
                        }
                        v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "AirKiss jni callback (%d, %d)", new Object[]{Integer.valueOf(intValue), Integer.valueOf(intValue2)});
                        if (intValue == 0 && intValue2 == 0) {
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass9 fBb;

                                {
                                    this.fBb = r1;
                                }

                                public final void run() {
                                    this.fBb.fAT.kt(b.fBg);
                                }
                            });
                        } else {
                            this.fAT.runOnUiThread(new Runnable(this) {
                                final /* synthetic */ AnonymousClass9 fBb;

                                {
                                    this.fBb = r1;
                                }

                                public final void run() {
                                    this.fBb.fAT.fAx.dismiss();
                                    g.a(this.fBb.fAT.nDR.nEl, this.fBb.fAT.nDR.nEl.getString(2131232487), "", this.fBb.fAT.nDR.nEl.getString(2131232517), "", false, new OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass2 fBc;

                                        {
                                            this.fBc = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            this.fBc.fBb.fAT.kt(b.fBh);
                                        }
                                    }, null).show();
                                }
                            });
                        }
                    }
                }
            };
            j.ajh().a(0, this.fAQ);
            NI();
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ ExdeviceConnectWifiUI fAT;

                {
                    this.fAT = r1;
                }

                public final void run() {
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        ak.yW();
                        byte[] d = e.d(stringBuilder.append(com.tencent.mm.model.c.xq()).append("exdevice_wifi_infos").toString(), 0, Integer.MAX_VALUE);
                        if (d != null) {
                            this.fAT.fAN.az(d);
                            this.fAT.akf();
                        }
                    } catch (Throwable e) {
                        v.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e.getMessage());
                        v.a("MicroMsg.exdevice.ExdeviceConnectWifiUI", e, "", new Object[0]);
                    }
                    ad.g(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 fAX;

                        {
                            this.fAX = r1;
                        }

                        public final void run() {
                            this.fAX.fAT.aJs();
                        }
                    }, 500);
                }
            });
            ks(1);
            this.fAR = ((WifiManager) getSystemService("wifi")).createMulticastLock("localWifi");
            return;
        }
        finish();
    }

    protected void onResume() {
        super.onResume();
        cP(false);
        ak.a(this.fAP);
        if (this.fAC) {
            akf();
            this.fAC = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.fAM) {
            ks(2);
        }
        j.ajh().b(0, this.fAQ);
    }

    protected void onStop() {
        super.onStop();
        ak.b(this.fAP);
    }

    protected final void NI() {
        vD(2131232521);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceConnectWifiUI fAT;

            {
                this.fAT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!this.fAT.fAD) {
                    boolean z;
                    Intent intent = new Intent();
                    String str = "is_wifi_connected";
                    if (this.fAT.fAO != b.fBe) {
                        z = true;
                    } else {
                        z = false;
                    }
                    intent.putExtra(str, z);
                    this.fAT.setResult(0, intent);
                    this.fAT.finish();
                }
                return false;
            }
        });
        this.fAs = findViewById(2131756794);
        this.fAt = (TextView) findViewById(2131756776);
        this.fAu = findViewById(2131756796);
        this.fAv = (EditText) findViewById(2131756795);
        this.fAw = findViewById(2131756799);
        this.abU = new TextWatcher(this) {
            final /* synthetic */ ExdeviceConnectWifiUI fAT;

            {
                this.fAT = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.length() > 31) {
                    this.fAT.fAu.setVisibility(0);
                    this.fAT.fAw.setEnabled(false);
                    return;
                }
                this.fAT.fAu.setVisibility(8);
                this.fAT.fAw.setEnabled(true);
            }
        };
        this.fAs.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ExdeviceConnectWifiUI fAT;

            {
                this.fAT = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.fAT.fAv.clearFocus();
                this.fAT.axg();
                return false;
            }
        });
        this.fAw.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ExdeviceConnectWifiUI fAT;

            {
                this.fAT = r1;
            }

            public final void onClick(View view) {
                v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onClick connectBtn.");
                ExdeviceConnectWifiUI.a(this.fAT, this.fAT.fAy);
            }
        });
        this.fAv.setTransformationMethod(new PasswordTransformationMethod());
        this.fAv.addTextChangedListener(this.abU);
        this.fAv.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ ExdeviceConnectWifiUI fAT;

            {
                this.fAT = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "on next Key down.");
                ExdeviceConnectWifiUI.a(this.fAT, this.fAT.fAy);
                return true;
            }
        });
        this.fAv.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ ExdeviceConnectWifiUI fAT;

            {
                this.fAT = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                ExdeviceConnectWifiUI.a(this.fAT, this.fAT.fAy);
                return true;
            }
        });
        this.fAv.requestFocus();
    }

    private void ks(int i) {
        long j = 0;
        if (i == 4) {
            j = System.currentTimeMillis() - this.fAL;
        }
        com.tencent.mm.plugin.report.service.g.iuh.h(13503, new Object[]{Integer.valueOf(i), Integer.valueOf(this.fAI), Long.valueOf(j), this.fAJ, this.fdK, Integer.valueOf(this.fAK)});
    }

    private com.tencent.mm.plugin.exdevice.d.a H(int i, String str) {
        if (be.kS(str) || this.fAN == null) {
            v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
            return null;
        }
        int i2 = 0;
        while (i2 < this.fAN.fvr.size()) {
            com.tencent.mm.plugin.exdevice.d.a aVar = (com.tencent.mm.plugin.exdevice.d.a) this.fAN.fvr.get(i2);
            if (aVar == null) {
                int i3 = i2 - 1;
                this.fAN.fvr.remove(i2);
                this.fAB = true;
                i2 = i3;
            } else if (aVar.fvo == i && str.equals(aVar.fvp)) {
                return aVar;
            }
            i2++;
        }
        return null;
    }

    private void akf() {
        if (this.fAy == null) {
            v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "wifiInfo is null, delay to fill.");
            this.fAC = true;
            return;
        }
        this.fAz.fvq = "";
        this.fAz.fvp = "";
        com.tencent.mm.plugin.exdevice.d.a H = H(this.fAE, this.fAy.getSSID());
        if (H == null) {
            return;
        }
        if (be.kS(H.fvq)) {
            v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
            this.fAN.fvr.remove(H);
            this.fAB = true;
            return;
        }
        this.fAz.fvq = c.ba(H.fvq, a.I(this.fAE, H.fvp));
        this.fAz.fvp = H.fvp;
        ad.o(this.fAS);
    }

    private String getPassword() {
        return this.fAv.getText() != null ? this.fAv.getText().toString() : null;
    }

    private void cP(boolean z) {
        this.fAy = com.tencent.mm.sdk.platformtools.ak.getWifiInfo(this);
        int i = z ? b.fBd : this.fAO;
        if (this.fAy == null) {
            i = b.fBe;
        } else {
            String ssid = this.fAy.getSSID();
            v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", new Object[]{ssid});
            if (be.kS(ssid)) {
                this.fAt.setText("");
            } else {
                this.fAt.setText(ssid.replaceAll("\"", ""));
            }
            if (!(be.kS(ssid) || ssid.equals(this.fAA))) {
                this.fAA = ssid;
            }
        }
        kt(i);
    }

    public final synchronized void kt(int i) {
        if (i == 0) {
            v.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
        } else {
            this.fAO = i;
            switch (AnonymousClass7.fAZ[i - 1]) {
                case 1:
                    b(true, false, false);
                    break;
                case 2:
                    b(true, true, false);
                    break;
                case 3:
                    b(false, false, false);
                    break;
                case 4:
                    ks(5);
                    this.fAD = true;
                    setResult(1);
                    break;
                case 5:
                    ks(4);
                    b(true, false, true);
                    this.fAD = true;
                    setResult(-1);
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ ExdeviceConnectWifiUI fAT;

                        {
                            this.fAT = r1;
                        }

                        public final void run() {
                            ExdeviceConnectWifiUI.q(this.fAT);
                        }
                    });
                    if (getIntent().getBooleanExtra("jumpToBindDevice", false)) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", getIntent().getStringExtra("device_scan_mode"));
                        intent.putExtra("device_scan_conn_proto", getIntent().getStringExtra("device_scan_conn_proto"));
                        intent.putExtra("device_id", getIntent().getStringExtra("device_id"));
                        intent.putExtra("device_type", getIntent().getStringExtra("device_type"));
                        intent.putExtra("device_title", getIntent().getStringExtra("device_title"));
                        intent.putExtra("device_desc", getIntent().getStringExtra("device_desc"));
                        intent.putExtra("device_icon_url", getIntent().getStringExtra("device_icon_url"));
                        intent.putExtra("device_category_id", getIntent().getStringExtra("device_category_id"));
                        intent.putExtra("device_brand_name", getIntent().getStringExtra("device_brand_name"));
                        intent.putExtra("bind_ticket", getIntent().getStringExtra("bind_ticket"));
                        com.tencent.mm.ay.c.b(this.nDR.nEl, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                        break;
                    }
                    break;
            }
            finish();
            if (i != b.fBd) {
                this.fAv.clearFocus();
                axg();
            }
        }
    }

    private void b(boolean z, boolean z2, boolean z3) {
        this.fAs.setVisibility(z ? 0 : 8);
        if (z2) {
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceConnectWifiUI fAT;

                {
                    this.fAT = r1;
                }

                public final void run() {
                    ExdeviceConnectWifiUI exdeviceConnectWifiUI = this.fAT;
                    ActionBarActivity actionBarActivity = this.fAT.nDR.nEl;
                    this.fAT.getString(2131231164);
                    exdeviceConnectWifiUI.fAx = g.a(actionBarActivity, this.fAT.getString(2131232587), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass5 fAY;

                        {
                            this.fAY = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            v.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
                            if (this.fAY.fAT.fAO != b.fBg) {
                                ExdeviceConnectWifiUI.r(this.fAY.fAT);
                            }
                        }
                    });
                }
            });
        } else {
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceConnectWifiUI fAT;

                {
                    this.fAT = r1;
                }

                public final void run() {
                    if (this.fAT.fAx != null && this.fAT.fAx.isShowing()) {
                        this.fAT.fAx.dismiss();
                    }
                }
            });
            if (this.fAR.isHeld()) {
                this.fAR.release();
            }
        }
        if (z3) {
            Toast.makeText(this.nDR.nEl, 2131232523, 0).show();
        }
    }
}
