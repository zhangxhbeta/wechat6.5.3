package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.mm.plugin.scanner.b.q;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public class SelectScanModeGrid extends GridView {

    public static class a extends BaseAdapter {
        private Context context;
        private List<b> iBY;
        int iBZ = -1;

        static class a {
            public TextView hRT;
            public TextView iCa;

            a() {
            }
        }

        public a(Context context, List<b> list) {
            this.context = context;
            this.iBY = list;
            v.d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.iBY.size());
        }

        public final int getCount() {
            return this.iBY.size();
        }

        public final Object getItem(int i) {
            if (i >= 0 && i < this.iBY.size()) {
                return this.iBY.get(i);
            }
            v.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = " + i);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(this.context, 2130904336, null);
                aVar = new a();
                aVar.iCa = (TextView) view.findViewById(2131759049);
                aVar.hRT = (TextView) view.findViewById(2131759050);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (i == viewGroup.getChildCount()) {
                b bVar = (b) getItem(i);
                if (bVar == null) {
                    v.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getView fail, item is null");
                } else {
                    if (bVar.iCb == 2131234748) {
                        aVar.hRT.setText(q.cu(q.iEj, this.context.getString(2131234748)));
                    } else {
                        aVar.hRT.setText(bVar.iCb);
                    }
                    if (i == this.iBZ) {
                        aVar.iCa.setBackgroundResource(bVar.iCd);
                    } else {
                        aVar.iCa.setBackgroundResource(bVar.iCc);
                    }
                    bVar.iCf = aVar.iCa;
                }
            }
            return view;
        }
    }

    public static class b {
        public int iCb;
        public int iCc;
        public int iCd;
        public int iCe;
        public TextView iCf;

        public b(int i, int i2, int i3, int i4) {
            this.iCb = i;
            this.iCc = i2;
            this.iCd = i3;
            this.iCe = i4;
        }
    }

    public SelectScanModeGrid(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectScanModeGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
