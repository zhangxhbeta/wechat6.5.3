package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.j;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI extends MMActivity {
    private static ac cnO = new ac(Looper.getMainLooper());
    private LinkedList<arq> cqE = new LinkedList();
    private ListView khG;
    private b khH;
    private Map<String, c> khI;

    private static abstract class a implements Runnable {
        public String iconUrl;
        public String username;

        private a() {
        }

        public final void cP(String str, String str2) {
            this.username = str;
            this.iconUrl = str2;
        }
    }

    private class b extends BaseAdapter {
        final /* synthetic */ ContactSearchResultUI khJ;
        private Context mContext;

        public final /* synthetic */ Object getItem(int i) {
            return rp(i);
        }

        public b(ContactSearchResultUI contactSearchResultUI, Context context) {
            this.khJ = contactSearchResultUI;
            this.mContext = context;
        }

        public final int getCount() {
            return this.khJ.cqE == null ? 0 : this.khJ.cqE.size();
        }

        private arq rp(int i) {
            return this.khJ.cqE == null ? null : (arq) this.khJ.cqE.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            int i2 = 8;
            if (view == null) {
                view = View.inflate(this.mContext, 2130904310, null);
                dVar = new d();
                dVar.dtX = (ImageView) view.findViewById(2131756803);
                dVar.exG = (TextView) view.findViewById(2131759003);
                dVar.exH = view.findViewById(2131759006);
                dVar.exI = (TextView) view.findViewById(2131759008);
                dVar.exL = view.findViewById(2131759005);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            arq rp = rp(i);
            if (rp == null) {
                v.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
            } else {
                dVar.username = rp.moM.mQy;
                dVar.iconUrl = rp.mlZ;
                dVar.dtX.setTag(dVar.username);
                dVar.YJ();
                String str = rp.moM.mQy;
                c cVar = (c) this.khJ.khI.get(str);
                if (cVar == null) {
                    c cVar2 = new c();
                    this.khJ.khI.put(str, cVar2);
                    mc mcVar = rp.mFB;
                    if (mcVar != null) {
                        com.tencent.mm.modelbiz.BizInfo.ExtInfo.c CS;
                        BizInfo bizInfo = new BizInfo();
                        bizInfo.field_username = str;
                        bizInfo.field_brandFlag = mcVar.cHq;
                        bizInfo.field_brandIconURL = mcVar.cHt;
                        bizInfo.field_brandInfo = mcVar.cHs;
                        bizInfo.field_extInfo = mcVar.cHr;
                        if (bizInfo.aX(false) != null) {
                            CS = bizInfo.aX(false).CS();
                        } else {
                            CS = null;
                        }
                        if (CS != null) {
                            boolean z = bizInfo.aX(false).CU() && !be.kS(CS.cCt);
                            cVar2.exE = z;
                            cVar2.exD = rp.mFu != 0;
                        }
                    }
                    cVar = cVar2;
                }
                dVar.exH.setVisibility(cVar.exD ? 0 : 8);
                View a = dVar.exL;
                if (cVar.exE) {
                    i2 = 0;
                }
                a.setVisibility(i2);
                v.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", new Object[]{Integer.valueOf(rp.mFu)});
                try {
                    dVar.exI.setText(e.a(this.mContext, be.ma(rp.cHf), dVar.exI.getTextSize()));
                } catch (Exception e) {
                    dVar.exI.setText("");
                }
                try {
                    TextView textView = dVar.exG;
                    Context context = this.mContext;
                    CharSequence ma = !be.kS(rp.mEj.mQy) ? rp.mEj.mQy : !be.kS(rp.cHh) ? rp.cHh : be.ma(rp.moM.mQy);
                    textView.setText(e.a(context, ma, dVar.exG.getTextSize()));
                } catch (Exception e2) {
                    dVar.exG.setText("");
                }
            }
            return view;
        }
    }

    private static class c {
        protected boolean exD;
        protected boolean exE;

        private c() {
        }
    }

    private static class d implements com.tencent.mm.modelbiz.j.a.a, Runnable {
        public ImageView dtX;
        public TextView exG;
        public View exH;
        public TextView exI;
        private View exL;
        public String iconUrl;
        a khL = new a(this) {
            final /* synthetic */ d khM;

            {
                this.khM = r2;
            }

            public final void run() {
                if (!be.kS(this.username) && !be.kS(this.khM.username) && this.username.equals(this.khM.username)) {
                    Bitmap b = j.b(this.username, this.iconUrl, 0);
                    if (b != null && !b.isRecycled()) {
                        this.khM.YJ();
                    }
                }
            }
        };
        public String username;

        public d() {
            u.DG().a(this);
        }

        public final void YJ() {
            if (this.dtX != null) {
                ak.vA().x(this);
            }
        }

        public final void run() {
            final Bitmap hM = j.hM(this.username);
            if (hM != null) {
                ContactSearchResultUI.cnO.post(new Runnable(this) {
                    final /* synthetic */ d khM;

                    public final void run() {
                        if (this.khM.dtX != null && this.khM.dtX.getTag() != null && this.khM.username != null && this.khM.username.equals(this.khM.dtX.getTag())) {
                            this.khM.dtX.setImageBitmap(hM);
                        }
                    }
                });
            } else {
                ContactSearchResultUI.cnO.post(new Runnable(this) {
                    final /* synthetic */ d khM;

                    {
                        this.khM = r1;
                    }

                    public final void run() {
                        if (this.khM.dtX != null) {
                            this.khM.dtX.setImageResource(2130837790);
                            this.khM.khL.cP(this.khM.username, this.khM.iconUrl);
                            ak.vA().f(this.khM.khL, 200);
                        }
                    }
                });
            }
        }

        public final void hO(String str) {
            if (str != null && str.equals(this.username)) {
                this.khL.cP(this.username, this.iconUrl);
                ak.vA().f(this.khL, 200);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        vD(2131232216);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactSearchResultUI khJ;

            {
                this.khJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.khJ.finish();
                return true;
            }
        });
        this.khI = new HashMap();
        this.khG = (ListView) findViewById(2131756536);
        this.khG.setEmptyView((TextView) findViewById(2131755597));
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("result");
        final int intExtra = getIntent().getIntExtra("add_more_friend_search_scene", 0);
        if (byteArrayExtra != null) {
            try {
                ars com_tencent_mm_protocal_c_ars = (ars) new ars().az(byteArrayExtra);
                if (com_tencent_mm_protocal_c_ars != null) {
                    this.cqE = com_tencent_mm_protocal_c_ars.mxQ;
                }
            } catch (Throwable e) {
                v.a("MicroMsg.ContactSearchResultUI", e, "", new Object[0]);
            }
        }
        if (this.cqE != null && this.cqE.size() != 0) {
            this.khH = new b(this, this);
            this.khG.setAdapter(this.khH);
            this.khG.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ ContactSearchResultUI khJ;

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    int headerViewsCount = i - this.khJ.khG.getHeaderViewsCount();
                    if (headerViewsCount >= 0 && headerViewsCount < this.khJ.khG.getCount()) {
                        arq com_tencent_mm_protocal_c_arq = (arq) this.khJ.khG.getItemAtPosition(headerViewsCount);
                        String str = com_tencent_mm_protocal_c_arq.moM.mQy;
                        ak.yW();
                        com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(str);
                        if (com.tencent.mm.i.a.ei(LX.field_type)) {
                            Intent intent = new Intent();
                            intent.putExtra("Contact_User", str);
                            intent.putExtra("Contact_Scene", 3);
                            if (str != null && str.length() > 0) {
                                if (LX.bvm()) {
                                    g.iuh.Y(10298, str + ",35");
                                    intent.putExtra("Contact_Scene", 35);
                                }
                                com.tencent.mm.ay.c.b(this.khJ, "profile", ".ui.ContactInfoUI", intent);
                                return;
                            }
                            return;
                        }
                        if ((com_tencent_mm_protocal_c_arq.mFu & 8) > 0) {
                            g.iuh.Y(10298, com_tencent_mm_protocal_c_arq.moM.mQy + ",35");
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", com_tencent_mm_protocal_c_arq.moM.mQy);
                        intent2.putExtra("Contact_Alias", com_tencent_mm_protocal_c_arq.cHh);
                        intent2.putExtra("Contact_Nick", com_tencent_mm_protocal_c_arq.mEj.mQy);
                        intent2.putExtra("Contact_Signature", com_tencent_mm_protocal_c_arq.cHf);
                        intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.Y(com_tencent_mm_protocal_c_arq.cHl, com_tencent_mm_protocal_c_arq.cHd, com_tencent_mm_protocal_c_arq.cHe));
                        intent2.putExtra("Contact_Sex", com_tencent_mm_protocal_c_arq.cHc);
                        intent2.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_arq.mFv);
                        intent2.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_arq.mFu);
                        intent2.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_arq.mFy);
                        intent2.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_arq.mFw);
                        intent2.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_arq.mFx);
                        intent2.putExtra("Contact_KSnsIFlag", com_tencent_mm_protocal_c_arq.mFA.cHn);
                        intent2.putExtra("Contact_KSnsBgId", com_tencent_mm_protocal_c_arq.mFA.cHp);
                        intent2.putExtra("Contact_KSnsBgUrl", com_tencent_mm_protocal_c_arq.mFA.cHo);
                        intent2.putExtra("Contact_Scene", 35);
                        if (intExtra != 0) {
                            intent2.putExtra("add_more_friend_search_scene", intExtra);
                        }
                        if (com_tencent_mm_protocal_c_arq.mFB != null) {
                            try {
                                intent2.putExtra("Contact_customInfo", com_tencent_mm_protocal_c_arq.mFB.toByteArray());
                            } catch (Throwable e) {
                                v.a("MicroMsg.ContactSearchResultUI", e, "", new Object[0]);
                            }
                        }
                        if ((com_tencent_mm_protocal_c_arq.mFu & 8) > 0) {
                            g.iuh.Y(10298, com_tencent_mm_protocal_c_arq.moM.mQy + ",35");
                        }
                        com.tencent.mm.ay.c.b(this.khJ, "profile", ".ui.ContactInfoUI", intent2);
                    }
                }
            });
            this.khG.setOnScrollListener(new com.tencent.mm.ui.applet.a());
        }
    }

    protected final int getLayoutId() {
        return 2130903429;
    }

    protected void onDestroy() {
        n.Bq().cancel();
        if (this.khI != null) {
            this.khI.clear();
        }
        super.onDestroy();
    }
}
