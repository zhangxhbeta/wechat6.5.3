package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.i;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.h;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.protocal.c.is;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.List;

public class CardNewMsgUI extends MMActivity implements com.tencent.mm.plugin.card.a.i.a {
    private ListView Eq;
    private View dZV;
    OnClickListener eFl = new OnClickListener(this) {
        final /* synthetic */ CardNewMsgUI eKV;

        {
            this.eKV = r1;
        }

        public final void onClick(View view) {
            g gVar;
            if (view.getId() == 2131755925) {
                gVar = (g) view.getTag();
                if (gVar != null && gVar.aab() != null) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11941, new Object[]{Integer.valueOf(2), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, ""});
                    if (gVar.aab().eCZ == 0) {
                        v.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
                        if (TextUtils.isEmpty(gVar.aab().url)) {
                            v.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                        } else {
                            com.tencent.mm.plugin.card.b.b.a(this.eKV, gVar.aab().url, 2);
                        }
                    } else if (gVar.aab().eCZ == 1) {
                        v.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
                        Intent intent = new Intent();
                        intent.putExtra("KEY_CARD_ID", gVar.field_card_id);
                        intent.putExtra("KEY_CARD_TP_ID", gVar.field_card_tp_id);
                        intent.setClass(this.eKV, CardShopUI.class);
                        this.eKV.startActivity(intent);
                        com.tencent.mm.plugin.report.service.g.iuh.h(11324, new Object[]{"UsedStoresView", Integer.valueOf(gVar.field_card_type), gVar.field_card_tp_id, gVar.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
                    }
                }
            } else if (view.getId() == 2131755929) {
                gVar = (g) view.getTag();
                if (gVar != null && gVar.aac() != null) {
                    if (gVar.aac().type == 0) {
                        v.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
                        if (TextUtils.isEmpty(gVar.aac().url)) {
                            v.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
                        } else {
                            com.tencent.mm.plugin.card.b.b.a(this.eKV, gVar.aac().url, 2);
                        }
                    } else if (gVar.aac().type == 1) {
                        v.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
                    }
                }
            }
        }
    };
    private a eKR;
    private View eKS;
    private View eKT = null;
    private boolean eKU = false;

    class a extends j<g> {
        final /* synthetic */ CardNewMsgUI eKV;
        private int eKW = 10;
        private int emv = this.eKW;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (g) obj;
            if (obj == null) {
                obj = new g();
            }
            obj.b(cursor);
            return obj;
        }

        public a(CardNewMsgUI cardNewMsgUI) {
            this.eKV = cardNewMsgUI;
            super(cardNewMsgUI, new g());
            iQ(true);
        }

        public final void Ol() {
            if (af.aam().Kw() > 0) {
                setCursor(af.aam().cie.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[]{"1"}));
            } else {
                this.emv = af.aam().getCount();
                h aam = af.aam();
                setCursor(aam.cie.rawQuery("select * from CardMsgInfo order by time desc LIMIT " + this.eKW, null));
            }
            notifyDataSetChanged();
        }

        protected final void Om() {
            avc();
            Ol();
        }

        public final boolean abO() {
            return this.eKW >= this.emv;
        }

        public final int abP() {
            if (abO()) {
                if (this.eKV.eKT.getParent() != null) {
                    this.eKV.Eq.removeFooterView(this.eKV.eKT);
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
            b bVar;
            g gVar = (g) getItem(i);
            if (view == null) {
                view = View.inflate(this.eKV.nDR.nEl, 2130903237, null);
                b bVar2 = new b();
                bVar2.eLb = (ImageView) view.findViewById(2131755922);
                bVar2.eLc = view.findViewById(2131755908);
                bVar2.eLd = (ImageView) view.findViewById(2131755909);
                bVar2.eLe = (TextView) view.findViewById(2131755456);
                bVar2.eLf = (TextView) view.findViewById(2131755923);
                bVar2.eLg = (TextView) view.findViewById(2131755924);
                bVar2.eLh = (TextView) view.findViewById(2131755925);
                bVar2.eLi = (TextView) view.findViewById(2131755928);
                bVar2.eLj = view.findViewById(2131755929);
                bVar2.eLk = (TextView) view.findViewById(2131755930);
                bVar2.eLl = (LinearLayout) view.findViewById(2131755927);
                bVar2.eLm = (LinearLayout) view.findViewById(2131755926);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.eLe.setText(gVar.field_title);
            bVar.eLf.setText(o.c(this.eKV, ((long) gVar.field_time) * 1000, true));
            bVar.eLg.setText(gVar.field_description);
            int dimensionPixelSize = this.eKV.getResources().getDimensionPixelSize(2131493372);
            v.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " logo_url :  " + gVar.field_logo_url);
            if (TextUtils.isEmpty(gVar.field_logo_color)) {
                bVar.eLc.setVisibility(8);
                bVar.eLb.setVisibility(0);
                bVar.eLb.setImageResource(2130838736);
                k.a(bVar.eLb, gVar.field_logo_url, dimensionPixelSize, 2130838736, true);
            } else {
                v.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " field_logo_color :  " + gVar.field_logo_color);
                bVar.eLc.setVisibility(0);
                bVar.eLb.setVisibility(8);
                if (TextUtils.isEmpty(gVar.field_logo_url)) {
                    k.a(bVar.eLd, 2130837885, com.tencent.mm.plugin.card.b.j.qv(gVar.field_logo_color));
                } else {
                    k.a(this.eKV, bVar.eLd, gVar.field_logo_url, dimensionPixelSize, com.tencent.mm.plugin.card.b.j.qv(gVar.field_logo_color));
                }
            }
            is aab = gVar.aab();
            if (aab == null || TextUtils.isEmpty(aab.text)) {
                bVar.eLh.setVisibility(8);
            } else {
                bVar.eLh.setText(aab.text);
                bVar.eLh.setTag(gVar);
                bVar.eLh.setVisibility(0);
                bVar.eLh.setOnClickListener(this.eKV.eFl);
            }
            iw aac = gVar.aac();
            if (aac == null || TextUtils.isEmpty(aac.text)) {
                bVar.eLj.setVisibility(8);
                bVar.eLi.setVisibility(8);
            } else {
                bVar.eLk.setText(aac.text);
                bVar.eLj.setVisibility(0);
                bVar.eLj.setOnClickListener(this.eKV.eFl);
                bVar.eLj.setTag(gVar);
                bVar.eLi.setVisibility(0);
            }
            gVar.aad();
            gVar.aae();
            a(gVar.eCS, gVar.eCT, bVar, gVar);
            return view;
        }

        private void a(List<com.tencent.mm.plugin.card.model.g.a> list, List<com.tencent.mm.plugin.card.model.g.b> list2, b bVar, final g gVar) {
            bVar.eLl.removeAllViews();
            if ((list == null || list.size() == 0) && (list2 == null || list2.size() == 0)) {
                bVar.eLm.setVisibility(8);
                return;
            }
            int i;
            View inflate;
            Button button;
            if (!be.bP(list)) {
                for (i = 0; i < list.size(); i++) {
                    final com.tencent.mm.plugin.card.model.g.a aVar = (com.tencent.mm.plugin.card.model.g.a) list.get(i);
                    inflate = View.inflate(this.eKV.nDR.nEl, 2130903198, null);
                    if (i == 0) {
                        inflate.findViewById(2131755707).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(2131755708)).setText(aVar.title);
                    ((TextView) inflate.findViewById(2131755709)).setText(aVar.eCW);
                    button = (Button) inflate.findViewById(2131755710);
                    button.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a eKZ;

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            if (aVar.eCZ == 0) {
                                intent.setClass(this.eKZ.eKV.nDR.nEl, CardDetailUI.class);
                                intent.putExtra("key_card_id", aVar.bns);
                                intent.putExtra("key_card_ext", aVar.eCX);
                                intent.putExtra("key_from_scene", 17);
                                this.eKZ.eKV.startActivity(intent);
                            } else if (aVar.eCZ == 1) {
                                intent.setClass(this.eKZ.eKV.nDR.nEl, CardConsumeSuccessUI.class);
                                intent.putExtra("key_card_id", gVar.field_card_id);
                                intent.putExtra("key_from_scene", 2);
                                this.eKZ.eKV.startActivity(intent);
                            }
                            com.tencent.mm.plugin.report.service.g.iuh.h(11941, new Object[]{Integer.valueOf(8), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, aVar.bns});
                        }
                    });
                    if (aVar.eCZ == 0) {
                        button.setText(2131231574);
                    } else if (aVar.eCZ == 1) {
                        button.setText(2131231575);
                    }
                    bVar.eLl.addView(inflate);
                }
            }
            if (!be.bP(list2)) {
                for (i = 0; i < list2.size(); i++) {
                    final com.tencent.mm.plugin.card.model.g.b bVar2 = (com.tencent.mm.plugin.card.model.g.b) list2.get(i);
                    inflate = View.inflate(this.eKV.nDR.nEl, 2130903198, null);
                    if (i == 0 && be.bP(list)) {
                        inflate.findViewById(2131755707).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(2131755708)).setText(bVar2.title);
                    ((TextView) inflate.findViewById(2131755709)).setText(bVar2.description);
                    button = (Button) inflate.findViewById(2131755710);
                    button.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a eKZ;

                        public final void onClick(View view) {
                            if (TextUtils.isEmpty(bVar2.eDc)) {
                                v.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                            } else {
                                com.tencent.mm.plugin.card.b.b.a(this.eKZ.eKV, bVar2.eDc, 2);
                            }
                        }
                    });
                    button.setText(bVar2.eDb);
                    bVar.eLl.addView(inflate);
                }
            }
            bVar.eLm.setVisibility(0);
        }
    }

    private class b {
        final /* synthetic */ CardNewMsgUI eKV;
        ImageView eLb;
        View eLc;
        ImageView eLd;
        TextView eLe;
        TextView eLf;
        TextView eLg;
        TextView eLh;
        TextView eLi;
        View eLj;
        TextView eLk;
        LinearLayout eLl;
        LinearLayout eLm;

        private b(CardNewMsgUI cardNewMsgUI) {
            this.eKV = cardNewMsgUI;
        }
    }

    static /* synthetic */ void a(CardNewMsgUI cardNewMsgUI, int i) {
        g gVar = (g) cardNewMsgUI.eKR.getItem(i);
        if (gVar != null) {
            if (gVar.field_jump_type == 3) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.O(gVar.field_card_id, false);
                } else if (TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    v.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.O(gVar.field_card_tp_id, false);
                }
            } else if (gVar.field_jump_type == 2) {
                if (TextUtils.isEmpty(gVar.field_url)) {
                    v.e("MicroMsg.CardNewMsgUI", "field_url is null");
                } else {
                    com.tencent.mm.plugin.card.b.b.a((MMActivity) cardNewMsgUI, gVar.field_url, 4);
                }
            } else if (gVar.field_jump_type == 1) {
                v.i("MicroMsg.CardNewMsgUI", "field_jump_type is MM_CARD_ITEM_XML_MSG_JUMP_TYPE_NO");
            } else if (gVar.field_jump_type == 4) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.O(gVar.field_card_id, true);
                } else if (TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    v.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.O(gVar.field_card_tp_id, true);
                }
            }
            int i2 = cardNewMsgUI.getIntent().getBooleanExtra("from_menu", false) ? 7 : 1;
            com.tencent.mm.plugin.report.service.g.iuh.h(11941, new Object[]{Integer.valueOf(i2), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, ""});
        }
    }

    protected final int getLayoutId() {
        return 2130903239;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        af.aao().a((com.tencent.mm.plugin.card.a.i.a) this);
        af.aao().ZZ();
    }

    protected void onDestroy() {
        this.eKR.avc();
        af.aao().b((com.tencent.mm.plugin.card.a.i.a) this);
        if (af.aam().Kw() > 0) {
            af.aam().aaf();
        }
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131231656);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardNewMsgUI eKV;

            {
                this.eKV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eKV.finish();
                return true;
            }
        });
        this.Eq = (ListView) findViewById(2131755934);
        this.eKR = new a(this);
        this.Eq.setAdapter(this.eKR);
        this.Eq.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CardNewMsgUI eKV;

            {
                this.eKV = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == this.eKV.eKR.getCount()) {
                    int i2 = 1;
                    if (af.aam().Kw() > 0) {
                        af.aam().aaf();
                    } else {
                        i2 = this.eKV.eKR.abP();
                    }
                    this.eKV.eKR.a(null, null);
                    if (!this.eKV.eKU) {
                        if (this.eKV.eKS.getParent() != null) {
                            v.d("MicroMsg.CardNewMsgUI", "remove footer");
                            this.eKV.Eq.removeFooterView(this.eKV.eKS);
                        }
                        if (!this.eKV.eKR.abO() && this.eKV.eKT.getParent() == null && r0 > 0) {
                            this.eKV.Eq.addFooterView(this.eKV.eKT);
                            v.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
                        }
                    }
                    this.eKV.eKU = true;
                    this.eKV.eKS.setVisibility(8);
                    return;
                }
                CardNewMsgUI.a(this.eKV, i);
            }
        });
        this.Eq.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ CardNewMsgUI eKV;

            {
                this.eKV = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.ui.base.g.a(this.eKV, this.eKV.getResources().getString(2131231657), null, this.eKV.getResources().getString(2131231020), new c(this.eKV, i) {
                    final /* synthetic */ CardNewMsgUI eKV;

                    public final void gT(int i) {
                        switch (i) {
                            case 0:
                                g gVar = (g) this.eKV.eKR.getItem(r5);
                                if (gVar != null) {
                                    af.aao().pN(gVar.field_msg_id);
                                    this.eKV.aaI();
                                    this.eKV.eKR.a(null, null);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        this.Eq.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ CardNewMsgUI eKV;

            {
                this.eKV = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (this.eKV.eKU && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (af.aam().Kw() > 0) {
                        af.aam().aaf();
                    } else {
                        this.eKV.eKR.abP();
                    }
                    this.eKV.eKR.a(null, null);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.eKR.nDK = new com.tencent.mm.ui.j.a(this) {
            final /* synthetic */ CardNewMsgUI eKV;

            {
                this.eKV = r1;
            }

            public final void Oj() {
            }

            public final void Oi() {
                this.eKV.aaI();
                if (this.eKV.eKR.abO() && af.aam().Kw() == 0) {
                    this.eKV.eKS.setVisibility(8);
                }
            }
        };
        a(0, getString(2131231596), new OnMenuItemClickListener(this) {
            final /* synthetic */ CardNewMsgUI eKV;

            {
                this.eKV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.report.service.g.iuh.h(11582, new Object[]{"CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", ""});
                com.tencent.mm.plugin.card.b.c.a(this.eKV, new com.tencent.mm.plugin.card.b.c.a(this.eKV) {
                    final /* synthetic */ CardNewMsgUI eKV;

                    {
                        this.eKV = r1;
                    }

                    public final void abK() {
                        i aao = af.aao();
                        if (aao.eBB.size() != 0) {
                            List arrayList = new ArrayList();
                            arrayList.addAll(aao.eBB);
                            for (int i = 0; i < arrayList.size(); i++) {
                                g gVar = (g) arrayList.get(i);
                                if (gVar != null) {
                                    aao.eBB.remove(gVar);
                                    i.c(gVar);
                                }
                            }
                            arrayList.clear();
                        }
                        this.eKV.aaI();
                        this.eKV.eKR.a(null, null);
                    }
                });
                return true;
            }
        });
        this.dZV = findViewById(2131755725);
        aaI();
        this.eKS = q.em(this).inflate(2130903236, null);
        this.eKT = q.em(this).inflate(2130903984, null);
        int Kw = af.aam().Kw();
        if (Kw > 0) {
            this.Eq.addFooterView(this.eKS);
        } else if (!this.eKR.abO() && Kw == 0 && af.aam().getCount() > 0) {
            this.Eq.addFooterView(this.eKT);
            this.eKU = true;
        } else if (this.eKR.abO() && Kw == 0) {
            af.aam().getCount();
        }
    }

    private void aaI() {
        i aao = af.aao();
        int size = (aao.eBB == null || aao.eBB.isEmpty()) ? 0 : aao.eBB.size();
        if (size > 0) {
            this.Eq.setVisibility(0);
            this.dZV.setVisibility(8);
            iT(true);
        } else {
            this.Eq.setVisibility(8);
            this.dZV.setVisibility(0);
            iT(false);
        }
        this.eKR.notifyDataSetChanged();
    }

    private void O(String str, boolean z) {
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_is_share_card", z);
        intent.putExtra("key_from_scene", 4);
        startActivity(intent);
    }

    public final void a(g gVar) {
        if ((gVar.field_msg_type & 1) != 0 && (gVar.field_msg_type & 3) != 0) {
            aaI();
            this.eKR.a(null, null);
        }
    }

    public final void Yj() {
    }
}
