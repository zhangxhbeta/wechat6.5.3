package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.ad.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class h implements e {
    private Context context;
    private ProgressDialog eLA;
    a oOQ;

    public interface a {
        void kb(boolean z);
    }

    public h(Context context, a aVar) {
        this.context = context;
        this.oOQ = aVar;
    }

    final void h(Cursor cursor) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                o oVar = new o();
                oVar.b(cursor);
                arrayList.add(oVar.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(oVar);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        Context context = this.context;
        String string = this.context.getResources().getString(2131233153);
        this.context.getResources().getString(2131231010);
        g.a(context, string, arrayList, arrayList2, new d(this) {
            final /* synthetic */ h oOR;

            public final void bw(int i, int i2) {
                if (i2 != -1) {
                    this.oOR.Pu(((o) arrayList3.get(i2)).field_googlegmail);
                }
            }
        });
    }

    final void Pu(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        final k bVar = new b(arrayList);
        ak.vy().a(bVar, 0);
        Context context = this.context;
        this.context.getString(2131233331);
        this.eLA = g.a(context, this.context.getString(2131233329), true, new OnCancelListener(this) {
            final /* synthetic */ h oOR;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(bVar);
                this.oOR.oOQ.kb(false);
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.SendInviteGoogleContact";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = SQLiteDatabase.KeyEmpty;
        }
        objArr[2] = str;
        v.i(str2, str3, objArr);
        if (kVar.getType() == 489) {
            if (this.eLA != null) {
                this.eLA.dismiss();
                this.eLA = null;
            }
            ak.vy().b(489, (e) this);
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteSuccess");
                g.a(this.context, 2131233328, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ h oOR;

                    {
                        this.oOR = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oOR.oOQ.kb(true);
                    }
                });
                return;
            }
            v.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteFail");
            this.oOQ.kb(false);
        }
    }
}
