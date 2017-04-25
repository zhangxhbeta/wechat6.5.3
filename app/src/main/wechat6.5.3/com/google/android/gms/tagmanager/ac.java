package com.google.android.gms.tagmanager;

import com.google.android.gms.c.at;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ac {
    private static final v<com.google.android.gms.c.b.a> aCG = new v(ai.mm(), true);
    private final f aCH;
    private final Map<String, g> aCI;
    private final Map<String, g> aCJ;
    private final Map<String, g> aCK;
    private final al<com.google.android.gms.c.at.a, v<com.google.android.gms.c.b.a>> aCL;
    private final al<String, b> aCM;
    private final Set<com.google.android.gms.c.at.b> aCN;
    private final Map<String, c> aCO;
    private volatile String aCP;
    private int aCQ;
    private final c aCk;

    interface a {
        void a(com.google.android.gms.c.at.b bVar, Set<com.google.android.gms.c.at.a> set, Set<com.google.android.gms.c.at.a> set2, aa aaVar);
    }

    private static class b {
        v<com.google.android.gms.c.b.a> aCW;
        com.google.android.gms.c.b.a azY;

        public b(v<com.google.android.gms.c.b.a> vVar, com.google.android.gms.c.b.a aVar) {
            this.aCW = vVar;
            this.azY = aVar;
        }
    }

    private static class c {
        final Set<com.google.android.gms.c.at.b> aCN = new HashSet();
        final Map<com.google.android.gms.c.at.b, List<com.google.android.gms.c.at.a>> aCX = new HashMap();
        final Map<com.google.android.gms.c.at.b, List<com.google.android.gms.c.at.a>> aCY = new HashMap();
        final Map<com.google.android.gms.c.at.b, List<String>> aCZ = new HashMap();
        final Map<com.google.android.gms.c.at.b, List<String>> aDa = new HashMap();
        com.google.android.gms.c.at.a aDb;
    }

    private v<Boolean> a(com.google.android.gms.c.at.a aVar, Set<String> set, x xVar) {
        v a = a(this.aCJ, aVar, (Set) set, xVar);
        Boolean c = ai.c((com.google.android.gms.c.b.a) a.aCw);
        ai.ag(c);
        return new v(c, a.aCx);
    }

    private v<Boolean> a(com.google.android.gms.c.at.b bVar, Set<String> set, aa aaVar) {
        boolean z = true;
        for (com.google.android.gms.c.at.a a : bVar.aAa) {
            v a2 = a(a, (Set) set, aaVar.lU());
            if (((Boolean) a2.aCw).booleanValue()) {
                ai.ag(Boolean.valueOf(false));
                return new v(Boolean.valueOf(false), a2.aCx);
            }
            boolean z2 = z && a2.aCx;
            z = z2;
        }
        for (com.google.android.gms.c.at.a a3 : bVar.azZ) {
            a2 = a(a3, (Set) set, aaVar.lV());
            if (((Boolean) a2.aCw).booleanValue()) {
                z = z && a2.aCx;
            } else {
                ai.ag(Boolean.valueOf(false));
                return new v(Boolean.valueOf(false), a2.aCx);
            }
        }
        ai.ag(Boolean.valueOf(true));
        return new v(Boolean.valueOf(true), z);
    }

    private v<com.google.android.gms.c.b.a> a(com.google.android.gms.c.b.a aVar, Set<String> set, aj ajVar) {
        if (!aVar.awW) {
            return new v(aVar, true);
        }
        com.google.android.gms.c.b.a a;
        int i;
        v a2;
        switch (aVar.type) {
            case 2:
                a = at.a(aVar);
                a.awN = new com.google.android.gms.c.b.a[aVar.awN.length];
                for (i = 0; i < aVar.awN.length; i++) {
                    a2 = a(aVar.awN[i], (Set) set, ajVar.mb());
                    if (a2 == aCG) {
                        return aCG;
                    }
                    a.awN[i] = (com.google.android.gms.c.b.a) a2.aCw;
                }
                return new v(a, false);
            case 3:
                a = at.a(aVar);
                if (aVar.awO.length != aVar.awP.length) {
                    new StringBuilder("Invalid serving value: ").append(aVar.toString());
                    m.lL();
                    return aCG;
                }
                a.awO = new com.google.android.gms.c.b.a[aVar.awO.length];
                a.awP = new com.google.android.gms.c.b.a[aVar.awO.length];
                for (i = 0; i < aVar.awO.length; i++) {
                    a2 = a(aVar.awO[i], (Set) set, ajVar.mc());
                    v a3 = a(aVar.awP[i], (Set) set, ajVar.md());
                    if (a2 == aCG || a3 == aCG) {
                        return aCG;
                    }
                    a.awO[i] = (com.google.android.gms.c.b.a) a2.aCw;
                    a.awP[i] = (com.google.android.gms.c.b.a) a3.aCw;
                }
                return new v(a, false);
            case 4:
                if (set.contains(aVar.awQ)) {
                    new StringBuilder("Macro cycle detected.  Current macro reference: ").append(aVar.awQ).append(".  Previous macro references: ").append(set.toString()).append(".");
                    m.lL();
                    return aCG;
                }
                set.add(aVar.awQ);
                v<com.google.android.gms.c.b.a> a4 = ak.a(a(aVar.awQ, (Set) set, ajVar.mf()), aVar.awV);
                set.remove(aVar.awQ);
                return a4;
            case 7:
                a = at.a(aVar);
                a.awU = new com.google.android.gms.c.b.a[aVar.awU.length];
                for (i = 0; i < aVar.awU.length; i++) {
                    a2 = a(aVar.awU[i], (Set) set, ajVar.me());
                    if (a2 == aCG) {
                        return aCG;
                    }
                    a.awU[i] = (com.google.android.gms.c.b.a) a2.aCw;
                }
                return new v(a, false);
            default:
                new StringBuilder("Unknown type: ").append(aVar.type);
                m.lL();
                return aCG;
        }
    }

    private v<com.google.android.gms.c.b.a> a(String str, Set<String> set, o oVar) {
        this.aCQ++;
        b bVar = (b) this.aCM.mn();
        if (bVar == null || this.aCH.lI()) {
            c cVar = (c) this.aCO.get(str);
            if (cVar == null) {
                new StringBuilder().append(mi()).append("Invalid macro: ").append(str);
                m.lL();
                this.aCQ--;
                return aCG;
            }
            com.google.android.gms.c.at.a aVar;
            v a = a(cVar.aCN, cVar.aCX, cVar.aCZ, cVar.aCY, cVar.aDa, set, oVar.lR());
            if (((Set) a.aCw).isEmpty()) {
                aVar = cVar.aDb;
            } else {
                if (((Set) a.aCw).size() > 1) {
                    new StringBuilder().append(mi()).append("Multiple macros active for macroName ").append(str);
                    m.lN();
                }
                aVar = (com.google.android.gms.c.at.a) ((Set) a.aCw).iterator().next();
            }
            if (aVar == null) {
                this.aCQ--;
                return aCG;
            }
            v a2 = a(this.aCK, aVar, (Set) set, oVar.lQ());
            boolean z = a.aCx && a2.aCx;
            v<com.google.android.gms.c.b.a> vVar = a2 == aCG ? aCG : new v(a2.aCw, z);
            com.google.android.gms.c.b.a aVar2 = aVar.azY;
            if (vVar.aCx) {
                b bVar2 = new b(vVar, aVar2);
            }
            a(aVar2, set);
            this.aCQ--;
            return vVar;
        }
        a(bVar.azY, set);
        this.aCQ--;
        return bVar.aCW;
    }

    private v<com.google.android.gms.c.b.a> a(Map<String, g> map, com.google.android.gms.c.at.a aVar, Set<String> set, x xVar) {
        com.google.android.gms.c.b.a aVar2 = (com.google.android.gms.c.b.a) Collections.unmodifiableMap(aVar.azX).get(com.google.android.gms.c.a.FUNCTION.toString());
        if (aVar2 == null) {
            m.lL();
            return aCG;
        }
        String str = aVar2.awR;
        g gVar = (g) map.get(str);
        if (gVar == null) {
            new StringBuilder().append(str).append(" has no backing implementation.");
            m.lL();
            return aCG;
        }
        v<com.google.android.gms.c.b.a> vVar = (v) this.aCL.mn();
        if (vVar != null && !this.aCH.lI()) {
            return vVar;
        }
        Map hashMap = new HashMap();
        Object obj = 1;
        for (Entry entry : Collections.unmodifiableMap(aVar.azX).entrySet()) {
            entry.getKey();
            z lS = xVar.lS();
            com.google.android.gms.c.b.a aVar3 = (com.google.android.gms.c.b.a) entry.getValue();
            entry.getValue();
            v a = a(aVar3, (Set) set, lS.lT());
            if (a == aCG) {
                return aCG;
            }
            Object obj2;
            if (a.aCx) {
                aVar.azX.put((String) entry.getKey(), (com.google.android.gms.c.b.a) a.aCw);
                obj2 = obj;
            } else {
                obj2 = null;
            }
            hashMap.put(entry.getKey(), a.aCw);
            obj = obj2;
        }
        if (hashMap.keySet().containsAll(gVar.aCr)) {
            boolean z = obj != null && gVar.lJ();
            return new v(gVar.lK(), z);
        }
        new StringBuilder("Incorrect keys for function ").append(str).append(" required ").append(gVar.aCr).append(" had ").append(hashMap.keySet());
        m.lL();
        return aCG;
    }

    private v<Set<com.google.android.gms.c.at.a>> a(Set<com.google.android.gms.c.at.b> set, Map<com.google.android.gms.c.at.b, List<com.google.android.gms.c.at.a>> map, Map<com.google.android.gms.c.at.b, List<String>> map2, Map<com.google.android.gms.c.at.b, List<com.google.android.gms.c.at.a>> map3, Map<com.google.android.gms.c.at.b, List<String>> map4, Set<String> set2, ab abVar) {
        final Map<com.google.android.gms.c.at.b, List<com.google.android.gms.c.at.a>> map5 = map;
        final Map<com.google.android.gms.c.at.b, List<String>> map6 = map2;
        final Map<com.google.android.gms.c.at.b, List<com.google.android.gms.c.at.a>> map7 = map3;
        final Map<com.google.android.gms.c.at.b, List<String>> map8 = map4;
        return a((Set) set, (Set) set2, new a(this) {
            final /* synthetic */ ac aCV;

            public final void a(com.google.android.gms.c.at.b bVar, Set<com.google.android.gms.c.at.a> set, Set<com.google.android.gms.c.at.a> set2, aa aaVar) {
                List list = (List) map5.get(bVar);
                map6.get(bVar);
                if (list != null) {
                    set.addAll(list);
                    aaVar.lW();
                }
                list = (List) map7.get(bVar);
                map8.get(bVar);
                if (list != null) {
                    set2.addAll(list);
                    aaVar.lX();
                }
            }
        }, abVar);
    }

    private v<Set<com.google.android.gms.c.at.a>> a(Set<com.google.android.gms.c.at.b> set, Set<String> set2, a aVar, ab abVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (com.google.android.gms.c.at.b bVar : set) {
            aa ma = abVar.ma();
            v a = a(bVar, (Set) set2, ma);
            if (((Boolean) a.aCw).booleanValue()) {
                aVar.a(bVar, hashSet, hashSet2, ma);
            }
            boolean z2 = z && a.aCx;
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        return new v(hashSet, z);
    }

    private void a(com.google.android.gms.c.b.a aVar, Set<String> set) {
        if (aVar != null) {
            v a = a(aVar, (Set) set, new u());
            if (a != aCG) {
                Object d = ai.d((com.google.android.gms.c.b.a) a.aCw);
                if (d instanceof Map) {
                    this.aCk.d((Map) d);
                } else if (d instanceof List) {
                    for (Object d2 : (List) d2) {
                        if (d2 instanceof Map) {
                            this.aCk.d((Map) d2);
                        } else {
                            m.lN();
                        }
                    }
                } else {
                    m.lN();
                }
            }
        }
    }

    private synchronized void ap(String str) {
        this.aCP = str;
    }

    private String mi() {
        if (this.aCQ <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.aCQ));
        for (int i = 2; i < this.aCQ; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    public final synchronized void ao(String str) {
        ap(str);
        ao lG = this.aCH.lH().lG();
        for (com.google.android.gms.c.at.a a : (Set) a(this.aCN, new HashSet(), new a(this) {
            final /* synthetic */ ac aCV;

            {
                this.aCV = r1;
            }

            public final void a(com.google.android.gms.c.at.b bVar, Set<com.google.android.gms.c.at.a> set, Set<com.google.android.gms.c.at.a> set2, aa aaVar) {
                set.addAll(bVar.aAb);
                set2.addAll(bVar.aAc);
                aaVar.lY();
                aaVar.lZ();
            }
        }, lG.lR()).aCw) {
            a(this.aCI, a, new HashSet(), lG.mr());
        }
        ap(null);
    }
}
