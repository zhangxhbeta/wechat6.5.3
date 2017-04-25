package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.model.d;
import com.tencent.mm.plugin.recharge.ui.MallEditText.b;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.qr;
import com.tencent.mm.protocal.c.wx;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI extends MMActivity implements com.tencent.mm.platformtools.j.a, b, e {
    protected Dialog dxy = null;
    private Button fzj = null;
    private boolean hRZ = false;
    private c hSc = new c<qp>(this) {
        final /* synthetic */ RechargeUI iok;

        {
            this.iok = r2;
            this.nhz = qp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            qp qpVar = (qp) bVar;
            if (qpVar instanceof qp) {
                if (qpVar.bsg.bpc != -1) {
                    v.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
                } else if (!this.iok.hRZ) {
                    v.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                    com.tencent.mm.plugin.recharge.a.a.aJi().a(this.iok.inX.aJl());
                    this.iok.finish();
                    this.iok.hRZ = true;
                }
                return true;
            }
            v.f("MicroMsg.MallRechargeUI", "mismatched event");
            return false;
        }
    };
    private MallFunction inD = null;
    private TextView inN = null;
    private TextView inO = null;
    private TextView inP = null;
    private TextView inQ = null;
    private FrameLayout inR = null;
    private ImageView inS = null;
    private ImageView inT = null;
    private LinearLayout inU = null;
    private a inV = null;
    private a inW = null;
    private MallEditText inX;
    private TextView inY;
    private int inZ;
    private MallRechargeProduct ioa = null;
    private String iob = null;
    private MallNews ioc = null;
    private boolean iod = false;
    private boolean ioe = true;
    private Map<String, Integer> iof = new HashMap();
    private String iog;
    public String ioh;
    private String ioi;
    public String ioj;

    private class a extends BaseAdapter {
        private List<MallRechargeProduct> imx;
        final /* synthetic */ RechargeUI iok;

        private a(RechargeUI rechargeUI) {
            this.iok = rechargeUI;
            this.imx = null;
        }

        public final /* synthetic */ Object getItem(int i) {
            return oK(i);
        }

        public final void bf(List<MallRechargeProduct> list) {
            this.imx = list;
            notifyDataSetChanged();
        }

        public final void oJ(int i) {
            for (int i2 = 0; i2 < this.imx.size(); i2++) {
                ((MallRechargeProduct) this.imx.get(i2)).isDefault = false;
            }
            ((MallRechargeProduct) this.imx.get(i)).isDefault = true;
        }

        public final int getCount() {
            return this.imx == null ? 0 : this.imx.size();
        }

        public final MallRechargeProduct oK(int i) {
            return (MallRechargeProduct) this.imx.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            if (oK(i).isValid()) {
                return super.isEnabled(i);
            }
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.iok, 2130904250, null);
            MallRechargeProduct oK = oK(i);
            checkedTextView.setText(oK.fkg);
            checkedTextView.setEnabled(oK.isValid());
            if (oK.isDefault) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            return checkedTextView;
        }
    }

    static /* synthetic */ boolean c(RechargeUI rechargeUI) {
        if (rechargeUI.inX.aJl().aYX != 0) {
            return true;
        }
        RechargeUI rechargeUI2 = rechargeUI;
        g.b(rechargeUI2, rechargeUI.getString(2131233797, new Object[]{rechargeUI.inX.getText().toString()}), "", rechargeUI.getString(2131231183), rechargeUI.getString(2131231104), new OnClickListener(rechargeUI) {
            final /* synthetic */ RechargeUI iok;

            {
                this.iok = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.iok.l(new com.tencent.mm.plugin.recharge.model.g(this.iok.ioa, this.iok.aJp()));
            }
        }, null);
        return false;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                final int color = getResources().getColor(2131690113);
                final int color2 = getResources().getColor(2131690123);
                View inflate = getLayoutInflater().inflate(2130904249, null);
                final TextView textView = (TextView) inflate.findViewById(2131758828);
                final ListView listView = (ListView) inflate.findViewById(2131758829);
                final ListView listView2 = (ListView) inflate.findViewById(2131758830);
                final TextView textView2 = (TextView) inflate.findViewById(2131758822);
                final View findViewById = inflate.findViewById(2131758823);
                final TextView textView3 = (TextView) inflate.findViewById(2131758825);
                final View findViewById2 = inflate.findViewById(2131758826);
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(2131758827);
                LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.height = (getResources().getDimensionPixelSize(2131493179) * this.inZ) + 4;
                relativeLayout.setLayoutParams(layoutParams);
                listView.setAdapter(this.inV);
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ RechargeUI iok;

                    {
                        this.iok = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.iok.dismissDialog(1);
                        v.d("MicroMsg.MallRechargeUI", "onItemClick : " + i);
                        v.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.iok.ioa);
                        this.iok.ioa = this.iok.inV.oK(i);
                        this.iok.inV.oJ(i);
                        this.iok.inV.notifyDataSetChanged();
                        v.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.iok.ioa);
                        this.iok.av();
                    }
                });
                listView2.setAdapter(this.inW);
                listView2.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ RechargeUI iok;

                    {
                        this.iok = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.iok.dismissDialog(1);
                        v.d("MicroMsg.MallRechargeUI", "onItemClick : " + i);
                        this.iok.ioa = this.iok.inW.oK(i);
                        this.iok.inW.oJ(i);
                        this.iok.inW.notifyDataSetChanged();
                        this.iok.iof.remove(RechargeUI.r(this.iok.ioa.imt, this.iok.ioa.aZD, this.iok.aJq()));
                        this.iok.Ox();
                        this.iok.av();
                    }
                });
                inflate.findViewById(2131758821).setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ RechargeUI iok;

                    public final void onClick(View view) {
                        findViewById.setVisibility(0);
                        textView2.setTextColor(color2);
                        listView.setVisibility(0);
                        findViewById2.setVisibility(8);
                        textView3.setTextColor(color);
                        listView2.setVisibility(8);
                        if (this.iok.inV.getCount() == 0) {
                            textView.setVisibility(0);
                        } else {
                            textView.setVisibility(8);
                        }
                    }
                });
                final View view = findViewById2;
                final TextView textView4 = textView3;
                final int i2 = color2;
                final ListView listView3 = listView2;
                final View view2 = findViewById;
                final TextView textView5 = textView2;
                final int i3 = color;
                final ListView listView4 = listView;
                final TextView textView6 = textView;
                inflate.findViewById(2131758824).setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ RechargeUI iok;

                    public final void onClick(View view) {
                        view.setVisibility(0);
                        textView4.setTextColor(i2);
                        listView3.setVisibility(0);
                        view2.setVisibility(8);
                        textView5.setTextColor(i3);
                        listView4.setVisibility(8);
                        if (this.iok.inW.getCount() == 0) {
                            textView6.setVisibility(0);
                        } else {
                            textView6.setVisibility(8);
                        }
                    }
                });
                if (this.inV.getCount() == 0) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this);
                aVar.Op(null);
                aVar.cC(inflate);
                aVar.c(null);
                return aVar.RX();
            default:
                return g.A(this, getString(2131233801), "");
        }
    }

    protected final int getLayoutId() {
        return 2130904253;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.inD = (MallFunction) intent.getParcelableExtra("key_func_info");
        List parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_product_list");
        this.ioe = !intent.getBooleanExtra("key_is_hide_progress", false);
        if (this.inD == null) {
            v.e("MicroMsg.MallRechargeUI", "function info is null");
            s.makeText(this, "function info is null", 1).show();
            return;
        }
        if (parcelableArrayListExtra == null) {
            v.d("MicroMsg.MallRechargeUI", "function info : " + this.inD.bpZ);
            l(new com.tencent.mm.plugin.recharge.model.e(this.inD.imm));
        } else {
            this.ioa = a.bd(parcelableArrayListExtra);
        }
        v.i("MicroMsg.MallRechargeUI", "onCreate()");
        this.ioc = com.tencent.mm.plugin.wallet_core.model.mall.c.bgL().Dh(this.inD.imm);
        NI();
    }

    protected final void NI() {
        Fd(this.inD.bpZ);
        vE(2131236646);
        v.v("MicroMsg.MallRechargeUI", "initView");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RechargeUI iok;

            {
                this.iok = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iok.axg();
                this.iok.finish();
                return true;
            }
        });
        this.inN = (TextView) findViewById(2131758647);
        this.inO = (TextView) findViewById(2131758840);
        this.inP = (TextView) findViewById(2131758839);
        this.fzj = (Button) findViewById(2131756365);
        this.inU = (LinearLayout) findViewById(2131758837);
        this.inQ = (TextView) findViewById(2131758841);
        this.inQ.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI iok;

            {
                this.iok = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.iok.ioi);
                com.tencent.mm.ay.c.b(this.iok, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        this.fzj.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI iok;

            {
                this.iok = r1;
            }

            public final void onClick(View view) {
                if (this.iok.Ox() && RechargeUI.c(this.iok)) {
                    this.iok.l(new com.tencent.mm.plugin.recharge.model.g(this.iok.ioa, this.iok.aJp()));
                }
            }
        });
        this.inX = (MallEditText) findViewById(2131758836);
        this.inX.dxQ.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI iok;

            {
                this.iok = r1;
            }

            public final void onClick(View view) {
                if (this.iok.inX.imQ) {
                    this.iok.inX.b(null);
                    return;
                }
                this.iok.startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 1);
            }
        });
        this.inY = (TextView) findViewById(2131758838);
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_product_list");
        List c = c(0, parcelableArrayListExtra);
        List c2 = c(2, parcelableArrayListExtra);
        this.inZ = c.size() > c2.size() ? c.size() : c2.size();
        this.inV = new a();
        this.inV.bf(c);
        this.inW = new a();
        this.inW.bf(c2);
        this.inU.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI iok;

            {
                this.iok = r1;
            }

            public final void onClick(View view) {
                if ((this.iok.inV != null && this.iok.inV.getCount() > 0) || (this.iok.inW != null && this.iok.inW.getCount() > 0)) {
                    this.iok.showDialog(1);
                }
            }
        });
        this.inR = (FrameLayout) findViewById(2131758833);
        this.inS = (ImageView) findViewById(2131758834);
        this.inT = (ImageView) findViewById(2131758835);
        this.inT.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI iok;

            {
                this.iok = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.wallet_core.model.mall.c bgL = com.tencent.mm.plugin.wallet_core.model.mall.c.bgL();
                String str = this.iok.inD.imm;
                v.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : " + str);
                if (!be.kS(str) && bgL.kRx.containsKey(str)) {
                    MallNews mallNews = (MallNews) bgL.kRx.get(str);
                    if ("1".equals(mallNews.kRl)) {
                        mallNews.kRl = "2";
                        bgL.aGr();
                    }
                }
                this.iok.inR.setVisibility(8);
            }
        });
        this.inR.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI iok;

            {
                this.iok = r1;
            }

            public final void onClick(View view) {
                if (!be.kS(this.iok.inD.kRg.kRp)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.iok.inD.kRg.kRp);
                    intent.putExtra("geta8key_username", k.xF());
                    com.tencent.mm.ay.c.b(this.iok, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            }
        });
        this.inX.imO = this;
        this.inX.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI iok;

            {
                this.iok = r1;
            }

            public final void onClick(View view) {
                this.iok.inX.imP.findFocus();
                if (this.iok.inX.aJl().aYX == 2) {
                    this.iok.inX.b(null);
                }
                if (be.kS(this.iok.inX.getText().toString())) {
                    this.iok.inX.imP.showDropDown();
                }
                this.iok.aJs();
            }
        });
        aJm();
        j.a(this);
        av();
    }

    private void av() {
        v.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.ioa);
        if (this.ioa != null) {
            CharSequence string;
            this.inY.setText(this.ioa.fkg);
            TextView textView = this.inP;
            MallRechargeProduct mallRechargeProduct = this.ioa;
            if (!mallRechargeProduct.isValid()) {
                string = getString(2131233799);
            } else if (mallRechargeProduct.imo != mallRechargeProduct.imp || (aJr() && this.ioa.imu)) {
                string = "";
            } else {
                string = String.format(getString(2131233802), new Object[]{Float.valueOf(mallRechargeProduct.imo)});
            }
            textView.setText(string);
        }
        if (this.ioc != null && this.inD.kRg != null && this.ioc.equals(this.inD.kRg) && !"1".equals(this.ioc.kRl)) {
            this.inR.setVisibility(8);
            v.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.ioc.toString());
        } else if (this.inD.kRg == null || be.kS(this.inD.kRg.kRq)) {
            this.inR.setVisibility(8);
            v.d("MicroMsg.MallRechargeUI", "dismiss banner!");
        } else {
            this.iob = this.inD.kRg.kRq;
            this.inS.setImageBitmap(j.a(new com.tencent.mm.plugin.recharge.b.a(this.iob)));
            this.inR.setVisibility(0);
            v.d("MicroMsg.MallRechargeUI", "Show banner!");
        }
        this.inO.setVisibility(4);
        if (!Ox()) {
            this.inN.setText("");
        } else if (!(this.ioa == null || aJr())) {
            this.inN.setText(this.ioa.imn);
            this.inN.setTextColor(getResources().getColor(2131689792));
        }
        String string2 = getString(2131233794);
        if (!TextUtils.isEmpty(this.ioh)) {
            string2 = this.ioh;
        }
        if (!be.kS(this.iog)) {
            a(0, string2, new OnMenuItemClickListener(this) {
                final /* synthetic */ RechargeUI iok;

                {
                    this.iok = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.iok.iog);
                    com.tencent.mm.ay.c.b(this.iok, "webview", ".ui.tools.WebViewUI", intent);
                    return true;
                }
            });
        }
        if (be.kS(this.ioi)) {
            this.inQ.setVisibility(8);
        } else {
            this.inQ.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.ioj)) {
            this.inQ.setText(this.ioj);
        }
    }

    private static List<MallRechargeProduct> c(int i, List<MallRechargeProduct> list) {
        List<MallRechargeProduct> arrayList = new ArrayList();
        if (list != null) {
            boolean z = false;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.imt == i) {
                    arrayList.add(mallRechargeProduct);
                    if (mallRechargeProduct.isDefault) {
                        if (z) {
                            mallRechargeProduct.isDefault = false;
                        }
                        z = true;
                    }
                }
            }
            if (!z && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
        }
        return arrayList;
    }

    private void l(final com.tencent.mm.v.k kVar) {
        if (kVar.getType() == 497 || kVar.getType() == 1555) {
            ak.vy().a(kVar, 0);
        } else if (this.ioe) {
            if (this.dxy == null || !(this.dxy == null || this.dxy.isShowing())) {
                this.dxy = com.tencent.mm.wallet_core.ui.g.a(this.nDR.nEl, true, new OnCancelListener(this) {
                    final /* synthetic */ RechargeUI iok;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(kVar);
                    }
                });
            }
            ak.vy().a(kVar, 0);
        } else {
            ak.vy().a(kVar, 0);
        }
    }

    private boolean Ox() {
        boolean z;
        MallEditText mallEditText = this.inX;
        if (mallEditText.getVisibility() == 0) {
            if (be.kS(mallEditText.getText())) {
                v.d("MicroMsg.MallEditText", "View:" + mallEditText.dxS + ", editType:" + mallEditText.dxT + " checkInputValid : empty ");
                z = false;
            } else if (!mallEditText.dxX) {
                v.d("MicroMsg.MallEditText", "View:" + mallEditText.dxS + ", editType:" + mallEditText.dxT + " checkInputValid : illegal ");
                z = false;
            }
            if (z) {
                z = false;
            } else {
                z = true;
            }
            if (z || this.ioa == null || !this.ioa.isValid()) {
                if (!(this.iod || z || this.ioa == null)) {
                    this.ioa.isValid();
                }
                this.fzj.setEnabled(false);
                this.fzj.setClickable(false);
                v.d("MicroMsg.MallRechargeUI", "checkInfo : false");
                return false;
            }
            if (aJr() && this.ioa.imu) {
                l(new d(this.ioa.imt, this.inD.imm, this.ioa.aZD, this.ioa.appId, aJp(), aJq()));
            }
            axg();
            this.fzj.setEnabled(true);
            this.fzj.setClickable(true);
            v.d("MicroMsg.MallRechargeUI", "checkInfo : true");
            return true;
        }
        z = true;
        if (z) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
        }
        this.ioa.isValid();
        this.fzj.setEnabled(false);
        this.fzj.setClickable(false);
        v.d("MicroMsg.MallRechargeUI", "checkInfo : false");
        return false;
    }

    private String aJp() {
        return "mobile=" + com.tencent.mm.plugin.recharge.model.b.yt(this.inX.getText());
    }

    private String aJq() {
        return com.tencent.mm.plugin.recharge.model.b.yt(this.inX.getText());
    }

    private static String r(int i, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("-");
        stringBuilder.append(str);
        stringBuilder.append("-");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private boolean aJr() {
        return !this.iof.containsKey(r(this.ioa.imt, this.ioa.aZD, aJq()));
    }

    public final void fc(boolean z) {
        if (!z) {
            this.iof.clear();
            this.inN.setText("");
            this.inO.setVisibility(4);
        }
        Ox();
    }

    public final void aJm() {
        if (be.kS(this.inX.getText()) || this.inX.Ou()) {
            this.inX.oG(2130839037);
        } else {
            this.inX.oG(2130838465);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + i + ", errCode = " + i2);
        if (!(this.dxy == null || !this.dxy.isShowing() || kVar.getType() == 497)) {
            this.dxy.dismiss();
            this.dxy = null;
        }
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.recharge.model.e) {
                com.tencent.mm.plugin.recharge.model.e eVar = (com.tencent.mm.plugin.recharge.model.e) kVar;
                List list = eVar.imz;
                if (list != null) {
                    this.ioa = a.bd(list);
                    v.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.ioa);
                }
                this.iog = eVar.imA;
                this.ioh = eVar.imB;
                this.ioi = eVar.imC;
                this.ioj = eVar.imD;
                v.d("MicroMsg.MallRechargeUI", "mProductList " + list);
                av();
                List c = c(0, list);
                List c2 = c(2, list);
                this.inZ = c.size() > c2.size() ? c.size() : c2.size();
                this.inV.bf(c);
                this.inW.bf(c2);
            } else if (kVar instanceof d) {
                v.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.ioa);
                d dVar = (d) kVar;
                if (!(this.ioa == null || this.ioa.aZD == null || dVar.imw == null || ((!this.ioa.aZD.equals(dVar.imw.aZD) || !aJq().equals(dVar.dwA)) && dVar.imt == 2))) {
                    MallRechargeProduct.a(dVar.imw, this.ioa);
                    this.ioa.isDefault = true;
                    this.iof.put(r(dVar.imt, dVar.imw.aZD, dVar.dwA), Integer.valueOf(1));
                    av();
                    this.inO.setText(str);
                    this.inO.setVisibility(0);
                    this.inO.setTextColor(getResources().getColor(2131689768));
                }
                if (dVar.imt == 2) {
                    if (this.ioa == null || !this.ioa.aZD.equals(dVar.imy) || !aJq().equals(dVar.dwA)) {
                        this.fzj.setEnabled(true);
                        this.fzj.setClickable(true);
                        this.inO.setText(null);
                    } else if (((wx) dVar.cif.czl.czs).muz == 0 && this.ioa.aZD.equals(dVar.imw.aZD)) {
                        l(new com.tencent.mm.plugin.recharge.model.c(this.ioa.imm, aJq(), this.ioa.fkg, this.ioa.appId, aJp()));
                    } else {
                        this.fzj.setEnabled(false);
                        this.fzj.setClickable(false);
                        this.inO.setText(((wx) dVar.cif.czl.czs).muA);
                        this.inO.setVisibility(0);
                        this.inO.setTextColor(getResources().getColor(2131689960));
                    }
                }
                be(dVar.imx);
                v.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.ioa);
            } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.g) {
                PayInfo payInfo = ((com.tencent.mm.plugin.recharge.model.g) kVar).imN;
                payInfo.bkq = 6;
                payInfo.lVy = 100;
                com.tencent.mm.pluginsdk.wallet.e.a(this, payInfo, 2);
                com.tencent.mm.sdk.c.a.nhr.e(this.hSc);
            } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.c) {
                com.tencent.mm.plugin.recharge.model.c cVar = (com.tencent.mm.plugin.recharge.model.c) kVar;
                if (this.ioa == null || !this.ioa.fkg.equals(cVar.fkg) || !aJq().equals(cVar.bhT)) {
                    this.fzj.setEnabled(true);
                    this.fzj.setClickable(true);
                    this.inO.setText(null);
                } else if (((qr) cVar.cif.czl.czs).muz != 0) {
                    this.fzj.setEnabled(false);
                    this.fzj.setClickable(false);
                    this.inO.setText(((qr) cVar.cif.czl.czs).muA);
                    this.inO.setVisibility(0);
                    this.inO.setTextColor(getResources().getColor(2131689960));
                }
            }
        } else if (!(kVar instanceof com.tencent.mm.plugin.recharge.model.c)) {
            if (kVar instanceof d) {
                if (i2 == 100) {
                    this.fzj.setEnabled(true);
                    this.fzj.setClickable(true);
                } else {
                    this.fzj.setEnabled(false);
                    this.fzj.setClickable(false);
                }
                be(((d) kVar).imx);
                this.inO.setText(str);
                this.inO.setVisibility(0);
                this.inO.setTextColor(getResources().getColor(2131689960));
                this.inN.setText(((d) kVar).imn);
                this.inN.setTextColor(getResources().getColor(2131689960));
                return;
            }
            if (be.kS(str)) {
                str = getString(2131236492);
            }
            g.a(this, str, null, false, new OnClickListener(this) {
                final /* synthetic */ RechargeUI iok;

                {
                    this.iok = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(496, this);
        ak.vy().a(497, this);
        ak.vy().a(498, this);
        ak.vy().a(1555, this);
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b(496, this);
        ak.vy().b(497, this);
        ak.vy().b(498, this);
        ak.vy().b(1555, this);
    }

    private void be(List<MallRechargeProduct> list) {
        if (list != null) {
            List arrayList = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.imt == 2) {
                    if (this.ioa != null && mallRechargeProduct.aZD.equals(this.ioa.aZD)) {
                        mallRechargeProduct.isDefault = true;
                        i = true;
                    }
                    arrayList.add(mallRechargeProduct);
                }
            }
            if (i == 0 && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
            this.inW.bf(arrayList);
            return;
        }
        this.inW.bf(new ArrayList());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data != null) {
                        if (com.tencent.mm.pluginsdk.i.a.aP(this, "android.permission.READ_CONTACTS")) {
                            String str2;
                            Cursor query = getContentResolver().query(data, null, null, null, null);
                            if (query != null && query.getCount() > 0) {
                                query.moveToFirst();
                                int columnIndex = query.getColumnIndex("has_phone_number");
                                if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                    Cursor query2 = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + query.getString(query.getColumnIndex("_id")), null, null);
                                    if (query2.moveToFirst()) {
                                        str2 = null;
                                        while (!query2.isAfterLast()) {
                                            columnIndex = query2.getColumnIndex("data1");
                                            int columnIndex2 = query2.getColumnIndex("display_name");
                                            String string = query2.getString(columnIndex);
                                            str = query2.getString(columnIndex2);
                                            v.d("MicroMsg.MallRechargeUI", "username : " + str);
                                            if (string != null) {
                                                v.d("MicroMsg.MallRechargeUI", "phoneNumber : " + string);
                                                string = com.tencent.mm.plugin.recharge.model.b.yt(string);
                                                v.d("MicroMsg.MallRechargeUI", "phoneNumber : " + string);
                                                if (!PhoneNumberUtils.isGlobalPhoneNumber(string)) {
                                                    string = str2;
                                                }
                                                v.d("MicroMsg.MallRechargeUI", "phoneResult : " + string);
                                            } else {
                                                string = str2;
                                            }
                                            query2.moveToNext();
                                            str2 = string;
                                        }
                                    } else {
                                        str2 = null;
                                    }
                                    if (!query2.isClosed()) {
                                        query2.close();
                                    }
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                                        this.iof.clear();
                                        this.inX.b(new com.tencent.mm.plugin.recharge.model.a(str2, str, 1));
                                        this.inN.setText("");
                                        this.inO.setVisibility(4);
                                        Ox();
                                        break;
                                    }
                                    showDialog(2);
                                    break;
                                }
                            }
                            str2 = null;
                            query.close();
                            if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                                this.iof.clear();
                                this.inX.b(new com.tencent.mm.plugin.recharge.model.a(str2, str, 1));
                                this.inN.setText("");
                                this.inO.setVisibility(4);
                                Ox();
                            } else {
                                showDialog(2);
                            }
                            break;
                        }
                        v.e("MicroMsg.MallRechargeUI", "no contact permission");
                        return;
                    }
                    v.e("MicroMsg.MallRechargeUI", "uri == null");
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.hRZ) {
                        v.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                        com.tencent.mm.plugin.recharge.a.a.aJi().a(this.inX.aJl());
                        finish();
                        this.hRZ = true;
                        break;
                    }
                }
                v.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onDestroy() {
        com.tencent.mm.sdk.c.a.nhr.f(this.hSc);
        super.onDestroy();
    }

    public final void k(String str, final Bitmap bitmap) {
        if (this.iob != null && str.equals(this.iob)) {
            this.inS.post(new Runnable(this) {
                final /* synthetic */ RechargeUI iok;

                public final void run() {
                    this.iok.inS.setImageBitmap(bitmap);
                }
            });
        }
    }

    public final void aJs() {
        v.d("MicroMsg.MallRechargeUI", "showVKB");
        this.inX.oG(2130838465);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.showSoftInput(currentFocus, 2);
            }
        }
    }

    public final void axg() {
        v.d("MicroMsg.MallRechargeUI", "hideVKB");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }
}
