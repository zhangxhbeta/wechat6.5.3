package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.b.b;
import com.tencent.mm.plugin.sns.e.o;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.acc;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.e;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SnsMsgUI extends MMActivity implements b, e {
    private String cyO;
    private View eKS;
    private View eKT = null;
    private boolean eKU = false;
    private d eus = new d(this) {
        final /* synthetic */ SnsMsgUI jQt;

        {
            this.jQt = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            SnsMsgUI.a(this.jQt, this.jQt.jBM);
        }
    };
    private ListView gMx;
    private View gMz;
    private ac handler = ad.aqz();
    private int jBM;
    private al jEr;
    private SnsCmdList jFZ = new SnsCmdList();
    private aa jMH;
    private a jQm;
    private boolean jQn = false;
    private boolean jQo = false;
    private boolean jQp = false;
    private OnClickListener jQq = new OnClickListener(this) {
        final /* synthetic */ SnsMsgUI jQt;

        {
            this.jQt = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof am) {
                this.jQt.jEr.a(view, -1, null);
            } else if (view.getTag() instanceof g) {
                SnsMsgUI.a(this.jQt, (g) view.getTag());
            } else {
                v.w("MicroMsg.SnsMsgUI", "v.getTag():" + view.getTag());
            }
        }
    };
    private com.tencent.mm.sdk.h.g.a jQr = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ SnsMsgUI jQt;

        {
            this.jQt = r1;
        }

        public final void a(String str, i iVar) {
            ad.aqz().post(new Runnable(this) {
                final /* synthetic */ AnonymousClass4 jQu;

                {
                    this.jQu = r1;
                }

                public final void run() {
                    synchronized (this.jQu.jQt.jQm) {
                        v.v("MicroMsg.SnsMsgUI", "comment notify");
                        this.jQu.jQt.jQo = true;
                        this.jQu.jQt.jQm.a(null, null);
                    }
                }
            });
        }
    };
    Runnable jQs = new Runnable(this) {
        final /* synthetic */ SnsMsgUI jQt;

        {
            this.jQt = r1;
        }

        public final void run() {
            if (this.jQt.jQm != null) {
                synchronized (this.jQt.jQm) {
                    this.jQt.jQm.a(null, null);
                    this.jQt.jQn = false;
                }
            }
        }
    };

    class a extends j<g> {
        int eKW = 10;
        int emv = this.eKW;
        protected f euc;
        protected c eud;
        protected MMSlideDelView.d euf = new MMSlideDelView.d(this) {
            final /* synthetic */ a jQx;

            {
                this.jQx = r1;
            }

            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                if (z) {
                    gMD.add(mMSlideDelView);
                } else {
                    gMD.remove(mMSlideDelView);
                }
            }

            public final boolean avl() {
                return gMD.size() > 0;
            }

            public final void avm() {
                for (MMSlideDelView mMSlideDelView : gMD) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.bCu();
                    }
                }
                gMD.clear();
            }

            public final void avn() {
                for (MMSlideDelView mMSlideDelView : gMD) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.bCt();
                    }
                }
                gMD.clear();
            }
        };
        private Set<MMSlideDelView> gMD = new HashSet();
        final /* synthetic */ SnsMsgUI jQt;
        protected MMSlideDelView.e jQw;

        class a {
            View eum;
            TextView eun;
            TextView fBO;
            TextView hWx;
            ImageView jQA;
            TextView jQB;
            MMImageView jQC;
            ImageView jQD;
            final /* synthetic */ a jQx;
            ImageView jQy;
            TextView jQz;
            long jdG;

            a(a aVar) {
                this.jQx = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (g) obj;
            if (obj == null) {
                obj = new g();
                v.d("MicroMsg.SnsMsgUI", "new SnsComment");
            }
            obj.b(cursor);
            return obj;
        }

        public a(SnsMsgUI snsMsgUI, Context context, g gVar) {
            this.jQt = snsMsgUI;
            super(context, gVar);
        }

        public final long getItemId(int i) {
            return ((g) getItem(i)).field_snsID;
        }

        protected final void Om() {
            avc();
            Ol();
        }

        public final void a(f fVar) {
            this.euc = fVar;
        }

        public final void b(MMSlideDelView.e eVar) {
            this.jQw = eVar;
        }

        public final void a(c cVar) {
            this.eud = cVar;
        }

        public final synchronized void a(String str, i iVar) {
            super.a(str, iVar);
        }

        public final void Ol() {
            if (ad.aSH().Kw() <= 0 || this.jQt.jQo) {
                this.emv = ad.aSH().aUv();
                h aSH = ad.aSH();
                String str = h.aUt() + " where isSend = 0 order by createTime desc LIMIT " + this.eKW;
                v.v("MicroMsg.SnsCommentStorage", "getCursor sql:" + str);
                setCursor(aSH.cuX.rawQuery(str, null));
            } else {
                setCursor(ad.aSH().aUu());
            }
            notifyDataSetChanged();
        }

        public final boolean abO() {
            return this.eKW >= this.emv;
        }

        public final int abP() {
            if (abO()) {
                if (this.jQt.eKT.getParent() != null) {
                    this.jQt.gMx.removeFooterView(this.jQt.eKT);
                }
                return 0;
            }
            this.eKW += 10;
            if (this.eKW <= this.emv) {
                return 10;
            }
            this.eKW = this.emv;
            return this.emv % 10;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            u LX;
            CharSequence tU;
            k dd;
            String str;
            TextView textView;
            Object obj;
            Drawable a;
            acc com_tencent_mm_protocal_c_acc;
            acc com_tencent_mm_protocal_c_acc2;
            List list;
            g gVar;
            am amVar;
            g gVar2 = (g) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                MMSlideDelView mMSlideDelView = (MMSlideDelView) q.em(this.context).inflate(2130903162, null);
                View inflate = q.em(this.context).inflate(2130904478, null);
                a aVar2 = new a(this);
                aVar2.jQy = (ImageView) inflate.findViewById(2131759418);
                aVar2.hWx = (TextView) inflate.findViewById(2131759419);
                aVar2.jQB = (TextView) inflate.findViewById(2131759421);
                aVar2.jQA = (ImageView) inflate.findViewById(2131759420);
                aVar2.fBO = (TextView) inflate.findViewById(2131759422);
                aVar2.jQC = (MMImageView) inflate.findViewById(2131759423);
                aVar2.jQz = (TextView) inflate.findViewById(2131759425);
                aVar2.jQC.setOnClickListener(this.jQt.jQq);
                aVar2.eum = mMSlideDelView.findViewById(2131755551);
                aVar2.eun = (TextView) mMSlideDelView.findViewById(2131755552);
                aVar2.jQD = (ImageView) inflate.findViewById(2131759424);
                mMSlideDelView.setView(inflate);
                mMSlideDelView.euc = this.euc;
                mMSlideDelView.eud = this.eud;
                mMSlideDelView.euf = this.euf;
                mMSlideDelView.gMt = false;
                mMSlideDelView.setTag(aVar2);
                aVar = aVar2;
                view = mMSlideDelView;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.jQC.setTag(null);
            aVar.jdG = gVar2.field_snsID;
            aVar.eum.setTag(Integer.valueOf(gVar2.jBM));
            aVar.eum.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a jQx;

                {
                    this.jQx = r1;
                }

                public final void onClick(View view) {
                    v.v("MicroMsg.SnsMsgUI", "on delView clicked");
                    this.jQx.euf.avn();
                    if (this.jQx.jQw != null) {
                        this.jQx.jQw.aE(view.getTag());
                    }
                }
            });
            String str2 = "";
            avm com_tencent_mm_protocal_c_avm = (avm) new avm().az(gVar2.field_curActionBuf);
            String str3;
            int i2;
            Drawable a2;
            TextView textView2;
            long j;
            CharSequence spannableString;
            com.tencent.mm.ui.widget.e eVar;
            com.tencent.mm.plugin.sns.storage.c cV;
            k kVar;
            Object obj2;
            int i3;
            MMImageView mMImageView;
            int i4;
            MMImageView mMImageView2;
            try {
                str3 = ((avm) new avm().az(gVar2.field_refActionBuf)).mOk;
                try {
                    if (be.kS(str3) || str3.equals(ad.aSk())) {
                        str2 = "";
                        try {
                            if (be.kS(com_tencent_mm_protocal_c_avm.mOk)) {
                                com.tencent.mm.pluginsdk.ui.a.b.m(aVar.jQy, com_tencent_mm_protocal_c_avm.mOk);
                            } else {
                                v.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                            }
                            LX = this.jQt.jMH.LX(com_tencent_mm_protocal_c_avm.mOk);
                            if (LX == null) {
                                tU = LX.tU();
                            } else if (be.kS(com_tencent_mm_protocal_c_avm.mSK)) {
                                tU = com_tencent_mm_protocal_c_avm.mSK;
                            } else {
                                tU = com_tencent_mm_protocal_c_avm.mOk;
                            }
                            aVar.hWx.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, tU, aVar.hWx.getTextSize()));
                            dd = ad.aSE().dd(gVar2.field_snsID);
                            if (dd == null && dd.field_type == 21) {
                                aVar.hWx.setTextColor(this.jQt.getResources().getColor(2131690035));
                            } else {
                                aVar.hWx.setTextColor(this.jQt.getResources().getColor(2131690029));
                            }
                            str = com_tencent_mm_protocal_c_avm.mOk;
                            textView = aVar.hWx;
                            i2 = com_tencent_mm_protocal_c_avm.mcP;
                            switch (gVar2.field_type) {
                                case 1:
                                case 2:
                                    obj = null;
                                    break;
                                case 3:
                                case 5:
                                    obj = 1;
                                    break;
                                case 4:
                                    obj = null;
                                    break;
                                case 7:
                                case 8:
                                case as.CTRL_INDEX /*13*/:
                                case an.CTRL_INDEX /*14*/:
                                    obj = null;
                                    break;
                                default:
                                    obj = 1;
                                    break;
                            }
                            if (obj != null || this.jQt.cyO.equals(str)) {
                                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                            } else {
                                switch (i2) {
                                    case 18:
                                        a2 = com.tencent.mm.bd.a.a(this.context, 2130838882);
                                        break;
                                    case bf.CTRL_INDEX /*22*/:
                                    case 23:
                                    case 24:
                                    case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                                    case bv.CTRL_INDEX /*27*/:
                                    case p.CTRL_INDEX /*28*/:
                                    case JsApiChooseImage.CTRL_INDEX /*29*/:
                                        a2 = com.tencent.mm.bd.a.a(this.context, 2130838884);
                                        break;
                                    case 25:
                                        a2 = com.tencent.mm.bd.a.a(this.context, 2130838880);
                                        break;
                                    case 30:
                                        a2 = com.tencent.mm.bd.a.a(this.context, 2130838881);
                                        break;
                                    default:
                                        a2 = com.tencent.mm.bd.a.a(this.context, 2130838883);
                                        break;
                                }
                                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, a2, null);
                            }
                            textView2 = aVar.jQB;
                            j = gVar2.field_snsID;
                            if (((gVar2.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                                textView2.setTextColor(this.jQt.getResources().getColor(2131689547));
                                textView2.setBackgroundDrawable(null);
                                textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                                textView2.setText("");
                                textView2.setCompoundDrawablePadding(0);
                                switch (com_tencent_mm_protocal_c_avm.efm) {
                                    case 1:
                                    case 5:
                                        dd = ad.aSE().dd(j);
                                        if (dd != null || dd.field_type != 7) {
                                            a = com.tencent.mm.bd.a.a(this.context, 2131165584);
                                            if (dd == null && dd.field_type == 21) {
                                                a.setColorFilter(this.jQt.getResources().getColor(2131690039), Mode.SRC_ATOP);
                                            } else {
                                                a.clearColorFilter();
                                            }
                                            a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
                                            tU = new SpannableString(" ");
                                            tU.setSpan(new ImageSpan(a), 0, 1, 18);
                                            textView2.setText(tU);
                                            textView2.setContentDescription(this.jQt.nDR.nEl.getString(2131235410));
                                            break;
                                        }
                                        textView2.setText(this.jQt.getString(2131235461));
                                        break;
                                    case 2:
                                    case 3:
                                        str3 = "";
                                        if (!be.kS(str2)) {
                                            str3 = this.context.getString(2131235488, new Object[]{str2});
                                        }
                                        textView2.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, str3 + com_tencent_mm_protocal_c_avm.hQP + " ", textView2.getTextSize()));
                                        break;
                                    case 4:
                                        textView2.setText(this.jQt.getString(2131235565));
                                        break;
                                    case 7:
                                        textView2.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bd.a.a(this.context, 2131165584), null, null, null);
                                        textView2.setContentDescription(this.jQt.nDR.nEl.getString(2131235410));
                                        break;
                                    case 8:
                                        str3 = "";
                                        if (!be.kS(str2)) {
                                            str3 = this.context.getString(2131235488, new Object[]{str2});
                                        }
                                        textView2.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, str3 + com_tencent_mm_protocal_c_avm.hQP + " ", textView2.getTextSize()));
                                        break;
                                    case as.CTRL_INDEX /*13*/:
                                        com_tencent_mm_protocal_c_acc = new acc();
                                        v.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_avm.mSR);
                                        try {
                                            com_tencent_mm_protocal_c_acc.az(m.a(com_tencent_mm_protocal_c_avm.mSR));
                                            v.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_acc.bst);
                                        } catch (Exception e) {
                                            v.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e.getMessage());
                                        }
                                        this.jQt.jMH.LX(com_tencent_mm_protocal_c_avm.mOk);
                                        a2 = null;
                                        if (com_tencent_mm_protocal_c_acc.bst != 0) {
                                            this.jQt.jQp = true;
                                            spannableString = new SpannableString(this.jQt.getString(2131233591));
                                        } else {
                                            this.jQt.jQp = false;
                                            spannableString = new SpannableString(" " + this.jQt.getString(2131233590, new Object[]{com.tencent.mm.wallet_core.ui.e.m(((double) com_tencent_mm_protocal_c_acc.bst) / 100.0d)}));
                                            a2 = this.jQt.getResources().getDrawable(2130837622);
                                        }
                                        if (a2 != null) {
                                            a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
                                            eVar = new com.tencent.mm.ui.widget.e(a2);
                                            eVar.pbC = (int) (((((float) a2.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) com.tencent.mm.bd.a.fromDPToPix(this.jQt, 2))) / 2.0f);
                                            spannableString.setSpan(eVar, 0, 1, 33);
                                        }
                                        textView2.setText(spannableString);
                                        break;
                                    case an.CTRL_INDEX /*14*/:
                                        com_tencent_mm_protocal_c_acc2 = new acc();
                                        v.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_avm.mSR);
                                        try {
                                            com_tencent_mm_protocal_c_acc2.az(m.a(com_tencent_mm_protocal_c_avm.mSR));
                                            v.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_acc2.bst);
                                        } catch (Exception e2) {
                                            v.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e2.getMessage());
                                        }
                                        LX = this.jQt.jMH.LX(com_tencent_mm_protocal_c_avm.mOk);
                                        textView2.setText(this.jQt.getString(2131233589, new Object[]{LX.tU(), com.tencent.mm.wallet_core.ui.e.m(((double) com_tencent_mm_protocal_c_acc2.bst) / 100.0d)}));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            textView2.setText(2131235485);
                            textView2.setBackgroundColor(this.jQt.getResources().getColor(2131689628));
                            textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                            aVar.fBO.setText(aw.j(this.jQt, ((long) com_tencent_mm_protocal_c_avm.hNS) * 1000));
                            dd = null;
                            if (com_tencent_mm_protocal_c_avm.efm != 7 || com_tencent_mm_protocal_c_avm.efm == 8) {
                                cV = ad.aSF().cV(gVar2.field_snsID);
                                if (cV != null) {
                                    dd = cV.aUr();
                                }
                                kVar = dd;
                            } else {
                                kVar = ad.aSE().dd(gVar2.field_snsID);
                            }
                            aVar.jQC.setVisibility(8);
                            aVar.jQz.setVisibility(8);
                            aVar.jQD.setVisibility(8);
                            aVar.jQC.setImageBitmap(null);
                            ad.aSB().cc(aVar.jQC);
                            if (kVar == null) {
                                list = kVar.aUp().mWq.mom;
                                if (kVar.field_type != 2) {
                                    aVar.jQC.setTag(null);
                                    aVar.jQz.setVisibility(0);
                                    aVar.jQz.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, kVar.aUp().mWn, aVar.jQz.getTextSize()));
                                } else {
                                    obj2 = null;
                                    if (list.size() > 0) {
                                        i3 = kVar.field_type;
                                        mMImageView = aVar.jQC;
                                        i4 = -1;
                                        switch (i3) {
                                            case 1:
                                                i4 = 2130837647;
                                                break;
                                            case 2:
                                                mMImageView.setImageDrawable(null);
                                                break;
                                            case 3:
                                                i4 = 2131165247;
                                                break;
                                            case 4:
                                                i4 = 2131165232;
                                                break;
                                            case 5:
                                                i4 = 2131165244;
                                                break;
                                            case 6:
                                                i4 = 2131165231;
                                                break;
                                            case 7:
                                                i4 = 2130837647;
                                                break;
                                            case 8:
                                                mMImageView.setImageDrawable(null);
                                                break;
                                            default:
                                                i4 = 2131165247;
                                                break;
                                        }
                                        ad.aSB().b((aib) list.get(0), aVar.jQC, i4, this.jQt.hashCode(), ak.nvv);
                                        if (kVar.field_type != 15) {
                                            aVar.jQD.setVisibility(0);
                                            gVar = new g();
                                            ad.aSH().b(gVar2.nmb, gVar);
                                            aVar.jQC.setTag(gVar);
                                            obj2 = 1;
                                        } else {
                                            amVar = new am();
                                            amVar.bde = kVar.aUL();
                                            amVar.index = 0;
                                            list = new ArrayList();
                                            list.add(aVar.jQC);
                                            amVar.jOH = list;
                                            amVar.position = i;
                                            aVar.jQC.setTag(amVar);
                                            i3 = 1;
                                        }
                                    }
                                    mMImageView2 = aVar.jQC;
                                    if (obj2 == null) {
                                        i3 = 0;
                                    } else {
                                        i3 = 8;
                                    }
                                    mMImageView2.setVisibility(i3);
                                }
                            } else if (!(com_tencent_mm_protocal_c_avm.efm == 7 || com_tencent_mm_protocal_c_avm.efm == 8 || !o.cH(gVar2.field_snsID))) {
                                com.tencent.mm.model.ak.vy().a(new o(gVar2.field_snsID), 0);
                            }
                        } catch (Throwable e3) {
                            v.a("MicroMsg.SnsMsgUI", e3, "", new Object[0]);
                        }
                        return view;
                    }
                    u LX2 = this.jQt.jMH.LX(str3);
                    if (!(LX2 == null || be.kS(LX2.tU()))) {
                        str3 = LX2.tU();
                    }
                    str2 = str3;
                    if (be.kS(com_tencent_mm_protocal_c_avm.mOk)) {
                        v.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.m(aVar.jQy, com_tencent_mm_protocal_c_avm.mOk);
                    }
                    LX = this.jQt.jMH.LX(com_tencent_mm_protocal_c_avm.mOk);
                    if (LX == null) {
                        tU = LX.tU();
                    } else if (be.kS(com_tencent_mm_protocal_c_avm.mSK)) {
                        tU = com_tencent_mm_protocal_c_avm.mOk;
                    } else {
                        tU = com_tencent_mm_protocal_c_avm.mSK;
                    }
                    aVar.hWx.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, tU, aVar.hWx.getTextSize()));
                    dd = ad.aSE().dd(gVar2.field_snsID);
                    if (dd == null) {
                    }
                    aVar.hWx.setTextColor(this.jQt.getResources().getColor(2131690029));
                    str = com_tencent_mm_protocal_c_avm.mOk;
                    textView = aVar.hWx;
                    i2 = com_tencent_mm_protocal_c_avm.mcP;
                    switch (gVar2.field_type) {
                        case 1:
                        case 2:
                            obj = null;
                            break;
                        case 3:
                        case 5:
                            obj = 1;
                            break;
                        case 4:
                            obj = null;
                            break;
                        case 7:
                        case 8:
                        case as.CTRL_INDEX /*13*/:
                        case an.CTRL_INDEX /*14*/:
                            obj = null;
                            break;
                        default:
                            obj = 1;
                            break;
                    }
                    if (obj != null) {
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2 = aVar.jQB;
                    j = gVar2.field_snsID;
                    if ((gVar2.field_commentflag & 1) <= 0) {
                    }
                    if (((gVar2.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                        textView2.setTextColor(this.jQt.getResources().getColor(2131689547));
                        textView2.setBackgroundDrawable(null);
                        textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        textView2.setText("");
                        textView2.setCompoundDrawablePadding(0);
                        switch (com_tencent_mm_protocal_c_avm.efm) {
                            case 1:
                            case 5:
                                dd = ad.aSE().dd(j);
                                if (dd != null) {
                                    break;
                                }
                                a = com.tencent.mm.bd.a.a(this.context, 2131165584);
                                if (dd == null) {
                                    break;
                                }
                                a.clearColorFilter();
                                a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
                                tU = new SpannableString(" ");
                                tU.setSpan(new ImageSpan(a), 0, 1, 18);
                                textView2.setText(tU);
                                textView2.setContentDescription(this.jQt.nDR.nEl.getString(2131235410));
                                break;
                            case 2:
                            case 3:
                                str3 = "";
                                if (be.kS(str2)) {
                                    str3 = this.context.getString(2131235488, new Object[]{str2});
                                }
                                textView2.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, str3 + com_tencent_mm_protocal_c_avm.hQP + " ", textView2.getTextSize()));
                                break;
                            case 4:
                                textView2.setText(this.jQt.getString(2131235565));
                                break;
                            case 7:
                                textView2.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bd.a.a(this.context, 2131165584), null, null, null);
                                textView2.setContentDescription(this.jQt.nDR.nEl.getString(2131235410));
                                break;
                            case 8:
                                str3 = "";
                                if (be.kS(str2)) {
                                    str3 = this.context.getString(2131235488, new Object[]{str2});
                                }
                                textView2.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, str3 + com_tencent_mm_protocal_c_avm.hQP + " ", textView2.getTextSize()));
                                break;
                            case as.CTRL_INDEX /*13*/:
                                com_tencent_mm_protocal_c_acc = new acc();
                                v.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_avm.mSR);
                                com_tencent_mm_protocal_c_acc.az(m.a(com_tencent_mm_protocal_c_avm.mSR));
                                v.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_acc.bst);
                                this.jQt.jMH.LX(com_tencent_mm_protocal_c_avm.mOk);
                                a2 = null;
                                if (com_tencent_mm_protocal_c_acc.bst != 0) {
                                    this.jQt.jQp = false;
                                    spannableString = new SpannableString(" " + this.jQt.getString(2131233590, new Object[]{com.tencent.mm.wallet_core.ui.e.m(((double) com_tencent_mm_protocal_c_acc.bst) / 100.0d)}));
                                    a2 = this.jQt.getResources().getDrawable(2130837622);
                                } else {
                                    this.jQt.jQp = true;
                                    spannableString = new SpannableString(this.jQt.getString(2131233591));
                                }
                                if (a2 != null) {
                                    a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
                                    eVar = new com.tencent.mm.ui.widget.e(a2);
                                    eVar.pbC = (int) (((((float) a2.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) com.tencent.mm.bd.a.fromDPToPix(this.jQt, 2))) / 2.0f);
                                    spannableString.setSpan(eVar, 0, 1, 33);
                                }
                                textView2.setText(spannableString);
                                break;
                            case an.CTRL_INDEX /*14*/:
                                com_tencent_mm_protocal_c_acc2 = new acc();
                                v.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_avm.mSR);
                                com_tencent_mm_protocal_c_acc2.az(m.a(com_tencent_mm_protocal_c_avm.mSR));
                                v.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_acc2.bst);
                                LX = this.jQt.jMH.LX(com_tencent_mm_protocal_c_avm.mOk);
                                textView2.setText(this.jQt.getString(2131233589, new Object[]{LX.tU(), com.tencent.mm.wallet_core.ui.e.m(((double) com_tencent_mm_protocal_c_acc2.bst) / 100.0d)}));
                                break;
                            default:
                                break;
                        }
                    }
                    textView2.setText(2131235485);
                    textView2.setBackgroundColor(this.jQt.getResources().getColor(2131689628));
                    textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    aVar.fBO.setText(aw.j(this.jQt, ((long) com_tencent_mm_protocal_c_avm.hNS) * 1000));
                    dd = null;
                    if (com_tencent_mm_protocal_c_avm.efm != 7) {
                    }
                    cV = ad.aSF().cV(gVar2.field_snsID);
                    if (cV != null) {
                        dd = cV.aUr();
                    }
                    kVar = dd;
                    aVar.jQC.setVisibility(8);
                    aVar.jQz.setVisibility(8);
                    aVar.jQD.setVisibility(8);
                    aVar.jQC.setImageBitmap(null);
                    ad.aSB().cc(aVar.jQC);
                    if (kVar == null) {
                        com.tencent.mm.model.ak.vy().a(new o(gVar2.field_snsID), 0);
                    } else {
                        list = kVar.aUp().mWq.mom;
                        if (kVar.field_type != 2) {
                            obj2 = null;
                            if (list.size() > 0) {
                                i3 = kVar.field_type;
                                mMImageView = aVar.jQC;
                                i4 = -1;
                                switch (i3) {
                                    case 1:
                                        i4 = 2130837647;
                                        break;
                                    case 2:
                                        mMImageView.setImageDrawable(null);
                                        break;
                                    case 3:
                                        i4 = 2131165247;
                                        break;
                                    case 4:
                                        i4 = 2131165232;
                                        break;
                                    case 5:
                                        i4 = 2131165244;
                                        break;
                                    case 6:
                                        i4 = 2131165231;
                                        break;
                                    case 7:
                                        i4 = 2130837647;
                                        break;
                                    case 8:
                                        mMImageView.setImageDrawable(null);
                                        break;
                                    default:
                                        i4 = 2131165247;
                                        break;
                                }
                                ad.aSB().b((aib) list.get(0), aVar.jQC, i4, this.jQt.hashCode(), ak.nvv);
                                if (kVar.field_type != 15) {
                                    amVar = new am();
                                    amVar.bde = kVar.aUL();
                                    amVar.index = 0;
                                    list = new ArrayList();
                                    list.add(aVar.jQC);
                                    amVar.jOH = list;
                                    amVar.position = i;
                                    aVar.jQC.setTag(amVar);
                                    i3 = 1;
                                } else {
                                    aVar.jQD.setVisibility(0);
                                    gVar = new g();
                                    ad.aSH().b(gVar2.nmb, gVar);
                                    aVar.jQC.setTag(gVar);
                                    obj2 = 1;
                                }
                            }
                            mMImageView2 = aVar.jQC;
                            if (obj2 == null) {
                                i3 = 8;
                            } else {
                                i3 = 0;
                            }
                            mMImageView2.setVisibility(i3);
                        } else {
                            aVar.jQC.setTag(null);
                            aVar.jQz.setVisibility(0);
                            aVar.jQz.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, kVar.aUp().mWn, aVar.jQz.getTextSize()));
                        }
                    }
                    return view;
                } catch (Exception e4) {
                    str2 = str3;
                    if (be.kS(com_tencent_mm_protocal_c_avm.mOk)) {
                        v.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.m(aVar.jQy, com_tencent_mm_protocal_c_avm.mOk);
                    }
                    LX = this.jQt.jMH.LX(com_tencent_mm_protocal_c_avm.mOk);
                    if (LX == null) {
                        tU = LX.tU();
                    } else if (be.kS(com_tencent_mm_protocal_c_avm.mSK)) {
                        tU = com_tencent_mm_protocal_c_avm.mOk;
                    } else {
                        tU = com_tencent_mm_protocal_c_avm.mSK;
                    }
                    aVar.hWx.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, tU, aVar.hWx.getTextSize()));
                    dd = ad.aSE().dd(gVar2.field_snsID);
                    if (dd == null) {
                    }
                    aVar.hWx.setTextColor(this.jQt.getResources().getColor(2131690029));
                    str = com_tencent_mm_protocal_c_avm.mOk;
                    textView = aVar.hWx;
                    i2 = com_tencent_mm_protocal_c_avm.mcP;
                    switch (gVar2.field_type) {
                        case 1:
                        case 2:
                            obj = null;
                            break;
                        case 3:
                        case 5:
                            obj = 1;
                            break;
                        case 4:
                            obj = null;
                            break;
                        case 7:
                        case 8:
                        case as.CTRL_INDEX /*13*/:
                        case an.CTRL_INDEX /*14*/:
                            obj = null;
                            break;
                        default:
                            obj = 1;
                            break;
                    }
                    if (obj != null) {
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2 = aVar.jQB;
                    j = gVar2.field_snsID;
                    if ((gVar2.field_commentflag & 1) <= 0) {
                    }
                    if (((gVar2.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                        textView2.setTextColor(this.jQt.getResources().getColor(2131689547));
                        textView2.setBackgroundDrawable(null);
                        textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        textView2.setText("");
                        textView2.setCompoundDrawablePadding(0);
                        switch (com_tencent_mm_protocal_c_avm.efm) {
                            case 1:
                            case 5:
                                dd = ad.aSE().dd(j);
                                if (dd != null) {
                                    break;
                                }
                                a = com.tencent.mm.bd.a.a(this.context, 2131165584);
                                if (dd == null) {
                                    break;
                                }
                                a.clearColorFilter();
                                a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
                                tU = new SpannableString(" ");
                                tU.setSpan(new ImageSpan(a), 0, 1, 18);
                                textView2.setText(tU);
                                textView2.setContentDescription(this.jQt.nDR.nEl.getString(2131235410));
                                break;
                            case 2:
                            case 3:
                                str3 = "";
                                if (be.kS(str2)) {
                                    str3 = this.context.getString(2131235488, new Object[]{str2});
                                }
                                textView2.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, str3 + com_tencent_mm_protocal_c_avm.hQP + " ", textView2.getTextSize()));
                                break;
                            case 4:
                                textView2.setText(this.jQt.getString(2131235565));
                                break;
                            case 7:
                                textView2.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bd.a.a(this.context, 2131165584), null, null, null);
                                textView2.setContentDescription(this.jQt.nDR.nEl.getString(2131235410));
                                break;
                            case 8:
                                str3 = "";
                                if (be.kS(str2)) {
                                    str3 = this.context.getString(2131235488, new Object[]{str2});
                                }
                                textView2.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, str3 + com_tencent_mm_protocal_c_avm.hQP + " ", textView2.getTextSize()));
                                break;
                            case as.CTRL_INDEX /*13*/:
                                com_tencent_mm_protocal_c_acc = new acc();
                                v.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_avm.mSR);
                                com_tencent_mm_protocal_c_acc.az(m.a(com_tencent_mm_protocal_c_avm.mSR));
                                v.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_acc.bst);
                                this.jQt.jMH.LX(com_tencent_mm_protocal_c_avm.mOk);
                                a2 = null;
                                if (com_tencent_mm_protocal_c_acc.bst != 0) {
                                    this.jQt.jQp = false;
                                    spannableString = new SpannableString(" " + this.jQt.getString(2131233590, new Object[]{com.tencent.mm.wallet_core.ui.e.m(((double) com_tencent_mm_protocal_c_acc.bst) / 100.0d)}));
                                    a2 = this.jQt.getResources().getDrawable(2130837622);
                                } else {
                                    this.jQt.jQp = true;
                                    spannableString = new SpannableString(this.jQt.getString(2131233591));
                                }
                                if (a2 != null) {
                                    a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
                                    eVar = new com.tencent.mm.ui.widget.e(a2);
                                    eVar.pbC = (int) (((((float) a2.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) com.tencent.mm.bd.a.fromDPToPix(this.jQt, 2))) / 2.0f);
                                    spannableString.setSpan(eVar, 0, 1, 33);
                                }
                                textView2.setText(spannableString);
                                break;
                            case an.CTRL_INDEX /*14*/:
                                com_tencent_mm_protocal_c_acc2 = new acc();
                                v.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_avm.mSR);
                                com_tencent_mm_protocal_c_acc2.az(m.a(com_tencent_mm_protocal_c_avm.mSR));
                                v.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_acc2.bst);
                                LX = this.jQt.jMH.LX(com_tencent_mm_protocal_c_avm.mOk);
                                textView2.setText(this.jQt.getString(2131233589, new Object[]{LX.tU(), com.tencent.mm.wallet_core.ui.e.m(((double) com_tencent_mm_protocal_c_acc2.bst) / 100.0d)}));
                                break;
                            default:
                                break;
                        }
                    }
                    textView2.setText(2131235485);
                    textView2.setBackgroundColor(this.jQt.getResources().getColor(2131689628));
                    textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    aVar.fBO.setText(aw.j(this.jQt, ((long) com_tencent_mm_protocal_c_avm.hNS) * 1000));
                    dd = null;
                    if (com_tencent_mm_protocal_c_avm.efm != 7) {
                    }
                    cV = ad.aSF().cV(gVar2.field_snsID);
                    if (cV != null) {
                        dd = cV.aUr();
                    }
                    kVar = dd;
                    aVar.jQC.setVisibility(8);
                    aVar.jQz.setVisibility(8);
                    aVar.jQD.setVisibility(8);
                    aVar.jQC.setImageBitmap(null);
                    ad.aSB().cc(aVar.jQC);
                    if (kVar == null) {
                        com.tencent.mm.model.ak.vy().a(new o(gVar2.field_snsID), 0);
                    } else {
                        list = kVar.aUp().mWq.mom;
                        if (kVar.field_type != 2) {
                            obj2 = null;
                            if (list.size() > 0) {
                                i3 = kVar.field_type;
                                mMImageView = aVar.jQC;
                                i4 = -1;
                                switch (i3) {
                                    case 1:
                                        i4 = 2130837647;
                                        break;
                                    case 2:
                                        mMImageView.setImageDrawable(null);
                                        break;
                                    case 3:
                                        i4 = 2131165247;
                                        break;
                                    case 4:
                                        i4 = 2131165232;
                                        break;
                                    case 5:
                                        i4 = 2131165244;
                                        break;
                                    case 6:
                                        i4 = 2131165231;
                                        break;
                                    case 7:
                                        i4 = 2130837647;
                                        break;
                                    case 8:
                                        mMImageView.setImageDrawable(null);
                                        break;
                                    default:
                                        i4 = 2131165247;
                                        break;
                                }
                                ad.aSB().b((aib) list.get(0), aVar.jQC, i4, this.jQt.hashCode(), ak.nvv);
                                if (kVar.field_type != 15) {
                                    amVar = new am();
                                    amVar.bde = kVar.aUL();
                                    amVar.index = 0;
                                    list = new ArrayList();
                                    list.add(aVar.jQC);
                                    amVar.jOH = list;
                                    amVar.position = i;
                                    aVar.jQC.setTag(amVar);
                                    i3 = 1;
                                } else {
                                    aVar.jQD.setVisibility(0);
                                    gVar = new g();
                                    ad.aSH().b(gVar2.nmb, gVar);
                                    aVar.jQC.setTag(gVar);
                                    obj2 = 1;
                                }
                            }
                            mMImageView2 = aVar.jQC;
                            if (obj2 == null) {
                                i3 = 8;
                            } else {
                                i3 = 0;
                            }
                            mMImageView2.setVisibility(i3);
                        } else {
                            aVar.jQC.setTag(null);
                            aVar.jQz.setVisibility(0);
                            aVar.jQz.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, kVar.aUp().mWn, aVar.jQz.getTextSize()));
                        }
                    }
                    return view;
                }
            } catch (Exception e5) {
                str3 = str2;
                str2 = str3;
                if (be.kS(com_tencent_mm_protocal_c_avm.mOk)) {
                    com.tencent.mm.pluginsdk.ui.a.b.m(aVar.jQy, com_tencent_mm_protocal_c_avm.mOk);
                } else {
                    v.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                }
                LX = this.jQt.jMH.LX(com_tencent_mm_protocal_c_avm.mOk);
                if (LX == null) {
                    tU = LX.tU();
                } else if (be.kS(com_tencent_mm_protocal_c_avm.mSK)) {
                    tU = com_tencent_mm_protocal_c_avm.mSK;
                } else {
                    tU = com_tencent_mm_protocal_c_avm.mOk;
                }
                aVar.hWx.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, tU, aVar.hWx.getTextSize()));
                dd = ad.aSE().dd(gVar2.field_snsID);
                if (dd == null) {
                }
                aVar.hWx.setTextColor(this.jQt.getResources().getColor(2131690029));
                str = com_tencent_mm_protocal_c_avm.mOk;
                textView = aVar.hWx;
                i2 = com_tencent_mm_protocal_c_avm.mcP;
                switch (gVar2.field_type) {
                    case 1:
                    case 2:
                        obj = null;
                        break;
                    case 3:
                    case 5:
                        obj = 1;
                        break;
                    case 4:
                        obj = null;
                        break;
                    case 7:
                    case 8:
                    case as.CTRL_INDEX /*13*/:
                    case an.CTRL_INDEX /*14*/:
                        obj = null;
                        break;
                    default:
                        obj = 1;
                        break;
                }
                if (obj != null) {
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                textView2 = aVar.jQB;
                j = gVar2.field_snsID;
                if ((gVar2.field_commentflag & 1) <= 0) {
                }
                if (((gVar2.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                    textView2.setTextColor(this.jQt.getResources().getColor(2131689547));
                    textView2.setBackgroundDrawable(null);
                    textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2.setText("");
                    textView2.setCompoundDrawablePadding(0);
                    switch (com_tencent_mm_protocal_c_avm.efm) {
                        case 1:
                        case 5:
                            dd = ad.aSE().dd(j);
                            if (dd != null) {
                                break;
                            }
                            a = com.tencent.mm.bd.a.a(this.context, 2131165584);
                            if (dd == null) {
                                break;
                            }
                            a.clearColorFilter();
                            a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
                            tU = new SpannableString(" ");
                            tU.setSpan(new ImageSpan(a), 0, 1, 18);
                            textView2.setText(tU);
                            textView2.setContentDescription(this.jQt.nDR.nEl.getString(2131235410));
                            break;
                        case 2:
                        case 3:
                            str3 = "";
                            if (be.kS(str2)) {
                                str3 = this.context.getString(2131235488, new Object[]{str2});
                            }
                            textView2.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, str3 + com_tencent_mm_protocal_c_avm.hQP + " ", textView2.getTextSize()));
                            break;
                        case 4:
                            textView2.setText(this.jQt.getString(2131235565));
                            break;
                        case 7:
                            textView2.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bd.a.a(this.context, 2131165584), null, null, null);
                            textView2.setContentDescription(this.jQt.nDR.nEl.getString(2131235410));
                            break;
                        case 8:
                            str3 = "";
                            if (be.kS(str2)) {
                                str3 = this.context.getString(2131235488, new Object[]{str2});
                            }
                            textView2.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, str3 + com_tencent_mm_protocal_c_avm.hQP + " ", textView2.getTextSize()));
                            break;
                        case as.CTRL_INDEX /*13*/:
                            com_tencent_mm_protocal_c_acc = new acc();
                            v.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_avm.mSR);
                            com_tencent_mm_protocal_c_acc.az(m.a(com_tencent_mm_protocal_c_avm.mSR));
                            v.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_acc.bst);
                            this.jQt.jMH.LX(com_tencent_mm_protocal_c_avm.mOk);
                            a2 = null;
                            if (com_tencent_mm_protocal_c_acc.bst != 0) {
                                this.jQt.jQp = true;
                                spannableString = new SpannableString(this.jQt.getString(2131233591));
                            } else {
                                this.jQt.jQp = false;
                                spannableString = new SpannableString(" " + this.jQt.getString(2131233590, new Object[]{com.tencent.mm.wallet_core.ui.e.m(((double) com_tencent_mm_protocal_c_acc.bst) / 100.0d)}));
                                a2 = this.jQt.getResources().getDrawable(2130837622);
                            }
                            if (a2 != null) {
                                a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
                                eVar = new com.tencent.mm.ui.widget.e(a2);
                                eVar.pbC = (int) (((((float) a2.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) com.tencent.mm.bd.a.fromDPToPix(this.jQt, 2))) / 2.0f);
                                spannableString.setSpan(eVar, 0, 1, 33);
                            }
                            textView2.setText(spannableString);
                            break;
                        case an.CTRL_INDEX /*14*/:
                            com_tencent_mm_protocal_c_acc2 = new acc();
                            v.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_avm.mSR);
                            com_tencent_mm_protocal_c_acc2.az(m.a(com_tencent_mm_protocal_c_avm.mSR));
                            v.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_acc2.bst);
                            LX = this.jQt.jMH.LX(com_tencent_mm_protocal_c_avm.mOk);
                            textView2.setText(this.jQt.getString(2131233589, new Object[]{LX.tU(), com.tencent.mm.wallet_core.ui.e.m(((double) com_tencent_mm_protocal_c_acc2.bst) / 100.0d)}));
                            break;
                        default:
                            break;
                    }
                }
                textView2.setText(2131235485);
                textView2.setBackgroundColor(this.jQt.getResources().getColor(2131689628));
                textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                aVar.fBO.setText(aw.j(this.jQt, ((long) com_tencent_mm_protocal_c_avm.hNS) * 1000));
                dd = null;
                if (com_tencent_mm_protocal_c_avm.efm != 7) {
                }
                cV = ad.aSF().cV(gVar2.field_snsID);
                if (cV != null) {
                    dd = cV.aUr();
                }
                kVar = dd;
                aVar.jQC.setVisibility(8);
                aVar.jQz.setVisibility(8);
                aVar.jQD.setVisibility(8);
                aVar.jQC.setImageBitmap(null);
                ad.aSB().cc(aVar.jQC);
                if (kVar == null) {
                    list = kVar.aUp().mWq.mom;
                    if (kVar.field_type != 2) {
                        aVar.jQC.setTag(null);
                        aVar.jQz.setVisibility(0);
                        aVar.jQz.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.jQt, kVar.aUp().mWn, aVar.jQz.getTextSize()));
                    } else {
                        obj2 = null;
                        if (list.size() > 0) {
                            i3 = kVar.field_type;
                            mMImageView = aVar.jQC;
                            i4 = -1;
                            switch (i3) {
                                case 1:
                                    i4 = 2130837647;
                                    break;
                                case 2:
                                    mMImageView.setImageDrawable(null);
                                    break;
                                case 3:
                                    i4 = 2131165247;
                                    break;
                                case 4:
                                    i4 = 2131165232;
                                    break;
                                case 5:
                                    i4 = 2131165244;
                                    break;
                                case 6:
                                    i4 = 2131165231;
                                    break;
                                case 7:
                                    i4 = 2130837647;
                                    break;
                                case 8:
                                    mMImageView.setImageDrawable(null);
                                    break;
                                default:
                                    i4 = 2131165247;
                                    break;
                            }
                            ad.aSB().b((aib) list.get(0), aVar.jQC, i4, this.jQt.hashCode(), ak.nvv);
                            if (kVar.field_type != 15) {
                                aVar.jQD.setVisibility(0);
                                gVar = new g();
                                ad.aSH().b(gVar2.nmb, gVar);
                                aVar.jQC.setTag(gVar);
                                obj2 = 1;
                            } else {
                                amVar = new am();
                                amVar.bde = kVar.aUL();
                                amVar.index = 0;
                                list = new ArrayList();
                                list.add(aVar.jQC);
                                amVar.jOH = list;
                                amVar.position = i;
                                aVar.jQC.setTag(amVar);
                                i3 = 1;
                            }
                        }
                        mMImageView2 = aVar.jQC;
                        if (obj2 == null) {
                            i3 = 0;
                        } else {
                            i3 = 8;
                        }
                        mMImageView2.setVisibility(i3);
                    }
                } else {
                    com.tencent.mm.model.ak.vy().a(new o(gVar2.field_snsID), 0);
                }
                return view;
            }
        }
    }

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, int i) {
        ad.aSH().delete((long) i);
        snsMsgUI.jQm.a(null, null);
    }

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, g gVar) {
        long j = gVar.field_snsID;
        if ((gVar.field_commentflag & 2) > 0) {
            com.tencent.mm.ui.base.g.f(snsMsgUI, 2131235487, 2131231164);
            return;
        }
        Intent intent = new Intent();
        if (gVar.field_type == 3 || gVar.field_type == 5) {
            intent.setClass(snsMsgUI, SnsStrangerCommentDetailUI.class);
            intent.putExtra("INTENT_TALKER", gVar.field_talker);
            try {
                intent.putExtra("INTENT_SOURCE", ((avm) new avm().az(gVar.field_curActionBuf)).mcP);
            } catch (Throwable e) {
                v.a("MicroMsg.SnsMsgUI", e, "", new Object[0]);
            }
        } else {
            intent.setClass(snsMsgUI, SnsCommentDetailUI.class);
        }
        if (gVar.field_type == 7 || gVar.field_type == 8) {
            intent.putExtra("INTENT_SNSID", s.A("ad_table_", j));
            if (ad.aSE().Bp(s.A("ad_table_", j)) == null) {
                v.i("MicroMsg.SnsMsgUI", "id " + j + " has delete");
                return;
            }
        }
        intent.putExtra("INTENT_SNSID", s.A("sns_table_", j));
        if (gVar.field_type == 2) {
            intent.putExtra("INTENT_FROMSUI", true);
            intent.putExtra("INTENT_FROMSUI_COMMENTID", gVar.field_commentSvrID);
        } else if (gVar.field_type == 8) {
            intent.putExtra("INTENT_FROMSUI", true);
            intent.putExtra("INTENT_FROMSUI_COMMENTID", gVar.field_commentSvrID);
        }
        snsMsgUI.startActivityForResult(intent, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.model.ak.vy().a(210, this);
        com.tencent.mm.model.ak.vy().a(683, this);
        this.cyO = com.tencent.mm.model.k.xF();
        this.jMH = ad.aSs();
        this.jQo = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
        if (this.jQo) {
            this.eKU = true;
        }
        ad.aSH().c(this.jQr);
        NI();
    }

    public void onDestroy() {
        v.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
        ad.aSH().aaf();
        com.tencent.mm.model.ak.vy().b(210, this);
        com.tencent.mm.model.ak.vy().b(683, this);
        ad.aSH().d(this.jQr);
        this.jQm.avc();
        ad.aSB().M(this);
        super.onDestroy();
    }

    public void onResume() {
        ad.aSz().a((b) this);
        super.onResume();
    }

    public void onPause() {
        ad.aSz().b((b) this);
        super.onPause();
    }

    protected final int getLayoutId() {
        return 2130904479;
    }

    protected final void NI() {
        vD(2131235489);
        a(0, getString(2131231012), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsMsgUI jQt;

            {
                this.jQt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.g.a(this.jQt.nDR.nEl, this.jQt.getString(2131235484), "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass6 jQv;

                    {
                        this.jQv = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.jQv.jQt.gMx.setVisibility(8);
                        this.jQv.jQt.gMz.setVisibility(0);
                        ad.aSH().cuX.dF("SnsComment", "delete from SnsComment");
                        this.jQv.jQt.iT(false);
                    }
                }, null);
                return true;
            }
        });
        this.jEr = new al(this);
        this.gMz = findViewById(2131759427);
        this.gMx = (ListView) findViewById(2131759426);
        this.eKS = q.em(this).inflate(2130904477, null);
        this.eKT = q.em(this).inflate(2130903984, null);
        v.d("MicroMsg.SnsMsgUI", "autoLoad " + this.eKU);
        if (this.eKU) {
            this.gMx.addFooterView(this.eKT);
        } else {
            this.gMx.addFooterView(this.eKS);
        }
        this.jQm = new a(this, this, new g());
        this.jQm.a(new c(this) {
            final /* synthetic */ SnsMsgUI jQt;

            {
                this.jQt = r1;
            }

            public final int bN(View view) {
                return this.jQt.gMx.getPositionForView(view);
            }
        });
        this.jQm.a(new f(this) {
            final /* synthetic */ SnsMsgUI jQt;

            {
                this.jQt = r1;
            }

            public final void p(View view, int i) {
                this.jQt.gMx.performItemClick(view, i, 0);
            }
        });
        this.jQm.b(new MMSlideDelView.e(this) {
            final /* synthetic */ SnsMsgUI jQt;

            {
                this.jQt = r1;
            }

            public final void aE(Object obj) {
                if (obj == null) {
                    v.e("MicroMsg.SnsMsgUI", "onItemDel object null");
                    return;
                }
                try {
                    SnsMsgUI.a(this.jQt, Integer.parseInt(obj.toString()));
                } catch (Throwable e) {
                    v.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
                    v.a("MicroMsg.SnsMsgUI", e, "", new Object[0]);
                }
            }
        });
        this.jQm.nDK = new com.tencent.mm.ui.j.a(this) {
            final /* synthetic */ SnsMsgUI jQt;

            {
                this.jQt = r1;
            }

            public final void Oj() {
            }

            public final void Oi() {
                v.v("MicroMsg.SnsMsgUI", "total count:" + this.jQt.jQm.emv + " unread:" + ad.aSH().Kw() + "  showcount:" + this.jQt.jQm.eKW);
                if (this.jQt.jQm.getCount() == 0) {
                    this.jQt.gMx.setVisibility(8);
                    this.jQt.gMz.setVisibility(0);
                    this.jQt.iT(false);
                } else {
                    this.jQt.gMx.setVisibility(0);
                    this.jQt.gMz.setVisibility(8);
                    this.jQt.iT(true);
                }
                if ((this.jQt.jQm.abO() && ad.aSH().Kw() == 0) || ad.aSH().Kw() == ad.aSH().aUv()) {
                    this.jQt.eKS.setVisibility(8);
                }
            }
        };
        this.gMx.setAdapter(this.jQm);
        this.gMx.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SnsMsgUI jQt;

            {
                this.jQt = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == this.jQt.jQm.getCount()) {
                    int i2 = 1;
                    if (ad.aSH().Kw() > 0) {
                        ad.aSH().aaf();
                    } else {
                        i2 = this.jQt.jQm.abP();
                    }
                    this.jQt.jQm.a(null, null);
                    if (!this.jQt.eKU) {
                        if (this.jQt.eKS.getParent() != null) {
                            v.d("MicroMsg.SnsMsgUI", "remove footer");
                            this.jQt.gMx.removeFooterView(this.jQt.eKS);
                        }
                        if (this.jQt.eKT.getParent() == null && r0 > 0) {
                            this.jQt.gMx.addFooterView(this.jQt.eKT);
                            v.i("MicroMsg.SnsMsgUI", "add mLoadingFooterView");
                        }
                    }
                    this.jQt.eKU = true;
                    this.jQt.eKS.setVisibility(8);
                    return;
                }
                SnsMsgUI.a(this.jQt, (g) this.jQt.jQm.getItem(i));
            }
        });
        final l lVar = new l(this);
        this.gMx.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ SnsMsgUI jQt;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.jQt.gMx.getHeaderViewsCount()) {
                    v.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, this.jQt, this.jQt.eus);
                }
                return true;
            }
        });
        this.gMx.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ SnsMsgUI jQt;

            {
                this.jQt = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (this.jQt.eKU && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (ad.aSH().Kw() > 0) {
                        ad.aSH().aaf();
                    } else {
                        this.jQt.jQm.abP();
                    }
                    this.jQt.jQm.a(null, null);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        if (this.jQm.getCount() == 0) {
            this.gMx.setVisibility(8);
            this.gMz.setVisibility(0);
            iT(false);
        } else {
            this.gMx.setVisibility(0);
            this.gMz.setVisibility(8);
            iT(true);
        }
        if ((this.jQm.abO() && ad.aSH().Kw() == 0) || ad.aSH().Kw() == ad.aSH().aUv()) {
            this.eKS.setVisibility(8);
        }
        if (this.jQm.abO() && this.eKU) {
            this.gMx.removeFooterView(this.eKT);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsMsgUI jQt;

            {
                this.jQt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("sns_cmd_list", this.jQt.jFZ);
                this.jQt.setResult(-1, intent);
                this.jQt.finish();
                return true;
            }
        });
        if (this.jQm.abO() && this.eKU) {
            this.gMx.removeFooterView(this.eKT);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        g gVar = (g) this.jQm.getItem(adapterContextMenuInfo.position);
        if (gVar != null) {
            this.jBM = gVar.jBM;
            try {
                avm com_tencent_mm_protocal_c_avm = (avm) new avm().az(gVar.field_curActionBuf);
                if (com_tencent_mm_protocal_c_avm != null) {
                    String tU;
                    u LX = this.jMH.LX(com_tencent_mm_protocal_c_avm.mOk);
                    if (LX != null) {
                        tU = LX.tU();
                    } else if (be.kS(com_tencent_mm_protocal_c_avm.mSK)) {
                        tU = com_tencent_mm_protocal_c_avm.mOk;
                    } else {
                        tU = com_tencent_mm_protocal_c_avm.mSK;
                    }
                    contextMenu.setHeaderTitle(be.ma(tU));
                }
            } catch (Throwable e) {
                v.a("MicroMsg.SnsMsgUI", e, "", new Object[0]);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 0, getString(2131231829));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.SnsMsgUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            if (intent != null && intent.getBooleanExtra("result_finish", false)) {
                finish();
            } else if (intent != null) {
                this.jFZ.pQ(intent.getIntExtra("sns_gallery_op_id", 0));
            }
        }
    }

    public final void Aa(String str) {
        this.jQm.notifyDataSetChanged();
    }

    public final void ai(String str, boolean z) {
    }

    public final void aRc() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        v.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.jFZ);
        setResult(-1, intent);
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof o)) {
            v.d("MicroMsg.SnsMsgUI", "onSceneEnd errtype errcode");
            if (!this.jQn) {
                this.jQn = true;
                this.handler.postDelayed(this.jQs, 500);
            }
        }
    }

    public final void aj(String str, boolean z) {
    }
}
