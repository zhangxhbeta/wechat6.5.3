package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.al;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.ui.b.a;
import com.tencent.mm.pluginsdk.model.app.s;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import java.util.LinkedList;

public class AuthorizedGameListUI extends MMActivity implements OnItemClickListener, s {
    public static int goF = 1;
    public static int goG = 2;
    public static int goH = 4;
    public static int goI = 5;
    public static int goJ = 6;
    private ProgressDialog dwR = null;
    private int gjl = 0;
    private ListView goB;
    private a goC;
    private View goD;
    private int goE = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gjl = getIntent().getIntExtra("game_report_from_scene", 0);
        au.ash().a(3, this);
        NI();
        final w wVar = new w(3, new al(u.d(getSharedPreferences(aa.bti(), 0))));
        ak.vy().a(wVar, 0);
        getString(2131231164);
        this.dwR = g.a(this, getString(2131231182), true, new OnCancelListener(this) {
            final /* synthetic */ AuthorizedGameListUI goK;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(wVar);
            }
        });
    }

    protected void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return 2130903738;
    }

    protected final void NI() {
        this.goB = (ListView) findViewById(2131757335);
        this.goD = findViewById(2131757202);
        this.goC = new a(this);
        this.goC.goM = new a(this) {
            final /* synthetic */ AuthorizedGameListUI goK;

            {
                this.goK = r1;
            }

            public final void lt(int i) {
                if (i <= 0) {
                    this.goK.goB.setVisibility(8);
                    this.goK.goD.setVisibility(0);
                    return;
                }
                this.goK.goB.setVisibility(0);
                this.goK.goD.setVisibility(8);
            }
        };
        this.goB.setVerticalScrollBarEnabled(false);
        this.goB.setOnItemClickListener(this);
        this.goB.setAdapter(this.goC);
        vD(2131233102);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AuthorizedGameListUI goK;

            {
                this.goK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.goK.finish();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        au.ash().b(3, this);
        if (this.goC != null) {
            this.goC.clear();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent(this, GameSettingsUI.class);
        this.goE = i;
        intent.putExtra("game_app_id", ((dk) this.goC.getItem(i)).gkz);
        intent.putExtra("game_report_from_scene", this.gjl);
        startActivityForResult(intent, 0);
        af.a((Context) this, 10, 1008, goG, 6, this.gjl, null);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 0) {
            v.e("MicroMsg.AuthorizedGameListUI", "invaild requestcode" + i);
            return;
        }
        if (i2 == -1) {
            this.goC.remove(this.goE);
            af.a(this.nDR.nEl, 10, 1008, goH, 21, 1, intent.getStringExtra("game_app_id"), this.gjl, 0, null, null, null);
        }
        if (this.goC != null) {
            this.goC.notifyDataSetChanged();
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.pluginsdk.model.app.v vVar) {
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
        }
        if (i == 0 && i2 == 0) {
            LinkedList linkedList = ((so) ((al) vVar).fut.czl.czs).mwn;
            if (linkedList == null || linkedList.size() == 0) {
                v.d("MicroMsg.AuthorizedGameListUI", "no authapp");
            }
            this.goC.H(linkedList);
            return;
        }
        Toast.makeText(this, getString(2131233099, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
    }
}
