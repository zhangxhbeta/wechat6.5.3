package com.tencent.mm.plugin.ipcall.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.q;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class IPCallMsgUI extends MMActivity {
    private View eKT;
    private boolean eKU = true;
    private com.tencent.mm.sdk.h.g.a gMA = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ IPCallMsgUI gMB;

        {
            this.gMB = r1;
        }

        public final void a(String str, i iVar) {
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ AnonymousClass7 gMC;

                {
                    this.gMC = r1;
                }

                public final void run() {
                    synchronized (this.gMC.gMB.gMy) {
                        v.v("MicroMsg.IPCallMsgUI", "comment notify");
                        this.gMC.gMB.gMy.a(null, null);
                    }
                }
            });
        }
    };
    private ListView gMx;
    private a gMy;
    private View gMz;

    class a extends j<g> {
        int eKW = 10;
        int emv = this.eKW;
        protected f euc;
        protected c eud;
        protected d euf = new d(this) {
            final /* synthetic */ a gME;

            {
                this.gME = r1;
            }

            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                if (z) {
                    gMD.add(mMSlideDelView);
                } else {
                    gMD.remove(mMSlideDelView);
                }
            }

            public final boolean avl() {
                return gMD.size() > 0;
            }

            public final void avm() {
                for (MMSlideDelView mMSlideDelView : gMD) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.bCu();
                    }
                }
                gMD.clear();
            }

            public final void avn() {
                for (MMSlideDelView mMSlideDelView : gMD) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.bCt();
                    }
                }
                gMD.clear();
            }
        };
        final /* synthetic */ IPCallMsgUI gMB;
        private Set<MMSlideDelView> gMD = new HashSet();

        class a {
            TextView dtB;
            TextView dyL;
            TextView fBO;
            final /* synthetic */ a gME;

            a(a aVar) {
                this.gME = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (g) obj;
            if (obj == null) {
                obj = new g();
                v.d("MicroMsg.IPCallMsgUI", "new IPCallMsg");
            }
            obj.b(cursor);
            return obj;
        }

        public a(IPCallMsgUI iPCallMsgUI, Context context, g gVar) {
            this.gMB = iPCallMsgUI;
            super(context, gVar);
        }

        public final long getItemId(int i) {
            return ((g) getItem(i)).nmb;
        }

        protected final void Om() {
            avc();
            Ol();
        }

        public final void a(f fVar) {
            this.euc = fVar;
        }

        public final void a(c cVar) {
            this.eud = cVar;
        }

        public final synchronized void a(String str, i iVar) {
            super.a(str, iVar);
        }

        public final void Ol() {
            this.emv = com.tencent.mm.plugin.ipcall.a.i.auu().getCount();
            h auu = com.tencent.mm.plugin.ipcall.a.i.auu();
            int i = this.eKW;
            setCursor(auu.cie.query("IPCallMsg", h.gIH, null, null, null, null, "pushTime desc limit " + i));
            notifyDataSetChanged();
        }

        public final boolean abO() {
            return this.eKW >= this.emv;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            g gVar = (g) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = q.em(this.context).inflate(2130903831, null);
                aVar = new a(this);
                aVar.dtB = (TextView) view.findViewById(2131755634);
                aVar.dyL = (TextView) view.findViewById(2131757629);
                aVar.fBO = (TextView) view.findViewById(2131757630);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.dtB.setText(gVar.field_title);
            aVar.dyL.setText(gVar.field_content);
            TextView textView = aVar.fBO;
            ActionBarActivity actionBarActivity = this.gMB.nDR.nEl;
            long j = gVar.field_pushTime * 1000;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            String str = (String) DateFormat.format(actionBarActivity.getString(2131232866), j);
            if (str.indexOf("-") > 0) {
                charSequence = (str.split("-")[1] + " " + com.tencent.mm.plugin.ipcall.b.c.af(actionBarActivity, str.split("-")[0]) + " ") + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.g(actionBarActivity, j));
            } else {
                long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis <= 0 || timeInMillis > 86400000) {
                    timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    charSequence = (timeInMillis <= 0 || timeInMillis > 86400000) ? str + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.g(actionBarActivity, j)) : actionBarActivity.getString(2131232911) + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.g(actionBarActivity, j));
                } else {
                    charSequence = ((String) com.tencent.mm.plugin.ipcall.b.c.g(actionBarActivity, j));
                }
            }
            textView.setText(charSequence);
            if ((gVar.field_isRead == (short) 1 ? 1 : null) != null) {
                aVar.dtB.setTextColor(this.gMB.getResources().getColor(2131689804));
            } else {
                aVar.dtB.setTextColor(this.gMB.getResources().getColor(2131689805));
            }
            return view;
        }
    }

    protected final int NO() {
        return 1;
    }

    protected final int getLayoutId() {
        return 2130903832;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.ipcall.a.i.auu().c(this.gMA);
        NI();
    }

    public void onDestroy() {
        v.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
        com.tencent.mm.plugin.ipcall.a.i.auu().d(this.gMA);
        this.gMy.avc();
        h auu = com.tencent.mm.plugin.ipcall.a.i.auu();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isRead", Short.valueOf((short) 1));
        auu.cie.update(auu.getTableName(), contentValues, "isRead!=? ", new String[]{"1"});
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131233416);
        this.gMz = findViewById(2131757632);
        this.gMx = (ListView) findViewById(2131757631);
        this.eKT = q.em(this).inflate(2130903984, null);
        this.gMx.addFooterView(this.eKT);
        this.gMy = new a(this, this, new g());
        this.gMy.a(new c(this) {
            final /* synthetic */ IPCallMsgUI gMB;

            {
                this.gMB = r1;
            }

            public final int bN(View view) {
                return this.gMB.gMx.getPositionForView(view);
            }
        });
        this.gMy.a(new f(this) {
            final /* synthetic */ IPCallMsgUI gMB;

            {
                this.gMB = r1;
            }

            public final void p(View view, int i) {
                this.gMB.gMx.performItemClick(view, i, 0);
            }
        });
        this.gMy.nDK = new com.tencent.mm.ui.j.a(this) {
            final /* synthetic */ IPCallMsgUI gMB;

            {
                this.gMB = r1;
            }

            public final void Oj() {
            }

            public final void Oi() {
                if (this.gMB.gMy.getCount() == 0) {
                    this.gMB.gMx.setVisibility(8);
                    this.gMB.gMz.setVisibility(0);
                    return;
                }
                this.gMB.gMx.setVisibility(0);
                this.gMB.gMz.setVisibility(8);
            }
        };
        this.gMx.setAdapter(this.gMy);
        this.gMx.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ IPCallMsgUI gMB;

            {
                this.gMB = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g gVar = (g) this.gMB.gMy.getItem(i);
                if (!be.kS(gVar.field_descUrl)) {
                    int i2 = gVar.field_msgType;
                    com.tencent.mm.plugin.report.service.g.iuh.h(13780, new Object[]{Integer.valueOf(i2)});
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", gVar.field_descUrl);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.ay.c.b(this.gMB, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
        this.gMx.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ IPCallMsgUI gMB;

            {
                this.gMB = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    a b = this.gMB.gMy;
                    if (!b.abO()) {
                        b.eKW += 10;
                        if (b.eKW > b.emv) {
                            b.eKW = b.emv;
                        }
                    } else if (b.gMB.eKT.getParent() != null) {
                        b.gMB.gMx.removeFooterView(b.gMB.eKT);
                    }
                    this.gMB.gMy.a(null, null);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        if (this.gMy.getCount() == 0) {
            this.gMx.setVisibility(8);
            this.gMz.setVisibility(0);
            iT(false);
        } else {
            this.gMx.setVisibility(0);
            this.gMz.setVisibility(8);
            iT(true);
        }
        if (this.gMy.abO()) {
            this.gMx.removeFooterView(this.eKT);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallMsgUI gMB;

            {
                this.gMB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gMB.finish();
                return true;
            }
        });
        if (this.gMy.abO()) {
            this.gMx.removeFooterView(this.eKT);
        }
    }
}
