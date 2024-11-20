package programmers_list;

import java.util.List;

public class Programmer {

    private String nickName;
    private List<String> technology;

    public Programmer(String nickName, List<String> technology) {
        this.nickName = nickName;
        this.technology = technology;
    }

    public String getNickName() {
        return nickName;
    }

    public List<String> getTechnology() {
        return technology;
    }

    @Override
    public String toString() {
        return "Programmer " + nickName + " | Technology: " + technology.toString();
    }
}
