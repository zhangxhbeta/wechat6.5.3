package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.od;
import com.tencent.mm.e.a.oe;
import com.tencent.mm.e.a.of;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.am;
import com.tencent.mm.plugin.sns.j.a;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class SnsSingleTextViewUI extends MMActivity {
    private String bde;
    private ClipboardManager fRJ;
    private d hkn = new d(this) {
        final /* synthetic */ SnsSingleTextViewUI jTm;

        {
            this.jTm = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 0:
                    if (this.jTm.jTg != null && this.jTm.jTg.getText() != null) {
                        this.jTm.fRJ.setText(this.jTm.jTg.getText());
                        g.bf(this.jTm.nDR.nEl, this.jTm.nDR.nEl.getString(2131231016));
                        return;
                    }
                    return;
                case 1:
                    if (this.jTm.jTg != null && this.jTm.jTg.getText() != null) {
                        bp bpVar = new bp();
                        a.a(bpVar, this.jTm.bde, this.jTm.jTg.getText());
                        bpVar.aZd.aXH = this.jTm;
                        bpVar.aZd.aZl = 18;
                        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                        return;
                    }
                    return;
                case 6:
                    if (this.jTm.jTg != null && this.jTm.jTg.getText() != null) {
                        Intent intent = new Intent();
                        k Bq = ad.aSE().Bq(this.jTm.bde);
                        intent.putExtra("k_username", Bq == null ? "" : Bq.field_userName);
                        intent.putExtra("k_expose_msg_id", Bq == null ? Integer.valueOf(0) : Bq.aUq());
                        intent.putExtra("showShare", false);
                        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                        c.b(this.jTm, "webview", ".ui.tools.WebViewUI", intent);
                        return;
                    }
                    return;
                case an.CTRL_INDEX /*14*/:
                    if (this.jTm.jTg != null && this.jTm.jTg.getText() != null) {
                        am.o(ad.aSE().Bq(this.jTm.bde));
                        return;
                    }
                    return;
                case 16:
                    if (this.jTm.jTg != null && this.jTm.jTg.getText() != null) {
                        am.p(ad.aSE().Bq(this.jTm.bde));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private TextView jTg;
    private boolean jTh = false;
    private SnsTranslateResultView jTi;
    private com.tencent.mm.sdk.c.c jTj = new com.tencent.mm.sdk.c.c<oe>(this) {
        final /* synthetic */ SnsSingleTextViewUI jTm;

        {
            this.jTm = r2;
            this.nhz = oe.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            oe oeVar = (oe) bVar;
            if ((oeVar instanceof oe) && this.jTm.joh != null && this.jTm.joh.aUq().equals(oeVar.bph.id)) {
                am.aS(this.jTm.joh.aUq(), 8);
                this.jTm.jTi.setVisibility(0);
                this.jTm.jTi.ri(2);
                this.jTm.jTh = false;
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jTk = new com.tencent.mm.sdk.c.c<od>(this) {
        final /* synthetic */ SnsSingleTextViewUI jTm;

        {
            this.jTm = r2;
            this.nhz = od.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            od odVar = (od) bVar;
            if ((odVar instanceof od) && this.jTm.joh != null && this.jTm.joh.aUq().equals(odVar.bpf.id)) {
                am.aS(this.jTm.joh.aUq(), 8);
                String str = odVar.bpf.bfz;
                String str2 = odVar.bpf.bpg;
                if (be.kS(str)) {
                    this.jTm.jTi.setVisibility(8);
                    am.aT(this.jTm.joh.aUq(), 8);
                } else {
                    this.jTm.jTi.setVisibility(0);
                    this.jTm.jTi.a(null, 1, str, str2, true);
                    this.jTm.jTh = true;
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jTl = new com.tencent.mm.sdk.c.c<of>(this) {
        final /* synthetic */ SnsSingleTextViewUI jTm;

        {
            this.jTm = r2;
            this.nhz = of.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            of ofVar = (of) bVar;
            if ((ofVar instanceof of) && this.jTm.joh.aUq().equals(ofVar.bpi.id)) {
                am.aT(ofVar.bpi.id, 8);
                this.jTm.jTi.setVisibility(8);
                this.jTm.jTh = false;
            }
            return false;
        }
    };
    private k joh;
    protected int requestType = 0;
    private String text;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fRJ = (ClipboardManager) getSystemService("clipboard");
        vD(2131235373);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsSingleTextViewUI jTm;

            {
                this.jTm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jTm.finish();
                return true;
            }
        });
        this.text = getIntent().getStringExtra("sns_text_show");
        this.bde = be.ah(getIntent().getStringExtra("sns_local_id"), "");
        this.joh = ad.aSE().Bq(this.bde);
        if (be.kS(this.text)) {
            this.text = "";
        }
        this.jTg = (TextView) findViewById(2131759458);
        this.jTg.setText(this.text, BufferType.SPANNABLE);
        e.e(this.jTg, 2);
        this.jTg.setOnTouchListener(new y());
        new l(this).a(this.jTg, this, this.hkn);
        this.jTi = (SnsTranslateResultView) findViewById(2131759300);
        this.jTi.ae(this.jTg.getTextSize());
        if (this.joh != null && am.aU(this.joh.aUq(), 8)) {
            am.b AA = am.AA(this.joh.aUq());
            if (AA != null && AA.cvW) {
                this.jTi.setVisibility(0);
                this.jTi.a(null, 1, AA.bfz, AA.cDd, false);
                this.jTh = true;
            }
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.jTj);
        com.tencent.mm.sdk.c.a.nhr.e(this.jTk);
        com.tencent.mm.sdk.c.a.nhr.e(this.jTl);
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.c.a.nhr.f(this.jTj);
        com.tencent.mm.sdk.c.a.nhr.f(this.jTk);
        com.tencent.mm.sdk.c.a.nhr.f(this.jTl);
    }

    protected final int getLayoutId() {
        return 2130904496;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view instanceof TextView) {
            contextMenu.add(0, 0, 0, getString(2131231773));
            if (c.EH("favorite")) {
                contextMenu.add(0, 1, 0, getString(2131232638));
            }
            contextMenu.add(0, 6, 1, getString(2131231779));
            if (this.jTh) {
                am.b(contextMenu, true);
            } else {
                am.a(contextMenu, true);
            }
        }
    }
}
