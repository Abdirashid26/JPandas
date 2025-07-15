package org.faisaldev.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupedDataFrame {
    private String groupColumn;
    private Map<Object, List<Row>> groups;

    public GroupedDataFrame(String groupColumn, Map<Object, List<Row>> groups) {
        this.groupColumn = groupColumn;
        this.groups = groups;
    }

    public DataFrame count() {
        List<Column<?>> columns = new ArrayList<>();
        Column<Object> groupKeyCol = new Column<>(groupColumn, DataType.STRING);
        Column<Integer> countCol = new Column<>("count", DataType.INTEGER);

        List<Row> resultRows = new ArrayList<>();

        for (Map.Entry<Object, List<Row>> entry : groups.entrySet()) {
            Object key = entry.getKey();
            int count = entry.getValue().size();

            groupKeyCol.add(key);
            countCol.add(count);

            Row row = new Row();
            row.put(groupColumn, key);
            row.put("count", count);
            resultRows.add(row);
        }

        columns.add(groupKeyCol);
        columns.add(countCol);

        return new DataFrame(columns, resultRows);
    }


}
