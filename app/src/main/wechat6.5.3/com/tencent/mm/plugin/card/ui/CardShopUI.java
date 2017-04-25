package com.tencent.mm.plugin.card.ui;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.card.a.k;
import com.tencent.mm.plugin.card.b.c.AnonymousClass7;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public class CardShopUI extends MMActivity implements com.tencent.mm.plugin.card.a.k.a {
    private ListView Eq;
    private String eAS;
    private b eBg;
    private ArrayList<ix> eBn = new ArrayList();
    private OnClickListener eFl = new OnClickListener(this) {
        final /* synthetic */ CardShopUI eLG;

        {
            this.eLG = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == 2131755989) {
                ix ixVar = (ix) view.getTag();
                if (ixVar != null) {
                    com.tencent.mm.plugin.card.b.b.a(this.eLG, ixVar.bhs, ixVar.biH, ixVar.cJf);
                    g.iuh.h(11941, new Object[]{Integer.valueOf(5), this.eLG.eBg.Zz(), this.eLG.eBg.ZA(), "", ixVar.name});
                }
            }
        }
    };
    private boolean eGy = false;
    private ProgressDialog eLA;
    private String eLB = "";
    private a eLC;
    private LinearLayout eLD;
    private View eLE;
    private TextView eLF;
    BroadcastReceiver esp = new BroadcastReceiver(this) {
        final /* synthetic */ CardShopUI eLG;

        {
            this.eLG = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.LOCALE_CHANGED") && CardShopUI.abU()) {
                this.eLG.abV();
            }
        }
    };

    class a extends BaseAdapter {
        final /* synthetic */ CardShopUI eLG;

        class a {
            public TextView eLH;
            public TextView eLI;
            public TextView eLJ;
            public ImageView eLK;
            public View eLL;
            final /* synthetic */ a eLM;

            a(a aVar) {
                this.eLM = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return jh(i);
        }

        private a(CardShopUI cardShopUI) {
            this.eLG = cardShopUI;
        }

        public final int getCount() {
            return this.eLG.eBn.size();
        }

        private ix jh(int i) {
            return (ix) this.eLG.eBn.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(this.eLG.nDR.nEl, 2130903253, null);
                a aVar2 = new a(this);
                aVar2.eLH = (TextView) view.findViewById(2131755986);
                aVar2.eLI = (TextView) view.findViewById(2131755987);
                aVar2.eLJ = (TextView) view.findViewById(2131755988);
                aVar2.eLK = (ImageView) view.findViewById(2131755990);
                aVar2.eLL = view.findViewById(2131755989);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            ix jh = jh(i);
            if (jh == null) {
                aVar.eLH.setText("");
                aVar.eLI.setText("");
                aVar.eLJ.setText("");
            } else {
                aVar.eLH.setText(jh.name);
                if (jh.mkD <= 0.0f) {
                    aVar.eLI.setVisibility(8);
                } else {
                    aVar.eLI.setText(j.b(this.eLG.getBaseContext(), jh.mkD));
                    aVar.eLI.setVisibility(0);
                }
                aVar.eLJ.setText(jh.bCk + jh.bCl + jh.cJf);
                aVar.eLL.setOnClickListener(this.eLG.eFl);
                aVar.eLL.setTag(jh);
            }
            return view;
        }
    }

    public void onCreate(Bundle bundle) {
        CardShopUI cardShopUI;
        super.onCreate(bundle);
        this.eBg = (b) getIntent().getParcelableExtra("key_card_info_data");
        Object stringExtra = getIntent().getStringExtra("KEY_CARD_TP_ID");
        String stringExtra2 = getIntent().getStringExtra("KEY_CARD_ID");
        if (this.eBg != null) {
            v.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
            this.eLB = this.eBg.ZA();
            stringExtra2 = this.eBg.Zz();
            cardShopUI = this;
        } else {
            if (!TextUtils.isEmpty(stringExtra)) {
                this.eLB = stringExtra;
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = "";
                    cardShopUI = this;
                } else {
                    cardShopUI = this;
                }
            }
            if (TextUtils.isEmpty(this.eLB)) {
                v.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
                finish();
            }
            v.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
            this.eGy = r0;
            if (this.eGy) {
                abT();
            }
            NI();
        }
        cardShopUI.eAS = stringExtra2;
        if (TextUtils.isEmpty(this.eLB)) {
            v.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
            finish();
        }
        v.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.eGy = r0;
        if (this.eGy) {
            abT();
        }
        NI();
    }

    protected final void NI() {
        if (TextUtils.isEmpty(this.eBg.Zv().mlq)) {
            vD(2131231589);
        } else {
            Fd(this.eBg.Zv().mlq);
        }
        this.Eq = (ListView) findViewById(2131755991);
        this.eLD = (LinearLayout) View.inflate(getBaseContext(), 2130903233, null);
        this.Eq.addHeaderView(this.eLD);
        this.eLC = new a();
        this.Eq.setAdapter(this.eLC);
        this.Eq.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CardShopUI eLG;

            {
                this.eLG = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    v.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
                    return;
                }
                if (i > 0) {
                    i--;
                }
                ix ixVar = (ix) this.eLG.eBn.get(i);
                if (!TextUtils.isEmpty(ixVar.eDc)) {
                    com.tencent.mm.plugin.card.b.b.a(this.eLG, ixVar.eDc, 1);
                    g.iuh.h(11941, new Object[]{Integer.valueOf(4), this.eLG.eBg.Zz(), this.eLG.eBg.ZA(), "", ixVar.name});
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardShopUI eLG;

            {
                this.eLG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eLG.finish();
                return true;
            }
        });
        this.eLE = View.inflate(this, 2130903232, null);
        if (this.eLD != null) {
            this.eLD.addView(this.eLE);
        }
        this.eLF = (TextView) this.eLE.findViewById(2131755912);
        this.eLF.setText(2131231698);
        this.eLE.setVisibility(8);
    }

    protected void onDestroy() {
        if (this.eGy) {
            unregisterReceiver(this.esp);
        }
        af.aan().a(this.eLB, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903255;
    }

    public final void a(boolean z, ArrayList<ix> arrayList) {
        if (this.eLA != null) {
            this.eLA.dismiss();
            this.eLA = null;
        }
        String str = "MicroMsg.CardShopUI";
        String str2 = "onGotCardShop, isOk = %b, shop list size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        v.d(str, str2, objArr);
        if (!z) {
            v.e("MicroMsg.CardShopUI", "onGotCardShop fail");
        } else if (arrayList == null || arrayList.size() == 0) {
            v.e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
        } else {
            if (this.eBn != null) {
                this.eBn.clear();
                this.eBn.addAll(arrayList);
                this.eLE.setVisibility(0);
            } else {
                this.eLE.setVisibility(8);
            }
            this.eLC.notifyDataSetChanged();
        }
    }

    private void abT() {
        v.i("MicroMsg.CardShopUI", aq.NAME);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        registerReceiver(this.esp, intentFilter);
        if (abU()) {
            abV();
            return;
        }
        com.tencent.mm.ui.base.g.a(this, getString(2131231767, new Object[]{getString(2131231589)}), getString(2131231164), new AnonymousClass7(this), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private static boolean abU() {
        boolean z;
        if (j.FZ() || j.Ga()) {
            z = false;
        } else {
            z = true;
        }
        return !z;
    }

    private void abV() {
        if (af.aan().a(this.eLB, this.eAS, (com.tencent.mm.plugin.card.a.k.a) this)) {
            ActionBarActivity actionBarActivity = this.nDR.nEl;
            getString(2131231164);
            this.eLA = com.tencent.mm.ui.base.g.a(actionBarActivity, getString(2131231622), true, new OnCancelListener(this) {
                final /* synthetic */ CardShopUI eLG;

                {
                    this.eLG = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    k aan = af.aan();
                    aan.a(this.eLG.eLB, this.eLG);
                    if (aan.eBH != null) {
                        ak.vy().c(aan.eBH);
                    }
                }
            });
            return;
        }
        com.tencent.mm.ui.base.g.bf(this, getString(2131231621));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.CardShopUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case q.CTRL_INDEX /*69*/:
                if (iArr[0] == 0) {
                    v.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.eGy);
                    if (!this.eGy) {
                        this.eGy = true;
                        abT();
                        return;
                    }
                    return;
                }
                com.tencent.mm.ui.base.g.a(this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ CardShopUI eLG;

                    {
                        this.eLG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.eLG.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, null);
                return;
            default:
                return;
        }
    }
}
