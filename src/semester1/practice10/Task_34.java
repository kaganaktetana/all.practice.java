package semester1.practice10;

abstract class AbstractSecurityProtocol {

    protected abstract boolean authenticateUser(String token);

    protected abstract String executePayload(String command);

    public final String runSecureCommand(String token, String command) {
        if (token == null || !authenticateUser(token)) {
            return "403 FORBIDDEN";
        }

        return "[AUDITED] " + executePayload(command);
    }
}

class JwtSecurityProtocol extends AbstractSecurityProtocol {

    @Override
    protected boolean authenticateUser(String token) {
        return token.startsWith("JWT-");
    }

    @Override
    protected String executePayload(String command) {
        return "JWT виконано команду: " + command;
    }
}

class ApiKeySecurityProtocol extends AbstractSecurityProtocol {

    @Override
    protected boolean authenticateUser(String token) {
        return token.equals("API-12345");
    }

    @Override
    protected String executePayload(String command) {
        return "API виконано команду: " + command;
    }
}

abstract class Task_34 {

    public static void main(String[] args) {
        AbstractSecurityProtocol jwt = new JwtSecurityProtocol();
        AbstractSecurityProtocol api = new ApiKeySecurityProtocol();

        System.out.println(
                jwt.runSecureCommand("JWT-987", "GET /users")
        );

        System.out.println(
                jwt.runSecureCommand("WRONG-TOKEN", "DELETE /users")
        );

        System.out.println(
                api.runSecureCommand("API-12345", "GET /products")
        );
    }
}