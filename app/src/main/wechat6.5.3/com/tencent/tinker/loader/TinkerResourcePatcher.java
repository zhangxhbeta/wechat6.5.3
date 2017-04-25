package com.tencent.tinker.loader;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class TinkerResourcePatcher {
    private static Method pGA = null;
    private static Field pGB = null;
    private static Field pGC = null;
    private static Field pGD = null;
    private static Field pGE = null;
    private static Field pGF = null;
    private static Collection<WeakReference<Resources>> pGx;
    private static AssetManager pGy = null;
    private static Method pGz = null;

    TinkerResourcePatcher() {
    }

    public static void gm(Context context) {
        Class cls;
        Class cls2 = Class.forName("android.app.ActivityThread");
        try {
            cls = Class.forName("android.app.LoadedApk");
        } catch (ClassNotFoundException e) {
            cls = Class.forName("android.app.ActivityThread$PackageInfo");
        }
        cls.getDeclaredField("mApplication").setAccessible(true);
        Field declaredField = cls.getDeclaredField("mResDir");
        pGD = declaredField;
        declaredField.setAccessible(true);
        declaredField = cls2.getDeclaredField("mPackages");
        pGE = declaredField;
        declaredField.setAccessible(true);
        declaredField = cls2.getDeclaredField("mResourcePackages");
        pGF = declaredField;
        declaredField.setAccessible(true);
        if (context.getAssets().getClass().getName().equals("android.content.res.BaiduAssetManager")) {
            pGy = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
        } else {
            pGy = (AssetManager) AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        Method declaredMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[]{String.class});
        pGz = declaredMethod;
        declaredMethod.setAccessible(true);
        declaredMethod = AssetManager.class.getDeclaredMethod("ensureStringBlocks", new Class[0]);
        pGA = declaredMethod;
        declaredMethod.setAccessible(true);
        if (VERSION.SDK_INT >= 19) {
            cls2 = Class.forName("android.app.ResourcesManager");
            declaredMethod = cls2.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            try {
                declaredField = cls2.getDeclaredField("mActiveResources");
                declaredField.setAccessible(true);
                pGx = ((ArrayMap) declaredField.get(invoke)).values();
            } catch (NoSuchFieldException e2) {
                declaredField = cls2.getDeclaredField("mResourceReferences");
                declaredField.setAccessible(true);
                pGx = (Collection) declaredField.get(invoke);
            }
        } else {
            declaredField = cls2.getDeclaredField("mActiveResources");
            declaredField.setAccessible(true);
            pGx = ((HashMap) declaredField.get(ShareReflectUtil.c(context, cls2))).values();
        }
        if (pGx == null || pGx.isEmpty()) {
            throw new IllegalStateException("resource references is null or empty");
        }
        try {
            declaredField = Resources.class.getDeclaredField("mAssets");
            pGB = declaredField;
            declaredField.setAccessible(true);
        } catch (Throwable th) {
            declaredField = Resources.class.getDeclaredField("mResourcesImpl");
            pGC = declaredField;
            declaredField.setAccessible(true);
        }
    }

    public static void bB(Context context, String str) {
        if (str != null) {
            Object c = ShareReflectUtil.c(context, Class.forName("android.app.ActivityThread"));
            Field[] fieldArr = new Field[]{pGE, pGF};
            for (int i = 0; i < 2; i++) {
                for (Entry value : ((Map) fieldArr[i].get(c)).entrySet()) {
                    Object obj = ((WeakReference) value.getValue()).get();
                    if (!(obj == null || str == null)) {
                        pGD.set(obj, str);
                    }
                }
            }
            if (((Integer) pGz.invoke(pGy, new Object[]{str})).intValue() == 0) {
                throw new IllegalStateException("Could not create new AssetManager");
            }
            pGA.invoke(pGy, new Object[0]);
            for (WeakReference weakReference : pGx) {
                Resources resources = (Resources) weakReference.get();
                if (resources != null) {
                    try {
                        pGB.set(resources, pGy);
                    } catch (Throwable th) {
                        Object obj2 = pGC.get(resources);
                        Field a = ShareReflectUtil.a(obj2, "mAssets");
                        a.setAccessible(true);
                        a.set(obj2, pGy);
                    }
                    resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
                }
            }
            if (!gn(context)) {
                throw new TinkerRuntimeException("checkResInstall failed");
            }
        }
    }

    private static boolean gn(Context context) {
        try {
            context.getAssets().open("only_use_to_test_tinker_resource.txt");
            return true;
        } catch (Throwable th) {
            new StringBuilder("checkResUpdate failed, can't find test resource assets file only_use_to_test_tinker_resource.txt e:").append(th.getMessage());
            return false;
        }
    }
}
