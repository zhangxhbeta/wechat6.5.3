package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.ui.MMActivity;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class GameRankUI extends MMActivity {
    private ListView grs;
    private GameRankView gwM;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        GameRankView gameRankView = this.gwM;
        getIntent().getStringExtra("extra_app_id");
        LinkedList linkedList = new LinkedList();
        Serializable serializableExtra = getIntent().getSerializableExtra("extra_user_ranks");
        if (serializableExtra != null && (serializableExtra instanceof List)) {
            linkedList.addAll((List) serializableExtra);
        }
        if (linkedList.size() == 0) {
            gameRankView.gwP.setVisibility(0);
            gameRankView.gwO.setVisibility(8);
            return;
        }
        gameRankView.gwQ.L(linkedList);
        gameRankView.gwO.setAdapter(gameRankView.gwQ);
        gameRankView.gwP.setVisibility(8);
        gameRankView.gwO.setVisibility(0);
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return 2130903748;
    }

    protected final void NI() {
        vD(2131233081);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameRankUI gwN;

            {
                this.gwN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gwN.finish();
                return true;
            }
        });
        this.gwM = (GameRankView) findViewById(2131757354);
        this.grs = (ListView) this.gwM.findViewById(2131757357);
        new View(this).setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(2131493135)));
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(2130903749, this.grs, false);
        View inflate2 = layoutInflater.inflate(2130903749, this.grs, false);
        this.grs.addHeaderView(inflate);
        this.grs.addFooterView(inflate2);
    }
}
