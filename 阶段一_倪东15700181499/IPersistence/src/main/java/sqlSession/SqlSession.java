package sqlSession;

import java.util.List;

public interface SqlSession {
    <E> List<E> selectList(String statementId, Object... params) throws Exception;

    <T> T selectOne(String statementId, Object... params) throws Exception;

    <T> T getMapper(Class<?> mapperClass);
}
