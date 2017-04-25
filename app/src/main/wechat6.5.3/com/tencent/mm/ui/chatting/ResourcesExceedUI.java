package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mmdb.database.SQLiteDatabase;

public class ResourcesExceedUI extends MMActivity {
    private TextView oyO;
    private int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("clean_view_type", 0);
        Fd(SQLiteDatabase.KeyEmpty);
        NI();
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ResourcesExceedUI oyP;

            {
                this.oyP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oyP.finish();
                return true;
            }
        });
        this.oyO = (TextView) findViewById(2131756625);
        switch (this.type) {
            case 0:
                this.oyO.setText(2131235790);
                return;
            case 1:
                this.oyO.setText(2131233293);
                return;
            case 2:
                this.oyO.setText(2131232768);
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return 2130904281;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
