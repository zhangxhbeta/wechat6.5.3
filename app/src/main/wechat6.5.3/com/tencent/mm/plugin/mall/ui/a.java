package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class a extends BaseAdapter {
    private LayoutInflater CE;
    SparseArray<String> hig = null;
    int hih;
    private final int hiq = 3;
    List<ArrayList<c>> hir = new ArrayList();
    d his;
    private Context mContext;

    class a {
        public ImageView fgD = null;
        public TextView hiA = null;
        public String hiB = null;
        public String hiC = null;
        public ImageView hiD = null;
        public ImageView hiE = null;
        public ImageView hiF = null;
        final /* synthetic */ a hiv;
        public View hiw = null;
        public ImageView hix = null;
        public ImageView hiy = null;
        public TextView hiz = null;

        a(a aVar) {
            this.hiv = aVar;
        }
    }

    class b {
        LinearLayout hiG;
        TextView hiH;
        final /* synthetic */ a hiv;

        b(a aVar) {
            this.hiv = aVar;
        }
    }

    class c {
        MallFunction hiI;
        int hiJ;
        final /* synthetic */ a hiv;

        c(a aVar) {
            this.hiv = aVar;
        }
    }

    public interface d {
        void a(int i, MallFunction mallFunction);
    }

    public a(Context context, int i) {
        this.mContext = context;
        this.hih = i;
        this.CE = LayoutInflater.from(this.mContext);
    }

    public final int getCount() {
        return this.hir.size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            b bVar2 = new b(this);
            view = this.CE.inflate(2130903924, viewGroup, false);
            bVar2.hiG = (LinearLayout) view.findViewById(2131758026);
            bVar2.hiH = (TextView) view.findViewById(2131758025);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        List list = (List) this.hir.get(i);
        if (list.size() > 0) {
            CharSequence charSequence;
            boolean z;
            int i2 = ((c) list.get(0)).hiI.type;
            if (this.hig == null) {
                charSequence = null;
            } else {
                Object obj = (String) this.hig.get(i2);
            }
            if (!be.kS(charSequence)) {
                if (i == 0) {
                    z = true;
                } else if (((ArrayList) this.hir.get(i - 1)).size() > 0 && i2 != ((c) ((ArrayList) this.hir.get(i - 1)).get(0)).hiI.type) {
                    z = true;
                }
                if (z) {
                    bVar.hiH.setVisibility(8);
                } else {
                    bVar.hiH.setText(charSequence);
                    bVar.hiH.setVisibility(0);
                }
            }
            z = false;
            if (z) {
                bVar.hiH.setVisibility(8);
            } else {
                bVar.hiH.setText(charSequence);
                bVar.hiH.setVisibility(0);
            }
        } else {
            bVar.hiH.setVisibility(8);
        }
        LinearLayout linearLayout = bVar.hiG;
        linearLayout.setFocusable(true);
        int i3 = 0;
        while (i3 < 3) {
            if (i3 >= linearLayout.getChildCount() || linearLayout.getChildAt(i3) == null) {
                a aVar = new a(this);
                View inflate = this.CE.inflate(2130903925, null);
                aVar.hiw = inflate.findViewById(2131758028);
                aVar.hix = (ImageView) inflate.findViewById(2131758030);
                aVar.hiz = (TextView) inflate.findViewById(2131758031);
                aVar.hiA = (TextView) inflate.findViewById(2131758032);
                aVar.hiy = (ImageView) inflate.findViewById(2131758029);
                aVar.hiD = (ImageView) inflate.findViewById(2131757556);
                aVar.fgD = (ImageView) inflate.findViewById(2131758034);
                aVar.hiE = (ImageView) inflate.findViewById(2131757601);
                aVar.hiF = (ImageView) inflate.findViewById(2131758033);
                inflate.setTag(aVar);
                if (i3 < list.size()) {
                    a(inflate, (c) list.get(i3));
                } else {
                    inflate.setFocusable(true);
                    ((a) inflate.getTag()).hiw.setVisibility(4);
                    inflate.setOnClickListener(null);
                }
                linearLayout.addView(inflate, new LayoutParams(-2, -1, 1.0f));
            } else if (i3 < list.size()) {
                a(linearLayout.getChildAt(i3), (c) list.get(i3));
            } else {
                linearLayout.getChildAt(i3).setFocusable(true);
                linearLayout.getChildAt(i3).setOnClickListener(null);
                ((a) linearLayout.getChildAt(i3).getTag()).hiw.setVisibility(4);
            }
            i3++;
        }
        return view;
    }

    public static boolean a(MallFunction mallFunction) {
        if (mallFunction.kRg == null || be.kS(mallFunction.kRg.kRo) || !b(mallFunction) || com.tencent.mm.plugin.wallet_core.model.mall.d.bgO().Dj(mallFunction.imm) == null) {
            return false;
        }
        return true;
    }

    private void a(View view, c cVar) {
        if (view != null) {
            a aVar = (a) view.getTag();
            final MallFunction mallFunction = cVar.hiI;
            final int i = cVar.hiJ;
            aVar.hiC = mallFunction.hiC;
            aVar.hiB = mallFunction.hiB;
            com.tencent.mm.plugin.mall.b.a.c(aVar.hix, aVar.hiB, 2131165655);
            aVar.hiz.setText(mallFunction.bpZ);
            if (mallFunction.kRg == null || be.kS(mallFunction.kRg.kRo) || !b(mallFunction)) {
                if (mallFunction.kRg == null || mallFunction.kRg.kRt != 1) {
                    aVar.hiA.setText("");
                    aVar.hiA.setVisibility(4);
                } else {
                    aVar.hiA.setText(mallFunction.kRg.kRo);
                    aVar.hiA.setVisibility(0);
                }
                aVar.hiy.setImageBitmap(null);
                aVar.hiy.setVisibility(8);
            } else {
                if (com.tencent.mm.plugin.wallet_core.model.mall.d.bgO().Dj(mallFunction.imm) != null) {
                    v.w("MicroMsg.FunctionListAdapter", "show the news : " + com.tencent.mm.plugin.wallet_core.model.mall.d.bgO().Dj(mallFunction.imm).kRo);
                    aVar.hiA.setText(mallFunction.kRg.kRo);
                    aVar.hiA.setVisibility(0);
                } else {
                    aVar.hiA.setVisibility(4);
                }
                com.tencent.mm.plugin.mall.b.a.j(aVar.hiy, aVar.hiC);
                aVar.hiy.setVisibility(0);
                String str = mallFunction.imm;
            }
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a hiv;

                public final void onClick(View view) {
                    v.v("MicroMsg.FunctionListAdapter", "on Click");
                    if (this.hiv.his != null) {
                        this.hiv.his.a(i, mallFunction);
                    }
                }
            });
            aVar.hiw.setVisibility(0);
        }
    }

    private static boolean b(MallFunction mallFunction) {
        MallNews Dj = com.tencent.mm.plugin.wallet_core.model.mall.d.bgO().Dj(mallFunction.imm);
        if (Dj == null || be.kS(Dj.keV) || !Dj.keV.equals(mallFunction.kRg.keV)) {
            v.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", new Object[]{mallFunction.kRg.keV, mallFunction.bpZ});
            com.tencent.mm.plugin.wallet_core.model.mall.d bgO = com.tencent.mm.plugin.wallet_core.model.mall.d.bgO();
            Dj = mallFunction.kRg;
            if (Dj == null) {
                v.w("MicroMsg.MallNewsManagerNewVersion", "null obj");
            } else {
                Dj.kRu = "<sysmsg><mallactivitynew><functionid>" + Dj.kRn + "</functionid><activityid>" + Dj.keV + "</activityid><type>" + Dj.type + "</type><showflag>" + Dj.kRl + "</showflag><newsTipFlag>" + Dj.kRm + "</newsTipFlag></mallactivitynew></sysmsg>;";
                bgO.kRx.put(Dj.kRn, Dj);
                bgO.aGr();
            }
            return true;
        } else if (Dj == null) {
            return false;
        } else {
            if ("0".equals(Dj.kRl)) {
                v.d("MicroMsg.FunctionListAdapter", "still old news and should show");
                return true;
            }
            v.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
            return false;
        }
    }
}
