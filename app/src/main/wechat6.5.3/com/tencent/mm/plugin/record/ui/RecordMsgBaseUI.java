package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.e.a.pn;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public abstract class RecordMsgBaseUI extends MMActivity {
    protected long bao = -1;
    protected ListView eyT = null;
    protected h iqo;

    protected abstract h aJK();

    protected abstract String aJL();

    protected abstract String aJM();

    protected abstract String aJN();

    protected abstract void aJO();

    protected abstract void b(int i, int i2, Intent intent);

    protected final int getLayoutId() {
        return 2130904263;
    }

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aJJ();
    }

    protected void aJJ() {
        this.iqo = aJK();
        this.bao = getIntent().getLongExtra("message_id", -1);
        this.eyT = (ListView) findViewById(2131758850);
        CharSequence aJL = aJL();
        String string = this.nDR.nEl.getString(2131232598);
        if (aJL.endsWith(string)) {
            aJL = aJL.substring(0, aJL.lastIndexOf(string) - 1);
        }
        H(e.a(this.nDR.nEl, aJL, getResources().getDimensionPixelSize(2131492967)));
        String aJM = aJM();
        string = aJN();
        if (be.kS(aJM) || be.kS(string)) {
            v.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
        } else {
            aJM = aJM.split(" ")[0];
            string = string.split(" ")[0];
            if (aJM.equals(string)) {
                this.iqo.iqi = false;
            } else {
                aJM = aJM + "~" + string;
                this.iqo.iqi = true;
            }
            NY(aJM);
        }
        View view = new View(this.nDR.nEl);
        view.setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(2131493182)));
        this.eyT.addHeaderView(view, null, false);
        view = View.inflate(this.nDR.nEl, 2130904262, null);
        this.eyT.setAdapter(this.iqo);
        this.iqo.Eq = this.eyT;
        this.iqo.aJP();
        this.eyT.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ RecordMsgBaseUI iqp;

            {
                this.iqp = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    pn pnVar = new pn();
                    pnVar.bqP.type = 5;
                    pnVar.bqP.bqQ = this.iqp.eyT.getFirstVisiblePosition();
                    pnVar.bqP.bqR = this.iqp.eyT.getLastVisiblePosition();
                    pnVar.bqP.bqS = this.iqp.eyT.getHeaderViewsCount();
                    a.nhr.z(pnVar);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RecordMsgBaseUI iqp;

            {
                this.iqp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iqp.finish();
                return true;
            }
        });
        aJO();
        this.eyT.postDelayed(new Runnable(this) {
            final /* synthetic */ RecordMsgBaseUI iqp;

            public final void run() {
                View childAt = this.iqp.eyT.getChildAt(this.iqp.eyT.getLastVisiblePosition());
                if (childAt != null) {
                    int bottom = childAt.getBottom();
                    int bottom2 = this.iqp.eyT.getBottom();
                    int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this.iqp.nDR.nEl, 64);
                    v.d("MicroMsg.RecordMsgBaseUI", "lastBotm %s, listBotm %s, listEndmargin %s", new Object[]{Integer.valueOf(bottom), Integer.valueOf(bottom2), Integer.valueOf(fromDPToPix)});
                    if (bottom < bottom2 - fromDPToPix) {
                        v.d("MicroMsg.RecordMsgBaseUI", "offset %d", new Object[]{Integer.valueOf((bottom2 - bottom) - fromDPToPix)});
                        view.setPadding(0, bottom, 0, 0);
                    }
                }
                this.iqp.eyT.addFooterView(view, null, false);
            }
        }, 100);
    }

    protected void onResume() {
        super.onResume();
        pn pnVar = new pn();
        pnVar.bqP.type = 0;
        pnVar.bqP.bqQ = this.eyT.getFirstVisiblePosition();
        pnVar.bqP.bqR = this.eyT.getLastVisiblePosition();
        pnVar.bqP.bqS = this.eyT.getHeaderViewsCount();
        a.nhr.z(pnVar);
    }

    protected void onPause() {
        super.onPause();
        pn pnVar = new pn();
        pnVar.bqP.type = 1;
        a.nhr.z(pnVar);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.iqo != null) {
            this.iqo.destroy();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        b(i, i2, intent);
    }
}
