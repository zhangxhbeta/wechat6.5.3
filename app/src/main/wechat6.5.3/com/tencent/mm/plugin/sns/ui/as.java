package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.e.a.id;
import com.tencent.mm.e.a.od;
import com.tencent.mm.e.a.oe;
import com.tencent.mm.e.a.of;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.am;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.ui.a.d;
import com.tencent.mm.plugin.sns.ui.a.f;
import com.tencent.mm.plugin.sns.ui.a.g;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public final class as implements v {
    public MMActivity aWn;
    com.tencent.mm.sdk.c.c dHB;
    private ListView dyx;
    public l eyZ;
    protected ac handler = new ac();
    protected HashMap<String, Integer> jER = new HashMap();
    public OnTouchListener jFF;
    public ao jMF;
    private int jMI = 0;
    public i jMK;
    public bd jMO;
    boolean jMd = false;
    protected ScaleAnimation jMy;
    protected ScaleAnimation jMz;
    com.tencent.mm.sdk.c.c jNa = new com.tencent.mm.sdk.c.c<od>(this) {
        final /* synthetic */ as jUs;

        {
            this.jUs = r2;
            this.nhz = od.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            od odVar = (od) bVar;
            if (odVar instanceof od) {
                String str = odVar.bpf.id;
                if (odVar.bpf.type == 1) {
                    as.c(this.jUs, str);
                } else if (odVar.bpf.type == 2) {
                    as.d(this.jUs, odVar.bpf.id);
                }
            }
            return false;
        }
    };
    com.tencent.mm.sdk.c.c jNb = new com.tencent.mm.sdk.c.c<oe>(this) {
        final /* synthetic */ as jUs;

        {
            this.jUs = r2;
            this.nhz = oe.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            oe oeVar = (oe) bVar;
            if (oeVar instanceof oe) {
                if (oeVar.bph.type == 1) {
                    as.a(this.jUs, oeVar.bph.id);
                } else if (oeVar.bph.type == 2) {
                    as.b(this.jUs, oeVar.bph.id);
                }
            }
            return false;
        }
    };
    com.tencent.mm.sdk.c.c jNc = new com.tencent.mm.sdk.c.c<of>(this) {
        final /* synthetic */ as jUs;

        {
            this.jUs = r2;
            this.nhz = of.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            of ofVar = (of) bVar;
            if (ofVar instanceof of) {
                String str = ofVar.bpi.id;
                if (ofVar.bpi.type == 1) {
                    as.e(this.jUs, str);
                } else if (ofVar.bpi.type == 2) {
                    as.f(this.jUs, str);
                }
            }
            return false;
        }
    };
    protected u jUd;
    public h jUe;
    protected LinkedList<SnsCommentPreloadTextView> jUf = new LinkedList();
    public HashMap<Integer, WeakReference<View>> jUg = new HashMap();
    View jUh;
    public int jUi = -1;
    int jUj = 0;
    protected HashMap<Integer, View> jUk = new HashMap();
    public HashMap<String, String> jUl = new HashMap();
    private HashMap<Integer, com.tencent.mm.plugin.sns.ui.a.a> jUm = new HashMap();
    private HashMap<Integer, com.tencent.mm.plugin.sns.ui.a.a.c> jUn;
    public OnClickListener jUo;
    public OnClickListener jUp;
    public HashMap<String, Boolean> jUq;
    private c jUr;
    public com.tencent.mm.plugin.sns.ui.b.b joV;
    protected int requestType = 0;

    class AnonymousClass7 implements AnimationListener {
        boolean jNE = false;
        final /* synthetic */ LinearLayout jNF;
        final /* synthetic */ as jUs;

        AnonymousClass7(as asVar, LinearLayout linearLayout) {
            this.jUs = asVar;
            this.jNF = linearLayout;
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.jNF != null) {
                this.jNF.setPressed(false);
            }
            if (!this.jNE) {
                this.jNE = true;
                if ((this.jUs.aWn instanceof s) && ((s) this.jUs.aWn).aVG()) {
                    this.jUs.jUd.notifyDataSetChanged();
                }
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }
    }

    public interface a {
        boolean aXD();
    }

    public static class b implements com.tencent.mm.model.ab.c.a {
        u jUu = null;
        int kB;

        public b(u uVar, int i) {
            this.jUu = uVar;
            this.kB = i;
        }

        public final void p(String str, boolean z) {
            if (ak.uz()) {
                ad.aqz().post(new Runnable(this) {
                    final /* synthetic */ b jUv;

                    {
                        this.jUv = r1;
                    }

                    public final void run() {
                        if (this.jUv.jUu.aVI() != null) {
                            ((at) this.jUv.jUu.aVI()).yx(this.jUv.kB);
                        }
                        this.jUv.jUu.notifyDataSetChanged();
                    }
                });
            }
        }
    }

    static class c implements OnCreateContextMenuListener {
        private String bde;
        private azr jFh;
        private k jRl;
        private aib jfX;
        private View targetView;
        private String url;

        c() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            Object tag = view.getTag();
            if (tag instanceof p) {
                p pVar = (p) tag;
                azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                view.getContext();
                String str = com_tencent_mm_protocal_c_azr.mWq.glb;
                String str2 = com_tencent_mm_protocal_c_azr.mWp.gID;
                str = as.Cg(str);
                if (str != null && str.length() != 0) {
                    this.url = str;
                    this.bde = pVar.bap;
                    this.targetView = view;
                    this.jfX = com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0 ? (aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0) : null;
                    this.jRl = ad.aSE().Bq(this.bde);
                    this.jFh = com_tencent_mm_protocal_c_azr;
                    if (com_tencent_mm_protocal_c_azr.mWq.mol != 10 && com_tencent_mm_protocal_c_azr.mWq.mol != 13) {
                        if (com.tencent.mm.ay.c.EH("favorite")) {
                            switch (com_tencent_mm_protocal_c_azr.mWq.mol) {
                                case 4:
                                    contextMenu.add(0, 4, 0, view.getContext().getString(2131234180));
                                    break;
                                case 9:
                                    contextMenu.add(0, 5, 0, view.getContext().getString(2131234180));
                                    break;
                                case an.CTRL_INDEX /*14*/:
                                    contextMenu.add(0, 9, 0, view.getContext().getString(2131234180));
                                    break;
                                default:
                                    contextMenu.add(0, 3, 0, view.getContext().getString(2131234180));
                                    break;
                            }
                        }
                        if (this.jRl != null && !this.jRl.field_userName.equals(ad.aSk())) {
                            contextMenu.add(0, 8, 0, view.getContext().getString(2131232104));
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(as asVar, String str) {
        v.d("MicroMsg.SnsTimeLineBaseAdapter", "postDescTranslateStart, id: %s", new Object[]{str});
        k Bp = ad.aSE().Bp(str);
        if (Bp != null) {
            String aUL = Bp.aUL();
            if (asVar.jER.containsKey(aUL) && ((Integer) asVar.jER.get(aUL)).equals(Integer.valueOf(1))) {
                asVar.jER.put(aUL, Integer.valueOf(2));
            }
            am.aS(str, 2);
            asVar.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void b(as asVar, String str) {
        v.d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateStart, id: %s", new Object[]{str});
        am.aS(str, 2);
        asVar.notifyDataSetChanged();
    }

    static /* synthetic */ void c(as asVar, String str) {
        v.d("MicroMsg.SnsTimeLineBaseAdapter", "postDescTranslateFinish, id: %s", new Object[]{str});
        am.aS(str, 2);
        asVar.notifyDataSetChanged();
    }

    static /* synthetic */ void d(as asVar, String str) {
        v.d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateFinish, id: %s", new Object[]{str});
        am.aS(str, 2);
        asVar.notifyDataSetChanged();
    }

    static /* synthetic */ void e(as asVar, String str) {
        v.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslatePostDesc, id: %s", new Object[]{str});
        am.aT(str, 2);
        asVar.notifyDataSetChanged();
    }

    static /* synthetic */ void f(as asVar, String str) {
        v.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslateComment, id: %s", new Object[]{str});
        am.aT(str, 2);
        asVar.notifyDataSetChanged();
    }

    public final void aXw() {
        this.jER.clear();
    }

    public final s aXx() {
        if (this.aWn instanceof s) {
            return (s) this.aWn;
        }
        return null;
    }

    public final SnsCommentPreloadTextView aXy() {
        if (this.jUf.size() == 0) {
            return new SnsCommentPreloadTextView(this.aWn);
        }
        return (SnsCommentPreloadTextView) this.jUf.removeFirst();
    }

    public final void a(SnsCommentPreloadTextView snsCommentPreloadTextView) {
        this.jUf.add(snsCommentPreloadTextView);
    }

    public final boolean aXz() {
        if (this.jUf != null) {
            this.jUf.clear();
        }
        if (this.jUn != null) {
            this.jUn.clear();
        }
        if (this.jUm != null) {
            this.jUm.clear();
        }
        e.clearCache();
        com.tencent.mm.kiss.widget.textview.c.clL.vK();
        return true;
    }

    public final void notifyDataSetChanged() {
        this.jUd.notifyDataSetChanged();
    }

    public final void aXA() {
        this.jUd.aVH();
    }

    public as(MMActivity mMActivity, ListView listView, com.tencent.mm.plugin.sns.ui.b.b bVar, h hVar, int i, final u uVar) {
        this.jUm.put(Integer.valueOf(6), new f());
        this.jUm.put(Integer.valueOf(2), new com.tencent.mm.plugin.sns.ui.a.e());
        this.jUm.put(Integer.valueOf(3), new com.tencent.mm.plugin.sns.ui.a.e());
        this.jUm.put(Integer.valueOf(4), new com.tencent.mm.plugin.sns.ui.a.e());
        this.jUm.put(Integer.valueOf(5), new com.tencent.mm.plugin.sns.ui.a.e());
        this.jUm.put(Integer.valueOf(0), new com.tencent.mm.plugin.sns.ui.a.c());
        this.jUm.put(Integer.valueOf(1), new d());
        this.jUm.put(Integer.valueOf(7), new d());
        this.jUm.put(Integer.valueOf(8), new d());
        this.jUm.put(Integer.valueOf(9), new g());
        this.jUm.put(Integer.valueOf(11), new com.tencent.mm.plugin.sns.ui.a.b());
        this.jUm.put(Integer.valueOf(10), new d());
        this.jUn = new HashMap();
        this.jUn.put(Integer.valueOf(6), new com.tencent.mm.plugin.sns.ui.a.f.a());
        this.jUn.put(Integer.valueOf(2), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.jUn.put(Integer.valueOf(3), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.jUn.put(Integer.valueOf(4), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.jUn.put(Integer.valueOf(5), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.jUn.put(Integer.valueOf(0), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.jUn.put(Integer.valueOf(1), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.jUn.put(Integer.valueOf(7), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.jUn.put(Integer.valueOf(8), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.jUn.put(Integer.valueOf(9), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.jUn.put(Integer.valueOf(10), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.jUo = new OnClickListener(this) {
            final /* synthetic */ as jUs;

            {
                this.jUs = r1;
            }

            public final void onClick(View view) {
                v.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
                com.tencent.mm.plugin.sns.abtest.a.aQK();
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
                    com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                    if (cVar.kba != null && cVar.kba.mWq.mol == 21) {
                        aic com_tencent_mm_protocal_c_aic = cVar.jBT;
                        if (!com.tencent.mm.model.k.xF().equals(cVar.kba.gln) && (com_tencent_mm_protocal_c_aic == null || com_tencent_mm_protocal_c_aic.hav == 0)) {
                            com.tencent.mm.plugin.sns.lucky.ui.b.e(this.jUs.aWn, cVar.kaA.qQ(0));
                            return;
                        }
                    }
                    if (this.jUs.aWn instanceof s) {
                        ((s) this.jUs.aWn).cj(view);
                        return;
                    }
                    return;
                }
                v.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
            }
        };
        this.jUp = new OnClickListener(this) {
            final /* synthetic */ as jUs;

            {
                this.jUs = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
                    com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                    if (cVar == null) {
                        return;
                    }
                    if (this.jUs.jER.containsKey(cVar.bap) && ((Integer) this.jUs.jER.get(cVar.bap)).equals(Integer.valueOf(1))) {
                        this.jUs.jER.put(cVar.bap, Integer.valueOf(2));
                        this.jUs.jUd.notifyDataSetChanged();
                        return;
                    }
                    this.jUs.jER.put(cVar.bap, Integer.valueOf(1));
                    if (cVar.kad.getTop() < 0) {
                        this.jUs.joV.b(cVar.kad, cVar.position, cVar.kad.getTop(), cVar.kah.aVx());
                    } else {
                        this.jUs.jUd.notifyDataSetChanged();
                    }
                }
            }
        };
        this.jFF = be.buq();
        this.jUq = new HashMap();
        this.jUr = new c();
        this.dHB = new com.tencent.mm.sdk.c.c<id>(this) {
            final /* synthetic */ as jUs;

            {
                this.jUs = r2;
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
                            this.jUs.jUd.notifyDataSetChanged();
                            break;
                    }
                }
                return false;
            }
        };
        this.jUd = uVar;
        this.jUe = hVar;
        v.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
        this.dyx = listView;
        ad.aSB();
        this.aWn = mMActivity;
        this.joV = bVar;
        this.eyZ = new l(mMActivity);
        this.jMF = new ao(mMActivity, (byte) 0);
        this.jMy = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.jMy.setDuration(150);
        this.jMz = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.jMz.setDuration(150);
        this.jMK = new i(mMActivity, 0, hVar.jEo);
        this.requestType = 10;
        this.jMO = new bd(mMActivity, new com.tencent.mm.plugin.sns.ui.bd.a(this) {
            final /* synthetic */ as jUs;

            public final void aWG() {
                uVar.notifyDataSetChanged();
            }
        }, 0, hVar.jEo);
        com.tencent.mm.sdk.c.a.nhr.e(this.dHB);
    }

    public final void aXB() {
        int firstVisiblePosition = this.dyx.getFirstVisiblePosition() - this.dyx.getHeaderViewsCount();
        int lastVisiblePosition = this.dyx.getLastVisiblePosition() - this.dyx.getHeaderViewsCount();
        v.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + firstVisiblePosition + " " + lastVisiblePosition);
        int count = this.jUd.getCount();
        int i = firstVisiblePosition;
        while (i <= lastVisiblePosition && i < count) {
            k qK = qK(i);
            View view = (View) this.jUk.get(Integer.valueOf(i));
            if (view == null || qK == null || view.getTag() == null) {
                v.e("MicroMsg.SnsTimeLineBaseAdapter", " passe " + i);
            } else {
                com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                v.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + cVar.position);
                cVar.kbd.a(cVar, i, qK);
            }
            i++;
        }
    }

    public final View g(int i, View view) {
        com.tencent.mm.plugin.sns.ui.a.a.c cVar;
        com.tencent.mm.plugin.sns.ui.a.a aVar;
        k qK = this.jUd.qK(i);
        azr aUp = qK.aUp();
        int c = c(aUp);
        if (view == null) {
            com.tencent.mm.plugin.sns.ui.a.a cVar2;
            switch (c) {
                case 0:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.c();
                    break;
                case 1:
                    cVar2 = new d();
                    break;
                case 2:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.e();
                    break;
                case 3:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.e();
                    break;
                case 4:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.e();
                    break;
                case 5:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.e();
                    break;
                case 6:
                    cVar2 = new f();
                    break;
                case 7:
                    cVar2 = new d();
                    break;
                case 8:
                    cVar2 = new d();
                    break;
                case 9:
                    cVar2 = new g();
                    break;
                case 10:
                    cVar2 = new d();
                    break;
                case 11:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.b();
                    break;
                default:
                    cVar2 = new d();
                    break;
            }
            com.tencent.mm.plugin.sns.ui.a.a.c aVar2 = new com.tencent.mm.plugin.sns.ui.a.e.a();
            aVar2.kbd = cVar2;
            aVar2.kba = aUp;
            view = cVar2.a(this.aWn, aVar2, c, this, qK);
            cVar = aVar2;
            aVar = cVar2;
        } else {
            com.tencent.mm.plugin.sns.ui.a.a.c cVar3 = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
            aVar = cVar3.kbd;
            cVar = cVar3;
        }
        aVar.gz(this.jMd);
        String aUq = qK.aUq();
        ArrayList arrayList = new ArrayList();
        if (am.aTc().size() > 0) {
            for (String str : am.aTc().keySet()) {
                if (str.startsWith(aUq)) {
                    com.tencent.mm.plugin.sns.e.am.b bVar = (com.tencent.mm.plugin.sns.e.am.b) am.aTc().get(str);
                    if (am.c(bVar)) {
                        arrayList.add(bVar);
                    }
                }
            }
        }
        aVar.jZZ = arrayList;
        aVar.a(cVar, i, qK, aUp, c, this);
        if (am.aU(qK.aUq(), 2)) {
            com.tencent.mm.plugin.sns.e.am.b AA = am.AA(qK.aUq());
            if (qK.field_snsId == 0) {
                AA = new com.tencent.mm.plugin.sns.e.am.b();
            }
            if (AA.cvW) {
                if (AA.cyo) {
                    com.tencent.mm.plugin.sns.ui.a.a.e(cVar);
                    am.aT(AA.id, 2);
                } else {
                    String str2 = AA.bfz;
                    String str3 = AA.cDd;
                    if (!(cVar == null || cVar.kai == null)) {
                        cVar.kai.a(AA, 1, str2, str3, AA.jnp);
                        cVar.kai.setVisibility(0);
                    }
                }
            } else if (!(cVar == null || cVar.kai == null)) {
                cVar.kai.ri(1);
                cVar.kai.setVisibility(0);
            }
        } else {
            com.tencent.mm.plugin.sns.ui.a.a.e(cVar);
        }
        this.jUk.put(Integer.valueOf(i), view);
        return view;
    }

    public final int getItemViewType(int i) {
        return c(this.jUd.qK(i).aUp());
    }

    public final u aXC() {
        return this.jUd;
    }

    protected static int c(azr com_tencent_mm_protocal_c_azr) {
        if (com_tencent_mm_protocal_c_azr.mWq.mol == 1) {
            int size = com_tencent_mm_protocal_c_azr.mWq.mom.size();
            if (size <= 1) {
                return 2;
            }
            if (size <= 3) {
                return 3;
            }
            if (size <= 6) {
                return 4;
            }
            return 5;
        }
        switch (com_tencent_mm_protocal_c_azr.mWq.mol) {
            case 1:
            case 8:
                return 3;
            case 2:
                return 6;
            case 4:
                return 0;
            case 5:
                return 1;
            case 7:
                return 2;
            case an.CTRL_INDEX /*14*/:
                return 7;
            case com.tencent.mm.plugin.appbrand.jsapi.am.CTRL_INDEX /*15*/:
                if (com_tencent_mm_protocal_c_azr.mWx == 1) {
                    return 1;
                }
                return 9;
            case 21:
                return 11;
            default:
                return 1;
        }
    }

    public static String Cf(String str) {
        if (be.kS(str)) {
            return str;
        }
        int indexOf = str.indexOf("://");
        if (indexOf != -1) {
            str = str.substring(indexOf + 3);
        }
        indexOf = str.indexOf("/");
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    protected static String d(azr com_tencent_mm_protocal_c_azr) {
        return com.tencent.mm.plugin.sns.b.a.drq.s(com_tencent_mm_protocal_c_azr.mWq.glb, "timeline");
    }

    public static String a(azr com_tencent_mm_protocal_c_azr, Context context) {
        return com.tencent.mm.plugin.sns.b.a.drq.e(context, com_tencent_mm_protocal_c_azr.mWp.gID, "timeline");
    }

    public static String Cg(String str) {
        v.d("MicroMsg.SnsTimeLineBaseAdapter", "url:" + str);
        return com.tencent.mm.plugin.sns.b.a.drq.s(str, "timeline");
    }

    public final void w(Runnable runnable) {
        this.jUd.aVH();
        runnable.run();
    }

    public final void ck(View view) {
        if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
            v.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
            if (this.jUh != null && this.jUh.getVisibility() == 0) {
                this.jUh.startAnimation(this.jMz);
                this.jMz.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ as jUs;

                    {
                        this.jUs = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        if (this.jUs.jUh != null) {
                            this.jUs.jUh.clearAnimation();
                            this.jUs.jUh.setVisibility(8);
                        }
                        this.jUs.jUh = null;
                    }
                });
            }
        }
    }

    public final k qK(int i) {
        return this.jUd.qK(i);
    }

    public final int getCount() {
        return this.jUd.getCount();
    }

    public final boolean qL(int i) {
        if (i < this.dyx.getFirstVisiblePosition() - 1 || i > this.dyx.getLastVisiblePosition() - 1) {
            return false;
        }
        return true;
    }
}
