package org.owner.notebook.app.sheet;

import org.owner.notebook.app.sheet.core.Sheet;
import org.owner.notebook.app.sheet.core.SheetRequest;
import org.owner.notebook.app.user.core.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SheetController
{
    @Autowired
    private SheetService sheetService;

    @PostMapping("/sheets/create")
    public ResponseEntity<Sheet> createSheet(@RequestBody SheetRequest sheetRequest)
    {
        return ResponseEntity.ok(sheetService.createSheet(sheetRequest));
    }

    @GetMapping("/testing")
    public User testing()
    {
        System.out.println("Calling testing endpoint");
        User user = new User();
        user.setFullName("TestName");
        user.setUsername("test");
        user.setPassword("1234");
        return user;
    }
}
