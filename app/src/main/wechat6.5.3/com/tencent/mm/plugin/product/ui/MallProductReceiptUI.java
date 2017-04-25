package com.tencent.mm.plugin.product.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.protocal.c.apv;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.s;

public class MallProductReceiptUI extends MallBaseUI {
    private c hSa;
    private d hSq = null;
    private AutoCompleteTextView hSr = null;
    private h hSs = null;

    protected final int getLayoutId() {
        return 2130904186;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hSq = a.aFW().aFY();
        a.aFW();
        this.hSa = a.aFX();
        NI();
    }

    public final void NI() {
        vD(2131233766);
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ MallProductReceiptUI hSt;

            {
                this.hSt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i = 0;
                String obj = this.hSt.hSr.getText().toString();
                if (be.kS(obj)) {
                    s.makeText(this.hSt, 2131233765, 0).show();
                } else {
                    c b = this.hSt.hSa;
                    b.hQj = new apv();
                    apv com_tencent_mm_protocal_c_apv = b.hQj;
                    if (!be.kS(obj)) {
                        i = 1;
                    }
                    com_tencent_mm_protocal_c_apv.mPl = i;
                    b.hQj.glo = obj;
                    this.hSt.finish();
                }
                return true;
            }
        });
        this.hSr = (AutoCompleteTextView) findViewById(2131758612);
        apv aGe = this.hSa.aGe();
        if (!(aGe == null || be.kS(aGe.glo))) {
            this.hSr.setText(aGe.glo);
        }
        this.hSr.setSelection(this.hSr.getText().length());
        this.hSs = new h(this);
        this.hSr.setAdapter(this.hSs);
        this.hSr.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MallProductReceiptUI hSt;

            {
                this.hSt = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d c = this.hSt.hSq;
                CharSequence charSequence = (c.hQu == null || i >= c.hQu.size()) ? null : (String) c.hQu.get(i);
                v.d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = " + charSequence);
                if (!be.kS(charSequence)) {
                    this.hSt.hSr.setText(charSequence);
                }
            }
        });
        View.inflate(this.nDR.nEl, 2130904183, null).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductReceiptUI hSt;

            {
                this.hSt = r1;
            }

            public final void onClick(View view) {
                d c = this.hSt.hSq;
                c.hQu.clear();
                c.aGr();
                this.hSt.hSs.notifyDataSetChanged();
            }
        });
    }
}
