package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.mm.model.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.f.a.a;

public class FTSTalkerUI extends MMActivity implements c {
    private String bdo;
    private String bkC;
    private int count;
    private ListView iHp;
    private g iIo;

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.nDR.nEl;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bdo = getIntent().getStringExtra("key_talker");
        this.bkC = getIntent().getStringExtra("key_query");
        this.count = getIntent().getIntExtra("key_count", 0);
        if (this.bdo == null || this.bkC == null || this.count == 0) {
            v.e("MicroMsg.FTS.FTSTalkerUI", "Invalid intent extra, 'talker', 'query', 'count' must be set.");
            finish();
            return;
        }
        Fd(l.er(this.bdo));
        this.iIo = new g(this, this.bdo);
        this.iHp = (ListView) findViewById(2131757154);
        this.iHp.setAdapter(this.iIo);
        this.iHp.setOnItemClickListener(this.iIo);
        this.iIo.zj(this.bkC);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FTSTalkerUI iIp;

            {
                this.iIp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iIp.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903690;
    }

    public final void b(a aVar) {
    }

    protected void onDestroy() {
        this.iIo.finish();
        super.onDestroy();
    }
}
