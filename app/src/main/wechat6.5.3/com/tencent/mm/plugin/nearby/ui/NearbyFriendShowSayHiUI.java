package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ar.h;
import com.tencent.mm.ar.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.MMActivity;

public class NearbyFriendShowSayHiUI extends MMActivity {
    ImageView dtX;
    String hFe = "";
    View hFf = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131234007);
        NI();
    }

    protected void onResume() {
        super.onResume();
        TextView textView = (TextView) findViewById(2131757422);
        int Kw = l.KE().Kw();
        if (Kw == 0) {
            this.hFf.setVisibility(4);
            return;
        }
        textView.setText(getResources().getQuantityString(2131361818, Kw, new Object[]{Integer.valueOf(Kw)}));
        this.dtX = (ImageView) findViewById(2131757421);
        h Kx = l.KE().Kx();
        if (Kx != null) {
            this.hFe = Kx.field_sayhiuser;
            b.m(this.dtX, this.hFe);
        }
    }

    public void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return 2130904117;
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbyFriendShowSayHiUI hFg;

            {
                this.hFg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hFg.axg();
                this.hFg.finish();
                return true;
            }
        });
        ((Button) findViewById(2131758409)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NearbyFriendShowSayHiUI hFg;

            {
                this.hFg = r1;
            }

            public final void onClick(View view) {
                this.hFg.startActivity(new Intent(this.hFg, NearbyFriendsUI.class));
            }
        });
        this.hFf = findViewById(2131757420);
        this.hFf.setVisibility(0);
        this.hFf.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NearbyFriendShowSayHiUI hFg;

            {
                this.hFg = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.hFg, NearbySayHiListUI.class);
                intent.putExtra("k_say_hi_type", 2);
                intent.putExtra("show_clear_header", true);
                this.hFg.startActivityForResult(intent, 2009);
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2009 && i2 == -1) {
            finish();
        }
    }
}
