package com.tencent.mm.plugin.product.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.protocal.c.apv;
import com.tencent.mm.protocal.c.avd;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.v.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MallProductSubmitUI extends MallBaseUI implements a {
    private TextView eXB;
    private Button fzj;
    private e hQr;
    private ImageView hSC;
    private TextView hSD;
    private f hSJ;
    private RelativeLayout hSZ;
    private c hSa;
    private TextView hTa;
    private TextView hTb;
    private MallProductItemView hTc;
    private MallProductItemView hTd;
    private TextView hTe;
    private TextView hTf;
    private TextView hTg;
    private TextView hTh;
    private ListView hTi;
    private a hTj;

    protected final int getLayoutId() {
        return 2130904193;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hSJ = new f(this.nDR.nEl, new f.a(this) {
            final /* synthetic */ MallProductSubmitUI hTk;

            {
                this.hTk = r1;
            }

            public final void i(int i, int i2, String str) {
                if (i == 0 && i2 == 0) {
                    this.hTk.av();
                } else {
                    this.hTk.xJ(str);
                }
            }
        });
        com.tencent.mm.plugin.product.a.a.aFW();
        this.hSa = com.tencent.mm.plugin.product.a.a.aFX();
        this.hQr = this.hSa.hQr;
        NI();
        av();
    }

    public void onStart() {
        this.hSJ.onStart();
        super.onStart();
    }

    protected void onStop() {
        this.hSJ.onStop();
        super.onStop();
    }

    protected final void NI() {
        vD(2131233791);
        this.hSZ = (RelativeLayout) findViewById(2131758629);
        this.hTa = (TextView) findViewById(2131758631);
        this.hTb = (TextView) findViewById(2131758632);
        this.hTc = (MallProductItemView) findViewById(2131758633);
        this.hTd = (MallProductItemView) findViewById(2131758634);
        this.hSC = (ImageView) findViewById(2131758635);
        this.eXB = (TextView) findViewById(2131758636);
        this.hTe = (TextView) findViewById(2131758637);
        this.hSD = (TextView) findViewById(2131758638);
        this.hTf = (TextView) findViewById(2131758642);
        this.hTg = (TextView) findViewById(2131758641);
        this.hTh = (TextView) findViewById(2131758640);
        this.hTi = (ListView) findViewById(2131758639);
        this.hTj = new a(this);
        this.hTi.setAdapter(this.hTj);
        this.hTi.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MallProductSubmitUI hTk;

            {
                this.hTk = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b bVar = (b) view.getTag();
                switch (bVar.type) {
                    case 1:
                        if (bVar.hRH instanceof String) {
                            this.hTk.hSa.hQl = (String) bVar.hRH;
                            break;
                        }
                        break;
                    case 2:
                        m mVar = this.hTk.hSa.hQc;
                        if (mVar.hQG.hQV != null && mVar.hQG.hQV.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            Iterator it = mVar.hQG.hQV.iterator();
                            while (it.hasNext()) {
                                arrayList.add((String) it.next());
                            }
                            bVar.hRH = arrayList;
                            break;
                        }
                }
                this.hTk.hTj.a(this.hTk, view, i);
            }
        });
        this.fzj = (Button) findViewById(2131758643);
        this.fzj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSubmitUI hTk;

            {
                this.hTk = r1;
            }

            public final void onClick(View view) {
                f d = this.hTk.hSJ;
                if (d.hSa.aGl()) {
                    int i;
                    if (d.hSa.aGc() == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        n vy = ak.vy();
                        avd aGn = d.hSa.aGn();
                        d.hSa.getAppId();
                        vy.a(new k(aGn), 0);
                        return;
                    }
                    ak.vy().a(new l(d.hSa.aGn(), d.hSa.getAppId()), 0);
                }
            }
        });
        this.hSZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSubmitUI hTk;

            {
                this.hTk = r1;
            }

            public final void onClick(View view) {
                f d = this.hTk.hSJ;
                Intent intent = new Intent();
                intent.putExtra("launch_from_webview", true);
                com.tencent.mm.ay.c.a(d.gZX, "address", ".ui.WalletSelectAddrUI", intent, 1, false);
            }
        });
        this.hTc.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSubmitUI hTk;

            {
                this.hTk = r1;
            }

            public final void onClick(View view) {
                this.hTk.showDialog(1);
            }
        });
        this.hTd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSubmitUI hTk;

            {
                this.hTk = r1;
            }

            public final void onClick(View view) {
                f d = this.hTk.hSJ;
                d.gZX.startActivityForResult(new Intent(d.gZX, MallProductReceiptUI.class), 4);
            }
        });
        MallProductItemView mallProductItemView = this.hTd;
        boolean z = (this.hSa.aFZ().hRX & 2) > 0;
        v.d("MicroMsg.MallProductConfig", "hasReceipt, ret = " + z);
        mallProductItemView.setVisibility(z ? 0 : 8);
        if (this.hSa.aFZ().aGv()) {
            this.hTc.setEnabled(false);
            this.hTc.setClickable(false);
            this.hTc.xL(getString(2131233789));
        }
    }

    private void av() {
        m mVar = this.hSa.hQc;
        if (this.hQr != null) {
            this.hSD.setText(b.h(this.hQr.hQv, this.hQr.hQv, mVar.hQG.hNg) + " x " + this.hSa.mCount);
        } else {
            this.hSD.setText(b.h(mVar.hQG.hQT, mVar.hQG.hQU, mVar.hQG.hNg));
        }
        if (!be.kS(this.hSa.aGa())) {
            this.hSC.setImageBitmap(j.a(new c(this.hSa.aGa())));
            j.a(this);
        }
        this.eXB.setText(mVar.hQG.name);
        this.hTe.setText(this.hSa.aGb());
        apv aGe = this.hSa.aGe();
        if (aGe == null || be.kS(aGe.glo)) {
            this.hTd.xL("");
        } else {
            this.hTd.xL(aGe.glo);
        }
        String str = "";
        if (!this.hSa.aFZ().aGv()) {
            pc pcVar = this.hSa.hQh;
            if (pcVar != null) {
                this.hTc.setEnabled(true);
                this.hTc.setClickable(true);
                this.hTc.xL(b.a(this, pcVar));
                str = getString(2131233787, new Object[]{b.c((double) pcVar.mjf, pcVar.mqp)});
                this.hTb.setVisibility(8);
            } else {
                this.hTc.setEnabled(false);
                this.hTc.setClickable(false);
                this.hTc.xL(getString(2131233788));
                this.hTb.setVisibility(0);
            }
        }
        String str2 = "";
        if (this.hSa.aGd() > 0) {
            be.kS(str);
            str2 = getString(2131233786, new Object[]{b.c((double) r3, mVar.hQG.hNg)});
        }
        List I = this.hSa.I(this);
        if (I.size() > 0) {
            this.hTi.setVisibility(0);
            this.hTj.aV(I);
            this.hTj.notifyDataSetChanged();
        } else {
            this.hTi.setVisibility(8);
        }
        if (this.hSa.hQi != null) {
            this.hTa.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[]{r3.gln, r3.mcl, r3.cHd, r3.cHe, r3.glo})));
        }
        if (be.kS(str + str2)) {
            this.hTg.setVisibility(0);
            this.hTf.setVisibility(8);
        } else {
            this.hTf.setText(getString(2131233785, new Object[]{str + str2}));
            this.hTg.setVisibility(8);
            this.hTf.setVisibility(0);
        }
        this.hTh.setText(b.c((double) this.hSa.aGc(), mVar.hQG.hNg));
        this.fzj.setEnabled(this.hSa.aGl());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hSJ.onActivityResult(i, i2, intent);
    }

    public final void k(String str, final Bitmap bitmap) {
        v.d("MicroMsg.MallProductSubmitUI", str + ", bitmap = " + (bitmap == null));
        if (!be.kS(this.hSa.aGa())) {
            this.hSC.post(new Runnable(this) {
                final /* synthetic */ MallProductSubmitUI hTk;

                public final void run() {
                    this.hTk.hSC.setImageBitmap(bitmap);
                }
            });
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                List<pc> list = this.hSa.hQp;
                if (list != null) {
                    List arrayList = new ArrayList();
                    for (pc a : list) {
                        arrayList.add(b.a(this, a));
                    }
                    String string = getString(2131233780);
                    OnItemClickListener anonymousClass8 = new OnItemClickListener(this) {
                        final /* synthetic */ MallProductSubmitUI hTk;

                        {
                            this.hTk = r1;
                        }

                        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            this.hTk.dismissDialog(1);
                            this.hTk.hSa.nZ(i);
                            this.hTk.av();
                        }
                    };
                    ListAdapter aVar = new a(this);
                    ListView listView = (ListView) View.inflate(this, 2130903991, null);
                    listView.setOnItemClickListener(new com.tencent.mm.plugin.product.ui.d.AnonymousClass1(anonymousClass8, aVar));
                    aVar.hRR = arrayList;
                    aVar.hRS = 0;
                    listView.setAdapter(aVar);
                    h.a aVar2 = new h.a(this);
                    aVar2.Op(string);
                    aVar2.cC(listView);
                    aVar2.c(null);
                    Dialog RX = aVar2.RX();
                    RX.show();
                    return RX;
                }
                break;
        }
        return super.onCreateDialog(i);
    }
}
