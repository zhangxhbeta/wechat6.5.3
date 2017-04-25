package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class WalletMultiRcptSelectUI extends MMPreference {
    private f dxf;
    private int dyp = 0;
    private RcptItem dyq = null;
    private RcptItem dyr = null;
    private List<RcptItem> dys;

    private void OB() {
        switch (this.dyp) {
            case 1:
                this.dyq = null;
                this.dyp = 0;
                break;
            case 2:
                this.dyr = null;
                this.dyp = 1;
                break;
        }
        Intent intent = new Intent();
        intent.putExtra("key_stage", this.dyp);
        intent.putExtra("key_province", this.dyq);
        intent.putExtra("key_city", this.dyr);
        setResult(0, intent);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dxf = this.ocZ;
        NI();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int Oo() {
        return 2131099714;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void NI() {
        /*
        r5 = this;
        r0 = 2131230875; // 0x7f08009b float:1.8077815E38 double:1.0529679587E-314;
        r1 = r5.getIntent();
        if (r1 == 0) goto L_0x0010;
    L_0x0009:
        r2 = "ui_title";
        r0 = r1.getIntExtra(r2, r0);
    L_0x0010:
        r5.vD(r0);
        r0 = new com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI$1;
        r0.<init>(r5);
        r5.b(r0);
        r5.o(r1);
        r0 = com.tencent.mm.plugin.address.a.a.Oq();
        r0 = r0.dxr;
        if (r0 == 0) goto L_0x002c;
    L_0x0026:
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x003c;
    L_0x002c:
        r0 = "MicroMsg.MultiRptSelectUI";
        r1 = "list == null || list.isEmpty(), need loadata!";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r0 = com.tencent.mm.plugin.address.a.a.Oq();
        r0.Or();
    L_0x003c:
        r0 = r5.dyp;
        switch(r0) {
            case 0: goto L_0x0062;
            case 1: goto L_0x006c;
            case 2: goto L_0x008a;
            default: goto L_0x0041;
        };
    L_0x0041:
        com.tencent.mm.plugin.address.a.a.Op();
        r0 = com.tencent.mm.plugin.address.a.a.Oq();
        r0 = r0.dxr;
    L_0x004a:
        r5.dys = r0;
        r0 = r5.dys;
        if (r0 == 0) goto L_0x0058;
    L_0x0050:
        r0 = r5.dys;
        r0 = r0.size();
        if (r0 > 0) goto L_0x00a8;
    L_0x0058:
        r0 = "MicroMsg.MultiRptSelectUI";
        r1 = "initZoneItems error ,check zone lists!";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
    L_0x0061:
        return;
    L_0x0062:
        com.tencent.mm.plugin.address.a.a.Op();
        r0 = com.tencent.mm.plugin.address.a.a.Oq();
        r0 = r0.dxr;
        goto L_0x004a;
    L_0x006c:
        r0 = r5.dyq;
        if (r0 == 0) goto L_0x008a;
    L_0x0070:
        r0 = r5.dyq;
        r0 = r0.code;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x008a;
    L_0x007a:
        com.tencent.mm.plugin.address.a.a.Op();
        r0 = com.tencent.mm.plugin.address.a.a.Oq();
        r1 = r5.dyq;
        r1 = r1.code;
        r0 = r0.mm(r1);
        goto L_0x004a;
    L_0x008a:
        r0 = r5.dyr;
        if (r0 == 0) goto L_0x0041;
    L_0x008e:
        r0 = r5.dyr;
        r0 = r0.code;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x0041;
    L_0x0098:
        com.tencent.mm.plugin.address.a.a.Op();
        r0 = com.tencent.mm.plugin.address.a.a.Oq();
        r1 = r5.dyr;
        r1 = r1.code;
        r0 = r0.mn(r1);
        goto L_0x004a;
    L_0x00a8:
        r0 = r5.dxf;
        r0.removeAll();
        r0 = 0;
        r1 = r0;
    L_0x00af:
        r0 = r5.dys;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x010d;
    L_0x00b7:
        r0 = r5.dys;
        r0 = r0.get(r1);
        if (r0 == 0) goto L_0x00f4;
    L_0x00bf:
        r0 = r5.dys;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.plugin.address.model.RcptItem) r0;
        r0 = r0.name;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x00f4;
    L_0x00cf:
        r2 = new com.tencent.mm.plugin.address.ui.RcptPreference;
        r2.<init>(r5);
        r0 = r5.dys;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.plugin.address.model.RcptItem) r0;
        if (r0 == 0) goto L_0x00e6;
    L_0x00de:
        r3 = r0.name;
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r3);
        if (r3 == 0) goto L_0x00f8;
    L_0x00e6:
        r0 = "MicroMsg.RcptPreference";
        r3 = "setZoneItem item = null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r3);
    L_0x00ef:
        r0 = r5.dxf;
        r0.a(r2);
    L_0x00f4:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00af;
    L_0x00f8:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r0.code;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.setKey(r3);
        r2.dyf = r0;
        goto L_0x00ef;
    L_0x010d:
        r0 = new com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
        r0.<init>(r5);
        r1 = r5.dxf;
        r1.a(r0);
        goto L_0x0061;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI.NI():void");
    }

    private void o(Intent intent) {
        RcptItem rcptItem = null;
        if (intent == null) {
            v.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
            return;
        }
        RcptItem rcptItem2;
        this.dyp = intent.getIntExtra("key_stage", 0);
        this.dyq = (RcptItem) intent.getParcelableExtra("key_province");
        this.dyr = (RcptItem) intent.getParcelableExtra("key_city");
        String stringExtra = intent.getStringExtra("extra_province");
        if (stringExtra != null) {
            a.Op();
            i Oq = a.Oq();
            if (!be.kS(stringExtra)) {
                for (RcptItem rcptItem22 : Oq.dxr) {
                    if (rcptItem22.name.startsWith(stringExtra)) {
                        break;
                    }
                }
            }
            rcptItem22 = null;
            this.dyq = rcptItem22;
            if (this.dyq != null) {
                this.dyp = 1;
            }
        }
        stringExtra = intent.getStringExtra("extra_city");
        if (stringExtra != null && 1 == this.dyp) {
            a.Op();
            List<RcptItem> mm = a.Oq().mm(this.dyq.code);
            if (mm != null && mm.size() != 0) {
                for (RcptItem rcptItem222 : mm) {
                    if (rcptItem222.name.startsWith(stringExtra)) {
                        rcptItem = rcptItem222;
                        break;
                    }
                }
            }
            this.dyr = rcptItem;
            if (this.dyr != null) {
                this.dyp = 2;
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference instanceof RcptPreference) {
            RcptItem rcptItem = ((RcptPreference) preference).dyf;
            if (rcptItem == null || be.kS(rcptItem.name)) {
                v.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
            } else {
                if (!rcptItem.dxp) {
                    this.dyp = 2;
                }
                switch (this.dyp) {
                    case 0:
                        this.dyq = rcptItem;
                        this.dyp = 1;
                        break;
                    case 1:
                        this.dyr = rcptItem;
                        this.dyp = 2;
                        break;
                    case 2:
                        StringBuilder stringBuilder = new StringBuilder();
                        if (this.dyq != null) {
                            stringBuilder.append(this.dyq.name).append(" ");
                        }
                        if (this.dyr != null) {
                            stringBuilder.append(this.dyr.name).append(" ");
                        }
                        stringBuilder.append(rcptItem.name);
                        v.d("MicroMsg.MultiRptSelectUI", "area_result: " + stringBuilder.toString() + ",item.name: " + rcptItem.name);
                        Intent intent = new Intent();
                        intent.putExtra("karea_result", stringBuilder.toString());
                        intent.putExtra("kpost_code", rcptItem.dxo);
                        intent.putExtra("kwcode", rcptItem.code);
                        setResult(-1, intent);
                        finish();
                        break;
                }
                Intent intent2 = getIntent();
                int intExtra = intent2 != null ? intent2.getIntExtra("ui_title", -1) : -1;
                Intent intent3 = new Intent(this, WalletMultiRcptSelectUI.class);
                intent3.putExtra("key_stage", this.dyp);
                intent3.putExtra("key_province", this.dyq);
                intent3.putExtra("key_city", this.dyr);
                if (-1 != intExtra) {
                    intent3.putExtra("ui_title", intExtra);
                }
                startActivityForResult(intent3, 1);
            }
        }
        return false;
    }

    public void onBackPressed() {
        OB();
        super.onBackPressed();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    setResult(-1, intent);
                    finish();
                    return;
                }
                o(intent);
                return;
            default:
                return;
        }
    }
}
