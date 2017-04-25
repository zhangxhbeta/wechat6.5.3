package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.mm.h.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

public final class e {
    private static h oMV = null;

    public static void eE(Context context) {
        if (be.buw()) {
            String value = j.sU().getValue("NewShowRating");
            if (!be.kS(value)) {
                Map q = bf.q(value, "ShowRatingNode");
                value = (q == null || q.get(".ShowRatingNode.MinVer") == null) ? "0" : (String) q.get(".ShowRatingNode.MinVer");
                int intValue = Integer.decode(value).intValue();
                value = (q == null || q.get(".ShowRatingNode.MaxVer") == null) ? "0" : (String) q.get(".ShowRatingNode.MaxVer");
                int intValue2 = Integer.decode(value).intValue();
                if (q == null || q.get(".ShowRatingNode.WaitDays") == null) {
                    value = "0";
                } else {
                    value = (String) q.get(".ShowRatingNode.WaitDays");
                }
                int intValue3 = Integer.decode(value).intValue();
                if (intValue <= d.lWh && d.lWh <= intValue2) {
                    Object obj;
                    final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
                    int i = sharedPreferences.getInt("show_rating_flag", 0);
                    int i2 = sharedPreferences.getInt("show_rating_version", 0);
                    long j = sharedPreferences.getLong("show_rating_timestamp", 0);
                    boolean z = sharedPreferences.getBoolean("show_rating_again", false);
                    long j2 = ((long) (intValue3 == 0 ? 7 : intValue3)) * 86400000;
                    if (i2 == 0 || intValue > i2 || i2 > intValue2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        sharedPreferences.edit().putInt("show_rating_version", d.lWh).commit();
                        sharedPreferences.edit().putInt("show_rating_flag", 0).commit();
                        i = 0;
                        j = System.currentTimeMillis();
                        sharedPreferences.edit().putLong("show_rating_timestamp", j).commit();
                        sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                        sharedPreferences.edit().putInt("show_rating_wait_days", intValue3).commit();
                        sharedPreferences.edit().putInt("show_rating_first_second_time", (int) (System.currentTimeMillis() / 1000)).commit();
                        v.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]current clientVersion=%s,has rating clientVersion=%s,dynamic config showRatting min version=%s,max version:%s,waitDaysMillis:%s", Integer.valueOf(d.lWh), Integer.valueOf(i2), Integer.valueOf(intValue), Integer.valueOf(intValue2), Long.valueOf(j2));
                    }
                    if (intValue <= d.lWh && d.lWh <= intValue2 && i == 0 && r2 != 0 && System.currentTimeMillis() >= r2 + j2) {
                        v.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show enjoy app dialog.");
                        String string = context.getString(2131235324);
                        String str = SQLiteDatabase.KeyEmpty;
                        String string2 = context.getString(2131235317);
                        String string3 = context.getString(2131235316);
                        final Context context2 = context;
                        OnClickListener anonymousClass1 = new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                sharedPreferences.edit().putInt("show_rating_flag", 1).commit();
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                                e.oMV = null;
                                e.l(context2, true);
                                v.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog from enjoy app dialog.");
                            }
                        };
                        context2 = context;
                        oMV = g.a(context, false, string, str, string2, string3, anonymousClass1, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                sharedPreferences.edit().putInt("show_rating_flag", 2).commit();
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                                e.oMV = null;
                                e.eF(context2);
                                v.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show feedback dialog.");
                            }
                        });
                    } else if (z && r2 != 0 && System.currentTimeMillis() >= (r2 + j2) + 345600000) {
                        v.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog again.");
                        l(context, false);
                        sharedPreferences.edit().putInt("show_rating_flag", 3).commit();
                    } else if (i == 1) {
                        l(context, true);
                    } else if (i == 2) {
                        eF(context);
                    } else if (i == 3) {
                        l(context, false);
                    }
                }
            }
        }
    }

    private static void l(Context context, boolean z) {
        String string;
        String str;
        String str2;
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final boolean z2 = sharedPreferences.getBoolean("show_rating_again", false);
        final int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        String string2;
        String string3;
        if (z) {
            string2 = context.getString(2131235323);
            string3 = context.getString(2131235322);
            string = context.getString(2131235321);
            str = string3;
            str2 = string2;
        } else {
            string2 = context.getString(2131235320);
            string3 = context.getString(2131235319);
            string = context.getString(2131235318);
            str = string3;
            str2 = string2;
        }
        final Context context2 = context;
        oMV = g.a(context, false, str2, SQLiteDatabase.KeyEmpty, str, string, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                String str = "market://details?id=" + aa.getPackageName();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                context2.startActivity(intent);
                v.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]start market intent");
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                e.oMV = null;
                if (z2) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11216, Integer.valueOf(5), Integer.valueOf(i2), Integer.valueOf(i));
                    return;
                }
                com.tencent.mm.plugin.report.service.g.iuh.h(11216, Integer.valueOf(4), Integer.valueOf(i2), Integer.valueOf(i));
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (z2) {
                    sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                    com.tencent.mm.plugin.report.service.g.iuh.h(11216, Integer.valueOf(3), Integer.valueOf(i2), Integer.valueOf(i));
                } else {
                    v.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]need to show rating dialog again.");
                    sharedPreferences.edit().putBoolean("show_rating_again", true).commit();
                    com.tencent.mm.plugin.report.service.g.iuh.h(11216, Integer.valueOf(6), Integer.valueOf(i2), Integer.valueOf(i));
                }
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                e.oMV = null;
            }
        });
    }

    private static void eF(final Context context) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        oMV = g.a(context, false, context.getString(2131235327), SQLiteDatabase.KeyEmpty, context.getString(2131235326), context.getString(2131235325), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                com.tencent.mm.pluginsdk.d.aI(context, "weixin://dl/feedback");
                e.oMV = null;
                com.tencent.mm.plugin.report.service.g.iuh.h(11216, Integer.valueOf(2), Integer.valueOf(i2), Integer.valueOf(i));
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                e.oMV = null;
                com.tencent.mm.plugin.report.service.g.iuh.h(11216, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i));
            }
        });
    }

    public static void bIB() {
        if (oMV != null) {
            oMV.dismiss();
            oMV = null;
        }
    }
}
