package com.tencent.mm.plugin.extqlauncher.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.extqlauncher.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.d;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.contact.r;
import java.util.List;

public class QLauncherCreateShortcutUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onCreate");
        requestWindowFeature(1);
        setContentView(2130903441);
        Intent intent = new Intent();
        int s = r.s(new int[]{r.oHI, 64, 16384});
        r.do(s, 1);
        intent.putExtra("list_attr", s);
        intent.putExtra("list_type", 12);
        intent.putExtra("stay_in_wechat", false);
        intent.putExtra("titile", getString(2131230883));
        intent.putExtra("block_contact", k.xF());
        c.a(this, ".ui.contact.SelectContactUI", intent, 1);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onActivityResult resultCode = %s", new Object[]{Integer.valueOf(i2)});
        if (i2 != -1) {
            finish();
            return;
        }
        switch (i) {
            case 1:
                if (intent != null) {
                    if (ak.uz()) {
                        List list;
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        if (be.kS(stringExtra)) {
                            list = null;
                        } else {
                            list = be.g(stringExtra.split(","));
                        }
                        if (list != null && list.size() > 0) {
                            v.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames count " + list.size());
                            String xF = k.xF();
                            try {
                                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                                for (int i3 = 0; i3 < list.size(); i3++) {
                                    ak.yW();
                                    u LX = com.tencent.mm.model.c.wH().LX((String) list.get(i3));
                                    if (LX == null || ((int) LX.chr) <= 0) {
                                        v.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
                                        finish();
                                        return;
                                    }
                                    String pr = com.tencent.mm.plugin.base.a.c.pr((String) list.get(i3));
                                    if (be.kS(pr)) {
                                        v.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
                                        finish();
                                        return;
                                    }
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("source_key", com.tencent.mm.plugin.base.a.c.eni);
                                    contentValues.put("owner_id", com.tencent.mm.plugin.base.a.c.pr(xF));
                                    contentValues.put("unique_id", pr);
                                    contentValues.put("container", Integer.valueOf(1));
                                    contentValues.put("item_type", Integer.valueOf(com.tencent.mm.plugin.base.a.c.w(LX)));
                                    contentValues.put("name", l.a(LX, (String) list.get(i3)));
                                    n.AX();
                                    contentValues.put("icon_path", d.s((String) list.get(i3), false));
                                    Intent intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                                    intent2.putExtra("LauncherUI.Shortcut.Username", pr);
                                    intent2.putExtra("LauncherUI.From.Biz.Shortcut", true);
                                    intent2.addFlags(67108864);
                                    contentValues.put("intent", intent2.toUri(0));
                                    contentValuesArr[i3] = contentValues;
                                }
                                getContentResolver().bulkInsert(a.fIM, contentValuesArr);
                                Toast.makeText(this, 2131232602, 0).show();
                                b.alf().alh();
                                break;
                            } catch (Throwable e) {
                                v.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", new Object[]{e.getMessage()});
                                v.a("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", e, "", new Object[0]);
                                Toast.makeText(this, 2131232601, 0).show();
                                break;
                            }
                        }
                        v.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames empty");
                        break;
                    }
                    v.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
                    Toast.makeText(this, 2131232601, 0).show();
                    finish();
                    return;
                }
                break;
        }
        finish();
    }
}
