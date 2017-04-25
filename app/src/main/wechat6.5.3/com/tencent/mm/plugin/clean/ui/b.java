package com.tencent.mm.plugin.clean.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.tools.gridviewheaders.GridHeadersGridView.c;
import com.tencent.mm.ui.tools.gridviewheaders.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public final class b extends BaseAdapter implements e {
    private static int eVn = 0;
    private CleanChattingDetailUI eVl;
    ArrayList<com.tencent.mm.plugin.clean.b.a> eVm;
    private boolean eVo;
    c eVp = new c(this) {
        final /* synthetic */ b eVs;

        {
            this.eVs = r1;
        }

        public final void bQ(View view) {
            b.a(this.eVs, (a) view.getTag());
            this.eVs.notifyDataSetChanged();
        }
    };
    private ac eVq = new ac(this) {
        final /* synthetic */ b eVs;

        {
            this.eVs = r1;
        }

        public final void handleMessage(Message message) {
            if (!this.eVs.eVo) {
                this.eVs.notifyDataSetChanged();
            }
        }
    };
    OnScrollListener eVr = new OnScrollListener(this) {
        final /* synthetic */ b eVs;

        {
            this.eVs = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            n.GL().ba(i);
            if (i != 2) {
                this.eVs.eVo = false;
                this.eVs.eVq.removeCallbacksAndMessages(null);
                this.eVs.eVq.sendEmptyMessageDelayed(0, 200);
                return;
            }
            this.eVs.eVo = true;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    HashSet<Integer> edo;
    OnItemClickListener ezi = new OnItemClickListener(this) {
        final /* synthetic */ b eVs;

        {
            this.eVs = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            v.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d", new Object[]{Integer.valueOf(i)});
            com.tencent.mm.plugin.clean.b.a jv = this.eVs.jv(i);
            Intent intent = new Intent();
            switch (jv.type) {
                case 1:
                    intent.putExtra("key_title", this.eVs.eVl.getString(2131231930));
                    intent.putExtra("show_menu", false);
                    intent.putExtra("key_image_path", jv.filePath);
                    com.tencent.mm.ay.c.a(this.eVs.eVl, ".ui.tools.ShowImageUI", intent);
                    return;
                case 3:
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(jv.filePath)), "video/*");
                    try {
                        this.eVs.eVl.startActivity(Intent.createChooser(intent, this.eVs.eVl.getString(2131235804)));
                        return;
                    } catch (Exception e) {
                        return;
                    }
                case 4:
                    intent.putExtra("app_msg_id", jv.aYG);
                    com.tencent.mm.ay.c.a(this.eVs.eVl, ".ui.chatting.AppAttachDownloadUI", intent);
                    return;
                default:
                    return;
            }
        }
    };

    class a {
        final /* synthetic */ b eVs;
        TextView eVt;
        TextView eVu;
        CheckBox eVv;
        int position;

        a(b bVar) {
            this.eVs = bVar;
        }
    }

    class b {
        CheckBox dua;
        TextView eVA;
        final /* synthetic */ b eVs;
        MMImageView eVw;
        ImageView eVx;
        View eVy;
        View eVz;

        b(b bVar) {
            this.eVs = bVar;
        }
    }

    static /* synthetic */ void a(b bVar, int i) {
        v.i("MicroMsg.CleanChattingDetailAdapter", "select position=%d", new Object[]{Integer.valueOf(i)});
        if (!bVar.edo.remove(Integer.valueOf(i))) {
            bVar.edo.add(Integer.valueOf(i));
        }
        bVar.adW();
    }

    static /* synthetic */ void a(b bVar, a aVar) {
        int i;
        v.i("MicroMsg.CleanChattingDetailAdapter", "select header position=%d | headerId=%d", new Object[]{Integer.valueOf(aVar.position), Long.valueOf(bVar.jw(aVar.position))});
        Collection hashSet = new HashSet();
        for (i = 0; i < bVar.eVm.size(); i++) {
            if (((com.tencent.mm.plugin.clean.b.a) bVar.eVm.get(i)).adE() == r4) {
                hashSet.add(Integer.valueOf(i));
            }
        }
        Iterator it = hashSet.iterator();
        i = 1;
        while (it.hasNext()) {
            i = !bVar.edo.remove(Integer.valueOf(((Integer) it.next()).intValue())) ? 0 : i;
        }
        if (i == 0) {
            bVar.edo.addAll(hashSet);
        }
        bVar.adW();
    }

    public final /* synthetic */ Object getItem(int i) {
        return jv(i);
    }

    public b(CleanChattingDetailUI cleanChattingDetailUI, ArrayList<com.tencent.mm.plugin.clean.b.a> arrayList) {
        this.eVl = cleanChattingDetailUI;
        this.eVm = arrayList;
        this.edo = new HashSet();
    }

    public final int getCount() {
        return this.eVm.size();
    }

    public final com.tencent.mm.plugin.clean.b.a jv(int i) {
        return (com.tencent.mm.plugin.clean.b.a) this.eVm.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = this.eVl.getLayoutInflater().inflate(2130903377, viewGroup, false);
            b bVar2 = new b(this);
            bVar2.eVw = (MMImageView) view.findViewById(2131756327);
            bVar2.dua = (CheckBox) view.findViewById(2131755510);
            bVar2.eVy = view.findViewById(2131756331);
            bVar2.eVz = view.findViewById(2131756330);
            bVar2.eVx = (ImageView) view.findViewById(2131756328);
            bVar2.eVA = (TextView) view.findViewById(2131756329);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.plugin.clean.b.a jv = jv(i);
        bVar.eVw.setTag(jv.filePath);
        bVar.eVy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b eVs;

            public final void onClick(View view) {
                b.a(this.eVs, i);
                this.eVs.notifyDataSetChanged();
            }
        });
        if (this.edo.contains(Integer.valueOf(i))) {
            bVar.dua.setChecked(true);
            bVar.eVz.setVisibility(0);
        } else {
            bVar.dua.setChecked(false);
            bVar.eVz.setVisibility(8);
        }
        if (jv.type == 3) {
            bVar.eVx.setVisibility(0);
        } else {
            bVar.eVx.setVisibility(8);
        }
        if (jv.type == 4) {
            bVar.eVw.setImageResource(p.Gt(com.tencent.mm.a.e.aS(jv.filePath)));
            bVar.eVA.setText(new File(jv.filePath).getName());
            bVar.eVA.setVisibility(0);
        } else {
            if (eVn == 0) {
                eVn = view.getMeasuredWidth();
            }
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPx = 1;
            aVar.cPt = false;
            aVar.cPz = eVn;
            aVar.cPy = eVn;
            if (jv.type == 1) {
                aVar.cPu = jv.filePath;
                n.GL().a(jv.filePath, bVar.eVw, aVar.GU());
            } else {
                aVar.cPu = jv.bdZ;
                n.GL().a(jv.bdZ, bVar.eVw, aVar.GU());
            }
            bVar.eVA.setVisibility(8);
        }
        v.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return view;
    }

    public final long jw(int i) {
        return ((com.tencent.mm.plugin.clean.b.a) this.eVm.get(i)).adE();
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            v.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
            view = this.eVl.getLayoutInflater().inflate(2130903378, viewGroup, false);
            aVar = new a(this);
            aVar.eVt = (TextView) view.findViewById(2131756332);
            aVar.eVu = (TextView) view.findViewById(2131756333);
            aVar.eVv = (CheckBox) view.findViewById(2131756334);
            view.setTag(aVar);
        } else {
            v.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.clean.b.a jv = jv(i);
        aVar.position = i;
        aVar.eVt.setText(o.F(this.eVl.getString(2131232939), jv.dhI / 1000));
        long adE = jv.adE();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.eVm.size(); i2++) {
            if (((com.tencent.mm.plugin.clean.b.a) this.eVm.get(i2)).adE() == adE) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        Iterator it = hashSet.iterator();
        boolean z = true;
        while (it.hasNext()) {
            boolean z2;
            if (this.edo.contains(Integer.valueOf(((Integer) it.next()).intValue()))) {
                z2 = z;
            } else {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            aVar.eVv.setChecked(true);
        } else {
            aVar.eVv.setChecked(false);
        }
        return view;
    }

    final void adW() {
        boolean z;
        this.eVl.jx(this.edo.size());
        CleanChattingDetailUI cleanChattingDetailUI = this.eVl;
        if (this.edo.size() == this.eVm.size()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            cleanChattingDetailUI.edw.setChecked(true);
        } else {
            cleanChattingDetailUI.edw.setChecked(false);
        }
        Iterator it = this.edo.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ((com.tencent.mm.plugin.clean.b.a) this.eVm.get(((Integer) it.next()).intValue())).size + j;
        }
        CleanChattingDetailUI cleanChattingDetailUI2 = this.eVl;
        if (j > 0) {
            cleanChattingDetailUI2.eVE.setText(cleanChattingDetailUI2.getString(2131232280, new Object[]{be.aw(j)}));
            return;
        }
        cleanChattingDetailUI2.eVE.setText("");
    }

    public final void adV() {
        this.edo.clear();
        adW();
    }
}
