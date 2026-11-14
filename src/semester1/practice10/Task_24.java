
package semester1.practice10;

interface TextProcessor {
    String process(String text);
}

interface ReversibleProcessor extends TextProcessor {
    String reverseProcess(String text);
}

class CaesarCipherProcessor implements ReversibleProcessor {
    private final int k;

    public CaesarCipherProcessor(int k) {
        this.k = k;
    }

    @Override
    public String process(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            result.append((char) (text.charAt(i) + k));
        }

        return result.toString();
    }

    @Override
    public String reverseProcess(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            result.append((char) (text.charAt(i) - k));
        }

        return result.toString();
    }
}

class WhitespaceTrimmerProcessor implements TextProcessor {

    @Override
    public String process(String text) {
        return text.trim().replaceAll("\\s+", " ");
    }
}

abstract class Task_24 {

    public static void main(String[] args) {

        TextProcessor[] processors = {
                new WhitespaceTrimmerProcessor(),
                new CaesarCipherProcessor(3)
        };

        String text = "   Hello     Java   ";

        System.out.println("Початковий текст: " + text);

        for (TextProcessor processor : processors) {
            text = processor.process(text);

            System.out.println(
                    processor.getClass().getSimpleName()
                            + ": " + text
            );
        }

        System.out.println();

        CaesarCipherProcessor cipher =
                new CaesarCipherProcessor(3);

        String encrypted = cipher.process("Hello Java");

        System.out.println("Зашифровано: " + encrypted);

        System.out.println("Розшифровано: "
                + cipher.reverseProcess(encrypted));
    }
}
