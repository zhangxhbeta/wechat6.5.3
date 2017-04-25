package com.tencent.mm.plugin.brandservice.a;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d implements e {
    public LinkedList<a> exl = new LinkedList();
    public boolean exm = false;
    public List<b> exn = new LinkedList();
    public List<b> exo = new LinkedList();

    public interface a {
        void Yj();
    }

    public d() {
        ak.vy().a(387, this);
        ak.vy().a(new f(), 0);
    }

    public final void init() {
        long currentTimeMillis = System.currentTimeMillis();
        this.exn.clear();
        this.exo.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select bizinfo.brandIconURL");
        stringBuilder.append(", bizinfo.type");
        stringBuilder.append(", bizinfo.status");
        stringBuilder.append(", rcontact.username");
        stringBuilder.append(", rcontact.conRemark");
        stringBuilder.append(", rcontact.nickname");
        stringBuilder.append(", rcontact.alias");
        stringBuilder.append(", rcontact.conRemarkPYFull");
        stringBuilder.append(", rcontact.conRemarkPYShort");
        stringBuilder.append(", rcontact.showHead");
        stringBuilder.append(", rcontact.pyInitial");
        stringBuilder.append(", rcontact.quanPin");
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where rcontact.username").append(" = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag").append(" & ").append(u.bvo()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type").append(" & 1) != 0 ");
        stringBuilder.append(" order by showHead asc, ");
        stringBuilder.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" upper(quanPin) asc, ");
        stringBuilder.append(" upper(nickname) asc");
        v.d("MicroMsg.BrandService.BrandServiceMgr", "sql %s", new Object[]{stringBuilder.toString()});
        ak.yW();
        Cursor rawQuery = c.wE().rawQuery(r0, null);
        Map hashMap = new HashMap();
        if (rawQuery != null) {
            if (rawQuery.getCount() > 0) {
                rawQuery.moveToFirst();
                while (!rawQuery.isAfterLast()) {
                    u uVar = new u();
                    uVar.b(rawQuery);
                    BizInfo bizInfo = new BizInfo();
                    bizInfo.b(rawQuery);
                    if (!uVar.field_username.equals("gh_43f2581f6fd6")) {
                        b bVar = new b();
                        bVar.userName = uVar.field_username;
                        bVar.euW = uVar;
                        bVar.exj = bizInfo;
                        if (!m.eP(bVar.userName)) {
                            hashMap.put(bVar.userName, bVar);
                            if (bVar.exj.field_type != 3) {
                                if (bVar.exj.field_type == 2) {
                                    this.exn.add(bVar);
                                } else if (bVar.exj.field_type == 1 || bVar.exj.field_type == 0) {
                                    this.exo.add(bVar);
                                }
                            }
                        }
                    }
                    rawQuery.moveToNext();
                }
            }
            v.d("MicroMsg.BrandService.BrandServiceMgr", "biz contact count %d", new Object[]{Integer.valueOf(r4)});
            rawQuery.close();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        stringBuilder = new StringBuilder();
        stringBuilder.append("select username");
        stringBuilder.append(" from rcontact");
        stringBuilder.append(" where (verifyFlag & ").append(u.bvo()).append(") != 0 ");
        stringBuilder.append(" and (type & 1").append(") != 0 ");
        v.d("MicroMsg.BrandService.BrandServiceMgr", "sql check %s", new Object[]{stringBuilder.toString()});
        ak.yW();
        rawQuery = c.wE().rawQuery(r0, null);
        if (rawQuery != null) {
            LinkedList linkedList = new LinkedList();
            rawQuery.moveToFirst();
            while (!rawQuery.isAfterLast()) {
                String string = rawQuery.getString(0);
                if (!hashMap.containsKey(string)) {
                    linkedList.add(string);
                }
                rawQuery.moveToNext();
            }
            rawQuery.close();
            v.i("MicroMsg.BrandService.BrandServiceMgr", "need update list size is %d, {%s}", new Object[]{Integer.valueOf(linkedList.size()), linkedList});
            if (!linkedList.isEmpty()) {
                ak.yW();
                long er = c.wE().er(Thread.currentThread().getId());
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.model.ab.a.crZ.I((String) it.next(), "");
                }
                ak.yW();
                c.wE().es(er);
            }
        }
        v.d("MicroMsg.BrandService.BrandServiceMgr", "check use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        v.d("MicroMsg.BrandService.BrandServiceMgr", "service add subscribe count:%d, enterpriseFather count:%d", new Object[]{Integer.valueOf(this.exo.size()), Integer.valueOf(this.exn.size())});
        v.d("MicroMsg.BrandService.BrandServiceMgr", "init time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        v.w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0 && kVar.getType() == 387) {
            LinkedList linkedList = ((f) kVar).exp;
            if (linkedList == null) {
                v.e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
            } else if (this.exn == null || this.exo == null) {
                v.e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
            } else {
                int i4;
                if (linkedList.size() != this.exn.size() + this.exo.size()) {
                    i4 = 1;
                } else {
                    for (b bVar : this.exn) {
                        if (bVar != null) {
                            if (!linkedList.contains(bVar.userName)) {
                            }
                        }
                        i3 = 1;
                    }
                    if (i3 == 0) {
                        for (b bVar2 : this.exo) {
                            if (bVar2 != null) {
                                if (!linkedList.contains(bVar2.userName)) {
                                }
                            }
                            i4 = 1;
                        }
                    }
                    i4 = i3;
                }
                if (i4 != 0) {
                    init();
                    Iterator it = this.exl.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).Yj();
                    }
                }
            }
        }
    }
}
