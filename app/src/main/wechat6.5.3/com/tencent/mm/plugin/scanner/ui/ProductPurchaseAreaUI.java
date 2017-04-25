package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.scanner.a.a.a;
import com.tencent.mm.plugin.scanner.a.h;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.b.n;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class ProductPurchaseAreaUI extends MMPreference {
    protected f ezq;
    private String fdU;
    private List<a> izi;
    private int izj;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        n.a aN = i.aN(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (aN == null || aN.iEd == null) {
            v.w("MicroMsg.ProductPurchaseAreaUI", "Data product null");
            return;
        }
        this.fdU = aN.field_productid;
        this.izj = aN.field_functionType;
        String stringExtra = getIntent().getStringExtra("referkey");
        v.i("MicroMsg.ProductPurchaseAreaUI", "referkey:" + stringExtra);
        if (!be.kS(stringExtra)) {
            for (int i = 0; i < aN.iEd.size(); i++) {
                if (stringExtra.equals(((com.tencent.mm.plugin.scanner.a.a) aN.iEd.get(i)).ivG)) {
                    this.izi = ((com.tencent.mm.plugin.scanner.a.a) aN.iEd.get(i)).cZq;
                    Fd(((com.tencent.mm.plugin.scanner.a.a) aN.iEd.get(i)).title);
                    aLz();
                    return;
                }
            }
        }
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ProductPurchaseAreaUI izk;

            {
                this.izk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.izk.finish();
                return false;
            }
        });
        this.ezq = this.ocZ;
    }

    private void aLz() {
        if (this.izi != null) {
            for (int i = 0; i < this.izi.size(); i++) {
                a aVar = (a) this.izi.get(i);
                String valueOf = String.valueOf(i);
                if (aVar != null) {
                    a aVar2 = new a(this);
                    aVar2.setKey(valueOf);
                    aVar2.setTitle(aVar.name);
                    aVar2.setSummary(aVar.desc);
                    aVar2.ixe = aVar.cqK;
                    this.ezq.a(aVar2);
                    if (i != this.izi.size() - 1) {
                        this.ezq.a(new g(this.nDR.nEl));
                    }
                }
            }
            this.ezq.notifyDataSetChanged();
        }
    }

    public final boolean a(f fVar, Preference preference) {
        if (this.izi == null) {
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.dnU).intValue();
            if (intValue < 0 || intValue >= this.izi.size()) {
                return false;
            }
            a aVar = (a) this.izi.get(intValue);
            if (aVar == null) {
                return false;
            }
            String str = null;
            switch (aVar.type) {
                case 1:
                    str = aVar.cZp;
                    if (!be.kS(aVar.cZp)) {
                        f(this.nDR.nEl, aVar.cZp, this.izj);
                        break;
                    }
                    v.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
                    break;
                case 9:
                    str = aVar.ivO;
                    if (!be.kS(aVar.ivO)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", aVar.ivO);
                        intent.putExtra("key_product_scene", 12);
                        c.b(this, "product", ".ui.MallProductUI", intent);
                        break;
                    }
                    break;
                default:
                    v.i("MicroMsg.ProductPurchaseAreaUI", "Default go url:" + aVar.cZp);
                    if (!be.kS(aVar.cZp)) {
                        f(this.nDR.nEl, aVar.cZp, this.izj);
                        break;
                    }
                    break;
            }
            ak.vy().a(new h(this.fdU, aVar.ivN, aVar.type, str, this.izi.size(), aVar.aXx), 0);
            return true;
        } catch (Throwable e) {
            v.e("MicroMsg.ProductPurchaseAreaUI", "onPreferenceTreeClick, [%s]", new Object[]{e.getMessage()});
            v.a("MicroMsg.ProductPurchaseAreaUI", e, "", new Object[0]);
            return false;
        }
    }

    private static void f(Context context, String str, int i) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", i.oV(i));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }

    public final int Oo() {
        return 2131099708;
    }
}
