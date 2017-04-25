package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.ae.n;
import com.tencent.mm.ar.h;
import com.tencent.mm.ar.l;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.e.a.hn;
import com.tencent.mm.e.a.mv;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.protocal.c.afo;
import com.tencent.mm.protocal.c.afs;
import com.tencent.mm.protocal.c.apy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NearbyFriendsUI extends MMActivity implements e {
    private com.tencent.mm.modelgeo.c bYe;
    private com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ NearbyFriendsUI hFA;

        {
            this.hFA = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (this.hFA.gXq) {
                return false;
            }
            this.hFA.gXq = true;
            if (this.hFA.cAv) {
                if (this.hFA.dwg != null) {
                    this.hFA.dwg.dismiss();
                    this.hFA.dwg = null;
                }
                f.oT(11);
                return false;
            }
            if (z) {
                if (this.hFA.dwg != null) {
                    this.hFA.dwg.setMessage(this.hFA.getString(2131233988));
                }
                this.hFA.hFz = new a(this.hFA, f2, f, (int) d2);
                com.tencent.mm.modelstat.e.JZ().a(2001, i != 0, this.hFA.bYe == null ? false : this.hFA.bYe.cJA, f, f2, (int) d2);
                this.hFA.hFl = new com.tencent.mm.plugin.nearby.a.d(this.hFA.hFp, this.hFA.hFz.cJr, this.hFA.hFz.cJq, this.hFA.hFz.accuracy, i, "", "");
                ak.vy().a(this.hFA.hFl, 0);
                ak.vy().a(new com.tencent.mm.plugin.nearby.a.c(this.hFA.hFz.cJr, this.hFA.hFz.cJq, this.hFA.hFz.accuracy, i, "", ""), 0);
                v.i("MicroMsg.NearbyFriend", "do NetSceneLBSLifeGetNearbyRecommendPoi");
            } else {
                f.oT(11);
                if (this.hFA.dwg != null) {
                    this.hFA.dwg.dismiss();
                    this.hFA.dwg = null;
                }
                this.hFA.aDF();
                this.hFA.findViewById(2131758408).setVisibility(0);
                this.hFA.hFk.setVisibility(8);
                this.hFA.hFw = true;
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c bYn = new com.tencent.mm.sdk.c.c<hn>(this) {
        final /* synthetic */ NearbyFriendsUI hFA;

        {
            this.hFA = r2;
            this.nhz = hn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            hn hnVar = (hn) bVar;
            if (hnVar != null && (hnVar instanceof hn)) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 hFB;

                    {
                        this.hFB = r1;
                    }

                    public final void run() {
                        this.hFB.hFA.aDE();
                    }
                });
            }
            return false;
        }
    };
    boolean cAv = false;
    private p dwg = null;
    private List<afs> fHE = new LinkedList();
    private boolean gXq = false;
    private List<afs> gYH = new LinkedList();
    private com.tencent.mm.plugin.nearby.a.d hEX;
    private b hFj;
    private ListView hFk;
    private com.tencent.mm.plugin.nearby.a.d hFl;
    private com.tencent.mm.plugin.nearby.a.e hFm;
    private boolean hFn = false;
    private String[] hFo;
    private int hFp = 1;
    private BindMobileOrQQHeaderView hFq;
    private ViewGroup hFr;
    private View hFs;
    private View hFt;
    private boolean hFu = false;
    private int hFv;
    private boolean hFw = false;
    private int hFx = 0;
    private View hFy = null;
    private a hFz;

    private class a {
        public int accuracy;
        public float cJq;
        public float cJr;
        final /* synthetic */ NearbyFriendsUI hFA;

        public a(NearbyFriendsUI nearbyFriendsUI, float f, float f2, int i) {
            this.hFA = nearbyFriendsUI;
            this.cJq = f;
            this.cJr = f2;
            this.accuracy = i;
        }
    }

    class b extends BaseAdapter {
        com.tencent.mm.ui.applet.b cHD = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a(this) {
            final /* synthetic */ b hFE;

            {
                this.hFE = r1;
            }

            public final Bitmap iG(String str) {
                return com.tencent.mm.u.b.a(str, false, -1);
            }
        });
        private com.tencent.mm.ui.applet.b.b cHE = null;
        private final Context context;
        final /* synthetic */ NearbyFriendsUI hFA;

        public final /* synthetic */ Object getItem(int i) {
            return ny(i);
        }

        public b(NearbyFriendsUI nearbyFriendsUI, Context context) {
            this.hFA = nearbyFriendsUI;
            this.context = context;
        }

        public final int getCount() {
            return this.hFA.fHE.size();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            if (this.cHE == null) {
                this.cHE = new com.tencent.mm.ui.applet.b.b(this) {
                    final /* synthetic */ b hFE;

                    {
                        this.hFE = r1;
                    }

                    public final String fo(int i) {
                        if (i < 0 || i >= this.hFE.getCount()) {
                            v.e("MicroMsg.NearbyFriend", "pos is invalid");
                            return null;
                        }
                        afs ny = this.hFE.ny(i);
                        if (ny != null) {
                            return ny.gln;
                        }
                        return null;
                    }

                    public final int EU() {
                        return this.hFE.getCount();
                    }
                };
            }
            if (this.cHD != null) {
                this.cHD.a(i, this.cHE);
            }
            if (view == null) {
                d dVar2 = new d();
                view = View.inflate(this.context, 2130904116, null);
                dVar2.cHI = (TextView) view.findViewById(2131756766);
                dVar2.hFH = (TextView) view.findViewById(2131758419);
                dVar2.hFG = (TextView) view.findViewById(2131758413);
                dVar2.cHH = (ImageView) view.findViewById(2131756765);
                dVar2.cHJ = (TextView) view.findViewById(2131758410);
                dVar2.hFI = (ImageView) view.findViewById(2131758412);
                dVar2.hFJ = (ImageView) view.findViewById(2131758414);
                dVar2.hFL = (ImageView) view.findViewById(2131758415);
                dVar2.hFM = (ImageView) view.findViewById(2131758416);
                dVar2.hFN = (ImageView) view.findViewById(2131758417);
                LayoutParams layoutParams = dVar2.hFJ.getLayoutParams();
                layoutParams.height = com.tencent.mm.bd.a.N(this.context, 2131493168);
                layoutParams.width = com.tencent.mm.bd.a.N(this.context, 2131493168);
                dVar2.hFJ.setLayoutParams(layoutParams);
                dVar2.hFK = (ImageView) view.findViewById(2131758411);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            afs com_tencent_mm_protocal_c_afs = (afs) this.hFA.fHE.get(i);
            dVar.cHI.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, com_tencent_mm_protocal_c_afs.efy, dVar.cHI.getTextSize()));
            if (this.hFA.hFp == 1) {
                switch (com_tencent_mm_protocal_c_afs.cHc) {
                    case 1:
                        dVar.hFK.setVisibility(0);
                        dVar.hFK.setImageResource(2131165606);
                        dVar.hFK.setContentDescription(this.context.getString(2131233728));
                        break;
                    case 2:
                        dVar.hFK.setVisibility(0);
                        dVar.hFK.setImageResource(2131165605);
                        dVar.hFK.setContentDescription(this.context.getString(2131232762));
                        break;
                    default:
                        dVar.hFK.setVisibility(8);
                        break;
                }
            }
            dVar.hFK.setVisibility(8);
            if (com_tencent_mm_protocal_c_afs.mFu != 0) {
                dVar.hFI.setVisibility(0);
                dVar.hFI.setImageBitmap(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.c(com.tencent.mm.model.ab.a.csb.eI(com_tencent_mm_protocal_c_afs.mFu), 2.0f));
                dVar.hFK.setVisibility(8);
            } else {
                dVar.hFI.setVisibility(8);
            }
            dVar.hFG.setText(com_tencent_mm_protocal_c_afs.mFt);
            dVar.hFL.setVisibility(8);
            dVar.hFM.setVisibility(8);
            dVar.hFN.setVisibility(8);
            if (com_tencent_mm_protocal_c_afs instanceof com.tencent.mm.plugin.nearby.a.a) {
                LinkedList linkedList = ((com.tencent.mm.plugin.nearby.a.a) com_tencent_mm_protocal_c_afs).hED;
                if (linkedList != null && linkedList.size() == 1) {
                    dVar.hFL.setVisibility(0);
                    NearbyFriendsUI.k(dVar.hFL, (String) linkedList.get(0));
                } else if (linkedList != null && linkedList.size() == 2) {
                    dVar.hFL.setVisibility(0);
                    dVar.hFM.setVisibility(0);
                    NearbyFriendsUI.k(dVar.hFL, (String) linkedList.get(0));
                    NearbyFriendsUI.k(dVar.hFM, (String) linkedList.get(1));
                } else if (linkedList != null && linkedList.size() >= 3) {
                    dVar.hFL.setVisibility(0);
                    dVar.hFM.setVisibility(0);
                    dVar.hFN.setVisibility(0);
                    NearbyFriendsUI.k(dVar.hFL, (String) linkedList.get(0));
                    NearbyFriendsUI.k(dVar.hFM, (String) linkedList.get(1));
                    NearbyFriendsUI.k(dVar.hFN, (String) linkedList.get(2));
                }
            }
            if (com_tencent_mm_protocal_c_afs.cHf == null || com_tencent_mm_protocal_c_afs.cHf.trim().equals("")) {
                dVar.hFH.setVisibility(8);
            } else {
                dVar.hFH.setVisibility(0);
                dVar.hFH.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, com_tencent_mm_protocal_c_afs.cHf, dVar.hFH.getTextSize()));
            }
            if (com_tencent_mm_protocal_c_afs.mFA == null || (com_tencent_mm_protocal_c_afs.mFA.cHn & 1) <= 0) {
                dVar.hFJ.setVisibility(8);
            } else {
                dVar.hFJ.setVisibility(0);
            }
            if (c.nz(com_tencent_mm_protocal_c_afs.cHc)) {
                dVar.cHH.setImageBitmap(null);
                com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
                ak.yW();
                aVar.cPv = com.tencent.mm.model.c.wP();
                aVar.cPs = true;
                aVar.cPO = true;
                n.GL().a(com_tencent_mm_protocal_c_afs.gln, dVar.cHH, aVar.GU());
                if (!be.kS(com_tencent_mm_protocal_c_afs.cHh)) {
                    dVar.cHJ.setText(com_tencent_mm_protocal_c_afs.cHh);
                    dVar.cHJ.setVisibility(0);
                }
                dVar.cHJ.setVisibility(8);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.m(dVar.cHH, com_tencent_mm_protocal_c_afs.gln);
                ak.yW();
                if (com.tencent.mm.model.c.wH().LT(com_tencent_mm_protocal_c_afs.gln)) {
                    dVar.cHJ.setVisibility(0);
                    if (u.vd(com_tencent_mm_protocal_c_afs.mFu)) {
                        dVar.cHJ.setText(this.hFA.getString(2131233989));
                    } else {
                        ak.yW();
                        u LV = com.tencent.mm.model.c.wH().LV(com_tencent_mm_protocal_c_afs.gln);
                        if (LV != null) {
                            dVar.cHI.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, be.kS(LV.tU()) ? com_tencent_mm_protocal_c_afs.efy : LV.tU(), dVar.cHI.getTextSize()));
                        }
                        dVar.cHJ.setText(this.hFA.getString(2131233994));
                    }
                }
                dVar.cHJ.setVisibility(8);
            }
            return view;
        }

        public final afs ny(int i) {
            return (afs) this.hFA.fHE.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }
    }

    static class c {
        public static int hFF = Constants.THREAD_BITSET_SIZE;

        public static afs a(apy com_tencent_mm_protocal_c_apy) {
            if (com_tencent_mm_protocal_c_apy == null) {
                return null;
            }
            afs aVar = new com.tencent.mm.plugin.nearby.a.a();
            aVar.cHc = hFF;
            aVar.gln = com_tencent_mm_protocal_c_apy.eBZ;
            aVar.mFt = com_tencent_mm_protocal_c_apy.mPq;
            aVar.efy = com_tencent_mm_protocal_c_apy.title;
            aVar.cHh = com_tencent_mm_protocal_c_apy.eBN;
            aVar.cHd = com_tencent_mm_protocal_c_apy.mPr;
            aVar.cHf = com_tencent_mm_protocal_c_apy.bCj;
            aVar.hED = com_tencent_mm_protocal_c_apy.hED;
            return aVar;
        }

        public static boolean nz(int i) {
            return i == hFF;
        }

        public static String b(afs com_tencent_mm_protocal_c_afs) {
            if (com_tencent_mm_protocal_c_afs != null) {
                return com_tencent_mm_protocal_c_afs.cHd;
            }
            return null;
        }
    }

    static class d {
        ImageView cHH;
        TextView cHI;
        TextView cHJ;
        TextView hFG;
        TextView hFH;
        ImageView hFI;
        ImageView hFJ;
        ImageView hFK;
        ImageView hFL;
        ImageView hFM;
        ImageView hFN;

        d() {
        }
    }

    static /* synthetic */ void k(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.NearbyFriend", "setImgBmp url is empty");
            return;
        }
        imageView.setImageBitmap(null);
        com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
        ak.yW();
        aVar.cPv = com.tencent.mm.model.c.wP();
        aVar.cPs = true;
        aVar.cPO = true;
        n.GL().a(str, imageView, aVar.GU());
    }

    static /* synthetic */ void w(NearbyFriendsUI nearbyFriendsUI) {
        if (nearbyFriendsUI.hFz != null) {
            nearbyFriendsUI.hFm = new com.tencent.mm.plugin.nearby.a.e(nearbyFriendsUI.hFz.cJr, nearbyFriendsUI.hFz.cJq, nearbyFriendsUI.hFz.accuracy, "", "");
            ActionBarActivity actionBarActivity = nearbyFriendsUI.nDR.nEl;
            nearbyFriendsUI.getString(2131231164);
            nearbyFriendsUI.dwg = g.a(actionBarActivity, nearbyFriendsUI.getString(2131234009), true, new OnCancelListener(nearbyFriendsUI) {
                final /* synthetic */ NearbyFriendsUI hFA;

                {
                    this.hFA = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(this.hFA.hFm);
                }
            });
            com.tencent.mm.plugin.nearby.a.b.cJ(3);
            ak.vy().a(nearbyFriendsUI.hFm, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        f.oR(11);
        super.onCreate(bundle);
        vD(2131234007);
        ak.vy().a(148, this);
        ak.vy().a(376, this);
        ak.vy().a(1087, this);
        this.bYe = com.tencent.mm.modelgeo.c.FY();
        NI();
        this.hFo = new String[]{getResources().getString(2131233999), getResources().getString(2131233998), getResources().getString(2131233997), getResources().getString(2131234732)};
        ak.yW();
        this.hFp = be.a((Integer) com.tencent.mm.model.c.vf().get(16386, null), 1);
        if (this.hFp == 3) {
            vG(2131165606);
        } else if (this.hFp == 4) {
            vG(2131165605);
        } else {
            vG(0);
            this.hFp = 1;
        }
        aDD();
    }

    private void aDD() {
        this.gXq = false;
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.dwg = g.a(actionBarActivity, getString(2131233996), true, new OnCancelListener(this) {
            final /* synthetic */ NearbyFriendsUI hFA;

            {
                this.hFA = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.hFA.cAv = true;
                f.oT(11);
                if (this.hFA.hFl != null) {
                    ak.vy().c(this.hFA.hFl);
                }
                v.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
                if (!this.hFA.hFw) {
                    this.hFA.finish();
                    v.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
                }
            }
        });
        this.cAv = false;
        if (this.bYe != null) {
            this.bYe.a(this.bYl, true);
        }
    }

    protected final int getLayoutId() {
        return 2130904114;
    }

    private void aDE() {
        if (com.tencent.mm.aw.a.bmn()) {
            View view;
            if (this.hFy != null) {
                this.hFk.removeHeaderView(this.hFy);
                this.hFy = null;
            }
            View inflate = View.inflate(this, 2130904118, null);
            TextView textView = (TextView) inflate.findViewById(2131757422);
            int Kw = l.KE().Kw();
            if (Kw == 0) {
                inflate.setVisibility(8);
                view = null;
            } else {
                inflate.setVisibility(0);
                textView.setText(getResources().getQuantityString(2131361818, Kw, new Object[]{Integer.valueOf(Kw)}));
                ImageView imageView = (ImageView) inflate.findViewById(2131757421);
                h Kx = l.KE().Kx();
                if (Kx != null) {
                    com.tencent.mm.pluginsdk.ui.a.b.m(imageView, Kx.field_sayhiuser);
                }
                inflate.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ NearbyFriendsUI hFA;

                    {
                        this.hFA = r1;
                    }

                    public final void onClick(View view) {
                        this.hFA.hFk.removeHeaderView(this.hFA.hFy);
                        this.hFA.hFy = null;
                        Intent intent = new Intent(this.hFA, NearbySayHiListUI.class);
                        intent.putExtra("k_say_hi_type", 2);
                        intent.putExtra("show_clear_header", true);
                        this.hFA.startActivityForResult(intent, 2009);
                    }
                });
                view = inflate;
            }
            this.hFy = view;
            if (this.hFy != null) {
                this.hFk.addHeaderView(this.hFy);
            }
        }
    }

    protected final void NI() {
        this.hFk = (ListView) findViewById(2131758406);
        this.hFj = new b(this, this);
        ListView listView = this.hFk;
        if (this.hFr == null) {
            this.hFr = new LinearLayout(this);
            this.hFr.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ((LinearLayout) this.hFr).setGravity(17);
        }
        this.hFu = true;
        listView.addHeaderView(this.hFr);
        String value = j.sU().getValue("LBSShowBindPhone");
        if (value != null && value.length() > 0) {
            try {
                this.hFv = Integer.valueOf(value).intValue();
            } catch (Exception e) {
                this.hFv = 0;
            }
        }
        ak.yW();
        value = (String) com.tencent.mm.model.c.vf().get(6, null);
        if (value != null && value.length() > 0) {
            this.hFv = 0;
        }
        this.hFx = 0;
        if (com.tencent.mm.model.a.f.Aj().ga(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
            value = com.tencent.mm.model.a.f.Aj().ga(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).value;
            com.tencent.mm.modelfriend.m.a EY = m.EY();
            if (value.equals("0")) {
                this.hFx = 0;
            } else if (value.equals("2")) {
                if (EY == com.tencent.mm.modelfriend.m.a.cHS) {
                    this.hFx = 2;
                    com.tencent.mm.model.a.e.ge(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                }
            } else if (value.equals("1") && EY == com.tencent.mm.modelfriend.m.a.cHP) {
                this.hFx = 2;
                com.tencent.mm.model.a.e.ge(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            }
        }
        if ((this.hFv > 0 || this.hFx > 0) && this.hFx != 1) {
            this.hFq = new BindMobileOrQQHeaderView(this);
            this.hFk.addHeaderView(this.hFq);
        }
        this.hFk.setAdapter(this.hFj);
        this.hFk.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ NearbyFriendsUI hFA;

            {
                this.hFA = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.hFA.hFv > 0 || this.hFA.hFx > 0) {
                    i--;
                }
                if (com.tencent.mm.aw.a.bmn() && this.hFA.hFy != null) {
                    i--;
                }
                if (this.hFA.hFu) {
                    i--;
                }
                if (i >= 0 && i < this.hFA.fHE.size()) {
                    afs com_tencent_mm_protocal_c_afs = (afs) this.hFA.fHE.get(i);
                    Intent intent;
                    if (c.nz(com_tencent_mm_protocal_c_afs.cHc)) {
                        String b = c.b(com_tencent_mm_protocal_c_afs);
                        v.d("MicroMsg.NearbyFriend", "poi item click, go:" + be.ma(b));
                        if (!be.kS(b)) {
                            intent = new Intent();
                            intent.putExtra("rawUrl", b);
                            intent.putExtra("geta8key_scene", 25);
                            intent.putExtra("stastic_scene", 12);
                            com.tencent.mm.ay.c.b(this.hFA.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                            return;
                        }
                        return;
                    }
                    String str = com_tencent_mm_protocal_c_afs.gln;
                    ak.yW();
                    u LX = com.tencent.mm.model.c.wH().LX(str);
                    if (com.tencent.mm.i.a.ei(LX.field_type)) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", str);
                        intent2.putExtra("Contact_Scene", 18);
                        intent2.putExtra("Sns_from_Scene", 18);
                        intent2.putExtra("lbs_ticket", com_tencent_mm_protocal_c_afs.mvR);
                        intent2.putExtra("Contact_IsLbsGotoChatting", true);
                        if (str != null && str.length() > 0) {
                            if (LX.bvm()) {
                                com.tencent.mm.plugin.report.service.g.iuh.Y(10298, str + ",18");
                            }
                            mv mvVar = new mv();
                            mvVar.bof.intent = intent2;
                            mvVar.bof.username = str;
                            com.tencent.mm.sdk.c.a.nhr.z(mvVar);
                            com.tencent.mm.plugin.nearby.a.drp.d(intent2, this.hFA);
                            return;
                        }
                        return;
                    }
                    intent = new Intent();
                    intent.putExtra("Contact_User", com_tencent_mm_protocal_c_afs.gln);
                    intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_afs.cHh);
                    intent.putExtra("Contact_Nick", com_tencent_mm_protocal_c_afs.efy);
                    intent.putExtra("Contact_Distance", com_tencent_mm_protocal_c_afs.mFt);
                    intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_afs.cHf);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.Y(com_tencent_mm_protocal_c_afs.cHl, com_tencent_mm_protocal_c_afs.cHd, com_tencent_mm_protocal_c_afs.cHe));
                    intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_afs.cHc);
                    intent.putExtra("Contact_IsLBSFriend", true);
                    intent.putExtra("Contact_Scene", 18);
                    intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_afs.mFv);
                    intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_afs.mFu);
                    intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_afs.mFy);
                    intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_afs.mFw);
                    intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_afs.mFx);
                    intent.putExtra("Contact_KSnsIFlag", com_tencent_mm_protocal_c_afs.mFA.cHn);
                    intent.putExtra("Contact_KSnsBgId", com_tencent_mm_protocal_c_afs.mFA.cHp);
                    intent.putExtra("Contact_KSnsBgUrl", com_tencent_mm_protocal_c_afs.mFA.cHo);
                    intent.putExtra("lbs_ticket", com_tencent_mm_protocal_c_afs.mvR);
                    intent.putExtra("Contact_IsLbsGotoChatting", true);
                    if (com_tencent_mm_protocal_c_afs.cHm != null) {
                        BizInfo bizInfo = new BizInfo();
                        bizInfo.field_brandList = com_tencent_mm_protocal_c_afs.cHm;
                        bizInfo.field_brandFlag = com_tencent_mm_protocal_c_afs.mFB.cHq;
                        bizInfo.field_brandIconURL = com_tencent_mm_protocal_c_afs.mFB.cHt;
                        bizInfo.field_extInfo = com_tencent_mm_protocal_c_afs.mFB.cHr;
                        bizInfo.field_brandInfo = com_tencent_mm_protocal_c_afs.mFB.cHs;
                        intent.putExtra("KBrandInfo_item", new MCacheItem(bizInfo));
                    }
                    intent.putExtra("Sns_from_Scene", 18);
                    com.tencent.mm.plugin.nearby.a.drp.d(intent, this.hFA);
                }
            }
        });
        this.hFk.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ NearbyFriendsUI hFA;

            {
                this.hFA = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.hFA.hFj != null) {
                    b s = this.hFA.hFj;
                    if (s.cHD != null) {
                        s.cHD.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbyFriendsUI hFA;

            {
                this.hFA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hFA.finish();
                return true;
            }
        });
        AnonymousClass13 anonymousClass13 = new OnClickListener(this) {
            final /* synthetic */ NearbyFriendsUI hFA;

            {
                this.hFA = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(this.hFA.hFk);
            }
        };
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbyFriendsUI hFA;

            {
                this.hFA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(this.hFA, com.tencent.mm.ui.widget.f.pbS, false);
                fVar.jXo = new com.tencent.mm.ui.base.n.d(this) {
                    final /* synthetic */ AnonymousClass14 hFC;

                    {
                        this.hFC = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (i) {
                            case 0:
                                this.hFC.hFA.hFp = 4;
                                this.hFC.hFA.hFn = false;
                                ak.yW();
                                com.tencent.mm.model.c.vf().set(16386, Integer.valueOf(this.hFC.hFA.hFp));
                                this.hFC.hFA.aDD();
                                return;
                            case 1:
                                this.hFC.hFA.hFp = 3;
                                this.hFC.hFA.hFn = false;
                                ak.yW();
                                com.tencent.mm.model.c.vf().set(16386, Integer.valueOf(this.hFC.hFA.hFp));
                                this.hFC.hFA.aDD();
                                return;
                            case 2:
                                this.hFC.hFA.hFp = 1;
                                this.hFC.hFA.hFn = false;
                                ak.yW();
                                com.tencent.mm.model.c.vf().set(16386, Integer.valueOf(this.hFC.hFA.hFp));
                                this.hFC.hFA.aDD();
                                return;
                            case 3:
                                Intent intent = new Intent(this.hFC.hFA, NearbySayHiListUI.class);
                                intent.putExtra("k_say_hi_type", 2);
                                this.hFC.hFA.startActivityForResult(intent, 2009);
                                return;
                            case 4:
                                this.hFC.hFA.hEX = new com.tencent.mm.plugin.nearby.a.d(2, 0.0f, 0.0f, 0, 0, "", "");
                                ak.vy().a(this.hFC.hFA.hEX, 0);
                                NearbyFriendsUI nearbyFriendsUI = this.hFC.hFA;
                                ActionBarActivity actionBarActivity = this.hFC.hFA.nDR.nEl;
                                this.hFC.hFA.getString(2131231164);
                                nearbyFriendsUI.dwg = g.a(actionBarActivity, this.hFC.hFA.getString(2131233986), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass1 hFD;

                                    {
                                        this.hFD = r1;
                                    }

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ak.vy().c(this.hFD.hFC.hFA.hEX);
                                    }
                                });
                                return;
                            default:
                                return;
                        }
                    }
                };
                fVar.jXn = new com.tencent.mm.ui.base.n.c(this) {
                    final /* synthetic */ AnonymousClass14 hFC;

                    {
                        this.hFC = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        lVar.dg(-1, 2131233999);
                        lVar.dg(-1, 2131233998);
                        lVar.dg(-1, 2131233997);
                        lVar.dg(-1, 2131234732);
                        lVar.dg(-1, 2131233982);
                    }
                };
                fVar.bKh();
                return true;
            }
        });
    }

    private void aDF() {
        com.tencent.mm.plugin.nearby.a.drp.aj(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.hFn = false;
                    aDD();
                    return;
                }
                return;
            case 2009:
                if (i2 == -1) {
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.bYe != null) {
            this.bYe.c(this.bYl);
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.bYn);
    }

    protected void onResume() {
        super.onResume();
        if (this.bYe != null) {
            this.bYe.a(this.bYl, true);
        }
        aDE();
        this.hFj.notifyDataSetChanged();
        if (l.KE().Kw() == 0) {
            this.hFk.removeHeaderView(this.hFt);
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.bYn);
    }

    protected void onDestroy() {
        if (this.hFx > 0) {
            com.tencent.mm.model.a.e.gf(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        }
        f.oT(11);
        ak.vy().b(148, this);
        ak.vy().b(376, this);
        ak.vy().b(1087, this);
        if (this.dwg != null && this.dwg.isShowing()) {
            this.dwg.dismiss();
        }
        if (this.bYe != null) {
            this.bYe.c(this.bYl);
        }
        com.tencent.mm.u.n.Bq().cancel();
        if (this.hFj != null) {
            b bVar = this.hFj;
            if (bVar.cHD != null) {
                bVar.cHD.detach();
                bVar.cHD = null;
            }
        }
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 148) {
            int AG = ((com.tencent.mm.plugin.nearby.a.d) kVar).AG();
            if (this.hFl != null || (AG != 1 && AG != 3 && AG != 4)) {
                if ((AG == 1 || AG == 3 || AG == 4) && this.hFn) {
                    v.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", new Object[]{Integer.valueOf(AG)});
                } else if (this.hEX != null || AG != 2) {
                    v.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (kVar.getType() == 148) {
                        if (this.dwg != null) {
                            this.dwg.dismiss();
                            this.dwg = null;
                        }
                        if (i == 0 && i2 == 0) {
                            if (AG == 1 || AG == 3 || AG == 4) {
                                this.fHE = ((com.tencent.mm.plugin.nearby.a.d) kVar).aDA();
                                if (this.fHE == null || this.fHE.size() == 0) {
                                    findViewById(2131758407).setVisibility(0);
                                    this.hFk.setVisibility(8);
                                    aDF();
                                    f.oT(11);
                                } else {
                                    findViewById(2131758407).setVisibility(8);
                                    List linkedList = new LinkedList();
                                    int i3 = 0;
                                    for (afs com_tencent_mm_protocal_c_afs : this.fHE) {
                                        ak.yW();
                                        if (com.tencent.mm.model.c.wH().LT(com_tencent_mm_protocal_c_afs.gln)) {
                                            linkedList.add(i3, com_tencent_mm_protocal_c_afs);
                                            i3++;
                                        } else {
                                            linkedList.add(com_tencent_mm_protocal_c_afs);
                                        }
                                    }
                                    this.fHE.clear();
                                    this.fHE = linkedList;
                                    if (this.gYH != null) {
                                        for (AG = this.gYH.size() - 1; AG >= 0; AG--) {
                                            if (this.gYH.get(AG) != null) {
                                                this.fHE.add(0, this.gYH.get(AG));
                                            }
                                        }
                                    }
                                    this.hFj.notifyDataSetChanged();
                                    if (this.hFj.getCount() > 0) {
                                        this.hFk.setSelection(0);
                                    }
                                    this.hFk.post(new Runnable(this) {
                                        final /* synthetic */ NearbyFriendsUI hFA;

                                        {
                                            this.hFA = r1;
                                        }

                                        public final void run() {
                                            f.oS(11);
                                        }
                                    });
                                }
                                if (this.hFp == 3) {
                                    vG(2131165606);
                                } else if (this.hFp == 4) {
                                    vG(2131165605);
                                } else {
                                    vG(0);
                                    this.hFp = 1;
                                }
                                this.hFn = true;
                                this.hFl = null;
                            }
                            if (((com.tencent.mm.plugin.nearby.a.d) kVar).AG() == 2) {
                                g.a(this.nDR.nEl, getString(2131233985), "", new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ NearbyFriendsUI hFA;

                                    {
                                        this.hFA = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.hFA.finish();
                                    }
                                });
                                this.hEX = null;
                            }
                            if (((com.tencent.mm.plugin.nearby.a.d) kVar).aDy()) {
                                CharSequence string = getString(2131234010);
                                int aDz = ((com.tencent.mm.plugin.nearby.a.d) kVar).aDz();
                                if (this.hFr != null) {
                                    if (this.hFs == null) {
                                        this.hFs = View.inflate(this, 2130904119, null);
                                        this.hFr.addView(this.hFs);
                                        this.hFs.setOnClickListener(new OnClickListener(this) {
                                            final /* synthetic */ NearbyFriendsUI hFA;

                                            {
                                                this.hFA = r1;
                                            }

                                            public final void onClick(View view) {
                                                NearbyFriendsUI.w(this.hFA);
                                            }
                                        });
                                    } else {
                                        this.hFs.setVisibility(0);
                                    }
                                    ((TextView) this.hFs.findViewById(2131758421)).setText(string);
                                    if (aDz != 0) {
                                        ((TextView) this.hFs.findViewById(2131758422)).setText(String.format(getResources().getQuantityString(2131361811, aDz, new Object[]{Integer.valueOf(aDz)}), new Object[0]));
                                    }
                                }
                            } else if (!(this.hFs == null || this.hFr == null)) {
                                this.hFs.setVisibility(8);
                            }
                            this.hFw = true;
                            return;
                        }
                        if (AG == 1 || AG == 3 || AG == 4) {
                            TextView textView = (TextView) findViewById(2131758407);
                            textView.setVisibility(0);
                            aDF();
                            if (i2 == -2001) {
                                textView.setText(getString(2131233987));
                            } else {
                                textView.setText(getString(2131233990));
                            }
                            this.hFk.setVisibility(8);
                            this.hFl = null;
                        }
                        if (((com.tencent.mm.plugin.nearby.a.d) kVar).AG() == 2) {
                            Toast.makeText(this, 2131233984, 1).show();
                            this.hEX = null;
                        }
                    }
                }
            }
        } else if (kVar.getType() == 376) {
            if (((com.tencent.mm.plugin.nearby.a.e) kVar).AG() == 1) {
                if (this.dwg != null) {
                    this.dwg.dismiss();
                    this.dwg = null;
                }
                if (i == 0 && i2 == 0 && ((com.tencent.mm.plugin.nearby.a.e) kVar).hEG != null) {
                    String str2 = ((com.tencent.mm.plugin.nearby.a.e) kVar).hEG;
                    com.tencent.mm.plugin.nearby.a.b.ck(str2, ((com.tencent.mm.plugin.nearby.a.e) kVar).hEH);
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", str2);
                    com.tencent.mm.plugin.nearby.a.drp.f(intent, this);
                    return;
                }
                g.a(this.nDR.nEl, 2131234008, 2131231164, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ NearbyFriendsUI hFA;

                    {
                        this.hFA = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        } else if (kVar.getType() == 1087) {
            v.i("MicroMsg.NearbyFriend", "NetSceneLBSLifeGetNearbyRecommendPoi onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                aQ(((afo) ((com.tencent.mm.plugin.nearby.a.c) kVar).cif.czl.czs).mFq);
                if (this.hFj != null) {
                    this.hFj.notifyDataSetChanged();
                }
            }
        }
    }

    private void aQ(List<apy> list) {
        int i;
        int i2;
        if (this.gYH == null) {
            this.gYH = new ArrayList();
        } else {
            this.gYH.clear();
        }
        List linkedList = new LinkedList();
        for (i = 0; i < this.fHE.size(); i++) {
            if (!c.nz(((afs) this.fHE.get(i)).cHc)) {
                linkedList.add(this.fHE.get(i));
            }
        }
        this.fHE.clear();
        this.fHE = linkedList;
        v.i("MicroMsg.NearbyFriend", "insertPoiItemList()");
        if (this.fHE.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (list != null) {
            for (i = list.size() - 1; i >= 0; i--) {
                afs a = c.a((apy) list.get(i));
                if (a != null) {
                    this.gYH.add(0, a);
                    if (i2 != 0) {
                        this.fHE.add(0, a);
                    }
                }
            }
            return;
        }
        v.e("MicroMsg.NearbyFriend", "insertPoiItemList list is null");
    }
}
