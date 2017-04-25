package com.tencent.mm.plugin.order.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.plugin.order.model.f;
import com.tencent.mm.plugin.order.model.h;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI extends WalletBaseUI implements com.tencent.mm.platformtools.j.a {
    private ListView Eq;
    private OnClickListener eFl = new OnClickListener(this) {
        final /* synthetic */ MallOrderDetailInfoUI hOP;

        {
            this.hOP = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == 2131758068) {
                if (this.hOP.hNN.hMD != null) {
                    c.aj(this.hOP, this.hOP.hNN.hMD.gkT);
                    c.a(Boolean.valueOf(this.hOP.hOI), this.hOP.hNN.gcD, this.hOP.hOJ, this.hOP.hNN.hMD.hML, "");
                }
            } else if (view.getId() == 2131758070 || view.getId() == 2131758072) {
                if (this.hOP.hNN.hME != null && this.hOP.hNN.hME.size() > 0) {
                    boolean z;
                    if (TextUtils.isEmpty(((ProductSectionItem) this.hOP.hNN.hME.get(0)).jumpUrl)) {
                        z = false;
                    } else {
                        z = c.aj(this.hOP, ((ProductSectionItem) this.hOP.hNN.hME.get(0)).jumpUrl);
                    }
                    if (!z) {
                        c.ak(this.hOP, ((ProductSectionItem) this.hOP.hNN.hME.get(0)).hOw);
                    }
                    c.a(Boolean.valueOf(this.hOP.hOI), this.hOP.hNN.gcD, this.hOP.hOJ, ((ProductSectionItem) this.hOP.hNN.hME.get(0)).name, "");
                }
            } else if (view.getId() == 2131758071) {
                Bundle bundle = this.hOP.uA;
                bundle.putParcelableArrayList("order_product_list", this.hOP.hNN.hME);
                bundle.putInt("key_enter_id", 0);
                bundle.putString("key_trans_id", this.hOP.hOJ);
                bundle.putString("appname", this.hOP.hNN.gcD);
                com.tencent.mm.wallet_core.a.k(this.hOP, new Bundle());
                c.a(Boolean.valueOf(this.hOP.hOI), this.hOP.hNN.gcD, this.hOP.hOJ, this.hOP.getResources().getString(2131233753), "");
            } else if (view.getId() == 2131758073) {
                String string = this.hOP.uA.getString("key_trans_id");
                Bundle bundle2 = this.hOP.uA;
                bundle2.putString("key_trans_id", string);
                bundle2.putInt("key_enter_id", 1);
                if (this.hOP.hNN != null) {
                    bundle2.putParcelable("transaction_data", this.hOP.hNN.hMC);
                }
                com.tencent.mm.wallet_core.a.k(this.hOP, bundle2);
                c.a(Boolean.valueOf(this.hOP.hOI), this.hOP.hNN.gcD, this.hOP.hOJ, this.hOP.getResources().getString(2131233750), "");
            } else if (view.getId() == 2131758087) {
                g.b(this.hOP, "商家已退全款，总价125元，包含商品价格115元，邮费10元，请确认是否同意通过该处理结果。", this.hOP.getString(2131233738), this.hOP.getString(2131233754), this.hOP.getString(2131233755), new DialogInterface.OnClickListener(this.hOP) {
                    final /* synthetic */ MallOrderDetailInfoUI hOP;

                    {
                        this.hOP = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new DialogInterface.OnClickListener(this.hOP) {
                    final /* synthetic */ MallOrderDetailInfoUI hOP;

                    {
                        this.hOP = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (view.getId() == 2131758078) {
                if (this.hOP.hNN != null && this.hOP.hNN.hMJ != null) {
                    this.hOP.hOz = this.hOP.hNN.hMJ;
                    MallOrderDetailInfoUI.c(this.hOP);
                    c.a(Boolean.valueOf(this.hOP.hOI), this.hOP.hNN.gcD, this.hOP.hOJ, this.hOP.getResources().getString(2131233748), "");
                }
            } else if (view.getId() == 2131758080) {
                e.M(this.hOP, this.hOP.hNN.gcD);
                c.a(Boolean.valueOf(this.hOP.hOI), this.hOP.hNN.gcD, this.hOP.hOJ, this.hOP.getResources().getString(2131233759), "");
            }
        }
    };
    private HashMap<String, View> hLy = new HashMap();
    private List<com.tencent.mm.plugin.order.model.MallOrderDetailObject.a> hMF = new ArrayList();
    protected MallOrderDetailObject hNN = null;
    private a hOA;
    private View hOB;
    private View hOC;
    private View hOD;
    private View hOE;
    private View hOF;
    private View hOG;
    private View hOH;
    private boolean hOI = false;
    private String hOJ = "";
    private boolean hOK = false;
    private int hOL = 0;
    private CheckedTextView hOM;
    private CheckedTextView hON;
    OnClickListener hOO = new OnClickListener(this) {
        final /* synthetic */ MallOrderDetailInfoUI hOP;

        {
            this.hOP = r1;
        }

        public final void onClick(View view) {
            if (this.hOP.hOM != null && this.hOP.hON != null) {
                if (view.getId() == 2131758056) {
                    this.hOP.hOM.setSelected(true);
                    this.hOP.hON.setSelected(false);
                    this.hOP.hOL = 100;
                    return;
                }
                this.hOP.hOM.setSelected(false);
                this.hOP.hON.setSelected(true);
                this.hOP.hOL = -100;
            }
        }
    };
    String hOz;

    private class a extends BaseAdapter {
        final /* synthetic */ MallOrderDetailInfoUI hOP;

        private a(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
            this.hOP = mallOrderDetailInfoUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return nV(i);
        }

        public final int getCount() {
            return this.hOP.hMF.size();
        }

        private com.tencent.mm.plugin.order.model.MallOrderDetailObject.a nV(int i) {
            return (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) this.hOP.hMF.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            com.tencent.mm.plugin.order.model.MallOrderDetailObject.a nV = nV(i);
            View findViewById;
            switch (nV.type) {
                case 1:
                    view = View.inflate(this.hOP, 2130903930, null);
                    findViewById = view.findViewById(2131758052);
                    this.hOP.hOM = (CheckedTextView) view.findViewById(2131758056);
                    this.hOP.hON = (CheckedTextView) view.findViewById(2131758055);
                    this.hOP.hOM.setOnClickListener(this.hOP.hOO);
                    this.hOP.hON.setOnClickListener(this.hOP.hOO);
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.a(findViewById, nV(i + 1));
                        break;
                    }
                    break;
                case 2:
                    view = View.inflate(this.hOP, 2130903929, null);
                    TextView textView = (TextView) view.findViewById(2131758055);
                    findViewById = view.findViewById(2131758052);
                    if (be.getInt(nV.value, 0) >= 0) {
                        textView.setText(2131233743);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131165662, 0);
                    } else {
                        textView.setText(2131233742);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131165658, 0);
                    }
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.a(findViewById, nV(i + 1));
                        break;
                    }
                    break;
                default:
                    b bVar;
                    if (view == null) {
                        view = View.inflate(this.hOP, 2130903928, null);
                        b bVar2 = new b();
                        bVar2.eLe = (TextView) view.findViewById(2131758053);
                        bVar2.eMf = (TextView) view.findViewById(2131758054);
                        bVar2.eMg = (TextView) view.findViewById(2131758050);
                        bVar2.edj = view.findViewById(2131758052);
                        view.setTag(bVar2);
                        bVar = bVar2;
                    } else {
                        bVar = (b) view.getTag();
                    }
                    bVar.eLe.setText(nV.name);
                    if (TextUtils.isEmpty(nV.value)) {
                        bVar.eMf.setVisibility(4);
                    } else {
                        bVar.eMf.setVisibility(0);
                        bVar.eMf.setText(nV.value);
                    }
                    if (nV.eBV) {
                        bVar.eMg.setVisibility(0);
                    } else {
                        bVar.eMg.setVisibility(8);
                    }
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.a(bVar.edj, nV(i + 1));
                        break;
                    }
                    break;
            }
            return view;
        }

        public final int getItemViewType(int i) {
            return nV(i).type;
        }

        public final int getViewTypeCount() {
            return 3;
        }
    }

    private class b {
        TextView eLe;
        TextView eMf;
        TextView eMg;
        View edj;
        final /* synthetic */ MallOrderDetailInfoUI hOP;

        private b(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
            this.hOP = mallOrderDetailInfoUI;
        }
    }

    static /* synthetic */ void c(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        if (!TextUtils.isEmpty(mallOrderDetailInfoUI.hOz)) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + mallOrderDetailInfoUI.hOz));
            intent.addFlags(268435456);
            mallOrderDetailInfoUI.startActivity(intent);
        }
    }

    static /* synthetic */ void d(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        Context context = mallOrderDetailInfoUI;
        g.a(context, "", new String[]{mallOrderDetailInfoUI.getString(2131233756)}, "", false, new g.c(mallOrderDetailInfoUI) {
            final /* synthetic */ MallOrderDetailInfoUI hOP;

            {
                this.hOP = r1;
            }

            public final void gT(int i) {
                switch (i) {
                    case 0:
                        c.ai(this.hOP, this.hOP.hNN.hMI);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903936;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.wallet_core.b ae = com.tencent.mm.wallet_core.a.ae(this);
        if (ae != null && (ae instanceof com.tencent.mm.plugin.order.a.a)) {
            String string = this.uA.getString("key_trans_id");
            this.hOJ = string;
            if (string != null) {
                com.tencent.mm.plugin.order.a.b.aFF();
                if (!com.tencent.mm.plugin.order.a.b.aFI().xB(string)) {
                    this.hOI = false;
                    j(new h(string));
                }
            }
            com.tencent.mm.plugin.order.a.b.aFF();
            if (com.tencent.mm.plugin.order.a.b.aFI().xB(string)) {
                MallOrderDetailObject mallOrderDetailObject;
                this.hOI = true;
                com.tencent.mm.plugin.order.a.b.aFF();
                com.tencent.mm.plugin.order.model.c aFI = com.tencent.mm.plugin.order.a.b.aFI();
                if (TextUtils.isEmpty(string)) {
                    mallOrderDetailObject = null;
                } else {
                    v.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:" + string);
                    mallOrderDetailObject = com.tencent.mm.plugin.order.model.c.a(aFI.xC(string));
                }
                this.hNN = mallOrderDetailObject;
                if (this.hNN == null) {
                    aFR();
                }
            } else {
                v.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
                aFR();
            }
        }
        NI();
    }

    protected final void NI() {
        if (this.hOI) {
            com.tencent.mm.plugin.order.a.b.aFF();
            j xC = com.tencent.mm.plugin.order.a.b.aFI().xC(this.hOJ);
            int intValue = (xC == null || TextUtils.isEmpty(xC.hOk) || !c.qw(xC.hOk)) ? -1 : Integer.valueOf(xC.hOk).intValue();
            if (intValue == 2) {
                vD(2131233745);
            } else if (intValue == 1) {
                vD(2131233746);
            }
        } else {
            vD(2131233747);
        }
        this.hOB = findViewById(2131758068);
        this.hOC = findViewById(2131758069);
        this.hOG = findViewById(2131758070);
        this.hOH = findViewById(2131758071);
        this.hOF = findViewById(2131758072);
        this.hOD = findViewById(2131758073);
        this.hOE = findViewById(2131758074);
        this.hOB.setOnClickListener(this.eFl);
        this.hOH.setOnClickListener(this.eFl);
        this.hOG.setOnClickListener(this.eFl);
        this.hOF.setOnClickListener(this.eFl);
        this.hOD.setOnClickListener(this.eFl);
        findViewById(2131758087).setOnClickListener(this.eFl);
        findViewById(2131758078).setOnClickListener(this.eFl);
        findViewById(2131758080).setOnClickListener(this.eFl);
        this.Eq = (ListView) findViewById(2131758076);
        this.hOA = new a();
        this.Eq.setAdapter(this.hOA);
        this.hOA.notifyDataSetChanged();
        this.Eq.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MallOrderDetailInfoUI hOP;

            {
                this.hOP = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.plugin.order.model.MallOrderDetailObject.a aVar = (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) this.hOP.hMF.get(i);
                if (!TextUtils.isEmpty(aVar.jumpUrl)) {
                    c.aj(this.hOP, aVar.jumpUrl);
                }
                c.a(Boolean.valueOf(this.hOP.hOI), this.hOP.hNN.gcD, this.hOP.hOJ, aVar.name, "");
            }
        });
        aEZ();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (com.tencent.mm.wallet_core.a.ae(this) instanceof com.tencent.mm.plugin.order.a.a) {
            com.tencent.mm.wallet_core.a.ab(this);
        }
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof h) {
            MallOrderDetailObject mallOrderDetailObject = ((h) kVar).hNN;
            v.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:" + mallOrderDetailObject);
            if (mallOrderDetailObject != null) {
                this.hNN = mallOrderDetailObject;
                aEZ();
            }
        }
        return true;
    }

    private void aEZ() {
        if (this.hNN != null) {
            com.tencent.mm.platformtools.j.a(this);
            this.hLy.clear();
            com.tencent.mm.plugin.order.model.MallOrderDetailObject.b bVar = this.hNN.hMD;
            if (bVar != null) {
                CharSequence charSequence;
                String str = bVar.hML;
                if (TextUtils.isEmpty(bVar.hMM)) {
                    Object obj = str;
                } else {
                    charSequence = str + "：" + bVar.hMM;
                }
                if (this.hOI) {
                    this.hOB.setVisibility(8);
                    this.hOC.setVisibility(0);
                    ((TextView) this.hOC.findViewById(2131758085)).setText(charSequence);
                    ((TextView) this.hOC.findViewById(2131758086)).setText(e.yB(this.hNN.hMK));
                    if (TextUtils.isEmpty(bVar.bea) || !e.PR(bVar.bea)) {
                        b((ImageView) this.hOC.findViewById(2131758084));
                    } else {
                        l((ImageView) this.hOC.findViewById(2131758084), bVar.bea);
                    }
                } else {
                    this.hOC.setVisibility(8);
                    this.hOB.setVisibility(0);
                    ((TextView) this.hOB.findViewById(2131758085)).setText(charSequence);
                    ((TextView) this.hOB.findViewById(2131758086)).setText(e.yB(this.hNN.hMK));
                    if (TextUtils.isEmpty(bVar.bea) || !e.PR(bVar.bea)) {
                        b((ImageView) this.hOB.findViewById(2131758084));
                    } else {
                        l((ImageView) this.hOB.findViewById(2131758084), bVar.bea);
                    }
                }
            } else {
                this.hOB.setVisibility(8);
                this.hOC.setVisibility(8);
            }
            List list = this.hNN.hME;
            if (list == null || list.size() == 0) {
                this.hOF.setVisibility(8);
                this.hOG.setVisibility(8);
                this.hOH.setVisibility(8);
            } else if (list.size() == 1) {
                this.hOH.setVisibility(8);
                ProductSectionItem productSectionItem = (ProductSectionItem) list.get(0);
                if (TextUtils.isEmpty(productSectionItem.iconUrl)) {
                    this.hOG.setVisibility(8);
                    this.hOF.setVisibility(0);
                    ((TextView) this.hOF.findViewById(2131758101)).setText(productSectionItem.name);
                    if (TextUtils.isEmpty(productSectionItem.jumpUrl)) {
                        Rect rect = new Rect();
                        rect.set(this.hOF.findViewById(2131758105).getPaddingLeft(), this.hOF.findViewById(2131758105).getPaddingTop(), this.hOF.findViewById(2131758105).getPaddingRight(), this.hOF.findViewById(2131758105).getPaddingBottom());
                        this.hOF.findViewById(2131758105).setBackgroundResource(2130838468);
                        this.hOF.findViewById(2131758105).setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    } else {
                        ((TextView) this.hOF.findViewById(2131758101)).setTextColor(getResources().getColor(2131689863));
                    }
                } else {
                    this.hOF.setVisibility(8);
                    this.hOG.setVisibility(0);
                    ((TextView) this.hOG.findViewById(2131758101)).setText(productSectionItem.name);
                    ((TextView) this.hOG.findViewById(2131758109)).setText(productSectionItem.hOv);
                    ((TextView) this.hOG.findViewById(2131758110)).setText("+" + productSectionItem.count);
                    ((TextView) this.hOG.findViewById(2131758108)).setText(Skus.aS(productSectionItem.hOu));
                    if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                        l((ImageView) this.hOG.findViewById(2131758100), productSectionItem.iconUrl);
                    }
                }
            } else {
                this.hOF.setVisibility(8);
                this.hOG.setVisibility(8);
                this.hOH.setVisibility(0);
                if (list.size() == 2) {
                    a(this.hOH.findViewById(2131758099), (ProductSectionItem) list.get(0));
                    a(this.hOH.findViewById(2131758102), (ProductSectionItem) list.get(1));
                    this.hOH.findViewById(2131758103).setVisibility(8);
                    this.hOH.findViewById(2131758104).setVisibility(8);
                } else if (list.size() == 3) {
                    a(this.hOH.findViewById(2131758099), (ProductSectionItem) list.get(0));
                    a(this.hOH.findViewById(2131758102), (ProductSectionItem) list.get(1));
                    a(this.hOH.findViewById(2131758103), (ProductSectionItem) list.get(2));
                    this.hOH.findViewById(2131758104).setVisibility(8);
                } else if (list.size() >= 4) {
                    a(this.hOH.findViewById(2131758099), (ProductSectionItem) list.get(0));
                    a(this.hOH.findViewById(2131758102), (ProductSectionItem) list.get(1));
                    a(this.hOH.findViewById(2131758103), (ProductSectionItem) list.get(2));
                    a(this.hOH.findViewById(2131758104), (ProductSectionItem) list.get(3));
                }
            }
            MallTransactionObject mallTransactionObject = this.hNN.hMC;
            if (mallTransactionObject != null) {
                this.hOD.setVisibility(0);
                ((TextView) findViewById(2131758075)).setText(e.d(mallTransactionObject.eWz, mallTransactionObject.hNg));
                if (!(this.hNN == null || this.hNN.hMF == null || this.hNN.hMF.size() <= 0)) {
                    a(this.hOE, (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) this.hNN.hMF.get(0));
                }
            } else {
                this.hOD.setVisibility(8);
            }
            Collection collection = this.hNN.hMF;
            if (collection != null) {
                this.hMF.addAll(collection);
                this.hOA.notifyDataSetChanged();
            }
            findViewById(2131758077).setVisibility(0);
            if (this.hNN != null && TextUtils.isEmpty(this.hNN.hMJ) && TextUtils.isEmpty(this.hNN.gcD)) {
                findViewById(2131758077).setVisibility(8);
            } else if (this.hNN != null && !TextUtils.isEmpty(this.hNN.hMJ) && TextUtils.isEmpty(this.hNN.gcD)) {
                findViewById(2131758080).setVisibility(8);
                findViewById(2131758079).setVisibility(8);
                r0 = (TextView) findViewById(2131758078);
                r0.setVisibility(0);
                r0.setGravity(3);
            } else if (!(this.hNN == null || !TextUtils.isEmpty(this.hNN.hMJ) || TextUtils.isEmpty(this.hNN.gcD))) {
                findViewById(2131758078).setVisibility(8);
                findViewById(2131758079).setVisibility(8);
                r0 = (TextView) findViewById(2131758080);
                r0.setVisibility(0);
                r0.setGravity(3);
            }
            if (this.hNN != null && !TextUtils.isEmpty(this.hNN.hMI)) {
                a(0, 2130838681, new OnMenuItemClickListener(this) {
                    final /* synthetic */ MallOrderDetailInfoUI hOP;

                    {
                        this.hOP = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        MallOrderDetailInfoUI.d(this.hOP);
                        return true;
                    }
                });
            }
        }
    }

    private void a(View view, ProductSectionItem productSectionItem) {
        if (view != null && productSectionItem != null) {
            view.setVisibility(0);
            TextView textView = (TextView) view.findViewById(2131758101);
            if (textView != null) {
                textView.setText(productSectionItem.name);
            }
            if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                l((ImageView) view.findViewById(2131758100), productSectionItem.iconUrl);
            }
        }
    }

    private void l(ImageView imageView, String str) {
        if (imageView != null && !TextUtils.isEmpty(str) && e.PR(str)) {
            imageView.setImageBitmap(com.tencent.mm.platformtools.j.a(new com.tencent.mm.plugin.order.c.b(str)));
            this.hLy.put(str, imageView);
        }
    }

    private static void a(View view, com.tencent.mm.plugin.order.model.MallOrderDetailObject.a aVar) {
        if (aVar != null) {
            Rect rect = new Rect();
            rect.left = view.getPaddingLeft();
            rect.right = view.getPaddingRight();
            rect.top = view.getPaddingTop();
            rect.bottom = view.getPaddingBottom();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (aVar == null || !aVar.eBV) {
                view.setBackgroundResource(2130838468);
            } else {
                view.setBackgroundResource(2130838689);
            }
            view.setLayoutParams(layoutParams);
            view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public final void k(String str, Bitmap bitmap) {
        ImageView imageView = (ImageView) this.hLy.get(str);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    private void b(ImageView imageView) {
        Bitmap decodeResource = com.tencent.mm.compatible.f.a.decodeResource(getResources(), 2131165668);
        if (decodeResource != null) {
            imageView.setImageBitmap(d.a(decodeResource, false, 96.0f));
        }
    }

    private void aFQ() {
        if (!this.hOK && this.hOL != 0) {
            ak.vy().a(new f(this.hOJ, "", this.hOL), 0);
            this.hOK = true;
        }
    }

    public void finish() {
        aFQ();
        super.finish();
    }

    public void onDestroy() {
        aFQ();
        super.onDestroy();
    }

    public final void nU(int i) {
        finish();
    }

    private void aFR() {
        g.a(this.nDR.nEl, 2131236242, 0, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ MallOrderDetailInfoUI hOP;

            {
                this.hOP = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.hOP.finish();
            }
        });
    }
}
