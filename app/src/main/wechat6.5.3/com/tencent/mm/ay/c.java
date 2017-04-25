package com.tencent.mm.ay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class c {
    private static final Map<String, String> lVN;
    private static HashMap<String, com.tencent.mm.pluginsdk.c.c> lVO = new HashMap();
    private static final HashSet<String> lVP = new HashSet<String>() {
        {
            add(".ui.transmit.SelectConversationUI");
        }
    };

    static {
        Map hashMap = new HashMap();
        lVN = hashMap;
        hashMap.put("location", "talkroom");
        lVN.put("talkroom", "voip");
    }

    public static void a(final Context context, final String str, final String str2, final Intent intent) {
        a(str, new a() {
            public final void onDone() {
                Intent intent = intent == null ? new Intent() : intent;
                intent.setClassName(aa.getPackageName(), str2.startsWith(".") ? (aa.bth() + ".plugin." + str) + str2 : str2);
                MMWizardActivity.w(context, intent);
            }
        }, new b() {
            public final void b(Exception exception) {
                v.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", str);
                v.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", exception);
            }
        });
    }

    public static void a(Context context, final String str, String str2, Intent intent, Intent intent2) {
        final Intent intent3 = intent;
        final String str3 = str;
        final String str4 = str2;
        final Context context2 = context;
        final Intent intent4 = intent2;
        a(str, new a() {
            public final void onDone() {
                Intent intent = intent3 == null ? new Intent() : intent3;
                intent.setClassName(aa.getPackageName(), str4.startsWith(".") ? (aa.bth() + ".plugin." + str3) + str4 : str4);
                MMWizardActivity.b(context2, intent, intent4);
            }
        }, new b() {
            public final void b(Exception exception) {
                v.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", str);
                v.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", exception);
            }
        });
    }

    public static void w(Context context, String str, String str2) {
        a(context, str, str2, null, true);
    }

    public static void b(Context context, String str, String str2, Intent intent) {
        if (!f.dX(21)) {
            try {
                if (context.getSharedPreferences(aa.bti(), 0).getBoolean("settings_multi_webview", false) && ".ui.tools.WebViewUI".endsWith(str2)) {
                    intent.addFlags(134217728);
                    intent.addFlags(524288);
                }
            } catch (Exception e) {
                v.e("MicroMsg.PluginHelper", "%s", e.getMessage());
            }
        }
        a(context, str, str2, intent, true);
    }

    public static void a(final Context context, final String str, final String str2, final Intent intent, boolean z) {
        v.d("MicroMsg.PluginHelper", "start activity, need try load plugin[%B]", Boolean.valueOf(z));
        a anonymousClass7 = new a() {
            public final void onDone() {
                v.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s", str);
                try {
                    Intent intent = intent == null ? new Intent() : intent;
                    String str = str2.startsWith(".") ? (aa.bth() + ".plugin." + str) + str2 : str2;
                    intent.setClassName(aa.getPackageName(), str);
                    Class.forName(str, false, context.getClassLoader());
                    if (context instanceof Activity) {
                        context.startActivity(intent);
                        return;
                    }
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    context.startActivity(intent);
                } catch (ClassNotFoundException e) {
                    v.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", e);
                }
            }
        };
        b anonymousClass8 = new b() {
            public final void b(Exception exception) {
                v.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                v.e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
            }
        };
        if (z) {
            a(str, anonymousClass7, anonymousClass8);
        } else {
            anonymousClass7.onDone();
        }
    }

    public static void a(Context context, String str, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        String bth = aa.bth();
        if (str.startsWith(".")) {
            str = bth + str;
        }
        intent.setClassName(aa.getPackageName(), str);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(intent);
    }

    public static void b(Context context, String str, String str2, int i) {
        a(context, str, str2, null, i, true);
    }

    public static void b(Context context, String str, String str2, Intent intent, int i) {
        a(context, str, str2, intent, i, true);
    }

    public static void a(Context context, final String str, String str2, Intent intent, int i, boolean z) {
        v.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", Boolean.valueOf(z));
        final Intent intent2 = intent;
        final String str3 = str;
        final String str4 = str2;
        final Context context2 = context;
        final int i2 = i;
        a(str, new a() {
            public final void onDone() {
                Intent intent = intent2 == null ? new Intent() : intent2;
                intent.setClassName(aa.getPackageName(), str4.startsWith(".") ? (aa.bth() + ".plugin." + str3) + str4 : str4);
                if (context2 instanceof Activity) {
                    ((Activity) context2).startActivityForResult(intent, i2);
                    c.b(context2, str4, intent);
                    return;
                }
                v.f("MicroMsg.PluginHelper", "context not activity, skipped");
            }
        }, new b() {
            public final void b(Exception exception) {
                v.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                v.e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
            }
        });
    }

    public static void a(Fragment fragment, final String str, String str2, Intent intent, int i) {
        v.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", Boolean.valueOf(true));
        final Intent intent2 = intent;
        final String str3 = str;
        final String str4 = str2;
        final Fragment fragment2 = fragment;
        final int i2 = i;
        a(str, new a() {
            public final void onDone() {
                Intent intent = intent2 == null ? new Intent() : intent2;
                intent.setClassName(aa.getPackageName(), str4.startsWith(".") ? (aa.bth() + ".plugin." + str3) + str4 : str4);
                fragment2.startActivityForResult(intent, i2);
                c.b(fragment2.aG(), str4, intent2);
            }
        }, new b() {
            public final void b(Exception exception) {
                v.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                v.e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
            }
        });
    }

    public static void b(Context context, String str, Intent intent) {
        if (intent != null && lVP.contains(str)) {
            intent.putExtra("animation_pop_in", true);
            b.x(context, intent);
        }
    }

    public static void a(Context context, String str, Intent intent, int i) {
        intent.setClassName(aa.getPackageName(), str.startsWith(".") ? aa.bth() + str : str);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            b(context, str, intent);
            return;
        }
        v.f("MicroMsg.PluginHelper", "context not activity, skipped");
    }

    public static void a(MMActivity mMActivity, String str, Intent intent, int i, a aVar) {
        String bth = aa.bth();
        if (str.startsWith(".")) {
            bth = bth + str;
        } else {
            bth = str;
        }
        intent.setClassName(aa.getPackageName(), bth);
        mMActivity.a(aVar, intent, i);
        b(mMActivity, str, intent);
    }

    public static void a(Fragment fragment, String str, Intent intent, int i) {
        intent.setClassName(aa.getPackageName(), str.startsWith(".") ? aa.bth() + str : str);
        if (fragment instanceof Fragment) {
            fragment.startActivityForResult(intent, i);
            b(fragment.aG(), str, intent);
            return;
        }
        v.f("MicroMsg.PluginHelper", "fragment not Fragment, skipped");
    }

    public static void k(String str, Map<String, ag> map) {
        v.d("MicroMsg.PluginHelper", "-->createSubCore: %s", str);
        com.tencent.mm.pluginsdk.c.c Il = Il(str);
        if (Il == null) {
            v.f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", str);
            return;
        }
        ag createSubCore = Il.createSubCore();
        if (createSubCore == null) {
            v.w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", str);
            return;
        }
        if (map != null) {
            map.put("plugin." + str, createSubCore);
        }
        v.d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", str);
    }

    public static void a(String str, h hVar, g gVar) {
        v.d("MicroMsg.PluginHelper", "--> registerApplication: %s", str);
        com.tencent.mm.pluginsdk.c.c Il = Il(str);
        if (Il == null) {
            v.f("MicroMsg.PluginHelper", "register application failed, plugin=%s", str);
            return;
        }
        i createApplication = Il.createApplication();
        if (createApplication == null) {
            v.w("MicroMsg.PluginHelper", "register application failed, plugin=%s", str);
            return;
        }
        createApplication.a(gVar);
        createApplication.a(hVar);
        v.d("MicroMsg.PluginHelper", "<-- registerApplication successfully: %s", str);
    }

    public static com.tencent.mm.pluginsdk.c.a J(Context context, String str) {
        return x(context, str, null);
    }

    public static com.tencent.mm.pluginsdk.c.a x(Context context, String str, String str2) {
        com.tencent.mm.pluginsdk.c.c Il = Il(str);
        if (Il == null) {
            v.f("MicroMsg.PluginHelper", "create contact widget failed, plugin=%s, type=%s", str, str2);
            return null;
        }
        com.tencent.mm.pluginsdk.c.b contactWidgetFactory = Il.getContactWidgetFactory();
        if (contactWidgetFactory != null) {
            return contactWidgetFactory.J(context, str2);
        }
        v.f("MicroMsg.PluginHelper", "create contact widget factory failed, plugin=%s, type=%s", str, str2);
        return null;
    }

    public static boolean brh() {
        return false;
    }

    public static synchronized boolean EH(String str) {
        boolean z;
        synchronized (c.class) {
            z = lVO.get(str) != null;
        }
        return z;
    }

    private static synchronized com.tencent.mm.pluginsdk.c.c Il(String str) {
        com.tencent.mm.pluginsdk.c.c Im;
        synchronized (c.class) {
            try {
                Im = Im(str);
            } catch (ClassNotFoundException e) {
                v.f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s, e:%s", str, e.toString());
                Im = null;
                return Im;
            } catch (InstantiationException e2) {
                v.f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", str, e2.toString());
                Im = null;
                return Im;
            } catch (IllegalAccessException e3) {
                v.f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", str, e3.toString());
                Im = null;
                return Im;
            }
        }
        return Im;
    }

    public static synchronized com.tencent.mm.pluginsdk.c.c a(String str, a aVar, b bVar) {
        com.tencent.mm.pluginsdk.c.c cVar;
        synchronized (c.class) {
            if (((String) lVN.get(str)) != null) {
                v.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", str, (String) lVN.get(str));
            }
            cVar = (com.tencent.mm.pluginsdk.c.c) lVO.get(str);
            if (cVar != null) {
                aVar.onDone();
            } else {
                try {
                    cVar = Im(str);
                    if (cVar != null) {
                        aVar.onDone();
                    }
                } catch (Exception e) {
                    try {
                        cVar = Im(str);
                        if (cVar != null) {
                            aVar.onDone();
                        }
                    } catch (ClassNotFoundException e2) {
                        v.f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s ,e:%s", str, e2.toString());
                        v.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        bVar.b(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        return cVar;
                    } catch (InstantiationException e3) {
                        v.f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", str, e3.toString());
                        v.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        bVar.b(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        return cVar;
                    } catch (IllegalAccessException e4) {
                        v.f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", str, e4.toString());
                        v.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        bVar.b(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        return cVar;
                    }
                }
            }
        }
        return cVar;
    }

    private static com.tencent.mm.pluginsdk.c.c Im(String str) {
        com.tencent.mm.pluginsdk.c.c cVar = (com.tencent.mm.pluginsdk.c.c) lVO.get(str);
        if (cVar != null) {
            return cVar;
        }
        cVar = (com.tencent.mm.pluginsdk.c.c) aa.getContext().getClassLoader().loadClass(aa.bth() + ".plugin." + str + ".Plugin").newInstance();
        lVO.put(str, cVar);
        return cVar;
    }

    public static synchronized Class<?> du(String str, String str2) {
        Class<?> loadClass;
        synchronized (c.class) {
            if (((String) lVN.get(str)) != null) {
                v.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", str, (String) lVN.get(str));
            }
            if (In(str)) {
                String str3 = aa.bth() + ".plugin." + str;
                if (str2.startsWith(".")) {
                    str2 = str3 + str2;
                }
                try {
                    loadClass = aa.getContext().getClassLoader().loadClass(str2);
                } catch (Exception e) {
                    v.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                    loadClass = null;
                }
            } else {
                v.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                loadClass = null;
            }
        }
        return loadClass;
    }

    public static synchronized boolean In(String str) {
        boolean z;
        synchronized (c.class) {
            z = Il(str) != null;
        }
        return z;
    }
}
