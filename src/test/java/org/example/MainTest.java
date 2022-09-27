package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MainTest {

    PermissionManager permissionManager;
    HashMap<PermissionLevel, String> permissons = new HashMap<>();

    @BeforeEach
    void setUp() {
        permissionManager = new PermissionManager();
        permissons.put(PermissionLevel.ADMIN, "ADMIN");
        permissons.put(PermissionLevel.USER, "USER");
        permissons.put(PermissionLevel.DEVELOPER, "DEVELOPER");
    }

    @Test
    @DisplayName("Testing current level")
    void testGetCurrentLevel() {
        for (PermissionLevel permissionLevel: permissons.keySet()){
            permissionManager.set(permissionLevel);
            assertEquals(permissons.get(permissionLevel), permissionManager.getCurrentLevel());
        }
    }

    @Test
    @DisplayName("Permission level should be set for ADMIN")
    void testSetAdmin() {
        assertEquals(PermissionLevel.ADMIN, permissionManager.set(PermissionLevel.ADMIN),
                "Regular level set should work for ADMIN");
    }
}

