package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.d.d;
import com.tencent.mm.plugin.ipcall.a.e.f;
import com.tencent.mm.plugin.ipcall.a.e.g;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.c.aas;
import com.tencent.mm.protocal.c.bgf;
import com.tencent.mm.protocal.c.bgi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class IPCallRechargeUI extends MMActivity implements e {
    private int fiQ = -1;
    private String[] fiS;
    private com.tencent.mm.pluginsdk.model.f.a fjg = new com.tencent.mm.pluginsdk.model.f.a(this) {
        final /* synthetic */ IPCallRechargeUI gNj;

        {
            this.gNj = r1;
        }

        public final void y(ArrayList<o> arrayList) {
            this.gNj.gMZ.gIn = System.currentTimeMillis();
            if (arrayList == null || arrayList.size() <= 0) {
                if (this.gNj.gKB != null && this.gNj.gKB.isShowing()) {
                    this.gNj.gKB.dismiss();
                }
                v.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
                this.gNj.fiQ = 10236;
                this.gNj.avo();
                return;
            }
            this.gNj.gMT = new String[arrayList.size()];
            this.gNj.gMU = new String[arrayList.size()];
            o oVar = (o) arrayList.get(0);
            if (oVar.lzM == 10232) {
                v.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + arrayList.size());
                Iterator it = arrayList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    oVar = (o) it.next();
                    this.gNj.gMT[i] = new BigDecimal(oVar.lzL).divide(new BigDecimal(1000000)).toString();
                    this.gNj.gMU[i] = oVar.lzK;
                    i++;
                }
                if (this.gNj.gMY > 0 && this.gNj.gMU.length > 0) {
                    String str = this.gNj.gMU[0];
                    if (!(be.kS(str) || str.equals(this.gNj.gMW))) {
                        v.i("MicroMsg.IPCallRechargeUI", "remote currency:" + this.gNj.gMW + ",google wallet currency:" + str);
                        this.gNj.va(str);
                        return;
                    }
                }
                if (this.gNj.gKB != null && this.gNj.gKB.isShowing()) {
                    this.gNj.gKB.dismiss();
                }
                this.gNj.avo();
                return;
            }
            if (this.gNj.gKB != null && this.gNj.gKB.isShowing()) {
                this.gNj.gKB.dismiss();
            }
            this.gNj.fiQ = oVar.lzM;
            v.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + this.gNj.fiQ);
            this.gNj.avo();
        }
    };
    ProgressDialog gKB;
    private String[] gMT;
    private String[] gMU;
    private String gMV;
    private String gMW;
    private boolean gMX = false;
    private int gMY;
    private g gMZ = new g();
    private f gNa = new f();
    private i gNb = new i();
    RelativeLayout gNc;
    GridView gNd;
    ListView gNe;
    a gNf;
    TextView gNg;
    Button gNh;
    d gNi;
    private ac mHandler = new ac(this) {
        final /* synthetic */ IPCallRechargeUI gNj;

        {
            this.gNj = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1002:
                    this.gNj.gNe.setVisibility(0);
                    return;
                default:
                    v.w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
                    return;
            }
        }
    };

    private static class a extends BaseAdapter {
        private IPCallRechargeUI gNk = null;
        aas gNl = null;
        List<bgf> grq = null;

        private class a {
            TextView gMK;
            final /* synthetic */ a gNm;
            TextView gNn;
            TextView gNo;
            TextView gNp;
            Button gNq;

            private a(a aVar) {
                this.gNm = aVar;
            }
        }

        public a(IPCallRechargeUI iPCallRechargeUI) {
            Assert.assertTrue(iPCallRechargeUI != null);
            this.gNk = iPCallRechargeUI;
        }

        public final int getCount() {
            return this.grq == null ? 0 : this.grq.size();
        }

        public final Object getItem(int i) {
            if (this.grq != null) {
                return this.grq.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.gNk.getSystemService("layout_inflater")).inflate(2130903836, viewGroup, false);
                aVar = new a();
                aVar.gMK = (TextView) view.findViewById(2131757639);
                aVar.gNn = (TextView) view.findViewById(2131757640);
                aVar.gNo = (TextView) view.findViewById(2131757642);
                aVar.gNp = (TextView) view.findViewById(2131757641);
                aVar.gNq = (Button) view.findViewById(2131757637);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            bgf com_tencent_mm_protocal_c_bgf = (bgf) getItem(i);
            aVar.gMK.setText(com_tencent_mm_protocal_c_bgf.mNw);
            aVar.gNn.setText(com_tencent_mm_protocal_c_bgf.nbO);
            aVar.gNo.setText(com_tencent_mm_protocal_c_bgf.nbP);
            if (be.kS(com_tencent_mm_protocal_c_bgf.nbP)) {
                aVar.gNo.setVisibility(8);
            } else {
                aVar.gNo.setVisibility(0);
            }
            if (this.gNl != null) {
                aVar.gNp.setText(String.format(this.gNk.getString(2131233377), new Object[]{com.tencent.mm.plugin.ipcall.b.a.vi(this.gNl.mBW), Integer.valueOf(com_tencent_mm_protocal_c_bgf.nbM)}));
            }
            aVar.gNq.setTag(Integer.valueOf(i));
            aVar.gNq.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a gNm;

                {
                    this.gNm = r1;
                }

                public final void onClick(View view) {
                    IPCallRechargeUI.b(this.gNm.gNk, ((Integer) view.getTag()).intValue());
                }
            });
            return view;
        }
    }

    static /* synthetic */ void b(IPCallRechargeUI iPCallRechargeUI, int i) {
        String string;
        boolean z;
        if (iPCallRechargeUI.fiQ != -1) {
            CharSequence string2;
            switch (iPCallRechargeUI.fiQ) {
                case 10233:
                    string2 = iPCallRechargeUI.getString(2131233420);
                    if (!c.avD()) {
                        Toast.makeText(iPCallRechargeUI, string2, 0).show();
                        break;
                    } else {
                        iPCallRechargeUI.vb(string2);
                        break;
                    }
                case 10234:
                    string = iPCallRechargeUI.getString(2131233414);
                    if (!c.avD()) {
                        com.tencent.mm.ui.base.g.a(iPCallRechargeUI, string, iPCallRechargeUI.getString(2131233422), true, null);
                        break;
                    } else {
                        iPCallRechargeUI.vb(string);
                        break;
                    }
                case 10235:
                    string2 = iPCallRechargeUI.getString(2131233441);
                    if (!c.avD()) {
                        Toast.makeText(iPCallRechargeUI, string2, 0).show();
                        break;
                    } else {
                        iPCallRechargeUI.vb(string2);
                        break;
                    }
                default:
                    string2 = iPCallRechargeUI.getString(2131233360);
                    if (!c.avD()) {
                        Toast.makeText(iPCallRechargeUI, string2, 0).show();
                        break;
                    } else {
                        iPCallRechargeUI.vb(string2);
                        break;
                    }
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            v.i("MicroMsg.IPCallRechargeUI", "ProductId:%s, PackPrice:%s,Currency:%s, index:%d", new Object[]{iPCallRechargeUI.fiS[i], iPCallRechargeUI.gMT[i], iPCallRechargeUI.gMU[i], Integer.valueOf(i)});
            com.tencent.mm.plugin.report.service.g.iuh.a(257, 5, 1, true);
            iPCallRechargeUI.gNa.start();
            if (iPCallRechargeUI.gNf.getItem(i) instanceof bgf) {
                iPCallRechargeUI.gNa.gIe = ((bgf) iPCallRechargeUI.gNf.getItem(i)).nbN;
            }
            iPCallRechargeUI.gNa.gIf = iPCallRechargeUI.gMU[i];
            iPCallRechargeUI.gNa.gId = (long) i;
            iPCallRechargeUI.gNa.gIj = iPCallRechargeUI.fiS[i];
            Intent intent = new Intent();
            intent.putExtra("key_product_id", iPCallRechargeUI.fiS[i]);
            intent.putExtra("key_currency_type", iPCallRechargeUI.gMU[i]);
            intent.putExtra("key_price", iPCallRechargeUI.gMU[i] + iPCallRechargeUI.gMT[i]);
            intent.putExtra("key_force_google", true);
            if (iPCallRechargeUI.gNf.getItem(i) instanceof bgf) {
                string = ((bgf) iPCallRechargeUI.gNf.getItem(i)).nbQ;
                if (!be.kS(string)) {
                    v.i("md5:%s", string);
                    bgi com_tencent_mm_protocal_c_bgi = new bgi();
                    com_tencent_mm_protocal_c_bgi.nbQ = string;
                    try {
                        intent.putExtra("key_ext_info", Base64.encodeToString(com_tencent_mm_protocal_c_bgi.toByteArray(), 2));
                    } catch (IOException e) {
                        v.e("MicroMsg.IPCallRechargeUI", e.getMessage());
                    }
                }
            }
            com.tencent.mm.ay.c.b(iPCallRechargeUI, "wallet_index", ".ui.WalletIapUI", intent, 2001);
        }
    }

    static /* synthetic */ void j(IPCallRechargeUI iPCallRechargeUI) {
        if (iPCallRechargeUI.gNf != null) {
            iPCallRechargeUI.gNf.grq = null;
            iPCallRechargeUI.gNf.notifyDataSetChanged();
        }
        if (iPCallRechargeUI.gNe != null) {
            iPCallRechargeUI.gNe.setVisibility(4);
        }
        if (iPCallRechargeUI.gKB != null) {
            iPCallRechargeUI.gKB.show();
        }
        iPCallRechargeUI.va("");
    }

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(929, this);
        vD(2131233375);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallRechargeUI gNj;

            {
                this.gNj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gNj.finish();
                return true;
            }
        });
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallRechargeUI gNj;

            {
                this.gNj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.g.a(this.gNj.nDR.nEl, null, null, this.gNj.getResources().getString(2131233424), false, new com.tencent.mm.ui.base.g.c(this.gNj) {
                    final /* synthetic */ IPCallRechargeUI gNj;

                    {
                        this.gNj = r1;
                    }

                    public final void gT(int i) {
                        switch (i) {
                            case 0:
                                v.i("MicroMsg.IPCallRechargeUI", "start restore");
                                this.gNj.gNb.start();
                                com.tencent.mm.plugin.report.service.g.iuh.a(257, 14, 1, true);
                                Intent intent = new Intent();
                                intent.putExtra("key_action_type", 200002);
                                intent.putExtra("key_force_google", true);
                                com.tencent.mm.ay.c.b(this.gNj, "wallet_index", ".ui.WalletIapUI", intent, 2002);
                                IPCallRechargeUI iPCallRechargeUI = this.gNj;
                                if (iPCallRechargeUI.isFinishing()) {
                                    v.i("MicroMsg.IPCallRechargeUI", "[showLoadingDialog] acitivity is finished.");
                                    return;
                                }
                                ActionBarActivity actionBarActivity = iPCallRechargeUI.nDR.nEl;
                                iPCallRechargeUI.getString(2131231164);
                                iPCallRechargeUI.gKB = com.tencent.mm.ui.base.g.a(actionBarActivity, iPCallRechargeUI.getString(2131233361), false, null);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        this.gNc = (RelativeLayout) findViewById(2131757519);
        this.gNd = (GridView) findViewById(2131757644);
        this.gNe = (ListView) findViewById(2131757636);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.nDR.nEl, 2130903835, null);
        this.gNe.addFooterView(viewGroup, null, false);
        this.gNf = new a(this);
        this.gNe.setAdapter(this.gNf);
        this.gNg = (TextView) viewGroup.findViewById(2131755314);
        this.gNh = (Button) findViewById(2131757645);
        Object string = getString(2131233379);
        CharSequence newSpannable = Factory.getInstance().newSpannable(string);
        newSpannable.setSpan(new ClickableSpan(this) {
            final /* synthetic */ IPCallRechargeUI gNj;

            {
                this.gNj = r1;
            }

            public final void onClick(View view) {
                ((TextView) view).setHighlightColor(this.gNj.getResources().getColor(2131690078));
                Intent intent = new Intent();
                String str = this.gNj.getString(2131233378) + "&usedcc=";
                List aub = com.tencent.mm.plugin.ipcall.a.c.atY().aub();
                if (aub.size() > 0) {
                    int size = aub.size();
                    if (size > 5) {
                        size = 5;
                    }
                    int i = 0;
                    while (i < size) {
                        String vk = com.tencent.mm.plugin.ipcall.b.a.vk(((Integer) aub.get(i)).toString());
                        if (be.kS(vk)) {
                            vk = str;
                        } else {
                            vk = str + vk + "|";
                        }
                        i++;
                        str = vk;
                    }
                    if (str.endsWith("|")) {
                        str = str.substring(0, str.length() - 1);
                    }
                } else {
                    str = str + com.tencent.mm.plugin.ipcall.b.a.vk(c.avC());
                }
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                com.tencent.mm.ay.c.b(this.gNj, "webview", ".ui.tools.WebViewUI", intent);
            }

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(this.gNj.getResources().getColor(2131689819));
                textPaint.setUnderlineText(false);
            }
        }, 0, string.length(), 33);
        this.gNg.setText(newSpannable);
        this.gNg.setMovementMethod(LinkMovementMethod.getInstance());
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.gKB = com.tencent.mm.ui.base.g.a(actionBarActivity, getString(2131233361), true, new OnCancelListener(this) {
            final /* synthetic */ IPCallRechargeUI gNj;

            {
                this.gNj = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                try {
                    if (this.gNj.gNi != null) {
                        ak.vy().c(this.gNj.gNi);
                    }
                    this.gNj.finish();
                } catch (Exception e) {
                    v.e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", new Object[]{e.getMessage()});
                }
            }
        });
        va("");
        this.gMZ.start();
        com.tencent.mm.plugin.report.service.g.iuh.a(257, 4, 1, true);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.gMZ.gHX = System.currentTimeMillis();
        this.gMZ.finish();
        ak.vy().b(929, this);
    }

    protected final int getLayoutId() {
        return 2130903837;
    }

    private void va(String str) {
        String vk;
        List aub = com.tencent.mm.plugin.ipcall.a.c.atY().aub();
        if (aub.size() == 0) {
            vk = com.tencent.mm.plugin.ipcall.b.a.vk(c.avC());
        } else {
            vk = com.tencent.mm.plugin.ipcall.b.a.vk(((Integer) aub.get(0)).toString());
        }
        this.gNi = new d(vk, str);
        ak.vy().a(this.gNi, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.IPCallRechargeUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        boolean z;
        int i3;
        ArrayList stringArrayListExtra;
        if (i == 2001) {
            int intExtra;
            int i4;
            String str;
            String str2 = "";
            z = false;
            if (intent != null) {
                String string;
                int intExtra2 = intent.getIntExtra("key_err_code", 0);
                String stringExtra = intent.getStringExtra("key_err_msg");
                long longExtra = intent.getLongExtra("key_launch_ts", 0);
                intExtra = intent.getIntExtra("key_gw_error_code", 0);
                int intExtra3 = intent.getIntExtra("key_response_position", 0);
                if (intExtra2 == 100000009) {
                    z = true;
                }
                v.i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[]{Integer.valueOf(intExtra2), stringExtra, Integer.valueOf(intExtra), Integer.valueOf(intExtra3), String.valueOf(z)});
                if (intExtra2 != -1 || intExtra == 0) {
                    this.gNa.gIh = (long) intExtra2;
                } else {
                    this.gNa.gIh = (long) intExtra;
                }
                if (intExtra3 == 3) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(257, 9, 1, true);
                    com.tencent.mm.plugin.report.service.g.iuh.a(257, 11, 1, true);
                    this.gNa.gIh = 0;
                    this.gNa.gIi = 2;
                    string = getString(2131233442);
                } else {
                    if (intExtra3 != 1) {
                        if (i2 == -1 && intExtra2 == 0) {
                            com.tencent.mm.plugin.report.service.g.iuh.a(257, 9, 1, true);
                            string = stringExtra;
                        } else if (z) {
                            com.tencent.mm.plugin.report.service.g.iuh.a(257, 9, 1, true);
                            com.tencent.mm.plugin.report.service.g.iuh.a(257, 12, 1, true);
                            this.gNa.gIh = 0;
                            this.gNa.gIi = 1;
                        }
                    }
                    string = stringExtra;
                }
                this.gNa.gIg = longExtra;
                this.gNa.gHX = System.currentTimeMillis();
                this.gNa.finish();
                i4 = intExtra3;
                str = string;
                i3 = intExtra;
                intExtra = intExtra2;
            } else {
                i3 = 0;
                i4 = 0;
                intExtra = 0;
                str = str2;
            }
            if (i2 != -1) {
                return;
            }
            if (intent != null && intExtra == 0) {
                stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                intent.getStringArrayListExtra("key_response_series_ids");
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    v.i("MicroMsg.IPCallRechargeUI", "buy product ok productId:", new Object[]{be.ma((String) it.next())});
                }
                com.tencent.mm.plugin.report.service.g.iuh.a(257, 6, 1, true);
                com.tencent.mm.plugin.report.service.g.iuh.a(257, 10, 1, true);
                Toast.makeText(this, 2131233423, 0).show();
                finish();
            } else if (intent != null && intExtra == 103) {
                com.tencent.mm.plugin.report.service.g.iuh.a(257, 6, 1, true);
                rC(str);
            } else if (intent == null || intExtra != 109) {
                CharSequence string2;
                if (intent != null && intExtra == 100000000) {
                    string2 = getString(2131233421);
                    com.tencent.mm.plugin.report.service.g.iuh.a(257, 8, 1, true);
                } else if (intent == null || intExtra != 113) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(257, 7, 1, true);
                    if (i4 == 3) {
                        rC(str);
                        return;
                    } else if (intExtra != 100000009 && intExtra != -1) {
                        return;
                    } else {
                        if (i3 == 0) {
                            string2 = getString(2131233358);
                        } else {
                            string2 = getString(2131233360);
                            if (c.avD()) {
                                vb(string2);
                                return;
                            }
                        }
                    }
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(2131233406), getString(2131233422), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ IPCallRechargeUI gNj;

                        {
                            this.gNj = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            IPCallRechargeUI.j(this.gNj);
                        }
                    });
                    return;
                }
                Toast.makeText(this, string2, 0).show();
            } else {
                rC(str);
            }
        } else if (i == 2002) {
            if (this.gKB != null && this.gKB.isShowing()) {
                this.gKB.dismiss();
            }
            String str3 = "";
            int i5 = 0;
            int i6 = 0;
            z = false;
            if (intent != null) {
                i5 = intent.getIntExtra("key_err_code", 0);
                str3 = intent.getStringExtra("key_err_msg");
                i6 = intent.getIntExtra("key_response_position", 0);
                if (i5 == 100000009) {
                    z = true;
                }
                v.i("MicroMsg.IPCallRechargeUI", "onActivityResult restore.errCode:[%d] errMsg:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[]{Integer.valueOf(i5), str3, Integer.valueOf(i6), String.valueOf(z)});
            }
            CharSequence charSequence = str3;
            int i7 = i5;
            boolean z2 = z;
            i3 = i6;
            i6 = i7;
            this.gNb.gIq = (long) i6;
            this.gNb.gIo = 0;
            if (i2 != -1) {
                this.gNb.gIp = 2;
                v.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
                Toast.makeText(this, 2131233425, 0).show();
            } else if (intent == null || i6 != 0) {
                if (z2) {
                    this.gNb.gIp = 1;
                    com.tencent.mm.plugin.report.service.g.iuh.a(257, 17, 1, true);
                    charSequence = getString(2131233426);
                } else if (i3 == 3) {
                    this.gNb.gIp = 2;
                    com.tencent.mm.plugin.report.service.g.iuh.a(257, 16, 1, true);
                } else {
                    this.gNb.gIp = 2;
                }
                v.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
                Toast.makeText(this, charSequence, 0).show();
            } else {
                stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    this.gNb.gIp = 3;
                    v.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
                    Toast.makeText(this, 2131233426, 0).show();
                } else {
                    this.gNb.gIp = 0;
                    com.tencent.mm.plugin.report.service.g.iuh.a(257, 15, 1, true);
                    v.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
                    com.tencent.mm.ui.base.g.a(this, getString(2131233427), getString(2131233428), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ IPCallRechargeUI gNj;

                        {
                            this.gNj = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.gNj.finish();
                        }
                    });
                }
            }
            this.gNb.gHX = System.currentTimeMillis();
            this.gNb.finish();
        }
    }

    private void rC(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(2131233422);
        }
        com.tencent.mm.ui.base.g.a(this, str, getString(2131233422), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ IPCallRechargeUI gNj;

            {
                this.gNj = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void vb(String str) {
        com.tencent.mm.ui.base.g.a(this, str, getString(2131233422), getString(2131233399), getString(2131231010), true, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ IPCallRechargeUI gNj;

            {
                this.gNj = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.plugin.report.service.g.iuh.a(257, 3, 1, true);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.gNj.getString(2131233398));
                intent.putExtra("showShare", false);
                com.tencent.mm.ay.c.b(this.gNj, "webview", ".ui.tools.WebViewUI", intent);
            }
        }, null);
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        v.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[]{Integer.valueOf(i2), str});
        if (kVar instanceof d) {
            g gVar = this.gMZ;
            gVar.gIl = System.currentTimeMillis();
            gVar.gIm = (long) i2;
            if (i == 0 && i2 == 0) {
                aas com_tencent_mm_protocal_c_aas = ((d) kVar).gHE;
                this.gNf.grq = com_tencent_mm_protocal_c_aas.myn;
                this.gNf.gNl = com_tencent_mm_protocal_c_aas;
                this.gNf.notifyDataSetChanged();
                this.fiS = new String[com_tencent_mm_protocal_c_aas.myn.size()];
                Iterator it = com_tencent_mm_protocal_c_aas.myn.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    this.fiS[i4] = ((bgf) it.next()).mdM;
                    i4++;
                }
                this.gMV = com_tencent_mm_protocal_c_aas.mBW;
                this.gMW = com_tencent_mm_protocal_c_aas.mCa;
                this.gMY = com_tencent_mm_protocal_c_aas.mBZ;
                if (this.gMX) {
                    this.gMU = new String[com_tencent_mm_protocal_c_aas.myn.size()];
                    for (int i5 = 0; i5 < this.gMU.length; i5++) {
                        this.gMU[i5] = com_tencent_mm_protocal_c_aas.mCa;
                    }
                    this.gMT = new String[com_tencent_mm_protocal_c_aas.myn.size()];
                    while (i3 < this.gMT.length) {
                        this.gMT[i3] = IPCallDynamicTextView.uZ(((bgf) com_tencent_mm_protocal_c_aas.myn.get(i3)).mNw);
                        i3++;
                    }
                }
                if (((d) kVar).gHF) {
                    v.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
                    if (this.fiS != null && this.fiS.length > 0) {
                        v.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
                        com.tencent.mm.pluginsdk.model.f.a(this, this.fiS, this.fjg);
                        return;
                    }
                    return;
                }
                if (this.gKB != null && this.gKB.isShowing()) {
                    this.gKB.dismiss();
                }
                avo();
                return;
            }
            if (this.gKB != null && this.gKB.isShowing()) {
                this.gKB.dismiss();
            }
            Toast.makeText(this.nDR.nEl, getString(2131233358), 0).show();
            finish();
        }
    }

    public final void avo() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1002);
        }
    }
}
