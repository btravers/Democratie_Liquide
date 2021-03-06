package com.zenika.liquid.democracy.api.channel.util;

import com.zenika.liquid.democracy.api.channel.exception.MalformedChannelException;
import com.zenika.liquid.democracy.api.channel.exception.UserAlreadyInChannelException;
import com.zenika.liquid.democracy.model.Channel;
import com.zenika.si.core.zenika.model.Collaborator;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class ChannelUtil {

    public static void checkChannel(Channel c) {
        if (StringUtils.isBlank(c.getTitle())) {
            throw new MalformedChannelException();
        }
    }

    public static void checkChannelForJoin(Channel c, String userId) {
        Optional<Collaborator> collaborator = c.findCollaborator(userId);

        if (collaborator.isPresent()) {
            throw new UserAlreadyInChannelException();
        }
    }

}
