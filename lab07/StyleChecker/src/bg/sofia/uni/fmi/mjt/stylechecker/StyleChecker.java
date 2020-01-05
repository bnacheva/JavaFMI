package bg.sofia.uni.fmi.mjt.stylechecker;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Checks adherence to Java style guidelines.
 */
public class StyleChecker {

    private static final String WILDCARDS_NOT_ALLOWED = "// FIXME Wildcards are not allowed in import statements";
    private static final String ONE_STATEMENT_PER_LINE = "// FIXME Only one statement per line is allowed";
    private static final String LENGTH_OF_LINE = "// FIXME Length of line should not exceed 100 characters";
    private static final String OPENING_BRACKETS = "// FIXME Opening brackets should be placed on the same line as the declaration";
    private static final String PACKAGE_NAME = "// FIXME Package name should not contain upper-case letters or underscores";

    @Contract(pure = true)
    private static boolean matchWildcards(@NotNull String currentLine) {
        return !currentLine.isBlank() && currentLine.trim().startsWith("import")
                && currentLine.trim().matches("^import\\s([a-z0-9]+\\.)+\\*;$");
    }

    @Contract(pure = true)
    private static boolean matchOneStatement(@NotNull String currentLine) {
        return !currentLine.isBlank() && currentLine.trim().matches(".*(;)+.+");
    }

    @Contract(pure = true)
    private static boolean matchLengthLine(@NotNull String currentLine) {
        return !currentLine.isBlank() && currentLine.trim().matches("^.{100,}$");
    }

    @Contract(pure = true)
    private static boolean matchOpeningBrackets(@NotNull String currentLine) {
        return !currentLine.isBlank() && currentLine.trim().equals("{");
    }

    private boolean matchPackageName(@NotNull String currentLine) {
        return !currentLine.isBlank() && currentLine.trim().startsWith("package")
                && !currentLine.trim().matches("^package\\s([a-z0-9]+\\.)+[a-z]+;$");
    }

    /**
     * For each line from the given {@code source} performs code style checks
     * and writes to the {@code output}
     * 1. a FIXME comment line for each style violation in the input line, if any
     * 2. the input line itself.
     *
     * @param source
     * @param output
     */
    public void checkStyle(Path source, Path output) {
        try (BufferedReader reader = Files.newBufferedReader(source, StandardCharsets.UTF_8)) {
            String currentLine = null;
            try (BufferedWriter writer = Files.newBufferedWriter(output, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE)) {
                while ((currentLine = reader.readLine()) != null) {
                    int spaces = currentLine.replaceAll("[^\\s]", "").length();
                    if (matchWildcards(currentLine)) {
                        for (int i = 0; i < spaces; i++) {
                            writer.append(" ");
                        }
                        writer.append(WILDCARDS_NOT_ALLOWED);
                        writer.newLine();
                    }
                    if (matchOneStatement(currentLine)) {
                        for (int i = 0; i < spaces; i++) {
                            writer.append(" ");
                        }
                        writer.append(ONE_STATEMENT_PER_LINE);
                        writer.newLine();
                    }
                    if (matchLengthLine(currentLine)) {
                        for (int i = 0; i < spaces; i++) {
                            writer.append(" ");
                        }
                        writer.append(LENGTH_OF_LINE);
                        writer.newLine();
                    }
                    if (matchOpeningBrackets(currentLine)) {
                        for (int i = 0; i < spaces; i++) {
                            writer.append(" ");
                        }
                        writer.append(OPENING_BRACKETS);
                        writer.newLine();
                    }
                    if (matchPackageName(currentLine)) {
                        for (int i = 0; i < spaces; i++) {
                            writer.append(" ");
                        }
                        writer.append(PACKAGE_NAME);
                        writer.newLine();
                    }
                    writer.write(currentLine);
                    writer.newLine();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
