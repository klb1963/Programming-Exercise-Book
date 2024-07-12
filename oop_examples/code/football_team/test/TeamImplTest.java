package football_team.test;

import football_team.dao.Team;
import football_team.dao.TeamImpl;
import football_team.model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
class TeamImplTest {

    Team team; // team - это объект типа Team
    Member[] command; // command - это массив из объектов типа Member

    @BeforeEach
        // ПЕРЕД КАЖДЫМ ТЕСТОМ!!!
    void setUp() {
        team = new TeamImpl(5); // это объект класса TeamImpl, который implements Team
        command = new Member[4];

        command[0] = new Member("Name1", 25, 1);
        command[1] = new Member("Name2", 35, 5);
        command[2] = new Member("Name3", 31, 7);
        command[3] = new Member("Name4", 19, 22);

        // добавить объекты в command
//        for (Member member : command) {
//            team.addMember(member);
//        }

        for (int i = 0; i < command.length; i++) {
            team.addMember(command[i]);
        }

        for (Member m : command) {
            System.out.println(m);
        }

    }

    @Test
    void addMember() {
        // не можем добавить null
        assertFalse(team.addMember(null));
        // не можем добавить дубль
        assertFalse(team.addMember(command[1]));
        // проверяем кол-во
        assertEquals(4, team.size());
        // добавляем новый элемент
        assertTrue(team.addMember(new Member("Name5", 28, 10)));
        assertEquals(5, team.size());
        // добавляем больше, чем capacity
        assertFalse(team.addMember(new Member("Name6", 30, 15)));
        assertEquals(5, team.size());
    }

    @Test
    void removeMember() {
        // удаление существующего члена
        assertNotNull(team.removeMember(command[0]));
        assertEquals(3, team.size());
        // удаление несуществующего члена
        assertNull(team.removeMember(new Member("NonExistent", 100, 100)));
        assertEquals(3, team.size());
    }

    @Test
    void updateMember() {
        // обновление существующего члена
        assertTrue(team.updateMember(new Member("UpdatedName1", 25, 1)));
        assertEquals("UpdatedName1", team.findMember(Integer.parseInt("1")).getName());
        // обновление несуществующего члена
        assertFalse(team.updateMember(new Member("NonExistent", 100, 100)));
    }

    @Test
    void findMember() {
        // поиск существующего члена
        assertNotNull(team.findMember(1));
        // поиск несуществующего члена
        assertNull(team.findMember(100));
    }

    @Test
    void findAllMemberAfterH() {
        // поиск членов с возрастом больше указанного значения
        Member[] expectedMembers = {
                command[1], command[2]
        };

        Member[] foundMembers = team.findAllMemberAfterH(30);
        assertArrayEquals(expectedMembers, foundMembers);
    }
}
