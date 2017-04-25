package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.d.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.aaq;
import com.tencent.mm.protocal.c.bgh;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.List;
import junit.framework.Assert;

public class IPCallMyGiftCardUI extends MMActivity implements e {
    private ListView Eq;
    private View dZV;
    private ProgressDialog eZg;
    private a gMF;
    private c gMG;

    private static class a extends BaseAdapter {
        private IPCallMyGiftCardUI gMI = null;
        aaq gMJ = null;
        List<bgh> grq = null;

        private class a {
            TextView gMK;
            TextView gML;
            TextView gMM;
            CdnImageView gMN;
            ImageView gMO;
            final /* synthetic */ a gMP;

            private a(a aVar) {
                this.gMP = aVar;
            }
        }

        public a(IPCallMyGiftCardUI iPCallMyGiftCardUI) {
            Assert.assertTrue(iPCallMyGiftCardUI != null);
            this.gMI = iPCallMyGiftCardUI;
        }

        public final int getCount() {
            return this.grq == null ? 0 : this.grq.size();
        }

        public final Object getItem(int i) {
            if (this.grq != null) {
                return this.grq.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.gMI.getSystemService("layout_inflater")).inflate(2130903833, viewGroup, false);
                aVar = new a();
                aVar.gMK = (TextView) view.findViewById(2131757524);
                aVar.gML = (TextView) view.findViewById(2131757525);
                aVar.gMM = (TextView) view.findViewById(2131757526);
                aVar.gMN = (CdnImageView) view.findViewById(2131755306);
                aVar.gMO = (ImageView) view.findViewById(2131757633);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            bgh com_tencent_mm_protocal_c_bgh = (bgh) getItem(i);
            if (be.kS(com_tencent_mm_protocal_c_bgh.nbS)) {
                aVar.gMK.setVisibility(0);
                aVar.gML.setVisibility(0);
                aVar.gMM.setVisibility(8);
                aVar.gMK.setText(com_tencent_mm_protocal_c_bgh.mNw);
                aVar.gML.setText(com_tencent_mm_protocal_c_bgh.nbR);
            } else {
                aVar.gMK.setVisibility(8);
                aVar.gML.setVisibility(8);
                aVar.gMM.setVisibility(0);
                aVar.gMM.setText(com_tencent_mm_protocal_c_bgh.nbS);
            }
            b.a(aVar.gMO, "", 0.5f, false);
            if (be.kS(com_tencent_mm_protocal_c_bgh.muL)) {
                aVar.gMO.setVisibility(0);
                aVar.gMN.setVisibility(4);
            } else {
                aVar.gMN.setVisibility(0);
                aVar.gMN.G(com_tencent_mm_protocal_c_bgh.muL, 0, 0);
                aVar.gMO.setVisibility(4);
            }
            return view;
        }
    }

    protected final int NO() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(288, this);
        vD(2131233419);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallMyGiftCardUI gMH;

            {
                this.gMH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gMH.finish();
                return true;
            }
        });
        a(0, this.nDR.nEl.getString(2131233417), new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallMyGiftCardUI gMH;

            {
                this.gMH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.gMH.getString(2131233351));
                intent.putExtra("showShare", false);
                com.tencent.mm.ay.c.b(this.gMH, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            }
        });
        this.dZV = findViewById(2131757635);
        this.Eq = (ListView) findViewById(2131757634);
        this.gMF = new a(this);
        this.Eq.setAdapter(this.gMF);
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.eZg = g.a(actionBarActivity, getString(2131233361), true, new OnCancelListener(this) {
            final /* synthetic */ IPCallMyGiftCardUI gMH;

            {
                this.gMH = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                try {
                    if (this.gMH.gMG != null) {
                        ak.vy().c(this.gMH.gMG);
                    }
                    this.gMH.finish();
                } catch (Exception e) {
                    v.e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", new Object[]{e.getMessage()});
                }
            }
        });
        this.gMG = new c();
        ak.vy().a(this.gMG, 0);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(288, this);
    }

    protected final int getLayoutId() {
        return 2130903834;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[]{Integer.valueOf(i2), str});
        if (!(kVar instanceof c)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            aaq com_tencent_mm_protocal_c_aaq = ((c) kVar).gHC;
            if (this.eZg != null && this.eZg.isShowing()) {
                this.eZg.dismiss();
            }
            this.gMF.grq = com_tencent_mm_protocal_c_aaq.mBV;
            this.gMF.gMJ = com_tencent_mm_protocal_c_aaq;
            this.gMF.notifyDataSetChanged();
            if (com_tencent_mm_protocal_c_aaq.mBV.size() == 0) {
                this.dZV.setVisibility(0);
                return;
            }
            return;
        }
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
        this.dZV.setVisibility(0);
        Toast.makeText(this.nDR.nEl, getString(2131233358), 0).show();
    }
}
