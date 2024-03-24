package managerPackage.test;

import managerPackage.Managers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagersTest {

    //5. убедитесь, что утилитарный класс всегда возвращает проинициализированные и готовые к работе экземпляры менеджеров;
    @Test
    void getDefault() {
        Assertions.assertNotNull(Managers.getDefault(),"утилитарный класс Менеджер не возвращает Менеджер по-умолчанию");
    }

    @Test
    void getDefaultHistory() {
        Assertions.assertNotNull(Managers.getDefaultHistory(),"утилитарный класс Менеджер не возвращает Менеджер истории по-умолчанию");
    }
}