package sqlSession;

import util.ParameterMapping;

import java.util.ArrayList;
import java.util.List;

public class BoundSql {
    // 最后解析过的sql
    private String sqlText;

    // 解析出来的参数
    private List<ParameterMapping> parameterMapperList = new ArrayList<ParameterMapping>();

    public BoundSql(String sqlText, List<ParameterMapping> parameterMapperList) {
        this.sqlText = sqlText;
        this.parameterMapperList = parameterMapperList;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public List<ParameterMapping> getParameterMapperList() {
        return parameterMapperList;
    }

    public void setParameterMapperList(List<ParameterMapping> parameterMapperList) {
        this.parameterMapperList = parameterMapperList;
    }
}
