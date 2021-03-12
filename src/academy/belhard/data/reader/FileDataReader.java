package academy.belhard.data.reader;

import academy.belhard.exception.EmptyDataFileException;

import java.util.List;

public interface FileDataReader<T> {

    List<T> read() throws EmptyDataFileException;
}
