package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.luckymoney.c.c;
import com.tencent.mm.plugin.luckymoney.c.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.g.b;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.ui.k;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyIndexUI extends LuckyMoneyBaseUI {
    private int hcU;
    private LinearLayout hfj;
    private LinearLayout hfk;
    private LinearLayout hfl;

    static /* synthetic */ void a(LuckyMoneyIndexUI luckyMoneyIndexUI, int i) {
        Intent intent = new Intent();
        intent.setClass(luckyMoneyIndexUI.nDR.nEl, LuckyMoneyPrepareUI.class);
        intent.putExtra("key_way", 3);
        intent.putExtra("key_type", i);
        intent.putExtra("pay_channel", luckyMoneyIndexUI.hcU);
        luckyMoneyIndexUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.O(this);
        NI();
        b(new v("v1.0", (byte) 0), false);
        this.hcU = getIntent().getIntExtra("pay_channel", -1);
        g.iuh.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
    }

    protected void onResume() {
        super.onResume();
        a.a(this, b.bmN());
    }

    protected final void NI() {
        vD(2131233669);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyIndexUI hfm;

            {
                this.hfm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hfm.finish();
                return true;
            }
        });
        this.hfj = (LinearLayout) findViewById(2131757845);
        this.hfk = (LinearLayout) findViewById(2131757844);
        this.hfl = (LinearLayout) findViewById(2131757846);
        ((Button) findViewById(2131757843)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyIndexUI hfm;

            {
                this.hfm = r1;
            }

            public final void onClick(View view) {
                g.iuh.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
                LuckyMoneyIndexUI.a(this.hfm, 0);
            }
        });
        ((Button) findViewById(2131757842)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyIndexUI hfm;

            {
                this.hfm = r1;
            }

            public final void onClick(View view) {
                g.iuh.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
                LuckyMoneyIndexUI.a(this.hfm, 1);
            }
        });
        a(0, getString(2131233628), new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyIndexUI hfm;

            {
                this.hfm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.iuh.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(this.hfm.getString(2131233629));
                linkedList2.add(Integer.valueOf(0));
                linkedList.add(this.hfm.getString(2131233631));
                linkedList2.add(Integer.valueOf(1));
                com.tencent.mm.ui.base.g.a(this.hfm.nDR.nEl, "", linkedList, linkedList2, "", false, new d(this) {
                    final /* synthetic */ AnonymousClass4 hfn;

                    {
                        this.hfn = r1;
                    }

                    public final void bw(int i, int i2) {
                        int i3 = 1;
                        switch (i2) {
                            case 1:
                                g.iuh.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6)});
                                break;
                            default:
                                g.iuh.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5)});
                                i3 = 2;
                                break;
                        }
                        Intent intent = new Intent();
                        intent.setClass(this.hfn.hfm.nDR.nEl, LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", i3);
                        this.hfn.hfm.startActivity(intent);
                    }
                });
                return true;
            }
        }, k.b.nFa);
        ayk();
    }

    private void ayk() {
        com.tencent.mm.plugin.luckymoney.a.a.axz();
        c axE = com.tencent.mm.plugin.luckymoney.a.a.axA().axE();
        if (axE != null) {
            ImageView imageView = (ImageView) findViewById(2131757840);
            if ((axE.hap & 1) == 1) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
                imageView.setImageResource(2130838547);
                return;
            }
            imageView.setImageResource(2130838548);
        }
    }

    protected final int getLayoutId() {
        return 2130903890;
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (!(kVar instanceof v)) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            v vVar = (v) kVar;
            g.c cVar = new g.c();
            cVar.textColor = getResources().getColor(2131689849);
            cVar.hgP = 101;
            g.a(this, this.hfj, vVar.haT, cVar, "Text");
            cVar = new g.c();
            cVar.textColor = getResources().getColor(2131689849);
            cVar.hgP = 100;
            g.a(this, this.hfk, vVar.hcb, cVar, "Text");
            cVar = new g.c();
            cVar.hgP = 102;
            g.a(this, this.hfl, vVar.hbZ, cVar, "Pic");
            ayk();
        }
        return true;
    }
}
