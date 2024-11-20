package programmers_list;

import java.util.List;
import java.util.Map;

public class ReportImpl implements Report {


    @Override
    public Map<String, Long> sortedByTechnologies(List<Programmer> programmers) {
        return Map.of();
    }

    @Override
    public Map<String, Integer> sortedMapTechnologies(List<Programmer> programmers) {
        return Map.of();
    }

    @Override
    public Map<Long, List<Programmer>> sortedMapFrequency(List<Programmer> programmers) {
        return Map.of();
    }
}
