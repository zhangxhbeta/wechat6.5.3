package com.tencent.mm.plugin.record.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.e.a.iu;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.f;
import java.util.LinkedList;

public class FavRecordDetailUI extends RecordMsgBaseUI {
    private String fQd = String.valueOf(this.fRB);
    private long fRB = -1;
    private c iqa;
    private com.tencent.mm.sdk.c.c iqb = new com.tencent.mm.sdk.c.c<iu>(this) {
        final /* synthetic */ FavRecordDetailUI iqc;

        {
            this.iqc = r2;
            this.nhz = iu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iu iuVar = (iu) bVar;
            if (this.iqc.fRB == ((long) iuVar.bjk.bjl)) {
                c cs = d.cs((long) iuVar.bjk.bjl);
                a bVar2 = new b();
                bVar2.ipT = cs;
                bVar2.ipS = cs.field_favProto.mtR;
                this.iqc.iqo.a(bVar2);
            }
            return false;
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void aJJ() {
        this.fRB = getIntent().getLongExtra("key_detail_info_id", -1);
        this.iqa = d.cs(this.fRB);
        this.fQd = String.valueOf(this.fRB);
        if (this.iqa == null) {
            finish();
            return;
        }
        a bVar = new b();
        bVar.ipT = this.iqa;
        bVar.ipS = this.iqa.field_favProto.mtR;
        super.aJJ();
        this.iqo.a(bVar);
    }

    protected final h aJK() {
        return new d(this, new c(this));
    }

    protected void onResume() {
        super.onResume();
        a.nhr.e(this.iqb);
        a.nhr.e(((d) this.iqo).ipV);
    }

    protected void onStop() {
        super.onStop();
        a.nhr.f(this.iqb);
        a.nhr.f(((d) this.iqo).ipV);
    }

    protected final String aJL() {
        if (14 == this.iqa.field_type && !be.kS(this.iqa.field_favProto.title)) {
            return this.iqa.field_favProto.title;
        }
        qg qgVar = this.iqa.field_favProto.mtP;
        if (qgVar == null || be.kS(qgVar.mtu)) {
            v.v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", new Object[]{this.iqa.field_fromUser});
            return m.et(this.iqa.field_fromUser);
        }
        String er = l.er(qgVar.mtu);
        String et;
        if (k.xF().equals(qgVar.bhM)) {
            et = m.et(qgVar.toUser);
            if (!be.ah(et, "").equals(qgVar.toUser)) {
                er = er + " - " + et;
            }
        } else {
            et = m.et(qgVar.bhM);
            if (!be.ah(et, "").equals(qgVar.bhM)) {
                er = er + " - " + et;
            }
        }
        v.v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", new Object[]{qgVar.bhM, qgVar.toUser});
        return er;
    }

    protected final String aJM() {
        LinkedList linkedList = this.iqa.field_favProto.mtR;
        if (linkedList.size() > 0) {
            return ((pw) linkedList.getFirst()).msQ;
        }
        return null;
    }

    protected final String aJN() {
        LinkedList linkedList = this.iqa.field_favProto.mtR;
        if (linkedList.size() > 0) {
            return ((pw) linkedList.getLast()).msQ;
        }
        return null;
    }

    protected final void aJO() {
        a(0, 2131235683, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ FavRecordDetailUI iqc;

            {
                this.iqc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                f fVar = new f(this.iqc.nDR.nEl, f.pbS, false);
                fVar.jXn = new n.c(this) {
                    final /* synthetic */ AnonymousClass2 iqd;

                    {
                        this.iqd = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        v.i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", new Object[]{Integer.valueOf(this.iqd.iqc.iqa.field_id), Integer.valueOf(this.iqd.iqc.iqa.field_itemStatus)});
                        if (!(this.iqd.iqc.iqa.field_id <= 0 || this.iqd.iqc.iqa.alA() || this.iqd.iqc.iqa.alB())) {
                            lVar.d(0, this.iqd.iqc.getString(2131232731));
                        }
                        lVar.d(3, this.iqd.iqc.getString(2131232647));
                        lVar.d(2, this.iqd.iqc.getString(2131231020));
                    }
                };
                fVar.jXo = new n.d(this) {
                    final /* synthetic */ AnonymousClass2 iqd;

                    {
                        this.iqd = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 0:
                                intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("scene_from", 1);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("select_fav_local_id", this.iqd.iqc.iqa.field_localId);
                                com.tencent.mm.ay.c.a(this.iqd.iqc, ".ui.transmit.SelectConversationUI", intent, 4097);
                                return;
                            case 2:
                                g.a(this.iqd.iqc.nDR.nEl, this.iqd.iqc.getString(2131231021), "", new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass2 iqe;

                                    {
                                        this.iqe = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        final p a = g.a(this.iqe.iqd.iqc.nDR.nEl, this.iqe.iqd.iqc.getString(2131231021), false, null);
                                        ez ezVar = new ez();
                                        ezVar.bdQ.type = 12;
                                        ezVar.bdQ.aZa = this.iqe.iqd.iqc.fRB;
                                        ezVar.bdQ.bdU = new Runnable(this) {
                                            final /* synthetic */ AnonymousClass1 iqf;

                                            public final void run() {
                                                a.dismiss();
                                                v.d("MicroMsg.FavRecordDetailUI", "do del, local id %d", new Object[]{Long.valueOf(this.iqf.iqe.iqd.iqc.fRB)});
                                                this.iqf.iqe.iqd.iqc.finish();
                                            }
                                        };
                                        a.nhr.z(ezVar);
                                    }
                                }, null);
                                return;
                            case 3:
                                intent = new Intent();
                                intent.putExtra("key_fav_scene", 2);
                                intent.putExtra("key_fav_item_id", this.iqd.iqc.fRB);
                                com.tencent.mm.ay.c.b(this.iqd.iqc.nDR.nEl, "favorite", ".ui.FavTagEditUI", intent);
                                return;
                            case 4:
                                intent = new Intent();
                                intent.putExtra("key_fav_scene", 1);
                                intent.putExtra("key_fav_item_id", this.iqd.iqc.iqa.field_localId);
                                com.tencent.mm.ay.c.b(this.iqd.iqc.nDR.nEl, "favorite", ".ui.FavTagEditUI", intent);
                                return;
                            default:
                                return;
                        }
                    }
                };
                fVar.bKh();
                return true;
            }
        });
    }

    protected final void b(int i, int i2, Intent intent) {
        if (4097 == i && -1 == i2) {
            ez ezVar = new ez();
            ezVar.bdQ.type = 32;
            ezVar.bdQ.aZa = this.fRB;
            a.nhr.z(ezVar);
            if (ezVar.bdR.beg) {
                g.bf(this.nDR.nEl, getString(2131230745));
                return;
            }
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            final p a = g.a(this.nDR.nEl, getString(2131232670), false, null);
            ez ezVar2 = new ez();
            ezVar2.bdQ.type = 13;
            ezVar2.bdQ.context = this.nDR.nEl;
            ezVar2.bdQ.toUser = stringExtra;
            ezVar2.bdQ.bdV = stringExtra2;
            ezVar2.bdQ.aZa = this.fRB;
            ezVar2.bdQ.bdU = new Runnable(this) {
                final /* synthetic */ FavRecordDetailUI iqc;

                public final void run() {
                    a.dismiss();
                    com.tencent.mm.ui.snackbar.a.f(this.iqc, this.iqc.getString(2131232839));
                }
            };
            a.nhr.z(ezVar2);
        }
    }
}
