package org.owner.finances.notebook.app.sheet;

import org.owner.finances.notebook.app.sheet.core.Sheet;
import org.owner.finances.notebook.app.sheet.core.SheetRepository;
import org.owner.finances.notebook.app.sheet.core.SheetRequest;
import org.owner.finances.notebook.app.user.UserService;
import org.owner.finances.notebook.app.user.core.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SheetService
{
    @Autowired
    private SheetRepository sheetRepository;

    @Autowired
    private UserService userService;

    public Sheet findSheetOrThrowError(Long sheetID, String username)
    {
        Sheet sheet = sheetRepository.findBySheetIDAndUserUsername(sheetID, username);
        if (sheet == null)
            throw new RuntimeException("");
        return sheet;
    }

    public Sheet consultSheet(SheetRequest sheetRequest)
    {
        return findSheetOrThrowError(sheetRequest.getSheetID(), sheetRequest.getUsername());
    }

    // Sheet CRUD Methods

    public Sheet createSheet(SheetRequest sheetRequest)
    {
        User user = userService.findUserOrThrowError(sheetRequest.getUsername());
        Sheet sheet = new Sheet();
        sheet.setUser(user);
        sheet.setSheetName(sheetRequest.getSheetName());
        sheet.setStartDate(sheetRequest.getStartDate());
        sheet.setEndDate(sheetRequest.getEndDate());
        return sheetRepository.save(sheet);
    }

    public Sheet updateSheet(SheetRequest sheetRequest)
    {
        return null;
    }

    public Sheet deleteSheet(SheetRequest sheetRequest)
    {
        return null;
    }
}
