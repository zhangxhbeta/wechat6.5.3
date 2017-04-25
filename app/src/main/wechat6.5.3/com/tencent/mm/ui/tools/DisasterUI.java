package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public class DisasterUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.DisasterUI", "onCreate :%d", Integer.valueOf(hashCode()));
        CharSequence stringExtra = getIntent().getStringExtra("key_disaster_content");
        final String stringExtra2 = getIntent().getStringExtra("key_disaster_url");
        ((TextView) findViewById(2131756613)).setText(stringExtra);
        findViewById(2131756614).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DisasterUI oSm;

            public final void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringExtra2));
                this.oSm.startActivity(intent);
            }
        });
        Fd(getString(2131233287));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ DisasterUI oSm;

            {
                this.oSm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oSm.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903466;
    }

    public final boolean bkk() {
        return false;
    }
}
