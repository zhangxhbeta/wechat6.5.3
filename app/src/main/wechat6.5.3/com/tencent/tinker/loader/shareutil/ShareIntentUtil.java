package com.tencent.tinker.loader.shareutil;

import android.content.Intent;
import java.io.Serializable;
import java.util.HashMap;

public class ShareIntentUtil {
    public static void a(Intent intent, int i) {
        intent.putExtra("intent_return_code", i);
    }

    public static int ac(Intent intent) {
        return n(intent, "intent_return_code");
    }

    public static void a(Intent intent, long j) {
        intent.putExtra("intent_patch_cost_time", j);
    }

    public static long ad(Intent intent) {
        return intent.getLongExtra("intent_patch_cost_time", 0);
    }

    public static Exception ae(Intent intent) {
        Serializable m = m(intent, "intent_patch_exception");
        if (m != null) {
            return (Exception) m;
        }
        return null;
    }

    public static HashMap<String, String> af(Intent intent) {
        Serializable m = m(intent, "intent_patch_dexes_path");
        if (m != null) {
            return (HashMap) m;
        }
        return null;
    }

    public static HashMap<String, String> ag(Intent intent) {
        Serializable m = m(intent, "intent_patch_libs_path");
        if (m != null) {
            return (HashMap) m;
        }
        return null;
    }

    public static HashMap<String, String> ah(Intent intent) {
        Serializable m = m(intent, "intent_patch_package_config");
        if (m != null) {
            return (HashMap) m;
        }
        return null;
    }

    public static String g(Intent intent, String str) {
        String str2 = null;
        if (intent != null) {
            try {
                str2 = intent.getStringExtra(str);
            } catch (Exception e) {
                new StringBuilder("getStringExtra exception:").append(e.getMessage());
            }
        }
        return str2;
    }

    public static Serializable m(Intent intent, String str) {
        Serializable serializable = null;
        if (intent != null) {
            try {
                serializable = intent.getSerializableExtra(str);
            } catch (Exception e) {
                new StringBuilder("getSerializableExtra exception:").append(e.getMessage());
            }
        }
        return serializable;
    }

    private static int n(Intent intent, String str) {
        int i = -10000;
        if (intent != null) {
            try {
                i = intent.getIntExtra(str, -10000);
            } catch (Exception e) {
                new StringBuilder("getIntExtra exception:").append(e.getMessage());
            }
        }
        return i;
    }
}
