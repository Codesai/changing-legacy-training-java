package problematic_searcher;

import java.util.List;

public class PeopleSearcher {
        public List<Person> search(String name)
        {
            return PersonsRepository.query("select * from Person where Name like '%" + name + "%'");
        }
}
