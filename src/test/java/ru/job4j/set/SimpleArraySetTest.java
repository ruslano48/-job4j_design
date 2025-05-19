package ru.job4j.set;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SimpleArraySetTest {

    @Test
    void whenAddNonNull() {
        SimpleSet<Integer> set = new SimpleArraySet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
    }

    @Test
    void whenAddSomeElementsNonNull() {
        SimpleSet<Integer> set = new SimpleArraySet<>();
        assertThat(set.contains(1)).isFalse();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
        assertThat(set.contains(2)).isFalse();
        assertThat(set.add(2)).isTrue();
        assertThat(set.contains(2)).isTrue();
        assertThat(set.add(2)).isFalse();
        assertThat(set.contains(3)).isFalse();
        assertThat(set.add(3)).isTrue();
        assertThat(set.contains(3)).isTrue();
        assertThat(set.add(3)).isFalse();
    }

    @Test
    void whenAddNull() {
        SimpleSet<Integer> set = new SimpleArraySet<>();
        assertThat(set.add(null)).isTrue();
        assertThat(set.contains(null)).isTrue();
        assertThat(set.add(null)).isFalse();
    }

    @Test
    void whenCheckContainsOnEmptySet() {
        SimpleSet<String> set = new SimpleArraySet<>();
        assertThat(set.contains("test")).isFalse();
        assertThat(set.contains(null)).isFalse();
    }

    @Test
    void whenAddDuplicateStrings() {
        SimpleSet<String> set = new SimpleArraySet<>();
        assertThat(set.add("apple")).isTrue();
        assertThat(set.add("banana")).isTrue();
        assertThat(set.add("apple")).isFalse();
        assertThat(set.contains("banana")).isTrue();
        assertThat(set.contains("orange")).isFalse();
    }
}