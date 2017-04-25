package com.tencent.mm.at;

import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bea;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class g {
    String dkD;
    LinkedHashMap<String, a> dkE = new LinkedHashMap();
    final ReadWriteLock dkF = new ReentrantReadWriteLock();
    private StringBuilder dkG = new StringBuilder();

    public class a {
        public String data;
        public String dkH;
        public boolean dkI;
        public boolean dkJ;
        public int dkK;
        public int dkL;
        public int dkM;
        public boolean dkN;
        final /* synthetic */ g dkO;

        public a(g gVar) {
            this.dkO = gVar;
            long nextInt = 4294967295L & ((long) new Random(System.currentTimeMillis()).nextInt());
            long currentTimeMillis = ((4294967295L & System.currentTimeMillis()) << 32) | nextInt;
            if (currentTimeMillis < 0) {
                currentTimeMillis = Math.abs(currentTimeMillis);
            }
            v.d("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", Long.valueOf(nextInt), Long.toBinaryString(nextInt), Long.valueOf(r2), Long.toBinaryString(r2), Long.valueOf(currentTimeMillis), Long.toBinaryString(currentTimeMillis), this.dkO.dkD, this.dkO.dkD + String.valueOf(currentTimeMillis));
            this.dkH = r6;
            this.dkI = false;
            this.dkJ = false;
            this.dkK = Integer.MAX_VALUE;
            this.dkL = 0;
            this.dkM = -1;
            this.data = null;
            this.dkN = false;
        }
    }

    public g(String str) {
        this.dkD = str;
    }

    public final LinkedList<arf> LS() {
        LinkedList<arf> linkedList = new LinkedList();
        this.dkF.readLock().lock();
        for (a aVar : this.dkE.values()) {
            if (aVar.dkI) {
                linkedList.add(new arf().JF(aVar.dkH));
            }
        }
        this.dkF.readLock().unlock();
        return linkedList;
    }

    public final String LT() {
        this.dkG.setLength(0);
        this.dkF.readLock().lock();
        for (a aVar : this.dkE.values()) {
            if (aVar.data != null) {
                this.dkG.append(aVar.data);
            }
        }
        this.dkF.readLock().unlock();
        return this.dkG.toString();
    }

    public final boolean LU() {
        if (this.dkE.size() == 0) {
            v.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
            return false;
        }
        boolean z;
        this.dkF.readLock().lock();
        for (a aVar : this.dkE.values()) {
            v.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", aVar.dkH, Boolean.valueOf(aVar.dkJ), Boolean.valueOf(aVar.dkN));
            if (!((a) r3.next()).dkN) {
                z = false;
                break;
            }
        }
        z = true;
        this.dkF.readLock().unlock();
        return z;
    }

    public final void Q(List<bea> list) {
        String str;
        String str2 = "MicroMsg.ShortSentenceContainer";
        String str3 = "updateVoiceInfoResult respVTList size %s innerContainer %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
        this.dkF.readLock().lock();
        if (this.dkE.size() == 0) {
            this.dkF.readLock().unlock();
            str = "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (a aVar : this.dkE.values()) {
                stringBuilder.append(aVar.dkH).append(", ");
            }
            if (stringBuilder.length() <= 3) {
                this.dkF.readLock().unlock();
                str = stringBuilder.append("]").toString();
            } else {
                stringBuilder.setLength(stringBuilder.length() - 2);
                this.dkF.readLock().unlock();
                str = stringBuilder.append("]").toString();
            }
        }
        objArr[1] = str;
        v.d(str2, str3, objArr);
        if (list == null || list.size() == 0) {
            v.i("MicroMsg.ShortSentenceContainer", "respList == null");
            return;
        }
        this.dkF.readLock().lock();
        for (bea com_tencent_mm_protocal_c_bea : list) {
            if (com_tencent_mm_protocal_c_bea == null) {
                v.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
            } else {
                a aVar2 = (a) this.dkE.get(com_tencent_mm_protocal_c_bea.mne);
                if (aVar2 == null) {
                    v.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", com_tencent_mm_protocal_c_bea.mne);
                } else if (com_tencent_mm_protocal_c_bea == null) {
                    v.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
                } else {
                    String str4 = "MicroMsg.ShortSentenceContainer";
                    String str5 = "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s";
                    Object[] objArr2 = new Object[12];
                    objArr2[0] = com_tencent_mm_protocal_c_bea.mne;
                    objArr2[1] = Integer.valueOf(com_tencent_mm_protocal_c_bea.mZJ);
                    Integer valueOf = (com_tencent_mm_protocal_c_bea.mXM == null || com_tencent_mm_protocal_c_bea.mXM.mQw == null) ? null : Integer.valueOf(com_tencent_mm_protocal_c_bea.mXM.mQu);
                    objArr2[2] = valueOf;
                    objArr2[3] = Boolean.valueOf(com_tencent_mm_protocal_c_bea.mfh != 0);
                    objArr2[4] = Integer.valueOf(com_tencent_mm_protocal_c_bea.mfh);
                    objArr2[5] = aVar2.dkH;
                    objArr2[6] = Boolean.valueOf(aVar2.dkI);
                    objArr2[7] = Boolean.valueOf(aVar2.dkJ);
                    objArr2[8] = Integer.valueOf(aVar2.dkK);
                    objArr2[9] = Integer.valueOf(aVar2.dkM);
                    objArr2[10] = aVar2.data == null ? null : Integer.valueOf(aVar2.data.length());
                    objArr2[11] = Boolean.valueOf(aVar2.dkN);
                    v.d(str4, str5, objArr2);
                    if (com_tencent_mm_protocal_c_bea.mZJ < aVar2.dkM || aVar2.dkN) {
                        v.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
                    } else {
                        aVar2.dkM = com_tencent_mm_protocal_c_bea.mZJ;
                        str3 = (com_tencent_mm_protocal_c_bea.mXM == null || com_tencent_mm_protocal_c_bea.mXM.mQw == null) ? null : com_tencent_mm_protocal_c_bea.mXM.mQw.brp();
                        aVar2.data = str3;
                        aVar2.dkN = com_tencent_mm_protocal_c_bea.mfh != 0;
                        str3 = "MicroMsg.ShortSentenceContainer";
                        str4 = "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s";
                        Object[] objArr3 = new Object[4];
                        objArr3[0] = com_tencent_mm_protocal_c_bea.mne;
                        objArr3[1] = Integer.valueOf(aVar2.dkM);
                        objArr3[2] = Boolean.valueOf(aVar2.dkN);
                        objArr3[3] = Integer.valueOf(aVar2.data == null ? -1 : aVar2.data.length());
                        v.i(str3, str4, objArr3);
                        if (com_tencent_mm_protocal_c_bea.mfh == 2) {
                            v.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", com_tencent_mm_protocal_c_bea.mne);
                        }
                    }
                }
            }
        }
        this.dkF.readLock().unlock();
    }

    public final void gy(int i) {
        v.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", Integer.valueOf(i));
        if (i < 0) {
            throw new IllegalStateException("splitShortSentence file mark less than zero. mark: " + i);
        }
        this.dkF.readLock().lock();
        if (this.dkE.size() == 0) {
            v.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
            return;
        }
        a aVar = null;
        for (a aVar2 : this.dkE.values()) {
        }
        if (aVar == null) {
            throw new IllegalStateException("splitShortSentence last info is null");
        }
        v.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", Integer.valueOf(aVar.dkK), aVar.dkH, Integer.valueOf(i));
        aVar.dkK = i;
        this.dkF.readLock().unlock();
    }

    public final a gz(int i) {
        if (this.dkE.size() == 0) {
            return null;
        }
        this.dkF.readLock().lock();
        for (a aVar : this.dkE.values()) {
            v.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", Integer.valueOf(i), Integer.valueOf(aVar.dkK), Boolean.valueOf(aVar.dkJ));
            if (!aVar.dkJ && i <= aVar.dkK) {
                break;
            }
        }
        a aVar2 = null;
        this.dkF.readLock().unlock();
        return aVar2;
    }
}
