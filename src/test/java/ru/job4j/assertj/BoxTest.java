package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

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

    @Test
    void whenCubeThenVerticesAre8() {
        Box box = new Box(8, 2);
        assertThat(box.getNumberOfVertices()).isEqualTo(8);
    }

    @Test
    void whenTetrahedronThenVerticesAre4() {
        Box box = new Box(4, 2);
        assertThat(box.getNumberOfVertices()).isEqualTo(4);
    }

    @Test
    void whenCubeIsExist() {
        Box box = new Box(8, 2);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void whenCubeNotIsExist() {
        Box box = new Box(1, 3);
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void whenEdgeIsZeroThenAreaIsZero() {
        Box box = new Box(4, 0);
        assertThat(box.getArea()).isEqualTo(0);
    }

    @Test
    void whenEdgeIsNegativeThenAreaIsZero() {
        Box box = new Box(8, -1);
        assertThat(box.getArea()).isEqualTo(0);

    }

    @Test
    void whenCubeWithEdge3ThenCorrectArea() {
        Box box = new Box(8, 3);
        double expected = 6 * 9; // 6 * a^2, a = 3
        assertThat(box.getArea()).isCloseTo(expected, within(0.0001));
    }
}