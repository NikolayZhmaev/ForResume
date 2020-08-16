package net.thumbtack.school.online.windows.v4.managers;

import net.thumbtack.school.online.windows.v4.base.Window;
import net.thumbtack.school.online.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.online.windows.v4.base.WindowException;

public class NamedManager<T extends Window> extends Manager {
   private String nameManager;

    public String getName() {
        return nameManager;
    }

    public void setName(String nameManager) throws WindowException {
        checName(nameManager);
        this.nameManager = nameManager;
    }

    public void checName(String nameManager) throws WindowException {
        if (nameManager == null) {
            throw new WindowException(WindowErrorCode.NULL_WINDOW);
        }
    }

    public NamedManager(T window, String nameManager) throws WindowException {
        super(window);
        setName(nameManager);
    }
}
