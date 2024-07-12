package football_team.dao;

import football_team.model.Member;

public interface Team {
    //Добавление игрока
    boolean addMember(Member member);

    //Удаление игрока
    Member removeMember(Member member);

    int size();

    // Обновление игрока
    boolean updateMember(Member member);

    // Поиск игрока по номеру
    Member findMember(int number);

    // Получить игроков старше 30
    Member[] findAllMemberAfterH(int age);

}