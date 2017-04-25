package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends BaseAdapter implements Filterable {
    private static String TAG = "MicroMsg.MobileHistoryAdapter";
    private AutoCompleteTextView imP;
    private List<String[]> imT;
    public List<com.tencent.mm.plugin.recharge.model.a> imZ = new ArrayList();
    public boolean ina = false;
    private List<com.tencent.mm.plugin.recharge.model.a> inb;
    private String ind;
    private MallFormView iou;
    private a ipf;
    public c ipg = null;
    private Context mContext;

    private class a extends Filter {
        final /* synthetic */ d iph;

        private a(d dVar) {
            this.iph = dVar;
        }

        protected final synchronized FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults;
            FilterResults filterResults2 = new FilterResults();
            List arrayList = new ArrayList();
            String yt = charSequence != null ? com.tencent.mm.plugin.recharge.model.b.yt(charSequence.toString()) : "";
            if (yt.equals(this.iph.ind)) {
                this.iph.imP.post(new Runnable(this) {
                    final /* synthetic */ a ipi;

                    {
                        this.ipi = r1;
                    }

                    public final void run() {
                        this.ipi.iph.imP.dismissDropDown();
                    }
                });
                filterResults = filterResults2;
            } else {
                final com.tencent.mm.plugin.recharge.model.a aVar;
                boolean z;
                boolean z2;
                this.iph.ind = yt;
                if (this.iph.iou.Ou()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    v.d(d.TAG, "performFiltering " + charSequence);
                    for (com.tencent.mm.plugin.recharge.model.a aVar2 : this.iph.inb) {
                        if (aVar2.imk.equals(this.iph.ind)) {
                            aVar2.iml = com.tencent.mm.plugin.recharge.model.a.imi;
                            arrayList.clear();
                            arrayList.add(aVar2);
                        }
                    }
                    if (arrayList.size() <= 0) {
                        if (this.iph.imT == null) {
                            try {
                                this.iph.imT = com.tencent.mm.pluginsdk.a.cW(this.iph.mContext);
                            } catch (Throwable e) {
                                v.a(d.TAG, e, "", new Object[0]);
                            }
                        }
                        if (this.iph.imT != null) {
                            for (String[] strArr : this.iph.imT) {
                                String yt2 = com.tencent.mm.plugin.recharge.model.b.yt(strArr[2]);
                                Object cp = cp(this.iph.ind, yt2);
                                if (com.tencent.mm.plugin.recharge.model.a.imi.equals(cp)) {
                                    com.tencent.mm.plugin.recharge.model.a aVar3 = new com.tencent.mm.plugin.recharge.model.a(yt2, strArr[1], 1);
                                    aVar3.iml = com.tencent.mm.plugin.recharge.model.a.imi;
                                    arrayList.clear();
                                    arrayList.add(aVar3);
                                    break;
                                } else if (!com.tencent.mm.plugin.recharge.model.a.imj.equals(cp) && arrayList.size() < 4) {
                                    com.tencent.mm.plugin.recharge.model.a aVar4 = new com.tencent.mm.plugin.recharge.model.a(yt2, strArr[1], 1);
                                    aVar4.iml = cp;
                                    arrayList.add(aVar4);
                                }
                            }
                        }
                    }
                    v.d(d.TAG, " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                    z = true;
                } else if (be.kS(this.iph.ind)) {
                    arrayList.addAll(this.iph.inb);
                    z = false;
                } else {
                    v.d(d.TAG, "performFiltering " + charSequence);
                    for (com.tencent.mm.plugin.recharge.model.a aVar22 : this.iph.inb) {
                        if (aVar22.imk.startsWith(this.iph.ind)) {
                            arrayList.add(aVar22);
                        }
                    }
                    z = false;
                }
                if (arrayList.size() == 0) {
                    this.iph.imP.post(new Runnable(this) {
                        final /* synthetic */ a ipi;

                        {
                            this.ipi = r1;
                        }

                        public final void run() {
                            if (this.ipi.iph.iou.isInEditMode() && this.ipi.iph.ipg != null) {
                                this.ipi.iph.ipg.c(null);
                            }
                            this.ipi.iph.imP.dismissDropDown();
                        }
                    });
                    z2 = false;
                } else {
                    if (arrayList.size() == 1 && this.iph.iou.Ou()) {
                        aVar22 = (com.tencent.mm.plugin.recharge.model.a) arrayList.get(0);
                        if (com.tencent.mm.plugin.recharge.model.a.imi.equals(aVar22.iml)) {
                            this.iph.imP.post(new Runnable(this) {
                                final /* synthetic */ a ipi;

                                public final void run() {
                                    if (this.ipi.iph.ipg != null) {
                                        this.ipi.iph.ipg.c(aVar22);
                                    }
                                    this.ipi.iph.imP.dismissDropDown();
                                }
                            });
                            z2 = false;
                        }
                    }
                    z2 = z;
                }
                List list = this.iph.imZ;
                this.iph.imZ = arrayList;
                this.iph.ina = z2;
                filterResults2.count = this.iph.imZ.size();
                filterResults2.values = this.iph.imZ;
                v.d(d.TAG, "results.count " + filterResults2.count);
                list.clear();
                filterResults = filterResults2;
            }
            return filterResults;
        }

        protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
        }

        private static int[] cp(String str, String str2) {
            if (str.equals(str2)) {
                return com.tencent.mm.plugin.recharge.model.a.imi;
            }
            if (str2 != null && str.length() == str2.length()) {
                int[] iArr = new int[]{-1, -1};
                int i = 0;
                for (int length = str.length() - 1; length > 0; length--) {
                    if (str2.charAt(length) != str.charAt(length)) {
                        i++;
                        if (i > 2) {
                            break;
                        }
                        iArr[i - 1] = length;
                    }
                }
                if (i <= 2) {
                    return iArr;
                }
            }
            return com.tencent.mm.plugin.recharge.model.a.imj;
        }
    }

    private class b {
        TextView dyN;
        TextView inh;
        final /* synthetic */ d iph;
        ImageView ipj;

        private b(d dVar) {
            this.iph = dVar;
        }
    }

    public interface c {
        void c(com.tencent.mm.plugin.recharge.model.a aVar);
    }

    public final /* synthetic */ Object getItem(int i) {
        return oH(i);
    }

    public d(MallFormView mallFormView, List<String[]> list) {
        this.mContext = mallFormView.getContext();
        this.iou = mallFormView;
        this.imP = (AutoCompleteTextView) mallFormView.ioz;
        this.imT = list;
    }

    public final void bc(List<com.tencent.mm.plugin.recharge.model.a> list) {
        this.inb = list;
        this.imZ.clear();
        this.ina = false;
        notifyDataSetChanged();
    }

    public final Filter getFilter() {
        v.d(TAG, "getFilter");
        if (this.ipf == null) {
            this.ipf = new a();
        }
        return this.ipf;
    }

    public final int getCount() {
        if (this.ina) {
            return this.imZ.size() + 2;
        }
        return this.imZ.size() > 0 ? this.imZ.size() + 1 : 0;
    }

    public final synchronized com.tencent.mm.plugin.recharge.model.a oH(int i) {
        com.tencent.mm.plugin.recharge.model.a aVar = null;
        synchronized (this) {
            if (this.ina) {
                if (i != 0) {
                    if (i <= this.imZ.size()) {
                        aVar = (com.tencent.mm.plugin.recharge.model.a) this.imZ.get(i - 1);
                    }
                }
            } else if (i < this.imZ.size()) {
                aVar = (com.tencent.mm.plugin.recharge.model.a) this.imZ.get(i);
            }
        }
        return aVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = 0;
        switch (getItemViewType(i)) {
            case 0:
                b bVar;
                if (view == null) {
                    view = View.inflate(this.mContext, 2130904247, null);
                    bVar = new b();
                    bVar.inh = (TextView) view.findViewById(2131758817);
                    bVar.dyN = (TextView) view.findViewById(2131758818);
                    bVar.ipj = (ImageView) view.findViewById(2131758816);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (!(bVar == null || bVar.ipj == null)) {
                    if (i == 0) {
                        bVar.ipj.setVisibility(0);
                    } else {
                        bVar.ipj.setVisibility(8);
                    }
                }
                com.tencent.mm.plugin.recharge.model.a oH = oH(i);
                if (oH == null || bVar == null || bVar.inh == null || bVar.dyN == null) {
                    return view;
                }
                CharSequence yu = com.tencent.mm.plugin.recharge.model.b.yu(oH.imk);
                v.d(TAG, "record.record " + yu + ", record.name " + oH.name);
                if (com.tencent.mm.plugin.recharge.model.a.imi.equals(oH.iml)) {
                    bVar.inh.setTextSize(16.0f);
                    bVar.inh.setTextColor(this.mContext.getResources().getColor(2131689792));
                    bVar.dyN.setTextColor(this.mContext.getResources().getColor(2131689792));
                    bVar.inh.setText(yu);
                } else {
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(yu);
                    int[] iArr = oH.iml;
                    int length = iArr.length;
                    while (i2 < length) {
                        int i3 = iArr[i2];
                        if (i3 >= 0) {
                            if (i3 >= 7) {
                                i3 += 2;
                            } else if (i3 >= 3) {
                                i3++;
                            }
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(2131689954)), i3, i3 + 1, 34);
                        }
                        i2++;
                    }
                    bVar.inh.setTextSize(24.0f);
                    bVar.inh.setTextColor(this.mContext.getResources().getColor(2131689909));
                    bVar.dyN.setTextColor(this.mContext.getResources().getColor(2131689909));
                    bVar.inh.setText(spannableStringBuilder);
                }
                if (oH.name == null || be.kS(oH.name.trim())) {
                    bVar.dyN.setText("");
                    return view;
                }
                bVar.dyN.setText(oH.name);
                return view;
            case 1:
                view = View.inflate(this.mContext, 2130904248, null);
                view.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ d iph;

                    {
                        this.iph = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.recharge.a.a.aJi().bc(null);
                        this.iph.iou.aJx();
                        this.iph.bc(new LinkedList());
                    }
                });
                return view;
            case 2:
                view = View.inflate(this.mContext, 2130904246, null);
                view.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ d iph;

                    {
                        this.iph = r1;
                    }

                    public final void onClick(View view) {
                        this.iph.imP.dismissDropDown();
                    }
                });
                return view;
            case 3:
                view = View.inflate(this.mContext, 2130904248, null);
                ((TextView) view.findViewById(2131758820)).setText(2131233796);
                view.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ d iph;

                    {
                        this.iph = r1;
                    }

                    public final void onClick(View view) {
                        this.iph.imP.dismissDropDown();
                    }
                });
                return view;
            default:
                return view;
        }
    }

    public final int getItemViewType(int i) {
        if (this.ina) {
            if (i == 0) {
                return 2;
            }
            if (i > this.imZ.size()) {
                return 3;
            }
            return 0;
        } else if (i >= this.imZ.size()) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }
}
