package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import com.tencent.mm.sdk.platformtools.v;

abstract class a {
    RadarSpecialGridView iiQ = null;
    private int iiR = 3;
    private Context mContext = null;

    public abstract int getCount();

    public abstract View w(View view, int i);

    public a(RadarSpecialGridView radarSpecialGridView, Context context) {
        this.mContext = context;
        this.iiQ = radarSpecialGridView;
    }

    public void aIO() {
        if (this.iiR == 0) {
            v.e("MicroMsg.RadarGridView.GridDataAdapter", "column is 0, pls check!");
            return;
        }
        for (int i = 0; i < getCount(); i++) {
            TableRow tableRow;
            int i2 = i / this.iiR;
            int childCount = this.iiQ.ijt.getChildCount();
            if (childCount > i2) {
                tableRow = (TableRow) this.iiQ.ijt.getChildAt((childCount - 1) - i2);
            } else {
                tableRow = new TableRow(this.mContext);
                tableRow.setLayoutParams(new LayoutParams(-1, -2));
                this.iiQ.ijt.addView(tableRow, 0);
            }
            int i3 = i % this.iiR;
            int childCount2 = tableRow.getChildCount();
            int i4 = childCount2 <= i3 ? 1 : 0;
            View view = null;
            i3 = (childCount2 - 1) - i3;
            if (i4 == 0) {
                view = tableRow.getChildAt(i3);
            }
            View w = w(view, i);
            if (i4 != 0) {
                tableRow.addView(w, 0);
            } else if (w != view) {
                tableRow.removeViewAt(i3);
                tableRow.addView(w, i3);
            }
            w.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a iiS;

                public final void onClick(View view) {
                    if (this.iiS.iiQ.ijs != null) {
                        this.iiS.iiQ.ijs.e(i, view);
                    }
                }
            });
        }
        v.v("MicroMsg.RadarGridView.GridDataAdapter", "mTable rows count : " + this.iiQ.ijt.getChildCount());
    }
}
