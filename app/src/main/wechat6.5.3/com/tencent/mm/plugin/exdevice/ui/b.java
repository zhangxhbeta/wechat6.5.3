package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b extends BaseAdapter {
    private String dRA = k.xF();
    List<e> fDj;
    Map<String, String> fDk;
    String fDl;
    d fDm;
    private String fDn;
    private boolean fDo = false;
    private a fDp = new a();
    private OnClickListener fDq = new OnClickListener(this) {
        final /* synthetic */ b fDs;

        {
            this.fDs = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
            this.fDs.fDm.sC(this.fDs.kz(((Integer) view.getTag()).intValue()).fGm.field_username);
        }
    };
    private Context mContext;

    static final class a {
        public View duA;

        a() {
        }
    }

    static final class b {
        public ExdeviceLikeView fDA;
        public View fDB;
        public View fDC;
        public View fDD;
        public View fDt;
        public View fDu;
        public TextView fDv;
        public ImageView fDw;
        public NoMeasuredTextView fDx;
        public TextView fDy;
        public TextView fDz;

        b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return kz(i);
    }

    public b(Context context, String str) {
        this.mContext = context;
        this.fDn = str;
    }

    private static void b(LinkedList<c> linkedList, String str) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).field_username.equalsIgnoreCase(str)) {
                v.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", new Object[]{((c) it.next()).toString()});
                it.remove();
            }
        }
    }

    private static boolean c(LinkedList<c> linkedList, String str) {
        try {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                if (((c) it.next()).field_username.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            v.d("MicroMsg.ExdeviceRankAdapter", e.toString());
            return false;
        }
    }

    private List<e> b(ArrayList<c> arrayList, ArrayList<d> arrayList2) {
        a aVar;
        LinkedList linkedList = new LinkedList(arrayList);
        List arrayList3 = new ArrayList();
        d c = c(this.dRA, (ArrayList) arrayList2);
        if (c != null) {
            a aVar2 = this.fDp;
            aVar2.fGm = c;
            aVar2.fGn = 3;
        } else {
            aVar = this.fDp;
            aVar.fGm = null;
            aVar.fDn = this.fDn;
            aVar.username = this.dRA;
            aVar.fGn = 7;
        }
        this.fDp.aeu = 1;
        arrayList3.add(this.fDp.akF());
        aVar = this.fDp;
        aVar.aeu = 0;
        arrayList3.add(aVar.akF());
        b(linkedList, this.dRA);
        Collection arrayList4 = new ArrayList();
        v.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", new Object[]{Integer.valueOf(linkedList.size()), linkedList.toString()});
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            c = (d) it.next();
            a aVar3 = this.fDp;
            aVar3.fGm = c;
            aVar3.aeu = 1;
            aVar3.fGn = 4;
            arrayList4.add(aVar3.akF());
            if (linkedList.size() > 0 && c(linkedList, c.field_username)) {
                aVar3 = this.fDp;
                aVar3.fGm = c;
                aVar3.aeu = 1;
                aVar3.fGn = 2;
                arrayList3.add(aVar3.akF());
                b(linkedList, c.field_username);
            }
        }
        if (linkedList.size() > 0) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                a aVar4 = this.fDp;
                aVar4.username = cVar.field_username;
                aVar4.fDn = this.fDn;
                aVar4.fGm = null;
                aVar4.aeu = 1;
                aVar4.fGn = 6;
                arrayList3.add(aVar4.akF());
            }
        }
        if (arrayList3.size() > 2) {
            ((e) arrayList3.get(arrayList3.size() - 1)).fGn = (((e) arrayList3.get(arrayList3.size() - 1)).fGn | 2) | 1;
            aVar = this.fDp;
            aVar.aeu = 0;
            aVar.fGm = null;
            arrayList3.add(aVar.akF());
        }
        if (arrayList4.size() > 1) {
            ((e) arrayList4.get(arrayList4.size() - 1)).fGn = 5;
        }
        arrayList3.addAll(arrayList4);
        v.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", new Object[]{Integer.valueOf(arrayList2.size()), arrayList2.toString()});
        v.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", new Object[]{Integer.valueOf(arrayList3.size()), arrayList3.toString()});
        return arrayList3;
    }

    public final List<e> c(ArrayList<c> arrayList, ArrayList<d> arrayList2) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        if (arrayList == null) {
            try {
                arrayList3 = new ArrayList();
            } catch (Exception e) {
                v.w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
                return new ArrayList();
            }
        }
        if (arrayList2 == null) {
            arrayList4 = new ArrayList();
        }
        return b(arrayList3, arrayList4);
    }

    private static d c(String str, ArrayList<d> arrayList) {
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equalsIgnoreCase(dVar.field_username)) {
                return dVar;
            }
        }
        return null;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final boolean isEnabled(int i) {
        return false;
    }

    public final int getCount() {
        return this.fDj == null ? 0 : this.fDj.size();
    }

    public final e kz(int i) {
        return (e) this.fDj.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        return kz(i).aeu;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        final d dVar = kz(i).fGm;
        e kz = kz(i);
        int itemViewType = getItemViewType(i);
        int i2 = kz.fGn;
        if (view != null) {
            switch (itemViewType) {
                case 1:
                    bVar = (b) view.getTag();
                    break;
                default:
                    bVar = null;
                    break;
            }
        }
        LayoutInflater from = LayoutInflater.from(this.mContext);
        switch (itemViewType) {
            case 0:
                view = from.inflate(2130903575, viewGroup, false);
                a aVar = new a();
                aVar.duA = view.findViewById(2131756872);
                view.setTag(aVar);
                bVar = null;
                break;
            case 1:
                view = from.inflate(2130903574, viewGroup, false);
                bVar = new b();
                bVar.fDy = (TextView) view.findViewById(2131756871);
                break;
            default:
                bVar = null;
                break;
        }
        if (bVar != null) {
            bVar.fDt = view.findViewById(2131755326);
            bVar.fDu = view.findViewById(2131756641);
            bVar.fDv = (TextView) view.findViewById(2131756866);
            bVar.fDw = (ImageView) view.findViewById(2131756867);
            bVar.fDx = (NoMeasuredTextView) view.findViewById(2131756870);
            bVar.fDz = (TextView) view.findViewById(2131756824);
            bVar.fDA = (ExdeviceLikeView) view.findViewById(2131756869);
            bVar.fDB = view.findViewById(2131756872);
            bVar.fDD = view.findViewById(2131756868);
            bVar.fDC = view.findViewById(2131756864);
            bVar.fDx.G(this.mContext.getResources().getDimension(2131493052));
            bVar.fDx.setTextColor(this.mContext.getResources().getColor(2131689703));
            bVar.fDx.bCo();
            bVar.fDx.oaP = true;
            view.setTag(bVar);
        }
        if (!(dVar == null || bVar == null)) {
            ExdeviceLikeView exdeviceLikeView;
            CharSequence charSequence;
            if (this.dRA.equalsIgnoreCase(dVar.field_username)) {
                this.fDo = true;
            } else {
                this.fDo = false;
            }
            if (bVar.fDy != null) {
                if ((i2 & 4) != 4) {
                    bVar.fDy.setVisibility(0);
                    bVar.fDy.setText(this.mContext.getResources().getString(2131232574, new Object[]{Integer.valueOf(dVar.field_ranknum)}));
                } else {
                    bVar.fDy.setVisibility(8);
                }
            }
            if ((i2 & 2) == 2 || !dVar.field_username.equalsIgnoreCase(this.fDl) || this.dRA.equalsIgnoreCase(this.fDl)) {
                bVar.fDu.setBackgroundColor(this.mContext.getResources().getColor(2131689697));
            } else {
                bVar.fDu.setBackgroundColor(this.mContext.getResources().getColor(2131689698));
            }
            if ((i2 & 1) == 1) {
                bVar.fDB.setVisibility(8);
            } else {
                bVar.fDB.setVisibility(0);
            }
            if (dVar.field_ranknum >= 100) {
                bVar.fDv.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(2131493054));
            } else {
                bVar.fDv.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(2131493053));
            }
            if ((i2 & 2) == 2) {
                bVar.fDv.setText("");
            } else {
                bVar.fDv.setText(dVar.field_ranknum);
            }
            if (dVar.field_score >= 10000) {
                bVar.fDz.setTextColor(this.mContext.getResources().getColor(2131689702));
            } else {
                bVar.fDz.setTextColor(this.mContext.getResources().getColor(2131689701));
            }
            bVar.fDz.setText(String.valueOf(dVar.field_score));
            com.tencent.mm.pluginsdk.ui.a.b.o(bVar.fDw, dVar.field_username);
            if (!this.fDo) {
                ak.yW();
                if (!(com.tencent.mm.model.c.wH().LT(dVar.field_username) || this.fDk == null || be.kS((String) this.fDk.get(dVar.field_username)))) {
                    bVar.fDx.setText(e.a(this.mContext, (CharSequence) this.fDk.get(dVar.field_username), bVar.fDx.gl.getTextSize()));
                    exdeviceLikeView = bVar.fDA;
                    i2 = dVar.field_likecount;
                    exdeviceLikeView.fBQ = i2;
                    charSequence = exdeviceLikeView.fBQ;
                    if (exdeviceLikeView.fBQ < 0) {
                        v.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
                        charSequence = "0";
                    } else if (i2 > 999) {
                        v.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
                        charSequence = "999+";
                    }
                    if (exdeviceLikeView.fBQ > 0) {
                        exdeviceLikeView.fBT.setVisibility(8);
                    } else {
                        exdeviceLikeView.fBT.setVisibility(0);
                    }
                    exdeviceLikeView.fBT.setText(charSequence);
                    if (this.fDo) {
                        bVar.fDA.kw(dVar.field_selfLikeState);
                    } else if (dVar.field_likecount == 0) {
                        bVar.fDA.kw(1);
                    } else {
                        bVar.fDA.kw(0);
                    }
                    if (dVar.field_score <= 0 || this.fDo) {
                        bVar.fDA.setClickable(true);
                        bVar.fDA.fBR = new com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView.a(this) {
                            final /* synthetic */ b fDs;

                            public final void gT(int i) {
                                v.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", new Object[]{Integer.valueOf(i)});
                                if (this.fDs.fDm != null) {
                                    this.fDs.fDm.at(dVar.field_username, i);
                                }
                            }

                            public final boolean akl() {
                                if (this.fDs.fDm != null) {
                                    return this.fDs.fDm.sD(dVar.field_username);
                                }
                                return true;
                            }
                        };
                    } else {
                        bVar.fDA.setClickable(false);
                    }
                    bVar.fDC.setTag(Integer.valueOf(i));
                    bVar.fDC.setOnClickListener(this.fDq);
                    bVar.fDD.setTag(Integer.valueOf(i));
                    bVar.fDD.setOnClickListener(this.fDq);
                }
            }
            bVar.fDx.setText(e.a(this.mContext, l.er(dVar.field_username), bVar.fDx.gl.getTextSize()));
            exdeviceLikeView = bVar.fDA;
            i2 = dVar.field_likecount;
            exdeviceLikeView.fBQ = i2;
            charSequence = exdeviceLikeView.fBQ;
            if (exdeviceLikeView.fBQ < 0) {
                v.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
                charSequence = "0";
            } else if (i2 > 999) {
                v.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
                charSequence = "999+";
            }
            if (exdeviceLikeView.fBQ > 0) {
                exdeviceLikeView.fBT.setVisibility(0);
            } else {
                exdeviceLikeView.fBT.setVisibility(8);
            }
            exdeviceLikeView.fBT.setText(charSequence);
            if (this.fDo) {
                bVar.fDA.kw(dVar.field_selfLikeState);
            } else if (dVar.field_likecount == 0) {
                bVar.fDA.kw(0);
            } else {
                bVar.fDA.kw(1);
            }
            if (dVar.field_score <= 0) {
            }
            bVar.fDA.setClickable(true);
            bVar.fDA.fBR = /* anonymous class already generated */;
            bVar.fDC.setTag(Integer.valueOf(i));
            bVar.fDC.setOnClickListener(this.fDq);
            bVar.fDD.setTag(Integer.valueOf(i));
            bVar.fDD.setOnClickListener(this.fDq);
        }
        return view;
    }
}
