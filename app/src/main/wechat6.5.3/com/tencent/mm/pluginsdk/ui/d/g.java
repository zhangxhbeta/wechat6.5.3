package com.tencent.mm.pluginsdk.ui.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.protocal.c.aje;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class g {
    static String lQU;

    static class AnonymousClass3 implements OnCreateContextMenuListener {
        final /* synthetic */ List lQX;

        public AnonymousClass3(List list) {
            this.lQX = list;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            for (String add : this.lQX) {
                contextMenu.add(0, 0, 0, add);
            }
        }
    }

    private static class a extends BaseAdapter {
        private List<String> grq = null;
        private OnDismissListener lRb = null;
        a lRc = null;
        private Context mContext = null;
        private Bundle ro = null;

        public interface a {
            void dO(boolean z);
        }

        private class b {
            TextView dID;
            Button fQF;
            final /* synthetic */ a lRd;
            TextView lRe;

            private b(a aVar) {
                this.lRd = aVar;
            }
        }

        private class c {
            TextView dID;
            final /* synthetic */ a lRd;

            private c(a aVar) {
                this.lRd = aVar;
            }
        }

        public a(List<String> list, Context context, OnDismissListener onDismissListener, Bundle bundle) {
            Assert.assertTrue(context != null);
            this.grq = list;
            this.mContext = context;
            this.lRb = onDismissListener;
            this.ro = bundle;
        }

        public final int getCount() {
            return this.grq == null ? 0 : this.grq.size();
        }

        public final Object getItem(int i) {
            return this.grq.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (this.mContext.getString(2131231860).equals((String) this.grq.get(i))) {
                return 1;
            }
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Object obj;
            String str = (String) getItem(i);
            int itemViewType = getItemViewType(i);
            if (view == null) {
                Object bVar;
                View view2;
                LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
                View inflate;
                if (itemViewType == 1) {
                    inflate = layoutInflater.inflate(2130903334, viewGroup, false);
                    bVar = new b();
                    ((b) bVar).dID = (TextView) inflate.findViewById(2131755226);
                    ((b) bVar).fQF = (Button) inflate.findViewById(2131756255);
                    ((b) bVar).lRe = (TextView) inflate.findViewById(2131756238);
                    view2 = inflate;
                } else {
                    inflate = layoutInflater.inflate(2130903335, viewGroup, false);
                    bVar = new c();
                    ((c) bVar).dID = (TextView) inflate.findViewById(2131755226);
                    view2 = inflate;
                }
                view2.setTag(bVar);
                view = view2;
                obj = bVar;
            } else {
                obj = view.getTag();
            }
            switch (itemViewType) {
                case 0:
                    c cVar = (c) obj;
                    cVar.dID.setText(e.a(this.mContext, be.ma(str), cVar.dID.getTextSize()));
                    break;
                case 1:
                    b bVar2 = (b) obj;
                    bVar2.dID.setText(e.a(this.mContext, be.ma(str), bVar2.dID.getTextSize()));
                    bVar2.lRe.setText(this.mContext.getString(2131231866));
                    bVar2.fQF.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a lRd;

                        {
                            this.lRd = r1;
                        }

                        public final void onClick(View view) {
                            if (C2Java.isNetworkConnected()) {
                                l.c(this.lRd.mContext, this.lRd.ro);
                                if (this.lRd.lRc != null) {
                                    this.lRd.lRc.dO(true);
                                    return;
                                }
                                return;
                            }
                            v.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
                            s.makeText(this.lRd.mContext, this.lRd.mContext.getString(2131232875), 0).show();
                            if (this.lRd.lRc != null) {
                                this.lRd.lRc.dO(false);
                            }
                        }
                    });
                    break;
                default:
                    v.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
                    break;
            }
            return view;
        }
    }

    static class AnonymousClass4 implements d {
        final /* synthetic */ Context val$context;

        public AnonymousClass4(Context context) {
            this.val$context = context;
        }

        public final void c(MenuItem menuItem, int i) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(menuItem.getTitle().toString().replace(" ", SQLiteDatabase.KeyEmpty).replace("(", SQLiteDatabase.KeyEmpty).replace(")", SQLiteDatabase.KeyEmpty).replace("-", SQLiteDatabase.KeyEmpty)).toString()));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (be.m(this.val$context, intent)) {
                this.val$context.startActivity(intent);
            }
        }
    }

    static /* synthetic */ void a(Activity activity, String str, Bundle bundle) {
        String ma = be.ma(bundle.getString("Contact_User"));
        if (ma == null) {
            v.e("MicroMsg.MailPhoneMenuHelper", "username is null");
            return;
        }
        ak.yW();
        u LX = c.wH().LX(ma);
        if (LX == null) {
            v.e("MicroMsg.MailPhoneMenuHelper", "contact is null");
            return;
        }
        int i;
        ArrayList arrayList;
        String[] split;
        String string = bundle.getString("Contact_Mobile_MD5");
        String str2 = LX.bCz;
        if (!be.kS(string)) {
            if (string == str) {
                i = 0;
            } else if (!LX.tQ()) {
                i = 1;
            }
            arrayList = new ArrayList();
            if (!be.kS(str2)) {
                split = str2.split(",");
                for (Object add : split) {
                    arrayList.add(add);
                }
                if (arrayList.contains(str)) {
                    arrayList.remove(str);
                }
            }
            arrayList.add(str);
            if (arrayList.size() + i > 5) {
                a(activity, LX, ma, arrayList);
                com.tencent.mm.plugin.report.service.g.iuh.h(12040, LX.field_username, Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(i + arrayList.size()));
            }
            Toast.makeText(activity, activity.getString(2131233895), 0).show();
            return;
        }
        i = 0;
        arrayList = new ArrayList();
        if (be.kS(str2)) {
            split = str2.split(",");
            while (r3 < split.length) {
                arrayList.add(add);
            }
            if (arrayList.contains(str)) {
                arrayList.remove(str);
            }
        }
        arrayList.add(str);
        if (arrayList.size() + i > 5) {
            Toast.makeText(activity, activity.getString(2131233895), 0).show();
            return;
        }
        a(activity, LX, ma, arrayList);
        com.tencent.mm.plugin.report.service.g.iuh.h(12040, LX.field_username, Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(i + arrayList.size()));
    }

    static /* synthetic */ void aT(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(WebView.SCHEME_MAILTO));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        if (be.m(context, intent)) {
            context.startActivity(intent);
        } else {
            com.tencent.mm.ui.base.g.a(context, 2131231854, 2131231164, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    static /* synthetic */ void aU(Context context, String str) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/person");
        intent.putExtra("phone", str);
        if (be.m(context, intent)) {
            context.startActivity(intent);
        }
    }

    public static void b(final Context context, final String str, final OnDismissListener onDismissListener) {
        if (((k.xQ() & 1) == 0 ? 1 : 0) != 0) {
            com.tencent.mm.ui.base.g.a(context, str, context.getResources().getStringArray(2131296274), SQLiteDatabase.KeyEmpty, new com.tencent.mm.ui.base.g.c() {
                public final void gT(int i) {
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                    String replace = str.replace(" ", SQLiteDatabase.KeyEmpty).replace("#", "@");
                    switch (i) {
                        case 0:
                            Context context = context;
                            Intent intent = new Intent();
                            intent.putExtra("composeType", 4);
                            String substring = replace.substring(0, replace.indexOf(64));
                            intent.putExtra("toList", new String[]{substring + " " + replace});
                            com.tencent.mm.ay.c.b(context, "qqmail", ".ui.ComposeUI", intent);
                            return;
                        case 1:
                            g.aT(context, replace);
                            return;
                        default:
                            return;
                    }
                }
            });
        } else {
            com.tencent.mm.ui.base.g.a(context, str, new String[]{context.getResources().getString(2131231775)}, SQLiteDatabase.KeyEmpty, new com.tencent.mm.ui.base.g.c() {
                public final void gT(int i) {
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                    String replace = str.replace(" ", SQLiteDatabase.KeyEmpty).replace("#", "@");
                    switch (i) {
                        case 0:
                            g.aT(context, replace);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    public static void a(Context context, String str, final OnDismissListener onDismissListener, Bundle bundle) {
        boolean booleanValue;
        List g;
        if (!(context instanceof Activity)) {
            v.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", be.bur());
        }
        if (ak.uz()) {
            ak.yW();
            booleanValue = ((Boolean) c.vf().get(com.tencent.mm.storage.t.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.valueOf(false))).booleanValue();
        } else {
            booleanValue = false;
        }
        final int i = bundle.getInt("fromScene");
        boolean z = bqJ() || bqK();
        if (z) {
            String[] strArr;
            String ma = be.ma(bundle.getString("Contact_User"));
            if (ma == null || ma == SQLiteDatabase.KeyEmpty || ma.endsWith("@chatroom") || k.eo(ma)) {
                strArr = booleanValue ? new String[]{context.getResources().getString(2131231864), context.getResources().getString(2131231865), context.getResources().getString(2131231857)} : new String[]{context.getResources().getString(2131231864), context.getResources().getString(2131231857)};
            } else {
                ak.yW();
                u LX = c.wH().LX(ma);
                if (LX != null) {
                    ma = LX.tU();
                    lQU = context.getResources().getString(2131231858, new Object[]{ma});
                    strArr = booleanValue ? new String[]{context.getResources().getString(2131231864), context.getResources().getString(2131231865), lQU, context.getResources().getString(2131231857)} : new String[]{context.getResources().getString(2131231864), lQU, context.getResources().getString(2131231857)};
                } else {
                    return;
                }
            }
            g = be.g(strArr);
        } else {
            g = be.g(new String[]{context.getResources().getString(2131231864), context.getResources().getString(2131231859)});
        }
        com.tencent.mm.plugin.report.service.g.iuh.h(11621, Integer.valueOf(i), Integer.valueOf(2));
        if (l.oB()) {
            g.add(context.getResources().getString(2131231860));
            com.tencent.mm.plugin.report.service.g.iuh.h(11621, Integer.valueOf(i), Integer.valueOf(3));
            if (C2Java.isNetworkConnected()) {
                ak.yW();
                v.v("MicroMsg.WxPhoneBookHelper", "hy: minus pb counter, ori counter = %d", Integer.valueOf(be.a((Integer) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_WXPHONE_PB_COUNT_INT, null), 3)));
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.USERINFO_WXPHONE_PB_COUNT_INT, Integer.valueOf(r0 - 1));
            }
        }
        final Dialog kVar = new com.tencent.mm.ui.base.k(context);
        kVar.setTitle(str);
        BaseAdapter aVar = new a(g, context, onDismissListener, bundle);
        aVar.lRc = new a() {
            public final void dO(boolean z) {
                if (z) {
                    kVar.dismiss();
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                }
            }
        };
        kVar.eGK = aVar;
        com.tencent.mm.ui.base.g.a(context, kVar);
        kVar.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(null);
                }
            }
        });
        final String str2 = str;
        final Context context2 = context;
        final OnDismissListener onDismissListener2 = onDismissListener;
        final Bundle bundle2 = bundle;
        kVar.lSE = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                final CharSequence replace = str2.replace(" ", SQLiteDatabase.KeyEmpty).replace("(", SQLiteDatabase.KeyEmpty).replace(")", SQLiteDatabase.KeyEmpty).replace("-", SQLiteDatabase.KeyEmpty);
                String str = (String) g.get(i);
                v.i("MicroMsg.MailPhoneMenuHelper", str);
                Intent intent;
                if (context2.getString(2131231864).equals(str)) {
                    intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(replace).toString()));
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    if (be.m(context2, intent)) {
                        context2.startActivity(intent);
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.Y(10112, "1");
                    kVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                } else if (context2.getString(2131231865).equals(str)) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    intent = new Intent();
                    intent.putExtra("IPCallTalkUI_phoneNumber", replace);
                    com.tencent.mm.ay.c.b(context2, "ipcall", ".ui.IPCallDialUI", intent);
                    kVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                } else if (context2.getString(2131231857).equals(str)) {
                    String[] stringArray;
                    if (g.bqJ() && g.bqK()) {
                        stringArray = context2.getResources().getStringArray(2131296285);
                    } else {
                        stringArray = g.bqJ() ? new String[]{context2.getResources().getString(2131231856)} : new String[]{context2.getResources().getString(2131231863)};
                    }
                    context2.getResources().getString(2131231862);
                    com.tencent.mm.ui.base.g.a(context2, str2, stringArray, SQLiteDatabase.KeyEmpty, new com.tencent.mm.ui.base.g.c(this) {
                        final /* synthetic */ AnonymousClass7 lRa;

                        public final void gT(int i) {
                            if (onDismissListener2 != null) {
                                onDismissListener2.onDismiss(null);
                            }
                            switch (i) {
                                case 0:
                                    if (g.bqJ()) {
                                        Context context = context2;
                                        String str = replace;
                                        Intent intent = new Intent("android.intent.action.INSERT");
                                        intent.setType("vnd.android.cursor.dir/contact");
                                        intent.putExtra("phone", str);
                                        context.startActivity(intent);
                                        com.tencent.mm.plugin.report.service.g.iuh.Y(10113, "1");
                                        return;
                                    }
                                    g.aU(context2, replace);
                                    com.tencent.mm.plugin.report.service.g.iuh.Y(10114, "1");
                                    return;
                                case 1:
                                    g.aU(context2, replace);
                                    com.tencent.mm.plugin.report.service.g.iuh.Y(10114, "1");
                                    return;
                                default:
                                    return;
                            }
                        }
                    }, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass7 lRa;

                        {
                            this.lRa = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            if (onDismissListener2 != null) {
                                onDismissListener2.onDismiss(null);
                            }
                        }
                    });
                    kVar.dismiss();
                } else if (context2.getString(2131231859).equals(str)) {
                    com.tencent.mm.pluginsdk.j.c.a(context2, replace, replace);
                    com.tencent.mm.plugin.report.service.g.iuh.Y(10115, "1");
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                    kVar.dismiss();
                } else if (context2.getString(2131231860).equals(str)) {
                    v.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
                } else if (g.lQU.equals(str)) {
                    g.a((Activity) context2, str2, bundle2);
                    kVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                } else {
                    v.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
                    kVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                }
            }
        };
        kVar.show();
    }

    static boolean bqJ() {
        Context context = aa.getContext();
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.putExtra("phone", "10086");
        return be.m(context, intent);
    }

    static boolean bqK() {
        return be.m(aa.getContext(), new Intent("android.intent.action.PICK", Contacts.CONTENT_URI));
    }

    private static void a(Activity activity, u uVar, String str, ArrayList<String> arrayList) {
        com.tencent.mm.ba.a com_tencent_mm_protocal_c_aje = new aje();
        com_tencent_mm_protocal_c_aje.mJq = str;
        ams com_tencent_mm_protocal_c_ams = new ams();
        com_tencent_mm_protocal_c_ams.eet = arrayList.size();
        com_tencent_mm_protocal_c_ams.mNk = new LinkedList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            amr com_tencent_mm_protocal_c_amr = new amr();
            com_tencent_mm_protocal_c_amr.mNj = str2;
            com_tencent_mm_protocal_c_ams.mNk.add(com_tencent_mm_protocal_c_amr);
        }
        com_tencent_mm_protocal_c_aje.mJo = com_tencent_mm_protocal_c_ams;
        ak.yW();
        c.wG().b(new com.tencent.mm.ak.j.a(60, com_tencent_mm_protocal_c_aje));
        ak.yW();
        ab LX = c.wH().LX(str);
        if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
            str2 = SQLiteDatabase.KeyEmpty;
            Iterator it2 = arrayList.iterator();
            String str3 = str2;
            while (it2.hasNext()) {
                str3 = (str3 + ((String) it2.next())) + ",";
            }
            uVar.cs(str3);
            ak.yW();
            c.wH().M(uVar);
        }
        Toast.makeText(activity, activity.getString(2131235593), 0).show();
    }
}
