package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ar.f;
import com.tencent.mm.ar.h;
import com.tencent.mm.ar.j;
import com.tencent.mm.ar.l;
import com.tencent.mm.e.a.hl;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;

public class FMessageListView extends LinearLayout {
    private Context context;
    private final LayoutParams gut;
    com.tencent.mm.pluginsdk.ui.preference.a.a lPk;
    private com.tencent.mm.pluginsdk.d.a lPq;
    private com.tencent.mm.sdk.h.g.a lPr;
    private com.tencent.mm.sdk.h.g.a lPs;
    a lPt;
    a lPu;
    private TextView lPv;

    static class a extends View {
        public a(Context context) {
            super(context);
            setLayoutParams(new LayoutParams(-1, 1));
        }
    }

    static /* synthetic */ void a(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.FMessageListView", "updateLbs, id is null");
            return;
        }
        long j;
        try {
            j = be.getLong(str, 0);
        } catch (Exception e) {
            v.e("MicroMsg.FMessageListView", "updateLbs, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            v.e("MicroMsg.FMessageListView", "updateLbs fail, sysRowId is invalid");
            return;
        }
        v.d("MicroMsg.FMessageListView", "updateLbs succ, sysRowId = " + j);
        h hVar = new h();
        if (!l.KE().b(j, hVar)) {
            v.e("MicroMsg.FMessageListView", "updateLbs, get fail, id = " + j);
        } else if (fMessageListView.lPk == null || !fMessageListView.lPk.bdo.equals(hVar.field_sayhiuser)) {
            v.d("MicroMsg.FMessageListView", "updateLbs, other talker, no need to process");
        } else {
            if (fMessageListView.lPk.hUb != null && fMessageListView.lPk.hUb.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, hVar));
        }
    }

    static /* synthetic */ void b(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.FMessageListView", "updateFMsg, id is null");
            return;
        }
        long j;
        try {
            j = be.getLong(str, 0);
        } catch (Exception e) {
            v.e("MicroMsg.FMessageListView", "updateFMsg, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            v.e("MicroMsg.FMessageListView", "updateFMsg fail, sysRowId is invalid");
            return;
        }
        v.d("MicroMsg.FMessageListView", "updateFMsg succ, sysRowId = " + j);
        f fVar = new f();
        if (!l.KC().b(j, fVar)) {
            v.e("MicroMsg.FMessageListView", "updateFMsg, get fail, id = " + j);
        } else if (fMessageListView.lPk == null || !fMessageListView.lPk.bdo.equals(fVar.field_talker)) {
            v.d("MicroMsg.FMessageListView", "updateFMsg, other talker, no need to process");
        } else {
            if (fMessageListView.lPk.hUb != null && fMessageListView.lPk.hUb.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, fVar));
        }
    }

    static /* synthetic */ void c(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.FMessageListView", "updateShake, id is null");
            return;
        }
        long j;
        try {
            j = be.getLong(str, 0);
        } catch (Exception e) {
            v.e("MicroMsg.FMessageListView", "updateShake, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            v.e("MicroMsg.FMessageListView", "updateShake fail, sysRowId is invalid");
            return;
        }
        v.d("MicroMsg.FMessageListView", "updateShake succ, sysRowId = " + j);
        j jVar = new j();
        if (!l.KF().b(j, jVar)) {
            v.e("MicroMsg.FMessageListView", "updateShake, get fail, id = " + j);
        } else if (fMessageListView.lPk == null || !fMessageListView.lPk.bdo.equals(jVar.field_sayhiuser)) {
            v.d("MicroMsg.FMessageListView", "updateShake, other talker, no need to process");
        } else {
            if (fMessageListView.lPk.hUb != null && fMessageListView.lPk.hUb.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, jVar));
        }
    }

    public FMessageListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FMessageListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.lPq = new com.tencent.mm.pluginsdk.d.a(this) {
            final /* synthetic */ FMessageListView lPw;

            {
                this.lPw = r1;
            }

            public final void w(b bVar) {
                if (bVar instanceof hl) {
                    FMessageListView.a(this.lPw, ((hl) bVar).bhf.aXv);
                }
            }
        };
        this.lPr = new com.tencent.mm.sdk.h.g.a(this) {
            final /* synthetic */ FMessageListView lPw;

            {
                this.lPw = r1;
            }

            public final void a(String str, i iVar) {
                FMessageListView.b(this.lPw, str);
            }
        };
        this.lPs = new com.tencent.mm.sdk.h.g.a(this) {
            final /* synthetic */ FMessageListView lPw;

            {
                this.lPw = r1;
            }

            public final void a(String str, i iVar) {
                FMessageListView.c(this.lPw, str);
            }
        };
        this.gut = new LayoutParams(-1, -2);
        this.context = context;
        l.KC().c(this.lPr);
        com.tencent.mm.pluginsdk.d.a.a(hl.class.getName(), this.lPq);
        l.KF().c(this.lPs);
    }

    public final void detach() {
        l.KC().d(this.lPr);
        com.tencent.mm.pluginsdk.d.a.b(hl.class.getName(), this.lPq);
        l.KF().d(this.lPs);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof a) {
                a aVar = (a) childAt;
                ak.vy().b(30, aVar);
                if (aVar.dwg != null && aVar.dwg.isShowing()) {
                    aVar.dwg.dismiss();
                }
            }
        }
        this.lPt = null;
        this.lPu = null;
    }

    public final void a(final b bVar) {
        if (bVar == null) {
            v.e("MicroMsg.FMessageListView", "addItem fail, provider is null");
        } else if (bVar.id <= 0) {
            v.e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + bVar.id);
        } else {
            int i;
            String string;
            int childCount = getChildCount();
            for (i = 1; i < childCount; i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof a) && childAt.getTag() != null && childAt.getTag().equals(Long.valueOf(bVar.id))) {
                    v.w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + bVar.id);
                    return;
                }
            }
            if (bVar.lPz != null) {
                if (this.lPv == null) {
                    this.lPv = (TextView) findViewById(2131756481);
                }
                this.lPv.setText(bVar.lPz);
                this.lPv.setVisibility(0);
            }
            v.d("MicroMsg.FMessageListView", "addItem, current child count = " + childCount);
            if (childCount == 6) {
                v.i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
                removeViewAt(1);
            }
            if (childCount == 1) {
                v.d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
                this.lPt = new a(this.context);
                addView(this.lPt);
                this.lPu = new a(this.context);
                this.lPu.HN("");
                this.lPu.ur(0);
                addView(this.lPu, this.gut);
                ak.yW();
                u LX = c.wH().LX(bVar.username);
                if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
                    v.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + bVar.username);
                    this.lPt.setVisibility(0);
                    this.lPu.setVisibility(0);
                } else {
                    v.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + bVar.username);
                    this.lPt.setVisibility(8);
                    this.lPu.setVisibility(8);
                }
            }
            if (bVar.cFQ) {
                string = this.context.getString(2131232850, new Object[]{bVar.cqK});
                i = 0;
            } else {
                String str;
                if (bVar.cID == null || bVar.cID.length() <= 0) {
                    str = bVar.username;
                    ak.yW();
                    u LX2 = c.wH().LX(bVar.username);
                    if (LX2 != null && ((int) LX2.chr) > 0) {
                        str = LX2.tU();
                    }
                } else {
                    str = bVar.cID;
                }
                string = str + ": " + bVar.cqK;
                i = 1;
            }
            View aVar = new a(this.context);
            aVar.setTag(Long.valueOf(bVar.id));
            aVar.HN(string);
            aVar.ur(8);
            if (i != 0) {
                aVar.setOnLongClickListener(new OnLongClickListener(this) {
                    final /* synthetic */ FMessageListView lPw;

                    public final boolean onLongClick(View view) {
                        v.d("MicroMsg.FMessageListView", "jacks long click digest");
                        g.a(this.lPw.getContext(), null, new String[]{this.lPw.getContext().getString(2131231773)}, new g.c(this) {
                            final /* synthetic */ AnonymousClass4 lPy;

                            {
                                this.lPy = r1;
                            }

                            public final void gT(int i) {
                                switch (i) {
                                    case 0:
                                        ((ClipboardManager) this.lPy.lPw.getContext().getSystemService("clipboard")).setText(bVar.cqK);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                        return true;
                    }
                });
            }
            addView(aVar, getChildCount() - 2, this.gut);
        }
    }
}
