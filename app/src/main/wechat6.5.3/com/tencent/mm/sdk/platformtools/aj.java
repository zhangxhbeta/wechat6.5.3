package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Looper;
import android.util.LruCache;
import android.util.Xml;
import com.tencent.mm.sdk.i.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public final class aj implements SharedPreferences {
    private static final LruCache<String, aj> njA = new LruCache(5);
    private static Class<?> njB = null;
    private static Method njC = null;
    private static Method njD = null;
    private static boolean njE = false;
    private static ac njq = null;
    private static final Object njy = new Object();
    private File dAr = null;
    private Map<String, Object> hKi = null;
    private boolean jWm = false;
    private int mMode = 0;
    private FLock njr = null;
    private File njs = null;
    private boolean njt = false;
    private int nju = 0;
    private long njv = 0;
    private long njw = 0;
    private final Object njx = new Object();
    private final WeakHashMap<OnSharedPreferenceChangeListener, Object> njz = new WeakHashMap();

    public static class a {
        private static SharedPreferences mPref = aa.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
        public static String njG = "pref_key_is_enable_MultiProcSP";
        public static String njH = "pref_key_is_disabled_MultiProcSP_manually";

        public static void iw(boolean z) {
            setValue(njH, z);
        }

        public static boolean btG() {
            return !Kn(njH) && Kn(njG);
        }

        private static boolean Kn(String str) {
            SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
            mPref = sharedPreferences;
            if (sharedPreferences == null) {
                v.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                return false;
            }
            v.d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", Boolean.valueOf(mPref.getBoolean(str, false)));
            return mPref.getBoolean(str, false);
        }

        public static void setValue(String str, boolean z) {
            if (mPref == null) {
                v.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                return;
            }
            Editor edit = mPref.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    private final class b implements Editor {
        final /* synthetic */ aj njF;
        private final Map<String, Object> njI;
        private boolean njJ;

        private b(aj ajVar) {
            this.njF = ajVar;
            this.njI = new HashMap();
            this.njJ = false;
        }

        static /* synthetic */ void a(b bVar, c cVar) {
            if (bVar.njF.njt) {
                try {
                    bVar.njF.njr.bsP();
                } catch (Throwable e) {
                    v.a("MicroMsg.MultiProcSharedPreferences", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
            try {
                if (bVar.njF.dAr.exists()) {
                    if (!cVar.njO) {
                        cVar.ix(true);
                        if (bVar.njF.njt) {
                            try {
                                bVar.njF.njr.unlock();
                                return;
                            } catch (Exception e2) {
                                return;
                            }
                        }
                        return;
                    } else if (bVar.njF.njs.exists()) {
                        bVar.njF.dAr.delete();
                    } else if (!bVar.njF.dAr.renameTo(bVar.njF.njs)) {
                        v.e("MicroMsg.MultiProcSharedPreferences", "Couldn't rename file " + bVar.njF.dAr + " to backup file " + bVar.njF.njs);
                        cVar.ix(false);
                        if (bVar.njF.njt) {
                            try {
                                bVar.njF.njr.unlock();
                                return;
                            } catch (Exception e3) {
                                return;
                            }
                        }
                        return;
                    }
                }
                try {
                    OutputStream x = bVar.x(bVar.njF.dAr);
                    if (x == null) {
                        cVar.ix(false);
                        if (bVar.njF.njt) {
                            try {
                                bVar.njF.njr.unlock();
                                return;
                            } catch (Exception e4) {
                                return;
                            }
                        }
                        return;
                    }
                    Map map = cVar.njQ;
                    XmlSerializer newSerializer = Xml.newSerializer();
                    newSerializer.setOutput(x, "utf-8");
                    newSerializer.startDocument(null, Boolean.valueOf(true));
                    newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                    bg.a(map, null, newSerializer);
                    newSerializer.endDocument();
                    x.getFD().sync();
                    x.close();
                    aj.e(bVar.njF.dAr, bVar.njF.mMode);
                    synchronized (bVar) {
                        bVar.njF.njv = bVar.njF.dAr.lastModified();
                        bVar.njF.njw = bVar.njF.dAr.length();
                    }
                    bVar.njF.njs.delete();
                    cVar.ix(true);
                    if (bVar.njF.njt) {
                        try {
                            bVar.njF.njr.unlock();
                        } catch (Exception e5) {
                        }
                    }
                } catch (XmlPullParserException e6) {
                    v.w("MicroMsg.MultiProcSharedPreferences", "writeToFile: Got exception:", e6);
                    if (bVar.njF.dAr.exists() && !bVar.njF.dAr.delete()) {
                        v.e("MicroMsg.MultiProcSharedPreferences", "Couldn't clean up partially-written file " + bVar.njF.dAr);
                    }
                    cVar.ix(false);
                    if (bVar.njF.njt) {
                        try {
                            bVar.njF.njr.unlock();
                        } catch (Exception e7) {
                        }
                    }
                } catch (IOException e8) {
                    v.w("MicroMsg.MultiProcSharedPreferences", "writeToFile: Got exception:", e8);
                    v.e("MicroMsg.MultiProcSharedPreferences", "Couldn't clean up partially-written file " + bVar.njF.dAr);
                    cVar.ix(false);
                    if (bVar.njF.njt) {
                        bVar.njF.njr.unlock();
                    }
                }
            } catch (Throwable th) {
                if (bVar.njF.njt) {
                    try {
                        bVar.njF.njr.unlock();
                    } catch (Exception e9) {
                    }
                }
            }
        }

        public final Editor putString(String str, String str2) {
            synchronized (this) {
                this.njI.put(str, str2);
            }
            return this;
        }

        public final Editor putStringSet(String str, Set<String> set) {
            synchronized (this) {
                this.njI.put(str, set);
            }
            return this;
        }

        public final Editor putInt(String str, int i) {
            synchronized (this) {
                this.njI.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public final Editor putLong(String str, long j) {
            synchronized (this) {
                this.njI.put(str, Long.valueOf(j));
            }
            return this;
        }

        public final Editor putFloat(String str, float f) {
            synchronized (this) {
                this.njI.put(str, Float.valueOf(f));
            }
            return this;
        }

        public final Editor putBoolean(String str, boolean z) {
            synchronized (this) {
                this.njI.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        public final Editor remove(String str) {
            synchronized (this) {
                this.njI.put(str, this);
            }
            return this;
        }

        public final Editor clear() {
            synchronized (this) {
                this.njJ = true;
            }
            return this;
        }

        public final boolean commit() {
            c btH = btH();
            a(btH, null);
            try {
                btH.njR.await();
                a(btH);
                return btH.njS;
            } catch (InterruptedException e) {
                return false;
            }
        }

        public final void apply() {
            final c btH = btH();
            final Runnable anonymousClass1 = new Runnable(this) {
                final /* synthetic */ b njL;

                public final void run() {
                    try {
                        btH.njR.await();
                    } catch (InterruptedException e) {
                    }
                }
            };
            aq.D(anonymousClass1);
            a(btH, new Runnable(this) {
                final /* synthetic */ b njL;

                public final void run() {
                    anonymousClass1.run();
                    aq.E(anonymousClass1);
                }
            });
            a(btH);
        }

        private c btH() {
            c cVar = new c();
            synchronized (this.njF) {
                if (this.njF.nju > 0) {
                    this.njF.hKi = new HashMap(this.njF.hKi);
                }
                cVar.njQ = this.njF.hKi;
                this.njF.nju = this.njF.nju + 1;
                byte b = this.njF.njz.size() > 0 ? (byte) 1 : (byte) 0;
                if (b != (byte) 0) {
                    cVar.njP = new ArrayList();
                    cVar.cbh = new HashSet(this.njF.njz.keySet());
                }
                synchronized (this) {
                    if (this.njJ) {
                        if (!this.njF.hKi.isEmpty()) {
                            cVar.njO = true;
                            this.njF.hKi.clear();
                        }
                        this.njJ = false;
                    }
                    for (Entry entry : this.njI.entrySet()) {
                        String str = (String) entry.getKey();
                        b value = entry.getValue();
                        if (value != this) {
                            if (this.njF.hKi.containsKey(str)) {
                                Object obj = this.njF.hKi.get(str);
                                if (obj != null && obj.equals(value)) {
                                }
                            }
                            this.njF.hKi.put(str, value);
                        } else if (this.njF.hKi.containsKey(str)) {
                            this.njF.hKi.remove(str);
                        }
                        cVar.njO = true;
                        if (b != (byte) 0) {
                            cVar.njP.add(str);
                        }
                    }
                    this.njI.clear();
                }
            }
            return cVar;
        }

        private void a(final c cVar, final Runnable runnable) {
            Object obj = 1;
            Runnable anonymousClass3 = new Runnable(this) {
                final /* synthetic */ b njL;

                public final void run() {
                    synchronized (this.njL.njF.njx) {
                        b.a(this.njL, cVar);
                    }
                    synchronized (this.njL.njF) {
                        this.njL.njF.nju = this.njL.njF.nju - 1;
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            };
            if ((runnable == null ? 1 : null) != null) {
                synchronized (this.njF) {
                    if (this.njF.nju != 1) {
                        obj = null;
                    }
                }
                if (obj != null) {
                    anonymousClass3.run();
                    return;
                }
            }
            aq.btL().execute(anonymousClass3);
        }

        private FileOutputStream x(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                File parentFile = file.getParentFile();
                if (parentFile.mkdir()) {
                    aj.e(parentFile, this.njF.mMode);
                    try {
                        return new FileOutputStream(file);
                    } catch (FileNotFoundException e2) {
                        v.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create SharedPreferences file " + file, e2);
                        return null;
                    }
                }
                v.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create directory for SharedPreferences file " + file);
                return null;
            }
        }

        private void a(final c cVar) {
            if (cVar.cbh != null && cVar.njP != null && cVar.njP.size() != 0) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    for (int size = cVar.njP.size() - 1; size >= 0; size--) {
                        String str = (String) cVar.njP.get(size);
                        for (OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : cVar.cbh) {
                            if (onSharedPreferenceChangeListener != null) {
                                onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.njF, str);
                            }
                        }
                    }
                    return;
                }
                aj.njq.post(new Runnable(this) {
                    final /* synthetic */ b njL;

                    public final void run() {
                        this.njL.a(cVar);
                    }
                });
            }
        }
    }

    private static class c {
        public Set<OnSharedPreferenceChangeListener> cbh;
        public boolean njO;
        public List<String> njP;
        public Map<String, Object> njQ;
        public final CountDownLatch njR;
        public volatile boolean njS;

        private c() {
            this.njO = false;
            this.njP = null;
            this.cbh = null;
            this.njQ = null;
            this.njR = new CountDownLatch(1);
            this.njS = false;
        }

        public final void ix(boolean z) {
            this.njS = z;
            this.njR.countDown();
        }
    }

    static /* synthetic */ void a(aj ajVar) {
        Object obj;
        XmlPullParserException xmlPullParserException;
        FileNotFoundException fileNotFoundException;
        IOException iOException;
        Map map = null;
        if (ajVar.njt) {
            try {
                ajVar.njr.bsO();
            } catch (Throwable e) {
                v.a("MicroMsg.MultiProcSharedPreferences", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        try {
            if (!ajVar.jWm) {
                if (ajVar.njs.exists()) {
                    ajVar.dAr.delete();
                    ajVar.njs.renameTo(ajVar.dAr);
                }
                if (ajVar.dAr.exists() && !ajVar.dAr.canRead()) {
                    v.w("MicroMsg.MultiProcSharedPreferences", "Attempt to read preferences file " + ajVar.dAr + " without permission");
                }
                if (ajVar.dAr.canRead()) {
                    InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(ajVar.dAr), 16384);
                    XmlPullParser newPullParser = Xml.newPullParser();
                    newPullParser.setInput(bufferedInputStream, null);
                    HashMap hashMap = (HashMap) bg.a(newPullParser, new String[1]);
                    try {
                        bufferedInputStream.close();
                        map = hashMap;
                    } catch (XmlPullParserException e2) {
                        XmlPullParserException xmlPullParserException2 = e2;
                        obj = hashMap;
                        xmlPullParserException = xmlPullParserException2;
                        v.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", xmlPullParserException);
                        ajVar.jWm = true;
                        if (map != null) {
                            ajVar.hKi = new HashMap();
                        } else {
                            ajVar.hKi = map;
                            ajVar.njv = ajVar.dAr.lastModified();
                            ajVar.njw = ajVar.dAr.length();
                        }
                        ajVar.notifyAll();
                        if (!ajVar.njt) {
                            try {
                                ajVar.njr.unlock();
                            } catch (Exception e3) {
                                return;
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        FileNotFoundException fileNotFoundException2 = e4;
                        obj = hashMap;
                        fileNotFoundException = fileNotFoundException2;
                        v.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", fileNotFoundException);
                        ajVar.jWm = true;
                        if (map != null) {
                            ajVar.hKi = map;
                            ajVar.njv = ajVar.dAr.lastModified();
                            ajVar.njw = ajVar.dAr.length();
                        } else {
                            ajVar.hKi = new HashMap();
                        }
                        ajVar.notifyAll();
                        if (!ajVar.njt) {
                            ajVar.njr.unlock();
                        }
                    } catch (IOException e5) {
                        IOException iOException2 = e5;
                        obj = hashMap;
                        iOException = iOException2;
                        v.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", iOException);
                        ajVar.jWm = true;
                        if (map != null) {
                            ajVar.hKi = new HashMap();
                        } else {
                            ajVar.hKi = map;
                            ajVar.njv = ajVar.dAr.lastModified();
                            ajVar.njw = ajVar.dAr.length();
                        }
                        ajVar.notifyAll();
                        if (!ajVar.njt) {
                            ajVar.njr.unlock();
                        }
                    }
                }
                ajVar.jWm = true;
                if (map != null) {
                    ajVar.hKi = map;
                    ajVar.njv = ajVar.dAr.lastModified();
                    ajVar.njw = ajVar.dAr.length();
                } else {
                    ajVar.hKi = new HashMap();
                }
                ajVar.notifyAll();
                if (!ajVar.njt) {
                    ajVar.njr.unlock();
                }
            } else if (ajVar.njt) {
                try {
                    ajVar.njr.unlock();
                } catch (Exception e6) {
                }
            }
        } catch (XmlPullParserException e7) {
            xmlPullParserException = e7;
            v.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", xmlPullParserException);
            ajVar.jWm = true;
            if (map != null) {
                ajVar.hKi = map;
                ajVar.njv = ajVar.dAr.lastModified();
                ajVar.njw = ajVar.dAr.length();
            } else {
                ajVar.hKi = new HashMap();
            }
            ajVar.notifyAll();
            if (!ajVar.njt) {
                ajVar.njr.unlock();
            }
        } catch (FileNotFoundException e8) {
            fileNotFoundException = e8;
            v.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", fileNotFoundException);
            ajVar.jWm = true;
            if (map != null) {
                ajVar.hKi = new HashMap();
            } else {
                ajVar.hKi = map;
                ajVar.njv = ajVar.dAr.lastModified();
                ajVar.njw = ajVar.dAr.length();
            }
            ajVar.notifyAll();
            if (!ajVar.njt) {
                ajVar.njr.unlock();
            }
        } catch (IOException e9) {
            iOException = e9;
            v.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", iOException);
            ajVar.jWm = true;
            if (map != null) {
                ajVar.hKi = map;
                ajVar.njv = ajVar.dAr.lastModified();
                ajVar.njw = ajVar.dAr.length();
            } else {
                ajVar.hKi = new HashMap();
            }
            ajVar.notifyAll();
            if (!ajVar.njt) {
                ajVar.njr.unlock();
            }
        } catch (Throwable th) {
            if (ajVar.njt) {
                try {
                    ajVar.njr.unlock();
                } catch (Exception e10) {
                }
            }
        }
    }

    static /* synthetic */ void e(File file, int i) {
        boolean z = false;
        file.setReadable(true, (i & 1) == 0);
        if ((i & 2) == 0) {
            z = true;
        }
        file.setWritable(true, z);
    }

    public static SharedPreferences aX(Context context, String str) {
        int i = 1;
        if (a.btG()) {
            v.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use Flock version MultiProcessSP.", str);
            aj ajVar = (aj) njA.get(str);
            if (ajVar == null) {
                SharedPreferences ajVar2 = new aj(context, str, 4);
                njA.put(str, ajVar2);
                return ajVar2;
            }
            synchronized (ajVar) {
                if (ajVar.nju > 0 || (ajVar.njv == ajVar.dAr.lastModified() && ajVar.njw == ajVar.dAr.length())) {
                    i = 0;
                }
                if (i == 0) {
                    return ajVar;
                }
                ajVar.btD();
                return ajVar;
            }
        }
        v.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use system sp.", str);
        return context.getSharedPreferences(str, 4);
    }

    private aj() {
        throw new RuntimeException("Not supported.");
    }

    private aj(Context context, String str, int i) {
        Context applicationContext = context.getApplicationContext();
        if (njq == null) {
            njq = new ac(Looper.getMainLooper());
        }
        String str2 = applicationContext.getApplicationInfo().dataDir;
        if (str2 == null || str2.length() == 0) {
            v.w("MicroMsg.MultiProcSharedPreferences", "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
            str2 = "/data/data/" + applicationContext.getPackageName();
        }
        v.i("MicroMsg.MultiProcSharedPreferences", "Path to store sp data: " + str2);
        File file = new File(str2, "shared_prefs");
        if (!file.exists()) {
            file.mkdirs();
        } else if (!(file.canRead() && file.canWrite())) {
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
        this.dAr = new File(file, str + ".xml");
        this.njs = new File(this.dAr.getPath() + ".bak");
        this.mMode = 4;
        this.njt = true;
        if (this.njt) {
            this.njr = new FLock(this.dAr.getPath() + ".lock");
        }
        btD();
    }

    private void btD() {
        synchronized (this) {
            this.jWm = false;
        }
        e.c(new Runnable(this) {
            final /* synthetic */ aj njF;

            {
                this.njF = r1;
            }

            public final void run() {
                synchronized (this.njF) {
                    aj.a(this.njF);
                }
            }
        }, "MultiProcessSP-LoadThread").start();
    }

    public final void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            this.njz.put(onSharedPreferenceChangeListener, njy);
        }
    }

    public final void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            this.njz.remove(onSharedPreferenceChangeListener);
        }
    }

    private void btE() {
        if (!(this.jWm || njE)) {
            if (njB == null) {
                try {
                    njB = Class.forName("dalvik.system.BlockGuard");
                } catch (Throwable th) {
                    njE = true;
                }
            }
            if (njC == null) {
                try {
                    Method declaredMethod = njB.getDeclaredMethod("getThreadPolicy", new Class[0]);
                    njC = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Throwable th2) {
                    njE = true;
                }
            }
            try {
                if (njC != null) {
                    Object invoke = njC.invoke(null, new Object[0]);
                    if (njD == null) {
                        Method declaredMethod2 = invoke.getClass().getDeclaredMethod("onReadFromDisk", new Class[0]);
                        njD = declaredMethod2;
                        declaredMethod2.setAccessible(true);
                    }
                    njD.invoke(invoke, new Object[0]);
                }
            } catch (Throwable th3) {
                njE = true;
            }
        }
        while (!this.jWm) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public final Map<String, ?> getAll() {
        Map hashMap;
        synchronized (this) {
            btE();
            hashMap = new HashMap(this.hKi);
        }
        return hashMap;
    }

    public final String getString(String str, String str2) {
        String str3;
        synchronized (this) {
            btE();
            str3 = (String) this.hKi.get(str);
            if (str3 == null) {
                str3 = str2;
            }
        }
        return str3;
    }

    public final Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        synchronized (this) {
            btE();
            set2 = (Set) this.hKi.get(str);
            if (set2 == null) {
                set2 = set;
            }
        }
        return set2;
    }

    public final int getInt(String str, int i) {
        synchronized (this) {
            btE();
            Integer num = (Integer) this.hKi.get(str);
            if (num != null) {
                i = num.intValue();
            }
        }
        return i;
    }

    public final long getLong(String str, long j) {
        synchronized (this) {
            btE();
            Long l = (Long) this.hKi.get(str);
            if (l != null) {
                j = l.longValue();
            }
        }
        return j;
    }

    public final float getFloat(String str, float f) {
        synchronized (this) {
            btE();
            Float f2 = (Float) this.hKi.get(str);
            if (f2 != null) {
                f = f2.floatValue();
            }
        }
        return f;
    }

    public final boolean getBoolean(String str, boolean z) {
        synchronized (this) {
            btE();
            Boolean bool = (Boolean) this.hKi.get(str);
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public final boolean contains(String str) {
        boolean containsKey;
        synchronized (this) {
            btE();
            containsKey = this.hKi.containsKey(str);
        }
        return containsKey;
    }

    public final Editor edit() {
        synchronized (this) {
            btE();
        }
        return new b();
    }
}
