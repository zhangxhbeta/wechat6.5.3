package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.UriMatcher;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiProcessSharedPreferences extends ContentProvider implements SharedPreferences {
    private static String AUTHORITY;
    private static volatile Uri AUTHORITY_URI;
    private List<SoftReference<OnSharedPreferenceChangeListener>> eD;
    private BroadcastReceiver esp;
    private Context mContext;
    private int mMode;
    private String mName;
    private boolean njT;
    private UriMatcher njU;
    private Map<String, Integer> njV;

    private static final class a extends MatrixCursor {
        private Bundle uA;

        public a(Bundle bundle) {
            super(new String[0], 0);
            this.uA = bundle;
        }

        public final Bundle getExtras() {
            return this.uA;
        }

        public final Bundle respond(Bundle bundle) {
            this.uA = bundle;
            return this.uA;
        }
    }

    public final class b implements Editor {
        private final Map<String, Object> njI = new HashMap();
        private boolean njJ = false;
        final /* synthetic */ MultiProcessSharedPreferences njW;

        public b(MultiProcessSharedPreferences multiProcessSharedPreferences) {
            this.njW = multiProcessSharedPreferences;
        }

        public final Editor putString(String str, String str2) {
            synchronized (this) {
                this.njI.put(str, str2);
            }
            return this;
        }

        public final Editor putStringSet(String str, Set<String> set) {
            synchronized (this) {
                this.njI.put(str, set == null ? null : new HashSet(set));
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
                this.njI.put(str, null);
            }
            return this;
        }

        public final Editor clear() {
            synchronized (this) {
                this.njJ = true;
            }
            return this;
        }

        public final void apply() {
            setValue("apply");
        }

        public final boolean commit() {
            return setValue("commit");
        }

        private boolean setValue(String str) {
            if (this.njW.njT) {
                return false;
            }
            boolean z;
            synchronized (this.njW) {
                this.njW.dL(this.njW.mContext);
                String[] strArr = new String[]{String.valueOf(this.njW.mMode), String.valueOf(this.njJ)};
                synchronized (this) {
                    if (this.njW.mContext.getContentResolver().update(Uri.withAppendedPath(Uri.withAppendedPath(MultiProcessSharedPreferences.AUTHORITY_URI, this.njW.mName), str), c.f((HashMap) this.njI), null, strArr) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
            }
            return z;
        }
    }

    private static class c {
        public static ContentValues f(HashMap<String, Object> hashMap) {
            try {
                Constructor declaredConstructor = ContentValues.class.getDeclaredConstructor(new Class[]{HashMap.class});
                declaredConstructor.setAccessible(true);
                return (ContentValues) declaredConstructor.newInstance(new Object[]{hashMap});
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            } catch (Throwable e222) {
                throw new RuntimeException(e222);
            } catch (Throwable e2222) {
                throw new RuntimeException(e2222);
            }
        }

        public static Editor a(Editor editor, String str, Set<String> set) {
            try {
                return (Editor) editor.getClass().getDeclaredMethod("putStringSet", new Class[]{String.class, Set.class}).invoke(editor, new Object[]{str, set});
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            } catch (Throwable e222) {
                throw new RuntimeException(e222);
            }
        }
    }

    private void dL(Context context) {
        if (AUTHORITY_URI == null) {
            synchronized (this) {
                if (AUTHORITY_URI == null) {
                    AUTHORITY = dM(context);
                    AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
                }
                if (AUTHORITY == null) {
                    throw new IllegalArgumentException("'AUTHORITY' initialize failed.");
                }
            }
        }
    }

    private static String dM(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 8);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo == null || packageInfo.providers == null) {
            return null;
        }
        for (ProviderInfo providerInfo : packageInfo.providers) {
            if (providerInfo.name.equals(MultiProcessSharedPreferences.class.getName())) {
                return providerInfo.authority;
            }
        }
        return null;
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, int i) {
        return new MultiProcessSharedPreferences(context, str, i);
    }

    private MultiProcessSharedPreferences(Context context, String str, int i) {
        this.mContext = context;
        this.mName = str;
        this.mMode = i;
        this.njT = context.getPackageManager().isSafeMode();
    }

    public Map<String, ?> getAll() {
        return (Map) b("getAll", null, null);
    }

    public String getString(String str, String str2) {
        String str3 = (String) b("getString", str, str2);
        return str3 != null ? str3 : str2;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        synchronized (this) {
            set2 = (Set) b("getString", str, set);
            if (set2 == null) {
                set2 = set;
            }
        }
        return set2;
    }

    public int getInt(String str, int i) {
        Integer num = (Integer) b("getInt", str, Integer.valueOf(i));
        return num != null ? num.intValue() : i;
    }

    public long getLong(String str, long j) {
        Long l = (Long) b("getLong", str, Long.valueOf(j));
        return l != null ? l.longValue() : j;
    }

    public float getFloat(String str, float f) {
        Float f2 = (Float) b("getFloat", str, Float.valueOf(f));
        return f2 != null ? f2.floatValue() : f;
    }

    public boolean getBoolean(String str, boolean z) {
        Boolean bool = (Boolean) b("getBoolean", str, Boolean.valueOf(z));
        return bool != null ? bool.booleanValue() : z;
    }

    public boolean contains(String str) {
        Boolean bool = (Boolean) b("contains", str, null);
        return bool != null ? bool.booleanValue() : false;
    }

    public Editor edit() {
        return new b(this);
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            if (this.eD == null) {
                this.eD = new ArrayList();
            }
            Boolean bool = (Boolean) b("registerOnSharedPreferenceChangeListener", null, Boolean.valueOf(false));
            if (bool != null && bool.booleanValue()) {
                this.eD.add(new SoftReference(onSharedPreferenceChangeListener));
                if (this.esp == null) {
                    this.esp = new BroadcastReceiver(this) {
                        final /* synthetic */ MultiProcessSharedPreferences njW;

                        {
                            this.njW = r1;
                        }

                        public final void onReceive(Context context, Intent intent) {
                            List list = (List) intent.getSerializableExtra("value");
                            if (this.njW.mName.equals(intent.getStringExtra("name")) && list != null) {
                                List<SoftReference> arrayList = new ArrayList(this.njW.eD);
                                for (int size = list.size() - 1; size >= 0; size--) {
                                    String str = (String) list.get(size);
                                    for (SoftReference softReference : arrayList) {
                                        OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (OnSharedPreferenceChangeListener) softReference.get();
                                        if (onSharedPreferenceChangeListener != null) {
                                            onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.njW, str);
                                        }
                                    }
                                }
                            }
                        }
                    };
                    this.mContext.registerReceiver(this.esp, new IntentFilter(Ko(this.mName)));
                }
            }
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            b("unregisterOnSharedPreferenceChangeListener", null, Boolean.valueOf(false));
            if (this.eD != null) {
                for (SoftReference softReference : this.eD) {
                    OnSharedPreferenceChangeListener onSharedPreferenceChangeListener2 = (OnSharedPreferenceChangeListener) softReference.get();
                    if (onSharedPreferenceChangeListener2 != null && onSharedPreferenceChangeListener2.equals(onSharedPreferenceChangeListener)) {
                        this.eD.remove(softReference);
                    }
                }
                if (this.eD.isEmpty() && this.esp != null) {
                    this.mContext.unregisterReceiver(this.esp);
                    this.esp = null;
                    this.eD = null;
                }
            }
        }
    }

    private Object b(String str, String str2, Object obj) {
        Object obj2 = null;
        if (this.njT) {
            return null;
        }
        dL(this.mContext);
        Uri withAppendedPath = Uri.withAppendedPath(Uri.withAppendedPath(AUTHORITY_URI, this.mName), str);
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(this.mMode);
        strArr[1] = str2;
        strArr[2] = obj == null ? null : String.valueOf(obj);
        Cursor query = this.mContext.getContentResolver().query(withAppendedPath, null, null, strArr, null);
        if (query != null) {
            Bundle extras = query.getExtras();
            if (extras != null) {
                obj2 = extras.get("value");
                extras.clear();
            }
            query.close();
        }
        if (obj2 == null) {
            return obj;
        }
        return obj2;
    }

    private static String Ko(String str) {
        return String.format("%1$s_%2$s", new Object[]{MultiProcessSharedPreferences.class.getName(), str});
    }

    public boolean onCreate() {
        dL(getContext());
        this.njU = new UriMatcher(-1);
        this.njU.addURI(AUTHORITY, "*/getAll", 1);
        this.njU.addURI(AUTHORITY, "*/getString", 2);
        this.njU.addURI(AUTHORITY, "*/getInt", 3);
        this.njU.addURI(AUTHORITY, "*/getLong", 4);
        this.njU.addURI(AUTHORITY, "*/getFloat", 5);
        this.njU.addURI(AUTHORITY, "*/getBoolean", 6);
        this.njU.addURI(AUTHORITY, "*/contains", 7);
        this.njU.addURI(AUTHORITY, "*/apply", 8);
        this.njU.addURI(AUTHORITY, "*/commit", 9);
        this.njU.addURI(AUTHORITY, "*/registerOnSharedPreferenceChangeListener", 10);
        this.njU.addURI(AUTHORITY, "*/unregisterOnSharedPreferenceChangeListener", 11);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        boolean z = true;
        boolean z2 = false;
        String str3 = (String) uri.getPathSegments().get(0);
        int parseInt = Integer.parseInt(strArr2[0]);
        String str4 = strArr2[1];
        String str5 = strArr2[2];
        Bundle bundle = new Bundle();
        Integer num;
        Integer num2;
        switch (this.njU.match(uri)) {
            case 1:
                bundle.putSerializable("value", (HashMap) getContext().getSharedPreferences(str3, parseInt).getAll());
                break;
            case 2:
                bundle.putString("value", getContext().getSharedPreferences(str3, parseInt).getString(str4, str5));
                break;
            case 3:
                bundle.putInt("value", getContext().getSharedPreferences(str3, parseInt).getInt(str4, Integer.parseInt(str5)));
                break;
            case 4:
                bundle.putLong("value", getContext().getSharedPreferences(str3, parseInt).getLong(str4, Long.parseLong(str5)));
                break;
            case 5:
                bundle.putFloat("value", getContext().getSharedPreferences(str3, parseInt).getFloat(str4, Float.parseFloat(str5)));
                break;
            case 6:
                bundle.putBoolean("value", getContext().getSharedPreferences(str3, parseInt).getBoolean(str4, Boolean.parseBoolean(str5)));
                break;
            case 7:
                bundle.putBoolean("value", getContext().getSharedPreferences(str3, parseInt).contains(str4));
                break;
            case 10:
                btI();
                num = (Integer) this.njV.get(str3);
                parseInt = (num == null ? 0 : num.intValue()) + 1;
                this.njV.put(str3, Integer.valueOf(parseInt));
                num2 = (Integer) this.njV.get(str3);
                str4 = "value";
                if (parseInt == (num2 == null ? 0 : num2.intValue())) {
                    z2 = true;
                }
                bundle.putBoolean(str4, z2);
                break;
            case 11:
                btI();
                num = (Integer) this.njV.get(str3);
                parseInt = (num == null ? 0 : num.intValue()) - 1;
                if (parseInt > 0) {
                    this.njV.put(str3, Integer.valueOf(parseInt));
                    num2 = (Integer) this.njV.get(str3);
                    str4 = "value";
                    if (parseInt != (num2 == null ? 0 : num2.intValue())) {
                        z = false;
                    }
                    bundle.putBoolean(str4, z);
                    break;
                }
                this.njV.remove(str3);
                String str6 = "value";
                if (this.njV.containsKey(str3)) {
                    z = false;
                }
                bundle.putBoolean(str6, z);
                break;
            default:
                throw new IllegalArgumentException("This is Unknown Uri：" + uri);
        }
        return new a(bundle);
    }

    public String getType(Uri uri) {
        throw new UnsupportedOperationException("No external call");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external insert");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external delete");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int update(android.net.Uri r13, android.content.ContentValues r14, java.lang.String r15, java.lang.String[] r16) {
        /*
        r12 = this;
        r5 = 0;
        r0 = r13.getPathSegments();
        r1 = 0;
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = 0;
        r1 = r16[r1];
        r1 = java.lang.Integer.parseInt(r1);
        r2 = r12.getContext();
        r7 = r2.getSharedPreferences(r0, r1);
        r1 = r12.njU;
        r8 = r1.match(r13);
        switch(r8) {
            case 8: goto L_0x003a;
            case 9: goto L_0x003a;
            default: goto L_0x0024;
        };
    L_0x0024:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "This is Unknown Uri：";
        r1.<init>(r2);
        r1 = r1.append(r13);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x003a:
        r1 = r12.njV;
        if (r1 == 0) goto L_0x0096;
    L_0x003e:
        r1 = r12.njV;
        r1 = r1.get(r0);
        if (r1 == 0) goto L_0x0096;
    L_0x0046:
        r1 = r12.njV;
        r1 = r1.get(r0);
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        if (r1 <= 0) goto L_0x0096;
    L_0x0054:
        r1 = 1;
        r6 = r1;
    L_0x0056:
        r2 = 0;
        r1 = 0;
        if (r6 == 0) goto L_0x018c;
    L_0x005a:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r1 = r7.getAll();
        r3 = r1;
        r4 = r2;
    L_0x0065:
        r7 = r7.edit();
        r1 = 1;
        r1 = r16[r1];
        r1 = java.lang.Boolean.parseBoolean(r1);
        if (r1 == 0) goto L_0x009c;
    L_0x0072:
        if (r6 == 0) goto L_0x0099;
    L_0x0074:
        r1 = r3.isEmpty();
        if (r1 != 0) goto L_0x0099;
    L_0x007a:
        r1 = r3.entrySet();
        r2 = r1.iterator();
    L_0x0082:
        r1 = r2.hasNext();
        if (r1 == 0) goto L_0x0099;
    L_0x0088:
        r1 = r2.next();
        r1 = (java.util.Map.Entry) r1;
        r1 = r1.getKey();
        r4.add(r1);
        goto L_0x0082;
    L_0x0096:
        r1 = 0;
        r6 = r1;
        goto L_0x0056;
    L_0x0099:
        r7.clear();
    L_0x009c:
        r1 = r14.valueSet();
        r9 = r1.iterator();
    L_0x00a4:
        r1 = r9.hasNext();
        if (r1 == 0) goto L_0x0138;
    L_0x00aa:
        r1 = r9.next();
        r1 = (java.util.Map.Entry) r1;
        r2 = r1.getKey();
        r2 = (java.lang.String) r2;
        r1 = r1.getValue();
        r10 = r1 instanceof com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences.b;
        if (r10 != 0) goto L_0x00c0;
    L_0x00be:
        if (r1 != 0) goto L_0x00d8;
    L_0x00c0:
        r7.remove(r2);
        if (r6 == 0) goto L_0x00ce;
    L_0x00c5:
        r10 = r3.containsKey(r2);
        if (r10 == 0) goto L_0x00ce;
    L_0x00cb:
        r4.add(r2);
    L_0x00ce:
        r10 = r1 instanceof java.lang.String;
        if (r10 == 0) goto L_0x00f4;
    L_0x00d2:
        r1 = (java.lang.String) r1;
        r7.putString(r2, r1);
        goto L_0x00a4;
    L_0x00d8:
        if (r6 == 0) goto L_0x00ce;
    L_0x00da:
        r10 = r3.containsKey(r2);
        if (r10 == 0) goto L_0x00f0;
    L_0x00e0:
        r10 = r3.containsKey(r2);
        if (r10 == 0) goto L_0x00ce;
    L_0x00e6:
        r10 = r3.get(r2);
        r10 = r1.equals(r10);
        if (r10 != 0) goto L_0x00ce;
    L_0x00f0:
        r4.add(r2);
        goto L_0x00ce;
    L_0x00f4:
        r10 = r1 instanceof java.util.Set;
        if (r10 == 0) goto L_0x00fe;
    L_0x00f8:
        r1 = (java.util.Set) r1;
        com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences.c.a(r7, r2, r1);
        goto L_0x00a4;
    L_0x00fe:
        r10 = r1 instanceof java.lang.Integer;
        if (r10 == 0) goto L_0x010c;
    L_0x0102:
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r7.putInt(r2, r1);
        goto L_0x00a4;
    L_0x010c:
        r10 = r1 instanceof java.lang.Long;
        if (r10 == 0) goto L_0x011a;
    L_0x0110:
        r1 = (java.lang.Long) r1;
        r10 = r1.longValue();
        r7.putLong(r2, r10);
        goto L_0x00a4;
    L_0x011a:
        r10 = r1 instanceof java.lang.Float;
        if (r10 == 0) goto L_0x0129;
    L_0x011e:
        r1 = (java.lang.Float) r1;
        r1 = r1.floatValue();
        r7.putFloat(r2, r1);
        goto L_0x00a4;
    L_0x0129:
        r10 = r1 instanceof java.lang.Boolean;
        if (r10 == 0) goto L_0x00a4;
    L_0x012d:
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        r7.putBoolean(r2, r1);
        goto L_0x00a4;
    L_0x0138:
        if (r6 == 0) goto L_0x0145;
    L_0x013a:
        r1 = r4.isEmpty();
        if (r1 == 0) goto L_0x0145;
    L_0x0140:
        r0 = 1;
    L_0x0141:
        r14.clear();
        return r0;
    L_0x0145:
        switch(r8) {
            case 8: goto L_0x014a;
            case 9: goto L_0x0180;
            default: goto L_0x0148;
        };
    L_0x0148:
        r0 = r5;
        goto L_0x0141;
    L_0x014a:
        r1 = r7.getClass();	 Catch:{ IllegalArgumentException -> 0x0164, IllegalAccessException -> 0x016b, InvocationTargetException -> 0x0172, NoSuchMethodException -> 0x0179 }
        r2 = "apply";
        r3 = 0;
        r3 = new java.lang.Class[r3];	 Catch:{ IllegalArgumentException -> 0x0164, IllegalAccessException -> 0x016b, InvocationTargetException -> 0x0172, NoSuchMethodException -> 0x0179 }
        r1 = r1.getDeclaredMethod(r2, r3);	 Catch:{ IllegalArgumentException -> 0x0164, IllegalAccessException -> 0x016b, InvocationTargetException -> 0x0172, NoSuchMethodException -> 0x0179 }
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ IllegalArgumentException -> 0x0164, IllegalAccessException -> 0x016b, InvocationTargetException -> 0x0172, NoSuchMethodException -> 0x0179 }
        r1.invoke(r7, r2);	 Catch:{ IllegalArgumentException -> 0x0164, IllegalAccessException -> 0x016b, InvocationTargetException -> 0x0172, NoSuchMethodException -> 0x0179 }
        r1 = 1;
        r12.g(r0, r4);
        r0 = r1;
        goto L_0x0141;
    L_0x0164:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r1.<init>(r0);
        throw r1;
    L_0x016b:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r1.<init>(r0);
        throw r1;
    L_0x0172:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r1.<init>(r0);
        throw r1;
    L_0x0179:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r1.<init>(r0);
        throw r1;
    L_0x0180:
        r1 = r7.commit();
        if (r1 == 0) goto L_0x0148;
    L_0x0186:
        r1 = 1;
        r12.g(r0, r4);
        r0 = r1;
        goto L_0x0141;
    L_0x018c:
        r3 = r1;
        r4 = r2;
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    public void onLowMemory() {
        if (this.njV != null) {
            this.njV.clear();
        }
        super.onLowMemory();
    }

    public void onTrimMemory(int i) {
        if (this.njV != null) {
            this.njV.clear();
        }
        super.onTrimMemory(i);
    }

    private void btI() {
        if (this.njV == null) {
            this.njV = new HashMap();
        }
    }

    private void g(String str, ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Intent intent = new Intent();
            intent.setAction(Ko(str));
            intent.setPackage(getContext().getPackageName());
            intent.putExtra("name", str);
            intent.putExtra("value", arrayList);
            getContext().sendBroadcast(intent);
        }
    }
}
