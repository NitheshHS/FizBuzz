package jsonAppend;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class TestPojo {
    private Map<String, Mapping> mapper;
}
