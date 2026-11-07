
package semester1.practice08;

public class Task_29 {

    public static void main(String[] args) {

        ImmutableServerCredentials credentials =
                new ImmutableServerCredentials(
                        "localhost",
                        8080,
                        "my-secret-api-key"
                );

        System.out.println("=== SERVER CREDENTIALS ===");

        System.out.println(credentials);

        System.out.println("\nДані сервера:");
        System.out.println("Host: " + credentials.getHost());
        System.out.println("Port: " + credentials.getPort());
        System.out.println("API Key: " + credentials.getApiKey());
    }
}

final class ImmutableServerCredentials {

    private final String host;
    private final int port;
    private final String apiKey;

    public ImmutableServerCredentials(
            String host,
            int port,
            String apiKey) {

        this.host = host;
        this.port = port;
        this.apiKey = apiKey;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getApiKey() {
        return apiKey;
    }

    @Override
    public String toString() {

        return "ImmutableServerCredentials{"
                + "host='" + host + '\''
                + ", port=" + port
                + ", apiKey='SECRET'"
                + '}';
    }
}
