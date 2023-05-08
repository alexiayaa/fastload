package io.github.bumblesoftware.fastload.abstraction.client.mc1194;

import io.github.bumblesoftware.fastload.api.abstraction.core.handler.AbstractionEntrypoint;
import io.github.bumblesoftware.fastload.api.abstraction.core.handler.MethodAbstractionApi;
import io.github.bumblesoftware.fastload.api.events.AbstractEvent;
import io.github.bumblesoftware.fastload.init.Fastload;
import io.github.bumblesoftware.fastload.util.MutableObjectHolder;

import static io.github.bumblesoftware.fastload.api.abstraction.core.versioning.VersionConstants.IS_MINECRAFT_1194;
import static io.github.bumblesoftware.fastload.api.abstraction.core.versioning.VersionConstants.IS_MINECRAFT_1200;
import static io.github.bumblesoftware.fastload.config.FLMath.ifDebugEnabled;

public class Hook1194 implements AbstractionEntrypoint {
    @Override
    public <A extends MethodAbstractionApi> void registerAbstraction(AbstractEvent<MutableObjectHolder<A>> clientAbstractionEvent) {
        clientAbstractionEvent.registerThreadUnsafe(3,
                (eventContext,event, eventArgs) -> {
                    if (IS_MINECRAFT_1194 || IS_MINECRAFT_1200) {
                        ifDebugEnabled(() ->
                            Fastload.LOGGER.info("Fastload 1.19.4 Hook!"));
                        eventContext.heldObj = new Client1194().generify();
                    }
                }
        );
    }
}
