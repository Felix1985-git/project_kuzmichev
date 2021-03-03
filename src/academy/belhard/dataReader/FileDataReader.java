package academy.belhard.dataReader;

import academy.belhard.exception.EmptyDataFileException;

import java.util.List;

public interface FileDataReader<T> {

    List<T> read() throws EmptyDataFileException;
}
