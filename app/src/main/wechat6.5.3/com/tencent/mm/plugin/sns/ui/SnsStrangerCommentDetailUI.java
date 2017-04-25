package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.b.b;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.j;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import java.util.ArrayList;
import java.util.List;

public class SnsStrangerCommentDetailUI extends MMActivity implements b {
    private static int jTx = 4;
    private int bbT;
    private String bdo;
    private ImageView cHH;
    private al jEr;
    private int jMD = -1;
    private com.tencent.mm.sdk.h.g.a jQr = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ SnsStrangerCommentDetailUI jTy;

        {
            this.jTy = r1;
        }

        public final void a(String str, i iVar) {
            ad.aqz().post(new Runnable(this) {
                final /* synthetic */ AnonymousClass7 jTz;

                {
                    this.jTz = r1;
                }

                public final void run() {
                    v.v("MicroMsg.SnsStrangerCommentDetailUI", "comment notify");
                    this.jTz.jTy.jTt.a(null, null);
                    if (this.jTz.jTy.jTv) {
                        this.jTz.jTy.jTv = false;
                        ad.aqz().postDelayed(new Runnable(this.jTz.jTy) {
                            final /* synthetic */ SnsStrangerCommentDetailUI jTy;

                            {
                                this.jTy = r1;
                            }

                            public final void run() {
                                this.jTy.jTn.setSelection(this.jTy.jTt.getCount() - 1);
                            }
                        }, 10);
                    }
                }
            });
        }
    };
    private k jRl;
    private ListView jTn;
    private SnsCommentFooter jTo;
    private View jTp;
    private LinearLayout jTq;
    private List<View> jTr;
    private TextView jTs;
    private a jTt;
    private boolean jTu = false;
    private boolean jTv = false;
    private u jTw;
    private long jdG;

    class a extends j<g> {
        private Activity bij;
        private OnClickListener jNf = new OnClickListener(this) {
            final /* synthetic */ a jTA;

            {
                this.jTA = r1;
            }

            public final void onClick(View view) {
                String str = (String) view.getTag();
                v.d("MicroMsg.SnsStrangerCommentDetailUI", "onCommentClick:" + str);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str);
                com.tencent.mm.plugin.sns.b.a.drp.d(intent, this.jTA.bij);
            }
        };
        final /* synthetic */ SnsStrangerCommentDetailUI jTy;

        class a {
            ImageView dtX;
            TextView dyL;
            TextView fBO;
            TextView hWx;
            TextView iBu;
            final /* synthetic */ a jTA;
            ImageView jTB;

            a(a aVar) {
                this.jTA = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (g) obj;
            if (obj == null) {
                obj = new g();
            }
            obj.b(cursor);
            return obj;
        }

        public a(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI, Activity activity) {
            this.jTy = snsStrangerCommentDetailUI;
            super(activity, new g());
            this.bij = activity;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                a aVar2 = new a(this);
                view = View.inflate(this.bij, 2130904498, null);
                aVar2.dtX = (ImageView) view.findViewById(2131759461);
                aVar2.dyL = (TextView) view.findViewById(2131759463);
                aVar2.hWx = (TextView) view.findViewById(2131759462);
                aVar2.iBu = (TextView) view.findViewById(2131759465);
                aVar2.fBO = (TextView) view.findViewById(2131759466);
                aVar2.jTB = (ImageView) view.findViewById(2131759464);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            g gVar = (g) getItem(i);
            try {
                Object obj;
                avm com_tencent_mm_protocal_c_avm = (avm) new avm().az(gVar.field_curActionBuf);
                com.tencent.mm.pluginsdk.ui.a.b.b(aVar.dtX, com_tencent_mm_protocal_c_avm.mOk, true);
                aVar.dtX.setTag(com_tencent_mm_protocal_c_avm.mOk);
                aVar.dtX.setOnClickListener(this.jNf);
                if (com_tencent_mm_protocal_c_avm.mSK != null) {
                    obj = com_tencent_mm_protocal_c_avm.mSK;
                } else {
                    obj = ((g) this.nDI).field_talker;
                }
                aVar.hWx.setTag(com_tencent_mm_protocal_c_avm.mOk);
                CharSequence a = e.a(this.bij, obj, aVar.hWx.getTextSize());
                a.setSpan(new com.tencent.mm.pluginsdk.ui.d.j(this, com_tencent_mm_protocal_c_avm.mOk) {
                    final /* synthetic */ a jTA;

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", view.getTag().toString());
                        com.tencent.mm.plugin.sns.b.a.drp.d(intent, this.jTA.bij);
                    }
                }, 0, obj.length(), 33);
                aVar.hWx.setText(a, BufferType.SPANNABLE);
                aVar.hWx.setOnTouchListener(new y());
                if (gVar.field_type == 3) {
                    aVar.dyL.setVisibility(0);
                    aVar.jTB.setVisibility(8);
                    v.v("MicroMsg.SnsStrangerCommentDetailUI", "source:" + com_tencent_mm_protocal_c_avm.mcP + "  time:" + com_tencent_mm_protocal_c_avm.hNS + " timeFormatted:" + aw.j(this.bij, ((long) com_tencent_mm_protocal_c_avm.hNS) * 1000));
                    aVar.dyL.setText(com_tencent_mm_protocal_c_avm.hQP + " ");
                    e.e(aVar.dyL, 2);
                    aVar.dyL.setVisibility(0);
                } else {
                    aVar.dyL.setVisibility(8);
                    aVar.jTB.setVisibility(0);
                }
                if (!com.tencent.mm.model.k.xF().equals(com_tencent_mm_protocal_c_avm.mOk)) {
                    aVar.iBu.setVisibility(0);
                    TextView textView = aVar.iBu;
                    switch (com_tencent_mm_protocal_c_avm.mcP) {
                        case 18:
                            textView.setText(this.jTy.getString(2131235412));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bd.a.a(this.bij, 2130838882), null);
                            break;
                        case bf.CTRL_INDEX /*22*/:
                        case 23:
                        case 24:
                        case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                        case bv.CTRL_INDEX /*27*/:
                        case p.CTRL_INDEX /*28*/:
                        case JsApiChooseImage.CTRL_INDEX /*29*/:
                            textView.setText(this.jTy.getString(2131235414));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bd.a.a(this.bij, 2130838884), null);
                            break;
                        case 25:
                            textView.setText(this.jTy.getString(2131235411));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bd.a.a(this.bij, 2130838880), null);
                            break;
                        case 30:
                            textView.setText(this.jTy.getString(2131235413));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bd.a.a(this.bij, 2130838881), null);
                            break;
                        default:
                            textView.setText(this.jTy.getString(2131235415));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bd.a.a(this.bij, 2130838883), null);
                            break;
                    }
                }
                aVar.iBu.setVisibility(8);
                aVar.fBO.setText(aw.j(this.bij, ((long) com_tencent_mm_protocal_c_avm.hNS) * 1000));
            } catch (Throwable e) {
                v.a("MicroMsg.SnsStrangerCommentDetailUI", e, "", new Object[0]);
            }
            return view;
        }

        public final void Ol() {
            h aSH = ad.aSH();
            String l = this.jTy.bdo;
            l = h.aUt() + " where talker = " + com.tencent.mm.bg.g.dM(l) + " and  snsID = " + this.jTy.jdG + " and ( type = 3 or type = 5" + " )";
            v.v("MicroMsg.SnsCommentStorage", "comment sql:" + l);
            setCursor(aSH.cuX.rawQuery(l, null));
        }

        protected final void Om() {
            Ol();
        }
    }

    static /* synthetic */ void a(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI, k kVar, String str) {
        if (str != null && !str.trim().equals("")) {
            com.tencent.mm.plugin.sns.e.ak.a.a(snsStrangerCommentDetailUI.bdo, 3, str, kVar, snsStrangerCommentDetailUI.bbT);
        }
    }

    static /* synthetic */ void b(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        String[] strArr = new String[1];
        if (snsStrangerCommentDetailUI.jTw == null) {
            snsStrangerCommentDetailUI.jTw = new u();
            return;
        }
        if (!com.tencent.mm.i.a.ei(snsStrangerCommentDetailUI.jTw.field_type)) {
            m.e(snsStrangerCommentDetailUI.jTw);
        }
        if (snsStrangerCommentDetailUI.jTw.tK()) {
            strArr[0] = snsStrangerCommentDetailUI.getString(2131232100);
        } else {
            strArr[0] = snsStrangerCommentDetailUI.getString(2131232096);
        }
        com.tencent.mm.ui.base.g.a(snsStrangerCommentDetailUI, "", strArr, "", false, new c(snsStrangerCommentDetailUI) {
            final /* synthetic */ SnsStrangerCommentDetailUI jTy;

            {
                this.jTy = r1;
            }

            public final void gT(int i) {
                switch (i) {
                    case 0:
                        if (this.jTy.jTw.tK()) {
                            m.g(this.jTy.jTw);
                            this.jTy.jTw.ts();
                            com.tencent.mm.plugin.sns.b.a.drq.ow();
                            return;
                        }
                        m.f(this.jTy.jTw);
                        this.jTy.jTw.tr();
                        com.tencent.mm.plugin.sns.b.a.drq.ow();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131235385);
        this.jdG = getIntent().getLongExtra("INTENT_SNSID", 0);
        this.bdo = getIntent().getStringExtra("INTENT_TALKER");
        this.jRl = ad.aSE().dd(this.jdG);
        this.bbT = getIntent().getIntExtra("INTENT_SOURCE", -1);
        ak.yW();
        this.jTw = com.tencent.mm.model.c.wH().LX(this.bdo);
        if (this.jRl == null || this.bdo == null) {
            finish();
            return;
        }
        this.jEr = new al(this);
        ad.aSH().c(this.jQr);
        NI();
    }

    public void onResume() {
        ad.aSz().a((b) this);
        super.onResume();
    }

    public void onPause() {
        ad.aSz().b((b) this);
        super.onPause();
    }

    protected void onDestroy() {
        ad.aSH().d(this.jQr);
        ad.aSB().M(this);
        if (this.jTt != null) {
            this.jTt.avc();
        }
        super.onDestroy();
    }

    protected final void NI() {
        this.jTn = (ListView) findViewById(2131759322);
        this.jTo = (SnsCommentFooter) findViewById(2131759323);
        this.jTp = View.inflate(this, 2130904497, null);
        this.jTq = (LinearLayout) this.jTp.findViewById(2131759460);
        this.cHH = (ImageView) this.jTp.findViewById(2131759292);
        this.jTs = (TextView) this.jTp.findViewById(2131759459);
        com.tencent.mm.pluginsdk.ui.a.b.b(this.cHH, this.jRl.field_userName, true);
        this.jTs.setText(e.a(this, l.er(this.jRl.field_userName), this.jTs.getTextSize()));
        aXr();
        for (int i = 0; i < this.jTr.size(); i++) {
            am amVar = new am();
            amVar.bde = this.jRl.aUL();
            amVar.index = i;
            amVar.jOH = this.jTr;
            ((View) this.jTr.get(i)).setTag(amVar);
            ((View) this.jTr.get(i)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsStrangerCommentDetailUI jTy;

                {
                    this.jTy = r1;
                }

                public final void onClick(View view) {
                    if (view.getTag() instanceof am) {
                        this.jTy.jEr.a(view, 2, null);
                    }
                }
            });
        }
        this.jTn.addHeaderView(this.jTp);
        this.jTt = new a(this, this);
        this.jTn.post(new Runnable(this) {
            final /* synthetic */ SnsStrangerCommentDetailUI jTy;

            {
                this.jTy = r1;
            }

            public final void run() {
                this.jTy.jMD = this.jTy.jTn.getBottom();
                v.d("MicroMsg.SnsStrangerCommentDetailUI", "listOriginalBottom: " + this.jTy.jMD);
            }
        });
        this.jTn.setAdapter(this.jTt);
        this.jTn.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ SnsStrangerCommentDetailUI jTy;

            {
                this.jTy = r1;
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }
        });
        SnsCommentFooter snsCommentFooter = this.jTo;
        AnonymousClass2 anonymousClass2 = new Runnable(this) {
            int jNR = -1;
            int jNS = 10;
            final /* synthetic */ SnsStrangerCommentDetailUI jTy;

            {
                this.jTy = r2;
            }

            public final void run() {
                if (!this.jTy.jTu) {
                    this.jNS = 10;
                }
                this.jTy.jTu = true;
                v.e("MicroMsg.SnsStrangerCommentDetailUI", "list.bottom:" + this.jTy.jTn.getBottom() + " footer.top" + this.jTy.jTn.getTop());
                int top = this.jTy.jTo.getTop();
                int i = this.jNS;
                this.jNS = i - 1;
                if (i > 0 && (this.jNR != top || this.jTy.jTn.getBottom() == this.jTy.jMD)) {
                    new ac().postDelayed(this, 30);
                }
                this.jNR = top;
                BackwardSupportUtil.c.b(this.jTy.jTn, this.jTy.jTn.getCount() - 1);
            }
        };
        snsCommentFooter.aWK();
        this.jTo.aWL();
        this.jTo.aWO();
        this.jTo.a(new c(this) {
            final /* synthetic */ SnsStrangerCommentDetailUI jTy;

            {
                this.jTy = r1;
            }

            public final void BP(String str) {
                v.v("MicroMsg.SnsStrangerCommentDetailUI", "comment send requested");
                this.jTy.jTv = true;
                SnsStrangerCommentDetailUI.a(this.jTy, this.jTy.jRl, str);
            }
        });
        this.jTo.BZ(getString(2131235510) + this.bdo + getString(2131235372));
        AnonymousClass1 anonymousClass1 = new OnClickListener(this) {
            final /* synthetic */ SnsStrangerCommentDetailUI jTy;

            {
                this.jTy = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.jTy.jTn);
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsStrangerCommentDetailUI jTy;

            {
                this.jTy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jTy.finish();
                return true;
            }
        });
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsStrangerCommentDetailUI jTy;

            {
                this.jTy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsStrangerCommentDetailUI.b(this.jTy);
                return true;
            }
        });
    }

    private void aXr() {
        this.jTq.removeAllViews();
        int a = BackwardSupportUtil.b.a(this, (float) jTx);
        List list = this.jRl.aUp().mWq.mom;
        this.jTr = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ImageView mMImageView = new MMImageView(this);
            mMImageView.setPadding(a, a, a, a);
            this.jTq.addView(mMImageView, new LayoutParams(-2, -2));
            Bitmap wm = ad.aSB().a((aib) list.get(i), mMImageView, hashCode(), com.tencent.mm.storage.ak.nvx).wm();
            if (wm == null) {
                int i2;
                switch (this.jRl.field_type) {
                    case 1:
                        i2 = 2130837647;
                        break;
                    case 2:
                        mMImageView.setImageDrawable(null);
                        i2 = 0;
                        break;
                    case 3:
                        i2 = 2131165247;
                        break;
                    case 4:
                        i2 = 2131165232;
                        break;
                    case 5:
                        i2 = 2131165244;
                        break;
                    case 6:
                        i2 = 2131165231;
                        break;
                    case 7:
                        i2 = 2130837647;
                        break;
                    case 8:
                        mMImageView.setImageDrawable(null);
                        i2 = 0;
                        break;
                    default:
                        i2 = 2131165247;
                        break;
                }
                if (i2 != 0) {
                    mMImageView.setImageResource(i2);
                }
            } else {
                mMImageView.setImageBitmap(wm);
            }
            this.jTr.add(mMImageView);
        }
    }

    protected final int getLayoutId() {
        return 2130904443;
    }

    public final void Aa(String str) {
        aXr();
    }

    public final void ai(String str, boolean z) {
    }

    public final void aRc() {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.SnsStrangerCommentDetailUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void aj(String str, boolean z) {
    }
}
