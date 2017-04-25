package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public final class c {

    static class AnonymousClass7 implements OnClickListener {
        final /* synthetic */ MMActivity eNm;

        public AnonymousClass7(MMActivity mMActivity) {
            this.eNm = mMActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.eNm.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    public interface b {
        void YZ();

        void abK();
    }

    public static class a implements b {
        public void YZ() {
        }

        public void abK() {
        }
    }

    public static void a(MMActivity mMActivity, final String str, String str2, final b bVar) {
        String string;
        if (TextUtils.isEmpty(str2)) {
            string = mMActivity.getString(2131231021);
        } else {
            string = str2;
        }
        g.a(mMActivity, true, string, mMActivity.getString(2131231164), mMActivity.getString(2131231107), mMActivity.getString(2131231010), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                bVar.YZ();
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }

    public static void a(MMActivity mMActivity, final b bVar) {
        g.a(mMActivity, true, mMActivity.getString(2131231597), "", mMActivity.getString(2131231107), mMActivity.getString(2131231010), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                bVar.abK();
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }

    public static void b(MMActivity mMActivity, String str) {
        if (TextUtils.isEmpty(str)) {
            str = mMActivity.getString(2131236492);
        }
        a(mMActivity, str, false);
    }

    public static void b(MMActivity mMActivity, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            str = "errcode = " + i;
        }
        a(mMActivity, str, false);
    }

    public static void a(final MMActivity mMActivity, String str, final boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = mMActivity.getString(2131236492);
        }
        g.a(mMActivity, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (z) {
                    mMActivity.finish();
                }
            }
        });
    }

    public static void c(final Context context, int i, int i2, String str) {
        if (i != -1) {
            h a;
            String string;
            TextView textView;
            if (i == 2130903258) {
                string = context.getResources().getString(i2);
                String string2 = context.getResources().getString(2131234768);
                OnClickListener anonymousClass9 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                };
                View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
                if (i == 2130903257) {
                    textView = (TextView) inflate.findViewById(2131755993);
                    if (TextUtils.isEmpty(str)) {
                        str = context.getResources().getString(2131231606);
                    }
                    textView.setText(context.getResources().getString(2131231586, new Object[]{str}));
                } else if (i == 2130903256) {
                    textView = (TextView) inflate.findViewById(2131755993);
                    if (TextUtils.isEmpty(str)) {
                        str = context.getResources().getString(2131231606);
                    }
                    textView.setText(context.getResources().getString(2131231585, new Object[]{str}));
                }
                a = g.a(context, string, string2, inflate, anonymousClass9);
            } else {
                string = context.getResources().getString(i2);
                String string3 = context.getResources().getString(2131231636);
                String string4 = context.getResources().getString(2131234768);
                OnClickListener anonymousClass10 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intent = new Intent();
                        intent.putExtra("key_from_scene", 22);
                        intent.putExtra("key_home_page_from_scene", 1);
                        com.tencent.mm.ay.c.b(context, "card", ".ui.CardHomePageUI", intent);
                    }
                };
                OnClickListener anonymousClass2 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                };
                View inflate2 = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
                if (i == 2130903257) {
                    textView = (TextView) inflate2.findViewById(2131755993);
                    if (TextUtils.isEmpty(str)) {
                        str = context.getResources().getString(2131231606);
                    }
                    textView.setText(context.getResources().getString(2131231586, new Object[]{str}));
                } else if (i == 2130903256) {
                    textView = (TextView) inflate2.findViewById(2131755993);
                    if (TextUtils.isEmpty(str)) {
                        str = context.getResources().getString(2131231606);
                    }
                    textView.setText(context.getResources().getString(2131231585, new Object[]{str}));
                }
                a = g.a(context, string, inflate2, string3, string4, anonymousClass10, anonymousClass2);
            }
            if (a != null) {
                a.show();
            }
        }
    }
}
