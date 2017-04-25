package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.j;

final class a extends j<ab> implements b {
    private final MMActivity aWn;
    protected f euc;
    protected c eud;
    protected e eue;
    protected d euf = MMSlideDelView.bCp();

    public static class a {
        public ImageView dtX;
        public TextView euh;
        public TextView eui;
        public TextView euj;
        public ImageView euk;
        public TextView eul;
        public View eum;
        public TextView eun;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ab) obj;
        if (obj == null) {
            obj = new ab();
        }
        obj.cu("");
        obj.cv("");
        obj.b(cursor);
        return obj;
    }

    public a(Context context, com.tencent.mm.ui.j.a aVar) {
        super(context, new ab());
        this.nDK = aVar;
        this.aWn = (MMActivity) context;
    }

    public final void Ol() {
        ak.yW();
        setCursor(com.tencent.mm.model.c.wK().bvL());
        if (this.nDK != null) {
            this.nDK.Oi();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void a(f fVar) {
        this.euc = fVar;
    }

    public final void a(e eVar) {
        this.eue = eVar;
    }

    public final void a(c cVar) {
        this.eud = cVar;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        if (this.euf != null) {
            this.euf.avm();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence string;
        int i2;
        ab abVar = (ab) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            MMSlideDelView mMSlideDelView = (MMSlideDelView) View.inflate(this.aWn, 2130903162, null);
            View inflate = View.inflate(this.aWn, 2130904547, null);
            aVar2.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar2.euh = (TextView) inflate.findViewById(2131756539);
            aVar2.eui = (TextView) inflate.findViewById(2131756540);
            aVar2.euj = (TextView) inflate.findViewById(2131756541);
            aVar2.euk = (ImageView) inflate.findViewById(2131759571);
            aVar2.eul = (TextView) inflate.findViewById(2131755330);
            aVar2.eum = mMSlideDelView.findViewById(2131755551);
            aVar2.eun = (TextView) mMSlideDelView.findViewById(2131755552);
            mMSlideDelView.setView(inflate);
            mMSlideDelView.euc = this.euc;
            mMSlideDelView.eud = this.eud;
            mMSlideDelView.euf = this.euf;
            mMSlideDelView.gMt = false;
            mMSlideDelView.setTag(aVar2);
            aVar = aVar2;
            view = mMSlideDelView;
        } else {
            aVar = (a) view.getTag();
        }
        ak.yW();
        aVar.euh.setText(y(com.tencent.mm.model.c.wH().LX(abVar.field_username)));
        TextView textView = aVar.eui;
        if (abVar.field_status == 1) {
            string = this.aWn.getString(2131233725);
        } else {
            string = o.c(this.aWn, abVar.field_conversationTime, true);
        }
        textView.setText(string);
        com.tencent.mm.pluginsdk.ui.a.b.m(aVar.dtX, u.LM(abVar.field_username));
        ak.yW();
        aVar.euj.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.aWn, com.tencent.mm.model.c.wK().nuA.a(abVar.field_isSend, abVar.field_username, abVar.field_content, py(abVar.field_msgType), this.aWn), aVar.euj.getTextSize()));
        aVar.euj.setTextColor(com.tencent.mm.bd.a.M(this.aWn, 2131690163));
        if (py(abVar.field_msgType) == 34 && abVar.field_isSend == 0 && !be.kS(abVar.field_content) && !new n(abVar.field_content).dhD) {
            aVar.euj.setTextColor(com.tencent.mm.bd.a.M(this.aWn, 2131690164));
        }
        switch (abVar.field_status) {
            case 0:
                i2 = -1;
                break;
            case 1:
                i2 = 2131165723;
                break;
            case 2:
                i2 = -1;
                break;
            case 5:
                i2 = 2131165722;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 != -1) {
            aVar.euk.setBackgroundResource(i2);
            aVar.euk.setVisibility(0);
        } else {
            aVar.euk.setVisibility(8);
        }
        aVar.eum.setTag(abVar.field_username);
        aVar.eum.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a eug;

            {
                this.eug = r1;
            }

            public final void onClick(View view) {
                v.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
                this.eug.euf.avn();
                if (this.eug.eue != null) {
                    this.eug.eue.aE(view.getTag());
                }
            }
        });
        i2 = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        if (abVar.field_unReadCount > 100) {
            aVar.eul.setText("...");
            aVar.eul.setVisibility(0);
            v.v("MicroMsg.BottleConversationAdapter", "has unread 100");
        } else if (abVar.field_unReadCount > 0) {
            aVar.eul.setText(abVar.field_unReadCount);
            aVar.eul.setVisibility(0);
            v.v("MicroMsg.BottleConversationAdapter", "has unread");
        } else {
            aVar.eul.setVisibility(4);
            v.v("MicroMsg.BottleConversationAdapter", "no unread");
        }
        view.setBackgroundResource(2130838666);
        view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
        return view;
    }

    final String y(u uVar) {
        return com.tencent.mm.plugin.bottle.a.c.a(this.aWn, uVar);
    }

    private static int py(String str) {
        int i = 1;
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    protected final void Om() {
        Ol();
    }
}
