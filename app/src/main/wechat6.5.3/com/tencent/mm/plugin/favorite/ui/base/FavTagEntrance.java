package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.be;
import java.util.List;

public class FavTagEntrance extends LinearLayout implements a {
    private long bjH = -1;
    private TextView fQc;
    private String fQd = String.valueOf(this.bjH);

    public FavTagEntrance(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.fQc = (TextView) findViewById(2131757006);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavTagEntrance fQe;

            {
                this.fQe = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.fQe.getContext(), FavTagEditUI.class);
                intent.putExtra("key_fav_scene", 1);
                intent.putExtra("key_fav_item_id", this.fQe.bjH);
                this.fQe.getContext().startActivity(intent);
            }
        });
    }

    public final void bQ(long j) {
        this.bjH = j;
        this.fQd = String.valueOf(j);
    }

    public final void av(List<String> list) {
        if (this.fQc != null) {
            CharSequence a = v.a(getContext(), (List) list);
            if (be.kS(a)) {
                this.fQc.setText("");
                this.fQc.setHint(2131232651);
                return;
            }
            this.fQc.setText(e.a(getContext(), a, this.fQc.getTextSize()));
        }
    }

    public final void a(String str, i iVar) {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavTagEntrence", "on notify change event %s, favIDStr %s", new Object[]{str, this.fQd});
        if (this.fQd.equals(str)) {
            com.tencent.mm.plugin.favorite.b.i bB = h.alu().bB(this.bjH);
            if (bB == null) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavTagEntrence", "id[%d] info is null, return", new Object[]{Long.valueOf(this.bjH)});
                return;
            }
            av(bB.field_tagProto.mub);
        }
    }
}
