package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@TargetApi(14)
class AndroidNClassLoader extends PathClassLoader {
    static ArrayList<DexFile> pGl = new ArrayList();
    PathClassLoader pGm;

    private AndroidNClassLoader(String str, PathClassLoader pathClassLoader) {
        super(str, pathClassLoader.getParent());
        this.pGm = pathClassLoader;
    }

    public static AndroidNClassLoader a(PathClassLoader pathClassLoader, Application application) {
        Object androidNClassLoader = new AndroidNClassLoader(SQLiteDatabase.KeyEmpty, pathClassLoader);
        Object obj = ShareReflectUtil.a((Object) pathClassLoader, "pathList").get(pathClassLoader);
        ShareReflectUtil.a(obj, "definingContext").set(obj, androidNClassLoader);
        ShareReflectUtil.a(androidNClassLoader, "pathList").set(androidNClassLoader, obj);
        List arrayList = new ArrayList();
        Field a = ShareReflectUtil.a(obj, "dexElements");
        for (Object obj2 : (Object[]) a.get(obj)) {
            DexFile dexFile = (DexFile) ShareReflectUtil.a(obj2, "dexFile").get(obj2);
            arrayList.add(new File(dexFile.getName()));
            pGl.add(dexFile);
        }
        Method a2 = ShareReflectUtil.a(obj, "makePathElements", List.class, File.class, List.class);
        ArrayList arrayList2 = new ArrayList();
        a.set(obj, (Object[]) a2.invoke(obj, new Object[]{arrayList, null, arrayList2}));
        Object obj3 = (Context) ShareReflectUtil.a((Object) application, "mBase").get(application);
        obj3 = ShareReflectUtil.a(obj3, "mPackageInfo").get(obj3);
        Field a3 = ShareReflectUtil.a(obj3, "mClassLoader");
        Thread.currentThread().setContextClassLoader(androidNClassLoader);
        a3.set(obj3, androidNClassLoader);
        return androidNClassLoader;
    }

    public Class<?> findClass(String str) {
        return super.findClass(str);
    }

    public String findLibrary(String str) {
        return super.findLibrary(str);
    }
}
