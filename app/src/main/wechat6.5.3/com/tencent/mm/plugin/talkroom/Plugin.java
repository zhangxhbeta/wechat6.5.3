package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.e.a.hr;
import com.tencent.mm.e.a.pc;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.e.a.pf;
import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.v;

public class Plugin implements com.tencent.mm.pluginsdk.c.c {

    private class a extends com.tencent.mm.sdk.c.c<pc> {
        final /* synthetic */ Plugin kjq;

        private a(Plugin plugin) {
            this.kjq = plugin;
            this.nhz = pc.class.getName().hashCode();
        }

        /* synthetic */ a(Plugin plugin, byte b) {
            this(plugin);
            this.nhz = pc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            pc pcVar = (pc) bVar;
            if (!(pcVar instanceof pc)) {
                v.f("MicroMsg.TalkRoomReportMgrListener", "mismatch %s", new Object[]{pcVar.getClass().getName()});
            } else if (pcVar.bqr.bqs) {
                com.tencent.mm.plugin.talkroom.model.b.aZZ().kkx = 1;
                return true;
            }
            return false;
        }
    }

    private static class b extends com.tencent.mm.sdk.c.c<pd> {
        private b() {
            this.nhz = pd.class.getName().hashCode();
        }

        /* synthetic */ b(byte b) {
            this();
            this.nhz = pd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            pd pdVar = (pd) bVar;
            if (pdVar != null) {
                if (!(pdVar instanceof pd)) {
                    v.f("MicroMsg.TalkRoomServerListener", "mismatch %s", new Object[]{pdVar.getClass().getName()});
                } else if (pdVar.bqt.bqw) {
                    com.tencent.mm.plugin.talkroom.model.b.aZW().awO();
                    return true;
                } else if (!(!pdVar.bqt.bqv || pdVar.bqu == null || com.tencent.mm.plugin.talkroom.model.b.aZW() == null)) {
                    pdVar.bqu.bqx = com.tencent.mm.plugin.talkroom.model.b.aZW().kkT;
                    return true;
                }
            }
            return false;
        }
    }

    private class c extends com.tencent.mm.sdk.c.c<pf> {
        final /* synthetic */ Plugin kjq;

        private c(Plugin plugin) {
            this.kjq = plugin;
            this.nhz = pf.class.getName().hashCode();
        }

        /* synthetic */ c(Plugin plugin, byte b) {
            this(plugin);
            this.nhz = pf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (!(((pf) bVar) instanceof pf)) {
                v.f("MicroMsg.TalkRoom.Plugin", "mismatch %s", new Object[]{((pf) bVar).getClass().getName()});
            }
            return false;
        }
    }

    public Plugin() {
        com.tencent.mm.sdk.c.a.nhr.e(new com.tencent.mm.sdk.c.c<hr>(this) {
            final /* synthetic */ Plugin kjq;

            {
                this.kjq = r2;
                this.nhz = hr.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                switch (((hr) bVar).bhA.status) {
                    case 0:
                        if (com.tencent.mm.plugin.talkroom.model.b.aZW() != null) {
                            com.tencent.mm.plugin.talkroom.model.b.aZW().awO();
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        com.tencent.mm.sdk.c.a.nhr.e(new b());
        com.tencent.mm.sdk.c.a.nhr.e(new a());
        com.tencent.mm.sdk.c.a.nhr.e(new c());
    }

    public i createApplication() {
        return new a();
    }

    public com.tencent.mm.pluginsdk.c.b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        return new com.tencent.mm.plugin.talkroom.model.b();
    }
}
