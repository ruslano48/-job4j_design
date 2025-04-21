package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {

    @Test
    void toArray() {
        SimpleConvert convert = new SimpleConvert();

        String first = "alpha";
        String second = "beta";
        String third = "gamma";

        String[] result = convert.toArray(first, second, third);

        assertThat(result)
                .hasSize(3)
                .isNotEmpty()
                .containsExactly(first, second, third);
    }


    @Test
    void toList() {
        SimpleConvert convert = new SimpleConvert();
        String first = "Petr";
        String second = "Ivan";
        String third = "Anna";
        String fourth = "Nikolay";

        List<String> result = convert.toList(first, second, third, fourth);
        assertThat(result)
                .hasSize(4)
                .isNotEmpty()
                .containsExactly(first, second, third, fourth)
                .doesNotContain("Mary", "Jone");

    }

    @Test
    void toSet() {
        SimpleConvert convert = new SimpleConvert();
        String first = "Январь";
        String second = "Февраль";
        String third = "Март";
        String fourth = "Апрель";
        Set<String> result = convert.toSet(first, second, third, fourth);
        assertThat(result)
                .hasSize(4)
                .isNotEmpty()
                .containsExactlyInAnyOrder("Январь", "Февраль", "Март", "Апрель")
                .containsOnly(first, second, third, fourth);
    }

    @Test
    void toMap() {
        Map<Integer, String> map = Map.of(
                1, "1", 2, "2", 3, "3");
        assertThat(map).hasSize(3)
                .containsKeys(1, 3, 2)
                .containsValues("3", "1", "2")
                .doesNotContainKey(0)
                .doesNotContainValue("0")
                .containsEntry(2, "2");
    }
}