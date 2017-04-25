package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.j.a;
import java.util.LinkedList;

public class SearchConversationResultUI extends MMActivity {
    private ListView oYD;
    private a oYE;
    private String oYF = null;
    private TextView oYG;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        this.oYD = (ListView) findViewById(2131759674);
        this.oYG = (TextView) findViewById(2131755318);
        this.oYE = new a(getApplicationContext(), new a(this) {
            final /* synthetic */ SearchConversationResultUI oYH;

            {
                this.oYH = r1;
            }

            public final void Oj() {
            }

            public final void Oi() {
            }
        });
        if (this.oYE != null) {
            this.oYE.cB(new LinkedList());
        }
        this.oYD.setAdapter(this.oYE);
        this.oYG.setVisibility(8);
        this.username = getIntent().getStringExtra("SearchConversationResult_User");
        this.oYF = getIntent().getStringExtra("SearchConversationResult_Error");
        Fd(getString(2131235837));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SearchConversationResultUI oYH;

            {
                this.oYH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oYH.finish();
                return true;
            }
        });
        this.oYD.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SearchConversationResultUI oYH;

            {
                this.oYH = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.oYH.oYD.getHeaderViewsCount()) {
                    int headerViewsCount = i - this.oYH.oYD.getHeaderViewsCount();
                    ab abVar = (ab) this.oYH.oYE.getItem(headerViewsCount);
                    if (abVar == null) {
                        v.e("MicroMsg.VoiceSearchResultUI", "null user at position = " + headerViewsCount);
                        return;
                    }
                    v.d("MicroMsg.VoiceSearchResultUI", "username " + abVar.field_username);
                    if (m.eI(abVar.field_username)) {
                        if (k.xZ()) {
                            c.b(this.oYH.nDR.nEl, "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                            return;
                        }
                        c.b(this.oYH, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                    } else if (m.eK(abVar.field_username)) {
                        if (k.xW()) {
                            c.b(this.oYH.nDR.nEl, "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                            return;
                        }
                        c.b(this.oYH, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                    } else if (m.eJ(abVar.field_username)) {
                        c.b(this.oYH, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                    } else if (m.eO(abVar.field_username)) {
                        MMAppMgr.cancelNotification(abVar.field_username);
                        c.b(this.oYH, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                    } else if (m.eG(abVar.field_username)) {
                        if (k.yi()) {
                            this.oYH.a(ChattingUI.class, new Intent().putExtra("Chat_User", abVar.field_username).putExtra("finish_direct", true));
                        } else {
                            c.b(this.oYH, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                        }
                    } else if (m.eT(abVar.field_username)) {
                        if (k.yd()) {
                            r0 = new Intent();
                            r0.putExtra("type", 20);
                            c.b(this.oYH, "readerapp", ".ui.ReaderAppUI", r0);
                            return;
                        }
                        c.b(this.oYH, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                    } else if (m.fb(abVar.field_username)) {
                        if (k.ye()) {
                            r0 = new Intent();
                            r0.putExtra("type", 11);
                            c.b(this.oYH, "readerapp", ".ui.ReaderAppUI", r0);
                            return;
                        }
                        c.b(this.oYH, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                    } else if (m.eL(abVar.field_username)) {
                        c.b(this.oYH, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                    } else if (m.eM(abVar.field_username)) {
                        if (k.yg()) {
                            c.b(this.oYH, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                            return;
                        }
                        c.b(this.oYH, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                    } else if (m.eS(abVar.field_username)) {
                        if (k.ya()) {
                            this.oYH.a(ChattingUI.class, new Intent().putExtra("Chat_User", abVar.field_username).putExtra("finish_direct", true));
                        } else {
                            c.b(this.oYH, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                        }
                    } else if (m.eQ(this.oYH.username) || m.eR(this.oYH.username) || m.eN(this.oYH.username) || m.eU(this.oYH.username) || m.eV(this.oYH.username) || m.eH(this.oYH.username) || m.fe(this.oYH.username)) {
                        c.b(this.oYH, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                    } else {
                        this.oYH.a(ChattingUI.class, new Intent().putExtra("Chat_User", abVar.field_username).putExtra("finish_direct", true));
                    }
                }
            }
        });
        String str = this.username;
        this.oYG.setVisibility(8);
        if (this.oYE != null) {
            this.oYE.uU(str);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.oYE.avc();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final int getLayoutId() {
        return 2130904590;
    }
}
