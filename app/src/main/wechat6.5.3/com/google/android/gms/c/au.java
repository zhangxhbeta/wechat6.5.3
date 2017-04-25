package com.google.android.gms.c;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class au {

    public static class a {
        public final av aAf;
        public final List<Asset> aAg;

        public a(av avVar, List<Asset> list) {
            this.aAf = avVar;
            this.aAg = list;
        }
    }

    private static int a(String str, com.google.android.gms.c.av.a.a[] aVarArr) {
        int i = 14;
        for (com.google.android.gms.c.av.a.a aVar : aVarArr) {
            if (i == 14) {
                if (aVar.type == 9 || aVar.type == 2 || aVar.type == 6) {
                    i = aVar.type;
                } else if (aVar.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + aVar.type + " for key " + str);
                }
            } else if (aVar.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + aVar.type);
            }
        }
        return i;
    }

    private static com.google.android.gms.c.av.a.a a(List<Asset> list, Object obj) {
        com.google.android.gms.c.av.a.a aVar = new com.google.android.gms.c.av.a.a();
        if (obj == null) {
            aVar.type = 14;
            return aVar;
        }
        aVar.aAl = new com.google.android.gms.c.av.a.a.a();
        if (obj instanceof String) {
            aVar.type = 2;
            aVar.aAl.aAn = (String) obj;
        } else if (obj instanceof Integer) {
            aVar.type = 6;
            aVar.aAl.aAr = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            aVar.type = 5;
            aVar.aAl.aAq = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            aVar.type = 3;
            aVar.aAl.aAo = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            aVar.type = 4;
            aVar.aAl.aAp = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            aVar.type = 8;
            aVar.aAl.aAt = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            aVar.type = 7;
            aVar.aAl.aAs = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            aVar.type = 1;
            aVar.aAl.aAm = (byte[]) obj;
        } else if (obj instanceof String[]) {
            aVar.type = 11;
            aVar.aAl.aAw = (String[]) obj;
        } else if (obj instanceof long[]) {
            aVar.type = 12;
            aVar.aAl.aAx = (long[]) obj;
        } else if (obj instanceof float[]) {
            aVar.type = 15;
            aVar.aAl.aAy = (float[]) obj;
        } else if (obj instanceof Asset) {
            aVar.type = 13;
            com.google.android.gms.c.av.a.a.a aVar2 = aVar.aAl;
            list.add((Asset) obj);
            aVar2.aAz = (long) (list.size() - 1);
        } else if (obj instanceof h) {
            aVar.type = 9;
            h hVar = (h) obj;
            TreeSet treeSet = new TreeSet(hVar.aEa.keySet());
            com.google.android.gms.c.av.a[] aVarArr = new com.google.android.gms.c.av.a[treeSet.size()];
            Iterator it = treeSet.iterator();
            r1 = 0;
            while (it.hasNext()) {
                String str = (String) it.next();
                aVarArr[r1] = new com.google.android.gms.c.av.a();
                aVarArr[r1].name = str;
                aVarArr[r1].aAj = a((List) list, hVar.get(str));
                r1++;
            }
            aVar.aAl.aAu = aVarArr;
        } else if (obj instanceof ArrayList) {
            aVar.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            com.google.android.gms.c.av.a.a[] aVarArr2 = new com.google.android.gms.c.av.a.a[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i = 0;
            int i2 = 14;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                com.google.android.gms.c.av.a.a a = a((List) list, obj3);
                if (a.type == 14 || a.type == 2 || a.type == 6 || a.type == 9) {
                    if (i2 == 14 && a.type != 14) {
                        r1 = a.type;
                    } else if (a.type != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        r1 = i2;
                    }
                    aVarArr2[i] = a;
                    i++;
                    i2 = r1;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            aVar.aAl.aAv = aVarArr2;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return aVar;
    }

    public static h a(a aVar) {
        h hVar = new h();
        for (com.google.android.gms.c.av.a aVar2 : aVar.aAf.aAh) {
            a(aVar.aAg, hVar, aVar2.name, aVar2.aAj);
        }
        return hVar;
    }

    private static ArrayList a(List<Asset> list, com.google.android.gms.c.av.a.a.a aVar, int i) {
        ArrayList arrayList = new ArrayList(aVar.aAv.length);
        for (com.google.android.gms.c.av.a.a aVar2 : aVar.aAv) {
            if (aVar2.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                h hVar = new h();
                for (com.google.android.gms.c.av.a aVar3 : aVar2.aAl.aAu) {
                    a(list, hVar, aVar3.name, aVar3.aAj);
                }
                arrayList.add(hVar);
            } else if (i == 2) {
                arrayList.add(aVar2.aAl.aAn);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(aVar2.aAl.aAr));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void a(List<Asset> list, h hVar, String str, com.google.android.gms.c.av.a.a aVar) {
        int i = aVar.type;
        if (i == 14) {
            hVar.putString(str, null);
            return;
        }
        com.google.android.gms.c.av.a.a.a aVar2 = aVar.aAl;
        if (i == 1) {
            hVar.aEa.put(str, aVar2.aAm);
        } else if (i == 11) {
            hVar.aEa.put(str, aVar2.aAw);
        } else if (i == 12) {
            hVar.aEa.put(str, aVar2.aAx);
        } else if (i == 15) {
            hVar.aEa.put(str, aVar2.aAy);
        } else if (i == 2) {
            hVar.putString(str, aVar2.aAn);
        } else if (i == 3) {
            hVar.aEa.put(str, Double.valueOf(aVar2.aAo));
        } else if (i == 4) {
            hVar.aEa.put(str, Float.valueOf(aVar2.aAp));
        } else if (i == 5) {
            hVar.putLong(str, aVar2.aAq);
        } else if (i == 6) {
            hVar.aEa.put(str, Integer.valueOf(aVar2.aAr));
        } else if (i == 7) {
            hVar.aEa.put(str, Byte.valueOf((byte) aVar2.aAs));
        } else if (i == 8) {
            hVar.aEa.put(str, Boolean.valueOf(aVar2.aAt));
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            hVar.a(str, (Asset) list.get((int) aVar2.aAz));
        } else if (i == 9) {
            h hVar2 = new h();
            for (com.google.android.gms.c.av.a aVar3 : aVar2.aAu) {
                a(list, hVar2, aVar3.name, aVar3.aAj);
            }
            hVar.aEa.put(str, hVar2);
        } else if (i == 10) {
            i = a(str, aVar2.aAv);
            ArrayList a = a(list, aVar2, i);
            if (i == 14) {
                hVar.putStringArrayList(str, a);
            } else if (i == 9) {
                hVar.aEa.put(str, a);
            } else if (i == 2) {
                hVar.putStringArrayList(str, a);
            } else if (i == 6) {
                hVar.aEa.put(str, a);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    public static com.google.android.gms.c.av.a[] a(h hVar, List<Asset> list) {
        TreeSet treeSet = new TreeSet(hVar.aEa.keySet());
        com.google.android.gms.c.av.a[] aVarArr = new com.google.android.gms.c.av.a[treeSet.size()];
        Iterator it = treeSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            Object obj = hVar.get(str);
            aVarArr[i] = new com.google.android.gms.c.av.a();
            aVarArr[i].name = str;
            aVarArr[i].aAj = a((List) list, obj);
            i++;
        }
        return aVarArr;
    }
}
