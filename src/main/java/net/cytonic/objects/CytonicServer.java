package net.cytonic.objects;

/**
 * A class that holds data about a Cytosis server
 * @param id The server ID
 * @param ip The ip address of the server
 *             (for example, 127.0.0.1)
 * @param port The port of the server, usually 25565
 */
@SuppressWarnings("unused")
public record CytonicServer(String ip, String id, int port) {

    /**
     * Converts a serialized string into a CytonicServer
     *
     * @param serialized The serialized string
     * @return the server object
     */
    public static CytonicServer deserialize(String serialized) {
        String[] parts = serialized.split("\\|");
        return new CytonicServer(parts[0], parts[1], Integer.parseInt(parts[2]));
    }

    /**
     * Serializes the server into a string
     *
     * @return the serialized string
     */
    public String serialize() {
        return String.format("%s|%s|%d", ip, id, port);
    }
}
