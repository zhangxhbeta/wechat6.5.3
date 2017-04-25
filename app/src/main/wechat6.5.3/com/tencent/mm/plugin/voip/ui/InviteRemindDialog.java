package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.az.d.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class InviteRemindDialog extends MMBaseActivity {
    private String bdo = "";
    private TextView dID;
    private TextView kxg;
    private int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130904081);
        this.dID = (TextView) findViewById(2131757308);
        this.kxg = (TextView) findViewById(2131757309);
        this.bdo = getIntent().getStringExtra("InviteRemindDialog_User");
        this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
        if (this.type == 0) {
            this.dID.setText(getString(2131235943));
            this.kxg.setText(getString(2131235921));
        } else if (this.type == 1) {
            this.dID.setText(getString(2131235964));
            this.kxg.setText(getString(2131235959));
        }
        findViewById(2131756397).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InviteRemindDialog kxh;

            {
                this.kxh = r1;
            }

            public final void onClick(View view) {
                if (this.kxh.bdo != null) {
                    try {
                        ak.yW();
                        Map Iq = a.Iq((String) c.vf().get(77829, null));
                        a aVar;
                        if (Iq != null) {
                            if (Iq != null && Iq.size() > 0) {
                                if (Iq.containsKey(this.kxh.bdo)) {
                                    aVar = (a) Iq.get(this.kxh.bdo);
                                    aVar.cUl++;
                                    Iq.put(this.kxh.bdo, aVar);
                                } else {
                                    aVar = new a();
                                    aVar.cUl++;
                                    Iq.put(this.kxh.bdo, aVar);
                                }
                            }
                            ak.yW();
                            c.vf().set(77829, a.T(Iq));
                            for (Entry value : Iq.entrySet()) {
                                aVar = (a) value.getValue();
                                v.d("MMInviteRemindDialog", "val " + aVar.hitCount + " " + aVar.cUl);
                            }
                        } else {
                            Map hashMap = new HashMap();
                            a aVar2 = new a();
                            aVar2.cUl++;
                            hashMap.put(this.kxh.bdo, aVar2);
                            ak.yW();
                            c.vf().set(77829, a.T(hashMap));
                            for (Entry value2 : hashMap.entrySet()) {
                                aVar = (a) value2.getValue();
                                v.d("MMInviteRemindDialog", "val " + aVar.hitCount + " " + aVar.cUl);
                            }
                        }
                    } catch (Throwable e) {
                        v.a("MMInviteRemindDialog", e, "", new Object[0]);
                    }
                }
                String string = this.kxh.type == 0 ? this.kxh.getString(2131235920) : this.kxh.type == 1 ? this.kxh.getString(2131235958) : null;
                ak.vy().a(new com.tencent.mm.plugin.voip.model.c(this.kxh.bdo, string, m.fp(this.kxh.bdo)), 0);
                Intent intent = new Intent();
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", this.kxh.bdo);
                com.tencent.mm.plugin.voip.a.a.drp.e(intent, this.kxh);
                this.kxh.finish();
            }
        });
        findViewById(2131756396).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InviteRemindDialog kxh;

            {
                this.kxh = r1;
            }

            public final void onClick(View view) {
                this.kxh.finish();
            }
        });
    }

    public void finish() {
        super.finish();
    }

    public static void g(Context context, String str, int i) {
        Intent intent = new Intent(context, InviteRemindDialog.class);
        intent.putExtra("InviteRemindDialog_User", str);
        intent.putExtra("InviteRemindDialog_Type", i);
        context.startActivity(intent);
    }
}
