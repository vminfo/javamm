package info.vm.javamm.cmd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import info.vm.javamm.code.fragment.SourceCode;

final class FileSourceCode implements SourceCode {

    private final Path path;

    private final List<String> lines;

    FileSourceCode(final String fileName) throws IOException {
        path = Paths.get(fileName);
        lines = Collections.unmodifiableList(Files.readAllLines(path));
    }

    @Override
    public String getModuleName() {
        return path.getFileName().toString();
    }

    @Override
    public List<String> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return path.toString();
    }

}
