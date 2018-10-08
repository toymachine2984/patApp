package app.comp.entity.system;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Sort;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataTable {

    @JsonProperty("draw")
    private int draw;

    @JsonProperty("start")
    private int start;

    @JsonProperty("length")
    private int length;

    @JsonProperty("columns")
    private List<Column> columns;

    @JsonProperty("search")
    private Search search;

    @JsonProperty("order")
    private List<Order> order;


    @JsonCreator
    public DataTable(@JsonProperty("draw") String draw,
                     @JsonProperty("start") String start,
                     @JsonProperty("length") String length,
                     @JsonProperty("columns") List<Column> columns,
                     @JsonProperty("search") Search search,
                     @JsonProperty("order") List<Order> order) {
        this.draw = Integer.parseInt(draw);
        this.start = Integer.parseInt(start);
        this.length = Integer.parseInt(length);
        this.columns = columns;
        this.search = search;
        this.order = order;
    }

    public int getDraw() {
        return draw;
    }

    public int getStart() {
        return start;
    }

    public int getLength() {
        return length;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public Search getSearch() {
        return search;
    }

    public List<Order> getOrder() {
        return order;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Order {

        @JsonProperty("column")
        int column;
        @JsonProperty("dir")
        Sort.Direction dir;

        @JsonCreator
        public Order(@JsonProperty("column") String column,
                     @JsonProperty("dir") String dir) {
            this.column = Integer.parseInt(column);
            this.dir = Sort.Direction.fromString(dir);
        }

        public int getColumn() {
            return column;
        }

        public Sort.Direction getDir() {
            return dir;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Column {

        @JsonProperty("data")
        String data;
        @JsonProperty("name")
        String name;
        @JsonProperty("searchable")
        boolean searchable;
        @JsonProperty("orderable")
        boolean orderable;
        @JsonProperty("search")
        Search search;


        public Column(){
            this.search = new Search("","false");
        }

        @JsonCreator
        public Column(@JsonProperty("data") String data,
                      @JsonProperty("name") String name,
                      @JsonProperty("searchable") String searchable,
                      @JsonProperty("orderable") String orderable,
                      @JsonProperty("search") Search search) {
            this.data = data;
            this.name = name;
            this.searchable = Boolean.parseBoolean(searchable);
            this.orderable = Boolean.parseBoolean(orderable);
            this.search = search;
        }

        public String getData() {
            return data;
        }

        public String getName() {
            return name;
        }

        public boolean isSearchable() {
            return searchable;
        }

        public boolean isOrderable() {
            return orderable;
        }

        public Search getSearch() {
            return search;
        }
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Search {
        String value;
        boolean regex;

        @JsonCreator
        public Search(@JsonProperty("value") String value,
                      @JsonProperty("regex") String regex) {
            this.value = value;
            this.regex = Boolean.parseBoolean(regex);
        }

        public String getValue() {
            return value;
        }

        public boolean isRegex() {
            return regex;
        }
    }

}
