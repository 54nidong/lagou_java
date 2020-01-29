package executor;

import config.MappedStatement;

import config.Configuration;
import java.util.List;

public interface Executor {
    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object[] param) throws Exception;
}
