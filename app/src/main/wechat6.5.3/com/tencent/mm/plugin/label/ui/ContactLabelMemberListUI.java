package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;

public class ContactLabelMemberListUI extends MMActivity {
    private TextView edy;
    private ListView gQL;
    private a gQM;
    private String gQN;
    private String gQO;
    private b gQw = new b(this) {
        final /* synthetic */ ContactLabelMemberListUI gQP;

        {
            this.gQP = r1;
        }

        public final void a(int i, j jVar, Object obj) {
            v.d("MicroMsg.Label.ContactLabelMemberListUI", "event:%d, obj:%s", new Object[]{Integer.valueOf(i), obj});
            if (this.gQP.mHandler != null) {
                this.gQP.mHandler.removeMessages(5001);
                this.gQP.mHandler.sendEmptyMessageDelayed(5001, 300);
            }
        }
    };
    private ac mHandler = new ac(this) {
        final /* synthetic */ ContactLabelMemberListUI gQP;

        {
            this.gQP = r1;
        }

        public final void handleMessage(Message message) {
            v.d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", new Object[]{Integer.valueOf(message.what)});
            switch (message.what) {
                case 5001:
                    this.gQP.avT();
                    return;
                default:
                    v.w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
                    return;
            }
        }
    };

    static /* synthetic */ void a(ContactLabelMemberListUI contactLabelMemberListUI, int i) {
        if (contactLabelMemberListUI.gQM != null && i <= contactLabelMemberListUI.gQM.getCount()) {
            u uVar = contactLabelMemberListUI.gQM.mn(i).euW;
            if (uVar != null && !be.kS(uVar.field_username) && uVar.field_deleteFlag != 1) {
                if (m.fc(uVar.field_username)) {
                    v.e("MicroMsg.Label.ContactLabelMemberListUI", "error, 4.5 do not contain this contact %s", new Object[]{uVar.field_username});
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", uVar.field_username);
                intent.putExtra("Contact_Alias", uVar.pD());
                intent.putExtra("Contact_Nick", uVar.tT());
                intent.putExtra("Contact_QuanPin", uVar.pF());
                intent.putExtra("Contact_PyInitial", uVar.pE());
                intent.putExtra("Contact_Sex", uVar.bBZ);
                intent.putExtra("Contact_Province", uVar.getProvince());
                intent.putExtra("Contact_City", uVar.getCity());
                intent.putExtra("Contact_Signature", uVar.bCj);
                a.drp.d(intent, contactLabelMemberListUI);
            }
        }
    }

    protected final int getLayoutId() {
        return 2130903421;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gQN = getIntent().getStringExtra("label_id");
        this.gQO = getIntent().getStringExtra("label_name");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelMemberListUI gQP;

            {
                this.gQP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gQP.finish();
                return false;
            }
        });
        a(0, getString(2131233458), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelMemberListUI gQP;

            {
                this.gQP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.setClass(this.gQP, ContactLabelEditUI.class);
                intent.putExtra("label_id", this.gQP.gQN);
                intent.putExtra("label_name", this.gQP.gQO);
                this.gQP.startActivityForResult(intent, 10001);
                return false;
            }
        });
        Fd(this.gQO);
        this.gQL = (ListView) findViewById(2131756502);
        this.edy = (TextView) findViewById(2131755597);
        if (be.kS(this.gQN)) {
            v.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
            finish();
        }
        this.gQM = new a(this.nDR.nEl);
        this.gQL.setAdapter(this.gQM);
        this.gQL.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ContactLabelMemberListUI gQP;

            {
                this.gQP = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ContactLabelMemberListUI.a(this.gQP, i);
            }
        });
        this.gQL.setEmptyView(this.edy);
    }

    protected void onResume() {
        ak.yW();
        c.wH().a(this.gQw);
        super.onResume();
        avT();
    }

    protected void onPause() {
        ak.yW();
        c.wH().b(this.gQw);
        super.onPause();
    }

    protected void onDestroy() {
        if (this.gQM != null) {
            this.gQM.avc();
            this.gQM.nDK = null;
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 10001:
                if (i2 == -1) {
                    finish();
                    return;
                } else {
                    avT();
                    return;
                }
            default:
                v.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }

    private void avT() {
        if (this.gQM != null) {
            this.gQM.gQH = com.tencent.mm.pluginsdk.j.a.bmu().vy(this.gQN);
            this.gQM.a(null, null);
        }
        this.gQO = com.tencent.mm.pluginsdk.j.a.bmu().vu(this.gQN);
        if (!be.kS(this.gQO)) {
            Fd(this.gQO);
        }
    }
}
