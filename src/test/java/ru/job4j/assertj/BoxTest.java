package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 3);
        assertThat(box.whatsThis()).isEqualTo("Cube");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(6, 5);
        assertThat(box.whatsThis()).isEqualTo("Unknown object");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 4);
        assertThat(box.whatsThis()).isEqualTo("Tetrahedron");
    }
}