package com.tencent.smtt.export.external;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DexLoader {
    private DexClassLoader mClassLoader;

    public DexLoader(Context context, String str, String str2) {
        this(context, new String[]{str}, str2);
    }

    public DexLoader(Context context, String[] strArr, String str) {
        this(null, context, strArr, str);
    }

    public DexLoader(Context context, String[] strArr, String str, DexLoader dexLoader) {
        ClassLoader classLoader = dexLoader.getClassLoader();
        int i = 0;
        while (i < strArr.length) {
            ClassLoader dexClassLoader = new DexClassLoader(strArr[i], str, context.getApplicationInfo().nativeLibraryDir, classLoader);
            this.mClassLoader = dexClassLoader;
            i++;
            classLoader = dexClassLoader;
        }
    }

    public DexLoader(Context context, String[] strArr, String str, String str2) {
        ClassLoader classLoader = context.getClassLoader();
        String str3 = context.getApplicationInfo().nativeLibraryDir;
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + File.pathSeparator + str2;
        }
        int i = 0;
        while (i < strArr.length) {
            ClassLoader dexClassLoader = new DexClassLoader(strArr[i], str, str3, classLoader);
            this.mClassLoader = dexClassLoader;
            i++;
            classLoader = dexClassLoader;
        }
    }

    public DexLoader(String str, Context context, String[] strArr, String str2) {
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        if (callingClassLoader == null) {
            callingClassLoader = context.getClassLoader();
        }
        int i = 0;
        while (i < strArr.length) {
            ClassLoader dexClassLoader = new DexClassLoader(strArr[i], str2, str, callingClassLoader);
            this.mClassLoader = dexClassLoader;
            i++;
            callingClassLoader = dexClassLoader;
        }
    }

    public DexClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public Object getStaticField(String str, String str2) {
        Object obj = null;
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            obj = field.get(null);
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' get field '").append(str2).append("' failed");
        }
        return obj;
    }

    public Object invokeMethod(Object obj, String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' invoke method '").append(str2).append("' failed");
            return null;
        }
    }

    public Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable th) {
            if (str2 == null || !str2.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                getClass().getSimpleName();
                new StringBuilder("'").append(str).append("' invoke static method '").append(str2).append("' failed");
                return null;
            }
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' invoke static method '").append(str2).append("' failed");
            return th;
        }
    }

    public Class<?> loadClass(String str) {
        try {
            return this.mClassLoader.loadClass(str);
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("loadClass '").append(str).append("' failed");
            return null;
        }
    }

    public Object newInstance(String str) {
        try {
            return this.mClassLoader.loadClass(str).newInstance();
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("create ").append(str).append(" instance failed");
            return null;
        }
    }

    public Object newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return this.mClassLoader.loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            if ("com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(str)) {
                getClass().getSimpleName();
                new StringBuilder("'newInstance ").append(str).append(" failed");
                return th;
            }
            getClass().getSimpleName();
            new StringBuilder("create '").append(str).append("' instance failed");
            return null;
        }
    }

    public void setStaticField(String str, String str2, Object obj) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            field.set(null, obj);
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' set field '").append(str2).append("' failed");
        }
    }
}
