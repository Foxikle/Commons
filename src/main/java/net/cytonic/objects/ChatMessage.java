package net.cytonic.objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.cytonic.enums.ChatChannel;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * A class that represents a message sent to the specified recipients.
 *
 * @param recipients        The intended recipients of the message, may be null. See note above.
 * @param channel           The channel the message is sent out upon.
 * @param serializedMessage The serialized message in MiniMessage form.
 * @apiNote The {@code recipients} field may be null, indicating the message should be broadcast out on the channel, rather than sent only to the recipients.
 */
@SuppressWarnings("unused")
public record ChatMessage(@Nullable List<UUID> recipients, ChatChannel channel, String serializedMessage) {

    /**
     * A GSON object that will serialize nulls
     */
    private static final Gson GSON = new GsonBuilder().serializeNulls().create();

    /**
     * Converts a string representation of this object to a new instance.
     *
     * @param json The string representation.
     * @return The {@link ChatMessage} object that results from the string.
     * @see ChatMessage#toJson()
     */
    public static ChatMessage fromJson(String json) {
        return GSON.fromJson(json, ChatMessage.class);
    }

    /**
     * Converts the object to a string representation of itself.
     *
     * @return the string representation of this chat message.
     * @see ChatMessage#fromJson(String)
     */
    public String toJson() {
        return GSON.toJson(this);
    }

    /**
     * A method to stringify this object.
     *
     * @return the string representation of this object
     * @see ChatMessage#toJson()
     */
    @Override
    public String toString() {
        return toJson();
    }
}
