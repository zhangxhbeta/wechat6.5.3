package com.tencent.mm.plugin.address.ui;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.al.k;
import com.tencent.mm.e.a.ie;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.c.b;
import com.tencent.mm.plugin.address.model.d;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletSelectAddrUI extends MMActivity implements com.tencent.mm.plugin.address.b.a {
    private TextView dyA = null;
    private Object dyB = new Object();
    private o dyC;
    private boolean dyD = false;
    private boolean dyE = false;
    private h dyF = null;
    private List<b> dyu = new LinkedList();
    private b dyv;
    private a dyw;
    private ListView dyx;
    private com.tencent.mm.plugin.address.b.b dyy = null;
    private View dyz;

    public class a extends BaseAdapter {
        private final Context context;
        List<b> cwd = new ArrayList();
        final /* synthetic */ WalletSelectAddrUI dyG;

        class a {
            TextView dyL;
            ImageView dyM;
            TextView dyN;
            final /* synthetic */ a dyO;

            a(a aVar) {
                this.dyO = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return gU(i);
        }

        public a(WalletSelectAddrUI walletSelectAddrUI, Context context) {
            this.dyG = walletSelectAddrUI;
            this.context = context;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            a aVar2 = new a(this);
            if (view == null) {
                view = View.inflate(this.context, 2130904603, null);
                aVar2.dyM = (ImageView) view.findViewById(2131759769);
                aVar2.dyL = (TextView) view.findViewById(2131759768);
                aVar2.dyN = (TextView) view.findViewById(2131759767);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            b gU = gU(i);
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(gU.dxD)) {
                stringBuilder.append(gU.dxD);
            }
            if (!TextUtils.isEmpty(gU.dxE)) {
                stringBuilder.append(" ");
                stringBuilder.append(gU.dxE);
            }
            if (!TextUtils.isEmpty(gU.dxF)) {
                stringBuilder.append(" ");
                stringBuilder.append(gU.dxF);
            }
            if (!TextUtils.isEmpty(gU.dxH)) {
                stringBuilder.append(" ");
                stringBuilder.append(gU.dxH);
            }
            aVar.dyL.setText(stringBuilder.toString());
            aVar.dyN.setText(gU.dxI + "，" + gU.dxJ);
            if (this.dyG.dyD && this.dyG.dyv != null && this.dyG.dyv.id == gU.id) {
                aVar.dyM.setImageResource(2131165878);
            } else {
                aVar.dyM.setImageBitmap(null);
            }
            return view;
        }

        public final int getCount() {
            return this.cwd.size();
        }

        private b gU(int i) {
            return (b) this.cwd.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI) {
        ak.yW();
        String ma = be.ma((String) c.vf().get(46, null));
        ak.yW();
        String ma2 = be.ma((String) c.vf().get(72, null));
        if (be.kS(ma) && be.kS(ma2)) {
            walletSelectAddrUI.OD();
        } else {
            walletSelectAddrUI.an(ma, ma2);
        }
    }

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI, b bVar) {
        if (bVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(bVar.dxI)) {
                stringBuilder.append(walletSelectAddrUI.getString(2131230864));
                stringBuilder.append("：");
                stringBuilder.append(bVar.dxI);
                stringBuilder.append(" \n");
            }
            if (!TextUtils.isEmpty(bVar.dxJ)) {
                stringBuilder.append(walletSelectAddrUI.getString(2131230869));
                stringBuilder.append("：");
                stringBuilder.append(bVar.dxJ);
                stringBuilder.append(" \n");
            }
            stringBuilder.append(walletSelectAddrUI.getString(2131230875));
            stringBuilder.append("：");
            if (!TextUtils.isEmpty(bVar.dxD)) {
                stringBuilder.append(bVar.dxD);
            }
            if (!TextUtils.isEmpty(bVar.dxE)) {
                stringBuilder.append(bVar.dxE);
            }
            if (!TextUtils.isEmpty(bVar.dxF)) {
                stringBuilder.append(bVar.dxF);
            }
            if (!TextUtils.isEmpty(bVar.dxH)) {
                stringBuilder.append(bVar.dxH);
            }
            if (!TextUtils.isEmpty(bVar.dxG)) {
                stringBuilder.append(" \n");
                stringBuilder.append(walletSelectAddrUI.getString(2131230871));
                stringBuilder.append("：");
                stringBuilder.append(bVar.dxG);
            }
            try {
                ActionBarActivity actionBarActivity = walletSelectAddrUI.nDR.nEl;
                CharSequence stringBuilder2 = stringBuilder.toString();
                if (VERSION.SDK_INT >= 11) {
                    com.tencent.mm.plugin.address.d.b bVar2 = new com.tencent.mm.plugin.address.d.b();
                    ((ClipboardManager) actionBarActivity.getSystemService("clipboard")).setText(stringBuilder2);
                    return;
                }
                com.tencent.mm.plugin.address.d.c cVar = new com.tencent.mm.plugin.address.d.c();
                ((android.text.ClipboardManager) actionBarActivity.getSystemService("clipboard")).setText(stringBuilder2);
            } catch (Throwable e) {
                v.a("MicroMsg.WalletSelectAddrUI", e, "", new Object[0]);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dyy = new com.tencent.mm.plugin.address.b.b(this, this);
        Intent intent = getIntent();
        this.dyE = intent.getBooleanExtra("launch_from_appbrand", false);
        if (intent.getBooleanExtra("launch_from_webview", false) || this.dyE) {
            this.dyD = true;
            this.nDR.dtW.setVisibility(8);
            if (this.dyE) {
                getWindow().setBackgroundDrawableResource(2131689900);
            }
            v.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
            ak.yW();
            if (((Boolean) c.vf().get(com.tencent.mm.storage.t.a.nti, Boolean.valueOf(true))).booleanValue()) {
                v.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
                g.a(this, getString(2131230876), getString(2131230877), getString(2131230747), new OnClickListener(this) {
                    final /* synthetic */ WalletSelectAddrUI dyG;

                    {
                        this.dyG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.nti, Boolean.valueOf(false));
            }
        }
        vD(2131230875);
        this.dyy.gQ(417);
        this.dyy.gQ(416);
        this.dyy.gQ(419);
        this.dyy.gQ(582);
        this.dyy.f(new com.tencent.mm.plugin.address.model.c(intent.getStringExtra("req_url"), intent.getStringExtra("req_app_id"), 2));
        ak.yW();
        this.dyC = new o(be.a((Integer) c.vf().get(9, null), 0));
        NI();
        ak.yW();
        if (c.isSDCardAvailable()) {
            ak.vy().a(new k(12), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.dyy.gR(417);
        this.dyy.gR(416);
        this.dyy.gR(419);
        this.dyy.gR(582);
    }

    public void onResume() {
        super.onResume();
        OC();
    }

    private void OC() {
        synchronized (this.dyB) {
            com.tencent.mm.plugin.address.a.a.Op();
            this.dyu = com.tencent.mm.plugin.address.a.a.Oq().dxq.dxB;
            this.dyw.cwd = this.dyu;
            this.dyu.size();
            this.dyz.setVisibility(8);
            this.dyw.notifyDataSetChanged();
        }
    }

    public final void NI() {
        this.dyA = (TextView) findViewById(2131759772);
        if (this.dyC.longValue() > 0) {
            ak.yW();
            ((Boolean) c.vf().get(196657, Boolean.valueOf(false))).booleanValue();
        }
        this.dyA.setVisibility(8);
        this.dyA.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletSelectAddrUI dyG;

            {
                this.dyG = r1;
            }

            public final void onClick(View view) {
                g.a(this.dyG, true, this.dyG.getString(2131233729, new Object[]{this.dyG.dyC.toString()}), "", this.dyG.getString(2131233730), this.dyG.getString(2131231010), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 dyH;

                    {
                        this.dyH = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WalletSelectAddrUI.b(this.dyH.dyG);
                    }
                }, null);
            }
        });
        this.dyx = (ListView) findViewById(2131759770);
        this.dyw = new a(this, this);
        this.dyz = findViewById(2131759771);
        this.dyz.findViewById(2131759768).setVisibility(8);
        ((TextView) this.dyz.findViewById(2131759767)).setText(2131230831);
        this.dyx.setAdapter(this.dyw);
        this.dyx.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletSelectAddrUI dyG;

            {
                this.dyG = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                v.d("MicroMsg.WalletSelectAddrUI", "select pos " + i);
                synchronized (this.dyG.dyB) {
                    if (i < this.dyG.dyu.size()) {
                        this.dyG.dyv = (b) this.dyG.dyu.get(i);
                        if (!this.dyG.dyD && this.dyG.dyv != null) {
                            this.dyG.gS(this.dyG.dyv.id);
                        } else if (!(this.dyG.dyv == null || this.dyG.dyv.id == 0)) {
                            this.dyG.dyy.f(new e(this.dyG.dyv.id));
                        }
                    }
                }
                this.dyG.dyw.notifyDataSetChanged();
            }
        });
        this.dyx.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ WalletSelectAddrUI dyG;

            {
                this.dyG = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                g.a(this.dyG.nDR.nEl, null, this.dyG.getResources().getStringArray(2131296268), null, new g.c(this) {
                    final /* synthetic */ AnonymousClass5 dyI;

                    public final void gT(int i) {
                        b bVar;
                        synchronized (this.dyI.dyG.dyB) {
                            if (i < this.dyI.dyG.dyu.size()) {
                                bVar = (b) this.dyI.dyG.dyu.get(i);
                            } else {
                                bVar = null;
                            }
                        }
                        if (bVar != null) {
                            switch (i) {
                                case 0:
                                    this.dyI.dyG.gS(bVar.id);
                                    return;
                                case 1:
                                    d dVar = new d(bVar.id);
                                    this.dyI.dyG.dyv = null;
                                    this.dyI.dyG.dyy.f(dVar);
                                    return;
                                case 2:
                                    WalletSelectAddrUI.b(this.dyI.dyG, bVar);
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                });
                return true;
            }
        });
        OC();
        this.dyz.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletSelectAddrUI dyG;

            {
                this.dyG = r1;
            }

            public final void onClick(View view) {
                this.dyG.gS(0);
            }
        });
        this.dyw.notifyDataSetChanged();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletSelectAddrUI dyG;

            {
                this.dyG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.dyG.setResult(0);
                this.dyG.finish();
                return true;
            }
        });
        a(0, 2131230833, 2131165188, new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletSelectAddrUI dyG;

            {
                this.dyG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.dyG.gS(0);
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130904604;
    }

    public final void e(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        this.dyy.a(i, i2, str, kVar);
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 417) {
                if (((com.tencent.mm.plugin.address.model.c) kVar).dxk) {
                    OC();
                    this.nDR.dtW.setVisibility(0);
                    if (this.dyD && this.dyu.size() == 0) {
                        Intent intent = new Intent();
                        intent.setClass(this, WalletAddAddressUI.class);
                        startActivityForResult(intent, 1);
                    }
                }
            } else if (kVar.getType() == 416) {
                d dVar = (d) kVar;
                com.tencent.mm.plugin.address.a.a.Op();
                b gP = com.tencent.mm.plugin.address.a.a.Oq().gP(dVar.dxl);
                if (gP != null) {
                    com.tencent.mm.plugin.address.a.a.Op();
                    v.d("MicroMsg.WalletSelectAddrUI", "delte addr " + com.tencent.mm.plugin.address.a.a.Oq().a(gP));
                }
                OC();
            } else if (kVar.getType() == 419) {
                if (this.dyv != null) {
                    setResult(-1, com.tencent.mm.plugin.address.d.a.b(this.dyv));
                    finish();
                }
            } else if (kVar.getType() == 582) {
                String string = getString(2131233732);
                switch (((com.tencent.mm.plugin.address.model.b) kVar).status) {
                    case 0:
                        ak.yW();
                        c.vf().set(196657, Boolean.valueOf(true));
                        this.dyA.setVisibility(8);
                        OC();
                        this.nDR.dtW.setVisibility(0);
                        string = getString(2131233734);
                        break;
                    case 1:
                    case 2:
                        ak.yW();
                        c.vf().set(196657, Boolean.valueOf(true));
                        this.dyA.setVisibility(8);
                        string = getString(2131233733);
                        break;
                    case 3:
                        OD();
                        return;
                }
                if (this.dyF != null) {
                    this.dyF.dismiss();
                }
                this.dyF = g.a(this, string, null, true, null);
            }
        } else if (kVar.getType() == 419 && i2 == -3103) {
            g.a(this, true, str, "", getString(2131230837), getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ WalletSelectAddrUI dyG;

                {
                    this.dyG = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.dyG.gS(this.dyG.dyv.id);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletSelectAddrUI dyG;

                {
                    this.dyG = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

    private void an(String str, String str2) {
        this.dyy.f(new com.tencent.mm.plugin.address.model.b(str, str2, this.dyC));
    }

    private void OD() {
        final ie ieVar = new ie();
        ieVar.bih.bij = this;
        ieVar.bih.bik = new Runnable(this) {
            final /* synthetic */ WalletSelectAddrUI dyG;

            public final void run() {
                this.dyG.dyx.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass9 dyK;

                    {
                        this.dyK = r1;
                    }

                    public final void run() {
                        if (ieVar.bii.aYN) {
                            ak.yW();
                            String ma = be.ma((String) c.vf().get(46, null));
                            ak.yW();
                            this.dyK.dyG.an(ma, be.ma((String) c.vf().get(72, null)));
                        }
                    }
                });
            }
        };
        com.tencent.mm.sdk.c.a.nhr.a(ieVar, Looper.myLooper());
    }

    private void gS(int i) {
        Intent intent = new Intent();
        intent.setClass(this, WalletAddAddressUI.class);
        intent.putExtra("address_id", i);
        startActivity(intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (-1 == i2) {
                b bVar;
                if (intent == null) {
                    v.e("MicroMsg.AddrUtil", "intent == null");
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.dxK = intent.getStringExtra("nationalCode");
                    bVar.dxI = intent.getStringExtra("userName");
                    bVar.dxJ = intent.getStringExtra("telNumber");
                    bVar.dxG = intent.getStringExtra("addressPostalCode");
                    bVar.dxD = intent.getStringExtra("proviceFirstStageName");
                    bVar.dxE = intent.getStringExtra("addressCitySecondStageName");
                    bVar.dxF = intent.getStringExtra("addressCountiesThirdStageName");
                    bVar.dxH = intent.getStringExtra("addressDetailInfo");
                }
                setResult(-1, com.tencent.mm.plugin.address.d.a.b(bVar));
            } else {
                setResult(0);
            }
            finish();
        }
    }
}
