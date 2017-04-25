package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.ai;
import com.tencent.mm.plugin.game.d.ch;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class GameDetailRankLikedUI extends MMActivity {
    private static final String TAG = ("MicroMsg" + GameDetailRankLikedUI.class.getSimpleName());
    private Dialog dQN;
    private ListView grn;
    private a gro;

    private static class a extends BaseAdapter {
        List<ch> grq = new LinkedList();
        private Context mContext;

        private static class a {
            public ImageView cHH;
            public TextView grb;
            public TextView grr;

            private a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return lz(i);
        }

        public a(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            return this.grq.size();
        }

        private ch lz(int i) {
            return (ch) this.grq.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(2130903715, viewGroup, false);
                a aVar2 = new a();
                aVar2.cHH = (ImageView) view.findViewById(2131757287);
                aVar2.grb = (TextView) view.findViewById(2131757288);
                aVar2.grr = (TextView) view.findViewById(2131757289);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            ch lz = lz(i);
            b.a(aVar.cHH, lz.gon, 0.5f, false);
            ak.yW();
            u LX = c.wH().LX(lz.gon);
            if (LX != null) {
                aVar.grb.setText(new SpannableString(e.a(this.mContext, LX.tU(), aVar.grb.getTextSize())));
            } else {
                aVar.grb.setText("");
            }
            aVar.grr.setText(lz.goo);
            return view;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        String stringExtra = getIntent().getStringExtra("extra_appdi");
        if (be.kS(stringExtra)) {
            finish();
            return;
        }
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new ah();
        aVar.czo = new ai();
        aVar.uri = "/cgi-bin/mmgame-bin/getuplist";
        aVar.czm = 1331;
        com.tencent.mm.v.b Bv = aVar.Bv();
        ((ah) Bv.czk.czs).gkz = stringExtra;
        com.tencent.mm.v.u.a(Bv, new com.tencent.mm.v.u.a(this) {
            final /* synthetic */ GameDetailRankLikedUI grp;

            {
                this.grp = r1;
            }

            public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                if (i == 0 && i2 == 0) {
                    ai aiVar = (ai) bVar.czl.czs;
                    a a = this.grp.gro;
                    Collection collection = aiVar.gmy;
                    if (collection != null) {
                        a.grq.clear();
                        a.grq.addAll(collection);
                        a.notifyDataSetChanged();
                    }
                    this.grp.dQN.dismiss();
                } else {
                    v.e(GameDetailRankLikedUI.TAG, "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    this.grp.finish();
                }
                return 0;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903714;
    }

    protected final void NI() {
        vD(2131233073);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameDetailRankLikedUI grp;

            {
                this.grp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.grp.finish();
                return true;
            }
        });
        this.grn = (ListView) findViewById(2131757286);
        this.gro = new a(this);
        this.grn.setAdapter(this.gro);
        this.dQN = com.tencent.mm.plugin.game.e.c.ca(this.nDR.nEl);
        this.dQN.show();
    }
}
