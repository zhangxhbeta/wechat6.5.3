package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.ui.MMActivity;

public class ReaderAppIntroUI extends MMActivity {
    private int blO = 0;

    protected final int getLayoutId() {
        return 2130904237;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        ImageView imageView = (ImageView) findViewById(2131758783);
        TextView textView = (TextView) findViewById(2131758784);
        this.blO = getIntent().getIntExtra("type", 0);
        if (this.blO == 20) {
            vD(2131233260);
            imageView.setImageResource(2130839027);
            textView.setText(2131232132);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReaderAppIntroUI iln;

            {
                this.iln = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iln.finish();
                return true;
            }
        });
        a(0, 2131165208, new OnMenuItemClickListener(this) {
            final /* synthetic */ ReaderAppIntroUI iln;

            {
                this.iln = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                a.drp.d(new Intent().putExtra("Contact_User", bc.eO(this.iln.blO)), this.iln);
                this.iln.finish();
                return true;
            }
        });
    }
}
