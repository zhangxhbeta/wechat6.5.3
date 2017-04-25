package com.tencent.mm.plugin.webview.stub;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.a.ad;
import com.tencent.mm.e.a.bl;
import com.tencent.mm.e.a.ir;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;

@a(7)
public class WebviewScanImageActivity extends Activity {
    private int aYV;
    private int aYW;
    private String jFv = null;
    private c jFy = new c<ir>(this) {
        final /* synthetic */ WebviewScanImageActivity lif;

        {
            this.lif = r2;
            this.nhz = ir.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ir irVar = (ir) bVar;
            if (irVar != null && (irVar instanceof ir)) {
                com.tencent.mm.sdk.c.a.nhr.f(this.lif.jFy);
                v.i("MicroMsg.WebviewScanImageActivity", "notify Event: %d", new Object[]{Integer.valueOf(irVar.bjg.bje)});
                v.d("MicroMsg.WebviewScanImageActivity", "%s, %s", new Object[]{irVar.bjg.aXH, this.lif});
                if (irVar.bjg.aXH == this.lif && irVar.bjg.aXG.equals(this.lif.jFv)) {
                    Bundle bundle = irVar.bjg.bjh;
                    int i;
                    switch (irVar.bjg.bje) {
                        case 0:
                        case 1:
                        case 2:
                            this.lif.finish();
                            break;
                        case 3:
                            if (bundle != null) {
                                i = bundle.getInt("geta8key_action_code", 0);
                                g.iuh.h(13329, new Object[]{this.lif.url, this.lif.jFv, Integer.valueOf(i)});
                            }
                            this.lif.finish();
                            break;
                        case 4:
                            if (bundle != null) {
                                i = bundle.getInt("geta8key_action_code", 0);
                                g.iuh.h(13329, new Object[]{this.lif.url, this.lif.jFv, Integer.valueOf(i)});
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
                v.e("MicroMsg.WebviewScanImageActivity", "not the same, eventStr: %s, origin: %s", new Object[]{irVar.bjg.aXG, this.lif.jFv});
            } else {
                v.e("MicroMsg.WebviewScanImageActivity", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            }
            return false;
        }
    };
    private boolean lie = false;
    private String url;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.WebviewScanImageActivity", "hy: on create");
        if (d.dW(21)) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        setContentView(2130903851);
    }

    protected void onStart() {
        super.onStart();
        v.i("MicroMsg.WebviewScanImageActivity", "hy: on start");
        if (!(this.lie || getIntent() == null)) {
            this.jFv = getIntent().getStringExtra("key_string_for_scan");
            this.aYV = getIntent().getIntExtra("key_codetype_for_scan", 0);
            this.aYW = getIntent().getIntExtra("key_codeversion_for_scan", 0);
            this.url = getIntent().getStringExtra("key_string_for_url");
            if (this.jFv != null) {
                bl blVar = new bl();
                blVar.aYU.aXH = this;
                blVar.aYU.aXG = this.jFv;
                blVar.aYU.aYW = this.aYW;
                blVar.aYU.aYV = this.aYV;
                blVar.aYU.aYX = 6;
                com.tencent.mm.sdk.c.a.nhr.z(blVar);
                com.tencent.mm.sdk.c.a.nhr.e(this.jFy);
            }
        }
        this.lie = true;
    }

    protected void onPause() {
        super.onPause();
        v.i("MicroMsg.WebviewScanImageActivity", "hy: on pause");
        ad adVar = new ad();
        adVar.aXF.aXH = this;
        adVar.aXF.aXG = this.jFv;
        com.tencent.mm.sdk.c.a.nhr.z(adVar);
        com.tencent.mm.sdk.c.a.nhr.f(this.jFy);
        finish();
    }
}
