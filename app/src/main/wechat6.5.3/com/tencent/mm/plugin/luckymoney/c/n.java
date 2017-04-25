package com.tencent.mm.plugin.luckymoney.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.a.f;
import com.tencent.mm.ae.a.a.c.a;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.a.ac;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONObject;

public final class n {
    private static f<String, Bitmap> fMG = new f(10);
    public static int hby = Integer.MAX_VALUE;

    public static String h(Context context, long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
        if (timeInMillis > 0 && timeInMillis <= 86400000) {
            return new SimpleDateFormat("HH:mm:ss").format(new Date(j));
        }
        Time time = new Time();
        time.set(j);
        return com.tencent.mm.pluginsdk.j.n.a(context.getString(2131232868, new Object[]{" "}), time).toString();
    }

    public static void a(ImageView imageView, String str, boolean z) {
        a(imageView, str, null, true);
    }

    public static void a(ImageView imageView, String str, String str2, boolean z) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!be.kS(str)) {
                a aVar = new a();
                com.tencent.mm.plugin.luckymoney.a.a.axz();
                aVar.cPv = com.tencent.mm.plugin.luckymoney.a.a.axB();
                aVar.cPs = true;
                aVar.cPO = true;
                aVar.cPP = z;
                if (be.kS(str2)) {
                    aVar.cPA = false;
                } else {
                    aVar.aZy = str2;
                    aVar.cPA = true;
                }
                com.tencent.mm.ae.n.GL().a(str, imageView, aVar.GU());
            }
        }
    }

    public static void e(ImageView imageView, String str) {
        a(imageView, str, null, false);
    }

    public static void g(ImageView imageView, String str) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!be.kS(str)) {
                a aVar = new a();
                com.tencent.mm.plugin.luckymoney.a.a.axz();
                aVar.cPv = com.tencent.mm.plugin.luckymoney.a.a.axB();
                aVar.cPs = true;
                aVar.cPO = true;
                aVar.cPP = false;
                aVar.cPH = 2130838546;
                com.tencent.mm.ae.n.GL().a(str, imageView, aVar.GU());
            }
        }
    }

    public static void h(ImageView imageView, String str) {
        if (imageView != null) {
            b.o(imageView, com.tencent.mm.u.n.Bq().gG(str));
        }
    }

    public static void i(ImageView imageView, String str) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!be.kS(str)) {
                a aVar = new a();
                com.tencent.mm.plugin.luckymoney.a.a.axz();
                aVar.cPv = com.tencent.mm.plugin.luckymoney.a.a.axB();
                aVar.cPs = true;
                aVar.cPO = true;
                aVar.cPP = true;
                aVar.cPx = 1;
                aVar.cPH = 2130838527;
                com.tencent.mm.ae.n.GL().a(str, imageView, aVar.GU());
            }
        }
    }

    public static void a(Context context, TextView textView, String str) {
        if (textView != null) {
            textView.setText(e.a(context, str, textView.getTextSize()));
        }
    }

    public static void a(MMActivity mMActivity, int i, int i2) {
        if (i != 0 || i2 <= 1) {
            c(mMActivity, 2);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(mMActivity, SelectLuckyMoneyContactUI.class);
        intent.putExtra("key_friends_num", i2);
        mMActivity.startActivityForResult(intent, 2);
    }

    public static void c(MMActivity mMActivity, int i) {
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_Conv_Type", 3);
        c.a(mMActivity, ".ui.transmit.SelectConversationUI", intent, i);
    }

    public static String axJ() {
        ak.yW();
        return (String) com.tencent.mm.model.c.vf().get(t.a.npg, null);
    }

    public static String wa(String str) {
        h gQ = com.tencent.mm.u.n.Bo().gQ(str);
        if (gQ != null) {
            return gQ.Bf();
        }
        ak.yW();
        u LX = com.tencent.mm.model.c.wH().LX(str);
        if (LX == null || !LX.field_username.equals(str) || LX.bBY == 4) {
            return null;
        }
        ak.yW();
        byte[] Ma = com.tencent.mm.model.c.wH().Ma(str);
        if (be.bl(Ma)) {
            return null;
        }
        String str2;
        try {
            str2 = ((ais) new ais().az(Ma)).mlZ;
        } catch (Throwable e) {
            v.e("MicroMsg.LuckyMoneyUtil", "exception:%s", new Object[]{be.e(e)});
            str2 = null;
        }
        return str2;
    }

    public static String eq(String str) {
        ak.yW();
        u LX = com.tencent.mm.model.c.wH().LX(str);
        if (LX == null || !LX.field_username.equals(str)) {
            return null;
        }
        return LX.field_nickname;
    }

    public static int cf(Context context) {
        if (hby == Integer.MAX_VALUE) {
            hby = context.getResources().getColor(2131689832);
        }
        return hby;
    }

    public static void a(final View view, AnimationListener animationListener) {
        Animation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setFillAfter(true);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                view.startAnimation(scaleAnimation2);
            }
        });
        if (animationListener != null) {
            scaleAnimation2.setAnimationListener(animationListener);
        }
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
    }

    public static void a(Button button) {
        b(button);
    }

    public static void b(Button button) {
        if (button != null) {
            button.setBackgroundResource(2130838227);
            AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
            if (animationDrawable != null) {
                animationDrawable.start();
            }
        }
    }

    public static void c(Button button) {
        if (button != null && (button.getBackground() instanceof AnimationDrawable)) {
            AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
        }
    }

    public static boolean v(String str, String str2, int i) {
        if (be.kS(str) || be.kS(str2)) {
            v.w("MicroMsg.LuckyMoneyUtil", be.ma(str) + ", " + be.ma(str2));
            return false;
        }
        at atVar = new at();
        atVar.setContent(str);
        atVar.dh(2);
        atVar.cH(str2);
        atVar.z(aw.fN(str2));
        atVar.di(1);
        if (i == 3) {
            atVar.setType(469762097);
        } else {
            atVar.setType(436207665);
        }
        ak.yW();
        long R = com.tencent.mm.model.c.wJ().R(atVar);
        if (R < 0) {
            v.e("MicroMsg.LuckyMoneyUtil", g.sm() + "insert msg failed :" + R);
            return false;
        }
        com.tencent.mm.modelstat.b.daJ.p(atVar);
        atVar.x(R);
        com.tencent.mm.q.a aVar = new com.tencent.mm.q.a();
        aVar.field_xml = atVar.field_content;
        String KK = be.KK(str);
        com.tencent.mm.q.a.a aVar2 = null;
        if (KK != null) {
            aVar2 = com.tencent.mm.q.a.a.B(KK, atVar.field_reserved);
            if (aVar2 != null) {
                aVar.field_title = aVar2.title;
                aVar.field_description = aVar2.description;
            }
        }
        aVar.field_type = 2001;
        aVar.field_msgId = R;
        if (aVar2 != null && aVar2.type == 2001 && aVar2.aXx == 1) {
            if (TextUtils.isEmpty(aVar2.cpN) || TextUtils.isEmpty(aVar2.cpO) || aVar2.cpP <= 0) {
                v.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
            } else {
                v.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
                ac acVar = new ac();
                acVar.aXB = new ac.a();
                acVar.aXB.aXD = aVar2.cpO;
                acVar.aXB.aXC = aVar2.cpN;
                acVar.aXB.aXE = aVar2.cpP;
                com.tencent.mm.sdk.c.a.nhr.z(acVar);
            }
        }
        com.tencent.mm.q.a dz = am.bnC().dz(R);
        if (dz != null && dz.field_msgId == R) {
            return am.bnC().a(aVar, new String[0]);
        }
        boolean b = am.bnC().b(aVar);
        if (b) {
            return b;
        }
        v.e("MicroMsg.LuckyMoneyUtil", "SubCorePluginBase.getAppMsgStg().insert msg failed id:" + R);
        return b;
    }

    public static boolean a(Activity activity, int i, k kVar, Bundle bundle, boolean z, OnClickListener onClickListener, com.tencent.mm.wallet_core.b.a aVar, int i2) {
        v.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
        if (i == 416) {
            return a(activity, kVar, bundle, z, onClickListener, i2);
        }
        v.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
        return false;
    }

    private static boolean a(Activity activity, k kVar, Bundle bundle, boolean z, OnClickListener onClickListener, int i) {
        JSONObject jSONObject;
        String str;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (kVar != null && (kVar instanceof p)) {
            com.tencent.mm.v.b bVar = ((p) kVar).cif;
            if (bVar != null) {
                ace com_tencent_mm_protocal_c_ace = (ace) bVar.czl.czs;
                if (com_tencent_mm_protocal_c_ace.mDl != null) {
                    try {
                        jSONObject = new JSONObject(m.b(com_tencent_mm_protocal_c_ace.mDl));
                    } catch (Throwable e) {
                        v.a("MicroMsg.LuckyMoneyUtil", e, "", new Object[0]);
                    }
                    if (jSONObject == null) {
                        v.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
                        if (jSONObject.has("real_name_info")) {
                            jSONObject = jSONObject.optJSONObject("real_name_info");
                        }
                        str2 = jSONObject.optString("guide_flag", "");
                        str3 = jSONObject.optString("guide_wording");
                        str4 = jSONObject.optString("left_button_wording", activity.getString(2131231565));
                        str5 = jSONObject.optString("right_button_wording", activity.getString(2131231107));
                        str6 = jSONObject.optString("upload_credit_url", "");
                        str = str2;
                    } else {
                        str = str2;
                    }
                    if ("1".equals(str)) {
                        v.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
                        return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, str3, str4, str5, bundle, z, onClickListener, i, 2);
                    } else if ("2".equals(str) || be.kS(str6)) {
                        v.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + be.kS(str6));
                        return false;
                    } else {
                        v.i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
                        return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, str3, str6, str4, str5, z, null);
                    }
                }
            }
        }
        jSONObject = null;
        if (jSONObject == null) {
            str = str2;
        } else {
            v.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
            if (jSONObject.has("real_name_info")) {
                jSONObject = jSONObject.optJSONObject("real_name_info");
            }
            str2 = jSONObject.optString("guide_flag", "");
            str3 = jSONObject.optString("guide_wording");
            str4 = jSONObject.optString("left_button_wording", activity.getString(2131231565));
            str5 = jSONObject.optString("right_button_wording", activity.getString(2131231107));
            str6 = jSONObject.optString("upload_credit_url", "");
            str = str2;
        }
        if ("1".equals(str)) {
            v.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, str3, str4, str5, bundle, z, onClickListener, i, 2);
        }
        if ("2".equals(str)) {
        }
        v.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + be.kS(str6));
        return false;
    }

    public static String wb(String str) {
        if (be.kS(str) || !ak.uz()) {
            return "";
        }
        r2 = new Object[2];
        ak.yW();
        r2[0] = com.tencent.mm.model.c.xq();
        r2[1] = "LuckyMoney";
        File file = new File(String.format("%s/%s/", r2));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return new File(file, str).getAbsolutePath();
    }

    public static Bitmap Y(String str, boolean z) {
        Bitmap bitmap;
        int i = 960;
        boolean z2 = true;
        if (z) {
            bitmap = (Bitmap) fMG.get(str);
            if (bitmap != null) {
                return bitmap;
            }
        }
        if (com.tencent.mm.compatible.util.f.sj()) {
            int i2;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(str, options);
            if (bitmap != null) {
                bitmap.recycle();
            }
            boolean z3 = d.aZ(options.outWidth, options.outHeight) && options.outWidth > 480;
            boolean z4;
            if (!d.aY(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z3 || r4) {
                i2 = options.outHeight;
                i = options.outWidth;
                while (i * i2 > 2764800) {
                    i >>= 1;
                    i2 >>= 1;
                }
                i = Math.max(1, i);
                i2 = Math.max(1, i2);
                v.w("MicroMsg.LuckyMoneyUtil", "fit long picture, beg %d*%d, after %d*%d", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i), Integer.valueOf(i2)});
            } else {
                i2 = 960;
            }
            int JQ = ExifHelper.JQ(str);
            if (JQ == 90 || JQ == 270) {
                int i3 = i;
                i = i2;
                i2 = i3;
            }
            if (MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                bitmap = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.LuckyMoneyUtil";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                if (bitmap != null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                v.i(str2, str3, objArr);
            } else {
                bitmap = d.b(str, i2, i, false);
            }
            if (bitmap == null) {
                v.e("MicroMsg.LuckyMoneyUtil", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                return null;
            }
            bitmap = d.b(bitmap, (float) JQ);
            if (!z) {
                return bitmap;
            }
            fMG.put(str, bitmap);
            return bitmap;
        }
        v.e("MicroMsg.LuckyMoneyUtil", "sdcard is not avail!");
        return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
    }

    public static String aI(List<ag> list) {
        if (list == null || list.size() == 0) {
            v.e("MicroMsg.LuckyMoneyUtil", "splitOperationField is empty!");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            ag agVar = (ag) list.get(i);
            if (agVar != null) {
                if (i != 0) {
                    stringBuilder.append("|");
                }
                stringBuilder.append(agVar.type);
                stringBuilder.append("|");
                stringBuilder.append(agVar.name);
            }
        }
        return stringBuilder.toString();
    }
}
