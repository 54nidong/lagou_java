package sqlSession;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import config.Configuration;
import executor.Executor;
import executor.SimpleExecutor;
import config.MappedStatement;
import executor.Executor;
import executor.SimpleExecutor;

public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object... params) throws Exception {
        Executor simpleExcutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
        List<E> query = simpleExcutor.query(configuration, mappedStatement, params);

        return query;
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) throws Exception {
        List<Object> objects = selectList(statementId, params);
        if(objects.size() ==1){
            return (T) objects.get(0);
        }else {
            throw new RuntimeException("结果太多or。。。"); }
    }

    @Override
    public <T> T getMapper(Class<?> mapperClass) {
        T o = (T) Proxy.newProxyInstance(mapperClass.getClassLoader(), new Class[] {mapperClass},
                (proxy, method, args) -> {
                    String methodName = method.getName();
                    String className = method.getDeclaringClass().getName();

                    // statemamentId
                    String key = className + "." + methodName;
                    MappedStatement mappedStatement = configuration.getMappedStatementMap().get(key);

                    Type returnType = method.getGenericReturnType();

                    List<T> list = new ArrayList<>();

                    // 判断是否实现范型参数化
                    if (returnType instanceof ParameterizedType) {
                        return selectList(key, args);
                    } else {
                        return selectOne(key, args);
                    }
                });

        return o;
    }
}
