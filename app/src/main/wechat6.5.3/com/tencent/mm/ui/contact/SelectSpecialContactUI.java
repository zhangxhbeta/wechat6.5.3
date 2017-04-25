package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.a;

public class SelectSpecialContactUI extends MMBaseSelectContactUI {
    private int eSM;
    private String title;

    protected final void NH() {
        super.NH();
        this.title = getIntent().getStringExtra("titile");
        this.eSM = getIntent().getIntExtra("list_attr", 0);
    }

    public final void gJ(int i) {
        a xS = bHH().xS(i);
        if (xS != null && xS.euW != null) {
            String str = xS.euW.field_username;
            v.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", str);
            Intent intent = new Intent();
            if (r.dn(this.eSM, 16384)) {
                intent.putExtra("Select_Contact", str);
                setResult(-1, intent);
                finish();
            } else if (r.dn(this.eSM, WXMediaMessage.THUMB_LENGTH_LIMIT)) {
                intent.putExtra("Contact_User", str);
                c.b((Context) this, "profile", ".ui.ContactInfoUI", intent);
                finish();
            } else {
                intent.setClass(this, ChattingUI.class);
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                startActivity(intent);
                finish();
            }
        }
    }

    protected final boolean NJ() {
        return false;
    }

    protected final String NK() {
        return this.title;
    }

    protected final n NL() {
        return new v(this, getIntent().getStringExtra("filter_type"));
    }

    protected final p NM() {
        return null;
    }
}
