package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.List;

public final class d {

    static class AnonymousClass1 implements OnItemClickListener {
        final /* synthetic */ OnItemClickListener hRP;
        final /* synthetic */ a hRQ;

        AnonymousClass1(OnItemClickListener onItemClickListener, a aVar) {
            this.hRP = onItemClickListener;
            this.hRQ = aVar;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.hRP != null) {
                this.hRP.onItemClick(adapterView, view, i, j);
            }
            this.hRQ.hRS = i;
            this.hRQ.notifyDataSetChanged();
        }
    }

    static class a extends BaseAdapter {
        private final Context context;
        List<String> hRR;
        int hRS = -1;
        private final int style;

        public a(Context context) {
            this.context = context;
            this.style = 1;
        }

        public final int getCount() {
            return this.hRR != null ? this.hRR.size() : 0;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            if (view == null) {
                view = View.inflate(this.context, 2130904039, null);
                b bVar = new b();
                bVar.hRT = (TextView) view.findViewById(2131755098);
                bVar.hRU = (CheckBox) view.findViewById(2131758278);
                bVar.hRV = (RadioButton) view.findViewById(2131755243);
                view.setTag(bVar);
            }
            b bVar2 = (b) view.getTag();
            bVar2.hRT.setText((CharSequence) this.hRR.get(i));
            switch (this.style) {
                case 1:
                    bVar2.hRU.setVisibility(8);
                    bVar2.hRV.setVisibility(0);
                    bVar2.hRV.setChecked(i == this.hRS);
                    break;
                case 2:
                    bVar2.hRU.setVisibility(0);
                    bVar2.hRV.setVisibility(8);
                    CheckBox checkBox = bVar2.hRU;
                    if (i != this.hRS) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    break;
                default:
                    bVar2.hRU.setVisibility(8);
                    bVar2.hRV.setVisibility(8);
                    break;
            }
            return view;
        }
    }

    static class b {
        TextView hRT;
        CheckBox hRU;
        RadioButton hRV;

        b() {
        }
    }
}
