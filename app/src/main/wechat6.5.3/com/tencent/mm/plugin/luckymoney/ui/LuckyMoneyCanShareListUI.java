package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.luckymoney.c.h;
import com.tencent.mm.plugin.luckymoney.c.x;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyCanShareListUI extends LuckyMoneyBaseUI {
    private boolean ffH = false;
    private MMLoadMoreListView heW;
    private d heX;
    private boolean heg = true;
    private List<h> hen = new LinkedList();
    private String heq = "";
    private int vI = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        ayh();
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyCanShareListUI heY;

            {
                this.heY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.heY.finish();
                return true;
            }
        });
        this.heW = (MMLoadMoreListView) findViewById(2131757867);
        Fd(getString(2131233623));
        this.heX = new e(this.nDR.nEl);
        this.heW.setAdapter(this.heX);
        this.heW.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ LuckyMoneyCanShareListUI heY;

            {
                this.heY = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                h mF = this.heY.heX.mF((int) j);
                if (mF != null && !be.kS(mF.haB)) {
                    Intent intent = new Intent();
                    intent.setClass(this.heY.nDR.nEl, LuckyMoneyDetailUI.class);
                    intent.putExtra("key_sendid", mF.haB);
                    this.heY.startActivity(intent);
                }
            }
        });
        this.heW.nWA = new a(this) {
            final /* synthetic */ LuckyMoneyCanShareListUI heY;

            {
                this.heY = r1;
            }

            public final void adB() {
                if (this.heY.heg && !this.heY.ffH) {
                    this.heY.ayh();
                }
            }
        };
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof x) || i != 0 || i2 != 0) {
            return false;
        }
        x xVar = (x) kVar;
        List list = xVar.hce.haY;
        this.heq = xVar.hbT;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                this.hen.add(list.get(i3));
            }
            this.vI += list.size();
            this.heg = xVar.axO();
            this.ffH = false;
            this.heX.aJ(this.hen);
        }
        if (this.heg) {
            this.heW.bCi();
        } else {
            this.heW.bCj();
        }
        return true;
    }

    protected final int getLayoutId() {
        return 2130903894;
    }

    private void ayh() {
        this.ffH = true;
        if (this.vI == 0) {
            this.heq = "";
        }
        j(new x(10, this.vI, 3, "", "v1.0", this.heq));
    }
}
