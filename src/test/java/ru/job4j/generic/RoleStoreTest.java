package ru.job4j.generic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void add() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Administrator");
    }

    @Test
    void replace() {
        RoleStore store = new RoleStore();
        store.add(new Role(("1"), "Administrator"));
        store.replace("1", new Role("1", "Mechanic"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Mechanic");

    }

    @Test
    void delete() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();

    }

    @Test
    void findById() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Administrator");
    }
}