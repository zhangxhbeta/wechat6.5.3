package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;

public class SelectDateUI extends MMActivity implements a {
    private p dFI = null;
    private long eQi = -1;
    private DayPickerView eSH;
    private String eSI;
    private HashMap<String, com.tencent.mm.plugin.chatroom.c.a> eSJ;
    private ac mHandler;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.chatroom.ui.SelectDateUI r10) {
        /*
        r9 = 1;
        r8 = 0;
        r2 = java.lang.System.currentTimeMillis();
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r1 = r10.eSI;
        r1 = r0.ME(r1);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0054 }
        if (r0 == 0) goto L_0x0083;
    L_0x0019:
        r0 = r1.isAfterLast();	 Catch:{ Exception -> 0x0054 }
        if (r0 != 0) goto L_0x0083;
    L_0x001f:
        r4 = -1;
        r6 = r10.eQi;	 Catch:{ Exception -> 0x0054 }
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x002e;
    L_0x0027:
        r0 = 0;
        r4 = r1.getLong(r0);	 Catch:{ Exception -> 0x0054 }
        r10.eQi = r4;	 Catch:{ Exception -> 0x0054 }
    L_0x002e:
        r0 = new com.tencent.mm.plugin.chatroom.c.a;	 Catch:{ Exception -> 0x0054 }
        r4 = 0;
        r4 = r1.getLong(r4);	 Catch:{ Exception -> 0x0054 }
        r0.<init>(r4);	 Catch:{ Exception -> 0x0054 }
        r4 = 1;
        r4 = r1.getLong(r4);	 Catch:{ Exception -> 0x0054 }
        r0.bao = r4;	 Catch:{ Exception -> 0x0054 }
        r4 = r0.toString();	 Catch:{ Exception -> 0x0054 }
        r5 = r10.eSJ;	 Catch:{ Exception -> 0x0054 }
        r5 = r5.containsKey(r4);	 Catch:{ Exception -> 0x0054 }
        if (r5 != 0) goto L_0x0050;
    L_0x004b:
        r5 = r10.eSJ;	 Catch:{ Exception -> 0x0054 }
        r5.put(r4, r0);	 Catch:{ Exception -> 0x0054 }
    L_0x0050:
        r1.moveToNext();	 Catch:{ Exception -> 0x0054 }
        goto L_0x0019;
    L_0x0054:
        r0 = move-exception;
        r4 = "MicroMsg.SelectDateUI";
        r0 = r0.toString();	 Catch:{ all -> 0x0087 }
        com.tencent.mm.sdk.platformtools.v.e(r4, r0);	 Catch:{ all -> 0x0087 }
        r1.close();
    L_0x0062:
        r0 = "MicroMsg.SelectDateUI";
        r1 = "[prepareData] time:%s";
        r4 = new java.lang.Object[r9];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = java.lang.System.currentTimeMillis();
        r2 = r6 - r2;
        r2 = r5.append(r2);
        r2 = r2.toString();
        r4[r8] = r2;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r4);
        return;
    L_0x0083:
        r1.close();
        goto L_0x0062;
    L_0x0087:
        r0 = move-exception;
        r1.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.chatroom.ui.SelectDateUI.a(com.tencent.mm.plugin.chatroom.ui.SelectDateUI):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131234660);
        this.eSH = (DayPickerView) findViewById(2131759033);
        this.eSJ = new HashMap();
        this.mHandler = new ac(getMainLooper());
        this.eSI = getIntent().getStringExtra("detail_username");
        e.a(new Runnable(this) {
            final /* synthetic */ SelectDateUI eSK;

            {
                this.eSK = r1;
            }

            public final void run() {
                SelectDateUI.a(this.eSK);
                this.eSK.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 eSL;

                    {
                        this.eSL = r1;
                    }

                    public final void run() {
                        this.eSL.eSK.eSH.eQi = this.eSL.eSK.eQi == -1 ? System.currentTimeMillis() * 1000 : this.eSL.eSK.eQi;
                        this.eSL.eSK.eSH.a(this.eSL.eSK, this.eSL.eSK.eSJ.values());
                    }
                });
            }
        }, "prepare_data");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SelectDateUI eSK;

            {
                this.eSK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eSK.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130904325;
    }

    public final long acZ() {
        return System.currentTimeMillis();
    }

    public final void a(com.tencent.mm.plugin.chatroom.c.a aVar) {
        if (aVar == null) {
            v.e("MicroMsg.SelectDateUI", "null == calendarDay");
            return;
        }
        v.i("MicroMsg.SelectDateUI", "Day Selected timestamp:%s day:%s month:%s year:%s", new Object[]{Long.valueOf(aVar.eOL), Integer.valueOf(aVar.evg), Integer.valueOf(aVar.month), Integer.valueOf(aVar.year)});
        v.i("MicroMsg.SelectDateUI", "[goToChattingUI] msgLocalId:%s", new Object[]{Long.valueOf(aVar.bao)});
        com.tencent.mm.plugin.chatroom.a.drp.e(new Intent().putExtra("Chat_User", this.eSI).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", r0), this);
    }
}
