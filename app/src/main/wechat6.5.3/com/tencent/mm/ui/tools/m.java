package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.q;

public final class m extends q {
    private LayoutInflater CE;
    private boolean jLZ = true;
    public c jXn;
    public d jXo;
    private l jXp;
    private com.tencent.mm.ui.base.n.a oTB;
    private b oTC;
    private a oTG;

    private class a extends BaseAdapter {
        final /* synthetic */ m oTH;

        private class a {
            TextView dID;
            ImageView dQZ;
            View lHh;
            final /* synthetic */ a oTI;

            private a(a aVar) {
                this.oTI = aVar;
            }
        }

        private a(m mVar) {
            this.oTH = mVar;
        }

        public final int getCount() {
            return this.oTH.jLZ ? this.oTH.jXp.size() + 1 : this.oTH.jXp.size();
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            return (this.oTH.jLZ && i == 0) ? 0 : 1;
        }

        public final int getViewTypeCount() {
            return this.oTH.jLZ ? 2 : 1;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            a aVar2;
            if (this.oTH.jLZ && i == 0) {
                if (view == null) {
                    view = this.oTH.CE.inflate(2130904076, viewGroup, false);
                    aVar = new a();
                    aVar.dID = (TextView) view.findViewById(2131755226);
                    aVar.dQZ = (ImageView) view.findViewById(2131755225);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                aVar2.dID.setText(m.f(this.oTH));
            } else {
                if (this.oTH.jLZ) {
                    i--;
                }
                if (view == null) {
                    view = this.oTH.CE.inflate(2130904075, viewGroup, false);
                    aVar = new a();
                    aVar.dID = (TextView) view.findViewById(2131755226);
                    aVar.dQZ = (ImageView) view.findViewById(2131755225);
                    aVar.lHh = view.findViewById(2131755452);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                MenuItem item = this.oTH.jXp.getItem(i);
                aVar2.dID.setText(item.getTitle());
                if (item.getIcon() != null) {
                    aVar2.dQZ.setVisibility(0);
                    aVar2.dQZ.setImageDrawable(item.getIcon());
                } else if (this.oTH.oTB != null) {
                    aVar2.dQZ.setVisibility(0);
                    this.oTH.oTB.a(aVar2.dQZ, item);
                } else {
                    aVar2.dQZ.setVisibility(8);
                }
                if (this.oTH.oTC != null) {
                    this.oTH.oTC.a(aVar2.dID, item);
                }
                if (i == this.oTH.jXp.size() - 1) {
                    aVar2.lHh.setBackgroundResource(2130839259);
                } else {
                    aVar2.lHh.setBackgroundResource(2130839258);
                }
            }
            return view;
        }
    }

    static /* synthetic */ CharSequence f(m mVar) {
        return (mVar.jXp.PF == null || mVar.jXp.PF.length() == 0) ? mVar.mContext.getResources().getString(2131231011) : mVar.jXp.PF;
    }

    public m(Context context) {
        super(context);
        this.CE = q.em(context);
        this.jXp = new l();
    }

    public final boolean dQ() {
        if (this.jXn != null) {
            this.jXn.a(this.jXp);
        }
        boolean z = this.jXp.PF != null && this.jXp.PF.length() > 0;
        this.jLZ = z;
        return super.dQ();
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.jLZ || i != 0) {
            if (this.jLZ) {
                i--;
            }
            if (this.jXo != null) {
                this.jXo.c(this.jXp.getItem(i), i);
            }
            dismiss();
        }
    }

    protected final BaseAdapter YP() {
        if (this.oTG == null) {
            this.oTG = new a();
        }
        return this.oTG;
    }
}
