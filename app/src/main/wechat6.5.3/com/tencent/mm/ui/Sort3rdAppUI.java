package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.o;
import com.tencent.mm.ui.widget.DragSortListView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3rdAppUI extends MMActivity {
    private DragSortListView fhU;
    private a nHg;
    private long nHh;
    private List<f> nHi;

    private static class a extends ArrayAdapter<f> {
        List<f> eZk;
        private c fzb;
        private Context mContext;
        private long nHh;

        static class a {
            TextView dtY;
            View eZl;
            ImageView eZm;
            ImageView eZn;
            MMSwitchBtn nHn;

            public a(View view) {
                this.eZm = (ImageView) view.findViewById(2131758332);
                this.eZn = (ImageView) view.findViewById(2131756775);
                this.dtY = (TextView) view.findViewById(2131756774);
                this.nHn = (MMSwitchBtn) view.findViewById(2131758333);
                this.eZl = view.findViewById(2131755326);
            }
        }

        public a(Context context, List<f> list, long j) {
            super(context, 2130904524, list);
            this.nHh = j;
            this.mContext = context;
            this.eZk = list;
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            this.fzb = aVar.GU();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z = true;
            if (view == null) {
                view = View.inflate(this.mContext, 2130904524, null);
                a aVar2 = new a(view);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            final f fVar = (f) getItem(i);
            aVar.dtY.setText(fVar.field_appName);
            Bitmap b = g.b(fVar.field_appId, 1, com.tencent.mm.bd.a.getDensity(this.mContext));
            if (b == null || b.isRecycled()) {
                n.GL().a(fVar.field_appIconUrl, aVar.eZn, this.fzb);
            } else {
                aVar.eZn.setImageBitmap(b);
            }
            MMSwitchBtn mMSwitchBtn = aVar.nHn;
            if ((fVar.field_appInfoFlag & 16384) != 0) {
                z = false;
            }
            mMSwitchBtn.kq(z);
            aVar.nHn.pdu = new com.tencent.mm.ui.widget.MMSwitchBtn.a(this) {
                final /* synthetic */ a nHm;

                public final void gB(boolean z) {
                    f fVar;
                    if (z) {
                        fVar = fVar;
                        fVar.field_appInfoFlag &= -16385;
                    } else {
                        fVar = fVar;
                        fVar.field_appInfoFlag |= 16384;
                    }
                    am.bnB().a(fVar, new String[0]);
                }
            };
            view.setVisibility(0);
            return view;
        }
    }

    protected final int getLayoutId() {
        return 2130904523;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nHh = getIntent().getLongExtra("KFlag", -1);
        NI();
        this.nHi = g.b((Context) this, this.nHh, true);
        final List dB = am.bnD().dB(this.nHh);
        if (dB != null && dB.size() > 0) {
            Collections.sort(this.nHi, new Comparator<f>(this) {
                final /* synthetic */ Sort3rdAppUI nHj;

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return dB.indexOf(((f) obj2).field_appId) - dB.indexOf(((f) obj).field_appId);
                }
            });
        }
        this.nHg = new a(this, this.nHi, this.nHh);
        this.fhU.setAdapter(this.nHg);
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ Sort3rdAppUI nHj;

            {
                this.nHj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nHj.finish();
                return true;
            }
        });
        Fd(getString(2131230797));
        this.fhU = (DragSortListView) findViewById(2131755705);
        this.fhU.oZO = new DragSortListView.g(this) {
            final /* synthetic */ Sort3rdAppUI nHj;

            {
                this.nHj = r1;
            }

            public final void bz(int i, int i2) {
                f fVar = (f) this.nHj.nHg.getItem(i);
                this.nHj.nHg.remove(fVar);
                this.nHj.nHg.insert(fVar, i2);
            }
        };
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        if (this.nHg != null) {
            List list = this.nHg.eZk;
            o bnD = am.bnD();
            long j = this.nHh;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete from AppSort");
            stringBuilder.append(" where flag = ").append(j).append(" ");
            bnD.cie.dF("AppSort", stringBuilder.toString());
            if (list != null && list.size() > 0) {
                ak.yW();
                j = com.tencent.mm.model.c.wE().er(Thread.currentThread().getId());
                o bnD2 = am.bnD();
                for (int i = 0; i < list.size(); i++) {
                    com.tencent.mm.pluginsdk.model.app.n nVar = new com.tencent.mm.pluginsdk.model.app.n();
                    nVar.field_flag = this.nHh;
                    nVar.field_appId = ((f) list.get(i)).field_appId;
                    nVar.field_sortId = i;
                    bnD2.a(nVar);
                }
                ak.yW();
                com.tencent.mm.model.c.wE().es(j);
            }
        }
    }
}
