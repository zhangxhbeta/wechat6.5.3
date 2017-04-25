package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.aa;

public final class b extends a {
    private static final int lsf = a.fromDPToPix(aa.getContext(), 48);
    private static final int lsg = a.fromDPToPix(aa.getContext(), 43);

    public final View tn(int i) {
        View view = null;
        Context context = this.fda;
        c cVar = this.lse;
        d dVar = new d();
        dVar.mIndex = i;
        dVar.lsr = this;
        dVar.mContext = context;
        dVar.lse = cVar;
        if (!(dVar.mContext == null || dVar.lsr == null)) {
            view = View.inflate(dVar.mContext, 2130904711, null);
            if (view instanceof WebViewSmileyGrid) {
                ((WebViewSmileyGrid) view).lse = dVar.lse;
                WebViewSmileyGrid webViewSmileyGrid = (WebViewSmileyGrid) view;
                int i2 = dVar.mIndex;
                int blJ = dVar.lsr.blJ();
                int ahs = dVar.lsr.ahs();
                int blK = dVar.lsr.blK();
                int rowCount = dVar.lsr.getRowCount();
                int blL = dVar.lsr.blL();
                webViewSmileyGrid.setLayoutParams(new LayoutParams(-1, -1));
                webViewSmileyGrid.setBackgroundResource(0);
                webViewSmileyGrid.setStretchMode(2);
                webViewSmileyGrid.setOnItemClickListener(webViewSmileyGrid.abT);
                webViewSmileyGrid.fkG = i2;
                webViewSmileyGrid.fkE = blJ;
                webViewSmileyGrid.lsi = ahs;
                webViewSmileyGrid.lsj = blL;
                webViewSmileyGrid.dWa = blK;
                webViewSmileyGrid.dWb = rowCount;
                webViewSmileyGrid.setNumColumns(blK);
                i2 = webViewSmileyGrid.lsj;
                blL = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                blJ = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                if (i2 == 0) {
                    i2 = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                }
                webViewSmileyGrid.setPadding(blL, i2, blJ, 0);
                webViewSmileyGrid.lsh = new a();
                webViewSmileyGrid.setAdapter(webViewSmileyGrid.lsh);
                webViewSmileyGrid.lsh.notifyDataSetChanged();
            }
        }
        return view;
    }

    public final int blJ() {
        return this.lse.Tg().Ti();
    }

    public final int ahs() {
        return blK() * getRowCount();
    }

    public final int getPageCount() {
        if (ahs() <= 0) {
            return 0;
        }
        return (int) Math.ceil(((double) blJ()) / ((double) ahs()));
    }

    public final int blK() {
        if (this.lse.lsn) {
            return 7;
        }
        c cVar = this.lse;
        if (cVar.fmd <= 1) {
            cVar.fmd = c.ahP()[0];
        }
        return cVar.fmd / lsg;
    }

    public final int blL() {
        return (this.lse.fmc - (lsf * getRowCount())) / (getRowCount() + 1);
    }

    public final int getRowCount() {
        int i = 3;
        int i2 = this.lse.fmc / lsf;
        if (i2 <= 3) {
            i = i2;
        }
        return i <= 0 ? 1 : i;
    }
}
