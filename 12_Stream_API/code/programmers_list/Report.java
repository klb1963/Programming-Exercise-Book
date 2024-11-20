package programmers_list;

import java.util.List;
import java.util.Map;

public interface Report {
    // programmer(имя) : number(кол-во), List<String> (технологии)
    Map<String, Long> sortedByTechnologies(List<Programmer> programmers);

    //sorting technologies by frequency
    // technology : frequency (сколько раз встретилось)
    Map< String , Integer> sortedMapTechnologies(List<Programmer> programmers);

    // число: список программистов
    Map <Long, List<Programmer>> sortedMapFrequency(List<Programmer> programmers);

}
