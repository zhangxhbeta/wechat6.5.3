package com.tencent.mm.plugin.favorite.ui.a;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import com.tencent.mm.e.a.id;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a;
import com.tencent.mm.plugin.favorite.ui.c.d;
import com.tencent.mm.plugin.favorite.ui.c.f;
import com.tencent.mm.plugin.favorite.ui.c.h;
import com.tencent.mm.plugin.favorite.ui.c.j;
import com.tencent.mm.plugin.favorite.ui.c.k;
import com.tencent.mm.plugin.favorite.ui.c.l;
import com.tencent.mm.plugin.favorite.ui.c.m;
import com.tencent.mm.plugin.favorite.ui.c.n;
import com.tencent.mm.plugin.favorite.ui.c.o;
import com.tencent.mm.plugin.favorite.ui.c.p;
import com.tencent.mm.plugin.favorite.ui.c.q;
import com.tencent.mm.plugin.favorite.ui.c.r;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class b extends a {
    private c dHB;
    private boolean fPk;
    public List<i> fPl;
    private List<i> fPm;
    private List<i> fPn;
    public boolean fPo;
    private Map<Long, i> fPp;
    private List<Integer> fPq;
    private List<String> fPr;
    private List<String> fPs;
    private SparseArray<a> fPt;
    private boolean fPu;
    public a.c fPv;
    public boolean fPw;
    public boolean fPx;

    public final /* synthetic */ Object getItem(int i) {
        return kJ(i);
    }

    public b(g gVar, boolean z) {
        this.fPk = false;
        this.fPl = new ArrayList();
        this.fPm = new ArrayList();
        this.fPn = new LinkedList();
        this.fPo = false;
        this.fPp = new TreeMap();
        this.fPq = new ArrayList();
        this.fPr = new LinkedList();
        this.fPs = new LinkedList();
        this.fPt = new SparseArray();
        this.fPu = false;
        this.fPw = false;
        this.fPx = false;
        this.dHB = new c<id>(this) {
            final /* synthetic */ b fPy;

            {
                this.fPy = r2;
                this.nhz = id.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                id idVar = (id) bVar;
                if (idVar instanceof id) {
                    switch (idVar.bif.action) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            this.fPy.notifyDataSetChanged();
                            break;
                    }
                }
                return false;
            }
        };
        this.type = -1;
        this.fPt.put(1, new m(gVar));
        this.fPt.put(2, new d(gVar));
        this.fPt.put(3, new q(gVar));
        this.fPt.put(4, new p(gVar));
        this.fPt.put(5, new o(gVar));
        this.fPt.put(6, new f(gVar));
        this.fPt.put(7, new h(gVar));
        this.fPt.put(8, new com.tencent.mm.plugin.favorite.ui.c.c(gVar));
        this.fPt.put(10, new com.tencent.mm.plugin.favorite.ui.c.i(gVar));
        this.fPt.put(12, new l(gVar));
        this.fPt.put(15, new l(gVar));
        this.fPt.put(11, new com.tencent.mm.plugin.favorite.ui.c.g(gVar));
        this.fPt.put(14, new j(gVar));
        this.fPt.put(16, new k(gVar));
        this.fPt.put(17, new com.tencent.mm.plugin.favorite.ui.c.b(gVar));
        this.fPt.put(18, new r(gVar));
        this.fPt.put(-2, new n(gVar));
        if (z != this.fPw) {
            this.fPw = z;
            if (z) {
                this.fPp.clear();
            }
        }
        if (!this.fPw) {
            amN();
        }
        amO();
        notifyDataSetChanged();
        com.tencent.mm.sdk.c.a.nhr.f(this.dHB);
        com.tencent.mm.sdk.c.a.nhr.e(this.dHB);
    }

    public final void finish() {
        com.tencent.mm.sdk.c.a.nhr.f(this.dHB);
    }

    public final void amN() {
        if (amP()) {
            v.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
        } else if (com.tencent.mm.plugin.favorite.b.v.alT()) {
            v.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
        } else if (this.fPw) {
            this.fPm = com.tencent.mm.plugin.favorite.b.v.a(this.fPl, this.fPi);
            this.fPk = true;
        } else {
            this.lastUpdateTime = com.tencent.mm.plugin.favorite.b.v.m(this.lastUpdateTime, this.type);
        }
    }

    private boolean amP() {
        return (this.fPr.isEmpty() && this.fPs.isEmpty() && this.fPq.isEmpty()) ? false : true;
    }

    public final void a(boolean z, i iVar) {
        if (z != this.fPo) {
            this.fPo = z;
            if (z) {
                this.fPp.clear();
                if (iVar != null) {
                    i bB = com.tencent.mm.plugin.favorite.h.alu().bB(iVar.field_localId);
                    if (bB != null) {
                        this.fPp.put(Long.valueOf(bB.field_localId), bB);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public final List<i> cZ(boolean z) {
        List<i> linkedList = new LinkedList();
        for (i iVar : this.fPp.values()) {
            if (iVar != null) {
                linkedList.add(iVar);
            }
        }
        if (z) {
            this.fPp.clear();
        }
        return linkedList;
    }

    public final int amQ() {
        return this.fPp.size();
    }

    public final long amR() {
        long j = 0;
        for (i iVar : this.fPp.values()) {
            long j2;
            if (iVar != null) {
                j2 = iVar.field_datatotalsize + j;
            } else {
                j2 = j;
            }
            j = j2;
        }
        return j;
    }

    public final void b(List<Integer> list, List<String> list2, List<String> list3) {
        this.fPq.clear();
        if (list != null) {
            this.fPq.addAll(list);
        }
        this.fPr.clear();
        if (list2 != null) {
            this.fPr.addAll(list2);
        }
        this.fPs.clear();
        if (list3 != null) {
            this.fPs.addAll(list3);
        }
        this.fPu = true;
        amO();
        this.fPu = false;
    }

    public final void amO() {
        v.v("MicroMsg.FavoriteAdapter", "reset data list beg");
        this.fPk = false;
        List list = this.fPm;
        if (list != null) {
            v.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", new Object[]{Integer.valueOf(list.size())});
            v.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", new Object[]{Integer.valueOf(this.fPn.size())});
            list.clear();
        }
        if (amP()) {
            v.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", new Object[]{this.fPr, this.fPs, this.fPq});
            this.fPm = com.tencent.mm.plugin.favorite.b.v.a(this.fPr, this.fPs, this.fPq, this.fPn, this.fPh, this.fPi);
            int size = this.fPm == null ? 0 : this.fPm.size();
            com.tencent.mm.plugin.report.service.g.iuh.h(10649, new Object[]{Integer.valueOf(size)});
        } else {
            v.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", new Object[]{Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type)});
            if (this.fPw) {
                this.fPm = com.tencent.mm.plugin.favorite.b.v.a(null, this.fPi);
            } else {
                this.fPm = com.tencent.mm.plugin.favorite.b.v.b(this.lastUpdateTime, this.type, this.fPh, this.fPi);
                if (this.lastUpdateTime == 0 && this.fPm.size() > 0) {
                    this.lastUpdateTime = ((i) this.fPm.get(this.fPm.size() - 1)).field_updateTime;
                }
            }
        }
        if (this.fPm == null) {
            v.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
            this.fPm = new ArrayList();
        }
        if (!(this.fPw || amP() || this.fPm.size() >= 20 || com.tencent.mm.plugin.favorite.h.alu().k(this.lastUpdateTime, this.type))) {
            v.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
            amN();
        }
        this.fPk = true;
        v.v("MicroMsg.FavoriteAdapter", "reset data list end");
    }

    public final boolean isEmpty() {
        return this.fPl.isEmpty();
    }

    public final void notifyDataSetChanged() {
        v.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", new Object[]{Boolean.valueOf(this.fPk)});
        if (this.fPk) {
            if (this.fPw && this.fPm != null && this.fPl != null && this.fPm.size() == this.fPl.size()) {
                this.fPx = true;
            }
            List list = this.fPl;
            this.fPl = this.fPm;
            this.fPm = list;
            this.fPk = false;
        }
        v.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
        super.notifyDataSetChanged();
    }

    public final int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        i kJ = kJ(i - 1);
        switch (kJ.field_type) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case an.CTRL_INDEX /*14*/:
            case am.CTRL_INDEX /*15*/:
            case 16:
            case 17:
            case 18:
                return kJ.field_type;
            default:
                v.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", new Object[]{Integer.valueOf(kJ.field_type)});
                return -2;
        }
    }

    public final int getViewTypeCount() {
        return this.fPt.size() + 3;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (i == 0) {
            View view2 = new View(viewGroup.getContext());
            view2.setLayoutParams(new LayoutParams(0, 0));
            view2.setBackgroundResource(2131689708);
            view2.setPadding(0, 0, 0, 0);
            view2.setEnabled(false);
            return view2;
        }
        i kJ = kJ(i - 1);
        a aVar = (a) this.fPt.get(kJ.field_type);
        if (aVar == null) {
            v.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", new Object[]{Integer.valueOf(kJ.field_type)});
            aVar = (a) this.fPt.get(-2);
            amM();
            return aVar.a(view, viewGroup, kJ);
        }
        aVar.fSl.eyB = amP();
        aVar.fSl.lastUpdateTime = this.lastUpdateTime;
        aVar.fSl.fPo = this.fPo;
        aVar.fSl.fPp = this.fPp;
        aVar.fSl.fSn = this.fPv;
        aVar.fSl.fPw = this.fPw;
        return aVar.a(view, viewGroup, kJ);
    }

    public final i kJ(int i) {
        if (i >= 0 && i < this.fPl.size()) {
            return (i) this.fPl.get(i);
        }
        v.e("MicroMsg.FavoriteAdapter", "get item, but position error");
        return new i();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getCount() {
        return this.fPl.size() + 1;
    }

    public final int bP(long j) {
        i bB = com.tencent.mm.plugin.favorite.h.alu().bB(j);
        if (bB == null) {
            return -1;
        }
        if (this.fPp.size() >= 30) {
            v.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[]{Integer.valueOf(30)});
            com.tencent.mm.ui.base.g.bf(aa.getContext(), aa.getContext().getResources().getString(2131232687, new Object[]{Integer.valueOf(30)}));
            return -1;
        }
        this.fPp.put(Long.valueOf(j), bB);
        int i;
        if (bB.field_updateTime < this.lastUpdateTime) {
            this.lastUpdateTime = bB.field_updateTime;
            amO();
            i = 0;
            for (i iVar : this.fPm) {
                if (iVar.field_localId == j) {
                    notifyDataSetChanged();
                    return i;
                }
                i++;
            }
            notifyDataSetChanged();
        } else {
            i = 0;
            for (i iVar2 : this.fPl) {
                if (iVar2.field_localId == j) {
                    notifyDataSetChanged();
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.tencent.mm.plugin.favorite.ui.c.a.b bVar = (com.tencent.mm.plugin.favorite.ui.c.a.b) view.getTag();
        if (bVar == null) {
            v.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
        } else if (bVar.fLP == null) {
            v.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
        } else if (!this.fPo && !this.fPw) {
            a aVar = (a) this.fPt.get(bVar.fLP.field_type);
            if (aVar != null) {
                aVar.bS(view);
                v.d("MicroMsg.FavoriteAdapter", "type %s", new Object[]{Integer.valueOf(bVar.fLP.field_type)});
                com.tencent.mm.plugin.report.service.g.iuh.h(12746, new Object[]{Integer.valueOf(bVar.fLP.field_type)});
            }
        } else if (bVar.dua.isChecked() || this.fPp.size() < 30) {
            bVar.dua.setChecked(!bVar.dua.isChecked());
        } else {
            v.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[]{Integer.valueOf(30)});
            com.tencent.mm.ui.base.g.bf(aa.getContext(), aa.getContext().getResources().getString(2131232687, new Object[]{Integer.valueOf(30)}));
        }
    }
}
