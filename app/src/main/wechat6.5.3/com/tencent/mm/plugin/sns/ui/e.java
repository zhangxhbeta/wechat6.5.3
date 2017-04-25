package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.al.n;
import com.tencent.mm.al.t;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.de;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e extends BaseAdapter {
    private final Activity bij;
    final List<aib> gKQ = new ArrayList();
    private String gRN = "";
    private final ac handler = new ac();
    final Map<Integer, Integer> jDl = new HashMap();
    final Map<Integer, Integer> jDm = new HashMap();
    int jDn = 0;
    int jDo = 0;
    private final b jDp;
    private final f jDq;
    final a jDr;

    public interface a {
        void a(de deVar);

        void aVm();
    }

    static abstract class b {
        OnClickListener jDt = new OnClickListener(this) {
            final /* synthetic */ b jDx;

            {
                this.jDx = r1;
            }

            public final void onClick(View view) {
                this.jDx.jDw = (a) view.getTag();
                this.jDx.qI(this.jDx.jDw.position);
            }
        };
        OnClickListener jDu = new OnClickListener(this) {
            final /* synthetic */ b jDx;

            {
                this.jDx = r1;
            }

            public final void onClick(View view) {
                this.jDx.jDw = (a) view.getTag();
                this.jDx.qI(this.jDx.jDw.position);
            }
        };
        OnClickListener jDv = new OnClickListener(this) {
            final /* synthetic */ b jDx;

            {
                this.jDx = r1;
            }

            public final void onClick(View view) {
                this.jDx.jDw = (a) view.getTag();
                this.jDx.qI(this.jDx.jDw.position);
            }
        };
        public a jDw = new a();

        public static class a {
            public String boC;
            public int position;
        }

        public abstract void qI(int i);
    }

    class c {
        TextView dID;
        ImageView jDA;
        ImageView jDB;
        LinearLayout jDC;
        View jDD;
        final /* synthetic */ e jDs;
        TextView jDy;
        ImageView jDz;

        c(e eVar) {
            this.jDs = eVar;
        }
    }

    public e(Activity activity, String str, b bVar, a aVar) {
        this.bij = activity;
        this.gRN = str;
        this.jDp = bVar;
        this.jDr = aVar;
        this.jDq = new f(new com.tencent.mm.plugin.sns.ui.f.a(this) {
            final /* synthetic */ e jDs;

            {
                this.jDs = r1;
            }

            public final void a(List<aib> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i, int i2, de deVar) {
                v.d("MicroMsg.ArtistAdapter", "onFinishFixPos");
                e eVar = this.jDs;
                if (list != null && list.size() > 0) {
                    int intValue;
                    try {
                        eVar.jDr.a((de) new de().az(deVar.toByteArray()));
                    } catch (Throwable e) {
                        v.a("MicroMsg.ArtistAdapter", e, "", new Object[0]);
                    }
                    v.d("MicroMsg.ArtistAdapter", "copy list info");
                    int size = list.size();
                    eVar.gKQ.clear();
                    eVar.jDl.clear();
                    eVar.jDm.clear();
                    for (int i3 = 0; i3 < size; i3++) {
                        aib com_tencent_mm_protocal_c_aib = (aib) list.get(i3);
                        eVar.gKQ.add(d.a(com_tencent_mm_protocal_c_aib.gID, com_tencent_mm_protocal_c_aib.efm, com_tencent_mm_protocal_c_aib.glb, com_tencent_mm_protocal_c_aib.mHP, com_tencent_mm_protocal_c_aib.mHO, com_tencent_mm_protocal_c_aib.mHQ, com_tencent_mm_protocal_c_aib.gkC));
                    }
                    for (Integer intValue2 : map.keySet()) {
                        intValue = intValue2.intValue();
                        eVar.jDl.put(Integer.valueOf(intValue), Integer.valueOf(((Integer) map.get(Integer.valueOf(intValue))).intValue()));
                    }
                    for (Integer intValue22 : map2.keySet()) {
                        intValue = intValue22.intValue();
                        eVar.jDm.put(Integer.valueOf(intValue), Integer.valueOf(((Integer) map2.get(Integer.valueOf(intValue))).intValue()));
                    }
                    list.clear();
                    map.clear();
                    map2.clear();
                    eVar.jDo = i;
                    eVar.jDn = i2;
                    v.d("MicroMsg.ArtistAdapter", "reallyCount " + i + " icount " + i2);
                    eVar.notifyDataSetChanged();
                }
            }

            public final void aVl() {
                e eVar = this.jDs;
                if (eVar.jDr != null) {
                    eVar.jDr.aVm();
                }
            }
        });
        Ol();
    }

    public final void Ol() {
        if (this.jDq != null) {
            t.HS();
            String HO = n.HO();
            v.d("MicroMsg.ArtistAdapter", "packgePath: " + HO);
            this.jDq.cN(this.gRN, HO);
        }
    }

    public final int getCount() {
        return this.jDn;
    }

    public final Object getItem(int i) {
        return this.gKQ.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            cVar = new c(this);
            view = View.inflate(this.bij, 2130904437, null);
            cVar.dID = (TextView) view.findViewById(2131759283);
            cVar.jDy = (TextView) view.findViewById(2131759284);
            cVar.jDz = (ImageView) view.findViewById(2131759285);
            cVar.jDA = (ImageView) view.findViewById(2131759286);
            cVar.jDB = (ImageView) view.findViewById(2131759287);
            cVar.jDC = (LinearLayout) view.findViewById(2131759282);
            cVar.jDD = view.findViewById(2131759281);
            cVar.jDz.setOnClickListener(this.jDp.jDt);
            cVar.jDA.setOnClickListener(this.jDp.jDu);
            cVar.jDB.setOnClickListener(this.jDp.jDv);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        int intValue = this.jDl.get(Integer.valueOf(i)) != null ? ((Integer) this.jDl.get(Integer.valueOf(i))).intValue() : -1;
        cVar.jDz.setVisibility(8);
        cVar.jDA.setVisibility(8);
        cVar.jDB.setVisibility(8);
        cVar.jDD.setVisibility(8);
        if (cVar.jDs.gRN.equals("en")) {
            cVar.dID.setVisibility(8);
            cVar.jDy.setVisibility(4);
        } else {
            cVar.dID.setVisibility(4);
            cVar.jDy.setVisibility(8);
        }
        if (intValue >= this.jDo || intValue == -1) {
            view.setLayoutParams(new LayoutParams(-1, 1));
            view.setVisibility(8);
        } else {
            String str = "";
            if (intValue - 1 >= 0) {
                Object obj = ((aib) getItem(intValue - 1)).gkC;
            } else {
                String str2 = str;
            }
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setVisibility(0);
            int intValue2 = this.jDm.get(Integer.valueOf(i)) != null ? ((Integer) this.jDm.get(Integer.valueOf(i))).intValue() : 1;
            aib com_tencent_mm_protocal_c_aib = (aib) getItem(intValue);
            if (com_tencent_mm_protocal_c_aib.gkC.equals("") || !com_tencent_mm_protocal_c_aib.gkC.equals(r4)) {
                if (this.gRN.equals("en")) {
                    cVar.jDy.setVisibility(0);
                    cVar.jDy.setText(com_tencent_mm_protocal_c_aib.gkC);
                    cVar.jDD.setVisibility(0);
                } else {
                    cVar.dID.setVisibility(0);
                    cVar.dID.setText(com_tencent_mm_protocal_c_aib.gkC);
                    cVar.jDD.setVisibility(0);
                }
            }
            if (intValue2 > 0) {
                a(intValue, cVar.jDz);
            }
            if (intValue2 >= 2) {
                a(intValue + 1, cVar.jDA);
            }
            if (intValue2 >= 3) {
                a(intValue + 2, cVar.jDB);
            }
        }
        return view;
    }

    private void a(int i, ImageView imageView) {
        aib com_tencent_mm_protocal_c_aib = (aib) getItem(i);
        imageView.setVisibility(0);
        a aVar = new a();
        aVar.boC = "";
        aVar.position = i;
        imageView.setTag(aVar);
        ad.aSB().b(com_tencent_mm_protocal_c_aib, imageView, this.bij.hashCode(), ak.nvx);
    }
}
