package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Selection;
import android.text.Spannable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k.b;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.v.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SayHiWithSnsPermissionUI extends MMActivity implements e {
    private String biB;
    private ProgressDialog dwR = null;
    private EditText hXv;
    private MMSwitchBtn hXw;
    private CharSequence hXx = null;
    String userName;

    static /* synthetic */ String a(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        String trim = sayHiWithSnsPermissionUI.hXv.getText().toString().trim();
        return trim.length() <= 50 ? trim : trim.substring(0, 50);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(30, this);
        this.biB = getIntent().getStringExtra("room_name");
        NI();
    }

    protected final int getLayoutId() {
        return 2130904287;
    }

    public void onDestroy() {
        ak.vy().b(30, this);
        super.onDestroy();
    }

    protected final void NI() {
        this.hXv = (EditText) findViewById(2131758941);
        this.hXv.setMinHeight(this.nDR.nEl.getResources().getDimensionPixelSize(2131493145));
        this.hXw = (MMSwitchBtn) findViewById(2131758945).findViewById(2131755241);
        this.hXw.kq(false);
        c.b(this.hXv).yn(100).a(null);
        this.hXv.setFilters(i.lTR);
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(294913, null);
        String xH = k.xH();
        if (xH == null) {
            xH = "";
        }
        String string = getString(2131234918);
        if (string.length() + xH.length() > 50) {
            xH = xH.substring(0, 50 - string.length());
        }
        int indexOf = string.indexOf("%s");
        this.hXx = com.tencent.mm.pluginsdk.ui.d.e.a(this.nDR.nEl, String.format(string, new Object[]{xH}), this.hXv.getTextSize());
        if (be.kS(str)) {
            this.hXv.append(this.hXx);
            if (indexOf != -1 && indexOf < this.hXx.length() && xH.length() + indexOf <= this.hXx.length()) {
                Selection.setSelection(this.hXv.getEditableText(), indexOf, xH.length() + indexOf);
            }
        } else {
            Spannable a = com.tencent.mm.pluginsdk.ui.d.e.a(this.nDR.nEl, str, this.hXv.getTextSize());
            this.hXv.append(a);
            if (this.hXv.getEditableText().length() >= a.length()) {
                Selection.setSelection(this.hXv.getEditableText(), 0, a.length());
            }
        }
        this.hXv.requestFocus();
        aJs();
        this.userName = getIntent().getStringExtra("Contact_User");
        final int intExtra = getIntent().getIntExtra("Contact_Scene", 9);
        a(0, getString(2131231149), new OnMenuItemClickListener(this) {
            final /* synthetic */ SayHiWithSnsPermissionUI hXz;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i;
                this.hXz.axg();
                List linkedList = new LinkedList();
                linkedList.add(this.hXz.userName);
                List linkedList2 = new LinkedList();
                linkedList2.add(Integer.valueOf(intExtra));
                String a = SayHiWithSnsPermissionUI.a(this.hXz);
                Map hashMap = new HashMap();
                if (this.hXz.hXw.pdq) {
                    i = 1;
                } else {
                    i = 0;
                }
                hashMap.put(this.hXz.userName, Integer.valueOf(i));
                v.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[]{Integer.valueOf(i)});
                final m mVar = new m(2, linkedList, linkedList2, a, "", hashMap, this.hXz.biB);
                String stringExtra = this.hXz.getIntent().getStringExtra("source_from_user_name");
                String stringExtra2 = this.hXz.getIntent().getStringExtra("source_from_nick_name");
                if (!be.kS(stringExtra)) {
                    mVar.dh(stringExtra, stringExtra2);
                }
                ak.vy().a(mVar, 0);
                SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI = this.hXz;
                ActionBarActivity actionBarActivity = this.hXz.nDR.nEl;
                this.hXz.getString(2131231164);
                sayHiWithSnsPermissionUI.dwR = g.a(actionBarActivity, this.hXz.getString(2131234922), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass1 hXB;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(mVar);
                    }
                });
                return false;
            }
        }, b.nET);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SayHiWithSnsPermissionUI hXz;

            {
                this.hXz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hXz.finish();
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        Object obj = 1;
        v.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.dwR != null) {
                this.dwR.dismiss();
                this.dwR = null;
            }
            String trim = this.hXv.getText().toString().trim();
            if (be.kS(trim) || trim.equals(this.hXx)) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(294913, "");
            } else {
                ak.yW();
                com.tencent.mm.model.c.vf().set(294913, trim);
            }
            switch (i2) {
                case -34:
                case -24:
                    Toast.makeText(this, 2131232851, 0).show();
                    break;
                case -22:
                    Toast.makeText(this, 2131234920, 0).show();
                    break;
                default:
                    obj = null;
                    break;
            }
            if (obj == null) {
                if (i == 0 && i2 == 0) {
                    g.bf(this, getString(2131234921));
                    finish();
                } else if (i == 4 && i2 == -24 && !be.kS(str)) {
                    Toast.makeText(this, str, 1).show();
                } else if (i == 4 && i2 == -2 && !be.kS(str)) {
                    g.a(this, str, getString(2131231164), getString(2131231107), null);
                } else {
                    Toast.makeText(this, 2131234920, 0).show();
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + e.getMessage());
        }
    }
}
