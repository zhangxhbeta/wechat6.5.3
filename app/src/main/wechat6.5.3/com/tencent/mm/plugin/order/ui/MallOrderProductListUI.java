package com.tencent.mm.plugin.order.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderProductListUI extends WalletBaseUI {
    private String cps = "";
    private BaseAdapter eGK;
    private String hOJ = "";
    private ListView hOQ;
    private List<ProductSectionItem> hOR = new ArrayList();

    private class a extends BaseAdapter {
        final /* synthetic */ MallOrderProductListUI hOS;

        private a(MallOrderProductListUI mallOrderProductListUI) {
            this.hOS = mallOrderProductListUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return nW(i);
        }

        public final int getCount() {
            return this.hOS.hOR.size();
        }

        private ProductSectionItem nW(int i) {
            return (ProductSectionItem) this.hOS.hOR.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = View.inflate(this.hOS, 2130903948, null);
                b bVar2 = new b();
                bVar2.eLb = (ImageView) view.findViewById(2131758100);
                bVar2.hOT = (TextView) view.findViewById(2131758101);
                bVar2.hOU = (TextView) view.findViewById(2131758108);
                bVar2.hOV = (TextView) view.findViewById(2131758109);
                bVar2.hOW = (TextView) view.findViewById(2131758110);
                bVar2.hOX = (TextView) view.findViewById(2131758107);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            ProductSectionItem nW = nW(i);
            bVar.eBM = nW.iconUrl;
            if (TextUtils.isEmpty(bVar.eBM) || !e.PR(bVar.eBM)) {
                bVar.eLb.setImageResource(2131165661);
            } else {
                bVar.eLb.setImageBitmap(j.a(new com.tencent.mm.plugin.order.c.b(bVar.eBM)));
            }
            bVar.hOT.setText(nW.name);
            bVar.hOU.setText(Skus.aS(nW.hOu));
            bVar.hOV.setText(nW.hOv);
            bVar.hOW.setText("+" + nW.count);
            j.a(bVar);
            bVar.hOX.setVisibility(8);
            return view;
        }
    }

    private class b implements com.tencent.mm.platformtools.j.a {
        String eBM;
        ImageView eLb;
        final /* synthetic */ MallOrderProductListUI hOS;
        TextView hOT;
        TextView hOU;
        TextView hOV;
        TextView hOW;
        TextView hOX;

        private b(MallOrderProductListUI mallOrderProductListUI) {
            this.hOS = mallOrderProductListUI;
        }

        public final void k(String str, final Bitmap bitmap) {
            if (str != null && str.equals(this.eBM)) {
                this.eLb.post(new Runnable(this) {
                    final /* synthetic */ b hOZ;

                    public final void run() {
                        this.hOZ.eLb.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    static /* synthetic */ void a(MallOrderProductListUI mallOrderProductListUI, ProductSectionItem productSectionItem) {
        if (!c.aj(mallOrderProductListUI, productSectionItem.jumpUrl)) {
            c.ak(mallOrderProductListUI, productSectionItem.hOw);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return 2130903947;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oa(0);
        NI();
    }

    @Deprecated
    protected final void NI() {
        vD(2131233753);
        Bundle bundle = this.uA;
        Collection parcelableArrayList = bundle.getParcelableArrayList("order_product_list");
        if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
            this.hOR.clear();
            this.hOR.addAll(parcelableArrayList);
        }
        this.hOJ = bundle.getString("key_trans_id");
        this.cps = bundle.getString("appname");
        this.hOQ = (ListView) findViewById(2131758106);
        this.eGK = new a();
        this.hOQ.setAdapter(this.eGK);
        this.eGK.notifyDataSetChanged();
        this.hOQ.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MallOrderProductListUI hOS;

            {
                this.hOS = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ProductSectionItem productSectionItem = (ProductSectionItem) this.hOS.hOR.get(i);
                if (productSectionItem != null) {
                    MallOrderProductListUI.a(this.hOS, productSectionItem);
                    c.a(Boolean.valueOf(false), this.hOS.cps, this.hOS.hOJ, productSectionItem.name, productSectionItem.hOw);
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
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
}
