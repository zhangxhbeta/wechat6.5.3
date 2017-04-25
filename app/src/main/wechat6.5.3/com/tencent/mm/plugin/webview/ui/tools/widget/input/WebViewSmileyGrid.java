package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.mm.ui.q;

public class WebViewSmileyGrid extends GridView {
    OnItemClickListener abT = new OnItemClickListener(this) {
        final /* synthetic */ WebViewSmileyGrid lsk;

        {
            this.lsk = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == this.lsk.lsh.getCount() - 1) {
                if (this.lsk.lse.lsq != null) {
                    this.lsk.lse.lsq.Tm();
                }
            } else if ((this.lsk.fkG * (this.lsk.lsi - 1)) + i < this.lsk.fkE) {
                int c = (this.lsk.fkG * (this.lsk.lsi - 1)) + i;
                if (this.lsk.lse.lsq != null) {
                    this.lsk.lse.lsq.append(this.lsk.lse.Tg().hJ(c));
                }
            }
        }
    };
    int dWa = 0;
    int dWb = 0;
    int fkE;
    int fkG;
    c lse;
    a lsh;
    int lsi = 0;
    int lsj = 0;

    private class a extends BaseAdapter {
        final /* synthetic */ WebViewSmileyGrid lsk;

        private a(WebViewSmileyGrid webViewSmileyGrid) {
            this.lsk = webViewSmileyGrid;
        }

        public final int getCount() {
            return this.lsk.lsi;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null || view.getTag() == null) {
                view = q.em(this.lsk.getContext()).inflate(2130904709, null);
                view.setLayoutParams(new LayoutParams(-1, ((this.lsk.lse.fmc - com.tencent.mm.bd.a.N(this.lsk.getContext(), 2131493144)) - com.tencent.mm.bd.a.N(this.lsk.getContext(), 2131493441)) / this.lsk.dWb));
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (i == getCount() - 1) {
                bVar.eZn.setImageResource(2130838085);
                bVar.eZn.setContentDescription(this.lsk.getContext().getString(2131232279));
            } else {
                int d = ((this.lsk.lsi - 1) * this.lsk.fkG) + i;
                if (d > this.lsk.fkE - 1) {
                    bVar.eZn.setImageDrawable(null);
                } else {
                    bVar.eZn.setImageDrawable(this.lsk.lse.Tg().hH(d));
                }
            }
            return view;
        }
    }

    private static final class b {
        ImageView eZn;

        public b(View view) {
            this.eZn = (ImageView) view.findViewById(2131759213);
        }
    }

    public WebViewSmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
