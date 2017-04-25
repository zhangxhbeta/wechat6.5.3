package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.h.j;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.mall.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.bgn;
import com.tencent.mm.protocal.c.bgo;
import com.tencent.mm.protocal.c.bgq;
import com.tencent.mm.protocal.c.bgr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.ui.e;

public class MallIndexOSUI extends MallIndexBaseUI {
    private a[] hiY = new a[3];
    private x hiZ = new x();
    private TextView hja = null;
    private long lastUpdateTime = 0;

    class a {
        public TextView eRp;
        final /* synthetic */ MallIndexOSUI hjc;
        public CdnImageView hjg;
        public TextView hjh;
        public View view;

        a(MallIndexOSUI mallIndexOSUI) {
            this.hjc = mallIndexOSUI;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hja = (TextView) findViewById(2131758049);
        this.hiZ = k.bgg().sp(this.hih);
        gQ(1577);
        v.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
        b bVar = new b();
        if (this.hiZ != null) {
            x xVar = this.hiZ;
            boolean z = xVar.kQG == null || xVar.kQG.mws == null || xVar.kQG.mws.size() == 0;
            if (!z) {
                b(bVar, false);
                return;
            }
        }
        p(bVar);
    }

    protected final void ayP() {
        e.a(this.hiQ, "1", this.hiZ.kQL, this.hiZ.hbY);
    }

    public final void a(MallFunction mallFunction, int i) {
        super.a(mallFunction, i);
        g.iuh.h(13720, new Object[]{mallFunction.gxI, Long.valueOf(be.KM(mallFunction.imm))});
    }

    protected final void ayG() {
        String str = this.hiZ.kQJ;
        String str2 = this.hiZ.kQK;
        Fd(str);
        NY(str2);
    }

    protected final void bU(View view) {
        this.hiY[0] = new a(this);
        this.hiY[0].view = view.findViewById(2131758035);
        this.hiY[0].hjg = (CdnImageView) view.findViewById(2131758036);
        this.hiY[0].eRp = (TextView) view.findViewById(2131758037);
        this.hiY[0].hjh = (TextView) view.findViewById(2131758038);
        this.hiY[0].hjg.setVisibility(4);
        this.hiY[1] = new a(this);
        this.hiY[1].view = view.findViewById(2131758039);
        this.hiY[1].hjg = (CdnImageView) view.findViewById(2131758040);
        this.hiY[1].eRp = (TextView) view.findViewById(2131758041);
        this.hiY[1].hjh = (TextView) view.findViewById(2131758042);
        this.hiY[1].hjg.setVisibility(4);
        this.hiY[2] = new a(this);
        this.hiY[2].view = view.findViewById(2131758043);
        this.hiY[2].hjg = (CdnImageView) view.findViewById(2131758044);
        this.hiY[2].eRp = (TextView) view.findViewById(2131758045);
        this.hiY[2].hjh = (TextView) view.findViewById(2131758047);
        this.hiY[2].hjg.setVisibility(4);
    }

    protected final void ayH() {
    }

    protected final void ayI() {
    }

    public void onResume() {
        super.onResume();
        v.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", new Object[]{Integer.valueOf(j.sU().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000), Long.valueOf(this.lastUpdateTime), Long.valueOf(System.currentTimeMillis())});
        if (System.currentTimeMillis() - this.lastUpdateTime >= ((long) (j.sU().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000))) {
            this.lastUpdateTime = System.currentTimeMillis();
            b(new b(), false);
        }
        ayG();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        gR(1577);
    }

    protected final boolean ayK() {
        bgn com_tencent_mm_protocal_c_bgn = this.hiZ.kQG;
        for (int i = 0; i < this.hiY.length; i++) {
            this.hiY[i].view.setVisibility(8);
            this.hiY[i].hjg.setImageBitmap(null);
        }
        int i2 = 0;
        while (i2 < com_tencent_mm_protocal_c_bgn.mws.size() && i2 < this.hiY.length) {
            final bgo com_tencent_mm_protocal_c_bgo = (bgo) com_tencent_mm_protocal_c_bgn.mws.get(i2);
            this.hiY[i2].view.setVisibility(0);
            this.hiY[i2].hjg.G(m.a(com_tencent_mm_protocal_c_bgo.nbW), 0, 0);
            this.hiY[i2].hjg.setVisibility(0);
            this.hiY[i2].eRp.setText(m.a(com_tencent_mm_protocal_c_bgo.nbV));
            v.i("MicroMsg.MallIndexOSUI", "item %d url %s", new Object[]{Integer.valueOf(i2), m.a(com_tencent_mm_protocal_c_bgo.nbW)});
            this.hiY[i2].hjh.setVisibility(8);
            CharSequence a = m.a(com_tencent_mm_protocal_c_bgo.nbY);
            if (!be.kS(a)) {
                this.hiY[i2].hjh.setText(a);
                this.hiY[i2].hjh.setVisibility(0);
            }
            this.hiY[i2].view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MallIndexOSUI hjc;

                public final void onClick(View view) {
                    g.iuh.h(13867, new Object[]{m.a(com_tencent_mm_protocal_c_bgo.nbX), Integer.valueOf(this.hjc.hih)});
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", m.a(com_tencent_mm_protocal_c_bgo.nbX));
                    intent.putExtra("geta8key_username", com.tencent.mm.model.k.xF());
                    intent.putExtra("pay_channel", 1);
                    c.b(this.hjc, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            });
            i2++;
        }
        if (!be.kS(this.hiZ.kQM)) {
            this.hja.setText(this.hiZ.kQM);
            this.hja.setVisibility(0);
        }
        return true;
    }

    protected final void ayQ() {
    }

    protected final void ayS() {
        this.nDR.bAi();
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ MallIndexOSUI hjc;

            {
                this.hjc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] strArr;
                final bgq com_tencent_mm_protocal_c_bgq = this.hjc.hiZ.kQH;
                final boolean z = this.hjc.hiZ.kQI;
                if (z) {
                    strArr = new String[(com_tencent_mm_protocal_c_bgq.mws.size() + 1)];
                    strArr[com_tencent_mm_protocal_c_bgq.mws.size()] = this.hjc.getString(2131236205);
                } else {
                    strArr = new String[com_tencent_mm_protocal_c_bgq.mws.size()];
                }
                for (int i = 0; i < com_tencent_mm_protocal_c_bgq.mws.size(); i++) {
                    strArr[i] = m.a(((bgr) com_tencent_mm_protocal_c_bgq.mws.get(i)).nbV);
                }
                com.tencent.mm.ui.base.g.a(this.hjc.nDR.nEl, null, strArr, null, false, new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ AnonymousClass2 hjf;

                    public final void gT(int i) {
                        if (i < com_tencent_mm_protocal_c_bgq.mws.size()) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", m.a(((bgr) com_tencent_mm_protocal_c_bgq.mws.get(i)).nca));
                            c.b(this.hjf.hjc, "webview", ".ui.tools.WebViewUI", intent);
                        } else if (z) {
                            this.hjf.hjc.ayV();
                        }
                    }
                });
                return true;
            }
        });
    }

    protected final void ayU() {
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        super.d(i, i2, str, kVar);
        if (kVar.getType() == 1577) {
            this.hiZ = k.bgg().sp(this.hih);
            ayP();
            ayK();
            ayG();
        }
        return true;
    }
}
