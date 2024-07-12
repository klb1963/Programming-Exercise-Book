package football_team.dao;

import football_team.model.Member;

import java.util.Objects;

public class TeamImpl implements Team {

    private Member[] members;
    private int size;

    public TeamImpl(int capacity) {
        members = new Member[capacity];
        size = 0;
    }

    @Override
    public boolean addMember(Member member) {
        if (member == null || size == members.length || findMember(member.getNumber()) != null) {
            return false;
        }
        members[size++] = member;
        return true;
    }

    @Override
    public Member removeMember(Member member) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(member.getNumber(), members[i].getNumber())) {
                Member temp = members[i];
                // Смещаем все элементы после найденного влево
                System.arraycopy(members, i + 1, members, i, size - i - 1);
                // Уменьшаем размер и очищаем последний элемент
                members[--size] = null;
                return temp;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean updateMember(Member member) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(member.getNumber(), members[i].getNumber())) {
                members[i] = member;
                return true;
            }
        }
        return false;
    }

    @Override
    public Member findMember(int number) {
        for (int i = 0; i < size; i++) {
            if(members[i].getNumber() == number){
                return  members[i];
            }
        }
        return null;
    }

    @Override
    public Member[] findAllMemberAfterH(int age) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (members[i].getAge() > age) {
                count++;
            }
        }
        System.out.println("Count =" + count);
        Member[] findedMembers = new Member[count];
        for (int i = 0, j = 0; i < size; i++) {
            if(members[i].getAge() > age){
                findedMembers[j++] = members[i];
            }
        }
        return findedMembers;
    }

    public Member findMember(String number) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(number, members[i].getNumber())) {
                return members[i];
            }
        }
        return null;
    }

}