package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k.b;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public class SayHiEditUI extends MMActivity implements e {
    private ProgressDialog dwR = null;
    private MMEditText oIg;

    static /* synthetic */ String a(SayHiEditUI sayHiEditUI) {
        String trim = sayHiEditUI.oIg.getText().toString().trim();
        return trim.length() <= 50 ? trim : trim.substring(0, 50);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(30, (e) this);
        vD(2131234000);
        NI();
    }

    protected final int getLayoutId() {
        return 2130904284;
    }

    public void onDestroy() {
        ak.vy().b(30, (e) this);
        super.onDestroy();
    }

    protected final void NI() {
        this.oIg = (MMEditText) findViewById(2131758941);
        c.b(this.oIg).yn(100).a(null);
        final String stringExtra = getIntent().getStringExtra("Contact_User");
        final int intExtra = getIntent().getIntExtra("Contact_Scene", 18);
        a(0, getString(2131231149), new OnMenuItemClickListener(this) {
            final /* synthetic */ SayHiEditUI oIh;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oIh.axg();
                List linkedList = new LinkedList();
                linkedList.add(stringExtra);
                List linkedList2 = new LinkedList();
                linkedList2.add(Integer.valueOf(intExtra));
                final k mVar = new m(2, linkedList, linkedList2, SayHiEditUI.a(this.oIh), SQLiteDatabase.KeyEmpty);
                ak.vy().a(mVar, 0);
                SayHiEditUI sayHiEditUI = this.oIh;
                Context context = this.oIh.nDR.nEl;
                this.oIh.getString(2131231164);
                sayHiEditUI.dwR = g.a(context, this.oIh.getString(2131234922), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass1 oIi;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(mVar);
                    }
                });
                return false;
            }
        }, b.nET);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SayHiEditUI oIh;

            {
                this.oIh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oIh.finish();
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj = 1;
        v.i("MicroMsg.SayHiEditUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.dwR != null) {
                this.dwR.dismiss();
                this.dwR = null;
            }
            switch (i2) {
                case -34:
                case -24:
                    Toast.makeText(this, 2131234004, 0).show();
                    break;
                case -22:
                    Toast.makeText(this, 2131234001, 0).show();
                    break;
                default:
                    obj = null;
                    break;
            }
            if (obj == null) {
                if (i == 0 && i2 == 0) {
                    g.bf(this, getString(2131231978));
                    finish();
                } else if (i == 4 && i2 == -24 && !t.kS(str)) {
                    Toast.makeText(this, str, 1).show();
                } else {
                    Toast.makeText(this, 2131234002, 0).show();
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.SayHiEditUI", "exception in onSceneEnd : " + e.getMessage());
        }
    }
}
