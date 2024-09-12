package unit_tests;

import org.junit.jupiter.api.Test;
import problematic_searcher.PeopleSearcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PeopleSearcherTest {
    @Test
    public void search_for_people_having_a_given_a_name()
    {
        var peopleSearcher = new PeopleSearcher();

        var persons = peopleSearcher.search("Pedro");

        assertThat(persons.size(), is(2));
    }
}

