package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;

public class MallProductSelectSkuUI extends MallBaseUI implements a {
    private TextView eXB;
    private m hQc;
    private e hQr;
    private ImageView hSC;
    private TextView hSD;
    private TextView hSE;
    private Button hSF;
    private ListView hSG;
    private MallProductSelectAmountView hSH = null;
    private i hSI = null;
    private f hSJ;
    private c hSa;

    protected final int getLayoutId() {
        return 2130904190;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hSJ = new f(this.nDR.nEl, new f.a(this) {
            final /* synthetic */ MallProductSelectSkuUI hSK;

            {
                this.hSK = r1;
            }

            public final void i(int i, int i2, String str) {
                if (i == 0 && i2 == 0) {
                    this.hSK.av();
                } else {
                    this.hSK.xJ(str);
                }
            }
        });
        com.tencent.mm.plugin.product.a.a.aFW();
        this.hSa = com.tencent.mm.plugin.product.a.a.aFX();
        this.hQc = this.hSa.hQc;
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
        vD(2131233772);
        this.hSC = (ImageView) findViewById(2131758618);
        this.eXB = (TextView) findViewById(2131758619);
        this.hSD = (TextView) findViewById(2131758620);
        this.hSE = (TextView) findViewById(2131758623);
        this.hSF = (Button) findViewById(2131758624);
        this.hSG = (ListView) findViewById(2131758621);
        this.hSH = (MallProductSelectAmountView) findViewById(2131758622);
        MallProductSelectAmountView mallProductSelectAmountView = this.hSH;
        mallProductSelectAmountView.hSz = this.hSa.mCount;
        if (mallProductSelectAmountView.aGy()) {
            mallProductSelectAmountView.dtD.setText(mallProductSelectAmountView.hSz);
            if (mallProductSelectAmountView.hSA != null) {
                mallProductSelectAmountView.hSA.dV(mallProductSelectAmountView.hSz);
            }
        }
        this.hSI = new i(this);
        if (this.hQc == null || this.hQc.hQG == null || this.hQc.hQG.hRc == null) {
            v.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
        } else {
            this.hSI.hSL = this.hQc.hQG.hRc;
        }
        this.hSI.hSM = new OnItemClickListener(this) {
            final /* synthetic */ MallProductSelectSkuUI hSK;

            {
                this.hSK = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                e eVar = null;
                Pair pair = (Pair) view.getTag();
                MallProductSelectSkuUI mallProductSelectSkuUI = this.hSK;
                c b = this.hSK.hSa;
                String str = (String) pair.first;
                String str2 = (String) pair.second;
                v.d("MicroMsg.MallProductManager", "selectSkuInfo (" + str + " , " + str2 + ")");
                if (b.hQo.containsKey(str) && ((String) b.hQo.get(str)).equals(str2)) {
                    b.hQo.remove(str);
                    b.hQg = c.x(b.hQo);
                    b.hQr = b.hQn != null ? (e) b.hQn.get(b.hQg) : null;
                } else {
                    b.hQo.put(str, str2);
                    b.hQg = c.x(b.hQo);
                    v.d("MicroMsg.MallProductManager", "getSkuInfoId (" + b.hQg + ")");
                    if (b.hQn != null) {
                        b.hQr = (e) b.hQn.get(b.hQg);
                    }
                    mallProductSelectSkuUI.hQr = eVar;
                    this.hSK.av();
                }
                b.aGo();
                eVar = b.hQr;
                mallProductSelectSkuUI.hQr = eVar;
                this.hSK.av();
            }
        };
        this.hSG.setAdapter(this.hSI);
        this.hSH.hSA = new MallProductSelectAmountView.a(this) {
            final /* synthetic */ MallProductSelectSkuUI hSK;

            {
                this.hSK = r1;
            }

            public final void dV(int i) {
                this.hSK.hSa.mCount = i;
                this.hSK.hSE.setVisibility(8);
            }

            public final void cf(int i, int i2) {
                switch (i2) {
                    case 1:
                        this.hSK.hSE.setText(2131233767);
                        this.hSK.hSE.setVisibility(0);
                        return;
                    case 3:
                        this.hSK.hSE.setText(this.hSK.getString(2131233768, new Object[]{Integer.valueOf(i)}));
                        this.hSK.hSE.setVisibility(0);
                        return;
                    default:
                        return;
                }
            }
        };
        this.hSF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSelectSkuUI hSK;

            {
                this.hSK = r1;
            }

            public final void onClick(View view) {
                f d = this.hSK.hSJ;
                if (d.hRY) {
                    s.makeText(d.gZX, 2131233761, 1).show();
                } else if (!d.hSa.aGk()) {
                    String str;
                    c cVar = d.hSa;
                    if (cVar.hQo != null && cVar.hQo.size() < cVar.hQm && cVar.hQm > 0) {
                        Iterator it = cVar.hQc.hQG.hRc.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.plugin.product.c.m mVar = (com.tencent.mm.plugin.product.c.m) it.next();
                            if (!cVar.hQo.containsKey(mVar.hRo)) {
                                str = mVar.hRp;
                                break;
                            }
                        }
                    }
                    str = null;
                    if (!be.kS(str)) {
                        s.makeText(d.gZX, d.gZX.getString(2131233770, new Object[]{str}), 0).show();
                    }
                } else if (d.hSa.hQi != null) {
                    ak.vy().a(new j(d.hSa.aGm(), f.cVh), 0);
                } else {
                    com.tencent.mm.ay.c.b(d.gZX, "address", ".ui.WalletAddAddressUI", 2);
                }
            }
        });
        this.hSC.setFocusable(true);
        this.hSC.setFocusableInTouchMode(true);
        this.hSC.requestFocus();
    }

    private void av() {
        if (this.hQc != null) {
            if (this.hQr == null || this.hQc.hQG == null) {
                this.hSD.setText(b.h(this.hQc.hQG.hQT, this.hQc.hQG.hQU, this.hQc.hQG.hNg));
            } else {
                this.hSD.setText(b.h(this.hQr.hQv, this.hQr.hQw, this.hQc.hQG.hNg));
            }
            if (this.hQc.hQG != null) {
                this.eXB.setText(this.hQc.hQG.name);
            }
        }
        if (!be.kS(this.hSa.aGa())) {
            this.hSC.setImageBitmap(com.tencent.mm.platformtools.j.a(new c(this.hSa.aGa())));
            com.tencent.mm.platformtools.j.a(this);
        }
        this.hSE.setVisibility(8);
        MallProductSelectAmountView mallProductSelectAmountView = this.hSH;
        int aGi = this.hSa.aGi();
        int i = this.hSa.hQc.hQF;
        if (aGi > i) {
            mallProductSelectAmountView.hSx = 3;
            mallProductSelectAmountView.hSw = i;
        } else {
            mallProductSelectAmountView.hSx = 1;
            mallProductSelectAmountView.hSw = aGi;
        }
        mallProductSelectAmountView.aGy();
        if (mallProductSelectAmountView.hSA != null) {
            mallProductSelectAmountView.hSA.dV(mallProductSelectAmountView.hSz);
        }
        this.hSI.notifyDataSetChanged();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hSJ.onActivityResult(i, i2, intent);
    }

    public final void k(String str, final Bitmap bitmap) {
        v.d("MicroMsg.MallProductSelectSkuUI", str + ", bitmap = " + (bitmap == null));
        if (!be.kS(this.hSa.aGa())) {
            this.hSC.post(new Runnable(this) {
                final /* synthetic */ MallProductSelectSkuUI hSK;

                public final void run() {
                    this.hSK.hSC.setImageBitmap(bitmap);
                }
            });
        }
    }
}
